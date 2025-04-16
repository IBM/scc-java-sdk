/*
 * (C) Copyright IBM Corp. 2025.
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
 * IBM OpenAPI SDK Code Generator Version: 3.98.0-8be2046a-20241205-162752
 */

package com.ibm.cloud.security_and_compliance_center_api.v3;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.cloud.security_and_compliance_center_api.common.SdkCommon;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ComparePredefinedProfilesResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CompareProfilesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibrary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibraryCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateProfileAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateScanOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateScanReport;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateScanReportOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateScanResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateScopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateSubscopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateTargetOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteCustomControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteCustomProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteProfileAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteScopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteSubscopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteTargetOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EvaluationPage;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetLatestReportsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProfileAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProviderTypeByIdOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportControlsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportDownloadFileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportSummaryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportTagsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportViolationsDriftOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetScanReportDownloadFileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetScanReportOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetScopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetServiceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetSettingsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetSubscopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetTargetOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListControlLibrariesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListInstanceAttachmentsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListProfileAttachmentsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListProfileParametersOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListProfilesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListProviderTypeInstancesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListProviderTypesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListReportEvaluationsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListReportResourcesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListReportsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListRulesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListScanReportsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListScopesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListServicesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListSubscopesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListTargetsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PostTestEventOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Profile;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileAttachment;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileAttachmentCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileAttachmentResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileDefaultParametersResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderType;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderTypeCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderTypeInstance;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderTypeInstanceCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceCustomControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceProfileAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceProfileParametersOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceTargetOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Report;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportLatest;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportSummary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportTags;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportViolationsDrift;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ResourcePage;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Rule;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RuleCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RuleInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScanReport;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScanReportCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Scope;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopeCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Service;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ServiceCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Settings;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.SubScope;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.SubScopeCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.SubScopeResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Target;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.TargetCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.TestEvent;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateScopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateSettingsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateSubscopeOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpgradeAttachmentOptions;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The Security and Compliance Center API reference.
 *
 */
public class SecurityAndComplianceCenterApi extends BaseService {

  /**
   * Default service name used when configuring the `SecurityAndComplianceCenterApi` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "security_and_compliance_center_api";

  /**
   * Default service endpoint URL.
   */
  public static final String DEFAULT_SERVICE_URL = "https://us-south.compliance.cloud.ibm.com";

  private static final Map<String, String> _regionalEndpoints;
  static {
    Map<String, String> m = new HashMap<>();
    m.put("us-south", "https://us-south.compliance.cloud.ibm.com"); // Dallas region

    m.put("eu-de", "https://eu-de.compliance.cloud.ibm.com"); // Frankfurt region

    m.put("eu-fr2", "https://eu-fr2.compliance.cloud.ibm.com"); // Frankfurt region(Restricted)

    m.put("ca-tor", "https://ca-tor.compliance.cloud.ibm.com"); // Toronto region

    m.put("au-syd", "https://au-syd.compliance.cloud.ibm.com"); // Sydney region

    m.put("eu-es", "https://eu-es.compliance.cloud.ibm.com"); // Madrid region
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

 /**
   * Class method which constructs an instance of the `SecurityAndComplianceCenterApi` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `SecurityAndComplianceCenterApi` client using external configuration
   */
  public static SecurityAndComplianceCenterApi newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `SecurityAndComplianceCenterApi` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `SecurityAndComplianceCenterApi` client using external configuration
   */
  public static SecurityAndComplianceCenterApi newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    SecurityAndComplianceCenterApi service = new SecurityAndComplianceCenterApi(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `SecurityAndComplianceCenterApi` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public SecurityAndComplianceCenterApi(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * List settings.
   *
   * Retrieve the settings of your service instance.
   *
   * @param getSettingsOptions the {@link GetSettingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Settings}
   */
  public ServiceCall<Settings> getSettings(GetSettingsOptions getSettingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getSettingsOptions,
      "getSettingsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getSettingsOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/settings", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getSettings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Settings> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Settings>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update settings.
   *
   * Update the settings of your service instance.
   *
   * @param updateSettingsOptions the {@link UpdateSettingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Settings}
   */
  public ServiceCall<Settings> updateSettings(UpdateSettingsOptions updateSettingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateSettingsOptions,
      "updateSettingsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", updateSettingsOptions.instanceId());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/settings", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "updateSettings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (updateSettingsOptions.objectStorage() != null) {
      contentJson.add("object_storage", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateSettingsOptions.objectStorage()));
    }
    if (updateSettingsOptions.eventNotifications() != null) {
      contentJson.add("event_notifications", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateSettingsOptions.eventNotifications()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Settings> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Settings>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a test event.
   *
   * Send a test event to your Event Notifications instance to ensure that the events that are generated  by Security
   * and Compliance Center are being forwarded to Event Notifications. For more information, see [Enabling event
   * notifications](/docs/security-compliance?topic=security-compliance-event-notifications#event-notifications-test-api).
   *
   * @param postTestEventOptions the {@link PostTestEventOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TestEvent}
   */
  public ServiceCall<TestEvent> postTestEvent(PostTestEventOptions postTestEventOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postTestEventOptions,
      "postTestEventOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", postTestEventOptions.instanceId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/test_event", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "postTestEvent");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<TestEvent> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TestEvent>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all instance attachments.
   *
   * Retrieve all instance attachments.
   *
   * With Security and Compliance Center, you can evaluate your resources on a recurring schedule or you can initiate a
   * scan at any time. To evaluate your resources, you create an attachment. An attachment is the association between
   * the set of resources that you want to evaluate and a profile that contains the specific controls that you want to
   * use. For more information, see [Running an evaluation for IBM
   * Cloud](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-scan-resources).
   *
   * @param listInstanceAttachmentsOptions the {@link ListInstanceAttachmentsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileAttachmentCollection}
   */
  public ServiceCall<ProfileAttachmentCollection> listInstanceAttachments(ListInstanceAttachmentsOptions listInstanceAttachmentsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listInstanceAttachmentsOptions,
      "listInstanceAttachmentsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listInstanceAttachmentsOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/attachments", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listInstanceAttachments");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listInstanceAttachmentsOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(listInstanceAttachmentsOptions.accountId()));
    }
    if (listInstanceAttachmentsOptions.versionGroupLabel() != null) {
      builder.query("version_group_label", String.valueOf(listInstanceAttachmentsOptions.versionGroupLabel()));
    }
    if (listInstanceAttachmentsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listInstanceAttachmentsOptions.limit()));
    }
    if (listInstanceAttachmentsOptions.sort() != null) {
      builder.query("sort", String.valueOf(listInstanceAttachmentsOptions.sort()));
    }
    if (listInstanceAttachmentsOptions.direction() != null) {
      builder.query("direction", String.valueOf(listInstanceAttachmentsOptions.direction()));
    }
    if (listInstanceAttachmentsOptions.start() != null) {
      builder.query("start", String.valueOf(listInstanceAttachmentsOptions.start()));
    }
    ResponseConverter<ProfileAttachmentCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileAttachmentCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create an attachment.
   *
   * Create an attachment to link to a profile.
   *
   * With Security and Compliance Center, you can evaluate your resources on a recurring schedule or you can initiate a
   * scan at any time. To evaluate your resources, you create an attachment. An attachment is the association between
   * the set of resources that you want to evaluate and a profile that contains the specific controls that you want to
   * use. For more information, see [Running an evaluation for IBM
   * Cloud](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-scan-resources).
   *
   * @param createProfileAttachmentOptions the {@link CreateProfileAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileAttachmentResponse}
   */
  public ServiceCall<ProfileAttachmentResponse> createProfileAttachment(CreateProfileAttachmentOptions createProfileAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createProfileAttachmentOptions,
      "createProfileAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", createProfileAttachmentOptions.instanceId());
    pathParamsMap.put("profile_id", createProfileAttachmentOptions.profileId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profile_id}/attachments", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "createProfileAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createProfileAttachmentOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(createProfileAttachmentOptions.accountId()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("attachments", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createProfileAttachmentOptions.newAttachments()));
    if (createProfileAttachmentOptions.newProfileId() != null) {
      contentJson.addProperty("profile_id", createProfileAttachmentOptions.newProfileId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ProfileAttachmentResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileAttachmentResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get an attachment.
   *
   * Retrieve an attachment that is linked to a profile by specifying the attachment ID.
   *
   * With Security and Compliance Center, you can evaluate your resources on a recurring schedule or you can initiate a
   * scan at any time. To evaluate your resources, you create an attachment. An attachment is the association between
   * the set of resources that you want to evaluate and a profile that contains the specific controls that you want to
   * use. For more information, see [Running an evaluation for IBM
   * Cloud](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-scan-resources).
   *
   * @param getProfileAttachmentOptions the {@link GetProfileAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileAttachment}
   */
  public ServiceCall<ProfileAttachment> getProfileAttachment(GetProfileAttachmentOptions getProfileAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getProfileAttachmentOptions,
      "getProfileAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getProfileAttachmentOptions.instanceId());
    pathParamsMap.put("profile_id", getProfileAttachmentOptions.profileId());
    pathParamsMap.put("attachment_id", getProfileAttachmentOptions.attachmentId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profile_id}/attachments/{attachment_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getProfileAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getProfileAttachmentOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(getProfileAttachmentOptions.accountId()));
    }
    ResponseConverter<ProfileAttachment> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileAttachment>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update an attachment.
   *
   * Update an attachment that is linked to a profile.
   *
   * With Security and Compliance Center, you can evaluate your resources on a recurring schedule or you can initiate a
   * scan at any time. To evaluate your resources, you create an attachment. An attachment is the association between
   * the set of resources that you want to evaluate and a profile that contains the specific controls that you want to
   * use. For more information, see [Running an evaluation for IBM
   * Cloud](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-scan-resources).
   *
   * @param replaceProfileAttachmentOptions the {@link ReplaceProfileAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileAttachment}
   */
  public ServiceCall<ProfileAttachment> replaceProfileAttachment(ReplaceProfileAttachmentOptions replaceProfileAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceProfileAttachmentOptions,
      "replaceProfileAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", replaceProfileAttachmentOptions.instanceId());
    pathParamsMap.put("profile_id", replaceProfileAttachmentOptions.profileId());
    pathParamsMap.put("attachment_id", replaceProfileAttachmentOptions.attachmentId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profile_id}/attachments/{attachment_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "replaceProfileAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (replaceProfileAttachmentOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(replaceProfileAttachmentOptions.accountId()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("attachment_parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileAttachmentOptions.attachmentParameters()));
    contentJson.addProperty("description", replaceProfileAttachmentOptions.description());
    contentJson.addProperty("name", replaceProfileAttachmentOptions.name());
    contentJson.add("notifications", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileAttachmentOptions.notifications()));
    contentJson.addProperty("schedule", replaceProfileAttachmentOptions.schedule());
    contentJson.add("scope", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileAttachmentOptions.scope()));
    contentJson.addProperty("status", replaceProfileAttachmentOptions.status());
    if (replaceProfileAttachmentOptions.dataSelectionRange() != null) {
      contentJson.add("data_selection_range", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileAttachmentOptions.dataSelectionRange()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ProfileAttachment> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileAttachment>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete an attachment.
   *
   * Delete an attachment that is linked to a profile.
   *
   * With Security and Compliance Center, you can evaluate your resources on a recurring schedule or you can initiate a
   * scan at any time. To evaluate your resources, you create an attachment. An attachment is the association between
   * the set of resources that you want to evaluate and a profile that contains the specific controls that you want to
   * use. For more information, see [Running an evaluation for IBM
   * Cloud](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-scan-resources).
   *
   * @param deleteProfileAttachmentOptions the {@link DeleteProfileAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileAttachment}
   */
  public ServiceCall<ProfileAttachment> deleteProfileAttachment(DeleteProfileAttachmentOptions deleteProfileAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteProfileAttachmentOptions,
      "deleteProfileAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", deleteProfileAttachmentOptions.instanceId());
    pathParamsMap.put("profile_id", deleteProfileAttachmentOptions.profileId());
    pathParamsMap.put("attachment_id", deleteProfileAttachmentOptions.attachmentId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profile_id}/attachments/{attachment_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "deleteProfileAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteProfileAttachmentOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(deleteProfileAttachmentOptions.accountId()));
    }
    ResponseConverter<ProfileAttachment> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileAttachment>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Upgrade an attachment.
   *
   * Upgrade an attachment to the latest version of a profile.
   *
   * With Security and Compliance Center, you can evaluate your resources on a recurring schedule or you can initiate a
   * scan at any time. To evaluate your resources, you create an attachment. An attachment is the association between
   * the set of resources that you want to evaluate and a profile that contains the specific controls that you want to
   * use. For more information, see [Running an evaluation for IBM
   * Cloud](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-scan-resources).
   *
   * @param upgradeAttachmentOptions the {@link UpgradeAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileAttachment}
   */
  public ServiceCall<ProfileAttachment> upgradeAttachment(UpgradeAttachmentOptions upgradeAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(upgradeAttachmentOptions,
      "upgradeAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", upgradeAttachmentOptions.instanceId());
    pathParamsMap.put("profile_id", upgradeAttachmentOptions.profileId());
    pathParamsMap.put("attachment_id", upgradeAttachmentOptions.attachmentId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profile_id}/attachments/{attachment_id}/upgrade", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "upgradeAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (upgradeAttachmentOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(upgradeAttachmentOptions.accountId()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("attachment_parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(upgradeAttachmentOptions.attachmentParameters()));
    builder.bodyJson(contentJson);
    ResponseConverter<ProfileAttachment> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileAttachment>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a scan.
   *
   * Create a scan to evaluate your resources.
   *
   * With Security and Compliance Center, you can evaluate your resources on a recurring schedule. If your attachment
   * exists, but you don't want to wait for the next scan to see your posture, you can initiate an on-demand scan. For
   * more information, see [Running a scan on
   * demand](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-scan-resources#scan-ondemand-api).
   *
   * @param createScanOptions the {@link CreateScanOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CreateScanResponse}
   */
  public ServiceCall<CreateScanResponse> createScan(CreateScanOptions createScanOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createScanOptions,
      "createScanOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", createScanOptions.instanceId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/scans", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "createScan");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createScanOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(createScanOptions.accountId()));
    }
    final JsonObject contentJson = new JsonObject();
    if (createScanOptions.attachmentId() != null) {
      contentJson.addProperty("attachment_id", createScanOptions.attachmentId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<CreateScanResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CreateScanResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a custom control library.
   *
   * Create a custom control library that is specific to your organization's needs.
   *
   * With Security and Compliance Center, you can create a custom control library that is specific to your
   * organization's needs. You define the controls and specifications before you map previously created assessments.
   * Each control has several specifications and assessments that are mapped to it. A specification is a defined
   * requirement that is specific to a component. An assessment, or several, are mapped to each specification with a
   * detailed evaluation that is done to check whether the specification is compliant. For more information, see
   * [Creating custom
   * libraries](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-custom-library).
   *
   * @param createControlLibraryOptions the {@link CreateControlLibraryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ControlLibrary}
   */
  public ServiceCall<ControlLibrary> createControlLibrary(CreateControlLibraryOptions createControlLibraryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createControlLibraryOptions,
      "createControlLibraryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", createControlLibraryOptions.instanceId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/control_libraries", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "createControlLibrary");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createControlLibraryOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(createControlLibraryOptions.accountId()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("control_library_name", createControlLibraryOptions.controlLibraryName());
    contentJson.addProperty("control_library_description", createControlLibraryOptions.controlLibraryDescription());
    contentJson.addProperty("control_library_type", createControlLibraryOptions.controlLibraryType());
    contentJson.addProperty("control_library_version", createControlLibraryOptions.controlLibraryVersion());
    contentJson.add("controls", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createControlLibraryOptions.controls()));
    builder.bodyJson(contentJson);
    ResponseConverter<ControlLibrary> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ControlLibrary>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all control libraries.
   *
   * Retrieve all the control libraries, including predefined, and custom libraries.
   *
   * With Security and Compliance Center, you can create a custom control library that is specific to your
   * organization's needs. You define the controls and specifications before you map previously created assessments.
   * Each control has several specifications and assessments that are mapped to it. A specification is a defined
   * requirement that is specific to a component. An assessment, or several, are mapped to each specification with a
   * detailed evaluation that is done to check whether the specification is compliant. For more information, see
   * [Creating custom
   * libraries](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-custom-library).
   *
   * @param listControlLibrariesOptions the {@link ListControlLibrariesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ControlLibraryCollection}
   */
  public ServiceCall<ControlLibraryCollection> listControlLibraries(ListControlLibrariesOptions listControlLibrariesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listControlLibrariesOptions,
      "listControlLibrariesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listControlLibrariesOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/control_libraries", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listControlLibraries");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listControlLibrariesOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(listControlLibrariesOptions.accountId()));
    }
    if (listControlLibrariesOptions.limit() != null) {
      builder.query("limit", String.valueOf(listControlLibrariesOptions.limit()));
    }
    if (listControlLibrariesOptions.start() != null) {
      builder.query("start", String.valueOf(listControlLibrariesOptions.start()));
    }
    ResponseConverter<ControlLibraryCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ControlLibraryCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a custom control library.
   *
   * Update a custom control library by specifying its ID.
   *
   * With Security and Compliance Center, you can create a custom control library that is specific to your
   * organization's needs. You define the controls and specifications before you map previously created assessments.
   * Each control has several specifications and assessments that are mapped to it. A specification is a defined
   * requirement that is specific to a component. An assessment, or several, are mapped to each specification with a
   * detailed evaluation that is done to check whether the specification is compliant. For more information, see
   * [Creating custom
   * libraries](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-custom-library).
   *
   * @param replaceCustomControlLibraryOptions the {@link ReplaceCustomControlLibraryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ControlLibrary}
   */
  public ServiceCall<ControlLibrary> replaceCustomControlLibrary(ReplaceCustomControlLibraryOptions replaceCustomControlLibraryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceCustomControlLibraryOptions,
      "replaceCustomControlLibraryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", replaceCustomControlLibraryOptions.instanceId());
    pathParamsMap.put("control_library_id", replaceCustomControlLibraryOptions.controlLibraryId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/control_libraries/{control_library_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "replaceCustomControlLibrary");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (replaceCustomControlLibraryOptions.bssAccount() != null) {
      builder.query("bss_account", String.valueOf(replaceCustomControlLibraryOptions.bssAccount()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("control_library_name", replaceCustomControlLibraryOptions.controlLibraryName());
    contentJson.addProperty("control_library_description", replaceCustomControlLibraryOptions.controlLibraryDescription());
    contentJson.addProperty("control_library_type", replaceCustomControlLibraryOptions.controlLibraryType());
    contentJson.addProperty("control_library_version", replaceCustomControlLibraryOptions.controlLibraryVersion());
    contentJson.add("controls", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceCustomControlLibraryOptions.controls()));
    builder.bodyJson(contentJson);
    ResponseConverter<ControlLibrary> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ControlLibrary>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a control library.
   *
   * View the details of a control library by specifying its ID.
   *
   * With Security and Compliance Center, you can create a custom control library that is specific to your
   * organization's needs. You define the controls and specifications before you map previously created assessments.
   * Each control has several specifications and assessments that are mapped to it. A specification is a defined
   * requirement that is specific to a component. An assessment, or several, are mapped to each specification with a
   * detailed evaluation that is done to check whether the specification is compliant. For more information, see
   * [Creating custom
   * libraries](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-custom-library).
   *
   * @param getControlLibraryOptions the {@link GetControlLibraryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ControlLibrary}
   */
  public ServiceCall<ControlLibrary> getControlLibrary(GetControlLibraryOptions getControlLibraryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getControlLibraryOptions,
      "getControlLibraryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getControlLibraryOptions.instanceId());
    pathParamsMap.put("control_library_id", getControlLibraryOptions.controlLibraryId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/control_libraries/{control_library_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getControlLibrary");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getControlLibraryOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(getControlLibraryOptions.accountId()));
    }
    ResponseConverter<ControlLibrary> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ControlLibrary>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a custom control library.
   *
   * Delete a custom control library by specifying its ID.
   *
   * With Security and Compliance Center, you can create a custom control library that is specific to your
   * organization's needs. You define the controls and specifications before you map previously created assessments.
   * Each control has several specifications and assessments that are mapped to it. A specification is a defined
   * requirement that is specific to a component. An assessment, or several, are mapped to each specification with a
   * detailed evaluation that is done to check whether the specification is compliant. For more information, see
   * [Creating custom
   * libraries](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-custom-library).
   *
   * @param deleteCustomControlLibraryOptions the {@link DeleteCustomControlLibraryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ControlLibrary}
   */
  public ServiceCall<ControlLibrary> deleteCustomControlLibrary(DeleteCustomControlLibraryOptions deleteCustomControlLibraryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteCustomControlLibraryOptions,
      "deleteCustomControlLibraryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", deleteCustomControlLibraryOptions.instanceId());
    pathParamsMap.put("control_library_id", deleteCustomControlLibraryOptions.controlLibraryId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/control_libraries/{control_library_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "deleteCustomControlLibrary");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteCustomControlLibraryOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(deleteCustomControlLibraryOptions.accountId()));
    }
    ResponseConverter<ControlLibrary> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ControlLibrary>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a custom profile.
   *
   * Create a user-defined custom profile.
   *
   * With Security and Compliance Center, you can create a profile that is specific to your usecase, by using an
   * existing library as a starting point. For more information, see [Building custom
   * profiles](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-build-custom-profiles&amp;interface=api).
   *
   * @param createProfileOptions the {@link CreateProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Profile}
   */
  public ServiceCall<Profile> createProfile(CreateProfileOptions createProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createProfileOptions,
      "createProfileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", createProfileOptions.instanceId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "createProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createProfileOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(createProfileOptions.accountId()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("profile_name", createProfileOptions.profileName());
    contentJson.addProperty("profile_version", createProfileOptions.profileVersion());
    contentJson.add("controls", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createProfileOptions.controls()));
    contentJson.add("default_parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createProfileOptions.defaultParameters()));
    if (createProfileOptions.profileDescription() != null) {
      contentJson.addProperty("profile_description", createProfileOptions.profileDescription());
    }
    if (createProfileOptions.latest() != null) {
      contentJson.addProperty("latest", createProfileOptions.latest());
    }
    if (createProfileOptions.versionGroupLabel() != null) {
      contentJson.addProperty("version_group_label", createProfileOptions.versionGroupLabel());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Profile> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Profile>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all profiles.
   *
   * Retrieve all profiles, including predefined and custom profiles.
   *
   * With Security and Compliance Center, you can take advantage of predefined profiles that are curated based on
   * industry standards. Or you can choose to create one that is specific to your usecase by using an existing library
   * as a starting point. For more information, see [Building custom
   * profiles](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-build-custom-profiles&amp;interface=api).
   *
   * @param listProfilesOptions the {@link ListProfilesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileCollection}
   */
  public ServiceCall<ProfileCollection> listProfiles(ListProfilesOptions listProfilesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listProfilesOptions,
      "listProfilesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listProfilesOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listProfiles");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listProfilesOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(listProfilesOptions.accountId()));
    }
    if (listProfilesOptions.limit() != null) {
      builder.query("limit", String.valueOf(listProfilesOptions.limit()));
    }
    if (listProfilesOptions.start() != null) {
      builder.query("start", String.valueOf(listProfilesOptions.start()));
    }
    ResponseConverter<ProfileCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a custom profile.
   *
   * Update the details of a user-defined profile.
   *
   * With Security and Compliance Center, you can create a profile that is specific to your usecase, by using an
   * existing library as a starting point. For more information, see [Building custom
   * profiles](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-build-custom-profiles&amp;interface=api).
   *
   * @param replaceProfileOptions the {@link ReplaceProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Profile}
   */
  public ServiceCall<Profile> replaceProfile(ReplaceProfileOptions replaceProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceProfileOptions,
      "replaceProfileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", replaceProfileOptions.instanceId());
    pathParamsMap.put("profile_id", replaceProfileOptions.profileId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profile_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "replaceProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (replaceProfileOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(replaceProfileOptions.accountId()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("profile_type", replaceProfileOptions.newProfileType());
    contentJson.add("controls", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileOptions.newControls()));
    contentJson.add("default_parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileOptions.newDefaultParameters()));
    if (replaceProfileOptions.newId() != null) {
      contentJson.addProperty("id", replaceProfileOptions.newId());
    }
    if (replaceProfileOptions.newProfileName() != null) {
      contentJson.addProperty("profile_name", replaceProfileOptions.newProfileName());
    }
    if (replaceProfileOptions.newInstanceId() != null) {
      contentJson.addProperty("instance_id", replaceProfileOptions.newInstanceId());
    }
    if (replaceProfileOptions.newHierarchyEnabled() != null) {
      contentJson.addProperty("hierarchy_enabled", replaceProfileOptions.newHierarchyEnabled());
    }
    if (replaceProfileOptions.newProfileDescription() != null) {
      contentJson.addProperty("profile_description", replaceProfileOptions.newProfileDescription());
    }
    if (replaceProfileOptions.newProfileVersion() != null) {
      contentJson.addProperty("profile_version", replaceProfileOptions.newProfileVersion());
    }
    if (replaceProfileOptions.newVersionGroupLabel() != null) {
      contentJson.addProperty("version_group_label", replaceProfileOptions.newVersionGroupLabel());
    }
    if (replaceProfileOptions.newLatest() != null) {
      contentJson.addProperty("latest", replaceProfileOptions.newLatest());
    }
    if (replaceProfileOptions.newCreatedBy() != null) {
      contentJson.addProperty("created_by", replaceProfileOptions.newCreatedBy());
    }
    if (replaceProfileOptions.newCreatedOn() != null) {
      contentJson.add("created_on", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileOptions.newCreatedOn()));
    }
    if (replaceProfileOptions.newUpdatedBy() != null) {
      contentJson.addProperty("updated_by", replaceProfileOptions.newUpdatedBy());
    }
    if (replaceProfileOptions.newUpdatedOn() != null) {
      contentJson.add("updated_on", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileOptions.newUpdatedOn()));
    }
    if (replaceProfileOptions.newControlsCount() != null) {
      contentJson.addProperty("controls_count", replaceProfileOptions.newControlsCount());
    }
    if (replaceProfileOptions.newAttachmentsCount() != null) {
      contentJson.addProperty("attachments_count", replaceProfileOptions.newAttachmentsCount());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Profile> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Profile>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a profile.
   *
   * Retrieve a profile by specifying the profile ID.
   *
   * With Security and Compliance Center, you can utilize predefined profiles that are curated based on industry
   * standards. Or you can choose to create one that is specific to your usecase, by using an existing library as a
   * starting point. For more information, see [Building custom
   * profiles](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-build-custom-profiles&amp;interface=api).
   *
   * @param getProfileOptions the {@link GetProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Profile}
   */
  public ServiceCall<Profile> getProfile(GetProfileOptions getProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getProfileOptions,
      "getProfileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getProfileOptions.instanceId());
    pathParamsMap.put("profile_id", getProfileOptions.profileId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profile_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getProfileOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(getProfileOptions.accountId()));
    }
    ResponseConverter<Profile> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Profile>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a custom profile.
   *
   * Delete a custom profile by specifying the profile ID.
   *
   * With Security and Compliance Center, you can utilize predefined profiles that are curated based on industry
   * standards. Or you can choose to create one that is specific to your usecase, by using an existing library as a
   * starting point. For more information, see [Building custom
   * profiles](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-build-custom-profiles&amp;interface=api).
   *
   * @param deleteCustomProfileOptions the {@link DeleteCustomProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Profile}
   */
  public ServiceCall<Profile> deleteCustomProfile(DeleteCustomProfileOptions deleteCustomProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteCustomProfileOptions,
      "deleteCustomProfileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", deleteCustomProfileOptions.instanceId());
    pathParamsMap.put("profile_id", deleteCustomProfileOptions.profileId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profile_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "deleteCustomProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteCustomProfileOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(deleteCustomProfileOptions.accountId()));
    }
    ResponseConverter<Profile> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Profile>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update custom profile parameters.
   *
   * Update the parameters of a custom profile.
   *
   * With Security and Compliance Center, you can utilize predefined profiles that are curated based on industry
   * standards. Or you can choose to create one that is specific to your usecase, by using an existing library as a
   * starting point. For more information, see [Building custom
   * profiles](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-build-custom-profiles&amp;interface=api).
   *
   * @param replaceProfileParametersOptions the {@link ReplaceProfileParametersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileDefaultParametersResponse}
   */
  public ServiceCall<ProfileDefaultParametersResponse> replaceProfileParameters(ReplaceProfileParametersOptions replaceProfileParametersOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceProfileParametersOptions,
      "replaceProfileParametersOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", replaceProfileParametersOptions.instanceId());
    pathParamsMap.put("profile_id", replaceProfileParametersOptions.profileId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profile_id}/parameters", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "replaceProfileParameters");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (replaceProfileParametersOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(replaceProfileParametersOptions.accountId()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("default_parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileParametersOptions.defaultParameters()));
    if (replaceProfileParametersOptions.id() != null) {
      contentJson.addProperty("id", replaceProfileParametersOptions.id());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ProfileDefaultParametersResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileDefaultParametersResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List profile parameters for a given profile.
   *
   * List the parameters used in the Profile.
   *
   * @param listProfileParametersOptions the {@link ListProfileParametersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileDefaultParametersResponse}
   */
  public ServiceCall<ProfileDefaultParametersResponse> listProfileParameters(ListProfileParametersOptions listProfileParametersOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listProfileParametersOptions,
      "listProfileParametersOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listProfileParametersOptions.instanceId());
    pathParamsMap.put("profile_id", listProfileParametersOptions.profileId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profile_id}/parameters", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listProfileParameters");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ProfileDefaultParametersResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileDefaultParametersResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Compare profiles.
   *
   * Compare the version of the profile that you're currently using with your attachment to the most recent profile
   * version. By comparing them, you can view what controls were added, removed, or modified. For more information, see
   * [Building custom
   * profiles](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-build-custom-profiles&amp;interface=api).
   *
   * @param compareProfilesOptions the {@link CompareProfilesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ComparePredefinedProfilesResponse}
   */
  public ServiceCall<ComparePredefinedProfilesResponse> compareProfiles(CompareProfilesOptions compareProfilesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(compareProfilesOptions,
      "compareProfilesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", compareProfilesOptions.instanceId());
    pathParamsMap.put("profile_id", compareProfilesOptions.profileId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profile_id}/compare", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "compareProfiles");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (compareProfilesOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(compareProfilesOptions.accountId()));
    }
    ResponseConverter<ComparePredefinedProfilesResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ComparePredefinedProfilesResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all attachments linked to a specific profile.
   *
   * Retrieve all attachments that are linked to a profile.
   *
   * With Security and Compliance Center, you can evaluate your resources on a recurring schedule or you can initiate a
   * scan at any time. To evaluate your resources, you create an attachment. An attachment is the association between
   * the set of resources that you want to evaluate and a profile that contains the specific controls that you want to
   * use. For more information, see [Running an evaluation for IBM
   * Cloud](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-scan-resources).
   *
   * @param listProfileAttachmentsOptions the {@link ListProfileAttachmentsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileAttachmentCollection}
   */
  public ServiceCall<ProfileAttachmentCollection> listProfileAttachments(ListProfileAttachmentsOptions listProfileAttachmentsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listProfileAttachmentsOptions,
      "listProfileAttachmentsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listProfileAttachmentsOptions.instanceId());
    pathParamsMap.put("profile_id", listProfileAttachmentsOptions.profileId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profile_id}/attachments", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listProfileAttachments");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listProfileAttachmentsOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(listProfileAttachmentsOptions.accountId()));
    }
    ResponseConverter<ProfileAttachmentCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileAttachmentCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a scope.
   *
   * Create a scope.
   *
   * @param createScopeOptions the {@link CreateScopeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Scope}
   */
  public ServiceCall<Scope> createScope(CreateScopeOptions createScopeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createScopeOptions,
      "createScopeOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", createScopeOptions.instanceId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/scopes", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "createScope");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (createScopeOptions.name() != null) {
      contentJson.addProperty("name", createScopeOptions.name());
    }
    if (createScopeOptions.description() != null) {
      contentJson.addProperty("description", createScopeOptions.description());
    }
    if (createScopeOptions.environment() != null) {
      contentJson.addProperty("environment", createScopeOptions.environment());
    }
    if (createScopeOptions.xProperties() != null) {
      contentJson.add("properties", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createScopeOptions.xProperties()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Scope> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Scope>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all scopes.
   *
   * Get all scopes.
   *
   * @param listScopesOptions the {@link ListScopesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ScopeCollection}
   */
  public ServiceCall<ScopeCollection> listScopes(ListScopesOptions listScopesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listScopesOptions,
      "listScopesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listScopesOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/scopes", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listScopes");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listScopesOptions.limit() != null) {
      builder.query("limit", String.valueOf(listScopesOptions.limit()));
    }
    if (listScopesOptions.start() != null) {
      builder.query("start", String.valueOf(listScopesOptions.start()));
    }
    if (listScopesOptions.name() != null) {
      builder.query("name", String.valueOf(listScopesOptions.name()));
    }
    if (listScopesOptions.description() != null) {
      builder.query("description", String.valueOf(listScopesOptions.description()));
    }
    if (listScopesOptions.environment() != null) {
      builder.query("environment", String.valueOf(listScopesOptions.environment()));
    }
    ResponseConverter<ScopeCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ScopeCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a scope.
   *
   * Update the details of a scope.
   *
   * @param updateScopeOptions the {@link UpdateScopeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Scope}
   */
  public ServiceCall<Scope> updateScope(UpdateScopeOptions updateScopeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateScopeOptions,
      "updateScopeOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", updateScopeOptions.instanceId());
    pathParamsMap.put("scope_id", updateScopeOptions.scopeId());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/scopes/{scope_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "updateScope");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (updateScopeOptions.name() != null) {
      contentJson.addProperty("name", updateScopeOptions.name());
    }
    if (updateScopeOptions.description() != null) {
      contentJson.addProperty("description", updateScopeOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Scope> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Scope>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a scope.
   *
   * Get a scope by specifying the scope ID.
   *
   * @param getScopeOptions the {@link GetScopeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Scope}
   */
  public ServiceCall<Scope> getScope(GetScopeOptions getScopeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getScopeOptions,
      "getScopeOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getScopeOptions.instanceId());
    pathParamsMap.put("scope_id", getScopeOptions.scopeId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/scopes/{scope_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getScope");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Scope> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Scope>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a scope.
   *
   * Delete a scope by specifying the scope ID.
   *
   * @param deleteScopeOptions the {@link DeleteScopeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteScope(DeleteScopeOptions deleteScopeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteScopeOptions,
      "deleteScopeOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", deleteScopeOptions.instanceId());
    pathParamsMap.put("scope_id", deleteScopeOptions.scopeId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/scopes/{scope_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "deleteScope");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a subscope.
   *
   * Create a subscope.
   *
   * @param createSubscopeOptions the {@link CreateSubscopeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SubScopeResponse}
   */
  public ServiceCall<SubScopeResponse> createSubscope(CreateSubscopeOptions createSubscopeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createSubscopeOptions,
      "createSubscopeOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", createSubscopeOptions.instanceId());
    pathParamsMap.put("scope_id", createSubscopeOptions.scopeId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/scopes/{scope_id}/subscopes", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "createSubscope");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("subscopes", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createSubscopeOptions.subscopes()));
    builder.bodyJson(contentJson);
    ResponseConverter<SubScopeResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SubScopeResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all subscopes.
   *
   * Get all subscopes.
   *
   * @param listSubscopesOptions the {@link ListSubscopesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SubScopeCollection}
   */
  public ServiceCall<SubScopeCollection> listSubscopes(ListSubscopesOptions listSubscopesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listSubscopesOptions,
      "listSubscopesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listSubscopesOptions.instanceId());
    pathParamsMap.put("scope_id", listSubscopesOptions.scopeId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/scopes/{scope_id}/subscopes", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listSubscopes");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listSubscopesOptions.limit() != null) {
      builder.query("limit", String.valueOf(listSubscopesOptions.limit()));
    }
    if (listSubscopesOptions.start() != null) {
      builder.query("start", String.valueOf(listSubscopesOptions.start()));
    }
    if (listSubscopesOptions.name() != null) {
      builder.query("name", String.valueOf(listSubscopesOptions.name()));
    }
    if (listSubscopesOptions.description() != null) {
      builder.query("description", String.valueOf(listSubscopesOptions.description()));
    }
    if (listSubscopesOptions.environment() != null) {
      builder.query("environment", String.valueOf(listSubscopesOptions.environment()));
    }
    ResponseConverter<SubScopeCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SubScopeCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a subscope.
   *
   * Get the subscope details.
   *
   * @param getSubscopeOptions the {@link GetSubscopeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SubScope}
   */
  public ServiceCall<SubScope> getSubscope(GetSubscopeOptions getSubscopeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getSubscopeOptions,
      "getSubscopeOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getSubscopeOptions.instanceId());
    pathParamsMap.put("scope_id", getSubscopeOptions.scopeId());
    pathParamsMap.put("subscope_id", getSubscopeOptions.subscopeId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/scopes/{scope_id}/subscopes/{subscope_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getSubscope");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<SubScope> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SubScope>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a subscope.
   *
   * Update the subscope details.
   *
   * @param updateSubscopeOptions the {@link UpdateSubscopeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SubScope}
   */
  public ServiceCall<SubScope> updateSubscope(UpdateSubscopeOptions updateSubscopeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateSubscopeOptions,
      "updateSubscopeOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", updateSubscopeOptions.instanceId());
    pathParamsMap.put("scope_id", updateSubscopeOptions.scopeId());
    pathParamsMap.put("subscope_id", updateSubscopeOptions.subscopeId());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/scopes/{scope_id}/subscopes/{subscope_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "updateSubscope");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (updateSubscopeOptions.name() != null) {
      contentJson.addProperty("name", updateSubscopeOptions.name());
    }
    if (updateSubscopeOptions.description() != null) {
      contentJson.addProperty("description", updateSubscopeOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<SubScope> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SubScope>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a subscope.
   *
   * Delete the subscope by specifying the subscope ID.
   *
   * @param deleteSubscopeOptions the {@link DeleteSubscopeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteSubscope(DeleteSubscopeOptions deleteSubscopeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteSubscopeOptions,
      "deleteSubscopeOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", deleteSubscopeOptions.instanceId());
    pathParamsMap.put("scope_id", deleteSubscopeOptions.scopeId());
    pathParamsMap.put("subscope_id", deleteSubscopeOptions.subscopeId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/scopes/{scope_id}/subscopes/{subscope_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "deleteSubscope");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a target.
   *
   * Creates a target to scan against.
   *
   * @param createTargetOptions the {@link CreateTargetOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Target}
   */
  public ServiceCall<Target> createTarget(CreateTargetOptions createTargetOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createTargetOptions,
      "createTargetOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", createTargetOptions.instanceId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/targets", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "createTarget");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("account_id", createTargetOptions.accountId());
    contentJson.addProperty("trusted_profile_id", createTargetOptions.trustedProfileId());
    contentJson.addProperty("name", createTargetOptions.name());
    if (createTargetOptions.credentials() != null) {
      contentJson.add("credentials", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createTargetOptions.credentials()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Target> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Target>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of targets with pagination.
   *
   * Returns a list of targets.
   *
   * @param listTargetsOptions the {@link ListTargetsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TargetCollection}
   */
  public ServiceCall<TargetCollection> listTargets(ListTargetsOptions listTargetsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listTargetsOptions,
      "listTargetsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listTargetsOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/targets", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listTargets");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<TargetCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TargetCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a target by ID.
   *
   * Retrieves a target by its ID association.
   *
   * @param getTargetOptions the {@link GetTargetOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Target}
   */
  public ServiceCall<Target> getTarget(GetTargetOptions getTargetOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getTargetOptions,
      "getTargetOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getTargetOptions.instanceId());
    pathParamsMap.put("target_id", getTargetOptions.targetId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/targets/{target_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getTarget");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Target> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Target>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * replace a target by ID.
   *
   * Updates a target by its ID.
   *
   * @param replaceTargetOptions the {@link ReplaceTargetOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Target}
   */
  public ServiceCall<Target> replaceTarget(ReplaceTargetOptions replaceTargetOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceTargetOptions,
      "replaceTargetOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", replaceTargetOptions.instanceId());
    pathParamsMap.put("target_id", replaceTargetOptions.targetId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/targets/{target_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "replaceTarget");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("account_id", replaceTargetOptions.accountId());
    contentJson.addProperty("trusted_profile_id", replaceTargetOptions.trustedProfileId());
    contentJson.addProperty("name", replaceTargetOptions.name());
    if (replaceTargetOptions.credentials() != null) {
      contentJson.add("credentials", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceTargetOptions.credentials()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Target> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Target>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a target by ID.
   *
   * Deletes a target by the ID.
   *
   * @param deleteTargetOptions the {@link DeleteTargetOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteTarget(DeleteTargetOptions deleteTargetOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteTargetOptions,
      "deleteTargetOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", deleteTargetOptions.instanceId());
    pathParamsMap.put("target_id", deleteTargetOptions.targetId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/targets/{target_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "deleteTarget");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a provider type instance.
   *
   * Create an instance of a provider type. For more information about integrations, see [Connecting Workload
   * Protection](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-setup-workload-protection).
   *
   * @param createProviderTypeInstanceOptions the {@link CreateProviderTypeInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProviderTypeInstance}
   */
  public ServiceCall<ProviderTypeInstance> createProviderTypeInstance(CreateProviderTypeInstanceOptions createProviderTypeInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createProviderTypeInstanceOptions,
      "createProviderTypeInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", createProviderTypeInstanceOptions.instanceId());
    pathParamsMap.put("provider_type_id", createProviderTypeInstanceOptions.providerTypeId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/provider_types/{provider_type_id}/provider_type_instances", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "createProviderTypeInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (createProviderTypeInstanceOptions.name() != null) {
      contentJson.addProperty("name", createProviderTypeInstanceOptions.name());
    }
    if (createProviderTypeInstanceOptions.attributes() != null) {
      contentJson.add("attributes", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createProviderTypeInstanceOptions.attributes()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ProviderTypeInstance> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProviderTypeInstance>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List instances of a specific provider type.
   *
   * Retrieve all instances of a provider type. For more information about integrations, see [Connecting Workload
   * Protection](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-setup-workload-protection).
   *
   * @param listProviderTypeInstancesOptions the {@link ListProviderTypeInstancesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProviderTypeInstanceCollection}
   */
  public ServiceCall<ProviderTypeInstanceCollection> listProviderTypeInstances(ListProviderTypeInstancesOptions listProviderTypeInstancesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listProviderTypeInstancesOptions,
      "listProviderTypeInstancesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listProviderTypeInstancesOptions.instanceId());
    pathParamsMap.put("provider_type_id", listProviderTypeInstancesOptions.providerTypeId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/provider_types/{provider_type_id}/provider_type_instances", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listProviderTypeInstances");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ProviderTypeInstanceCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProviderTypeInstanceCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a provider type instance.
   *
   * Retrieve a provider type instance by specifying the provider type ID, and Security and Compliance Center instance
   * ID. For more information about integrations, see [Connecting Workload
   * Protection](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-setup-workload-protection).
   *
   * @param getProviderTypeInstanceOptions the {@link GetProviderTypeInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProviderTypeInstance}
   */
  public ServiceCall<ProviderTypeInstance> getProviderTypeInstance(GetProviderTypeInstanceOptions getProviderTypeInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getProviderTypeInstanceOptions,
      "getProviderTypeInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getProviderTypeInstanceOptions.instanceId());
    pathParamsMap.put("provider_type_id", getProviderTypeInstanceOptions.providerTypeId());
    pathParamsMap.put("provider_type_instance_id", getProviderTypeInstanceOptions.providerTypeInstanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/provider_types/{provider_type_id}/provider_type_instances/{provider_type_instance_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getProviderTypeInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ProviderTypeInstance> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProviderTypeInstance>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a provider type instance.
   *
   * Update a provider type instance. For more information about integrations, see [Connecting Workload
   * Protection](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-setup-workload-protection).
   *
   * @param updateProviderTypeInstanceOptions the {@link UpdateProviderTypeInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProviderTypeInstance}
   */
  public ServiceCall<ProviderTypeInstance> updateProviderTypeInstance(UpdateProviderTypeInstanceOptions updateProviderTypeInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateProviderTypeInstanceOptions,
      "updateProviderTypeInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", updateProviderTypeInstanceOptions.instanceId());
    pathParamsMap.put("provider_type_id", updateProviderTypeInstanceOptions.providerTypeId());
    pathParamsMap.put("provider_type_instance_id", updateProviderTypeInstanceOptions.providerTypeInstanceId());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/provider_types/{provider_type_id}/provider_type_instances/{provider_type_instance_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "updateProviderTypeInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (updateProviderTypeInstanceOptions.name() != null) {
      contentJson.addProperty("name", updateProviderTypeInstanceOptions.name());
    }
    if (updateProviderTypeInstanceOptions.attributes() != null) {
      contentJson.add("attributes", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateProviderTypeInstanceOptions.attributes()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ProviderTypeInstance> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProviderTypeInstance>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a provider type instance.
   *
   * Remove a provider type instance. For more information about integrations, see [Connecting Workload
   * Protection](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-setup-workload-protection).
   *
   * @param deleteProviderTypeInstanceOptions the {@link DeleteProviderTypeInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteProviderTypeInstance(DeleteProviderTypeInstanceOptions deleteProviderTypeInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteProviderTypeInstanceOptions,
      "deleteProviderTypeInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", deleteProviderTypeInstanceOptions.instanceId());
    pathParamsMap.put("provider_type_id", deleteProviderTypeInstanceOptions.providerTypeId());
    pathParamsMap.put("provider_type_instance_id", deleteProviderTypeInstanceOptions.providerTypeInstanceId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/provider_types/{provider_type_id}/provider_type_instances/{provider_type_instance_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "deleteProviderTypeInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List provider types.
   *
   * List all the registered provider types or integrations such as Workload Protection available to connect to Security
   * and Compliance Center.  For more information about connecting Workload Protection with the Security and Compliance
   * Center, see [Connecting Workload
   * Protection](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-setup-workload-protection).
   *
   * @param listProviderTypesOptions the {@link ListProviderTypesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProviderTypeCollection}
   */
  public ServiceCall<ProviderTypeCollection> listProviderTypes(ListProviderTypesOptions listProviderTypesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listProviderTypesOptions,
      "listProviderTypesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listProviderTypesOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/provider_types", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listProviderTypes");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ProviderTypeCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProviderTypeCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a provider type.
   *
   * Retrieve a provider type by specifying its ID. For more information about integrations, see [Connecting Workload
   * Protection](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-setup-workload-protection).
   *
   * @param getProviderTypeByIdOptions the {@link GetProviderTypeByIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProviderType}
   */
  public ServiceCall<ProviderType> getProviderTypeById(GetProviderTypeByIdOptions getProviderTypeByIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getProviderTypeByIdOptions,
      "getProviderTypeByIdOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getProviderTypeByIdOptions.instanceId());
    pathParamsMap.put("provider_type_id", getProviderTypeByIdOptions.providerTypeId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/provider_types/{provider_type_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getProviderTypeById");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ProviderType> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProviderType>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List latest reports.
   *
   * Retrieve the latest reports, which are grouped by profile ID, scope ID, and attachment ID. For more information,
   * see [Viewing results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @param getLatestReportsOptions the {@link GetLatestReportsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ReportLatest}
   */
  public ServiceCall<ReportLatest> getLatestReports(GetLatestReportsOptions getLatestReportsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getLatestReportsOptions,
      "getLatestReportsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getLatestReportsOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/reports/latest", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getLatestReports");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getLatestReportsOptions.sort() != null) {
      builder.query("sort", String.valueOf(getLatestReportsOptions.sort()));
    }
    ResponseConverter<ReportLatest> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ReportLatest>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List reports.
   *
   * Retrieve a page of reports that are filtered by the specified parameters. For more information, see [Viewing
   * results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @param listReportsOptions the {@link ListReportsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ReportCollection}
   */
  public ServiceCall<ReportCollection> listReports(ListReportsOptions listReportsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listReportsOptions,
      "listReportsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listReportsOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/reports", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listReports");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listReportsOptions.reportAttachmentId() != null) {
      builder.query("report_attachment_id", String.valueOf(listReportsOptions.reportAttachmentId()));
    }
    if (listReportsOptions.groupId() != null) {
      builder.query("group_id", String.valueOf(listReportsOptions.groupId()));
    }
    if (listReportsOptions.reportProfileId() != null) {
      builder.query("report_profile_id", String.valueOf(listReportsOptions.reportProfileId()));
    }
    if (listReportsOptions.type() != null) {
      builder.query("type", String.valueOf(listReportsOptions.type()));
    }
    if (listReportsOptions.start() != null) {
      builder.query("start", String.valueOf(listReportsOptions.start()));
    }
    if (listReportsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listReportsOptions.limit()));
    }
    if (listReportsOptions.sort() != null) {
      builder.query("sort", String.valueOf(listReportsOptions.sort()));
    }
    ResponseConverter<ReportCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ReportCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a report.
   *
   * Retrieve a specified report and filter the report details by the specified scope ID and/or subscope ID. For more
   * information, see [Viewing
   * results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @param getReportOptions the {@link GetReportOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Report}
   */
  public ServiceCall<Report> getReport(GetReportOptions getReportOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getReportOptions,
      "getReportOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("report_id", getReportOptions.reportId());
    pathParamsMap.put("instance_id", getReportOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/reports/{report_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getReport");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getReportOptions.scopeId() != null) {
      builder.query("scope_id", String.valueOf(getReportOptions.scopeId()));
    }
    if (getReportOptions.subscopeId() != null) {
      builder.query("subscope_id", String.valueOf(getReportOptions.subscopeId()));
    }
    ResponseConverter<Report> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Report>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a report summary.
   *
   * Retrieve the complete summarized information for a report. For more information, see [Viewing
   * results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @param getReportSummaryOptions the {@link GetReportSummaryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ReportSummary}
   */
  public ServiceCall<ReportSummary> getReportSummary(GetReportSummaryOptions getReportSummaryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getReportSummaryOptions,
      "getReportSummaryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getReportSummaryOptions.instanceId());
    pathParamsMap.put("report_id", getReportSummaryOptions.reportId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/reports/{report_id}/summary", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getReportSummary");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ReportSummary> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ReportSummary>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get report evaluation details.
   *
   * Download a .csv file to inspect the evaluation details of a specified report. For more information, see [Viewing
   * results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @param getReportDownloadFileOptions the {@link GetReportDownloadFileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> getReportDownloadFile(GetReportDownloadFileOptions getReportDownloadFileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getReportDownloadFileOptions,
      "getReportDownloadFileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getReportDownloadFileOptions.instanceId());
    pathParamsMap.put("report_id", getReportDownloadFileOptions.reportId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/reports/{report_id}/download", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getReportDownloadFile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (getReportDownloadFileOptions.accept() != null) {
      builder.header("Accept", getReportDownloadFileOptions.accept());
    }
    if (getReportDownloadFileOptions.excludeSummary() != null) {
      builder.query("exclude_summary", String.valueOf(getReportDownloadFileOptions.excludeSummary()));
    }
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get report controls.
   *
   * Retrieve a sorted and filtered list of controls for the specified report. For more information, see [Viewing
   * results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @param getReportControlsOptions the {@link GetReportControlsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ReportControls}
   */
  public ServiceCall<ReportControls> getReportControls(GetReportControlsOptions getReportControlsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getReportControlsOptions,
      "getReportControlsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getReportControlsOptions.instanceId());
    pathParamsMap.put("report_id", getReportControlsOptions.reportId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/reports/{report_id}/controls", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getReportControls");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getReportControlsOptions.controlId() != null) {
      builder.query("control_id", String.valueOf(getReportControlsOptions.controlId()));
    }
    if (getReportControlsOptions.controlName() != null) {
      builder.query("control_name", String.valueOf(getReportControlsOptions.controlName()));
    }
    if (getReportControlsOptions.controlDescription() != null) {
      builder.query("control_description", String.valueOf(getReportControlsOptions.controlDescription()));
    }
    if (getReportControlsOptions.controlCategory() != null) {
      builder.query("control_category", String.valueOf(getReportControlsOptions.controlCategory()));
    }
    if (getReportControlsOptions.status() != null) {
      builder.query("status", String.valueOf(getReportControlsOptions.status()));
    }
    if (getReportControlsOptions.sort() != null) {
      builder.query("sort", String.valueOf(getReportControlsOptions.sort()));
    }
    if (getReportControlsOptions.scopeId() != null) {
      builder.query("scope_id", String.valueOf(getReportControlsOptions.scopeId()));
    }
    if (getReportControlsOptions.subscopeId() != null) {
      builder.query("subscope_id", String.valueOf(getReportControlsOptions.subscopeId()));
    }
    ResponseConverter<ReportControls> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ReportControls>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a report rule.
   *
   * Retrieve the rule by specifying the report ID and rule ID. For more information, see [Viewing
   * results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @param getReportRuleOptions the {@link GetReportRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link RuleInfo}
   */
  public ServiceCall<RuleInfo> getReportRule(GetReportRuleOptions getReportRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getReportRuleOptions,
      "getReportRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getReportRuleOptions.instanceId());
    pathParamsMap.put("report_id", getReportRuleOptions.reportId());
    pathParamsMap.put("rule_id", getReportRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/reports/{report_id}/rules/{rule_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getReportRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<RuleInfo> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<RuleInfo>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List report evaluations.
   *
   * Get a paginated list of evaluations for the specified report. For more information, see [Viewing
   * results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @param listReportEvaluationsOptions the {@link ListReportEvaluationsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link EvaluationPage}
   */
  public ServiceCall<EvaluationPage> listReportEvaluations(ListReportEvaluationsOptions listReportEvaluationsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listReportEvaluationsOptions,
      "listReportEvaluationsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listReportEvaluationsOptions.instanceId());
    pathParamsMap.put("report_id", listReportEvaluationsOptions.reportId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/reports/{report_id}/evaluations", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listReportEvaluations");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listReportEvaluationsOptions.assessmentId() != null) {
      builder.query("assessment_id", String.valueOf(listReportEvaluationsOptions.assessmentId()));
    }
    if (listReportEvaluationsOptions.assessmentMethod() != null) {
      builder.query("assessment_method", String.valueOf(listReportEvaluationsOptions.assessmentMethod()));
    }
    if (listReportEvaluationsOptions.componentId() != null) {
      builder.query("component_id", String.valueOf(listReportEvaluationsOptions.componentId()));
    }
    if (listReportEvaluationsOptions.targetId() != null) {
      builder.query("target_id", String.valueOf(listReportEvaluationsOptions.targetId()));
    }
    if (listReportEvaluationsOptions.targetEnv() != null) {
      builder.query("target_env", String.valueOf(listReportEvaluationsOptions.targetEnv()));
    }
    if (listReportEvaluationsOptions.targetName() != null) {
      builder.query("target_name", String.valueOf(listReportEvaluationsOptions.targetName()));
    }
    if (listReportEvaluationsOptions.status() != null) {
      builder.query("status", String.valueOf(listReportEvaluationsOptions.status()));
    }
    if (listReportEvaluationsOptions.start() != null) {
      builder.query("start", String.valueOf(listReportEvaluationsOptions.start()));
    }
    if (listReportEvaluationsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listReportEvaluationsOptions.limit()));
    }
    if (listReportEvaluationsOptions.sort() != null) {
      builder.query("sort", String.valueOf(listReportEvaluationsOptions.sort()));
    }
    if (listReportEvaluationsOptions.scopeId() != null) {
      builder.query("scope_id", String.valueOf(listReportEvaluationsOptions.scopeId()));
    }
    if (listReportEvaluationsOptions.subscopeId() != null) {
      builder.query("subscope_id", String.valueOf(listReportEvaluationsOptions.subscopeId()));
    }
    ResponseConverter<EvaluationPage> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<EvaluationPage>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List report resources.
   *
   * Get a paginated list of resources for the specified report. For more information, see [Viewing
   * results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @param listReportResourcesOptions the {@link ListReportResourcesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourcePage}
   */
  public ServiceCall<ResourcePage> listReportResources(ListReportResourcesOptions listReportResourcesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listReportResourcesOptions,
      "listReportResourcesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listReportResourcesOptions.instanceId());
    pathParamsMap.put("report_id", listReportResourcesOptions.reportId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/reports/{report_id}/resources", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listReportResources");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listReportResourcesOptions.id() != null) {
      builder.query("id", String.valueOf(listReportResourcesOptions.id()));
    }
    if (listReportResourcesOptions.resourceName() != null) {
      builder.query("resource_name", String.valueOf(listReportResourcesOptions.resourceName()));
    }
    if (listReportResourcesOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(listReportResourcesOptions.accountId()));
    }
    if (listReportResourcesOptions.componentId() != null) {
      builder.query("component_id", String.valueOf(listReportResourcesOptions.componentId()));
    }
    if (listReportResourcesOptions.status() != null) {
      builder.query("status", String.valueOf(listReportResourcesOptions.status()));
    }
    if (listReportResourcesOptions.sort() != null) {
      builder.query("sort", String.valueOf(listReportResourcesOptions.sort()));
    }
    if (listReportResourcesOptions.start() != null) {
      builder.query("start", String.valueOf(listReportResourcesOptions.start()));
    }
    if (listReportResourcesOptions.limit() != null) {
      builder.query("limit", String.valueOf(listReportResourcesOptions.limit()));
    }
    if (listReportResourcesOptions.scopeId() != null) {
      builder.query("scope_id", String.valueOf(listReportResourcesOptions.scopeId()));
    }
    if (listReportResourcesOptions.subscopeId() != null) {
      builder.query("subscope_id", String.valueOf(listReportResourcesOptions.subscopeId()));
    }
    ResponseConverter<ResourcePage> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourcePage>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List report tags.
   *
   * Retrieve a list of tags for the specified report. For more information, see [Viewing
   * results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @param getReportTagsOptions the {@link GetReportTagsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ReportTags}
   */
  public ServiceCall<ReportTags> getReportTags(GetReportTagsOptions getReportTagsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getReportTagsOptions,
      "getReportTagsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getReportTagsOptions.instanceId());
    pathParamsMap.put("report_id", getReportTagsOptions.reportId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/reports/{report_id}/tags", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getReportTags");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ReportTags> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ReportTags>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get report violations drift.
   *
   * Get a list of report violation data points for the specified report and time frame. For more information, see
   * [Viewing results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @param getReportViolationsDriftOptions the {@link GetReportViolationsDriftOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ReportViolationsDrift}
   */
  public ServiceCall<ReportViolationsDrift> getReportViolationsDrift(GetReportViolationsDriftOptions getReportViolationsDriftOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getReportViolationsDriftOptions,
      "getReportViolationsDriftOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getReportViolationsDriftOptions.instanceId());
    pathParamsMap.put("report_id", getReportViolationsDriftOptions.reportId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/reports/{report_id}/violations_drift", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getReportViolationsDrift");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getReportViolationsDriftOptions.scanTimeDuration() != null) {
      builder.query("scan_time_duration", String.valueOf(getReportViolationsDriftOptions.scanTimeDuration()));
    }
    if (getReportViolationsDriftOptions.scopeId() != null) {
      builder.query("scope_id", String.valueOf(getReportViolationsDriftOptions.scopeId()));
    }
    if (getReportViolationsDriftOptions.subscopeId() != null) {
      builder.query("subscope_id", String.valueOf(getReportViolationsDriftOptions.subscopeId()));
    }
    ResponseConverter<ReportViolationsDrift> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ReportViolationsDrift>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List scan reports.
   *
   * Get a list of scan reports and view the status of report generation in progress. For more information, see [Viewing
   * results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @param listScanReportsOptions the {@link ListScanReportsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ScanReportCollection}
   */
  public ServiceCall<ScanReportCollection> listScanReports(ListScanReportsOptions listScanReportsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listScanReportsOptions,
      "listScanReportsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listScanReportsOptions.instanceId());
    pathParamsMap.put("report_id", listScanReportsOptions.reportId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/reports/{report_id}/scan_reports", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listScanReports");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listScanReportsOptions.scopeId() != null) {
      builder.query("scope_id", String.valueOf(listScanReportsOptions.scopeId()));
    }
    if (listScanReportsOptions.subscopeId() != null) {
      builder.query("subscope_id", String.valueOf(listScanReportsOptions.subscopeId()));
    }
    if (listScanReportsOptions.sort() != null) {
      builder.query("sort", String.valueOf(listScanReportsOptions.sort()));
    }
    ResponseConverter<ScanReportCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ScanReportCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a scan report.
   *
   * Create a scan report for a specific scope or sub-scope. For more information, see [Defining custom
   * rules](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-rules-define).
   *
   * @param createScanReportOptions the {@link CreateScanReportOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CreateScanReport}
   */
  public ServiceCall<CreateScanReport> createScanReport(CreateScanReportOptions createScanReportOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createScanReportOptions,
      "createScanReportOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", createScanReportOptions.instanceId());
    pathParamsMap.put("report_id", createScanReportOptions.reportId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/reports/{report_id}/scan_reports", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "createScanReport");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("format", createScanReportOptions.format());
    if (createScanReportOptions.scopeId() != null) {
      contentJson.addProperty("scope_id", createScanReportOptions.scopeId());
    }
    if (createScanReportOptions.subscopeId() != null) {
      contentJson.addProperty("subscope_id", createScanReportOptions.subscopeId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<CreateScanReport> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CreateScanReport>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a scan report.
   *
   * Retrieve the scan report by specifying the ID. For more information, see [Viewing
   * results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @param getScanReportOptions the {@link GetScanReportOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ScanReport}
   */
  public ServiceCall<ScanReport> getScanReport(GetScanReportOptions getScanReportOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getScanReportOptions,
      "getScanReportOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getScanReportOptions.instanceId());
    pathParamsMap.put("report_id", getScanReportOptions.reportId());
    pathParamsMap.put("job_id", getScanReportOptions.jobId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/reports/{report_id}/scan_reports/{job_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getScanReport");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ScanReport> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ScanReport>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a scan report details.
   *
   * Download the scan report with evaluation details for the specified ID. For more information, see [Viewing
   * results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @param getScanReportDownloadFileOptions the {@link GetScanReportDownloadFileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> getScanReportDownloadFile(GetScanReportDownloadFileOptions getScanReportDownloadFileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getScanReportDownloadFileOptions,
      "getScanReportDownloadFileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getScanReportDownloadFileOptions.instanceId());
    pathParamsMap.put("report_id", getScanReportDownloadFileOptions.reportId());
    pathParamsMap.put("job_id", getScanReportDownloadFileOptions.jobId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/reports/{report_id}/scan_reports/{job_id}/download", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getScanReportDownloadFile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (getScanReportDownloadFileOptions.accept() != null) {
      builder.header("Accept", getScanReportDownloadFileOptions.accept());
    }
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all rules.
   *
   * Retrieve all the rules that you use to target the exact configuration properties  that you need to ensure are
   * compliant. For more information, see [Defining custom
   * rules](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-rules-define).
   *
   * @param listRulesOptions the {@link ListRulesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link RuleCollection}
   */
  public ServiceCall<RuleCollection> listRules(ListRulesOptions listRulesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listRulesOptions,
      "listRulesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listRulesOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/rules", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listRules");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listRulesOptions.limit() != null) {
      builder.query("limit", String.valueOf(listRulesOptions.limit()));
    }
    if (listRulesOptions.start() != null) {
      builder.query("start", String.valueOf(listRulesOptions.start()));
    }
    if (listRulesOptions.type() != null) {
      builder.query("type", String.valueOf(listRulesOptions.type()));
    }
    if (listRulesOptions.search() != null) {
      builder.query("search", String.valueOf(listRulesOptions.search()));
    }
    if (listRulesOptions.serviceName() != null) {
      builder.query("service_name", String.valueOf(listRulesOptions.serviceName()));
    }
    if (listRulesOptions.sort() != null) {
      builder.query("sort", String.valueOf(listRulesOptions.sort()));
    }
    ResponseConverter<RuleCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<RuleCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a custom rule.
   *
   * Create a custom rule to to target the exact configuration properties  that you need to evaluate your resources for
   * compliance. For more information, see [Defining custom
   * rules](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-rules-define).
   *
   * @param createRuleOptions the {@link CreateRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Rule}
   */
  public ServiceCall<Rule> createRule(CreateRuleOptions createRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createRuleOptions,
      "createRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", createRuleOptions.instanceId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/rules", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "createRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("description", createRuleOptions.description());
    contentJson.add("target", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createRuleOptions.target()));
    contentJson.add("required_config", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createRuleOptions.requiredConfig()));
    if (createRuleOptions.version() != null) {
      contentJson.addProperty("version", createRuleOptions.version());
    }
    if (createRuleOptions.xImport() != null) {
      contentJson.add("import", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createRuleOptions.xImport()));
    }
    if (createRuleOptions.labels() != null) {
      contentJson.add("labels", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createRuleOptions.labels()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Rule> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Rule>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a custom rule.
   *
   * Retrieve a rule that you created to evaluate your resources.  For more information, see [Defining custom
   * rules](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-rules-define).
   *
   * @param getRuleOptions the {@link GetRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Rule}
   */
  public ServiceCall<Rule> getRule(GetRuleOptions getRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getRuleOptions,
      "getRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getRuleOptions.instanceId());
    pathParamsMap.put("rule_id", getRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/rules/{rule_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Rule> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Rule>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a custom rule.
   *
   * Update a custom rule that you use to target the exact configuration properties  that you need to evaluate your
   * resources for compliance. For more information, see [Defining custom
   * rules](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-rules-define).
   *
   * @param replaceRuleOptions the {@link ReplaceRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Rule}
   */
  public ServiceCall<Rule> replaceRule(ReplaceRuleOptions replaceRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceRuleOptions,
      "replaceRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", replaceRuleOptions.instanceId());
    pathParamsMap.put("rule_id", replaceRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/rules/{rule_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "replaceRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", replaceRuleOptions.ifMatch());
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("description", replaceRuleOptions.description());
    contentJson.add("target", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceRuleOptions.target()));
    contentJson.add("required_config", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceRuleOptions.requiredConfig()));
    if (replaceRuleOptions.version() != null) {
      contentJson.addProperty("version", replaceRuleOptions.version());
    }
    if (replaceRuleOptions.xImport() != null) {
      contentJson.add("import", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceRuleOptions.xImport()));
    }
    if (replaceRuleOptions.labels() != null) {
      contentJson.add("labels", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceRuleOptions.labels()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Rule> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Rule>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a custom rule.
   *
   * Delete a custom rule that you no longer require to evaluate your resources. For more information, see [Defining
   * custom rules](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-rules-define).
   *
   * @param deleteRuleOptions the {@link DeleteRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteRule(DeleteRuleOptions deleteRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteRuleOptions,
      "deleteRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", deleteRuleOptions.instanceId());
    pathParamsMap.put("rule_id", deleteRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/rules/{rule_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "deleteRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List services.
   *
   * List all the services that you use to evaluate the configuration of your resources for security and compliance.
   * [Learn more](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-scannable-components).
   *
   * @param listServicesOptions the {@link ListServicesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ServiceCollection}
   */
  public ServiceCall<ServiceCollection> listServices(ListServicesOptions listServicesOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/services"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listServices");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ServiceCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ServiceCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List services.
   *
   * List all the services that you use to evaluate the configuration of your resources for security and compliance.
   * [Learn more](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-scannable-components).
   *
   * @return a {@link ServiceCall} with a result of type {@link ServiceCollection}
   */
  public ServiceCall<ServiceCollection> listServices() {
    return listServices(null);
  }

  /**
   * Get a service.
   *
   * Retrieve a service configuration that you monitor. [Learn
   * more](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-scannable-components).
   *
   * @param getServiceOptions the {@link GetServiceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Service}
   */
  public ServiceCall<Service> getService(GetServiceOptions getServiceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getServiceOptions,
      "getServiceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("services_name", getServiceOptions.servicesName());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/services/{services_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getService");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Service> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Service>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
