/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.cloud.security_and_compliance_center_api.v3.model;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AdditionalTargetAttribute;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigConditionSubRuleConditionSubRuleConditionAll;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RuleTarget;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.SubRule;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RequiredConfigConditionSubRuleConditionSubRuleConditionAll model.
 */
public class RequiredConfigConditionSubRuleConditionSubRuleConditionAllTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRequiredConfigConditionSubRuleConditionSubRuleConditionAll() throws Throwable {
    AdditionalTargetAttribute additionalTargetAttributeModel = new AdditionalTargetAttribute.Builder()
      .name("testString")
      .operator("string_equals")
      .value("testString")
      .build();
    assertEquals(additionalTargetAttributeModel.name(), "testString");
    assertEquals(additionalTargetAttributeModel.operator(), "string_equals");
    assertEquals(additionalTargetAttributeModel.value(), "testString");

    RuleTarget ruleTargetModel = new RuleTarget.Builder()
      .serviceName("testString")
      .serviceDisplayName("testString")
      .resourceKind("testString")
      .additionalTargetAttributes(java.util.Arrays.asList(additionalTargetAttributeModel))
      .ref("testString")
      .build();
    assertEquals(ruleTargetModel.serviceName(), "testString");
    assertEquals(ruleTargetModel.serviceDisplayName(), "testString");
    assertEquals(ruleTargetModel.resourceKind(), "testString");
    assertEquals(ruleTargetModel.additionalTargetAttributes(), java.util.Arrays.asList(additionalTargetAttributeModel));
    assertEquals(ruleTargetModel.ref(), "testString");

    SubRule subRuleModel = new SubRule.Builder()
      .target(ruleTargetModel)
      .build();
    assertEquals(subRuleModel.target(), ruleTargetModel);

    RequiredConfigConditionSubRuleConditionSubRuleConditionAll requiredConfigConditionSubRuleConditionSubRuleConditionAllModel = new RequiredConfigConditionSubRuleConditionSubRuleConditionAll.Builder()
      .all(subRuleModel)
      .build();
    assertEquals(requiredConfigConditionSubRuleConditionSubRuleConditionAllModel.all(), subRuleModel);

    String json = TestUtilities.serialize(requiredConfigConditionSubRuleConditionSubRuleConditionAllModel);

    RequiredConfigConditionSubRuleConditionSubRuleConditionAll requiredConfigConditionSubRuleConditionSubRuleConditionAllModelNew = TestUtilities.deserialize(json, RequiredConfigConditionSubRuleConditionSubRuleConditionAll.class);
    assertTrue(requiredConfigConditionSubRuleConditionSubRuleConditionAllModelNew instanceof RequiredConfigConditionSubRuleConditionSubRuleConditionAll);
    assertEquals(requiredConfigConditionSubRuleConditionSubRuleConditionAllModelNew.all().toString(), subRuleModel.toString());
  }
}