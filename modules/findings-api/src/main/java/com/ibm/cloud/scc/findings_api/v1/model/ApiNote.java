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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Provides a detailed description of a `Note`.
 */
public class ApiNote extends GenericModel {

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

  @SerializedName("short_description")
  protected String shortDescription;
  @SerializedName("long_description")
  protected String longDescription;
  protected String kind;
  @SerializedName("related_url")
  protected List<ApiNoteRelatedUrl> relatedUrl;
  @SerializedName("expiration_time")
  protected Date expirationTime;
  @SerializedName("create_time")
  protected Date createTime;
  @SerializedName("update_time")
  protected Date updateTime;
  protected String id;
  protected Boolean shared;
  @SerializedName("reported_by")
  protected Reporter reportedBy;
  protected FindingType finding;
  protected KpiType kpi;
  protected Card card;
  protected Section section;

  /**
   * Builder.
   */
  public static class Builder {
    private String shortDescription;
    private String longDescription;
    private String kind;
    private List<ApiNoteRelatedUrl> relatedUrl;
    private Date expirationTime;
    private Date createTime;
    private Date updateTime;
    private String id;
    private Boolean shared;
    private Reporter reportedBy;
    private FindingType finding;
    private KpiType kpi;
    private Card card;
    private Section section;

    private Builder(ApiNote apiNote) {
      this.shortDescription = apiNote.shortDescription;
      this.longDescription = apiNote.longDescription;
      this.kind = apiNote.kind;
      this.relatedUrl = apiNote.relatedUrl;
      this.expirationTime = apiNote.expirationTime;
      this.createTime = apiNote.createTime;
      this.updateTime = apiNote.updateTime;
      this.id = apiNote.id;
      this.shared = apiNote.shared;
      this.reportedBy = apiNote.reportedBy;
      this.finding = apiNote.finding;
      this.kpi = apiNote.kpi;
      this.card = apiNote.card;
      this.section = apiNote.section;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param shortDescription the shortDescription
     * @param longDescription the longDescription
     * @param kind the kind
     * @param id the id
     * @param reportedBy the reportedBy
     */
    public Builder(String shortDescription, String longDescription, String kind, String id, Reporter reportedBy) {
      this.shortDescription = shortDescription;
      this.longDescription = longDescription;
      this.kind = kind;
      this.id = id;
      this.reportedBy = reportedBy;
    }

    /**
     * Builds a ApiNote.
     *
     * @return the new ApiNote instance
     */
    public ApiNote build() {
      return new ApiNote(this);
    }

    /**
     * Adds an relatedUrl to relatedUrl.
     *
     * @param relatedUrl the new relatedUrl
     * @return the ApiNote builder
     */
    public Builder addRelatedUrl(ApiNoteRelatedUrl relatedUrl) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(relatedUrl,
        "relatedUrl cannot be null");
      if (this.relatedUrl == null) {
        this.relatedUrl = new ArrayList<ApiNoteRelatedUrl>();
      }
      this.relatedUrl.add(relatedUrl);
      return this;
    }

    /**
     * Set the shortDescription.
     *
     * @param shortDescription the shortDescription
     * @return the ApiNote builder
     */
    public Builder shortDescription(String shortDescription) {
      this.shortDescription = shortDescription;
      return this;
    }

    /**
     * Set the longDescription.
     *
     * @param longDescription the longDescription
     * @return the ApiNote builder
     */
    public Builder longDescription(String longDescription) {
      this.longDescription = longDescription;
      return this;
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the ApiNote builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the relatedUrl.
     * Existing relatedUrl will be replaced.
     *
     * @param relatedUrl the relatedUrl
     * @return the ApiNote builder
     */
    public Builder relatedUrl(List<ApiNoteRelatedUrl> relatedUrl) {
      this.relatedUrl = relatedUrl;
      return this;
    }

    /**
     * Set the expirationTime.
     *
     * @param expirationTime the expirationTime
     * @return the ApiNote builder
     */
    public Builder expirationTime(Date expirationTime) {
      this.expirationTime = expirationTime;
      return this;
    }

    /**
     * Set the createTime.
     *
     * @param createTime the createTime
     * @return the ApiNote builder
     */
    public Builder createTime(Date createTime) {
      this.createTime = createTime;
      return this;
    }

    /**
     * Set the updateTime.
     *
     * @param updateTime the updateTime
     * @return the ApiNote builder
     */
    public Builder updateTime(Date updateTime) {
      this.updateTime = updateTime;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ApiNote builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the shared.
     *
     * @param shared the shared
     * @return the ApiNote builder
     */
    public Builder shared(Boolean shared) {
      this.shared = shared;
      return this;
    }

    /**
     * Set the reportedBy.
     *
     * @param reportedBy the reportedBy
     * @return the ApiNote builder
     */
    public Builder reportedBy(Reporter reportedBy) {
      this.reportedBy = reportedBy;
      return this;
    }

    /**
     * Set the finding.
     *
     * @param finding the finding
     * @return the ApiNote builder
     */
    public Builder finding(FindingType finding) {
      this.finding = finding;
      return this;
    }

    /**
     * Set the kpi.
     *
     * @param kpi the kpi
     * @return the ApiNote builder
     */
    public Builder kpi(KpiType kpi) {
      this.kpi = kpi;
      return this;
    }

    /**
     * Set the card.
     *
     * @param card the card
     * @return the ApiNote builder
     */
    public Builder card(Card card) {
      this.card = card;
      return this;
    }

    /**
     * Set the section.
     *
     * @param section the section
     * @return the ApiNote builder
     */
    public Builder section(Section section) {
      this.section = section;
      return this;
    }
  }

  protected ApiNote(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.shortDescription,
      "shortDescription cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.longDescription,
      "longDescription cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.id,
      "id cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.reportedBy,
      "reportedBy cannot be null");
    shortDescription = builder.shortDescription;
    longDescription = builder.longDescription;
    kind = builder.kind;
    relatedUrl = builder.relatedUrl;
    expirationTime = builder.expirationTime;
    createTime = builder.createTime;
    updateTime = builder.updateTime;
    id = builder.id;
    shared = builder.shared;
    reportedBy = builder.reportedBy;
    finding = builder.finding;
    kpi = builder.kpi;
    card = builder.card;
    section = builder.section;
  }

  /**
   * New builder.
   *
   * @return a ApiNote builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the shortDescription.
   *
   * A one sentence description of this `Note`.
   *
   * @return the shortDescription
   */
  public String shortDescription() {
    return shortDescription;
  }

  /**
   * Gets the longDescription.
   *
   * A detailed description of this `Note`.
   *
   * @return the longDescription
   */
  public String longDescription() {
    return longDescription;
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
   * Gets the relatedUrl.
   *
   * @return the relatedUrl
   */
  public List<ApiNoteRelatedUrl> relatedUrl() {
    return relatedUrl;
  }

  /**
   * Gets the expirationTime.
   *
   * Time of expiration for this note, null if note does not expire.
   *
   * @return the expirationTime
   */
  public Date expirationTime() {
    return expirationTime;
  }

  /**
   * Gets the createTime.
   *
   * Output only. The time this note was created. This field can be used as a filter in list requests.
   *
   * @return the createTime
   */
  public Date createTime() {
    return createTime;
  }

  /**
   * Gets the updateTime.
   *
   * Output only. The time this note was last updated. This field can be used as a filter in list requests.
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
   * Gets the shared.
   *
   * True if this `Note` can be shared by multiple accounts.
   *
   * @return the shared
   */
  public Boolean shared() {
    return shared;
  }

  /**
   * Gets the reportedBy.
   *
   * The entity reporting a note.
   *
   * @return the reportedBy
   */
  public Reporter reportedBy() {
    return reportedBy;
  }

  /**
   * Gets the finding.
   *
   * FindingType provides details about a finding note.
   *
   * @return the finding
   */
  public FindingType finding() {
    return finding;
  }

  /**
   * Gets the kpi.
   *
   * KpiType provides details about a KPI note.
   *
   * @return the kpi
   */
  public KpiType kpi() {
    return kpi;
  }

  /**
   * Gets the card.
   *
   * Card provides details about a card kind of note.
   *
   * @return the card
   */
  public Card card() {
    return card;
  }

  /**
   * Gets the section.
   *
   * Card provides details about a card kind of note.
   *
   * @return the section
   */
  public Section section() {
    return section;
  }
}

