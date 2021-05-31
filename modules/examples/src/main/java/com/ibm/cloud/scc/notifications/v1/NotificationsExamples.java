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
import com.ibm.cloud.scc.notifications.v1.model.PublicKeyGet;
import com.ibm.cloud.scc.notifications.v1.model.TestChannel;
import com.ibm.cloud.scc.notifications.v1.model.TestNotificationChannelOptions;
import com.ibm.cloud.scc.notifications.v1.model.UpdateNotificationChannelOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This file provides an example of how to use the Notifications service.
//
// The following configuration properties are assumed to be defined:
// NOTIFICATIONS_URL=<service base url>
// NOTIFICATIONS_AUTH_TYPE=iam
// NOTIFICATIONS_APIKEY=<IAM apikey>
// NOTIFICATIONS_AUTH_URL=<IAM token service base URL - omit this if using the production environment>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class NotificationsExamples {
  private static final Logger logger = LoggerFactory.getLogger(NotificationsExamples.class);
  protected NotificationsExamples() { }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    Notifications service = Notifications.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(Notifications.DEFAULT_SERVICE_NAME);

    try {
      System.out.println("listAllChannels() result:");
      // begin-listAllChannels
      ListAllChannelsOptions listAllChannelsOptions = new ListAllChannelsOptions.Builder()
        .accountId("testString")
        .build();

      Response<ChannelsList> response = service.listAllChannels(listAllChannelsOptions).execute();
      ChannelsList channelsList = response.getResult();

      System.out.println(channelsList);
      // end-listAllChannels
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createNotificationChannel() result:");
      // begin-createNotificationChannel
      CreateNotificationChannelOptions createNotificationChannelOptions = new CreateNotificationChannelOptions.Builder()
        .accountId("testString")
        .name("testString")
        .type("Webhook")
        .endpoint("testString")
        .build();

      Response<ChannelInfo> response = service.createNotificationChannel(createNotificationChannelOptions).execute();
      ChannelInfo channelInfo = response.getResult();

      System.out.println(channelInfo);
      // end-createNotificationChannel
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getNotificationChannel() result:");
      // begin-getNotificationChannel
      GetNotificationChannelOptions getNotificationChannelOptions = new GetNotificationChannelOptions.Builder()
        .accountId("testString")
        .channelId("testString")
        .build();

      Response<ChannelGet> response = service.getNotificationChannel(getNotificationChannelOptions).execute();
      ChannelGet channelGet = response.getResult();

      System.out.println(channelGet);
      // end-getNotificationChannel
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateNotificationChannel() result:");
      // begin-updateNotificationChannel
      UpdateNotificationChannelOptions updateNotificationChannelOptions = new UpdateNotificationChannelOptions.Builder()
        .accountId("testString")
        .channelId("testString")
        .name("testString")
        .type("Webhook")
        .endpoint("testString")
        .build();

      Response<ChannelInfo> response = service.updateNotificationChannel(updateNotificationChannelOptions).execute();
      ChannelInfo channelInfo = response.getResult();

      System.out.println(channelInfo);
      // end-updateNotificationChannel
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("testNotificationChannel() result:");
      // begin-testNotificationChannel
      TestNotificationChannelOptions testNotificationChannelOptions = new TestNotificationChannelOptions.Builder()
        .accountId("testString")
        .channelId("testString")
        .build();

      Response<TestChannel> response = service.testNotificationChannel(testNotificationChannelOptions).execute();
      TestChannel testChannel = response.getResult();

      System.out.println(testChannel);
      // end-testNotificationChannel
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getPublicKey() result:");
      // begin-getPublicKey
      GetPublicKeyOptions getPublicKeyOptions = new GetPublicKeyOptions.Builder()
        .accountId("testString")
        .build();

      Response<PublicKeyGet> response = service.getPublicKey(getPublicKeyOptions).execute();
      PublicKeyGet publicKeyGet = response.getResult();

      System.out.println(publicKeyGet);
      // end-getPublicKey
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("deleteNotificationChannels() result:");
      // begin-deleteNotificationChannels
      DeleteNotificationChannelsOptions deleteNotificationChannelsOptions = new DeleteNotificationChannelsOptions.Builder()
        .accountId("testString")
        .body(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
        .build();

      Response<ChannelsDelete> response = service.deleteNotificationChannels(deleteNotificationChannelsOptions).execute();
      ChannelsDelete channelsDelete = response.getResult();

      System.out.println(channelsDelete);
      // end-deleteNotificationChannels
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("deleteNotificationChannel() result:");
      // begin-deleteNotificationChannel
      DeleteNotificationChannelOptions deleteNotificationChannelOptions = new DeleteNotificationChannelOptions.Builder()
        .accountId("testString")
        .channelId("testString")
        .build();

      Response<ChannelDelete> response = service.deleteNotificationChannel(deleteNotificationChannelOptions).execute();
      ChannelDelete channelDelete = response.getResult();

      System.out.println(channelDelete);
      // end-deleteNotificationChannel
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
