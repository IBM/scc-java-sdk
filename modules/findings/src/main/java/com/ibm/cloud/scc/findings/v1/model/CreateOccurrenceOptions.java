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
package com.ibm.cloud.scc.findings.v1.model;

import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createOccurrence options.
 */
public class CreateOccurrenceOptions extends GenericModel {

  /**
   * The type of note. Use this field to filter notes and occurences by kind.
   *  - FINDING&amp;#58; The note and occurrence represent a finding.
   *  - KPI&amp;#58; The note and occurrence represent a KPI value.
   *  - CARD&amp;#58; The note represents a card showing findings and related metric values.
   *  - CARD_CONFIGURED&amp;#58; The note represents a card configured for a user account.
   *  - SECTION&amp;#58; The note represents a section in a dashboard.
   */
  public interface Kind {
    /** FINDING. */
    String FINDING = "FINDING";
    /** KPI. */
    String KPI = "KPI";
    /** CARD. */
    String CARD = "CARD";
    /** CARD_CONFIGURED. */
    String CARD_CONFIGURED = "CARD_CONFIGURED";
    /** SECTION. */
    String SECTION = "SECTION";
  }

  protected String providerId;
  protected String noteName;
  protected String kind;
  protected String id;
  protected String resourceUrl;
  protected String remediation;
  protected Context context;
  protected Finding finding;
  protected Kpi kpi;
  protected Map<String, Object> referenceData;
  protected String transactionId;
  protected Boolean replaceIfExists;

  /**
   * Builder.
   */
  public static class Builder {
    private String providerId;
    private String noteName;
    private String kind;
    private String id;
    private String resourceUrl;
    private String remediation;
    private Context context;
    private Finding finding;
    private Kpi kpi;
    private Map<String, Object> referenceData;
    private String transactionId;
    private Boolean replaceIfExists;

    private Builder(CreateOccurrenceOptions createOccurrenceOptions) {
      this.providerId = createOccurrenceOptions.providerId;
      this.noteName = createOccurrenceOptions.noteName;
      this.kind = createOccurrenceOptions.kind;
      this.id = createOccurrenceOptions.id;
      this.resourceUrl = createOccurrenceOptions.resourceUrl;
      this.remediation = createOccurrenceOptions.remediation;
      this.context = createOccurrenceOptions.context;
      this.finding = createOccurrenceOptions.finding;
      this.kpi = createOccurrenceOptions.kpi;
      this.referenceData = createOccurrenceOptions.referenceData;
      this.transactionId = createOccurrenceOptions.transactionId;
      this.replaceIfExists = createOccurrenceOptions.replaceIfExists;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param providerId the providerId
     * @param noteName the noteName
     * @param kind the kind
     * @param id the id
     */
    public Builder(String providerId, String noteName, String kind, String id) {
      this.providerId = providerId;
      this.noteName = noteName;
      this.kind = kind;
      this.id = id;
    }

    /**
     * Builds a CreateOccurrenceOptions.
     *
     * @return the new CreateOccurrenceOptions instance
     */
    public CreateOccurrenceOptions build() {
      return new CreateOccurrenceOptions(this);
    }

    /**
     * Set the providerId.
     *
     * @param providerId the providerId
     * @return the CreateOccurrenceOptions builder
     */
    public Builder providerId(String providerId) {
      this.providerId = providerId;
      return this;
    }

    /**
     * Set the noteName.
     *
     * @param noteName the noteName
     * @return the CreateOccurrenceOptions builder
     */
    public Builder noteName(String noteName) {
      this.noteName = noteName;
      return this;
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the CreateOccurrenceOptions builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the CreateOccurrenceOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the resourceUrl.
     *
     * @param resourceUrl the resourceUrl
     * @return the CreateOccurrenceOptions builder
     */
    public Builder resourceUrl(String resourceUrl) {
      this.resourceUrl = resourceUrl;
      return this;
    }

    /**
     * Set the remediation.
     *
     * @param remediation the remediation
     * @return the CreateOccurrenceOptions builder
     */
    public Builder remediation(String remediation) {
      this.remediation = remediation;
      return this;
    }

    /**
     * Set the context.
     *
     * @param context the context
     * @return the CreateOccurrenceOptions builder
     */
    public Builder context(Context context) {
      this.context = context;
      return this;
    }

    /**
     * Set the finding.
     *
     * @param finding the finding
     * @return the CreateOccurrenceOptions builder
     */
    public Builder finding(Finding finding) {
      this.finding = finding;
      return this;
    }

    /**
     * Set the kpi.
     *
     * @param kpi the kpi
     * @return the CreateOccurrenceOptions builder
     */
    public Builder kpi(Kpi kpi) {
      this.kpi = kpi;
      return this;
    }

    /**
     * Set the referenceData.
     *
     * @param referenceData the referenceData
     * @return the CreateOccurrenceOptions builder
     */
    public Builder referenceData(Map<String, Object> referenceData) {
      this.referenceData = referenceData;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the CreateOccurrenceOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the replaceIfExists.
     *
     * @param replaceIfExists the replaceIfExists
     * @return the CreateOccurrenceOptions builder
     */
    public Builder replaceIfExists(Boolean replaceIfExists) {
      this.replaceIfExists = replaceIfExists;
      return this;
    }

    /**
     * Set the apiOccurrence.
     *
     * @param apiOccurrence the apiOccurrence
     * @return the CreateOccurrenceOptions builder
     */
    public Builder apiOccurrence(ApiOccurrence apiOccurrence) {
      this.noteName = apiOccurrence.noteName();
      this.kind = apiOccurrence.kind();
      this.id = apiOccurrence.id();
      this.resourceUrl = apiOccurrence.resourceUrl();
      this.remediation = apiOccurrence.remediation();
      this.context = apiOccurrence.context();
      this.finding = apiOccurrence.finding();
      this.kpi = apiOccurrence.kpi();
      this.referenceData = apiOccurrence.referenceData();
      return this;
    }
  }

  protected CreateOccurrenceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.providerId,
      "providerId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.noteName,
      "noteName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.id,
      "id cannot be null");
    providerId = builder.providerId;
    noteName = builder.noteName;
    kind = builder.kind;
    id = builder.id;
    resourceUrl = builder.resourceUrl;
    remediation = builder.remediation;
    context = builder.context;
    finding = builder.finding;
    kpi = builder.kpi;
    referenceData = builder.referenceData;
    transactionId = builder.transactionId;
    replaceIfExists = builder.replaceIfExists;
  }

  /**
   * New builder.
   *
   * @return a CreateOccurrenceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the providerId.
   *
   * Part of the parent. This field contains the provider ID. For example: providers/{provider_id}.
   *
   * @return the providerId
   */
  public String providerId() {
    return providerId;
  }

  /**
   * Gets the noteName.
   *
   * An analysis note associated with this image, in the form "{account_id}/providers/{provider_id}/notes/{note_id}"
   * This field can be used as a filter in list requests.
   *
   * @return the noteName
   */
  public String noteName() {
    return noteName;
  }

  /**
   * Gets the kind.
   *
   * The type of note. Use this field to filter notes and occurences by kind.
   *  - FINDING&amp;#58; The note and occurrence represent a finding.
   *  - KPI&amp;#58; The note and occurrence represent a KPI value.
   *  - CARD&amp;#58; The note represents a card showing findings and related metric values.
   *  - CARD_CONFIGURED&amp;#58; The note represents a card configured for a user account.
   *  - SECTION&amp;#58; The note represents a section in a dashboard.
   *
   * @return the kind
   */
  public String kind() {
    return kind;
  }

  /**
   * Gets the id.
   *
   * The id of the occurrence.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the resourceUrl.
   *
   * The unique URL of the resource, image or the container, for which the `Occurrence` applies. For example,
   * https://gcr.io/provider/image@sha256:foo. This field can be used as a filter in list requests.
   *
   * @return the resourceUrl
   */
  public String resourceUrl() {
    return resourceUrl;
  }

  /**
   * Gets the remediation.
   *
   * A description of actions that can be taken to remedy the `Note`.
   *
   * @return the remediation
   */
  public String remediation() {
    return remediation;
  }

  /**
   * Gets the context.
   *
   * @return the context
   */
  public Context context() {
    return context;
  }

  /**
   * Gets the finding.
   *
   * Finding provides details about a finding occurrence.
   *
   * @return the finding
   */
  public Finding finding() {
    return finding;
  }

  /**
   * Gets the kpi.
   *
   * Kpi provides details about a KPI occurrence.
   *
   * @return the kpi
   */
  public Kpi kpi() {
    return kpi;
  }

  /**
   * Gets the referenceData.
   *
   * Additional data for the finding, like AT event etc.
   *
   * @return the referenceData
   */
  public Map<String, Object> referenceData() {
    return referenceData;
  }

  /**
   * Gets the transactionId.
   *
   * The transaction ID for the request in UUID v4 format.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }

  /**
   * Gets the replaceIfExists.
   *
   * When set to true, an existing occurrence is replaced rather than duplicated.
   *
   * @return the replaceIfExists
   */
  public Boolean replaceIfExists() {
    return replaceIfExists;
  }
}

