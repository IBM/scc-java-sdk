/*
 * (C) Copyright IBM Corp. 2022.
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
package com.ibm.cloud.scc.addon_mgr.v1;

import com.ibm.cloud.scc.addon_mgr.v1.AddonMgr;
import com.ibm.cloud.scc.addon_mgr.v1.model.AddActivityInsightsCosDetailsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.AddNetworkInsightsCosDetailsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.AllInsights;
import com.ibm.cloud.scc.addon_mgr.v1.model.CosDetailsV2CosDetailsItem;
import com.ibm.cloud.scc.addon_mgr.v1.model.DeleteActivityInsightsCosDetailsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.DeleteNetworkInsightsCosDetailsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.DisableInsightsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.EnableInsightsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.GetSupportedInsightsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.TestAIFindingsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
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
 * Unit test class for the AddonMgr service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class AddonMgrTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected AddonMgr addonMgrService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    // Set mock values for global params
    String accountId = "testString";
    new AddonMgr(accountId, serviceName, null);
  }

  // Test the getServiceUrlForRegion() method
  @Test
  public void testGetServiceUrlForRegion() throws Throwable {
    assertNull(AddonMgr.getServiceUrlForRegion("INVALID_REGION"));
    assertEquals(AddonMgr.getServiceUrlForRegion("us-south"), "https://us-south.secadvisor.cloud.ibm.com/addonmgr");
    assertEquals(AddonMgr.getServiceUrlForRegion("us-east"), "https://us-south.secadvisor.cloud.ibm.com/addonmgr");
    assertEquals(AddonMgr.getServiceUrlForRegion("eu-gb"), "https://eu-gb.secadvisor.cloud.ibm.com/addonmgr");
    assertEquals(AddonMgr.getServiceUrlForRegion("eu-de"), "https://eu.compliance.cloud.ibm.com/si/addonmgr");
  }


  // Test the getter for the accountId global parameter
  @Test
  public void testGetAccountId() throws Throwable {
    assertEquals(addonMgrService.getAccountId(), "testString");
  }

  // Test the addNetworkInsightsCosDetailsV2 operation with a valid options model parameter
  @Test
  public void testAddNetworkInsightsCosDetailsV2WOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String addNetworkInsightsCosDetailsV2Path = "/v2/addons/testString/network-insights/cos";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CosDetailsV2CosDetailsItem model
    CosDetailsV2CosDetailsItem cosDetailsV2CosDetailsItemModel = new CosDetailsV2CosDetailsItem.Builder()
      .cosInstance("testString")
      .bucketName("testString")
      .description("testString")
      .type("network-insights")
      .cosBucketUrl("testString")
      .build();

    // Construct an instance of the AddNetworkInsightsCosDetailsV2Options model
    AddNetworkInsightsCosDetailsV2Options addNetworkInsightsCosDetailsV2OptionsModel = new AddNetworkInsightsCosDetailsV2Options.Builder()
      .regionId("testString")
      .cosDetails(new java.util.ArrayList<CosDetailsV2CosDetailsItem>(java.util.Arrays.asList(cosDetailsV2CosDetailsItemModel)))
      .transactionId("testString")
      .build();

    // Invoke addNetworkInsightsCosDetailsV2() with a valid options model and verify the result
    Response<Void> response = addonMgrService.addNetworkInsightsCosDetailsV2(addNetworkInsightsCosDetailsV2OptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addNetworkInsightsCosDetailsV2Path);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the addNetworkInsightsCosDetailsV2 operation with and without retries enabled
  @Test
  public void testAddNetworkInsightsCosDetailsV2WRetries() throws Throwable {
    addonMgrService.enableRetries(4, 30);
    testAddNetworkInsightsCosDetailsV2WOptions();

    addonMgrService.disableRetries();
    testAddNetworkInsightsCosDetailsV2WOptions();
  }

  // Test the addNetworkInsightsCosDetailsV2 operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddNetworkInsightsCosDetailsV2NoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    addonMgrService.addNetworkInsightsCosDetailsV2(null).execute();
  }

  // Test the deleteNetworkInsightsCosDetailsV2 operation with a valid options model parameter
  @Test
  public void testDeleteNetworkInsightsCosDetailsV2WOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteNetworkInsightsCosDetailsV2Path = "/v2/addons/testString/network-insights/cos";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteNetworkInsightsCosDetailsV2Options model
    DeleteNetworkInsightsCosDetailsV2Options deleteNetworkInsightsCosDetailsV2OptionsModel = new DeleteNetworkInsightsCosDetailsV2Options.Builder()
      .ids(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .transactionId("testString")
      .build();

    // Invoke deleteNetworkInsightsCosDetailsV2() with a valid options model and verify the result
    Response<Void> response = addonMgrService.deleteNetworkInsightsCosDetailsV2(deleteNetworkInsightsCosDetailsV2OptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteNetworkInsightsCosDetailsV2Path);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteNetworkInsightsCosDetailsV2 operation with and without retries enabled
  @Test
  public void testDeleteNetworkInsightsCosDetailsV2WRetries() throws Throwable {
    addonMgrService.enableRetries(4, 30);
    testDeleteNetworkInsightsCosDetailsV2WOptions();

    addonMgrService.disableRetries();
    testDeleteNetworkInsightsCosDetailsV2WOptions();
  }

  // Test the addActivityInsightsCosDetailsV2 operation with a valid options model parameter
  @Test
  public void testAddActivityInsightsCosDetailsV2WOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String addActivityInsightsCosDetailsV2Path = "/v2/addons/testString/activity-insights/cos";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CosDetailsV2CosDetailsItem model
    CosDetailsV2CosDetailsItem cosDetailsV2CosDetailsItemModel = new CosDetailsV2CosDetailsItem.Builder()
      .cosInstance("testString")
      .bucketName("testString")
      .description("testString")
      .type("network-insights")
      .cosBucketUrl("testString")
      .build();

    // Construct an instance of the AddActivityInsightsCosDetailsV2Options model
    AddActivityInsightsCosDetailsV2Options addActivityInsightsCosDetailsV2OptionsModel = new AddActivityInsightsCosDetailsV2Options.Builder()
      .regionId("testString")
      .cosDetails(new java.util.ArrayList<CosDetailsV2CosDetailsItem>(java.util.Arrays.asList(cosDetailsV2CosDetailsItemModel)))
      .transactionId("testString")
      .build();

    // Invoke addActivityInsightsCosDetailsV2() with a valid options model and verify the result
    Response<Void> response = addonMgrService.addActivityInsightsCosDetailsV2(addActivityInsightsCosDetailsV2OptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addActivityInsightsCosDetailsV2Path);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the addActivityInsightsCosDetailsV2 operation with and without retries enabled
  @Test
  public void testAddActivityInsightsCosDetailsV2WRetries() throws Throwable {
    addonMgrService.enableRetries(4, 30);
    testAddActivityInsightsCosDetailsV2WOptions();

    addonMgrService.disableRetries();
    testAddActivityInsightsCosDetailsV2WOptions();
  }

  // Test the addActivityInsightsCosDetailsV2 operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddActivityInsightsCosDetailsV2NoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    addonMgrService.addActivityInsightsCosDetailsV2(null).execute();
  }

  // Test the deleteActivityInsightsCosDetailsV2 operation with a valid options model parameter
  @Test
  public void testDeleteActivityInsightsCosDetailsV2WOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteActivityInsightsCosDetailsV2Path = "/v2/addons/testString/activity-insights/cos";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteActivityInsightsCosDetailsV2Options model
    DeleteActivityInsightsCosDetailsV2Options deleteActivityInsightsCosDetailsV2OptionsModel = new DeleteActivityInsightsCosDetailsV2Options.Builder()
      .ids(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .transactionId("testString")
      .build();

    // Invoke deleteActivityInsightsCosDetailsV2() with a valid options model and verify the result
    Response<Void> response = addonMgrService.deleteActivityInsightsCosDetailsV2(deleteActivityInsightsCosDetailsV2OptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteActivityInsightsCosDetailsV2Path);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteActivityInsightsCosDetailsV2 operation with and without retries enabled
  @Test
  public void testDeleteActivityInsightsCosDetailsV2WRetries() throws Throwable {
    addonMgrService.enableRetries(4, 30);
    testDeleteActivityInsightsCosDetailsV2WOptions();

    addonMgrService.disableRetries();
    testDeleteActivityInsightsCosDetailsV2WOptions();
  }

  // Test the disableInsightsV2 operation with a valid options model parameter
  @Test
  public void testDisableInsightsV2WOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String disableInsightsV2Path = "/v2/addons/testString/disable";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DisableInsightsV2Options model
    DisableInsightsV2Options disableInsightsV2OptionsModel = new DisableInsightsV2Options.Builder()
      .regionId("testString")
      .networkInsights(true)
      .activityInsights(true)
      .transactionId("testString")
      .build();

    // Invoke disableInsightsV2() with a valid options model and verify the result
    Response<Void> response = addonMgrService.disableInsightsV2(disableInsightsV2OptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, disableInsightsV2Path);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the disableInsightsV2 operation with and without retries enabled
  @Test
  public void testDisableInsightsV2WRetries() throws Throwable {
    addonMgrService.enableRetries(4, 30);
    testDisableInsightsV2WOptions();

    addonMgrService.disableRetries();
    testDisableInsightsV2WOptions();
  }

  // Test the disableInsightsV2 operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDisableInsightsV2NoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    addonMgrService.disableInsightsV2(null).execute();
  }

  // Test the enableInsightsV2 operation with a valid options model parameter
  @Test
  public void testEnableInsightsV2WOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String enableInsightsV2Path = "/v2/addons/testString/enable";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the EnableInsightsV2Options model
    EnableInsightsV2Options enableInsightsV2OptionsModel = new EnableInsightsV2Options.Builder()
      .regionId("testString")
      .networkInsights(true)
      .activityInsights(true)
      .transactionId("testString")
      .build();

    // Invoke enableInsightsV2() with a valid options model and verify the result
    Response<Void> response = addonMgrService.enableInsightsV2(enableInsightsV2OptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, enableInsightsV2Path);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the enableInsightsV2 operation with and without retries enabled
  @Test
  public void testEnableInsightsV2WRetries() throws Throwable {
    addonMgrService.enableRetries(4, 30);
    testEnableInsightsV2WOptions();

    addonMgrService.disableRetries();
    testEnableInsightsV2WOptions();
  }

  // Test the enableInsightsV2 operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testEnableInsightsV2NoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    addonMgrService.enableInsightsV2(null).execute();
  }

  // Test the getSupportedInsightsV2 operation with a valid options model parameter
  @Test
  public void testGetSupportedInsightsV2WOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"type\": [\"network-insights\"]}";
    String getSupportedInsightsV2Path = "/v2/addons/testString/insights";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSupportedInsightsV2Options model
    GetSupportedInsightsV2Options getSupportedInsightsV2OptionsModel = new GetSupportedInsightsV2Options.Builder()
      .transactionId("testString")
      .build();

    // Invoke getSupportedInsightsV2() with a valid options model and verify the result
    Response<AllInsights> response = addonMgrService.getSupportedInsightsV2(getSupportedInsightsV2OptionsModel).execute();
    assertNotNull(response);
    AllInsights responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSupportedInsightsV2Path);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getSupportedInsightsV2 operation with and without retries enabled
  @Test
  public void testGetSupportedInsightsV2WRetries() throws Throwable {
    addonMgrService.enableRetries(4, 30);
    testGetSupportedInsightsV2WOptions();

    addonMgrService.disableRetries();
    testGetSupportedInsightsV2WOptions();
  }

  // Test the testAiFindingsV2 operation with a valid options model parameter
  @Test
  public void testTestAiFindingsV2WOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String testAiFindingsV2Path = "/v2/addons/testString/activity-insights/test-ai-findings";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the TestAIFindingsV2Options model
    TestAIFindingsV2Options testAiFindingsV2OptionsModel = new TestAIFindingsV2Options.Builder()
      .regionId("testString")
      .build();

    // Invoke testAiFindingsV2() with a valid options model and verify the result
    Response<Void> response = addonMgrService.testAiFindingsV2(testAiFindingsV2OptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, testAiFindingsV2Path);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the testAiFindingsV2 operation with and without retries enabled
  @Test
  public void testTestAiFindingsV2WRetries() throws Throwable {
    addonMgrService.enableRetries(4, 30);
    testTestAiFindingsV2WOptions();

    addonMgrService.disableRetries();
    testTestAiFindingsV2WOptions();
  }

  // Test the testAiFindingsV2 operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTestAiFindingsV2NoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    addonMgrService.testAiFindingsV2(null).execute();
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
    addonMgrService = null;
  }

  // Creates a mock set of environment variables that are returned by EnvironmentUtils.getenv()
  private Map<String, String> getTestProcessEnvironment() {
    Map<String, String> env = new HashMap<>();
    env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
    return env;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    PowerMockito.spy(EnvironmentUtils.class);
    PowerMockito.when(EnvironmentUtils.getenv()).thenReturn(getTestProcessEnvironment());
    final String serviceName = "testService";
    // set mock values for global params
    String accountId = "testString";

    addonMgrService = AddonMgr.newInstance(accountId, serviceName);
    String url = server.url("/").toString();
    addonMgrService.setServiceUrl(url);
  }
}