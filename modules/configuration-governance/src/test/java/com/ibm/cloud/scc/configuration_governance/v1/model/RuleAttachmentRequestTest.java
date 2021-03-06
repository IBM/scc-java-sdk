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

import com.ibm.cloud.scc.configuration_governance.v1.model.RuleAttachmentRequest;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleScope;
import com.ibm.cloud.scc.configuration_governance.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RuleAttachmentRequest model.
 */
public class RuleAttachmentRequestTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuleAttachmentRequest() throws Throwable {
    RuleScope ruleScopeModel = new RuleScope.Builder()
      .note("testString")
      .scopeId("testString")
      .scopeType("enterprise")
      .build();
    assertEquals(ruleScopeModel.note(), "testString");
    assertEquals(ruleScopeModel.scopeId(), "testString");
    assertEquals(ruleScopeModel.scopeType(), "enterprise");

    RuleAttachmentRequest ruleAttachmentRequestModel = new RuleAttachmentRequest.Builder()
      .accountId("testString")
      .includedScope(ruleScopeModel)
      .excludedScopes(new java.util.ArrayList<RuleScope>(java.util.Arrays.asList(ruleScopeModel)))
      .build();
    assertEquals(ruleAttachmentRequestModel.accountId(), "testString");
    assertEquals(ruleAttachmentRequestModel.includedScope(), ruleScopeModel);
    assertEquals(ruleAttachmentRequestModel.excludedScopes(), new java.util.ArrayList<RuleScope>(java.util.Arrays.asList(ruleScopeModel)));

    String json = TestUtilities.serialize(ruleAttachmentRequestModel);

    RuleAttachmentRequest ruleAttachmentRequestModelNew = TestUtilities.deserialize(json, RuleAttachmentRequest.class);
    assertTrue(ruleAttachmentRequestModelNew instanceof RuleAttachmentRequest);
    assertEquals(ruleAttachmentRequestModelNew.accountId(), "testString");
    assertEquals(ruleAttachmentRequestModelNew.includedScope().toString(), ruleScopeModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuleAttachmentRequestError() throws Throwable {
    new RuleAttachmentRequest.Builder().build();
  }

}