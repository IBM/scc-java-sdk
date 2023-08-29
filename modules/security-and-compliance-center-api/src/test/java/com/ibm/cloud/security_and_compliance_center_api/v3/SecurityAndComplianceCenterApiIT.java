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
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Account;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AdditionalProperty;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AdditionalTargetAttribute;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Assessment;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Attachment;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentParameterPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentScope;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentsAccountPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentsNotificationsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentsPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ComplianceScore;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ComplianceStats;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlDocs;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibrariesPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibrary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibraryCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibraryDelete;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibraryItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSpecificationWithStats;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSpecifications;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlWithStats;
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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EvalDetails;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EvalStats;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Evaluation;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EvaluationPage;
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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.LabelType;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.LastScan;
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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PageHRef;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PageHRefFirst;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PageHRefNext;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PaginatedCollectionFirst;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PaginatedCollectionNext;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Parameter;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ParameterInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PostTestEventOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Profile;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileControlsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfilesPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Property;
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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportPage;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportResourcesPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportSummary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportTags;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportViolationDataPoint;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportViolationsDrift;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportsPager;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfig;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigItems;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigItemsRequiredConfigAnd;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigItemsRequiredConfigBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigItemsRequiredConfigOr;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigRequiredConfigAnd;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigRequiredConfigBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigRequiredConfigOr;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Resource;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ResourcePage;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ResourceSummary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ResourceSummaryItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Rule;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RuleInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RulesPageBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Scan;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopeProperty;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Settings;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Tags;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Target;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.TargetInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.TestEvent;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateSettingsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import com.ibm.cloud.security_and_compliance_center_api.test.SdkIntegrationTestBase;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
  String providerTypeIdLink = null;
  String providerTypeInstanceIdLink = null;
  String reportIdForReportLink = null;
  String ruleIdLink = null;
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
        .xCorrelationId("1a2b3c4d-5e6f-4a7b-8c9d-e0f1a2b3c4d5")
        .xRequestId("testString")
        .build();

      // Invoke operation
      Response<Settings> response = service.getSettings(getSettingsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Settings settingsResult = response.getResult();

      assertNotNull(settingsResult);
      eventNotificationsCrnForUpdateSettingsLink = settingsResult.eventNotifications().instanceCrn();
      objectStorageCrnForUpdateSettingsLink = settingsResult.objectStorage().instanceCrn();
      objectStorageBucketForUpdateSettingsLink = settingsResult.objectStorage().bucket();
      objectStorageLocationForUpdateSettingsLink = settingsResult.objectStorage().bucketLocation();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetSettings" })
  public void testCreateRule() throws Exception {
    try {
      AdditionalTargetAttribute additionalTargetAttributeModel = new AdditionalTargetAttribute.Builder()
        .name("location")
        .operator("string_equals")
        .value("us-east")
        .build();

      Target targetModel = new Target.Builder()
        .serviceName("cloud-object-storage")
        .serviceDisplayName("testString")
        .resourceKind("bucket")
        .additionalTargetAttributes(java.util.Arrays.asList(additionalTargetAttributeModel))
        .build();

      RequiredConfigItemsRequiredConfigBase requiredConfigItemsModel = new RequiredConfigItemsRequiredConfigBase.Builder()
        .description("testString")
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
        .type("user_defined")
        .version("1.0.0")
        .xImport(importModel)
        .labels(java.util.Arrays.asList())
        .xCorrelationId("testString")
        .xRequestId("testString")
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
        .ruleId(ruleIdLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
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

  @Test(dependsOnMethods = { "testCreateRule" })
  public void testGetLatestReports() throws Exception {
    try {
      GetLatestReportsOptions getLatestReportsOptions = new GetLatestReportsOptions.Builder()
        .xCorrelationId("testString")
        .xRequestId("testString")
        .sort("profile_name")
        .build();

      // Invoke operation
      Response<ReportLatest> response = service.getLatestReports(getLatestReportsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ReportLatest reportLatestResult = response.getResult();

      assertNotNull(reportLatestResult);
      accountIdForReportLink = reportLatestResult.getReports().get(0).getAccount().getId();
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
  public void testUpdateSettings() throws Exception {
    try {
      EventNotifications eventNotificationsModel = new EventNotifications.Builder()
        .instanceCrn(eventNotificationsCrnForUpdateSettingsLink)
        .updatedOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
        .sourceId("crn:v1:staging:public:event-notifications:us-south:a/ff88f007f9ff4622aac4fbc0eda36255:b8b07245-0bbe-4478-b11c-0dce523105fd::")
        .sourceDescription("This source is used for integration with IBM Cloud Security and Compliance Center.")
        .sourceName("compliance")
        .build();

      ObjectStorage objectStorageModel = new ObjectStorage.Builder()
        .instanceCrn(objectStorageCrnForUpdateSettingsLink)
        .bucket(objectStorageBucketForUpdateSettingsLink)
        .bucketLocation(objectStorageLocationForUpdateSettingsLink)
        .bucketEndpoint("testString")
        .updatedOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
        .build();

      UpdateSettingsOptions updateSettingsOptions = new UpdateSettingsOptions.Builder()
        .eventNotifications(eventNotificationsModel)
        .objectStorage(objectStorageModel)
        .xCorrelationId("1a2b3c4d-5e6f-4a7b-8c9d-e0f1a2b3c4d5")
        .xRequestId("testString")
        .build();

      // Invoke operation
      Response<Settings> response = service.updateSettings(updateSettingsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);

      Settings settingsResult = response.getResult();

      //assertNotNull(settingsResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  // @Test(dependsOnMethods = { "testUpdateSettings" })
  // public void testPostTestEvent() throws Exception {
  //   try {
  //     PostTestEventOptions postTestEventOptions = new PostTestEventOptions.Builder()
  //       .xCorrelationId("1a2b3c4d-5e6f-4a7b-8c9d-e0f1a2b3c4d5")
  //       .xRequestId("testString")
  //       .build();

  //     // Invoke operation
  //     Response<TestEvent> response = service.postTestEvent(postTestEventOptions).execute();
  //     // Validate response
  //     assertNotNull(response);
  //     assertEquals(response.getStatusCode(), 202);

  //     TestEvent testEventResult = response.getResult();

  //     assertNotNull(testEventResult);
  //   } catch (ServiceResponseException e) {
  //       fail(String.format("Service returned status code %d: %s%nError details: %s",
  //         e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
  //   }
  // }

  @Test(dependsOnMethods = { "testUpdateSettings" })
  public void testCreateCustomControlLibrary() throws Exception {
    try {
      ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
        .parameterName("session_invalidation_in_seconds")
        .parameterDisplayName("Sign out due to inactivity in seconds")
        .parameterType("numeric")
        .parameterValue("public")
        .build();

      Implementation implementationModel = new Implementation.Builder()
        .assessmentId("rule-a637949b-7e51-46c4-afd4-b96619001bf1")
        .assessmentMethod("ibm-cloud-rule")
        .assessmentType("automated")
        .assessmentDescription("Check that there is an Activity Tracker event route defined to collect global events generated by IBM Cloud services")
        .parameterCount(Long.valueOf("38"))
        .parameters(java.util.Arrays.asList(parameterInfoModel))
        .build();

      ControlSpecifications controlSpecificationsModel = new ControlSpecifications.Builder()
        .controlSpecificationId("5c7d6f88-a92f-4734-9b49-bd22b0900184")
        .responsibility("user")
        .componentId("iam-identity")
        .componenetName("testString")
        .environment("ibm-cloud")
        .controlSpecificationDescription("IBM cloud")
        .assessmentsCount(Long.valueOf("38"))
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
        .controlParent("")
        .controlTags(java.util.Arrays.asList("1fa45e17-9322-4e6c-bbd6-1c51db08e790"))
        .controlSpecifications(java.util.Arrays.asList(controlSpecificationsModel))
        .controlDocs(controlDocsModel)
        .controlRequirement(true)
        .status("enabled")
        .build();

      CreateCustomControlLibraryOptions createCustomControlLibraryOptions = new CreateCustomControlLibraryOptions.Builder()
        .controlLibraryName("IBM Cloud for Financial Services")
        .controlLibraryDescription("IBM Cloud for Financial Services")
        .controlLibraryType("custom")
        .controls(java.util.Arrays.asList(controlsInControlLibModel))
        .controlLibraryVersion("1.0.0")
        .latest(true)
        .controlsCount(Long.valueOf("38"))
        .xCorrelationId("testString")
        .xRequestId("testString")
        .build();

      // Invoke operation
      Response<ControlLibrary> response = service.createCustomControlLibrary(createCustomControlLibraryOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      ControlLibrary controlLibraryResult = response.getResult();

      assertNotNull(controlLibraryResult);
      controlLibraryIdLink = controlLibraryResult.id();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateCustomControlLibrary" })
  public void testListControlLibraries() throws Exception {
    try {
      ListControlLibrariesOptions listControlLibrariesOptions = new ListControlLibrariesOptions.Builder()
        .xCorrelationId("testString")
        .xRequestId("testString")
        .limit(Long.valueOf("1"))
        .controlLibraryType("custom")
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
        .xCorrelationId("testString")
        .xRequestId("testString")
        .limit(Long.valueOf("50"))
        .controlLibraryType("custom")
        .build();

      // Test getNext().
      List<ControlLibraryItem> allResults = new ArrayList<>();
      ControlLibrariesPager pager = new ControlLibrariesPager(service, options);
      while (pager.hasNext()) {
        List<ControlLibraryItem> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new ControlLibrariesPager(service, options);
      List<ControlLibraryItem> allItems = pager.getAll();
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
  public void testGetControlLibrary() throws Exception {
    try {
      GetControlLibraryOptions getControlLibraryOptions = new GetControlLibraryOptions.Builder()
        .controlLibrariesId(controlLibraryIdLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
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
  public void testReplaceCustomControlLibrary() throws Exception {
    try {
      ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
        .parameterName("session_invalidation_in_seconds")
        .parameterDisplayName("Sign out due to inactivity in seconds")
        .parameterType("numeric")
        .parameterValue("public")
        .build();

      Implementation implementationModel = new Implementation.Builder()
        .assessmentId("rule-a637949b-7e51-46c4-afd4-b96619001bf1")
        .assessmentMethod("ibm-cloud-rule")
        .assessmentType("automated")
        .assessmentDescription("Check that there is an Activity Tracker event route defined to collect global events generated by IBM Cloud services")
        .parameterCount(Long.valueOf("38"))
        .parameters(java.util.Arrays.asList(parameterInfoModel))
        .build();

      ControlSpecifications controlSpecificationsModel = new ControlSpecifications.Builder()
        .controlSpecificationId("5c7d6f88-a92f-4734-9b49-bd22b0900184")
        .responsibility("user")
        .componentId("iam-identity")
        .componenetName("testString")
        .environment("ibm-cloud")
        .controlSpecificationDescription("IBM cloud")
        .assessmentsCount(Long.valueOf("38"))
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
        .controlParent("")
        .controlTags(java.util.Arrays.asList("1fa45e17-9322-4e6c-bbd6-1c51db08e790"))
        .controlSpecifications(java.util.Arrays.asList(controlSpecificationsModel))
        .controlDocs(controlDocsModel)
        .controlRequirement(true)
        .status("enabled")
        .build();

      ReplaceCustomControlLibraryOptions replaceCustomControlLibraryOptions = new ReplaceCustomControlLibraryOptions.Builder()
        .controlLibrariesId(controlLibraryIdLink)
        .id("testString")
        .accountId(config.get("ACCOUNTID"))
        .controlLibraryName("IBM Cloud for Financial Services")
        .controlLibraryDescription("IBM Cloud for Financial Services")
        .controlLibraryType("custom")
        .controlLibraryVersion("1.1.0")
        .createdOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
        .createdBy("testString")
        .updatedOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
        .updatedBy("testString")
        .latest(true)
        .hierarchyEnabled(true)
        .controlsCount(Long.valueOf("38"))
        .controlParentsCount(Long.valueOf("38"))
        .controls(java.util.Arrays.asList(controlsInControlLibModel))
        .xCorrelationId("testString")
        .xRequestId("testString")
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
  public void testCreateProfile() throws Exception {
    try {
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
        .xCorrelationId("testString")
        .xRequestId("testString")
        .build();

      // Invoke operation
      Response<Profile> response = service.createProfile(createProfileOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      Profile profileResult = response.getResult();

      assertNotNull(profileResult);
      profileIdLink = profileResult.getId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateProfile" })
  public void testListProfiles() throws Exception {
    try {
      ListProfilesOptions listProfilesOptions = new ListProfilesOptions.Builder()
        .xCorrelationId("testString")
        .xRequestId("testString")
        .limit(Long.valueOf("1"))
        .profileType("custom")
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
        .xCorrelationId("testString")
        .xRequestId("testString")
        .limit(Long.valueOf("10"))
        .profileType("custom")
        .build();

      // Test getNext().
      List<ProfileItem> allResults = new ArrayList<>();
      ProfilesPager pager = new ProfilesPager(service, options);
      while (pager.hasNext()) {
        List<ProfileItem> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new ProfilesPager(service, options);
      List<ProfileItem> allItems = pager.getAll();
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
  public void testGetProfile() throws Exception {
    try {
      GetProfileOptions getProfileOptions = new GetProfileOptions.Builder()
        .profilesId(profileIdLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
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
  public void testReplaceProfile() throws Exception {
    try {
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
        .xCorrelationId("testString")
        .xRequestId("testString")
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
  public void testListRules() throws Exception {
    try {
      ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
        .xCorrelationId("testString")
        .xRequestId("testString")
        .type("system_defined")
        .search("testString")
        .serviceName("testString")
        .build();

      // Invoke operation
      Response<RulesPageBase> response = service.listRules(listRulesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      RulesPageBase rulesPageBaseResult = response.getResult();

      assertNotNull(rulesPageBaseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListRules" })
  public void testReplaceRule() throws Exception {
    try {
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
        .description("testString")
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
        .xCorrelationId("testString")
        .xRequestId("testString")
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
  public void testCreateAttachment() throws Exception {
    try {
      PropertyItem propertyScopeId = new PropertyItem.Builder()
      .name("scope_id")
      .value(config.get("ACCOUNTID"))
      .build();  

      PropertyItem propertyScopeType = new PropertyItem.Builder()
      .name("scope_type")
      .value("account")
      .build();


      MultiCloudScope multiCloudScopeModel = new MultiCloudScope.Builder()
        .environment("ibm-cloud")
        .xProperties(java.util.Arrays.asList(propertyScopeId,propertyScopeType))
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
        .id("130003ea8bfa43c5aacea07a86da3000")
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
        .xCorrelationId("testString")
        .xRequestId("testString")
        .build();

      // Invoke operation
      Response<AttachmentPrototype> response = service.createAttachment(createAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      AttachmentPrototype attachmentPrototypeResult = response.getResult();

      assertNotNull(attachmentPrototypeResult);
      attachmentIdLink = attachmentPrototypeResult.attachments().get(0).id();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateAttachment" })
  public void testListAttachments() throws Exception {
    try {
      ListAttachmentsOptions listAttachmentsOptions = new ListAttachmentsOptions.Builder()
        .profilesId(profileIdLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
        .limit(Long.valueOf("1"))
        .build();

      // Invoke operation
      Response<AttachmentCollection> response = service.listAttachments(listAttachmentsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AttachmentCollection attachmentCollectionResult = response.getResult();

      assertNotNull(attachmentCollectionResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListAttachments" })
  public void testListAttachmentsWithPager() throws Exception {
    try {
      ListAttachmentsOptions options = new ListAttachmentsOptions.Builder()
        .profilesId(profileIdLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
        .limit(Long.valueOf("10"))
        .build();

      // Test getNext().
      List<AttachmentItem> allResults = new ArrayList<>();
      AttachmentsPager pager = new AttachmentsPager(service, options);
      while (pager.hasNext()) {
        List<AttachmentItem> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new AttachmentsPager(service, options);
      List<AttachmentItem> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListAttachments" })
  public void testGetProfileAttachment() throws Exception {
    try {
      GetProfileAttachmentOptions getProfileAttachmentOptions = new GetProfileAttachmentOptions.Builder()
        .attachmentId(attachmentIdLink)
        .profilesId(profileIdLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
        .build();

      // Invoke operation
      Response<AttachmentItem> response = service.getProfileAttachment(getProfileAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AttachmentItem attachmentItemResult = response.getResult();

      assertNotNull(attachmentItemResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetProfileAttachment" })
  public void testReplaceProfileAttachment() throws Exception {
    try {
      PropertyItem propertyScopeId = new PropertyItem.Builder()
      .name("scope_id")
      .value(config.get("ACCOUNTID"))
      .build();  

      PropertyItem propertyScopeType = new PropertyItem.Builder()
      .name("scope_type")
      .value("account")
      .build();

      MultiCloudScope multiCloudScopeModel = new MultiCloudScope.Builder()
        .environment("ibm-cloud")
        .xProperties(java.util.Arrays.asList(propertyScopeId,propertyScopeType))
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

      LastScan lastScanModel = new LastScan.Builder()
        .id("e8a39d25-0051-4328-8462-988ad321f49a")
        .status("in_progress")
        .time(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
        .build();

      ReplaceProfileAttachmentOptions replaceProfileAttachmentOptions = new ReplaceProfileAttachmentOptions.Builder()
        .attachmentId(attachmentIdLink)
        .profilesId(profileIdLink)
        .id("testString")
        .profileId(profileIdLink)
        .accountId(config.get("ACCOUNTID"))
        .instanceId(config.get("INSTANCEID"))
        .scope(java.util.Arrays.asList(multiCloudScopeModel))
        .createdOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
        .createdBy("testString")
        .updatedOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
        .updatedBy("testString")
        .status("enabled")
        .schedule("every_30_days")
        .notifications(attachmentsNotificationsPrototypeModel)
        .attachmentParameters(java.util.Arrays.asList(attachmentParameterPrototypeModel))
        .lastScan(lastScanModel)
        .nextScanTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
        .name("account-0d8c3805dfea40aa8ad02265a18eb12b")
        .description("Test description")
        .xCorrelationId("testString")
        .xRequestId("testString")
        .build();

      // Invoke operation
      Response<AttachmentItem> response = service.replaceProfileAttachment(replaceProfileAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AttachmentItem attachmentItemResult = response.getResult();

      assertNotNull(attachmentItemResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testReplaceProfileAttachment" })
  public void testCreateScan() throws Exception {
    try {
      CreateScanOptions createScanOptions = new CreateScanOptions.Builder()
        .attachmentId(config.get("ATTACHMENTID"))
        .xCorrelationId("testString")
        .xRequestId("testString")
        .build();

      // Invoke operation
      Response<Scan> response = service.createScan(createScanOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      Scan scanResult = response.getResult();

      assertNotNull(scanResult);
    } catch (ServiceResponseException e) {
        if(e.getMessage() != null && e.getMessage().contains("Another scan is currently in progress.")){
          return;
        }
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateScan" })
  public void testListAttachmentsAccount() throws Exception {
    try {
      ListAttachmentsAccountOptions listAttachmentsAccountOptions = new ListAttachmentsAccountOptions.Builder()
        .xCorrelationId("testString")
        .xRequestId("testString")
        .limit(Long.valueOf("1"))
        .build();

      // Invoke operation
      Response<AttachmentCollection> response = service.listAttachmentsAccount(listAttachmentsAccountOptions).execute();

      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AttachmentCollection attachmentCollectionResult = response.getResult();

      assertNotNull(attachmentCollectionResult);
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListAttachmentsAccount" })
  public void testListAttachmentsAccountWithPager() throws Exception {
    try {
      ListAttachmentsAccountOptions options = new ListAttachmentsAccountOptions.Builder()
        .xCorrelationId("testString")
        .xRequestId("testString")
        .limit(Long.valueOf("1"))
        .build();

      // Test getNext().
      List<AttachmentItem> allResults = new ArrayList<>();
      AttachmentsAccountPager pager = new AttachmentsAccountPager(service, options);
      if(pager.hasNext()) {
        List<AttachmentItem> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }

      assertNotNull(allResults);
      assertFalse(allResults.isEmpty());

      assertEquals(allResults.size(),1);
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListAttachmentsAccount" })
  public void testListReports() throws Exception {
    try {
      ListReportsOptions listReportsOptions = new ListReportsOptions.Builder()
        .xCorrelationId("testString")
        .xRequestId("testString")
        .attachmentId(attachmentIdForReportLink)
        .groupId(groupIdForReportLink)
        .profileId(profileIdForReportLink)
        .type(typeForReportLink)
        .limit(Long.valueOf("1"))
        .sort("profile_name")
        .build();

      // Invoke operation
      Response<ReportPage> response = service.listReports(listReportsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ReportPage reportPageResult = response.getResult();

      assertNotNull(reportPageResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListReports" })
  public void testListReportsWithPager() throws Exception {
    try {
      ListReportsOptions options = new ListReportsOptions.Builder()
        .xCorrelationId("testString")
        .xRequestId("testString")
        .attachmentId(attachmentIdForReportLink)
        .groupId(groupIdForReportLink)
        .profileId(profileIdForReportLink)
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
        .xCorrelationId("testString")
        .xRequestId("testString")
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
        .reportId(reportIdForReportLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
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
  public void testGetReportEvaluation() throws Exception {
    try {
      GetReportEvaluationOptions getReportEvaluationOptions = new GetReportEvaluationOptions.Builder()
        .reportId(reportIdForReportLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
        .excludeSummary(true)
        .build();

      // Invoke operation
      Response<InputStream> response = service.getReportEvaluation(getReportEvaluationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      InputStream inputStreamResult = response.getResult();

      assertNotNull(inputStreamResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetReportEvaluation" })
  public void testGetReportControls() throws Exception {
    try {
      GetReportControlsOptions getReportControlsOptions = new GetReportControlsOptions.Builder()
        .reportId(reportIdForReportLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
        .controlId("testString")
        .controlName("testString")
        .controlDescription("testString")
        .controlCategory("testString")
        .status("compliant")
        .sort("control_name")
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
  public void testListReportEvaluations() throws Exception {
    try {
      ListReportEvaluationsOptions listReportEvaluationsOptions = new ListReportEvaluationsOptions.Builder()
        .reportId(reportIdForReportLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
        .assessmentId("testString")
        .componentId("testString")
        .targetId("testString")
        .targetName("testString")
        .status("failure")
        .limit(Long.valueOf("1"))
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
        .reportId(reportIdForReportLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
        .status("failure")
        .limit(Long.valueOf("10"))
        .build();

      // Test getNext().
      List<Evaluation> allResults = new ArrayList<>();
      ReportEvaluationsPager pager = new ReportEvaluationsPager(service, options);
      while (pager.hasNext()) {
        List<Evaluation> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }

      // Test getAll();
      pager = new ReportEvaluationsPager(service, options);
      List<Evaluation> allItems = pager.getAll();

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListReportEvaluationsWithPager" })
  public void testListReportResources() throws Exception {
    try {
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
        .limit(Long.valueOf("1"))
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
        .reportId(reportIdForReportLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
        .accountId(accountIdForReportLink)
        .status("compliant")
        .sort("account_id")
        .limit(Long.valueOf("10"))
        .build();

      // Test getNext().
      List<Resource> allResults = new ArrayList<>();
      ReportResourcesPager pager = new ReportResourcesPager(service, options);
      while (pager.hasNext()) {
        List<Resource> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }

      // Test getAll();
      pager = new ReportResourcesPager(service, options);
      List<Resource> allItems = pager.getAll();

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
        .reportId(reportIdForReportLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
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
        .reportId(reportIdForReportLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
        .scanTimeDuration(Long.valueOf("0"))
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
  public void testListProviderTypes() throws Exception {
    try {
      ListProviderTypesOptions listProviderTypesOptions = new ListProviderTypesOptions.Builder()
        .xCorrelationId("testString")
        .xRequestId("testString")
        .build();

      // Invoke operation
      Response<ProviderTypesCollection> response = service.listProviderTypes(listProviderTypesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProviderTypesCollection providerTypesCollectionResult = response.getResult();

      assertNotNull(providerTypesCollectionResult);
      providerTypeIdLink = providerTypesCollectionResult.getProviderTypes().get(0).getId();

      for(ProviderTypeItem providerTypeItem: providerTypesCollectionResult.getProviderTypes()){
        if(providerTypeItem.getName().equals("workload-protection")){
          providerTypeIdLink = providerTypeItem.getId();
          break;
        }
      }

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListProviderTypes" })
  public void testGetProviderTypeById() throws Exception {
    try {
      GetProviderTypeByIdOptions getProviderTypeByIdOptions = new GetProviderTypeByIdOptions.Builder()
        .providerTypeId(providerTypeIdLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
        .build();

      // Invoke operation
      Response<ProviderTypeItem> response = service.getProviderTypeById(getProviderTypeByIdOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProviderTypeItem providerTypeItemResult = response.getResult();

      assertNotNull(providerTypeItemResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetProviderTypeById" })
  public void testListProviderTypeInstances() throws Exception {
    try {
      ListProviderTypeInstancesOptions listProviderTypeInstancesOptions = new ListProviderTypeInstancesOptions.Builder()
        .providerTypeId(providerTypeIdLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
        .build();

      // Invoke operation
      Response<ProviderTypeInstancesResponse> response = service.listProviderTypeInstances(listProviderTypeInstancesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProviderTypeInstancesResponse providerTypeInstancesResponseResult = response.getResult();

      assertNotNull(providerTypeInstancesResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListProviderTypeInstances" })
  public void testCreateProviderTypeInstance() throws Exception {
    try {
      CreateProviderTypeInstanceOptions createProviderTypeInstanceOptions = new CreateProviderTypeInstanceOptions.Builder()
        .providerTypeId(providerTypeIdLink)
        .name("workload-protection-instance-1")
        .attributes(java.util.Collections.singletonMap("wp_crn", "crn:v1:staging:public:sysdig-secure:us-south:a/ff88f007f9ff4622aac4fbc0eda36255:0df4004c-fb74-483b-97be-dd9bd35af4d8::"))
        .xCorrelationId("testString")
        .xRequestId("testString")
        .build();

      // Invoke operation
      Response<ProviderTypeInstanceItem> response = service.createProviderTypeInstance(createProviderTypeInstanceOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      ProviderTypeInstanceItem providerTypeInstanceItemResult = response.getResult();

      assertNotNull(providerTypeInstanceItemResult);
      providerTypeInstanceIdLink = providerTypeInstanceItemResult.getId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateProviderTypeInstance" })
  public void testGetProviderTypeInstance() throws Exception {
    try {
      GetProviderTypeInstanceOptions getProviderTypeInstanceOptions = new GetProviderTypeInstanceOptions.Builder()
        .providerTypeId(providerTypeIdLink)
        .providerTypeInstanceId(providerTypeInstanceIdLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
        .build();

      // Invoke operation
      Response<ProviderTypeInstanceItem> response = service.getProviderTypeInstance(getProviderTypeInstanceOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProviderTypeInstanceItem providerTypeInstanceItemResult = response.getResult();

      assertNotNull(providerTypeInstanceItemResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetProviderTypeInstance" })
  public void testUpdateProviderTypeInstance() throws Exception {
    try {
      UpdateProviderTypeInstanceOptions updateProviderTypeInstanceOptions = new UpdateProviderTypeInstanceOptions.Builder()
        .providerTypeId(providerTypeIdLink)
        .providerTypeInstanceId(providerTypeInstanceIdLink)
        .name("workload-protection-instance-1")
        .attributes(java.util.Collections.singletonMap("wp_crn", "crn:v1:staging:public:sysdig-secure:us-south:a/ff88f007f9ff4622aac4fbc0eda36255:0df4004c-fb74-483b-97be-dd9bd35af4d8::"))
        .xCorrelationId("testString")
        .xRequestId("testString")
        .build();

      // Invoke operation
      Response<ProviderTypeInstanceItem> response = service.updateProviderTypeInstance(updateProviderTypeInstanceOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProviderTypeInstanceItem providerTypeInstanceItemResult = response.getResult();

      assertNotNull(providerTypeInstanceItemResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testUpdateProviderTypeInstance" })
  public void testGetProviderTypesInstances() throws Exception {
    try {
      GetProviderTypesInstancesOptions getProviderTypesInstancesOptions = new GetProviderTypesInstancesOptions.Builder()
        .xCorrelationId("testString")
        .xRequestId("testString")
        .build();

      // Invoke operation
      Response<ProviderTypesInstancesResponse> response = service.getProviderTypesInstances(getProviderTypesInstancesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProviderTypesInstancesResponse providerTypesInstancesResponseResult = response.getResult();

      assertNotNull(providerTypesInstancesResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetProviderTypesInstances" })
  public void testDeleteProfileAttachment() throws Exception {
    try {
      DeleteProfileAttachmentOptions deleteProfileAttachmentOptions = new DeleteProfileAttachmentOptions.Builder()
        .attachmentId(attachmentIdLink)
        .profilesId(profileIdLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
        .build();

      // Invoke operation
      Response<AttachmentItem> response = service.deleteProfileAttachment(deleteProfileAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AttachmentItem attachmentItemResult = response.getResult();

      assertNotNull(attachmentItemResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }


  @Test(dependsOnMethods = { "testDeleteProfileAttachment" })
  public void testDeleteCustomProfile() throws Exception {
    try {
      DeleteCustomProfileOptions deleteCustomProfileOptions = new DeleteCustomProfileOptions.Builder()
        .profilesId(profileIdLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
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
  public void testDeleteCustomControlLibrary() throws Exception {
    try {
      DeleteCustomControlLibraryOptions deleteCustomControlLibraryOptions = new DeleteCustomControlLibraryOptions.Builder()
        .controlLibrariesId(controlLibraryIdLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
        .build();

      // Invoke operation
      Response<ControlLibraryDelete> response = service.deleteCustomControlLibrary(deleteCustomControlLibraryOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ControlLibraryDelete controlLibraryDeleteResult = response.getResult();

      assertNotNull(controlLibraryDeleteResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteCustomControlLibrary" })
  public void testDeleteRule() throws Exception {
    try {
      DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
        .ruleId(ruleIdLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
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

  
  @Test(dependsOnMethods = { "testDeleteProfileAttachment" })
  public void testDeleteProviderTypeInstance() throws Exception {
    try {
      DeleteProviderTypeInstanceOptions deleteProviderTypeInstanceOptions = new DeleteProviderTypeInstanceOptions.Builder()
        .providerTypeId(providerTypeIdLink)
        .providerTypeInstanceId(providerTypeInstanceIdLink)
        .xCorrelationId("testString")
        .xRequestId("testString")
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

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
