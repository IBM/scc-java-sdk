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
package com.ibm.cloud.scc.compliance.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The attachment details of a profile.
 */
public class AttachmentPayload extends GenericModel {

  /**
   * status.
   */
  public interface Status {
    /** enabled. */
    String ENABLED = "enabled";
    /** disabled. */
    String DISABLED = "disabled";
  }

  protected String id;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("included_scope")
  protected ScopePayload includedScope;
  protected List<ScopePayload> exclusions;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("created_on")
  protected String createdOn;
  @SerializedName("updated_by")
  protected String updatedBy;
  @SerializedName("updated_on")
  protected String updatedOn;
  protected String status;
  @SerializedName("attachment_parameters")
  protected List<ParameterDetails> attachmentParameters;
  @SerializedName("attachment_notifications")
  protected AttachmentsNotificationsPayload attachmentNotifications;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String accountId;
    private ScopePayload includedScope;
    private List<ScopePayload> exclusions;
    private String createdBy;
    private String createdOn;
    private String updatedBy;
    private String updatedOn;
    private String status;
    private List<ParameterDetails> attachmentParameters;
    private AttachmentsNotificationsPayload attachmentNotifications;

    /**
     * Instantiates a new Builder from an existing AttachmentPayload instance.
     *
     * @param attachmentPayload the instance to initialize the Builder with
     */
    private Builder(AttachmentPayload attachmentPayload) {
      this.id = attachmentPayload.id;
      this.accountId = attachmentPayload.accountId;
      this.includedScope = attachmentPayload.includedScope;
      this.exclusions = attachmentPayload.exclusions;
      this.createdBy = attachmentPayload.createdBy;
      this.createdOn = attachmentPayload.createdOn;
      this.updatedBy = attachmentPayload.updatedBy;
      this.updatedOn = attachmentPayload.updatedOn;
      this.status = attachmentPayload.status;
      this.attachmentParameters = attachmentPayload.attachmentParameters;
      this.attachmentNotifications = attachmentPayload.attachmentNotifications;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AttachmentPayload.
     *
     * @return the new AttachmentPayload instance
     */
    public AttachmentPayload build() {
      return new AttachmentPayload(this);
    }

    /**
     * Adds an exclusions to exclusions.
     *
     * @param exclusions the new exclusions
     * @return the AttachmentPayload builder
     */
    public Builder addExclusions(ScopePayload exclusions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(exclusions,
        "exclusions cannot be null");
      if (this.exclusions == null) {
        this.exclusions = new ArrayList<ScopePayload>();
      }
      this.exclusions.add(exclusions);
      return this;
    }

    /**
     * Adds an attachmentParameters to attachmentParameters.
     *
     * @param attachmentParameters the new attachmentParameters
     * @return the AttachmentPayload builder
     */
    public Builder addAttachmentParameters(ParameterDetails attachmentParameters) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attachmentParameters,
        "attachmentParameters cannot be null");
      if (this.attachmentParameters == null) {
        this.attachmentParameters = new ArrayList<ParameterDetails>();
      }
      this.attachmentParameters.add(attachmentParameters);
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the AttachmentPayload builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the AttachmentPayload builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the includedScope.
     *
     * @param includedScope the includedScope
     * @return the AttachmentPayload builder
     */
    public Builder includedScope(ScopePayload includedScope) {
      this.includedScope = includedScope;
      return this;
    }

    /**
     * Set the exclusions.
     * Existing exclusions will be replaced.
     *
     * @param exclusions the exclusions
     * @return the AttachmentPayload builder
     */
    public Builder exclusions(List<ScopePayload> exclusions) {
      this.exclusions = exclusions;
      return this;
    }

    /**
     * Set the createdBy.
     *
     * @param createdBy the createdBy
     * @return the AttachmentPayload builder
     */
    public Builder createdBy(String createdBy) {
      this.createdBy = createdBy;
      return this;
    }

    /**
     * Set the createdOn.
     *
     * @param createdOn the createdOn
     * @return the AttachmentPayload builder
     */
    public Builder createdOn(String createdOn) {
      this.createdOn = createdOn;
      return this;
    }

    /**
     * Set the updatedBy.
     *
     * @param updatedBy the updatedBy
     * @return the AttachmentPayload builder
     */
    public Builder updatedBy(String updatedBy) {
      this.updatedBy = updatedBy;
      return this;
    }

    /**
     * Set the updatedOn.
     *
     * @param updatedOn the updatedOn
     * @return the AttachmentPayload builder
     */
    public Builder updatedOn(String updatedOn) {
      this.updatedOn = updatedOn;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the AttachmentPayload builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Set the attachmentParameters.
     * Existing attachmentParameters will be replaced.
     *
     * @param attachmentParameters the attachmentParameters
     * @return the AttachmentPayload builder
     */
    public Builder attachmentParameters(List<ParameterDetails> attachmentParameters) {
      this.attachmentParameters = attachmentParameters;
      return this;
    }

    /**
     * Set the attachmentNotifications.
     *
     * @param attachmentNotifications the attachmentNotifications
     * @return the AttachmentPayload builder
     */
    public Builder attachmentNotifications(AttachmentsNotificationsPayload attachmentNotifications) {
      this.attachmentNotifications = attachmentNotifications;
      return this;
    }
  }

  protected AttachmentPayload() { }

  protected AttachmentPayload(Builder builder) {
    id = builder.id;
    accountId = builder.accountId;
    includedScope = builder.includedScope;
    exclusions = builder.exclusions;
    createdBy = builder.createdBy;
    createdOn = builder.createdOn;
    updatedBy = builder.updatedBy;
    updatedOn = builder.updatedOn;
    status = builder.status;
    attachmentParameters = builder.attachmentParameters;
    attachmentNotifications = builder.attachmentNotifications;
  }

  /**
   * New builder.
   *
   * @return a AttachmentPayload builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * attachment id.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the accountId.
   *
   * account id.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the includedScope.
   *
   * scope payload.
   *
   * @return the includedScope
   */
  public ScopePayload includedScope() {
    return includedScope;
  }

  /**
   * Gets the exclusions.
   *
   * exclusions.
   *
   * @return the exclusions
   */
  public List<ScopePayload> exclusions() {
    return exclusions;
  }

  /**
   * Gets the createdBy.
   *
   * created by.
   *
   * @return the createdBy
   */
  public String createdBy() {
    return createdBy;
  }

  /**
   * Gets the createdOn.
   *
   * created on.
   *
   * @return the createdOn
   */
  public String createdOn() {
    return createdOn;
  }

  /**
   * Gets the updatedBy.
   *
   * updated by.
   *
   * @return the updatedBy
   */
  public String updatedBy() {
    return updatedBy;
  }

  /**
   * Gets the updatedOn.
   *
   * updated on.
   *
   * @return the updatedOn
   */
  public String updatedOn() {
    return updatedOn;
  }

  /**
   * Gets the status.
   *
   * status.
   *
   * @return the status
   */
  public String status() {
    return status;
  }

  /**
   * Gets the attachmentParameters.
   *
   * attachment parameters.
   *
   * @return the attachmentParameters
   */
  public List<ParameterDetails> attachmentParameters() {
    return attachmentParameters;
  }

  /**
   * Gets the attachmentNotifications.
   *
   * payload of the attachments notifications.
   *
   * @return the attachmentNotifications
   */
  public AttachmentsNotificationsPayload attachmentNotifications() {
    return attachmentNotifications;
  }
}

