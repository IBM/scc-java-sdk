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

import com.ibm.cloud.scc.configuration_governance.v1.model.EnforcementAction;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleRequest;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleRequiredConfigSingleProperty;
import com.ibm.cloud.scc.configuration_governance.v1.model.TargetResource;
import com.ibm.cloud.scc.configuration_governance.v1.model.TargetResourceAdditionalTargetAttributesItem;
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
 * Unit test class for the RuleRequest model.
 */
public class RuleRequestTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuleRequest() throws Throwable {
    TargetResourceAdditionalTargetAttributesItem targetResourceAdditionalTargetAttributesItemModel = new TargetResourceAdditionalTargetAttributesItem.Builder()
      .name("resource_id")
      .value("81f3db5e-f9db-4c46-9de3-a4a76e66adbf")
      .operator("string_equals")
      .build();
    assertEquals(targetResourceAdditionalTargetAttributesItemModel.name(), "resource_id");
    assertEquals(targetResourceAdditionalTargetAttributesItemModel.value(), "81f3db5e-f9db-4c46-9de3-a4a76e66adbf");
    assertEquals(targetResourceAdditionalTargetAttributesItemModel.operator(), "string_equals");

    TargetResource targetResourceModel = new TargetResource.Builder()
      .serviceName("cloud-object-storage")
      .resourceKind("bucket")
      .additionalTargetAttributes(new java.util.ArrayList<TargetResourceAdditionalTargetAttributesItem>(java.util.Arrays.asList(targetResourceAdditionalTargetAttributesItemModel)))
      .build();
    assertEquals(targetResourceModel.serviceName(), "cloud-object-storage");
    assertEquals(targetResourceModel.resourceKind(), "bucket");
    assertEquals(targetResourceModel.additionalTargetAttributes(), new java.util.ArrayList<TargetResourceAdditionalTargetAttributesItem>(java.util.Arrays.asList(targetResourceAdditionalTargetAttributesItemModel)));

    RuleRequiredConfigSingleProperty ruleRequiredConfigModel = new RuleRequiredConfigSingleProperty.Builder()
      .description("testString")
      .property("public_access_enabled")
      .operator("is_true")
      .value("testString")
      .build();
    assertEquals(ruleRequiredConfigModel.description(), "testString");
    assertEquals(ruleRequiredConfigModel.property(), "public_access_enabled");
    assertEquals(ruleRequiredConfigModel.operator(), "is_true");
    assertEquals(ruleRequiredConfigModel.value(), "testString");

    EnforcementAction enforcementActionModel = new EnforcementAction.Builder()
      .action("disallow")
      .build();
    assertEquals(enforcementActionModel.action(), "disallow");

    RuleRequest ruleRequestModel = new RuleRequest.Builder()
      .accountId("testString")
      .name("testString")
      .description("testString")
      .ruleType("user_defined")
      .target(targetResourceModel)
      .requiredConfig(ruleRequiredConfigModel)
      .enforcementActions(new java.util.ArrayList<EnforcementAction>(java.util.Arrays.asList(enforcementActionModel)))
      .labels(new java.util.ArrayList<String>(java.util.Arrays.asList("SOC2", "ITCS300")))
      .build();
    assertEquals(ruleRequestModel.accountId(), "testString");
    assertEquals(ruleRequestModel.name(), "testString");
    assertEquals(ruleRequestModel.description(), "testString");
    assertEquals(ruleRequestModel.ruleType(), "user_defined");
    assertEquals(ruleRequestModel.target(), targetResourceModel);
    assertEquals(ruleRequestModel.requiredConfig(), ruleRequiredConfigModel);
    assertEquals(ruleRequestModel.enforcementActions(), new java.util.ArrayList<EnforcementAction>(java.util.Arrays.asList(enforcementActionModel)));
    assertEquals(ruleRequestModel.labels(), new java.util.ArrayList<String>(java.util.Arrays.asList("SOC2", "ITCS300")));

    String json = TestUtilities.serialize(ruleRequestModel);

    RuleRequest ruleRequestModelNew = TestUtilities.deserialize(json, RuleRequest.class);
    assertTrue(ruleRequestModelNew instanceof RuleRequest);
    assertEquals(ruleRequestModelNew.accountId(), "testString");
    assertEquals(ruleRequestModelNew.name(), "testString");
    assertEquals(ruleRequestModelNew.description(), "testString");
    assertEquals(ruleRequestModelNew.ruleType(), "user_defined");
    assertEquals(ruleRequestModelNew.target().toString(), targetResourceModel.toString());
    assertEquals(ruleRequestModelNew.requiredConfig().toString(), ruleRequiredConfigModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuleRequestError() throws Throwable {
    new RuleRequest.Builder().build();
  }

}