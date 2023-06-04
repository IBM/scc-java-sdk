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
package com.ibm.cloud.scc.compliance.v2;

import com.ibm.cloud.scc.compliance.v2.Compliance;
import com.ibm.cloud.scc.compliance.v2.model.AddProfileOptions;
import com.ibm.cloud.scc.compliance.v2.model.AttachmentPayload;
import com.ibm.cloud.scc.compliance.v2.model.AttachmentProfileRequest;
import com.ibm.cloud.scc.compliance.v2.model.AttachmentProfileResponse;
import com.ibm.cloud.scc.compliance.v2.model.AttachmentResponse;
import com.ibm.cloud.scc.compliance.v2.model.AttachmentsNotificationsPayload;
import com.ibm.cloud.scc.compliance.v2.model.CheckProfileAttachmnetsOptions;
import com.ibm.cloud.scc.compliance.v2.model.ControlDocs;
import com.ibm.cloud.scc.compliance.v2.model.ControlLibraryListResponse;
import com.ibm.cloud.scc.compliance.v2.model.ControlLibraryRequest;
import com.ibm.cloud.scc.compliance.v2.model.ControlSpecifications;
import com.ibm.cloud.scc.compliance.v2.model.ControlsInControlLibRequestPayload;
import com.ibm.cloud.scc.compliance.v2.model.CreateAttachmentOptions;
import com.ibm.cloud.scc.compliance.v2.model.CreateCustomControlLibraryOptions;
import com.ibm.cloud.scc.compliance.v2.model.CreateProfileOptions;
import com.ibm.cloud.scc.compliance.v2.model.CreateScanOptions;
import com.ibm.cloud.scc.compliance.v2.model.CreateScanResponse;
import com.ibm.cloud.scc.compliance.v2.model.DefaultParameters;
import com.ibm.cloud.scc.compliance.v2.model.DeleteCustomControllibraryOptions;
import com.ibm.cloud.scc.compliance.v2.model.DeleteCustomProfileOptions;
import com.ibm.cloud.scc.compliance.v2.model.DeleteProfileAttachmnetOptions;
import com.ibm.cloud.scc.compliance.v2.model.FailedControls;
import com.ibm.cloud.scc.compliance.v2.model.GetAllAttachmnetsForProfileRespBody;
import com.ibm.cloud.scc.compliance.v2.model.GetAllControlLibrariesRespBody;
import com.ibm.cloud.scc.compliance.v2.model.GetAllProfilesRespBody;
import com.ibm.cloud.scc.compliance.v2.model.GetControlLibraryOptions;
import com.ibm.cloud.scc.compliance.v2.model.GetParametersByNameOptions;
import com.ibm.cloud.scc.compliance.v2.model.GetProfileAttachmnetOptions;
import com.ibm.cloud.scc.compliance.v2.model.GetProfileOptions;
import com.ibm.cloud.scc.compliance.v2.model.ImplementationPayload;
import com.ibm.cloud.scc.compliance.v2.model.ListAttachmentParametersOptions;
import com.ibm.cloud.scc.compliance.v2.model.ListControlLibrariesOptions;
import com.ibm.cloud.scc.compliance.v2.model.ListProfilesOptions;
import com.ibm.cloud.scc.compliance.v2.model.ListProfilesResponseStructure;
import com.ibm.cloud.scc.compliance.v2.model.PageRefFirst;
import com.ibm.cloud.scc.compliance.v2.model.PageRefNext;
import com.ibm.cloud.scc.compliance.v2.model.ParameterDetails;
import com.ibm.cloud.scc.compliance.v2.model.ParameterInfo;
import com.ibm.cloud.scc.compliance.v2.model.ProfileControlsInRequest;
import com.ibm.cloud.scc.compliance.v2.model.ProfileControlsInResponse;
import com.ibm.cloud.scc.compliance.v2.model.ProfileDefaultParametersResponse;
import com.ibm.cloud.scc.compliance.v2.model.ProfileResponse;
import com.ibm.cloud.scc.compliance.v2.model.ReplaceAttachmentOptions;
import com.ibm.cloud.scc.compliance.v2.model.ReplaceAttachmnetParametersByNameOptions;
import com.ibm.cloud.scc.compliance.v2.model.ReplaceCustomControlLibraryOptions;
import com.ibm.cloud.scc.compliance.v2.model.ReplaceProfileAttachmentOptions;
import com.ibm.cloud.scc.compliance.v2.model.ReplaceProfileParametersOptions;
import com.ibm.cloud.scc.compliance.v2.model.ScopePayload;
import com.ibm.cloud.scc.compliance.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.IOException;
import java.io.InputStream;
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
 * Unit test class for the Compliance service.
 */
public class ComplianceTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected Compliance complianceService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new Compliance(serviceName, null);
  }

  // Test the createProfile operation with a valid options model parameter
  @Test
  public void testCreateProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"profile_name\": \"profileName\", \"profile_description\": \"profileDescription\", \"profile_type\": \"profileType\", \"profile_version\": \"profileVersion\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"createdOn\", \"updated_by\": \"updatedBy\", \"updated_on\": \"updatedOn\", \"controls_count\": 13, \"attachments_count\": 16, \"controls\": [{\"control_library_id\": \"controlLibraryId\", \"control_id\": \"controlId\", \"control_library_version\": \"controlLibraryVersion\", \"control_name\": \"controlName\", \"control_description\": \"controlDescription\", \"control_severity\": \"controlSeverity\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"user\", \"component_id\": \"componentId\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"assessmentId\", \"assessment_method\": \"assessmentMethod\", \"assessment_type\": \"assessmentType\", \"assessment_description\": \"assessmentDescription\", \"parameter_count\": 14, \"parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}]}]}], \"default_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}";
    String createProfilePath = "/instances/testString/v3/profiles";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ProfileControlsInRequest model
    ProfileControlsInRequest profileControlsInRequestModel = new ProfileControlsInRequest.Builder()
      .controlLibraryId("testString")
      .controlId("testString")
      .build();

    // Construct an instance of the DefaultParameters model
    DefaultParameters defaultParametersModel = new DefaultParameters.Builder()
      .assessmentType("testString")
      .assessmentId("testString")
      .parameterName("testString")
      .parameterDefaultValue("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .build();

    // Construct an instance of the CreateProfileOptions model
    CreateProfileOptions createProfileOptionsModel = new CreateProfileOptions.Builder()
      .instanceId("testString")
      .profileName("testString")
      .profileDescription("testString")
      .profileType("predefined")
      .profileVersion("testString")
      .latest(true)
      .versionGroupLabel("testString")
      .controls(java.util.Arrays.asList(profileControlsInRequestModel))
      .defaultParameters(java.util.Arrays.asList(defaultParametersModel))
      .transactionId("testString")
      .build();

    // Invoke createProfile() with a valid options model and verify the result
    Response<ProfileResponse> response = complianceService.createProfile(createProfileOptionsModel).execute();
    assertNotNull(response);
    ProfileResponse responseObj = response.getResult();
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
    complianceService.enableRetries(4, 30);
    testCreateProfileWOptions();

    complianceService.disableRetries();
    testCreateProfileWOptions();
  }

  // Test the createProfile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateProfileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.createProfile(null).execute();
  }

  // Test the listProfiles operation with a valid options model parameter
  @Test
  public void testListProfilesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_count\": 1, \"limit\": 20, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"profiles\": [{\"id\": \"id\", \"profile_name\": \"profileName\", \"profile_description\": \"profileDescription\", \"profile_type\": \"profileType\", \"profile_version\": \"profileVersion\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"createdOn\", \"updated_by\": \"updatedBy\", \"updated_on\": \"updatedOn\", \"controls_count\": 13, \"attachments_count\": 16}]}";
    String listProfilesPath = "/instances/testString/v3/profiles";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListProfilesOptions model
    ListProfilesOptions listProfilesOptionsModel = new ListProfilesOptions.Builder()
      .instanceId("testString")
      .transactionId("testString")
      .build();

    // Invoke listProfiles() with a valid options model and verify the result
    Response<GetAllProfilesRespBody> response = complianceService.listProfiles(listProfilesOptionsModel).execute();
    assertNotNull(response);
    GetAllProfilesRespBody responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listProfilesPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listProfiles operation with and without retries enabled
  @Test
  public void testListProfilesWRetries() throws Throwable {
    complianceService.enableRetries(4, 30);
    testListProfilesWOptions();

    complianceService.disableRetries();
    testListProfilesWOptions();
  }

  // Test the listProfiles operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListProfilesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.listProfiles(null).execute();
  }

  // Test the addProfile operation with a valid options model parameter
  @Test
  public void testAddProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"profile_name\": \"profileName\", \"profile_description\": \"profileDescription\", \"profile_type\": \"profileType\", \"profile_version\": \"profileVersion\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"createdOn\", \"updated_by\": \"updatedBy\", \"updated_on\": \"updatedOn\", \"controls_count\": 13, \"attachments_count\": 16, \"controls\": [{\"control_library_id\": \"controlLibraryId\", \"control_id\": \"controlId\", \"control_library_version\": \"controlLibraryVersion\", \"control_name\": \"controlName\", \"control_description\": \"controlDescription\", \"control_severity\": \"controlSeverity\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"user\", \"component_id\": \"componentId\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"assessmentId\", \"assessment_method\": \"assessmentMethod\", \"assessment_type\": \"assessmentType\", \"assessment_description\": \"assessmentDescription\", \"parameter_count\": 14, \"parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}]}]}], \"default_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}";
    String addProfilePath = "/instances/testString/v3/profiles/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ProfileControlsInRequest model
    ProfileControlsInRequest profileControlsInRequestModel = new ProfileControlsInRequest.Builder()
      .controlLibraryId("testString")
      .controlId("testString")
      .build();

    // Construct an instance of the DefaultParameters model
    DefaultParameters defaultParametersModel = new DefaultParameters.Builder()
      .assessmentType("testString")
      .assessmentId("testString")
      .parameterName("testString")
      .parameterDefaultValue("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .build();

    // Construct an instance of the AddProfileOptions model
    AddProfileOptions addProfileOptionsModel = new AddProfileOptions.Builder()
      .profilesId("testString")
      .instanceId("testString")
      .profileName("testString")
      .profileDescription("testString")
      .profileType("predefined")
      .profileVersion("testString")
      .latest(true)
      .versionGroupLabel("testString")
      .controls(java.util.Arrays.asList(profileControlsInRequestModel))
      .defaultParameters(java.util.Arrays.asList(defaultParametersModel))
      .transactionId("testString")
      .build();

    // Invoke addProfile() with a valid options model and verify the result
    Response<ProfileResponse> response = complianceService.addProfile(addProfileOptionsModel).execute();
    assertNotNull(response);
    ProfileResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addProfilePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the addProfile operation with and without retries enabled
  @Test
  public void testAddProfileWRetries() throws Throwable {
    complianceService.enableRetries(4, 30);
    testAddProfileWOptions();

    complianceService.disableRetries();
    testAddProfileWOptions();
  }

  // Test the addProfile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddProfileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.addProfile(null).execute();
  }

  // Test the getProfile operation with a valid options model parameter
  @Test
  public void testGetProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"profile_name\": \"profileName\", \"profile_description\": \"profileDescription\", \"profile_type\": \"profileType\", \"profile_version\": \"profileVersion\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"createdOn\", \"updated_by\": \"updatedBy\", \"updated_on\": \"updatedOn\", \"controls_count\": 13, \"attachments_count\": 16, \"controls\": [{\"control_library_id\": \"controlLibraryId\", \"control_id\": \"controlId\", \"control_library_version\": \"controlLibraryVersion\", \"control_name\": \"controlName\", \"control_description\": \"controlDescription\", \"control_severity\": \"controlSeverity\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"user\", \"component_id\": \"componentId\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"assessmentId\", \"assessment_method\": \"assessmentMethod\", \"assessment_type\": \"assessmentType\", \"assessment_description\": \"assessmentDescription\", \"parameter_count\": 14, \"parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}]}]}], \"default_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}";
    String getProfilePath = "/instances/testString/v3/profiles/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetProfileOptions model
    GetProfileOptions getProfileOptionsModel = new GetProfileOptions.Builder()
      .profilesId("testString")
      .instanceId("testString")
      .transactionId("testString")
      .build();

    // Invoke getProfile() with a valid options model and verify the result
    Response<ProfileResponse> response = complianceService.getProfile(getProfileOptionsModel).execute();
    assertNotNull(response);
    ProfileResponse responseObj = response.getResult();
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
    complianceService.enableRetries(4, 30);
    testGetProfileWOptions();

    complianceService.disableRetries();
    testGetProfileWOptions();
  }

  // Test the getProfile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetProfileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.getProfile(null).execute();
  }

  // Test the deleteCustomProfile operation with a valid options model parameter
  @Test
  public void testDeleteCustomProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"profile_name\": \"profileName\", \"profile_description\": \"profileDescription\", \"profile_type\": \"profileType\", \"profile_version\": \"profileVersion\", \"version_group_label\": \"versionGroupLabel\", \"latest\": true, \"created_by\": \"createdBy\", \"created_on\": \"createdOn\", \"updated_by\": \"updatedBy\", \"updated_on\": \"updatedOn\", \"controls_count\": 13, \"attachments_count\": 16, \"controls\": [{\"control_library_id\": \"controlLibraryId\", \"control_id\": \"controlId\", \"control_library_version\": \"controlLibraryVersion\", \"control_name\": \"controlName\", \"control_description\": \"controlDescription\", \"control_severity\": \"controlSeverity\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"user\", \"component_id\": \"componentId\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"assessmentId\", \"assessment_method\": \"assessmentMethod\", \"assessment_type\": \"assessmentType\", \"assessment_description\": \"assessmentDescription\", \"parameter_count\": 14, \"parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}]}]}], \"default_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}";
    String deleteCustomProfilePath = "/instances/testString/v3/profiles/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteCustomProfileOptions model
    DeleteCustomProfileOptions deleteCustomProfileOptionsModel = new DeleteCustomProfileOptions.Builder()
      .profilesId("testString")
      .instanceId("testString")
      .transactionId("testString")
      .build();

    // Invoke deleteCustomProfile() with a valid options model and verify the result
    Response<ProfileResponse> response = complianceService.deleteCustomProfile(deleteCustomProfileOptionsModel).execute();
    assertNotNull(response);
    ProfileResponse responseObj = response.getResult();
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
    complianceService.enableRetries(4, 30);
    testDeleteCustomProfileWOptions();

    complianceService.disableRetries();
    testDeleteCustomProfileWOptions();
  }

  // Test the deleteCustomProfile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCustomProfileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.deleteCustomProfile(null).execute();
  }

  // Test the replaceProfileParameters operation with a valid options model parameter
  @Test
  public void testReplaceProfileParametersWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"default_parameters\": [{\"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameter_name\": \"parameterName\", \"parameter_default_value\": \"parameterDefaultValue\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}";
    String replaceProfileParametersPath = "/instances/testString/v3/profiles/testString/parameters";
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
      .parameterType("numeric")
      .build();

    // Construct an instance of the ReplaceProfileParametersOptions model
    ReplaceProfileParametersOptions replaceProfileParametersOptionsModel = new ReplaceProfileParametersOptions.Builder()
      .profilesId("testString")
      .instanceId("testString")
      .id("testString")
      .defaultParameters(java.util.Arrays.asList(defaultParametersModel))
      .transactionId("testString")
      .build();

    // Invoke replaceProfileParameters() with a valid options model and verify the result
    Response<ProfileDefaultParametersResponse> response = complianceService.replaceProfileParameters(replaceProfileParametersOptionsModel).execute();
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
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the replaceProfileParameters operation with and without retries enabled
  @Test
  public void testReplaceProfileParametersWRetries() throws Throwable {
    complianceService.enableRetries(4, 30);
    testReplaceProfileParametersWOptions();

    complianceService.disableRetries();
    testReplaceProfileParametersWOptions();
  }

  // Test the replaceProfileParameters operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceProfileParametersNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.replaceProfileParameters(null).execute();
  }

  // Test the createAttachment operation with a valid options model parameter
  @Test
  public void testCreateAttachmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"profile_id\": \"profileId\", \"attachments\": [{\"id\": \"id\", \"account_id\": \"accountId\", \"included_scope\": {\"scope_id\": \"scopeId\", \"scope_type\": \"scopeType\"}, \"exclusions\": [{\"scope_id\": \"scopeId\", \"scope_type\": \"scopeType\"}], \"created_by\": \"createdBy\", \"created_on\": \"createdOn\", \"updated_by\": \"updatedBy\", \"updated_on\": \"updatedOn\", \"status\": \"status\", \"attachment_parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\", \"parameter_value\": \"parameterValue\", \"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}], \"last_scan\": \"lastScan\", \"last_scan_status\": \"lastScanStatus\", \"last_scan_time\": \"lastScanTime\"}]}";
    String createAttachmentPath = "/instances/testString/v3/profiles/testString/attachments";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ScopePayload model
    ScopePayload scopePayloadModel = new ScopePayload.Builder()
      .scopeId("testString")
      .scopeType("testString")
      .build();

    // Construct an instance of the ParameterInfo model
    ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
      .parameterName("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .build();

    // Construct an instance of the ParameterDetails model
    ParameterDetails parameterDetailsModel = new ParameterDetails.Builder()
      .parameterName("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .parameterValue("testString")
      .assessmentType("testString")
      .assessmentId("testString")
      .parameters(java.util.Arrays.asList(parameterInfoModel))
      .build();

    // Construct an instance of the FailedControls model
    FailedControls failedControlsModel = new FailedControls.Builder()
      .thresholdLimit(Long.valueOf("26"))
      .failedControlIds(java.util.Arrays.asList("testString"))
      .build();

    // Construct an instance of the AttachmentsNotificationsPayload model
    AttachmentsNotificationsPayload attachmentsNotificationsPayloadModel = new AttachmentsNotificationsPayload.Builder()
      .enabled(true)
      .controls(failedControlsModel)
      .build();

    // Construct an instance of the AttachmentPayload model
    AttachmentPayload attachmentPayloadModel = new AttachmentPayload.Builder()
      .id("testString")
      .accountId("testString")
      .includedScope(scopePayloadModel)
      .exclusions(java.util.Arrays.asList(scopePayloadModel))
      .createdBy("testString")
      .createdOn("testString")
      .updatedBy("testString")
      .updatedOn("testString")
      .status("enabled")
      .attachmentParameters(java.util.Arrays.asList(parameterDetailsModel))
      .attachmentNotifications(attachmentsNotificationsPayloadModel)
      .build();

    // Construct an instance of the CreateAttachmentOptions model
    CreateAttachmentOptions createAttachmentOptionsModel = new CreateAttachmentOptions.Builder()
      .profilesId("testString")
      .instanceId("testString")
      .attachments(java.util.Arrays.asList(attachmentPayloadModel))
      .transactionId("testString")
      .build();

    // Invoke createAttachment() with a valid options model and verify the result
    Response<AttachmentProfileResponse> response = complianceService.createAttachment(createAttachmentOptionsModel).execute();
    assertNotNull(response);
    AttachmentProfileResponse responseObj = response.getResult();
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
    complianceService.enableRetries(4, 30);
    testCreateAttachmentWOptions();

    complianceService.disableRetries();
    testCreateAttachmentWOptions();
  }

  // Test the createAttachment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAttachmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.createAttachment(null).execute();
  }

  // Test the checkProfileAttachmnets operation with a valid options model parameter
  @Test
  public void testCheckProfileAttachmnetsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_count\": 10, \"limit\": 5, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"profile_id\": \"profileId\", \"account_id\": \"accountId\", \"control_libraries\": [{\"id\": \"id\", \"account_id\": \"accountId\", \"control_library_name\": \"controlLibraryName\", \"control_library_description\": \"controlLibraryDescription\", \"control_library_type\": \"controlLibraryType\", \"created_on\": \"createdOn\", \"created_by\": \"createdBy\", \"updated_on\": \"updatedOn\", \"updated_by\": \"updatedBy\", \"version_group_label\": \"versionGroupLabel\", \"control_library_version\": \"controlLibraryVersion\", \"latest\": true, \"controls_count\": 13}], \"attachments\": [{\"attachments\": [{\"id\": \"id\", \"account_id\": \"accountId\", \"included_scope\": {\"scope_id\": \"scopeId\", \"scope_type\": \"scopeType\"}, \"exclusions\": [{\"scope_id\": \"scopeId\", \"scope_type\": \"scopeType\"}], \"created_by\": \"createdBy\", \"created_on\": \"createdOn\", \"updated_by\": \"updatedBy\", \"updated_on\": \"updatedOn\", \"status\": \"enabled\", \"attachment_parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\", \"parameter_value\": \"parameterValue\", \"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}], \"attachment_notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 14, \"failed_control_ids\": [\"failedControlIds\"]}}}]}]}";
    String checkProfileAttachmnetsPath = "/instances/testString/v3/profiles/testString/attachments";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CheckProfileAttachmnetsOptions model
    CheckProfileAttachmnetsOptions checkProfileAttachmnetsOptionsModel = new CheckProfileAttachmnetsOptions.Builder()
      .profilesId("testString")
      .instanceId("testString")
      .transactionId("testString")
      .build();

    // Invoke checkProfileAttachmnets() with a valid options model and verify the result
    Response<GetAllAttachmnetsForProfileRespBody> response = complianceService.checkProfileAttachmnets(checkProfileAttachmnetsOptionsModel).execute();
    assertNotNull(response);
    GetAllAttachmnetsForProfileRespBody responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, checkProfileAttachmnetsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the checkProfileAttachmnets operation with and without retries enabled
  @Test
  public void testCheckProfileAttachmnetsWRetries() throws Throwable {
    complianceService.enableRetries(4, 30);
    testCheckProfileAttachmnetsWOptions();

    complianceService.disableRetries();
    testCheckProfileAttachmnetsWOptions();
  }

  // Test the checkProfileAttachmnets operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCheckProfileAttachmnetsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.checkProfileAttachmnets(null).execute();
  }

  // Test the getProfileAttachmnet operation with a valid options model parameter
  @Test
  public void testGetProfileAttachmnetWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"account_id\": \"accountId\", \"included_scope\": {\"scope_id\": \"scopeId\", \"scope_type\": \"scopeType\"}, \"exclusions\": [{\"scope_id\": \"scopeId\", \"scope_type\": \"scopeType\"}], \"created_by\": \"createdBy\", \"created_on\": \"createdOn\", \"updated_by\": \"updatedBy\", \"updated_on\": \"updatedOn\", \"status\": \"enabled\", \"attachment_parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\", \"parameter_value\": \"parameterValue\", \"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}], \"attachment_notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 14, \"failed_control_ids\": [\"failedControlIds\"]}}}";
    String getProfileAttachmnetPath = "/instances/testString/v3/profiles/testString/attachments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetProfileAttachmnetOptions model
    GetProfileAttachmnetOptions getProfileAttachmnetOptionsModel = new GetProfileAttachmnetOptions.Builder()
      .profilesId("testString")
      .attachmentId("testString")
      .instanceId("testString")
      .transactionId("testString")
      .build();

    // Invoke getProfileAttachmnet() with a valid options model and verify the result
    Response<AttachmentPayload> response = complianceService.getProfileAttachmnet(getProfileAttachmnetOptionsModel).execute();
    assertNotNull(response);
    AttachmentPayload responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getProfileAttachmnetPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getProfileAttachmnet operation with and without retries enabled
  @Test
  public void testGetProfileAttachmnetWRetries() throws Throwable {
    complianceService.enableRetries(4, 30);
    testGetProfileAttachmnetWOptions();

    complianceService.disableRetries();
    testGetProfileAttachmnetWOptions();
  }

  // Test the getProfileAttachmnet operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetProfileAttachmnetNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.getProfileAttachmnet(null).execute();
  }

  // Test the replaceProfileAttachment operation with a valid options model parameter
  @Test
  public void testReplaceProfileAttachmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"account_id\": \"accountId\", \"included_scope\": {\"scope_id\": \"scopeId\", \"scope_type\": \"scopeType\"}, \"exclusions\": [{\"scope_id\": \"scopeId\", \"scope_type\": \"scopeType\"}], \"created_by\": \"createdBy\", \"created_on\": \"createdOn\", \"updated_by\": \"updatedBy\", \"updated_on\": \"updatedOn\", \"status\": \"enabled\", \"attachment_parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\", \"parameter_value\": \"parameterValue\", \"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}], \"attachment_notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 14, \"failed_control_ids\": [\"failedControlIds\"]}}}";
    String replaceProfileAttachmentPath = "/instances/testString/v3/profiles/testString/attachments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ScopePayload model
    ScopePayload scopePayloadModel = new ScopePayload.Builder()
      .scopeId("testString")
      .scopeType("testString")
      .build();

    // Construct an instance of the ParameterInfo model
    ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
      .parameterName("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .build();

    // Construct an instance of the ParameterDetails model
    ParameterDetails parameterDetailsModel = new ParameterDetails.Builder()
      .parameterName("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .parameterValue("testString")
      .assessmentType("testString")
      .assessmentId("testString")
      .parameters(java.util.Arrays.asList(parameterInfoModel))
      .build();

    // Construct an instance of the FailedControls model
    FailedControls failedControlsModel = new FailedControls.Builder()
      .thresholdLimit(Long.valueOf("26"))
      .failedControlIds(java.util.Arrays.asList("testString"))
      .build();

    // Construct an instance of the AttachmentsNotificationsPayload model
    AttachmentsNotificationsPayload attachmentsNotificationsPayloadModel = new AttachmentsNotificationsPayload.Builder()
      .enabled(true)
      .controls(failedControlsModel)
      .build();

    // Construct an instance of the ReplaceProfileAttachmentOptions model
    ReplaceProfileAttachmentOptions replaceProfileAttachmentOptionsModel = new ReplaceProfileAttachmentOptions.Builder()
      .profilesId("testString")
      .attachmentId("testString")
      .instanceId("testString")
      .id("testString")
      .accountId("testString")
      .includedScope(scopePayloadModel)
      .exclusions(java.util.Arrays.asList(scopePayloadModel))
      .createdBy("testString")
      .createdOn("testString")
      .updatedBy("testString")
      .updatedOn("testString")
      .status("enabled")
      .attachmentParameters(java.util.Arrays.asList(parameterDetailsModel))
      .attachmentNotifications(attachmentsNotificationsPayloadModel)
      .transactionId("testString")
      .build();

    // Invoke replaceProfileAttachment() with a valid options model and verify the result
    Response<AttachmentPayload> response = complianceService.replaceProfileAttachment(replaceProfileAttachmentOptionsModel).execute();
    assertNotNull(response);
    AttachmentPayload responseObj = response.getResult();
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
    complianceService.enableRetries(4, 30);
    testReplaceProfileAttachmentWOptions();

    complianceService.disableRetries();
    testReplaceProfileAttachmentWOptions();
  }

  // Test the replaceProfileAttachment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceProfileAttachmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.replaceProfileAttachment(null).execute();
  }

  // Test the deleteProfileAttachmnet operation with a valid options model parameter
  @Test
  public void testDeleteProfileAttachmnetWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"account_id\": \"accountId\", \"included_scope\": {\"scope_id\": \"scopeId\", \"scope_type\": \"scopeType\"}, \"exclusions\": [{\"scope_id\": \"scopeId\", \"scope_type\": \"scopeType\"}], \"created_by\": \"createdBy\", \"created_on\": \"createdOn\", \"updated_by\": \"updatedBy\", \"updated_on\": \"updatedOn\", \"status\": \"enabled\", \"attachment_parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\", \"parameter_value\": \"parameterValue\", \"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}], \"attachment_notifications\": {\"enabled\": false, \"controls\": {\"threshold_limit\": 14, \"failed_control_ids\": [\"failedControlIds\"]}}}";
    String deleteProfileAttachmnetPath = "/instances/testString/v3/profiles/testString/attachments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteProfileAttachmnetOptions model
    DeleteProfileAttachmnetOptions deleteProfileAttachmnetOptionsModel = new DeleteProfileAttachmnetOptions.Builder()
      .profilesId("testString")
      .attachmentId("testString")
      .instanceId("testString")
      .transactionId("testString")
      .build();

    // Invoke deleteProfileAttachmnet() with a valid options model and verify the result
    Response<AttachmentPayload> response = complianceService.deleteProfileAttachmnet(deleteProfileAttachmnetOptionsModel).execute();
    assertNotNull(response);
    AttachmentPayload responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteProfileAttachmnetPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteProfileAttachmnet operation with and without retries enabled
  @Test
  public void testDeleteProfileAttachmnetWRetries() throws Throwable {
    complianceService.enableRetries(4, 30);
    testDeleteProfileAttachmnetWOptions();

    complianceService.disableRetries();
    testDeleteProfileAttachmnetWOptions();
  }

  // Test the deleteProfileAttachmnet operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteProfileAttachmnetNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.deleteProfileAttachmnet(null).execute();
  }

  // Test the listAttachmentParameters operation with a valid options model parameter
  @Test
  public void testListAttachmentParametersWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\", \"parameter_value\": \"parameterValue\", \"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}";
    String listAttachmentParametersPath = "/instances/testString/v3/profiles/testString/attachments/testString/parameters";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListAttachmentParametersOptions model
    ListAttachmentParametersOptions listAttachmentParametersOptionsModel = new ListAttachmentParametersOptions.Builder()
      .profilesId("testString")
      .attachmentId("testString")
      .instanceId("testString")
      .transactionId("testString")
      .build();

    // Invoke listAttachmentParameters() with a valid options model and verify the result
    Response<ParameterDetails> response = complianceService.listAttachmentParameters(listAttachmentParametersOptionsModel).execute();
    assertNotNull(response);
    ParameterDetails responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAttachmentParametersPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listAttachmentParameters operation with and without retries enabled
  @Test
  public void testListAttachmentParametersWRetries() throws Throwable {
    complianceService.enableRetries(4, 30);
    testListAttachmentParametersWOptions();

    complianceService.disableRetries();
    testListAttachmentParametersWOptions();
  }

  // Test the listAttachmentParameters operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAttachmentParametersNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.listAttachmentParameters(null).execute();
  }

  // Test the replaceAttachment operation with a valid options model parameter
  @Test
  public void testReplaceAttachmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\", \"parameter_value\": \"parameterValue\", \"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}";
    String replaceAttachmentPath = "/instances/testString/v3/profiles/testString/attachments/testString/parameters";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ParameterInfo model
    ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
      .parameterName("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .build();

    // Construct an instance of the ReplaceAttachmentOptions model
    ReplaceAttachmentOptions replaceAttachmentOptionsModel = new ReplaceAttachmentOptions.Builder()
      .profilesId("testString")
      .attachmentId("testString")
      .instanceId("testString")
      .parameterName("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .parameterValue("testString")
      .assessmentType("testString")
      .assessmentId("testString")
      .parameters(java.util.Arrays.asList(parameterInfoModel))
      .transactionId("testString")
      .build();

    // Invoke replaceAttachment() with a valid options model and verify the result
    Response<ParameterDetails> response = complianceService.replaceAttachment(replaceAttachmentOptionsModel).execute();
    assertNotNull(response);
    ParameterDetails responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceAttachmentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the replaceAttachment operation with and without retries enabled
  @Test
  public void testReplaceAttachmentWRetries() throws Throwable {
    complianceService.enableRetries(4, 30);
    testReplaceAttachmentWOptions();

    complianceService.disableRetries();
    testReplaceAttachmentWOptions();
  }

  // Test the replaceAttachment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceAttachmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.replaceAttachment(null).execute();
  }

  // Test the getParametersByName operation with a valid options model parameter
  @Test
  public void testGetParametersByNameWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\", \"parameter_value\": \"parameterValue\", \"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}";
    String getParametersByNamePath = "/instances/testString/v3/profiles/testString/attachments/testString/parameters/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetParametersByNameOptions model
    GetParametersByNameOptions getParametersByNameOptionsModel = new GetParametersByNameOptions.Builder()
      .profilesId("testString")
      .attachmentId("testString")
      .parameterName("testString")
      .instanceId("testString")
      .transactionId("testString")
      .build();

    // Invoke getParametersByName() with a valid options model and verify the result
    Response<ParameterDetails> response = complianceService.getParametersByName(getParametersByNameOptionsModel).execute();
    assertNotNull(response);
    ParameterDetails responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getParametersByNamePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getParametersByName operation with and without retries enabled
  @Test
  public void testGetParametersByNameWRetries() throws Throwable {
    complianceService.enableRetries(4, 30);
    testGetParametersByNameWOptions();

    complianceService.disableRetries();
    testGetParametersByNameWOptions();
  }

  // Test the getParametersByName operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetParametersByNameNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.getParametersByName(null).execute();
  }

  // Test the replaceAttachmnetParametersByName operation with a valid options model parameter
  @Test
  public void testReplaceAttachmnetParametersByNameWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\", \"parameter_value\": \"parameterValue\", \"assessment_type\": \"assessmentType\", \"assessment_id\": \"assessmentId\", \"parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}";
    String replaceAttachmnetParametersByNamePath = "/instances/testString/v3/profiles/testString/attachments/testString/parameters/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ParameterInfo model
    ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
      .parameterName("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .build();

    // Construct an instance of the ReplaceAttachmnetParametersByNameOptions model
    ReplaceAttachmnetParametersByNameOptions replaceAttachmnetParametersByNameOptionsModel = new ReplaceAttachmnetParametersByNameOptions.Builder()
      .profilesId("testString")
      .attachmentId("testString")
      .parameterName("testString")
      .instanceId("testString")
      .newParameterName("testString")
      .newParameterDisplayName("testString")
      .newParameterType("numeric")
      .newParameterValue("testString")
      .newAssessmentType("testString")
      .newAssessmentId("testString")
      .newParameters(java.util.Arrays.asList(parameterInfoModel))
      .transactionId("testString")
      .build();

    // Invoke replaceAttachmnetParametersByName() with a valid options model and verify the result
    Response<ParameterDetails> response = complianceService.replaceAttachmnetParametersByName(replaceAttachmnetParametersByNameOptionsModel).execute();
    assertNotNull(response);
    ParameterDetails responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceAttachmnetParametersByNamePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the replaceAttachmnetParametersByName operation with and without retries enabled
  @Test
  public void testReplaceAttachmnetParametersByNameWRetries() throws Throwable {
    complianceService.enableRetries(4, 30);
    testReplaceAttachmnetParametersByNameWOptions();

    complianceService.disableRetries();
    testReplaceAttachmnetParametersByNameWOptions();
  }

  // Test the replaceAttachmnetParametersByName operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceAttachmnetParametersByNameNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.replaceAttachmnetParametersByName(null).execute();
  }

  // Test the createCustomControlLibrary operation with a valid options model parameter
  @Test
  public void testCreateCustomControlLibraryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"account_id\": \"accountId\", \"control_library_name\": \"controlLibraryName\", \"control_library_description\": \"controlLibraryDescription\", \"control_library_type\": \"predefined\", \"version_group_label\": \"versionGroupLabel\", \"control_library_version\": \"controlLibraryVersion\", \"latest\": true, \"controls_count\": 13, \"controls\": [{\"control_name\": \"controlName\", \"control_id\": \"controlId\", \"control_description\": \"controlDescription\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_severity\": \"controlSeverity\", \"control_tags\": [\"controlTags\"], \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"user\", \"component_id\": \"componentId\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"assessmentId\", \"assessment_method\": \"assessmentMethod\", \"assessment_type\": \"assessmentType\", \"assessment_description\": \"assessmentDescription\", \"parameter_count\": 14, \"parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}]}], \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"status\": \"enabled\"}]}";
    String createCustomControlLibraryPath = "/instances/testString/v3/control_libraries";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ParameterInfo model
    ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
      .parameterName("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .build();

    // Construct an instance of the ImplementationPayload model
    ImplementationPayload implementationPayloadModel = new ImplementationPayload.Builder()
      .assessmentId("testString")
      .assessmentMethod("testString")
      .assessmentType("testString")
      .assessmentDescription("testString")
      .parameterCount(Long.valueOf("26"))
      .parameters(java.util.Arrays.asList(parameterInfoModel))
      .build();

    // Construct an instance of the ControlSpecifications model
    ControlSpecifications controlSpecificationsModel = new ControlSpecifications.Builder()
      .id("testString")
      .responsibility("user")
      .componentId("testString")
      .environment("testString")
      .description("testString")
      .assessmentsCount(Long.valueOf("26"))
      .assessments(java.util.Arrays.asList(implementationPayloadModel))
      .build();

    // Construct an instance of the ControlDocs model
    ControlDocs controlDocsModel = new ControlDocs.Builder()
      .controlDocsId("testString")
      .controlDocsType("testString")
      .build();

    // Construct an instance of the ControlsInControlLibRequestPayload model
    ControlsInControlLibRequestPayload controlsInControlLibRequestPayloadModel = new ControlsInControlLibRequestPayload.Builder()
      .controlName("testString")
      .controlId("testString")
      .controlDescription("testString")
      .controlCategory("testString")
      .controlParent("testString")
      .controlSeverity("testString")
      .controlTags(java.util.Arrays.asList("testString"))
      .controlSpecifications(java.util.Arrays.asList(controlSpecificationsModel))
      .controlDocs(controlDocsModel)
      .status("enabled")
      .build();

    // Construct an instance of the CreateCustomControlLibraryOptions model
    CreateCustomControlLibraryOptions createCustomControlLibraryOptionsModel = new CreateCustomControlLibraryOptions.Builder()
      .instanceId("testString")
      .id("testString")
      .accountId("testString")
      .controlLibraryName("testString")
      .controlLibraryDescription("testString")
      .controlLibraryType("predefined")
      .versionGroupLabel("testString")
      .controlLibraryVersion("testString")
      .latest(true)
      .controlsCount(Long.valueOf("26"))
      .controls(java.util.Arrays.asList(controlsInControlLibRequestPayloadModel))
      .transactionId("testString")
      .build();

    // Invoke createCustomControlLibrary() with a valid options model and verify the result
    Response<ControlLibraryRequest> response = complianceService.createCustomControlLibrary(createCustomControlLibraryOptionsModel).execute();
    assertNotNull(response);
    ControlLibraryRequest responseObj = response.getResult();
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
    complianceService.enableRetries(4, 30);
    testCreateCustomControlLibraryWOptions();

    complianceService.disableRetries();
    testCreateCustomControlLibraryWOptions();
  }

  // Test the createCustomControlLibrary operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCustomControlLibraryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.createCustomControlLibrary(null).execute();
  }

  // Test the listControlLibraries operation with a valid options model parameter
  @Test
  public void testListControlLibrariesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_count\": 1, \"limit\": 20, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"control_libraries\": [{\"id\": \"id\", \"account_id\": \"accountId\", \"control_library_name\": \"controlLibraryName\", \"control_library_description\": \"controlLibraryDescription\", \"control_library_type\": \"controlLibraryType\", \"created_on\": \"createdOn\", \"created_by\": \"createdBy\", \"updated_on\": \"updatedOn\", \"updated_by\": \"updatedBy\", \"version_group_label\": \"versionGroupLabel\", \"control_library_version\": \"controlLibraryVersion\", \"latest\": true, \"controls_count\": 13}]}";
    String listControlLibrariesPath = "/instances/testString/v3/control_libraries";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListControlLibrariesOptions model
    ListControlLibrariesOptions listControlLibrariesOptionsModel = new ListControlLibrariesOptions.Builder()
      .instanceId("testString")
      .transactionId("testString")
      .build();

    // Invoke listControlLibraries() with a valid options model and verify the result
    Response<GetAllControlLibrariesRespBody> response = complianceService.listControlLibraries(listControlLibrariesOptionsModel).execute();
    assertNotNull(response);
    GetAllControlLibrariesRespBody responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listControlLibrariesPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listControlLibraries operation with and without retries enabled
  @Test
  public void testListControlLibrariesWRetries() throws Throwable {
    complianceService.enableRetries(4, 30);
    testListControlLibrariesWOptions();

    complianceService.disableRetries();
    testListControlLibrariesWOptions();
  }

  // Test the listControlLibraries operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListControlLibrariesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.listControlLibraries(null).execute();
  }

  // Test the replaceCustomControlLibrary operation with a valid options model parameter
  @Test
  public void testReplaceCustomControlLibraryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"account_id\": \"accountId\", \"control_library_name\": \"controlLibraryName\", \"control_library_description\": \"controlLibraryDescription\", \"control_library_type\": \"predefined\", \"version_group_label\": \"versionGroupLabel\", \"control_library_version\": \"controlLibraryVersion\", \"latest\": true, \"controls_count\": 13, \"controls\": [{\"control_name\": \"controlName\", \"control_id\": \"controlId\", \"control_description\": \"controlDescription\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_severity\": \"controlSeverity\", \"control_tags\": [\"controlTags\"], \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"user\", \"component_id\": \"componentId\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"assessmentId\", \"assessment_method\": \"assessmentMethod\", \"assessment_type\": \"assessmentType\", \"assessment_description\": \"assessmentDescription\", \"parameter_count\": 14, \"parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}]}], \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"status\": \"enabled\"}]}";
    String replaceCustomControlLibraryPath = "/instances/testString/v3/control_libraries/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ParameterInfo model
    ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
      .parameterName("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .build();

    // Construct an instance of the ImplementationPayload model
    ImplementationPayload implementationPayloadModel = new ImplementationPayload.Builder()
      .assessmentId("testString")
      .assessmentMethod("testString")
      .assessmentType("testString")
      .assessmentDescription("testString")
      .parameterCount(Long.valueOf("26"))
      .parameters(java.util.Arrays.asList(parameterInfoModel))
      .build();

    // Construct an instance of the ControlSpecifications model
    ControlSpecifications controlSpecificationsModel = new ControlSpecifications.Builder()
      .id("testString")
      .responsibility("user")
      .componentId("testString")
      .environment("testString")
      .description("testString")
      .assessmentsCount(Long.valueOf("26"))
      .assessments(java.util.Arrays.asList(implementationPayloadModel))
      .build();

    // Construct an instance of the ControlDocs model
    ControlDocs controlDocsModel = new ControlDocs.Builder()
      .controlDocsId("testString")
      .controlDocsType("testString")
      .build();

    // Construct an instance of the ControlsInControlLibRequestPayload model
    ControlsInControlLibRequestPayload controlsInControlLibRequestPayloadModel = new ControlsInControlLibRequestPayload.Builder()
      .controlName("testString")
      .controlId("testString")
      .controlDescription("testString")
      .controlCategory("testString")
      .controlParent("testString")
      .controlSeverity("testString")
      .controlTags(java.util.Arrays.asList("testString"))
      .controlSpecifications(java.util.Arrays.asList(controlSpecificationsModel))
      .controlDocs(controlDocsModel)
      .status("enabled")
      .build();

    // Construct an instance of the ReplaceCustomControlLibraryOptions model
    ReplaceCustomControlLibraryOptions replaceCustomControlLibraryOptionsModel = new ReplaceCustomControlLibraryOptions.Builder()
      .controlLibrariesId("testString")
      .instanceId("testString")
      .id("testString")
      .accountId("testString")
      .controlLibraryName("testString")
      .controlLibraryDescription("testString")
      .controlLibraryType("predefined")
      .versionGroupLabel("testString")
      .controlLibraryVersion("testString")
      .latest(true)
      .controlsCount(Long.valueOf("26"))
      .controls(java.util.Arrays.asList(controlsInControlLibRequestPayloadModel))
      .transactionId("testString")
      .build();

    // Invoke replaceCustomControlLibrary() with a valid options model and verify the result
    Response<ControlLibraryRequest> response = complianceService.replaceCustomControlLibrary(replaceCustomControlLibraryOptionsModel).execute();
    assertNotNull(response);
    ControlLibraryRequest responseObj = response.getResult();
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
    complianceService.enableRetries(4, 30);
    testReplaceCustomControlLibraryWOptions();

    complianceService.disableRetries();
    testReplaceCustomControlLibraryWOptions();
  }

  // Test the replaceCustomControlLibrary operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceCustomControlLibraryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.replaceCustomControlLibrary(null).execute();
  }

  // Test the getControlLibrary operation with a valid options model parameter
  @Test
  public void testGetControlLibraryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"account_id\": \"accountId\", \"control_library_name\": \"controlLibraryName\", \"control_library_description\": \"controlLibraryDescription\", \"control_library_type\": \"predefined\", \"version_group_label\": \"versionGroupLabel\", \"control_library_version\": \"controlLibraryVersion\", \"latest\": true, \"controls_count\": 13, \"controls\": [{\"control_name\": \"controlName\", \"control_id\": \"controlId\", \"control_description\": \"controlDescription\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_severity\": \"controlSeverity\", \"control_tags\": [\"controlTags\"], \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"user\", \"component_id\": \"componentId\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"assessmentId\", \"assessment_method\": \"assessmentMethod\", \"assessment_type\": \"assessmentType\", \"assessment_description\": \"assessmentDescription\", \"parameter_count\": 14, \"parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}]}], \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"status\": \"enabled\"}]}";
    String getControlLibraryPath = "/instances/testString/v3/control_libraries/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetControlLibraryOptions model
    GetControlLibraryOptions getControlLibraryOptionsModel = new GetControlLibraryOptions.Builder()
      .controlLibrariesId("testString")
      .instanceId("testString")
      .transactionId("testString")
      .build();

    // Invoke getControlLibrary() with a valid options model and verify the result
    Response<ControlLibraryRequest> response = complianceService.getControlLibrary(getControlLibraryOptionsModel).execute();
    assertNotNull(response);
    ControlLibraryRequest responseObj = response.getResult();
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
    complianceService.enableRetries(4, 30);
    testGetControlLibraryWOptions();

    complianceService.disableRetries();
    testGetControlLibraryWOptions();
  }

  // Test the getControlLibrary operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetControlLibraryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.getControlLibrary(null).execute();
  }

  // Test the deleteCustomControllibrary operation with a valid options model parameter
  @Test
  public void testDeleteCustomControllibraryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"account_id\": \"accountId\", \"control_library_name\": \"controlLibraryName\", \"control_library_description\": \"controlLibraryDescription\", \"control_library_type\": \"predefined\", \"version_group_label\": \"versionGroupLabel\", \"control_library_version\": \"controlLibraryVersion\", \"latest\": true, \"controls_count\": 13, \"controls\": [{\"control_name\": \"controlName\", \"control_id\": \"controlId\", \"control_description\": \"controlDescription\", \"control_category\": \"controlCategory\", \"control_parent\": \"controlParent\", \"control_severity\": \"controlSeverity\", \"control_tags\": [\"controlTags\"], \"control_specifications\": [{\"id\": \"id\", \"responsibility\": \"user\", \"component_id\": \"componentId\", \"environment\": \"environment\", \"description\": \"description\", \"assessments_count\": 16, \"assessments\": [{\"assessment_id\": \"assessmentId\", \"assessment_method\": \"assessmentMethod\", \"assessment_type\": \"assessmentType\", \"assessment_description\": \"assessmentDescription\", \"parameter_count\": 14, \"parameters\": [{\"parameter_name\": \"parameterName\", \"parameter_display_name\": \"parameterDisplayName\", \"parameter_type\": \"numeric\"}]}]}], \"control_docs\": {\"control_docs_id\": \"controlDocsId\", \"control_docs_type\": \"controlDocsType\"}, \"status\": \"enabled\"}]}";
    String deleteCustomControllibraryPath = "/instances/testString/v3/control_libraries/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteCustomControllibraryOptions model
    DeleteCustomControllibraryOptions deleteCustomControllibraryOptionsModel = new DeleteCustomControllibraryOptions.Builder()
      .controlLibrariesId("testString")
      .instanceId("testString")
      .transactionId("testString")
      .build();

    // Invoke deleteCustomControllibrary() with a valid options model and verify the result
    Response<ControlLibraryRequest> response = complianceService.deleteCustomControllibrary(deleteCustomControllibraryOptionsModel).execute();
    assertNotNull(response);
    ControlLibraryRequest responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteCustomControllibraryPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteCustomControllibrary operation with and without retries enabled
  @Test
  public void testDeleteCustomControllibraryWRetries() throws Throwable {
    complianceService.enableRetries(4, 30);
    testDeleteCustomControllibraryWOptions();

    complianceService.disableRetries();
    testDeleteCustomControllibraryWOptions();
  }

  // Test the deleteCustomControllibrary operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCustomControllibraryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.deleteCustomControllibrary(null).execute();
  }

  // Test the createScan operation with a valid options model parameter
  @Test
  public void testCreateScanWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"account_id\": \"accountId\", \"attachment_id\": \"attachmentId\", \"report_id\": \"reportId\", \"status\": \"status\", \"last_scan_time\": \"lastScanTime\", \"next_scan_time\": \"nextScanTime\", \"scan_type\": \"scanType\", \"occurence\": 9}";
    String createScanPath = "/instances/testString/v3/scans";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateScanOptions model
    CreateScanOptions createScanOptionsModel = new CreateScanOptions.Builder()
      .instanceId("testString")
      .attachmentId("testString")
      .transactionId("testString")
      .build();

    // Invoke createScan() with a valid options model and verify the result
    Response<CreateScanResponse> response = complianceService.createScan(createScanOptionsModel).execute();
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
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createScan operation with and without retries enabled
  @Test
  public void testCreateScanWRetries() throws Throwable {
    complianceService.enableRetries(4, 30);
    testCreateScanWOptions();

    complianceService.disableRetries();
    testCreateScanWOptions();
  }

  // Test the createScan operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateScanNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    complianceService.createScan(null).execute();
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
    complianceService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    complianceService = Compliance.newInstance(serviceName);
    String url = server.url("/").toString();
    complianceService.setServiceUrl(url);
  }
}