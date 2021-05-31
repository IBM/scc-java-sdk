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

/*
 * IBM OpenAPI SDK Code Generator Version: 3.32.0-4c6a3129-20210514-210323
 */

package com.ibm.cloud.scc.notifications.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.scc.common.SdkCommon;
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
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * API specification for the Notifications service.
 *
 * @version v1
 */
public class Notifications extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "notifications";

  public static final String DEFAULT_SERVICE_URL = "https://us-south.secadvisor.cloud.ibm.com/notifications";

 /**
   * Class method which constructs an instance of the `Notifications` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `Notifications` client using external configuration
   */
  public static Notifications newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `Notifications` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `Notifications` client using external configuration
   */
  public static Notifications newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    Notifications service = new Notifications(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `Notifications` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public Notifications(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * list all channels.
   *
   * list all channels under this account.
   *
   * @param listAllChannelsOptions the {@link ListAllChannelsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ChannelsList}
   */
  public ServiceCall<ChannelsList> listAllChannels(ListAllChannelsOptions listAllChannelsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listAllChannelsOptions,
      "listAllChannelsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", listAllChannelsOptions.accountId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/notifications/channels", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("notifications", "v1", "listAllChannels");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listAllChannelsOptions.transactionId() != null) {
      builder.header("Transaction-Id", listAllChannelsOptions.transactionId());
    }
    if (listAllChannelsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listAllChannelsOptions.limit()));
    }
    if (listAllChannelsOptions.skip() != null) {
      builder.query("skip", String.valueOf(listAllChannelsOptions.skip()));
    }
    ResponseConverter<ChannelsList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ChannelsList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * create notification channel.
   *
   * create notification channel.
   *
   * @param createNotificationChannelOptions the {@link CreateNotificationChannelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ChannelInfo}
   */
  public ServiceCall<ChannelInfo> createNotificationChannel(CreateNotificationChannelOptions createNotificationChannelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createNotificationChannelOptions,
      "createNotificationChannelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", createNotificationChannelOptions.accountId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/notifications/channels", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("notifications", "v1", "createNotificationChannel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createNotificationChannelOptions.transactionId() != null) {
      builder.header("Transaction-Id", createNotificationChannelOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createNotificationChannelOptions.name());
    contentJson.addProperty("type", createNotificationChannelOptions.type());
    contentJson.addProperty("endpoint", createNotificationChannelOptions.endpoint());
    if (createNotificationChannelOptions.description() != null) {
      contentJson.addProperty("description", createNotificationChannelOptions.description());
    }
    if (createNotificationChannelOptions.severity() != null) {
      contentJson.add("severity", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNotificationChannelOptions.severity()));
    }
    if (createNotificationChannelOptions.enabled() != null) {
      contentJson.addProperty("enabled", createNotificationChannelOptions.enabled());
    }
    if (createNotificationChannelOptions.alertSource() != null) {
      contentJson.add("alert_source", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNotificationChannelOptions.alertSource()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ChannelInfo> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ChannelInfo>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * bulk delete of channels.
   *
   * bulk delete of channels.
   *
   * @param deleteNotificationChannelsOptions the {@link DeleteNotificationChannelsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ChannelsDelete}
   */
  public ServiceCall<ChannelsDelete> deleteNotificationChannels(DeleteNotificationChannelsOptions deleteNotificationChannelsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteNotificationChannelsOptions,
      "deleteNotificationChannelsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", deleteNotificationChannelsOptions.accountId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/notifications/channels", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("notifications", "v1", "deleteNotificationChannels");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteNotificationChannelsOptions.transactionId() != null) {
      builder.header("Transaction-Id", deleteNotificationChannelsOptions.transactionId());
    }
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(deleteNotificationChannelsOptions.body()), "application/json");
    ResponseConverter<ChannelsDelete> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ChannelsDelete>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * delete the details of a specific channel.
   *
   * delete the details of a specific channel.
   *
   * @param deleteNotificationChannelOptions the {@link DeleteNotificationChannelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ChannelDelete}
   */
  public ServiceCall<ChannelDelete> deleteNotificationChannel(DeleteNotificationChannelOptions deleteNotificationChannelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteNotificationChannelOptions,
      "deleteNotificationChannelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", deleteNotificationChannelOptions.accountId());
    pathParamsMap.put("channel_id", deleteNotificationChannelOptions.channelId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/notifications/channels/{channel_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("notifications", "v1", "deleteNotificationChannel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteNotificationChannelOptions.transactionId() != null) {
      builder.header("Transaction-Id", deleteNotificationChannelOptions.transactionId());
    }
    ResponseConverter<ChannelDelete> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ChannelDelete>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * get the details of a specific channel.
   *
   * get the details of a specific channel.
   *
   * @param getNotificationChannelOptions the {@link GetNotificationChannelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ChannelGet}
   */
  public ServiceCall<ChannelGet> getNotificationChannel(GetNotificationChannelOptions getNotificationChannelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getNotificationChannelOptions,
      "getNotificationChannelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", getNotificationChannelOptions.accountId());
    pathParamsMap.put("channel_id", getNotificationChannelOptions.channelId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/notifications/channels/{channel_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("notifications", "v1", "getNotificationChannel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getNotificationChannelOptions.transactionId() != null) {
      builder.header("Transaction-Id", getNotificationChannelOptions.transactionId());
    }
    ResponseConverter<ChannelGet> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ChannelGet>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * update notification channel.
   *
   * update notification channel.
   *
   * @param updateNotificationChannelOptions the {@link UpdateNotificationChannelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ChannelInfo}
   */
  public ServiceCall<ChannelInfo> updateNotificationChannel(UpdateNotificationChannelOptions updateNotificationChannelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateNotificationChannelOptions,
      "updateNotificationChannelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", updateNotificationChannelOptions.accountId());
    pathParamsMap.put("channel_id", updateNotificationChannelOptions.channelId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/notifications/channels/{channel_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("notifications", "v1", "updateNotificationChannel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (updateNotificationChannelOptions.transactionId() != null) {
      builder.header("Transaction-Id", updateNotificationChannelOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", updateNotificationChannelOptions.name());
    contentJson.addProperty("type", updateNotificationChannelOptions.type());
    contentJson.addProperty("endpoint", updateNotificationChannelOptions.endpoint());
    if (updateNotificationChannelOptions.description() != null) {
      contentJson.addProperty("description", updateNotificationChannelOptions.description());
    }
    if (updateNotificationChannelOptions.severity() != null) {
      contentJson.add("severity", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNotificationChannelOptions.severity()));
    }
    if (updateNotificationChannelOptions.enabled() != null) {
      contentJson.addProperty("enabled", updateNotificationChannelOptions.enabled());
    }
    if (updateNotificationChannelOptions.alertSource() != null) {
      contentJson.add("alert_source", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNotificationChannelOptions.alertSource()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ChannelInfo> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ChannelInfo>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * test notification channel.
   *
   * test a nofication channel under this account.
   *
   * @param testNotificationChannelOptions the {@link TestNotificationChannelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TestChannel}
   */
  public ServiceCall<TestChannel> testNotificationChannel(TestNotificationChannelOptions testNotificationChannelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(testNotificationChannelOptions,
      "testNotificationChannelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", testNotificationChannelOptions.accountId());
    pathParamsMap.put("channel_id", testNotificationChannelOptions.channelId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/notifications/channels/{channel_id}/test", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("notifications", "v1", "testNotificationChannel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (testNotificationChannelOptions.transactionId() != null) {
      builder.header("Transaction-Id", testNotificationChannelOptions.transactionId());
    }
    ResponseConverter<TestChannel> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TestChannel>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * fetch notifications public key.
   *
   * fetch public key to decrypt messages in notification payload.
   *
   * @param getPublicKeyOptions the {@link GetPublicKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PublicKeyGet}
   */
  public ServiceCall<PublicKeyGet> getPublicKey(GetPublicKeyOptions getPublicKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getPublicKeyOptions,
      "getPublicKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", getPublicKeyOptions.accountId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/notifications/public_key", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("notifications", "v1", "getPublicKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getPublicKeyOptions.transactionId() != null) {
      builder.header("Transaction-Id", getPublicKeyOptions.transactionId());
    }
    ResponseConverter<PublicKeyGet> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PublicKeyGet>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}