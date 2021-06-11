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

package com.ibm.cloud.scc.findings.v1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;

import com.ibm.cloud.scc.findings.v1.model.ApiListNoteOccurrencesResponse;
import com.ibm.cloud.scc.findings.v1.model.ApiListNotesResponse;
import com.ibm.cloud.scc.findings.v1.model.ApiListOccurrencesResponse;
import com.ibm.cloud.scc.findings.v1.model.ApiListProvidersResponse;
import com.ibm.cloud.scc.findings.v1.model.ApiNote;
import com.ibm.cloud.scc.findings.v1.model.ApiNoteRelatedUrl;
import com.ibm.cloud.scc.findings.v1.model.ApiOccurrence;
import com.ibm.cloud.scc.findings.v1.model.ApiProvider;
import com.ibm.cloud.scc.findings.v1.model.Card;
import com.ibm.cloud.scc.findings.v1.model.CardElement;
import com.ibm.cloud.scc.findings.v1.model.CardElementTimeSeriesCardElement;
import com.ibm.cloud.scc.findings.v1.model.Context;
import com.ibm.cloud.scc.findings.v1.model.CreateNoteOptions;
import com.ibm.cloud.scc.findings.v1.model.CreateOccurrenceOptions;
import com.ibm.cloud.scc.findings.v1.model.DataTransferred;
import com.ibm.cloud.scc.findings.v1.model.DeleteNoteOptions;
import com.ibm.cloud.scc.findings.v1.model.DeleteOccurrenceOptions;
import com.ibm.cloud.scc.findings.v1.model.Finding;
import com.ibm.cloud.scc.findings.v1.model.FindingType;
import com.ibm.cloud.scc.findings.v1.model.GetNoteOptions;
import com.ibm.cloud.scc.findings.v1.model.GetOccurrenceNoteOptions;
import com.ibm.cloud.scc.findings.v1.model.GetOccurrenceOptions;
import com.ibm.cloud.scc.findings.v1.model.Kpi;
import com.ibm.cloud.scc.findings.v1.model.KpiType;
import com.ibm.cloud.scc.findings.v1.model.ListNoteOccurrencesOptions;
import com.ibm.cloud.scc.findings.v1.model.ListNotesOptions;
import com.ibm.cloud.scc.findings.v1.model.ListOccurrencesOptions;
import com.ibm.cloud.scc.findings.v1.model.ListProvidersOptions;
import com.ibm.cloud.scc.findings.v1.model.NetworkConnection;
import com.ibm.cloud.scc.findings.v1.model.PostGraphOptions;
import com.ibm.cloud.scc.findings.v1.model.RemediationStep;
import com.ibm.cloud.scc.findings.v1.model.Reporter;
import com.ibm.cloud.scc.findings.v1.model.Section;
import com.ibm.cloud.scc.findings.v1.model.SocketAddress;
import com.ibm.cloud.scc.findings.v1.model.UpdateNoteOptions;
import com.ibm.cloud.scc.findings.v1.model.UpdateOccurrenceOptions;
import com.ibm.cloud.scc.findings.v1.model.ValueType;
import com.ibm.cloud.scc.findings.v1.model.ValueTypeFindingCountValueType;
import com.ibm.cloud.scc.findings.v1.utils.TestUtilities;
import com.ibm.cloud.scc.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.DateUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.testng.annotations.AfterGroups;

/**
 * Integration test class for the Findings service.
 */
public class FindingsIT extends SdkIntegrationTestBase {
  public Findings service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  /**
   * This method provides our config filename to the base class.
   */

  final String accountID = System.getenv("ACCOUNT_ID");
  String providerID = System.getenv("PROVIDER_ID");
  final String testString = "testString";
  String identifier = System.getenv("TRAVIS_BUILD_NUMBER");

  public String getConfigFilename() {
    return "../../findings_v1.env";
  }

  @BeforeClass
  public void constructService() {

    if(identifier == null){
      identifier = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    if(providerID == null){
      providerID = "sdk-it";
    }

    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = Findings.newInstance(accountID);
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(Findings.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    System.out.println("Setup complete.");
  }

  @Test
  public void testPostGraph() throws Exception {
    try {
      PostGraphOptions postGraphOptions = new PostGraphOptions.Builder()
      .body(TestUtilities.createMockStream("{notes{id}}"))
      .contentType("application/graphql")
      .build();

      // Invoke operation
      Response<Void> response = service.postGraph(postGraphOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCreateNoteFinding() throws Exception {
    try {
      Reporter reporterModel = new Reporter.Builder()
      .id(testString)
      .title(testString)
      .url(testString)
      .build();

      ApiNoteRelatedUrl apiNoteRelatedUrlModel = new ApiNoteRelatedUrl.Builder()
      .label(testString)
      .url(testString)
      .build();

      RemediationStep remediationStepModel = new RemediationStep.Builder()
      .title(testString)
      .url(testString)
      .build();

      FindingType findingTypeModel = new FindingType.Builder()
      .severity("LOW")
      .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
      .build();

      CreateNoteOptions createNoteOptions = new CreateNoteOptions.Builder()
      .providerId(providerID)
      .shortDescription(testString)
      .longDescription(testString)
      .kind("FINDING")
      .id(String.format("finding-note-%s", identifier))
      .reportedBy(reporterModel)
      .relatedUrl(new java.util.ArrayList<ApiNoteRelatedUrl>(java.util.Arrays.asList(apiNoteRelatedUrlModel)))
      .expirationTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .shared(true)
      .finding(findingTypeModel)
      .build();

      // Invoke operation
      Response<ApiNote> response = service.createNote(createNoteOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiNote apiNoteResult = response.getResult();

      assertNotNull(apiNoteResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(groups={"kpi"})
  public void testCreateNoteKpi() throws Exception {
    try {
      Reporter reporterModel = new Reporter.Builder()
      .id(testString)
      .title(testString)
      .url(testString)
      .build();

      KpiType kpiTypeModel = new KpiType.Builder()
      .aggregationType("SUM")
      .build();

      CreateNoteOptions createNoteOptions = new CreateNoteOptions.Builder()
      .providerId(providerID)
      .shortDescription(testString)
      .longDescription(testString)
      .kind("KPI")
      .id(String.format("kpi-note-%s", identifier))
      .reportedBy(reporterModel)
      .expirationTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .shared(true)
      .kpi(kpiTypeModel)
      .build();

      // Invoke operation
      Response<ApiNote> response = service.createNote(createNoteOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiNote apiNoteResult = response.getResult();

      assertNotNull(apiNoteResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCreateNoteCard() throws Exception {
    try {
      Reporter reporterModel = new Reporter.Builder()
      .id(testString)
      .title(testString)
      .url(testString)
      .build();

      ValueTypeFindingCountValueType valueTypeModel = new ValueTypeFindingCountValueType.Builder()
      .kind("FINDING_COUNT")
      .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList(testString)))
      .text(testString)
      .build();

      CardElementTimeSeriesCardElement cardElementModel = new CardElementTimeSeriesCardElement.Builder()
      .text(testString)
      .defaultInterval(testString)
      .kind("TIME_SERIES")
      .defaultTimeRange("1d")
      .valueTypes(new java.util.ArrayList<ValueType>(java.util.Arrays.asList(valueTypeModel)))
      .build();

      Card cardModel = new Card.Builder()
      .section(testString)
      .title(testString)
      .subtitle(testString)
      .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList(String.format("%s/providers/%s/notes/finding-note-%s", accountID, providerID, identifier))))
      .requiresConfiguration(true)
      .badgeText(testString)
      .badgeImage(testString)
      .elements(new java.util.ArrayList<CardElement>(java.util.Arrays.asList(cardElementModel)))
      .build();

      CreateNoteOptions createNoteOptions = new CreateNoteOptions.Builder()
      .providerId(providerID)
      .shortDescription(testString)
      .longDescription(testString)
      .kind("CARD")
      .id(String.format("card-note-%s", identifier))
      .reportedBy(reporterModel)
      .expirationTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .shared(true)
      .card(cardModel)
      .build();

      // Invoke operation
      Response<ApiNote> response = service.createNote(createNoteOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiNote apiNoteResult = response.getResult();

      assertNotNull(apiNoteResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCreateNoteSection() throws Exception {
    try {
      Reporter reporterModel = new Reporter.Builder()
      .id(testString)
      .title(testString)
      .url(testString)
      .build();

      Section sectionModel = new Section.Builder()
      .title(testString)
      .image(testString)
      .build();

      CreateNoteOptions createNoteOptions = new CreateNoteOptions.Builder()
      .providerId(providerID)
      .shortDescription(testString)
      .longDescription(testString)
      .kind("SECTION")
      .id(String.format("section-note-%s", identifier))
      .reportedBy(reporterModel)
      .expirationTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .shared(true)
      .section(sectionModel)
      .build();

      // Invoke operation
      Response<ApiNote> response = service.createNote(createNoteOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiNote apiNoteResult = response.getResult();

      assertNotNull(apiNoteResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }
  @Test
  public void testListNotes() throws Exception {
    try {
      ListNotesOptions listNotesOptions = new ListNotesOptions.Builder()
      .providerId(providerID)
      .build();

      // Invoke operation
      Response<ApiListNotesResponse> response = service.listNotes(listNotesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiListNotesResponse apiListNotesResponseResult = response.getResult();

      assertNotNull(apiListNotesResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(groups={"kpi"})
  public void testGetNote() throws Exception {
    try {
      GetNoteOptions getNoteOptions = new GetNoteOptions.Builder()
      .providerId(providerID)
      .noteId(String.format("kpi-note-%s", identifier))
      .build();

      // Invoke operation
      Response<ApiNote> response = service.getNote(getNoteOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiNote apiNoteResult = response.getResult();

      assertNotNull(apiNoteResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testUpdateNoteFinding() throws Exception {
    try {
      Reporter reporterModel = new Reporter.Builder()
      .id(testString)
      .title(testString)
      .url(testString)
      .build();

      ApiNoteRelatedUrl apiNoteRelatedUrlModel = new ApiNoteRelatedUrl.Builder()
      .label(testString)
      .url(testString)
      .build();

      RemediationStep remediationStepModel = new RemediationStep.Builder()
      .title(testString)
      .url(testString)
      .build();

      FindingType findingTypeModel = new FindingType.Builder()
      .severity("LOW")
      .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
      .build();

      UpdateNoteOptions updateNoteOptions = new UpdateNoteOptions.Builder()
      .providerId(providerID)
      .noteId(String.format("finding-note-%s", identifier))
      .shortDescription(testString)
      .longDescription(testString)
      .kind("FINDING")
      .id(String.format("finding-note-%s", identifier))
      .reportedBy(reporterModel)
      .relatedUrl(new java.util.ArrayList<ApiNoteRelatedUrl>(java.util.Arrays.asList(apiNoteRelatedUrlModel)))
      .expirationTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .shared(true)
      .finding(findingTypeModel)
      .build();

      // Invoke operation
      Response<ApiNote> response = service.updateNote(updateNoteOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiNote apiNoteResult = response.getResult();

      assertNotNull(apiNoteResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(groups={"kpi"})
  public void testUpdateNoteKpi() throws Exception {
    try {
      Reporter reporterModel = new Reporter.Builder()
      .id(testString)
      .title(testString)
      .url(testString)
      .build();

      KpiType kpiTypeModel = new KpiType.Builder()
      .aggregationType("SUM")
      .build();

      UpdateNoteOptions updateNoteOptions = new UpdateNoteOptions.Builder()
      .providerId(providerID)
      .noteId(String.format("kpi-note-%s", identifier))
      .shortDescription(testString)
      .longDescription(testString)
      .kind("KPI")
      .id(String.format("kpi-note-%s", identifier))
      .reportedBy(reporterModel)
      .expirationTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .shared(true)
      .kpi(kpiTypeModel)
      .build();

      // Invoke operation
      Response<ApiNote> response = service.updateNote(updateNoteOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiNote apiNoteResult = response.getResult();

      assertNotNull(apiNoteResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testUpdateNoteCard() throws Exception {
    try {
      Reporter reporterModel = new Reporter.Builder()
      .id(testString)
      .title(testString)
      .url(testString)
      .build();

      ValueTypeFindingCountValueType valueTypeModel = new ValueTypeFindingCountValueType.Builder()
      .kind("FINDING_COUNT")
      .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList(testString)))
      .text(testString)
      .build();

      CardElementTimeSeriesCardElement cardElementModel = new CardElementTimeSeriesCardElement.Builder()
      .text(testString)
      .defaultInterval(testString)
      .kind("TIME_SERIES")
      .defaultTimeRange("1d")
      .valueTypes(new java.util.ArrayList<ValueType>(java.util.Arrays.asList(valueTypeModel)))
      .build();

      Card cardModel = new Card.Builder()
      .section(testString)
      .title(testString)
      .subtitle(testString)
      .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList(testString)))
      .requiresConfiguration(true)
      .badgeText(testString)
      .badgeImage(testString)
      .elements(new java.util.ArrayList<CardElement>(java.util.Arrays.asList(cardElementModel)))
      .build();

      UpdateNoteOptions updateNoteOptions = new UpdateNoteOptions.Builder()
      .providerId(providerID)
      .noteId(String.format("card-note-%s", identifier))
      .shortDescription(testString)
      .longDescription(testString)
      .kind("CARD")
      .id(String.format("card-note-%s", identifier))
      .reportedBy(reporterModel)
      .expirationTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .shared(true)
      .card(cardModel)
      .build();

      // Invoke operation
      Response<ApiNote> response = service.updateNote(updateNoteOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiNote apiNoteResult = response.getResult();

      assertNotNull(apiNoteResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testUpdateNoteSection() throws Exception {
    try {
      Reporter reporterModel = new Reporter.Builder()
      .id(testString)
      .title(testString)
      .url(testString)
      .build();

      Section sectionModel = new Section.Builder()
      .title(testString)
      .image(testString)
      .build();

      UpdateNoteOptions updateNoteOptions = new UpdateNoteOptions.Builder()
      .providerId(providerID)
      .noteId(String.format("section-note-%s", identifier))
      .shortDescription(testString)
      .longDescription(testString)
      .kind("SECTION")
      .id(String.format("section-note-%s", identifier))
      .reportedBy(reporterModel)
      .expirationTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .shared(true)
      .section(sectionModel)
      .build();

      // Invoke operation
      Response<ApiNote> response = service.updateNote(updateNoteOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiNote apiNoteResult = response.getResult();

      assertNotNull(apiNoteResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCreateOccurrenceFinding() throws Exception 
  {
    try {
      Context contextModel = new Context.Builder()
      .region(testString)
      .resourceCrn(testString)
      .resourceId(testString)
      .resourceName(testString)
      .resourceType(testString)
      .serviceCrn(testString)
      .serviceName(testString)
      .environmentName(testString)
      .componentName(testString)
      .toolchainId(testString)
      .build();

      RemediationStep remediationStepModel = new RemediationStep.Builder()
      .title(testString)
      .url(testString)
      .build();

      SocketAddress socketAddressModel = new SocketAddress.Builder()
      .address(testString)
      .port(Long.valueOf("26"))
      .build();

      NetworkConnection networkConnectionModel = new NetworkConnection.Builder()
      .direction(testString)
      .protocol(testString)
      .client(socketAddressModel)
      .server(socketAddressModel)
      .build();

      DataTransferred dataTransferredModel = new DataTransferred.Builder()
      .clientBytes(Long.valueOf("26"))
      .serverBytes(Long.valueOf("26"))
      .clientPackets(Long.valueOf("26"))
      .serverPackets(Long.valueOf("26"))
      .build();

      Finding findingModel = new Finding.Builder()
      .severity("LOW")
      .certainty("LOW")
      .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
      .networkConnection(networkConnectionModel)
      .dataTransferred(dataTransferredModel)
      .build();

      CreateOccurrenceOptions createOccurrenceOptions = new CreateOccurrenceOptions.Builder()
      .providerId(providerID)
      .noteName(String.format("%s/providers/%s/notes/finding-note-%s", accountID, providerID, identifier))
      .kind("FINDING")
      .id(String.format("finding-occurrence-%s", identifier))
      .resourceUrl(testString)
      .remediation(testString)
      .context(contextModel)
      .finding(findingModel)
      .replaceIfExists(true)
      .build();

      // Invoke operation
      Response<ApiOccurrence> response = service.createOccurrence(createOccurrenceOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiOccurrence apiOccurrenceResult = response.getResult();

      assertNotNull(apiOccurrenceResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(groups={"kpi"})
  public void testCreateOccurrenceKpi() throws Exception {
    try {
      Context contextModel = new Context.Builder()
      .region(testString)
      .resourceCrn(testString)
      .resourceId(testString)
      .resourceName(testString)
      .resourceType(testString)
      .serviceCrn(testString)
      .serviceName(testString)
      .environmentName(testString)
      .componentName(testString)
      .toolchainId(testString)
      .build();

      Kpi kpiModel = new Kpi.Builder()
      .value(Double.valueOf("72.5"))
      .total(Double.valueOf("72.5"))
      .build();

      CreateOccurrenceOptions createOccurrenceOptions = new CreateOccurrenceOptions.Builder()
      .providerId(providerID)
      .noteName(String.format("%s/providers/%s/notes/kpi-note-%s", accountID, providerID, identifier))
      .kind("KPI")
      .id(String.format("kpi-occurrence-%s", identifier))
      .resourceUrl(testString)
      .remediation(testString)
      .context(contextModel)
      .kpi(kpiModel)
      .replaceIfExists(true)
      .build();

      // Invoke operation
      Response<ApiOccurrence> response = service.createOccurrence(createOccurrenceOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiOccurrence apiOccurrenceResult = response.getResult();

      assertNotNull(apiOccurrenceResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetOccurrenceNote() throws Exception {
    try {
      GetOccurrenceNoteOptions getOccurrenceNoteOptions = new GetOccurrenceNoteOptions.Builder()
      .providerId(providerID)
      .occurrenceId(String.format("kpi-occurrence-%s", identifier))
      .build();

      // Invoke operation
      Response<ApiNote> response = service.getOccurrenceNote(getOccurrenceNoteOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiNote apiNoteResult = response.getResult();

      assertNotNull(apiNoteResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListOccurrences() throws Exception {
    try {
      ListOccurrencesOptions listOccurrencesOptions = new ListOccurrencesOptions.Builder()
      .providerId(providerID)
      .build();

      // Invoke operation
      Response<ApiListOccurrencesResponse> response = service.listOccurrences(listOccurrencesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiListOccurrencesResponse apiListOccurrencesResponseResult = response.getResult();

      assertNotNull(apiListOccurrencesResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListNoteOccurrences() throws Exception {
    try {
      ListNoteOccurrencesOptions listNoteOccurrencesOptions = new ListNoteOccurrencesOptions.Builder()
      .providerId(providerID)
      .noteId(String.format("kpi-note-%s", identifier))
      .build();

      // Invoke operation
      Response<ApiListNoteOccurrencesResponse> response = service.listNoteOccurrences(listNoteOccurrencesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiListNoteOccurrencesResponse apiListNoteOccurrencesResponseResult = response.getResult();

      assertNotNull(apiListNoteOccurrencesResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetOccurrence() throws Exception {
    try {
      GetOccurrenceOptions getOccurrenceOptions = new GetOccurrenceOptions.Builder()
      .providerId(providerID)
      .occurrenceId(String.format("kpi-occurrence-%s", identifier))
      .build();

      // Invoke operation
      Response<ApiListOccurrencesResponse> response = service.getOccurrence(getOccurrenceOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiListOccurrencesResponse apiListOccurrencesResponseResult = response.getResult();

      assertNotNull(apiListOccurrencesResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testUpdateOccurrenceFinding() throws Exception {
    try {
      Context contextModel = new Context.Builder()
      .region(testString)
      .resourceCrn(testString)
      .resourceId(testString)
      .resourceName(testString)
      .resourceType(testString)
      .serviceCrn(testString)
      .serviceName(testString)
      .environmentName(testString)
      .componentName(testString)
      .toolchainId(testString)
      .build();

      RemediationStep remediationStepModel = new RemediationStep.Builder()
      .title(testString)
      .url(testString)
      .build();

      SocketAddress socketAddressModel = new SocketAddress.Builder()
      .address(testString)
      .port(Long.valueOf("26"))
      .build();

      NetworkConnection networkConnectionModel = new NetworkConnection.Builder()
      .direction(testString)
      .protocol(testString)
      .client(socketAddressModel)
      .server(socketAddressModel)
      .build();

      DataTransferred dataTransferredModel = new DataTransferred.Builder()
      .clientBytes(Long.valueOf("26"))
      .serverBytes(Long.valueOf("26"))
      .clientPackets(Long.valueOf("26"))
      .serverPackets(Long.valueOf("26"))
      .build();

      Finding findingModel = new Finding.Builder()
      .severity("LOW")
      .certainty("LOW")
      .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
      .networkConnection(networkConnectionModel)
      .dataTransferred(dataTransferredModel)
      .build();

      UpdateOccurrenceOptions updateOccurrenceOptions = new UpdateOccurrenceOptions.Builder()
      .providerId(providerID)
      .occurrenceId(String.format("finding-occurrence-%s", identifier))
      .noteName(String.format("%s/providers/%s/notes/finding-note-%s", accountID, providerID, identifier))
      .kind("FINDING")
      .id(String.format("finding-occurrence-%s", identifier))
      .resourceUrl(testString)
      .remediation(testString)
      .context(contextModel)
      .finding(findingModel)
      .build();

      // Invoke operation
      Response<ApiOccurrence> response = service.updateOccurrence(updateOccurrenceOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiOccurrence apiOccurrenceResult = response.getResult();

      assertNotNull(apiOccurrenceResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(groups={"kpi"})
  public void testUpdateOccurrenceKpi() throws Exception {
    try {
      Context contextModel = new Context.Builder()
      .region(testString)
      .resourceCrn(testString)
      .resourceId(testString)
      .resourceName(testString)
      .resourceType(testString)
      .serviceCrn(testString)
      .serviceName(testString)
      .environmentName(testString)
      .componentName(testString)
      .toolchainId(testString)
      .build();

      Kpi kpiModel = new Kpi.Builder()
      .value(Double.valueOf("72.5"))
      .total(Double.valueOf("72.5"))
      .build();

      UpdateOccurrenceOptions updateOccurrenceOptions = new UpdateOccurrenceOptions.Builder()
      .providerId(providerID)
      .occurrenceId(String.format("kpi-occurrence-%s", identifier))
      .noteName(String.format("%s/providers/%s/notes/kpi-note-%s", accountID, providerID, identifier))
      .kind("KPI")
      .id(String.format("kpi-occurrence-%s", identifier))
      .resourceUrl(testString)
      .remediation(testString)
      .context(contextModel)
      .kpi(kpiModel)
      .build();

      // Invoke operation
      Response<ApiOccurrence> response = service.updateOccurrence(updateOccurrenceOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiOccurrence apiOccurrenceResult = response.getResult();

      assertNotNull(apiOccurrenceResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }
  @Test
  public void testListProviders() throws Exception {
    try {
      ListProvidersOptions listProvidersOptions = new ListProvidersOptions.Builder()
      .build();

      // Invoke operation
      Response<ApiListProvidersResponse> response = service.listProviders(listProvidersOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApiListProvidersResponse apiListProvidersResponseResult = response.getResult();

      assertNotNull(apiListProvidersResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterGroups(groups={"kpi"})
  public void testDeleteOccurrence() throws Exception {
    try {
      DeleteOccurrenceOptions deleteOccurrenceOptions = new DeleteOccurrenceOptions.Builder()
      .providerId(providerID)
      .occurrenceId(String.format("kpi-occurrence-%s", identifier))
      .build();

      // Invoke operation
      Response<Void> response = service.deleteOccurrence(deleteOccurrenceOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterGroups(groups={"kpi"})
  public void testDeleteNote() throws Exception {
    try {
      DeleteNoteOptions deleteNoteOptions = new DeleteNoteOptions.Builder()
      .providerId(providerID)
      .noteId(String.format("kpi-note-%s", identifier))
      .build();

      // Invoke operation
      Response<Void> response = service.deleteNote(deleteNoteOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterClass
  public void tearDown() {
    service = Findings.newInstance(accountID);
    config = CredentialUtils.getServiceProperties(Findings.DEFAULT_SERVICE_NAME);
    System.out.println("Setup complete.");

    System.out.println(String.format("cleaning up account: %s with provider: %s", accountID, providerID));
    
    ListNotesOptions listNotesOptions = new ListNotesOptions.Builder()
    .providerId(providerID)
    .build();
    Response<ApiListNotesResponse> notes = service.listNotes(listNotesOptions).execute();
    for(ApiNote note: notes.getResult().getNotes()){
      String[] parts = note.id().split("-");
      if(parts[parts.length-1]==identifier){
        DeleteNoteOptions deleteNoteOptions = new DeleteNoteOptions.Builder()
        .providerId(providerID)
        .noteId(note.id())
        .build();
        service.deleteNote(deleteNoteOptions).execute();
      }
    }

    ListOccurrencesOptions listOccurrencesOptions = new ListOccurrencesOptions.Builder()
    .providerId(providerID)
    .build();
    Response<ApiListOccurrencesResponse> occurrences = service.listOccurrences(listOccurrencesOptions).execute();
    for(ApiOccurrence occurrence: occurrences.getResult().getOccurrences()){
      String[] parts = occurrence.id().split("-");
      if(parts[parts.length-1]==identifier){
        DeleteOccurrenceOptions deleteOccurrenceOptions = new DeleteOccurrenceOptions.Builder()
        .providerId(providerID)
        .occurrenceId(occurrence.id())
        .build();
        service.deleteOccurrence(deleteOccurrenceOptions).execute();
      }
    }
    System.out.println("cleanup was successful");

    ListProvidersOptions listProvidersOptions = new ListProvidersOptions.Builder()
    .build();
    Response<ApiListProvidersResponse> providers = service.listProviders(listProvidersOptions).execute();
    for(ApiProvider provider: providers.getResult().getProviders()){
      if(provider.getId() == providerID) {
        System.out.println(String.format("seems like account has some resources left even after a successful cleanup, please consider manual cleanup for account: %s and provider: %s", accountID, providerID));
      }
    }
  }
 }
