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
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.security_and_compliance_center_api.test.SdkIntegrationTestBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Account;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AdditionalDetails;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AdditionalProperty;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AdditionalTargetAttribute;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Assessment;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AssessmentPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AssessmentWithStats;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Attachment;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentNotifications;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentNotificationsControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ComparePredefinedProfilesResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CompareProfileResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CompareProfilesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ComplianceScore;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ComplianceStats;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ComplianceStatsWithNonCompliant;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ConditionItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ConditionItemConditionBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ConditionItemConditionList;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ConditionItemConditionListConditionListConditionAnd;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ConditionItemConditionListConditionListConditionOr;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ConditionItemConditionSubRule;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ConditionItemConditionSubRuleConditionSubRuleConditionAll;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ConditionItemConditionSubRuleConditionSubRuleConditionAllIf;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ConditionItemConditionSubRuleConditionSubRuleConditionAny;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ConditionItemConditionSubRuleConditionSubRuleConditionAnyIf;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ConfigurationInformationPoints;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Control;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlChanges;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlChangesUpdated;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlDoc;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibrariesPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibrary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibraryCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSpecification;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSpecificationPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSpecificationWithStats;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSummary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlWithStats;
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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Credential;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CredentialResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DateRange;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DefaultParameters;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DefaultParametersChanges;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DefaultParametersDifference;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteCustomControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteCustomProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteProfileAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteScopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteSubscopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteTargetOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Endpoint;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EvalStats;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Evaluation;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EvaluationDetails;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EvaluationPage;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EvaluationProperty;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EvaluationProviderInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EventNotifications;
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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.LabelType;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.LastScan;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Link;
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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.MultiCloudScopePayload;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.MultiCloudScopePayloadById;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.MultiCloudScopePayloadByProperties;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ObjectStorage;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ObjectStoragePrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PageHRefFirst;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PageHRefNext;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Parameter;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PostTestEventOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Profile;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileAttachment;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileAttachmentBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileAttachmentCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileAttachmentResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileControlsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileDefaultParametersResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileInfo;
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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportEvaluationsPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportLatest;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportResourcesPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportScope;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportSummary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportTags;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportViolationDataPoint;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportViolationsDrift;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportsPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfig;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigConditionBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigConditionList;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigConditionListConditionListConditionAnd;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigConditionListConditionListConditionOr;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigConditionSubRule;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigConditionSubRuleConditionSubRuleConditionAll;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigConditionSubRuleConditionSubRuleConditionAllIf;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigConditionSubRuleConditionSubRuleConditionAny;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigConditionSubRuleConditionSubRuleConditionAnyIf;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Resource;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ResourcePage;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ResourceSummary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ResourceSummaryItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Rule;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RuleCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RuleInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RuleParameter;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RuleProperty;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RuleTarget;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RuleTargetPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RulesPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScanReport;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScanReportCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Scope;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopeCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopeID;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopeProperty;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopePropertyExclusionItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopePropertyExclusions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopePropertyScopeAny;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopePropertyScopeId;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopePropertyScopeType;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopePrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopesPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Service;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ServiceCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Settings;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.SubRule;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.SubScope;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.SubScopeCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.SubScopeResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.SubscopesPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.SupportedConfigs;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Tags;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Target;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.TargetCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.TargetInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.TestEvent;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateScopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateSettingsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateSubscopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpgradeAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the SecurityAndComplianceCenterApi service.
 */
public class SecurityAndComplianceCenterApiIT extends SdkIntegrationTestBase {
  public SecurityAndComplianceCenterApi service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

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

  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../security_and_compliance_center_api_v3.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = SecurityAndComplianceCenterApi.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(SecurityAndComplianceCenterApi.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    service.enableRetries(4, 30);

    System.out.println("Setup complete.");
  }

  @Test
  public void testGetSettings() throws Exception {
    try {
      GetSettingsOptions getSettingsOptions = new GetSettingsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .build();

      // Invoke operation
      Response<Settings> response = service.getSettings(getSettingsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Settings settingsResult = response.getResult();
      assertNotNull(settingsResult);

      eventNotificationsCrnForUpdateSettingsLink = settingsResult.getEventNotifications().getInstanceCrn();
      objectStorageCrnForUpdateSettingsLink = settingsResult.getObjectStorage().getInstanceCrn();
      objectStorageBucketForUpdateSettingsLink = settingsResult.getObjectStorage().getBucket();
      objectStorageLocationForUpdateSettingsLink = settingsResult.getObjectStorage().getBucketLocation();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetSettings" })
  public void testUpdateSettings() throws Exception {
    try {
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

      // Invoke operation
      Response<Settings> response = service.updateSettings(updateSettingsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertTrue(response.getStatusCode() == 200 || response.getStatusCode() == 204);

      Settings settingsResult = response.getResult();
      if (response.getStatusCode() == 200) {
        assertNotNull(settingsResult);
      } else if (response.getStatusCode() == 204) {
        assertNull(settingsResult);
      }

    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s",
        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testUpdateSettings" })
  public void testPostTestEvent() throws Exception {
    try {
      PostTestEventOptions postTestEventOptions = new PostTestEventOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .build();

      // Invoke operation
      Response<TestEvent> response = service.postTestEvent(postTestEventOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);

      TestEvent testEventResult = response.getResult();
      assertNotNull(testEventResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testPostTestEvent" })
  public void testListInstanceAttachments() throws Exception {
    try {
      ListInstanceAttachmentsOptions listInstanceAttachmentsOptions = new ListInstanceAttachmentsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .accountId(accountIdForReportLink)
        .versionGroupLabel("6702d85a-6437-4d6f-8701-c0146648787b")
        .limit(Long.valueOf("10"))
        .sort("created_on")
        .direction("desc")
        .start("testString")
        .build();

      // Invoke operation
      Response<ProfileAttachmentCollection> response = service.listInstanceAttachments(listInstanceAttachmentsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProfileAttachmentCollection profileAttachmentCollectionResult = response.getResult();
      assertNotNull(profileAttachmentCollectionResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListInstanceAttachments" })
  public void testListInstanceAttachmentsWithPager() throws Exception {
    try {
      ListInstanceAttachmentsOptions options = new ListInstanceAttachmentsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .accountId(accountIdForReportLink)
        .versionGroupLabel("6702d85a-6437-4d6f-8701-c0146648787b")
        .limit(Long.valueOf("10"))
        .sort("created_on")
        .direction("desc")
        .build();

      // Test getNext().
      List<ProfileAttachment> allResults = new ArrayList<>();
      InstanceAttachmentsPager pager = new InstanceAttachmentsPager(service, options);
      while (pager.hasNext()) {
        List<ProfileAttachment> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new InstanceAttachmentsPager(service, options);
      List<ProfileAttachment> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListInstanceAttachments" })
  public void testCreateProfileAttachment() throws Exception {
    try {
      List<Parameter> parameters = new ArrayList<>();
      Parameter parameterModel = new Parameter.Builder()
        .assessmentId("rule-e16fcfea-fe21-4d30-a721-423611481fea")
        .parameterName("tls_version")
        .parameterDisplayName("IBM Cloud Internet Services TLS version")
        .parameterType("string_list")
        .parameterValue("['1.2', '1.3']")
        .build();

      Parameter parameterModel2 = new Parameter.Builder()
        .assessmentId("rule-f9137be8-2490-4afb-8cd5-a201cb167eb2")
        .parameterName("ssh_port")
        .parameterDisplayName("Network ACL rule for allowed IPs to SSH port")
        .parameterType("numeric")
        .parameterValue("22")
        .build();

      Parameter parameterModel3 = new Parameter.Builder()
        .assessmentId("rule-9653d2c7-6290-4128-a5a3-65487ba40370")
        .parameterName("rdp_port")
        .parameterDisplayName("Security group rule RDP allow port number")
        .parameterType("numeric")
        .parameterValue("22")
        .build();

      Parameter parameterModel4 = new Parameter.Builder()
        .assessmentId("rule-7c5f6385-67e4-4edf-bec8-c722558b2dec")
        .parameterName("ssh_port")
        .parameterDisplayName("Security group rule SSH allow port number")
        .parameterType("numeric")
        .parameterValue("22")
        .build();

      Parameter parameterModel5 = new Parameter.Builder()
        .assessmentId("rule-f1e80ee7-88d5-4bf2-b42f-c863bb24601c")
        .parameterName("rdp_port")
        .parameterDisplayName("Disallowed IPs for ingress to RDP port")
        .parameterType("numeric")
        .parameterValue("3389")
        .build();

      Parameter parameterModel6 = new Parameter.Builder()
        .assessmentId("rule-96527f89-1867-4581-b923-1400e04661e0")
        .parameterName("exclude_default_security_groups")
        .parameterDisplayName("Exclude the default security groups")
        .parameterType("string_list")
        .parameterValue("['Default']")
        .build();

      parameters.add(parameterModel);
      parameters.add(parameterModel2);
      parameters.add(parameterModel3);
      parameters.add(parameterModel4);
      parameters.add(parameterModel5);
      parameters.add(parameterModel6);

      AttachmentNotificationsControls attachmentNotificationsControlsModel = new AttachmentNotificationsControls.Builder()
        .thresholdLimit(Long.valueOf("15"))
        .failedControlIds(new ArrayList<>())
        .build();

      AttachmentNotifications attachmentNotificationsModel = new AttachmentNotifications.Builder()
        .enabled(true)
        .controls(attachmentNotificationsControlsModel)
        .build();

      MultiCloudScopePayloadById multiCloudScopePayloadModel = new MultiCloudScopePayloadById.Builder()
        .id("8baad3b5-2e69-4027-9967-efac19508e1c")
        .build();

      Date endDate = new Date();
      DateRange dateRangeModel = new DateRange.Builder()
        .startDate(DateUtils.parseAsDateTime("2025-02-28T05:42:58.000Z"))
        .endDate(endDate)
        .build();

      ProfileAttachmentBase profileAttachmentBaseModel = new ProfileAttachmentBase.Builder()
        .attachmentParameters(parameters)
        .description("This is a profile attachment targeting IBM CIS Foundation using a SDK")
        .name("Profile Attachment for IBM CIS Foundation SDK test")
        .notifications(attachmentNotificationsModel)
        .schedule("daily")
        .scope(java.util.Arrays.asList(multiCloudScopePayloadModel))
        .status("disabled")
        .dataSelectionRange(dateRangeModel)
        .build();

      CreateProfileAttachmentOptions createProfileAttachmentOptions = new CreateProfileAttachmentOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
        .newAttachments(java.util.Arrays.asList(profileAttachmentBaseModel))
        .newProfileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3")
        .accountId(accountIdForReportLink)
        .build();

      // Invoke operation
      Response<ProfileAttachmentResponse> response = service.createProfileAttachment(createProfileAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      ProfileAttachmentResponse profileAttachmentResponseResult = response.getResult();
      assertNotNull(profileAttachmentResponseResult);

      attachmentIdLink = profileAttachmentResponseResult.getAttachments().get(0).getId();
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s",
        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateProfileAttachment" })
  public void testGetProfileAttachment() throws Exception {
    try {
      GetProfileAttachmentOptions getProfileAttachmentOptions = new GetProfileAttachmentOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
        .attachmentId(attachmentIdLink)
        .accountId(accountIdForReportLink)
        .build();

      // Invoke operation
      Response<ProfileAttachment> response = service.getProfileAttachment(getProfileAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProfileAttachment profileAttachmentResult = response.getResult();
      assertNotNull(profileAttachmentResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetProfileAttachment" })
  public void testReplaceProfileAttachment() throws Exception {
    try {
      List<Parameter> parameters = new ArrayList<>();
      Parameter parameterModel = new Parameter.Builder()
        .assessmentId("rule-e16fcfea-fe21-4d30-a721-423611481fea")
        .parameterName("tls_version")
        .parameterDisplayName("IBM Cloud Internet Services TLS version")
        .parameterType("string_list")
        .parameterValue("['1.2', '1.3']")
        .build();

      Parameter parameterModel2 = new Parameter.Builder()
        .assessmentId("rule-f9137be8-2490-4afb-8cd5-a201cb167eb2")
        .parameterName("ssh_port")
        .parameterDisplayName("Network ACL rule for allowed IPs to SSH port")
        .parameterType("numeric")
        .parameterValue("22")
        .build();

      Parameter parameterModel3 = new Parameter.Builder()
        .assessmentId("rule-9653d2c7-6290-4128-a5a3-65487ba40370")
        .parameterName("rdp_port")
        .parameterDisplayName("Security group rule RDP allow port number")
        .parameterType("numeric")
        .parameterValue("22")
        .build();

      Parameter parameterModel4 = new Parameter.Builder()
        .assessmentId("rule-7c5f6385-67e4-4edf-bec8-c722558b2dec")
        .parameterName("ssh_port")
        .parameterDisplayName("Security group rule SSH allow port number")
        .parameterType("numeric")
        .parameterValue("22")
        .build();

      Parameter parameterModel5 = new Parameter.Builder()
        .assessmentId("rule-f1e80ee7-88d5-4bf2-b42f-c863bb24601c")
        .parameterName("rdp_port")
        .parameterDisplayName("Disallowed IPs for ingress to RDP port")
        .parameterType("numeric")
        .parameterValue("3389")
        .build();

      Parameter parameterModel6 = new Parameter.Builder()
        .assessmentId("rule-96527f89-1867-4581-b923-1400e04661e0")
        .parameterName("exclude_default_security_groups")
        .parameterDisplayName("Exclude the default security groups")
        .parameterType("string_list")
        .parameterValue("['Default']")
        .build();

      parameters.add(parameterModel);
      parameters.add(parameterModel2);
      parameters.add(parameterModel3);
      parameters.add(parameterModel4);
      parameters.add(parameterModel5);
      parameters.add(parameterModel6);

      AttachmentNotificationsControls attachmentNotificationsControlsModel = new AttachmentNotificationsControls.Builder()
        .thresholdLimit(Long.valueOf("15"))
        .failedControlIds(new ArrayList<>())
        .build();

      AttachmentNotifications attachmentNotificationsModel = new AttachmentNotifications.Builder()
        .enabled(true)
        .controls(attachmentNotificationsControlsModel)
        .build();

      MultiCloudScopePayloadById multiCloudScopePayloadModel = new MultiCloudScopePayloadById.Builder()
        .id("8baad3b5-2e69-4027-9967-efac19508e1c")
        .build();

      Date endDate = new Date();
      DateRange dateRangeModel = new DateRange.Builder()
        .startDate(DateUtils.parseAsDateTime("2025-02-28T05:42:58.000Z"))
        .endDate(endDate)
        .build();

      ReplaceProfileAttachmentOptions replaceProfileAttachmentOptions = new ReplaceProfileAttachmentOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
        .attachmentId(attachmentIdLink)
        .attachmentParameters(parameters)
        .description("New Profile Attachment Update")
        .name("SDK Updated Test")
        .notifications(attachmentNotificationsModel)
        .schedule("daily")
        .scope(java.util.Arrays.asList(multiCloudScopePayloadModel))
        .status("disabled")
        .dataSelectionRange(dateRangeModel)
        .accountId(accountIdForReportLink)
        .build();

      // Invoke operation
      Response<ProfileAttachment> response = service.replaceProfileAttachment(replaceProfileAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProfileAttachment profileAttachmentResult = response.getResult();
      assertNotNull(profileAttachmentResult);

    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s",
        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testReplaceProfileAttachment" })
  public void testUpgradeAttachment() throws Exception {
    try {
      Parameter parameterModel = new Parameter.Builder()
        .assessmentType("testString")
        .assessmentId("testString")
        .parameterName("location")
        .parameterDisplayName("Location")
        .parameterType("string")
        .parameterValue("testString")
        .build();

      UpgradeAttachmentOptions upgradeAttachmentOptions = new UpgradeAttachmentOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
        .attachmentId(attachmentIdLink)
        .attachmentParameters(java.util.Arrays.asList(parameterModel))
        .accountId(accountIdForReportLink)
        .build();

      // Invoke operation
      Response<ProfileAttachment> response = service.upgradeAttachment(upgradeAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProfileAttachment profileAttachmentResult = response.getResult();
      assertNotNull(profileAttachmentResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testUpgradeAttachment" })
  public void testCreateScan() throws Exception {
    try {
      CreateScanOptions createScanOptions = new CreateScanOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .attachmentId("4deb572c-9f37-4126-9cc0-d550672533cb")
        .accountId(accountIdForReportLink)
        .build();

      // Invoke operation
      Response<CreateScanResponse> response = service.createScan(createScanOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      CreateScanResponse createScanResponseResult = response.getResult();
      assertNotNull(createScanResponseResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateScan" })
  public void testCreateControlLibrary() throws Exception {
    try {
      AssessmentPrototype assessmentPrototypeModel = new AssessmentPrototype.Builder()
        .assessmentId("rule-d1bd9f3f-bee1-46c5-9533-da8bba9eed4e")
        .assessmentDescription("This rule will check on regulation")
        .build();

      ControlSpecificationPrototype controlSpecificationPrototypeModel = new ControlSpecificationPrototype.Builder()
        .componentId("apprapp")
        .environment("ibm-cloud")
        .controlSpecificationId("testString")
        .controlSpecificationDescription("This field is used to describe a control specification")
        .assessments(java.util.Arrays.asList(assessmentPrototypeModel))
        .build();

      ControlDoc controlDocModel = new ControlDoc.Builder()
        .controlDocsId("testString")
        .controlDocsType("testString")
        .build();

      ControlPrototype controlPrototypeModel = new ControlPrototype.Builder()
        .controlName("security")
        .controlDescription("This is a description of a control")
        .controlCategory("test-control")
        .controlRequirement(true)
        .controlParent("testString")
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
        .accountId(accountIdForReportLink)
        .build();

      // Invoke operation
      Response<ControlLibrary> response = service.createControlLibrary(createControlLibraryOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      ControlLibrary controlLibraryResult = response.getResult();
      assertNotNull(controlLibraryResult);

      controlLibraryIdLink = controlLibraryResult.getId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateControlLibrary" })
  public void testListControlLibraries() throws Exception {
    try {
      ListControlLibrariesOptions listControlLibrariesOptions = new ListControlLibrariesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .accountId(accountIdForReportLink)
        .limit(Long.valueOf("10"))
        .start("testString")
        .build();

      // Invoke operation
      Response<ControlLibraryCollection> response = service.listControlLibraries(listControlLibrariesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ControlLibraryCollection controlLibraryCollectionResult = response.getResult();
      assertNotNull(controlLibraryCollectionResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListControlLibraries" })
  public void testListControlLibrariesWithPager() throws Exception {
    try {
      ListControlLibrariesOptions options = new ListControlLibrariesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .accountId(accountIdForReportLink)
        .limit(Long.valueOf("10"))
        .build();

      // Test getNext().
      List<ControlLibrary> allResults = new ArrayList<>();
      ControlLibrariesPager pager = new ControlLibrariesPager(service, options);
      while (pager.hasNext()) {
        List<ControlLibrary> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new ControlLibrariesPager(service, options);
      List<ControlLibrary> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListControlLibraries" })
  public void testReplaceCustomControlLibrary() throws Exception {
    try {
      AssessmentPrototype assessmentPrototypeModel = new AssessmentPrototype.Builder()
        .assessmentId("rule-d1bd9f3f-bee1-46c5-9533-da8bba9eed4e")
        .assessmentDescription("This rule will check on regulation")
        .build();

      ControlSpecificationPrototype controlSpecificationPrototypeModel = new ControlSpecificationPrototype.Builder()
        .componentId("apprapp")
        .environment("ibm-cloud")
        .controlSpecificationId("testString")
        .controlSpecificationDescription("This field is used to describe a control specification")
        .assessments(java.util.Arrays.asList(assessmentPrototypeModel))
        .build();

      ControlDoc controlDocModel = new ControlDoc.Builder()
        .controlDocsId("testString")
        .controlDocsType("testString")
        .build();

      ControlPrototype controlPrototypeModel = new ControlPrototype.Builder()
        .controlName("security")
        .controlDescription("This is a description of a control")
        .controlCategory("test-control")
        .controlRequirement(true)
        .controlParent("testString")
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
        .bssAccount("testString")
        .build();

      // Invoke operation
      Response<ControlLibrary> response = service.replaceCustomControlLibrary(replaceCustomControlLibraryOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ControlLibrary controlLibraryResult = response.getResult();
      assertNotNull(controlLibraryResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testReplaceCustomControlLibrary" })
  public void testGetControlLibrary() throws Exception {
    try {
      GetControlLibraryOptions getControlLibraryOptions = new GetControlLibraryOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .controlLibraryId(controlLibraryIdLink)
        .accountId(accountIdForReportLink)
        .build();

      // Invoke operation
      Response<ControlLibrary> response = service.getControlLibrary(getControlLibraryOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ControlLibrary controlLibraryResult = response.getResult();
      assertNotNull(controlLibraryResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetControlLibrary" })
  public void testCreateProfile() throws Exception {
    try {
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
        .versionGroupLabel("testString")
        .accountId(accountIdForReportLink)
        .build();

      // Invoke operation
      Response<Profile> response = service.createProfile(createProfileOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      Profile profileResult = response.getResult();
      assertNotNull(profileResult);

      profileIdLink = profileResult.id();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateProfile" })
  public void testListProfiles() throws Exception {
    try {
      ListProfilesOptions listProfilesOptions = new ListProfilesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .accountId(accountIdForReportLink)
        .limit(Long.valueOf("10"))
        .start("testString")
        .build();

      // Invoke operation
      Response<ProfileCollection> response = service.listProfiles(listProfilesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProfileCollection profileCollectionResult = response.getResult();
      assertNotNull(profileCollectionResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListProfiles" })
  public void testListProfilesWithPager() throws Exception {
    try {
      ListProfilesOptions options = new ListProfilesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .accountId(accountIdForReportLink)
        .limit(Long.valueOf("10"))
        .build();

      // Test getNext().
      List<Profile> allResults = new ArrayList<>();
      ProfilesPager pager = new ProfilesPager(service, options);
      while (pager.hasNext()) {
        List<Profile> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new ProfilesPager(service, options);
      List<Profile> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListProfiles" })
  public void testReplaceProfile() throws Exception {
    try {
      ControlDoc controlDocModel = new ControlDoc.Builder()
        .controlDocsId("testString")
        .controlDocsType("testString")
        .build();

      Parameter parameterModel = new Parameter.Builder()
        .assessmentType("testString")
        .assessmentId("testString")
        .parameterName("location")
        .parameterDisplayName("Location")
        .parameterType("string")
        .parameterValue("testString")
        .build();

      Assessment assessmentModel = new Assessment.Builder()
        .assessmentId("382c2b06-e6b2-43ee-b189-c1c7743b67ee")
        .assessmentType("ibm-cloud-rule")
        .assessmentMethod("ibm-cloud-rule")
        .assessmentDescription("Check whether Cloud Object Storage is accessible only by using private endpoints")
        .parameterCount(Long.valueOf("1"))
        .parameters(java.util.Arrays.asList(parameterModel))
        .build();

      ControlSpecification controlSpecificationModel = new ControlSpecification.Builder()
        .id("testString")
        .responsibility("testString")
        .componentId("testString")
        .componentName("testString")
        .componentType("testString")
        .environment("testString")
        .description("testString")
        .assessmentsCount(Long.valueOf("26"))
        .assessments(java.util.Arrays.asList(assessmentModel))
        .build();

      ProfileControls profileControlsModel = new ProfileControls.Builder()
        .controlRequirement(true)
        .controlLibraryId("a046fb6b-aba5-4646-b190-a2c76241e7af")
        .controlId("60dae3b5-6104-4b3e-bac7-26cc7b741aca")
        .controlLibraryVersion("testString")
        .controlName("testString")
        .controlDescription("testString")
        .controlSeverity("testString")
        .controlCategory("testString")
        .controlParent("testString")
        .controlDocs(controlDocModel)
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
        .newId("testString")
        .newProfileName("Example Profile Updated")
        .newInstanceId("testString")
        .newHierarchyEnabled(true)
        .newProfileDescription("This profile has been updated")
        .newProfileVersion("0.0.2")
        .newVersionGroupLabel("testString")
        .newLatest(true)
        .newCreatedBy("testString")
        .newCreatedOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
        .newUpdatedBy("testString")
        .newUpdatedOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
        .newControlsCount(Long.valueOf("26"))
        .newAttachmentsCount(Long.valueOf("26"))
        .accountId(accountIdForReportLink)
        .build();

      // Invoke operation
      Response<Profile> response = service.replaceProfile(replaceProfileOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Profile profileResult = response.getResult();
      assertNotNull(profileResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testReplaceProfile" })
  public void testGetProfile() throws Exception {
    try {
      GetProfileOptions getProfileOptions = new GetProfileOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId(profileIdLink)
        .accountId(accountIdForReportLink)
        .build();

      // Invoke operation
      Response<Profile> response = service.getProfile(getProfileOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Profile profileResult = response.getResult();
      assertNotNull(profileResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetProfile" })
  public void testReplaceProfileParameters() throws Exception {
    try {
      DefaultParameters defaultParametersModel = new DefaultParameters.Builder()
        .assessmentType("testString")
        .assessmentId("testString")
        .parameterName("testString")
        .parameterDefaultValue("testString")
        .parameterDisplayName("testString")
        .parameterType("testString")
        .build();

      ReplaceProfileParametersOptions replaceProfileParametersOptions = new ReplaceProfileParametersOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId(profileIdLink)
        .defaultParameters(java.util.Arrays.asList(defaultParametersModel))
        .id("testString")
        .accountId(accountIdForReportLink)
        .build();

      // Invoke operation
      Response<ProfileDefaultParametersResponse> response = service.replaceProfileParameters(replaceProfileParametersOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProfileDefaultParametersResponse profileDefaultParametersResponseResult = response.getResult();
      assertNotNull(profileDefaultParametersResponseResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testReplaceProfileParameters" })
  public void testListProfileParameters() throws Exception {
    try {
      ListProfileParametersOptions listProfileParametersOptions = new ListProfileParametersOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId(profileIdLink)
        .build();

      // Invoke operation
      Response<ProfileDefaultParametersResponse> response = service.listProfileParameters(listProfileParametersOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProfileDefaultParametersResponse profileDefaultParametersResponseResult = response.getResult();
      assertNotNull(profileDefaultParametersResponseResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListProfileParameters" })
  public void testCompareProfiles() throws Exception {
    try {
      CompareProfilesOptions compareProfilesOptions = new CompareProfilesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId("2f598907-970d-4d52-9071-5cc95912f55e")
        .accountId(accountIdForReportLink)
        .build();

      // Invoke operation
      Response<ComparePredefinedProfilesResponse> response = service.compareProfiles(compareProfilesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ComparePredefinedProfilesResponse comparePredefinedProfilesResponseResult = response.getResult();
      assertNotNull(comparePredefinedProfilesResponseResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCompareProfiles" })
  public void testListProfileAttachments() throws Exception {
    try {
      ListProfileAttachmentsOptions listProfileAttachmentsOptions = new ListProfileAttachmentsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
        .accountId(accountIdForReportLink)
        .build();

      // Invoke operation
      Response<ProfileAttachmentCollection> response = service.listProfileAttachments(listProfileAttachmentsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProfileAttachmentCollection profileAttachmentCollectionResult = response.getResult();
      assertNotNull(profileAttachmentCollectionResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListProfileAttachments" })
  public void testCreateScope() throws Exception {
    try {
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

      // Invoke operation
      Response<Scope> response = service.createScope(createScopeOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      Scope scopeResult = response.getResult();
      assertNotNull(scopeResult);

      scopeIdLink = scopeResult.getId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateScope" })
  public void testListScopes() throws Exception {
    try {
      ListScopesOptions listScopesOptions = new ListScopesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .limit(Long.valueOf("10"))
        .start("testString")
        .name("testString")
        .description("testString")
        .environment("testString")
        .build();

      // Invoke operation
      Response<ScopeCollection> response = service.listScopes(listScopesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ScopeCollection scopeCollectionResult = response.getResult();
      assertNotNull(scopeCollectionResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListScopes" })
  public void testListScopesWithPager() throws Exception {
    try {
      ListScopesOptions options = new ListScopesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .limit(Long.valueOf("10"))
        .name("testString")
        .description("testString")
        .environment("testString")
        .build();

      // Test getNext().
      List<Scope> allResults = new ArrayList<>();
      ScopesPager pager = new ScopesPager(service, options);
      while (pager.hasNext()) {
        List<Scope> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new ScopesPager(service, options);
      List<Scope> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListScopes" })
  public void testUpdateScope() throws Exception {
    try {
      UpdateScopeOptions updateScopeOptions = new UpdateScopeOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .scopeId(scopeIdLink)
        .name("updated name of scope")
        .description("updated scope description")
        .build();

      // Invoke operation
      Response<Scope> response = service.updateScope(updateScopeOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Scope scopeResult = response.getResult();
      assertNotNull(scopeResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testUpdateScope" })
  public void testGetScope() throws Exception {
    try {
      GetScopeOptions getScopeOptions = new GetScopeOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .scopeId(scopeIdLink)
        .build();

      // Invoke operation
      Response<Scope> response = service.getScope(getScopeOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Scope scopeResult = response.getResult();
      assertNotNull(scopeResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetScope" })
  public void testCreateSubscope() throws Exception {
    try {
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

      // Invoke operation
      Response<SubScopeResponse> response = service.createSubscope(createSubscopeOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      SubScopeResponse subScopeResponseResult = response.getResult();
      assertNotNull(subScopeResponseResult);

      subScopeIdLink = subScopeResponseResult.getSubscopes().get(0).getId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateSubscope" })
  public void testListSubscopes() throws Exception {
    try {
      ListSubscopesOptions listSubscopesOptions = new ListSubscopesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .scopeId(scopeIdLink)
        .limit(Long.valueOf("10"))
        .start("testString")
        .name("testString")
        .description("testString")
        .environment("testString")
        .build();

      // Invoke operation
      Response<SubScopeCollection> response = service.listSubscopes(listSubscopesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      SubScopeCollection subScopeCollectionResult = response.getResult();
      assertNotNull(subScopeCollectionResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListSubscopes" })
  public void testListSubscopesWithPager() throws Exception {
    try {
      ListSubscopesOptions options = new ListSubscopesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .scopeId(scopeIdLink)
        .limit(Long.valueOf("10"))
        .name("testString")
        .description("testString")
        .environment("testString")
        .build();

      // Test getNext().
      List<SubScope> allResults = new ArrayList<>();
      SubscopesPager pager = new SubscopesPager(service, options);
      while (pager.hasNext()) {
        List<SubScope> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new SubscopesPager(service, options);
      List<SubScope> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListSubscopes" })
  public void testGetSubscope() throws Exception {
    try {
      GetSubscopeOptions getSubscopeOptions = new GetSubscopeOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .scopeId(scopeIdLink)
        .subscopeId(subScopeIdLink)
        .build();

      // Invoke operation
      Response<SubScope> response = service.getSubscope(getSubscopeOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      SubScope subScopeResult = response.getResult();
      assertNotNull(subScopeResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetSubscope" })
  public void testUpdateSubscope() throws Exception {
    try {
      UpdateSubscopeOptions updateSubscopeOptions = new UpdateSubscopeOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .scopeId(scopeIdLink)
        .subscopeId(subScopeIdLink)
        .name("updated name of scope")
        .description("updated scope description")
        .build();

      // Invoke operation
      Response<SubScope> response = service.updateSubscope(updateSubscopeOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      SubScope subScopeResult = response.getResult();
      assertNotNull(subScopeResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testUpdateSubscope" })
  public void testCreateTarget() throws Exception {
    try {
      Account accountModel = new Account.Builder()
        .id("531fc3e28bfc43c5a2cea07786d93f5c")
        .name("NIST")
        .type("account_type")
        .build();

      Tags tagsModel = new Tags.Builder()
        .user(java.util.Arrays.asList("testString"))
        .access(java.util.Arrays.asList("testString"))
        .service(java.util.Arrays.asList("testString"))
        .build();

      Resource resourceModel = new Resource.Builder()
        .reportId("30b434b3-cb08-4845-af10-7a8fc682b6a8")
        .homeAccountId("2411ffdc16844b07b42521c3443f456d")
        .id("crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::")
        .resourceName("jeff's key")
        .account(accountModel)
        .componentId("cloud-object_storage")
        .componentName("cloud-object_storage")
        .environment("ibm cloud")
        .tags(tagsModel)
        .status("compliant")
        .totalCount(Long.valueOf("140"))
        .passCount(Long.valueOf("123"))
        .failureCount(Long.valueOf("12"))
        .errorCount(Long.valueOf("5"))
        .skippedCount(Long.valueOf("7"))
        .completedCount(Long.valueOf("135"))
        .serviceName("pm-20")
        .instanceCrn("testString")
        .build();

      Credential credentialModel = new Credential.Builder()
        .secretCrn("testString")
        .resources(java.util.Arrays.asList(resourceModel))
        .build();

      CreateTargetOptions createTargetOptions = new CreateTargetOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .accountId("62ecf99b240144dea9125666249edfcb")
        .trustedProfileId("Profile-cb2c1829-9a8d-4218-b9cd-9f83fc814e54")
        .name("Target for IBM account")
        .credentials(java.util.Arrays.asList(credentialModel))
        .build();

      // Invoke operation
      Response<Target> response = service.createTarget(createTargetOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      Target targetResult = response.getResult();
      assertNotNull(targetResult);

      targetIdLink = targetResult.getId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTarget" })
  public void testListTargets() throws Exception {
    try {
      ListTargetsOptions listTargetsOptions = new ListTargetsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .build();

      // Invoke operation
      Response<TargetCollection> response = service.listTargets(listTargetsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TargetCollection targetCollectionResult = response.getResult();
      assertNotNull(targetCollectionResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListTargets" })
  public void testGetTarget() throws Exception {
    try {
      GetTargetOptions getTargetOptions = new GetTargetOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .targetId(targetIdLink)
        .build();

      // Invoke operation
      Response<Target> response = service.getTarget(getTargetOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Target targetResult = response.getResult();
      assertNotNull(targetResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetTarget" })
  public void testReplaceTarget() throws Exception {
    try {
      Account accountModel = new Account.Builder()
        .id("531fc3e28bfc43c5a2cea07786d93f5c")
        .name("NIST")
        .type("account_type")
        .build();

      Tags tagsModel = new Tags.Builder()
        .user(java.util.Arrays.asList("testString"))
        .access(java.util.Arrays.asList("testString"))
        .service(java.util.Arrays.asList("testString"))
        .build();

      Resource resourceModel = new Resource.Builder()
        .reportId("30b434b3-cb08-4845-af10-7a8fc682b6a8")
        .homeAccountId("2411ffdc16844b07b42521c3443f456d")
        .id("crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::")
        .resourceName("jeff's key")
        .account(accountModel)
        .componentId("cloud-object_storage")
        .componentName("cloud-object_storage")
        .environment("ibm cloud")
        .tags(tagsModel)
        .status("compliant")
        .totalCount(Long.valueOf("140"))
        .passCount(Long.valueOf("123"))
        .failureCount(Long.valueOf("12"))
        .errorCount(Long.valueOf("5"))
        .skippedCount(Long.valueOf("7"))
        .completedCount(Long.valueOf("135"))
        .serviceName("pm-20")
        .instanceCrn("testString")
        .build();

      Credential credentialModel = new Credential.Builder()
        .secretCrn("dummy")
        .resources(java.util.Arrays.asList(resourceModel))
        .build();

      ReplaceTargetOptions replaceTargetOptions = new ReplaceTargetOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .targetId(targetIdLink)
        .accountId("be200c80cabc456e91139e4152327823")
        .trustedProfileId("Profile-a0a4c149-4fed-47ff-bfb2-680bcfaa64d3")
        .name("Sample Target Name")
        .credentials(java.util.Arrays.asList(credentialModel))
        .build();

      // Invoke operation
      Response<Target> response = service.replaceTarget(replaceTargetOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Target targetResult = response.getResult();
      assertNotNull(targetResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testReplaceTarget" })
  public void testCreateProviderTypeInstance() throws Exception {
    try {
      CreateProviderTypeInstanceOptions createProviderTypeInstanceOptions = new CreateProviderTypeInstanceOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
        .name("workload-protection-instance-1")
        .attributes(java.util.Collections.singletonMap("anyKey", "anyValue"))
        .build();

      // Invoke operation
      Response<ProviderTypeInstance> response = service.createProviderTypeInstance(createProviderTypeInstanceOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      ProviderTypeInstance providerTypeInstanceResult = response.getResult();
      assertNotNull(providerTypeInstanceResult);

      providerTypeInstanceIdLink = providerTypeInstanceResult.getId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateProviderTypeInstance" })
  public void testListProviderTypeInstances() throws Exception {
    try {
      ListProviderTypeInstancesOptions listProviderTypeInstancesOptions = new ListProviderTypeInstancesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
        .build();

      // Invoke operation
      Response<ProviderTypeInstanceCollection> response = service.listProviderTypeInstances(listProviderTypeInstancesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProviderTypeInstanceCollection providerTypeInstanceCollectionResult = response.getResult();
      assertNotNull(providerTypeInstanceCollectionResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListProviderTypeInstances" })
  public void testGetProviderTypeInstance() throws Exception {
    try {
      GetProviderTypeInstanceOptions getProviderTypeInstanceOptions = new GetProviderTypeInstanceOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
        .providerTypeInstanceId(providerTypeInstanceIdLink)
        .build();

      // Invoke operation
      Response<ProviderTypeInstance> response = service.getProviderTypeInstance(getProviderTypeInstanceOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProviderTypeInstance providerTypeInstanceResult = response.getResult();
      assertNotNull(providerTypeInstanceResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetProviderTypeInstance" })
  public void testUpdateProviderTypeInstance() throws Exception {
    try {
      UpdateProviderTypeInstanceOptions updateProviderTypeInstanceOptions = new UpdateProviderTypeInstanceOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
        .providerTypeInstanceId(providerTypeInstanceIdLink)
        .name("workload-protection-instance-1")
        .attributes(java.util.Collections.singletonMap("anyKey", "anyValue"))
        .build();

      // Invoke operation
      Response<ProviderTypeInstance> response = service.updateProviderTypeInstance(updateProviderTypeInstanceOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProviderTypeInstance providerTypeInstanceResult = response.getResult();
      assertNotNull(providerTypeInstanceResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testUpdateProviderTypeInstance" })
  public void testListProviderTypes() throws Exception {
    try {
      ListProviderTypesOptions listProviderTypesOptions = new ListProviderTypesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .build();

      // Invoke operation
      Response<ProviderTypeCollection> response = service.listProviderTypes(listProviderTypesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProviderTypeCollection providerTypeCollectionResult = response.getResult();
      assertNotNull(providerTypeCollectionResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListProviderTypes" })
  public void testGetProviderTypeById() throws Exception {
    try {
      GetProviderTypeByIdOptions getProviderTypeByIdOptions = new GetProviderTypeByIdOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
        .build();

      // Invoke operation
      Response<ProviderType> response = service.getProviderTypeById(getProviderTypeByIdOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProviderType providerTypeResult = response.getResult();
      assertNotNull(providerTypeResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetProviderTypeById" })
  public void testGetLatestReports() throws Exception {
    try {
      GetLatestReportsOptions getLatestReportsOptions = new GetLatestReportsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .sort("profile_name")
        .build();

      // Invoke operation
      Response<ReportLatest> response = service.getLatestReports(getLatestReportsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ReportLatest reportLatestResult = response.getResult();
      assertNotNull(reportLatestResult);

      accountIdForReportLink = reportLatestResult.getReports().get(0).getAccount().id();
      reportIdForReportLink = reportLatestResult.getReports().get(0).getId();
      attachmentIdForReportLink = reportLatestResult.getReports().get(0).getAttachment().getId();
      groupIdForReportLink = reportLatestResult.getReports().get(0).getGroupId();
      profileIdForReportLink = reportLatestResult.getReports().get(0).getProfile().getId();
      typeForReportLink = reportLatestResult.getReports().get(0).getType();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetLatestReports" })
  public void testListReports() throws Exception {
    try {
      ListReportsOptions listReportsOptions = new ListReportsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportAttachmentId(attachmentIdForReportLink)
        .groupId(groupIdForReportLink)
        .reportProfileId(profileIdForReportLink)
        .type(typeForReportLink)
        .start("testString")
        .limit(Long.valueOf("10"))
        .sort("profile_name")
        .build();

      // Invoke operation
      Response<ReportCollection> response = service.listReports(listReportsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ReportCollection reportCollectionResult = response.getResult();
      assertNotNull(reportCollectionResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListReports" })
  public void testListReportsWithPager() throws Exception {
    try {
      ListReportsOptions options = new ListReportsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportAttachmentId(attachmentIdForReportLink)
        .groupId(groupIdForReportLink)
        .reportProfileId(profileIdForReportLink)
        .type(typeForReportLink)
        .limit(Long.valueOf("10"))
        .sort("profile_name")
        .build();

      // Test getNext().
      List<Report> allResults = new ArrayList<>();
      ReportsPager pager = new ReportsPager(service, options);
      while (pager.hasNext()) {
        List<Report> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new ReportsPager(service, options);
      List<Report> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListReports" })
  public void testGetReport() throws Exception {
    try {
      GetReportOptions getReportOptions = new GetReportOptions.Builder()
        .reportId(reportIdForReportLink)
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .scopeId("testString")
        .subscopeId("testString")
        .build();

      // Invoke operation
      Response<Report> response = service.getReport(getReportOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Report reportResult = response.getResult();
      assertNotNull(reportResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetReport" })
  public void testGetReportSummary() throws Exception {
    try {
      GetReportSummaryOptions getReportSummaryOptions = new GetReportSummaryOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .build();

      // Invoke operation
      Response<ReportSummary> response = service.getReportSummary(getReportSummaryOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ReportSummary reportSummaryResult = response.getResult();
      assertNotNull(reportSummaryResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetReportSummary" })
  public void testGetReportDownloadFile() throws Exception {
    try {
      GetReportDownloadFileOptions getReportDownloadFileOptions = new GetReportDownloadFileOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .accept("application/csv")
        .excludeSummary(true)
        .build();

      // Invoke operation
      Response<InputStream> response = service.getReportDownloadFile(getReportDownloadFileOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream inputStreamResult = response.getResult();) {
          assertNotNull(inputStreamResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetReportDownloadFile" })
  public void testGetReportControls() throws Exception {
    try {
      GetReportControlsOptions getReportControlsOptions = new GetReportControlsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .controlId("testString")
        .controlName("testString")
        .controlDescription("testString")
        .controlCategory("testString")
        .status("compliant")
        .sort("control_name")
        .scopeId("testString")
        .subscopeId("testString")
        .build();

      // Invoke operation
      Response<ReportControls> response = service.getReportControls(getReportControlsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ReportControls reportControlsResult = response.getResult();
      assertNotNull(reportControlsResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetReportControls" })
  public void testGetReportRule() throws Exception {
    try {
      GetReportRuleOptions getReportRuleOptions = new GetReportRuleOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .ruleId("rule-61fa114a-2bb9-43fd-8068-b873b48bdf79")
        .build();

      // Invoke operation
      Response<RuleInfo> response = service.getReportRule(getReportRuleOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      RuleInfo ruleInfoResult = response.getResult();
      assertNotNull(ruleInfoResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetReportRule" })
  public void testListReportEvaluations() throws Exception {
    try {
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
        .start("testString")
        .limit(Long.valueOf("10"))
        .sort("assessment_id")
        .scopeId("testString")
        .subscopeId("testString")
        .build();

      // Invoke operation
      Response<EvaluationPage> response = service.listReportEvaluations(listReportEvaluationsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      EvaluationPage evaluationPageResult = response.getResult();
      assertNotNull(evaluationPageResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListReportEvaluations" })
  public void testListReportEvaluationsWithPager() throws Exception {
    try {
      ListReportEvaluationsOptions options = new ListReportEvaluationsOptions.Builder()
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

      // Test getNext().
      List<Evaluation> allResults = new ArrayList<>();
      ReportEvaluationsPager pager = new ReportEvaluationsPager(service, options);
      while (pager.hasNext()) {
        List<Evaluation> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new ReportEvaluationsPager(service, options);
      List<Evaluation> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListReportEvaluations" })
  public void testListReportResources() throws Exception {
    try {
      ListReportResourcesOptions listReportResourcesOptions = new ListReportResourcesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .id("testString")
        .resourceName("testString")
        .accountId(accountIdForReportLink)
        .componentId("testString")
        .status("compliant")
        .sort("account_id")
        .start("testString")
        .limit(Long.valueOf("10"))
        .scopeId("testString")
        .subscopeId("testString")
        .build();

      // Invoke operation
      Response<ResourcePage> response = service.listReportResources(listReportResourcesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ResourcePage resourcePageResult = response.getResult();
      assertNotNull(resourcePageResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListReportResources" })
  public void testListReportResourcesWithPager() throws Exception {
    try {
      ListReportResourcesOptions options = new ListReportResourcesOptions.Builder()
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

      // Test getNext().
      List<Resource> allResults = new ArrayList<>();
      ReportResourcesPager pager = new ReportResourcesPager(service, options);
      while (pager.hasNext()) {
        List<Resource> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new ReportResourcesPager(service, options);
      List<Resource> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListReportResources" })
  public void testGetReportTags() throws Exception {
    try {
      GetReportTagsOptions getReportTagsOptions = new GetReportTagsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .build();

      // Invoke operation
      Response<ReportTags> response = service.getReportTags(getReportTagsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ReportTags reportTagsResult = response.getResult();
      assertNotNull(reportTagsResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetReportTags" })
  public void testGetReportViolationsDrift() throws Exception {
    try {
      GetReportViolationsDriftOptions getReportViolationsDriftOptions = new GetReportViolationsDriftOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .scanTimeDuration(Long.valueOf("0"))
        .scopeId("testString")
        .subscopeId("testString")
        .build();

      // Invoke operation
      Response<ReportViolationsDrift> response = service.getReportViolationsDrift(getReportViolationsDriftOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ReportViolationsDrift reportViolationsDriftResult = response.getResult();
      assertNotNull(reportViolationsDriftResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetReportViolationsDrift" })
  public void testListScanReports() throws Exception {
    try {
      ListScanReportsOptions listScanReportsOptions = new ListScanReportsOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .scopeId("testString")
        .subscopeId("testString")
        .sort("status")
        .build();

      // Invoke operation
      Response<ScanReportCollection> response = service.listScanReports(listScanReportsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ScanReportCollection scanReportCollectionResult = response.getResult();
      assertNotNull(scanReportCollectionResult);

      scanIdForScanReportLink = scanReportCollectionResult.getScanReports().get(0).getId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListScanReports" })
  public void testCreateScanReport() throws Exception {
    try {
      CreateScanReportOptions createScanReportOptions = new CreateScanReportOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .format("csv")
        .scopeId("132009ff-b982-412e-a110-ad8797e10f84")
        .subscopeId("c7ddcbcc-6a43-4ab3-b6a7-b2d8f65cd54a")
        .build();

      // Invoke operation
      Response<CreateScanReport> response = service.createScanReport(createScanReportOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);

      CreateScanReport createScanReportResult = response.getResult();
      assertNotNull(createScanReportResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateScanReport" })
  public void testGetScanReport() throws Exception {
    try {
      GetScanReportOptions getScanReportOptions = new GetScanReportOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .jobId(scanIdForScanReportLink)
        .build();

      // Invoke operation
      Response<ScanReport> response = service.getScanReport(getScanReportOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ScanReport scanReportResult = response.getResult();
      assertNotNull(scanReportResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetScanReport" })
  public void testGetScanReportDownloadFile() throws Exception {
    try {
      GetScanReportDownloadFileOptions getScanReportDownloadFileOptions = new GetScanReportDownloadFileOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .reportId(reportIdForReportLink)
        .jobId(scanIdForScanReportLink)
        .accept("application/csv")
        .build();

      // Invoke operation
      Response<InputStream> response = service.getScanReportDownloadFile(getScanReportDownloadFileOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      try (InputStream inputStreamResult = response.getResult();) {
          assertNotNull(inputStreamResult);
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetScanReportDownloadFile" })
  public void testListRules() throws Exception {
    try {
      ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .limit(Long.valueOf("10"))
        .start("testString")
        .type("system_defined")
        .search("testString")
        .serviceName("testString")
        .sort("updated_on")
        .build();

      // Invoke operation
      Response<RuleCollection> response = service.listRules(listRulesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      RuleCollection ruleCollectionResult = response.getResult();
      assertNotNull(ruleCollectionResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListRules" })
  public void testListRulesWithPager() throws Exception {
    try {
      ListRulesOptions options = new ListRulesOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .limit(Long.valueOf("10"))
        .type("system_defined")
        .search("testString")
        .serviceName("testString")
        .sort("updated_on")
        .build();

      // Test getNext().
      List<Rule> allResults = new ArrayList<>();
      RulesPager pager = new RulesPager(service, options);
      while (pager.hasNext()) {
        List<Rule> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new RulesPager(service, options);
      List<Rule> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListRules" })
  public void testCreateRule() throws Exception {
    try {
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
        .description("testString")
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

      // Invoke operation
      Response<Rule> response = service.createRule(createRuleOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      Rule ruleResult = response.getResult();
      assertNotNull(ruleResult);

      ruleIdLink = ruleResult.getId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateRule" })
  public void testGetRule() throws Exception {
    try {
      GetRuleOptions getRuleOptions = new GetRuleOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .ruleId(ruleIdLink)
        .build();

      // Invoke operation
      Response<Rule> response = service.getRule(getRuleOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Rule ruleResult = response.getResult();
      assertNotNull(ruleResult);

      eTagLink = response.getHeaders().values("ETag").get(0);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetRule" })
  public void testReplaceRule() throws Exception {
    try {
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
        .description("testString")
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

      // Invoke operation
      Response<Rule> response = service.replaceRule(replaceRuleOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Rule ruleResult = response.getResult();
      assertNotNull(ruleResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testReplaceRule" })
  public void testListServices() throws Exception {
    try {
      ListServicesOptions listServicesOptions = new ListServicesOptions();

      // Invoke operation
      Response<ServiceCollection> response = service.listServices(listServicesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ServiceCollection serviceCollectionResult = response.getResult();
      assertNotNull(serviceCollectionResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListServices" })
  public void testGetService() throws Exception {
    try {
      GetServiceOptions getServiceOptions = new GetServiceOptions.Builder()
        .servicesName("cloud-object-storage")
        .build();

      // Invoke operation
      Response<Service> response = service.getService(getServiceOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Service serviceResult = response.getResult();
      assertNotNull(serviceResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetService" })
  public void testDeleteProfileAttachment() throws Exception {
    try {
      DeleteProfileAttachmentOptions deleteProfileAttachmentOptions = new DeleteProfileAttachmentOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
        .attachmentId(attachmentIdLink)
        .accountId(accountIdForReportLink)
        .build();

      // Invoke operation
      Response<ProfileAttachment> response = service.deleteProfileAttachment(deleteProfileAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProfileAttachment profileAttachmentResult = response.getResult();
      assertNotNull(profileAttachmentResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteProfileAttachment" })
  public void testDeleteCustomControlLibrary() throws Exception {
    try {
      DeleteCustomControlLibraryOptions deleteCustomControlLibraryOptions = new DeleteCustomControlLibraryOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .controlLibraryId(controlLibraryIdLink)
        .accountId(accountIdForReportLink)
        .build();

      // Invoke operation
      Response<ControlLibrary> response = service.deleteCustomControlLibrary(deleteCustomControlLibraryOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ControlLibrary controlLibraryResult = response.getResult();
      assertNotNull(controlLibraryResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteCustomControlLibrary" })
  public void testDeleteCustomProfile() throws Exception {
    try {
      DeleteCustomProfileOptions deleteCustomProfileOptions = new DeleteCustomProfileOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .profileId(profileIdLink)
        .accountId(accountIdForReportLink)
        .build();

      // Invoke operation
      Response<Profile> response = service.deleteCustomProfile(deleteCustomProfileOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Profile profileResult = response.getResult();
      assertNotNull(profileResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteCustomProfile" })
  public void testDeleteSubscope() throws Exception {
    try {
      DeleteSubscopeOptions deleteSubscopeOptions = new DeleteSubscopeOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .scopeId(scopeIdLink)
        .subscopeId(subScopeIdLink)
        .build();

      // Invoke operation
      Response<Void> response = service.deleteSubscope(deleteSubscopeOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteSubscope" })
  public void testDeleteScope() throws Exception {
    try {
      DeleteScopeOptions deleteScopeOptions = new DeleteScopeOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .scopeId(scopeIdLink)
        .build();

      // Invoke operation
      Response<Void> response = service.deleteScope(deleteScopeOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteScope" })
  public void testDeleteTarget() throws Exception {
    try {
      DeleteTargetOptions deleteTargetOptions = new DeleteTargetOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .targetId(targetIdLink)
        .build();

      // Invoke operation
      Response<Void> response = service.deleteTarget(deleteTargetOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteTarget" })
  public void testDeleteProviderTypeInstance() throws Exception {
    try {
      DeleteProviderTypeInstanceOptions deleteProviderTypeInstanceOptions = new DeleteProviderTypeInstanceOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
        .providerTypeInstanceId(providerTypeInstanceIdLink)
        .build();

      // Invoke operation
      Response<Void> response = service.deleteProviderTypeInstance(deleteProviderTypeInstanceOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteProviderTypeInstance" })
  public void testDeleteRule() throws Exception {
    try {
      DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
        .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
        .ruleId(ruleIdLink)
        .build();

      // Invoke operation
      Response<Void> response = service.deleteRule(deleteRuleOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
