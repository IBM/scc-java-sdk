/*
 * (C) Copyright IBM Corp. 2023.
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
 * IBM OpenAPI SDK Code Generator Version: 3.76.0-ad3e6f96-20230724-172814
 */

package com.ibm.cloud.security_and_compliance_center_api.v3;

import com.google.gson.JsonObject;
import com.ibm.cloud.security_and_compliance_center_api.common.SdkCommon;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibrary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibraryCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibraryDelete;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateCustomControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateScanOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteCustomControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteCustomProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteProfileAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EvaluationPage;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetLatestReportsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProfileAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProviderTypeByIdOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetProviderTypesInstancesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportControlsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportEvaluationOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportSummaryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportTagsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportViolationsDriftOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetSettingsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListAttachmentsAccountOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListAttachmentsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListControlLibrariesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListProfilesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListProviderTypeInstancesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListProviderTypesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListReportEvaluationsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListReportResourcesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListReportsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListRulesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PostTestEventOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Profile;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderTypeInstanceItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderTypeInstancesResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderTypeItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderTypesCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProviderTypesInstancesResponse;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceCustomControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceProfileAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Report;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportLatest;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportPage;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportSummary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportTags;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportViolationsDrift;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ResourcePage;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Rule;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RuleInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RulesPageBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Scan;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Settings;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.TestEvent;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateSettingsOptions;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Security and Compliance Center API
 * .
 *
 * API Version: 3.0.0
 */
public class SecurityAndComplianceCenterApi extends BaseService {

  /**
   * Default service name used when configuring the `SecurityAndComplianceCenterApi` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "security_and_compliance_center_api";

  /**
   * Default service endpoint URL.
   */
  public static final String DEFAULT_SERVICE_URL = "https://us-south.compliance.cloud.ibm.com/instances/instance_id/v3";

  /**
   * The parameterized service endpoint URL.
   */
  public static final String PARAMETERIZED_SERVICE_URL = "https://{region}.cloud.ibm.com/instances/{instance_id}/v3";

  private static final Map<String, String> defaultUrlVariables = createDefaultUrlVariables();

  private static Map<String, String> createDefaultUrlVariables() {
    Map<String, String> map = new HashMap<>();
    map.put("region", "us-south.compliance");
    map.put("instance_id", "instance_id");
    return map;
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
   * Constructs a service URL by formatting the parameterized service URL.
   *
   * The parameterized service URL is:
   * 'https://{region}.cloud.ibm.com/instances/{instance_id}/v3'
   *
   * The default variable values are:
   * - 'region': 'us-south.compliance'
   * - 'instance_id': 'instance_id'
   *
   * @param providedUrlVariables map from variable names to desired values.
   *   If a variable is not provided in this map,
   *   the default variable value will be used instead.
   * @return the formatted URL with all variable placeholders replaced by values.
   */
  public static String constructServiceUrl(Map<String, String> providedUrlVariables) {
    return BaseService.constructServiceUrl(PARAMETERIZED_SERVICE_URL, defaultUrlVariables, providedUrlVariables);
  }

  /**
   * Get settings.
   *
   * Retrieve the settings of your service instance.
   *
   * @param getSettingsOptions the {@link GetSettingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Settings}
   */
  public ServiceCall<Settings> getSettings(GetSettingsOptions getSettingsOptions) {
    if (getSettingsOptions == null) {
      getSettingsOptions = new GetSettingsOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/settings"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getSettings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getSettingsOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-Id", getSettingsOptions.xCorrelationId());
    }
    if (getSettingsOptions.xRequestId() != null) {
      builder.header("X-Request-Id", getSettingsOptions.xRequestId());
    }
    ResponseConverter<Settings> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Settings>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get settings.
   *
   * Retrieve the settings of your service instance.
   *
   * @return a {@link ServiceCall} with a result of type {@link Settings}
   */
  public ServiceCall<Settings> getSettings() {
    return getSettings(null);
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
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/settings"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "updateSettings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (updateSettingsOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-Id", updateSettingsOptions.xCorrelationId());
    }
    if (updateSettingsOptions.xRequestId() != null) {
      builder.header("X-Request-Id", updateSettingsOptions.xRequestId());
    }
    final JsonObject contentJson = new JsonObject();
    if (updateSettingsOptions.eventNotifications() != null) {
      contentJson.add("event_notifications", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateSettingsOptions.eventNotifications()));
    }
    if (updateSettingsOptions.objectStorage() != null) {
      contentJson.add("object_storage", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateSettingsOptions.objectStorage()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Settings> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Settings>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update settings.
   *
   * Update the settings of your service instance.
   *
   * @return a {@link ServiceCall} with a result of type {@link Settings}
   */
  public ServiceCall<Settings> updateSettings() {
    return updateSettings(null);
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
    if (postTestEventOptions == null) {
      postTestEventOptions = new PostTestEventOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/test_event"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "postTestEvent");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (postTestEventOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-Id", postTestEventOptions.xCorrelationId());
    }
    if (postTestEventOptions.xRequestId() != null) {
      builder.header("X-Request-Id", postTestEventOptions.xRequestId());
    }
    ResponseConverter<TestEvent> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TestEvent>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a test event.
   *
   * Send a test event to your Event Notifications instance to ensure that the events that are generated  by Security
   * and Compliance Center are being forwarded to Event Notifications. For more information, see [Enabling event
   * notifications](/docs/security-compliance?topic=security-compliance-event-notifications#event-notifications-test-api).
   *
   * @return a {@link ServiceCall} with a result of type {@link TestEvent}
   */
  public ServiceCall<TestEvent> postTestEvent() {
    return postTestEvent(null);
  }

  /**
   * Get control libraries.
   *
   * Retrieve all of the control libraries that are available in your account, including predefined, and custom
   * libraries.
   *
   * With Security and Compliance Center, you can create a custom control library that is specific to your
   * organization's needs.  You define the controls and specifications before you map previously created assessments.
   * Each control has several specifications  and assessments that are mapped to it. A specification is a defined
   * requirement that is specific to a component. An assessment, or several,  are mapped to each specification with a
   * detailed evaluation that is done to check whether the specification is compliant. For more information, see
   * [Creating custom libraries](/docs/security-compliance?topic=security-compliance-custom-library).
   *
   * @param listControlLibrariesOptions the {@link ListControlLibrariesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ControlLibraryCollection}
   */
  public ServiceCall<ControlLibraryCollection> listControlLibraries(ListControlLibrariesOptions listControlLibrariesOptions) {
    if (listControlLibrariesOptions == null) {
      listControlLibrariesOptions = new ListControlLibrariesOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/control_libraries"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listControlLibraries");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listControlLibrariesOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", listControlLibrariesOptions.xCorrelationId());
    }
    if (listControlLibrariesOptions.xRequestId() != null) {
      builder.header("X-Request-ID", listControlLibrariesOptions.xRequestId());
    }
    if (listControlLibrariesOptions.limit() != null) {
      builder.query("limit", String.valueOf(listControlLibrariesOptions.limit()));
    }
    if (listControlLibrariesOptions.controlLibraryType() != null) {
      builder.query("control_library_type", String.valueOf(listControlLibrariesOptions.controlLibraryType()));
    }
    if (listControlLibrariesOptions.start() != null) {
      builder.query("start", String.valueOf(listControlLibrariesOptions.start()));
    }
    ResponseConverter<ControlLibraryCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ControlLibraryCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get control libraries.
   *
   * Retrieve all of the control libraries that are available in your account, including predefined, and custom
   * libraries.
   *
   * With Security and Compliance Center, you can create a custom control library that is specific to your
   * organization's needs.  You define the controls and specifications before you map previously created assessments.
   * Each control has several specifications  and assessments that are mapped to it. A specification is a defined
   * requirement that is specific to a component. An assessment, or several,  are mapped to each specification with a
   * detailed evaluation that is done to check whether the specification is compliant. For more information, see
   * [Creating custom libraries](/docs/security-compliance?topic=security-compliance-custom-library).
   *
   * @return a {@link ServiceCall} with a result of type {@link ControlLibraryCollection}
   */
  public ServiceCall<ControlLibraryCollection> listControlLibraries() {
    return listControlLibraries(null);
  }

  /**
   * Create a custom control library.
   *
   * Create a custom control library that is specific to your organization's needs.
   *
   * With Security and Compliance Center, you can create a custom control library that is specific to your
   * organization's needs.  You define the controls and specifications before you map previously created assessments.
   * Each control has several specifications  and assessments that are mapped to it. A specification is a defined
   * requirement that is specific to a component. An assessment, or several,  are mapped to each specification with a
   * detailed evaluation that is done to check whether the specification is compliant. For more information, see
   * [Creating custom libraries](/docs/security-compliance?topic=security-compliance-custom-library).
   *
   * @param createCustomControlLibraryOptions the {@link CreateCustomControlLibraryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ControlLibrary}
   */
  public ServiceCall<ControlLibrary> createCustomControlLibrary(CreateCustomControlLibraryOptions createCustomControlLibraryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createCustomControlLibraryOptions,
      "createCustomControlLibraryOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/control_libraries"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "createCustomControlLibrary");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createCustomControlLibraryOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", createCustomControlLibraryOptions.xCorrelationId());
    }
    if (createCustomControlLibraryOptions.xRequestId() != null) {
      builder.header("X-Request-ID", createCustomControlLibraryOptions.xRequestId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("control_library_name", createCustomControlLibraryOptions.controlLibraryName());
    contentJson.addProperty("control_library_description", createCustomControlLibraryOptions.controlLibraryDescription());
    contentJson.addProperty("control_library_type", createCustomControlLibraryOptions.controlLibraryType());
    contentJson.add("controls", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCustomControlLibraryOptions.controls()));
    if (createCustomControlLibraryOptions.versionGroupLabel() != null) {
      contentJson.addProperty("version_group_label", createCustomControlLibraryOptions.versionGroupLabel());
    }
    if (createCustomControlLibraryOptions.controlLibraryVersion() != null) {
      contentJson.addProperty("control_library_version", createCustomControlLibraryOptions.controlLibraryVersion());
    }
    if (createCustomControlLibraryOptions.latest() != null) {
      contentJson.addProperty("latest", createCustomControlLibraryOptions.latest());
    }
    if (createCustomControlLibraryOptions.controlsCount() != null) {
      contentJson.addProperty("controls_count", createCustomControlLibraryOptions.controlsCount());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ControlLibrary> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ControlLibrary>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a control library.
   *
   * Delete a custom control library by providing the control library ID.  You can find this ID by looking in the
   * Security and Compliance Center UI.
   *
   * With Security and Compliance Center, you can manage a custom control library  that is specific to your
   * organization's needs. Each control has several specifications  and assessments that are mapped to it.  For more
   * information, see [Creating custom libraries](/docs/security-compliance?topic=security-compliance-custom-library).
   *
   * @param deleteCustomControlLibraryOptions the {@link DeleteCustomControlLibraryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ControlLibraryDelete}
   */
  public ServiceCall<ControlLibraryDelete> deleteCustomControlLibrary(DeleteCustomControlLibraryOptions deleteCustomControlLibraryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteCustomControlLibraryOptions,
      "deleteCustomControlLibraryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("control_libraries_id", deleteCustomControlLibraryOptions.controlLibrariesId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/control_libraries/{control_libraries_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "deleteCustomControlLibrary");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteCustomControlLibraryOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", deleteCustomControlLibraryOptions.xCorrelationId());
    }
    if (deleteCustomControlLibraryOptions.xRequestId() != null) {
      builder.header("X-Request-ID", deleteCustomControlLibraryOptions.xRequestId());
    }
    ResponseConverter<ControlLibraryDelete> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ControlLibraryDelete>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a control library.
   *
   * View the details of a control library by specifying its ID.
   *
   * With Security and Compliance Center, you can create a custom control library that is specific to your
   * organization's needs.  You define the controls and specifications before you map previously created assessments.
   * Each control has several specifications  and assessments that are mapped to it. A specification is a defined
   * requirement that is specific to a component. An assessment, or several,  are mapped to each specification with a
   * detailed evaluation that is done to check whether the specification is compliant. For more information, see
   * [Creating custom libraries](/docs/security-compliance?topic=security-compliance-custom-library).
   *
   * @param getControlLibraryOptions the {@link GetControlLibraryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ControlLibrary}
   */
  public ServiceCall<ControlLibrary> getControlLibrary(GetControlLibraryOptions getControlLibraryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getControlLibraryOptions,
      "getControlLibraryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("control_libraries_id", getControlLibraryOptions.controlLibrariesId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/control_libraries/{control_libraries_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getControlLibrary");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getControlLibraryOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", getControlLibraryOptions.xCorrelationId());
    }
    if (getControlLibraryOptions.xRequestId() != null) {
      builder.header("X-Request-ID", getControlLibraryOptions.xRequestId());
    }
    ResponseConverter<ControlLibrary> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ControlLibrary>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a control library.
   *
   * Update a custom control library by providing the control library ID. You can find this ID in the Security and
   * Compliance Center UI.
   *
   * With Security and Compliance Center, you can create and update a custom control library that is specific to your
   * organization's needs.  You define the controls and specifications before you map previously created assessments.
   * Each control has several specifications  and assessments that are mapped to it. For more information, see [Creating
   * custom libraries](/docs/security-compliance?topic=security-compliance-custom-library).
   *
   * @param replaceCustomControlLibraryOptions the {@link ReplaceCustomControlLibraryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ControlLibrary}
   */
  public ServiceCall<ControlLibrary> replaceCustomControlLibrary(ReplaceCustomControlLibraryOptions replaceCustomControlLibraryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceCustomControlLibraryOptions,
      "replaceCustomControlLibraryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("control_libraries_id", replaceCustomControlLibraryOptions.controlLibrariesId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/control_libraries/{control_libraries_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "replaceCustomControlLibrary");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (replaceCustomControlLibraryOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", replaceCustomControlLibraryOptions.xCorrelationId());
    }
    if (replaceCustomControlLibraryOptions.xRequestId() != null) {
      builder.header("X-Request-ID", replaceCustomControlLibraryOptions.xRequestId());
    }
    final JsonObject contentJson = new JsonObject();
    if (replaceCustomControlLibraryOptions.id() != null) {
      contentJson.addProperty("id", replaceCustomControlLibraryOptions.id());
    }
    if (replaceCustomControlLibraryOptions.accountId() != null) {
      contentJson.addProperty("account_id", replaceCustomControlLibraryOptions.accountId());
    }
    if (replaceCustomControlLibraryOptions.controlLibraryName() != null) {
      contentJson.addProperty("control_library_name", replaceCustomControlLibraryOptions.controlLibraryName());
    }
    if (replaceCustomControlLibraryOptions.controlLibraryDescription() != null) {
      contentJson.addProperty("control_library_description", replaceCustomControlLibraryOptions.controlLibraryDescription());
    }
    if (replaceCustomControlLibraryOptions.controlLibraryType() != null) {
      contentJson.addProperty("control_library_type", replaceCustomControlLibraryOptions.controlLibraryType());
    }
    if (replaceCustomControlLibraryOptions.versionGroupLabel() != null) {
      contentJson.addProperty("version_group_label", replaceCustomControlLibraryOptions.versionGroupLabel());
    }
    if (replaceCustomControlLibraryOptions.controlLibraryVersion() != null) {
      contentJson.addProperty("control_library_version", replaceCustomControlLibraryOptions.controlLibraryVersion());
    }
    if (replaceCustomControlLibraryOptions.createdOn() != null) {
      contentJson.add("created_on", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceCustomControlLibraryOptions.createdOn()));
    }
    if (replaceCustomControlLibraryOptions.createdBy() != null) {
      contentJson.addProperty("created_by", replaceCustomControlLibraryOptions.createdBy());
    }
    if (replaceCustomControlLibraryOptions.updatedOn() != null) {
      contentJson.add("updated_on", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceCustomControlLibraryOptions.updatedOn()));
    }
    if (replaceCustomControlLibraryOptions.updatedBy() != null) {
      contentJson.addProperty("updated_by", replaceCustomControlLibraryOptions.updatedBy());
    }
    if (replaceCustomControlLibraryOptions.latest() != null) {
      contentJson.addProperty("latest", replaceCustomControlLibraryOptions.latest());
    }
    if (replaceCustomControlLibraryOptions.hierarchyEnabled() != null) {
      contentJson.addProperty("hierarchy_enabled", replaceCustomControlLibraryOptions.hierarchyEnabled());
    }
    if (replaceCustomControlLibraryOptions.controlsCount() != null) {
      contentJson.addProperty("controls_count", replaceCustomControlLibraryOptions.controlsCount());
    }
    if (replaceCustomControlLibraryOptions.controlParentsCount() != null) {
      contentJson.addProperty("control_parents_count", replaceCustomControlLibraryOptions.controlParentsCount());
    }
    if (replaceCustomControlLibraryOptions.controls() != null) {
      contentJson.add("controls", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceCustomControlLibraryOptions.controls()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ControlLibrary> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ControlLibrary>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all profiles.
   *
   * View all of the predefined and custom profiles that are available in your account.
   *
   * @param listProfilesOptions the {@link ListProfilesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileCollection}
   */
  public ServiceCall<ProfileCollection> listProfiles(ListProfilesOptions listProfilesOptions) {
    if (listProfilesOptions == null) {
      listProfilesOptions = new ListProfilesOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/profiles"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listProfiles");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listProfilesOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", listProfilesOptions.xCorrelationId());
    }
    if (listProfilesOptions.xRequestId() != null) {
      builder.header("X-Request-ID", listProfilesOptions.xRequestId());
    }
    if (listProfilesOptions.limit() != null) {
      builder.query("limit", String.valueOf(listProfilesOptions.limit()));
    }
    if (listProfilesOptions.profileType() != null) {
      builder.query("profile_type", String.valueOf(listProfilesOptions.profileType()));
    }
    if (listProfilesOptions.start() != null) {
      builder.query("start", String.valueOf(listProfilesOptions.start()));
    }
    ResponseConverter<ProfileCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all profiles.
   *
   * View all of the predefined and custom profiles that are available in your account.
   *
   * @return a {@link ServiceCall} with a result of type {@link ProfileCollection}
   */
  public ServiceCall<ProfileCollection> listProfiles() {
    return listProfiles(null);
  }

  /**
   * Create a custom profile.
   *
   * Create a custom profile that is specific to your usecase, by using an existing library as a starting point.  For
   * more information, see [Building custom
   * profiles](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-build-custom-profiles&amp;interface=api).
   *
   * @param createProfileOptions the {@link CreateProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Profile}
   */
  public ServiceCall<Profile> createProfile(CreateProfileOptions createProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createProfileOptions,
      "createProfileOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/profiles"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "createProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createProfileOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", createProfileOptions.xCorrelationId());
    }
    if (createProfileOptions.xRequestId() != null) {
      builder.header("X-Request-ID", createProfileOptions.xRequestId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("profile_name", createProfileOptions.profileName());
    contentJson.addProperty("profile_description", createProfileOptions.profileDescription());
    contentJson.addProperty("profile_type", createProfileOptions.profileType());
    contentJson.add("controls", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createProfileOptions.controls()));
    contentJson.add("default_parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createProfileOptions.defaultParameters()));
    builder.bodyJson(contentJson);
    ResponseConverter<Profile> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Profile>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a custom profile.
   *
   * Delete a custom profile by providing the profile ID.  You can find the ID in the Security and Compliance Center UI.
   * For more information about managing your custom profiles, see [Building custom
   * profiles](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-build-custom-profiles&amp;interface=api).
   *
   * @param deleteCustomProfileOptions the {@link DeleteCustomProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Profile}
   */
  public ServiceCall<Profile> deleteCustomProfile(DeleteCustomProfileOptions deleteCustomProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteCustomProfileOptions,
      "deleteCustomProfileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", deleteCustomProfileOptions.profilesId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/profiles/{profiles_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "deleteCustomProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteCustomProfileOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", deleteCustomProfileOptions.xCorrelationId());
    }
    if (deleteCustomProfileOptions.xRequestId() != null) {
      builder.header("X-Request-ID", deleteCustomProfileOptions.xRequestId());
    }
    ResponseConverter<Profile> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Profile>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a profile.
   *
   * View the details of a profile by providing the profile ID.  You can find the profile ID in the Security and
   * Compliance Center UI. For more information, see [Building custom
   * profiles](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-build-custom-profiles&amp;interface=api).
   *
   * @param getProfileOptions the {@link GetProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Profile}
   */
  public ServiceCall<Profile> getProfile(GetProfileOptions getProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getProfileOptions,
      "getProfileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", getProfileOptions.profilesId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/profiles/{profiles_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getProfileOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", getProfileOptions.xCorrelationId());
    }
    if (getProfileOptions.xRequestId() != null) {
      builder.header("X-Request-ID", getProfileOptions.xRequestId());
    }
    ResponseConverter<Profile> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Profile>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a profile.
   *
   * Update the details of a custom profile. With Security and Compliance Center, you can manage  a profile that is
   * specific to your usecase, by using an existing library as a starting point.  For more information, see [Building
   * custom
   * profiles](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-build-custom-profiles&amp;interface=api).
   *
   * @param replaceProfileOptions the {@link ReplaceProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Profile}
   */
  public ServiceCall<Profile> replaceProfile(ReplaceProfileOptions replaceProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceProfileOptions,
      "replaceProfileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", replaceProfileOptions.profilesId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/profiles/{profiles_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "replaceProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (replaceProfileOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", replaceProfileOptions.xCorrelationId());
    }
    if (replaceProfileOptions.xRequestId() != null) {
      builder.header("X-Request-ID", replaceProfileOptions.xRequestId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("profile_name", replaceProfileOptions.profileName());
    contentJson.addProperty("profile_description", replaceProfileOptions.profileDescription());
    contentJson.addProperty("profile_type", replaceProfileOptions.profileType());
    contentJson.add("controls", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileOptions.controls()));
    contentJson.add("default_parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileOptions.defaultParameters()));
    builder.bodyJson(contentJson);
    ResponseConverter<Profile> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Profile>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List all rules.
   *
   * Retrieve all the rules that you use to target the exact configuration properties  that you need to ensure are
   * compliant. For more information, see [Defining custom
   * rules](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-rules-define).
   *
   * @param listRulesOptions the {@link ListRulesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link RulesPageBase}
   */
  public ServiceCall<RulesPageBase> listRules(ListRulesOptions listRulesOptions) {
    if (listRulesOptions == null) {
      listRulesOptions = new ListRulesOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/rules"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listRules");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listRulesOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-Id", listRulesOptions.xCorrelationId());
    }
    if (listRulesOptions.xRequestId() != null) {
      builder.header("X-Request-Id", listRulesOptions.xRequestId());
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
    ResponseConverter<RulesPageBase> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<RulesPageBase>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List all rules.
   *
   * Retrieve all the rules that you use to target the exact configuration properties  that you need to ensure are
   * compliant. For more information, see [Defining custom
   * rules](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-rules-define).
   *
   * @return a {@link ServiceCall} with a result of type {@link RulesPageBase}
   */
  public ServiceCall<RulesPageBase> listRules() {
    return listRules(null);
  }

  /**
   * Create a custom rule.
   *
   * Create a custom rule to to target the exact configuration properties  that you need to evaluate your resources for
   * compliance. For more information, see [Defining custom
   * rules](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-rules-define).
   *
   * @param createRuleOptions the {@link CreateRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Rule}
   */
  public ServiceCall<Rule> createRule(CreateRuleOptions createRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createRuleOptions,
      "createRuleOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/rules"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "createRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createRuleOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-Id", createRuleOptions.xCorrelationId());
    }
    if (createRuleOptions.xRequestId() != null) {
      builder.header("X-Request-Id", createRuleOptions.xRequestId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("description", createRuleOptions.description());
    contentJson.add("target", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createRuleOptions.target()));
    contentJson.add("required_config", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createRuleOptions.requiredConfig()));
    if (createRuleOptions.type() != null) {
      contentJson.addProperty("type", createRuleOptions.type());
    }
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
   * Delete a custom rule.
   *
   * Delete a custom rule that you no longer require to evaluate your resources. For more information, see [Defining
   * custom rules](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-rules-define).
   *
   * @param deleteRuleOptions the {@link DeleteRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteRule(DeleteRuleOptions deleteRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteRuleOptions,
      "deleteRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("rule_id", deleteRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/rules/{rule_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "deleteRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (deleteRuleOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-Id", deleteRuleOptions.xCorrelationId());
    }
    if (deleteRuleOptions.xRequestId() != null) {
      builder.header("X-Request-Id", deleteRuleOptions.xRequestId());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a custom rule.
   *
   * Retrieve a rule that you created to evaluate your resources.  For more information, see [Defining custom
   * rules](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-rules-define).
   *
   * @param getRuleOptions the {@link GetRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Rule}
   */
  public ServiceCall<Rule> getRule(GetRuleOptions getRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getRuleOptions,
      "getRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("rule_id", getRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/rules/{rule_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getRuleOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-Id", getRuleOptions.xCorrelationId());
    }
    if (getRuleOptions.xRequestId() != null) {
      builder.header("X-Request-Id", getRuleOptions.xRequestId());
    }
    ResponseConverter<Rule> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Rule>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a custom rule.
   *
   * Update a custom rule that you use to target the exact configuration properties  that you need to evaluate your
   * resources for compliance. For more information, see [Defining custom
   * rules](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-rules-define).
   *
   * @param replaceRuleOptions the {@link ReplaceRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Rule}
   */
  public ServiceCall<Rule> replaceRule(ReplaceRuleOptions replaceRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceRuleOptions,
      "replaceRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("rule_id", replaceRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/rules/{rule_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "replaceRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", replaceRuleOptions.ifMatch());
    if (replaceRuleOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-Id", replaceRuleOptions.xCorrelationId());
    }
    if (replaceRuleOptions.xRequestId() != null) {
      builder.header("X-Request-Id", replaceRuleOptions.xRequestId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("description", replaceRuleOptions.description());
    contentJson.add("target", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceRuleOptions.target()));
    contentJson.add("required_config", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceRuleOptions.requiredConfig()));
    if (replaceRuleOptions.type() != null) {
      contentJson.addProperty("type", replaceRuleOptions.type());
    }
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
   * Get all attachments linked to a specific profile.
   *
   * View all of the attachments that are linked to a specific profile.  An attachment is the association between the
   * set of resources that you want to evaluate  and a profile that contains the specific controls that you want to use.
   * For more information, see [Running an evaluation for IBM
   * Cloud](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-scan-resources).
   *
   * @param listAttachmentsOptions the {@link ListAttachmentsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AttachmentCollection}
   */
  public ServiceCall<AttachmentCollection> listAttachments(ListAttachmentsOptions listAttachmentsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listAttachmentsOptions,
      "listAttachmentsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", listAttachmentsOptions.profilesId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/profiles/{profiles_id}/attachments", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listAttachments");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listAttachmentsOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", listAttachmentsOptions.xCorrelationId());
    }
    if (listAttachmentsOptions.xRequestId() != null) {
      builder.header("X-Request-ID", listAttachmentsOptions.xRequestId());
    }
    if (listAttachmentsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listAttachmentsOptions.limit()));
    }
    if (listAttachmentsOptions.start() != null) {
      builder.query("start", String.valueOf(listAttachmentsOptions.start()));
    }
    ResponseConverter<AttachmentCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AttachmentCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create an attachment.
   *
   * Create an attachment to link to a profile to schedule evaluations  of your resources on a recurring schedule, or
   * on-demand. For more information, see [Running an evaluation for IBM
   * Cloud](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-scan-resources).
   *
   * @param createAttachmentOptions the {@link CreateAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AttachmentPrototype}
   */
  public ServiceCall<AttachmentPrototype> createAttachment(CreateAttachmentOptions createAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createAttachmentOptions,
      "createAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", createAttachmentOptions.profilesId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/profiles/{profiles_id}/attachments", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "createAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createAttachmentOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", createAttachmentOptions.xCorrelationId());
    }
    if (createAttachmentOptions.xRequestId() != null) {
      builder.header("X-Request-ID", createAttachmentOptions.xRequestId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("attachments", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createAttachmentOptions.attachments()));
    if (createAttachmentOptions.profileId() != null) {
      contentJson.addProperty("profile_id", createAttachmentOptions.profileId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<AttachmentPrototype> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AttachmentPrototype>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete an attachment.
   *
   * Delete an attachment. Alternatively, if you think that you might need  this configuration in the future, you can
   * pause an attachment to stop being charged. For more information, see [Running an evaluation for IBM
   * Cloud](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-scan-resources).
   *
   * @param deleteProfileAttachmentOptions the {@link DeleteProfileAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AttachmentItem}
   */
  public ServiceCall<AttachmentItem> deleteProfileAttachment(DeleteProfileAttachmentOptions deleteProfileAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteProfileAttachmentOptions,
      "deleteProfileAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("attachment_id", deleteProfileAttachmentOptions.attachmentId());
    pathParamsMap.put("profiles_id", deleteProfileAttachmentOptions.profilesId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/profiles/{profiles_id}/attachments/{attachment_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "deleteProfileAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteProfileAttachmentOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", deleteProfileAttachmentOptions.xCorrelationId());
    }
    if (deleteProfileAttachmentOptions.xRequestId() != null) {
      builder.header("X-Request-ID", deleteProfileAttachmentOptions.xRequestId());
    }
    ResponseConverter<AttachmentItem> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AttachmentItem>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get an attachment.
   *
   * View the details of an attachment a profile by providing the attachment ID.  You can find this value in the
   * Security and Compliance Center UI. For more information, see [Running an evaluation for IBM
   * Cloud](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-scan-resources).
   *
   * @param getProfileAttachmentOptions the {@link GetProfileAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AttachmentItem}
   */
  public ServiceCall<AttachmentItem> getProfileAttachment(GetProfileAttachmentOptions getProfileAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getProfileAttachmentOptions,
      "getProfileAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("attachment_id", getProfileAttachmentOptions.attachmentId());
    pathParamsMap.put("profiles_id", getProfileAttachmentOptions.profilesId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/profiles/{profiles_id}/attachments/{attachment_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getProfileAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getProfileAttachmentOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", getProfileAttachmentOptions.xCorrelationId());
    }
    if (getProfileAttachmentOptions.xRequestId() != null) {
      builder.header("X-Request-ID", getProfileAttachmentOptions.xRequestId());
    }
    ResponseConverter<AttachmentItem> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AttachmentItem>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update an attachment.
   *
   * Update an attachment that is linked to a profile to evaluate your resources  on a recurring schedule, or on-demand.
   * For more information, see [Running an evaluation for IBM
   * Cloud](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-scan-resources).
   *
   * @param replaceProfileAttachmentOptions the {@link ReplaceProfileAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AttachmentItem}
   */
  public ServiceCall<AttachmentItem> replaceProfileAttachment(ReplaceProfileAttachmentOptions replaceProfileAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceProfileAttachmentOptions,
      "replaceProfileAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("attachment_id", replaceProfileAttachmentOptions.attachmentId());
    pathParamsMap.put("profiles_id", replaceProfileAttachmentOptions.profilesId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/profiles/{profiles_id}/attachments/{attachment_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "replaceProfileAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (replaceProfileAttachmentOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", replaceProfileAttachmentOptions.xCorrelationId());
    }
    if (replaceProfileAttachmentOptions.xRequestId() != null) {
      builder.header("X-Request-ID", replaceProfileAttachmentOptions.xRequestId());
    }
    final JsonObject contentJson = new JsonObject();
    if (replaceProfileAttachmentOptions.id() != null) {
      contentJson.addProperty("id", replaceProfileAttachmentOptions.id());
    }
    if (replaceProfileAttachmentOptions.profileId() != null) {
      contentJson.addProperty("profile_id", replaceProfileAttachmentOptions.profileId());
    }
    if (replaceProfileAttachmentOptions.accountId() != null) {
      contentJson.addProperty("account_id", replaceProfileAttachmentOptions.accountId());
    }
    if (replaceProfileAttachmentOptions.instanceId() != null) {
      contentJson.addProperty("instance_id", replaceProfileAttachmentOptions.instanceId());
    }
    if (replaceProfileAttachmentOptions.scope() != null) {
      contentJson.add("scope", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileAttachmentOptions.scope()));
    }
    if (replaceProfileAttachmentOptions.createdOn() != null) {
      contentJson.add("created_on", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileAttachmentOptions.createdOn()));
    }
    if (replaceProfileAttachmentOptions.createdBy() != null) {
      contentJson.addProperty("created_by", replaceProfileAttachmentOptions.createdBy());
    }
    if (replaceProfileAttachmentOptions.updatedOn() != null) {
      contentJson.add("updated_on", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileAttachmentOptions.updatedOn()));
    }
    if (replaceProfileAttachmentOptions.updatedBy() != null) {
      contentJson.addProperty("updated_by", replaceProfileAttachmentOptions.updatedBy());
    }
    if (replaceProfileAttachmentOptions.status() != null) {
      contentJson.addProperty("status", replaceProfileAttachmentOptions.status());
    }
    if (replaceProfileAttachmentOptions.schedule() != null) {
      contentJson.addProperty("schedule", replaceProfileAttachmentOptions.schedule());
    }
    if (replaceProfileAttachmentOptions.notifications() != null) {
      contentJson.add("notifications", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileAttachmentOptions.notifications()));
    }
    if (replaceProfileAttachmentOptions.attachmentParameters() != null) {
      contentJson.add("attachment_parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileAttachmentOptions.attachmentParameters()));
    }
    if (replaceProfileAttachmentOptions.lastScan() != null) {
      contentJson.add("last_scan", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileAttachmentOptions.lastScan()));
    }
    if (replaceProfileAttachmentOptions.nextScanTime() != null) {
      contentJson.add("next_scan_time", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileAttachmentOptions.nextScanTime()));
    }
    if (replaceProfileAttachmentOptions.name() != null) {
      contentJson.addProperty("name", replaceProfileAttachmentOptions.name());
    }
    if (replaceProfileAttachmentOptions.description() != null) {
      contentJson.addProperty("description", replaceProfileAttachmentOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<AttachmentItem> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AttachmentItem>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a scan.
   *
   * Create a scan to evaluate your resources on a recurring basis or on demand.
   *
   * @param createScanOptions the {@link CreateScanOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Scan}
   */
  public ServiceCall<Scan> createScan(CreateScanOptions createScanOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createScanOptions,
      "createScanOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/scans"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "createScan");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createScanOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", createScanOptions.xCorrelationId());
    }
    if (createScanOptions.xRequestId() != null) {
      builder.header("X-Request-ID", createScanOptions.xRequestId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("attachment_id", createScanOptions.attachmentId());
    builder.bodyJson(contentJson);
    ResponseConverter<Scan> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Scan>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all attachments in an instance.
   *
   * View all of the attachments that are linked to an account. An attachment is the association between the set of
   * resources that you want to evaluate  and a profile that contains the specific controls that you want to use. For
   * more information, see [Running an evaluation for IBM
   * Cloud](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-scan-resources).
   *
   * @param listAttachmentsAccountOptions the {@link ListAttachmentsAccountOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AttachmentCollection}
   */
  public ServiceCall<AttachmentCollection> listAttachmentsAccount(ListAttachmentsAccountOptions listAttachmentsAccountOptions) {
    if (listAttachmentsAccountOptions == null) {
      listAttachmentsAccountOptions = new ListAttachmentsAccountOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/attachments"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listAttachmentsAccount");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listAttachmentsAccountOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", listAttachmentsAccountOptions.xCorrelationId());
    }
    if (listAttachmentsAccountOptions.xRequestId() != null) {
      builder.header("X-Request-ID", listAttachmentsAccountOptions.xRequestId());
    }
    if (listAttachmentsAccountOptions.limit() != null) {
      builder.query("limit", String.valueOf(listAttachmentsAccountOptions.limit()));
    }
    if (listAttachmentsAccountOptions.start() != null) {
      builder.query("start", String.valueOf(listAttachmentsAccountOptions.start()));
    }
    ResponseConverter<AttachmentCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AttachmentCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all attachments in an instance.
   *
   * View all of the attachments that are linked to an account. An attachment is the association between the set of
   * resources that you want to evaluate  and a profile that contains the specific controls that you want to use. For
   * more information, see [Running an evaluation for IBM
   * Cloud](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-scan-resources).
   *
   * @return a {@link ServiceCall} with a result of type {@link AttachmentCollection}
   */
  public ServiceCall<AttachmentCollection> listAttachmentsAccount() {
    return listAttachmentsAccount(null);
  }

  /**
   * Get the latest reports.
   *
   * Retrieve the latest reports, which are grouped by profile ID, scope ID, and attachment ID. For more information,
   * see [Viewing results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @param getLatestReportsOptions the {@link GetLatestReportsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ReportLatest}
   */
  public ServiceCall<ReportLatest> getLatestReports(GetLatestReportsOptions getLatestReportsOptions) {
    if (getLatestReportsOptions == null) {
      getLatestReportsOptions = new GetLatestReportsOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/reports/latest"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getLatestReports");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getLatestReportsOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", getLatestReportsOptions.xCorrelationId());
    }
    if (getLatestReportsOptions.xRequestId() != null) {
      builder.header("X-Request-ID", getLatestReportsOptions.xRequestId());
    }
    if (getLatestReportsOptions.sort() != null) {
      builder.query("sort", String.valueOf(getLatestReportsOptions.sort()));
    }
    ResponseConverter<ReportLatest> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ReportLatest>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get the latest reports.
   *
   * Retrieve the latest reports, which are grouped by profile ID, scope ID, and attachment ID. For more information,
   * see [Viewing results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @return a {@link ServiceCall} with a result of type {@link ReportLatest}
   */
  public ServiceCall<ReportLatest> getLatestReports() {
    return getLatestReports(null);
  }

  /**
   * List reports.
   *
   * Retrieve a page of reports that are filtered by the specified parameters. For more information, see [Viewing
   * results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @param listReportsOptions the {@link ListReportsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ReportPage}
   */
  public ServiceCall<ReportPage> listReports(ListReportsOptions listReportsOptions) {
    if (listReportsOptions == null) {
      listReportsOptions = new ListReportsOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/reports"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listReports");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listReportsOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", listReportsOptions.xCorrelationId());
    }
    if (listReportsOptions.xRequestId() != null) {
      builder.header("X-Request-ID", listReportsOptions.xRequestId());
    }
    if (listReportsOptions.attachmentId() != null) {
      builder.query("attachment_id", String.valueOf(listReportsOptions.attachmentId()));
    }
    if (listReportsOptions.groupId() != null) {
      builder.query("group_id", String.valueOf(listReportsOptions.groupId()));
    }
    if (listReportsOptions.profileId() != null) {
      builder.query("profile_id", String.valueOf(listReportsOptions.profileId()));
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
    ResponseConverter<ReportPage> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ReportPage>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List reports.
   *
   * Retrieve a page of reports that are filtered by the specified parameters. For more information, see [Viewing
   * results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @return a {@link ServiceCall} with a result of type {@link ReportPage}
   */
  public ServiceCall<ReportPage> listReports() {
    return listReports(null);
  }

  /**
   * Get a report.
   *
   * Retrieve a report by specifying its ID. For more information, see [Viewing
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
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/reports/{report_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getReport");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getReportOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", getReportOptions.xCorrelationId());
    }
    if (getReportOptions.xRequestId() != null) {
      builder.header("X-Request-ID", getReportOptions.xRequestId());
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
    pathParamsMap.put("report_id", getReportSummaryOptions.reportId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/reports/{report_id}/summary", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getReportSummary");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getReportSummaryOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", getReportSummaryOptions.xCorrelationId());
    }
    if (getReportSummaryOptions.xRequestId() != null) {
      builder.header("X-Request-ID", getReportSummaryOptions.xRequestId());
    }
    ResponseConverter<ReportSummary> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ReportSummary>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get report evaluation details.
   *
   * Retrieve the evaluation details of a report by specifying the report ID. For more information, see [Viewing
   * results](https://cloud.ibm.com/docs/security-compliance?topic=security-compliance-results).
   *
   * @param getReportEvaluationOptions the {@link GetReportEvaluationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> getReportEvaluation(GetReportEvaluationOptions getReportEvaluationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getReportEvaluationOptions,
      "getReportEvaluationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("report_id", getReportEvaluationOptions.reportId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/reports/{report_id}/download", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getReportEvaluation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/csv");
    if (getReportEvaluationOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", getReportEvaluationOptions.xCorrelationId());
    }
    if (getReportEvaluationOptions.xRequestId() != null) {
      builder.header("X-Request-ID", getReportEvaluationOptions.xRequestId());
    }
    if (getReportEvaluationOptions.excludeSummary() != null) {
      builder.query("exclude_summary", String.valueOf(getReportEvaluationOptions.excludeSummary()));
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
    pathParamsMap.put("report_id", getReportControlsOptions.reportId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/reports/{report_id}/controls", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getReportControls");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getReportControlsOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", getReportControlsOptions.xCorrelationId());
    }
    if (getReportControlsOptions.xRequestId() != null) {
      builder.header("X-Request-ID", getReportControlsOptions.xRequestId());
    }
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
    pathParamsMap.put("report_id", getReportRuleOptions.reportId());
    pathParamsMap.put("rule_id", getReportRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/reports/{report_id}/rules/{rule_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getReportRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getReportRuleOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", getReportRuleOptions.xCorrelationId());
    }
    if (getReportRuleOptions.xRequestId() != null) {
      builder.header("X-Request-ID", getReportRuleOptions.xRequestId());
    }
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
    pathParamsMap.put("report_id", listReportEvaluationsOptions.reportId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/reports/{report_id}/evaluations", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listReportEvaluations");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listReportEvaluationsOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", listReportEvaluationsOptions.xCorrelationId());
    }
    if (listReportEvaluationsOptions.xRequestId() != null) {
      builder.header("X-Request-ID", listReportEvaluationsOptions.xRequestId());
    }
    if (listReportEvaluationsOptions.assessmentId() != null) {
      builder.query("assessment_id", String.valueOf(listReportEvaluationsOptions.assessmentId()));
    }
    if (listReportEvaluationsOptions.componentId() != null) {
      builder.query("component_id", String.valueOf(listReportEvaluationsOptions.componentId()));
    }
    if (listReportEvaluationsOptions.targetId() != null) {
      builder.query("target_id", String.valueOf(listReportEvaluationsOptions.targetId()));
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
    pathParamsMap.put("report_id", listReportResourcesOptions.reportId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/reports/{report_id}/resources", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listReportResources");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listReportResourcesOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", listReportResourcesOptions.xCorrelationId());
    }
    if (listReportResourcesOptions.xRequestId() != null) {
      builder.header("X-Request-ID", listReportResourcesOptions.xRequestId());
    }
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
    ResponseConverter<ResourcePage> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourcePage>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get report tags.
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
    pathParamsMap.put("report_id", getReportTagsOptions.reportId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/reports/{report_id}/tags", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getReportTags");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getReportTagsOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", getReportTagsOptions.xCorrelationId());
    }
    if (getReportTagsOptions.xRequestId() != null) {
      builder.header("X-Request-ID", getReportTagsOptions.xRequestId());
    }
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
    pathParamsMap.put("report_id", getReportViolationsDriftOptions.reportId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/reports/{report_id}/violations_drift", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getReportViolationsDrift");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getReportViolationsDriftOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", getReportViolationsDriftOptions.xCorrelationId());
    }
    if (getReportViolationsDriftOptions.xRequestId() != null) {
      builder.header("X-Request-ID", getReportViolationsDriftOptions.xRequestId());
    }
    if (getReportViolationsDriftOptions.scanTimeDuration() != null) {
      builder.query("scan_time_duration", String.valueOf(getReportViolationsDriftOptions.scanTimeDuration()));
    }
    ResponseConverter<ReportViolationsDrift> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ReportViolationsDrift>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List all provider types.
   *
   * List all the registered provider types. For more information about connecting Workload Protection with the Security
   * and Compliance Center, see [Connecting Workload
   * Protection](/docs/security-compliance?topic=security-compliance-setup-workload-protection&amp;interface=api#wp-register).
   *
   * @param listProviderTypesOptions the {@link ListProviderTypesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProviderTypesCollection}
   */
  public ServiceCall<ProviderTypesCollection> listProviderTypes(ListProviderTypesOptions listProviderTypesOptions) {
    if (listProviderTypesOptions == null) {
      listProviderTypesOptions = new ListProviderTypesOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/provider_types"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listProviderTypes");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listProviderTypesOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", listProviderTypesOptions.xCorrelationId());
    }
    if (listProviderTypesOptions.xRequestId() != null) {
      builder.header("X-Request-ID", listProviderTypesOptions.xRequestId());
    }
    ResponseConverter<ProviderTypesCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProviderTypesCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List all provider types.
   *
   * List all the registered provider types. For more information about connecting Workload Protection with the Security
   * and Compliance Center, see [Connecting Workload
   * Protection](/docs/security-compliance?topic=security-compliance-setup-workload-protection&amp;interface=api#wp-register).
   *
   * @return a {@link ServiceCall} with a result of type {@link ProviderTypesCollection}
   */
  public ServiceCall<ProviderTypesCollection> listProviderTypes() {
    return listProviderTypes(null);
  }

  /**
   * Get a provider type.
   *
   * Retrieve a provider type by specifying its ID. For more information about integrations, see [Connecting Workload
   * Protection](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-setup-workload-protection).
   *
   * @param getProviderTypeByIdOptions the {@link GetProviderTypeByIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProviderTypeItem}
   */
  public ServiceCall<ProviderTypeItem> getProviderTypeById(GetProviderTypeByIdOptions getProviderTypeByIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getProviderTypeByIdOptions,
      "getProviderTypeByIdOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("provider_type_id", getProviderTypeByIdOptions.providerTypeId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/provider_types/{provider_type_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getProviderTypeById");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getProviderTypeByIdOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", getProviderTypeByIdOptions.xCorrelationId());
    }
    if (getProviderTypeByIdOptions.xRequestId() != null) {
      builder.header("X-Request-ID", getProviderTypeByIdOptions.xRequestId());
    }
    ResponseConverter<ProviderTypeItem> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProviderTypeItem>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List all provider type instances.
   *
   * Retrieve all instances of provider type. For more information about integrations, see [Connecting Workload
   * Protection](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-setup-workload-protection).
   *
   * @param listProviderTypeInstancesOptions the {@link ListProviderTypeInstancesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProviderTypeInstancesResponse}
   */
  public ServiceCall<ProviderTypeInstancesResponse> listProviderTypeInstances(ListProviderTypeInstancesOptions listProviderTypeInstancesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listProviderTypeInstancesOptions,
      "listProviderTypeInstancesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("provider_type_id", listProviderTypeInstancesOptions.providerTypeId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/provider_types/{provider_type_id}/provider_type_instances", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "listProviderTypeInstances");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listProviderTypeInstancesOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", listProviderTypeInstancesOptions.xCorrelationId());
    }
    if (listProviderTypeInstancesOptions.xRequestId() != null) {
      builder.header("X-Request-ID", listProviderTypeInstancesOptions.xRequestId());
    }
    ResponseConverter<ProviderTypeInstancesResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProviderTypeInstancesResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a provider type instance.
   *
   * Create an instance of a provider type. For more information about integrations, see [Connecting Workload
   * Protection](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-setup-workload-protection).
   *
   * @param createProviderTypeInstanceOptions the {@link CreateProviderTypeInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProviderTypeInstanceItem}
   */
  public ServiceCall<ProviderTypeInstanceItem> createProviderTypeInstance(CreateProviderTypeInstanceOptions createProviderTypeInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createProviderTypeInstanceOptions,
      "createProviderTypeInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("provider_type_id", createProviderTypeInstanceOptions.providerTypeId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/provider_types/{provider_type_id}/provider_type_instances", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "createProviderTypeInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createProviderTypeInstanceOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", createProviderTypeInstanceOptions.xCorrelationId());
    }
    if (createProviderTypeInstanceOptions.xRequestId() != null) {
      builder.header("X-Request-ID", createProviderTypeInstanceOptions.xRequestId());
    }
    final JsonObject contentJson = new JsonObject();
    if (createProviderTypeInstanceOptions.name() != null) {
      contentJson.addProperty("name", createProviderTypeInstanceOptions.name());
    }
    if (createProviderTypeInstanceOptions.attributes() != null) {
      contentJson.add("attributes", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createProviderTypeInstanceOptions.attributes()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ProviderTypeInstanceItem> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProviderTypeInstanceItem>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Remove a specific instance of a provider type.
   *
   * Remove a specific instance of a provider type.
   *
   * @param deleteProviderTypeInstanceOptions the {@link DeleteProviderTypeInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteProviderTypeInstance(DeleteProviderTypeInstanceOptions deleteProviderTypeInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteProviderTypeInstanceOptions,
      "deleteProviderTypeInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("provider_type_id", deleteProviderTypeInstanceOptions.providerTypeId());
    pathParamsMap.put("provider_type_instance_id", deleteProviderTypeInstanceOptions.providerTypeInstanceId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/provider_types/{provider_type_id}/provider_type_instances/{provider_type_instance_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "deleteProviderTypeInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (deleteProviderTypeInstanceOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", deleteProviderTypeInstanceOptions.xCorrelationId());
    }
    if (deleteProviderTypeInstanceOptions.xRequestId() != null) {
      builder.header("X-Request-ID", deleteProviderTypeInstanceOptions.xRequestId());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List a provider type instance.
   *
   * Retrieve a provider type instance by specifying the provider type ID, and Security and Compliance Center instance
   * ID. For more information about integrations, see [Connecting Workload
   * Protection](https://test.cloud.ibm.com/docs/security-compliance?topic=security-compliance-setup-workload-protection).
   *
   * @param getProviderTypeInstanceOptions the {@link GetProviderTypeInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProviderTypeInstanceItem}
   */
  public ServiceCall<ProviderTypeInstanceItem> getProviderTypeInstance(GetProviderTypeInstanceOptions getProviderTypeInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getProviderTypeInstanceOptions,
      "getProviderTypeInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("provider_type_id", getProviderTypeInstanceOptions.providerTypeId());
    pathParamsMap.put("provider_type_instance_id", getProviderTypeInstanceOptions.providerTypeInstanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/provider_types/{provider_type_id}/provider_type_instances/{provider_type_instance_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getProviderTypeInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getProviderTypeInstanceOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", getProviderTypeInstanceOptions.xCorrelationId());
    }
    if (getProviderTypeInstanceOptions.xRequestId() != null) {
      builder.header("X-Request-ID", getProviderTypeInstanceOptions.xRequestId());
    }
    ResponseConverter<ProviderTypeInstanceItem> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProviderTypeInstanceItem>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Patch a specific instance of a provider type.
   *
   * Patch a specific instance of a provider type.
   *
   * @param updateProviderTypeInstanceOptions the {@link UpdateProviderTypeInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProviderTypeInstanceItem}
   */
  public ServiceCall<ProviderTypeInstanceItem> updateProviderTypeInstance(UpdateProviderTypeInstanceOptions updateProviderTypeInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateProviderTypeInstanceOptions,
      "updateProviderTypeInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("provider_type_id", updateProviderTypeInstanceOptions.providerTypeId());
    pathParamsMap.put("provider_type_instance_id", updateProviderTypeInstanceOptions.providerTypeInstanceId());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/provider_types/{provider_type_id}/provider_type_instances/{provider_type_instance_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "updateProviderTypeInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (updateProviderTypeInstanceOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", updateProviderTypeInstanceOptions.xCorrelationId());
    }
    if (updateProviderTypeInstanceOptions.xRequestId() != null) {
      builder.header("X-Request-ID", updateProviderTypeInstanceOptions.xRequestId());
    }
    final JsonObject contentJson = new JsonObject();
    if (updateProviderTypeInstanceOptions.name() != null) {
      contentJson.addProperty("name", updateProviderTypeInstanceOptions.name());
    }
    if (updateProviderTypeInstanceOptions.attributes() != null) {
      contentJson.add("attributes", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateProviderTypeInstanceOptions.attributes()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ProviderTypeInstanceItem> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProviderTypeInstanceItem>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of instances for all provider types.
   *
   * Get a list of instances for all provider types.
   *
   * @param getProviderTypesInstancesOptions the {@link GetProviderTypesInstancesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProviderTypesInstancesResponse}
   */
  public ServiceCall<ProviderTypesInstancesResponse> getProviderTypesInstances(GetProviderTypesInstancesOptions getProviderTypesInstancesOptions) {
    if (getProviderTypesInstancesOptions == null) {
      getProviderTypesInstancesOptions = new GetProviderTypesInstancesOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/provider_types_instances"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("security_and_compliance_center_api", "v3", "getProviderTypesInstances");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getProviderTypesInstancesOptions.xCorrelationId() != null) {
      builder.header("X-Correlation-ID", getProviderTypesInstancesOptions.xCorrelationId());
    }
    if (getProviderTypesInstancesOptions.xRequestId() != null) {
      builder.header("X-Request-ID", getProviderTypesInstancesOptions.xRequestId());
    }
    ResponseConverter<ProviderTypesInstancesResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProviderTypesInstancesResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of instances for all provider types.
   *
   * Get a list of instances for all provider types.
   *
   * @return a {@link ServiceCall} with a result of type {@link ProviderTypesInstancesResponse}
   */
  public ServiceCall<ProviderTypesInstancesResponse> getProviderTypesInstances() {
    return getProviderTypesInstances(null);
  }

}
