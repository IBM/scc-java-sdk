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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Import;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigConditionBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RuleParameter;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RuleTargetPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateRuleOptions model.
 */
public class CreateRuleOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateRuleOptions() throws Throwable {
    AdditionalTargetAttribute additionalTargetAttributeModel = new AdditionalTargetAttribute.Builder()
      .name("testString")
      .operator("string_equals")
      .value("testString")
      .build();
    assertEquals(additionalTargetAttributeModel.name(), "testString");
    assertEquals(additionalTargetAttributeModel.operator(), "string_equals");
    assertEquals(additionalTargetAttributeModel.value(), "testString");

    RuleTargetPrototype ruleTargetPrototypeModel = new RuleTargetPrototype.Builder()
      .serviceName("testString")
      .resourceKind("testString")
      .additionalTargetAttributes(java.util.Arrays.asList(additionalTargetAttributeModel))
      .build();
    assertEquals(ruleTargetPrototypeModel.serviceName(), "testString");
    assertEquals(ruleTargetPrototypeModel.resourceKind(), "testString");
    assertEquals(ruleTargetPrototypeModel.additionalTargetAttributes(), java.util.Arrays.asList(additionalTargetAttributeModel));

    RequiredConfigConditionBase requiredConfigModel = new RequiredConfigConditionBase.Builder()
      .description("testString")
      .property("testString")
      .operator("string_equals")
      .value("testString")
      .build();
    assertEquals(requiredConfigModel.description(), "testString");
    assertEquals(requiredConfigModel.property(), "testString");
    assertEquals(requiredConfigModel.operator(), "string_equals");
    assertEquals(requiredConfigModel.value(), "testString");

    RuleParameter ruleParameterModel = new RuleParameter.Builder()
      .name("testString")
      .displayName("testString")
      .description("testString")
      .type("string")
      .build();
    assertEquals(ruleParameterModel.name(), "testString");
    assertEquals(ruleParameterModel.displayName(), "testString");
    assertEquals(ruleParameterModel.description(), "testString");
    assertEquals(ruleParameterModel.type(), "string");

    Import importModel = new Import.Builder()
      .parameters(java.util.Arrays.asList(ruleParameterModel))
      .build();
    assertEquals(importModel.parameters(), java.util.Arrays.asList(ruleParameterModel));

    CreateRuleOptions createRuleOptionsModel = new CreateRuleOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .description("testString")
      .target(ruleTargetPrototypeModel)
      .requiredConfig(requiredConfigModel)
      .version("testString")
      .xImport(importModel)
      .labels(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(createRuleOptionsModel.instanceId(), "acd7032c-15a3-484f-bf5b-67d41534d940");
    assertEquals(createRuleOptionsModel.description(), "testString");
    assertEquals(createRuleOptionsModel.target(), ruleTargetPrototypeModel);
    assertEquals(createRuleOptionsModel.requiredConfig(), requiredConfigModel);
    assertEquals(createRuleOptionsModel.version(), "testString");
    assertEquals(createRuleOptionsModel.xImport(), importModel);
    assertEquals(createRuleOptionsModel.labels(), java.util.Arrays.asList("testString"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateRuleOptionsError() throws Throwable {
    new CreateRuleOptions.Builder().build();
  }

}