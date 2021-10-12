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

import com.ibm.cloud.scc.findings.v1.Findings;
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
import com.ibm.cloud.scc.findings.v1.model.CardElementBreakdownCardElement;
import com.ibm.cloud.scc.findings.v1.model.CardElementNumericCardElement;
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
import com.ibm.cloud.scc.findings.v1.model.NumericCardElementValueType;
import com.ibm.cloud.scc.findings.v1.model.PostGraphOptions;
import com.ibm.cloud.scc.findings.v1.model.RemediationStep;
import com.ibm.cloud.scc.findings.v1.model.Reporter;
import com.ibm.cloud.scc.findings.v1.model.Section;
import com.ibm.cloud.scc.findings.v1.model.SocketAddress;
import com.ibm.cloud.scc.findings.v1.model.UpdateNoteOptions;
import com.ibm.cloud.scc.findings.v1.model.UpdateOccurrenceOptions;
import com.ibm.cloud.scc.findings.v1.model.ValueType;
import com.ibm.cloud.scc.findings.v1.model.ValueTypeFindingCountValueType;
import com.ibm.cloud.scc.findings.v1.model.ValueTypeKpiValueType;
import com.ibm.cloud.scc.findings.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.sdk.core.util.EnvironmentUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Findings service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class FindingsTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected Findings findingsService;

  // Creates a mock set of environment variables that are returned by EnvironmentUtils.getenv().
  private Map<String, String> getTestProcessEnvironment() {
    Map<String, String> env = new HashMap<>();
    env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
    return env;
  }

  public void constructClientService() throws Throwable {
    PowerMockito.spy(EnvironmentUtils.class);
    PowerMockito.when(EnvironmentUtils.getenv()).thenReturn(getTestProcessEnvironment());
    final String serviceName = "testService";
    // set mock values for global params
    String accountId = "testString";

    findingsService = Findings.newInstance(accountId, serviceName);
    String url = server.url("/").toString();
    findingsService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    // set mock values for global params
    String accountId = "testString";

    new Findings(accountId, serviceName, null);
  }


  @Test
  public void testGetAccountId() throws Throwable {
    constructClientService();
    assertEquals(findingsService.getAccountId(), "testString");
  }

  @Test
  public void testPostGraphWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String postGraphPath = "/v1/testString/graph";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PostGraphOptions model
    PostGraphOptions postGraphOptionsModel = new PostGraphOptions.Builder()
    .body(TestUtilities.createMockStream("This is a mock file."))
    .contentType("application/json")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = findingsService.postGraph(postGraphOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, postGraphPath);
  }
  
  public void testPostGraphWOptionsWRetries() throws Throwable {
    // Enable retries and run testPostGraphWOptions.
    // findingsService.enableRetries(4, 30);
    testPostGraphWOptions();

    // Disable retries and run testPostGraphWOptions.
    // findingsService.disableRetries();
    testPostGraphWOptions();
  }  

  // Test the postGraph operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPostGraphNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    findingsService.postGraph(null).execute();
  }

  @Test
  public void testListProvidersWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"providers\": [{\"name\": \"name\", \"id\": \"id\"}], \"limit\": 5, \"skip\": 4, \"total_count\": 10}";
    String listProvidersPath = "/v1/testString/providers";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListProvidersOptions model
    ListProvidersOptions listProvidersOptionsModel = new ListProvidersOptions.Builder()
    .transactionId("testString")
    .limit(Long.valueOf("2"))
    .skip(Long.valueOf("26"))
    .startProviderId("testString")
    .endProviderId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApiListProvidersResponse> response = findingsService.listProviders(listProvidersOptionsModel).execute();
    assertNotNull(response);
    ApiListProvidersResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("2"));
    assertEquals(Long.valueOf(query.get("skip")), Long.valueOf("26"));
    assertEquals(query.get("start_provider_id"), "testString");
    assertEquals(query.get("end_provider_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listProvidersPath);
  }
  
  public void testListProvidersWOptionsWRetries() throws Throwable {
    // Enable retries and run testListProvidersWOptions.
    // findingsService.enableRetries(4, 30);
    testListProvidersWOptions();

    // Disable retries and run testListProvidersWOptions.
    // findingsService.disableRetries();
    testListProvidersWOptions();
  }  

  @Test
  public void testCreateNoteWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"kind\": \"FINDING\", \"related_url\": [{\"label\": \"label\", \"url\": \"url\"}], \"create_time\": \"2019-01-01T12:00:00.000Z\", \"update_time\": \"2019-01-01T12:00:00.000Z\", \"id\": \"id\", \"shared\": true, \"reported_by\": {\"id\": \"id\", \"title\": \"title\", \"url\": \"url\"}, \"finding\": {\"severity\": \"LOW\", \"next_steps\": [{\"title\": \"title\", \"url\": \"url\"}]}, \"kpi\": {\"Severity\": \"MEDIUM\", \"aggregation_type\": \"SUM\"}, \"card\": {\"section\": \"section\", \"title\": \"title\", \"subtitle\": \"subtitle\", \"order\": 1, \"finding_note_names\": [\"findingNoteNames\"], \"requires_configuration\": false, \"badge_text\": \"badgeText\", \"badge_image\": \"badgeImage\", \"elements\": [{\"text\": \"text\", \"default_interval\": \"d\", \"kind\": \"TIME_SERIES\", \"default_time_range\": \"4d\", \"value_types\": [{\"kind\": \"FINDING_COUNT\", \"finding_note_names\": [\"findingNoteNames\"], \"text\": \"label\"}]}]}, \"section\": {\"title\": \"title\", \"image\": \"image\"}}";
    String createNotePath = "/v1/testString/providers/testString/notes";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Reporter model
    Reporter reporterModel = new Reporter.Builder()
    .id("testString")
    .title("testString")
    .url("testString")
    .build();

    // Construct an instance of the ApiNoteRelatedUrl model
    ApiNoteRelatedUrl apiNoteRelatedUrlModel = new ApiNoteRelatedUrl.Builder()
    .label("testString")
    .url("testString")
    .build();

    // Construct an instance of the RemediationStep model
    RemediationStep remediationStepModel = new RemediationStep.Builder()
    .title("testString")
    .url("testString")
    .build();

    // Construct an instance of the FindingType model
    FindingType findingTypeModel = new FindingType.Builder()
    .severity("LOW")
    .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
    .build();

    // Construct an instance of the KpiType model
    KpiType kpiTypeModel = new KpiType.Builder()
    .severity("MEDIUM")
    .aggregationType("SUM")
    .build();

    // Construct an instance of the ValueTypeFindingCountValueType model
    ValueTypeFindingCountValueType valueTypeModel = new ValueTypeFindingCountValueType.Builder()
    .kind("FINDING_COUNT")
    .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .text("label")
    .build();

    // Construct an instance of the CardElementTimeSeriesCardElement model
    CardElementTimeSeriesCardElement cardElementModel = new CardElementTimeSeriesCardElement.Builder()
    .text("testString")
    .defaultInterval("d")
    .kind("TIME_SERIES")
    .defaultTimeRange("4d")
    .valueTypes(new java.util.ArrayList<ValueType>(java.util.Arrays.asList(valueTypeModel)))
    .build();

    // Construct an instance of the Card model
    Card cardModel = new Card.Builder()
    .section("testString")
    .title("testString")
    .subtitle("testString")
    .order(Long.valueOf("1"))
    .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .requiresConfiguration(false)
    .badgeText("testString")
    .badgeImage("testString")
    .elements(new java.util.ArrayList<CardElement>(java.util.Arrays.asList(cardElementModel)))
    .build();

    // Construct an instance of the Section model
    Section sectionModel = new Section.Builder()
    .title("testString")
    .image("testString")
    .build();

    // Construct an instance of the CreateNoteOptions model
    CreateNoteOptions createNoteOptionsModel = new CreateNoteOptions.Builder()
    .providerId("testString")
    .shortDescription("testString")
    .longDescription("testString")
    .kind("FINDING")
    .id("testString")
    .reportedBy(reporterModel)
    .relatedUrl(new java.util.ArrayList<ApiNoteRelatedUrl>(java.util.Arrays.asList(apiNoteRelatedUrlModel)))
    .createTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .updateTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .shared(true)
    .finding(findingTypeModel)
    .kpi(kpiTypeModel)
    .card(cardModel)
    .section(sectionModel)
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApiNote> response = findingsService.createNote(createNoteOptionsModel).execute();
    assertNotNull(response);
    ApiNote responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createNotePath);
  }
  
  public void testCreateNoteWOptionsWRetries() throws Throwable {
    // Enable retries and run testCreateNoteWOptions.
    // findingsService.enableRetries(4, 30);
    testCreateNoteWOptions();

    // Disable retries and run testCreateNoteWOptions.
    // findingsService.disableRetries();
    testCreateNoteWOptions();
  }  

  // Test the createNote operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateNoteNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    findingsService.createNote(null).execute();
  }

  @Test
  public void testListNotesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"notes\": [{\"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"kind\": \"FINDING\", \"related_url\": [{\"label\": \"label\", \"url\": \"url\"}], \"create_time\": \"2019-01-01T12:00:00.000Z\", \"update_time\": \"2019-01-01T12:00:00.000Z\", \"id\": \"id\", \"shared\": true, \"reported_by\": {\"id\": \"id\", \"title\": \"title\", \"url\": \"url\"}, \"finding\": {\"severity\": \"LOW\", \"next_steps\": [{\"title\": \"title\", \"url\": \"url\"}]}, \"kpi\": {\"Severity\": \"MEDIUM\", \"aggregation_type\": \"SUM\"}, \"card\": {\"section\": \"section\", \"title\": \"title\", \"subtitle\": \"subtitle\", \"order\": 1, \"finding_note_names\": [\"findingNoteNames\"], \"requires_configuration\": false, \"badge_text\": \"badgeText\", \"badge_image\": \"badgeImage\", \"elements\": [{\"text\": \"text\", \"default_interval\": \"d\", \"kind\": \"TIME_SERIES\", \"default_time_range\": \"4d\", \"value_types\": [{\"kind\": \"FINDING_COUNT\", \"finding_note_names\": [\"findingNoteNames\"], \"text\": \"label\"}]}]}, \"section\": {\"title\": \"title\", \"image\": \"image\"}}], \"next_page_token\": \"nextPageToken\"}";
    String listNotesPath = "/v1/testString/providers/testString/notes";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListNotesOptions model
    ListNotesOptions listNotesOptionsModel = new ListNotesOptions.Builder()
    .providerId("testString")
    .transactionId("testString")
    .pageSize(Long.valueOf("2"))
    .pageToken("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApiListNotesResponse> response = findingsService.listNotes(listNotesOptionsModel).execute();
    assertNotNull(response);
    ApiListNotesResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Long.valueOf(query.get("page_size")), Long.valueOf("2"));
    assertEquals(query.get("page_token"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listNotesPath);
  }
  
  public void testListNotesWOptionsWRetries() throws Throwable {
    // Enable retries and run testListNotesWOptions.
    // findingsService.enableRetries(4, 30);
    testListNotesWOptions();

    // Disable retries and run testListNotesWOptions.
    // findingsService.disableRetries();
    testListNotesWOptions();
  }  

  // Test the listNotes operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListNotesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    findingsService.listNotes(null).execute();
  }

  @Test
  public void testGetNoteWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"kind\": \"FINDING\", \"related_url\": [{\"label\": \"label\", \"url\": \"url\"}], \"create_time\": \"2019-01-01T12:00:00.000Z\", \"update_time\": \"2019-01-01T12:00:00.000Z\", \"id\": \"id\", \"shared\": true, \"reported_by\": {\"id\": \"id\", \"title\": \"title\", \"url\": \"url\"}, \"finding\": {\"severity\": \"LOW\", \"next_steps\": [{\"title\": \"title\", \"url\": \"url\"}]}, \"kpi\": {\"Severity\": \"MEDIUM\", \"aggregation_type\": \"SUM\"}, \"card\": {\"section\": \"section\", \"title\": \"title\", \"subtitle\": \"subtitle\", \"order\": 1, \"finding_note_names\": [\"findingNoteNames\"], \"requires_configuration\": false, \"badge_text\": \"badgeText\", \"badge_image\": \"badgeImage\", \"elements\": [{\"text\": \"text\", \"default_interval\": \"d\", \"kind\": \"TIME_SERIES\", \"default_time_range\": \"4d\", \"value_types\": [{\"kind\": \"FINDING_COUNT\", \"finding_note_names\": [\"findingNoteNames\"], \"text\": \"label\"}]}]}, \"section\": {\"title\": \"title\", \"image\": \"image\"}}";
    String getNotePath = "/v1/testString/providers/testString/notes/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetNoteOptions model
    GetNoteOptions getNoteOptionsModel = new GetNoteOptions.Builder()
    .providerId("testString")
    .noteId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApiNote> response = findingsService.getNote(getNoteOptionsModel).execute();
    assertNotNull(response);
    ApiNote responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getNotePath);
  }
  
  public void testGetNoteWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetNoteWOptions.
    // findingsService.enableRetries(4, 30);
    testGetNoteWOptions();

    // Disable retries and run testGetNoteWOptions.
    // findingsService.disableRetries();
    testGetNoteWOptions();
  }  

  // Test the getNote operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetNoteNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    findingsService.getNote(null).execute();
  }

  @Test
  public void testUpdateNoteWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"kind\": \"FINDING\", \"related_url\": [{\"label\": \"label\", \"url\": \"url\"}], \"create_time\": \"2019-01-01T12:00:00.000Z\", \"update_time\": \"2019-01-01T12:00:00.000Z\", \"id\": \"id\", \"shared\": true, \"reported_by\": {\"id\": \"id\", \"title\": \"title\", \"url\": \"url\"}, \"finding\": {\"severity\": \"LOW\", \"next_steps\": [{\"title\": \"title\", \"url\": \"url\"}]}, \"kpi\": {\"Severity\": \"MEDIUM\", \"aggregation_type\": \"SUM\"}, \"card\": {\"section\": \"section\", \"title\": \"title\", \"subtitle\": \"subtitle\", \"order\": 1, \"finding_note_names\": [\"findingNoteNames\"], \"requires_configuration\": false, \"badge_text\": \"badgeText\", \"badge_image\": \"badgeImage\", \"elements\": [{\"text\": \"text\", \"default_interval\": \"d\", \"kind\": \"TIME_SERIES\", \"default_time_range\": \"4d\", \"value_types\": [{\"kind\": \"FINDING_COUNT\", \"finding_note_names\": [\"findingNoteNames\"], \"text\": \"label\"}]}]}, \"section\": {\"title\": \"title\", \"image\": \"image\"}}";
    String updateNotePath = "/v1/testString/providers/testString/notes/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Reporter model
    Reporter reporterModel = new Reporter.Builder()
    .id("testString")
    .title("testString")
    .url("testString")
    .build();

    // Construct an instance of the ApiNoteRelatedUrl model
    ApiNoteRelatedUrl apiNoteRelatedUrlModel = new ApiNoteRelatedUrl.Builder()
    .label("testString")
    .url("testString")
    .build();

    // Construct an instance of the RemediationStep model
    RemediationStep remediationStepModel = new RemediationStep.Builder()
    .title("testString")
    .url("testString")
    .build();

    // Construct an instance of the FindingType model
    FindingType findingTypeModel = new FindingType.Builder()
    .severity("LOW")
    .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
    .build();

    // Construct an instance of the KpiType model
    KpiType kpiTypeModel = new KpiType.Builder()
    .severity("MEDIUM")
    .aggregationType("SUM")
    .build();

    // Construct an instance of the ValueTypeFindingCountValueType model
    ValueTypeFindingCountValueType valueTypeModel = new ValueTypeFindingCountValueType.Builder()
    .kind("FINDING_COUNT")
    .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .text("label")
    .build();

    // Construct an instance of the CardElementTimeSeriesCardElement model
    CardElementTimeSeriesCardElement cardElementModel = new CardElementTimeSeriesCardElement.Builder()
    .text("testString")
    .defaultInterval("d")
    .kind("TIME_SERIES")
    .defaultTimeRange("4d")
    .valueTypes(new java.util.ArrayList<ValueType>(java.util.Arrays.asList(valueTypeModel)))
    .build();

    // Construct an instance of the Card model
    Card cardModel = new Card.Builder()
    .section("testString")
    .title("testString")
    .subtitle("testString")
    .order(Long.valueOf("1"))
    .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .requiresConfiguration(false)
    .badgeText("testString")
    .badgeImage("testString")
    .elements(new java.util.ArrayList<CardElement>(java.util.Arrays.asList(cardElementModel)))
    .build();

    // Construct an instance of the Section model
    Section sectionModel = new Section.Builder()
    .title("testString")
    .image("testString")
    .build();

    // Construct an instance of the UpdateNoteOptions model
    UpdateNoteOptions updateNoteOptionsModel = new UpdateNoteOptions.Builder()
    .providerId("testString")
    .noteId("testString")
    .shortDescription("testString")
    .longDescription("testString")
    .kind("FINDING")
    .id("testString")
    .reportedBy(reporterModel)
    .relatedUrl(new java.util.ArrayList<ApiNoteRelatedUrl>(java.util.Arrays.asList(apiNoteRelatedUrlModel)))
    .createTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .updateTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .shared(true)
    .finding(findingTypeModel)
    .kpi(kpiTypeModel)
    .card(cardModel)
    .section(sectionModel)
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApiNote> response = findingsService.updateNote(updateNoteOptionsModel).execute();
    assertNotNull(response);
    ApiNote responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateNotePath);
  }
  
  public void testUpdateNoteWOptionsWRetries() throws Throwable {
    // Enable retries and run testUpdateNoteWOptions.
    // findingsService.enableRetries(4, 30);
    testUpdateNoteWOptions();

    // Disable retries and run testUpdateNoteWOptions.
    // findingsService.disableRetries();
    testUpdateNoteWOptions();
  }  

  // Test the updateNote operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateNoteNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    findingsService.updateNote(null).execute();
  }

  @Test
  public void testDeleteNoteWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteNotePath = "/v1/testString/providers/testString/notes/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteNoteOptions model
    DeleteNoteOptions deleteNoteOptionsModel = new DeleteNoteOptions.Builder()
    .providerId("testString")
    .noteId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = findingsService.deleteNote(deleteNoteOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteNotePath);
  }
  
  public void testDeleteNoteWOptionsWRetries() throws Throwable {
    // Enable retries and run testDeleteNoteWOptions.
    // findingsService.enableRetries(4, 30);
    testDeleteNoteWOptions();

    // Disable retries and run testDeleteNoteWOptions.
    // findingsService.disableRetries();
    testDeleteNoteWOptions();
  }  

  // Test the deleteNote operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteNoteNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    findingsService.deleteNote(null).execute();
  }

  @Test
  public void testGetOccurrenceNoteWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"kind\": \"FINDING\", \"related_url\": [{\"label\": \"label\", \"url\": \"url\"}], \"create_time\": \"2019-01-01T12:00:00.000Z\", \"update_time\": \"2019-01-01T12:00:00.000Z\", \"id\": \"id\", \"shared\": true, \"reported_by\": {\"id\": \"id\", \"title\": \"title\", \"url\": \"url\"}, \"finding\": {\"severity\": \"LOW\", \"next_steps\": [{\"title\": \"title\", \"url\": \"url\"}]}, \"kpi\": {\"Severity\": \"MEDIUM\", \"aggregation_type\": \"SUM\"}, \"card\": {\"section\": \"section\", \"title\": \"title\", \"subtitle\": \"subtitle\", \"order\": 1, \"finding_note_names\": [\"findingNoteNames\"], \"requires_configuration\": false, \"badge_text\": \"badgeText\", \"badge_image\": \"badgeImage\", \"elements\": [{\"text\": \"text\", \"default_interval\": \"d\", \"kind\": \"TIME_SERIES\", \"default_time_range\": \"4d\", \"value_types\": [{\"kind\": \"FINDING_COUNT\", \"finding_note_names\": [\"findingNoteNames\"], \"text\": \"label\"}]}]}, \"section\": {\"title\": \"title\", \"image\": \"image\"}}";
    String getOccurrenceNotePath = "/v1/testString/providers/testString/occurrences/testString/note";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetOccurrenceNoteOptions model
    GetOccurrenceNoteOptions getOccurrenceNoteOptionsModel = new GetOccurrenceNoteOptions.Builder()
    .providerId("testString")
    .occurrenceId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApiNote> response = findingsService.getOccurrenceNote(getOccurrenceNoteOptionsModel).execute();
    assertNotNull(response);
    ApiNote responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getOccurrenceNotePath);
  }
  
  public void testGetOccurrenceNoteWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetOccurrenceNoteWOptions.
    // findingsService.enableRetries(4, 30);
    testGetOccurrenceNoteWOptions();

    // Disable retries and run testGetOccurrenceNoteWOptions.
    // findingsService.disableRetries();
    testGetOccurrenceNoteWOptions();
  }  

  // Test the getOccurrenceNote operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetOccurrenceNoteNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    findingsService.getOccurrenceNote(null).execute();
  }

  @Test
  public void testCreateOccurrenceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"resource_url\": \"resourceUrl\", \"note_name\": \"noteName\", \"kind\": \"FINDING\", \"remediation\": \"remediation\", \"create_time\": \"2019-01-01T12:00:00.000Z\", \"update_time\": \"2019-01-01T12:00:00.000Z\", \"id\": \"id\", \"context\": {\"region\": \"region\", \"resource_crn\": \"resourceCrn\", \"resource_id\": \"resourceId\", \"resource_name\": \"resourceName\", \"resource_type\": \"resourceType\", \"service_crn\": \"serviceCrn\", \"service_name\": \"serviceName\", \"environment_name\": \"environmentName\", \"component_name\": \"componentName\", \"toolchain_id\": \"toolchainId\"}, \"finding\": {\"severity\": \"LOW\", \"certainty\": \"LOW\", \"next_steps\": [{\"title\": \"title\", \"url\": \"url\"}], \"network_connection\": {\"direction\": \"direction\", \"protocol\": \"protocol\", \"client\": {\"address\": \"address\", \"port\": 4}, \"server\": {\"address\": \"address\", \"port\": 4}}, \"data_transferred\": {\"client_bytes\": 11, \"server_bytes\": 11, \"client_packets\": 13, \"server_packets\": 13}}, \"kpi\": {\"value\": 5, \"total\": 5}, \"reference_data\": {\"mapKey\": \"anyValue\"}}";
    String createOccurrencePath = "/v1/testString/providers/testString/occurrences";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Context model
    Context contextModel = new Context.Builder()
    .region("testString")
    .resourceCrn("testString")
    .resourceId("testString")
    .resourceName("testString")
    .resourceType("testString")
    .serviceCrn("testString")
    .serviceName("testString")
    .environmentName("testString")
    .componentName("testString")
    .toolchainId("testString")
    .build();

    // Construct an instance of the RemediationStep model
    RemediationStep remediationStepModel = new RemediationStep.Builder()
    .title("testString")
    .url("testString")
    .build();

    // Construct an instance of the SocketAddress model
    SocketAddress socketAddressModel = new SocketAddress.Builder()
    .address("testString")
    .port(Long.valueOf("26"))
    .build();

    // Construct an instance of the NetworkConnection model
    NetworkConnection networkConnectionModel = new NetworkConnection.Builder()
    .direction("testString")
    .protocol("testString")
    .client(socketAddressModel)
    .server(socketAddressModel)
    .build();

    // Construct an instance of the DataTransferred model
    DataTransferred dataTransferredModel = new DataTransferred.Builder()
    .clientBytes(Long.valueOf("26"))
    .serverBytes(Long.valueOf("26"))
    .clientPackets(Long.valueOf("26"))
    .serverPackets(Long.valueOf("26"))
    .build();

    // Construct an instance of the Finding model
    Finding findingModel = new Finding.Builder()
    .severity("LOW")
    .certainty("LOW")
    .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
    .networkConnection(networkConnectionModel)
    .dataTransferred(dataTransferredModel)
    .build();

    // Construct an instance of the Kpi model
    Kpi kpiModel = new Kpi.Builder()
    .value(Double.valueOf("72.5"))
    .total(Double.valueOf("72.5"))
    .build();

    // Construct an instance of the CreateOccurrenceOptions model
    CreateOccurrenceOptions createOccurrenceOptionsModel = new CreateOccurrenceOptions.Builder()
    .providerId("testString")
    .noteName("testString")
    .kind("FINDING")
    .id("testString")
    .resourceUrl("testString")
    .remediation("testString")
    .context(contextModel)
    .finding(findingModel)
    .kpi(kpiModel)
    .referenceData(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .transactionId("testString")
    .replaceIfExists(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApiOccurrence> response = findingsService.createOccurrence(createOccurrenceOptionsModel).execute();
    assertNotNull(response);
    ApiOccurrence responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createOccurrencePath);
  }
  
  public void testCreateOccurrenceWOptionsWRetries() throws Throwable {
    // Enable retries and run testCreateOccurrenceWOptions.
    // findingsService.enableRetries(4, 30);
    testCreateOccurrenceWOptions();

    // Disable retries and run testCreateOccurrenceWOptions.
    // findingsService.disableRetries();
    testCreateOccurrenceWOptions();
  }  

  // Test the createOccurrence operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateOccurrenceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    findingsService.createOccurrence(null).execute();
  }

  @Test
  public void testListOccurrencesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"occurrences\": [{\"resource_url\": \"resourceUrl\", \"note_name\": \"noteName\", \"kind\": \"FINDING\", \"remediation\": \"remediation\", \"create_time\": \"2019-01-01T12:00:00.000Z\", \"update_time\": \"2019-01-01T12:00:00.000Z\", \"id\": \"id\", \"context\": {\"region\": \"region\", \"resource_crn\": \"resourceCrn\", \"resource_id\": \"resourceId\", \"resource_name\": \"resourceName\", \"resource_type\": \"resourceType\", \"service_crn\": \"serviceCrn\", \"service_name\": \"serviceName\", \"environment_name\": \"environmentName\", \"component_name\": \"componentName\", \"toolchain_id\": \"toolchainId\"}, \"finding\": {\"severity\": \"LOW\", \"certainty\": \"LOW\", \"next_steps\": [{\"title\": \"title\", \"url\": \"url\"}], \"network_connection\": {\"direction\": \"direction\", \"protocol\": \"protocol\", \"client\": {\"address\": \"address\", \"port\": 4}, \"server\": {\"address\": \"address\", \"port\": 4}}, \"data_transferred\": {\"client_bytes\": 11, \"server_bytes\": 11, \"client_packets\": 13, \"server_packets\": 13}}, \"kpi\": {\"value\": 5, \"total\": 5}, \"reference_data\": {\"mapKey\": \"anyValue\"}}], \"next_page_token\": \"nextPageToken\"}";
    String listOccurrencesPath = "/v1/testString/providers/testString/occurrences";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListOccurrencesOptions model
    ListOccurrencesOptions listOccurrencesOptionsModel = new ListOccurrencesOptions.Builder()
    .providerId("testString")
    .transactionId("testString")
    .pageSize(Long.valueOf("2"))
    .pageToken("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApiListOccurrencesResponse> response = findingsService.listOccurrences(listOccurrencesOptionsModel).execute();
    assertNotNull(response);
    ApiListOccurrencesResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Long.valueOf(query.get("page_size")), Long.valueOf("2"));
    assertEquals(query.get("page_token"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listOccurrencesPath);
  }
  
  public void testListOccurrencesWOptionsWRetries() throws Throwable {
    // Enable retries and run testListOccurrencesWOptions.
    // findingsService.enableRetries(4, 30);
    testListOccurrencesWOptions();

    // Disable retries and run testListOccurrencesWOptions.
    // findingsService.disableRetries();
    testListOccurrencesWOptions();
  }  

  // Test the listOccurrences operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListOccurrencesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    findingsService.listOccurrences(null).execute();
  }

  @Test
  public void testListNoteOccurrencesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"occurrences\": [{\"resource_url\": \"resourceUrl\", \"note_name\": \"noteName\", \"kind\": \"FINDING\", \"remediation\": \"remediation\", \"create_time\": \"2019-01-01T12:00:00.000Z\", \"update_time\": \"2019-01-01T12:00:00.000Z\", \"id\": \"id\", \"context\": {\"region\": \"region\", \"resource_crn\": \"resourceCrn\", \"resource_id\": \"resourceId\", \"resource_name\": \"resourceName\", \"resource_type\": \"resourceType\", \"service_crn\": \"serviceCrn\", \"service_name\": \"serviceName\", \"environment_name\": \"environmentName\", \"component_name\": \"componentName\", \"toolchain_id\": \"toolchainId\"}, \"finding\": {\"severity\": \"LOW\", \"certainty\": \"LOW\", \"next_steps\": [{\"title\": \"title\", \"url\": \"url\"}], \"network_connection\": {\"direction\": \"direction\", \"protocol\": \"protocol\", \"client\": {\"address\": \"address\", \"port\": 4}, \"server\": {\"address\": \"address\", \"port\": 4}}, \"data_transferred\": {\"client_bytes\": 11, \"server_bytes\": 11, \"client_packets\": 13, \"server_packets\": 13}}, \"kpi\": {\"value\": 5, \"total\": 5}, \"reference_data\": {\"mapKey\": \"anyValue\"}}], \"next_page_token\": \"nextPageToken\"}";
    String listNoteOccurrencesPath = "/v1/testString/providers/testString/notes/testString/occurrences";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListNoteOccurrencesOptions model
    ListNoteOccurrencesOptions listNoteOccurrencesOptionsModel = new ListNoteOccurrencesOptions.Builder()
    .providerId("testString")
    .noteId("testString")
    .transactionId("testString")
    .pageSize(Long.valueOf("2"))
    .pageToken("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApiListNoteOccurrencesResponse> response = findingsService.listNoteOccurrences(listNoteOccurrencesOptionsModel).execute();
    assertNotNull(response);
    ApiListNoteOccurrencesResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Long.valueOf(query.get("page_size")), Long.valueOf("2"));
    assertEquals(query.get("page_token"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listNoteOccurrencesPath);
  }
  
  public void testListNoteOccurrencesWOptionsWRetries() throws Throwable {
    // Enable retries and run testListNoteOccurrencesWOptions.
    // findingsService.enableRetries(4, 30);
    testListNoteOccurrencesWOptions();

    // Disable retries and run testListNoteOccurrencesWOptions.
    // findingsService.disableRetries();
    testListNoteOccurrencesWOptions();
  }  

  // Test the listNoteOccurrences operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListNoteOccurrencesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    findingsService.listNoteOccurrences(null).execute();
  }

  @Test
  public void testGetOccurrenceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"occurrences\": [{\"resource_url\": \"resourceUrl\", \"note_name\": \"noteName\", \"kind\": \"FINDING\", \"remediation\": \"remediation\", \"create_time\": \"2019-01-01T12:00:00.000Z\", \"update_time\": \"2019-01-01T12:00:00.000Z\", \"id\": \"id\", \"context\": {\"region\": \"region\", \"resource_crn\": \"resourceCrn\", \"resource_id\": \"resourceId\", \"resource_name\": \"resourceName\", \"resource_type\": \"resourceType\", \"service_crn\": \"serviceCrn\", \"service_name\": \"serviceName\", \"environment_name\": \"environmentName\", \"component_name\": \"componentName\", \"toolchain_id\": \"toolchainId\"}, \"finding\": {\"severity\": \"LOW\", \"certainty\": \"LOW\", \"next_steps\": [{\"title\": \"title\", \"url\": \"url\"}], \"network_connection\": {\"direction\": \"direction\", \"protocol\": \"protocol\", \"client\": {\"address\": \"address\", \"port\": 4}, \"server\": {\"address\": \"address\", \"port\": 4}}, \"data_transferred\": {\"client_bytes\": 11, \"server_bytes\": 11, \"client_packets\": 13, \"server_packets\": 13}}, \"kpi\": {\"value\": 5, \"total\": 5}, \"reference_data\": {\"mapKey\": \"anyValue\"}}], \"next_page_token\": \"nextPageToken\"}";
    String getOccurrencePath = "/v1/testString/providers/testString/occurrences/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetOccurrenceOptions model
    GetOccurrenceOptions getOccurrenceOptionsModel = new GetOccurrenceOptions.Builder()
    .providerId("testString")
    .occurrenceId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApiListOccurrencesResponse> response = findingsService.getOccurrence(getOccurrenceOptionsModel).execute();
    assertNotNull(response);
    ApiListOccurrencesResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getOccurrencePath);
  }
  
  public void testGetOccurrenceWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetOccurrenceWOptions.
    // findingsService.enableRetries(4, 30);
    testGetOccurrenceWOptions();

    // Disable retries and run testGetOccurrenceWOptions.
    // findingsService.disableRetries();
    testGetOccurrenceWOptions();
  }  

  // Test the getOccurrence operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetOccurrenceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    findingsService.getOccurrence(null).execute();
  }

  @Test
  public void testUpdateOccurrenceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"resource_url\": \"resourceUrl\", \"note_name\": \"noteName\", \"kind\": \"FINDING\", \"remediation\": \"remediation\", \"create_time\": \"2019-01-01T12:00:00.000Z\", \"update_time\": \"2019-01-01T12:00:00.000Z\", \"id\": \"id\", \"context\": {\"region\": \"region\", \"resource_crn\": \"resourceCrn\", \"resource_id\": \"resourceId\", \"resource_name\": \"resourceName\", \"resource_type\": \"resourceType\", \"service_crn\": \"serviceCrn\", \"service_name\": \"serviceName\", \"environment_name\": \"environmentName\", \"component_name\": \"componentName\", \"toolchain_id\": \"toolchainId\"}, \"finding\": {\"severity\": \"LOW\", \"certainty\": \"LOW\", \"next_steps\": [{\"title\": \"title\", \"url\": \"url\"}], \"network_connection\": {\"direction\": \"direction\", \"protocol\": \"protocol\", \"client\": {\"address\": \"address\", \"port\": 4}, \"server\": {\"address\": \"address\", \"port\": 4}}, \"data_transferred\": {\"client_bytes\": 11, \"server_bytes\": 11, \"client_packets\": 13, \"server_packets\": 13}}, \"kpi\": {\"value\": 5, \"total\": 5}, \"reference_data\": {\"mapKey\": \"anyValue\"}}";
    String updateOccurrencePath = "/v1/testString/providers/testString/occurrences/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Context model
    Context contextModel = new Context.Builder()
    .region("testString")
    .resourceCrn("testString")
    .resourceId("testString")
    .resourceName("testString")
    .resourceType("testString")
    .serviceCrn("testString")
    .serviceName("testString")
    .environmentName("testString")
    .componentName("testString")
    .toolchainId("testString")
    .build();

    // Construct an instance of the RemediationStep model
    RemediationStep remediationStepModel = new RemediationStep.Builder()
    .title("testString")
    .url("testString")
    .build();

    // Construct an instance of the SocketAddress model
    SocketAddress socketAddressModel = new SocketAddress.Builder()
    .address("testString")
    .port(Long.valueOf("26"))
    .build();

    // Construct an instance of the NetworkConnection model
    NetworkConnection networkConnectionModel = new NetworkConnection.Builder()
    .direction("testString")
    .protocol("testString")
    .client(socketAddressModel)
    .server(socketAddressModel)
    .build();

    // Construct an instance of the DataTransferred model
    DataTransferred dataTransferredModel = new DataTransferred.Builder()
    .clientBytes(Long.valueOf("26"))
    .serverBytes(Long.valueOf("26"))
    .clientPackets(Long.valueOf("26"))
    .serverPackets(Long.valueOf("26"))
    .build();

    // Construct an instance of the Finding model
    Finding findingModel = new Finding.Builder()
    .severity("LOW")
    .certainty("LOW")
    .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
    .networkConnection(networkConnectionModel)
    .dataTransferred(dataTransferredModel)
    .build();

    // Construct an instance of the Kpi model
    Kpi kpiModel = new Kpi.Builder()
    .value(Double.valueOf("72.5"))
    .total(Double.valueOf("72.5"))
    .build();

    // Construct an instance of the UpdateOccurrenceOptions model
    UpdateOccurrenceOptions updateOccurrenceOptionsModel = new UpdateOccurrenceOptions.Builder()
    .providerId("testString")
    .occurrenceId("testString")
    .noteName("testString")
    .kind("FINDING")
    .id("testString")
    .resourceUrl("testString")
    .remediation("testString")
    .context(contextModel)
    .finding(findingModel)
    .kpi(kpiModel)
    .referenceData(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApiOccurrence> response = findingsService.updateOccurrence(updateOccurrenceOptionsModel).execute();
    assertNotNull(response);
    ApiOccurrence responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateOccurrencePath);
  }
  
  public void testUpdateOccurrenceWOptionsWRetries() throws Throwable {
    // Enable retries and run testUpdateOccurrenceWOptions.
    // findingsService.enableRetries(4, 30);
    testUpdateOccurrenceWOptions();

    // Disable retries and run testUpdateOccurrenceWOptions.
    // findingsService.disableRetries();
    testUpdateOccurrenceWOptions();
  }  

  // Test the updateOccurrence operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateOccurrenceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    findingsService.updateOccurrence(null).execute();
  }

  @Test
  public void testDeleteOccurrenceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteOccurrencePath = "/v1/testString/providers/testString/occurrences/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteOccurrenceOptions model
    DeleteOccurrenceOptions deleteOccurrenceOptionsModel = new DeleteOccurrenceOptions.Builder()
    .providerId("testString")
    .occurrenceId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = findingsService.deleteOccurrence(deleteOccurrenceOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteOccurrencePath);
  }
  
  public void testDeleteOccurrenceWOptionsWRetries() throws Throwable {
    // Enable retries and run testDeleteOccurrenceWOptions.
    // findingsService.enableRetries(4, 30);
    testDeleteOccurrenceWOptions();

    // Disable retries and run testDeleteOccurrenceWOptions.
    // findingsService.disableRetries();
    testDeleteOccurrenceWOptions();
  }  

  // Test the deleteOccurrence operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteOccurrenceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    findingsService.deleteOccurrence(null).execute();
  }

  /** Initialize the server */
  @BeforeMethod
  public void setUpMockServer() {
    try {
        server = new MockWebServer();
        // register handler
        server.start();
        }
    catch (IOException err) {
        fail("Failed to instantiate mock web server");
    }
  }

  @AfterMethod
  public void tearDownMockServer() throws IOException {
    server.shutdown();
    findingsService = null;
  }
}