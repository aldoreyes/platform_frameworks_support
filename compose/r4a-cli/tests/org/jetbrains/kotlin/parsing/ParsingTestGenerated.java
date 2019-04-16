/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.parsing;

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
@TestMetadata("plugins/r4a/r4a-cli/testData/psi")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class ParsingTestGenerated extends AbstractParsingTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doParsingTest, TargetBackend.ANY, testDataFilePath);
    }

    public void testAllFilesPresentInPsi() throws Exception {
        KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("plugins/r4a/r4a-cli/testData/psi"), Pattern.compile("^(.*)\\.kts?$"), TargetBackend.ANY, true);
    }

    @TestMetadata("Ktx.kt")
    public void testKtx() throws Exception {
        runTest("plugins/r4a/r4a-cli/testData/psi/Ktx.kt");
    }

    @TestMetadata("KtxBlock.kt")
    public void testKtxBlock() throws Exception {
        runTest("plugins/r4a/r4a-cli/testData/psi/KtxBlock.kt");
    }

    @TestMetadata("KtxChildrenWithParameters.kt")
    public void testKtxChildrenWithParameters() throws Exception {
        runTest("plugins/r4a/r4a-cli/testData/psi/KtxChildrenWithParameters.kt");
    }

    @TestMetadata("plugins/r4a/r4a-cli/testData/psi/recovery")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Recovery extends AbstractParsingTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doParsingTest, TargetBackend.ANY, testDataFilePath);
        }

        public void testAllFilesPresentInRecovery() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("plugins/r4a/r4a-cli/testData/psi/recovery"), Pattern.compile("^(.*)\\.kts?$"), TargetBackend.ANY, true);
        }

        @TestMetadata("KtxBlockRecovery.kt")
        public void testKtxBlockRecovery() throws Exception {
            runTest("plugins/r4a/r4a-cli/testData/psi/recovery/KtxBlockRecovery.kt");
        }

        @TestMetadata("KtxNestedTagRecovery.kt")
        public void testKtxNestedTagRecovery() throws Exception {
            runTest("plugins/r4a/r4a-cli/testData/psi/recovery/KtxNestedTagRecovery.kt");
        }

        @TestMetadata("KtxTagRecovery.kt")
        public void testKtxTagRecovery() throws Exception {
            runTest("plugins/r4a/r4a-cli/testData/psi/recovery/KtxTagRecovery.kt");
        }
    }
}