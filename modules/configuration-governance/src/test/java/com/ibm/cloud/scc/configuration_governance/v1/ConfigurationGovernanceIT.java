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

package com.ibm.cloud.scc.configuration_governance.v1;

import com.ibm.cloud.scc.configuration_governance.v1.model.CreateRuleAttachmentsOptions;
import com.ibm.cloud.scc.configuration_governance.v1.model.CreateRuleAttachmentsResponse;
import com.ibm.cloud.scc.configuration_governance.v1.model.CreateRuleRequest;
import com.ibm.cloud.scc.configuration_governance.v1.model.CreateRuleResponse;
import com.ibm.cloud.scc.configuration_governance.v1.model.CreateRulesOptions;
import com.ibm.cloud.scc.configuration_governance.v1.model.CreateRulesResponse;
import com.ibm.cloud.scc.configuration_governance.v1.model.DeleteRuleAttachmentOptions;
import com.ibm.cloud.scc.configuration_governance.v1.model.DeleteRuleOptions;
import com.ibm.cloud.scc.configuration_governance.v1.model.EnforcementAction;
import com.ibm.cloud.scc.configuration_governance.v1.model.GetRuleAttachmentOptions;
import com.ibm.cloud.scc.configuration_governance.v1.model.GetRuleOptions;
import com.ibm.cloud.scc.configuration_governance.v1.model.Link;
import com.ibm.cloud.scc.configuration_governance.v1.model.ListRuleAttachmentsOptions;
import com.ibm.cloud.scc.configuration_governance.v1.model.ListRulesOptions;
import com.ibm.cloud.scc.configuration_governance.v1.model.Rule;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleAttachment;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleAttachmentList;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleAttachmentRequest;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleCondition;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleConditionAndLvl2;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleConditionOrLvl2;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleConditionSingleProperty;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleList;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleRequest;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleRequiredConfig;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleRequiredConfigMultipleProperties;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleRequiredConfigMultiplePropertiesConditionAnd;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleRequiredConfigMultiplePropertiesConditionOr;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleRequiredConfigSingleProperty;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleResponseError;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleScope;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleSingleProperty;
import com.ibm.cloud.scc.configuration_governance.v1.model.TargetResource;
import com.ibm.cloud.scc.configuration_governance.v1.model.TargetResourceAdditionalTargetAttributesItem;
import com.ibm.cloud.scc.configuration_governance.v1.model.TemplateAttachment;
import com.ibm.cloud.scc.configuration_governance.v1.model.TemplateScope;
import com.ibm.cloud.scc.configuration_governance.v1.model.UpdateRuleAttachmentOptions;
import com.ibm.cloud.scc.configuration_governance.v1.model.UpdateRuleOptions;
import com.ibm.cloud.scc.configuration_governance.v1.utils.TestUtilities;
import com.ibm.cloud.scc.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the ConfigurationGovernance service.
 */
public class ConfigurationGovernanceIT extends SdkIntegrationTestBase {
  public ConfigurationGovernance service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  // Globlal variables to hold link values
  String ruleAttachmentIdLink = null;
  String ruleIdLink = null;
  String ruleAttachmentEtag = null;
  String ruleEtag = null;

  /**
   * This method provides our config filename to the base class.
   */

  final String accountID = System.getenv("ACCOUNT_ID");
  String ruleLabel = System.getenv("RULE_LABEL");
  final String testString = "testString";
  String resourceGroupID = System.getenv("RESOURCE_GROUP_ID");
  String identifier = "jv-"+(System.currentTimeMillis()/1000);

  public String getConfigFilename() {
    return "compliance_v2.env";
  }

  @BeforeClass
  public void constructService() {

    if (ruleLabel==null){
      ruleLabel = "sdk-it";
    }

    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = ConfigurationGovernance.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(ConfigurationGovernance.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    System.out.println("Setup complete.");
  }

  @Test
  public void testCreateRules() throws Exception {
    try {
      TargetResourceAdditionalTargetAttributesItem targetResourceAdditionalTargetAttributesItemModel = new TargetResourceAdditionalTargetAttributesItem.Builder()
      .name("resource_id")
      .value("81f3db5e-f9db-4c46-9de3-a4a76e66adbf")
      .operator("string_equals")
      .build();

      TargetResource targetResourceModel = new TargetResource.Builder()
      .serviceName("cloud-object-storage")
      .resourceKind("bucket")
      .build();

      RuleConditionSingleProperty ruleConditionModel = new RuleConditionSingleProperty.Builder()
      .description(testString)
      .property("location")
      .operator("string_equals")
      .value("us-south")
      .build();

      RuleRequiredConfigMultiplePropertiesConditionAnd ruleRequiredConfigModel = new RuleRequiredConfigMultiplePropertiesConditionAnd.Builder()
      .description("Public access check")
      .and(new java.util.ArrayList<RuleCondition>(java.util.Arrays.asList(ruleConditionModel)))
      .build();

      EnforcementAction enforcementActionModel = new EnforcementAction.Builder()
      .action("disallow")
      .build();

      RuleRequest ruleRequestModel = new RuleRequest.Builder()
      .accountId(accountID)
      .name("Disable public access")
      .description("Ensure that public access to account resources is disabled.")
      .ruleType("user_defined")
      .target(targetResourceModel)
      .requiredConfig(ruleRequiredConfigModel)
      .enforcementActions(new java.util.ArrayList<EnforcementAction>(java.util.Arrays.asList(enforcementActionModel)))
      .labels(new java.util.ArrayList<String>(java.util.Arrays.asList(ruleLabel+"-"+identifier)))
      .build();

      CreateRuleRequest createRuleRequestModel = new CreateRuleRequest.Builder()
      .requestId("3cebc877-58e7-44a5-a292-32114fa73558")
      .rule(ruleRequestModel)
      .build();

      CreateRulesOptions createRulesOptions = new CreateRulesOptions.Builder()
      .rules(new java.util.ArrayList<CreateRuleRequest>(java.util.Arrays.asList(createRuleRequestModel)))
      .transactionId(testString)
      .build();

      // Invoke operation
      Response<CreateRulesResponse> response = service.createRules(createRulesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      CreateRulesResponse createRulesResponseResult = response.getResult();

      assertNotNull(createRulesResponseResult);
      ruleIdLink = createRulesResponseResult.getRules().get(0).getRule().getRuleId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateRules" })
  public void testCreateRuleAttachments() throws Exception {
    try {
      RuleScope ruleScopeModel = new RuleScope.Builder()
      .note("My account")
      .scopeId(accountID)
      .scopeType("account")
      .build();

      RuleScope excludedRuleScope = new RuleScope.Builder()
      .note("My account resource group")
      .scopeId(resourceGroupID)
      .scopeType("account.resource_group")
      .build();

      RuleAttachmentRequest ruleAttachmentRequestModel = new RuleAttachmentRequest.Builder()
      .accountId(accountID)
      .includedScope(ruleScopeModel)
      .excludedScopes(new java.util.ArrayList<RuleScope>(java.util.Arrays.asList(excludedRuleScope)))
      .build();

      CreateRuleAttachmentsOptions createRuleAttachmentsOptions = new CreateRuleAttachmentsOptions.Builder()
      .ruleId(ruleIdLink)
      .attachments(new java.util.ArrayList<RuleAttachmentRequest>(java.util.Arrays.asList(ruleAttachmentRequestModel)))
      .transactionId(testString)
      .build();

      // Invoke operation
      Response<CreateRuleAttachmentsResponse> response = service.createRuleAttachments(createRuleAttachmentsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      CreateRuleAttachmentsResponse createRuleAttachmentsResponseResult = response.getResult();

      assertNotNull(createRuleAttachmentsResponseResult);
      ruleAttachmentIdLink = createRuleAttachmentsResponseResult.getAttachments().get(0).getAttachmentId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListRules() throws Exception {
    try {
      ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
      .accountId(accountID)
      .transactionId(testString)
      .attached(true)
      .labels(ruleLabel+"-"+identifier)
      .scopes("scope_id")
      .limit(Long.valueOf("1000"))
      .offset(Long.valueOf("26"))
      .build();

      // Invoke operation
      Response<RuleList> response = service.listRules(listRulesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      RuleList ruleListResult = response.getResult();

      assertNotNull(ruleListResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateRules" })
  public void testGetRule() throws Exception {
    try {
      GetRuleOptions getRuleOptions = new GetRuleOptions.Builder()
      .ruleId(ruleIdLink)
      .transactionId(testString)
      .build();

      // Invoke operation
      Response<Rule> response = service.getRule(getRuleOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Rule ruleResult = response.getResult();

      assertNotNull(ruleResult);

      ruleEtag = response.getHeaders().values("etag").get(0);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateRules" })
  public void testUpdateRule() throws Exception {
    try {
      TargetResourceAdditionalTargetAttributesItem targetResourceAdditionalTargetAttributesItemModel = new TargetResourceAdditionalTargetAttributesItem.Builder()
      .name("resource_id")
      .value("81f3db5e-f9db-4c46-9de3-a4a76e66adbf")
      .operator("string_equals")
      .build();

      TargetResource targetResourceModel = new TargetResource.Builder()
      .serviceName("cloud-object-storage")
      .resourceKind("bucket")
      .additionalTargetAttributes(new java.util.ArrayList<TargetResourceAdditionalTargetAttributesItem>(java.util.Arrays.asList(targetResourceAdditionalTargetAttributesItemModel)))
      .build();

      RuleRequiredConfigSingleProperty ruleRequiredConfigModel = new RuleRequiredConfigSingleProperty.Builder()
      .description(testString)
      .property("location")
      .operator("string_equals")
      .value("eu-gb")
      .build();

      EnforcementAction enforcementActionModel = new EnforcementAction.Builder()
      .action("disallow")
      .build();

      UpdateRuleOptions updateRuleOptions = new UpdateRuleOptions.Builder()
      .ruleId(ruleIdLink)
      .ifMatch(ruleEtag)
      .name("Disable public access")
      .description("Ensure that public access to account resources is disabled.")
      .target(targetResourceModel)
      .requiredConfig(ruleRequiredConfigModel)
      .enforcementActions(new java.util.ArrayList<EnforcementAction>(java.util.Arrays.asList(enforcementActionModel)))
      .accountId(accountID)
      .ruleType("user_defined")
      .labels(new java.util.ArrayList<String>(java.util.Arrays.asList(ruleLabel+"-"+identifier)))
      .transactionId(testString)
      .build();

      // Invoke operation
      Response<Rule> response = service.updateRule(updateRuleOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Rule ruleResult = response.getResult();

      assertNotNull(ruleResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateRules" })
  public void testListRuleAttachments() throws Exception {
    try {
      ListRuleAttachmentsOptions listRuleAttachmentsOptions = new ListRuleAttachmentsOptions.Builder()
      .ruleId(ruleIdLink)
      .transactionId(testString)
      .limit(Long.valueOf("1000"))
      .offset(Long.valueOf("26"))
      .build();

      // Invoke operation
      Response<RuleAttachmentList> response = service.listRuleAttachments(listRuleAttachmentsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      RuleAttachmentList ruleAttachmentListResult = response.getResult();

      assertNotNull(ruleAttachmentListResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateRuleAttachments", "testCreateRules" })
  public void testGetRuleAttachment() throws Exception {
    try {
      GetRuleAttachmentOptions getRuleAttachmentOptions = new GetRuleAttachmentOptions.Builder()
      .ruleId(ruleIdLink)
      .attachmentId(ruleAttachmentIdLink)
      .transactionId(testString)
      .build();

      // Invoke operation
      Response<RuleAttachment> response = service.getRuleAttachment(getRuleAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      RuleAttachment ruleAttachmentResult = response.getResult();

      assertNotNull(ruleAttachmentResult);
      
      ruleAttachmentEtag = response.getHeaders().values("etag").get(0);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateRuleAttachments", "testCreateRules" })
  public void testUpdateRuleAttachment() throws Exception {
    try {
      RuleScope ruleScopeModel = new RuleScope.Builder()
      .note("My account")
      .scopeId(accountID)
      .scopeType("account")
      .build();

      RuleScope excludedRuleScopeModel = new RuleScope.Builder()
      .note("My account resource group")
      .scopeId(resourceGroupID)
      .scopeType("account.resource_group")
      .build();

      UpdateRuleAttachmentOptions updateRuleAttachmentOptions = new UpdateRuleAttachmentOptions.Builder()
      .ruleId(ruleIdLink)
      .attachmentId(ruleAttachmentIdLink)
      .ifMatch(ruleAttachmentEtag)
      .accountId(accountID)
      .includedScope(ruleScopeModel)
      .excludedScopes(new java.util.ArrayList<RuleScope>(java.util.Arrays.asList(excludedRuleScopeModel)))
      .transactionId(testString)
      .build();

      // Invoke operation
      Response<TemplateAttachment> response = service.updateRuleAttachment(updateRuleAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TemplateAttachment templateAttachmentResult = response.getResult();

      assertNotNull(templateAttachmentResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateRuleAttachments", "testCreateRules", "testGetRuleAttachment", "testListRuleAttachments", "testGetRule", "testListRules" })
  public void testDeleteRuleAttachment() throws Exception {
    try {
      DeleteRuleAttachmentOptions deleteRuleAttachmentOptions = new DeleteRuleAttachmentOptions.Builder()
      .ruleId(ruleIdLink)
      .attachmentId(ruleAttachmentIdLink)
      .transactionId(testString)
      .build();

      // Invoke operation
      Response<Void> response = service.deleteRuleAttachment(deleteRuleAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteRuleAttachment", "testCreateRules", "testGetRule", "testListRules" })
  public void testDeleteRule() throws Exception {
    try {
      DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
      .ruleId(ruleIdLink)
      .transactionId(testString)
      .build();

      // Invoke operation
      Response<Void> response = service.deleteRule(deleteRuleOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterClass
  public void tearDown() {
    service = ConfigurationGovernance.newInstance();
    config = CredentialUtils.getServiceProperties(ConfigurationGovernance.DEFAULT_SERVICE_NAME);
    System.out.println("Setup up complete.");

    System.out.println(String.format("cleaning up account: %s with rules labelled %s", accountID, ruleLabel));

    ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
    .accountId(accountID)
    .labels(ruleLabel+"-"+identifier)
    .build();

    Response<RuleList> rules = service.listRules(listRulesOptions).execute();
    for(Rule rule: rules.getResult().getRules()) {
      DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
      .ruleId(rule.getRuleId())
      .build();

      service.deleteRule(deleteRuleOptions);
    }
    System.out.println("cleanup was successful");
  }
 }
