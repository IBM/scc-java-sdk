/*
 * (C) Copyright IBM Corp. 2021.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.cloud.scc.configuration_governance.v1.model;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleScope;
import com.ibm.cloud.scc.configuration_governance.v1.model.UpdateRuleAttachmentOptions;
import com.ibm.cloud.scc.configuration_governance.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the UpdateRuleAttachmentOptions model.
 */
public class UpdateRuleAttachmentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateRuleAttachmentOptions() throws Throwable {
    RuleScope ruleScopeModel = new RuleScope.Builder()
      .note("testString")
      .scopeId("testString")
      .scopeType("enterprise")
      .build();
    assertEquals(ruleScopeModel.note(), "testString");
    assertEquals(ruleScopeModel.scopeId(), "testString");
    assertEquals(ruleScopeModel.scopeType(), "enterprise");

    UpdateRuleAttachmentOptions updateRuleAttachmentOptionsModel = new UpdateRuleAttachmentOptions.Builder()
      .ruleId("testString")
      .attachmentId("testString")
      .ifMatch("testString")
      .accountId("testString")
      .includedScope(ruleScopeModel)
      .excludedScopes(new java.util.ArrayList<RuleScope>(java.util.Arrays.asList(ruleScopeModel)))
      .transactionId("testString")
      .build();
    assertEquals(updateRuleAttachmentOptionsModel.ruleId(), "testString");
    assertEquals(updateRuleAttachmentOptionsModel.attachmentId(), "testString");
    assertEquals(updateRuleAttachmentOptionsModel.ifMatch(), "testString");
    assertEquals(updateRuleAttachmentOptionsModel.accountId(), "testString");
    assertEquals(updateRuleAttachmentOptionsModel.includedScope(), ruleScopeModel);
    assertEquals(updateRuleAttachmentOptionsModel.excludedScopes(), new java.util.ArrayList<RuleScope>(java.util.Arrays.asList(ruleScopeModel)));
    assertEquals(updateRuleAttachmentOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateRuleAttachmentOptionsError() throws Throwable {
    new UpdateRuleAttachmentOptions.Builder().build();
  }

}