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

/*
 * IBM OpenAPI SDK Code Generator Version: 3.46.0-a4e29da0-20220224-210428
 */

package com.ibm.cloud.scc.addon_mgr.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.scc.addon_mgr.v1.model.AddActivityInsightsCosDetailsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.AddNetworkInsightsCosDetailsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.AllInsights;
import com.ibm.cloud.scc.addon_mgr.v1.model.DeleteActivityInsightsCosDetailsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.DeleteNetworkInsightsCosDetailsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.DisableInsightsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.EnableInsightsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.GetSupportedInsightsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.TestAIFindingsV2Options;
import com.ibm.cloud.scc.common.SdkCommon;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The Addon Manager API.
 *
 * API Version: 1.0.0
 */
public class AddonMgr extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "addon_mgr";

  public static final String DEFAULT_SERVICE_URL = "https://us-south.secadvisor.cloud.ibm.com/addonmgr";

  private static final Map<String, String> _regionalEndpoints;
  static {
    Map<String, String> m = new HashMap<>();
    m.put("us-south", "https://us-south.secadvisor.cloud.ibm.com/addonmgr");
    m.put("us-east", "https://us-south.secadvisor.cloud.ibm.com/addonmgr");
    m.put("eu-gb", "https://eu-gb.secadvisor.cloud.ibm.com/addonmgr");
    m.put("eu-de", "https://eu.compliance.cloud.ibm.com/si/addonmgr");
    _regionalEndpoints = Collections.unmodifiableMap(m);
  }

  /**
   * Returns the service URL associated with the specified region.
   * @param region a string representing the region
   * @return the service URL associated with the specified region or null
   * if no mapping for the region exists
   */
  public static String getServiceUrlForRegion(String region) {
    return _regionalEndpoints.get(region);
  }

  private String accountId;

 /**
   * Class method which constructs an instance of the `AddonMgr` client.
   * The default service name is used to configure the client instance.
   *
   * @param accountId Account ID.
   * @return an instance of the `AddonMgr` client using external configuration
   */
  public static AddonMgr newInstance(String accountId) {
    return newInstance(accountId, DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `AddonMgr` client.
   * The specified service name is used to configure the client instance.
   *
   * @param accountId Account ID.
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `AddonMgr` client using external configuration
   */
  public static AddonMgr newInstance(String accountId, String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    AddonMgr service = new AddonMgr(accountId, serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `AddonMgr` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param accountId Account ID.
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public AddonMgr(String accountId, String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
    setAccountId(accountId);
  }

  /**
   * Gets the accountId.
   *
   * Account ID.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return this.accountId;
  }

  /**
   * Sets the accountId.
   *
   * @param accountId the new accountId
   */
  public void setAccountId(final String accountId) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(accountId, "accountId cannot be empty.");
    this.accountId = accountId;
  }

  /**
   * Add cos details.
   *
   * Addcos details.
   *
   * @param addNetworkInsightsCosDetailsV2Options the {@link AddNetworkInsightsCosDetailsV2Options} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> addNetworkInsightsCosDetailsV2(AddNetworkInsightsCosDetailsV2Options addNetworkInsightsCosDetailsV2Options) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addNetworkInsightsCosDetailsV2Options,
      "addNetworkInsightsCosDetailsV2Options cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/addons/{account_id}/network-insights/cos", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("addon_mgr", "v1", "addNetworkInsightsCosDetailsV2");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (addNetworkInsightsCosDetailsV2Options.transactionId() != null) {
      builder.header("Transaction-Id", addNetworkInsightsCosDetailsV2Options.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("region_id", addNetworkInsightsCosDetailsV2Options.regionId());
    contentJson.add("cos_details", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(addNetworkInsightsCosDetailsV2Options.cosDetails()));
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete cos details.
   *
   * Delete NA cos details.
   *
   * @param deleteNetworkInsightsCosDetailsV2Options the {@link DeleteNetworkInsightsCosDetailsV2Options} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteNetworkInsightsCosDetailsV2(DeleteNetworkInsightsCosDetailsV2Options deleteNetworkInsightsCosDetailsV2Options) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteNetworkInsightsCosDetailsV2Options,
      "deleteNetworkInsightsCosDetailsV2Options cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/addons/{account_id}/network-insights/cos", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("addon_mgr", "v1", "deleteNetworkInsightsCosDetailsV2");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteNetworkInsightsCosDetailsV2Options.transactionId() != null) {
      builder.header("Transaction-Id", deleteNetworkInsightsCosDetailsV2Options.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    if (deleteNetworkInsightsCosDetailsV2Options.ids() != null) {
      contentJson.add("ids", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(deleteNetworkInsightsCosDetailsV2Options.ids()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete cos details.
   *
   * Delete NA cos details.
   *
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteNetworkInsightsCosDetailsV2() {
    return deleteNetworkInsightsCosDetailsV2(null);
  }

  /**
   * Add cos details.
   *
   * Addcos details.
   *
   * @param addActivityInsightsCosDetailsV2Options the {@link AddActivityInsightsCosDetailsV2Options} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> addActivityInsightsCosDetailsV2(AddActivityInsightsCosDetailsV2Options addActivityInsightsCosDetailsV2Options) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addActivityInsightsCosDetailsV2Options,
      "addActivityInsightsCosDetailsV2Options cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/addons/{account_id}/activity-insights/cos", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("addon_mgr", "v1", "addActivityInsightsCosDetailsV2");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (addActivityInsightsCosDetailsV2Options.transactionId() != null) {
      builder.header("Transaction-Id", addActivityInsightsCosDetailsV2Options.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("region_id", addActivityInsightsCosDetailsV2Options.regionId());
    contentJson.add("cos_details", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(addActivityInsightsCosDetailsV2Options.cosDetails()));
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete cos details.
   *
   * Delete AT cos details.
   *
   * @param deleteActivityInsightsCosDetailsV2Options the {@link DeleteActivityInsightsCosDetailsV2Options} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteActivityInsightsCosDetailsV2(DeleteActivityInsightsCosDetailsV2Options deleteActivityInsightsCosDetailsV2Options) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteActivityInsightsCosDetailsV2Options,
      "deleteActivityInsightsCosDetailsV2Options cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/addons/{account_id}/activity-insights/cos", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("addon_mgr", "v1", "deleteActivityInsightsCosDetailsV2");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteActivityInsightsCosDetailsV2Options.transactionId() != null) {
      builder.header("Transaction-Id", deleteActivityInsightsCosDetailsV2Options.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    if (deleteActivityInsightsCosDetailsV2Options.ids() != null) {
      contentJson.add("ids", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(deleteActivityInsightsCosDetailsV2Options.ids()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete cos details.
   *
   * Delete AT cos details.
   *
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteActivityInsightsCosDetailsV2() {
    return deleteActivityInsightsCosDetailsV2(null);
  }

  /**
   * Disable add-on.
   *
   * Disable add-on.
   *
   * @param disableInsightsV2Options the {@link DisableInsightsV2Options} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> disableInsightsV2(DisableInsightsV2Options disableInsightsV2Options) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(disableInsightsV2Options,
      "disableInsightsV2Options cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/addons/{account_id}/disable", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("addon_mgr", "v1", "disableInsightsV2");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (disableInsightsV2Options.transactionId() != null) {
      builder.header("Transaction-Id", disableInsightsV2Options.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("region_id", disableInsightsV2Options.regionId());
    if (disableInsightsV2Options.networkInsights() != null) {
      contentJson.addProperty("network-insights", disableInsightsV2Options.networkInsights());
    }
    if (disableInsightsV2Options.activityInsights() != null) {
      contentJson.addProperty("activity-insights", disableInsightsV2Options.activityInsights());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Enable add-on.
   *
   * Enable add-on.
   *
   * @param enableInsightsV2Options the {@link EnableInsightsV2Options} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> enableInsightsV2(EnableInsightsV2Options enableInsightsV2Options) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(enableInsightsV2Options,
      "enableInsightsV2Options cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/addons/{account_id}/enable", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("addon_mgr", "v1", "enableInsightsV2");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (enableInsightsV2Options.transactionId() != null) {
      builder.header("Transaction-Id", enableInsightsV2Options.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("region_id", enableInsightsV2Options.regionId());
    if (enableInsightsV2Options.networkInsights() != null) {
      contentJson.addProperty("network-insights", enableInsightsV2Options.networkInsights());
    }
    if (enableInsightsV2Options.activityInsights() != null) {
      contentJson.addProperty("activity-insights", enableInsightsV2Options.activityInsights());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Fetch supported insights.
   *
   * Retrieve insights details.
   *
   * @param getSupportedInsightsV2Options the {@link GetSupportedInsightsV2Options} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AllInsights}
   */
  public ServiceCall<AllInsights> getSupportedInsightsV2(GetSupportedInsightsV2Options getSupportedInsightsV2Options) {
    if (getSupportedInsightsV2Options == null) {
      getSupportedInsightsV2Options = new GetSupportedInsightsV2Options.Builder().build();
    }
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/addons/{account_id}/insights", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("addon_mgr", "v1", "getSupportedInsightsV2");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getSupportedInsightsV2Options.transactionId() != null) {
      builder.header("Transaction-Id", getSupportedInsightsV2Options.transactionId());
    }
    ResponseConverter<AllInsights> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AllInsights>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Fetch supported insights.
   *
   * Retrieve insights details.
   *
   * @return a {@link ServiceCall} with a result of type {@link AllInsights}
   */
  public ServiceCall<AllInsights> getSupportedInsightsV2() {
    return getSupportedInsightsV2(null);
  }

  /**
   * test findings for activity-insights.
   *
   * Test findings for activity-insights.
   *
   * @param testAiFindingsV2Options the {@link TestAIFindingsV2Options} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> testAiFindingsV2(TestAIFindingsV2Options testAiFindingsV2Options) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(testAiFindingsV2Options,
      "testAiFindingsV2Options cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/addons/{account_id}/activity-insights/test-ai-findings", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("addon_mgr", "v1", "testAiFindingsV2");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("region_id", testAiFindingsV2Options.regionId());
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
