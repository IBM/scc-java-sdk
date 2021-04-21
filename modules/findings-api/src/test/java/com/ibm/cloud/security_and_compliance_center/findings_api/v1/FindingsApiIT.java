// /*
//  * (C) Copyright IBM Corp. 2021.
//  *
//  * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
//  * the License. You may obtain a copy of the License at
//  *
//  * http://www.apache.org/licenses/LICENSE-2.0
//  *
//  * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
//  * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
//  * specific language governing permissions and limitations under the License.
//  */

package com.ibm.cloud.security_and_compliance_center.findings_api.v1;

// import static org.testng.Assert.assertEquals;
// import static org.testng.Assert.assertFalse;
// import static org.testng.Assert.assertNotNull;
// import static org.testng.Assert.fail;

// import java.io.InputStream;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import com.ibm.cloud.sdk.core.http.Response;
// import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
// import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
// import com.ibm.cloud.sdk.core.util.CredentialUtils;
// import com.ibm.cloud.sdk.core.util.DateUtils;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.ApiListNoteOccurrencesResponse;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.ApiListNotesResponse;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.ApiListOccurrencesResponse;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.ApiListProvidersResponse;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.ApiNote;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.ApiNoteRelatedUrl;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.ApiOccurrence;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.Card;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.CardElement;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.CardElementTimeSeriesCardElement;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.Context;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.CreateNoteOptions;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.CreateOccurrenceOptions;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.DataTransferred;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.DeleteNoteOptions;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.DeleteOccurrenceOptions;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.Finding;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.FindingType;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.GetNoteOptions;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.GetOccurrenceNoteOptions;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.GetOccurrenceOptions;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.Kpi;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.KpiType;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.ListNoteOccurrencesOptions;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.ListNotesOptions;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.ListOccurrencesOptions;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.ListProvidersOptions;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.NetworkConnection;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.PostGraphOptions;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.RemediationStep;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.Reporter;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.Section;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.SocketAddress;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.UpdateNoteOptions;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.UpdateOccurrenceOptions;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.ValueType;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.ValueTypeFindingCountValueType;
// import com.ibm.cloud.security_and_compliance_center.findings_api.v1.utils.TestUtilities;
// import com.ibm.cloud.security_and_compliance_center.test.SdkIntegrationTestBase;

// import org.testng.annotations.AfterClass;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.Test;

// /**
//  * Integration test class for the FindingsApi service.
//  */
// public class FindingsApiIT extends SdkIntegrationTestBase {
//   public FindingsApi service = null;
//   public static Map<String, String> config = null;
//   final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
//   final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
//   /**
//    * This method provides our config filename to the base class.
//    */

//   public String getConfigFilename() {
//     return "../../findings_api_v1.env";
//   }

//   @BeforeClass
//   public void constructService() {
//     // Ask super if we should skip the tests.
//     if (skipTests()) {
//       return;
//     }

//     service = FindingsApi.newInstance();
//     assertNotNull(service);
//     assertNotNull(service.getServiceUrl());

//     // Load up our test-specific config properties.
//     config = CredentialUtils.getServiceProperties(FindingsApi.DEFAULT_SERVICE_NAME);
//     assertNotNull(config);
//     assertFalse(config.isEmpty());
//     assertEquals(service.getServiceUrl(), config.get("URL"));

//     System.out.println("Setup complete.");
//   }

//   @Test
//   public void testPostGraph() throws Exception {
//     try {
//       PostGraphOptions postGraphOptions = new PostGraphOptions.Builder()
//       .accountId("testString")
//       .body(TestUtilities.createMockStream("This is a mock file."))
//       .contentType("application/json")
//       .transactionId("testString")
//       .build();

//       // Invoke operation
//       Response<Void> response = service.postGraph(postGraphOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//         fail(String.format("Service returned status code %d: %s\nError details: %s",
//           e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
//     }
//   }

//   @Test
//   public void testCreateNote() throws Exception {
//     try {
//       Reporter reporterModel = new Reporter.Builder()
//       .id("testString")
//       .title("testString")
//       .url("testString")
//       .build();

//       ApiNoteRelatedUrl apiNoteRelatedUrlModel = new ApiNoteRelatedUrl.Builder()
//       .label("testString")
//       .url("testString")
//       .build();

//       RemediationStep remediationStepModel = new RemediationStep.Builder()
//       .title("testString")
//       .url("testString")
//       .build();

//       FindingType findingTypeModel = new FindingType.Builder()
//       .severity("LOW")
//       .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
//       .build();

//       KpiType kpiTypeModel = new KpiType.Builder()
//       .aggregationType("SUM")
//       .build();

//       ValueTypeFindingCountValueType valueTypeModel = new ValueTypeFindingCountValueType.Builder()
//       .kind("FINDING_COUNT")
//       .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       .text("testString")
//       .build();

//       CardElementTimeSeriesCardElement cardElementModel = new CardElementTimeSeriesCardElement.Builder()
//       .text("testString")
//       .defaultInterval("testString")
//       .kind("TIME_SERIES")
//       .defaultTimeRange("1d")
//       .valueTypes(new java.util.ArrayList<ValueType>(java.util.Arrays.asList(valueTypeModel)))
//       .build();

//       Card cardModel = new Card.Builder()
//       .section("testString")
//       .title("testString")
//       .subtitle("testString")
//       .order(Long.valueOf("1"))
//       .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       .requiresConfiguration(true)
//       .badgeText("testString")
//       .badgeImage("testString")
//       .elements(new java.util.ArrayList<CardElement>(java.util.Arrays.asList(cardElementModel)))
//       .build();

//       Section sectionModel = new Section.Builder()
//       .title("testString")
//       .image("testString")
//       .build();

//       CreateNoteOptions createNoteOptions = new CreateNoteOptions.Builder()
//       .accountId("testString")
//       .providerId("testString")
//       .shortDescription("testString")
//       .longDescription("testString")
//       .kind("FINDING")
//       .id("testString")
//       .reportedBy(reporterModel)
//       .relatedUrl(new java.util.ArrayList<ApiNoteRelatedUrl>(java.util.Arrays.asList(apiNoteRelatedUrlModel)))
//       .expirationTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       .createTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       .updateTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       .shared(true)
//       .finding(findingTypeModel)
//       .kpi(kpiTypeModel)
//       .card(cardModel)
//       .section(sectionModel)
//       .transactionId("testString")
//       .build();

//       // Invoke operation
//       Response<ApiNote> response = service.createNote(createNoteOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);

//       ApiNote apiNoteResult = response.getResult();

//       assertNotNull(apiNoteResult);
//     } catch (ServiceResponseException e) {
//         fail(String.format("Service returned status code %d: %s\nError details: %s",
//           e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
//     }
//   }

//   @Test
//   public void testListNotes() throws Exception {
//     try {
//       ListNotesOptions listNotesOptions = new ListNotesOptions.Builder()
//       .accountId("testString")
//       .providerId("testString")
//       .transactionId("testString")
//       .pageSize(Long.valueOf("2"))
//       .pageToken("testString")
//       .build();

//       // Invoke operation
//       Response<ApiListNotesResponse> response = service.listNotes(listNotesOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);

//       ApiListNotesResponse apiListNotesResponseResult = response.getResult();

//       assertNotNull(apiListNotesResponseResult);
//     } catch (ServiceResponseException e) {
//         fail(String.format("Service returned status code %d: %s\nError details: %s",
//           e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
//     }
//   }

//   @Test
//   public void testGetNote() throws Exception {
//     try {
//       GetNoteOptions getNoteOptions = new GetNoteOptions.Builder()
//       .accountId("testString")
//       .providerId("testString")
//       .noteId("testString")
//       .transactionId("testString")
//       .build();

//       // Invoke operation
//       Response<ApiNote> response = service.getNote(getNoteOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);

//       ApiNote apiNoteResult = response.getResult();

//       assertNotNull(apiNoteResult);
//     } catch (ServiceResponseException e) {
//         fail(String.format("Service returned status code %d: %s\nError details: %s",
//           e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
//     }
//   }

//   @Test
//   public void testUpdateNote() throws Exception {
//     try {
//       Reporter reporterModel = new Reporter.Builder()
//       .id("testString")
//       .title("testString")
//       .url("testString")
//       .build();

//       ApiNoteRelatedUrl apiNoteRelatedUrlModel = new ApiNoteRelatedUrl.Builder()
//       .label("testString")
//       .url("testString")
//       .build();

//       RemediationStep remediationStepModel = new RemediationStep.Builder()
//       .title("testString")
//       .url("testString")
//       .build();

//       FindingType findingTypeModel = new FindingType.Builder()
//       .severity("LOW")
//       .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
//       .build();

//       KpiType kpiTypeModel = new KpiType.Builder()
//       .aggregationType("SUM")
//       .build();

//       ValueTypeFindingCountValueType valueTypeModel = new ValueTypeFindingCountValueType.Builder()
//       .kind("FINDING_COUNT")
//       .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       .text("testString")
//       .build();

//       CardElementTimeSeriesCardElement cardElementModel = new CardElementTimeSeriesCardElement.Builder()
//       .text("testString")
//       .defaultInterval("testString")
//       .kind("TIME_SERIES")
//       .defaultTimeRange("1d")
//       .valueTypes(new java.util.ArrayList<ValueType>(java.util.Arrays.asList(valueTypeModel)))
//       .build();

//       Card cardModel = new Card.Builder()
//       .section("testString")
//       .title("testString")
//       .subtitle("testString")
//       .order(Long.valueOf("1"))
//       .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       .requiresConfiguration(true)
//       .badgeText("testString")
//       .badgeImage("testString")
//       .elements(new java.util.ArrayList<CardElement>(java.util.Arrays.asList(cardElementModel)))
//       .build();

//       Section sectionModel = new Section.Builder()
//       .title("testString")
//       .image("testString")
//       .build();

//       UpdateNoteOptions updateNoteOptions = new UpdateNoteOptions.Builder()
//       .accountId("testString")
//       .providerId("testString")
//       .noteId("testString")
//       .shortDescription("testString")
//       .longDescription("testString")
//       .kind("FINDING")
//       .id("testString")
//       .reportedBy(reporterModel)
//       .relatedUrl(new java.util.ArrayList<ApiNoteRelatedUrl>(java.util.Arrays.asList(apiNoteRelatedUrlModel)))
//       .expirationTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       .createTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       .updateTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       .shared(true)
//       .finding(findingTypeModel)
//       .kpi(kpiTypeModel)
//       .card(cardModel)
//       .section(sectionModel)
//       .transactionId("testString")
//       .build();

//       // Invoke operation
//       Response<ApiNote> response = service.updateNote(updateNoteOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);

//       ApiNote apiNoteResult = response.getResult();

//       assertNotNull(apiNoteResult);
//     } catch (ServiceResponseException e) {
//         fail(String.format("Service returned status code %d: %s\nError details: %s",
//           e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
//     }
//   }

//   @Test
//   public void testGetOccurrenceNote() throws Exception {
//     try {
//       GetOccurrenceNoteOptions getOccurrenceNoteOptions = new GetOccurrenceNoteOptions.Builder()
//       .accountId("testString")
//       .providerId("testString")
//       .occurrenceId("testString")
//       .transactionId("testString")
//       .build();

//       // Invoke operation
//       Response<ApiNote> response = service.getOccurrenceNote(getOccurrenceNoteOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);

//       ApiNote apiNoteResult = response.getResult();

//       assertNotNull(apiNoteResult);
//     } catch (ServiceResponseException e) {
//         fail(String.format("Service returned status code %d: %s\nError details: %s",
//           e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
//     }
//   }

//   @Test
//   public void testCreateOccurrence() throws Exception {
//     try {
//       Context contextModel = new Context.Builder()
//       .region("testString")
//       .resourceCrn("testString")
//       .resourceId("testString")
//       .resourceName("testString")
//       .resourceType("testString")
//       .serviceCrn("testString")
//       .serviceName("testString")
//       .environmentName("testString")
//       .componentName("testString")
//       .toolchainId("testString")
//       .build();

//       RemediationStep remediationStepModel = new RemediationStep.Builder()
//       .title("testString")
//       .url("testString")
//       .build();

//       SocketAddress socketAddressModel = new SocketAddress.Builder()
//       .address("testString")
//       .port(Long.valueOf("26"))
//       .build();

//       NetworkConnection networkConnectionModel = new NetworkConnection.Builder()
//       .direction("testString")
//       .protocol("testString")
//       .client(socketAddressModel)
//       .server(socketAddressModel)
//       .build();

//       DataTransferred dataTransferredModel = new DataTransferred.Builder()
//       .clientBytes(Long.valueOf("26"))
//       .serverBytes(Long.valueOf("26"))
//       .clientPackets(Long.valueOf("26"))
//       .serverPackets(Long.valueOf("26"))
//       .build();

//       Finding findingModel = new Finding.Builder()
//       .severity("LOW")
//       .certainty("LOW")
//       .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
//       .networkConnection(networkConnectionModel)
//       .dataTransferred(dataTransferredModel)
//       .build();

//       Kpi kpiModel = new Kpi.Builder()
//       .value(Double.valueOf("72.5"))
//       .total(Double.valueOf("72.5"))
//       .build();

//       CreateOccurrenceOptions createOccurrenceOptions = new CreateOccurrenceOptions.Builder()
//       .accountId("testString")
//       .providerId("testString")
//       .noteName("testString")
//       .kind("FINDING")
//       .id("testString")
//       .resourceUrl("testString")
//       .remediation("testString")
//       .createTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       .updateTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       .context(contextModel)
//       .finding(findingModel)
//       .kpi(kpiModel)
//       .referenceData(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
//       .replaceIfExists(true)
//       .transactionId("testString")
//       .build();

//       // Invoke operation
//       Response<ApiOccurrence> response = service.createOccurrence(createOccurrenceOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);

//       ApiOccurrence apiOccurrenceResult = response.getResult();

//       assertNotNull(apiOccurrenceResult);
//     } catch (ServiceResponseException e) {
//         fail(String.format("Service returned status code %d: %s\nError details: %s",
//           e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
//     }
//   }

//   @Test
//   public void testListOccurrences() throws Exception {
//     try {
//       ListOccurrencesOptions listOccurrencesOptions = new ListOccurrencesOptions.Builder()
//       .accountId("testString")
//       .providerId("testString")
//       .transactionId("testString")
//       .pageSize(Long.valueOf("2"))
//       .pageToken("testString")
//       .build();

//       // Invoke operation
//       Response<ApiListOccurrencesResponse> response = service.listOccurrences(listOccurrencesOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);

//       ApiListOccurrencesResponse apiListOccurrencesResponseResult = response.getResult();

//       assertNotNull(apiListOccurrencesResponseResult);
//     } catch (ServiceResponseException e) {
//         fail(String.format("Service returned status code %d: %s\nError details: %s",
//           e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
//     }
//   }

//   @Test
//   public void testListNoteOccurrences() throws Exception {
//     try {
//       ListNoteOccurrencesOptions listNoteOccurrencesOptions = new ListNoteOccurrencesOptions.Builder()
//       .accountId("testString")
//       .providerId("testString")
//       .noteId("testString")
//       .transactionId("testString")
//       .pageSize(Long.valueOf("2"))
//       .pageToken("testString")
//       .build();

//       // Invoke operation
//       Response<ApiListNoteOccurrencesResponse> response = service.listNoteOccurrences(listNoteOccurrencesOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);

//       ApiListNoteOccurrencesResponse apiListNoteOccurrencesResponseResult = response.getResult();

//       assertNotNull(apiListNoteOccurrencesResponseResult);
//     } catch (ServiceResponseException e) {
//         fail(String.format("Service returned status code %d: %s\nError details: %s",
//           e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
//     }
//   }

//   @Test
//   public void testGetOccurrence() throws Exception {
//     try {
//       GetOccurrenceOptions getOccurrenceOptions = new GetOccurrenceOptions.Builder()
//       .accountId("testString")
//       .providerId("testString")
//       .occurrenceId("testString")
//       .transactionId("testString")
//       .build();

//       // Invoke operation
//       Response<ApiListOccurrencesResponse> response = service.getOccurrence(getOccurrenceOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);

//       ApiListOccurrencesResponse apiListOccurrencesResponseResult = response.getResult();

//       assertNotNull(apiListOccurrencesResponseResult);
//     } catch (ServiceResponseException e) {
//         fail(String.format("Service returned status code %d: %s\nError details: %s",
//           e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
//     }
//   }

//   @Test
//   public void testUpdateOccurrence() throws Exception {
//     try {
//       Context contextModel = new Context.Builder()
//       .region("testString")
//       .resourceCrn("testString")
//       .resourceId("testString")
//       .resourceName("testString")
//       .resourceType("testString")
//       .serviceCrn("testString")
//       .serviceName("testString")
//       .environmentName("testString")
//       .componentName("testString")
//       .toolchainId("testString")
//       .build();

//       RemediationStep remediationStepModel = new RemediationStep.Builder()
//       .title("testString")
//       .url("testString")
//       .build();

//       SocketAddress socketAddressModel = new SocketAddress.Builder()
//       .address("testString")
//       .port(Long.valueOf("26"))
//       .build();

//       NetworkConnection networkConnectionModel = new NetworkConnection.Builder()
//       .direction("testString")
//       .protocol("testString")
//       .client(socketAddressModel)
//       .server(socketAddressModel)
//       .build();

//       DataTransferred dataTransferredModel = new DataTransferred.Builder()
//       .clientBytes(Long.valueOf("26"))
//       .serverBytes(Long.valueOf("26"))
//       .clientPackets(Long.valueOf("26"))
//       .serverPackets(Long.valueOf("26"))
//       .build();

//       Finding findingModel = new Finding.Builder()
//       .severity("LOW")
//       .certainty("LOW")
//       .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
//       .networkConnection(networkConnectionModel)
//       .dataTransferred(dataTransferredModel)
//       .build();

//       Kpi kpiModel = new Kpi.Builder()
//       .value(Double.valueOf("72.5"))
//       .total(Double.valueOf("72.5"))
//       .build();

//       UpdateOccurrenceOptions updateOccurrenceOptions = new UpdateOccurrenceOptions.Builder()
//       .accountId("testString")
//       .providerId("testString")
//       .occurrenceId("testString")
//       .noteName("testString")
//       .kind("FINDING")
//       .id("testString")
//       .resourceUrl("testString")
//       .remediation("testString")
//       .createTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       .updateTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       .context(contextModel)
//       .finding(findingModel)
//       .kpi(kpiModel)
//       .referenceData(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
//       .transactionId("testString")
//       .build();

//       // Invoke operation
//       Response<ApiOccurrence> response = service.updateOccurrence(updateOccurrenceOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);

//       ApiOccurrence apiOccurrenceResult = response.getResult();

//       assertNotNull(apiOccurrenceResult);
//     } catch (ServiceResponseException e) {
//         fail(String.format("Service returned status code %d: %s\nError details: %s",
//           e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
//     }
//   }

//   @Test
//   public void testListProviders() throws Exception {
//     try {
//       ListProvidersOptions listProvidersOptions = new ListProvidersOptions.Builder()
//       .accountId("testString")
//       .transactionId("testString")
//       .limit(Long.valueOf("2"))
//       .skip(Long.valueOf("26"))
//       .startProviderId("testString")
//       .endProviderId("testString")
//       .build();

//       // Invoke operation
//       Response<ApiListProvidersResponse> response = service.listProviders(listProvidersOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);

//       ApiListProvidersResponse apiListProvidersResponseResult = response.getResult();

//       assertNotNull(apiListProvidersResponseResult);
//     } catch (ServiceResponseException e) {
//         fail(String.format("Service returned status code %d: %s\nError details: %s",
//           e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
//     }
//   }

//   @Test
//   public void testDeleteOccurrence() throws Exception {
//     try {
//       DeleteOccurrenceOptions deleteOccurrenceOptions = new DeleteOccurrenceOptions.Builder()
//       .accountId("testString")
//       .providerId("testString")
//       .occurrenceId("testString")
//       .transactionId("testString")
//       .build();

//       // Invoke operation
//       Response<Void> response = service.deleteOccurrence(deleteOccurrenceOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//         fail(String.format("Service returned status code %d: %s\nError details: %s",
//           e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
//     }
//   }

//   @Test
//   public void testDeleteNote() throws Exception {
//     try {
//       DeleteNoteOptions deleteNoteOptions = new DeleteNoteOptions.Builder()
//       .accountId("testString")
//       .providerId("testString")
//       .noteId("testString")
//       .transactionId("testString")
//       .build();

//       // Invoke operation
//       Response<Void> response = service.deleteNote(deleteNoteOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//         fail(String.format("Service returned status code %d: %s\nError details: %s",
//           e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
//     }
//   }

//   @AfterClass
//   public void tearDown() {
//     // Add any clean up logic here
//     System.out.println("Clean up complete.");
//   }
//  }
