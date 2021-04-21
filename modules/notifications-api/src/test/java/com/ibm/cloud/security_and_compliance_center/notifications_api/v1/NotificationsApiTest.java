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
package com.ibm.cloud.security_and_compliance_center.notifications_api.v1;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.EnvironmentUtils;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.NotificationsApi;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.Channel;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.ChannelAlertSourceItem;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.ChannelDelete;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.ChannelGet;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.ChannelGetChannel;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.ChannelGetChannelAlertSourceItem;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.ChannelGetChannelSeverity;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.ChannelInfo;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.ChannelSeverity;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.ChannelsDelete;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.ChannelsList;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.CreateNotificationChannelOptions;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.DeleteNotificationChannelOptions;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.DeleteNotificationChannelsOptions;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.GetNotificationChannelOptions;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.GetPublicKeyOptions;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.ListAllChannelsOptions;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.NotificationChannelAlertSourceItem;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.PublicKeyGet;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.TestChannel;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.TestNotificationChannelOptions;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.UpdateNotificationChannelOptions;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.utils.TestUtilities;
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
 * Unit test class for the NotificationsApi service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class NotificationsApiTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected NotificationsApi notificationsApiService;

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

    notificationsApiService = NotificationsApi.newInstance(serviceName);
    String url = server.url("/").toString();
    notificationsApiService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new NotificationsApi(serviceName, null);
  }

  @Test
  public void testListAllChannelsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"channels\": [{\"channel_id\": \"channelId\", \"name\": \"name\", \"description\": \"description\", \"type\": \"Webhook\", \"severity\": {\"critical\": true, \"high\": true, \"medium\": true, \"low\": false}, \"endpoint\": \"endpoint\", \"enabled\": false, \"alert_source\": [{\"provider_name\": \"VA\", \"finding_types\": [\"anyValue\"]}], \"frequency\": \"frequency\"}]}";
    String listAllChannelsPath = "/v1/testString/notifications/channels";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListAllChannelsOptions model
    ListAllChannelsOptions listAllChannelsOptionsModel = new ListAllChannelsOptions.Builder()
    .accountId("testString")
    .transactionId("testString")
    .limit(Long.valueOf("26"))
    .skip(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ChannelsList> response = notificationsApiService.listAllChannels(listAllChannelsOptionsModel).execute();
    assertNotNull(response);
    ChannelsList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("skip")), Long.valueOf("26"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAllChannelsPath);
  }

  // Test the listAllChannels operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAllChannelsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    notificationsApiService.listAllChannels(null).execute();
  }

  @Test
  public void testCreateNotificationChannelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"channel_id\": \"channelId\", \"status_code\": 10}";
    String createNotificationChannelPath = "/v1/testString/notifications/channels";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the NotificationChannelAlertSourceItem model
    NotificationChannelAlertSourceItem notificationChannelAlertSourceItemModel = new NotificationChannelAlertSourceItem.Builder()
    .providerName("testString")
    .findingTypes(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Construct an instance of the CreateNotificationChannelOptions model
    CreateNotificationChannelOptions createNotificationChannelOptionsModel = new CreateNotificationChannelOptions.Builder()
    .accountId("testString")
    .name("testString")
    .type("Webhook")
    .endpoint("testString")
    .description("testString")
    .severity(new java.util.ArrayList<String>(java.util.Arrays.asList("low")))
    .enabled(true)
    .alertSource(new java.util.ArrayList<NotificationChannelAlertSourceItem>(java.util.Arrays.asList(notificationChannelAlertSourceItemModel)))
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ChannelInfo> response = notificationsApiService.createNotificationChannel(createNotificationChannelOptionsModel).execute();
    assertNotNull(response);
    ChannelInfo responseObj = response.getResult();
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
    assertEquals(parsedPath, createNotificationChannelPath);
  }

  // Test the createNotificationChannel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateNotificationChannelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    notificationsApiService.createNotificationChannel(null).execute();
  }

  @Test
  public void testDeleteNotificationChannelsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"message\": \"message\"}";
    String deleteNotificationChannelsPath = "/v1/testString/notifications/channels";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteNotificationChannelsOptions model
    DeleteNotificationChannelsOptions deleteNotificationChannelsOptionsModel = new DeleteNotificationChannelsOptions.Builder()
    .accountId("testString")
    .body(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ChannelsDelete> response = notificationsApiService.deleteNotificationChannels(deleteNotificationChannelsOptionsModel).execute();
    assertNotNull(response);
    ChannelsDelete responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteNotificationChannelsPath);
  }

  // Test the deleteNotificationChannels operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteNotificationChannelsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    notificationsApiService.deleteNotificationChannels(null).execute();
  }

  @Test
  public void testDeleteNotificationChannelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"channel_id\": \"channelId\", \"message\": \"message\"}";
    String deleteNotificationChannelPath = "/v1/testString/notifications/channels/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteNotificationChannelOptions model
    DeleteNotificationChannelOptions deleteNotificationChannelOptionsModel = new DeleteNotificationChannelOptions.Builder()
    .accountId("testString")
    .channelId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ChannelDelete> response = notificationsApiService.deleteNotificationChannel(deleteNotificationChannelOptionsModel).execute();
    assertNotNull(response);
    ChannelDelete responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteNotificationChannelPath);
  }

  // Test the deleteNotificationChannel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteNotificationChannelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    notificationsApiService.deleteNotificationChannel(null).execute();
  }

  @Test
  public void testGetNotificationChannelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"channel\": {\"channel_id\": \"channelId\", \"name\": \"name\", \"description\": \"description\", \"type\": \"Webhook\", \"severity\": {\"critical\": true, \"high\": true, \"medium\": true, \"low\": false}, \"endpoint\": \"endpoint\", \"enabled\": false, \"alert_source\": [{\"provider_name\": \"VA\", \"finding_types\": [\"anyValue\"]}], \"frequency\": \"frequency\"}}";
    String getNotificationChannelPath = "/v1/testString/notifications/channels/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetNotificationChannelOptions model
    GetNotificationChannelOptions getNotificationChannelOptionsModel = new GetNotificationChannelOptions.Builder()
    .accountId("testString")
    .channelId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ChannelGet> response = notificationsApiService.getNotificationChannel(getNotificationChannelOptionsModel).execute();
    assertNotNull(response);
    ChannelGet responseObj = response.getResult();
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
    assertEquals(parsedPath, getNotificationChannelPath);
  }

  // Test the getNotificationChannel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetNotificationChannelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    notificationsApiService.getNotificationChannel(null).execute();
  }

  @Test
  public void testUpdateNotificationChannelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"channel_id\": \"channelId\", \"status_code\": 10}";
    String updateNotificationChannelPath = "/v1/testString/notifications/channels/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the NotificationChannelAlertSourceItem model
    NotificationChannelAlertSourceItem notificationChannelAlertSourceItemModel = new NotificationChannelAlertSourceItem.Builder()
    .providerName("testString")
    .findingTypes(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Construct an instance of the UpdateNotificationChannelOptions model
    UpdateNotificationChannelOptions updateNotificationChannelOptionsModel = new UpdateNotificationChannelOptions.Builder()
    .accountId("testString")
    .channelId("testString")
    .name("testString")
    .type("Webhook")
    .endpoint("testString")
    .description("testString")
    .severity(new java.util.ArrayList<String>(java.util.Arrays.asList("low")))
    .enabled(true)
    .alertSource(new java.util.ArrayList<NotificationChannelAlertSourceItem>(java.util.Arrays.asList(notificationChannelAlertSourceItemModel)))
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ChannelInfo> response = notificationsApiService.updateNotificationChannel(updateNotificationChannelOptionsModel).execute();
    assertNotNull(response);
    ChannelInfo responseObj = response.getResult();
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
    assertEquals(parsedPath, updateNotificationChannelPath);
  }

  // Test the updateNotificationChannel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateNotificationChannelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    notificationsApiService.updateNotificationChannel(null).execute();
  }

  @Test
  public void testTestNotificationChannelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"test\": \"test\"}";
    String testNotificationChannelPath = "/v1/testString/notifications/channels/testString/test";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the TestNotificationChannelOptions model
    TestNotificationChannelOptions testNotificationChannelOptionsModel = new TestNotificationChannelOptions.Builder()
    .accountId("testString")
    .channelId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<TestChannel> response = notificationsApiService.testNotificationChannel(testNotificationChannelOptionsModel).execute();
    assertNotNull(response);
    TestChannel responseObj = response.getResult();
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
    assertEquals(parsedPath, testNotificationChannelPath);
  }

  // Test the testNotificationChannel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTestNotificationChannelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    notificationsApiService.testNotificationChannel(null).execute();
  }

  @Test
  public void testGetPublicKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"public_key\": \"publicKey\"}";
    String getPublicKeyPath = "/v1/testString/notifications/public_key";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetPublicKeyOptions model
    GetPublicKeyOptions getPublicKeyOptionsModel = new GetPublicKeyOptions.Builder()
    .accountId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<PublicKeyGet> response = notificationsApiService.getPublicKey(getPublicKeyOptionsModel).execute();
    assertNotNull(response);
    PublicKeyGet responseObj = response.getResult();
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
    assertEquals(parsedPath, getPublicKeyPath);
  }

  // Test the getPublicKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPublicKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    notificationsApiService.getPublicKey(null).execute();
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
    notificationsApiService = null;
  }
}