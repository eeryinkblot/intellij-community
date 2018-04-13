/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.parameterInfo;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("idea/testData/parameterInfo")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class ParameterInfoTestGenerated extends AbstractParameterInfoTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, TargetBackend.ANY, testDataFilePath);
    }

    public void testAllFilesPresentInParameterInfo() throws Exception {
        KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/parameterInfo"), Pattern.compile("^(.+)\\.kt$"), TargetBackend.ANY, true, "withLib1/sharedLib", "withLib2/sharedLib", "withLib3/sharedLib");
    }

    @TestMetadata("idea/testData/parameterInfo/annotations")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Annotations extends AbstractParameterInfoTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.ANY, testDataFilePath);
        }

        public void testAllFilesPresentInAnnotations() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/parameterInfo/annotations"), Pattern.compile("^(.+)\\.kt$"), TargetBackend.ANY, true);
        }

        @TestMetadata("ConstructorCall.kt")
        public void testConstructorCall() throws Exception {
            runTest("idea/testData/parameterInfo/annotations/ConstructorCall.kt");
        }

        @TestMetadata("ConstructorCallWithUseSite.kt")
        public void testConstructorCallWithUseSite() throws Exception {
            runTest("idea/testData/parameterInfo/annotations/ConstructorCallWithUseSite.kt");
        }

        @TestMetadata("FunctionCall.kt")
        public void testFunctionCall() throws Exception {
            runTest("idea/testData/parameterInfo/annotations/FunctionCall.kt");
        }
    }

    @TestMetadata("idea/testData/parameterInfo/arrayAccess")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class ArrayAccess extends AbstractParameterInfoTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.ANY, testDataFilePath);
        }

        public void testAllFilesPresentInArrayAccess() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/parameterInfo/arrayAccess"), Pattern.compile("^(.+)\\.kt$"), TargetBackend.ANY, true);
        }

        @TestMetadata("Overloads.kt")
        public void testOverloads() throws Exception {
            runTest("idea/testData/parameterInfo/arrayAccess/Overloads.kt");
        }

        @TestMetadata("Overloads2.kt")
        public void testOverloads2() throws Exception {
            runTest("idea/testData/parameterInfo/arrayAccess/Overloads2.kt");
        }

        @TestMetadata("Set.kt")
        public void testSet() throws Exception {
            runTest("idea/testData/parameterInfo/arrayAccess/Set.kt");
        }

        @TestMetadata("SetTooManyArgs.kt")
        public void testSetTooManyArgs() throws Exception {
            runTest("idea/testData/parameterInfo/arrayAccess/SetTooManyArgs.kt");
        }

        @TestMetadata("Simple.kt")
        public void testSimple() throws Exception {
            runTest("idea/testData/parameterInfo/arrayAccess/Simple.kt");
        }
    }

    @TestMetadata("idea/testData/parameterInfo/functionCall")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class FunctionCall extends AbstractParameterInfoTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.ANY, testDataFilePath);
        }

        public void testAllFilesPresentInFunctionCall() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/parameterInfo/functionCall"), Pattern.compile("^(.+)\\.kt$"), TargetBackend.ANY, true);
        }

        @TestMetadata("DefaultValuesFromLib.kt")
        public void testDefaultValuesFromLib() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/DefaultValuesFromLib.kt");
        }

        @TestMetadata("Deprecated.kt")
        public void testDeprecated() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/Deprecated.kt");
        }

        @TestMetadata("ExtensionOnCapturedScopeChange.kt")
        public void testExtensionOnCapturedScopeChange() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/ExtensionOnCapturedScopeChange.kt");
        }

        @TestMetadata("ExtensionOnClassObject.kt")
        public void testExtensionOnClassObject() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/ExtensionOnClassObject.kt");
        }

        @TestMetadata("FunctionalValue1.kt")
        public void testFunctionalValue1() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/FunctionalValue1.kt");
        }

        @TestMetadata("FunctionalValue2.kt")
        public void testFunctionalValue2() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/FunctionalValue2.kt");
        }

        @TestMetadata("FunctionalValueAndTypeAlias.kt")
        public void testFunctionalValueAndTypeAlias() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/FunctionalValueAndTypeAlias.kt");
        }

        @TestMetadata("FunctionalValueGeneric1.kt")
        public void testFunctionalValueGeneric1() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/FunctionalValueGeneric1.kt");
        }

        @TestMetadata("FunctionalValueGeneric2.kt")
        public void testFunctionalValueGeneric2() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/FunctionalValueGeneric2.kt");
        }

        @TestMetadata("InheritedFunctions.kt")
        public void testInheritedFunctions() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/InheritedFunctions.kt");
        }

        @TestMetadata("InheritedWithCurrentFunctions.kt")
        public void testInheritedWithCurrentFunctions() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/InheritedWithCurrentFunctions.kt");
        }

        @TestMetadata("Invoke.kt")
        public void testInvoke() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/Invoke.kt");
        }

        @TestMetadata("LocalFunctionBug.kt")
        public void testLocalFunctionBug() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/LocalFunctionBug.kt");
        }

        @TestMetadata("NamedAndDefaultParameter.kt")
        public void testNamedAndDefaultParameter() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/NamedAndDefaultParameter.kt");
        }

        @TestMetadata("NamedParameter.kt")
        public void testNamedParameter() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/NamedParameter.kt");
        }

        @TestMetadata("NamedParameter2.kt")
        public void testNamedParameter2() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/NamedParameter2.kt");
        }

        @TestMetadata("NoAnnotations.kt")
        public void testNoAnnotations() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/NoAnnotations.kt");
        }

        @TestMetadata("NoShadowedDeclarations.kt")
        public void testNoShadowedDeclarations() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/NoShadowedDeclarations.kt");
        }

        @TestMetadata("NoShadowedDeclarations2.kt")
        public void testNoShadowedDeclarations2() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/NoShadowedDeclarations2.kt");
        }

        @TestMetadata("NoSynthesizedParameterNames.kt")
        public void testNoSynthesizedParameterNames() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/NoSynthesizedParameterNames.kt");
        }

        @TestMetadata("NotAccessible.kt")
        public void testNotAccessible() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/NotAccessible.kt");
        }

        @TestMetadata("NotGreen.kt")
        public void testNotGreen() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/NotGreen.kt");
        }

        @TestMetadata("Nullability.kt")
        public void testNullability() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/Nullability.kt");
        }

        @TestMetadata("NullableTypeCall.kt")
        public void testNullableTypeCall() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/NullableTypeCall.kt");
        }

        @TestMetadata("OtherConstructorFromSecondary.kt")
        public void testOtherConstructorFromSecondary() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/OtherConstructorFromSecondary.kt");
        }

        @TestMetadata("Println.kt")
        public void testPrintln() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/Println.kt");
        }

        @TestMetadata("PrivateConstructor.kt")
        public void testPrivateConstructor() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/PrivateConstructor.kt");
        }

        @TestMetadata("Simple.kt")
        public void testSimple() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/Simple.kt");
        }

        @TestMetadata("SimpleConstructor.kt")
        public void testSimpleConstructor() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/SimpleConstructor.kt");
        }

        @TestMetadata("SmartCastReceiver.kt")
        public void testSmartCastReceiver() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/SmartCastReceiver.kt");
        }

        @TestMetadata("SmartCastReceiver2.kt")
        public void testSmartCastReceiver2() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/SmartCastReceiver2.kt");
        }

        @TestMetadata("SubstituteExpectedType.kt")
        public void testSubstituteExpectedType() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/SubstituteExpectedType.kt");
        }

        @TestMetadata("SubstituteExplicitTypeArgs.kt")
        public void testSubstituteExplicitTypeArgs() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/SubstituteExplicitTypeArgs.kt");
        }

        @TestMetadata("SubstituteFromArguments1.kt")
        public void testSubstituteFromArguments1() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/SubstituteFromArguments1.kt");
        }

        @TestMetadata("SubstituteFromArguments2.kt")
        public void testSubstituteFromArguments2() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/SubstituteFromArguments2.kt");
        }

        @TestMetadata("SubstituteFromArguments3.kt")
        public void testSubstituteFromArguments3() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/SubstituteFromArguments3.kt");
        }

        @TestMetadata("SubstituteFromArguments4.kt")
        public void testSubstituteFromArguments4() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/SubstituteFromArguments4.kt");
        }

        @TestMetadata("SubstituteFromArgumentsOnTyping.kt")
        public void testSubstituteFromArgumentsOnTyping() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/SubstituteFromArgumentsOnTyping.kt");
        }

        @TestMetadata("SuperConstructorCall.kt")
        public void testSuperConstructorCall() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/SuperConstructorCall.kt");
        }

        @TestMetadata("SuperConstructorFromSecondary.kt")
        public void testSuperConstructorFromSecondary() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/SuperConstructorFromSecondary.kt");
        }

        @TestMetadata("TooManyArgs.kt")
        public void testTooManyArgs() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/TooManyArgs.kt");
        }

        @TestMetadata("TwoFunctions.kt")
        public void testTwoFunctions() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/TwoFunctions.kt");
        }

        @TestMetadata("TwoFunctionsGrey.kt")
        public void testTwoFunctionsGrey() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/TwoFunctionsGrey.kt");
        }

        @TestMetadata("TwoSmartCasts.kt")
        public void testTwoSmartCasts() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/TwoSmartCasts.kt");
        }

        @TestMetadata("TypeAliasConstructor.kt")
        public void testTypeAliasConstructor() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/TypeAliasConstructor.kt");
        }

        @TestMetadata("TypeInference.kt")
        public void testTypeInference() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/TypeInference.kt");
        }

        @TestMetadata("UpdateOnTyping.kt")
        public void testUpdateOnTyping() throws Exception {
            runTest("idea/testData/parameterInfo/functionCall/UpdateOnTyping.kt");
        }
    }

    @TestMetadata("idea/testData/parameterInfo/typeArguments")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class TypeArguments extends AbstractParameterInfoTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.ANY, testDataFilePath);
        }

        public void testAllFilesPresentInTypeArguments() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/parameterInfo/typeArguments"), Pattern.compile("^(.+)\\.kt$"), TargetBackend.ANY, true);
        }

        @TestMetadata("BaseClass.kt")
        public void testBaseClass() throws Exception {
            runTest("idea/testData/parameterInfo/typeArguments/BaseClass.kt");
        }

        @TestMetadata("Constraints.kt")
        public void testConstraints() throws Exception {
            runTest("idea/testData/parameterInfo/typeArguments/Constraints.kt");
        }

        @TestMetadata("ConstructorCall.kt")
        public void testConstructorCall() throws Exception {
            runTest("idea/testData/parameterInfo/typeArguments/ConstructorCall.kt");
        }

        @TestMetadata("FunctionCall.kt")
        public void testFunctionCall() throws Exception {
            runTest("idea/testData/parameterInfo/typeArguments/FunctionCall.kt");
        }

        @TestMetadata("JavaClass.kt")
        public void testJavaClass() throws Exception {
            runTest("idea/testData/parameterInfo/typeArguments/JavaClass.kt");
        }

        @TestMetadata("Overloads.kt")
        public void testOverloads() throws Exception {
            runTest("idea/testData/parameterInfo/typeArguments/Overloads.kt");
        }

        @TestMetadata("Reified.kt")
        public void testReified() throws Exception {
            runTest("idea/testData/parameterInfo/typeArguments/Reified.kt");
        }

        @TestMetadata("VariableType.kt")
        public void testVariableType() throws Exception {
            runTest("idea/testData/parameterInfo/typeArguments/VariableType.kt");
        }
    }

    @TestMetadata("idea/testData/parameterInfo/withLib1")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class WithLib1 extends AbstractParameterInfoTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.ANY, testDataFilePath);
        }

        public void testAllFilesPresentInWithLib1() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/parameterInfo/withLib1"), Pattern.compile("^(.+)\\.kt$"), TargetBackend.ANY, true, "sharedLib");
        }

        @TestMetadata("useJavaFromLib.kt")
        public void testUseJavaFromLib() throws Exception {
            runTest("idea/testData/parameterInfo/withLib1/useJavaFromLib.kt");
        }
    }

    @TestMetadata("idea/testData/parameterInfo/withLib2")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class WithLib2 extends AbstractParameterInfoTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.ANY, testDataFilePath);
        }

        public void testAllFilesPresentInWithLib2() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/parameterInfo/withLib2"), Pattern.compile("^(.+)\\.kt$"), TargetBackend.ANY, true, "sharedLib");
        }

        @TestMetadata("useJavaSAMFromLib.kt")
        public void testUseJavaSAMFromLib() throws Exception {
            runTest("idea/testData/parameterInfo/withLib2/useJavaSAMFromLib.kt");
        }
    }

    @TestMetadata("idea/testData/parameterInfo/withLib3")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class WithLib3 extends AbstractParameterInfoTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.ANY, testDataFilePath);
        }

        public void testAllFilesPresentInWithLib3() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/parameterInfo/withLib3"), Pattern.compile("^(.+)\\.kt$"), TargetBackend.ANY, true, "sharedLib");
        }

        @TestMetadata("useJavaSAMFromLib.kt")
        public void testUseJavaSAMFromLib() throws Exception {
            runTest("idea/testData/parameterInfo/withLib3/useJavaSAMFromLib.kt");
        }
    }
}
