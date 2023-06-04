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
import com.ibm.cloud.scc.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the Compliance service.
 */
public class ComplianceIT extends SdkIntegrationTestBase {
  public Compliance service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "compliance_v2.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = Compliance.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(Compliance.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    service.enableRetries(4, 30);

    System.out.println("Setup complete.");
  }

  @Test
  public void testCreateProfile() throws Exception {
    try {
      ProfileControlsInRequest profileControlsInRequestModel = new ProfileControlsInRequest.Builder()
        .controlLibraryId("testString")
        .controlId("testString")
        .build();

      DefaultParameters defaultParametersModel = new DefaultParameters.Builder()
        .assessmentType("testString")
        .assessmentId("testString")
        .parameterName("testString")
        .parameterDefaultValue("testString")
        .parameterDisplayName("testString")
        .parameterType("numeric")
        .build();

      CreateProfileOptions createProfileOptions = new CreateProfileOptions.Builder()
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

      // Invoke operation
      Response<ProfileResponse> response = service.createProfile(createProfileOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProfileResponse profileResponseResult = response.getResult();

      assertNotNull(profileResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListProfiles() throws Exception {
    try {
      ListProfilesOptions listProfilesOptions = new ListProfilesOptions.Builder()
        .instanceId("testString")
        .transactionId("testString")
        .build();

      // Invoke operation
      Response<GetAllProfilesRespBody> response = service.listProfiles(listProfilesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      GetAllProfilesRespBody getAllProfilesRespBodyResult = response.getResult();

      assertNotNull(getAllProfilesRespBodyResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testAddProfile() throws Exception {
    try {
      ProfileControlsInRequest profileControlsInRequestModel = new ProfileControlsInRequest.Builder()
        .controlLibraryId("testString")
        .controlId("testString")
        .build();

      DefaultParameters defaultParametersModel = new DefaultParameters.Builder()
        .assessmentType("testString")
        .assessmentId("testString")
        .parameterName("testString")
        .parameterDefaultValue("testString")
        .parameterDisplayName("testString")
        .parameterType("numeric")
        .build();

      AddProfileOptions addProfileOptions = new AddProfileOptions.Builder()
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

      // Invoke operation
      Response<ProfileResponse> response = service.addProfile(addProfileOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProfileResponse profileResponseResult = response.getResult();

      assertNotNull(profileResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetProfile() throws Exception {
    try {
      GetProfileOptions getProfileOptions = new GetProfileOptions.Builder()
        .profilesId("testString")
        .instanceId("testString")
        .transactionId("testString")
        .build();

      // Invoke operation
      Response<ProfileResponse> response = service.getProfile(getProfileOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProfileResponse profileResponseResult = response.getResult();

      assertNotNull(profileResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testReplaceProfileParameters() throws Exception {
    try {
      DefaultParameters defaultParametersModel = new DefaultParameters.Builder()
        .assessmentType("testString")
        .assessmentId("testString")
        .parameterName("testString")
        .parameterDefaultValue("testString")
        .parameterDisplayName("testString")
        .parameterType("numeric")
        .build();

      ReplaceProfileParametersOptions replaceProfileParametersOptions = new ReplaceProfileParametersOptions.Builder()
        .profilesId("testString")
        .instanceId("testString")
        .id("testString")
        .defaultParameters(java.util.Arrays.asList(defaultParametersModel))
        .transactionId("testString")
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

  @Test
  public void testCreateAttachment() throws Exception {
    try {
      ScopePayload scopePayloadModel = new ScopePayload.Builder()
        .scopeId("testString")
        .scopeType("testString")
        .build();

      ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
        .parameterName("testString")
        .parameterDisplayName("testString")
        .parameterType("numeric")
        .build();

      ParameterDetails parameterDetailsModel = new ParameterDetails.Builder()
        .parameterName("testString")
        .parameterDisplayName("testString")
        .parameterType("numeric")
        .parameterValue("testString")
        .assessmentType("testString")
        .assessmentId("testString")
        .parameters(java.util.Arrays.asList(parameterInfoModel))
        .build();

      FailedControls failedControlsModel = new FailedControls.Builder()
        .thresholdLimit(Long.valueOf("26"))
        .failedControlIds(java.util.Arrays.asList("testString"))
        .build();

      AttachmentsNotificationsPayload attachmentsNotificationsPayloadModel = new AttachmentsNotificationsPayload.Builder()
        .enabled(true)
        .controls(failedControlsModel)
        .build();

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

      CreateAttachmentOptions createAttachmentOptions = new CreateAttachmentOptions.Builder()
        .profilesId("testString")
        .instanceId("testString")
        .attachments(java.util.Arrays.asList(attachmentPayloadModel))
        .transactionId("testString")
        .build();

      // Invoke operation
      Response<AttachmentProfileResponse> response = service.createAttachment(createAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AttachmentProfileResponse attachmentProfileResponseResult = response.getResult();

      assertNotNull(attachmentProfileResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCheckProfileAttachmnets() throws Exception {
    try {
      CheckProfileAttachmnetsOptions checkProfileAttachmnetsOptions = new CheckProfileAttachmnetsOptions.Builder()
        .profilesId("testString")
        .instanceId("testString")
        .transactionId("testString")
        .build();

      // Invoke operation
      Response<GetAllAttachmnetsForProfileRespBody> response = service.checkProfileAttachmnets(checkProfileAttachmnetsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      GetAllAttachmnetsForProfileRespBody getAllAttachmnetsForProfileRespBodyResult = response.getResult();

      assertNotNull(getAllAttachmnetsForProfileRespBodyResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetProfileAttachmnet() throws Exception {
    try {
      GetProfileAttachmnetOptions getProfileAttachmnetOptions = new GetProfileAttachmnetOptions.Builder()
        .profilesId("testString")
        .attachmentId("testString")
        .instanceId("testString")
        .transactionId("testString")
        .build();

      // Invoke operation
      Response<AttachmentPayload> response = service.getProfileAttachmnet(getProfileAttachmnetOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AttachmentPayload attachmentPayloadResult = response.getResult();

      assertNotNull(attachmentPayloadResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testReplaceProfileAttachment() throws Exception {
    try {
      ScopePayload scopePayloadModel = new ScopePayload.Builder()
        .scopeId("testString")
        .scopeType("testString")
        .build();

      ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
        .parameterName("testString")
        .parameterDisplayName("testString")
        .parameterType("numeric")
        .build();

      ParameterDetails parameterDetailsModel = new ParameterDetails.Builder()
        .parameterName("testString")
        .parameterDisplayName("testString")
        .parameterType("numeric")
        .parameterValue("testString")
        .assessmentType("testString")
        .assessmentId("testString")
        .parameters(java.util.Arrays.asList(parameterInfoModel))
        .build();

      FailedControls failedControlsModel = new FailedControls.Builder()
        .thresholdLimit(Long.valueOf("26"))
        .failedControlIds(java.util.Arrays.asList("testString"))
        .build();

      AttachmentsNotificationsPayload attachmentsNotificationsPayloadModel = new AttachmentsNotificationsPayload.Builder()
        .enabled(true)
        .controls(failedControlsModel)
        .build();

      ReplaceProfileAttachmentOptions replaceProfileAttachmentOptions = new ReplaceProfileAttachmentOptions.Builder()
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

      // Invoke operation
      Response<AttachmentPayload> response = service.replaceProfileAttachment(replaceProfileAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AttachmentPayload attachmentPayloadResult = response.getResult();

      assertNotNull(attachmentPayloadResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListAttachmentParameters() throws Exception {
    try {
      ListAttachmentParametersOptions listAttachmentParametersOptions = new ListAttachmentParametersOptions.Builder()
        .profilesId("testString")
        .attachmentId("testString")
        .instanceId("testString")
        .transactionId("testString")
        .build();

      // Invoke operation
      Response<ParameterDetails> response = service.listAttachmentParameters(listAttachmentParametersOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ParameterDetails parameterDetailsResult = response.getResult();

      assertNotNull(parameterDetailsResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testReplaceAttachment() throws Exception {
    try {
      ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
        .parameterName("testString")
        .parameterDisplayName("testString")
        .parameterType("numeric")
        .build();

      ReplaceAttachmentOptions replaceAttachmentOptions = new ReplaceAttachmentOptions.Builder()
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

      // Invoke operation
      Response<ParameterDetails> response = service.replaceAttachment(replaceAttachmentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ParameterDetails parameterDetailsResult = response.getResult();

      assertNotNull(parameterDetailsResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetParametersByName() throws Exception {
    try {
      GetParametersByNameOptions getParametersByNameOptions = new GetParametersByNameOptions.Builder()
        .profilesId("testString")
        .attachmentId("testString")
        .parameterName("testString")
        .instanceId("testString")
        .transactionId("testString")
        .build();

      // Invoke operation
      Response<ParameterDetails> response = service.getParametersByName(getParametersByNameOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ParameterDetails parameterDetailsResult = response.getResult();

      assertNotNull(parameterDetailsResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testReplaceAttachmnetParametersByName() throws Exception {
    try {
      ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
        .parameterName("testString")
        .parameterDisplayName("testString")
        .parameterType("numeric")
        .build();

      ReplaceAttachmnetParametersByNameOptions replaceAttachmnetParametersByNameOptions = new ReplaceAttachmnetParametersByNameOptions.Builder()
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

      // Invoke operation
      Response<ParameterDetails> response = service.replaceAttachmnetParametersByName(replaceAttachmnetParametersByNameOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ParameterDetails parameterDetailsResult = response.getResult();

      assertNotNull(parameterDetailsResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCreateCustomControlLibrary() throws Exception {
    try {
      ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
        .parameterName("testString")
        .parameterDisplayName("testString")
        .parameterType("numeric")
        .build();

      ImplementationPayload implementationPayloadModel = new ImplementationPayload.Builder()
        .assessmentId("testString")
        .assessmentMethod("testString")
        .assessmentType("testString")
        .assessmentDescription("testString")
        .parameterCount(Long.valueOf("26"))
        .parameters(java.util.Arrays.asList(parameterInfoModel))
        .build();

      ControlSpecifications controlSpecificationsModel = new ControlSpecifications.Builder()
        .id("testString")
        .responsibility("user")
        .componentId("testString")
        .environment("testString")
        .description("testString")
        .assessmentsCount(Long.valueOf("26"))
        .assessments(java.util.Arrays.asList(implementationPayloadModel))
        .build();

      ControlDocs controlDocsModel = new ControlDocs.Builder()
        .controlDocsId("testString")
        .controlDocsType("testString")
        .build();

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

      CreateCustomControlLibraryOptions createCustomControlLibraryOptions = new CreateCustomControlLibraryOptions.Builder()
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

      // Invoke operation
      Response<ControlLibraryRequest> response = service.createCustomControlLibrary(createCustomControlLibraryOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ControlLibraryRequest controlLibraryRequestResult = response.getResult();

      assertNotNull(controlLibraryRequestResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListControlLibraries() throws Exception {
    try {
      ListControlLibrariesOptions listControlLibrariesOptions = new ListControlLibrariesOptions.Builder()
        .instanceId("testString")
        .transactionId("testString")
        .build();

      // Invoke operation
      Response<GetAllControlLibrariesRespBody> response = service.listControlLibraries(listControlLibrariesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      GetAllControlLibrariesRespBody getAllControlLibrariesRespBodyResult = response.getResult();

      assertNotNull(getAllControlLibrariesRespBodyResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testReplaceCustomControlLibrary() throws Exception {
    try {
      ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
        .parameterName("testString")
        .parameterDisplayName("testString")
        .parameterType("numeric")
        .build();

      ImplementationPayload implementationPayloadModel = new ImplementationPayload.Builder()
        .assessmentId("testString")
        .assessmentMethod("testString")
        .assessmentType("testString")
        .assessmentDescription("testString")
        .parameterCount(Long.valueOf("26"))
        .parameters(java.util.Arrays.asList(parameterInfoModel))
        .build();

      ControlSpecifications controlSpecificationsModel = new ControlSpecifications.Builder()
        .id("testString")
        .responsibility("user")
        .componentId("testString")
        .environment("testString")
        .description("testString")
        .assessmentsCount(Long.valueOf("26"))
        .assessments(java.util.Arrays.asList(implementationPayloadModel))
        .build();

      ControlDocs controlDocsModel = new ControlDocs.Builder()
        .controlDocsId("testString")
        .controlDocsType("testString")
        .build();

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

      ReplaceCustomControlLibraryOptions replaceCustomControlLibraryOptions = new ReplaceCustomControlLibraryOptions.Builder()
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

      // Invoke operation
      Response<ControlLibraryRequest> response = service.replaceCustomControlLibrary(replaceCustomControlLibraryOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ControlLibraryRequest controlLibraryRequestResult = response.getResult();

      assertNotNull(controlLibraryRequestResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetControlLibrary() throws Exception {
    try {
      GetControlLibraryOptions getControlLibraryOptions = new GetControlLibraryOptions.Builder()
        .controlLibrariesId("testString")
        .instanceId("testString")
        .transactionId("testString")
        .build();

      // Invoke operation
      Response<ControlLibraryRequest> response = service.getControlLibrary(getControlLibraryOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ControlLibraryRequest controlLibraryRequestResult = response.getResult();

      assertNotNull(controlLibraryRequestResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCreateScan() throws Exception {
    try {
      CreateScanOptions createScanOptions = new CreateScanOptions.Builder()
        .instanceId("testString")
        .attachmentId("testString")
        .transactionId("testString")
        .build();

      // Invoke operation
      Response<CreateScanResponse> response = service.createScan(createScanOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      CreateScanResponse createScanResponseResult = response.getResult();

      assertNotNull(createScanResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteCustomProfile() throws Exception {
    try {
      DeleteCustomProfileOptions deleteCustomProfileOptions = new DeleteCustomProfileOptions.Builder()
        .profilesId("testString")
        .instanceId("testString")
        .transactionId("testString")
        .build();

      // Invoke operation
      Response<ProfileResponse> response = service.deleteCustomProfile(deleteCustomProfileOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ProfileResponse profileResponseResult = response.getResult();

      assertNotNull(profileResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteProfileAttachmnet() throws Exception {
    try {
      DeleteProfileAttachmnetOptions deleteProfileAttachmnetOptions = new DeleteProfileAttachmnetOptions.Builder()
        .profilesId("testString")
        .attachmentId("testString")
        .instanceId("testString")
        .transactionId("testString")
        .build();

      // Invoke operation
      Response<AttachmentPayload> response = service.deleteProfileAttachmnet(deleteProfileAttachmnetOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AttachmentPayload attachmentPayloadResult = response.getResult();

      assertNotNull(attachmentPayloadResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteCustomControllibrary() throws Exception {
    try {
      DeleteCustomControllibraryOptions deleteCustomControllibraryOptions = new DeleteCustomControllibraryOptions.Builder()
        .controlLibrariesId("testString")
        .instanceId("testString")
        .transactionId("testString")
        .build();

      // Invoke operation
      Response<ControlLibraryRequest> response = service.deleteCustomControllibrary(deleteCustomControllibraryOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ControlLibraryRequest controlLibraryRequestResult = response.getResult();

      assertNotNull(controlLibraryRequestResult);
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
