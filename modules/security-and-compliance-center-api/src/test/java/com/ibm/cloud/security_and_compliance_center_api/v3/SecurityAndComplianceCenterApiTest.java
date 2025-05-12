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
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.security_and_compliance_center_api.v3.SecurityAndComplianceCenterApi;
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
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SecurityAndComplianceCenterApi service.
 */
public class SecurityAndComplianceCenterApiTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected SecurityAndComplianceCenterApi securityAndComplianceCenterApiService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new SecurityAndComplianceCenterApi(serviceName, null);
  }

  // Test the getServiceUrlForRegion() method
  @Test
  public void testGetServiceUrlForRegion() throws Throwable {
    assertNull(SecurityAndComplianceCenterApi.getServiceUrlForRegion("INVALID_REGION"));
    assertEquals(SecurityAndComplianceCenterApi.getServiceUrlForRegion("us-south"), "https://us-south.compliance.cloud.ibm.com");
    assertEquals(SecurityAndComplianceCenterApi.getServiceUrlForRegion("eu-de"), "https://eu-de.compliance.cloud.ibm.com");
    assertEquals(SecurityAndComplianceCenterApi.getServiceUrlForRegion("eu-fr2"), "https://eu-fr2.compliance.cloud.ibm.com");
    assertEquals(SecurityAndComplianceCenterApi.getServiceUrlForRegion("ca-tor"), "https://ca-tor.compliance.cloud.ibm.com");
    assertEquals(SecurityAndComplianceCenterApi.getServiceUrlForRegion("au-syd"), "https://au-syd.compliance.cloud.ibm.com");
    assertEquals(SecurityAndComplianceCenterApi.getServiceUrlForRegion("eu-es"), "https://eu-es.compliance.cloud.ibm.com");
  }

  // Test the getSettings operation with a valid options model parameter
  @Test
  public void testGetSettingsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"event_notifications\": {\"instance_crn\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/ff88f007f9ff4622aac4fbc0eda36255:7199ae60-a214-4dd8-9bf7-ce571de49d01::\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"source_id\": \"crn:v1:bluemix:public:event-notifications:us-south:a/ff88f007f9ff4622aac4fbc0eda36255:b8b07245-0bbe-4478-b11c-0dce523105fd::\", \"source_description\": \"This source is used for integration with IBM Cloud Security and Compliance Center.\", \"source_name\": \"compliance\"}, \"object_storage\": {\"instance_crn\": \"instanceCrn\", \"bucket\": \"bucket\", \"bucket_location\": \"bucketLocation\", \"bucket_endpoint\": \"bucketEndpoint\", \"updated_on\": \"2019-01-01T12:00:00.000Z\"}}";
    String getSettingsPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/settings";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSettingsOptions model
    GetSettingsOptions getSettingsOptionsModel = new GetSettingsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .build();

    // Invoke getSettings() with a valid options model and verify the result
    Response<Settings> response = securityAndComplianceCenterApiService.getSettings(getSettingsOptionsModel).execute();
    assertNotNull(response);
    Settings responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSettingsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getSettings operation with and without retries enabled
  @Test
  public void testGetSettingsWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetSettingsWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetSettingsWOptions();
  }

  // Test the getSettings operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSettingsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getSettings(null).execute();
  }

  // Test the updateSettings operation with a valid options model parameter
  @Test
  public void testUpdateSettingsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"event_notifications\": {\"instance_crn\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/ff88f007f9ff4622aac4fbc0eda36255:7199ae60-a214-4dd8-9bf7-ce571de49d01::\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"source_id\": \"crn:v1:bluemix:public:event-notifications:us-south:a/ff88f007f9ff4622aac4fbc0eda36255:b8b07245-0bbe-4478-b11c-0dce523105fd::\", \"source_description\": \"This source is used for integration with IBM Cloud Security and Compliance Center.\", \"source_name\": \"compliance\"}, \"object_storage\": {\"instance_crn\": \"instanceCrn\", \"bucket\": \"bucket\", \"bucket_location\": \"bucketLocation\", \"bucket_endpoint\": \"bucketEndpoint\", \"updated_on\": \"2019-01-01T12:00:00.000Z\"}}";
    String updateSettingsPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/settings";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ObjectStoragePrototype model
    ObjectStoragePrototype objectStoragePrototypeModel = new ObjectStoragePrototype.Builder()
      .bucket("px-scan-results")
      .instanceCrn("crn:v1:staging:public:cloud-object-storage:global:a/ff88f007f9ff4622aac4fbc0eda36255:7199ae60-a214-4dd8-9bf7-ce571de49d01::")
      .build();

    // Construct an instance of the EventNotificationsPrototype model
    EventNotificationsPrototype eventNotificationsPrototypeModel = new EventNotificationsPrototype.Builder()
      .instanceCrn("crn:v1:staging:public:event-notifications:us-south:a/ff88f007f9ff4622aac4fbc0eda36255:b8b07245-0bbe-4478-b11c-0dce523105fd::")
      .sourceDescription("This source is used for integration with IBM Cloud Security and Compliance Center.")
      .sourceName("scc-sdk-integration")
      .build();

    // Construct an instance of the UpdateSettingsOptions model
    UpdateSettingsOptions updateSettingsOptionsModel = new UpdateSettingsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .objectStorage(objectStoragePrototypeModel)
      .eventNotifications(eventNotificationsPrototypeModel)
      .build();

    // Invoke updateSettings() with a valid options model and verify the result
    Response<Settings> response = securityAndComplianceCenterApiService.updateSettings(updateSettingsOptionsModel).execute();
    assertNotNull(response);
    Settings responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateSettingsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateSettings operation with and without retries enabled
  @Test
  public void testUpdateSettingsWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testUpdateSettingsWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testUpdateSettingsWOptions();
  }

  // Test the updateSettings operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateSettingsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.updateSettings(null).execute();
  }

  // Test the postTestEvent operation with a valid options model parameter
  @Test
  public void testPostTestEventWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"success\": false}";
    String postTestEventPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/test_event";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the PostTestEventOptions model
    PostTestEventOptions postTestEventOptionsModel = new PostTestEventOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .build();

    // Invoke postTestEvent() with a valid options model and verify the result
    Response<TestEvent> response = securityAndComplianceCenterApiService.postTestEvent(postTestEventOptionsModel).execute();
    assertNotNull(response);
    TestEvent responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postTestEventPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the postTestEvent operation with and without retries enabled
  @Test
  public void testPostTestEventWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testPostTestEventWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testPostTestEventWOptions();
  }

  // Test the postTestEvent operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostTestEventNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.postTestEvent(null).execute();
  }

  // Test the listInstanceAttachments operation with a valid options model parameter
  @Test
  public void testListInstanceAttachmentsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 50, \"total_count\": 230, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"attachments\": [{\"attachment_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}], \"description\": \"description\", \"name\": \"name\", \"notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 15, \"failed_control_ids\": [\"failedControlIds\"]}}, \"schedule\": \"daily\", \"scope\": [{\"id\": \"id\"}], \"status\": \"enabled\", \"data_selection_range\": {\"start_date\": \"2025-02-28T05:42:58.000Z\", \"end_date\": \"2025-02-28T05:42:58.000Z\"}, \"account_id\": \"accountId\", \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"id\": \"id\", \"instance_id\": \"instanceId\", \"last_scan\": {\"id\": \"id\", \"status\": \"status\", \"time\": \"2019-01-01T12:00:00.000Z\"}, \"next_scan_time\": \"2019-01-01T12:00:00.000Z\", \"profile_id\": \"profileId\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\"}]}";
    String listInstanceAttachmentsPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/attachments";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListInstanceAttachmentsOptions model
    ListInstanceAttachmentsOptions listInstanceAttachmentsOptionsModel = new ListInstanceAttachmentsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .accountId("testString")
      .versionGroupLabel("6702d85a-6437-4d6f-8701-c0146648787b")
      .limit(Long.valueOf("10"))
      .sort("created_on")
      .direction("desc")
      .start("testString")
      .build();

    // Invoke listInstanceAttachments() with a valid options model and verify the result
    Response<ProfileAttachmentCollection> response = securityAndComplianceCenterApiService.listInstanceAttachments(listInstanceAttachmentsOptionsModel).execute();
    assertNotNull(response);
    ProfileAttachmentCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listInstanceAttachmentsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("version_group_label"), "6702d85a-6437-4d6f-8701-c0146648787b");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("sort"), "created_on");
    assertEquals(query.get("direction"), "desc");
    assertEquals(query.get("start"), "testString");
  }

  // Test the listInstanceAttachments operation with and without retries enabled
  @Test
  public void testListInstanceAttachmentsWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListInstanceAttachmentsWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListInstanceAttachmentsWOptions();
  }

  // Test the listInstanceAttachments operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListInstanceAttachmentsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.listInstanceAttachments(null).execute();
  }

  // Test the listInstanceAttachments operation using the InstanceAttachmentsPager.getNext() method
  @Test
  public void testListInstanceAttachmentsWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"attachments\":[{\"attachment_parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}],\"description\":\"description\",\"name\":\"name\",\"notifications\":{\"enabled\":false,\"controls\":{\"threshold_limit\":15,\"failed_control_ids\":[\"failedControlIds\"]}},\"schedule\":\"daily\",\"scope\":[{\"id\":\"id\"}],\"status\":\"enabled\",\"data_selection_range\":{\"start_date\":\"2025-02-28T05:42:58.000Z\",\"end_date\":\"2025-02-28T05:42:58.000Z\"},\"account_id\":\"accountId\",\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"id\":\"id\",\"instance_id\":\"instanceId\",\"last_scan\":{\"id\":\"id\",\"status\":\"status\",\"time\":\"2019-01-01T12:00:00.000Z\"},\"next_scan_time\":\"2019-01-01T12:00:00.000Z\",\"profile_id\":\"profileId\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\"}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"attachments\":[{\"attachment_parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}],\"description\":\"description\",\"name\":\"name\",\"notifications\":{\"enabled\":false,\"controls\":{\"threshold_limit\":15,\"failed_control_ids\":[\"failedControlIds\"]}},\"schedule\":\"daily\",\"scope\":[{\"id\":\"id\"}],\"status\":\"enabled\",\"data_selection_range\":{\"start_date\":\"2025-02-28T05:42:58.000Z\",\"end_date\":\"2025-02-28T05:42:58.000Z\"},\"account_id\":\"accountId\",\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"id\":\"id\",\"instance_id\":\"instanceId\",\"last_scan\":{\"id\":\"id\",\"status\":\"status\",\"time\":\"2019-01-01T12:00:00.000Z\"},\"next_scan_time\":\"2019-01-01T12:00:00.000Z\",\"profile_id\":\"profileId\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\"}],\"total_count\":2,\"limit\":1}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListInstanceAttachmentsOptions listInstanceAttachmentsOptions = new ListInstanceAttachmentsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .accountId("testString")
      .versionGroupLabel("6702d85a-6437-4d6f-8701-c0146648787b")
      .limit(Long.valueOf("10"))
      .sort("created_on")
      .direction("desc")
      .build();

    List<ProfileAttachment> allResults = new ArrayList<>();
    InstanceAttachmentsPager pager = new InstanceAttachmentsPager(securityAndComplianceCenterApiService, listInstanceAttachmentsOptions);
    while (pager.hasNext()) {
      List<ProfileAttachment> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listInstanceAttachments operation using the InstanceAttachmentsPager.getAll() method
  @Test
  public void testListInstanceAttachmentsWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"attachments\":[{\"attachment_parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}],\"description\":\"description\",\"name\":\"name\",\"notifications\":{\"enabled\":false,\"controls\":{\"threshold_limit\":15,\"failed_control_ids\":[\"failedControlIds\"]}},\"schedule\":\"daily\",\"scope\":[{\"id\":\"id\"}],\"status\":\"enabled\",\"data_selection_range\":{\"start_date\":\"2025-02-28T05:42:58.000Z\",\"end_date\":\"2025-02-28T05:42:58.000Z\"},\"account_id\":\"accountId\",\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"id\":\"id\",\"instance_id\":\"instanceId\",\"last_scan\":{\"id\":\"id\",\"status\":\"status\",\"time\":\"2019-01-01T12:00:00.000Z\"},\"next_scan_time\":\"2019-01-01T12:00:00.000Z\",\"profile_id\":\"profileId\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\"}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"attachments\":[{\"attachment_parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}],\"description\":\"description\",\"name\":\"name\",\"notifications\":{\"enabled\":false,\"controls\":{\"threshold_limit\":15,\"failed_control_ids\":[\"failedControlIds\"]}},\"schedule\":\"daily\",\"scope\":[{\"id\":\"id\"}],\"status\":\"enabled\",\"data_selection_range\":{\"start_date\":\"2025-02-28T05:42:58.000Z\",\"end_date\":\"2025-02-28T05:42:58.000Z\"},\"account_id\":\"accountId\",\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"id\":\"id\",\"instance_id\":\"instanceId\",\"last_scan\":{\"id\":\"id\",\"status\":\"status\",\"time\":\"2019-01-01T12:00:00.000Z\"},\"next_scan_time\":\"2019-01-01T12:00:00.000Z\",\"profile_id\":\"profileId\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\"}],\"total_count\":2,\"limit\":1}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListInstanceAttachmentsOptions listInstanceAttachmentsOptions = new ListInstanceAttachmentsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .accountId("testString")
      .versionGroupLabel("6702d85a-6437-4d6f-8701-c0146648787b")
      .limit(Long.valueOf("10"))
      .sort("created_on")
      .direction("desc")
      .build();

    InstanceAttachmentsPager pager = new InstanceAttachmentsPager(securityAndComplianceCenterApiService, listInstanceAttachmentsOptions);
    List<ProfileAttachment> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the createProfileAttachment operation with a valid options model parameter
  @Test
  public void testCreateProfileAttachmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"profile_id\": \"profileId\", \"attachments\": [{\"attachment_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}], \"description\": \"description\", \"name\": \"name\", \"notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 15, \"failed_control_ids\": [\"failedControlIds\"]}}, \"schedule\": \"daily\", \"scope\": [{\"id\": \"id\"}], \"status\": \"enabled\", \"data_selection_range\": {\"start_date\": \"2025-02-28T05:42:58.000Z\", \"end_date\": \"2025-02-28T05:42:58.000Z\"}, \"account_id\": \"accountId\", \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"id\": \"id\", \"instance_id\": \"instanceId\", \"last_scan\": {\"id\": \"id\", \"status\": \"status\", \"time\": \"2019-01-01T12:00:00.000Z\"}, \"next_scan_time\": \"2019-01-01T12:00:00.000Z\", \"profile_id\": \"profileId\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\"}]}";
    String createProfileAttachmentPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/profiles/9c265b4a-4cdf-47f1-acd3-17b5808f7f3f/attachments";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the Parameter model
    Parameter parameterModel = new Parameter.Builder()
      .assessmentType("automated")
      .assessmentId("rule-e16fcfea-fe21-4d30-a721-423611481fea")
      .parameterName("tls_version")
      .parameterDisplayName("IBM Cloud Internet Services TLS version")
      .parameterType("string_list")
      .parameterValue("[\"1.2\", \"1.3\"]")
      .build();

    // Construct an instance of the AttachmentNotificationsControls model
    AttachmentNotificationsControls attachmentNotificationsControlsModel = new AttachmentNotificationsControls.Builder()
      .thresholdLimit(Long.valueOf("15"))
      .failedControlIds(java.util.Arrays.asList())
      .build();

    // Construct an instance of the AttachmentNotifications model
    AttachmentNotifications attachmentNotificationsModel = new AttachmentNotifications.Builder()
      .enabled(true)
      .controls(attachmentNotificationsControlsModel)
      .build();

    // Construct an instance of the MultiCloudScopePayloadById model
    MultiCloudScopePayloadById multiCloudScopePayloadModel = new MultiCloudScopePayloadById.Builder()
      .id("8baad3b5-2e69-4027-9967-efac19508e1c")
      .build();

    // Construct an instance of the DateRange model
    DateRange dateRangeModel = new DateRange.Builder()
      .startDate(DateUtils.parseAsDateTime("2025-02-28T05:42:58.000Z"))
      .endDate(DateUtils.parseAsDateTime("2025-02-28T05:42:58.000Z"))
      .build();

    // Construct an instance of the ProfileAttachmentBase model
    ProfileAttachmentBase profileAttachmentBaseModel = new ProfileAttachmentBase.Builder()
      .attachmentParameters(java.util.Arrays.asList(parameterModel))
      .description("This is a profile attachment targeting IBM CIS Foundation using a SDK")
      .name("Profile Attachment for IBM CIS Foundation SDK test")
      .notifications(attachmentNotificationsModel)
      .schedule("daily")
      .scope(java.util.Arrays.asList(multiCloudScopePayloadModel))
      .status("disabled")
      .dataSelectionRange(dateRangeModel)
      .build();

    // Construct an instance of the CreateProfileAttachmentOptions model
    CreateProfileAttachmentOptions createProfileAttachmentOptionsModel = new CreateProfileAttachmentOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
      .newAttachments(java.util.Arrays.asList(profileAttachmentBaseModel))
      .newProfileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3")
      .accountId("testString")
      .build();

    // Invoke createProfileAttachment() with a valid options model and verify the result
    Response<ProfileAttachmentResponse> response = securityAndComplianceCenterApiService.createProfileAttachment(createProfileAttachmentOptionsModel).execute();
    assertNotNull(response);
    ProfileAttachmentResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createProfileAttachmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the createProfileAttachment operation with and without retries enabled
  @Test
  public void testCreateProfileAttachmentWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testCreateProfileAttachmentWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testCreateProfileAttachmentWOptions();
  }

  // Test the createProfileAttachment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateProfileAttachmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.createProfileAttachment(null).execute();
  }

  // Test the getProfileAttachment operation with a valid options model parameter
  @Test
  public void testGetProfileAttachmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"attachment_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}], \"description\": \"description\", \"name\": \"name\", \"notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 15, \"failed_control_ids\": [\"failedControlIds\"]}}, \"schedule\": \"daily\", \"scope\": [{\"id\": \"id\"}], \"status\": \"enabled\", \"data_selection_range\": {\"start_date\": \"2025-02-28T05:42:58.000Z\", \"end_date\": \"2025-02-28T05:42:58.000Z\"}, \"account_id\": \"accountId\", \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"id\": \"id\", \"instance_id\": \"instanceId\", \"last_scan\": {\"id\": \"id\", \"status\": \"status\", \"time\": \"2019-01-01T12:00:00.000Z\"}, \"next_scan_time\": \"2019-01-01T12:00:00.000Z\", \"profile_id\": \"profileId\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\"}";
    String getProfileAttachmentPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/profiles/9c265b4a-4cdf-47f1-acd3-17b5808f7f3f/attachments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetProfileAttachmentOptions model
    GetProfileAttachmentOptions getProfileAttachmentOptionsModel = new GetProfileAttachmentOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
      .attachmentId("testString")
      .accountId("testString")
      .build();

    // Invoke getProfileAttachment() with a valid options model and verify the result
    Response<ProfileAttachment> response = securityAndComplianceCenterApiService.getProfileAttachment(getProfileAttachmentOptionsModel).execute();
    assertNotNull(response);
    ProfileAttachment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getProfileAttachmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the getProfileAttachment operation with and without retries enabled
  @Test
  public void testGetProfileAttachmentWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetProfileAttachmentWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetProfileAttachmentWOptions();
  }

  // Test the getProfileAttachment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetProfileAttachmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getProfileAttachment(null).execute();
  }

  // Test the replaceProfileAttachment operation with a valid options model parameter
  @Test
  public void testReplaceProfileAttachmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"attachment_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}], \"description\": \"description\", \"name\": \"name\", \"notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 15, \"failed_control_ids\": [\"failedControlIds\"]}}, \"schedule\": \"daily\", \"scope\": [{\"id\": \"id\"}], \"status\": \"enabled\", \"data_selection_range\": {\"start_date\": \"2025-02-28T05:42:58.000Z\", \"end_date\": \"2025-02-28T05:42:58.000Z\"}, \"account_id\": \"accountId\", \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"id\": \"id\", \"instance_id\": \"instanceId\", \"last_scan\": {\"id\": \"id\", \"status\": \"status\", \"time\": \"2019-01-01T12:00:00.000Z\"}, \"next_scan_time\": \"2019-01-01T12:00:00.000Z\", \"profile_id\": \"profileId\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\"}";
    String replaceProfileAttachmentPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/profiles/9c265b4a-4cdf-47f1-acd3-17b5808f7f3f/attachments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the Parameter model
    Parameter parameterModel = new Parameter.Builder()
      .assessmentType("testString")
      .assessmentId("testString")
      .parameterName("location")
      .parameterDisplayName("Location")
      .parameterType("string")
      .parameterValue("testString")
      .build();

    // Construct an instance of the AttachmentNotificationsControls model
    AttachmentNotificationsControls attachmentNotificationsControlsModel = new AttachmentNotificationsControls.Builder()
      .thresholdLimit(Long.valueOf("15"))
      .failedControlIds(java.util.Arrays.asList("testString"))
      .build();

    // Construct an instance of the AttachmentNotifications model
    AttachmentNotifications attachmentNotificationsModel = new AttachmentNotifications.Builder()
      .enabled(true)
      .controls(attachmentNotificationsControlsModel)
      .build();

    // Construct an instance of the MultiCloudScopePayloadById model
    MultiCloudScopePayloadById multiCloudScopePayloadModel = new MultiCloudScopePayloadById.Builder()
      .id("testString")
      .build();

    // Construct an instance of the DateRange model
    DateRange dateRangeModel = new DateRange.Builder()
      .startDate(DateUtils.parseAsDateTime("2025-02-28T05:42:58.000Z"))
      .endDate(DateUtils.parseAsDateTime("2025-02-28T05:42:58.000Z"))
      .build();

    // Construct an instance of the ReplaceProfileAttachmentOptions model
    ReplaceProfileAttachmentOptions replaceProfileAttachmentOptionsModel = new ReplaceProfileAttachmentOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
      .attachmentId("testString")
      .attachmentParameters(java.util.Arrays.asList(parameterModel))
      .description("testString")
      .name("testString")
      .notifications(attachmentNotificationsModel)
      .schedule("daily")
      .scope(java.util.Arrays.asList(multiCloudScopePayloadModel))
      .status("enabled")
      .dataSelectionRange(dateRangeModel)
      .accountId("testString")
      .build();

    // Invoke replaceProfileAttachment() with a valid options model and verify the result
    Response<ProfileAttachment> response = securityAndComplianceCenterApiService.replaceProfileAttachment(replaceProfileAttachmentOptionsModel).execute();
    assertNotNull(response);
    ProfileAttachment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceProfileAttachmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the replaceProfileAttachment operation with and without retries enabled
  @Test
  public void testReplaceProfileAttachmentWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testReplaceProfileAttachmentWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testReplaceProfileAttachmentWOptions();
  }

  // Test the replaceProfileAttachment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceProfileAttachmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.replaceProfileAttachment(null).execute();
  }

  // Test the deleteProfileAttachment operation with a valid options model parameter
  @Test
  public void testDeleteProfileAttachmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"attachment_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}], \"description\": \"description\", \"name\": \"name\", \"notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 15, \"failed_control_ids\": [\"failedControlIds\"]}}, \"schedule\": \"daily\", \"scope\": [{\"id\": \"id\"}], \"status\": \"enabled\", \"data_selection_range\": {\"start_date\": \"2025-02-28T05:42:58.000Z\", \"end_date\": \"2025-02-28T05:42:58.000Z\"}, \"account_id\": \"accountId\", \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"id\": \"id\", \"instance_id\": \"instanceId\", \"last_scan\": {\"id\": \"id\", \"status\": \"status\", \"time\": \"2019-01-01T12:00:00.000Z\"}, \"next_scan_time\": \"2019-01-01T12:00:00.000Z\", \"profile_id\": \"profileId\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\"}";
    String deleteProfileAttachmentPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/profiles/9c265b4a-4cdf-47f1-acd3-17b5808f7f3f/attachments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteProfileAttachmentOptions model
    DeleteProfileAttachmentOptions deleteProfileAttachmentOptionsModel = new DeleteProfileAttachmentOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
      .attachmentId("testString")
      .accountId("testString")
      .build();

    // Invoke deleteProfileAttachment() with a valid options model and verify the result
    Response<ProfileAttachment> response = securityAndComplianceCenterApiService.deleteProfileAttachment(deleteProfileAttachmentOptionsModel).execute();
    assertNotNull(response);
    ProfileAttachment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteProfileAttachmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the deleteProfileAttachment operation with and without retries enabled
  @Test
  public void testDeleteProfileAttachmentWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testDeleteProfileAttachmentWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testDeleteProfileAttachmentWOptions();
  }

  // Test the deleteProfileAttachment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteProfileAttachmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.deleteProfileAttachment(null).execute();
  }

  // Test the upgradeAttachment operation with a valid options model parameter
  @Test
  public void testUpgradeAttachmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"attachment_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}], \"description\": \"description\", \"name\": \"name\", \"notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 15, \"failed_control_ids\": [\"failedControlIds\"]}}, \"schedule\": \"daily\", \"scope\": [{\"id\": \"id\"}], \"status\": \"enabled\", \"data_selection_range\": {\"start_date\": \"2025-02-28T05:42:58.000Z\", \"end_date\": \"2025-02-28T05:42:58.000Z\"}, \"account_id\": \"accountId\", \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"id\": \"id\", \"instance_id\": \"instanceId\", \"last_scan\": {\"id\": \"id\", \"status\": \"status\", \"time\": \"2019-01-01T12:00:00.000Z\"}, \"next_scan_time\": \"2019-01-01T12:00:00.000Z\", \"profile_id\": \"profileId\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\"}";
    String upgradeAttachmentPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/profiles/9c265b4a-4cdf-47f1-acd3-17b5808f7f3f/attachments/testString/upgrade";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the Parameter model
    Parameter parameterModel = new Parameter.Builder()
      .assessmentType("testString")
      .assessmentId("testString")
      .parameterName("location")
      .parameterDisplayName("Location")
      .parameterType("string")
      .parameterValue("testString")
      .build();

    // Construct an instance of the UpgradeAttachmentOptions model
    UpgradeAttachmentOptions upgradeAttachmentOptionsModel = new UpgradeAttachmentOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
      .attachmentId("testString")
      .attachmentParameters(java.util.Arrays.asList(parameterModel))
      .accountId("testString")
      .build();

    // Invoke upgradeAttachment() with a valid options model and verify the result
    Response<ProfileAttachment> response = securityAndComplianceCenterApiService.upgradeAttachment(upgradeAttachmentOptionsModel).execute();
    assertNotNull(response);
    ProfileAttachment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, upgradeAttachmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the upgradeAttachment operation with and without retries enabled
  @Test
  public void testUpgradeAttachmentWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testUpgradeAttachmentWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testUpgradeAttachmentWOptions();
  }

  // Test the upgradeAttachment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpgradeAttachmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.upgradeAttachment(null).execute();
  }

  // Test the createScan operation with a valid options model parameter
  @Test
  public void testCreateScanWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"account_id\": \"accountId\", \"attachment_id\": \"attachmentId\", \"report_id\": \"reportId\", \"status\": \"status\", \"last_scan_time\": \"2019-01-01T12:00:00.000Z\", \"next_scan_time\": \"2019-01-01T12:00:00.000Z\", \"scan_type\": \"scanType\", \"occurence\": 9}";
    String createScanPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/scans";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateScanOptions model
    CreateScanOptions createScanOptionsModel = new CreateScanOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .attachmentId("4deb572c-9f37-4126-9cc0-d550672533cb")
      .accountId("testString")
      .build();

    // Invoke createScan() with a valid options model and verify the result
    Response<CreateScanResponse> response = securityAndComplianceCenterApiService.createScan(createScanOptionsModel).execute();
    assertNotNull(response);
    CreateScanResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createScanPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the createScan operation with and without retries enabled
  @Test
  public void testCreateScanWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testCreateScanWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testCreateScanWOptions();
  }

  // Test the createScan operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateScanNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.createScan(null).execute();
  }

  // Test the createControlLibrary operation with a valid options model parameter
  @Test
  public void testCreateControlLibraryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"control_library_name\": \"controlLibraryName\", \"control_library_description\": \"controlLibraryDescription\", \"control_library_type\": \"custom\", \"control_library_version\": \"controlLibraryVersion\", \"controls\": [{\"control_name\": \"controlName\", \"control_id\": \"controlId\", \"control_description\": \"controlDescription\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_severity\": \"controlSeverity\", \"control_tags\": [\"controlTags\"], \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"responsibility\", \"component_id\": \"componentId\", \"component_name\": \"componentName\", \"component_type\": \"componentType\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}], \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"status\": \"status\"}], \"id\": \"id\", \"account_id\": \"accountId\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"hierarchy_enabled\": true, \"controls_count\": 13, \"control_parents_count\": 19}";
    String createControlLibraryPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/control_libraries";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the AssessmentPrototype model
    AssessmentPrototype assessmentPrototypeModel = new AssessmentPrototype.Builder()
      .assessmentId("rule-d1bd9f3f-bee1-46c5-9533-da8bba9eed4e")
      .assessmentDescription("This rule will check on regulation")
      .build();

    // Construct an instance of the ControlSpecificationPrototype model
    ControlSpecificationPrototype controlSpecificationPrototypeModel = new ControlSpecificationPrototype.Builder()
      .componentId("apprapp")
      .environment("ibm-cloud")
      .controlSpecificationId("testString")
      .controlSpecificationDescription("This field is used to describe a control specification")
      .assessments(java.util.Arrays.asList(assessmentPrototypeModel))
      .build();

    // Construct an instance of the ControlDoc model
    ControlDoc controlDocModel = new ControlDoc.Builder()
      .controlDocsId("testString")
      .controlDocsType("testString")
      .build();

    // Construct an instance of the ControlPrototype model
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

    // Construct an instance of the CreateControlLibraryOptions model
    CreateControlLibraryOptions createControlLibraryOptionsModel = new CreateControlLibraryOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .controlLibraryName("custom control library from SDK")
      .controlLibraryDescription("This is a custom control library made from the SDK test framework")
      .controlLibraryType("custom")
      .controlLibraryVersion("0.0.1")
      .controls(java.util.Arrays.asList(controlPrototypeModel))
      .accountId("testString")
      .build();

    // Invoke createControlLibrary() with a valid options model and verify the result
    Response<ControlLibrary> response = securityAndComplianceCenterApiService.createControlLibrary(createControlLibraryOptionsModel).execute();
    assertNotNull(response);
    ControlLibrary responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createControlLibraryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the createControlLibrary operation with and without retries enabled
  @Test
  public void testCreateControlLibraryWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testCreateControlLibraryWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testCreateControlLibraryWOptions();
  }

  // Test the createControlLibrary operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateControlLibraryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.createControlLibrary(null).execute();
  }

  // Test the listControlLibraries operation with a valid options model parameter
  @Test
  public void testListControlLibrariesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 50, \"total_count\": 230, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"control_libraries\": [{\"control_library_name\": \"controlLibraryName\", \"control_library_description\": \"controlLibraryDescription\", \"control_library_type\": \"custom\", \"control_library_version\": \"controlLibraryVersion\", \"controls\": [{\"control_name\": \"controlName\", \"control_id\": \"controlId\", \"control_description\": \"controlDescription\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_severity\": \"controlSeverity\", \"control_tags\": [\"controlTags\"], \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"responsibility\", \"component_id\": \"componentId\", \"component_name\": \"componentName\", \"component_type\": \"componentType\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}], \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"status\": \"status\"}], \"id\": \"id\", \"account_id\": \"accountId\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"hierarchy_enabled\": true, \"controls_count\": 13, \"control_parents_count\": 19}]}";
    String listControlLibrariesPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/control_libraries";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListControlLibrariesOptions model
    ListControlLibrariesOptions listControlLibrariesOptionsModel = new ListControlLibrariesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .accountId("testString")
      .limit(Long.valueOf("10"))
      .start("testString")
      .build();

    // Invoke listControlLibraries() with a valid options model and verify the result
    Response<ControlLibraryCollection> response = securityAndComplianceCenterApiService.listControlLibraries(listControlLibrariesOptionsModel).execute();
    assertNotNull(response);
    ControlLibraryCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listControlLibrariesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
  }

  // Test the listControlLibraries operation with and without retries enabled
  @Test
  public void testListControlLibrariesWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListControlLibrariesWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListControlLibrariesWOptions();
  }

  // Test the listControlLibraries operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListControlLibrariesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.listControlLibraries(null).execute();
  }

  // Test the listControlLibraries operation using the ControlLibrariesPager.getNext() method
  @Test
  public void testListControlLibrariesWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"control_libraries\":[{\"control_library_name\":\"controlLibraryName\",\"control_library_description\":\"controlLibraryDescription\",\"control_library_type\":\"custom\",\"control_library_version\":\"controlLibraryVersion\",\"controls\":[{\"control_name\":\"controlName\",\"control_id\":\"controlId\",\"control_description\":\"controlDescription\",\"control_category\":\"controlCategory\",\"control_parent\":\"controlParent\",\"control_severity\":\"controlSeverity\",\"control_tags\":[\"controlTags\"],\"control_specifications\":[{\"id\":\"id\",\"responsibility\":\"responsibility\",\"component_id\":\"componentId\",\"component_name\":\"componentName\",\"component_type\":\"componentType\",\"environment\":\"environment\",\"description\":\"description\",\"assessments_count\":16,\"assessments\":[{\"assessment_id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"assessment_type\":\"ibm-cloud-rule\",\"assessment_method\":\"ibm-cloud-rule\",\"assessment_description\":\"Check whether Cloud Object Storage is accessible only by using private endpoints\",\"parameter_count\":1,\"parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}]}]}],\"control_docs\":{\"control_docs_id\":\"controlDocsId\",\"control_docs_type\":\"controlDocsType\"},\"status\":\"status\"}],\"id\":\"id\",\"account_id\":\"accountId\",\"version_group_label\":\"versionGroupLabel\",\"latest\":true,\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"hierarchy_enabled\":true,\"controls_count\":13,\"control_parents_count\":19}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"control_libraries\":[{\"control_library_name\":\"controlLibraryName\",\"control_library_description\":\"controlLibraryDescription\",\"control_library_type\":\"custom\",\"control_library_version\":\"controlLibraryVersion\",\"controls\":[{\"control_name\":\"controlName\",\"control_id\":\"controlId\",\"control_description\":\"controlDescription\",\"control_category\":\"controlCategory\",\"control_parent\":\"controlParent\",\"control_severity\":\"controlSeverity\",\"control_tags\":[\"controlTags\"],\"control_specifications\":[{\"id\":\"id\",\"responsibility\":\"responsibility\",\"component_id\":\"componentId\",\"component_name\":\"componentName\",\"component_type\":\"componentType\",\"environment\":\"environment\",\"description\":\"description\",\"assessments_count\":16,\"assessments\":[{\"assessment_id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"assessment_type\":\"ibm-cloud-rule\",\"assessment_method\":\"ibm-cloud-rule\",\"assessment_description\":\"Check whether Cloud Object Storage is accessible only by using private endpoints\",\"parameter_count\":1,\"parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}]}]}],\"control_docs\":{\"control_docs_id\":\"controlDocsId\",\"control_docs_type\":\"controlDocsType\"},\"status\":\"status\"}],\"id\":\"id\",\"account_id\":\"accountId\",\"version_group_label\":\"versionGroupLabel\",\"latest\":true,\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"hierarchy_enabled\":true,\"controls_count\":13,\"control_parents_count\":19}],\"total_count\":2,\"limit\":1}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListControlLibrariesOptions listControlLibrariesOptions = new ListControlLibrariesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .accountId("testString")
      .limit(Long.valueOf("10"))
      .build();

    List<ControlLibrary> allResults = new ArrayList<>();
    ControlLibrariesPager pager = new ControlLibrariesPager(securityAndComplianceCenterApiService, listControlLibrariesOptions);
    while (pager.hasNext()) {
      List<ControlLibrary> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listControlLibraries operation using the ControlLibrariesPager.getAll() method
  @Test
  public void testListControlLibrariesWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"control_libraries\":[{\"control_library_name\":\"controlLibraryName\",\"control_library_description\":\"controlLibraryDescription\",\"control_library_type\":\"custom\",\"control_library_version\":\"controlLibraryVersion\",\"controls\":[{\"control_name\":\"controlName\",\"control_id\":\"controlId\",\"control_description\":\"controlDescription\",\"control_category\":\"controlCategory\",\"control_parent\":\"controlParent\",\"control_severity\":\"controlSeverity\",\"control_tags\":[\"controlTags\"],\"control_specifications\":[{\"id\":\"id\",\"responsibility\":\"responsibility\",\"component_id\":\"componentId\",\"component_name\":\"componentName\",\"component_type\":\"componentType\",\"environment\":\"environment\",\"description\":\"description\",\"assessments_count\":16,\"assessments\":[{\"assessment_id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"assessment_type\":\"ibm-cloud-rule\",\"assessment_method\":\"ibm-cloud-rule\",\"assessment_description\":\"Check whether Cloud Object Storage is accessible only by using private endpoints\",\"parameter_count\":1,\"parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}]}]}],\"control_docs\":{\"control_docs_id\":\"controlDocsId\",\"control_docs_type\":\"controlDocsType\"},\"status\":\"status\"}],\"id\":\"id\",\"account_id\":\"accountId\",\"version_group_label\":\"versionGroupLabel\",\"latest\":true,\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"hierarchy_enabled\":true,\"controls_count\":13,\"control_parents_count\":19}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"control_libraries\":[{\"control_library_name\":\"controlLibraryName\",\"control_library_description\":\"controlLibraryDescription\",\"control_library_type\":\"custom\",\"control_library_version\":\"controlLibraryVersion\",\"controls\":[{\"control_name\":\"controlName\",\"control_id\":\"controlId\",\"control_description\":\"controlDescription\",\"control_category\":\"controlCategory\",\"control_parent\":\"controlParent\",\"control_severity\":\"controlSeverity\",\"control_tags\":[\"controlTags\"],\"control_specifications\":[{\"id\":\"id\",\"responsibility\":\"responsibility\",\"component_id\":\"componentId\",\"component_name\":\"componentName\",\"component_type\":\"componentType\",\"environment\":\"environment\",\"description\":\"description\",\"assessments_count\":16,\"assessments\":[{\"assessment_id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"assessment_type\":\"ibm-cloud-rule\",\"assessment_method\":\"ibm-cloud-rule\",\"assessment_description\":\"Check whether Cloud Object Storage is accessible only by using private endpoints\",\"parameter_count\":1,\"parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}]}]}],\"control_docs\":{\"control_docs_id\":\"controlDocsId\",\"control_docs_type\":\"controlDocsType\"},\"status\":\"status\"}],\"id\":\"id\",\"account_id\":\"accountId\",\"version_group_label\":\"versionGroupLabel\",\"latest\":true,\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"hierarchy_enabled\":true,\"controls_count\":13,\"control_parents_count\":19}],\"total_count\":2,\"limit\":1}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListControlLibrariesOptions listControlLibrariesOptions = new ListControlLibrariesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .accountId("testString")
      .limit(Long.valueOf("10"))
      .build();

    ControlLibrariesPager pager = new ControlLibrariesPager(securityAndComplianceCenterApiService, listControlLibrariesOptions);
    List<ControlLibrary> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the replaceCustomControlLibrary operation with a valid options model parameter
  @Test
  public void testReplaceCustomControlLibraryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"control_library_name\": \"controlLibraryName\", \"control_library_description\": \"controlLibraryDescription\", \"control_library_type\": \"custom\", \"control_library_version\": \"controlLibraryVersion\", \"controls\": [{\"control_name\": \"controlName\", \"control_id\": \"controlId\", \"control_description\": \"controlDescription\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_severity\": \"controlSeverity\", \"control_tags\": [\"controlTags\"], \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"responsibility\", \"component_id\": \"componentId\", \"component_name\": \"componentName\", \"component_type\": \"componentType\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}], \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"status\": \"status\"}], \"id\": \"id\", \"account_id\": \"accountId\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"hierarchy_enabled\": true, \"controls_count\": 13, \"control_parents_count\": 19}";
    String replaceCustomControlLibraryPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/control_libraries/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the AssessmentPrototype model
    AssessmentPrototype assessmentPrototypeModel = new AssessmentPrototype.Builder()
      .assessmentId("rule-d1bd9f3f-bee1-46c5-9533-da8bba9eed4e")
      .assessmentDescription("This rule will check on regulation")
      .build();

    // Construct an instance of the ControlSpecificationPrototype model
    ControlSpecificationPrototype controlSpecificationPrototypeModel = new ControlSpecificationPrototype.Builder()
      .componentId("apprapp")
      .environment("ibm-cloud")
      .controlSpecificationId("testString")
      .controlSpecificationDescription("This field is used to describe a control specification")
      .assessments(java.util.Arrays.asList(assessmentPrototypeModel))
      .build();

    // Construct an instance of the ControlDoc model
    ControlDoc controlDocModel = new ControlDoc.Builder()
      .controlDocsId("testString")
      .controlDocsType("testString")
      .build();

    // Construct an instance of the ControlPrototype model
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

    // Construct an instance of the ReplaceCustomControlLibraryOptions model
    ReplaceCustomControlLibraryOptions replaceCustomControlLibraryOptionsModel = new ReplaceCustomControlLibraryOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .controlLibraryId("testString")
      .controlLibraryName("custom control library from SDK")
      .controlLibraryDescription("This is a custom control library made from the SDK test framework")
      .controlLibraryType("custom")
      .controlLibraryVersion("0.0.2")
      .controls(java.util.Arrays.asList(controlPrototypeModel))
      .bssAccount("testString")
      .build();

    // Invoke replaceCustomControlLibrary() with a valid options model and verify the result
    Response<ControlLibrary> response = securityAndComplianceCenterApiService.replaceCustomControlLibrary(replaceCustomControlLibraryOptionsModel).execute();
    assertNotNull(response);
    ControlLibrary responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceCustomControlLibraryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("bss_account"), "testString");
  }

  // Test the replaceCustomControlLibrary operation with and without retries enabled
  @Test
  public void testReplaceCustomControlLibraryWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testReplaceCustomControlLibraryWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testReplaceCustomControlLibraryWOptions();
  }

  // Test the replaceCustomControlLibrary operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceCustomControlLibraryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.replaceCustomControlLibrary(null).execute();
  }

  // Test the getControlLibrary operation with a valid options model parameter
  @Test
  public void testGetControlLibraryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"control_library_name\": \"controlLibraryName\", \"control_library_description\": \"controlLibraryDescription\", \"control_library_type\": \"custom\", \"control_library_version\": \"controlLibraryVersion\", \"controls\": [{\"control_name\": \"controlName\", \"control_id\": \"controlId\", \"control_description\": \"controlDescription\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_severity\": \"controlSeverity\", \"control_tags\": [\"controlTags\"], \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"responsibility\", \"component_id\": \"componentId\", \"component_name\": \"componentName\", \"component_type\": \"componentType\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}], \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"status\": \"status\"}], \"id\": \"id\", \"account_id\": \"accountId\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"hierarchy_enabled\": true, \"controls_count\": 13, \"control_parents_count\": 19}";
    String getControlLibraryPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/control_libraries/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetControlLibraryOptions model
    GetControlLibraryOptions getControlLibraryOptionsModel = new GetControlLibraryOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .controlLibraryId("testString")
      .accountId("testString")
      .build();

    // Invoke getControlLibrary() with a valid options model and verify the result
    Response<ControlLibrary> response = securityAndComplianceCenterApiService.getControlLibrary(getControlLibraryOptionsModel).execute();
    assertNotNull(response);
    ControlLibrary responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getControlLibraryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the getControlLibrary operation with and without retries enabled
  @Test
  public void testGetControlLibraryWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetControlLibraryWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetControlLibraryWOptions();
  }

  // Test the getControlLibrary operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetControlLibraryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getControlLibrary(null).execute();
  }

  // Test the deleteCustomControlLibrary operation with a valid options model parameter
  @Test
  public void testDeleteCustomControlLibraryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"control_library_name\": \"controlLibraryName\", \"control_library_description\": \"controlLibraryDescription\", \"control_library_type\": \"custom\", \"control_library_version\": \"controlLibraryVersion\", \"controls\": [{\"control_name\": \"controlName\", \"control_id\": \"controlId\", \"control_description\": \"controlDescription\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_severity\": \"controlSeverity\", \"control_tags\": [\"controlTags\"], \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"responsibility\", \"component_id\": \"componentId\", \"component_name\": \"componentName\", \"component_type\": \"componentType\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}], \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"status\": \"status\"}], \"id\": \"id\", \"account_id\": \"accountId\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"hierarchy_enabled\": true, \"controls_count\": 13, \"control_parents_count\": 19}";
    String deleteCustomControlLibraryPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/control_libraries/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteCustomControlLibraryOptions model
    DeleteCustomControlLibraryOptions deleteCustomControlLibraryOptionsModel = new DeleteCustomControlLibraryOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .controlLibraryId("testString")
      .accountId("testString")
      .build();

    // Invoke deleteCustomControlLibrary() with a valid options model and verify the result
    Response<ControlLibrary> response = securityAndComplianceCenterApiService.deleteCustomControlLibrary(deleteCustomControlLibraryOptionsModel).execute();
    assertNotNull(response);
    ControlLibrary responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteCustomControlLibraryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the deleteCustomControlLibrary operation with and without retries enabled
  @Test
  public void testDeleteCustomControlLibraryWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testDeleteCustomControlLibraryWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testDeleteCustomControlLibraryWOptions();
  }

  // Test the deleteCustomControlLibrary operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCustomControlLibraryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.deleteCustomControlLibrary(null).execute();
  }

  // Test the createProfile operation with a valid options model parameter
  @Test
  public void testCreateProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"profile_name\": \"profileName\", \"instance_id\": \"instanceId\", \"hierarchy_enabled\": true, \"profile_description\": \"profileDescription\", \"profile_type\": \"custom\", \"profile_version\": \"profileVersion\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"controls_count\": 13, \"attachments_count\": 16, \"controls\": [{\"control_requirement\": true, \"control_library_id\": \"controlLibraryId\", \"control_id\": \"controlId\", \"control_library_version\": \"controlLibraryVersion\", \"control_name\": \"controlName\", \"control_description\": \"controlDescription\", \"control_severity\": \"controlSeverity\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"responsibility\", \"component_id\": \"componentId\", \"component_name\": \"componentName\", \"component_type\": \"componentType\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}]}], \"default_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"parameterType\"}]}";
    String createProfilePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/profiles";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the ProfileControlsPrototype model
    ProfileControlsPrototype profileControlsPrototypeModel = new ProfileControlsPrototype.Builder()
      .controlLibraryId("a046fb6b-aba5-4646-b190-a2c76241e7af")
      .controlId("60dae3b5-6104-4b3e-bac7-26cc7b741aca")
      .build();

    // Construct an instance of the DefaultParameters model
    DefaultParameters defaultParametersModel = new DefaultParameters.Builder()
      .assessmentType("automated")
      .assessmentId("rule-e16fcfea-fe21-4d30-a721-423611481fea")
      .parameterName("tls_version")
      .parameterDefaultValue("[\"1.2\",\"1.3\"]")
      .parameterDisplayName("IBM Cloud Internet Services TLS version")
      .parameterType("string_list")
      .build();

    // Construct an instance of the CreateProfileOptions model
    CreateProfileOptions createProfileOptionsModel = new CreateProfileOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .profileName("Example Profile")
      .profileVersion("0.0.1")
      .controls(java.util.Arrays.asList(profileControlsPrototypeModel))
      .defaultParameters(java.util.Arrays.asList(defaultParametersModel))
      .profileDescription("This profile is created as an example of the SDK gen")
      .latest(true)
      .versionGroupLabel("testString")
      .accountId("testString")
      .build();

    // Invoke createProfile() with a valid options model and verify the result
    Response<Profile> response = securityAndComplianceCenterApiService.createProfile(createProfileOptionsModel).execute();
    assertNotNull(response);
    Profile responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createProfilePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the createProfile operation with and without retries enabled
  @Test
  public void testCreateProfileWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testCreateProfileWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testCreateProfileWOptions();
  }

  // Test the createProfile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateProfileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.createProfile(null).execute();
  }

  // Test the listProfiles operation with a valid options model parameter
  @Test
  public void testListProfilesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 50, \"total_count\": 230, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"profiles\": [{\"id\": \"id\", \"profile_name\": \"profileName\", \"instance_id\": \"instanceId\", \"hierarchy_enabled\": true, \"profile_description\": \"profileDescription\", \"profile_type\": \"custom\", \"profile_version\": \"profileVersion\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"controls_count\": 13, \"attachments_count\": 16, \"controls\": [{\"control_requirement\": true, \"control_library_id\": \"controlLibraryId\", \"control_id\": \"controlId\", \"control_library_version\": \"controlLibraryVersion\", \"control_name\": \"controlName\", \"control_description\": \"controlDescription\", \"control_severity\": \"controlSeverity\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"responsibility\", \"component_id\": \"componentId\", \"component_name\": \"componentName\", \"component_type\": \"componentType\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}]}], \"default_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"parameterType\"}]}]}";
    String listProfilesPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/profiles";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListProfilesOptions model
    ListProfilesOptions listProfilesOptionsModel = new ListProfilesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .accountId("testString")
      .limit(Long.valueOf("10"))
      .start("testString")
      .build();

    // Invoke listProfiles() with a valid options model and verify the result
    Response<ProfileCollection> response = securityAndComplianceCenterApiService.listProfiles(listProfilesOptionsModel).execute();
    assertNotNull(response);
    ProfileCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listProfilesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
  }

  // Test the listProfiles operation with and without retries enabled
  @Test
  public void testListProfilesWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListProfilesWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListProfilesWOptions();
  }

  // Test the listProfiles operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListProfilesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.listProfiles(null).execute();
  }

  // Test the listProfiles operation using the ProfilesPager.getNext() method
  @Test
  public void testListProfilesWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"limit\":1,\"profiles\":[{\"id\":\"id\",\"profile_name\":\"profileName\",\"instance_id\":\"instanceId\",\"hierarchy_enabled\":true,\"profile_description\":\"profileDescription\",\"profile_type\":\"custom\",\"profile_version\":\"profileVersion\",\"version_group_label\":\"versionGroupLabel\",\"latest\":true,\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"controls_count\":13,\"attachments_count\":16,\"controls\":[{\"control_requirement\":true,\"control_library_id\":\"controlLibraryId\",\"control_id\":\"controlId\",\"control_library_version\":\"controlLibraryVersion\",\"control_name\":\"controlName\",\"control_description\":\"controlDescription\",\"control_severity\":\"controlSeverity\",\"control_category\":\"controlCategory\",\"control_parent\":\"controlParent\",\"control_docs\":{\"control_docs_id\":\"controlDocsId\",\"control_docs_type\":\"controlDocsType\"},\"control_specifications\":[{\"id\":\"id\",\"responsibility\":\"responsibility\",\"component_id\":\"componentId\",\"component_name\":\"componentName\",\"component_type\":\"componentType\",\"environment\":\"environment\",\"description\":\"description\",\"assessments_count\":16,\"assessments\":[{\"assessment_id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"assessment_type\":\"ibm-cloud-rule\",\"assessment_method\":\"ibm-cloud-rule\",\"assessment_description\":\"Check whether Cloud Object Storage is accessible only by using private endpoints\",\"parameter_count\":1,\"parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}]}]}]}],\"default_parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"parameterName\",\"parameter_default_value\":\"parameterDefaultValue\",\"parameter_display_name\":\"parameterDisplayName\",\"parameter_type\":\"parameterType\"}]}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"profiles\":[{\"id\":\"id\",\"profile_name\":\"profileName\",\"instance_id\":\"instanceId\",\"hierarchy_enabled\":true,\"profile_description\":\"profileDescription\",\"profile_type\":\"custom\",\"profile_version\":\"profileVersion\",\"version_group_label\":\"versionGroupLabel\",\"latest\":true,\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"controls_count\":13,\"attachments_count\":16,\"controls\":[{\"control_requirement\":true,\"control_library_id\":\"controlLibraryId\",\"control_id\":\"controlId\",\"control_library_version\":\"controlLibraryVersion\",\"control_name\":\"controlName\",\"control_description\":\"controlDescription\",\"control_severity\":\"controlSeverity\",\"control_category\":\"controlCategory\",\"control_parent\":\"controlParent\",\"control_docs\":{\"control_docs_id\":\"controlDocsId\",\"control_docs_type\":\"controlDocsType\"},\"control_specifications\":[{\"id\":\"id\",\"responsibility\":\"responsibility\",\"component_id\":\"componentId\",\"component_name\":\"componentName\",\"component_type\":\"componentType\",\"environment\":\"environment\",\"description\":\"description\",\"assessments_count\":16,\"assessments\":[{\"assessment_id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"assessment_type\":\"ibm-cloud-rule\",\"assessment_method\":\"ibm-cloud-rule\",\"assessment_description\":\"Check whether Cloud Object Storage is accessible only by using private endpoints\",\"parameter_count\":1,\"parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}]}]}]}],\"default_parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"parameterName\",\"parameter_default_value\":\"parameterDefaultValue\",\"parameter_display_name\":\"parameterDisplayName\",\"parameter_type\":\"parameterType\"}]}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListProfilesOptions listProfilesOptions = new ListProfilesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .accountId("testString")
      .limit(Long.valueOf("10"))
      .build();

    List<Profile> allResults = new ArrayList<>();
    ProfilesPager pager = new ProfilesPager(securityAndComplianceCenterApiService, listProfilesOptions);
    while (pager.hasNext()) {
      List<Profile> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listProfiles operation using the ProfilesPager.getAll() method
  @Test
  public void testListProfilesWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"limit\":1,\"profiles\":[{\"id\":\"id\",\"profile_name\":\"profileName\",\"instance_id\":\"instanceId\",\"hierarchy_enabled\":true,\"profile_description\":\"profileDescription\",\"profile_type\":\"custom\",\"profile_version\":\"profileVersion\",\"version_group_label\":\"versionGroupLabel\",\"latest\":true,\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"controls_count\":13,\"attachments_count\":16,\"controls\":[{\"control_requirement\":true,\"control_library_id\":\"controlLibraryId\",\"control_id\":\"controlId\",\"control_library_version\":\"controlLibraryVersion\",\"control_name\":\"controlName\",\"control_description\":\"controlDescription\",\"control_severity\":\"controlSeverity\",\"control_category\":\"controlCategory\",\"control_parent\":\"controlParent\",\"control_docs\":{\"control_docs_id\":\"controlDocsId\",\"control_docs_type\":\"controlDocsType\"},\"control_specifications\":[{\"id\":\"id\",\"responsibility\":\"responsibility\",\"component_id\":\"componentId\",\"component_name\":\"componentName\",\"component_type\":\"componentType\",\"environment\":\"environment\",\"description\":\"description\",\"assessments_count\":16,\"assessments\":[{\"assessment_id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"assessment_type\":\"ibm-cloud-rule\",\"assessment_method\":\"ibm-cloud-rule\",\"assessment_description\":\"Check whether Cloud Object Storage is accessible only by using private endpoints\",\"parameter_count\":1,\"parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}]}]}]}],\"default_parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"parameterName\",\"parameter_default_value\":\"parameterDefaultValue\",\"parameter_display_name\":\"parameterDisplayName\",\"parameter_type\":\"parameterType\"}]}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"profiles\":[{\"id\":\"id\",\"profile_name\":\"profileName\",\"instance_id\":\"instanceId\",\"hierarchy_enabled\":true,\"profile_description\":\"profileDescription\",\"profile_type\":\"custom\",\"profile_version\":\"profileVersion\",\"version_group_label\":\"versionGroupLabel\",\"latest\":true,\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"controls_count\":13,\"attachments_count\":16,\"controls\":[{\"control_requirement\":true,\"control_library_id\":\"controlLibraryId\",\"control_id\":\"controlId\",\"control_library_version\":\"controlLibraryVersion\",\"control_name\":\"controlName\",\"control_description\":\"controlDescription\",\"control_severity\":\"controlSeverity\",\"control_category\":\"controlCategory\",\"control_parent\":\"controlParent\",\"control_docs\":{\"control_docs_id\":\"controlDocsId\",\"control_docs_type\":\"controlDocsType\"},\"control_specifications\":[{\"id\":\"id\",\"responsibility\":\"responsibility\",\"component_id\":\"componentId\",\"component_name\":\"componentName\",\"component_type\":\"componentType\",\"environment\":\"environment\",\"description\":\"description\",\"assessments_count\":16,\"assessments\":[{\"assessment_id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"assessment_type\":\"ibm-cloud-rule\",\"assessment_method\":\"ibm-cloud-rule\",\"assessment_description\":\"Check whether Cloud Object Storage is accessible only by using private endpoints\",\"parameter_count\":1,\"parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}]}]}]}],\"default_parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"parameterName\",\"parameter_default_value\":\"parameterDefaultValue\",\"parameter_display_name\":\"parameterDisplayName\",\"parameter_type\":\"parameterType\"}]}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListProfilesOptions listProfilesOptions = new ListProfilesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .accountId("testString")
      .limit(Long.valueOf("10"))
      .build();

    ProfilesPager pager = new ProfilesPager(securityAndComplianceCenterApiService, listProfilesOptions);
    List<Profile> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the replaceProfile operation with a valid options model parameter
  @Test
  public void testReplaceProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"profile_name\": \"profileName\", \"instance_id\": \"instanceId\", \"hierarchy_enabled\": true, \"profile_description\": \"profileDescription\", \"profile_type\": \"custom\", \"profile_version\": \"profileVersion\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"controls_count\": 13, \"attachments_count\": 16, \"controls\": [{\"control_requirement\": true, \"control_library_id\": \"controlLibraryId\", \"control_id\": \"controlId\", \"control_library_version\": \"controlLibraryVersion\", \"control_name\": \"controlName\", \"control_description\": \"controlDescription\", \"control_severity\": \"controlSeverity\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"responsibility\", \"component_id\": \"componentId\", \"component_name\": \"componentName\", \"component_type\": \"componentType\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}]}], \"default_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"parameterType\"}]}";
    String replaceProfilePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/profiles/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ControlDoc model
    ControlDoc controlDocModel = new ControlDoc.Builder()
      .controlDocsId("testString")
      .controlDocsType("testString")
      .build();

    // Construct an instance of the Parameter model
    Parameter parameterModel = new Parameter.Builder()
      .assessmentType("testString")
      .assessmentId("testString")
      .parameterName("location")
      .parameterDisplayName("Location")
      .parameterType("string")
      .parameterValue("testString")
      .build();

    // Construct an instance of the Assessment model
    Assessment assessmentModel = new Assessment.Builder()
      .assessmentId("382c2b06-e6b2-43ee-b189-c1c7743b67ee")
      .assessmentType("ibm-cloud-rule")
      .assessmentMethod("ibm-cloud-rule")
      .assessmentDescription("Check whether Cloud Object Storage is accessible only by using private endpoints")
      .parameterCount(Long.valueOf("1"))
      .parameters(java.util.Arrays.asList(parameterModel))
      .build();

    // Construct an instance of the ControlSpecification model
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

    // Construct an instance of the ProfileControls model
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

    // Construct an instance of the DefaultParameters model
    DefaultParameters defaultParametersModel = new DefaultParameters.Builder()
      .assessmentType("automated")
      .assessmentId("rule-e16fcfea-fe21-4d30-a721-423611481fea")
      .parameterName("tls_version")
      .parameterDefaultValue("[\"1.2\",\"1.3\"]")
      .parameterDisplayName("IBM Cloud Internet Services TLS version")
      .parameterType("string_list")
      .build();

    // Construct an instance of the ReplaceProfileOptions model
    ReplaceProfileOptions replaceProfileOptionsModel = new ReplaceProfileOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .profileId("testString")
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
      .accountId("testString")
      .build();

    // Invoke replaceProfile() with a valid options model and verify the result
    Response<Profile> response = securityAndComplianceCenterApiService.replaceProfile(replaceProfileOptionsModel).execute();
    assertNotNull(response);
    Profile responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceProfilePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the replaceProfile operation with and without retries enabled
  @Test
  public void testReplaceProfileWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testReplaceProfileWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testReplaceProfileWOptions();
  }

  // Test the replaceProfile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceProfileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.replaceProfile(null).execute();
  }

  // Test the getProfile operation with a valid options model parameter
  @Test
  public void testGetProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"profile_name\": \"profileName\", \"instance_id\": \"instanceId\", \"hierarchy_enabled\": true, \"profile_description\": \"profileDescription\", \"profile_type\": \"custom\", \"profile_version\": \"profileVersion\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"controls_count\": 13, \"attachments_count\": 16, \"controls\": [{\"control_requirement\": true, \"control_library_id\": \"controlLibraryId\", \"control_id\": \"controlId\", \"control_library_version\": \"controlLibraryVersion\", \"control_name\": \"controlName\", \"control_description\": \"controlDescription\", \"control_severity\": \"controlSeverity\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"responsibility\", \"component_id\": \"componentId\", \"component_name\": \"componentName\", \"component_type\": \"componentType\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}]}], \"default_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"parameterType\"}]}";
    String getProfilePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/profiles/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetProfileOptions model
    GetProfileOptions getProfileOptionsModel = new GetProfileOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .profileId("testString")
      .accountId("testString")
      .build();

    // Invoke getProfile() with a valid options model and verify the result
    Response<Profile> response = securityAndComplianceCenterApiService.getProfile(getProfileOptionsModel).execute();
    assertNotNull(response);
    Profile responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getProfilePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the getProfile operation with and without retries enabled
  @Test
  public void testGetProfileWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetProfileWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetProfileWOptions();
  }

  // Test the getProfile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetProfileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getProfile(null).execute();
  }

  // Test the deleteCustomProfile operation with a valid options model parameter
  @Test
  public void testDeleteCustomProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"profile_name\": \"profileName\", \"instance_id\": \"instanceId\", \"hierarchy_enabled\": true, \"profile_description\": \"profileDescription\", \"profile_type\": \"custom\", \"profile_version\": \"profileVersion\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"controls_count\": 13, \"attachments_count\": 16, \"controls\": [{\"control_requirement\": true, \"control_library_id\": \"controlLibraryId\", \"control_id\": \"controlId\", \"control_library_version\": \"controlLibraryVersion\", \"control_name\": \"controlName\", \"control_description\": \"controlDescription\", \"control_severity\": \"controlSeverity\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"responsibility\", \"component_id\": \"componentId\", \"component_name\": \"componentName\", \"component_type\": \"componentType\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}]}], \"default_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"parameterType\"}]}";
    String deleteCustomProfilePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/profiles/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteCustomProfileOptions model
    DeleteCustomProfileOptions deleteCustomProfileOptionsModel = new DeleteCustomProfileOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .profileId("testString")
      .accountId("testString")
      .build();

    // Invoke deleteCustomProfile() with a valid options model and verify the result
    Response<Profile> response = securityAndComplianceCenterApiService.deleteCustomProfile(deleteCustomProfileOptionsModel).execute();
    assertNotNull(response);
    Profile responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteCustomProfilePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the deleteCustomProfile operation with and without retries enabled
  @Test
  public void testDeleteCustomProfileWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testDeleteCustomProfileWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testDeleteCustomProfileWOptions();
  }

  // Test the deleteCustomProfile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCustomProfileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.deleteCustomProfile(null).execute();
  }

  // Test the replaceProfileParameters operation with a valid options model parameter
  @Test
  public void testReplaceProfileParametersWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"default_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"parameterType\"}]}";
    String replaceProfileParametersPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/profiles/testString/parameters";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DefaultParameters model
    DefaultParameters defaultParametersModel = new DefaultParameters.Builder()
      .assessmentType("testString")
      .assessmentId("testString")
      .parameterName("testString")
      .parameterDefaultValue("testString")
      .parameterDisplayName("testString")
      .parameterType("testString")
      .build();

    // Construct an instance of the ReplaceProfileParametersOptions model
    ReplaceProfileParametersOptions replaceProfileParametersOptionsModel = new ReplaceProfileParametersOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .profileId("testString")
      .defaultParameters(java.util.Arrays.asList(defaultParametersModel))
      .id("testString")
      .accountId("testString")
      .build();

    // Invoke replaceProfileParameters() with a valid options model and verify the result
    Response<ProfileDefaultParametersResponse> response = securityAndComplianceCenterApiService.replaceProfileParameters(replaceProfileParametersOptionsModel).execute();
    assertNotNull(response);
    ProfileDefaultParametersResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceProfileParametersPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the replaceProfileParameters operation with and without retries enabled
  @Test
  public void testReplaceProfileParametersWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testReplaceProfileParametersWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testReplaceProfileParametersWOptions();
  }

  // Test the replaceProfileParameters operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceProfileParametersNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.replaceProfileParameters(null).execute();
  }

  // Test the listProfileParameters operation with a valid options model parameter
  @Test
  public void testListProfileParametersWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"default_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"parameterType\"}]}";
    String listProfileParametersPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/profiles/testString/parameters";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListProfileParametersOptions model
    ListProfileParametersOptions listProfileParametersOptionsModel = new ListProfileParametersOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .profileId("testString")
      .build();

    // Invoke listProfileParameters() with a valid options model and verify the result
    Response<ProfileDefaultParametersResponse> response = securityAndComplianceCenterApiService.listProfileParameters(listProfileParametersOptionsModel).execute();
    assertNotNull(response);
    ProfileDefaultParametersResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listProfileParametersPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listProfileParameters operation with and without retries enabled
  @Test
  public void testListProfileParametersWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListProfileParametersWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListProfileParametersWOptions();
  }

  // Test the listProfileParameters operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListProfileParametersNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.listProfileParameters(null).execute();
  }

  // Test the compareProfiles operation with a valid options model parameter
  @Test
  public void testCompareProfilesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"current_predefined_version\": {\"id\": \"id\", \"profile_name\": \"profileName\", \"profile_description\": \"profileDescription\", \"profile_type\": \"custom\", \"profile_version\": \"profileVersion\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"controls_count\": 13}, \"latest_predefined_version\": {\"id\": \"id\", \"profile_name\": \"profileName\", \"profile_description\": \"profileDescription\", \"profile_type\": \"custom\", \"profile_version\": \"profileVersion\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"controls_count\": 13}, \"controls_changes\": {\"total_added\": 10, \"total_removed\": 12, \"total_updated\": 12, \"added\": [{\"control_requirement\": true, \"control_library_id\": \"controlLibraryId\", \"control_id\": \"controlId\", \"control_library_version\": \"controlLibraryVersion\", \"control_name\": \"controlName\", \"control_description\": \"controlDescription\", \"control_severity\": \"controlSeverity\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"responsibility\", \"component_id\": \"componentId\", \"component_name\": \"componentName\", \"component_type\": \"componentType\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}]}], \"removed\": [{\"control_requirement\": true, \"control_library_id\": \"controlLibraryId\", \"control_id\": \"controlId\", \"control_library_version\": \"controlLibraryVersion\", \"control_name\": \"controlName\", \"control_description\": \"controlDescription\", \"control_severity\": \"controlSeverity\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"responsibility\", \"component_id\": \"componentId\", \"component_name\": \"componentName\", \"component_type\": \"componentType\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}]}], \"updated\": [{\"current\": {\"control_requirement\": true, \"control_library_id\": \"controlLibraryId\", \"control_id\": \"controlId\", \"control_library_version\": \"controlLibraryVersion\", \"control_name\": \"controlName\", \"control_description\": \"controlDescription\", \"control_severity\": \"controlSeverity\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"responsibility\", \"component_id\": \"componentId\", \"component_name\": \"componentName\", \"component_type\": \"componentType\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}]}, \"latest\": {\"control_requirement\": true, \"control_library_id\": \"controlLibraryId\", \"control_id\": \"controlId\", \"control_library_version\": \"controlLibraryVersion\", \"control_name\": \"controlName\", \"control_description\": \"controlDescription\", \"control_severity\": \"controlSeverity\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"responsibility\", \"component_id\": \"componentId\", \"component_name\": \"componentName\", \"component_type\": \"componentType\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}]}}]}, \"default_parameters_changes\": {\"total_added\": 10, \"total_removed\": 12, \"total_updated\": 12, \"added\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"parameterType\"}], \"removed\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"parameterType\"}], \"updated\": [{\"current\": {\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"parameterType\"}, \"latest\": {\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"parameterType\"}}]}}";
    String compareProfilesPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/profiles/2f598907-970d-4d52-9071-5cc95912f55e/compare";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CompareProfilesOptions model
    CompareProfilesOptions compareProfilesOptionsModel = new CompareProfilesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .profileId("2f598907-970d-4d52-9071-5cc95912f55e")
      .accountId("testString")
      .build();

    // Invoke compareProfiles() with a valid options model and verify the result
    Response<ComparePredefinedProfilesResponse> response = securityAndComplianceCenterApiService.compareProfiles(compareProfilesOptionsModel).execute();
    assertNotNull(response);
    ComparePredefinedProfilesResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, compareProfilesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the compareProfiles operation with and without retries enabled
  @Test
  public void testCompareProfilesWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testCompareProfilesWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testCompareProfilesWOptions();
  }

  // Test the compareProfiles operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCompareProfilesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.compareProfiles(null).execute();
  }

  // Test the listProfileAttachments operation with a valid options model parameter
  @Test
  public void testListProfileAttachmentsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 50, \"total_count\": 230, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"attachments\": [{\"attachment_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}], \"description\": \"description\", \"name\": \"name\", \"notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 15, \"failed_control_ids\": [\"failedControlIds\"]}}, \"schedule\": \"daily\", \"scope\": [{\"id\": \"id\"}], \"status\": \"enabled\", \"data_selection_range\": {\"start_date\": \"2025-02-28T05:42:58.000Z\", \"end_date\": \"2025-02-28T05:42:58.000Z\"}, \"account_id\": \"accountId\", \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"id\": \"id\", \"instance_id\": \"instanceId\", \"last_scan\": {\"id\": \"id\", \"status\": \"status\", \"time\": \"2019-01-01T12:00:00.000Z\"}, \"next_scan_time\": \"2019-01-01T12:00:00.000Z\", \"profile_id\": \"profileId\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\"}]}";
    String listProfileAttachmentsPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/profiles/9c265b4a-4cdf-47f1-acd3-17b5808f7f3f/attachments";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListProfileAttachmentsOptions model
    ListProfileAttachmentsOptions listProfileAttachmentsOptionsModel = new ListProfileAttachmentsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
      .accountId("testString")
      .build();

    // Invoke listProfileAttachments() with a valid options model and verify the result
    Response<ProfileAttachmentCollection> response = securityAndComplianceCenterApiService.listProfileAttachments(listProfileAttachmentsOptionsModel).execute();
    assertNotNull(response);
    ProfileAttachmentCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listProfileAttachmentsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the listProfileAttachments operation with and without retries enabled
  @Test
  public void testListProfileAttachmentsWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListProfileAttachmentsWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListProfileAttachmentsWOptions();
  }

  // Test the listProfileAttachments operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListProfileAttachmentsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.listProfileAttachments(null).execute();
  }

  // Test the createScope operation with a valid options model parameter
  @Test
  public void testCreateScopeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"environment\": \"environment\", \"properties\": [{\"name\": \"name\", \"value\": \"anyValue\"}], \"account_id\": \"accountId\", \"instance_id\": \"instanceId\", \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"attachment_count\": 15}";
    String createScopePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/scopes";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the ScopePropertyScopeAny model
    ScopePropertyScopeAny scopePropertyModel = new ScopePropertyScopeAny.Builder()
      .name("scope_id")
      .value("ff88f007f9ff4622aac4fbc0eda36255")
      .build();

    // Construct an instance of the CreateScopeOptions model
    CreateScopeOptions createScopeOptionsModel = new CreateScopeOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .name("ibm scope")
      .description("The scope that is defined for IBM resources.")
      .environment("ibm-cloud")
      .xProperties(java.util.Arrays.asList(scopePropertyModel))
      .build();

    // Invoke createScope() with a valid options model and verify the result
    Response<Scope> response = securityAndComplianceCenterApiService.createScope(createScopeOptionsModel).execute();
    assertNotNull(response);
    Scope responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createScopePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createScope operation with and without retries enabled
  @Test
  public void testCreateScopeWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testCreateScopeWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testCreateScopeWOptions();
  }

  // Test the createScope operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateScopeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.createScope(null).execute();
  }

  // Test the listScopes operation with a valid options model parameter
  @Test
  public void testListScopesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 50, \"total_count\": 230, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"scopes\": [{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"environment\": \"environment\", \"properties\": [{\"name\": \"name\", \"value\": \"anyValue\"}], \"account_id\": \"accountId\", \"instance_id\": \"instanceId\", \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"attachment_count\": 15}]}";
    String listScopesPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/scopes";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListScopesOptions model
    ListScopesOptions listScopesOptionsModel = new ListScopesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .limit(Long.valueOf("10"))
      .start("testString")
      .name("testString")
      .description("testString")
      .environment("testString")
      .build();

    // Invoke listScopes() with a valid options model and verify the result
    Response<ScopeCollection> response = securityAndComplianceCenterApiService.listScopes(listScopesOptionsModel).execute();
    assertNotNull(response);
    ScopeCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listScopesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
    assertEquals(query.get("name"), "testString");
    assertEquals(query.get("description"), "testString");
    assertEquals(query.get("environment"), "testString");
  }

  // Test the listScopes operation with and without retries enabled
  @Test
  public void testListScopesWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListScopesWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListScopesWOptions();
  }

  // Test the listScopes operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListScopesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.listScopes(null).execute();
  }

  // Test the listScopes operation using the ScopesPager.getNext() method
  @Test
  public void testListScopesWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"limit\":1,\"scopes\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"anyValue\"}],\"account_id\":\"accountId\",\"instance_id\":\"instanceId\",\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"attachment_count\":15}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"scopes\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"anyValue\"}],\"account_id\":\"accountId\",\"instance_id\":\"instanceId\",\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"attachment_count\":15}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListScopesOptions listScopesOptions = new ListScopesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .limit(Long.valueOf("10"))
      .name("testString")
      .description("testString")
      .environment("testString")
      .build();

    List<Scope> allResults = new ArrayList<>();
    ScopesPager pager = new ScopesPager(securityAndComplianceCenterApiService, listScopesOptions);
    while (pager.hasNext()) {
      List<Scope> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listScopes operation using the ScopesPager.getAll() method
  @Test
  public void testListScopesWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"limit\":1,\"scopes\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"anyValue\"}],\"account_id\":\"accountId\",\"instance_id\":\"instanceId\",\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"attachment_count\":15}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"scopes\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"anyValue\"}],\"account_id\":\"accountId\",\"instance_id\":\"instanceId\",\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"attachment_count\":15}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListScopesOptions listScopesOptions = new ListScopesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .limit(Long.valueOf("10"))
      .name("testString")
      .description("testString")
      .environment("testString")
      .build();

    ScopesPager pager = new ScopesPager(securityAndComplianceCenterApiService, listScopesOptions);
    List<Scope> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the updateScope operation with a valid options model parameter
  @Test
  public void testUpdateScopeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"environment\": \"environment\", \"properties\": [{\"name\": \"name\", \"value\": \"anyValue\"}], \"account_id\": \"accountId\", \"instance_id\": \"instanceId\", \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"attachment_count\": 15}";
    String updateScopePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/scopes/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateScopeOptions model
    UpdateScopeOptions updateScopeOptionsModel = new UpdateScopeOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .scopeId("testString")
      .name("updated name of scope")
      .description("updated scope description")
      .build();

    // Invoke updateScope() with a valid options model and verify the result
    Response<Scope> response = securityAndComplianceCenterApiService.updateScope(updateScopeOptionsModel).execute();
    assertNotNull(response);
    Scope responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateScopePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateScope operation with and without retries enabled
  @Test
  public void testUpdateScopeWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testUpdateScopeWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testUpdateScopeWOptions();
  }

  // Test the updateScope operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateScopeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.updateScope(null).execute();
  }

  // Test the getScope operation with a valid options model parameter
  @Test
  public void testGetScopeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"environment\": \"environment\", \"properties\": [{\"name\": \"name\", \"value\": \"anyValue\"}], \"account_id\": \"accountId\", \"instance_id\": \"instanceId\", \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"attachment_count\": 15}";
    String getScopePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/scopes/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetScopeOptions model
    GetScopeOptions getScopeOptionsModel = new GetScopeOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .scopeId("testString")
      .build();

    // Invoke getScope() with a valid options model and verify the result
    Response<Scope> response = securityAndComplianceCenterApiService.getScope(getScopeOptionsModel).execute();
    assertNotNull(response);
    Scope responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getScopePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getScope operation with and without retries enabled
  @Test
  public void testGetScopeWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetScopeWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetScopeWOptions();
  }

  // Test the getScope operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetScopeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getScope(null).execute();
  }

  // Test the deleteScope operation with a valid options model parameter
  @Test
  public void testDeleteScopeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteScopePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/scopes/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteScopeOptions model
    DeleteScopeOptions deleteScopeOptionsModel = new DeleteScopeOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .scopeId("testString")
      .build();

    // Invoke deleteScope() with a valid options model and verify the result
    Response<Void> response = securityAndComplianceCenterApiService.deleteScope(deleteScopeOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteScopePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteScope operation with and without retries enabled
  @Test
  public void testDeleteScopeWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testDeleteScopeWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testDeleteScopeWOptions();
  }

  // Test the deleteScope operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteScopeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.deleteScope(null).execute();
  }

  // Test the createSubscope operation with a valid options model parameter
  @Test
  public void testCreateSubscopeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"subscopes\": [{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"environment\": \"environment\", \"properties\": [{\"name\": \"name\", \"value\": \"anyValue\"}]}]}";
    String createSubscopePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/scopes/testString/subscopes";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the ScopePropertyScopeAny model
    ScopePropertyScopeAny scopePropertyModel = new ScopePropertyScopeAny.Builder()
      .name("scope_id")
      .value("1f689f08ec9b47b885c2659c17029581")
      .build();

    // Construct an instance of the ScopePrototype model
    ScopePrototype scopePrototypeModel = new ScopePrototype.Builder()
      .name("ibm subscope update")
      .description("The subscope that is defined for IBM resources.")
      .environment("ibm-cloud")
      .xProperties(java.util.Arrays.asList(scopePropertyModel))
      .build();

    // Construct an instance of the CreateSubscopeOptions model
    CreateSubscopeOptions createSubscopeOptionsModel = new CreateSubscopeOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .scopeId("testString")
      .subscopes(java.util.Arrays.asList(scopePrototypeModel))
      .build();

    // Invoke createSubscope() with a valid options model and verify the result
    Response<SubScopeResponse> response = securityAndComplianceCenterApiService.createSubscope(createSubscopeOptionsModel).execute();
    assertNotNull(response);
    SubScopeResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createSubscopePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createSubscope operation with and without retries enabled
  @Test
  public void testCreateSubscopeWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testCreateSubscopeWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testCreateSubscopeWOptions();
  }

  // Test the createSubscope operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateSubscopeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.createSubscope(null).execute();
  }

  // Test the listSubscopes operation with a valid options model parameter
  @Test
  public void testListSubscopesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 50, \"total_count\": 230, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"subscopes\": [{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"environment\": \"environment\", \"properties\": [{\"name\": \"name\", \"value\": \"anyValue\"}]}]}";
    String listSubscopesPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/scopes/testString/subscopes";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListSubscopesOptions model
    ListSubscopesOptions listSubscopesOptionsModel = new ListSubscopesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .scopeId("testString")
      .limit(Long.valueOf("10"))
      .start("testString")
      .name("testString")
      .description("testString")
      .environment("testString")
      .build();

    // Invoke listSubscopes() with a valid options model and verify the result
    Response<SubScopeCollection> response = securityAndComplianceCenterApiService.listSubscopes(listSubscopesOptionsModel).execute();
    assertNotNull(response);
    SubScopeCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listSubscopesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
    assertEquals(query.get("name"), "testString");
    assertEquals(query.get("description"), "testString");
    assertEquals(query.get("environment"), "testString");
  }

  // Test the listSubscopes operation with and without retries enabled
  @Test
  public void testListSubscopesWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListSubscopesWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListSubscopesWOptions();
  }

  // Test the listSubscopes operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListSubscopesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.listSubscopes(null).execute();
  }

  // Test the listSubscopes operation using the SubscopesPager.getNext() method
  @Test
  public void testListSubscopesWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"subscopes\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"anyValue\"}]}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"subscopes\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"anyValue\"}]}],\"total_count\":2,\"limit\":1}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListSubscopesOptions listSubscopesOptions = new ListSubscopesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .scopeId("testString")
      .limit(Long.valueOf("10"))
      .name("testString")
      .description("testString")
      .environment("testString")
      .build();

    List<SubScope> allResults = new ArrayList<>();
    SubscopesPager pager = new SubscopesPager(securityAndComplianceCenterApiService, listSubscopesOptions);
    while (pager.hasNext()) {
      List<SubScope> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listSubscopes operation using the SubscopesPager.getAll() method
  @Test
  public void testListSubscopesWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"subscopes\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"anyValue\"}]}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"subscopes\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"anyValue\"}]}],\"total_count\":2,\"limit\":1}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListSubscopesOptions listSubscopesOptions = new ListSubscopesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .scopeId("testString")
      .limit(Long.valueOf("10"))
      .name("testString")
      .description("testString")
      .environment("testString")
      .build();

    SubscopesPager pager = new SubscopesPager(securityAndComplianceCenterApiService, listSubscopesOptions);
    List<SubScope> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getSubscope operation with a valid options model parameter
  @Test
  public void testGetSubscopeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"environment\": \"environment\", \"properties\": [{\"name\": \"name\", \"value\": \"anyValue\"}]}";
    String getSubscopePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/scopes/testString/subscopes/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSubscopeOptions model
    GetSubscopeOptions getSubscopeOptionsModel = new GetSubscopeOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .scopeId("testString")
      .subscopeId("testString")
      .build();

    // Invoke getSubscope() with a valid options model and verify the result
    Response<SubScope> response = securityAndComplianceCenterApiService.getSubscope(getSubscopeOptionsModel).execute();
    assertNotNull(response);
    SubScope responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSubscopePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getSubscope operation with and without retries enabled
  @Test
  public void testGetSubscopeWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetSubscopeWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetSubscopeWOptions();
  }

  // Test the getSubscope operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSubscopeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getSubscope(null).execute();
  }

  // Test the updateSubscope operation with a valid options model parameter
  @Test
  public void testUpdateSubscopeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"environment\": \"environment\", \"properties\": [{\"name\": \"name\", \"value\": \"anyValue\"}]}";
    String updateSubscopePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/scopes/testString/subscopes/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateSubscopeOptions model
    UpdateSubscopeOptions updateSubscopeOptionsModel = new UpdateSubscopeOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .scopeId("testString")
      .subscopeId("testString")
      .name("updated name of scope")
      .description("updated scope description")
      .build();

    // Invoke updateSubscope() with a valid options model and verify the result
    Response<SubScope> response = securityAndComplianceCenterApiService.updateSubscope(updateSubscopeOptionsModel).execute();
    assertNotNull(response);
    SubScope responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateSubscopePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateSubscope operation with and without retries enabled
  @Test
  public void testUpdateSubscopeWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testUpdateSubscopeWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testUpdateSubscopeWOptions();
  }

  // Test the updateSubscope operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateSubscopeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.updateSubscope(null).execute();
  }

  // Test the deleteSubscope operation with a valid options model parameter
  @Test
  public void testDeleteSubscopeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteSubscopePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/scopes/testString/subscopes/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteSubscopeOptions model
    DeleteSubscopeOptions deleteSubscopeOptionsModel = new DeleteSubscopeOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .scopeId("testString")
      .subscopeId("testString")
      .build();

    // Invoke deleteSubscope() with a valid options model and verify the result
    Response<Void> response = securityAndComplianceCenterApiService.deleteSubscope(deleteSubscopeOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteSubscopePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteSubscope operation with and without retries enabled
  @Test
  public void testDeleteSubscopeWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testDeleteSubscopeWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testDeleteSubscopeWOptions();
  }

  // Test the deleteSubscope operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteSubscopeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.deleteSubscope(null).execute();
  }

  // Test the createTarget operation with a valid options model parameter
  @Test
  public void testCreateTargetWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"a2366444-ad87-40b1-81d0-476df1cc1f18\", \"account_id\": \"be200c80cabc456e91139e4152327823\", \"trusted_profile_id\": \"Profile-a0a4c149-4fed-47ff-bfb2-680bcfaa64d3\", \"name\": \"Target Account-A\", \"credentials\": [{\"type\": \"iam_credentials\", \"secret_crn\": \"secretCrn\", \"secret_name\": \"my secret\", \"resources\": [{\"report_id\": \"30b434b3-cb08-4845-af10-7a8fc682b6a8\", \"home_account_id\": \"2411ffdc16844b07b42521c3443f456d\", \"id\": \"crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::\", \"resource_name\": \"jeff's key\", \"account\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"NIST\", \"type\": \"account_type\"}, \"component_id\": \"cloud-object_storage\", \"component_name\": \"cloud-object_storage\", \"environment\": \"ibm cloud\", \"tags\": {\"user\": [\"user\"], \"access\": [\"access\"], \"service\": [\"service\"]}, \"status\": \"compliant\", \"total_count\": 140, \"pass_count\": 123, \"failure_count\": 12, \"error_count\": 5, \"skipped_count\": 7, \"completed_count\": 135, \"service_name\": \"pm-20\", \"instance_crn\": \"instanceCrn\"}]}], \"created_by\": \"IBMid-270007EPPC\", \"created_on\": \"2024-02-07T05:42:58.000Z\", \"updated_by\": \"IBMid-270007EPPC\", \"updated_on\": \"2024-02-07T05:42:58.000Z\"}";
    String createTargetPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/targets";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the Account model
    Account accountModel = new Account.Builder()
      .id("531fc3e28bfc43c5a2cea07786d93f5c")
      .name("NIST")
      .type("account_type")
      .build();

    // Construct an instance of the Tags model
    Tags tagsModel = new Tags.Builder()
      .user(java.util.Arrays.asList("testString"))
      .access(java.util.Arrays.asList("testString"))
      .service(java.util.Arrays.asList("testString"))
      .build();

    // Construct an instance of the Resource model
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

    // Construct an instance of the Credential model
    Credential credentialModel = new Credential.Builder()
      .secretCrn("testString")
      .resources(java.util.Arrays.asList(resourceModel))
      .build();

    // Construct an instance of the CreateTargetOptions model
    CreateTargetOptions createTargetOptionsModel = new CreateTargetOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .accountId("62ecf99b240144dea9125666249edfcb")
      .trustedProfileId("Profile-cb2c1829-9a8d-4218-b9cd-9f83fc814e54")
      .name("Target for IBM account")
      .credentials(java.util.Arrays.asList(credentialModel))
      .build();

    // Invoke createTarget() with a valid options model and verify the result
    Response<Target> response = securityAndComplianceCenterApiService.createTarget(createTargetOptionsModel).execute();
    assertNotNull(response);
    Target responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createTargetPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createTarget operation with and without retries enabled
  @Test
  public void testCreateTargetWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testCreateTargetWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testCreateTargetWOptions();
  }

  // Test the createTarget operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTargetNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.createTarget(null).execute();
  }

  // Test the listTargets operation with a valid options model parameter
  @Test
  public void testListTargetsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 50, \"total_count\": 230, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"targets\": [{\"id\": \"a2366444-ad87-40b1-81d0-476df1cc1f18\", \"account_id\": \"be200c80cabc456e91139e4152327823\", \"trusted_profile_id\": \"Profile-a0a4c149-4fed-47ff-bfb2-680bcfaa64d3\", \"name\": \"Target Account-A\", \"credentials\": [{\"type\": \"iam_credentials\", \"secret_crn\": \"secretCrn\", \"secret_name\": \"my secret\", \"resources\": [{\"report_id\": \"30b434b3-cb08-4845-af10-7a8fc682b6a8\", \"home_account_id\": \"2411ffdc16844b07b42521c3443f456d\", \"id\": \"crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::\", \"resource_name\": \"jeff's key\", \"account\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"NIST\", \"type\": \"account_type\"}, \"component_id\": \"cloud-object_storage\", \"component_name\": \"cloud-object_storage\", \"environment\": \"ibm cloud\", \"tags\": {\"user\": [\"user\"], \"access\": [\"access\"], \"service\": [\"service\"]}, \"status\": \"compliant\", \"total_count\": 140, \"pass_count\": 123, \"failure_count\": 12, \"error_count\": 5, \"skipped_count\": 7, \"completed_count\": 135, \"service_name\": \"pm-20\", \"instance_crn\": \"instanceCrn\"}]}], \"created_by\": \"IBMid-270007EPPC\", \"created_on\": \"2024-02-07T05:42:58.000Z\", \"updated_by\": \"IBMid-270007EPPC\", \"updated_on\": \"2024-02-07T05:42:58.000Z\"}]}";
    String listTargetsPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/targets";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListTargetsOptions model
    ListTargetsOptions listTargetsOptionsModel = new ListTargetsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .build();

    // Invoke listTargets() with a valid options model and verify the result
    Response<TargetCollection> response = securityAndComplianceCenterApiService.listTargets(listTargetsOptionsModel).execute();
    assertNotNull(response);
    TargetCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listTargetsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listTargets operation with and without retries enabled
  @Test
  public void testListTargetsWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListTargetsWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListTargetsWOptions();
  }

  // Test the listTargets operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListTargetsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.listTargets(null).execute();
  }

  // Test the getTarget operation with a valid options model parameter
  @Test
  public void testGetTargetWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"a2366444-ad87-40b1-81d0-476df1cc1f18\", \"account_id\": \"be200c80cabc456e91139e4152327823\", \"trusted_profile_id\": \"Profile-a0a4c149-4fed-47ff-bfb2-680bcfaa64d3\", \"name\": \"Target Account-A\", \"credentials\": [{\"type\": \"iam_credentials\", \"secret_crn\": \"secretCrn\", \"secret_name\": \"my secret\", \"resources\": [{\"report_id\": \"30b434b3-cb08-4845-af10-7a8fc682b6a8\", \"home_account_id\": \"2411ffdc16844b07b42521c3443f456d\", \"id\": \"crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::\", \"resource_name\": \"jeff's key\", \"account\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"NIST\", \"type\": \"account_type\"}, \"component_id\": \"cloud-object_storage\", \"component_name\": \"cloud-object_storage\", \"environment\": \"ibm cloud\", \"tags\": {\"user\": [\"user\"], \"access\": [\"access\"], \"service\": [\"service\"]}, \"status\": \"compliant\", \"total_count\": 140, \"pass_count\": 123, \"failure_count\": 12, \"error_count\": 5, \"skipped_count\": 7, \"completed_count\": 135, \"service_name\": \"pm-20\", \"instance_crn\": \"instanceCrn\"}]}], \"created_by\": \"IBMid-270007EPPC\", \"created_on\": \"2024-02-07T05:42:58.000Z\", \"updated_by\": \"IBMid-270007EPPC\", \"updated_on\": \"2024-02-07T05:42:58.000Z\"}";
    String getTargetPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/targets/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetTargetOptions model
    GetTargetOptions getTargetOptionsModel = new GetTargetOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .targetId("testString")
      .build();

    // Invoke getTarget() with a valid options model and verify the result
    Response<Target> response = securityAndComplianceCenterApiService.getTarget(getTargetOptionsModel).execute();
    assertNotNull(response);
    Target responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getTargetPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getTarget operation with and without retries enabled
  @Test
  public void testGetTargetWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetTargetWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetTargetWOptions();
  }

  // Test the getTarget operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTargetNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getTarget(null).execute();
  }

  // Test the replaceTarget operation with a valid options model parameter
  @Test
  public void testReplaceTargetWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"a2366444-ad87-40b1-81d0-476df1cc1f18\", \"account_id\": \"be200c80cabc456e91139e4152327823\", \"trusted_profile_id\": \"Profile-a0a4c149-4fed-47ff-bfb2-680bcfaa64d3\", \"name\": \"Target Account-A\", \"credentials\": [{\"type\": \"iam_credentials\", \"secret_crn\": \"secretCrn\", \"secret_name\": \"my secret\", \"resources\": [{\"report_id\": \"30b434b3-cb08-4845-af10-7a8fc682b6a8\", \"home_account_id\": \"2411ffdc16844b07b42521c3443f456d\", \"id\": \"crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::\", \"resource_name\": \"jeff's key\", \"account\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"NIST\", \"type\": \"account_type\"}, \"component_id\": \"cloud-object_storage\", \"component_name\": \"cloud-object_storage\", \"environment\": \"ibm cloud\", \"tags\": {\"user\": [\"user\"], \"access\": [\"access\"], \"service\": [\"service\"]}, \"status\": \"compliant\", \"total_count\": 140, \"pass_count\": 123, \"failure_count\": 12, \"error_count\": 5, \"skipped_count\": 7, \"completed_count\": 135, \"service_name\": \"pm-20\", \"instance_crn\": \"instanceCrn\"}]}], \"created_by\": \"IBMid-270007EPPC\", \"created_on\": \"2024-02-07T05:42:58.000Z\", \"updated_by\": \"IBMid-270007EPPC\", \"updated_on\": \"2024-02-07T05:42:58.000Z\"}";
    String replaceTargetPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/targets/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the Account model
    Account accountModel = new Account.Builder()
      .id("531fc3e28bfc43c5a2cea07786d93f5c")
      .name("NIST")
      .type("account_type")
      .build();

    // Construct an instance of the Tags model
    Tags tagsModel = new Tags.Builder()
      .user(java.util.Arrays.asList("testString"))
      .access(java.util.Arrays.asList("testString"))
      .service(java.util.Arrays.asList("testString"))
      .build();

    // Construct an instance of the Resource model
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

    // Construct an instance of the Credential model
    Credential credentialModel = new Credential.Builder()
      .secretCrn("dummy")
      .resources(java.util.Arrays.asList(resourceModel))
      .build();

    // Construct an instance of the ReplaceTargetOptions model
    ReplaceTargetOptions replaceTargetOptionsModel = new ReplaceTargetOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .targetId("testString")
      .accountId("be200c80cabc456e91139e4152327823")
      .trustedProfileId("Profile-a0a4c149-4fed-47ff-bfb2-680bcfaa64d3")
      .name("Sample Target Name")
      .credentials(java.util.Arrays.asList(credentialModel))
      .build();

    // Invoke replaceTarget() with a valid options model and verify the result
    Response<Target> response = securityAndComplianceCenterApiService.replaceTarget(replaceTargetOptionsModel).execute();
    assertNotNull(response);
    Target responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceTargetPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the replaceTarget operation with and without retries enabled
  @Test
  public void testReplaceTargetWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testReplaceTargetWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testReplaceTargetWOptions();
  }

  // Test the replaceTarget operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceTargetNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.replaceTarget(null).execute();
  }

  // Test the deleteTarget operation with a valid options model parameter
  @Test
  public void testDeleteTargetWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteTargetPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/targets/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteTargetOptions model
    DeleteTargetOptions deleteTargetOptionsModel = new DeleteTargetOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .targetId("testString")
      .build();

    // Invoke deleteTarget() with a valid options model and verify the result
    Response<Void> response = securityAndComplianceCenterApiService.deleteTarget(deleteTargetOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTargetPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteTarget operation with and without retries enabled
  @Test
  public void testDeleteTargetWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testDeleteTargetWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testDeleteTargetWOptions();
  }

  // Test the deleteTarget operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTargetNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.deleteTarget(null).execute();
  }

  // Test the createProviderTypeInstance operation with a valid options model parameter
  @Test
  public void testCreateProviderTypeInstanceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"7588190cce3c05ac8f7942ea597dafce\", \"type\": \"workload-protection\", \"name\": \"workload-protection-instance-1\", \"attributes\": {\"anyKey\": \"anyValue\"}, \"created_at\": \"2023-07-24T13:14:18.884Z\", \"updated_at\": \"2023-07-24T13:14:18.884Z\"}";
    String createProviderTypeInstancePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/provider_types/3e25966275dccfa2c3a34786919c5af7/provider_type_instances";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateProviderTypeInstanceOptions model
    CreateProviderTypeInstanceOptions createProviderTypeInstanceOptionsModel = new CreateProviderTypeInstanceOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
      .name("workload-protection-instance-1")
      .attributes(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();

    // Invoke createProviderTypeInstance() with a valid options model and verify the result
    Response<ProviderTypeInstance> response = securityAndComplianceCenterApiService.createProviderTypeInstance(createProviderTypeInstanceOptionsModel).execute();
    assertNotNull(response);
    ProviderTypeInstance responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createProviderTypeInstancePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createProviderTypeInstance operation with and without retries enabled
  @Test
  public void testCreateProviderTypeInstanceWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testCreateProviderTypeInstanceWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testCreateProviderTypeInstanceWOptions();
  }

  // Test the createProviderTypeInstance operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateProviderTypeInstanceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.createProviderTypeInstance(null).execute();
  }

  // Test the listProviderTypeInstances operation with a valid options model parameter
  @Test
  public void testListProviderTypeInstancesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"provider_type_instances\": [{\"id\": \"7588190cce3c05ac8f7942ea597dafce\", \"type\": \"workload-protection\", \"name\": \"workload-protection-instance-1\", \"attributes\": {\"anyKey\": \"anyValue\"}, \"created_at\": \"2023-07-24T13:14:18.884Z\", \"updated_at\": \"2023-07-24T13:14:18.884Z\"}]}";
    String listProviderTypeInstancesPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/provider_types/3e25966275dccfa2c3a34786919c5af7/provider_type_instances";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListProviderTypeInstancesOptions model
    ListProviderTypeInstancesOptions listProviderTypeInstancesOptionsModel = new ListProviderTypeInstancesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
      .build();

    // Invoke listProviderTypeInstances() with a valid options model and verify the result
    Response<ProviderTypeInstanceCollection> response = securityAndComplianceCenterApiService.listProviderTypeInstances(listProviderTypeInstancesOptionsModel).execute();
    assertNotNull(response);
    ProviderTypeInstanceCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listProviderTypeInstancesPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listProviderTypeInstances operation with and without retries enabled
  @Test
  public void testListProviderTypeInstancesWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListProviderTypeInstancesWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListProviderTypeInstancesWOptions();
  }

  // Test the listProviderTypeInstances operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListProviderTypeInstancesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.listProviderTypeInstances(null).execute();
  }

  // Test the getProviderTypeInstance operation with a valid options model parameter
  @Test
  public void testGetProviderTypeInstanceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"7588190cce3c05ac8f7942ea597dafce\", \"type\": \"workload-protection\", \"name\": \"workload-protection-instance-1\", \"attributes\": {\"anyKey\": \"anyValue\"}, \"created_at\": \"2023-07-24T13:14:18.884Z\", \"updated_at\": \"2023-07-24T13:14:18.884Z\"}";
    String getProviderTypeInstancePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/provider_types/3e25966275dccfa2c3a34786919c5af7/provider_type_instances/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetProviderTypeInstanceOptions model
    GetProviderTypeInstanceOptions getProviderTypeInstanceOptionsModel = new GetProviderTypeInstanceOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
      .providerTypeInstanceId("testString")
      .build();

    // Invoke getProviderTypeInstance() with a valid options model and verify the result
    Response<ProviderTypeInstance> response = securityAndComplianceCenterApiService.getProviderTypeInstance(getProviderTypeInstanceOptionsModel).execute();
    assertNotNull(response);
    ProviderTypeInstance responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getProviderTypeInstancePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getProviderTypeInstance operation with and without retries enabled
  @Test
  public void testGetProviderTypeInstanceWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetProviderTypeInstanceWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetProviderTypeInstanceWOptions();
  }

  // Test the getProviderTypeInstance operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetProviderTypeInstanceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getProviderTypeInstance(null).execute();
  }

  // Test the updateProviderTypeInstance operation with a valid options model parameter
  @Test
  public void testUpdateProviderTypeInstanceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"7588190cce3c05ac8f7942ea597dafce\", \"type\": \"workload-protection\", \"name\": \"workload-protection-instance-1\", \"attributes\": {\"anyKey\": \"anyValue\"}, \"created_at\": \"2023-07-24T13:14:18.884Z\", \"updated_at\": \"2023-07-24T13:14:18.884Z\"}";
    String updateProviderTypeInstancePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/provider_types/3e25966275dccfa2c3a34786919c5af7/provider_type_instances/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateProviderTypeInstanceOptions model
    UpdateProviderTypeInstanceOptions updateProviderTypeInstanceOptionsModel = new UpdateProviderTypeInstanceOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
      .providerTypeInstanceId("testString")
      .name("workload-protection-instance-1")
      .attributes(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();

    // Invoke updateProviderTypeInstance() with a valid options model and verify the result
    Response<ProviderTypeInstance> response = securityAndComplianceCenterApiService.updateProviderTypeInstance(updateProviderTypeInstanceOptionsModel).execute();
    assertNotNull(response);
    ProviderTypeInstance responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateProviderTypeInstancePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateProviderTypeInstance operation with and without retries enabled
  @Test
  public void testUpdateProviderTypeInstanceWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testUpdateProviderTypeInstanceWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testUpdateProviderTypeInstanceWOptions();
  }

  // Test the updateProviderTypeInstance operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateProviderTypeInstanceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.updateProviderTypeInstance(null).execute();
  }

  // Test the deleteProviderTypeInstance operation with a valid options model parameter
  @Test
  public void testDeleteProviderTypeInstanceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteProviderTypeInstancePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/provider_types/3e25966275dccfa2c3a34786919c5af7/provider_type_instances/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteProviderTypeInstanceOptions model
    DeleteProviderTypeInstanceOptions deleteProviderTypeInstanceOptionsModel = new DeleteProviderTypeInstanceOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
      .providerTypeInstanceId("testString")
      .build();

    // Invoke deleteProviderTypeInstance() with a valid options model and verify the result
    Response<Void> response = securityAndComplianceCenterApiService.deleteProviderTypeInstance(deleteProviderTypeInstanceOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteProviderTypeInstancePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteProviderTypeInstance operation with and without retries enabled
  @Test
  public void testDeleteProviderTypeInstanceWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testDeleteProviderTypeInstanceWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testDeleteProviderTypeInstanceWOptions();
  }

  // Test the deleteProviderTypeInstance operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteProviderTypeInstanceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.deleteProviderTypeInstance(null).execute();
  }

  // Test the listProviderTypes operation with a valid options model parameter
  @Test
  public void testListProviderTypesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"provider_types\": [{\"id\": \"7588190cce3c05ac8f7942ea597dafce\", \"type\": \"workload-protection\", \"name\": \"workload-protection\", \"description\": \"Security and Compliance Center Workload Protection helps you accelerate your Kubernetes and cloud adoption by addressing security and regulatory compliance. Easily identify vulnerabilities, check compliance, block threats and respond faster at every stage of the container and Kubernetes lifecycle.\", \"s2s_enabled\": true, \"instance_limit\": 1, \"mode\": \"PULL\", \"data_type\": \"com.sysdig.secure.results\", \"icon\": \"PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiBkYXRhLW5hbWU9IkJ1aWxkIGljb24gaGVyZSIgdmlld0JveD0iMCAwIDMyIDMyIj48ZGVmcz48bGluZWFyR3JhZGllbnQgaWQ9ImEiIHgxPSItMjgxMS4xOTgiIHgyPSItMjgxNC4xOTgiIHkxPSI1NTcuNTE3IiB5Mj0iNTU3LjUxNyIgZ3JhZGllbnRUcmFuc2Zvcm09InRyYW5zbGF0ZSgyODMxLjE5OCAtNTQyLjAxNykiIGdyYWRpZW50VW5pdHM9InVzZXJTcGFjZU9uVXNlIj48c3RvcCBvZmZzZXQ9Ii4xIiBzdG9wLW9wYWNpdHk9IjAiLz48c3RvcCBvZmZzZXQ9Ii44Ii8+PC9saW5lYXJHcmFkaWVudD48bGluZWFyR3JhZGllbnQgeGxpbms6aHJlZj0iI2EiIGlkPSJiIiB4MT0iLTgwNi4xOTgiIHgyPSItNzk5LjE5OCIgeTE9Ii0yNDE0LjQ4MSIgeTI9Ii0yNDE0LjQ4MSIgZ3JhZGllbnRUcmFuc2Zvcm09InRyYW5zbGF0ZSg4MjUuMTk4IDI0MjguOTgxKSIvPjxsaW5lYXJHcmFkaWVudCB4bGluazpocmVmPSIjYSIgaWQ9ImMiIHgxPSItODEwLjE5OCIgeDI9Ii03OTguMTk4IiB5MT0iLTI0MTkuOTgxIiB5Mj0iLTI0MTkuOTgxIiBncmFkaWVudFRyYW5zZm9ybT0idHJhbnNsYXRlKDgzMi4xOTggMjQzMi45ODEpIi8+PGxpbmVhckdyYWRpZW50IGlkPSJlIiB4MT0iLTI1MTQiIHgyPSItMjQ4MiIgeTE9Ii0yNDgyIiB5Mj0iLTI1MTQiIGdyYWRpZW50VHJhbnNmb3JtPSJtYXRyaXgoMSAwIDAgLTEgMjUxNCAtMjQ4MikiIGdyYWRpZW50VW5pdHM9InVzZXJTcGFjZU9uVXNlIj48c3RvcCBvZmZzZXQ9Ii4xIiBzdG9wLWNvbG9yPSIjMDhiZGJhIi8+PHN0b3Agb2Zmc2V0PSIuOSIgc3RvcC1jb2xvcj0iIzBmNjJmZSIvPjwvbGluZWFyR3JhZGllbnQ+PG1hc2sgaWQ9ImQiIHdpZHRoPSIyOS4wMTciIGhlaWdodD0iMjcuOTk2IiB4PSIxLjk4MyIgeT0iMiIgZGF0YS1uYW1lPSJtYXNrIiBtYXNrVW5pdHM9InVzZXJTcGFjZU9uVXNlIj48ZyBmaWxsPSIjZmZmIj48cGF0aCBkPSJNMjkuOTc2IDE2YzAtMy43MzktMS40NTYtNy4yNTUtNC4xMDEtOS44OTlTMTkuNzE1IDIgMTUuOTc2IDIgOC43MjEgMy40NTYgNi4wNzcgNi4xMDFjLTUuNDU5IDUuNDU5LTUuNDU5IDE0LjM0IDAgMTkuNzk4QTE0LjA0NCAxNC4wNDQgMCAwIDAgMTYgMjkuOTk1di0yLjAwMWExMi4wNCAxMi4wNCAwIDAgMS04LjUwOS0zLjUxYy00LjY3OS00LjY3OS00LjY3OS0xMi4yOTIgMC0xNi45NzEgMi4yNjctMi4yNjcgNS4yOC0zLjUxNSA4LjQ4NS0zLjUxNXM2LjIxOSAxLjI0OCA4LjQ4NSAzLjUxNSAzLjUxNSA1LjI4IDMuNTE1IDguNDg1YzAgMS4zMDgtLjIxOCAyLjU4LS42MTggMy43ODZsMS44OTcuNjMyYy40NjctMS40MDguNzIyLTIuODkyLjcyMi00LjQxOFoiLz48cGF0aCBkPSJNMjQuNyAxMy42NzVhOC45NCA4Ljk0IDAgMCAwLTQuMTkzLTUuNDY1IDguOTQyIDguOTQyIDAgMCAwLTYuODMtLjg5OSA4Ljk3MSA4Ljk3MSAwIDAgMC01LjQ2MSA0LjE5NSA4Ljk4IDguOTggMCAwIDAtLjkwMyA2LjgyOGMxLjA3NyA0LjAxNiA0LjcyMiA2LjY2IDguNjk1IDYuNjYxdi0xLjk5OGMtMy4wOS0uMDAxLTUuOTI2LTIuMDU4LTYuNzYzLTUuMTgxYTcuMDEgNy4wMSAwIDAgMSA0Ljk1LTguNTc0IDYuOTU4IDYuOTU4IDAgMCAxIDUuMzEyLjY5OSA2Ljk1NCA2Ljk1NCAwIDAgMSAzLjI2MSA0LjI1Yy4zNTkgMS4zNDIuMjc1IDIuNzMyLS4xNTQgNC4wMTNsMS45MDkuNjM2YTguOTU5IDguOTU5IDAgMCAwIC4xNzYtNS4xNjdaIi8+PC9nPjxwYXRoIGZpbGw9IiNmZmYiIGQ9Ik0xNCAxNmMwLTEuMTAzLjg5Ny0yIDItMnMyIC44OTcgMiAyYTIgMiAwIDAgMS0uMTExLjYzbDEuODg5LjYzYy4xMzMtLjM5OC4yMjItLjgxNy4yMjItMS4yNTlhNCA0IDAgMSAwLTQgNHYtMmMtMS4xMDMgMC0yLS44OTctMi0yWiIvPjxwYXRoIGZpbGw9InVybCgjYSkiIGQ9Ik0xNyAxNGgzdjNoLTN6IiB0cmFuc2Zvcm09InJvdGF0ZSgtOTAgMTguNSAxNS41KSIvPjxwYXRoIGZpbGw9InVybCgjYikiIGQ9Ik0xOSAxMmg3djVoLTd6IiB0cmFuc2Zvcm09InJvdGF0ZSg5MCAyMi41IDE0LjUpIi8+PHBhdGggZmlsbD0idXJsKCNjKSIgZD0iTTIyIDEwaDEydjZIMjJ6IiB0cmFuc2Zvcm09InJvdGF0ZSg5MCAyOCAxMykiLz48cGF0aCBkPSJNMjUgMTloNnY0aC02ek0yMCAxOGg1djVoLTV6TTE3IDE3aDN2NmgtM3oiLz48L21hc2s+PC9kZWZzPjxwYXRoIGZpbGw9IiMwMDFkNmMiIGQ9Im0yNSAzMS4wMDEtMi4xMzktMS4wMTNBNS4wMjIgNS4wMjIgMCAwIDEgMjAgMjUuNDY4VjE5aDEwdjYuNDY4YTUuMDIzIDUuMDIzIDAgMCAxLTIuODYxIDQuNTJMMjUgMzEuMDAxWm0tMy0xMHY0LjQ2OGMwIDEuMTUzLjY3NCAyLjIxOCAxLjcxNyAyLjcxMWwxLjI4My42MDcgMS4yODMtLjYwN0EzLjAxMiAzLjAxMiAwIDAgMCAyOCAyNS40Njl2LTQuNDY4aC02WiIgZGF0YS1uYW1lPSJ1dWlkLTU1ODMwNDRiLWZmMjQtNGUyNy05MDU0LTI0MDQzYWRkZmMwNiIvPjxnIG1hc2s9InVybCgjZCkiPjxwYXRoIGZpbGw9InVybCgjZSkiIGQ9Ik0wIDBoMzJ2MzJIMHoiIHRyYW5zZm9ybT0icm90YXRlKC05MCAxNiAxNikiLz48L2c+PC9zdmc+\", \"label\": {\"text\": \"1 per instance\", \"tip\": \"Only 1 per instance\"}, \"attributes\": {\"mapKey\": {\"type\": \"text\", \"display_name\": \"Workload Protection Instance CRN\"}}, \"created_at\": \"2023-07-24T13:14:18.884Z\", \"updated_at\": \"2023-07-24T13:14:18.884Z\"}]}";
    String listProviderTypesPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/provider_types";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListProviderTypesOptions model
    ListProviderTypesOptions listProviderTypesOptionsModel = new ListProviderTypesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .build();

    // Invoke listProviderTypes() with a valid options model and verify the result
    Response<ProviderTypeCollection> response = securityAndComplianceCenterApiService.listProviderTypes(listProviderTypesOptionsModel).execute();
    assertNotNull(response);
    ProviderTypeCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listProviderTypesPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listProviderTypes operation with and without retries enabled
  @Test
  public void testListProviderTypesWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListProviderTypesWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListProviderTypesWOptions();
  }

  // Test the listProviderTypes operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListProviderTypesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.listProviderTypes(null).execute();
  }

  // Test the getProviderTypeById operation with a valid options model parameter
  @Test
  public void testGetProviderTypeByIdWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"7588190cce3c05ac8f7942ea597dafce\", \"type\": \"workload-protection\", \"name\": \"workload-protection\", \"description\": \"Security and Compliance Center Workload Protection helps you accelerate your Kubernetes and cloud adoption by addressing security and regulatory compliance. Easily identify vulnerabilities, check compliance, block threats and respond faster at every stage of the container and Kubernetes lifecycle.\", \"s2s_enabled\": true, \"instance_limit\": 1, \"mode\": \"PULL\", \"data_type\": \"com.sysdig.secure.results\", \"icon\": \"PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiBkYXRhLW5hbWU9IkJ1aWxkIGljb24gaGVyZSIgdmlld0JveD0iMCAwIDMyIDMyIj48ZGVmcz48bGluZWFyR3JhZGllbnQgaWQ9ImEiIHgxPSItMjgxMS4xOTgiIHgyPSItMjgxNC4xOTgiIHkxPSI1NTcuNTE3IiB5Mj0iNTU3LjUxNyIgZ3JhZGllbnRUcmFuc2Zvcm09InRyYW5zbGF0ZSgyODMxLjE5OCAtNTQyLjAxNykiIGdyYWRpZW50VW5pdHM9InVzZXJTcGFjZU9uVXNlIj48c3RvcCBvZmZzZXQ9Ii4xIiBzdG9wLW9wYWNpdHk9IjAiLz48c3RvcCBvZmZzZXQ9Ii44Ii8+PC9saW5lYXJHcmFkaWVudD48bGluZWFyR3JhZGllbnQgeGxpbms6aHJlZj0iI2EiIGlkPSJiIiB4MT0iLTgwNi4xOTgiIHgyPSItNzk5LjE5OCIgeTE9Ii0yNDE0LjQ4MSIgeTI9Ii0yNDE0LjQ4MSIgZ3JhZGllbnRUcmFuc2Zvcm09InRyYW5zbGF0ZSg4MjUuMTk4IDI0MjguOTgxKSIvPjxsaW5lYXJHcmFkaWVudCB4bGluazpocmVmPSIjYSIgaWQ9ImMiIHgxPSItODEwLjE5OCIgeDI9Ii03OTguMTk4IiB5MT0iLTI0MTkuOTgxIiB5Mj0iLTI0MTkuOTgxIiBncmFkaWVudFRyYW5zZm9ybT0idHJhbnNsYXRlKDgzMi4xOTggMjQzMi45ODEpIi8+PGxpbmVhckdyYWRpZW50IGlkPSJlIiB4MT0iLTI1MTQiIHgyPSItMjQ4MiIgeTE9Ii0yNDgyIiB5Mj0iLTI1MTQiIGdyYWRpZW50VHJhbnNmb3JtPSJtYXRyaXgoMSAwIDAgLTEgMjUxNCAtMjQ4MikiIGdyYWRpZW50VW5pdHM9InVzZXJTcGFjZU9uVXNlIj48c3RvcCBvZmZzZXQ9Ii4xIiBzdG9wLWNvbG9yPSIjMDhiZGJhIi8+PHN0b3Agb2Zmc2V0PSIuOSIgc3RvcC1jb2xvcj0iIzBmNjJmZSIvPjwvbGluZWFyR3JhZGllbnQ+PG1hc2sgaWQ9ImQiIHdpZHRoPSIyOS4wMTciIGhlaWdodD0iMjcuOTk2IiB4PSIxLjk4MyIgeT0iMiIgZGF0YS1uYW1lPSJtYXNrIiBtYXNrVW5pdHM9InVzZXJTcGFjZU9uVXNlIj48ZyBmaWxsPSIjZmZmIj48cGF0aCBkPSJNMjkuOTc2IDE2YzAtMy43MzktMS40NTYtNy4yNTUtNC4xMDEtOS44OTlTMTkuNzE1IDIgMTUuOTc2IDIgOC43MjEgMy40NTYgNi4wNzcgNi4xMDFjLTUuNDU5IDUuNDU5LTUuNDU5IDE0LjM0IDAgMTkuNzk4QTE0LjA0NCAxNC4wNDQgMCAwIDAgMTYgMjkuOTk1di0yLjAwMWExMi4wNCAxMi4wNCAwIDAgMS04LjUwOS0zLjUxYy00LjY3OS00LjY3OS00LjY3OS0xMi4yOTIgMC0xNi45NzEgMi4yNjctMi4yNjcgNS4yOC0zLjUxNSA4LjQ4NS0zLjUxNXM2LjIxOSAxLjI0OCA4LjQ4NSAzLjUxNSAzLjUxNSA1LjI4IDMuNTE1IDguNDg1YzAgMS4zMDgtLjIxOCAyLjU4LS42MTggMy43ODZsMS44OTcuNjMyYy40NjctMS40MDguNzIyLTIuODkyLjcyMi00LjQxOFoiLz48cGF0aCBkPSJNMjQuNyAxMy42NzVhOC45NCA4Ljk0IDAgMCAwLTQuMTkzLTUuNDY1IDguOTQyIDguOTQyIDAgMCAwLTYuODMtLjg5OSA4Ljk3MSA4Ljk3MSAwIDAgMC01LjQ2MSA0LjE5NSA4Ljk4IDguOTggMCAwIDAtLjkwMyA2LjgyOGMxLjA3NyA0LjAxNiA0LjcyMiA2LjY2IDguNjk1IDYuNjYxdi0xLjk5OGMtMy4wOS0uMDAxLTUuOTI2LTIuMDU4LTYuNzYzLTUuMTgxYTcuMDEgNy4wMSAwIDAgMSA0Ljk1LTguNTc0IDYuOTU4IDYuOTU4IDAgMCAxIDUuMzEyLjY5OSA2Ljk1NCA2Ljk1NCAwIDAgMSAzLjI2MSA0LjI1Yy4zNTkgMS4zNDIuMjc1IDIuNzMyLS4xNTQgNC4wMTNsMS45MDkuNjM2YTguOTU5IDguOTU5IDAgMCAwIC4xNzYtNS4xNjdaIi8+PC9nPjxwYXRoIGZpbGw9IiNmZmYiIGQ9Ik0xNCAxNmMwLTEuMTAzLjg5Ny0yIDItMnMyIC44OTcgMiAyYTIgMiAwIDAgMS0uMTExLjYzbDEuODg5LjYzYy4xMzMtLjM5OC4yMjItLjgxNy4yMjItMS4yNTlhNCA0IDAgMSAwLTQgNHYtMmMtMS4xMDMgMC0yLS44OTctMi0yWiIvPjxwYXRoIGZpbGw9InVybCgjYSkiIGQ9Ik0xNyAxNGgzdjNoLTN6IiB0cmFuc2Zvcm09InJvdGF0ZSgtOTAgMTguNSAxNS41KSIvPjxwYXRoIGZpbGw9InVybCgjYikiIGQ9Ik0xOSAxMmg3djVoLTd6IiB0cmFuc2Zvcm09InJvdGF0ZSg5MCAyMi41IDE0LjUpIi8+PHBhdGggZmlsbD0idXJsKCNjKSIgZD0iTTIyIDEwaDEydjZIMjJ6IiB0cmFuc2Zvcm09InJvdGF0ZSg5MCAyOCAxMykiLz48cGF0aCBkPSJNMjUgMTloNnY0aC02ek0yMCAxOGg1djVoLTV6TTE3IDE3aDN2NmgtM3oiLz48L21hc2s+PC9kZWZzPjxwYXRoIGZpbGw9IiMwMDFkNmMiIGQ9Im0yNSAzMS4wMDEtMi4xMzktMS4wMTNBNS4wMjIgNS4wMjIgMCAwIDEgMjAgMjUuNDY4VjE5aDEwdjYuNDY4YTUuMDIzIDUuMDIzIDAgMCAxLTIuODYxIDQuNTJMMjUgMzEuMDAxWm0tMy0xMHY0LjQ2OGMwIDEuMTUzLjY3NCAyLjIxOCAxLjcxNyAyLjcxMWwxLjI4My42MDcgMS4yODMtLjYwN0EzLjAxMiAzLjAxMiAwIDAgMCAyOCAyNS40Njl2LTQuNDY4aC02WiIgZGF0YS1uYW1lPSJ1dWlkLTU1ODMwNDRiLWZmMjQtNGUyNy05MDU0LTI0MDQzYWRkZmMwNiIvPjxnIG1hc2s9InVybCgjZCkiPjxwYXRoIGZpbGw9InVybCgjZSkiIGQ9Ik0wIDBoMzJ2MzJIMHoiIHRyYW5zZm9ybT0icm90YXRlKC05MCAxNiAxNikiLz48L2c+PC9zdmc+\", \"label\": {\"text\": \"1 per instance\", \"tip\": \"Only 1 per instance\"}, \"attributes\": {\"mapKey\": {\"type\": \"text\", \"display_name\": \"Workload Protection Instance CRN\"}}, \"created_at\": \"2023-07-24T13:14:18.884Z\", \"updated_at\": \"2023-07-24T13:14:18.884Z\"}";
    String getProviderTypeByIdPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/provider_types/3e25966275dccfa2c3a34786919c5af7";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetProviderTypeByIdOptions model
    GetProviderTypeByIdOptions getProviderTypeByIdOptionsModel = new GetProviderTypeByIdOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
      .build();

    // Invoke getProviderTypeById() with a valid options model and verify the result
    Response<ProviderType> response = securityAndComplianceCenterApiService.getProviderTypeById(getProviderTypeByIdOptionsModel).execute();
    assertNotNull(response);
    ProviderType responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getProviderTypeByIdPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getProviderTypeById operation with and without retries enabled
  @Test
  public void testGetProviderTypeByIdWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetProviderTypeByIdWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetProviderTypeByIdWOptions();
  }

  // Test the getProviderTypeById operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetProviderTypeByIdNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getProviderTypeById(null).execute();
  }

  // Test the getLatestReports operation with a valid options model parameter
  @Test
  public void testGetLatestReportsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"home_account_id\": \"homeAccountId\", \"controls_summary\": {\"status\": \"compliant\", \"total_count\": 150, \"compliant_count\": 130, \"not_compliant_count\": 5, \"unable_to_perform_count\": 5, \"user_evaluation_required_count\": 10, \"not_applicable_count\": 7}, \"evaluations_summary\": {\"status\": \"compliant\", \"total_count\": 140, \"pass_count\": 123, \"failure_count\": 12, \"error_count\": 5, \"skipped_count\": 7, \"completed_count\": 135}, \"score\": {\"passed\": 1, \"total_count\": 4, \"percent\": 25}, \"reports\": [{\"id\": \"44a5-a292-32114fa73558\", \"type\": \"scheduled\", \"group_id\": \"55b6-b3A4-432250b84669\", \"created_on\": \"2022-08-15T12:30:01Z\", \"scan_time\": \"2022-08-15T12:30:01Z\", \"cos_object\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/531fc3e28bfc43c5a2cea07786d93f5c:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:b1a8f3da-49d2-4966-ae83-a8d02bc2aac7\", \"instance_id\": \"instanceId\", \"account\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"NIST\", \"type\": \"account_type\"}, \"profile\": {\"id\": \"44a5-a292-32114fa73558\", \"name\": \"IBM FS Cloud\", \"version\": \"0.1\"}, \"scope\": {\"id\": \"2411ffdc16844b07b42521c3443f456d\", \"type\": \"account\"}, \"attachment\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"resource group - Default\", \"description\": \"Scoped to the Default resource group\", \"schedule\": \"daily\", \"scope\": \"anyValue\", \"scopes\": [{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"environment\": \"environment\", \"properties\": [{\"name\": \"name\", \"value\": \"anyValue\"}], \"account_id\": \"accountId\", \"instance_id\": \"instanceId\", \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"attachment_count\": 15}], \"notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 15, \"failed_control_ids\": [\"failedControlIds\"]}}}, \"controls_summary\": {\"status\": \"compliant\", \"total_count\": 150, \"compliant_count\": 130, \"not_compliant_count\": 5, \"unable_to_perform_count\": 5, \"user_evaluation_required_count\": 10, \"not_applicable_count\": 7, \"not_compliant_controls\": [{\"id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"control_name\": \"ibm-cloud-rule\", \"control_description\": \"Ensure security questions are registered by the account owner\"}]}, \"evaluations_summary\": {\"status\": \"compliant\", \"total_count\": 140, \"pass_count\": 123, \"failure_count\": 12, \"error_count\": 5, \"skipped_count\": 7, \"completed_count\": 135}, \"tags\": {\"user\": [\"user\"], \"access\": [\"access\"], \"service\": [\"service\"]}, \"scopes\": [{\"id\": \"id\", \"name\": \"name\", \"href\": \"href\", \"environment\": \"environment\"}], \"additional_details\": {\"created_by\": \"Security and Compliance Center\", \"labels\": [\"labels\"], \"links\": [{\"description\": \"description\", \"href\": \"href\"}]}}]}";
    String getLatestReportsPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/reports/latest";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetLatestReportsOptions model
    GetLatestReportsOptions getLatestReportsOptionsModel = new GetLatestReportsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .sort("profile_name")
      .build();

    // Invoke getLatestReports() with a valid options model and verify the result
    Response<ReportLatest> response = securityAndComplianceCenterApiService.getLatestReports(getLatestReportsOptionsModel).execute();
    assertNotNull(response);
    ReportLatest responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getLatestReportsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("sort"), "profile_name");
  }

  // Test the getLatestReports operation with and without retries enabled
  @Test
  public void testGetLatestReportsWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetLatestReportsWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetLatestReportsWOptions();
  }

  // Test the getLatestReports operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLatestReportsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getLatestReports(null).execute();
  }

  // Test the listReports operation with a valid options model parameter
  @Test
  public void testListReportsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 50, \"total_count\": 230, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"home_account_id\": \"homeAccountId\", \"reports\": [{\"id\": \"44a5-a292-32114fa73558\", \"type\": \"scheduled\", \"group_id\": \"55b6-b3A4-432250b84669\", \"created_on\": \"2022-08-15T12:30:01Z\", \"scan_time\": \"2022-08-15T12:30:01Z\", \"cos_object\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/531fc3e28bfc43c5a2cea07786d93f5c:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:b1a8f3da-49d2-4966-ae83-a8d02bc2aac7\", \"instance_id\": \"instanceId\", \"account\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"NIST\", \"type\": \"account_type\"}, \"profile\": {\"id\": \"44a5-a292-32114fa73558\", \"name\": \"IBM FS Cloud\", \"version\": \"0.1\"}, \"scope\": {\"id\": \"2411ffdc16844b07b42521c3443f456d\", \"type\": \"account\"}, \"attachment\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"resource group - Default\", \"description\": \"Scoped to the Default resource group\", \"schedule\": \"daily\", \"scope\": \"anyValue\", \"scopes\": [{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"environment\": \"environment\", \"properties\": [{\"name\": \"name\", \"value\": \"anyValue\"}], \"account_id\": \"accountId\", \"instance_id\": \"instanceId\", \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"attachment_count\": 15}], \"notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 15, \"failed_control_ids\": [\"failedControlIds\"]}}}, \"controls_summary\": {\"status\": \"compliant\", \"total_count\": 150, \"compliant_count\": 130, \"not_compliant_count\": 5, \"unable_to_perform_count\": 5, \"user_evaluation_required_count\": 10, \"not_applicable_count\": 7, \"not_compliant_controls\": [{\"id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"control_name\": \"ibm-cloud-rule\", \"control_description\": \"Ensure security questions are registered by the account owner\"}]}, \"evaluations_summary\": {\"status\": \"compliant\", \"total_count\": 140, \"pass_count\": 123, \"failure_count\": 12, \"error_count\": 5, \"skipped_count\": 7, \"completed_count\": 135}, \"tags\": {\"user\": [\"user\"], \"access\": [\"access\"], \"service\": [\"service\"]}, \"scopes\": [{\"id\": \"id\", \"name\": \"name\", \"href\": \"href\", \"environment\": \"environment\"}], \"additional_details\": {\"created_by\": \"Security and Compliance Center\", \"labels\": [\"labels\"], \"links\": [{\"description\": \"description\", \"href\": \"href\"}]}}]}";
    String listReportsPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/reports";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListReportsOptions model
    ListReportsOptions listReportsOptionsModel = new ListReportsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportAttachmentId("testString")
      .groupId("testString")
      .reportProfileId("testString")
      .type("scheduled")
      .start("testString")
      .limit(Long.valueOf("10"))
      .sort("profile_name")
      .build();

    // Invoke listReports() with a valid options model and verify the result
    Response<ReportCollection> response = securityAndComplianceCenterApiService.listReports(listReportsOptionsModel).execute();
    assertNotNull(response);
    ReportCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listReportsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("report_attachment_id"), "testString");
    assertEquals(query.get("group_id"), "testString");
    assertEquals(query.get("report_profile_id"), "testString");
    assertEquals(query.get("type"), "scheduled");
    assertEquals(query.get("start"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("sort"), "profile_name");
  }

  // Test the listReports operation with and without retries enabled
  @Test
  public void testListReportsWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListReportsWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListReportsWOptions();
  }

  // Test the listReports operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListReportsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.listReports(null).execute();
  }

  // Test the listReports operation using the ReportsPager.getNext() method
  @Test
  public void testListReportsWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"reports\":[{\"id\":\"44a5-a292-32114fa73558\",\"type\":\"scheduled\",\"group_id\":\"55b6-b3A4-432250b84669\",\"created_on\":\"2022-08-15T12:30:01Z\",\"scan_time\":\"2022-08-15T12:30:01Z\",\"cos_object\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/531fc3e28bfc43c5a2cea07786d93f5c:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:b1a8f3da-49d2-4966-ae83-a8d02bc2aac7\",\"instance_id\":\"instanceId\",\"account\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"NIST\",\"type\":\"account_type\"},\"profile\":{\"id\":\"44a5-a292-32114fa73558\",\"name\":\"IBM FS Cloud\",\"version\":\"0.1\"},\"scope\":{\"id\":\"2411ffdc16844b07b42521c3443f456d\",\"type\":\"account\"},\"attachment\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"resource group - Default\",\"description\":\"Scoped to the Default resource group\",\"schedule\":\"daily\",\"scope\":\"anyValue\",\"scopes\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"anyValue\"}],\"account_id\":\"accountId\",\"instance_id\":\"instanceId\",\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"attachment_count\":15}],\"notifications\":{\"enabled\":false,\"controls\":{\"threshold_limit\":15,\"failed_control_ids\":[\"failedControlIds\"]}}},\"controls_summary\":{\"status\":\"compliant\",\"total_count\":150,\"compliant_count\":130,\"not_compliant_count\":5,\"unable_to_perform_count\":5,\"user_evaluation_required_count\":10,\"not_applicable_count\":7,\"not_compliant_controls\":[{\"id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"control_name\":\"ibm-cloud-rule\",\"control_description\":\"Ensure security questions are registered by the account owner\"}]},\"evaluations_summary\":{\"status\":\"compliant\",\"total_count\":140,\"pass_count\":123,\"failure_count\":12,\"error_count\":5,\"skipped_count\":7,\"completed_count\":135},\"tags\":{\"user\":[\"user\"],\"access\":[\"access\"],\"service\":[\"service\"]},\"scopes\":[{\"id\":\"id\",\"name\":\"name\",\"href\":\"href\",\"environment\":\"environment\"}],\"additional_details\":{\"created_by\":\"Security and Compliance Center\",\"labels\":[\"labels\"],\"links\":[{\"description\":\"description\",\"href\":\"href\"}]}}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"reports\":[{\"id\":\"44a5-a292-32114fa73558\",\"type\":\"scheduled\",\"group_id\":\"55b6-b3A4-432250b84669\",\"created_on\":\"2022-08-15T12:30:01Z\",\"scan_time\":\"2022-08-15T12:30:01Z\",\"cos_object\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/531fc3e28bfc43c5a2cea07786d93f5c:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:b1a8f3da-49d2-4966-ae83-a8d02bc2aac7\",\"instance_id\":\"instanceId\",\"account\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"NIST\",\"type\":\"account_type\"},\"profile\":{\"id\":\"44a5-a292-32114fa73558\",\"name\":\"IBM FS Cloud\",\"version\":\"0.1\"},\"scope\":{\"id\":\"2411ffdc16844b07b42521c3443f456d\",\"type\":\"account\"},\"attachment\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"resource group - Default\",\"description\":\"Scoped to the Default resource group\",\"schedule\":\"daily\",\"scope\":\"anyValue\",\"scopes\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"anyValue\"}],\"account_id\":\"accountId\",\"instance_id\":\"instanceId\",\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"attachment_count\":15}],\"notifications\":{\"enabled\":false,\"controls\":{\"threshold_limit\":15,\"failed_control_ids\":[\"failedControlIds\"]}}},\"controls_summary\":{\"status\":\"compliant\",\"total_count\":150,\"compliant_count\":130,\"not_compliant_count\":5,\"unable_to_perform_count\":5,\"user_evaluation_required_count\":10,\"not_applicable_count\":7,\"not_compliant_controls\":[{\"id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"control_name\":\"ibm-cloud-rule\",\"control_description\":\"Ensure security questions are registered by the account owner\"}]},\"evaluations_summary\":{\"status\":\"compliant\",\"total_count\":140,\"pass_count\":123,\"failure_count\":12,\"error_count\":5,\"skipped_count\":7,\"completed_count\":135},\"tags\":{\"user\":[\"user\"],\"access\":[\"access\"],\"service\":[\"service\"]},\"scopes\":[{\"id\":\"id\",\"name\":\"name\",\"href\":\"href\",\"environment\":\"environment\"}],\"additional_details\":{\"created_by\":\"Security and Compliance Center\",\"labels\":[\"labels\"],\"links\":[{\"description\":\"description\",\"href\":\"href\"}]}}],\"total_count\":2,\"limit\":1}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListReportsOptions listReportsOptions = new ListReportsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportAttachmentId("testString")
      .groupId("testString")
      .reportProfileId("testString")
      .type("scheduled")
      .limit(Long.valueOf("10"))
      .sort("profile_name")
      .build();

    List<Report> allResults = new ArrayList<>();
    ReportsPager pager = new ReportsPager(securityAndComplianceCenterApiService, listReportsOptions);
    while (pager.hasNext()) {
      List<Report> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listReports operation using the ReportsPager.getAll() method
  @Test
  public void testListReportsWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"reports\":[{\"id\":\"44a5-a292-32114fa73558\",\"type\":\"scheduled\",\"group_id\":\"55b6-b3A4-432250b84669\",\"created_on\":\"2022-08-15T12:30:01Z\",\"scan_time\":\"2022-08-15T12:30:01Z\",\"cos_object\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/531fc3e28bfc43c5a2cea07786d93f5c:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:b1a8f3da-49d2-4966-ae83-a8d02bc2aac7\",\"instance_id\":\"instanceId\",\"account\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"NIST\",\"type\":\"account_type\"},\"profile\":{\"id\":\"44a5-a292-32114fa73558\",\"name\":\"IBM FS Cloud\",\"version\":\"0.1\"},\"scope\":{\"id\":\"2411ffdc16844b07b42521c3443f456d\",\"type\":\"account\"},\"attachment\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"resource group - Default\",\"description\":\"Scoped to the Default resource group\",\"schedule\":\"daily\",\"scope\":\"anyValue\",\"scopes\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"anyValue\"}],\"account_id\":\"accountId\",\"instance_id\":\"instanceId\",\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"attachment_count\":15}],\"notifications\":{\"enabled\":false,\"controls\":{\"threshold_limit\":15,\"failed_control_ids\":[\"failedControlIds\"]}}},\"controls_summary\":{\"status\":\"compliant\",\"total_count\":150,\"compliant_count\":130,\"not_compliant_count\":5,\"unable_to_perform_count\":5,\"user_evaluation_required_count\":10,\"not_applicable_count\":7,\"not_compliant_controls\":[{\"id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"control_name\":\"ibm-cloud-rule\",\"control_description\":\"Ensure security questions are registered by the account owner\"}]},\"evaluations_summary\":{\"status\":\"compliant\",\"total_count\":140,\"pass_count\":123,\"failure_count\":12,\"error_count\":5,\"skipped_count\":7,\"completed_count\":135},\"tags\":{\"user\":[\"user\"],\"access\":[\"access\"],\"service\":[\"service\"]},\"scopes\":[{\"id\":\"id\",\"name\":\"name\",\"href\":\"href\",\"environment\":\"environment\"}],\"additional_details\":{\"created_by\":\"Security and Compliance Center\",\"labels\":[\"labels\"],\"links\":[{\"description\":\"description\",\"href\":\"href\"}]}}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"reports\":[{\"id\":\"44a5-a292-32114fa73558\",\"type\":\"scheduled\",\"group_id\":\"55b6-b3A4-432250b84669\",\"created_on\":\"2022-08-15T12:30:01Z\",\"scan_time\":\"2022-08-15T12:30:01Z\",\"cos_object\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/531fc3e28bfc43c5a2cea07786d93f5c:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:b1a8f3da-49d2-4966-ae83-a8d02bc2aac7\",\"instance_id\":\"instanceId\",\"account\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"NIST\",\"type\":\"account_type\"},\"profile\":{\"id\":\"44a5-a292-32114fa73558\",\"name\":\"IBM FS Cloud\",\"version\":\"0.1\"},\"scope\":{\"id\":\"2411ffdc16844b07b42521c3443f456d\",\"type\":\"account\"},\"attachment\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"resource group - Default\",\"description\":\"Scoped to the Default resource group\",\"schedule\":\"daily\",\"scope\":\"anyValue\",\"scopes\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"anyValue\"}],\"account_id\":\"accountId\",\"instance_id\":\"instanceId\",\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"attachment_count\":15}],\"notifications\":{\"enabled\":false,\"controls\":{\"threshold_limit\":15,\"failed_control_ids\":[\"failedControlIds\"]}}},\"controls_summary\":{\"status\":\"compliant\",\"total_count\":150,\"compliant_count\":130,\"not_compliant_count\":5,\"unable_to_perform_count\":5,\"user_evaluation_required_count\":10,\"not_applicable_count\":7,\"not_compliant_controls\":[{\"id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"control_name\":\"ibm-cloud-rule\",\"control_description\":\"Ensure security questions are registered by the account owner\"}]},\"evaluations_summary\":{\"status\":\"compliant\",\"total_count\":140,\"pass_count\":123,\"failure_count\":12,\"error_count\":5,\"skipped_count\":7,\"completed_count\":135},\"tags\":{\"user\":[\"user\"],\"access\":[\"access\"],\"service\":[\"service\"]},\"scopes\":[{\"id\":\"id\",\"name\":\"name\",\"href\":\"href\",\"environment\":\"environment\"}],\"additional_details\":{\"created_by\":\"Security and Compliance Center\",\"labels\":[\"labels\"],\"links\":[{\"description\":\"description\",\"href\":\"href\"}]}}],\"total_count\":2,\"limit\":1}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListReportsOptions listReportsOptions = new ListReportsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportAttachmentId("testString")
      .groupId("testString")
      .reportProfileId("testString")
      .type("scheduled")
      .limit(Long.valueOf("10"))
      .sort("profile_name")
      .build();

    ReportsPager pager = new ReportsPager(securityAndComplianceCenterApiService, listReportsOptions);
    List<Report> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getReport operation with a valid options model parameter
  @Test
  public void testGetReportWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"44a5-a292-32114fa73558\", \"type\": \"scheduled\", \"group_id\": \"55b6-b3A4-432250b84669\", \"created_on\": \"2022-08-15T12:30:01Z\", \"scan_time\": \"2022-08-15T12:30:01Z\", \"cos_object\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/531fc3e28bfc43c5a2cea07786d93f5c:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:b1a8f3da-49d2-4966-ae83-a8d02bc2aac7\", \"instance_id\": \"instanceId\", \"account\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"NIST\", \"type\": \"account_type\"}, \"profile\": {\"id\": \"44a5-a292-32114fa73558\", \"name\": \"IBM FS Cloud\", \"version\": \"0.1\"}, \"scope\": {\"id\": \"2411ffdc16844b07b42521c3443f456d\", \"type\": \"account\"}, \"attachment\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"resource group - Default\", \"description\": \"Scoped to the Default resource group\", \"schedule\": \"daily\", \"scope\": \"anyValue\", \"scopes\": [{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"environment\": \"environment\", \"properties\": [{\"name\": \"name\", \"value\": \"anyValue\"}], \"account_id\": \"accountId\", \"instance_id\": \"instanceId\", \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"attachment_count\": 15}], \"notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 15, \"failed_control_ids\": [\"failedControlIds\"]}}}, \"controls_summary\": {\"status\": \"compliant\", \"total_count\": 150, \"compliant_count\": 130, \"not_compliant_count\": 5, \"unable_to_perform_count\": 5, \"user_evaluation_required_count\": 10, \"not_applicable_count\": 7, \"not_compliant_controls\": [{\"id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"control_name\": \"ibm-cloud-rule\", \"control_description\": \"Ensure security questions are registered by the account owner\"}]}, \"evaluations_summary\": {\"status\": \"compliant\", \"total_count\": 140, \"pass_count\": 123, \"failure_count\": 12, \"error_count\": 5, \"skipped_count\": 7, \"completed_count\": 135}, \"tags\": {\"user\": [\"user\"], \"access\": [\"access\"], \"service\": [\"service\"]}, \"scopes\": [{\"id\": \"id\", \"name\": \"name\", \"href\": \"href\", \"environment\": \"environment\"}], \"additional_details\": {\"created_by\": \"Security and Compliance Center\", \"labels\": [\"labels\"], \"links\": [{\"description\": \"description\", \"href\": \"href\"}]}}";
    String getReportPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/reports/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetReportOptions model
    GetReportOptions getReportOptionsModel = new GetReportOptions.Builder()
      .reportId("testString")
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .scopeId("testString")
      .subscopeId("testString")
      .build();

    // Invoke getReport() with a valid options model and verify the result
    Response<Report> response = securityAndComplianceCenterApiService.getReport(getReportOptionsModel).execute();
    assertNotNull(response);
    Report responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getReportPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("scope_id"), "testString");
    assertEquals(query.get("subscope_id"), "testString");
  }

  // Test the getReport operation with and without retries enabled
  @Test
  public void testGetReportWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetReportWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetReportWOptions();
  }

  // Test the getReport operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReportNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getReport(null).execute();
  }

  // Test the getReportSummary operation with a valid options model parameter
  @Test
  public void testGetReportSummaryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"report_id\": \"30b434b3-cb08-4845-af10-7a8fc682b6a8\", \"instance_id\": \"84644a08-31b6-4988-b504-49a46ca69ccd\", \"account\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"NIST\", \"type\": \"account_type\"}, \"score\": {\"passed\": 1, \"total_count\": 4, \"percent\": 25}, \"evaluations\": {\"status\": \"compliant\", \"total_count\": 140, \"pass_count\": 123, \"failure_count\": 12, \"error_count\": 5, \"skipped_count\": 7, \"completed_count\": 135}, \"controls\": {\"status\": \"compliant\", \"total_count\": 150, \"compliant_count\": 130, \"not_compliant_count\": 5, \"unable_to_perform_count\": 5, \"user_evaluation_required_count\": 10, \"not_applicable_count\": 7}, \"resources\": {\"status\": \"compliant\", \"total_count\": 150, \"compliant_count\": 130, \"not_compliant_count\": 5, \"unable_to_perform_count\": 5, \"user_evaluation_required_count\": 10, \"not_applicable_count\": 7, \"top_failed\": [{\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"my-bucket\", \"account\": \"59bcbfa6ea2f006b4ed7094c1a08dcdd\", \"service\": \"cloud-object-storage\", \"service_display_name\": \"cloud-object-storage\", \"tags\": {\"user\": [\"user\"], \"access\": [\"access\"], \"service\": [\"service\"]}, \"status\": \"compliant\", \"total_count\": 140, \"pass_count\": 123, \"failure_count\": 12, \"error_count\": 5, \"skipped_count\": 7, \"completed_count\": 135}]}}";
    String getReportSummaryPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/reports/testString/summary";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetReportSummaryOptions model
    GetReportSummaryOptions getReportSummaryOptionsModel = new GetReportSummaryOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportId("testString")
      .build();

    // Invoke getReportSummary() with a valid options model and verify the result
    Response<ReportSummary> response = securityAndComplianceCenterApiService.getReportSummary(getReportSummaryOptionsModel).execute();
    assertNotNull(response);
    ReportSummary responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getReportSummaryPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getReportSummary operation with and without retries enabled
  @Test
  public void testGetReportSummaryWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetReportSummaryWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetReportSummaryWOptions();
  }

  // Test the getReportSummary operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReportSummaryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getReportSummary(null).execute();
  }

  // Test the getReportDownloadFile operation with a valid options model parameter
  @Test
  public void testGetReportDownloadFileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "This is a mock binary response.";
    String getReportDownloadFilePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/reports/testString/download";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/csv")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetReportDownloadFileOptions model
    GetReportDownloadFileOptions getReportDownloadFileOptionsModel = new GetReportDownloadFileOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportId("testString")
      .accept("application/csv")
      .excludeSummary(true)
      .build();

    // Invoke getReportDownloadFile() with a valid options model and verify the result
    Response<InputStream> response = securityAndComplianceCenterApiService.getReportDownloadFile(getReportDownloadFileOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertNotNull(responseObj);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getReportDownloadFilePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("exclude_summary")), Boolean.valueOf(true));
  }

  // Test the getReportDownloadFile operation with and without retries enabled
  @Test
  public void testGetReportDownloadFileWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetReportDownloadFileWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetReportDownloadFileWOptions();
  }

  // Test the getReportDownloadFile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReportDownloadFileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getReportDownloadFile(null).execute();
  }

  // Test the getReportControls operation with a valid options model parameter
  @Test
  public void testGetReportControlsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"report_id\": \"reportId\", \"home_account_id\": \"homeAccountId\", \"controls\": [{\"report_id\": \"6f1fdb98-c08b-41a8-a2f9-df10b51ff34a\", \"home_account_id\": \"2411ffdc16844b07b42521c3443f456d\", \"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"control_library_id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"control_library_version\": \"v1.2.3\", \"control_name\": \"Password Management\", \"control_description\": \"Password Management\", \"control_category\": \"Access Control\", \"control_specifications\": [{\"control_specification_id\": \"18d32a4430e54c81a6668952609763b2\", \"control_specification_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"component_id\": \"cloud-object_storage\", \"component_name\": \"cloud-object_storage\", \"environment\": \"ibm cloud\", \"responsibility\": \"user\", \"assessments\": [{\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}], \"total_count\": 140, \"pass_count\": 123, \"failure_count\": 12, \"error_count\": 5, \"completed_count\": 135}], \"status\": \"compliant\", \"total_count\": 150, \"compliant_count\": 130, \"not_compliant_count\": 5, \"unable_to_perform_count\": 5, \"user_evaluation_required_count\": 10, \"not_applicable_count\": 7}], \"resource_tags\": {\"user\": [\"user\"], \"access\": [\"access\"], \"service\": [\"service\"]}, \"status\": \"compliant\", \"total_count\": 150, \"compliant_count\": 130, \"not_compliant_count\": 5, \"unable_to_perform_count\": 5, \"user_evaluation_required_count\": 10, \"not_applicable_count\": 7}]}";
    String getReportControlsPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/reports/testString/controls";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetReportControlsOptions model
    GetReportControlsOptions getReportControlsOptionsModel = new GetReportControlsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportId("testString")
      .controlId("testString")
      .controlName("testString")
      .controlDescription("testString")
      .controlCategory("testString")
      .status("compliant")
      .sort("control_name")
      .scopeId("testString")
      .subscopeId("testString")
      .build();

    // Invoke getReportControls() with a valid options model and verify the result
    Response<ReportControls> response = securityAndComplianceCenterApiService.getReportControls(getReportControlsOptionsModel).execute();
    assertNotNull(response);
    ReportControls responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getReportControlsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("control_id"), "testString");
    assertEquals(query.get("control_name"), "testString");
    assertEquals(query.get("control_description"), "testString");
    assertEquals(query.get("control_category"), "testString");
    assertEquals(query.get("status"), "compliant");
    assertEquals(query.get("sort"), "control_name");
    assertEquals(query.get("scope_id"), "testString");
    assertEquals(query.get("subscope_id"), "testString");
  }

  // Test the getReportControls operation with and without retries enabled
  @Test
  public void testGetReportControlsWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetReportControlsWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetReportControlsWOptions();
  }

  // Test the getReportControls operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReportControlsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getReportControls(null).execute();
  }

  // Test the getReportRule operation with a valid options model parameter
  @Test
  public void testGetReportRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"rule-7b0560a4-df94-4629-bb76-680f3155ddda\", \"type\": \"user_defined/system_defined\", \"description\": \"rule\", \"version\": \"1.2.3\", \"account_id\": \"59bcbfa6ea2f006b4ed7094c1a08dcdd\", \"created_on\": \"2022-08-15T12:30:01.000Z\", \"created_by\": \"IBMid-12345\", \"updated_on\": \"2022-08-15T12:30:01.000Z\", \"updated_by\": \"IBMid-12345\", \"labels\": [\"labels\"]}";
    String getReportRulePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/reports/testString/rules/rule-61fa114a-2bb9-43fd-8068-b873b48bdf79";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetReportRuleOptions model
    GetReportRuleOptions getReportRuleOptionsModel = new GetReportRuleOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportId("testString")
      .ruleId("rule-61fa114a-2bb9-43fd-8068-b873b48bdf79")
      .build();

    // Invoke getReportRule() with a valid options model and verify the result
    Response<RuleInfo> response = securityAndComplianceCenterApiService.getReportRule(getReportRuleOptionsModel).execute();
    assertNotNull(response);
    RuleInfo responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getReportRulePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getReportRule operation with and without retries enabled
  @Test
  public void testGetReportRuleWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetReportRuleWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetReportRuleWOptions();
  }

  // Test the getReportRule operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReportRuleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getReportRule(null).execute();
  }

  // Test the listReportEvaluations operation with a valid options model parameter
  @Test
  public void testListReportEvaluationsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 50, \"total_count\": 230, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"report_id\": \"reportId\", \"home_account_id\": \"homeAccountId\", \"evaluations\": [{\"report_id\": \"reportId\", \"home_account_id\": \"be200c80cabc456e91139e4152327456\", \"component_id\": \"cloud-object_storage\", \"component_name\": \"cloud-object_storage\", \"assessment\": {\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}, \"evaluate_time\": \"2022-06-30T11:03:44.630150782Z\", \"target\": {\"id\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\", \"account_id\": \"59bcbfa6ea2f006b4ed7094c1a08dcdd\", \"service_name\": \"cloud-object-storage\", \"service_display_name\": \"cloud-object-storage\", \"resource_crn\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\", \"resource_name\": \"mybucket\", \"tags\": {\"user\": [\"user\"], \"access\": [\"access\"], \"service\": [\"service\"]}}, \"status\": \"failure\", \"reason\": \"One or more conditions in rule rule-7b0560a4-df94-4629-bb76-680f3155ddda were not met\", \"details\": {\"properties\": [{\"property\": \"property\", \"property_description\": \"propertyDescription\", \"operator\": \"string_equals\", \"expected_value\": \"anyValue\", \"found_value\": \"anyValue\"}], \"provider_info\": {\"provider_type\": \"providerType\"}}, \"evaluated_by\": \"abc@ibm.com\"}]}";
    String listReportEvaluationsPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/reports/testString/evaluations";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListReportEvaluationsOptions model
    ListReportEvaluationsOptions listReportEvaluationsOptionsModel = new ListReportEvaluationsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportId("testString")
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

    // Invoke listReportEvaluations() with a valid options model and verify the result
    Response<EvaluationPage> response = securityAndComplianceCenterApiService.listReportEvaluations(listReportEvaluationsOptionsModel).execute();
    assertNotNull(response);
    EvaluationPage responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listReportEvaluationsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("assessment_id"), "testString");
    assertEquals(query.get("assessment_method"), "testString");
    assertEquals(query.get("component_id"), "testString");
    assertEquals(query.get("target_id"), "testString");
    assertEquals(query.get("target_env"), "testString");
    assertEquals(query.get("target_name"), "testString");
    assertEquals(query.get("status"), "failure");
    assertEquals(query.get("start"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("sort"), "assessment_id");
    assertEquals(query.get("scope_id"), "testString");
    assertEquals(query.get("subscope_id"), "testString");
  }

  // Test the listReportEvaluations operation with and without retries enabled
  @Test
  public void testListReportEvaluationsWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListReportEvaluationsWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListReportEvaluationsWOptions();
  }

  // Test the listReportEvaluations operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListReportEvaluationsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.listReportEvaluations(null).execute();
  }

  // Test the listReportEvaluations operation using the ReportEvaluationsPager.getNext() method
  @Test
  public void testListReportEvaluationsWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"evaluations\":[{\"report_id\":\"reportId\",\"home_account_id\":\"be200c80cabc456e91139e4152327456\",\"component_id\":\"cloud-object_storage\",\"component_name\":\"cloud-object_storage\",\"assessment\":{\"assessment_id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"assessment_type\":\"ibm-cloud-rule\",\"assessment_method\":\"ibm-cloud-rule\",\"assessment_description\":\"Check whether Cloud Object Storage is accessible only by using private endpoints\",\"parameter_count\":1,\"parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}]},\"evaluate_time\":\"2022-06-30T11:03:44.630150782Z\",\"target\":{\"id\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\",\"account_id\":\"59bcbfa6ea2f006b4ed7094c1a08dcdd\",\"service_name\":\"cloud-object-storage\",\"service_display_name\":\"cloud-object-storage\",\"resource_crn\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\",\"resource_name\":\"mybucket\",\"tags\":{\"user\":[\"user\"],\"access\":[\"access\"],\"service\":[\"service\"]}},\"status\":\"failure\",\"reason\":\"One or more conditions in rule rule-7b0560a4-df94-4629-bb76-680f3155ddda were not met\",\"details\":{\"properties\":[{\"property\":\"property\",\"property_description\":\"propertyDescription\",\"operator\":\"string_equals\",\"expected_value\":\"anyValue\",\"found_value\":\"anyValue\"}],\"provider_info\":{\"provider_type\":\"providerType\"}},\"evaluated_by\":\"abc@ibm.com\"}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"evaluations\":[{\"report_id\":\"reportId\",\"home_account_id\":\"be200c80cabc456e91139e4152327456\",\"component_id\":\"cloud-object_storage\",\"component_name\":\"cloud-object_storage\",\"assessment\":{\"assessment_id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"assessment_type\":\"ibm-cloud-rule\",\"assessment_method\":\"ibm-cloud-rule\",\"assessment_description\":\"Check whether Cloud Object Storage is accessible only by using private endpoints\",\"parameter_count\":1,\"parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}]},\"evaluate_time\":\"2022-06-30T11:03:44.630150782Z\",\"target\":{\"id\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\",\"account_id\":\"59bcbfa6ea2f006b4ed7094c1a08dcdd\",\"service_name\":\"cloud-object-storage\",\"service_display_name\":\"cloud-object-storage\",\"resource_crn\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\",\"resource_name\":\"mybucket\",\"tags\":{\"user\":[\"user\"],\"access\":[\"access\"],\"service\":[\"service\"]}},\"status\":\"failure\",\"reason\":\"One or more conditions in rule rule-7b0560a4-df94-4629-bb76-680f3155ddda were not met\",\"details\":{\"properties\":[{\"property\":\"property\",\"property_description\":\"propertyDescription\",\"operator\":\"string_equals\",\"expected_value\":\"anyValue\",\"found_value\":\"anyValue\"}],\"provider_info\":{\"provider_type\":\"providerType\"}},\"evaluated_by\":\"abc@ibm.com\"}],\"total_count\":2,\"limit\":1}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListReportEvaluationsOptions listReportEvaluationsOptions = new ListReportEvaluationsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportId("testString")
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

    List<Evaluation> allResults = new ArrayList<>();
    ReportEvaluationsPager pager = new ReportEvaluationsPager(securityAndComplianceCenterApiService, listReportEvaluationsOptions);
    while (pager.hasNext()) {
      List<Evaluation> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listReportEvaluations operation using the ReportEvaluationsPager.getAll() method
  @Test
  public void testListReportEvaluationsWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"evaluations\":[{\"report_id\":\"reportId\",\"home_account_id\":\"be200c80cabc456e91139e4152327456\",\"component_id\":\"cloud-object_storage\",\"component_name\":\"cloud-object_storage\",\"assessment\":{\"assessment_id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"assessment_type\":\"ibm-cloud-rule\",\"assessment_method\":\"ibm-cloud-rule\",\"assessment_description\":\"Check whether Cloud Object Storage is accessible only by using private endpoints\",\"parameter_count\":1,\"parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}]},\"evaluate_time\":\"2022-06-30T11:03:44.630150782Z\",\"target\":{\"id\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\",\"account_id\":\"59bcbfa6ea2f006b4ed7094c1a08dcdd\",\"service_name\":\"cloud-object-storage\",\"service_display_name\":\"cloud-object-storage\",\"resource_crn\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\",\"resource_name\":\"mybucket\",\"tags\":{\"user\":[\"user\"],\"access\":[\"access\"],\"service\":[\"service\"]}},\"status\":\"failure\",\"reason\":\"One or more conditions in rule rule-7b0560a4-df94-4629-bb76-680f3155ddda were not met\",\"details\":{\"properties\":[{\"property\":\"property\",\"property_description\":\"propertyDescription\",\"operator\":\"string_equals\",\"expected_value\":\"anyValue\",\"found_value\":\"anyValue\"}],\"provider_info\":{\"provider_type\":\"providerType\"}},\"evaluated_by\":\"abc@ibm.com\"}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"evaluations\":[{\"report_id\":\"reportId\",\"home_account_id\":\"be200c80cabc456e91139e4152327456\",\"component_id\":\"cloud-object_storage\",\"component_name\":\"cloud-object_storage\",\"assessment\":{\"assessment_id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"assessment_type\":\"ibm-cloud-rule\",\"assessment_method\":\"ibm-cloud-rule\",\"assessment_description\":\"Check whether Cloud Object Storage is accessible only by using private endpoints\",\"parameter_count\":1,\"parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}]},\"evaluate_time\":\"2022-06-30T11:03:44.630150782Z\",\"target\":{\"id\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\",\"account_id\":\"59bcbfa6ea2f006b4ed7094c1a08dcdd\",\"service_name\":\"cloud-object-storage\",\"service_display_name\":\"cloud-object-storage\",\"resource_crn\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\",\"resource_name\":\"mybucket\",\"tags\":{\"user\":[\"user\"],\"access\":[\"access\"],\"service\":[\"service\"]}},\"status\":\"failure\",\"reason\":\"One or more conditions in rule rule-7b0560a4-df94-4629-bb76-680f3155ddda were not met\",\"details\":{\"properties\":[{\"property\":\"property\",\"property_description\":\"propertyDescription\",\"operator\":\"string_equals\",\"expected_value\":\"anyValue\",\"found_value\":\"anyValue\"}],\"provider_info\":{\"provider_type\":\"providerType\"}},\"evaluated_by\":\"abc@ibm.com\"}],\"total_count\":2,\"limit\":1}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListReportEvaluationsOptions listReportEvaluationsOptions = new ListReportEvaluationsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportId("testString")
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
    List<Evaluation> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listReportResources operation with a valid options model parameter
  @Test
  public void testListReportResourcesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 50, \"total_count\": 230, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"report_id\": \"reportId\", \"home_account_id\": \"homeAccountId\", \"resources\": [{\"report_id\": \"30b434b3-cb08-4845-af10-7a8fc682b6a8\", \"home_account_id\": \"2411ffdc16844b07b42521c3443f456d\", \"id\": \"crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::\", \"resource_name\": \"jeff's key\", \"account\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"NIST\", \"type\": \"account_type\"}, \"component_id\": \"cloud-object_storage\", \"component_name\": \"cloud-object_storage\", \"environment\": \"ibm cloud\", \"tags\": {\"user\": [\"user\"], \"access\": [\"access\"], \"service\": [\"service\"]}, \"status\": \"compliant\", \"total_count\": 140, \"pass_count\": 123, \"failure_count\": 12, \"error_count\": 5, \"skipped_count\": 7, \"completed_count\": 135, \"service_name\": \"pm-20\", \"instance_crn\": \"instanceCrn\"}]}";
    String listReportResourcesPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/reports/testString/resources";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListReportResourcesOptions model
    ListReportResourcesOptions listReportResourcesOptionsModel = new ListReportResourcesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportId("testString")
      .id("testString")
      .resourceName("testString")
      .accountId("testString")
      .componentId("testString")
      .status("compliant")
      .sort("account_id")
      .start("testString")
      .limit(Long.valueOf("10"))
      .scopeId("testString")
      .subscopeId("testString")
      .build();

    // Invoke listReportResources() with a valid options model and verify the result
    Response<ResourcePage> response = securityAndComplianceCenterApiService.listReportResources(listReportResourcesOptionsModel).execute();
    assertNotNull(response);
    ResourcePage responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listReportResourcesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("id"), "testString");
    assertEquals(query.get("resource_name"), "testString");
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("component_id"), "testString");
    assertEquals(query.get("status"), "compliant");
    assertEquals(query.get("sort"), "account_id");
    assertEquals(query.get("start"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("scope_id"), "testString");
    assertEquals(query.get("subscope_id"), "testString");
  }

  // Test the listReportResources operation with and without retries enabled
  @Test
  public void testListReportResourcesWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListReportResourcesWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListReportResourcesWOptions();
  }

  // Test the listReportResources operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListReportResourcesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.listReportResources(null).execute();
  }

  // Test the listReportResources operation using the ReportResourcesPager.getNext() method
  @Test
  public void testListReportResourcesWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"limit\":1,\"resources\":[{\"report_id\":\"30b434b3-cb08-4845-af10-7a8fc682b6a8\",\"home_account_id\":\"2411ffdc16844b07b42521c3443f456d\",\"id\":\"crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::\",\"resource_name\":\"jeff's key\",\"account\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"NIST\",\"type\":\"account_type\"},\"component_id\":\"cloud-object_storage\",\"component_name\":\"cloud-object_storage\",\"environment\":\"ibm cloud\",\"tags\":{\"user\":[\"user\"],\"access\":[\"access\"],\"service\":[\"service\"]},\"status\":\"compliant\",\"total_count\":140,\"pass_count\":123,\"failure_count\":12,\"error_count\":5,\"skipped_count\":7,\"completed_count\":135,\"service_name\":\"pm-20\",\"instance_crn\":\"instanceCrn\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"report_id\":\"30b434b3-cb08-4845-af10-7a8fc682b6a8\",\"home_account_id\":\"2411ffdc16844b07b42521c3443f456d\",\"id\":\"crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::\",\"resource_name\":\"jeff's key\",\"account\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"NIST\",\"type\":\"account_type\"},\"component_id\":\"cloud-object_storage\",\"component_name\":\"cloud-object_storage\",\"environment\":\"ibm cloud\",\"tags\":{\"user\":[\"user\"],\"access\":[\"access\"],\"service\":[\"service\"]},\"status\":\"compliant\",\"total_count\":140,\"pass_count\":123,\"failure_count\":12,\"error_count\":5,\"skipped_count\":7,\"completed_count\":135,\"service_name\":\"pm-20\",\"instance_crn\":\"instanceCrn\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListReportResourcesOptions listReportResourcesOptions = new ListReportResourcesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportId("testString")
      .id("testString")
      .resourceName("testString")
      .accountId("testString")
      .componentId("testString")
      .status("compliant")
      .sort("account_id")
      .limit(Long.valueOf("10"))
      .scopeId("testString")
      .subscopeId("testString")
      .build();

    List<Resource> allResults = new ArrayList<>();
    ReportResourcesPager pager = new ReportResourcesPager(securityAndComplianceCenterApiService, listReportResourcesOptions);
    while (pager.hasNext()) {
      List<Resource> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listReportResources operation using the ReportResourcesPager.getAll() method
  @Test
  public void testListReportResourcesWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"limit\":1,\"resources\":[{\"report_id\":\"30b434b3-cb08-4845-af10-7a8fc682b6a8\",\"home_account_id\":\"2411ffdc16844b07b42521c3443f456d\",\"id\":\"crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::\",\"resource_name\":\"jeff's key\",\"account\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"NIST\",\"type\":\"account_type\"},\"component_id\":\"cloud-object_storage\",\"component_name\":\"cloud-object_storage\",\"environment\":\"ibm cloud\",\"tags\":{\"user\":[\"user\"],\"access\":[\"access\"],\"service\":[\"service\"]},\"status\":\"compliant\",\"total_count\":140,\"pass_count\":123,\"failure_count\":12,\"error_count\":5,\"skipped_count\":7,\"completed_count\":135,\"service_name\":\"pm-20\",\"instance_crn\":\"instanceCrn\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"report_id\":\"30b434b3-cb08-4845-af10-7a8fc682b6a8\",\"home_account_id\":\"2411ffdc16844b07b42521c3443f456d\",\"id\":\"crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::\",\"resource_name\":\"jeff's key\",\"account\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"NIST\",\"type\":\"account_type\"},\"component_id\":\"cloud-object_storage\",\"component_name\":\"cloud-object_storage\",\"environment\":\"ibm cloud\",\"tags\":{\"user\":[\"user\"],\"access\":[\"access\"],\"service\":[\"service\"]},\"status\":\"compliant\",\"total_count\":140,\"pass_count\":123,\"failure_count\":12,\"error_count\":5,\"skipped_count\":7,\"completed_count\":135,\"service_name\":\"pm-20\",\"instance_crn\":\"instanceCrn\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListReportResourcesOptions listReportResourcesOptions = new ListReportResourcesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportId("testString")
      .id("testString")
      .resourceName("testString")
      .accountId("testString")
      .componentId("testString")
      .status("compliant")
      .sort("account_id")
      .limit(Long.valueOf("10"))
      .scopeId("testString")
      .subscopeId("testString")
      .build();

    ReportResourcesPager pager = new ReportResourcesPager(securityAndComplianceCenterApiService, listReportResourcesOptions);
    List<Resource> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getReportTags operation with a valid options model parameter
  @Test
  public void testGetReportTagsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"report_id\": \"reportId\", \"tags\": {\"user\": [\"user\"], \"access\": [\"access\"], \"service\": [\"service\"]}}";
    String getReportTagsPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/reports/testString/tags";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetReportTagsOptions model
    GetReportTagsOptions getReportTagsOptionsModel = new GetReportTagsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportId("testString")
      .build();

    // Invoke getReportTags() with a valid options model and verify the result
    Response<ReportTags> response = securityAndComplianceCenterApiService.getReportTags(getReportTagsOptionsModel).execute();
    assertNotNull(response);
    ReportTags responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getReportTagsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getReportTags operation with and without retries enabled
  @Test
  public void testGetReportTagsWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetReportTagsWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetReportTagsWOptions();
  }

  // Test the getReportTags operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReportTagsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getReportTags(null).execute();
  }

  // Test the getReportViolationsDrift operation with a valid options model parameter
  @Test
  public void testGetReportViolationsDriftWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"home_account_id\": \"homeAccountId\", \"report_group_id\": \"reportGroupId\", \"data_points\": [{\"report_id\": \"30b434b3-cb08-4845-af10-7a8fc682b6a8\", \"report_group_id\": \"55b6-b3A4-432250b84669\", \"scan_time\": \"2022-08-15T12:30:01Z\", \"controls_summary\": {\"status\": \"compliant\", \"total_count\": 150, \"compliant_count\": 130, \"not_compliant_count\": 5, \"unable_to_perform_count\": 5, \"user_evaluation_required_count\": 10, \"not_applicable_count\": 7}}]}";
    String getReportViolationsDriftPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/reports/testString/violations_drift";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetReportViolationsDriftOptions model
    GetReportViolationsDriftOptions getReportViolationsDriftOptionsModel = new GetReportViolationsDriftOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportId("testString")
      .scanTimeDuration(Long.valueOf("0"))
      .scopeId("testString")
      .subscopeId("testString")
      .build();

    // Invoke getReportViolationsDrift() with a valid options model and verify the result
    Response<ReportViolationsDrift> response = securityAndComplianceCenterApiService.getReportViolationsDrift(getReportViolationsDriftOptionsModel).execute();
    assertNotNull(response);
    ReportViolationsDrift responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getReportViolationsDriftPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("scan_time_duration")), Long.valueOf("0"));
    assertEquals(query.get("scope_id"), "testString");
    assertEquals(query.get("subscope_id"), "testString");
  }

  // Test the getReportViolationsDrift operation with and without retries enabled
  @Test
  public void testGetReportViolationsDriftWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetReportViolationsDriftWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetReportViolationsDriftWOptions();
  }

  // Test the getReportViolationsDrift operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReportViolationsDriftNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getReportViolationsDrift(null).execute();
  }

  // Test the listScanReports operation with a valid options model parameter
  @Test
  public void testListScanReportsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 50, \"total_count\": 230, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"scope_id\": \"44a5-a292-32114fa73558\", \"subscope_id\": \"44a5-a292-32114fa73555\", \"scan_reports\": [{\"id\": \"e44316e3-53bc-449b-a808-c16df680d462\", \"scan_id\": \"44a5-a292-32114fa73553\", \"instance_id\": \"instanceId\", \"scope_id\": \"44a5-a292-32114fa73558\", \"subscope_id\": \"44a5-a292-32114fa73555\", \"status\": \"completed\", \"created_on\": \"2024-05-08T12:30:01.000Z\", \"format\": \"pdf\", \"href\": \"href\"}]}";
    String listScanReportsPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/reports/testString/scan_reports";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListScanReportsOptions model
    ListScanReportsOptions listScanReportsOptionsModel = new ListScanReportsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportId("testString")
      .scopeId("testString")
      .subscopeId("testString")
      .sort("status")
      .build();

    // Invoke listScanReports() with a valid options model and verify the result
    Response<ScanReportCollection> response = securityAndComplianceCenterApiService.listScanReports(listScanReportsOptionsModel).execute();
    assertNotNull(response);
    ScanReportCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listScanReportsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("scope_id"), "testString");
    assertEquals(query.get("subscope_id"), "testString");
    assertEquals(query.get("sort"), "status");
  }

  // Test the listScanReports operation with and without retries enabled
  @Test
  public void testListScanReportsWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListScanReportsWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListScanReportsWOptions();
  }

  // Test the listScanReports operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListScanReportsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.listScanReports(null).execute();
  }

  // Test the createScanReport operation with a valid options model parameter
  @Test
  public void testCreateScanReportWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\"}";
    String createScanReportPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/reports/testString/scan_reports";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateScanReportOptions model
    CreateScanReportOptions createScanReportOptionsModel = new CreateScanReportOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportId("testString")
      .format("csv")
      .scopeId("132009ff-b982-412e-a110-ad8797e10f84")
      .subscopeId("c7ddcbcc-6a43-4ab3-b6a7-b2d8f65cd54a")
      .build();

    // Invoke createScanReport() with a valid options model and verify the result
    Response<CreateScanReport> response = securityAndComplianceCenterApiService.createScanReport(createScanReportOptionsModel).execute();
    assertNotNull(response);
    CreateScanReport responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createScanReportPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createScanReport operation with and without retries enabled
  @Test
  public void testCreateScanReportWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testCreateScanReportWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testCreateScanReportWOptions();
  }

  // Test the createScanReport operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateScanReportNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.createScanReport(null).execute();
  }

  // Test the getScanReport operation with a valid options model parameter
  @Test
  public void testGetScanReportWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"e44316e3-53bc-449b-a808-c16df680d462\", \"scan_id\": \"44a5-a292-32114fa73553\", \"instance_id\": \"instanceId\", \"scope_id\": \"44a5-a292-32114fa73558\", \"subscope_id\": \"44a5-a292-32114fa73555\", \"status\": \"completed\", \"created_on\": \"2024-05-08T12:30:01.000Z\", \"format\": \"pdf\", \"href\": \"href\"}";
    String getScanReportPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/reports/testString/scan_reports/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetScanReportOptions model
    GetScanReportOptions getScanReportOptionsModel = new GetScanReportOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportId("testString")
      .jobId("testString")
      .build();

    // Invoke getScanReport() with a valid options model and verify the result
    Response<ScanReport> response = securityAndComplianceCenterApiService.getScanReport(getScanReportOptionsModel).execute();
    assertNotNull(response);
    ScanReport responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getScanReportPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getScanReport operation with and without retries enabled
  @Test
  public void testGetScanReportWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetScanReportWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetScanReportWOptions();
  }

  // Test the getScanReport operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetScanReportNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getScanReport(null).execute();
  }

  // Test the getScanReportDownloadFile operation with a valid options model parameter
  @Test
  public void testGetScanReportDownloadFileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "This is a mock binary response.";
    String getScanReportDownloadFilePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/reports/testString/scan_reports/testString/download";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/csv")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetScanReportDownloadFileOptions model
    GetScanReportDownloadFileOptions getScanReportDownloadFileOptionsModel = new GetScanReportDownloadFileOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportId("testString")
      .jobId("testString")
      .accept("application/csv")
      .build();

    // Invoke getScanReportDownloadFile() with a valid options model and verify the result
    Response<InputStream> response = securityAndComplianceCenterApiService.getScanReportDownloadFile(getScanReportDownloadFileOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertNotNull(responseObj);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getScanReportDownloadFilePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getScanReportDownloadFile operation with and without retries enabled
  @Test
  public void testGetScanReportDownloadFileWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetScanReportDownloadFileWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetScanReportDownloadFileWOptions();
  }

  // Test the getScanReportDownloadFile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetScanReportDownloadFileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getScanReportDownloadFile(null).execute();
  }

  // Test the listRules operation with a valid options model parameter
  @Test
  public void testListRulesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 50, \"total_count\": 230, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"rules\": [{\"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"id\": \"id\", \"account_id\": \"accountId\", \"description\": \"description\", \"type\": \"user_defined\", \"version\": \"version\", \"import\": {\"parameters\": [{\"name\": \"name\", \"display_name\": \"displayName\", \"description\": \"description\", \"type\": \"string\"}]}, \"target\": {\"service_name\": \"serviceName\", \"service_display_name\": \"serviceDisplayName\", \"resource_kind\": \"resourceKind\", \"additional_target_attributes\": [{\"name\": \"name\", \"operator\": \"string_equals\", \"value\": \"anyValue\"}], \"ref\": \"ref\"}, \"required_config\": {\"description\": \"description\", \"property\": \"property\", \"operator\": \"string_equals\", \"value\": \"anyValue\"}, \"labels\": [\"labels\"]}]}";
    String listRulesPath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/rules";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListRulesOptions model
    ListRulesOptions listRulesOptionsModel = new ListRulesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .limit(Long.valueOf("10"))
      .start("testString")
      .type("system_defined")
      .search("testString")
      .serviceName("testString")
      .sort("updated_on")
      .build();

    // Invoke listRules() with a valid options model and verify the result
    Response<RuleCollection> response = securityAndComplianceCenterApiService.listRules(listRulesOptionsModel).execute();
    assertNotNull(response);
    RuleCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listRulesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
    assertEquals(query.get("type"), "system_defined");
    assertEquals(query.get("search"), "testString");
    assertEquals(query.get("service_name"), "testString");
    assertEquals(query.get("sort"), "updated_on");
  }

  // Test the listRules operation with and without retries enabled
  @Test
  public void testListRulesWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListRulesWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListRulesWOptions();
  }

  // Test the listRules operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListRulesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.listRules(null).execute();
  }

  // Test the listRules operation using the RulesPager.getNext() method
  @Test
  public void testListRulesWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"limit\":1,\"rules\":[{\"created_on\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"id\":\"id\",\"account_id\":\"accountId\",\"description\":\"description\",\"type\":\"user_defined\",\"version\":\"version\",\"import\":{\"parameters\":[{\"name\":\"name\",\"display_name\":\"displayName\",\"description\":\"description\",\"type\":\"string\"}]},\"target\":{\"service_name\":\"serviceName\",\"service_display_name\":\"serviceDisplayName\",\"resource_kind\":\"resourceKind\",\"additional_target_attributes\":[{\"name\":\"name\",\"operator\":\"string_equals\",\"value\":\"anyValue\"}],\"ref\":\"ref\"},\"required_config\":{\"description\":\"description\",\"property\":\"property\",\"operator\":\"string_equals\",\"value\":\"anyValue\"},\"labels\":[\"labels\"]}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"rules\":[{\"created_on\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"id\":\"id\",\"account_id\":\"accountId\",\"description\":\"description\",\"type\":\"user_defined\",\"version\":\"version\",\"import\":{\"parameters\":[{\"name\":\"name\",\"display_name\":\"displayName\",\"description\":\"description\",\"type\":\"string\"}]},\"target\":{\"service_name\":\"serviceName\",\"service_display_name\":\"serviceDisplayName\",\"resource_kind\":\"resourceKind\",\"additional_target_attributes\":[{\"name\":\"name\",\"operator\":\"string_equals\",\"value\":\"anyValue\"}],\"ref\":\"ref\"},\"required_config\":{\"description\":\"description\",\"property\":\"property\",\"operator\":\"string_equals\",\"value\":\"anyValue\"},\"labels\":[\"labels\"]}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .limit(Long.valueOf("10"))
      .type("system_defined")
      .search("testString")
      .serviceName("testString")
      .sort("updated_on")
      .build();

    List<Rule> allResults = new ArrayList<>();
    RulesPager pager = new RulesPager(securityAndComplianceCenterApiService, listRulesOptions);
    while (pager.hasNext()) {
      List<Rule> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listRules operation using the RulesPager.getAll() method
  @Test
  public void testListRulesWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"limit\":1,\"rules\":[{\"created_on\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"id\":\"id\",\"account_id\":\"accountId\",\"description\":\"description\",\"type\":\"user_defined\",\"version\":\"version\",\"import\":{\"parameters\":[{\"name\":\"name\",\"display_name\":\"displayName\",\"description\":\"description\",\"type\":\"string\"}]},\"target\":{\"service_name\":\"serviceName\",\"service_display_name\":\"serviceDisplayName\",\"resource_kind\":\"resourceKind\",\"additional_target_attributes\":[{\"name\":\"name\",\"operator\":\"string_equals\",\"value\":\"anyValue\"}],\"ref\":\"ref\"},\"required_config\":{\"description\":\"description\",\"property\":\"property\",\"operator\":\"string_equals\",\"value\":\"anyValue\"},\"labels\":[\"labels\"]}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"rules\":[{\"created_on\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"id\":\"id\",\"account_id\":\"accountId\",\"description\":\"description\",\"type\":\"user_defined\",\"version\":\"version\",\"import\":{\"parameters\":[{\"name\":\"name\",\"display_name\":\"displayName\",\"description\":\"description\",\"type\":\"string\"}]},\"target\":{\"service_name\":\"serviceName\",\"service_display_name\":\"serviceDisplayName\",\"resource_kind\":\"resourceKind\",\"additional_target_attributes\":[{\"name\":\"name\",\"operator\":\"string_equals\",\"value\":\"anyValue\"}],\"ref\":\"ref\"},\"required_config\":{\"description\":\"description\",\"property\":\"property\",\"operator\":\"string_equals\",\"value\":\"anyValue\"},\"labels\":[\"labels\"]}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .limit(Long.valueOf("10"))
      .type("system_defined")
      .search("testString")
      .serviceName("testString")
      .sort("updated_on")
      .build();

    RulesPager pager = new RulesPager(securityAndComplianceCenterApiService, listRulesOptions);
    List<Rule> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the createRule operation with a valid options model parameter
  @Test
  public void testCreateRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"id\": \"id\", \"account_id\": \"accountId\", \"description\": \"description\", \"type\": \"user_defined\", \"version\": \"version\", \"import\": {\"parameters\": [{\"name\": \"name\", \"display_name\": \"displayName\", \"description\": \"description\", \"type\": \"string\"}]}, \"target\": {\"service_name\": \"serviceName\", \"service_display_name\": \"serviceDisplayName\", \"resource_kind\": \"resourceKind\", \"additional_target_attributes\": [{\"name\": \"name\", \"operator\": \"string_equals\", \"value\": \"anyValue\"}], \"ref\": \"ref\"}, \"required_config\": {\"description\": \"description\", \"property\": \"property\", \"operator\": \"string_equals\", \"value\": \"anyValue\"}, \"labels\": [\"labels\"]}";
    String createRulePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/rules";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the AdditionalTargetAttribute model
    AdditionalTargetAttribute additionalTargetAttributeModel = new AdditionalTargetAttribute.Builder()
      .name("location")
      .operator("string_equals")
      .value("us-east")
      .build();

    // Construct an instance of the RuleTargetPrototype model
    RuleTargetPrototype ruleTargetPrototypeModel = new RuleTargetPrototype.Builder()
      .serviceName("cloud-object-storage")
      .resourceKind("bucket")
      .additionalTargetAttributes(java.util.Arrays.asList(additionalTargetAttributeModel))
      .build();

    // Construct an instance of the ConditionItemConditionBase model
    ConditionItemConditionBase conditionItemModel = new ConditionItemConditionBase.Builder()
      .description("testString")
      .property("hard_quota")
      .operator("num_equals")
      .value("${hard_quota}")
      .build();

    // Construct an instance of the RequiredConfigConditionListConditionListConditionAnd model
    RequiredConfigConditionListConditionListConditionAnd requiredConfigModel = new RequiredConfigConditionListConditionListConditionAnd.Builder()
      .description("The Cloud Object Storage rule.")
      .and(java.util.Arrays.asList(conditionItemModel))
      .build();

    // Construct an instance of the RuleParameter model
    RuleParameter ruleParameterModel = new RuleParameter.Builder()
      .name("hard_quota")
      .displayName("The Cloud Object Storage bucket quota.")
      .description("The maximum bytes that are allocated to the Cloud Object Storage bucket.")
      .type("numeric")
      .build();

    // Construct an instance of the Import model
    Import importModel = new Import.Builder()
      .parameters(java.util.Arrays.asList(ruleParameterModel))
      .build();

    // Construct an instance of the CreateRuleOptions model
    CreateRuleOptions createRuleOptionsModel = new CreateRuleOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .description("Example rule")
      .target(ruleTargetPrototypeModel)
      .requiredConfig(requiredConfigModel)
      .version("1.0.0")
      .xImport(importModel)
      .labels(java.util.Arrays.asList())
      .build();

    // Invoke createRule() with a valid options model and verify the result
    Response<Rule> response = securityAndComplianceCenterApiService.createRule(createRuleOptionsModel).execute();
    assertNotNull(response);
    Rule responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createRulePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createRule operation with and without retries enabled
  @Test
  public void testCreateRuleWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testCreateRuleWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testCreateRuleWOptions();
  }

  // Test the createRule operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateRuleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.createRule(null).execute();
  }

  // Test the getRule operation with a valid options model parameter
  @Test
  public void testGetRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"id\": \"id\", \"account_id\": \"accountId\", \"description\": \"description\", \"type\": \"user_defined\", \"version\": \"version\", \"import\": {\"parameters\": [{\"name\": \"name\", \"display_name\": \"displayName\", \"description\": \"description\", \"type\": \"string\"}]}, \"target\": {\"service_name\": \"serviceName\", \"service_display_name\": \"serviceDisplayName\", \"resource_kind\": \"resourceKind\", \"additional_target_attributes\": [{\"name\": \"name\", \"operator\": \"string_equals\", \"value\": \"anyValue\"}], \"ref\": \"ref\"}, \"required_config\": {\"description\": \"description\", \"property\": \"property\", \"operator\": \"string_equals\", \"value\": \"anyValue\"}, \"labels\": [\"labels\"]}";
    String getRulePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/rules/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetRuleOptions model
    GetRuleOptions getRuleOptionsModel = new GetRuleOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .ruleId("testString")
      .build();

    // Invoke getRule() with a valid options model and verify the result
    Response<Rule> response = securityAndComplianceCenterApiService.getRule(getRuleOptionsModel).execute();
    assertNotNull(response);
    Rule responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getRulePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getRule operation with and without retries enabled
  @Test
  public void testGetRuleWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetRuleWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetRuleWOptions();
  }

  // Test the getRule operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetRuleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getRule(null).execute();
  }

  // Test the replaceRule operation with a valid options model parameter
  @Test
  public void testReplaceRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"id\": \"id\", \"account_id\": \"accountId\", \"description\": \"description\", \"type\": \"user_defined\", \"version\": \"version\", \"import\": {\"parameters\": [{\"name\": \"name\", \"display_name\": \"displayName\", \"description\": \"description\", \"type\": \"string\"}]}, \"target\": {\"service_name\": \"serviceName\", \"service_display_name\": \"serviceDisplayName\", \"resource_kind\": \"resourceKind\", \"additional_target_attributes\": [{\"name\": \"name\", \"operator\": \"string_equals\", \"value\": \"anyValue\"}], \"ref\": \"ref\"}, \"required_config\": {\"description\": \"description\", \"property\": \"property\", \"operator\": \"string_equals\", \"value\": \"anyValue\"}, \"labels\": [\"labels\"]}";
    String replaceRulePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/rules/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the AdditionalTargetAttribute model
    AdditionalTargetAttribute additionalTargetAttributeModel = new AdditionalTargetAttribute.Builder()
      .name("location")
      .operator("string_equals")
      .value("us-south")
      .build();

    // Construct an instance of the RuleTargetPrototype model
    RuleTargetPrototype ruleTargetPrototypeModel = new RuleTargetPrototype.Builder()
      .serviceName("cloud-object-storage")
      .resourceKind("bucket")
      .additionalTargetAttributes(java.util.Arrays.asList(additionalTargetAttributeModel))
      .build();

    // Construct an instance of the ConditionItemConditionBase model
    ConditionItemConditionBase conditionItemModel = new ConditionItemConditionBase.Builder()
      .description("testString")
      .property("hard_quota")
      .operator("num_equals")
      .value("${hard_quota}")
      .build();

    // Construct an instance of the RequiredConfigConditionListConditionListConditionAnd model
    RequiredConfigConditionListConditionListConditionAnd requiredConfigModel = new RequiredConfigConditionListConditionListConditionAnd.Builder()
      .description("The Cloud Object Storage rule.")
      .and(java.util.Arrays.asList(conditionItemModel))
      .build();

    // Construct an instance of the RuleParameter model
    RuleParameter ruleParameterModel = new RuleParameter.Builder()
      .name("hard_quota")
      .displayName("The Cloud Object Storage bucket quota.")
      .description("The maximum bytes that are allocated to the Cloud Object Storage bucket.")
      .type("numeric")
      .build();

    // Construct an instance of the Import model
    Import importModel = new Import.Builder()
      .parameters(java.util.Arrays.asList(ruleParameterModel))
      .build();

    // Construct an instance of the ReplaceRuleOptions model
    ReplaceRuleOptions replaceRuleOptionsModel = new ReplaceRuleOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .ruleId("testString")
      .ifMatch("testString")
      .description("Example rule")
      .target(ruleTargetPrototypeModel)
      .requiredConfig(requiredConfigModel)
      .version("1.0.1")
      .xImport(importModel)
      .labels(java.util.Arrays.asList())
      .build();

    // Invoke replaceRule() with a valid options model and verify the result
    Response<Rule> response = securityAndComplianceCenterApiService.replaceRule(replaceRuleOptionsModel).execute();
    assertNotNull(response);
    Rule responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceRulePath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the replaceRule operation with and without retries enabled
  @Test
  public void testReplaceRuleWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testReplaceRuleWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testReplaceRuleWOptions();
  }

  // Test the replaceRule operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceRuleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.replaceRule(null).execute();
  }

  // Test the deleteRule operation with a valid options model parameter
  @Test
  public void testDeleteRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteRulePath = "/instances/acd7032c-15a3-484f-bf5b-67d41534d940/v3/rules/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteRuleOptions model
    DeleteRuleOptions deleteRuleOptionsModel = new DeleteRuleOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .ruleId("testString")
      .build();

    // Invoke deleteRule() with a valid options model and verify the result
    Response<Void> response = securityAndComplianceCenterApiService.deleteRule(deleteRuleOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteRulePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteRule operation with and without retries enabled
  @Test
  public void testDeleteRuleWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testDeleteRuleWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testDeleteRuleWOptions();
  }

  // Test the deleteRule operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteRuleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.deleteRule(null).execute();
  }

  // Test the listServices operation with a valid options model parameter
  @Test
  public void testListServicesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"services\": [{\"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"service_name\": \"serviceName\", \"service_display_name\": \"serviceDisplayName\", \"description\": \"description\", \"monitoring_enabled\": false, \"enforcement_enabled\": true, \"service_listing_enabled\": false, \"config_information_point\": {\"type\": \"type\", \"endpoints\": [{\"host\": \"host\", \"path\": \"path\", \"region\": \"region\", \"advisory_call_limit\": 17}]}, \"supported_configs\": [{\"resource_kind\": \"resourceKind\", \"additional_target_attributes\": [{\"name\": \"name\", \"operator\": \"string_equals\", \"value\": \"anyValue\"}], \"properties\": [{\"name\": \"name\", \"description\": \"description\", \"type\": \"string\"}], \"description\": \"description\", \"cip_requires_service_instance\": true, \"resource_group_support\": true, \"tagging_support\": true, \"inherit_tags\": false}]}]}";
    String listServicesPath = "/v3/services";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListServicesOptions model
    ListServicesOptions listServicesOptionsModel = new ListServicesOptions();

    // Invoke listServices() with a valid options model and verify the result
    Response<ServiceCollection> response = securityAndComplianceCenterApiService.listServices(listServicesOptionsModel).execute();
    assertNotNull(response);
    ServiceCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listServicesPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listServices operation with and without retries enabled
  @Test
  public void testListServicesWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListServicesWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListServicesWOptions();
  }

  // Test the getService operation with a valid options model parameter
  @Test
  public void testGetServiceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"service_name\": \"serviceName\", \"service_display_name\": \"serviceDisplayName\", \"description\": \"description\", \"monitoring_enabled\": false, \"enforcement_enabled\": true, \"service_listing_enabled\": false, \"config_information_point\": {\"type\": \"type\", \"endpoints\": [{\"host\": \"host\", \"path\": \"path\", \"region\": \"region\", \"advisory_call_limit\": 17}]}, \"supported_configs\": [{\"resource_kind\": \"resourceKind\", \"additional_target_attributes\": [{\"name\": \"name\", \"operator\": \"string_equals\", \"value\": \"anyValue\"}], \"properties\": [{\"name\": \"name\", \"description\": \"description\", \"type\": \"string\"}], \"description\": \"description\", \"cip_requires_service_instance\": true, \"resource_group_support\": true, \"tagging_support\": true, \"inherit_tags\": false}]}";
    String getServicePath = "/v3/services/cloud-object-storage";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetServiceOptions model
    GetServiceOptions getServiceOptionsModel = new GetServiceOptions.Builder()
      .servicesName("cloud-object-storage")
      .build();

    // Invoke getService() with a valid options model and verify the result
    Response<Service> response = securityAndComplianceCenterApiService.getService(getServiceOptionsModel).execute();
    assertNotNull(response);
    Service responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getServicePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getService operation with and without retries enabled
  @Test
  public void testGetServiceWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetServiceWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetServiceWOptions();
  }

  // Test the getService operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetServiceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getService(null).execute();
  }

  // Perform setup needed before each test method
  @BeforeMethod
  public void beforeEachTest() {
    // Start the mock server.
    try {
      server = new MockWebServer();
      server.start();
    } catch (IOException err) {
      fail("Failed to instantiate mock web server");
    }

    // Construct an instance of the service
    constructClientService();
  }

  // Perform tear down after each test method
  @AfterMethod
  public void afterEachTest() throws IOException {
    server.shutdown();
    securityAndComplianceCenterApiService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    securityAndComplianceCenterApiService = SecurityAndComplianceCenterApi.newInstance(serviceName);
    String url = server.url("/").toString();
    securityAndComplianceCenterApiService.setServiceUrl(url);
  }
}