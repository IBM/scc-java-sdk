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
package com.ibm.cloud.security_and_compliance_center.findings_api.v1.model;

import java.util.Date;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateOccurrence options.
 */
public class UpdateOccurrenceOptions extends GenericModel {

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
  protected String occurrenceId;
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
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String providerId;
    private String occurrenceId;
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
    private String transactionId;

    private Builder(UpdateOccurrenceOptions updateOccurrenceOptions) {
      this.accountId = updateOccurrenceOptions.accountId;
      this.providerId = updateOccurrenceOptions.providerId;
      this.occurrenceId = updateOccurrenceOptions.occurrenceId;
      this.noteName = updateOccurrenceOptions.noteName;
      this.kind = updateOccurrenceOptions.kind;
      this.id = updateOccurrenceOptions.id;
      this.resourceUrl = updateOccurrenceOptions.resourceUrl;
      this.remediation = updateOccurrenceOptions.remediation;
      this.createTime = updateOccurrenceOptions.createTime;
      this.updateTime = updateOccurrenceOptions.updateTime;
      this.context = updateOccurrenceOptions.context;
      this.finding = updateOccurrenceOptions.finding;
      this.kpi = updateOccurrenceOptions.kpi;
      this.referenceData = updateOccurrenceOptions.referenceData;
      this.transactionId = updateOccurrenceOptions.transactionId;
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
     * @param occurrenceId the occurrenceId
     * @param noteName the noteName
     * @param kind the kind
     * @param id the id
     */
    public Builder(String accountId, String providerId, String occurrenceId, String noteName, String kind, String id) {
      this.accountId = accountId;
      this.providerId = providerId;
      this.occurrenceId = occurrenceId;
      this.noteName = noteName;
      this.kind = kind;
      this.id = id;
    }

    /**
     * Builds a UpdateOccurrenceOptions.
     *
     * @return the new UpdateOccurrenceOptions instance
     */
    public UpdateOccurrenceOptions build() {
      return new UpdateOccurrenceOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the UpdateOccurrenceOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the providerId.
     *
     * @param providerId the providerId
     * @return the UpdateOccurrenceOptions builder
     */
    public Builder providerId(String providerId) {
      this.providerId = providerId;
      return this;
    }

    /**
     * Set the occurrenceId.
     *
     * @param occurrenceId the occurrenceId
     * @return the UpdateOccurrenceOptions builder
     */
    public Builder occurrenceId(String occurrenceId) {
      this.occurrenceId = occurrenceId;
      return this;
    }

    /**
     * Set the noteName.
     *
     * @param noteName the noteName
     * @return the UpdateOccurrenceOptions builder
     */
    public Builder noteName(String noteName) {
      this.noteName = noteName;
      return this;
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the UpdateOccurrenceOptions builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the UpdateOccurrenceOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the resourceUrl.
     *
     * @param resourceUrl the resourceUrl
     * @return the UpdateOccurrenceOptions builder
     */
    public Builder resourceUrl(String resourceUrl) {
      this.resourceUrl = resourceUrl;
      return this;
    }

    /**
     * Set the remediation.
     *
     * @param remediation the remediation
     * @return the UpdateOccurrenceOptions builder
     */
    public Builder remediation(String remediation) {
      this.remediation = remediation;
      return this;
    }

    /**
     * Set the createTime.
     *
     * @param createTime the createTime
     * @return the UpdateOccurrenceOptions builder
     */
    public Builder createTime(Date createTime) {
      this.createTime = createTime;
      return this;
    }

    /**
     * Set the updateTime.
     *
     * @param updateTime the updateTime
     * @return the UpdateOccurrenceOptions builder
     */
    public Builder updateTime(Date updateTime) {
      this.updateTime = updateTime;
      return this;
    }

    /**
     * Set the context.
     *
     * @param context the context
     * @return the UpdateOccurrenceOptions builder
     */
    public Builder context(Context context) {
      this.context = context;
      return this;
    }

    /**
     * Set the finding.
     *
     * @param finding the finding
     * @return the UpdateOccurrenceOptions builder
     */
    public Builder finding(Finding finding) {
      this.finding = finding;
      return this;
    }

    /**
     * Set the kpi.
     *
     * @param kpi the kpi
     * @return the UpdateOccurrenceOptions builder
     */
    public Builder kpi(Kpi kpi) {
      this.kpi = kpi;
      return this;
    }

    /**
     * Set the referenceData.
     *
     * @param referenceData the referenceData
     * @return the UpdateOccurrenceOptions builder
     */
    public Builder referenceData(Map<String, Object> referenceData) {
      this.referenceData = referenceData;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the UpdateOccurrenceOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the apiOccurrence.
     *
     * @param apiOccurrence the apiOccurrence
     * @return the UpdateOccurrenceOptions builder
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

  protected UpdateOccurrenceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.providerId,
      "providerId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.occurrenceId,
      "occurrenceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.noteName,
      "noteName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.id,
      "id cannot be null");
    accountId = builder.accountId;
    providerId = builder.providerId;
    occurrenceId = builder.occurrenceId;
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
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a UpdateOccurrenceOptions builder
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
   * First part of occurrence `name`: providers/{provider_id}/occurrences/{occurrence_id}.
   *
   * @return the providerId
   */
  public String providerId() {
    return providerId;
  }

  /**
   * Gets the occurrenceId.
   *
   * Second part of occurrence `name`: providers/{provider_id}/occurrences/{occurrence_id}.
   *
   * @return the occurrenceId
   */
  public String occurrenceId() {
    return occurrenceId;
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

