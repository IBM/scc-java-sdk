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

package com.ibm.cloud.scc.notifications.v1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.cloud.scc.notifications.v1.model.Channel;
import com.ibm.cloud.scc.notifications.v1.model.ChannelDelete;
import com.ibm.cloud.scc.notifications.v1.model.ChannelGet;
import com.ibm.cloud.scc.notifications.v1.model.ChannelInfo;
import com.ibm.cloud.scc.notifications.v1.model.ChannelsDelete;
import com.ibm.cloud.scc.notifications.v1.model.ChannelsList;
import com.ibm.cloud.scc.notifications.v1.model.CreateNotificationChannelOptions;
import com.ibm.cloud.scc.notifications.v1.model.DeleteNotificationChannelOptions;
import com.ibm.cloud.scc.notifications.v1.model.DeleteNotificationChannelsOptions;
import com.ibm.cloud.scc.notifications.v1.model.GetNotificationChannelOptions;
import com.ibm.cloud.scc.notifications.v1.model.GetPublicKeyOptions;
import com.ibm.cloud.scc.notifications.v1.model.ListAllChannelsOptions;
import com.ibm.cloud.scc.notifications.v1.model.NotificationChannelAlertSourceItem;
import com.ibm.cloud.scc.notifications.v1.model.PublicKeyGet;
import com.ibm.cloud.scc.notifications.v1.model.TestChannel;
import com.ibm.cloud.scc.notifications.v1.model.TestNotificationChannelOptions;
import com.ibm.cloud.scc.notifications.v1.model.UpdateNotificationChannelOptions;
import com.ibm.cloud.scc.notifications.v1.utils.TestUtilities;
import com.ibm.cloud.scc.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Integration test class for the Notifications service.
 */
public class NotificationsIT extends SdkIntegrationTestBase {
  public Notifications service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  /**
   * This method provides our config filename to the base class.
   */

  final String accountID = System.getenv("ACCOUNT_ID");
  String channelID = "";
  final String testString = "testString";

  public String getConfigFilename() {
    return "../../notifications_v1.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = Notifications.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(Notifications.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    System.out.println("Setup complete.");
  }

  @Test
  public void testListAllChannels() throws Exception {
    try {
      ListAllChannelsOptions listAllChannelsOptions = new ListAllChannelsOptions.Builder()
      .accountId(accountID)
      .build();

      // Invoke operation
      Response<ChannelsList> response = service.listAllChannels(listAllChannelsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ChannelsList channelsListResult = response.getResult();

      assertNotNull(channelsListResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(groups={"channel"})
  public void testCreateNotificationChannel() throws Exception {
    try {
      NotificationChannelAlertSourceItem notificationChannelAlertSourceItemModel = new NotificationChannelAlertSourceItem.Builder()
      .providerName("VA")
      .findingTypes(new java.util.ArrayList<String>(java.util.Arrays.asList("image_with_vulnerabilities")))
      .build();

      CreateNotificationChannelOptions createNotificationChannelOptions = new CreateNotificationChannelOptions.Builder()
      .accountId(accountID)
      .name(testString)
      .type("Webhook")
      .endpoint("https://webhook.site/136fe1e2-3c3f-4bff-925f-391fbb202546")
      .description(testString)
      .severity(new java.util.ArrayList<String>(java.util.Arrays.asList("low")))
      .enabled(true)
      .alertSource(new java.util.ArrayList<NotificationChannelAlertSourceItem>(java.util.Arrays.asList(notificationChannelAlertSourceItemModel)))
      .build();

      // Invoke operation
      Response<ChannelInfo> response = service.createNotificationChannel(createNotificationChannelOptions).execute();
      channelID = response.getResult().getChannelId();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ChannelInfo channelInfoResult = response.getResult();

      assertNotNull(channelInfoResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(groups={"channel"})
  public void testGetNotificationChannel() throws Exception {
    try {
      GetNotificationChannelOptions getNotificationChannelOptions = new GetNotificationChannelOptions.Builder()
      .accountId(accountID)
      .channelId(channelID)
      .build();

      // Invoke operation
      Response<ChannelGet> response = service.getNotificationChannel(getNotificationChannelOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ChannelGet channelGetResult = response.getResult();

      assertNotNull(channelGetResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(groups={"channel"})
  public void testUpdateNotificationChannel() throws Exception {
    try {
      NotificationChannelAlertSourceItem notificationChannelAlertSourceItemModel = new NotificationChannelAlertSourceItem.Builder()
      .providerName("VA")
      .findingTypes(new java.util.ArrayList<String>(java.util.Arrays.asList("image_with_vulnerabilities")))
      .build();

      UpdateNotificationChannelOptions updateNotificationChannelOptions = new UpdateNotificationChannelOptions.Builder()
      .accountId(accountID)
      .channelId(channelID)
      .name(testString)
      .type("Webhook")
      .endpoint("https://webhook.site/136fe1e2-3c3f-4bff-925f-391fbb202546")
      .description(testString)
      .severity(new java.util.ArrayList<String>(java.util.Arrays.asList("low")))
      .enabled(true)
      .alertSource(new java.util.ArrayList<NotificationChannelAlertSourceItem>(java.util.Arrays.asList(notificationChannelAlertSourceItemModel)))
      .build();

      // Invoke operation
      Response<ChannelInfo> response = service.updateNotificationChannel(updateNotificationChannelOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ChannelInfo channelInfoResult = response.getResult();

      assertNotNull(channelInfoResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(groups={"channel"})
  public void testTestNotificationChannel() throws Exception {
    try {
      TestNotificationChannelOptions testNotificationChannelOptions = new TestNotificationChannelOptions.Builder()
      .accountId(accountID)
      .channelId(channelID)
      .build();

      // Invoke operation
      Response<TestChannel> response = service.testNotificationChannel(testNotificationChannelOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TestChannel testChannelResult = response.getResult();

      assertNotNull(testChannelResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetPublicKey() throws Exception {
    try {
      GetPublicKeyOptions getPublicKeyOptions = new GetPublicKeyOptions.Builder()
      .accountId(accountID)
      .build();

      // Invoke operation
      Response<PublicKeyGet> response = service.getPublicKey(getPublicKeyOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      PublicKeyGet publicKeyGetResult = response.getResult();

      assertNotNull(publicKeyGetResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterGroups(groups={"channel"})
  public void testDeleteNotificationChannel() throws Exception {
    try {
      DeleteNotificationChannelOptions deleteNotificationChannelOptions = new DeleteNotificationChannelOptions.Builder()
      .accountId(accountID)
      .channelId(channelID)
      .build();

      // Invoke operation
      Response<ChannelDelete> response = service.deleteNotificationChannel(deleteNotificationChannelOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ChannelDelete channelDeleteResult = response.getResult();

      assertNotNull(channelDeleteResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterGroups(groups={"channel"})
  public void testDeleteNotificationChannels() throws Exception {
    try {
      NotificationChannelAlertSourceItem notificationChannelAlertSourceItemModel = new NotificationChannelAlertSourceItem.Builder()
      .providerName("VA")
      .findingTypes(new java.util.ArrayList<String>(java.util.Arrays.asList("image_with_vulnerabilities")))
      .build();

      CreateNotificationChannelOptions createNotificationChannelOptions = new CreateNotificationChannelOptions.Builder()
      .accountId(accountID)
      .name(testString)
      .type("Webhook")
      .endpoint("https://webhook.site/136fe1e2-3c3f-4bff-925f-391fbb202546")
      .description(testString)
      .severity(new java.util.ArrayList<String>(java.util.Arrays.asList("low")))
      .enabled(true)
      .alertSource(new java.util.ArrayList<NotificationChannelAlertSourceItem>(java.util.Arrays.asList(notificationChannelAlertSourceItemModel)))
      .build();

      // Invoke operation
      Response<ChannelInfo> createChannelResp = service.createNotificationChannel(createNotificationChannelOptions).execute();

      DeleteNotificationChannelsOptions deleteNotificationChannelsOptions = new DeleteNotificationChannelsOptions.Builder()
      .accountId(accountID)
      .body(new java.util.ArrayList<String>(java.util.Arrays.asList(createChannelResp.getResult().getChannelId())))
      .build();

      // Invoke operation
      Response<ChannelsDelete> deleteChannelResp = service.deleteNotificationChannels(deleteNotificationChannelsOptions).execute();
      // Validate response
      assertNotNull(deleteChannelResp);
      assertEquals(deleteChannelResp.getStatusCode(), 200);

      ChannelsDelete channelsDeleteResult = deleteChannelResp.getResult();

      assertNotNull(channelsDeleteResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterClass
  public void tearDown() {
    service = Notifications.newInstance();
    config = CredentialUtils.getServiceProperties(Notifications.DEFAULT_SERVICE_NAME);
    System.out.println("Clean up complete.");

    System.out.println(String.format("cleaning up account: %s", accountID));

    ListAllChannelsOptions listAllChannelsOptions = new ListAllChannelsOptions.Builder()
    .accountId(accountID)
    .build();

    Response<ChannelsList> channels = service.listAllChannels(listAllChannelsOptions).execute();
    for(Channel channel: channels.getResult().getChannels()) {
      if (channel.getChannelId() == channelID) {
        DeleteNotificationChannelOptions deleteNotificationChannelOptions = new DeleteNotificationChannelOptions.Builder()
        .accountId(accountID)
        .channelId(channelID)
        .build();

        service.deleteNotificationChannel(deleteNotificationChannelOptions);
      }
    }
    System.out.println("cleanup was successful");
  }
 }
