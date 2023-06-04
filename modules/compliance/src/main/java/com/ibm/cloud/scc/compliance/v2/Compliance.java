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
 * IBM OpenAPI SDK Code Generator Version: 3.72.0-5d70f2bb-20230511-203609
 */

package com.ibm.cloud.scc.compliance.v2;

import com.google.gson.JsonObject;
import com.ibm.cloud.scc.common.SdkCommon;
import com.ibm.cloud.scc.compliance.v2.model.AddProfileOptions;
import com.ibm.cloud.scc.compliance.v2.model.AttachmentPayload;
import com.ibm.cloud.scc.compliance.v2.model.AttachmentProfileResponse;
import com.ibm.cloud.scc.compliance.v2.model.CheckProfileAttachmnetsOptions;
import com.ibm.cloud.scc.compliance.v2.model.ControlLibraryRequest;
import com.ibm.cloud.scc.compliance.v2.model.CreateAttachmentOptions;
import com.ibm.cloud.scc.compliance.v2.model.CreateCustomControlLibraryOptions;
import com.ibm.cloud.scc.compliance.v2.model.CreateProfileOptions;
import com.ibm.cloud.scc.compliance.v2.model.CreateScanOptions;
import com.ibm.cloud.scc.compliance.v2.model.CreateScanResponse;
import com.ibm.cloud.scc.compliance.v2.model.DeleteCustomControllibraryOptions;
import com.ibm.cloud.scc.compliance.v2.model.DeleteCustomProfileOptions;
import com.ibm.cloud.scc.compliance.v2.model.DeleteProfileAttachmnetOptions;
import com.ibm.cloud.scc.compliance.v2.model.GetAllAttachmnetsForProfileRespBody;
import com.ibm.cloud.scc.compliance.v2.model.GetAllControlLibrariesRespBody;
import com.ibm.cloud.scc.compliance.v2.model.GetAllProfilesRespBody;
import com.ibm.cloud.scc.compliance.v2.model.GetControlLibraryOptions;
import com.ibm.cloud.scc.compliance.v2.model.GetParametersByNameOptions;
import com.ibm.cloud.scc.compliance.v2.model.GetProfileAttachmnetOptions;
import com.ibm.cloud.scc.compliance.v2.model.GetProfileOptions;
import com.ibm.cloud.scc.compliance.v2.model.ListAttachmentParametersOptions;
import com.ibm.cloud.scc.compliance.v2.model.ListControlLibrariesOptions;
import com.ibm.cloud.scc.compliance.v2.model.ListProfilesOptions;
import com.ibm.cloud.scc.compliance.v2.model.ParameterDetails;
import com.ibm.cloud.scc.compliance.v2.model.ProfileDefaultParametersResponse;
import com.ibm.cloud.scc.compliance.v2.model.ProfileResponse;
import com.ibm.cloud.scc.compliance.v2.model.ReplaceAttachmentOptions;
import com.ibm.cloud.scc.compliance.v2.model.ReplaceAttachmnetParametersByNameOptions;
import com.ibm.cloud.scc.compliance.v2.model.ReplaceCustomControlLibraryOptions;
import com.ibm.cloud.scc.compliance.v2.model.ReplaceProfileAttachmentOptions;
import com.ibm.cloud.scc.compliance.v2.model.ReplaceProfileParametersOptions;
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
 * The SCC Phoenix Compliance APIs.
 *
 * API Version: 2.0.0
 */
public class Compliance extends BaseService {

  /**
   * Default service name used when configuring the `Compliance` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "compliance";

 /**
   * Class method which constructs an instance of the `Compliance` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `Compliance` client using external configuration
   */
  public static Compliance newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `Compliance` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `Compliance` client using external configuration
   */
  public static Compliance newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    Compliance service = new Compliance(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `Compliance` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public Compliance(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
  }

  /**
   * Create a custom profile.
   *
   * Create a user-defined custom profile.
   *
   * @param createProfileOptions the {@link CreateProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileResponse}
   */
  public ServiceCall<ProfileResponse> createProfile(CreateProfileOptions createProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createProfileOptions,
      "createProfileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", createProfileOptions.instanceId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "createProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createProfileOptions.transactionId() != null) {
      builder.header("Transaction-Id", createProfileOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    if (createProfileOptions.profileName() != null) {
      contentJson.addProperty("profile_name", createProfileOptions.profileName());
    }
    if (createProfileOptions.profileDescription() != null) {
      contentJson.addProperty("profile_description", createProfileOptions.profileDescription());
    }
    if (createProfileOptions.profileType() != null) {
      contentJson.addProperty("profile_type", createProfileOptions.profileType());
    }
    if (createProfileOptions.profileVersion() != null) {
      contentJson.addProperty("profile_version", createProfileOptions.profileVersion());
    }
    if (createProfileOptions.latest() != null) {
      contentJson.addProperty("latest", createProfileOptions.latest());
    }
    if (createProfileOptions.versionGroupLabel() != null) {
      contentJson.addProperty("version_group_label", createProfileOptions.versionGroupLabel());
    }
    if (createProfileOptions.controls() != null) {
      contentJson.add("controls", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createProfileOptions.controls()));
    }
    if (createProfileOptions.defaultParameters() != null) {
      contentJson.add("default_parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createProfileOptions.defaultParameters()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ProfileResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all predefined and user's custom profiles.
   *
   * Get all predefined and user's custom profiles.
   *
   * @param listProfilesOptions the {@link ListProfilesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetAllProfilesRespBody}
   */
  public ServiceCall<GetAllProfilesRespBody> listProfiles(ListProfilesOptions listProfilesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listProfilesOptions,
      "listProfilesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listProfilesOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "listProfiles");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listProfilesOptions.transactionId() != null) {
      builder.header("Transaction-Id", listProfilesOptions.transactionId());
    }
    ResponseConverter<GetAllProfilesRespBody> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetAllProfilesRespBody>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a custom profile.
   *
   * Update a user-defined custom profile.
   *
   * @param addProfileOptions the {@link AddProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileResponse}
   */
  public ServiceCall<ProfileResponse> addProfile(AddProfileOptions addProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addProfileOptions,
      "addProfileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", addProfileOptions.profilesId());
    pathParamsMap.put("instance_id", addProfileOptions.instanceId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profiles_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "addProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (addProfileOptions.transactionId() != null) {
      builder.header("Transaction-Id", addProfileOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    if (addProfileOptions.profileName() != null) {
      contentJson.addProperty("profile_name", addProfileOptions.profileName());
    }
    if (addProfileOptions.profileDescription() != null) {
      contentJson.addProperty("profile_description", addProfileOptions.profileDescription());
    }
    if (addProfileOptions.profileType() != null) {
      contentJson.addProperty("profile_type", addProfileOptions.profileType());
    }
    if (addProfileOptions.profileVersion() != null) {
      contentJson.addProperty("profile_version", addProfileOptions.profileVersion());
    }
    if (addProfileOptions.latest() != null) {
      contentJson.addProperty("latest", addProfileOptions.latest());
    }
    if (addProfileOptions.versionGroupLabel() != null) {
      contentJson.addProperty("version_group_label", addProfileOptions.versionGroupLabel());
    }
    if (addProfileOptions.controls() != null) {
      contentJson.add("controls", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(addProfileOptions.controls()));
    }
    if (addProfileOptions.defaultParameters() != null) {
      contentJson.add("default_parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(addProfileOptions.defaultParameters()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ProfileResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a profile.
   *
   * Retrieve a profile by specifying the profile ID.
   *
   * @param getProfileOptions the {@link GetProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileResponse}
   */
  public ServiceCall<ProfileResponse> getProfile(GetProfileOptions getProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getProfileOptions,
      "getProfileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", getProfileOptions.profilesId());
    pathParamsMap.put("instance_id", getProfileOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profiles_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "getProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getProfileOptions.transactionId() != null) {
      builder.header("Transaction-Id", getProfileOptions.transactionId());
    }
    ResponseConverter<ProfileResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a custom profile.
   *
   * Delete a custom profile by specifying the profile ID.
   *
   * @param deleteCustomProfileOptions the {@link DeleteCustomProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileResponse}
   */
  public ServiceCall<ProfileResponse> deleteCustomProfile(DeleteCustomProfileOptions deleteCustomProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteCustomProfileOptions,
      "deleteCustomProfileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", deleteCustomProfileOptions.profilesId());
    pathParamsMap.put("instance_id", deleteCustomProfileOptions.instanceId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profiles_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "deleteCustomProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteCustomProfileOptions.transactionId() != null) {
      builder.header("Transaction-Id", deleteCustomProfileOptions.transactionId());
    }
    ResponseConverter<ProfileResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update custom profile parameters.
   *
   * Update the parameters of a custom profile.
   *
   * @param replaceProfileParametersOptions the {@link ReplaceProfileParametersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileDefaultParametersResponse}
   */
  public ServiceCall<ProfileDefaultParametersResponse> replaceProfileParameters(ReplaceProfileParametersOptions replaceProfileParametersOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceProfileParametersOptions,
      "replaceProfileParametersOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", replaceProfileParametersOptions.profilesId());
    pathParamsMap.put("instance_id", replaceProfileParametersOptions.instanceId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profiles_id}/parameters", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "replaceProfileParameters");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (replaceProfileParametersOptions.transactionId() != null) {
      builder.header("Transaction-Id", replaceProfileParametersOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    if (replaceProfileParametersOptions.id() != null) {
      contentJson.addProperty("id", replaceProfileParametersOptions.id());
    }
    if (replaceProfileParametersOptions.defaultParameters() != null) {
      contentJson.add("default_parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileParametersOptions.defaultParameters()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ProfileDefaultParametersResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileDefaultParametersResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create an attachment.
   *
   * Create an attachment to link to a profile.
   *
   * @param createAttachmentOptions the {@link CreateAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AttachmentProfileResponse}
   */
  public ServiceCall<AttachmentProfileResponse> createAttachment(CreateAttachmentOptions createAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createAttachmentOptions,
      "createAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", createAttachmentOptions.profilesId());
    pathParamsMap.put("instance_id", createAttachmentOptions.instanceId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profiles_id}/attachments", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "createAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createAttachmentOptions.transactionId() != null) {
      builder.header("Transaction-Id", createAttachmentOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    if (createAttachmentOptions.attachments() != null) {
      contentJson.add("attachments", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createAttachmentOptions.attachments()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<AttachmentProfileResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AttachmentProfileResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all attachments.
   *
   * Retrieve all attachments that are linked to a profile.
   *
   * @param checkProfileAttachmnetsOptions the {@link CheckProfileAttachmnetsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetAllAttachmnetsForProfileRespBody}
   */
  public ServiceCall<GetAllAttachmnetsForProfileRespBody> checkProfileAttachmnets(CheckProfileAttachmnetsOptions checkProfileAttachmnetsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(checkProfileAttachmnetsOptions,
      "checkProfileAttachmnetsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", checkProfileAttachmnetsOptions.profilesId());
    pathParamsMap.put("instance_id", checkProfileAttachmnetsOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profiles_id}/attachments", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "checkProfileAttachmnets");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (checkProfileAttachmnetsOptions.transactionId() != null) {
      builder.header("Transaction-Id", checkProfileAttachmnetsOptions.transactionId());
    }
    ResponseConverter<GetAllAttachmnetsForProfileRespBody> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetAllAttachmnetsForProfileRespBody>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get an attachment for a profile.
   *
   * Retrieve an attachment that is linked to a profile by specifying the attachment ID.
   *
   * @param getProfileAttachmnetOptions the {@link GetProfileAttachmnetOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AttachmentPayload}
   */
  public ServiceCall<AttachmentPayload> getProfileAttachmnet(GetProfileAttachmnetOptions getProfileAttachmnetOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getProfileAttachmnetOptions,
      "getProfileAttachmnetOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", getProfileAttachmnetOptions.profilesId());
    pathParamsMap.put("attachment_id", getProfileAttachmnetOptions.attachmentId());
    pathParamsMap.put("instance_id", getProfileAttachmnetOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profiles_id}/attachments/{attachment_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "getProfileAttachmnet");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getProfileAttachmnetOptions.transactionId() != null) {
      builder.header("Transaction-Id", getProfileAttachmnetOptions.transactionId());
    }
    ResponseConverter<AttachmentPayload> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AttachmentPayload>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update an attachment.
   *
   * Update an attachment that is linked to a profile.
   *
   * @param replaceProfileAttachmentOptions the {@link ReplaceProfileAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AttachmentPayload}
   */
  public ServiceCall<AttachmentPayload> replaceProfileAttachment(ReplaceProfileAttachmentOptions replaceProfileAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceProfileAttachmentOptions,
      "replaceProfileAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", replaceProfileAttachmentOptions.profilesId());
    pathParamsMap.put("attachment_id", replaceProfileAttachmentOptions.attachmentId());
    pathParamsMap.put("instance_id", replaceProfileAttachmentOptions.instanceId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profiles_id}/attachments/{attachment_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "replaceProfileAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (replaceProfileAttachmentOptions.transactionId() != null) {
      builder.header("Transaction-Id", replaceProfileAttachmentOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    if (replaceProfileAttachmentOptions.id() != null) {
      contentJson.addProperty("id", replaceProfileAttachmentOptions.id());
    }
    if (replaceProfileAttachmentOptions.accountId() != null) {
      contentJson.addProperty("account_id", replaceProfileAttachmentOptions.accountId());
    }
    if (replaceProfileAttachmentOptions.includedScope() != null) {
      contentJson.add("included_scope", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileAttachmentOptions.includedScope()));
    }
    if (replaceProfileAttachmentOptions.exclusions() != null) {
      contentJson.add("exclusions", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileAttachmentOptions.exclusions()));
    }
    if (replaceProfileAttachmentOptions.createdBy() != null) {
      contentJson.addProperty("created_by", replaceProfileAttachmentOptions.createdBy());
    }
    if (replaceProfileAttachmentOptions.createdOn() != null) {
      contentJson.addProperty("created_on", replaceProfileAttachmentOptions.createdOn());
    }
    if (replaceProfileAttachmentOptions.updatedBy() != null) {
      contentJson.addProperty("updated_by", replaceProfileAttachmentOptions.updatedBy());
    }
    if (replaceProfileAttachmentOptions.updatedOn() != null) {
      contentJson.addProperty("updated_on", replaceProfileAttachmentOptions.updatedOn());
    }
    if (replaceProfileAttachmentOptions.status() != null) {
      contentJson.addProperty("status", replaceProfileAttachmentOptions.status());
    }
    if (replaceProfileAttachmentOptions.attachmentParameters() != null) {
      contentJson.add("attachment_parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileAttachmentOptions.attachmentParameters()));
    }
    if (replaceProfileAttachmentOptions.attachmentNotifications() != null) {
      contentJson.add("attachment_notifications", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceProfileAttachmentOptions.attachmentNotifications()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<AttachmentPayload> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AttachmentPayload>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete an attachment.
   *
   * Delete an attachment that is linked to a profile.
   *
   * @param deleteProfileAttachmnetOptions the {@link DeleteProfileAttachmnetOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AttachmentPayload}
   */
  public ServiceCall<AttachmentPayload> deleteProfileAttachmnet(DeleteProfileAttachmnetOptions deleteProfileAttachmnetOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteProfileAttachmnetOptions,
      "deleteProfileAttachmnetOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", deleteProfileAttachmnetOptions.profilesId());
    pathParamsMap.put("attachment_id", deleteProfileAttachmnetOptions.attachmentId());
    pathParamsMap.put("instance_id", deleteProfileAttachmnetOptions.instanceId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profiles_id}/attachments/{attachment_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "deleteProfileAttachmnet");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteProfileAttachmnetOptions.transactionId() != null) {
      builder.header("Transaction-Id", deleteProfileAttachmnetOptions.transactionId());
    }
    ResponseConverter<AttachmentPayload> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AttachmentPayload>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get attachment's parameters.
   *
   * Get attachment's parameters.
   *
   * @param listAttachmentParametersOptions the {@link ListAttachmentParametersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ParameterDetails}
   */
  public ServiceCall<ParameterDetails> listAttachmentParameters(ListAttachmentParametersOptions listAttachmentParametersOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listAttachmentParametersOptions,
      "listAttachmentParametersOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", listAttachmentParametersOptions.profilesId());
    pathParamsMap.put("attachment_id", listAttachmentParametersOptions.attachmentId());
    pathParamsMap.put("instance_id", listAttachmentParametersOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profiles_id}/attachments/{attachment_id}/parameters", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "listAttachmentParameters");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listAttachmentParametersOptions.transactionId() != null) {
      builder.header("Transaction-Id", listAttachmentParametersOptions.transactionId());
    }
    ResponseConverter<ParameterDetails> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ParameterDetails>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update parameters for an attachment.
   *
   * Update parameters for an attachment.
   *
   * @param replaceAttachmentOptions the {@link ReplaceAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ParameterDetails}
   */
  public ServiceCall<ParameterDetails> replaceAttachment(ReplaceAttachmentOptions replaceAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceAttachmentOptions,
      "replaceAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", replaceAttachmentOptions.profilesId());
    pathParamsMap.put("attachment_id", replaceAttachmentOptions.attachmentId());
    pathParamsMap.put("instance_id", replaceAttachmentOptions.instanceId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profiles_id}/attachments/{attachment_id}/parameters", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "replaceAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (replaceAttachmentOptions.transactionId() != null) {
      builder.header("Transaction-Id", replaceAttachmentOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    if (replaceAttachmentOptions.parameterName() != null) {
      contentJson.addProperty("parameter_name", replaceAttachmentOptions.parameterName());
    }
    if (replaceAttachmentOptions.parameterDisplayName() != null) {
      contentJson.addProperty("parameter_display_name", replaceAttachmentOptions.parameterDisplayName());
    }
    if (replaceAttachmentOptions.parameterType() != null) {
      contentJson.addProperty("parameter_type", replaceAttachmentOptions.parameterType());
    }
    if (replaceAttachmentOptions.parameterValue() != null) {
      contentJson.addProperty("parameter_value", replaceAttachmentOptions.parameterValue());
    }
    if (replaceAttachmentOptions.assessmentType() != null) {
      contentJson.addProperty("assessment_type", replaceAttachmentOptions.assessmentType());
    }
    if (replaceAttachmentOptions.assessmentId() != null) {
      contentJson.addProperty("assessment_id", replaceAttachmentOptions.assessmentId());
    }
    if (replaceAttachmentOptions.parameters() != null) {
      contentJson.add("parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceAttachmentOptions.parameters()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ParameterDetails> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ParameterDetails>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get parameters by name.
   *
   * Get parametes by name.
   *
   * @param getParametersByNameOptions the {@link GetParametersByNameOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ParameterDetails}
   */
  public ServiceCall<ParameterDetails> getParametersByName(GetParametersByNameOptions getParametersByNameOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getParametersByNameOptions,
      "getParametersByNameOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", getParametersByNameOptions.profilesId());
    pathParamsMap.put("attachment_id", getParametersByNameOptions.attachmentId());
    pathParamsMap.put("parameter_name", getParametersByNameOptions.parameterName());
    pathParamsMap.put("instance_id", getParametersByNameOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profiles_id}/attachments/{attachment_id}/parameters/{parameter_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "getParametersByName");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getParametersByNameOptions.transactionId() != null) {
      builder.header("Transaction-Id", getParametersByNameOptions.transactionId());
    }
    ResponseConverter<ParameterDetails> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ParameterDetails>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update parameter by name.
   *
   * Update parameter by name.
   *
   * @param replaceAttachmnetParametersByNameOptions the {@link ReplaceAttachmnetParametersByNameOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ParameterDetails}
   */
  public ServiceCall<ParameterDetails> replaceAttachmnetParametersByName(ReplaceAttachmnetParametersByNameOptions replaceAttachmnetParametersByNameOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceAttachmnetParametersByNameOptions,
      "replaceAttachmnetParametersByNameOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profiles_id", replaceAttachmnetParametersByNameOptions.profilesId());
    pathParamsMap.put("attachment_id", replaceAttachmnetParametersByNameOptions.attachmentId());
    pathParamsMap.put("parameter_name", replaceAttachmnetParametersByNameOptions.parameterName());
    pathParamsMap.put("instance_id", replaceAttachmnetParametersByNameOptions.instanceId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/profiles/{profiles_id}/attachments/{attachment_id}/parameters/{parameter_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "replaceAttachmnetParametersByName");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (replaceAttachmnetParametersByNameOptions.transactionId() != null) {
      builder.header("Transaction-Id", replaceAttachmnetParametersByNameOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    if (replaceAttachmnetParametersByNameOptions.newParameterName() != null) {
      contentJson.addProperty("parameter_name", replaceAttachmnetParametersByNameOptions.newParameterName());
    }
    if (replaceAttachmnetParametersByNameOptions.newParameterDisplayName() != null) {
      contentJson.addProperty("parameter_display_name", replaceAttachmnetParametersByNameOptions.newParameterDisplayName());
    }
    if (replaceAttachmnetParametersByNameOptions.newParameterType() != null) {
      contentJson.addProperty("parameter_type", replaceAttachmnetParametersByNameOptions.newParameterType());
    }
    if (replaceAttachmnetParametersByNameOptions.newParameterValue() != null) {
      contentJson.addProperty("parameter_value", replaceAttachmnetParametersByNameOptions.newParameterValue());
    }
    if (replaceAttachmnetParametersByNameOptions.newAssessmentType() != null) {
      contentJson.addProperty("assessment_type", replaceAttachmnetParametersByNameOptions.newAssessmentType());
    }
    if (replaceAttachmnetParametersByNameOptions.newAssessmentId() != null) {
      contentJson.addProperty("assessment_id", replaceAttachmnetParametersByNameOptions.newAssessmentId());
    }
    if (replaceAttachmnetParametersByNameOptions.newParameters() != null) {
      contentJson.add("parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceAttachmnetParametersByNameOptions.newParameters()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ParameterDetails> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ParameterDetails>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a custom control library.
   *
   * Create a custom control library.
   *
   * @param createCustomControlLibraryOptions the {@link CreateCustomControlLibraryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ControlLibraryRequest}
   */
  public ServiceCall<ControlLibraryRequest> createCustomControlLibrary(CreateCustomControlLibraryOptions createCustomControlLibraryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createCustomControlLibraryOptions,
      "createCustomControlLibraryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", createCustomControlLibraryOptions.instanceId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/control_libraries", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "createCustomControlLibrary");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createCustomControlLibraryOptions.transactionId() != null) {
      builder.header("Transaction-Id", createCustomControlLibraryOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    if (createCustomControlLibraryOptions.id() != null) {
      contentJson.addProperty("id", createCustomControlLibraryOptions.id());
    }
    if (createCustomControlLibraryOptions.accountId() != null) {
      contentJson.addProperty("account_id", createCustomControlLibraryOptions.accountId());
    }
    if (createCustomControlLibraryOptions.controlLibraryName() != null) {
      contentJson.addProperty("control_library_name", createCustomControlLibraryOptions.controlLibraryName());
    }
    if (createCustomControlLibraryOptions.controlLibraryDescription() != null) {
      contentJson.addProperty("control_library_description", createCustomControlLibraryOptions.controlLibraryDescription());
    }
    if (createCustomControlLibraryOptions.controlLibraryType() != null) {
      contentJson.addProperty("control_library_type", createCustomControlLibraryOptions.controlLibraryType());
    }
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
    if (createCustomControlLibraryOptions.controls() != null) {
      contentJson.add("controls", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCustomControlLibraryOptions.controls()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ControlLibraryRequest> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ControlLibraryRequest>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all control libraries.
   *
   * Retrieve all the control libraries, including predefined and custom libraries.
   *
   * @param listControlLibrariesOptions the {@link ListControlLibrariesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetAllControlLibrariesRespBody}
   */
  public ServiceCall<GetAllControlLibrariesRespBody> listControlLibraries(ListControlLibrariesOptions listControlLibrariesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listControlLibrariesOptions,
      "listControlLibrariesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listControlLibrariesOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/control_libraries", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "listControlLibraries");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listControlLibrariesOptions.transactionId() != null) {
      builder.header("Transaction-Id", listControlLibrariesOptions.transactionId());
    }
    ResponseConverter<GetAllControlLibrariesRespBody> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetAllControlLibrariesRespBody>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update custom control library.
   *
   * Update a custom control library by specifying the control library ID.
   *
   * @param replaceCustomControlLibraryOptions the {@link ReplaceCustomControlLibraryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ControlLibraryRequest}
   */
  public ServiceCall<ControlLibraryRequest> replaceCustomControlLibrary(ReplaceCustomControlLibraryOptions replaceCustomControlLibraryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceCustomControlLibraryOptions,
      "replaceCustomControlLibraryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("control_libraries_id", replaceCustomControlLibraryOptions.controlLibrariesId());
    pathParamsMap.put("instance_id", replaceCustomControlLibraryOptions.instanceId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/control_libraries/{control_libraries_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "replaceCustomControlLibrary");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (replaceCustomControlLibraryOptions.transactionId() != null) {
      builder.header("Transaction-Id", replaceCustomControlLibraryOptions.transactionId());
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
    if (replaceCustomControlLibraryOptions.latest() != null) {
      contentJson.addProperty("latest", replaceCustomControlLibraryOptions.latest());
    }
    if (replaceCustomControlLibraryOptions.controlsCount() != null) {
      contentJson.addProperty("controls_count", replaceCustomControlLibraryOptions.controlsCount());
    }
    if (replaceCustomControlLibraryOptions.controls() != null) {
      contentJson.add("controls", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceCustomControlLibraryOptions.controls()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ControlLibraryRequest> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ControlLibraryRequest>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get control library by id.
   *
   * Get control library by id.
   *
   * @param getControlLibraryOptions the {@link GetControlLibraryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ControlLibraryRequest}
   */
  public ServiceCall<ControlLibraryRequest> getControlLibrary(GetControlLibraryOptions getControlLibraryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getControlLibraryOptions,
      "getControlLibraryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("control_libraries_id", getControlLibraryOptions.controlLibrariesId());
    pathParamsMap.put("instance_id", getControlLibraryOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/control_libraries/{control_libraries_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "getControlLibrary");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getControlLibraryOptions.transactionId() != null) {
      builder.header("Transaction-Id", getControlLibraryOptions.transactionId());
    }
    ResponseConverter<ControlLibraryRequest> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ControlLibraryRequest>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete custom control library.
   *
   * Delete custom control library.
   *
   * @param deleteCustomControllibraryOptions the {@link DeleteCustomControllibraryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ControlLibraryRequest}
   */
  public ServiceCall<ControlLibraryRequest> deleteCustomControllibrary(DeleteCustomControllibraryOptions deleteCustomControllibraryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteCustomControllibraryOptions,
      "deleteCustomControllibraryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("control_libraries_id", deleteCustomControllibraryOptions.controlLibrariesId());
    pathParamsMap.put("instance_id", deleteCustomControllibraryOptions.instanceId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/{instance_id}/v3/control_libraries/{control_libraries_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "deleteCustomControllibrary");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteCustomControllibraryOptions.transactionId() != null) {
      builder.header("Transaction-Id", deleteCustomControllibraryOptions.transactionId());
    }
    ResponseConverter<ControlLibraryRequest> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ControlLibraryRequest>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a scan.
   *
   * Create a scan.
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
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compliance", "v2", "createScan");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createScanOptions.transactionId() != null) {
      builder.header("Transaction-Id", createScanOptions.transactionId());
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

}
