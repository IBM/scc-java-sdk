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
package com.ibm.cloud.scc.findings_api.v1.model;

import java.util.Date;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createOccurrence options.
 */
public class CreateOccurrenceOptions extends GenericModel {

  /**
   * This must be 1&amp;#58;1 with members of our oneofs, it can be used for filtering Note and Occurrence on their
   * kind.
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

  protected String accountId;
  protected String providerId;
  protected String noteName;
  protected String kind;
  protected String id;
  protected String resourceUrl;
  protected String remediation;
  protected Date createTime;
  protected Date updateTime;
  protected Context context;
  protected Finding finding;
  protected Kpi kpi;
  protected Map<String, Object> referenceData;
  protected Boolean replaceIfExists;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String providerId;
    private String noteName;
    private String kind;
    private String id;
    private String resourceUrl;
    private String remediation;
    private Date createTime;
    private Date updateTime;
    private Context context;
    private Finding finding;
    private Kpi kpi;
    private Map<String, Object> referenceData;
    private Boolean replaceIfExists;
    private String transactionId;

    private Builder(CreateOccurrenceOptions createOccurrenceOptions) {
      this.accountId = createOccurrenceOptions.accountId;
      this.providerId = createOccurrenceOptions.providerId;
      this.noteName = createOccurrenceOptions.noteName;
      this.kind = createOccurrenceOptions.kind;
      this.id = createOccurrenceOptions.id;
      this.resourceUrl = createOccurrenceOptions.resourceUrl;
      this.remediation = createOccurrenceOptions.remediation;
      this.createTime = createOccurrenceOptions.createTime;
      this.updateTime = createOccurrenceOptions.updateTime;
      this.context = createOccurrenceOptions.context;
      this.finding = createOccurrenceOptions.finding;
      this.kpi = createOccurrenceOptions.kpi;
      this.referenceData = createOccurrenceOptions.referenceData;
      this.replaceIfExists = createOccurrenceOptions.replaceIfExists;
      this.transactionId = createOccurrenceOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountId the accountId
     * @param providerId the providerId
     * @param noteName the noteName
     * @param kind the kind
     * @param id the id
     */
    public Builder(String accountId, String providerId, String noteName, String kind, String id) {
      this.accountId = accountId;
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
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateOccurrenceOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
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
     * Set the createTime.
     *
     * @param createTime the createTime
     * @return the CreateOccurrenceOptions builder
     */
    public Builder createTime(Date createTime) {
      this.createTime = createTime;
      return this;
    }

    /**
     * Set the updateTime.
     *
     * @param updateTime the updateTime
     * @return the CreateOccurrenceOptions builder
     */
    public Builder updateTime(Date updateTime) {
      this.updateTime = updateTime;
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
      this.createTime = apiOccurrence.createTime();
      this.updateTime = apiOccurrence.updateTime();
      this.context = apiOccurrence.context();
      this.finding = apiOccurrence.finding();
      this.kpi = apiOccurrence.kpi();
      this.referenceData = apiOccurrence.referenceData();
      return this;
    }
  }

  protected CreateOccurrenceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.providerId,
      "providerId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.noteName,
      "noteName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.id,
      "id cannot be null");
    accountId = builder.accountId;
    providerId = builder.providerId;
    noteName = builder.noteName;
    kind = builder.kind;
    id = builder.id;
    resourceUrl = builder.resourceUrl;
    remediation = builder.remediation;
    createTime = builder.createTime;
    updateTime = builder.updateTime;
    context = builder.context;
    finding = builder.finding;
    kpi = builder.kpi;
    referenceData = builder.referenceData;
    replaceIfExists = builder.replaceIfExists;
    transactionId = builder.transactionId;
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
   * Gets the accountId.
   *
   * Account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the providerId.
   *
   * Part of `parent`. This contains the provider_id for example: providers/{provider_id}.
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
   * This must be 1&amp;#58;1 with members of our oneofs, it can be used for filtering Note and Occurrence on their
   * kind.
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
   * @return the remediation
   */
  public String remediation() {
    return remediation;
  }

  /**
   * Gets the createTime.
   *
   * Output only. The time this `Occurrence` was created.
   *
   * @return the createTime
   */
  public Date createTime() {
    return createTime;
  }

  /**
   * Gets the updateTime.
   *
   * Output only. The time this `Occurrence` was last updated.
   *
   * @return the updateTime
   */
  public Date updateTime() {
    return updateTime;
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
   * Gets the replaceIfExists.
   *
   * It allows replacing an existing occurrence when set to true.
   *
   * @return the replaceIfExists
   */
  public Boolean replaceIfExists() {
    return replaceIfExists;
  }

  /**
   * Gets the transactionId.
   *
   * The transaction id for the request in uuid v4 format.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

