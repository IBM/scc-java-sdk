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
 * IBM OpenAPI SDK Code Generator Version: 3.40.0-910cf8c2-20211006-154754
 */

package com.ibm.cloud.scc.findings.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.scc.common.SdkCommon;
import com.ibm.cloud.scc.findings.v1.model.ApiListNoteOccurrencesResponse;
import com.ibm.cloud.scc.findings.v1.model.ApiListNotesResponse;
import com.ibm.cloud.scc.findings.v1.model.ApiListOccurrencesResponse;
import com.ibm.cloud.scc.findings.v1.model.ApiListProvidersResponse;
import com.ibm.cloud.scc.findings.v1.model.ApiNote;
import com.ibm.cloud.scc.findings.v1.model.ApiOccurrence;
import com.ibm.cloud.scc.findings.v1.model.CreateNoteOptions;
import com.ibm.cloud.scc.findings.v1.model.CreateOccurrenceOptions;
import com.ibm.cloud.scc.findings.v1.model.DeleteNoteOptions;
import com.ibm.cloud.scc.findings.v1.model.DeleteOccurrenceOptions;
import com.ibm.cloud.scc.findings.v1.model.GetNoteOptions;
import com.ibm.cloud.scc.findings.v1.model.GetOccurrenceNoteOptions;
import com.ibm.cloud.scc.findings.v1.model.GetOccurrenceOptions;
import com.ibm.cloud.scc.findings.v1.model.ListNoteOccurrencesOptions;
import com.ibm.cloud.scc.findings.v1.model.ListNotesOptions;
import com.ibm.cloud.scc.findings.v1.model.ListOccurrencesOptions;
import com.ibm.cloud.scc.findings.v1.model.ListProvidersOptions;
import com.ibm.cloud.scc.findings.v1.model.PostGraphOptions;
import com.ibm.cloud.scc.findings.v1.model.UpdateNoteOptions;
import com.ibm.cloud.scc.findings.v1.model.UpdateOccurrenceOptions;
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
 * The Findings API is used to find and display occurrences of security issues in your IBM Cloud account by using the
 * artifact metadata specification. Findings are summarized in cards in the Security and Compliance Center that allow
 * you to see the security status of your account at a glance and start an investigation into any potential issues.
 *
 * API Version: 1.0.0
 */
public class Findings extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "findings";

  public static final String DEFAULT_SERVICE_URL = "https://us-south.secadvisor.cloud.ibm.com/findings";

  private String accountId;

 /**
   * Class method which constructs an instance of the `Findings` client.
   * The default service name is used to configure the client instance.
   *
   * @param accountId Account ID.
   * @return an instance of the `Findings` client using external configuration
   */
  public static Findings newInstance(String accountId) {
    return newInstance(accountId, DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `Findings` client.
   * The specified service name is used to configure the client instance.
   *
   * @param accountId Account ID.
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `Findings` client using external configuration
   */
  public static Findings newInstance(String accountId, String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    Findings service = new Findings(accountId, serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `Findings` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param accountId Account ID.
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public Findings(String accountId, String serviceName, Authenticator authenticator) {
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
   * Query findings.
   *
   * Query findings by using the GraphQL query language. For more information about using GraphQL, see the [GraphQL
   * documentation](https://graphql.org/learn/).
   *
   * @param postGraphOptions the {@link PostGraphOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> postGraph(PostGraphOptions postGraphOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postGraphOptions,
      "postGraphOptions cannot be null");

    if (postGraphOptions.body() != null && postGraphOptions.contentType() == null) {
      postGraphOptions = postGraphOptions.newBuilder().contentType("application/json").build();
    }
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/graph", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings", "v1", "postGraph");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (postGraphOptions.contentType() != null) {
      builder.header("Content-Type", postGraphOptions.contentType());
    }
    if (postGraphOptions.transactionId() != null) {
      builder.header("Transaction-Id", postGraphOptions.transactionId());
    }
    builder.bodyContent(postGraphOptions.contentType(), null,
      null, postGraphOptions.body());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List providers.
   *
   * List all of the providers for a specified account.
   *
   * @param listProvidersOptions the {@link ListProvidersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiListProvidersResponse}
   */
  public ServiceCall<ApiListProvidersResponse> listProviders(ListProvidersOptions listProvidersOptions) {
    if (listProvidersOptions == null) {
      listProvidersOptions = new ListProvidersOptions.Builder().build();
    }
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/providers", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings", "v1", "listProviders");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listProvidersOptions.transactionId() != null) {
      builder.header("Transaction-Id", listProvidersOptions.transactionId());
    }
    if (listProvidersOptions.limit() != null) {
      builder.query("limit", String.valueOf(listProvidersOptions.limit()));
    }
    if (listProvidersOptions.skip() != null) {
      builder.query("skip", String.valueOf(listProvidersOptions.skip()));
    }
    if (listProvidersOptions.startProviderId() != null) {
      builder.query("start_provider_id", String.valueOf(listProvidersOptions.startProviderId()));
    }
    if (listProvidersOptions.endProviderId() != null) {
      builder.query("end_provider_id", String.valueOf(listProvidersOptions.endProviderId()));
    }
    ResponseConverter<ApiListProvidersResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiListProvidersResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List providers.
   *
   * List all of the providers for a specified account.
   *
   * @return a {@link ServiceCall} with a result of type {@link ApiListProvidersResponse}
   */
  public ServiceCall<ApiListProvidersResponse> listProviders() {
    return listProviders(null);
  }

  /**
   * Create a note.
   *
   * Register a new finding type with the Security and Compliance Center.
   *
   * A successful request creates a note with a high-level description of a particular type of finding. To learn more
   * about creating notes to register findings, see [Custom
   * findings](/docs/security-advisor?topic=security-advisor-setup_custom).
   *
   * @param createNoteOptions the {@link CreateNoteOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiNote}
   */
  public ServiceCall<ApiNote> createNote(CreateNoteOptions createNoteOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createNoteOptions,
      "createNoteOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    pathParamsMap.put("provider_id", createNoteOptions.providerId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/providers/{provider_id}/notes", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings", "v1", "createNote");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createNoteOptions.transactionId() != null) {
      builder.header("Transaction-Id", createNoteOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("short_description", createNoteOptions.shortDescription());
    contentJson.addProperty("long_description", createNoteOptions.longDescription());
    contentJson.addProperty("kind", createNoteOptions.kind());
    contentJson.addProperty("id", createNoteOptions.id());
    contentJson.add("reported_by", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNoteOptions.reportedBy()));
    if (createNoteOptions.relatedUrl() != null) {
      contentJson.add("related_url", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNoteOptions.relatedUrl()));
    }
    if (createNoteOptions.createTime() != null) {
      contentJson.add("create_time", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNoteOptions.createTime()));
    }
    if (createNoteOptions.updateTime() != null) {
      contentJson.add("update_time", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNoteOptions.updateTime()));
    }
    if (createNoteOptions.shared() != null) {
      contentJson.addProperty("shared", createNoteOptions.shared());
    }
    if (createNoteOptions.finding() != null) {
      contentJson.add("finding", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNoteOptions.finding()));
    }
    if (createNoteOptions.kpi() != null) {
      contentJson.add("kpi", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNoteOptions.kpi()));
    }
    if (createNoteOptions.card() != null) {
      contentJson.add("card", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNoteOptions.card()));
    }
    if (createNoteOptions.section() != null) {
      contentJson.add("section", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNoteOptions.section()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ApiNote> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiNote>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List notes.
   *
   * List all of the available notes for a specific provider.
   *
   * @param listNotesOptions the {@link ListNotesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiListNotesResponse}
   */
  public ServiceCall<ApiListNotesResponse> listNotes(ListNotesOptions listNotesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listNotesOptions,
      "listNotesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    pathParamsMap.put("provider_id", listNotesOptions.providerId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/providers/{provider_id}/notes", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings", "v1", "listNotes");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listNotesOptions.transactionId() != null) {
      builder.header("Transaction-Id", listNotesOptions.transactionId());
    }
    if (listNotesOptions.pageSize() != null) {
      builder.query("page_size", String.valueOf(listNotesOptions.pageSize()));
    }
    if (listNotesOptions.pageToken() != null) {
      builder.query("page_token", String.valueOf(listNotesOptions.pageToken()));
    }
    ResponseConverter<ApiListNotesResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiListNotesResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a note by provider.
   *
   * Get the details of the note that is associated with a specified note ID and provider ID.
   *
   * @param getNoteOptions the {@link GetNoteOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiNote}
   */
  public ServiceCall<ApiNote> getNote(GetNoteOptions getNoteOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getNoteOptions,
      "getNoteOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    pathParamsMap.put("provider_id", getNoteOptions.providerId());
    pathParamsMap.put("note_id", getNoteOptions.noteId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/providers/{provider_id}/notes/{note_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings", "v1", "getNote");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getNoteOptions.transactionId() != null) {
      builder.header("Transaction-Id", getNoteOptions.transactionId());
    }
    ResponseConverter<ApiNote> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiNote>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a note.
   *
   * Update a note that already exists in your account.
   *
   * @param updateNoteOptions the {@link UpdateNoteOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiNote}
   */
  public ServiceCall<ApiNote> updateNote(UpdateNoteOptions updateNoteOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateNoteOptions,
      "updateNoteOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    pathParamsMap.put("provider_id", updateNoteOptions.providerId());
    pathParamsMap.put("note_id", updateNoteOptions.noteId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/providers/{provider_id}/notes/{note_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings", "v1", "updateNote");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (updateNoteOptions.transactionId() != null) {
      builder.header("Transaction-Id", updateNoteOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("short_description", updateNoteOptions.shortDescription());
    contentJson.addProperty("long_description", updateNoteOptions.longDescription());
    contentJson.addProperty("kind", updateNoteOptions.kind());
    contentJson.addProperty("id", updateNoteOptions.id());
    contentJson.add("reported_by", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNoteOptions.reportedBy()));
    if (updateNoteOptions.relatedUrl() != null) {
      contentJson.add("related_url", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNoteOptions.relatedUrl()));
    }
    if (updateNoteOptions.createTime() != null) {
      contentJson.add("create_time", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNoteOptions.createTime()));
    }
    if (updateNoteOptions.updateTime() != null) {
      contentJson.add("update_time", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNoteOptions.updateTime()));
    }
    if (updateNoteOptions.shared() != null) {
      contentJson.addProperty("shared", updateNoteOptions.shared());
    }
    if (updateNoteOptions.finding() != null) {
      contentJson.add("finding", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNoteOptions.finding()));
    }
    if (updateNoteOptions.kpi() != null) {
      contentJson.add("kpi", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNoteOptions.kpi()));
    }
    if (updateNoteOptions.card() != null) {
      contentJson.add("card", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNoteOptions.card()));
    }
    if (updateNoteOptions.section() != null) {
      contentJson.add("section", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNoteOptions.section()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ApiNote> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiNote>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a note.
   *
   * Delete a note with the ID and provider ID that you specify.
   *
   * @param deleteNoteOptions the {@link DeleteNoteOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteNote(DeleteNoteOptions deleteNoteOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteNoteOptions,
      "deleteNoteOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    pathParamsMap.put("provider_id", deleteNoteOptions.providerId());
    pathParamsMap.put("note_id", deleteNoteOptions.noteId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/providers/{provider_id}/notes/{note_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings", "v1", "deleteNote");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteNoteOptions.transactionId() != null) {
      builder.header("Transaction-Id", deleteNoteOptions.transactionId());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a note by occurrence.
   *
   * Get a note that is associated with the occurrence ID that you specify.
   *
   * @param getOccurrenceNoteOptions the {@link GetOccurrenceNoteOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiNote}
   */
  public ServiceCall<ApiNote> getOccurrenceNote(GetOccurrenceNoteOptions getOccurrenceNoteOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getOccurrenceNoteOptions,
      "getOccurrenceNoteOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    pathParamsMap.put("provider_id", getOccurrenceNoteOptions.providerId());
    pathParamsMap.put("occurrence_id", getOccurrenceNoteOptions.occurrenceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/providers/{provider_id}/occurrences/{occurrence_id}/note", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings", "v1", "getOccurrenceNote");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getOccurrenceNoteOptions.transactionId() != null) {
      builder.header("Transaction-Id", getOccurrenceNoteOptions.transactionId());
    }
    ResponseConverter<ApiNote> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiNote>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create an occurrence.
   *
   * Create an occurrence to denote the existence of a particular type of finding.
   *
   * An occurrence describes provider-specific details of a note and contains vulnerability details, remediation steps,
   * and other general information.
   *
   * @param createOccurrenceOptions the {@link CreateOccurrenceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiOccurrence}
   */
  public ServiceCall<ApiOccurrence> createOccurrence(CreateOccurrenceOptions createOccurrenceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createOccurrenceOptions,
      "createOccurrenceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    pathParamsMap.put("provider_id", createOccurrenceOptions.providerId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/providers/{provider_id}/occurrences", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings", "v1", "createOccurrence");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createOccurrenceOptions.transactionId() != null) {
      builder.header("Transaction-Id", createOccurrenceOptions.transactionId());
    }
    if (createOccurrenceOptions.replaceIfExists() != null) {
      builder.header("Replace-If-Exists", createOccurrenceOptions.replaceIfExists());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("note_name", createOccurrenceOptions.noteName());
    contentJson.addProperty("kind", createOccurrenceOptions.kind());
    contentJson.addProperty("id", createOccurrenceOptions.id());
    if (createOccurrenceOptions.resourceUrl() != null) {
      contentJson.addProperty("resource_url", createOccurrenceOptions.resourceUrl());
    }
    if (createOccurrenceOptions.remediation() != null) {
      contentJson.addProperty("remediation", createOccurrenceOptions.remediation());
    }
    if (createOccurrenceOptions.context() != null) {
      contentJson.add("context", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOccurrenceOptions.context()));
    }
    if (createOccurrenceOptions.finding() != null) {
      contentJson.add("finding", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOccurrenceOptions.finding()));
    }
    if (createOccurrenceOptions.kpi() != null) {
      contentJson.add("kpi", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOccurrenceOptions.kpi()));
    }
    if (createOccurrenceOptions.referenceData() != null) {
      contentJson.add("reference_data", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOccurrenceOptions.referenceData()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ApiOccurrence> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiOccurrence>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List occurrences.
   *
   * List all of the occurrences that are associated with the provider ID that you specify.
   *
   * @param listOccurrencesOptions the {@link ListOccurrencesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiListOccurrencesResponse}
   */
  public ServiceCall<ApiListOccurrencesResponse> listOccurrences(ListOccurrencesOptions listOccurrencesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listOccurrencesOptions,
      "listOccurrencesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    pathParamsMap.put("provider_id", listOccurrencesOptions.providerId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/providers/{provider_id}/occurrences", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings", "v1", "listOccurrences");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listOccurrencesOptions.transactionId() != null) {
      builder.header("Transaction-Id", listOccurrencesOptions.transactionId());
    }
    if (listOccurrencesOptions.pageSize() != null) {
      builder.query("page_size", String.valueOf(listOccurrencesOptions.pageSize()));
    }
    if (listOccurrencesOptions.pageToken() != null) {
      builder.query("page_token", String.valueOf(listOccurrencesOptions.pageToken()));
    }
    ResponseConverter<ApiListOccurrencesResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiListOccurrencesResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List occurrences by note.
   *
   * Get a list of occurrences that are associated with a specific note.
   *
   * @param listNoteOccurrencesOptions the {@link ListNoteOccurrencesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiListNoteOccurrencesResponse}
   */
  public ServiceCall<ApiListNoteOccurrencesResponse> listNoteOccurrences(ListNoteOccurrencesOptions listNoteOccurrencesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listNoteOccurrencesOptions,
      "listNoteOccurrencesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    pathParamsMap.put("provider_id", listNoteOccurrencesOptions.providerId());
    pathParamsMap.put("note_id", listNoteOccurrencesOptions.noteId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/providers/{provider_id}/notes/{note_id}/occurrences", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings", "v1", "listNoteOccurrences");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listNoteOccurrencesOptions.transactionId() != null) {
      builder.header("Transaction-Id", listNoteOccurrencesOptions.transactionId());
    }
    if (listNoteOccurrencesOptions.pageSize() != null) {
      builder.query("page_size", String.valueOf(listNoteOccurrencesOptions.pageSize()));
    }
    if (listNoteOccurrencesOptions.pageToken() != null) {
      builder.query("page_token", String.valueOf(listNoteOccurrencesOptions.pageToken()));
    }
    ResponseConverter<ApiListNoteOccurrencesResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiListNoteOccurrencesResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a specific occurrence.
   *
   * Get the details of a specific occurrence by specifying the ID and provider ID.
   *
   * @param getOccurrenceOptions the {@link GetOccurrenceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiOccurrence}
   */
  public ServiceCall<ApiOccurrence> getOccurrence(GetOccurrenceOptions getOccurrenceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getOccurrenceOptions,
      "getOccurrenceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    pathParamsMap.put("provider_id", getOccurrenceOptions.providerId());
    pathParamsMap.put("occurrence_id", getOccurrenceOptions.occurrenceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/providers/{provider_id}/occurrences/{occurrence_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings", "v1", "getOccurrence");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getOccurrenceOptions.transactionId() != null) {
      builder.header("Transaction-Id", getOccurrenceOptions.transactionId());
    }
    ResponseConverter<ApiOccurrence> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiOccurrence>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update an occurrence.
   *
   * Update an occurrence that already exists in your account.
   *
   * @param updateOccurrenceOptions the {@link UpdateOccurrenceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiOccurrence}
   */
  public ServiceCall<ApiOccurrence> updateOccurrence(UpdateOccurrenceOptions updateOccurrenceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateOccurrenceOptions,
      "updateOccurrenceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    pathParamsMap.put("provider_id", updateOccurrenceOptions.providerId());
    pathParamsMap.put("occurrence_id", updateOccurrenceOptions.occurrenceId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/providers/{provider_id}/occurrences/{occurrence_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings", "v1", "updateOccurrence");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (updateOccurrenceOptions.transactionId() != null) {
      builder.header("Transaction-Id", updateOccurrenceOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("note_name", updateOccurrenceOptions.noteName());
    contentJson.addProperty("kind", updateOccurrenceOptions.kind());
    contentJson.addProperty("id", updateOccurrenceOptions.id());
    if (updateOccurrenceOptions.resourceUrl() != null) {
      contentJson.addProperty("resource_url", updateOccurrenceOptions.resourceUrl());
    }
    if (updateOccurrenceOptions.remediation() != null) {
      contentJson.addProperty("remediation", updateOccurrenceOptions.remediation());
    }
    if (updateOccurrenceOptions.context() != null) {
      contentJson.add("context", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateOccurrenceOptions.context()));
    }
    if (updateOccurrenceOptions.finding() != null) {
      contentJson.add("finding", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateOccurrenceOptions.finding()));
    }
    if (updateOccurrenceOptions.kpi() != null) {
      contentJson.add("kpi", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateOccurrenceOptions.kpi()));
    }
    if (updateOccurrenceOptions.referenceData() != null) {
      contentJson.add("reference_data", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateOccurrenceOptions.referenceData()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ApiOccurrence> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiOccurrence>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete an occurrence.
   *
   * Delete an occurrence by specifying the occurrence ID and provider ID.
   *
   * @param deleteOccurrenceOptions the {@link DeleteOccurrenceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteOccurrence(DeleteOccurrenceOptions deleteOccurrenceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteOccurrenceOptions,
      "deleteOccurrenceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", this.accountId);
    pathParamsMap.put("provider_id", deleteOccurrenceOptions.providerId());
    pathParamsMap.put("occurrence_id", deleteOccurrenceOptions.occurrenceId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/{account_id}/providers/{provider_id}/occurrences/{occurrence_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings", "v1", "deleteOccurrence");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteOccurrenceOptions.transactionId() != null) {
      builder.header("Transaction-Id", deleteOccurrenceOptions.transactionId());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
