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
 * IBM OpenAPI SDK Code Generator Version: 3.30.0-bd714324-20210406-200538
 */

package com.ibm.cloud.security_and_compliance_center.notifications_api.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.security_and_compliance_center.common.SdkCommon;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.BulkDeleteChannelsResponse;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.CreateChannelsResponse;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.CreateNotificationChannelOptions;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.DeleteChannelResponse;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.DeleteNotificationChannelOptions;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.DeleteNotificationChannelsOptions;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.GetChannelResponse;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.GetNotificationChannelOptions;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.GetPublicKeyOptions;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.ListAllChannelsOptions;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.ListChannelsResponse;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.PublicKeyResponse;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.TestChannelResponse;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.TestNotificationChannelOptions;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.UpdateChannelResponse;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.UpdateNotificationChannelOptions;
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
 * notifications-api.
 *
 * @version v1
 */
public class NotificationsApi extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "notifications_api";

  public static final String DEFAULT_SERVICE_URL = "https://notifications-api.cloud.ibm.com/notifications";

 /**
   * Class method which constructs an instance of the `NotificationsApi` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `NotificationsApi` client using external configuration
   */
  public static NotificationsApi newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `NotificationsApi` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `NotificationsApi` client using external configuration
   */
  public static NotificationsApi newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    NotificationsApi service = new NotificationsApi(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `NotificationsApi` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public NotificationsApi(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * list all channels.
   *
   * list all channels under this account.
   *
   * @param listAllChannelsOptions the {@link ListAllChannelsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListChannelsResponse}
   */
  public ServiceCall<ListChannelsResponse> listAllChannels(ListAllChannelsOptions listAllChannelsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listAllChannelsOptions,
      "listAllChannelsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", listAllChannelsOptions.accountId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/notifications/channels", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("notifications_api", "v1", "listAllChannels");
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
    ResponseConverter<ListChannelsResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListChannelsResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * create notification channel.
   *
   * create notification channel.
   *
   * @param createNotificationChannelOptions the {@link CreateNotificationChannelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CreateChannelsResponse}
   */
  public ServiceCall<CreateChannelsResponse> createNotificationChannel(CreateNotificationChannelOptions createNotificationChannelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createNotificationChannelOptions,
      "createNotificationChannelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", createNotificationChannelOptions.accountId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/notifications/channels", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("notifications_api", "v1", "createNotificationChannel");
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
    ResponseConverter<CreateChannelsResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CreateChannelsResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * bulk delete of channels.
   *
   * bulk delete of channels.
   *
   * @param deleteNotificationChannelsOptions the {@link DeleteNotificationChannelsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BulkDeleteChannelsResponse}
   */
  public ServiceCall<BulkDeleteChannelsResponse> deleteNotificationChannels(DeleteNotificationChannelsOptions deleteNotificationChannelsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteNotificationChannelsOptions,
      "deleteNotificationChannelsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", deleteNotificationChannelsOptions.accountId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/notifications/channels", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("notifications_api", "v1", "deleteNotificationChannels");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteNotificationChannelsOptions.transactionId() != null) {
      builder.header("Transaction-Id", deleteNotificationChannelsOptions.transactionId());
    }
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(deleteNotificationChannelsOptions.body()), "application/json");
    ResponseConverter<BulkDeleteChannelsResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<BulkDeleteChannelsResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * delete the details of a specific channel.
   *
   * delete the details of a specific channel.
   *
   * @param deleteNotificationChannelOptions the {@link DeleteNotificationChannelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DeleteChannelResponse}
   */
  public ServiceCall<DeleteChannelResponse> deleteNotificationChannel(DeleteNotificationChannelOptions deleteNotificationChannelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteNotificationChannelOptions,
      "deleteNotificationChannelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", deleteNotificationChannelOptions.accountId());
    pathParamsMap.put("channel_id", deleteNotificationChannelOptions.channelId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/notifications/channels/{channel_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("notifications_api", "v1", "deleteNotificationChannel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteNotificationChannelOptions.transactionId() != null) {
      builder.header("Transaction-Id", deleteNotificationChannelOptions.transactionId());
    }
    ResponseConverter<DeleteChannelResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DeleteChannelResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * get the details of a specific channel.
   *
   * get the details of a specific channel.
   *
   * @param getNotificationChannelOptions the {@link GetNotificationChannelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetChannelResponse}
   */
  public ServiceCall<GetChannelResponse> getNotificationChannel(GetNotificationChannelOptions getNotificationChannelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getNotificationChannelOptions,
      "getNotificationChannelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", getNotificationChannelOptions.accountId());
    pathParamsMap.put("channel_id", getNotificationChannelOptions.channelId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/notifications/channels/{channel_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("notifications_api", "v1", "getNotificationChannel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getNotificationChannelOptions.transactionId() != null) {
      builder.header("Transaction-Id", getNotificationChannelOptions.transactionId());
    }
    ResponseConverter<GetChannelResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetChannelResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * update notification channel.
   *
   * update notification channel.
   *
   * @param updateNotificationChannelOptions the {@link UpdateNotificationChannelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link UpdateChannelResponse}
   */
  public ServiceCall<UpdateChannelResponse> updateNotificationChannel(UpdateNotificationChannelOptions updateNotificationChannelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateNotificationChannelOptions,
      "updateNotificationChannelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", updateNotificationChannelOptions.accountId());
    pathParamsMap.put("channel_id", updateNotificationChannelOptions.channelId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/notifications/channels/{channel_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("notifications_api", "v1", "updateNotificationChannel");
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
    ResponseConverter<UpdateChannelResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<UpdateChannelResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * test notification channel.
   *
   * test a nofication channel under this account.
   *
   * @param testNotificationChannelOptions the {@link TestNotificationChannelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TestChannelResponse}
   */
  public ServiceCall<TestChannelResponse> testNotificationChannel(TestNotificationChannelOptions testNotificationChannelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(testNotificationChannelOptions,
      "testNotificationChannelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", testNotificationChannelOptions.accountId());
    pathParamsMap.put("channel_id", testNotificationChannelOptions.channelId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/notifications/channels/{channel_id}/test", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("notifications_api", "v1", "testNotificationChannel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (testNotificationChannelOptions.transactionId() != null) {
      builder.header("Transaction-Id", testNotificationChannelOptions.transactionId());
    }
    ResponseConverter<TestChannelResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TestChannelResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * fetch notifications public key.
   *
   * fetch public key to decrypt messages in notification payload.
   *
   * @param getPublicKeyOptions the {@link GetPublicKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PublicKeyResponse}
   */
  public ServiceCall<PublicKeyResponse> getPublicKey(GetPublicKeyOptions getPublicKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getPublicKeyOptions,
      "getPublicKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", getPublicKeyOptions.accountId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/notifications/public_key", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("notifications_api", "v1", "getPublicKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getPublicKeyOptions.transactionId() != null) {
      builder.header("Transaction-Id", getPublicKeyOptions.transactionId());
    }
    ResponseConverter<PublicKeyResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PublicKeyResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
