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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * `Occurrence` includes information about analysis occurrences for an image.
 */
public class ApiOccurrence extends GenericModel {

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

  @SerializedName("resource_url")
  protected String resourceUrl;
  @SerializedName("note_name")
  protected String noteName;
  protected String kind;
  protected String remediation;
  @SerializedName("create_time")
  protected Date createTime;
  @SerializedName("update_time")
  protected Date updateTime;
  protected String id;
  protected Context context;
  protected Finding finding;
  protected Kpi kpi;
  @SerializedName("reference_data")
  protected Map<String, Object> referenceData;

  /**
   * Builder.
   */
  public static class Builder {
    private String resourceUrl;
    private String noteName;
    private String kind;
    private String remediation;
    private Date createTime;
    private Date updateTime;
    private String id;
    private Context context;
    private Finding finding;
    private Kpi kpi;
    private Map<String, Object> referenceData;

    private Builder(ApiOccurrence apiOccurrence) {
      this.resourceUrl = apiOccurrence.resourceUrl;
      this.noteName = apiOccurrence.noteName;
      this.kind = apiOccurrence.kind;
      this.remediation = apiOccurrence.remediation;
      this.createTime = apiOccurrence.createTime;
      this.updateTime = apiOccurrence.updateTime;
      this.id = apiOccurrence.id;
      this.context = apiOccurrence.context;
      this.finding = apiOccurrence.finding;
      this.kpi = apiOccurrence.kpi;
      this.referenceData = apiOccurrence.referenceData;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param noteName the noteName
     * @param kind the kind
     * @param id the id
     */
    public Builder(String noteName, String kind, String id) {
      this.noteName = noteName;
      this.kind = kind;
      this.id = id;
    }

    /**
     * Builds a ApiOccurrence.
     *
     * @return the new ApiOccurrence instance
     */
    public ApiOccurrence build() {
      return new ApiOccurrence(this);
    }

    /**
     * Set the resourceUrl.
     *
     * @param resourceUrl the resourceUrl
     * @return the ApiOccurrence builder
     */
    public Builder resourceUrl(String resourceUrl) {
      this.resourceUrl = resourceUrl;
      return this;
    }

    /**
     * Set the noteName.
     *
     * @param noteName the noteName
     * @return the ApiOccurrence builder
     */
    public Builder noteName(String noteName) {
      this.noteName = noteName;
      return this;
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the ApiOccurrence builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the remediation.
     *
     * @param remediation the remediation
     * @return the ApiOccurrence builder
     */
    public Builder remediation(String remediation) {
      this.remediation = remediation;
      return this;
    }

    /**
     * Set the createTime.
     *
     * @param createTime the createTime
     * @return the ApiOccurrence builder
     */
    public Builder createTime(Date createTime) {
      this.createTime = createTime;
      return this;
    }

    /**
     * Set the updateTime.
     *
     * @param updateTime the updateTime
     * @return the ApiOccurrence builder
     */
    public Builder updateTime(Date updateTime) {
      this.updateTime = updateTime;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ApiOccurrence builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the context.
     *
     * @param context the context
     * @return the ApiOccurrence builder
     */
    public Builder context(Context context) {
      this.context = context;
      return this;
    }

    /**
     * Set the finding.
     *
     * @param finding the finding
     * @return the ApiOccurrence builder
     */
    public Builder finding(Finding finding) {
      this.finding = finding;
      return this;
    }

    /**
     * Set the kpi.
     *
     * @param kpi the kpi
     * @return the ApiOccurrence builder
     */
    public Builder kpi(Kpi kpi) {
      this.kpi = kpi;
      return this;
    }

    /**
     * Set the referenceData.
     *
     * @param referenceData the referenceData
     * @return the ApiOccurrence builder
     */
    public Builder referenceData(Map<String, Object> referenceData) {
      this.referenceData = referenceData;
      return this;
    }
  }

  protected ApiOccurrence(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.noteName,
      "noteName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.id,
      "id cannot be null");
    resourceUrl = builder.resourceUrl;
    noteName = builder.noteName;
    kind = builder.kind;
    remediation = builder.remediation;
    createTime = builder.createTime;
    updateTime = builder.updateTime;
    id = builder.id;
    context = builder.context;
    finding = builder.finding;
    kpi = builder.kpi;
    referenceData = builder.referenceData;
  }

  /**
   * New builder.
   *
   * @return a ApiOccurrence builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Gets the id.
   *
   * @return the id
   */
  public String id() {
    return id;
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
}

