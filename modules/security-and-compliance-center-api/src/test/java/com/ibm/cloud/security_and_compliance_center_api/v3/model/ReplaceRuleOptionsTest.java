/*
 * (C) Copyright IBM Corp. 2023.
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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Import;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Parameter;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigItemsRequiredConfigOr;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigRequiredConfigAnd;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Target;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceRuleOptions model.
 */
public class ReplaceRuleOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceRuleOptions() throws Throwable {
    AdditionalTargetAttribute additionalTargetAttributeModel = new AdditionalTargetAttribute.Builder()
      .name("testString")
      .operator("string_equals")
      .value("testString")
      .build();
    assertEquals(additionalTargetAttributeModel.name(), "testString");
    assertEquals(additionalTargetAttributeModel.operator(), "string_equals");
    assertEquals(additionalTargetAttributeModel.value(), "testString");

    Target targetModel = new Target.Builder()
      .serviceName("testString")
      .serviceDisplayName("testString")
      .resourceKind("testString")
      .additionalTargetAttributes(java.util.Arrays.asList(additionalTargetAttributeModel))
      .build();
    assertEquals(targetModel.serviceName(), "testString");
    assertEquals(targetModel.serviceDisplayName(), "testString");
    assertEquals(targetModel.resourceKind(), "testString");
    assertEquals(targetModel.additionalTargetAttributes(), java.util.Arrays.asList(additionalTargetAttributeModel));

    RequiredConfigItemsRequiredConfigOr requiredConfigItemsModel = new RequiredConfigItemsRequiredConfigOr.Builder()
      .description("testString")
      .build();
    assertEquals(requiredConfigItemsModel.description(), "testString");

    RequiredConfigRequiredConfigAnd requiredConfigModel = new RequiredConfigRequiredConfigAnd.Builder()
      .description("testString")
      .and(java.util.Arrays.asList(requiredConfigItemsModel))
      .build();
    assertEquals(requiredConfigModel.description(), "testString");
    assertEquals(requiredConfigModel.and(), java.util.Arrays.asList(requiredConfigItemsModel));

    Parameter parameterModel = new Parameter.Builder()
      .name("testString")
      .displayName("testString")
      .description("testString")
      .type("string")
      .build();
    assertEquals(parameterModel.name(), "testString");
    assertEquals(parameterModel.displayName(), "testString");
    assertEquals(parameterModel.description(), "testString");
    assertEquals(parameterModel.type(), "string");

    Import importModel = new Import.Builder()
      .parameters(java.util.Arrays.asList(parameterModel))
      .build();
    assertEquals(importModel.parameters(), java.util.Arrays.asList(parameterModel));

    ReplaceRuleOptions replaceRuleOptionsModel = new ReplaceRuleOptions.Builder()
      .ruleId("testString")
      .ifMatch("testString")
      .description("testString")
      .target(targetModel)
      .requiredConfig(requiredConfigModel)
      .type("user_defined")
      .version("testString")
      .xImport(importModel)
      .labels(java.util.Arrays.asList("testString"))
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();
    assertEquals(replaceRuleOptionsModel.ruleId(), "testString");
    assertEquals(replaceRuleOptionsModel.ifMatch(), "testString");
    assertEquals(replaceRuleOptionsModel.description(), "testString");
    assertEquals(replaceRuleOptionsModel.target(), targetModel);
    assertEquals(replaceRuleOptionsModel.requiredConfig(), requiredConfigModel);
    assertEquals(replaceRuleOptionsModel.type(), "user_defined");
    assertEquals(replaceRuleOptionsModel.version(), "testString");
    assertEquals(replaceRuleOptionsModel.xImport(), importModel);
    assertEquals(replaceRuleOptionsModel.labels(), java.util.Arrays.asList("testString"));
    assertEquals(replaceRuleOptionsModel.xCorrelationId(), "testString");
    assertEquals(replaceRuleOptionsModel.xRequestId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceRuleOptionsError() throws Throwable {
    new ReplaceRuleOptions.Builder().build();
  }

}