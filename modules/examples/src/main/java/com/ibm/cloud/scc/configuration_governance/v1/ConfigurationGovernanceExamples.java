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
import com.ibm.cloud.scc.configuration_governance.v1.model.CreateRulesOptions;
import com.ibm.cloud.scc.configuration_governance.v1.model.CreateRulesResponse;
import com.ibm.cloud.scc.configuration_governance.v1.model.DeleteRuleAttachmentOptions;
import com.ibm.cloud.scc.configuration_governance.v1.model.DeleteRuleOptions;
import com.ibm.cloud.scc.configuration_governance.v1.model.EnforcementAction;
import com.ibm.cloud.scc.configuration_governance.v1.model.GetRuleAttachmentOptions;
import com.ibm.cloud.scc.configuration_governance.v1.model.GetRuleOptions;
import com.ibm.cloud.scc.configuration_governance.v1.model.ListRuleAttachmentsOptions;
import com.ibm.cloud.scc.configuration_governance.v1.model.ListRulesOptions;
import com.ibm.cloud.scc.configuration_governance.v1.model.Rule;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleAttachment;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleAttachmentList;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleAttachmentRequest;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleCondition;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleConditionSingleProperty;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleList;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleRequest;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleRequiredConfigMultiplePropertiesConditionAnd;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleRequiredConfigSingleProperty;
import com.ibm.cloud.scc.configuration_governance.v1.model.RuleScope;
import com.ibm.cloud.scc.configuration_governance.v1.model.TargetResource;
import com.ibm.cloud.scc.configuration_governance.v1.model.TargetResourceAdditionalTargetAttributesItem;
import com.ibm.cloud.scc.configuration_governance.v1.model.TemplateAttachment;
import com.ibm.cloud.scc.configuration_governance.v1.model.UpdateRuleAttachmentOptions;
import com.ibm.cloud.scc.configuration_governance.v1.model.UpdateRuleOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This file provides an example of how to use the Configuration Governance service.
//
// The following configuration properties are assumed to be defined:
// CONFIGURATION_GOVERNANCE_URL=<service base url>
// CONFIGURATION_GOVERNANCE_AUTH_TYPE=iam
// CONFIGURATION_GOVERNANCE_APIKEY=<IAM apikey>
// CONFIGURATION_GOVERNANCE_AUTH_URL=<IAM token service base URL - omit this if using the production environment>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class ConfigurationGovernanceExamples {
  private static final Logger logger = LoggerFactory.getLogger(ConfigurationGovernanceExamples.class);
  protected ConfigurationGovernanceExamples() { }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    ConfigurationGovernance service = ConfigurationGovernance.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(ConfigurationGovernance.DEFAULT_SERVICE_NAME);

    // Variables to hold link values
    String ruleAttachmentIdLink = null;
    String ruleIdLink = null;

    try {
      System.out.println("createRules() result:");
      // begin-create_rules
      TargetResource targetResourceModel = new TargetResource.Builder()
        .serviceName("iam-groups")
        .resourceKind("service")
        .build();
      RuleConditionSingleProperty ruleConditionModel = new RuleConditionSingleProperty.Builder()
        .property("public_access_enabled")
        .operator("is_false")
        .build();
      RuleRequiredConfigMultiplePropertiesConditionAnd ruleRequiredConfigModel = new RuleRequiredConfigMultiplePropertiesConditionAnd.Builder()
        .description("Public access check")
        .and(new java.util.ArrayList<RuleCondition>(java.util.Arrays.asList(ruleConditionModel)))
        .build();
      EnforcementAction enforcementActionModel = new EnforcementAction.Builder()
        .action("disallow")
        .build();
      RuleRequest ruleRequestModel = new RuleRequest.Builder()
        .accountId("531fc3e28bfc43c5a2cea07786d93f5c")
        .name("Disable public access")
        .description("Ensure that public access to account resources is disabled.")
        .target(targetResourceModel)
        .requiredConfig(ruleRequiredConfigModel)
        .enforcementActions(new java.util.ArrayList<EnforcementAction>(java.util.Arrays.asList(enforcementActionModel)))
        .labels(new java.util.ArrayList<String>(java.util.Arrays.asList("Access", "IAM")))
        .build();
      CreateRuleRequest createRuleRequestModel = new CreateRuleRequest.Builder()
        .requestId("3cebc877-58e7-44a5-a292-32114fa73558")
        .rule(ruleRequestModel)
        .build();
      CreateRulesOptions createRulesOptions = new CreateRulesOptions.Builder()
        .rules(new java.util.ArrayList<CreateRuleRequest>(java.util.Arrays.asList(createRuleRequestModel)))
        .build();

      Response<CreateRulesResponse> response = service.createRules(createRulesOptions).execute();
      CreateRulesResponse createRulesResponse = response.getResult();

      System.out.println(createRulesResponse);
      // end-create_rules

      ruleIdLink = createRulesResponse.getRules().get(0).getRule().getRuleId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createRuleAttachments() result:");
      // begin-create_rule_attachments
      RuleScope ruleScopeModel = new RuleScope.Builder()
        .note("My enterprise")
        .scopeId("282cf433ac91493ba860480d92519990")
        .scopeType("enterprise")
        .build();
      RuleAttachmentRequest ruleAttachmentRequestModel = new RuleAttachmentRequest.Builder()
        .accountId("531fc3e28bfc43c5a2cea07786d93f5c")
        .includedScope(ruleScopeModel)
        .excludedScopes(new java.util.ArrayList<RuleScope>(java.util.Arrays.asList(ruleScopeModel)))
        .build();
      CreateRuleAttachmentsOptions createRuleAttachmentsOptions = new CreateRuleAttachmentsOptions.Builder()
        .ruleId(ruleIdLink)
        .attachments(new java.util.ArrayList<RuleAttachmentRequest>(java.util.Arrays.asList(ruleAttachmentRequestModel)))
        .build();

      Response<CreateRuleAttachmentsResponse> response = service.createRuleAttachments(createRuleAttachmentsOptions).execute();
      CreateRuleAttachmentsResponse createRuleAttachmentsResponse = response.getResult();

      System.out.println(createRuleAttachmentsResponse);
      // end-create_rule_attachments

      ruleAttachmentIdLink = createRuleAttachmentsResponse.getAttachments().get(0).getAttachmentId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listRules() result:");
      // begin-list_rules
      ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
        .accountId("531fc3e28bfc43c5a2cea07786d93f5c")
        .attached(true)
        .labels("SOC2,ITCS300")
        .scopes("scope_id")
        .build();

      Response<RuleList> response = service.listRules(listRulesOptions).execute();
      RuleList ruleList = response.getResult();

      System.out.println(ruleList);
      // end-list_rules
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getRule() result:");
      // begin-get_rule
      GetRuleOptions getRuleOptions = new GetRuleOptions.Builder()
        .ruleId(ruleIdLink)
        .build();

      Response<Rule> response = service.getRule(getRuleOptions).execute();
      Rule rule = response.getResult();

      System.out.println(rule);
      // end-get_rule
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateRule() result:");
      // begin-update_rule
      TargetResourceAdditionalTargetAttributesItem targetResourceAdditionalTargetAttributesItemModel = new TargetResourceAdditionalTargetAttributesItem.Builder()
        .name("testString")
        .value("testString")
        .operator("string_equals")
        .build();
      TargetResource targetResourceModel = new TargetResource.Builder()
        .serviceName("iam-groups")
        .resourceKind("service")
        .additionalTargetAttributes(new java.util.ArrayList<TargetResourceAdditionalTargetAttributesItem>(java.util.Arrays.asList(targetResourceAdditionalTargetAttributesItemModel)))
        .build();
      RuleRequiredConfigSingleProperty ruleRequiredConfigModel = new RuleRequiredConfigSingleProperty.Builder()
        .property("public_access_enabled")
        .operator("is_false")
        .build();
      EnforcementAction enforcementActionModel = new EnforcementAction.Builder()
        .action("audit_log")
        .build();
      UpdateRuleOptions updateRuleOptions = new UpdateRuleOptions.Builder()
        .ruleId(ruleIdLink)
        .ifMatch("testString")
        .name("Disable public access")
        .description("Ensure that public access to account resources is disabled.")
        .target(targetResourceModel)
        .requiredConfig(ruleRequiredConfigModel)
        .enforcementActions(new java.util.ArrayList<EnforcementAction>(java.util.Arrays.asList(enforcementActionModel)))
        .accountId("531fc3e28bfc43c5a2cea07786d93f5c")
        .ruleType("user_defined")
        .labels(new java.util.ArrayList<String>(java.util.Arrays.asList("SOC2", "ITCS300")))
        .build();

      Response<Rule> response = service.updateRule(updateRuleOptions).execute();
      Rule rule = response.getResult();

      System.out.println(rule);
      // end-update_rule
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listRuleAttachments() result:");
      // begin-list_rule_attachments
      ListRuleAttachmentsOptions listRuleAttachmentsOptions = new ListRuleAttachmentsOptions.Builder()
        .ruleId(ruleIdLink)
        .build();

      Response<RuleAttachmentList> response = service.listRuleAttachments(listRuleAttachmentsOptions).execute();
      RuleAttachmentList ruleAttachmentList = response.getResult();

      System.out.println(ruleAttachmentList);
      // end-list_rule_attachments
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getRuleAttachment() result:");
      // begin-get_rule_attachment
      GetRuleAttachmentOptions getRuleAttachmentOptions = new GetRuleAttachmentOptions.Builder()
        .ruleId(ruleIdLink)
        .attachmentId(ruleAttachmentIdLink)
        .build();

      Response<RuleAttachment> response = service.getRuleAttachment(getRuleAttachmentOptions).execute();
      RuleAttachment ruleAttachment = response.getResult();

      System.out.println(ruleAttachment);
      // end-get_rule_attachment
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateRuleAttachment() result:");
      // begin-update_rule_attachment
      RuleScope ruleScopeModel = new RuleScope.Builder()
        .note("My enterprise")
        .scopeId("282cf433ac91493ba860480d92519990")
        .scopeType("enterprise")
        .build();
      UpdateRuleAttachmentOptions updateRuleAttachmentOptions = new UpdateRuleAttachmentOptions.Builder()
        .ruleId(ruleIdLink)
        .attachmentId(ruleAttachmentIdLink)
        .ifMatch("testString")
        .accountId("531fc3e28bfc43c5a2cea07786d93f5c")
        .includedScope(ruleScopeModel)
        .excludedScopes(new java.util.ArrayList<RuleScope>(java.util.Arrays.asList(ruleScopeModel)))
        .build();

      Response<TemplateAttachment> response = service.updateRuleAttachment(updateRuleAttachmentOptions).execute();
      TemplateAttachment templateAttachment = response.getResult();

      System.out.println(templateAttachment);
      // end-update_rule_attachment
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_rule_attachment
      DeleteRuleAttachmentOptions deleteRuleAttachmentOptions = new DeleteRuleAttachmentOptions.Builder()
        .ruleId(ruleIdLink)
        .attachmentId(ruleAttachmentIdLink)
        .build();

      Response<Void> response = service.deleteRuleAttachment(deleteRuleAttachmentOptions).execute();
      // end-delete_rule_attachment
      System.out.printf("deleteRuleAttachment() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_rule
      DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
        .ruleId(ruleIdLink)
        .build();

      Response<Void> response = service.deleteRule(deleteRuleOptions).execute();
      // end-delete_rule
      System.out.printf("deleteRule() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
