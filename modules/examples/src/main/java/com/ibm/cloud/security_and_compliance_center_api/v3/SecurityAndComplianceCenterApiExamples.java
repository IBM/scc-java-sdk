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

package com.ibm.cloud.security_and_compliance_center_api.v3;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AdditionalTargetAttribute;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Assessment;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AssessmentPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentNotifications;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentNotificationsControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ComparePredefinedProfilesResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CompareProfilesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ConditionItemConditionBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlDoc;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibrariesPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibrary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSpecification;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSpecificationPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateProfileAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateScanOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateScanReport;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateScanReportOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateScanResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateScopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateSubscopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateTargetOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DefaultParameters;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteCustomControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteCustomProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteProfileAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteScopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteSubscopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteTargetOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Evaluation;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EventNotificationsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetLatestReportsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProfileAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProviderTypeByIdOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportControlsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportDownloadFileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportSummaryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportTagsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportViolationsDriftOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetScanReportDownloadFileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetScanReportOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetScopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetServiceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetSettingsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetSubscopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetTargetOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Import;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.InstanceAttachmentsPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListControlLibrariesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListInstanceAttachmentsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListProfileAttachmentsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListProfileParametersOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListProfilesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListProviderTypeInstancesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListProviderTypesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListReportEvaluationsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListReportResourcesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListReportsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListRulesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListScanReportsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListScopesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListServicesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListSubscopesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListTargetsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.MultiCloudScopePayloadById;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ObjectStoragePrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Parameter;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PostTestEventOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Profile;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileAttachment;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileAttachmentBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileAttachmentCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileAttachmentResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileControlsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileDefaultParametersResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfilesPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderType;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderTypeCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderTypeInstance;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderTypeInstanceCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceCustomControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceProfileAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceProfileParametersOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceTargetOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Report;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportEvaluationsPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportLatest;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportResourcesPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportSummary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportTags;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportViolationsDrift;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportsPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigConditionListConditionListConditionAnd;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Resource;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Rule;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RuleInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RuleParameter;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RuleTargetPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RulesPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScanReport;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScanReportCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Scope;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopePropertyScopeAny;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopePrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopesPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Service;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ServiceCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Settings;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.SubScope;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.SubScopeResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.SubscopesPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Target;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.TargetCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.TestEvent;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateScopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateSettingsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateSubscopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpgradeAttachmentOptions;
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
    String providerTypeInstanceIdLink = null;
    String reportIdForReportLink = null;
    String ruleIdLink = null;
    String scanIdForScanReportLink = null;
    String scopeIdLink = null;
    String subScopeIdLink = null;
    String targetIdLink = null;
    String typeForReportLink = null;

    try {
      System.out.println("getSettings() result:");
      // begin-get_settings
      GetSettingsOptions getSettingsOptions = new GetSettingsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .build();

      Response<Settings> response = securityAndComplianceCenterApiService.getSettings(getSettingsOptions).execute();
      Settings settings = response.getResult();

      System.out.println(settings);
      // end-get_settings

      eventNotificationsCrnForUpdateSettingsLink = settings.getEventNotifications().getInstanceCrn();
      objectStorageCrnForUpdateSettingsLink = settings.getObjectStorage().getInstanceCrn();
      objectStorageBucketForUpdateSettingsLink = settings.getObjectStorage().getBucket();
      objectStorageLocationForUpdateSettingsLink = settings.getObjectStorage().getBucketLocation();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateSettings() result:");
      // begin-update_settings
      ObjectStoragePrototype objectStoragePrototypeModel = new ObjectStoragePrototype.Builder()
        .bucket("px-scan-results")
        .instanceCrn("crn:v1:staging:public:cloud-object-storage:global:a/ff88f007f9ff4622aac4fbc0eda36255:7199ae60-a214-4dd8-9bf7-ce571de49d01::")
        .build();
      EventNotificationsPrototype eventNotificationsPrototypeModel = new EventNotificationsPrototype.Builder()
        .instanceCrn("crn:v1:staging:public:event-notifications:us-south:a/ff88f007f9ff4622aac4fbc0eda36255:b8b07245-0bbe-4478-b11c-0dce523105fd::")
        .sourceDescription("This source is used for integration with IBM Cloud Security and Compliance Center.")
        .sourceName("scc-sdk-integration")
        .build();
      UpdateSettingsOptions updateSettingsOptions = new UpdateSettingsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .objectStorage(objectStoragePrototypeModel)
        .eventNotifications(eventNotificationsPrototypeModel)
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
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
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
      System.out.println("listInstanceAttachments() result:");
      // begin-list_instance_attachments
      ListInstanceAttachmentsOptions listInstanceAttachmentsOptions = new ListInstanceAttachmentsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .accountId(accountIdForReportLink)
        .versionGroupLabel("6702d85a-6437-4d6f-8701-c0146648787b")
        .limit(Long.valueOf("10"))
        .sort("created_on")
        .direction("desc")
        .build();

      InstanceAttachmentsPager pager = new InstanceAttachmentsPager(securityAndComplianceCenterApiService, listInstanceAttachmentsOptions);
      List<ProfileAttachment> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<ProfileAttachment> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_instance_attachments
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createProfileAttachment() result:");
      // begin-create_profile_attachment
      Parameter parameterModel = new Parameter.Builder()
        .assessmentType("automated")
        .assessmentId("rule-e16fcfea-fe21-4d30-a721-423611481fea")
        .parameterName("tls_version")
        .parameterDisplayName("IBM Cloud Internet Services TLS version")
        .parameterType("string_list")
        .parameterValue("[\"1.2\", \"1.3\"]")
        .build();
      AttachmentNotificationsControls attachmentNotificationsControlsModel = new AttachmentNotificationsControls.Builder()
        .thresholdLimit(Long.valueOf("15"))
        .failedControlIds(java.util.Arrays.asList())
        .build();
      AttachmentNotifications attachmentNotificationsModel = new AttachmentNotifications.Builder()
        .enabled(true)
        .controls(attachmentNotificationsControlsModel)
        .build();
      MultiCloudScopePayloadById multiCloudScopePayloadModel = new MultiCloudScopePayloadById.Builder()
        .id("8baad3b5-2e69-4027-9967-efac19508e1c")
        .build();
      ProfileAttachmentBase profileAttachmentBaseModel = new ProfileAttachmentBase.Builder()
        .attachmentParameters(java.util.Arrays.asList(parameterModel))
        .description("This is a profile attachment targeting IBM CIS Foundation using a SDK")
        .name("Profile Attachment for IBM CIS Foundation SDK test")
        .notifications(attachmentNotificationsModel)
        .schedule("daily")
        .scope(java.util.Arrays.asList(multiCloudScopePayloadModel))
        .status("disabled")
        .build();
      CreateProfileAttachmentOptions createProfileAttachmentOptions = new CreateProfileAttachmentOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
        .newAttachments(java.util.Arrays.asList(profileAttachmentBaseModel))
        .newProfileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3")
        .build();

      Response<ProfileAttachmentResponse> response = securityAndComplianceCenterApiService.createProfileAttachment(createProfileAttachmentOptions).execute();
      ProfileAttachmentResponse profileAttachmentResponse = response.getResult();

      System.out.println(profileAttachmentResponse);
      // end-create_profile_attachment

      attachmentIdLink = profileAttachmentResponse.getAttachments().get(0).getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getProfileAttachment() result:");
      // begin-get_profile_attachment
      GetProfileAttachmentOptions getProfileAttachmentOptions = new GetProfileAttachmentOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
        .attachmentId(attachmentIdLink)
        .build();

      Response<ProfileAttachment> response = securityAndComplianceCenterApiService.getProfileAttachment(getProfileAttachmentOptions).execute();
      ProfileAttachment profileAttachment = response.getResult();

      System.out.println(profileAttachment);
      // end-get_profile_attachment
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("replaceProfileAttachment() result:");
      // begin-replace_profile_attachment
      Parameter parameterModel = new Parameter.Builder()
        .build();
      AttachmentNotifications attachmentNotificationsModel = new AttachmentNotifications.Builder()
        .build();
      MultiCloudScopePayloadById multiCloudScopePayloadModel = new MultiCloudScopePayloadById.Builder()
        .build();
      ReplaceProfileAttachmentOptions replaceProfileAttachmentOptions = new ReplaceProfileAttachmentOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
        .attachmentId(attachmentIdLink)
        .attachmentParameters(java.util.Arrays.asList(parameterModel))
        .description("testString")
        .name("testString")
        .notifications(attachmentNotificationsModel)
        .schedule("daily")
        .scope(java.util.Arrays.asList(multiCloudScopePayloadModel))
        .status("enabled")
        .build();

      Response<ProfileAttachment> response = securityAndComplianceCenterApiService.replaceProfileAttachment(replaceProfileAttachmentOptions).execute();
      ProfileAttachment profileAttachment = response.getResult();

      System.out.println(profileAttachment);
      // end-replace_profile_attachment
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("upgradeAttachment() result:");
      // begin-upgrade_attachment
      Parameter parameterModel = new Parameter.Builder()
        .build();
      UpgradeAttachmentOptions upgradeAttachmentOptions = new UpgradeAttachmentOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
        .attachmentId(attachmentIdLink)
        .attachmentParameters(java.util.Arrays.asList(parameterModel))
        .build();

      Response<ProfileAttachment> response = securityAndComplianceCenterApiService.upgradeAttachment(upgradeAttachmentOptions).execute();
      ProfileAttachment profileAttachment = response.getResult();

      System.out.println(profileAttachment);
      // end-upgrade_attachment
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createScan() result:");
      // begin-create_scan
      CreateScanOptions createScanOptions = new CreateScanOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .attachmentId("4deb572c-9f37-4126-9cc0-d550672533cb")
        .build();

      Response<CreateScanResponse> response = securityAndComplianceCenterApiService.createScan(createScanOptions).execute();
      CreateScanResponse createScanResponse = response.getResult();

      System.out.println(createScanResponse);
      // end-create_scan
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createControlLibrary() result:");
      // begin-create_control_library
      AssessmentPrototype assessmentPrototypeModel = new AssessmentPrototype.Builder()
        .assessmentId("rule-d1bd9f3f-bee1-46c5-9533-da8bba9eed4e")
        .assessmentDescription("This rule will check on regulation")
        .build();
      ControlSpecificationPrototype controlSpecificationPrototypeModel = new ControlSpecificationPrototype.Builder()
        .componentId("apprapp")
        .environment("ibm-cloud")
        .controlSpecificationDescription("This field is used to describe a control specification")
        .assessments(java.util.Arrays.asList(assessmentPrototypeModel))
        .build();
      ControlDoc controlDocModel = new ControlDoc.Builder()
        .build();
      ControlPrototype controlPrototypeModel = new ControlPrototype.Builder()
        .controlName("security")
        .controlDescription("This is a description of a control")
        .controlCategory("test-control")
        .controlRequirement(true)
        .controlSpecifications(java.util.Arrays.asList(controlSpecificationPrototypeModel))
        .controlDocs(controlDocModel)
        .status("disabled")
        .build();
      CreateControlLibraryOptions createControlLibraryOptions = new CreateControlLibraryOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .controlLibraryName("custom control library from SDK")
        .controlLibraryDescription("This is a custom control library made from the SDK test framework")
        .controlLibraryType("custom")
        .controlLibraryVersion("0.0.1")
        .controls(java.util.Arrays.asList(controlPrototypeModel))
        .build();

      Response<ControlLibrary> response = securityAndComplianceCenterApiService.createControlLibrary(createControlLibraryOptions).execute();
      ControlLibrary controlLibrary = response.getResult();

      System.out.println(controlLibrary);
      // end-create_control_library

      controlLibraryIdLink = controlLibrary.getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listControlLibraries() result:");
      // begin-list_control_libraries
      ListControlLibrariesOptions listControlLibrariesOptions = new ListControlLibrariesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .accountId(accountIdForReportLink)
        .limit(Long.valueOf("10"))
        .build();

      ControlLibrariesPager pager = new ControlLibrariesPager(securityAndComplianceCenterApiService, listControlLibrariesOptions);
      List<ControlLibrary> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<ControlLibrary> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_control_libraries
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("replaceCustomControlLibrary() result:");
      // begin-replace_custom_control_library
      AssessmentPrototype assessmentPrototypeModel = new AssessmentPrototype.Builder()
        .assessmentId("rule-d1bd9f3f-bee1-46c5-9533-da8bba9eed4e")
        .assessmentDescription("This rule will check on regulation")
        .build();
      ControlSpecificationPrototype controlSpecificationPrototypeModel = new ControlSpecificationPrototype.Builder()
        .componentId("apprapp")
        .environment("ibm-cloud")
        .controlSpecificationDescription("This field is used to describe a control specification")
        .assessments(java.util.Arrays.asList(assessmentPrototypeModel))
        .build();
      ControlDoc controlDocModel = new ControlDoc.Builder()
        .build();
      ControlPrototype controlPrototypeModel = new ControlPrototype.Builder()
        .controlName("security")
        .controlDescription("This is a description of a control")
        .controlCategory("test-control")
        .controlRequirement(true)
        .controlSpecifications(java.util.Arrays.asList(controlSpecificationPrototypeModel))
        .controlDocs(controlDocModel)
        .status("disabled")
        .build();
      ReplaceCustomControlLibraryOptions replaceCustomControlLibraryOptions = new ReplaceCustomControlLibraryOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .controlLibraryId(controlLibraryIdLink)
        .controlLibraryName("custom control library from SDK")
        .controlLibraryDescription("This is a custom control library made from the SDK test framework")
        .controlLibraryType("custom")
        .controlLibraryVersion("0.0.2")
        .controls(java.util.Arrays.asList(controlPrototypeModel))
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
      System.out.println("getControlLibrary() result:");
      // begin-get_control_library
      GetControlLibraryOptions getControlLibraryOptions = new GetControlLibraryOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .controlLibraryId(controlLibraryIdLink)
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
      System.out.println("createProfile() result:");
      // begin-create_profile
      ProfileControlsPrototype profileControlsPrototypeModel = new ProfileControlsPrototype.Builder()
        .controlLibraryId("a046fb6b-aba5-4646-b190-a2c76241e7af")
        .controlId("60dae3b5-6104-4b3e-bac7-26cc7b741aca")
        .build();
      DefaultParameters defaultParametersModel = new DefaultParameters.Builder()
        .assessmentType("automated")
        .assessmentId("rule-e16fcfea-fe21-4d30-a721-423611481fea")
        .parameterName("tls_version")
        .parameterDefaultValue("[\"1.2\",\"1.3\"]")
        .parameterDisplayName("IBM Cloud Internet Services TLS version")
        .parameterType("string_list")
        .build();
      CreateProfileOptions createProfileOptions = new CreateProfileOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileName("Example Profile")
        .profileVersion("0.0.1")
        .controls(java.util.Arrays.asList(profileControlsPrototypeModel))
        .defaultParameters(java.util.Arrays.asList(defaultParametersModel))
        .profileDescription("This profile is created as an example of the SDK gen")
        .latest(true)
        .build();

      Response<Profile> response = securityAndComplianceCenterApiService.createProfile(createProfileOptions).execute();
      Profile profile = response.getResult();

      System.out.println(profile);
      // end-create_profile

      profileIdLink = profile.id();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listProfiles() result:");
      // begin-list_profiles
      ListProfilesOptions listProfilesOptions = new ListProfilesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .accountId(accountIdForReportLink)
        .limit(Long.valueOf("10"))
        .build();

      ProfilesPager pager = new ProfilesPager(securityAndComplianceCenterApiService, listProfilesOptions);
      List<Profile> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<Profile> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_profiles
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("replaceProfile() result:");
      // begin-replace_profile
      Parameter parameterModel = new Parameter.Builder()
        .build();
      Assessment assessmentModel = new Assessment.Builder()
        .parameters(java.util.Arrays.asList(parameterModel))
        .build();
      ControlSpecification controlSpecificationModel = new ControlSpecification.Builder()
        .assessments(java.util.Arrays.asList(assessmentModel))
        .build();
      ProfileControls profileControlsModel = new ProfileControls.Builder()
        .controlLibraryId("a046fb6b-aba5-4646-b190-a2c76241e7af")
        .controlId("60dae3b5-6104-4b3e-bac7-26cc7b741aca")
        .controlSpecifications(java.util.Arrays.asList(controlSpecificationModel))
        .build();
      DefaultParameters defaultParametersModel = new DefaultParameters.Builder()
        .assessmentType("automated")
        .assessmentId("rule-e16fcfea-fe21-4d30-a721-423611481fea")
        .parameterName("tls_version")
        .parameterDefaultValue("[\"1.2\",\"1.3\"]")
        .parameterDisplayName("IBM Cloud Internet Services TLS version")
        .parameterType("string_list")
        .build();
      ReplaceProfileOptions replaceProfileOptions = new ReplaceProfileOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId(profileIdLink)
        .newProfileType("custom")
        .newControls(java.util.Arrays.asList(profileControlsModel))
        .newDefaultParameters(java.util.Arrays.asList(defaultParametersModel))
        .newProfileName("Example Profile Updated")
        .newProfileDescription("This profile has been updated")
        .newProfileVersion("0.0.2")
        .newLatest(true)
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
      System.out.println("getProfile() result:");
      // begin-get_profile
      GetProfileOptions getProfileOptions = new GetProfileOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId(profileIdLink)
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
      System.out.println("replaceProfileParameters() result:");
      // begin-replace_profile_parameters
      DefaultParameters defaultParametersModel = new DefaultParameters.Builder()
        .build();
      ReplaceProfileParametersOptions replaceProfileParametersOptions = new ReplaceProfileParametersOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId(profileIdLink)
        .defaultParameters(java.util.Arrays.asList(defaultParametersModel))
        .build();

      Response<ProfileDefaultParametersResponse> response = securityAndComplianceCenterApiService.replaceProfileParameters(replaceProfileParametersOptions).execute();
      ProfileDefaultParametersResponse profileDefaultParametersResponse = response.getResult();

      System.out.println(profileDefaultParametersResponse);
      // end-replace_profile_parameters
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listProfileParameters() result:");
      // begin-list_profile_parameters
      ListProfileParametersOptions listProfileParametersOptions = new ListProfileParametersOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId(profileIdLink)
        .build();

      Response<ProfileDefaultParametersResponse> response = securityAndComplianceCenterApiService.listProfileParameters(listProfileParametersOptions).execute();
      ProfileDefaultParametersResponse profileDefaultParametersResponse = response.getResult();

      System.out.println(profileDefaultParametersResponse);
      // end-list_profile_parameters
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("compareProfiles() result:");
      // begin-compare_profiles
      CompareProfilesOptions compareProfilesOptions = new CompareProfilesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId("2f598907-970d-4d52-9071-5cc95912f55e")
        .build();

      Response<ComparePredefinedProfilesResponse> response = securityAndComplianceCenterApiService.compareProfiles(compareProfilesOptions).execute();
      ComparePredefinedProfilesResponse comparePredefinedProfilesResponse = response.getResult();

      System.out.println(comparePredefinedProfilesResponse);
      // end-compare_profiles
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listProfileAttachments() result:");
      // begin-list_profile_attachments
      ListProfileAttachmentsOptions listProfileAttachmentsOptions = new ListProfileAttachmentsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
        .build();

      Response<ProfileAttachmentCollection> response = securityAndComplianceCenterApiService.listProfileAttachments(listProfileAttachmentsOptions).execute();
      ProfileAttachmentCollection profileAttachmentCollection = response.getResult();

      System.out.println(profileAttachmentCollection);
      // end-list_profile_attachments
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createScope() result:");
      // begin-create_scope
      ScopePropertyScopeAny scopePropertyModel = new ScopePropertyScopeAny.Builder()
        .name("scope_id")
        .value("ff88f007f9ff4622aac4fbc0eda36255")
        .build();
      CreateScopeOptions createScopeOptions = new CreateScopeOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .name("ibm scope")
        .description("The scope that is defined for IBM resources.")
        .environment("ibm-cloud")
        .xProperties(java.util.Arrays.asList(scopePropertyModel))
        .build();

      Response<Scope> response = securityAndComplianceCenterApiService.createScope(createScopeOptions).execute();
      Scope scope = response.getResult();

      System.out.println(scope);
      // end-create_scope

      scopeIdLink = scope.getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listScopes() result:");
      // begin-list_scopes
      ListScopesOptions listScopesOptions = new ListScopesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .limit(Long.valueOf("10"))
        .name("testString")
        .description("testString")
        .environment("testString")
        .build();

      ScopesPager pager = new ScopesPager(securityAndComplianceCenterApiService, listScopesOptions);
      List<Scope> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<Scope> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_scopes
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateScope() result:");
      // begin-update_scope
      UpdateScopeOptions updateScopeOptions = new UpdateScopeOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .scopeId(scopeIdLink)
        .name("updated name of scope")
        .description("updated scope description")
        .build();

      Response<Scope> response = securityAndComplianceCenterApiService.updateScope(updateScopeOptions).execute();
      Scope scope = response.getResult();

      System.out.println(scope);
      // end-update_scope
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getScope() result:");
      // begin-get_scope
      GetScopeOptions getScopeOptions = new GetScopeOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .scopeId(scopeIdLink)
        .build();

      Response<Scope> response = securityAndComplianceCenterApiService.getScope(getScopeOptions).execute();
      Scope scope = response.getResult();

      System.out.println(scope);
      // end-get_scope
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createSubscope() result:");
      // begin-create_subscope
      ScopePropertyScopeAny scopePropertyModel = new ScopePropertyScopeAny.Builder()
        .name("scope_id")
        .value("1f689f08ec9b47b885c2659c17029581")
        .build();
      ScopePrototype scopePrototypeModel = new ScopePrototype.Builder()
        .name("ibm subscope update")
        .description("The subscope that is defined for IBM resources.")
        .environment("ibm-cloud")
        .xProperties(java.util.Arrays.asList(scopePropertyModel))
        .build();
      CreateSubscopeOptions createSubscopeOptions = new CreateSubscopeOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .scopeId(scopeIdLink)
        .subscopes(java.util.Arrays.asList(scopePrototypeModel))
        .build();

      Response<SubScopeResponse> response = securityAndComplianceCenterApiService.createSubscope(createSubscopeOptions).execute();
      SubScopeResponse subScopeResponse = response.getResult();

      System.out.println(subScopeResponse);
      // end-create_subscope

      subScopeIdLink = subScopeResponse.getSubscopes().get(0).getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listSubscopes() result:");
      // begin-list_subscopes
      ListSubscopesOptions listSubscopesOptions = new ListSubscopesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .scopeId(scopeIdLink)
        .limit(Long.valueOf("10"))
        .name("testString")
        .description("testString")
        .environment("testString")
        .build();

      SubscopesPager pager = new SubscopesPager(securityAndComplianceCenterApiService, listSubscopesOptions);
      List<SubScope> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<SubScope> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_subscopes
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getSubscope() result:");
      // begin-get_subscope
      GetSubscopeOptions getSubscopeOptions = new GetSubscopeOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .scopeId(scopeIdLink)
        .subscopeId(subScopeIdLink)
        .build();

      Response<SubScope> response = securityAndComplianceCenterApiService.getSubscope(getSubscopeOptions).execute();
      SubScope subScope = response.getResult();

      System.out.println(subScope);
      // end-get_subscope
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateSubscope() result:");
      // begin-update_subscope
      UpdateSubscopeOptions updateSubscopeOptions = new UpdateSubscopeOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .scopeId(scopeIdLink)
        .subscopeId(subScopeIdLink)
        .name("updated name of scope")
        .description("updated scope description")
        .build();

      Response<SubScope> response = securityAndComplianceCenterApiService.updateSubscope(updateSubscopeOptions).execute();
      SubScope subScope = response.getResult();

      System.out.println(subScope);
      // end-update_subscope
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createTarget() result:");
      // begin-create_target
      CreateTargetOptions createTargetOptions = new CreateTargetOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .accountId("62ecf99b240144dea9125666249edfcb")
        .trustedProfileId("Profile-cb2c1829-9a8d-4218-b9cd-9f83fc814e54")
        .name("Target for IBM account")
        .build();

      Response<Target> response = securityAndComplianceCenterApiService.createTarget(createTargetOptions).execute();
      Target target = response.getResult();

      System.out.println(target);
      // end-create_target

      targetIdLink = target.getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listTargets() result:");
      // begin-list_targets
      ListTargetsOptions listTargetsOptions = new ListTargetsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .build();

      Response<TargetCollection> response = securityAndComplianceCenterApiService.listTargets(listTargetsOptions).execute();
      TargetCollection targetCollection = response.getResult();

      System.out.println(targetCollection);
      // end-list_targets
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getTarget() result:");
      // begin-get_target
      GetTargetOptions getTargetOptions = new GetTargetOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .targetId(targetIdLink)
        .build();

      Response<Target> response = securityAndComplianceCenterApiService.getTarget(getTargetOptions).execute();
      Target target = response.getResult();

      System.out.println(target);
      // end-get_target
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("replaceTarget() result:");
      // begin-replace_target
      ReplaceTargetOptions replaceTargetOptions = new ReplaceTargetOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .targetId(targetIdLink)
        .accountId("be200c80cabc456e91139e4152327823")
        .trustedProfileId("Profile-a0a4c149-4fed-47ff-bfb2-680bcfaa64d3")
        .name("Sample Target Name")
        .build();

      Response<Target> response = securityAndComplianceCenterApiService.replaceTarget(replaceTargetOptions).execute();
      Target target = response.getResult();

      System.out.println(target);
      // end-replace_target
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createProviderTypeInstance() result:");
      // begin-create_provider_type_instance
      CreateProviderTypeInstanceOptions createProviderTypeInstanceOptions = new CreateProviderTypeInstanceOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
        .build();

      Response<ProviderTypeInstance> response = securityAndComplianceCenterApiService.createProviderTypeInstance(createProviderTypeInstanceOptions).execute();
      ProviderTypeInstance providerTypeInstance = response.getResult();

      System.out.println(providerTypeInstance);
      // end-create_provider_type_instance

      providerTypeInstanceIdLink = providerTypeInstance.getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listProviderTypeInstances() result:");
      // begin-list_provider_type_instances
      ListProviderTypeInstancesOptions listProviderTypeInstancesOptions = new ListProviderTypeInstancesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
        .build();

      Response<ProviderTypeInstanceCollection> response = securityAndComplianceCenterApiService.listProviderTypeInstances(listProviderTypeInstancesOptions).execute();
      ProviderTypeInstanceCollection providerTypeInstanceCollection = response.getResult();

      System.out.println(providerTypeInstanceCollection);
      // end-list_provider_type_instances
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getProviderTypeInstance() result:");
      // begin-get_provider_type_instance
      GetProviderTypeInstanceOptions getProviderTypeInstanceOptions = new GetProviderTypeInstanceOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
        .providerTypeInstanceId(providerTypeInstanceIdLink)
        .build();

      Response<ProviderTypeInstance> response = securityAndComplianceCenterApiService.getProviderTypeInstance(getProviderTypeInstanceOptions).execute();
      ProviderTypeInstance providerTypeInstance = response.getResult();

      System.out.println(providerTypeInstance);
      // end-get_provider_type_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateProviderTypeInstance() result:");
      // begin-update_provider_type_instance
      UpdateProviderTypeInstanceOptions updateProviderTypeInstanceOptions = new UpdateProviderTypeInstanceOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
        .providerTypeInstanceId(providerTypeInstanceIdLink)
        .build();

      Response<ProviderTypeInstance> response = securityAndComplianceCenterApiService.updateProviderTypeInstance(updateProviderTypeInstanceOptions).execute();
      ProviderTypeInstance providerTypeInstance = response.getResult();

      System.out.println(providerTypeInstance);
      // end-update_provider_type_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listProviderTypes() result:");
      // begin-list_provider_types
      ListProviderTypesOptions listProviderTypesOptions = new ListProviderTypesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .build();

      Response<ProviderTypeCollection> response = securityAndComplianceCenterApiService.listProviderTypes(listProviderTypesOptions).execute();
      ProviderTypeCollection providerTypeCollection = response.getResult();

      System.out.println(providerTypeCollection);
      // end-list_provider_types
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getProviderTypeById() result:");
      // begin-get_provider_type_by_id
      GetProviderTypeByIdOptions getProviderTypeByIdOptions = new GetProviderTypeByIdOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
        .build();

      Response<ProviderType> response = securityAndComplianceCenterApiService.getProviderTypeById(getProviderTypeByIdOptions).execute();
      ProviderType providerType = response.getResult();

      System.out.println(providerType);
      // end-get_provider_type_by_id
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getLatestReports() result:");
      // begin-get_latest_reports
      GetLatestReportsOptions getLatestReportsOptions = new GetLatestReportsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .build();

      Response<ReportLatest> response = securityAndComplianceCenterApiService.getLatestReports(getLatestReportsOptions).execute();
      ReportLatest reportLatest = response.getResult();

      System.out.println(reportLatest);
      // end-get_latest_reports

      accountIdForReportLink = reportLatest.getReports().get(0).getAccount().id();
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
      System.out.println("listReports() result:");
      // begin-list_reports
      ListReportsOptions listReportsOptions = new ListReportsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportAttachmentId(attachmentIdForReportLink)
        .groupId(groupIdForReportLink)
        .reportProfileId(profileIdForReportLink)
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
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
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
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
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
      System.out.println("getReportDownloadFile() result:");
      // begin-get_report_download_file
      GetReportDownloadFileOptions getReportDownloadFileOptions = new GetReportDownloadFileOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .build();

      Response<InputStream> response = securityAndComplianceCenterApiService.getReportDownloadFile(getReportDownloadFileOptions).execute();
      try (InputStream inputStream = response.getResult();) {
          inputStream.transferTo(new java.io.FileOutputStream("result.out"));
      }
      // end-get_report_download_file
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getReportControls() result:");
      // begin-get_report_controls
      GetReportControlsOptions getReportControlsOptions = new GetReportControlsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
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
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .ruleId("rule-61fa114a-2bb9-43fd-8068-b873b48bdf79")
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
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .assessmentId("testString")
        .assessmentMethod("testString")
        .componentId("testString")
        .targetId("testString")
        .targetEnv("testString")
        .targetName("testString")
        .status("failure")
        .limit(Long.valueOf("10"))
        .sort("assessment_id")
        .scopeId("testString")
        .subscopeId("testString")
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
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .id("testString")
        .resourceName("testString")
        .accountId(accountIdForReportLink)
        .componentId("testString")
        .status("compliant")
        .sort("account_id")
        .limit(Long.valueOf("10"))
        .scopeId("testString")
        .subscopeId("testString")
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
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
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
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
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
      System.out.println("listScanReports() result:");
      // begin-list_scan_reports
      ListScanReportsOptions listScanReportsOptions = new ListScanReportsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .build();

      Response<ScanReportCollection> response = securityAndComplianceCenterApiService.listScanReports(listScanReportsOptions).execute();
      ScanReportCollection scanReportCollection = response.getResult();

      System.out.println(scanReportCollection);
      // end-list_scan_reports

      scanIdForScanReportLink = scanReportCollection.getScanReports().get(0).getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createScanReport() result:");
      // begin-create_scan_report
      CreateScanReportOptions createScanReportOptions = new CreateScanReportOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .format("csv")
        .scopeId("132009ff-b982-412e-a110-ad8797e10f84")
        .subscopeId("c7ddcbcc-6a43-4ab3-b6a7-b2d8f65cd54a")
        .build();

      Response<CreateScanReport> response = securityAndComplianceCenterApiService.createScanReport(createScanReportOptions).execute();
      CreateScanReport createScanReport = response.getResult();

      System.out.println(createScanReport);
      // end-create_scan_report
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getScanReport() result:");
      // begin-get_scan_report
      GetScanReportOptions getScanReportOptions = new GetScanReportOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .jobId(scanIdForScanReportLink)
        .build();

      Response<ScanReport> response = securityAndComplianceCenterApiService.getScanReport(getScanReportOptions).execute();
      ScanReport scanReport = response.getResult();

      System.out.println(scanReport);
      // end-get_scan_report
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getScanReportDownloadFile() result:");
      // begin-get_scan_report_download_file
      GetScanReportDownloadFileOptions getScanReportDownloadFileOptions = new GetScanReportDownloadFileOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .jobId(scanIdForScanReportLink)
        .build();

      Response<InputStream> response = securityAndComplianceCenterApiService.getScanReportDownloadFile(getScanReportDownloadFileOptions).execute();
      try (InputStream inputStream = response.getResult();) {
          inputStream.transferTo(new java.io.FileOutputStream("result.out"));
      }
      // end-get_scan_report_download_file
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listRules() result:");
      // begin-list_rules
      ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .limit(Long.valueOf("10"))
        .type("system_defined")
        .search("testString")
        .serviceName("testString")
        .sort("updated_on")
        .build();

      RulesPager pager = new RulesPager(securityAndComplianceCenterApiService, listRulesOptions);
      List<Rule> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<Rule> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_rules
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
      RuleTargetPrototype ruleTargetPrototypeModel = new RuleTargetPrototype.Builder()
        .serviceName("cloud-object-storage")
        .resourceKind("bucket")
        .additionalTargetAttributes(java.util.Arrays.asList(additionalTargetAttributeModel))
        .build();
      ConditionItemConditionBase conditionItemModel = new ConditionItemConditionBase.Builder()
        .property("hard_quota")
        .operator("num_equals")
        .value("${hard_quota}")
        .build();
      RequiredConfigConditionListConditionListConditionAnd requiredConfigModel = new RequiredConfigConditionListConditionListConditionAnd.Builder()
        .description("The Cloud Object Storage rule.")
        .and(java.util.Arrays.asList(conditionItemModel))
        .build();
      RuleParameter ruleParameterModel = new RuleParameter.Builder()
        .name("hard_quota")
        .displayName("The Cloud Object Storage bucket quota.")
        .description("The maximum bytes that are allocated to the Cloud Object Storage bucket.")
        .type("numeric")
        .build();
      Import importModel = new Import.Builder()
        .parameters(java.util.Arrays.asList(ruleParameterModel))
        .build();
      CreateRuleOptions createRuleOptions = new CreateRuleOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .description("Example rule")
        .target(ruleTargetPrototypeModel)
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
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
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
      System.out.println("replaceRule() result:");
      // begin-replace_rule
      AdditionalTargetAttribute additionalTargetAttributeModel = new AdditionalTargetAttribute.Builder()
        .name("location")
        .operator("string_equals")
        .value("us-south")
        .build();
      RuleTargetPrototype ruleTargetPrototypeModel = new RuleTargetPrototype.Builder()
        .serviceName("cloud-object-storage")
        .resourceKind("bucket")
        .additionalTargetAttributes(java.util.Arrays.asList(additionalTargetAttributeModel))
        .build();
      ConditionItemConditionBase conditionItemModel = new ConditionItemConditionBase.Builder()
        .property("hard_quota")
        .operator("num_equals")
        .value("${hard_quota}")
        .build();
      RequiredConfigConditionListConditionListConditionAnd requiredConfigModel = new RequiredConfigConditionListConditionListConditionAnd.Builder()
        .description("The Cloud Object Storage rule.")
        .and(java.util.Arrays.asList(conditionItemModel))
        .build();
      RuleParameter ruleParameterModel = new RuleParameter.Builder()
        .name("hard_quota")
        .displayName("The Cloud Object Storage bucket quota.")
        .description("The maximum bytes that are allocated to the Cloud Object Storage bucket.")
        .type("numeric")
        .build();
      Import importModel = new Import.Builder()
        .parameters(java.util.Arrays.asList(ruleParameterModel))
        .build();
      ReplaceRuleOptions replaceRuleOptions = new ReplaceRuleOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .ruleId(ruleIdLink)
        .ifMatch(eTagLink)
        .description("Example rule")
        .target(ruleTargetPrototypeModel)
        .requiredConfig(requiredConfigModel)
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
      System.out.println("listServices() result:");
      // begin-list_services
      ListServicesOptions listServicesOptions = new ListServicesOptions();

      Response<ServiceCollection> response = securityAndComplianceCenterApiService.listServices(listServicesOptions).execute();
      ServiceCollection serviceCollection = response.getResult();

      System.out.println(serviceCollection);
      // end-list_services
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getService() result:");
      // begin-get_service
      GetServiceOptions getServiceOptions = new GetServiceOptions.Builder()
        .servicesName("cloud-object-storage")
        .build();

      Response<Service> response = securityAndComplianceCenterApiService.getService(getServiceOptions).execute();
      Service service = response.getResult();

      System.out.println(service);
      // end-get_service
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("deleteProfileAttachment() result:");
      // begin-delete_profile_attachment
      DeleteProfileAttachmentOptions deleteProfileAttachmentOptions = new DeleteProfileAttachmentOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
        .attachmentId(attachmentIdLink)
        .build();

      Response<ProfileAttachment> response = securityAndComplianceCenterApiService.deleteProfileAttachment(deleteProfileAttachmentOptions).execute();
      ProfileAttachment profileAttachment = response.getResult();

      System.out.println(profileAttachment);
      // end-delete_profile_attachment
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("deleteCustomControlLibrary() result:");
      // begin-delete_custom_control_library
      DeleteCustomControlLibraryOptions deleteCustomControlLibraryOptions = new DeleteCustomControlLibraryOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .controlLibraryId(controlLibraryIdLink)
        .build();

      Response<ControlLibrary> response = securityAndComplianceCenterApiService.deleteCustomControlLibrary(deleteCustomControlLibraryOptions).execute();
      ControlLibrary controlLibrary = response.getResult();

      System.out.println(controlLibrary);
      // end-delete_custom_control_library
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("deleteCustomProfile() result:");
      // begin-delete_custom_profile
      DeleteCustomProfileOptions deleteCustomProfileOptions = new DeleteCustomProfileOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId(profileIdLink)
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
      // begin-delete_subscope
      DeleteSubscopeOptions deleteSubscopeOptions = new DeleteSubscopeOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .scopeId(scopeIdLink)
        .subscopeId(subScopeIdLink)
        .build();

      Response<Void> response = securityAndComplianceCenterApiService.deleteSubscope(deleteSubscopeOptions).execute();
      // end-delete_subscope
      System.out.printf("deleteSubscope() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_scope
      DeleteScopeOptions deleteScopeOptions = new DeleteScopeOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .scopeId(scopeIdLink)
        .build();

      Response<Void> response = securityAndComplianceCenterApiService.deleteScope(deleteScopeOptions).execute();
      // end-delete_scope
      System.out.printf("deleteScope() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_target
      DeleteTargetOptions deleteTargetOptions = new DeleteTargetOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .targetId(targetIdLink)
        .build();

      Response<Void> response = securityAndComplianceCenterApiService.deleteTarget(deleteTargetOptions).execute();
      // end-delete_target
      System.out.printf("deleteTarget() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_provider_type_instance
      DeleteProviderTypeInstanceOptions deleteProviderTypeInstanceOptions = new DeleteProviderTypeInstanceOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
        .providerTypeInstanceId(providerTypeInstanceIdLink)
        .build();

      Response<Void> response = securityAndComplianceCenterApiService.deleteProviderTypeInstance(deleteProviderTypeInstanceOptions).execute();
      // end-delete_provider_type_instance
      System.out.printf("deleteProviderTypeInstance() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_rule
      DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .ruleId(ruleIdLink)
        .build();

      Response<Void> response = securityAndComplianceCenterApiService.deleteRule(deleteRuleOptions).execute();
      // end-delete_rule
      System.out.printf("deleteRule() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  }
}
