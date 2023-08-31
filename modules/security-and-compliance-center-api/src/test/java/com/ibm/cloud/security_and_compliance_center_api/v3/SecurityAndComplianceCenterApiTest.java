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
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.security_and_compliance_center_api.v3.SecurityAndComplianceCenterApi;
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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderTypeInstanceAttributes;
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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigAnd;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigItems;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigItemsRequiredConfigAndDepth1;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigItemsRequiredConfigBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigItemsRequiredConfigOrDepth1;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigOr;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigRequiredConfigBase;
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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.TargetPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.TestEvent;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateProviderTypeInstanceRequest;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingAttributes;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateSettingsOptions;
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

  // Construct the service URL using the default server variable values
  @Test
  public void testConstructServiceURLwithDefaultValues() throws Throwable {
    String defaultFormattedUrl = "https://us-south.compliance.cloud.ibm.com/instances/instance_id/v3";
    String constructedUrl = SecurityAndComplianceCenterApi.constructServiceUrl(null);
    assertEquals(constructedUrl, defaultFormattedUrl);
  }

  // Construct the service URL with an invalid server variable name (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructServiceURLWithInvalidVariable() throws Throwable {
    Map<String, String> variables = new HashMap<>();
    variables.put("invalid_variable_name", "value");

    SecurityAndComplianceCenterApi.constructServiceUrl(variables);
  }

  // Test the getSettings operation with a valid options model parameter
  @Test
  public void testGetSettingsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"event_notifications\": {\"instance_crn\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/ff88f007f9ff4622aac4fbc0eda36255:7199ae60-a214-4dd8-9bf7-ce571de49d01::\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"source_id\": \"crn:v1:bluemix:public:event-notifications:us-south:a/ff88f007f9ff4622aac4fbc0eda36255:b8b07245-0bbe-4478-b11c-0dce523105fd::\", \"source_description\": \"This source is used for integration with IBM Cloud Security and Compliance Center.\", \"source_name\": \"compliance\"}, \"object_storage\": {\"instance_crn\": \"instanceCrn\", \"bucket\": \"bucket\", \"bucket_location\": \"bucketLocation\", \"bucket_endpoint\": \"bucketEndpoint\", \"updated_on\": \"2019-01-01T12:00:00.000Z\"}}";
    String getSettingsPath = "/settings";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSettingsOptions model
    GetSettingsOptions getSettingsOptionsModel = new GetSettingsOptions.Builder()
      .xCorrelationId("1a2b3c4d-5e6f-4a7b-8c9d-e0f1a2b3c4d5")
      .xRequestId("testString")
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

  // Test the updateSettings operation with a valid options model parameter
  @Test
  public void testUpdateSettingsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"event_notifications\": {\"instance_crn\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/ff88f007f9ff4622aac4fbc0eda36255:7199ae60-a214-4dd8-9bf7-ce571de49d01::\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"source_id\": \"crn:v1:bluemix:public:event-notifications:us-south:a/ff88f007f9ff4622aac4fbc0eda36255:b8b07245-0bbe-4478-b11c-0dce523105fd::\", \"source_description\": \"This source is used for integration with IBM Cloud Security and Compliance Center.\", \"source_name\": \"compliance\"}, \"object_storage\": {\"instance_crn\": \"instanceCrn\", \"bucket\": \"bucket\", \"bucket_location\": \"bucketLocation\", \"bucket_endpoint\": \"bucketEndpoint\", \"updated_on\": \"2019-01-01T12:00:00.000Z\"}}";
    String updateSettingsPath = "/settings";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the EventNotifications model
    EventNotifications eventNotificationsModel = new EventNotifications.Builder()
      .instanceCrn("crn:v1:bluemix:public:event-notifications:us-south:a/ff88f007f9ff4622aac4fbc0eda36255:7199ae60-a214-4dd8-9bf7-ce571de49d01::")
      .updatedOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .sourceId("crn:v1:bluemix:public:event-notifications:us-south:a/ff88f007f9ff4622aac4fbc0eda36255:b8b07245-0bbe-4478-b11c-0dce523105fd::")
      .sourceDescription("This source is used for integration with IBM Cloud Security and Compliance Center.")
      .sourceName("compliance")
      .build();

    // Construct an instance of the ObjectStorage model
    ObjectStorage objectStorageModel = new ObjectStorage.Builder()
      .instanceCrn("crn:v1:bluemix:public:cloud-object-storage:global:a/ff88f007f9ff4622aac4fbc0eda36255:7199ae60-a214-4dd8-9bf7-ce571de49d01::")
      .bucket("px-scan-results")
      .bucketLocation("us-south")
      .bucketEndpoint("testString")
      .updatedOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .build();

    // Construct an instance of the UpdateSettingsOptions model
    UpdateSettingsOptions updateSettingsOptionsModel = new UpdateSettingsOptions.Builder()
      .eventNotifications(eventNotificationsModel)
      .objectStorage(objectStorageModel)
      .xCorrelationId("1a2b3c4d-5e6f-4a7b-8c9d-e0f1a2b3c4d5")
      .xRequestId("testString")
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

  // Test the postTestEvent operation with a valid options model parameter
  @Test
  public void testPostTestEventWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"success\": false}";
    String postTestEventPath = "/test_event";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the PostTestEventOptions model
    PostTestEventOptions postTestEventOptionsModel = new PostTestEventOptions.Builder()
      .xCorrelationId("1a2b3c4d-5e6f-4a7b-8c9d-e0f1a2b3c4d5")
      .xRequestId("testString")
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

  // Test the listControlLibraries operation with a valid options model parameter
  @Test
  public void testListControlLibrariesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_count\": 1, \"limit\": 20, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"control_libraries\": [{\"id\": \"id\", \"account_id\": \"accountId\", \"control_library_name\": \"controlLibraryName\", \"control_library_description\": \"controlLibraryDescription\", \"control_library_type\": \"controlLibraryType\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"version_group_label\": \"versionGroupLabel\", \"control_library_version\": \"controlLibraryVersion\", \"latest\": true, \"controls_count\": 13}]}";
    String listControlLibrariesPath = "/control_libraries";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListControlLibrariesOptions model
    ListControlLibrariesOptions listControlLibrariesOptionsModel = new ListControlLibrariesOptions.Builder()
      .xCorrelationId("testString")
      .xRequestId("testString")
      .limit(Long.valueOf("50"))
      .controlLibraryType("custom")
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
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("50"));
    assertEquals(query.get("control_library_type"), "custom");
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

  // Test the listControlLibraries operation using the ControlLibrariesPager.getNext() method
  @Test
  public void testListControlLibrariesWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"control_libraries\":[{\"id\":\"id\",\"account_id\":\"accountId\",\"control_library_name\":\"controlLibraryName\",\"control_library_description\":\"controlLibraryDescription\",\"control_library_type\":\"controlLibraryType\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"version_group_label\":\"versionGroupLabel\",\"control_library_version\":\"controlLibraryVersion\",\"latest\":true,\"controls_count\":13}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"control_libraries\":[{\"id\":\"id\",\"account_id\":\"accountId\",\"control_library_name\":\"controlLibraryName\",\"control_library_description\":\"controlLibraryDescription\",\"control_library_type\":\"controlLibraryType\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"version_group_label\":\"versionGroupLabel\",\"control_library_version\":\"controlLibraryVersion\",\"latest\":true,\"controls_count\":13}],\"total_count\":2,\"limit\":1}";
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
      .xCorrelationId("testString")
      .xRequestId("testString")
      .limit(Long.valueOf("50"))
      .controlLibraryType("custom")
      .build();

    List<ControlLibraryItem> allResults = new ArrayList<>();
    ControlLibrariesPager pager = new ControlLibrariesPager(securityAndComplianceCenterApiService, listControlLibrariesOptions);
    while (pager.hasNext()) {
      List<ControlLibraryItem> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listControlLibraries operation using the ControlLibrariesPager.getAll() method
  @Test
  public void testListControlLibrariesWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"control_libraries\":[{\"id\":\"id\",\"account_id\":\"accountId\",\"control_library_name\":\"controlLibraryName\",\"control_library_description\":\"controlLibraryDescription\",\"control_library_type\":\"controlLibraryType\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"version_group_label\":\"versionGroupLabel\",\"control_library_version\":\"controlLibraryVersion\",\"latest\":true,\"controls_count\":13}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"control_libraries\":[{\"id\":\"id\",\"account_id\":\"accountId\",\"control_library_name\":\"controlLibraryName\",\"control_library_description\":\"controlLibraryDescription\",\"control_library_type\":\"controlLibraryType\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"version_group_label\":\"versionGroupLabel\",\"control_library_version\":\"controlLibraryVersion\",\"latest\":true,\"controls_count\":13}],\"total_count\":2,\"limit\":1}";
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
      .xCorrelationId("testString")
      .xRequestId("testString")
      .limit(Long.valueOf("50"))
      .controlLibraryType("custom")
      .build();

    ControlLibrariesPager pager = new ControlLibrariesPager(securityAndComplianceCenterApiService, listControlLibrariesOptions);
    List<ControlLibraryItem> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the createCustomControlLibrary operation with a valid options model parameter
  @Test
  public void testCreateCustomControlLibraryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"f3517159-889e-4781-819a-89d89b747c85\", \"account_id\": \"130003ea8bfa43c5aacea07a86da3000\", \"control_library_name\": \"controlLibraryName\", \"control_library_description\": \"controlLibraryDescription\", \"control_library_type\": \"predefined\", \"version_group_label\": \"e0923045-f00d-44de-b49b-6f1f0e8033cc\", \"control_library_version\": \"controlLibraryVersion\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"latest\": true, \"hierarchy_enabled\": true, \"controls_count\": 13, \"control_parents_count\": 19, \"controls\": [{\"control_name\": \"controlName\", \"control_id\": \"1fa45e17-9322-4e6c-bbd6-1c51db08e790\", \"control_description\": \"controlDescription\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_tags\": [\"controlTags\"], \"control_specifications\": [{\"control_specification_id\": \"f3517159-889e-4781-819a-89d89b747c85\", \"responsibility\": \"user\", \"component_id\": \"f3517159-889e-4781-819a-89d89b747c85\", \"component_name\": \"componentName\", \"environment\": \"environment\", \"control_specification_description\": \"controlSpecificationDescription\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"assessmentId\", \"assessment_method\": \"assessmentMethod\", \"assessment_type\": \"assessmentType\", \"assessment_description\": \"assessmentDescription\", \"parameter_count\": 14, \"parameters\": [{\"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}], \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_requirement\": true, \"status\": \"enabled\"}]}";
    String createCustomControlLibraryPath = "/control_libraries";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the ParameterInfo model
    ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
      .parameterName("session_invalidation_in_seconds")
      .parameterDisplayName("Sign out due to inactivity in seconds")
      .parameterType("numeric")
      .parameterValue("public")
      .build();

    // Construct an instance of the Implementation model
    Implementation implementationModel = new Implementation.Builder()
      .assessmentId("rule-a637949b-7e51-46c4-afd4-b96619001bf1")
      .assessmentMethod("ibm-cloud-rule")
      .assessmentType("automated")
      .assessmentDescription("Check that there is an Activity Tracker event route defined to collect global events generated by IBM Cloud services")
      .parameterCount(Long.valueOf("26"))
      .parameters(java.util.Arrays.asList(parameterInfoModel))
      .build();

    // Construct an instance of the ControlSpecifications model
    ControlSpecifications controlSpecificationsModel = new ControlSpecifications.Builder()
      .controlSpecificationId("5c7d6f88-a92f-4734-9b49-bd22b0900184")
      .responsibility("user")
      .componentId("iam-identity")
      .componentName("IAM Identity Service")
      .environment("ibm-cloud")
      .controlSpecificationDescription("IBM cloud")
      .assessmentsCount(Long.valueOf("26"))
      .assessments(java.util.Arrays.asList(implementationModel))
      .build();

    // Construct an instance of the ControlDocs model
    ControlDocs controlDocsModel = new ControlDocs.Builder()
      .controlDocsId("sc-7")
      .controlDocsType("ibm-cloud")
      .build();

    // Construct an instance of the ControlsInControlLib model
    ControlsInControlLib controlsInControlLibModel = new ControlsInControlLib.Builder()
      .controlName("SC-7")
      .controlId("1fa45e17-9322-4e6c-bbd6-1c51db08e790")
      .controlDescription("Boundary Protection")
      .controlCategory("System and Communications Protection")
      .controlParent("testString")
      .controlTags(java.util.Arrays.asList("1fa45e17-9322-4e6c-bbd6-1c51db08e790"))
      .controlSpecifications(java.util.Arrays.asList(controlSpecificationsModel))
      .controlDocs(controlDocsModel)
      .controlRequirement(true)
      .status("enabled")
      .build();

    // Construct an instance of the CreateCustomControlLibraryOptions model
    CreateCustomControlLibraryOptions createCustomControlLibraryOptionsModel = new CreateCustomControlLibraryOptions.Builder()
      .controlLibraryName("IBM Cloud for Financial Services")
      .controlLibraryDescription("IBM Cloud for Financial Services")
      .controlLibraryType("custom")
      .controls(java.util.Arrays.asList(controlsInControlLibModel))
      .versionGroupLabel("33fc7b80-0fa5-4f16-bbba-1f293f660f0d")
      .controlLibraryVersion("1.0.0")
      .latest(true)
      .controlsCount(Long.valueOf("26"))
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();

    // Invoke createCustomControlLibrary() with a valid options model and verify the result
    Response<ControlLibrary> response = securityAndComplianceCenterApiService.createCustomControlLibrary(createCustomControlLibraryOptionsModel).execute();
    assertNotNull(response);
    ControlLibrary responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createCustomControlLibraryPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createCustomControlLibrary operation with and without retries enabled
  @Test
  public void testCreateCustomControlLibraryWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testCreateCustomControlLibraryWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testCreateCustomControlLibraryWOptions();
  }

  // Test the createCustomControlLibrary operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCustomControlLibraryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.createCustomControlLibrary(null).execute();
  }

  // Test the deleteCustomControlLibrary operation with a valid options model parameter
  @Test
  public void testDeleteCustomControlLibraryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"deleted\": \"deleted\"}";
    String deleteCustomControlLibraryPath = "/control_libraries/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteCustomControlLibraryOptions model
    DeleteCustomControlLibraryOptions deleteCustomControlLibraryOptionsModel = new DeleteCustomControlLibraryOptions.Builder()
      .controlLibrariesId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();

    // Invoke deleteCustomControlLibrary() with a valid options model and verify the result
    Response<ControlLibraryDelete> response = securityAndComplianceCenterApiService.deleteCustomControlLibrary(deleteCustomControlLibraryOptionsModel).execute();
    assertNotNull(response);
    ControlLibraryDelete responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteCustomControlLibraryPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
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

  // Test the getControlLibrary operation with a valid options model parameter
  @Test
  public void testGetControlLibraryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"f3517159-889e-4781-819a-89d89b747c85\", \"account_id\": \"130003ea8bfa43c5aacea07a86da3000\", \"control_library_name\": \"controlLibraryName\", \"control_library_description\": \"controlLibraryDescription\", \"control_library_type\": \"predefined\", \"version_group_label\": \"e0923045-f00d-44de-b49b-6f1f0e8033cc\", \"control_library_version\": \"controlLibraryVersion\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"latest\": true, \"hierarchy_enabled\": true, \"controls_count\": 13, \"control_parents_count\": 19, \"controls\": [{\"control_name\": \"controlName\", \"control_id\": \"1fa45e17-9322-4e6c-bbd6-1c51db08e790\", \"control_description\": \"controlDescription\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_tags\": [\"controlTags\"], \"control_specifications\": [{\"control_specification_id\": \"f3517159-889e-4781-819a-89d89b747c85\", \"responsibility\": \"user\", \"component_id\": \"f3517159-889e-4781-819a-89d89b747c85\", \"component_name\": \"componentName\", \"environment\": \"environment\", \"control_specification_description\": \"controlSpecificationDescription\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"assessmentId\", \"assessment_method\": \"assessmentMethod\", \"assessment_type\": \"assessmentType\", \"assessment_description\": \"assessmentDescription\", \"parameter_count\": 14, \"parameters\": [{\"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}], \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_requirement\": true, \"status\": \"enabled\"}]}";
    String getControlLibraryPath = "/control_libraries/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetControlLibraryOptions model
    GetControlLibraryOptions getControlLibraryOptionsModel = new GetControlLibraryOptions.Builder()
      .controlLibrariesId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
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
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
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

  // Test the replaceCustomControlLibrary operation with a valid options model parameter
  @Test
  public void testReplaceCustomControlLibraryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"f3517159-889e-4781-819a-89d89b747c85\", \"account_id\": \"130003ea8bfa43c5aacea07a86da3000\", \"control_library_name\": \"controlLibraryName\", \"control_library_description\": \"controlLibraryDescription\", \"control_library_type\": \"predefined\", \"version_group_label\": \"e0923045-f00d-44de-b49b-6f1f0e8033cc\", \"control_library_version\": \"controlLibraryVersion\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"latest\": true, \"hierarchy_enabled\": true, \"controls_count\": 13, \"control_parents_count\": 19, \"controls\": [{\"control_name\": \"controlName\", \"control_id\": \"1fa45e17-9322-4e6c-bbd6-1c51db08e790\", \"control_description\": \"controlDescription\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_tags\": [\"controlTags\"], \"control_specifications\": [{\"control_specification_id\": \"f3517159-889e-4781-819a-89d89b747c85\", \"responsibility\": \"user\", \"component_id\": \"f3517159-889e-4781-819a-89d89b747c85\", \"component_name\": \"componentName\", \"environment\": \"environment\", \"control_specification_description\": \"controlSpecificationDescription\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"assessmentId\", \"assessment_method\": \"assessmentMethod\", \"assessment_type\": \"assessmentType\", \"assessment_description\": \"assessmentDescription\", \"parameter_count\": 14, \"parameters\": [{\"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}], \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_requirement\": true, \"status\": \"enabled\"}]}";
    String replaceCustomControlLibraryPath = "/control_libraries/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ParameterInfo model
    ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
      .parameterName("session_invalidation_in_seconds")
      .parameterDisplayName("Sign out due to inactivity in seconds")
      .parameterType("numeric")
      .parameterValue("public")
      .build();

    // Construct an instance of the Implementation model
    Implementation implementationModel = new Implementation.Builder()
      .assessmentId("rule-a637949b-7e51-46c4-afd4-b96619001bf1")
      .assessmentMethod("ibm-cloud-rule")
      .assessmentType("automated")
      .assessmentDescription("Check that there is an Activity Tracker event route defined to collect global events generated by IBM Cloud services")
      .parameterCount(Long.valueOf("26"))
      .parameters(java.util.Arrays.asList(parameterInfoModel))
      .build();

    // Construct an instance of the ControlSpecifications model
    ControlSpecifications controlSpecificationsModel = new ControlSpecifications.Builder()
      .controlSpecificationId("5c7d6f88-a92f-4734-9b49-bd22b0900184")
      .responsibility("user")
      .componentId("iam-identity")
      .componentName("IAM Identity Service")
      .environment("ibm-cloud")
      .controlSpecificationDescription("IBM cloud")
      .assessmentsCount(Long.valueOf("26"))
      .assessments(java.util.Arrays.asList(implementationModel))
      .build();

    // Construct an instance of the ControlDocs model
    ControlDocs controlDocsModel = new ControlDocs.Builder()
      .controlDocsId("sc-7")
      .controlDocsType("ibm-cloud")
      .build();

    // Construct an instance of the ControlsInControlLib model
    ControlsInControlLib controlsInControlLibModel = new ControlsInControlLib.Builder()
      .controlName("SC-7")
      .controlId("1fa45e17-9322-4e6c-bbd6-1c51db08e790")
      .controlDescription("Boundary Protection")
      .controlCategory("System and Communications Protection")
      .controlParent("testString")
      .controlTags(java.util.Arrays.asList("1fa45e17-9322-4e6c-bbd6-1c51db08e790"))
      .controlSpecifications(java.util.Arrays.asList(controlSpecificationsModel))
      .controlDocs(controlDocsModel)
      .controlRequirement(true)
      .status("enabled")
      .build();

    // Construct an instance of the ReplaceCustomControlLibraryOptions model
    ReplaceCustomControlLibraryOptions replaceCustomControlLibraryOptionsModel = new ReplaceCustomControlLibraryOptions.Builder()
      .controlLibrariesId("testString")
      .id("testString")
      .accountId("testString")
      .controlLibraryName("IBM Cloud for Financial Services")
      .controlLibraryDescription("IBM Cloud for Financial Services")
      .controlLibraryType("custom")
      .versionGroupLabel("testString")
      .controlLibraryVersion("1.1.0")
      .createdOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .createdBy("testString")
      .updatedOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .updatedBy("testString")
      .latest(true)
      .hierarchyEnabled(true)
      .controlsCount(Long.valueOf("26"))
      .controlParentsCount(Long.valueOf("26"))
      .controls(java.util.Arrays.asList(controlsInControlLibModel))
      .xCorrelationId("testString")
      .xRequestId("testString")
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
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
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

  // Test the listProfiles operation with a valid options model parameter
  @Test
  public void testListProfilesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_count\": 1, \"limit\": 20, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"profiles\": [{\"id\": \"id\", \"profile_name\": \"profileName\", \"profile_description\": \"profileDescription\", \"profile_type\": \"profileType\", \"profile_version\": \"profileVersion\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"controls_count\": 13, \"attachments_count\": 16}]}";
    String listProfilesPath = "/profiles";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListProfilesOptions model
    ListProfilesOptions listProfilesOptionsModel = new ListProfilesOptions.Builder()
      .xCorrelationId("testString")
      .xRequestId("testString")
      .limit(Long.valueOf("10"))
      .profileType("custom")
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
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("profile_type"), "custom");
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

  // Test the listProfiles operation using the ProfilesPager.getNext() method
  @Test
  public void testListProfilesWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"limit\":1,\"profiles\":[{\"id\":\"id\",\"profile_name\":\"profileName\",\"profile_description\":\"profileDescription\",\"profile_type\":\"profileType\",\"profile_version\":\"profileVersion\",\"version_group_label\":\"versionGroupLabel\",\"latest\":true,\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"controls_count\":13,\"attachments_count\":16}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"profiles\":[{\"id\":\"id\",\"profile_name\":\"profileName\",\"profile_description\":\"profileDescription\",\"profile_type\":\"profileType\",\"profile_version\":\"profileVersion\",\"version_group_label\":\"versionGroupLabel\",\"latest\":true,\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"controls_count\":13,\"attachments_count\":16}]}";
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
      .xCorrelationId("testString")
      .xRequestId("testString")
      .limit(Long.valueOf("10"))
      .profileType("custom")
      .build();

    List<ProfileItem> allResults = new ArrayList<>();
    ProfilesPager pager = new ProfilesPager(securityAndComplianceCenterApiService, listProfilesOptions);
    while (pager.hasNext()) {
      List<ProfileItem> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listProfiles operation using the ProfilesPager.getAll() method
  @Test
  public void testListProfilesWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"limit\":1,\"profiles\":[{\"id\":\"id\",\"profile_name\":\"profileName\",\"profile_description\":\"profileDescription\",\"profile_type\":\"profileType\",\"profile_version\":\"profileVersion\",\"version_group_label\":\"versionGroupLabel\",\"latest\":true,\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"controls_count\":13,\"attachments_count\":16}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"profiles\":[{\"id\":\"id\",\"profile_name\":\"profileName\",\"profile_description\":\"profileDescription\",\"profile_type\":\"profileType\",\"profile_version\":\"profileVersion\",\"version_group_label\":\"versionGroupLabel\",\"latest\":true,\"created_by\":\"createdBy\",\"created_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"controls_count\":13,\"attachments_count\":16}]}";
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
      .xCorrelationId("testString")
      .xRequestId("testString")
      .limit(Long.valueOf("10"))
      .profileType("custom")
      .build();

    ProfilesPager pager = new ProfilesPager(securityAndComplianceCenterApiService, listProfilesOptions);
    List<ProfileItem> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the createProfile operation with a valid options model parameter
  @Test
  public void testCreateProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"profile_name\": \"profileName\", \"profile_description\": \"profileDescription\", \"profile_type\": \"predefined\", \"profile_version\": \"profileVersion\", \"version_group_label\": \"e0923045-f00d-44de-b49b-6f1f0e8033cc\", \"instance_id\": \"instanceId\", \"latest\": true, \"hierarchy_enabled\": true, \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"controls_count\": 13, \"control_parents_count\": 19, \"attachments_count\": 16, \"controls\": [{\"control_library_id\": \"e98a56ff-dc24-41d4-9875-1e188e2da6cd\", \"control_id\": \"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\", \"control_library_version\": \"controlLibraryVersion\", \"control_name\": \"controlName\", \"control_description\": \"controlDescription\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_requirement\": true, \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_specifications_count\": 26, \"control_specifications\": [{\"control_specification_id\": \"f3517159-889e-4781-819a-89d89b747c85\", \"responsibility\": \"user\", \"component_id\": \"f3517159-889e-4781-819a-89d89b747c85\", \"component_name\": \"componentName\", \"environment\": \"environment\", \"control_specification_description\": \"controlSpecificationDescription\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"assessmentId\", \"assessment_method\": \"assessmentMethod\", \"assessment_type\": \"assessmentType\", \"assessment_description\": \"assessmentDescription\", \"parameter_count\": 14, \"parameters\": [{\"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}]}], \"default_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"string\"}]}";
    String createProfilePath = "/profiles";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the ProfileControlsPrototype model
    ProfileControlsPrototype profileControlsPrototypeModel = new ProfileControlsPrototype.Builder()
      .controlLibraryId("e98a56ff-dc24-41d4-9875-1e188e2da6cd")
      .controlId("1fa45e17-9322-4e6c-bbd6-1c51db08e790")
      .build();

    // Construct an instance of the DefaultParametersPrototype model
    DefaultParametersPrototype defaultParametersPrototypeModel = new DefaultParametersPrototype.Builder()
      .assessmentType("Automated")
      .assessmentId("rule-a637949b-7e51-46c4-afd4-b96619001bf1")
      .parameterName("session_invalidation_in_seconds")
      .parameterDefaultValue("120")
      .parameterDisplayName("Sign out due to inactivity in seconds")
      .parameterType("numeric")
      .build();

    // Construct an instance of the CreateProfileOptions model
    CreateProfileOptions createProfileOptionsModel = new CreateProfileOptions.Builder()
      .profileName("test_profile1")
      .profileDescription("test_description1")
      .profileType("custom")
      .controls(java.util.Arrays.asList(profileControlsPrototypeModel))
      .defaultParameters(java.util.Arrays.asList(defaultParametersPrototypeModel))
      .xCorrelationId("testString")
      .xRequestId("testString")
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
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
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

  // Test the deleteCustomProfile operation with a valid options model parameter
  @Test
  public void testDeleteCustomProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"profile_name\": \"profileName\", \"profile_description\": \"profileDescription\", \"profile_type\": \"predefined\", \"profile_version\": \"profileVersion\", \"version_group_label\": \"e0923045-f00d-44de-b49b-6f1f0e8033cc\", \"instance_id\": \"instanceId\", \"latest\": true, \"hierarchy_enabled\": true, \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"controls_count\": 13, \"control_parents_count\": 19, \"attachments_count\": 16, \"controls\": [{\"control_library_id\": \"e98a56ff-dc24-41d4-9875-1e188e2da6cd\", \"control_id\": \"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\", \"control_library_version\": \"controlLibraryVersion\", \"control_name\": \"controlName\", \"control_description\": \"controlDescription\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_requirement\": true, \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_specifications_count\": 26, \"control_specifications\": [{\"control_specification_id\": \"f3517159-889e-4781-819a-89d89b747c85\", \"responsibility\": \"user\", \"component_id\": \"f3517159-889e-4781-819a-89d89b747c85\", \"component_name\": \"componentName\", \"environment\": \"environment\", \"control_specification_description\": \"controlSpecificationDescription\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"assessmentId\", \"assessment_method\": \"assessmentMethod\", \"assessment_type\": \"assessmentType\", \"assessment_description\": \"assessmentDescription\", \"parameter_count\": 14, \"parameters\": [{\"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}]}], \"default_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"string\"}]}";
    String deleteCustomProfilePath = "/profiles/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteCustomProfileOptions model
    DeleteCustomProfileOptions deleteCustomProfileOptionsModel = new DeleteCustomProfileOptions.Builder()
      .profileId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
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
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
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

  // Test the getProfile operation with a valid options model parameter
  @Test
  public void testGetProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"profile_name\": \"profileName\", \"profile_description\": \"profileDescription\", \"profile_type\": \"predefined\", \"profile_version\": \"profileVersion\", \"version_group_label\": \"e0923045-f00d-44de-b49b-6f1f0e8033cc\", \"instance_id\": \"instanceId\", \"latest\": true, \"hierarchy_enabled\": true, \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"controls_count\": 13, \"control_parents_count\": 19, \"attachments_count\": 16, \"controls\": [{\"control_library_id\": \"e98a56ff-dc24-41d4-9875-1e188e2da6cd\", \"control_id\": \"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\", \"control_library_version\": \"controlLibraryVersion\", \"control_name\": \"controlName\", \"control_description\": \"controlDescription\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_requirement\": true, \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_specifications_count\": 26, \"control_specifications\": [{\"control_specification_id\": \"f3517159-889e-4781-819a-89d89b747c85\", \"responsibility\": \"user\", \"component_id\": \"f3517159-889e-4781-819a-89d89b747c85\", \"component_name\": \"componentName\", \"environment\": \"environment\", \"control_specification_description\": \"controlSpecificationDescription\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"assessmentId\", \"assessment_method\": \"assessmentMethod\", \"assessment_type\": \"assessmentType\", \"assessment_description\": \"assessmentDescription\", \"parameter_count\": 14, \"parameters\": [{\"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}]}], \"default_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"string\"}]}";
    String getProfilePath = "/profiles/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetProfileOptions model
    GetProfileOptions getProfileOptionsModel = new GetProfileOptions.Builder()
      .profileId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
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
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
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

  // Test the replaceProfile operation with a valid options model parameter
  @Test
  public void testReplaceProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"profile_name\": \"profileName\", \"profile_description\": \"profileDescription\", \"profile_type\": \"predefined\", \"profile_version\": \"profileVersion\", \"version_group_label\": \"e0923045-f00d-44de-b49b-6f1f0e8033cc\", \"instance_id\": \"instanceId\", \"latest\": true, \"hierarchy_enabled\": true, \"created_by\": \"createdBy\", \"created_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"controls_count\": 13, \"control_parents_count\": 19, \"attachments_count\": 16, \"controls\": [{\"control_library_id\": \"e98a56ff-dc24-41d4-9875-1e188e2da6cd\", \"control_id\": \"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\", \"control_library_version\": \"controlLibraryVersion\", \"control_name\": \"controlName\", \"control_description\": \"controlDescription\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_requirement\": true, \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_specifications_count\": 26, \"control_specifications\": [{\"control_specification_id\": \"f3517159-889e-4781-819a-89d89b747c85\", \"responsibility\": \"user\", \"component_id\": \"f3517159-889e-4781-819a-89d89b747c85\", \"component_name\": \"componentName\", \"environment\": \"environment\", \"control_specification_description\": \"controlSpecificationDescription\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"assessmentId\", \"assessment_method\": \"assessmentMethod\", \"assessment_type\": \"assessmentType\", \"assessment_description\": \"assessmentDescription\", \"parameter_count\": 14, \"parameters\": [{\"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}]}]}], \"default_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"string\"}]}";
    String replaceProfilePath = "/profiles/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ProfileControlsPrototype model
    ProfileControlsPrototype profileControlsPrototypeModel = new ProfileControlsPrototype.Builder()
      .controlLibraryId("e98a56ff-dc24-41d4-9875-1e188e2da6cd")
      .controlId("1fa45e17-9322-4e6c-bbd6-1c51db08e790")
      .build();

    // Construct an instance of the DefaultParametersPrototype model
    DefaultParametersPrototype defaultParametersPrototypeModel = new DefaultParametersPrototype.Builder()
      .assessmentType("Automated")
      .assessmentId("rule-a637949b-7e51-46c4-afd4-b96619001bf1")
      .parameterName("session_invalidation_in_seconds")
      .parameterDefaultValue("120")
      .parameterDisplayName("Sign out due to inactivity in seconds")
      .parameterType("numeric")
      .build();

    // Construct an instance of the ReplaceProfileOptions model
    ReplaceProfileOptions replaceProfileOptionsModel = new ReplaceProfileOptions.Builder()
      .profileId("testString")
      .profileName("test_profile1")
      .profileDescription("test_description1")
      .profileType("custom")
      .controls(java.util.Arrays.asList(profileControlsPrototypeModel))
      .defaultParameters(java.util.Arrays.asList(defaultParametersPrototypeModel))
      .xCorrelationId("testString")
      .xRequestId("testString")
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
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
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

  // Test the listRules operation with a valid options model parameter
  @Test
  public void testListRulesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 50, \"total_count\": 230, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"rules\": [{\"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"id\": \"id\", \"account_id\": \"accountId\", \"description\": \"description\", \"type\": \"user_defined\", \"version\": \"version\", \"import\": {\"parameters\": [{\"name\": \"name\", \"display_name\": \"displayName\", \"description\": \"description\", \"type\": \"string\"}]}, \"target\": {\"service_name\": \"serviceName\", \"service_display_name\": \"serviceDisplayName\", \"resource_kind\": \"resourceKind\", \"additional_target_attributes\": [{\"name\": \"name\", \"operator\": \"string_equals\", \"value\": \"value\"}]}, \"required_config\": {\"description\": \"description\", \"and\": [{\"description\": \"description\", \"or\": [{\"description\": \"description\", \"property\": \"property\", \"operator\": \"string_equals\", \"value\": \"anyValue\"}]}]}, \"labels\": [\"labels\"]}]}";
    String listRulesPath = "/rules";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListRulesOptions model
    ListRulesOptions listRulesOptionsModel = new ListRulesOptions.Builder()
      .xCorrelationId("testString")
      .xRequestId("testString")
      .type("system_defined")
      .search("testString")
      .serviceName("testString")
      .build();

    // Invoke listRules() with a valid options model and verify the result
    Response<RulesPageBase> response = securityAndComplianceCenterApiService.listRules(listRulesOptionsModel).execute();
    assertNotNull(response);
    RulesPageBase responseObj = response.getResult();
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
    assertEquals(query.get("type"), "system_defined");
    assertEquals(query.get("search"), "testString");
    assertEquals(query.get("service_name"), "testString");
  }

  // Test the listRules operation with and without retries enabled
  @Test
  public void testListRulesWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListRulesWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListRulesWOptions();
  }

  // Test the createRule operation with a valid options model parameter
  @Test
  public void testCreateRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"id\": \"id\", \"account_id\": \"accountId\", \"description\": \"description\", \"type\": \"user_defined\", \"version\": \"version\", \"import\": {\"parameters\": [{\"name\": \"name\", \"display_name\": \"displayName\", \"description\": \"description\", \"type\": \"string\"}]}, \"target\": {\"service_name\": \"serviceName\", \"service_display_name\": \"serviceDisplayName\", \"resource_kind\": \"resourceKind\", \"additional_target_attributes\": [{\"name\": \"name\", \"operator\": \"string_equals\", \"value\": \"value\"}]}, \"required_config\": {\"description\": \"description\", \"and\": [{\"description\": \"description\", \"or\": [{\"description\": \"description\", \"property\": \"property\", \"operator\": \"string_equals\", \"value\": \"anyValue\"}]}]}, \"labels\": [\"labels\"]}";
    String createRulePath = "/rules";
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

    // Construct an instance of the TargetPrototype model
    TargetPrototype targetPrototypeModel = new TargetPrototype.Builder()
      .serviceName("cloud-object-storage")
      .resourceKind("bucket")
      .additionalTargetAttributes(java.util.Arrays.asList(additionalTargetAttributeModel))
      .build();

    // Construct an instance of the RequiredConfigItemsRequiredConfigBase model
    RequiredConfigItemsRequiredConfigBase requiredConfigItemsModel = new RequiredConfigItemsRequiredConfigBase.Builder()
      .description("testString")
      .property("hard_quota")
      .operator("num_equals")
      .value("${hard_quota}")
      .build();

    // Construct an instance of the RequiredConfigAnd model
    RequiredConfigAnd requiredConfigModel = new RequiredConfigAnd.Builder()
      .description("The Cloud Object Storage rule.")
      .and(java.util.Arrays.asList(requiredConfigItemsModel))
      .build();

    // Construct an instance of the Parameter model
    Parameter parameterModel = new Parameter.Builder()
      .name("hard_quota")
      .displayName("The Cloud Object Storage bucket quota.")
      .description("The maximum bytes that are allocated to the Cloud Object Storage bucket.")
      .type("numeric")
      .build();

    // Construct an instance of the Import model
    Import importModel = new Import.Builder()
      .parameters(java.util.Arrays.asList(parameterModel))
      .build();

    // Construct an instance of the CreateRuleOptions model
    CreateRuleOptions createRuleOptionsModel = new CreateRuleOptions.Builder()
      .description("Example rule")
      .target(targetPrototypeModel)
      .requiredConfig(requiredConfigModel)
      .version("1.0.0")
      .xImport(importModel)
      .labels(java.util.Arrays.asList())
      .xCorrelationId("testString")
      .xRequestId("testString")
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

  // Test the deleteRule operation with a valid options model parameter
  @Test
  public void testDeleteRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteRulePath = "/rules/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteRuleOptions model
    DeleteRuleOptions deleteRuleOptionsModel = new DeleteRuleOptions.Builder()
      .ruleId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
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

  // Test the getRule operation with a valid options model parameter
  @Test
  public void testGetRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"id\": \"id\", \"account_id\": \"accountId\", \"description\": \"description\", \"type\": \"user_defined\", \"version\": \"version\", \"import\": {\"parameters\": [{\"name\": \"name\", \"display_name\": \"displayName\", \"description\": \"description\", \"type\": \"string\"}]}, \"target\": {\"service_name\": \"serviceName\", \"service_display_name\": \"serviceDisplayName\", \"resource_kind\": \"resourceKind\", \"additional_target_attributes\": [{\"name\": \"name\", \"operator\": \"string_equals\", \"value\": \"value\"}]}, \"required_config\": {\"description\": \"description\", \"and\": [{\"description\": \"description\", \"or\": [{\"description\": \"description\", \"property\": \"property\", \"operator\": \"string_equals\", \"value\": \"anyValue\"}]}]}, \"labels\": [\"labels\"]}";
    String getRulePath = "/rules/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetRuleOptions model
    GetRuleOptions getRuleOptionsModel = new GetRuleOptions.Builder()
      .ruleId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
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
    String mockResponseBody = "{\"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"id\": \"id\", \"account_id\": \"accountId\", \"description\": \"description\", \"type\": \"user_defined\", \"version\": \"version\", \"import\": {\"parameters\": [{\"name\": \"name\", \"display_name\": \"displayName\", \"description\": \"description\", \"type\": \"string\"}]}, \"target\": {\"service_name\": \"serviceName\", \"service_display_name\": \"serviceDisplayName\", \"resource_kind\": \"resourceKind\", \"additional_target_attributes\": [{\"name\": \"name\", \"operator\": \"string_equals\", \"value\": \"value\"}]}, \"required_config\": {\"description\": \"description\", \"and\": [{\"description\": \"description\", \"or\": [{\"description\": \"description\", \"property\": \"property\", \"operator\": \"string_equals\", \"value\": \"anyValue\"}]}]}, \"labels\": [\"labels\"]}";
    String replaceRulePath = "/rules/testString";
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

    // Construct an instance of the TargetPrototype model
    TargetPrototype targetPrototypeModel = new TargetPrototype.Builder()
      .serviceName("cloud-object-storage")
      .resourceKind("bucket")
      .additionalTargetAttributes(java.util.Arrays.asList(additionalTargetAttributeModel))
      .build();

    // Construct an instance of the RequiredConfigItemsRequiredConfigBase model
    RequiredConfigItemsRequiredConfigBase requiredConfigItemsModel = new RequiredConfigItemsRequiredConfigBase.Builder()
      .description("testString")
      .property("hard_quota")
      .operator("num_equals")
      .value("${hard_quota}")
      .build();

    // Construct an instance of the RequiredConfigAnd model
    RequiredConfigAnd requiredConfigModel = new RequiredConfigAnd.Builder()
      .description("The Cloud Object Storage rule.")
      .and(java.util.Arrays.asList(requiredConfigItemsModel))
      .build();

    // Construct an instance of the Parameter model
    Parameter parameterModel = new Parameter.Builder()
      .name("hard_quota")
      .displayName("The Cloud Object Storage bucket quota.")
      .description("The maximum bytes that are allocated to the Cloud Object Storage bucket.")
      .type("numeric")
      .build();

    // Construct an instance of the Import model
    Import importModel = new Import.Builder()
      .parameters(java.util.Arrays.asList(parameterModel))
      .build();

    // Construct an instance of the ReplaceRuleOptions model
    ReplaceRuleOptions replaceRuleOptionsModel = new ReplaceRuleOptions.Builder()
      .ruleId("testString")
      .ifMatch("testString")
      .description("Example rule")
      .target(targetPrototypeModel)
      .requiredConfig(requiredConfigModel)
      .version("1.0.1")
      .xImport(importModel)
      .labels(java.util.Arrays.asList())
      .xCorrelationId("testString")
      .xRequestId("testString")
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

  // Test the listAttachments operation with a valid options model parameter
  @Test
  public void testListAttachmentsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_count\": 1, \"limit\": 20, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"attachments\": [{\"id\": \"130003ea8bfa43c5aacea07a86da3000\", \"profile_id\": \"7ec45986-54fc-4b66-a303-d9577b078c65\", \"account_id\": \"130003ea8bfa43c5aacea07a86da3000\", \"instance_id\": \"edf9524f-406c-412c-acbb-ee371a5cabda\", \"scope\": [{\"environment\": \"environment\", \"properties\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"status\": \"enabled\", \"schedule\": \"daily\", \"notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 14, \"failed_control_ids\": [\"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\"]}}, \"attachment_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_value\": \"parameterValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"string\"}], \"last_scan\": {\"id\": \"e8a39d25-0051-4328-8462-988ad321f49a\", \"status\": \"in_progress\", \"time\": \"2019-01-01T12:00:00.000Z\"}, \"next_scan_time\": \"2019-01-01T12:00:00.000Z\", \"name\": \"account-130003ea8bfa43c5aacea07a86da3000\", \"description\": \"Test description\"}]}";
    String listAttachmentsPath = "/profiles/testString/attachments";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListAttachmentsOptions model
    ListAttachmentsOptions listAttachmentsOptionsModel = new ListAttachmentsOptions.Builder()
      .profileId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .limit(Long.valueOf("10"))
      .start("testString")
      .build();

    // Invoke listAttachments() with a valid options model and verify the result
    Response<AttachmentCollection> response = securityAndComplianceCenterApiService.listAttachments(listAttachmentsOptionsModel).execute();
    assertNotNull(response);
    AttachmentCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAttachmentsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
  }

  // Test the listAttachments operation with and without retries enabled
  @Test
  public void testListAttachmentsWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListAttachmentsWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListAttachmentsWOptions();
  }

  // Test the listAttachments operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAttachmentsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.listAttachments(null).execute();
  }

  // Test the listAttachments operation using the AttachmentsPager.getNext() method
  @Test
  public void testListAttachmentsWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"attachments\":[{\"id\":\"130003ea8bfa43c5aacea07a86da3000\",\"profile_id\":\"7ec45986-54fc-4b66-a303-d9577b078c65\",\"account_id\":\"130003ea8bfa43c5aacea07a86da3000\",\"instance_id\":\"edf9524f-406c-412c-acbb-ee371a5cabda\",\"scope\":[{\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"value\"}]}],\"created_on\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"status\":\"enabled\",\"schedule\":\"daily\",\"notifications\":{\"enabled\":false,\"controls\":{\"threshold_limit\":14,\"failed_control_ids\":[\"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\"]}},\"attachment_parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"parameterName\",\"parameter_value\":\"parameterValue\",\"parameter_display_name\":\"parameterDisplayName\",\"parameter_type\":\"string\"}],\"last_scan\":{\"id\":\"e8a39d25-0051-4328-8462-988ad321f49a\",\"status\":\"in_progress\",\"time\":\"2019-01-01T12:00:00.000Z\"},\"next_scan_time\":\"2019-01-01T12:00:00.000Z\",\"name\":\"account-130003ea8bfa43c5aacea07a86da3000\",\"description\":\"Test description\"}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"attachments\":[{\"id\":\"130003ea8bfa43c5aacea07a86da3000\",\"profile_id\":\"7ec45986-54fc-4b66-a303-d9577b078c65\",\"account_id\":\"130003ea8bfa43c5aacea07a86da3000\",\"instance_id\":\"edf9524f-406c-412c-acbb-ee371a5cabda\",\"scope\":[{\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"value\"}]}],\"created_on\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"status\":\"enabled\",\"schedule\":\"daily\",\"notifications\":{\"enabled\":false,\"controls\":{\"threshold_limit\":14,\"failed_control_ids\":[\"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\"]}},\"attachment_parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"parameterName\",\"parameter_value\":\"parameterValue\",\"parameter_display_name\":\"parameterDisplayName\",\"parameter_type\":\"string\"}],\"last_scan\":{\"id\":\"e8a39d25-0051-4328-8462-988ad321f49a\",\"status\":\"in_progress\",\"time\":\"2019-01-01T12:00:00.000Z\"},\"next_scan_time\":\"2019-01-01T12:00:00.000Z\",\"name\":\"account-130003ea8bfa43c5aacea07a86da3000\",\"description\":\"Test description\"}],\"total_count\":2,\"limit\":1}";
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

    ListAttachmentsOptions listAttachmentsOptions = new ListAttachmentsOptions.Builder()
      .profileId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .limit(Long.valueOf("10"))
      .build();

    List<AttachmentItem> allResults = new ArrayList<>();
    AttachmentsPager pager = new AttachmentsPager(securityAndComplianceCenterApiService, listAttachmentsOptions);
    while (pager.hasNext()) {
      List<AttachmentItem> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listAttachments operation using the AttachmentsPager.getAll() method
  @Test
  public void testListAttachmentsWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"attachments\":[{\"id\":\"130003ea8bfa43c5aacea07a86da3000\",\"profile_id\":\"7ec45986-54fc-4b66-a303-d9577b078c65\",\"account_id\":\"130003ea8bfa43c5aacea07a86da3000\",\"instance_id\":\"edf9524f-406c-412c-acbb-ee371a5cabda\",\"scope\":[{\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"value\"}]}],\"created_on\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"status\":\"enabled\",\"schedule\":\"daily\",\"notifications\":{\"enabled\":false,\"controls\":{\"threshold_limit\":14,\"failed_control_ids\":[\"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\"]}},\"attachment_parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"parameterName\",\"parameter_value\":\"parameterValue\",\"parameter_display_name\":\"parameterDisplayName\",\"parameter_type\":\"string\"}],\"last_scan\":{\"id\":\"e8a39d25-0051-4328-8462-988ad321f49a\",\"status\":\"in_progress\",\"time\":\"2019-01-01T12:00:00.000Z\"},\"next_scan_time\":\"2019-01-01T12:00:00.000Z\",\"name\":\"account-130003ea8bfa43c5aacea07a86da3000\",\"description\":\"Test description\"}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"attachments\":[{\"id\":\"130003ea8bfa43c5aacea07a86da3000\",\"profile_id\":\"7ec45986-54fc-4b66-a303-d9577b078c65\",\"account_id\":\"130003ea8bfa43c5aacea07a86da3000\",\"instance_id\":\"edf9524f-406c-412c-acbb-ee371a5cabda\",\"scope\":[{\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"value\"}]}],\"created_on\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"status\":\"enabled\",\"schedule\":\"daily\",\"notifications\":{\"enabled\":false,\"controls\":{\"threshold_limit\":14,\"failed_control_ids\":[\"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\"]}},\"attachment_parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"parameterName\",\"parameter_value\":\"parameterValue\",\"parameter_display_name\":\"parameterDisplayName\",\"parameter_type\":\"string\"}],\"last_scan\":{\"id\":\"e8a39d25-0051-4328-8462-988ad321f49a\",\"status\":\"in_progress\",\"time\":\"2019-01-01T12:00:00.000Z\"},\"next_scan_time\":\"2019-01-01T12:00:00.000Z\",\"name\":\"account-130003ea8bfa43c5aacea07a86da3000\",\"description\":\"Test description\"}],\"total_count\":2,\"limit\":1}";
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

    ListAttachmentsOptions listAttachmentsOptions = new ListAttachmentsOptions.Builder()
      .profileId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .limit(Long.valueOf("10"))
      .build();

    AttachmentsPager pager = new AttachmentsPager(securityAndComplianceCenterApiService, listAttachmentsOptions);
    List<AttachmentItem> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the createAttachment operation with a valid options model parameter
  @Test
  public void testCreateAttachmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"profile_id\": \"profileId\", \"attachments\": [{\"id\": \"130003ea8bfa43c5aacea07a86da3000\", \"name\": \"account-130003ea8bfa43c5aacea07a86da3000\", \"description\": \"Test description\", \"scope\": [{\"environment\": \"environment\", \"properties\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"status\": \"enabled\", \"schedule\": \"daily\", \"notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 14, \"failed_control_ids\": [\"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\"]}}, \"attachment_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_value\": \"parameterValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"string\"}]}]}";
    String createAttachmentPath = "/profiles/testString/attachments";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the PropertyItem model
    PropertyItem propertyItemModel = new PropertyItem.Builder()
      .name("scope_id")
      .value("cg3335893hh1428692d6747cf300yeb5")
      .build();

    // Construct an instance of the MultiCloudScope model
    MultiCloudScope multiCloudScopeModel = new MultiCloudScope.Builder()
      .environment("ibm-cloud")
      .xProperties(java.util.Arrays.asList(propertyItemModel))
      .build();

    // Construct an instance of the FailedControls model
    FailedControls failedControlsModel = new FailedControls.Builder()
      .thresholdLimit(Long.valueOf("15"))
      .failedControlIds(java.util.Arrays.asList())
      .build();

    // Construct an instance of the AttachmentsNotificationsPrototype model
    AttachmentsNotificationsPrototype attachmentsNotificationsPrototypeModel = new AttachmentsNotificationsPrototype.Builder()
      .enabled(false)
      .controls(failedControlsModel)
      .build();

    // Construct an instance of the AttachmentParameterPrototype model
    AttachmentParameterPrototype attachmentParameterPrototypeModel = new AttachmentParameterPrototype.Builder()
      .assessmentType("Automated")
      .assessmentId("rule-a637949b-7e51-46c4-afd4-b96619001bf1")
      .parameterName("session_invalidation_in_seconds")
      .parameterValue("120")
      .parameterDisplayName("Sign out due to inactivity in seconds")
      .parameterType("numeric")
      .build();

    // Construct an instance of the AttachmentsPrototype model
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

    // Construct an instance of the CreateAttachmentOptions model
    CreateAttachmentOptions createAttachmentOptionsModel = new CreateAttachmentOptions.Builder()
      .profileId("testString")
      .attachments(java.util.Arrays.asList(attachmentsPrototypeModel))
      .profileId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();

    // Invoke createAttachment() with a valid options model and verify the result
    Response<AttachmentPrototype> response = securityAndComplianceCenterApiService.createAttachment(createAttachmentOptionsModel).execute();
    assertNotNull(response);
    AttachmentPrototype responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createAttachmentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createAttachment operation with and without retries enabled
  @Test
  public void testCreateAttachmentWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testCreateAttachmentWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testCreateAttachmentWOptions();
  }

  // Test the createAttachment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAttachmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.createAttachment(null).execute();
  }

  // Test the deleteProfileAttachment operation with a valid options model parameter
  @Test
  public void testDeleteProfileAttachmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"130003ea8bfa43c5aacea07a86da3000\", \"profile_id\": \"7ec45986-54fc-4b66-a303-d9577b078c65\", \"account_id\": \"130003ea8bfa43c5aacea07a86da3000\", \"instance_id\": \"edf9524f-406c-412c-acbb-ee371a5cabda\", \"scope\": [{\"environment\": \"environment\", \"properties\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"status\": \"enabled\", \"schedule\": \"daily\", \"notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 14, \"failed_control_ids\": [\"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\"]}}, \"attachment_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_value\": \"parameterValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"string\"}], \"last_scan\": {\"id\": \"e8a39d25-0051-4328-8462-988ad321f49a\", \"status\": \"in_progress\", \"time\": \"2019-01-01T12:00:00.000Z\"}, \"next_scan_time\": \"2019-01-01T12:00:00.000Z\", \"name\": \"account-130003ea8bfa43c5aacea07a86da3000\", \"description\": \"Test description\"}";
    String deleteProfileAttachmentPath = "/profiles/testString/attachments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteProfileAttachmentOptions model
    DeleteProfileAttachmentOptions deleteProfileAttachmentOptionsModel = new DeleteProfileAttachmentOptions.Builder()
      .attachmentId("testString")
      .profileId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();

    // Invoke deleteProfileAttachment() with a valid options model and verify the result
    Response<AttachmentItem> response = securityAndComplianceCenterApiService.deleteProfileAttachment(deleteProfileAttachmentOptionsModel).execute();
    assertNotNull(response);
    AttachmentItem responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteProfileAttachmentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
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

  // Test the getProfileAttachment operation with a valid options model parameter
  @Test
  public void testGetProfileAttachmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"130003ea8bfa43c5aacea07a86da3000\", \"profile_id\": \"7ec45986-54fc-4b66-a303-d9577b078c65\", \"account_id\": \"130003ea8bfa43c5aacea07a86da3000\", \"instance_id\": \"edf9524f-406c-412c-acbb-ee371a5cabda\", \"scope\": [{\"environment\": \"environment\", \"properties\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"status\": \"enabled\", \"schedule\": \"daily\", \"notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 14, \"failed_control_ids\": [\"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\"]}}, \"attachment_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_value\": \"parameterValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"string\"}], \"last_scan\": {\"id\": \"e8a39d25-0051-4328-8462-988ad321f49a\", \"status\": \"in_progress\", \"time\": \"2019-01-01T12:00:00.000Z\"}, \"next_scan_time\": \"2019-01-01T12:00:00.000Z\", \"name\": \"account-130003ea8bfa43c5aacea07a86da3000\", \"description\": \"Test description\"}";
    String getProfileAttachmentPath = "/profiles/testString/attachments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetProfileAttachmentOptions model
    GetProfileAttachmentOptions getProfileAttachmentOptionsModel = new GetProfileAttachmentOptions.Builder()
      .attachmentId("testString")
      .profileId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();

    // Invoke getProfileAttachment() with a valid options model and verify the result
    Response<AttachmentItem> response = securityAndComplianceCenterApiService.getProfileAttachment(getProfileAttachmentOptionsModel).execute();
    assertNotNull(response);
    AttachmentItem responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getProfileAttachmentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
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
    String mockResponseBody = "{\"id\": \"130003ea8bfa43c5aacea07a86da3000\", \"profile_id\": \"7ec45986-54fc-4b66-a303-d9577b078c65\", \"account_id\": \"130003ea8bfa43c5aacea07a86da3000\", \"instance_id\": \"edf9524f-406c-412c-acbb-ee371a5cabda\", \"scope\": [{\"environment\": \"environment\", \"properties\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"status\": \"enabled\", \"schedule\": \"daily\", \"notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 14, \"failed_control_ids\": [\"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\"]}}, \"attachment_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_value\": \"parameterValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"string\"}], \"last_scan\": {\"id\": \"e8a39d25-0051-4328-8462-988ad321f49a\", \"status\": \"in_progress\", \"time\": \"2019-01-01T12:00:00.000Z\"}, \"next_scan_time\": \"2019-01-01T12:00:00.000Z\", \"name\": \"account-130003ea8bfa43c5aacea07a86da3000\", \"description\": \"Test description\"}";
    String replaceProfileAttachmentPath = "/profiles/testString/attachments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PropertyItem model
    PropertyItem propertyItemModel = new PropertyItem.Builder()
      .name("scope_id")
      .value("cg3335893hh1428692d6747cf300yeb5")
      .build();

    // Construct an instance of the MultiCloudScope model
    MultiCloudScope multiCloudScopeModel = new MultiCloudScope.Builder()
      .environment("ibm-cloud")
      .xProperties(java.util.Arrays.asList(propertyItemModel))
      .build();

    // Construct an instance of the FailedControls model
    FailedControls failedControlsModel = new FailedControls.Builder()
      .thresholdLimit(Long.valueOf("15"))
      .failedControlIds(java.util.Arrays.asList())
      .build();

    // Construct an instance of the AttachmentsNotificationsPrototype model
    AttachmentsNotificationsPrototype attachmentsNotificationsPrototypeModel = new AttachmentsNotificationsPrototype.Builder()
      .enabled(false)
      .controls(failedControlsModel)
      .build();

    // Construct an instance of the AttachmentParameterPrototype model
    AttachmentParameterPrototype attachmentParameterPrototypeModel = new AttachmentParameterPrototype.Builder()
      .assessmentType("Automated")
      .assessmentId("rule-a637949b-7e51-46c4-afd4-b96619001bf1")
      .parameterName("session_invalidation_in_seconds")
      .parameterValue("120")
      .parameterDisplayName("Sign out due to inactivity in seconds")
      .parameterType("numeric")
      .build();

    // Construct an instance of the LastScan model
    LastScan lastScanModel = new LastScan.Builder()
      .id("e8a39d25-0051-4328-8462-988ad321f49a")
      .status("in_progress")
      .time(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .build();

    // Construct an instance of the ReplaceProfileAttachmentOptions model
    ReplaceProfileAttachmentOptions replaceProfileAttachmentOptionsModel = new ReplaceProfileAttachmentOptions.Builder()
      .attachmentId("testString")
      .profileId("testString")
      .id("testString")
      .profileId("testString")
      .accountId("testString")
      .instanceId("testString")
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

    // Invoke replaceProfileAttachment() with a valid options model and verify the result
    Response<AttachmentItem> response = securityAndComplianceCenterApiService.replaceProfileAttachment(replaceProfileAttachmentOptionsModel).execute();
    assertNotNull(response);
    AttachmentItem responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceProfileAttachmentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
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

  // Test the createScan operation with a valid options model parameter
  @Test
  public void testCreateScanWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"account_id\": \"accountId\", \"attachment_id\": \"attachmentId\", \"report_id\": \"reportId\", \"status\": \"completed\", \"last_scan_time\": \"lastScanTime\", \"next_scan_time\": \"nextScanTime\", \"scan_type\": \"ondemand\", \"occurence\": 9}";
    String createScanPath = "/scans";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateScanOptions model
    CreateScanOptions createScanOptionsModel = new CreateScanOptions.Builder()
      .attachmentId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();

    // Invoke createScan() with a valid options model and verify the result
    Response<Scan> response = securityAndComplianceCenterApiService.createScan(createScanOptionsModel).execute();
    assertNotNull(response);
    Scan responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createScanPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
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

  // Test the listAttachmentsAccount operation with a valid options model parameter
  @Test
  public void testListAttachmentsAccountWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_count\": 1, \"limit\": 20, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"attachments\": [{\"id\": \"130003ea8bfa43c5aacea07a86da3000\", \"profile_id\": \"7ec45986-54fc-4b66-a303-d9577b078c65\", \"account_id\": \"130003ea8bfa43c5aacea07a86da3000\", \"instance_id\": \"edf9524f-406c-412c-acbb-ee371a5cabda\", \"scope\": [{\"environment\": \"environment\", \"properties\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"created_on\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_on\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\", \"status\": \"enabled\", \"schedule\": \"daily\", \"notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 14, \"failed_control_ids\": [\"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\"]}}, \"attachment_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_value\": \"parameterValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"string\"}], \"last_scan\": {\"id\": \"e8a39d25-0051-4328-8462-988ad321f49a\", \"status\": \"in_progress\", \"time\": \"2019-01-01T12:00:00.000Z\"}, \"next_scan_time\": \"2019-01-01T12:00:00.000Z\", \"name\": \"account-130003ea8bfa43c5aacea07a86da3000\", \"description\": \"Test description\"}]}";
    String listAttachmentsAccountPath = "/attachments";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListAttachmentsAccountOptions model
    ListAttachmentsAccountOptions listAttachmentsAccountOptionsModel = new ListAttachmentsAccountOptions.Builder()
      .xCorrelationId("testString")
      .xRequestId("testString")
      .limit(Long.valueOf("10"))
      .start("testString")
      .build();

    // Invoke listAttachmentsAccount() with a valid options model and verify the result
    Response<AttachmentCollection> response = securityAndComplianceCenterApiService.listAttachmentsAccount(listAttachmentsAccountOptionsModel).execute();
    assertNotNull(response);
    AttachmentCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAttachmentsAccountPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
  }

  // Test the listAttachmentsAccount operation with and without retries enabled
  @Test
  public void testListAttachmentsAccountWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testListAttachmentsAccountWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testListAttachmentsAccountWOptions();
  }

  // Test the listAttachmentsAccount operation using the AttachmentsAccountPager.getNext() method
  @Test
  public void testListAttachmentsAccountWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"attachments\":[{\"id\":\"130003ea8bfa43c5aacea07a86da3000\",\"profile_id\":\"7ec45986-54fc-4b66-a303-d9577b078c65\",\"account_id\":\"130003ea8bfa43c5aacea07a86da3000\",\"instance_id\":\"edf9524f-406c-412c-acbb-ee371a5cabda\",\"scope\":[{\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"value\"}]}],\"created_on\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"status\":\"enabled\",\"schedule\":\"daily\",\"notifications\":{\"enabled\":false,\"controls\":{\"threshold_limit\":14,\"failed_control_ids\":[\"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\"]}},\"attachment_parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"parameterName\",\"parameter_value\":\"parameterValue\",\"parameter_display_name\":\"parameterDisplayName\",\"parameter_type\":\"string\"}],\"last_scan\":{\"id\":\"e8a39d25-0051-4328-8462-988ad321f49a\",\"status\":\"in_progress\",\"time\":\"2019-01-01T12:00:00.000Z\"},\"next_scan_time\":\"2019-01-01T12:00:00.000Z\",\"name\":\"account-130003ea8bfa43c5aacea07a86da3000\",\"description\":\"Test description\"}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"attachments\":[{\"id\":\"130003ea8bfa43c5aacea07a86da3000\",\"profile_id\":\"7ec45986-54fc-4b66-a303-d9577b078c65\",\"account_id\":\"130003ea8bfa43c5aacea07a86da3000\",\"instance_id\":\"edf9524f-406c-412c-acbb-ee371a5cabda\",\"scope\":[{\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"value\"}]}],\"created_on\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"status\":\"enabled\",\"schedule\":\"daily\",\"notifications\":{\"enabled\":false,\"controls\":{\"threshold_limit\":14,\"failed_control_ids\":[\"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\"]}},\"attachment_parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"parameterName\",\"parameter_value\":\"parameterValue\",\"parameter_display_name\":\"parameterDisplayName\",\"parameter_type\":\"string\"}],\"last_scan\":{\"id\":\"e8a39d25-0051-4328-8462-988ad321f49a\",\"status\":\"in_progress\",\"time\":\"2019-01-01T12:00:00.000Z\"},\"next_scan_time\":\"2019-01-01T12:00:00.000Z\",\"name\":\"account-130003ea8bfa43c5aacea07a86da3000\",\"description\":\"Test description\"}],\"total_count\":2,\"limit\":1}";
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

    ListAttachmentsAccountOptions listAttachmentsAccountOptions = new ListAttachmentsAccountOptions.Builder()
      .xCorrelationId("testString")
      .xRequestId("testString")
      .limit(Long.valueOf("10"))
      .build();

    List<AttachmentItem> allResults = new ArrayList<>();
    AttachmentsAccountPager pager = new AttachmentsAccountPager(securityAndComplianceCenterApiService, listAttachmentsAccountOptions);
    while (pager.hasNext()) {
      List<AttachmentItem> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listAttachmentsAccount operation using the AttachmentsAccountPager.getAll() method
  @Test
  public void testListAttachmentsAccountWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"attachments\":[{\"id\":\"130003ea8bfa43c5aacea07a86da3000\",\"profile_id\":\"7ec45986-54fc-4b66-a303-d9577b078c65\",\"account_id\":\"130003ea8bfa43c5aacea07a86da3000\",\"instance_id\":\"edf9524f-406c-412c-acbb-ee371a5cabda\",\"scope\":[{\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"value\"}]}],\"created_on\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"status\":\"enabled\",\"schedule\":\"daily\",\"notifications\":{\"enabled\":false,\"controls\":{\"threshold_limit\":14,\"failed_control_ids\":[\"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\"]}},\"attachment_parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"parameterName\",\"parameter_value\":\"parameterValue\",\"parameter_display_name\":\"parameterDisplayName\",\"parameter_type\":\"string\"}],\"last_scan\":{\"id\":\"e8a39d25-0051-4328-8462-988ad321f49a\",\"status\":\"in_progress\",\"time\":\"2019-01-01T12:00:00.000Z\"},\"next_scan_time\":\"2019-01-01T12:00:00.000Z\",\"name\":\"account-130003ea8bfa43c5aacea07a86da3000\",\"description\":\"Test description\"}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"attachments\":[{\"id\":\"130003ea8bfa43c5aacea07a86da3000\",\"profile_id\":\"7ec45986-54fc-4b66-a303-d9577b078c65\",\"account_id\":\"130003ea8bfa43c5aacea07a86da3000\",\"instance_id\":\"edf9524f-406c-412c-acbb-ee371a5cabda\",\"scope\":[{\"environment\":\"environment\",\"properties\":[{\"name\":\"name\",\"value\":\"value\"}]}],\"created_on\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_on\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\",\"status\":\"enabled\",\"schedule\":\"daily\",\"notifications\":{\"enabled\":false,\"controls\":{\"threshold_limit\":14,\"failed_control_ids\":[\"5C453578-E9A1-421E-AD0F-C6AFCDD67CCF\"]}},\"attachment_parameters\":[{\"assessment_type\":\"assessmentType\",\"assessment_id\":\"assessmentId\",\"parameter_name\":\"parameterName\",\"parameter_value\":\"parameterValue\",\"parameter_display_name\":\"parameterDisplayName\",\"parameter_type\":\"string\"}],\"last_scan\":{\"id\":\"e8a39d25-0051-4328-8462-988ad321f49a\",\"status\":\"in_progress\",\"time\":\"2019-01-01T12:00:00.000Z\"},\"next_scan_time\":\"2019-01-01T12:00:00.000Z\",\"name\":\"account-130003ea8bfa43c5aacea07a86da3000\",\"description\":\"Test description\"}],\"total_count\":2,\"limit\":1}";
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

    ListAttachmentsAccountOptions listAttachmentsAccountOptions = new ListAttachmentsAccountOptions.Builder()
      .xCorrelationId("testString")
      .xRequestId("testString")
      .limit(Long.valueOf("10"))
      .build();

    AttachmentsAccountPager pager = new AttachmentsAccountPager(securityAndComplianceCenterApiService, listAttachmentsAccountOptions);
    List<AttachmentItem> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getLatestReports operation with a valid options model parameter
  @Test
  public void testGetLatestReportsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"home_account_id\": \"homeAccountId\", \"controls_summary\": {\"status\": \"compliant\", \"total_count\": 150, \"compliant_count\": 130, \"not_compliant_count\": 5, \"unable_to_perform_count\": 5, \"user_evaluation_required_count\": 10}, \"evaluations_summary\": {\"status\": \"compliant\", \"total_count\": 140, \"pass_count\": 123, \"failure_count\": 12, \"error_count\": 5, \"completed_count\": 135}, \"score\": {\"passed\": 1, \"total_count\": 4, \"percent\": 25}, \"reports\": [{\"id\": \"44a5-a292-32114fa73558\", \"group_id\": \"55b6-b3A4-432250b84669\", \"created_on\": \"2022-08-15T12:30:01Z\", \"scan_time\": \"2022-08-15T12:30:01Z\", \"type\": \"scheduled\", \"cos_object\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/531fc3e28bfc43c5a2cea07786d93f5c:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:b1a8f3da-49d2-4966-ae83-a8d02bc2aac7\", \"instance_id\": \"84644a08-31b6-4988-b504-49a46ca69ccd\", \"account\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"NIST\", \"type\": \"account_type\"}, \"profile\": {\"id\": \"44a5-a292-32114fa73558\", \"name\": \"IBM FS Cloud\", \"version\": \"0.1\"}, \"attachment\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"resource group - Default\", \"description\": \"Scoped to the Default resource group\", \"schedule\": \"daily\", \"scope\": [{\"id\": \"ca0941aa-b7e2-43a3-9794-1b3d322474d9\", \"environment\": \"ibm-cloud\", \"properties\": [{\"name\": \"scope_id\", \"value\": \"18d32a4430e54c81a6668952609763b2\"}]}]}}]}";
    String getLatestReportsPath = "/reports/latest";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetLatestReportsOptions model
    GetLatestReportsOptions getLatestReportsOptionsModel = new GetLatestReportsOptions.Builder()
      .xCorrelationId("testString")
      .xRequestId("testString")
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

  // Test the listReports operation with a valid options model parameter
  @Test
  public void testListReportsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_count\": 230, \"limit\": 50, \"start\": \"start\", \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\"}, \"home_account_id\": \"homeAccountId\", \"reports\": [{\"id\": \"44a5-a292-32114fa73558\", \"group_id\": \"55b6-b3A4-432250b84669\", \"created_on\": \"2022-08-15T12:30:01Z\", \"scan_time\": \"2022-08-15T12:30:01Z\", \"type\": \"scheduled\", \"cos_object\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/531fc3e28bfc43c5a2cea07786d93f5c:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:b1a8f3da-49d2-4966-ae83-a8d02bc2aac7\", \"instance_id\": \"84644a08-31b6-4988-b504-49a46ca69ccd\", \"account\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"NIST\", \"type\": \"account_type\"}, \"profile\": {\"id\": \"44a5-a292-32114fa73558\", \"name\": \"IBM FS Cloud\", \"version\": \"0.1\"}, \"attachment\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"resource group - Default\", \"description\": \"Scoped to the Default resource group\", \"schedule\": \"daily\", \"scope\": [{\"id\": \"ca0941aa-b7e2-43a3-9794-1b3d322474d9\", \"environment\": \"ibm-cloud\", \"properties\": [{\"name\": \"scope_id\", \"value\": \"18d32a4430e54c81a6668952609763b2\"}]}]}}]}";
    String listReportsPath = "/reports";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListReportsOptions model
    ListReportsOptions listReportsOptionsModel = new ListReportsOptions.Builder()
      .xCorrelationId("testString")
      .xRequestId("testString")
      .attachmentId("testString")
      .groupId("testString")
      .profileId("testString")
      .type("scheduled")
      .start("testString")
      .limit(Long.valueOf("10"))
      .sort("profile_name")
      .build();

    // Invoke listReports() with a valid options model and verify the result
    Response<ReportPage> response = securityAndComplianceCenterApiService.listReports(listReportsOptionsModel).execute();
    assertNotNull(response);
    ReportPage responseObj = response.getResult();
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
    assertEquals(query.get("attachment_id"), "testString");
    assertEquals(query.get("group_id"), "testString");
    assertEquals(query.get("profile_id"), "testString");
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

  // Test the listReports operation using the ReportsPager.getNext() method
  @Test
  public void testListReportsWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?start=1\"},\"reports\":[{\"id\":\"44a5-a292-32114fa73558\",\"group_id\":\"55b6-b3A4-432250b84669\",\"created_on\":\"2022-08-15T12:30:01Z\",\"scan_time\":\"2022-08-15T12:30:01Z\",\"type\":\"scheduled\",\"cos_object\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/531fc3e28bfc43c5a2cea07786d93f5c:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:b1a8f3da-49d2-4966-ae83-a8d02bc2aac7\",\"instance_id\":\"84644a08-31b6-4988-b504-49a46ca69ccd\",\"account\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"NIST\",\"type\":\"account_type\"},\"profile\":{\"id\":\"44a5-a292-32114fa73558\",\"name\":\"IBM FS Cloud\",\"version\":\"0.1\"},\"attachment\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"resource group - Default\",\"description\":\"Scoped to the Default resource group\",\"schedule\":\"daily\",\"scope\":[{\"id\":\"ca0941aa-b7e2-43a3-9794-1b3d322474d9\",\"environment\":\"ibm-cloud\",\"properties\":[{\"name\":\"scope_id\",\"value\":\"18d32a4430e54c81a6668952609763b2\"}]}]}}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"reports\":[{\"id\":\"44a5-a292-32114fa73558\",\"group_id\":\"55b6-b3A4-432250b84669\",\"created_on\":\"2022-08-15T12:30:01Z\",\"scan_time\":\"2022-08-15T12:30:01Z\",\"type\":\"scheduled\",\"cos_object\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/531fc3e28bfc43c5a2cea07786d93f5c:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:b1a8f3da-49d2-4966-ae83-a8d02bc2aac7\",\"instance_id\":\"84644a08-31b6-4988-b504-49a46ca69ccd\",\"account\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"NIST\",\"type\":\"account_type\"},\"profile\":{\"id\":\"44a5-a292-32114fa73558\",\"name\":\"IBM FS Cloud\",\"version\":\"0.1\"},\"attachment\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"resource group - Default\",\"description\":\"Scoped to the Default resource group\",\"schedule\":\"daily\",\"scope\":[{\"id\":\"ca0941aa-b7e2-43a3-9794-1b3d322474d9\",\"environment\":\"ibm-cloud\",\"properties\":[{\"name\":\"scope_id\",\"value\":\"18d32a4430e54c81a6668952609763b2\"}]}]}}],\"total_count\":2,\"limit\":1}";
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
      .xCorrelationId("testString")
      .xRequestId("testString")
      .attachmentId("testString")
      .groupId("testString")
      .profileId("testString")
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
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?start=1\"},\"reports\":[{\"id\":\"44a5-a292-32114fa73558\",\"group_id\":\"55b6-b3A4-432250b84669\",\"created_on\":\"2022-08-15T12:30:01Z\",\"scan_time\":\"2022-08-15T12:30:01Z\",\"type\":\"scheduled\",\"cos_object\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/531fc3e28bfc43c5a2cea07786d93f5c:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:b1a8f3da-49d2-4966-ae83-a8d02bc2aac7\",\"instance_id\":\"84644a08-31b6-4988-b504-49a46ca69ccd\",\"account\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"NIST\",\"type\":\"account_type\"},\"profile\":{\"id\":\"44a5-a292-32114fa73558\",\"name\":\"IBM FS Cloud\",\"version\":\"0.1\"},\"attachment\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"resource group - Default\",\"description\":\"Scoped to the Default resource group\",\"schedule\":\"daily\",\"scope\":[{\"id\":\"ca0941aa-b7e2-43a3-9794-1b3d322474d9\",\"environment\":\"ibm-cloud\",\"properties\":[{\"name\":\"scope_id\",\"value\":\"18d32a4430e54c81a6668952609763b2\"}]}]}}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"reports\":[{\"id\":\"44a5-a292-32114fa73558\",\"group_id\":\"55b6-b3A4-432250b84669\",\"created_on\":\"2022-08-15T12:30:01Z\",\"scan_time\":\"2022-08-15T12:30:01Z\",\"type\":\"scheduled\",\"cos_object\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/531fc3e28bfc43c5a2cea07786d93f5c:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:b1a8f3da-49d2-4966-ae83-a8d02bc2aac7\",\"instance_id\":\"84644a08-31b6-4988-b504-49a46ca69ccd\",\"account\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"NIST\",\"type\":\"account_type\"},\"profile\":{\"id\":\"44a5-a292-32114fa73558\",\"name\":\"IBM FS Cloud\",\"version\":\"0.1\"},\"attachment\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"resource group - Default\",\"description\":\"Scoped to the Default resource group\",\"schedule\":\"daily\",\"scope\":[{\"id\":\"ca0941aa-b7e2-43a3-9794-1b3d322474d9\",\"environment\":\"ibm-cloud\",\"properties\":[{\"name\":\"scope_id\",\"value\":\"18d32a4430e54c81a6668952609763b2\"}]}]}}],\"total_count\":2,\"limit\":1}";
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
      .xCorrelationId("testString")
      .xRequestId("testString")
      .attachmentId("testString")
      .groupId("testString")
      .profileId("testString")
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
    String mockResponseBody = "{\"id\": \"44a5-a292-32114fa73558\", \"group_id\": \"55b6-b3A4-432250b84669\", \"created_on\": \"2022-08-15T12:30:01Z\", \"scan_time\": \"2022-08-15T12:30:01Z\", \"type\": \"scheduled\", \"cos_object\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/531fc3e28bfc43c5a2cea07786d93f5c:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:b1a8f3da-49d2-4966-ae83-a8d02bc2aac7\", \"instance_id\": \"84644a08-31b6-4988-b504-49a46ca69ccd\", \"account\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"NIST\", \"type\": \"account_type\"}, \"profile\": {\"id\": \"44a5-a292-32114fa73558\", \"name\": \"IBM FS Cloud\", \"version\": \"0.1\"}, \"attachment\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"resource group - Default\", \"description\": \"Scoped to the Default resource group\", \"schedule\": \"daily\", \"scope\": [{\"id\": \"ca0941aa-b7e2-43a3-9794-1b3d322474d9\", \"environment\": \"ibm-cloud\", \"properties\": [{\"name\": \"scope_id\", \"value\": \"18d32a4430e54c81a6668952609763b2\"}]}]}}";
    String getReportPath = "/reports/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetReportOptions model
    GetReportOptions getReportOptionsModel = new GetReportOptions.Builder()
      .reportId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
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
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
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
    String mockResponseBody = "{\"report_id\": \"30b434b3-cb08-4845-af10-7a8fc682b6a8\", \"isntance_id\": \"84644a08-31b6-4988-b504-49a46ca69ccd\", \"account\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"NIST\", \"type\": \"account_type\"}, \"score\": {\"passed\": 1, \"total_count\": 4, \"percent\": 25}, \"controls\": {\"status\": \"compliant\", \"total_count\": 150, \"compliant_count\": 130, \"not_compliant_count\": 5, \"unable_to_perform_count\": 5, \"user_evaluation_required_count\": 10}, \"evaluations\": {\"status\": \"compliant\", \"total_count\": 140, \"pass_count\": 123, \"failure_count\": 12, \"error_count\": 5, \"completed_count\": 135}, \"resources\": {\"status\": \"compliant\", \"total_count\": 150, \"compliant_count\": 130, \"not_compliant_count\": 5, \"unable_to_perform_count\": 5, \"user_evaluation_required_count\": 10, \"top_failed\": [{\"name\": \"my-bucket\", \"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"service\": \"cloud-object-storage\", \"tags\": {\"user\": [\"user\"], \"access\": [\"access\"], \"service\": [\"service\"]}, \"account\": \"59bcbfa6ea2f006b4ed7094c1a08dcdd\", \"status\": \"compliant\", \"total_count\": 140, \"pass_count\": 123, \"failure_count\": 12, \"error_count\": 5, \"completed_count\": 135}]}}";
    String getReportSummaryPath = "/reports/testString/summary";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetReportSummaryOptions model
    GetReportSummaryOptions getReportSummaryOptionsModel = new GetReportSummaryOptions.Builder()
      .reportId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
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

  // Test the getReportEvaluation operation with a valid options model parameter
  @Test
  public void testGetReportEvaluationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "This is a mock binary response.";
    String getReportEvaluationPath = "/reports/testString/download";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/csv")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetReportEvaluationOptions model
    GetReportEvaluationOptions getReportEvaluationOptionsModel = new GetReportEvaluationOptions.Builder()
      .reportId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .excludeSummary(true)
      .build();

    // Invoke getReportEvaluation() with a valid options model and verify the result
    Response<InputStream> response = securityAndComplianceCenterApiService.getReportEvaluation(getReportEvaluationOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);
    responseObj.close();

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getReportEvaluationPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("exclude_summary")), Boolean.valueOf(true));
  }

  // Test the getReportEvaluation operation with and without retries enabled
  @Test
  public void testGetReportEvaluationWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetReportEvaluationWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetReportEvaluationWOptions();
  }

  // Test the getReportEvaluation operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReportEvaluationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    securityAndComplianceCenterApiService.getReportEvaluation(null).execute();
  }

  // Test the getReportControls operation with a valid options model parameter
  @Test
  public void testGetReportControlsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"status\": \"compliant\", \"total_count\": 150, \"compliant_count\": 130, \"not_compliant_count\": 5, \"unable_to_perform_count\": 5, \"user_evaluation_required_count\": 10, \"home_account_id\": \"homeAccountId\", \"report_id\": \"reportId\", \"controls\": [{\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"control_library_id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"control_library_version\": \"v1.2.3\", \"control_name\": \"Password Management\", \"control_description\": \"Password Management\", \"control_category\": \"Access Control\", \"control_path\": \"AC-2(a)\", \"control_specifications\": [{\"control_specification_id\": \"18d32a4430e54c81a6668952609763b2\", \"component_id\": \"cloud-object_storage\", \"control_specification_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"environment\": \"ibm cloud\", \"responsibility\": \"user\", \"assessments\": [{\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}], \"status\": \"compliant\", \"total_count\": 150, \"compliant_count\": 130, \"not_compliant_count\": 5, \"unable_to_perform_count\": 5, \"user_evaluation_required_count\": 10}], \"status\": \"compliant\", \"total_count\": 150, \"compliant_count\": 130, \"not_compliant_count\": 5, \"unable_to_perform_count\": 5, \"user_evaluation_required_count\": 10}]}";
    String getReportControlsPath = "/reports/testString/controls";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetReportControlsOptions model
    GetReportControlsOptions getReportControlsOptionsModel = new GetReportControlsOptions.Builder()
      .reportId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .controlId("testString")
      .controlName("testString")
      .controlDescription("testString")
      .controlCategory("testString")
      .status("compliant")
      .sort("control_name")
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
    String mockResponseBody = "{\"id\": \"rule-7b0560a4-df94-4629-bb76-680f3155ddda\", \"type\": \"user_defined/system_defined\", \"description\": \"rule\", \"version\": \"1.2.3\", \"account_id\": \"59bcbfa6ea2f006b4ed7094c1a08dcdd\", \"created_on\": \"2022-08-15T12:30:01Z\", \"created_by\": \"IBMid-12345\", \"updated_on\": \"2022-08-15T12:30:01Z\", \"updated_by\": \"IBMid-12345\", \"labels\": [\"labels\"]}";
    String getReportRulePath = "/reports/testString/rules/rule-8d444f8c-fd1d-48de-bcaa-f43732568761";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetReportRuleOptions model
    GetReportRuleOptions getReportRuleOptionsModel = new GetReportRuleOptions.Builder()
      .reportId("testString")
      .ruleId("rule-8d444f8c-fd1d-48de-bcaa-f43732568761")
      .xCorrelationId("testString")
      .xRequestId("testString")
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
    String mockResponseBody = "{\"total_count\": 230, \"limit\": 50, \"start\": \"start\", \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\"}, \"home_account_id\": \"homeAccountId\", \"report_id\": \"reportId\", \"evaluations\": [{\"home_account_id\": \"be200c80cabc456e91139e4152327456\", \"report_id\": \"44a5-a292-32114fa73558\", \"control_id\": \"28016c95-b389-447f-8a05-eabe1ad7fd24\", \"component_id\": \"cloud-object_storage\", \"assessment\": {\"assessment_id\": \"382c2b06-e6b2-43ee-b189-c1c7743b67ee\", \"assessment_type\": \"ibm-cloud-rule\", \"assessment_method\": \"ibm-cloud-rule\", \"assessment_description\": \"Check whether Cloud Object Storage is accessible only by using private endpoints\", \"parameter_count\": 1, \"parameters\": [{\"parameter_name\": \"location\", \"parameter_display_name\": \"Location\", \"parameter_type\": \"string\", \"parameter_value\": \"anyValue\"}]}, \"evaluate_time\": \"2022-06-30T11:03:44.630150782Z\", \"target\": {\"id\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\", \"account_id\": \"59bcbfa6ea2f006b4ed7094c1a08dcdd\", \"resource_crn\": \"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\", \"resource_name\": \"mybucket\", \"service_name\": \"cloud-object-storage\"}, \"status\": \"failure\", \"reason\": \"One or more conditions in rule rule-7b0560a4-df94-4629-bb76-680f3155ddda were not met\", \"details\": {\"properties\": [{\"property\": \"allowed_network\", \"property_description\": \"A description for this property\", \"operator\": \"string_equals\", \"expected_value\": \"anyValue\", \"found_value\": \"anyValue\"}]}}]}";
    String listReportEvaluationsPath = "/reports/testString/evaluations";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListReportEvaluationsOptions model
    ListReportEvaluationsOptions listReportEvaluationsOptionsModel = new ListReportEvaluationsOptions.Builder()
      .reportId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .assessmentId("testString")
      .assessmentMethod("testString")
      .componentId("testString")
      .targetId("testString")
      .targetEnv("testString")
      .targetName("testString")
      .status("failure")
      .start("testString")
      .limit(Long.valueOf("10"))
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
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?start=1\"},\"evaluations\":[{\"home_account_id\":\"be200c80cabc456e91139e4152327456\",\"report_id\":\"44a5-a292-32114fa73558\",\"control_id\":\"28016c95-b389-447f-8a05-eabe1ad7fd24\",\"component_id\":\"cloud-object_storage\",\"assessment\":{\"assessment_id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"assessment_type\":\"ibm-cloud-rule\",\"assessment_method\":\"ibm-cloud-rule\",\"assessment_description\":\"Check whether Cloud Object Storage is accessible only by using private endpoints\",\"parameter_count\":1,\"parameters\":[{\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}]},\"evaluate_time\":\"2022-06-30T11:03:44.630150782Z\",\"target\":{\"id\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\",\"account_id\":\"59bcbfa6ea2f006b4ed7094c1a08dcdd\",\"resource_crn\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\",\"resource_name\":\"mybucket\",\"service_name\":\"cloud-object-storage\"},\"status\":\"failure\",\"reason\":\"One or more conditions in rule rule-7b0560a4-df94-4629-bb76-680f3155ddda were not met\",\"details\":{\"properties\":[{\"property\":\"allowed_network\",\"property_description\":\"A description for this property\",\"operator\":\"string_equals\",\"expected_value\":\"anyValue\",\"found_value\":\"anyValue\"}]}}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"evaluations\":[{\"home_account_id\":\"be200c80cabc456e91139e4152327456\",\"report_id\":\"44a5-a292-32114fa73558\",\"control_id\":\"28016c95-b389-447f-8a05-eabe1ad7fd24\",\"component_id\":\"cloud-object_storage\",\"assessment\":{\"assessment_id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"assessment_type\":\"ibm-cloud-rule\",\"assessment_method\":\"ibm-cloud-rule\",\"assessment_description\":\"Check whether Cloud Object Storage is accessible only by using private endpoints\",\"parameter_count\":1,\"parameters\":[{\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}]},\"evaluate_time\":\"2022-06-30T11:03:44.630150782Z\",\"target\":{\"id\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\",\"account_id\":\"59bcbfa6ea2f006b4ed7094c1a08dcdd\",\"resource_crn\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\",\"resource_name\":\"mybucket\",\"service_name\":\"cloud-object-storage\"},\"status\":\"failure\",\"reason\":\"One or more conditions in rule rule-7b0560a4-df94-4629-bb76-680f3155ddda were not met\",\"details\":{\"properties\":[{\"property\":\"allowed_network\",\"property_description\":\"A description for this property\",\"operator\":\"string_equals\",\"expected_value\":\"anyValue\",\"found_value\":\"anyValue\"}]}}],\"total_count\":2,\"limit\":1}";
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
      .reportId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .assessmentId("testString")
      .assessmentMethod("testString")
      .componentId("testString")
      .targetId("testString")
      .targetEnv("testString")
      .targetName("testString")
      .status("failure")
      .limit(Long.valueOf("10"))
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
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?start=1\"},\"evaluations\":[{\"home_account_id\":\"be200c80cabc456e91139e4152327456\",\"report_id\":\"44a5-a292-32114fa73558\",\"control_id\":\"28016c95-b389-447f-8a05-eabe1ad7fd24\",\"component_id\":\"cloud-object_storage\",\"assessment\":{\"assessment_id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"assessment_type\":\"ibm-cloud-rule\",\"assessment_method\":\"ibm-cloud-rule\",\"assessment_description\":\"Check whether Cloud Object Storage is accessible only by using private endpoints\",\"parameter_count\":1,\"parameters\":[{\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}]},\"evaluate_time\":\"2022-06-30T11:03:44.630150782Z\",\"target\":{\"id\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\",\"account_id\":\"59bcbfa6ea2f006b4ed7094c1a08dcdd\",\"resource_crn\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\",\"resource_name\":\"mybucket\",\"service_name\":\"cloud-object-storage\"},\"status\":\"failure\",\"reason\":\"One or more conditions in rule rule-7b0560a4-df94-4629-bb76-680f3155ddda were not met\",\"details\":{\"properties\":[{\"property\":\"allowed_network\",\"property_description\":\"A description for this property\",\"operator\":\"string_equals\",\"expected_value\":\"anyValue\",\"found_value\":\"anyValue\"}]}}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"evaluations\":[{\"home_account_id\":\"be200c80cabc456e91139e4152327456\",\"report_id\":\"44a5-a292-32114fa73558\",\"control_id\":\"28016c95-b389-447f-8a05-eabe1ad7fd24\",\"component_id\":\"cloud-object_storage\",\"assessment\":{\"assessment_id\":\"382c2b06-e6b2-43ee-b189-c1c7743b67ee\",\"assessment_type\":\"ibm-cloud-rule\",\"assessment_method\":\"ibm-cloud-rule\",\"assessment_description\":\"Check whether Cloud Object Storage is accessible only by using private endpoints\",\"parameter_count\":1,\"parameters\":[{\"parameter_name\":\"location\",\"parameter_display_name\":\"Location\",\"parameter_type\":\"string\",\"parameter_value\":\"anyValue\"}]},\"evaluate_time\":\"2022-06-30T11:03:44.630150782Z\",\"target\":{\"id\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\",\"account_id\":\"59bcbfa6ea2f006b4ed7094c1a08dcdd\",\"resource_crn\":\"crn:v1:bluemix:public:cloud-object-storage:global:a/59bcbfa6ea2f006b4ed7094c1a08dcdd:1a0ec336-f391-4091-a6fb-5e084a4c56f4:bucket:mybucket\",\"resource_name\":\"mybucket\",\"service_name\":\"cloud-object-storage\"},\"status\":\"failure\",\"reason\":\"One or more conditions in rule rule-7b0560a4-df94-4629-bb76-680f3155ddda were not met\",\"details\":{\"properties\":[{\"property\":\"allowed_network\",\"property_description\":\"A description for this property\",\"operator\":\"string_equals\",\"expected_value\":\"anyValue\",\"found_value\":\"anyValue\"}]}}],\"total_count\":2,\"limit\":1}";
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
      .reportId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .assessmentId("testString")
      .assessmentMethod("testString")
      .componentId("testString")
      .targetId("testString")
      .targetEnv("testString")
      .targetName("testString")
      .status("failure")
      .limit(Long.valueOf("10"))
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
    String mockResponseBody = "{\"total_count\": 230, \"limit\": 50, \"start\": \"start\", \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\"}, \"home_account_id\": \"homeAccountId\", \"report_id\": \"reportId\", \"resources\": [{\"report_id\": \"30b434b3-cb08-4845-af10-7a8fc682b6a8\", \"id\": \"crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::\", \"resource_name\": \"jeff's key\", \"component_id\": \"cloud-object_storage\", \"environment\": \"ibm cloud\", \"account\": {\"id\": \"531fc3e28bfc43c5a2cea07786d93f5c\", \"name\": \"NIST\", \"type\": \"account_type\"}, \"status\": \"compliant\", \"total_count\": 140, \"pass_count\": 123, \"failure_count\": 12, \"error_count\": 5, \"completed_count\": 135}]}";
    String listReportResourcesPath = "/reports/testString/resources";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListReportResourcesOptions model
    ListReportResourcesOptions listReportResourcesOptionsModel = new ListReportResourcesOptions.Builder()
      .reportId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .id("testString")
      .resourceName("testString")
      .accountId("testString")
      .componentId("testString")
      .status("compliant")
      .sort("account_id")
      .start("testString")
      .limit(Long.valueOf("10"))
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
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?start=1\"},\"total_count\":2,\"limit\":1,\"resources\":[{\"report_id\":\"30b434b3-cb08-4845-af10-7a8fc682b6a8\",\"id\":\"crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::\",\"resource_name\":\"jeff's key\",\"component_id\":\"cloud-object_storage\",\"environment\":\"ibm cloud\",\"account\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"NIST\",\"type\":\"account_type\"},\"status\":\"compliant\",\"total_count\":140,\"pass_count\":123,\"failure_count\":12,\"error_count\":5,\"completed_count\":135}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"report_id\":\"30b434b3-cb08-4845-af10-7a8fc682b6a8\",\"id\":\"crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::\",\"resource_name\":\"jeff's key\",\"component_id\":\"cloud-object_storage\",\"environment\":\"ibm cloud\",\"account\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"NIST\",\"type\":\"account_type\"},\"status\":\"compliant\",\"total_count\":140,\"pass_count\":123,\"failure_count\":12,\"error_count\":5,\"completed_count\":135}]}";
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
      .reportId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .id("testString")
      .resourceName("testString")
      .accountId("testString")
      .componentId("testString")
      .status("compliant")
      .sort("account_id")
      .limit(Long.valueOf("10"))
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
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?start=1\"},\"total_count\":2,\"limit\":1,\"resources\":[{\"report_id\":\"30b434b3-cb08-4845-af10-7a8fc682b6a8\",\"id\":\"crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::\",\"resource_name\":\"jeff's key\",\"component_id\":\"cloud-object_storage\",\"environment\":\"ibm cloud\",\"account\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"NIST\",\"type\":\"account_type\"},\"status\":\"compliant\",\"total_count\":140,\"pass_count\":123,\"failure_count\":12,\"error_count\":5,\"completed_count\":135}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"report_id\":\"30b434b3-cb08-4845-af10-7a8fc682b6a8\",\"id\":\"crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::\",\"resource_name\":\"jeff's key\",\"component_id\":\"cloud-object_storage\",\"environment\":\"ibm cloud\",\"account\":{\"id\":\"531fc3e28bfc43c5a2cea07786d93f5c\",\"name\":\"NIST\",\"type\":\"account_type\"},\"status\":\"compliant\",\"total_count\":140,\"pass_count\":123,\"failure_count\":12,\"error_count\":5,\"completed_count\":135}]}";
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
      .reportId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .id("testString")
      .resourceName("testString")
      .accountId("testString")
      .componentId("testString")
      .status("compliant")
      .sort("account_id")
      .limit(Long.valueOf("10"))
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
    String getReportTagsPath = "/reports/testString/tags";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetReportTagsOptions model
    GetReportTagsOptions getReportTagsOptionsModel = new GetReportTagsOptions.Builder()
      .reportId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
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
    String mockResponseBody = "{\"home_account_id\": \"homeAccountId\", \"report_id\": \"reportId\", \"data_points\": [{\"report_id\": \"30b434b3-cb08-4845-af10-7a8fc682b6a8\", \"report_group_id\": \"55b6-b3A4-432250b84669\", \"scan_time\": \"2022-08-15T12:30:01Z\", \"controls\": {\"status\": \"compliant\", \"total_count\": 150, \"compliant_count\": 130, \"not_compliant_count\": 5, \"unable_to_perform_count\": 5, \"user_evaluation_required_count\": 10}}]}";
    String getReportViolationsDriftPath = "/reports/testString/violations_drift";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetReportViolationsDriftOptions model
    GetReportViolationsDriftOptions getReportViolationsDriftOptionsModel = new GetReportViolationsDriftOptions.Builder()
      .reportId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .scanTimeDuration(Long.valueOf("0"))
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

  // Test the listProviderTypeInstances operation with a valid options model parameter
  @Test
  public void testListProviderTypeInstancesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"provider_type_instances\": [{\"id\": \"7588190cce3c05ac8f7942ea597dafce\", \"type\": \"workload-protection\", \"name\": \"workload-protection-instance-1\", \"attributes\": {}, \"created_at\": \"2023-07-24T13:14:18.884Z\", \"updated_at\": \"2023-07-24T13:14:18.884Z\"}]}";
    String listProviderTypeInstancesPath = "/provider_types/testString/provider_type_instances";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListProviderTypeInstancesOptions model
    ListProviderTypeInstancesOptions listProviderTypeInstancesOptionsModel = new ListProviderTypeInstancesOptions.Builder()
      .providerTypeId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();

    // Invoke listProviderTypeInstances() with a valid options model and verify the result
    Response<ProviderTypeInstancesResponse> response = securityAndComplianceCenterApiService.listProviderTypeInstances(listProviderTypeInstancesOptionsModel).execute();
    assertNotNull(response);
    ProviderTypeInstancesResponse responseObj = response.getResult();
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

  // Test the createProviderTypeInstance operation with a valid options model parameter
  @Test
  public void testCreateProviderTypeInstanceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"7588190cce3c05ac8f7942ea597dafce\", \"type\": \"workload-protection\", \"name\": \"workload-protection-instance-1\", \"attributes\": {}, \"created_at\": \"2023-07-24T13:14:18.884Z\", \"updated_at\": \"2023-07-24T13:14:18.884Z\"}";
    String createProviderTypeInstancePath = "/provider_types/testString/provider_type_instances";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateProviderTypeInstanceOptions model
    CreateProviderTypeInstanceOptions createProviderTypeInstanceOptionsModel = new CreateProviderTypeInstanceOptions.Builder()
      .providerTypeId("testString")
      .name("workload-protection-instance-1")
      .attributes(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();

    // Invoke createProviderTypeInstance() with a valid options model and verify the result
    Response<ProviderTypeInstanceItem> response = securityAndComplianceCenterApiService.createProviderTypeInstance(createProviderTypeInstanceOptionsModel).execute();
    assertNotNull(response);
    ProviderTypeInstanceItem responseObj = response.getResult();
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

  // Test the deleteProviderTypeInstance operation with a valid options model parameter
  @Test
  public void testDeleteProviderTypeInstanceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteProviderTypeInstancePath = "/provider_types/testString/provider_type_instances/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteProviderTypeInstanceOptions model
    DeleteProviderTypeInstanceOptions deleteProviderTypeInstanceOptionsModel = new DeleteProviderTypeInstanceOptions.Builder()
      .providerTypeId("testString")
      .providerTypeInstanceId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
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

  // Test the getProviderTypeInstance operation with a valid options model parameter
  @Test
  public void testGetProviderTypeInstanceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"7588190cce3c05ac8f7942ea597dafce\", \"type\": \"workload-protection\", \"name\": \"workload-protection-instance-1\", \"attributes\": {}, \"created_at\": \"2023-07-24T13:14:18.884Z\", \"updated_at\": \"2023-07-24T13:14:18.884Z\"}";
    String getProviderTypeInstancePath = "/provider_types/testString/provider_type_instances/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetProviderTypeInstanceOptions model
    GetProviderTypeInstanceOptions getProviderTypeInstanceOptionsModel = new GetProviderTypeInstanceOptions.Builder()
      .providerTypeId("testString")
      .providerTypeInstanceId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();

    // Invoke getProviderTypeInstance() with a valid options model and verify the result
    Response<ProviderTypeInstanceItem> response = securityAndComplianceCenterApiService.getProviderTypeInstance(getProviderTypeInstanceOptionsModel).execute();
    assertNotNull(response);
    ProviderTypeInstanceItem responseObj = response.getResult();
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
    String mockResponseBody = "{\"id\": \"7588190cce3c05ac8f7942ea597dafce\", \"type\": \"workload-protection\", \"name\": \"workload-protection-instance-1\", \"attributes\": {}, \"created_at\": \"2023-07-24T13:14:18.884Z\", \"updated_at\": \"2023-07-24T13:14:18.884Z\"}";
    String updateProviderTypeInstancePath = "/provider_types/testString/provider_type_instances/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName model
    UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName updateProviderTypeInstanceRequestModel = new UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName.Builder()
      .name("workload-protection-instance-1")
      .build();

    // Construct an instance of the UpdateProviderTypeInstanceOptions model
    UpdateProviderTypeInstanceOptions updateProviderTypeInstanceOptionsModel = new UpdateProviderTypeInstanceOptions.Builder()
      .providerTypeId("testString")
      .providerTypeInstanceId("testString")
      .updateProviderTypeInstanceRequest(updateProviderTypeInstanceRequestModel)
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();

    // Invoke updateProviderTypeInstance() with a valid options model and verify the result
    Response<ProviderTypeInstanceItem> response = securityAndComplianceCenterApiService.updateProviderTypeInstance(updateProviderTypeInstanceOptionsModel).execute();
    assertNotNull(response);
    ProviderTypeInstanceItem responseObj = response.getResult();
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

  // Test the getProviderTypesInstances operation with a valid options model parameter
  @Test
  public void testGetProviderTypesInstancesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"provider_types_instances\": [{\"id\": \"7588190cce3c05ac8f7942ea597dafce\", \"type\": \"workload-protection\", \"name\": \"workload-protection-instance-1\", \"attributes\": {}, \"created_at\": \"2023-07-24T13:14:18.884Z\", \"updated_at\": \"2023-07-24T13:14:18.884Z\"}]}";
    String getProviderTypesInstancesPath = "/provider_types_instances";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetProviderTypesInstancesOptions model
    GetProviderTypesInstancesOptions getProviderTypesInstancesOptionsModel = new GetProviderTypesInstancesOptions.Builder()
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();

    // Invoke getProviderTypesInstances() with a valid options model and verify the result
    Response<ProviderTypesInstancesResponse> response = securityAndComplianceCenterApiService.getProviderTypesInstances(getProviderTypesInstancesOptionsModel).execute();
    assertNotNull(response);
    ProviderTypesInstancesResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getProviderTypesInstancesPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getProviderTypesInstances operation with and without retries enabled
  @Test
  public void testGetProviderTypesInstancesWRetries() throws Throwable {
    securityAndComplianceCenterApiService.enableRetries(4, 30);
    testGetProviderTypesInstancesWOptions();

    securityAndComplianceCenterApiService.disableRetries();
    testGetProviderTypesInstancesWOptions();
  }

  // Test the listProviderTypes operation with a valid options model parameter
  @Test
  public void testListProviderTypesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"provider_types\": [{\"id\": \"7588190cce3c05ac8f7942ea597dafce\", \"type\": \"workload-protection\", \"name\": \"workload-protection\", \"description\": \"Security and Compliance Center Workload Protection helps you accelerate your Kubernetes and cloud adoption by addressing security and regulatory compliance. Easily identify vulnerabilities, check compliance, block threats and respond faster at every stage of the container and Kubernetes lifecycle.\", \"s2s_enabled\": true, \"instance_limit\": 1, \"mode\": \"PULL\", \"data_type\": \"com.sysdig.secure.results\", \"icon\": \"PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiBkYXRhLW5hbWU9IkJ1aWxkIGljb24gaGVyZSIgdmlld0JveD0iMCAwIDMyIDMyIj48ZGVmcz48bGluZWFyR3JhZGllbnQgaWQ9ImEiIHgxPSItMjgxMS4xOTgiIHgyPSItMjgxNC4xOTgiIHkxPSI1NTcuNTE3IiB5Mj0iNTU3LjUxNyIgZ3JhZGllbnRUcmFuc2Zvcm09InRyYW5zbGF0ZSgyODMxLjE5OCAtNTQyLjAxNykiIGdyYWRpZW50VW5pdHM9InVzZXJTcGFjZU9uVXNlIj48c3RvcCBvZmZzZXQ9Ii4xIiBzdG9wLW9wYWNpdHk9IjAiLz48c3RvcCBvZmZzZXQ9Ii44Ii8+PC9saW5lYXJHcmFkaWVudD48bGluZWFyR3JhZGllbnQgeGxpbms6aHJlZj0iI2EiIGlkPSJiIiB4MT0iLTgwNi4xOTgiIHgyPSItNzk5LjE5OCIgeTE9Ii0yNDE0LjQ4MSIgeTI9Ii0yNDE0LjQ4MSIgZ3JhZGllbnRUcmFuc2Zvcm09InRyYW5zbGF0ZSg4MjUuMTk4IDI0MjguOTgxKSIvPjxsaW5lYXJHcmFkaWVudCB4bGluazpocmVmPSIjYSIgaWQ9ImMiIHgxPSItODEwLjE5OCIgeDI9Ii03OTguMTk4IiB5MT0iLTI0MTkuOTgxIiB5Mj0iLTI0MTkuOTgxIiBncmFkaWVudFRyYW5zZm9ybT0idHJhbnNsYXRlKDgzMi4xOTggMjQzMi45ODEpIi8+PGxpbmVhckdyYWRpZW50IGlkPSJlIiB4MT0iLTI1MTQiIHgyPSItMjQ4MiIgeTE9Ii0yNDgyIiB5Mj0iLTI1MTQiIGdyYWRpZW50VHJhbnNmb3JtPSJtYXRyaXgoMSAwIDAgLTEgMjUxNCAtMjQ4MikiIGdyYWRpZW50VW5pdHM9InVzZXJTcGFjZU9uVXNlIj48c3RvcCBvZmZzZXQ9Ii4xIiBzdG9wLWNvbG9yPSIjMDhiZGJhIi8+PHN0b3Agb2Zmc2V0PSIuOSIgc3RvcC1jb2xvcj0iIzBmNjJmZSIvPjwvbGluZWFyR3JhZGllbnQ+PG1hc2sgaWQ9ImQiIHdpZHRoPSIyOS4wMTciIGhlaWdodD0iMjcuOTk2IiB4PSIxLjk4MyIgeT0iMiIgZGF0YS1uYW1lPSJtYXNrIiBtYXNrVW5pdHM9InVzZXJTcGFjZU9uVXNlIj48ZyBmaWxsPSIjZmZmIj48cGF0aCBkPSJNMjkuOTc2IDE2YzAtMy43MzktMS40NTYtNy4yNTUtNC4xMDEtOS44OTlTMTkuNzE1IDIgMTUuOTc2IDIgOC43MjEgMy40NTYgNi4wNzcgNi4xMDFjLTUuNDU5IDUuNDU5LTUuNDU5IDE0LjM0IDAgMTkuNzk4QTE0LjA0NCAxNC4wNDQgMCAwIDAgMTYgMjkuOTk1di0yLjAwMWExMi4wNCAxMi4wNCAwIDAgMS04LjUwOS0zLjUxYy00LjY3OS00LjY3OS00LjY3OS0xMi4yOTIgMC0xNi45NzEgMi4yNjctMi4yNjcgNS4yOC0zLjUxNSA4LjQ4NS0zLjUxNXM2LjIxOSAxLjI0OCA4LjQ4NSAzLjUxNSAzLjUxNSA1LjI4IDMuNTE1IDguNDg1YzAgMS4zMDgtLjIxOCAyLjU4LS42MTggMy43ODZsMS44OTcuNjMyYy40NjctMS40MDguNzIyLTIuODkyLjcyMi00LjQxOFoiLz48cGF0aCBkPSJNMjQuNyAxMy42NzVhOC45NCA4Ljk0IDAgMCAwLTQuMTkzLTUuNDY1IDguOTQyIDguOTQyIDAgMCAwLTYuODMtLjg5OSA4Ljk3MSA4Ljk3MSAwIDAgMC01LjQ2MSA0LjE5NSA4Ljk4IDguOTggMCAwIDAtLjkwMyA2LjgyOGMxLjA3NyA0LjAxNiA0LjcyMiA2LjY2IDguNjk1IDYuNjYxdi0xLjk5OGMtMy4wOS0uMDAxLTUuOTI2LTIuMDU4LTYuNzYzLTUuMTgxYTcuMDEgNy4wMSAwIDAgMSA0Ljk1LTguNTc0IDYuOTU4IDYuOTU4IDAgMCAxIDUuMzEyLjY5OSA2Ljk1NCA2Ljk1NCAwIDAgMSAzLjI2MSA0LjI1Yy4zNTkgMS4zNDIuMjc1IDIuNzMyLS4xNTQgNC4wMTNsMS45MDkuNjM2YTguOTU5IDguOTU5IDAgMCAwIC4xNzYtNS4xNjdaIi8+PC9nPjxwYXRoIGZpbGw9IiNmZmYiIGQ9Ik0xNCAxNmMwLTEuMTAzLjg5Ny0yIDItMnMyIC44OTcgMiAyYTIgMiAwIDAgMS0uMTExLjYzbDEuODg5LjYzYy4xMzMtLjM5OC4yMjItLjgxNy4yMjItMS4yNTlhNCA0IDAgMSAwLTQgNHYtMmMtMS4xMDMgMC0yLS44OTctMi0yWiIvPjxwYXRoIGZpbGw9InVybCgjYSkiIGQ9Ik0xNyAxNGgzdjNoLTN6IiB0cmFuc2Zvcm09InJvdGF0ZSgtOTAgMTguNSAxNS41KSIvPjxwYXRoIGZpbGw9InVybCgjYikiIGQ9Ik0xOSAxMmg3djVoLTd6IiB0cmFuc2Zvcm09InJvdGF0ZSg5MCAyMi41IDE0LjUpIi8+PHBhdGggZmlsbD0idXJsKCNjKSIgZD0iTTIyIDEwaDEydjZIMjJ6IiB0cmFuc2Zvcm09InJvdGF0ZSg5MCAyOCAxMykiLz48cGF0aCBkPSJNMjUgMTloNnY0aC02ek0yMCAxOGg1djVoLTV6TTE3IDE3aDN2NmgtM3oiLz48L21hc2s+PC9kZWZzPjxwYXRoIGZpbGw9IiMwMDFkNmMiIGQ9Im0yNSAzMS4wMDEtMi4xMzktMS4wMTNBNS4wMjIgNS4wMjIgMCAwIDEgMjAgMjUuNDY4VjE5aDEwdjYuNDY4YTUuMDIzIDUuMDIzIDAgMCAxLTIuODYxIDQuNTJMMjUgMzEuMDAxWm0tMy0xMHY0LjQ2OGMwIDEuMTUzLjY3NCAyLjIxOCAxLjcxNyAyLjcxMWwxLjI4My42MDcgMS4yODMtLjYwN0EzLjAxMiAzLjAxMiAwIDAgMCAyOCAyNS40Njl2LTQuNDY4aC02WiIgZGF0YS1uYW1lPSJ1dWlkLTU1ODMwNDRiLWZmMjQtNGUyNy05MDU0LTI0MDQzYWRkZmMwNiIvPjxnIG1hc2s9InVybCgjZCkiPjxwYXRoIGZpbGw9InVybCgjZSkiIGQ9Ik0wIDBoMzJ2MzJIMHoiIHRyYW5zZm9ybT0icm90YXRlKC05MCAxNiAxNikiLz48L2c+PC9zdmc+\", \"label\": {\"text\": \"1 per instance\", \"tip\": \"Only 1 per instance\"}, \"attributes\": {\"mapKey\": {\"type\": \"text\", \"display_name\": \"Workload Protection Instance CRN\"}}, \"created_at\": \"2023-07-24T13:14:18.884Z\", \"updated_at\": \"2023-07-24T13:14:18.884Z\"}]}";
    String listProviderTypesPath = "/provider_types";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListProviderTypesOptions model
    ListProviderTypesOptions listProviderTypesOptionsModel = new ListProviderTypesOptions.Builder()
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();

    // Invoke listProviderTypes() with a valid options model and verify the result
    Response<ProviderTypesCollection> response = securityAndComplianceCenterApiService.listProviderTypes(listProviderTypesOptionsModel).execute();
    assertNotNull(response);
    ProviderTypesCollection responseObj = response.getResult();
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

  // Test the getProviderTypeById operation with a valid options model parameter
  @Test
  public void testGetProviderTypeByIdWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"7588190cce3c05ac8f7942ea597dafce\", \"type\": \"workload-protection\", \"name\": \"workload-protection\", \"description\": \"Security and Compliance Center Workload Protection helps you accelerate your Kubernetes and cloud adoption by addressing security and regulatory compliance. Easily identify vulnerabilities, check compliance, block threats and respond faster at every stage of the container and Kubernetes lifecycle.\", \"s2s_enabled\": true, \"instance_limit\": 1, \"mode\": \"PULL\", \"data_type\": \"com.sysdig.secure.results\", \"icon\": \"PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiBkYXRhLW5hbWU9IkJ1aWxkIGljb24gaGVyZSIgdmlld0JveD0iMCAwIDMyIDMyIj48ZGVmcz48bGluZWFyR3JhZGllbnQgaWQ9ImEiIHgxPSItMjgxMS4xOTgiIHgyPSItMjgxNC4xOTgiIHkxPSI1NTcuNTE3IiB5Mj0iNTU3LjUxNyIgZ3JhZGllbnRUcmFuc2Zvcm09InRyYW5zbGF0ZSgyODMxLjE5OCAtNTQyLjAxNykiIGdyYWRpZW50VW5pdHM9InVzZXJTcGFjZU9uVXNlIj48c3RvcCBvZmZzZXQ9Ii4xIiBzdG9wLW9wYWNpdHk9IjAiLz48c3RvcCBvZmZzZXQ9Ii44Ii8+PC9saW5lYXJHcmFkaWVudD48bGluZWFyR3JhZGllbnQgeGxpbms6aHJlZj0iI2EiIGlkPSJiIiB4MT0iLTgwNi4xOTgiIHgyPSItNzk5LjE5OCIgeTE9Ii0yNDE0LjQ4MSIgeTI9Ii0yNDE0LjQ4MSIgZ3JhZGllbnRUcmFuc2Zvcm09InRyYW5zbGF0ZSg4MjUuMTk4IDI0MjguOTgxKSIvPjxsaW5lYXJHcmFkaWVudCB4bGluazpocmVmPSIjYSIgaWQ9ImMiIHgxPSItODEwLjE5OCIgeDI9Ii03OTguMTk4IiB5MT0iLTI0MTkuOTgxIiB5Mj0iLTI0MTkuOTgxIiBncmFkaWVudFRyYW5zZm9ybT0idHJhbnNsYXRlKDgzMi4xOTggMjQzMi45ODEpIi8+PGxpbmVhckdyYWRpZW50IGlkPSJlIiB4MT0iLTI1MTQiIHgyPSItMjQ4MiIgeTE9Ii0yNDgyIiB5Mj0iLTI1MTQiIGdyYWRpZW50VHJhbnNmb3JtPSJtYXRyaXgoMSAwIDAgLTEgMjUxNCAtMjQ4MikiIGdyYWRpZW50VW5pdHM9InVzZXJTcGFjZU9uVXNlIj48c3RvcCBvZmZzZXQ9Ii4xIiBzdG9wLWNvbG9yPSIjMDhiZGJhIi8+PHN0b3Agb2Zmc2V0PSIuOSIgc3RvcC1jb2xvcj0iIzBmNjJmZSIvPjwvbGluZWFyR3JhZGllbnQ+PG1hc2sgaWQ9ImQiIHdpZHRoPSIyOS4wMTciIGhlaWdodD0iMjcuOTk2IiB4PSIxLjk4MyIgeT0iMiIgZGF0YS1uYW1lPSJtYXNrIiBtYXNrVW5pdHM9InVzZXJTcGFjZU9uVXNlIj48ZyBmaWxsPSIjZmZmIj48cGF0aCBkPSJNMjkuOTc2IDE2YzAtMy43MzktMS40NTYtNy4yNTUtNC4xMDEtOS44OTlTMTkuNzE1IDIgMTUuOTc2IDIgOC43MjEgMy40NTYgNi4wNzcgNi4xMDFjLTUuNDU5IDUuNDU5LTUuNDU5IDE0LjM0IDAgMTkuNzk4QTE0LjA0NCAxNC4wNDQgMCAwIDAgMTYgMjkuOTk1di0yLjAwMWExMi4wNCAxMi4wNCAwIDAgMS04LjUwOS0zLjUxYy00LjY3OS00LjY3OS00LjY3OS0xMi4yOTIgMC0xNi45NzEgMi4yNjctMi4yNjcgNS4yOC0zLjUxNSA4LjQ4NS0zLjUxNXM2LjIxOSAxLjI0OCA4LjQ4NSAzLjUxNSAzLjUxNSA1LjI4IDMuNTE1IDguNDg1YzAgMS4zMDgtLjIxOCAyLjU4LS42MTggMy43ODZsMS44OTcuNjMyYy40NjctMS40MDguNzIyLTIuODkyLjcyMi00LjQxOFoiLz48cGF0aCBkPSJNMjQuNyAxMy42NzVhOC45NCA4Ljk0IDAgMCAwLTQuMTkzLTUuNDY1IDguOTQyIDguOTQyIDAgMCAwLTYuODMtLjg5OSA4Ljk3MSA4Ljk3MSAwIDAgMC01LjQ2MSA0LjE5NSA4Ljk4IDguOTggMCAwIDAtLjkwMyA2LjgyOGMxLjA3NyA0LjAxNiA0LjcyMiA2LjY2IDguNjk1IDYuNjYxdi0xLjk5OGMtMy4wOS0uMDAxLTUuOTI2LTIuMDU4LTYuNzYzLTUuMTgxYTcuMDEgNy4wMSAwIDAgMSA0Ljk1LTguNTc0IDYuOTU4IDYuOTU4IDAgMCAxIDUuMzEyLjY5OSA2Ljk1NCA2Ljk1NCAwIDAgMSAzLjI2MSA0LjI1Yy4zNTkgMS4zNDIuMjc1IDIuNzMyLS4xNTQgNC4wMTNsMS45MDkuNjM2YTguOTU5IDguOTU5IDAgMCAwIC4xNzYtNS4xNjdaIi8+PC9nPjxwYXRoIGZpbGw9IiNmZmYiIGQ9Ik0xNCAxNmMwLTEuMTAzLjg5Ny0yIDItMnMyIC44OTcgMiAyYTIgMiAwIDAgMS0uMTExLjYzbDEuODg5LjYzYy4xMzMtLjM5OC4yMjItLjgxNy4yMjItMS4yNTlhNCA0IDAgMSAwLTQgNHYtMmMtMS4xMDMgMC0yLS44OTctMi0yWiIvPjxwYXRoIGZpbGw9InVybCgjYSkiIGQ9Ik0xNyAxNGgzdjNoLTN6IiB0cmFuc2Zvcm09InJvdGF0ZSgtOTAgMTguNSAxNS41KSIvPjxwYXRoIGZpbGw9InVybCgjYikiIGQ9Ik0xOSAxMmg3djVoLTd6IiB0cmFuc2Zvcm09InJvdGF0ZSg5MCAyMi41IDE0LjUpIi8+PHBhdGggZmlsbD0idXJsKCNjKSIgZD0iTTIyIDEwaDEydjZIMjJ6IiB0cmFuc2Zvcm09InJvdGF0ZSg5MCAyOCAxMykiLz48cGF0aCBkPSJNMjUgMTloNnY0aC02ek0yMCAxOGg1djVoLTV6TTE3IDE3aDN2NmgtM3oiLz48L21hc2s+PC9kZWZzPjxwYXRoIGZpbGw9IiMwMDFkNmMiIGQ9Im0yNSAzMS4wMDEtMi4xMzktMS4wMTNBNS4wMjIgNS4wMjIgMCAwIDEgMjAgMjUuNDY4VjE5aDEwdjYuNDY4YTUuMDIzIDUuMDIzIDAgMCAxLTIuODYxIDQuNTJMMjUgMzEuMDAxWm0tMy0xMHY0LjQ2OGMwIDEuMTUzLjY3NCAyLjIxOCAxLjcxNyAyLjcxMWwxLjI4My42MDcgMS4yODMtLjYwN0EzLjAxMiAzLjAxMiAwIDAgMCAyOCAyNS40Njl2LTQuNDY4aC02WiIgZGF0YS1uYW1lPSJ1dWlkLTU1ODMwNDRiLWZmMjQtNGUyNy05MDU0LTI0MDQzYWRkZmMwNiIvPjxnIG1hc2s9InVybCgjZCkiPjxwYXRoIGZpbGw9InVybCgjZSkiIGQ9Ik0wIDBoMzJ2MzJIMHoiIHRyYW5zZm9ybT0icm90YXRlKC05MCAxNiAxNikiLz48L2c+PC9zdmc+\", \"label\": {\"text\": \"1 per instance\", \"tip\": \"Only 1 per instance\"}, \"attributes\": {\"mapKey\": {\"type\": \"text\", \"display_name\": \"Workload Protection Instance CRN\"}}, \"created_at\": \"2023-07-24T13:14:18.884Z\", \"updated_at\": \"2023-07-24T13:14:18.884Z\"}";
    String getProviderTypeByIdPath = "/provider_types/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetProviderTypeByIdOptions model
    GetProviderTypeByIdOptions getProviderTypeByIdOptionsModel = new GetProviderTypeByIdOptions.Builder()
      .providerTypeId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();

    // Invoke getProviderTypeById() with a valid options model and verify the result
    Response<ProviderTypeItem> response = securityAndComplianceCenterApiService.getProviderTypeById(getProviderTypeByIdOptionsModel).execute();
    assertNotNull(response);
    ProviderTypeItem responseObj = response.getResult();
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