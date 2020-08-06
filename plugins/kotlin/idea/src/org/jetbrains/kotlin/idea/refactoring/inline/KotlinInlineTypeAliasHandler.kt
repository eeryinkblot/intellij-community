/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.refactoring.inline

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.WindowManager
import com.intellij.psi.search.searches.ReferencesSearch
import com.intellij.refactoring.HelpID
import com.intellij.refactoring.RefactoringBundle
import com.intellij.refactoring.util.CommonRefactoringUtil
import org.jetbrains.annotations.Nls
import org.jetbrains.kotlin.builtins.isExtensionFunctionType
import org.jetbrains.kotlin.builtins.isFunctionType
import org.jetbrains.kotlin.descriptors.TypeAliasDescriptor
import org.jetbrains.kotlin.idea.KotlinBundle
import org.jetbrains.kotlin.idea.caches.resolve.analyze
import org.jetbrains.kotlin.idea.caches.resolve.resolveToCall
import org.jetbrains.kotlin.idea.caches.resolve.unsafeResolveToDescriptor
import org.jetbrains.kotlin.idea.core.ShortenReferences
import org.jetbrains.kotlin.idea.core.replaced
import org.jetbrains.kotlin.idea.imports.importableFqName
import org.jetbrains.kotlin.idea.references.KtSimpleNameReference
import org.jetbrains.kotlin.idea.references.mainReference
import org.jetbrains.kotlin.idea.util.IdeDescriptorRenderers
import org.jetbrains.kotlin.idea.util.application.executeWriteCommand
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.*
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.lazy.BodyResolveMode
import org.jetbrains.kotlin.types.TypeProjectionImpl
import org.jetbrains.kotlin.types.TypeSubstitutor
import org.jetbrains.kotlin.types.Variance

class KotlinInlineTypeAliasHandler : KotlinInlineActionHandler() {
    companion object {
        val REFACTORING_NAME get() = KotlinBundle.message("name.inline.type.alias")
    }

    private fun showErrorHint(project: Project, editor: Editor?, @Nls message: String) {
        CommonRefactoringUtil.showErrorHint(project, editor, message, REFACTORING_NAME, null)
    }

    override fun canInlineKotlinElement(element: KtElement): Boolean = element is KtTypeAlias

    override fun inlineKotlinElement(project: Project, editor: Editor?, element: KtElement) {
        val typeAlias = element as? KtTypeAlias ?: return
        val name = typeAlias.name ?: return
        val aliasBody = typeAlias.getTypeReference() ?: return
        val file = typeAlias.containingKtFile

        val typeAliasDescriptor = typeAlias.unsafeResolveToDescriptor() as TypeAliasDescriptor
        val typeToInline = typeAliasDescriptor.expandedType
        val typeConstructorsToInline = typeAliasDescriptor.typeConstructor.parameters.map { it.typeConstructor }

        val usages = ReferencesSearch.search(typeAlias).mapNotNull {
            val refElement = it.element
            refElement.getParentOfTypeAndBranch<KtUserType> { referenceExpression }
                ?: refElement.getNonStrictParentOfType<KtSimpleNameExpression>()
        }

        if (usages.isEmpty()) return showErrorHint(
            project,
            editor,
            KotlinBundle.message("message.text.type.alias.0.is.never.used", name)
        )

        val usagesInOriginalFile = usages.filter { it.containingFile == file }
        val isHighlighting = usagesInOriginalFile.isNotEmpty()
        highlightElements(project, editor, usagesInOriginalFile)

        if (usagesInOriginalFile.size != usages.size) {
            preProcessInternalUsages(aliasBody, usages)
        }

        if (!showDialog(
                project,
                name,
                REFACTORING_NAME,
                typeAlias,
                usages,
                HelpID.INLINE_VARIABLE
            )
        ) {
            if (isHighlighting) {
                val statusBar = WindowManager.getInstance().getStatusBar(project)
                statusBar?.info = RefactoringBundle.message("press.escape.to.remove.the.highlighting")
            }
            return
        }

        val psiFactory = KtPsiFactory(project)

        fun inlineIntoType(usage: KtUserType): KtElement? {
            val context = usage.analyze(BodyResolveMode.PARTIAL)

            val argumentTypes = usage
                .typeArguments
                .asSequence()
                .filterNotNull()
                .mapNotNull {
                    val type = context[BindingContext.ABBREVIATED_TYPE, it.typeReference] ?: context[BindingContext.TYPE, it.typeReference]
                    if (type != null) TypeProjectionImpl(type) else null
                }
                .toList()
            if (argumentTypes.size != typeConstructorsToInline.size) return null
            val substitution = (typeConstructorsToInline zip argumentTypes).toMap()
            val substitutor = TypeSubstitutor.create(substitution)
            val expandedType = substitutor.substitute(typeToInline, Variance.INVARIANT) ?: return null
            val expandedTypeText = IdeDescriptorRenderers.SOURCE_CODE.renderType(expandedType)
            val needParentheses =
                (expandedType.isFunctionType && usage.parent is KtNullableType) || (expandedType.isExtensionFunctionType && usage.getParentOfTypeAndBranch<KtFunctionType> { receiverTypeReference } != null)
            val expandedTypeReference = psiFactory.createType(expandedTypeText)
            return usage.replaced(expandedTypeReference.typeElement!!).apply {
                if (needParentheses) {
                    val sample = psiFactory.createParameterList("()")
                    parent.addBefore(sample.firstChild, this)
                    parent.addAfter(sample.lastChild, this)
                }
            }
        }

        fun inlineIntoCall(usage: KtReferenceExpression): KtElement? {

            val importDirective = usage.getStrictParentOfType<KtImportDirective>()
            if (importDirective != null) {
                val reference = usage.getQualifiedElementSelector()?.mainReference
                if (reference != null && reference.multiResolve(false).size <= 1) {
                    importDirective.delete()
                }

                return null
            }

            val resolvedCall = usage.resolveToCall() ?: return null
            val callElement = resolvedCall.call.callElement as? KtCallElement ?: return null
            val substitution = resolvedCall.typeArguments
                .mapKeys { it.key.typeConstructor }
                .mapValues { TypeProjectionImpl(it.value) }
            if (substitution.size != typeConstructorsToInline.size) return null
            val substitutor = TypeSubstitutor.create(substitution)
            val expandedType = substitutor.substitute(typeToInline, Variance.INVARIANT) ?: return null
            val expandedTypeFqName = expandedType.constructor.declarationDescriptor?.importableFqName ?: return null

            if (expandedType.arguments.isNotEmpty()) {
                val expandedTypeArgumentList = psiFactory.createTypeArguments(
                    expandedType.arguments.joinToString(
                        prefix = "<",
                        postfix = ">"
                    ) { IdeDescriptorRenderers.SOURCE_CODE.renderType(it.type) }
                )

                val originalTypeArgumentList = callElement.typeArgumentList
                if (originalTypeArgumentList != null) {
                    originalTypeArgumentList.replaced(expandedTypeArgumentList)
                } else {
                    callElement.addAfter(expandedTypeArgumentList, callElement.calleeExpression)
                }
            }

            val newCallElement = ((usage.mainReference as KtSimpleNameReference).bindToFqName(
                expandedTypeFqName,
                KtSimpleNameReference.ShorteningMode.NO_SHORTENING
            ) as KtExpression).getNonStrictParentOfType<KtCallElement>()
            return newCallElement?.getQualifiedExpressionForSelector() ?: newCallElement
        }

        project.executeWriteCommand(RefactoringBundle.message("inline.command", name)) {
            val inlinedElements = usages.mapNotNull {
                val inlinedElement = when (it) {
                    is KtUserType -> inlineIntoType(it)
                    is KtReferenceExpression -> inlineIntoCall(it)
                    else -> null
                } ?: return@mapNotNull null

                postProcessInternalReferences(inlinedElement)
            }

            if (inlinedElements.isNotEmpty() && isHighlighting) {
                highlightElements(project, editor, inlinedElements)
            }

            typeAlias.delete()

            ShortenReferences.DEFAULT.process(inlinedElements)
        }
    }
}
