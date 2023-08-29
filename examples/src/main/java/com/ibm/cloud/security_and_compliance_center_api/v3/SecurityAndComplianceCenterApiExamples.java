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

package com.ibm.cloud.security_and_compliance_center_api.v3;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AdditionalTargetAttribute;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentParameterPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentsAccountPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentsNotificationsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentsPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlDocs;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibrariesPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibrary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibraryDelete;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibraryItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSpecifications;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlsInControlLib;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateCustomControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateScanOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DefaultParametersPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteCustomControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteCustomProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteProfileAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Evaluation;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EventNotifications;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.FailedControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetLatestReportsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProfileAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProviderTypeByIdOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProviderTypesInstancesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportControlsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportEvaluationOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportSummaryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportTagsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportViolationsDriftOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetSettingsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Implementation;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Import;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListAttachmentsAccountOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListAttachmentsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListControlLibrariesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListProfilesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListProviderTypeInstancesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListProviderTypesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListReportEvaluationsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListReportResourcesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListReportsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListRulesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.MultiCloudScope;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ObjectStorage;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Parameter;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ParameterInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PostTestEventOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Profile;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileControlsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfilesPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PropertyItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderTypeInstanceItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderTypeInstancesResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderTypeItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderTypesCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderTypesInstancesResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceCustomControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceProfileAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Report;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportEvaluationsPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportLatest;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportResourcesPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportSummary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportTags;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportViolationsDrift;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportsPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigItemsRequiredConfigBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigRequiredConfigAnd;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Resource;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Rule;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RuleInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RulesPageBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Scan;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Settings;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Target;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.TestEvent;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateSettingsOptions;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class contains examples of how to use the Security and Compliance Center API service.
 *
 * The following configuration properties are assumed to be defined:
 * SECURITY_AND_COMPLIANCE_CENTER_API_URL=&lt;service base url&gt;
 * SECURITY_AND_COMPLIANCE_CENTER_API_AUTH_TYPE=iam
 * SECURITY_AND_COMPLIANCE_CENTER_API_APIKEY=&lt;IAM apikey&gt;
 * SECURITY_AND_COMPLIANCE_CENTER_API_AUTH_URL=&lt;IAM token service base URL - omit this if using the production environment&gt;
 *
 * These configuration properties can be exported as environment variables, or stored
 * in a configuration file and then:
 * export IBM_CREDENTIALS_FILE=&lt;name of configuration file&gt;
 */
public class SecurityAndComplianceCenterApiExamples {
  private static final Logger logger = LoggerFactory.getLogger(SecurityAndComplianceCenterApiExamples.class);
  protected SecurityAndComplianceCenterApiExamples() { }

  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../security_and_compliance_center_api_v3.env");
  }

  /**
   * The main() function invokes operations of the Security and Compliance Center API service.
   * @param args command-line arguments
   * @throws Exception an error occurred
   */
  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    SecurityAndComplianceCenterApi securityAndComplianceCenterApiService = SecurityAndComplianceCenterApi.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> testConfigProperties = CredentialUtils.getServiceProperties(SecurityAndComplianceCenterApi.DEFAULT_SERVICE_NAME);

    // Variables to hold link values
    String accountIdForReportLink = null;
    String attachmentIdForReportLink = null;
    String attachmentIdLink = null;
    String controlLibraryIdLink = null;
    String eTagLink = null;
    String eventNotificationsCrnForUpdateSettingsLink = null;
    String groupIdForReportLink = null;
    String objectStorageBucketForUpdateSettingsLink = null;
    String objectStorageCrnForUpdateSettingsLink = null;
    String objectStorageLocationForUpdateSettingsLink = null;
    String profileIdForReportLink = null;
    String profileIdLink = null;
    String providerTypeIdLink = null;
    String providerTypeInstanceIdLink = null;
    String reportIdForReportLink = null;
    String ruleIdLink = null;
    String typeForReportLink = null;

    try {
      System.out.println("getSettings() result:");
      // begin-get_settings
      GetSettingsOptions getSettingsOptions = new GetSettingsOptions.Builder()
        .xCorrelationId("1a2b3c4d-5e6f-4a7b-8c9d-e0f1a2b3c4d5")
        .build();

      Response<Settings> response = securityAndComplianceCenterApiService.getSettings(getSettingsOptions).execute();
      Settings settings = response.getResult();

      System.out.println(settings);
      // end-get_settings

      eventNotificationsCrnForUpdateSettingsLink = settings.eventNotifications().instanceCrn();
      objectStorageCrnForUpdateSettingsLink = settings.objectStorage().instanceCrn();
      objectStorageBucketForUpdateSettingsLink = settings.objectStorage().bucket();
      objectStorageLocationForUpdateSettingsLink = settings.objectStorage().bucketLocation();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createRule() result:");
      // begin-create_rule
      AdditionalTargetAttribute additionalTargetAttributeModel = new AdditionalTargetAttribute.Builder()
        .name("location")
        .operator("string_equals")
        .value("us-east")
        .build();
      Target targetModel = new Target.Builder()
        .serviceName("cloud-object-storage")
        .resourceKind("bucket")
        .additionalTargetAttributes(java.util.Arrays.asList(additionalTargetAttributeModel))
        .build();
      RequiredConfigItemsRequiredConfigBase requiredConfigItemsModel = new RequiredConfigItemsRequiredConfigBase.Builder()
        .property("hard_quota")
        .operator("num_equals")
        .value("${hard_quota}")
        .build();
      RequiredConfigRequiredConfigAnd requiredConfigModel = new RequiredConfigRequiredConfigAnd.Builder()
        .description("The Cloud Object Storage rule.")
        .and(java.util.Arrays.asList(requiredConfigItemsModel))
        .build();
      Parameter parameterModel = new Parameter.Builder()
        .name("hard_quota")
        .displayName("The Cloud Object Storage bucket quota.")
        .description("The maximum bytes that are allocated to the Cloud Object Storage bucket.")
        .type("numeric")
        .build();
      Import importModel = new Import.Builder()
        .parameters(java.util.Arrays.asList(parameterModel))
        .build();
      CreateRuleOptions createRuleOptions = new CreateRuleOptions.Builder()
        .description("Example rule")
        .target(targetModel)
        .requiredConfig(requiredConfigModel)
        .version("1.0.0")
        .xImport(importModel)
        .labels(java.util.Arrays.asList())
        .build();

      Response<Rule> response = securityAndComplianceCenterApiService.createRule(createRuleOptions).execute();
      Rule rule = response.getResult();

      System.out.println(rule);
      // end-create_rule

      ruleIdLink = rule.getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getRule() result:");
      // begin-get_rule
      GetRuleOptions getRuleOptions = new GetRuleOptions.Builder()
        .ruleId(ruleIdLink)
        .build();

      Response<Rule> response = securityAndComplianceCenterApiService.getRule(getRuleOptions).execute();
      Rule rule = response.getResult();

      System.out.println(rule);
      // end-get_rule

      eTagLink = response.getHeaders().values("ETag").get(0);
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getLatestReports() result:");
      // begin-get_latest_reports
      GetLatestReportsOptions getLatestReportsOptions = new GetLatestReportsOptions.Builder()
        .sort("profile_name")
        .build();

      Response<ReportLatest> response = securityAndComplianceCenterApiService.getLatestReports(getLatestReportsOptions).execute();
      ReportLatest reportLatest = response.getResult();

      System.out.println(reportLatest);
      // end-get_latest_reports

      accountIdForReportLink = reportLatest.getReports().get(0).getAccount().getId();
      reportIdForReportLink = reportLatest.getReports().get(0).getId();
      attachmentIdForReportLink = reportLatest.getReports().get(0).getAttachment().getId();
      groupIdForReportLink = reportLatest.getReports().get(0).getGroupId();
      profileIdForReportLink = reportLatest.getReports().get(0).getProfile().getId();
      typeForReportLink = reportLatest.getReports().get(0).getType();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateSettings() result:");
      // begin-update_settings
      EventNotifications eventNotificationsModel = new EventNotifications.Builder()
        .instanceCrn(eventNotificationsCrnForUpdateSettingsLink)
        .sourceDescription("This source is used for integration with IBM Cloud Security and Compliance Center.")
        .sourceName("compliance")
        .build();
      ObjectStorage objectStorageModel = new ObjectStorage.Builder()
        .instanceCrn(objectStorageCrnForUpdateSettingsLink)
        .bucket(objectStorageBucketForUpdateSettingsLink)
        .bucketLocation(objectStorageLocationForUpdateSettingsLink)
        .build();
      UpdateSettingsOptions updateSettingsOptions = new UpdateSettingsOptions.Builder()
        .eventNotifications(eventNotificationsModel)
        .objectStorage(objectStorageModel)
        .xCorrelationId("1a2b3c4d-5e6f-4a7b-8c9d-e0f1a2b3c4d5")
        .build();

      Response<Settings> response = securityAndComplianceCenterApiService.updateSettings(updateSettingsOptions).execute();
      Settings settings = response.getResult();

      System.out.println(settings);
      // end-update_settings
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("postTestEvent() result:");
      // begin-post_test_event
      PostTestEventOptions postTestEventOptions = new PostTestEventOptions.Builder()
        .xCorrelationId("1a2b3c4d-5e6f-4a7b-8c9d-e0f1a2b3c4d5")
        .build();

      Response<TestEvent> response = securityAndComplianceCenterApiService.postTestEvent(postTestEventOptions).execute();
      TestEvent testEvent = response.getResult();

      System.out.println(testEvent);
      // end-post_test_event
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createCustomControlLibrary() result:");
      // begin-create_custom_control_library
      ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
        .parameterName("session_invalidation_in_seconds")
        .parameterDisplayName("Sign out due to inactivity in seconds")
        .parameterType("numeric")
        .build();
      Implementation implementationModel = new Implementation.Builder()
        .assessmentId("rule-a637949b-7e51-46c4-afd4-b96619001bf1")
        .assessmentMethod("ibm-cloud-rule")
        .assessmentType("automated")
        .assessmentDescription("Check that there is an Activity Tracker event route defined to collect global events generated by IBM Cloud services")
        .parameters(java.util.Arrays.asList(parameterInfoModel))
        .build();
      ControlSpecifications controlSpecificationsModel = new ControlSpecifications.Builder()
        .controlSpecificationId("5c7d6f88-a92f-4734-9b49-bd22b0900184")
        .componentId("iam-identity")
        .environment("ibm-cloud")
        .controlSpecificationDescription("IBM cloud")
        .assessments(java.util.Arrays.asList(implementationModel))
        .build();
      ControlDocs controlDocsModel = new ControlDocs.Builder()
        .controlDocsId("sc-7")
        .controlDocsType("ibm-cloud")
        .build();
      ControlsInControlLib controlsInControlLibModel = new ControlsInControlLib.Builder()
        .controlName("SC-7")
        .controlId("1fa45e17-9322-4e6c-bbd6-1c51db08e790")
        .controlDescription("Boundary Protection")
        .controlCategory("System and Communications Protection")
        .controlTags(java.util.Arrays.asList("1fa45e17-9322-4e6c-bbd6-1c51db08e790"))
        .controlSpecifications(java.util.Arrays.asList(controlSpecificationsModel))
        .controlDocs(controlDocsModel)
        .controlRequirement(true)
        .build();
      CreateCustomControlLibraryOptions createCustomControlLibraryOptions = new CreateCustomControlLibraryOptions.Builder()
        .controlLibraryName("IBM Cloud for Financial Services")
        .controlLibraryDescription("IBM Cloud for Financial Services")
        .controlLibraryType("custom")
        .controls(java.util.Arrays.asList(controlsInControlLibModel))
        .versionGroupLabel("33fc7b80-0fa5-4f16-bbba-1f293f660f0d")
        .controlLibraryVersion("1.0.0")
        .build();

      Response<ControlLibrary> response = securityAndComplianceCenterApiService.createCustomControlLibrary(createCustomControlLibraryOptions).execute();
      ControlLibrary controlLibrary = response.getResult();

      System.out.println(controlLibrary);
      // end-create_custom_control_library

      controlLibraryIdLink = controlLibrary.id();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listControlLibraries() result:");
      // begin-list_control_libraries
      ListControlLibrariesOptions listControlLibrariesOptions = new ListControlLibrariesOptions.Builder()
        .xCorrelationId("testString")
        .xRequestId("testString")
        .limit(Long.valueOf("50"))
        .controlLibraryType("custom")
        .build();

      ControlLibrariesPager pager = new ControlLibrariesPager(securityAndComplianceCenterApiService, listControlLibrariesOptions);
      List<ControlLibraryItem> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<ControlLibraryItem> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_control_libraries
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getControlLibrary() result:");
      // begin-get_control_library
      GetControlLibraryOptions getControlLibraryOptions = new GetControlLibraryOptions.Builder()
        .controlLibrariesId(controlLibraryIdLink)
        .build();

      Response<ControlLibrary> response = securityAndComplianceCenterApiService.getControlLibrary(getControlLibraryOptions).execute();
      ControlLibrary controlLibrary = response.getResult();

      System.out.println(controlLibrary);
      // end-get_control_library
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("replaceCustomControlLibrary() result:");
      // begin-replace_custom_control_library
      ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
        .parameterName("session_invalidation_in_seconds")
        .parameterDisplayName("Sign out due to inactivity in seconds")
        .parameterType("numeric")
        .build();
      Implementation implementationModel = new Implementation.Builder()
        .assessmentId("rule-a637949b-7e51-46c4-afd4-b96619001bf1")
        .assessmentMethod("ibm-cloud-rule")
        .assessmentType("automated")
        .assessmentDescription("Check that there is an Activity Tracker event route defined to collect global events generated by IBM Cloud services")
        .parameters(java.util.Arrays.asList(parameterInfoModel))
        .build();
      ControlSpecifications controlSpecificationsModel = new ControlSpecifications.Builder()
        .controlSpecificationId("5c7d6f88-a92f-4734-9b49-bd22b0900184")
        .responsibility("user")
        .componentId("iam-identity")
        .environment("ibm-cloud")
        .controlSpecificationDescription("IBM cloud")
        .assessments(java.util.Arrays.asList(implementationModel))
        .build();
      ControlDocs controlDocsModel = new ControlDocs.Builder()
        .controlDocsId("sc-7")
        .controlDocsType("ibm-cloud")
        .build();
      ControlsInControlLib controlsInControlLibModel = new ControlsInControlLib.Builder()
        .controlName("SC-7")
        .controlId("1fa45e17-9322-4e6c-bbd6-1c51db08e790")
        .controlDescription("Boundary Protection")
        .controlCategory("System and Communications Protection")
        .controlTags(java.util.Arrays.asList("1fa45e17-9322-4e6c-bbd6-1c51db08e790"))
        .controlSpecifications(java.util.Arrays.asList(controlSpecificationsModel))
        .controlDocs(controlDocsModel)
        .controlRequirement(true)
        .build();
      ReplaceCustomControlLibraryOptions replaceCustomControlLibraryOptions = new ReplaceCustomControlLibraryOptions.Builder()
        .controlLibrariesId(controlLibraryIdLink)
        .controlLibraryName("IBM Cloud for Financial Services")
        .controlLibraryDescription("IBM Cloud for Financial Services")
        .controlLibraryType("custom")
        .controlLibraryVersion("1.1.0")
        .controls(java.util.Arrays.asList(controlsInControlLibModel))
        .build();

      Response<ControlLibrary> response = securityAndComplianceCenterApiService.replaceCustomControlLibrary(replaceCustomControlLibraryOptions).execute();
      ControlLibrary controlLibrary = response.getResult();

      System.out.println(controlLibrary);
      // end-replace_custom_control_library
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createProfile() result:");
      // begin-create_profile
      ProfileControlsPrototype profileControlsPrototypeModel = new ProfileControlsPrototype.Builder()
        .controlLibraryId(controlLibraryIdLink)
        .controlId("1fa45e17-9322-4e6c-bbd6-1c51db08e790")
        .build();
      DefaultParametersPrototype defaultParametersPrototypeModel = new DefaultParametersPrototype.Builder()
        .assessmentType("Automated")
        .assessmentId("rule-a637949b-7e51-46c4-afd4-b96619001bf1")
        .parameterName("session_invalidation_in_seconds")
        .parameterDefaultValue("120")
        .parameterDisplayName("Sign out due to inactivity in seconds")
        .parameterType("numeric")
        .build();
      CreateProfileOptions createProfileOptions = new CreateProfileOptions.Builder()
        .profileName("test_profile1")
        .profileDescription("test_description1")
        .profileType("custom")
        .controls(java.util.Arrays.asList(profileControlsPrototypeModel))
        .defaultParameters(java.util.Arrays.asList(defaultParametersPrototypeModel))
        .build();

      Response<Profile> response = securityAndComplianceCenterApiService.createProfile(createProfileOptions).execute();
      Profile profile = response.getResult();

      System.out.println(profile);
      // end-create_profile

      profileIdLink = profile.getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listProfiles() result:");
      // begin-list_profiles
      ListProfilesOptions listProfilesOptions = new ListProfilesOptions.Builder()
        .xCorrelationId("testString")
        .xRequestId("testString")
        .limit(Long.valueOf("10"))
        .profileType("custom")
        .build();

      ProfilesPager pager = new ProfilesPager(securityAndComplianceCenterApiService, listProfilesOptions);
      List<ProfileItem> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<ProfileItem> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_profiles
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getProfile() result:");
      // begin-get_profile
      GetProfileOptions getProfileOptions = new GetProfileOptions.Builder()
        .profilesId(profileIdLink)
        .build();

      Response<Profile> response = securityAndComplianceCenterApiService.getProfile(getProfileOptions).execute();
      Profile profile = response.getResult();

      System.out.println(profile);
      // end-get_profile
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("replaceProfile() result:");
      // begin-replace_profile
      ProfileControlsPrototype profileControlsPrototypeModel = new ProfileControlsPrototype.Builder()
        .controlLibraryId(controlLibraryIdLink)
        .controlId("1fa45e17-9322-4e6c-bbd6-1c51db08e790")
        .build();
      DefaultParametersPrototype defaultParametersPrototypeModel = new DefaultParametersPrototype.Builder()
        .assessmentType("Automated")
        .assessmentId("rule-a637949b-7e51-46c4-afd4-b96619001bf1")
        .parameterName("session_invalidation_in_seconds")
        .parameterDefaultValue("120")
        .parameterDisplayName("Sign out due to inactivity in seconds")
        .parameterType("numeric")
        .build();
      ReplaceProfileOptions replaceProfileOptions = new ReplaceProfileOptions.Builder()
        .profilesId(profileIdLink)
        .profileName("test_profile1")
        .profileDescription("test_description1")
        .profileType("custom")
        .controls(java.util.Arrays.asList(profileControlsPrototypeModel))
        .defaultParameters(java.util.Arrays.asList(defaultParametersPrototypeModel))
        .build();

      Response<Profile> response = securityAndComplianceCenterApiService.replaceProfile(replaceProfileOptions).execute();
      Profile profile = response.getResult();

      System.out.println(profile);
      // end-replace_profile
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listRules() result:");
      // begin-list_rules
      ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
        .type("system_defined")
        .build();

      Response<RulesPageBase> response = securityAndComplianceCenterApiService.listRules(listRulesOptions).execute();
      RulesPageBase rulesPageBase = response.getResult();

      System.out.println(rulesPageBase);
      // end-list_rules
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("replaceRule() result:");
      // begin-replace_rule
      AdditionalTargetAttribute additionalTargetAttributeModel = new AdditionalTargetAttribute.Builder()
        .name("location")
        .operator("string_equals")
        .value("us-south")
        .build();
      Target targetModel = new Target.Builder()
        .serviceName("cloud-object-storage")
        .serviceDisplayName("Cloud Object Storage")
        .resourceKind("bucket")
        .additionalTargetAttributes(java.util.Arrays.asList(additionalTargetAttributeModel))
        .build();
      RequiredConfigItemsRequiredConfigBase requiredConfigItemsModel = new RequiredConfigItemsRequiredConfigBase.Builder()
        .property("hard_quota")
        .operator("num_equals")
        .value("${hard_quota}")
        .build();
      RequiredConfigRequiredConfigAnd requiredConfigModel = new RequiredConfigRequiredConfigAnd.Builder()
        .description("The Cloud Object Storage rule.")
        .and(java.util.Arrays.asList(requiredConfigItemsModel))
        .build();
      Parameter parameterModel = new Parameter.Builder()
        .name("hard_quota")
        .displayName("The Cloud Object Storage bucket quota.")
        .description("The maximum bytes that are allocated to the Cloud Object Storage bucket.")
        .type("numeric")
        .build();
      Import importModel = new Import.Builder()
        .parameters(java.util.Arrays.asList(parameterModel))
        .build();
      ReplaceRuleOptions replaceRuleOptions = new ReplaceRuleOptions.Builder()
        .ruleId(ruleIdLink)
        .ifMatch(eTagLink)
        .description("Example rule")
        .target(targetModel)
        .requiredConfig(requiredConfigModel)
        .type("user_defined")
        .version("1.0.1")
        .xImport(importModel)
        .labels(java.util.Arrays.asList())
        .build();

      Response<Rule> response = securityAndComplianceCenterApiService.replaceRule(replaceRuleOptions).execute();
      Rule rule = response.getResult();

      System.out.println(rule);
      // end-replace_rule
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createAttachment() result:");
      // begin-create_attachment
      PropertyItem propertyItemModel = new PropertyItem.Builder()
        .name("scope_id")
        .value("cg3335893hh1428692d6747cf300yeb5")
        .build();
      MultiCloudScope multiCloudScopeModel = new MultiCloudScope.Builder()
        .environment("ibm-cloud")
        .xProperties(java.util.Arrays.asList(propertyItemModel))
        .build();
      FailedControls failedControlsModel = new FailedControls.Builder()
        .thresholdLimit(Long.valueOf("15"))
        .failedControlIds(java.util.Arrays.asList())
        .build();
      AttachmentsNotificationsPrototype attachmentsNotificationsPrototypeModel = new AttachmentsNotificationsPrototype.Builder()
        .enabled(false)
        .controls(failedControlsModel)
        .build();
      AttachmentParameterPrototype attachmentParameterPrototypeModel = new AttachmentParameterPrototype.Builder()
        .assessmentType("Automated")
        .assessmentId("rule-a637949b-7e51-46c4-afd4-b96619001bf1")
        .parameterName("session_invalidation_in_seconds")
        .parameterValue("120")
        .parameterDisplayName("Sign out due to inactivity in seconds")
        .parameterType("numeric")
        .build();
      AttachmentsPrototype attachmentsPrototypeModel = new AttachmentsPrototype.Builder()
        .name("account-0d8c3805dfea40aa8ad02265a18eb12b")
        .description("Test description")
        .scope(java.util.Arrays.asList(multiCloudScopeModel))
        .status("enabled")
        .schedule("every_30_days")
        .notifications(attachmentsNotificationsPrototypeModel)
        .attachmentParameters(java.util.Arrays.asList(attachmentParameterPrototypeModel))
        .build();
      CreateAttachmentOptions createAttachmentOptions = new CreateAttachmentOptions.Builder()
        .profilesId(profileIdLink)
        .attachments(java.util.Arrays.asList(attachmentsPrototypeModel))
        .build();

      Response<AttachmentPrototype> response = securityAndComplianceCenterApiService.createAttachment(createAttachmentOptions).execute();
      AttachmentPrototype attachmentPrototype = response.getResult();

      System.out.println(attachmentPrototype);
      // end-create_attachment

      attachmentIdLink = attachmentPrototype.attachments().get(0).id();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listAttachments() result:");
      // begin-list_attachments
      ListAttachmentsOptions listAttachmentsOptions = new ListAttachmentsOptions.Builder()
        .profilesId(profileIdLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
        .limit(Long.valueOf("10"))
        .build();

      AttachmentsPager pager = new AttachmentsPager(securityAndComplianceCenterApiService, listAttachmentsOptions);
      List<AttachmentItem> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<AttachmentItem> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_attachments
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getProfileAttachment() result:");
      // begin-get_profile_attachment
      GetProfileAttachmentOptions getProfileAttachmentOptions = new GetProfileAttachmentOptions.Builder()
        .attachmentId(attachmentIdLink)
        .profilesId(profileIdLink)
        .build();

      Response<AttachmentItem> response = securityAndComplianceCenterApiService.getProfileAttachment(getProfileAttachmentOptions).execute();
      AttachmentItem attachmentItem = response.getResult();

      System.out.println(attachmentItem);
      // end-get_profile_attachment
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("replaceProfileAttachment() result:");
      // begin-replace_profile_attachment
      PropertyItem propertyItemModel = new PropertyItem.Builder()
        .name("scope_id")
        .value("cg3335893hh1428692d6747cf300yeb5")
        .build();
      MultiCloudScope multiCloudScopeModel = new MultiCloudScope.Builder()
        .environment("ibm-cloud")
        .xProperties(java.util.Arrays.asList(propertyItemModel))
        .build();
      FailedControls failedControlsModel = new FailedControls.Builder()
        .thresholdLimit(Long.valueOf("15"))
        .failedControlIds(java.util.Arrays.asList())
        .build();
      AttachmentsNotificationsPrototype attachmentsNotificationsPrototypeModel = new AttachmentsNotificationsPrototype.Builder()
        .enabled(false)
        .controls(failedControlsModel)
        .build();
      AttachmentParameterPrototype attachmentParameterPrototypeModel = new AttachmentParameterPrototype.Builder()
        .assessmentType("Automated")
        .assessmentId("rule-a637949b-7e51-46c4-afd4-b96619001bf1")
        .parameterName("session_invalidation_in_seconds")
        .parameterValue("120")
        .parameterDisplayName("Sign out due to inactivity in seconds")
        .parameterType("numeric")
        .build();
      ReplaceProfileAttachmentOptions replaceProfileAttachmentOptions = new ReplaceProfileAttachmentOptions.Builder()
        .attachmentId(attachmentIdLink)
        .profilesId(profileIdLink)
        .scope(java.util.Arrays.asList(multiCloudScopeModel))
        .status("enabled")
        .schedule("every_30_days")
        .notifications(attachmentsNotificationsPrototypeModel)
        .attachmentParameters(java.util.Arrays.asList(attachmentParameterPrototypeModel))
        .name("account-0d8c3805dfea40aa8ad02265a18eb12b")
        .description("Test description")
        .build();

      Response<AttachmentItem> response = securityAndComplianceCenterApiService.replaceProfileAttachment(replaceProfileAttachmentOptions).execute();
      AttachmentItem attachmentItem = response.getResult();

      System.out.println(attachmentItem);
      // end-replace_profile_attachment
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createScan() result:");
      // begin-create_scan
      CreateScanOptions createScanOptions = new CreateScanOptions.Builder()
        .attachmentId(attachmentIdLink)
        .build();

      Response<Scan> response = securityAndComplianceCenterApiService.createScan(createScanOptions).execute();
      Scan scan = response.getResult();

      System.out.println(scan);
      // end-create_scan
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listAttachmentsAccount() result:");
      // begin-list_attachments_account
      ListAttachmentsAccountOptions listAttachmentsAccountOptions = new ListAttachmentsAccountOptions.Builder()
        .xCorrelationId("testString")
        .xRequestId("testString")
        .limit(Long.valueOf("10"))
        .build();

      AttachmentsAccountPager pager = new AttachmentsAccountPager(securityAndComplianceCenterApiService, listAttachmentsAccountOptions);
      List<AttachmentItem> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<AttachmentItem> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_attachments_account
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listReports() result:");
      // begin-list_reports
      ListReportsOptions listReportsOptions = new ListReportsOptions.Builder()
        .xCorrelationId("testString")
        .xRequestId("testString")
        .attachmentId(attachmentIdForReportLink)
        .groupId(groupIdForReportLink)
        .profileId(profileIdForReportLink)
        .type(typeForReportLink)
        .limit(Long.valueOf("10"))
        .sort("profile_name")
        .build();

      ReportsPager pager = new ReportsPager(securityAndComplianceCenterApiService, listReportsOptions);
      List<Report> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<Report> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_reports
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getReport() result:");
      // begin-get_report
      GetReportOptions getReportOptions = new GetReportOptions.Builder()
        .reportId(reportIdForReportLink)
        .build();

      Response<Report> response = securityAndComplianceCenterApiService.getReport(getReportOptions).execute();
      Report report = response.getResult();

      System.out.println(report);
      // end-get_report
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getReportSummary() result:");
      // begin-get_report_summary
      GetReportSummaryOptions getReportSummaryOptions = new GetReportSummaryOptions.Builder()
        .reportId(reportIdForReportLink)
        .build();

      Response<ReportSummary> response = securityAndComplianceCenterApiService.getReportSummary(getReportSummaryOptions).execute();
      ReportSummary reportSummary = response.getResult();

      System.out.println(reportSummary);
      // end-get_report_summary
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getReportEvaluation() result:");
      // begin-get_report_evaluation
      GetReportEvaluationOptions getReportEvaluationOptions = new GetReportEvaluationOptions.Builder()
        .reportId(reportIdForReportLink)
        .build();

      Response<InputStream> response = securityAndComplianceCenterApiService.getReportEvaluation(getReportEvaluationOptions).execute();
      InputStream inputStream = response.getResult();

      System.out.println(inputStream);
      // end-get_report_evaluation
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getReportControls() result:");
      // begin-get_report_controls
      GetReportControlsOptions getReportControlsOptions = new GetReportControlsOptions.Builder()
        .reportId(reportIdForReportLink)
        .status("compliant")
        .build();

      Response<ReportControls> response = securityAndComplianceCenterApiService.getReportControls(getReportControlsOptions).execute();
      ReportControls reportControls = response.getResult();

      System.out.println(reportControls);
      // end-get_report_controls
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getReportRule() result:");
      // begin-get_report_rule
      GetReportRuleOptions getReportRuleOptions = new GetReportRuleOptions.Builder()
        .reportId(reportIdForReportLink)
        .ruleId("rule-8d444f8c-fd1d-48de-bcaa-f43732568761")
        .build();

      Response<RuleInfo> response = securityAndComplianceCenterApiService.getReportRule(getReportRuleOptions).execute();
      RuleInfo ruleInfo = response.getResult();

      System.out.println(ruleInfo);
      // end-get_report_rule
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listReportEvaluations() result:");
      // begin-list_report_evaluations
      ListReportEvaluationsOptions listReportEvaluationsOptions = new ListReportEvaluationsOptions.Builder()
        .reportId(reportIdForReportLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
        .assessmentId("testString")
        .componentId("testString")
        .targetId("testString")
        .targetName("testString")
        .status("failure")
        .limit(Long.valueOf("10"))
        .build();

      ReportEvaluationsPager pager = new ReportEvaluationsPager(securityAndComplianceCenterApiService, listReportEvaluationsOptions);
      List<Evaluation> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<Evaluation> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_report_evaluations
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listReportResources() result:");
      // begin-list_report_resources
      ListReportResourcesOptions listReportResourcesOptions = new ListReportResourcesOptions.Builder()
        .reportId(reportIdForReportLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
        .id("testString")
        .resourceName("testString")
        .accountId(accountIdForReportLink)
        .componentId("testString")
        .status("compliant")
        .sort("account_id")
        .limit(Long.valueOf("10"))
        .build();

      ReportResourcesPager pager = new ReportResourcesPager(securityAndComplianceCenterApiService, listReportResourcesOptions);
      List<Resource> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<Resource> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_report_resources
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getReportTags() result:");
      // begin-get_report_tags
      GetReportTagsOptions getReportTagsOptions = new GetReportTagsOptions.Builder()
        .reportId(reportIdForReportLink)
        .build();

      Response<ReportTags> response = securityAndComplianceCenterApiService.getReportTags(getReportTagsOptions).execute();
      ReportTags reportTags = response.getResult();

      System.out.println(reportTags);
      // end-get_report_tags
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getReportViolationsDrift() result:");
      // begin-get_report_violations_drift
      GetReportViolationsDriftOptions getReportViolationsDriftOptions = new GetReportViolationsDriftOptions.Builder()
        .reportId(reportIdForReportLink)
        .build();

      Response<ReportViolationsDrift> response = securityAndComplianceCenterApiService.getReportViolationsDrift(getReportViolationsDriftOptions).execute();
      ReportViolationsDrift reportViolationsDrift = response.getResult();

      System.out.println(reportViolationsDrift);
      // end-get_report_violations_drift
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listProviderTypes() result:");
      // begin-list_provider_types
      ListProviderTypesOptions listProviderTypesOptions = new ListProviderTypesOptions.Builder()
        .build();

      Response<ProviderTypesCollection> response = securityAndComplianceCenterApiService.listProviderTypes(listProviderTypesOptions).execute();
      ProviderTypesCollection providerTypesCollection = response.getResult();

      System.out.println(providerTypesCollection);
      // end-list_provider_types

      providerTypeIdLink = providerTypesCollection.getProviderTypes().get(0).getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getProviderTypeById() result:");
      // begin-get_provider_type_by_id
      GetProviderTypeByIdOptions getProviderTypeByIdOptions = new GetProviderTypeByIdOptions.Builder()
        .providerTypeId(providerTypeIdLink)
        .build();

      Response<ProviderTypeItem> response = securityAndComplianceCenterApiService.getProviderTypeById(getProviderTypeByIdOptions).execute();
      ProviderTypeItem providerTypeItem = response.getResult();

      System.out.println(providerTypeItem);
      // end-get_provider_type_by_id
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listProviderTypeInstances() result:");
      // begin-list_provider_type_instances
      ListProviderTypeInstancesOptions listProviderTypeInstancesOptions = new ListProviderTypeInstancesOptions.Builder()
        .providerTypeId(providerTypeIdLink)
        .build();

      Response<ProviderTypeInstancesResponse> response = securityAndComplianceCenterApiService.listProviderTypeInstances(listProviderTypeInstancesOptions).execute();
      ProviderTypeInstancesResponse providerTypeInstancesResponse = response.getResult();

      System.out.println(providerTypeInstancesResponse);
      // end-list_provider_type_instances
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createProviderTypeInstance() result:");
      // begin-create_provider_type_instance
      CreateProviderTypeInstanceOptions createProviderTypeInstanceOptions = new CreateProviderTypeInstanceOptions.Builder()
        .providerTypeId(providerTypeIdLink)
        .build();

      Response<ProviderTypeInstanceItem> response = securityAndComplianceCenterApiService.createProviderTypeInstance(createProviderTypeInstanceOptions).execute();
      ProviderTypeInstanceItem providerTypeInstanceItem = response.getResult();

      System.out.println(providerTypeInstanceItem);
      // end-create_provider_type_instance

      providerTypeInstanceIdLink = providerTypeInstanceItem.getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getProviderTypeInstance() result:");
      // begin-get_provider_type_instance
      GetProviderTypeInstanceOptions getProviderTypeInstanceOptions = new GetProviderTypeInstanceOptions.Builder()
        .providerTypeId(providerTypeIdLink)
        .providerTypeInstanceId(providerTypeInstanceIdLink)
        .build();

      Response<ProviderTypeInstanceItem> response = securityAndComplianceCenterApiService.getProviderTypeInstance(getProviderTypeInstanceOptions).execute();
      ProviderTypeInstanceItem providerTypeInstanceItem = response.getResult();

      System.out.println(providerTypeInstanceItem);
      // end-get_provider_type_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateProviderTypeInstance() result:");
      // begin-update_provider_type_instance
      UpdateProviderTypeInstanceOptions updateProviderTypeInstanceOptions = new UpdateProviderTypeInstanceOptions.Builder()
        .providerTypeId(providerTypeIdLink)
        .providerTypeInstanceId(providerTypeInstanceIdLink)
        .build();

      Response<ProviderTypeInstanceItem> response = securityAndComplianceCenterApiService.updateProviderTypeInstance(updateProviderTypeInstanceOptions).execute();
      ProviderTypeInstanceItem providerTypeInstanceItem = response.getResult();

      System.out.println(providerTypeInstanceItem);
      // end-update_provider_type_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getProviderTypesInstances() result:");
      // begin-get_provider_types_instances
      GetProviderTypesInstancesOptions getProviderTypesInstancesOptions = new GetProviderTypesInstancesOptions.Builder()
        .build();

      Response<ProviderTypesInstancesResponse> response = securityAndComplianceCenterApiService.getProviderTypesInstances(getProviderTypesInstancesOptions).execute();
      ProviderTypesInstancesResponse providerTypesInstancesResponse = response.getResult();

      System.out.println(providerTypesInstancesResponse);
      // end-get_provider_types_instances
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("deleteCustomProfile() result:");
      // begin-delete_custom_profile
      DeleteCustomProfileOptions deleteCustomProfileOptions = new DeleteCustomProfileOptions.Builder()
        .profilesId(profileIdLink)
        .build();

      Response<Profile> response = securityAndComplianceCenterApiService.deleteCustomProfile(deleteCustomProfileOptions).execute();
      Profile profile = response.getResult();

      System.out.println(profile);
      // end-delete_custom_profile
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("deleteCustomControlLibrary() result:");
      // begin-delete_custom_control_library
      DeleteCustomControlLibraryOptions deleteCustomControlLibraryOptions = new DeleteCustomControlLibraryOptions.Builder()
        .controlLibrariesId(controlLibraryIdLink)
        .build();

      Response<ControlLibraryDelete> response = securityAndComplianceCenterApiService.deleteCustomControlLibrary(deleteCustomControlLibraryOptions).execute();
      ControlLibraryDelete controlLibraryDelete = response.getResult();

      System.out.println(controlLibraryDelete);
      // end-delete_custom_control_library
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_rule
      DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
        .ruleId(ruleIdLink)
        .build();

      Response<Void> response = securityAndComplianceCenterApiService.deleteRule(deleteRuleOptions).execute();
      // end-delete_rule
      System.out.printf("deleteRule() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("deleteProfileAttachment() result:");
      // begin-delete_profile_attachment
      DeleteProfileAttachmentOptions deleteProfileAttachmentOptions = new DeleteProfileAttachmentOptions.Builder()
        .attachmentId(attachmentIdLink)
        .profilesId(profileIdLink)
        .build();

      Response<AttachmentItem> response = securityAndComplianceCenterApiService.deleteProfileAttachment(deleteProfileAttachmentOptions).execute();
      AttachmentItem attachmentItem = response.getResult();

      System.out.println(attachmentItem);
      // end-delete_profile_attachment
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_provider_type_instance
      DeleteProviderTypeInstanceOptions deleteProviderTypeInstanceOptions = new DeleteProviderTypeInstanceOptions.Builder()
        .providerTypeId(providerTypeIdLink)
        .providerTypeInstanceId(providerTypeInstanceIdLink)
        .build();

      Response<Void> response = securityAndComplianceCenterApiService.deleteProviderTypeInstance(deleteProviderTypeInstanceOptions).execute();
      // end-delete_provider_type_instance
      System.out.printf("deleteProviderTypeInstance() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  }
}
