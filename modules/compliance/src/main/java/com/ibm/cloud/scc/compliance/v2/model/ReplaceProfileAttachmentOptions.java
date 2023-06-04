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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceProfileAttachment options.
 */
public class ReplaceProfileAttachmentOptions extends GenericModel {

  /**
   * status.
   */
  public interface Status {
    /** enabled. */
    String ENABLED = "enabled";
    /** disabled. */
    String DISABLED = "disabled";
  }

  protected String profilesId;
  protected String attachmentId;
  protected String instanceId;
  protected String id;
  protected String accountId;
  protected ScopePayload includedScope;
  protected List<ScopePayload> exclusions;
  protected String createdBy;
  protected String createdOn;
  protected String updatedBy;
  protected String updatedOn;
  protected String status;
  protected List<ParameterDetails> attachmentParameters;
  protected AttachmentsNotificationsPayload attachmentNotifications;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String profilesId;
    private String attachmentId;
    private String instanceId;
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
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing ReplaceProfileAttachmentOptions instance.
     *
     * @param replaceProfileAttachmentOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceProfileAttachmentOptions replaceProfileAttachmentOptions) {
      this.profilesId = replaceProfileAttachmentOptions.profilesId;
      this.attachmentId = replaceProfileAttachmentOptions.attachmentId;
      this.instanceId = replaceProfileAttachmentOptions.instanceId;
      this.id = replaceProfileAttachmentOptions.id;
      this.accountId = replaceProfileAttachmentOptions.accountId;
      this.includedScope = replaceProfileAttachmentOptions.includedScope;
      this.exclusions = replaceProfileAttachmentOptions.exclusions;
      this.createdBy = replaceProfileAttachmentOptions.createdBy;
      this.createdOn = replaceProfileAttachmentOptions.createdOn;
      this.updatedBy = replaceProfileAttachmentOptions.updatedBy;
      this.updatedOn = replaceProfileAttachmentOptions.updatedOn;
      this.status = replaceProfileAttachmentOptions.status;
      this.attachmentParameters = replaceProfileAttachmentOptions.attachmentParameters;
      this.attachmentNotifications = replaceProfileAttachmentOptions.attachmentNotifications;
      this.transactionId = replaceProfileAttachmentOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param profilesId the profilesId
     * @param attachmentId the attachmentId
     * @param instanceId the instanceId
     */
    public Builder(String profilesId, String attachmentId, String instanceId) {
      this.profilesId = profilesId;
      this.attachmentId = attachmentId;
      this.instanceId = instanceId;
    }

    /**
     * Builds a ReplaceProfileAttachmentOptions.
     *
     * @return the new ReplaceProfileAttachmentOptions instance
     */
    public ReplaceProfileAttachmentOptions build() {
      return new ReplaceProfileAttachmentOptions(this);
    }

    /**
     * Adds an exclusions to exclusions.
     *
     * @param exclusions the new exclusions
     * @return the ReplaceProfileAttachmentOptions builder
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
     * @return the ReplaceProfileAttachmentOptions builder
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
     * Set the profilesId.
     *
     * @param profilesId the profilesId
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder profilesId(String profilesId) {
      this.profilesId = profilesId;
      return this;
    }

    /**
     * Set the attachmentId.
     *
     * @param attachmentId the attachmentId
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder attachmentId(String attachmentId) {
      this.attachmentId = attachmentId;
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the includedScope.
     *
     * @param includedScope the includedScope
     * @return the ReplaceProfileAttachmentOptions builder
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
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder exclusions(List<ScopePayload> exclusions) {
      this.exclusions = exclusions;
      return this;
    }

    /**
     * Set the createdBy.
     *
     * @param createdBy the createdBy
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder createdBy(String createdBy) {
      this.createdBy = createdBy;
      return this;
    }

    /**
     * Set the createdOn.
     *
     * @param createdOn the createdOn
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder createdOn(String createdOn) {
      this.createdOn = createdOn;
      return this;
    }

    /**
     * Set the updatedBy.
     *
     * @param updatedBy the updatedBy
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder updatedBy(String updatedBy) {
      this.updatedBy = updatedBy;
      return this;
    }

    /**
     * Set the updatedOn.
     *
     * @param updatedOn the updatedOn
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder updatedOn(String updatedOn) {
      this.updatedOn = updatedOn;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the ReplaceProfileAttachmentOptions builder
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
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder attachmentParameters(List<ParameterDetails> attachmentParameters) {
      this.attachmentParameters = attachmentParameters;
      return this;
    }

    /**
     * Set the attachmentNotifications.
     *
     * @param attachmentNotifications the attachmentNotifications
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder attachmentNotifications(AttachmentsNotificationsPayload attachmentNotifications) {
      this.attachmentNotifications = attachmentNotifications;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the attachmentPayload.
     *
     * @param attachmentPayload the attachmentPayload
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder attachmentPayload(AttachmentPayload attachmentPayload) {
      this.id = attachmentPayload.id();
      this.accountId = attachmentPayload.accountId();
      this.includedScope = attachmentPayload.includedScope();
      this.exclusions = attachmentPayload.exclusions();
      this.createdBy = attachmentPayload.createdBy();
      this.createdOn = attachmentPayload.createdOn();
      this.updatedBy = attachmentPayload.updatedBy();
      this.updatedOn = attachmentPayload.updatedOn();
      this.status = attachmentPayload.status();
      this.attachmentParameters = attachmentPayload.attachmentParameters();
      this.attachmentNotifications = attachmentPayload.attachmentNotifications();
      return this;
    }
  }

  protected ReplaceProfileAttachmentOptions() { }

  protected ReplaceProfileAttachmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profilesId,
      "profilesId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.attachmentId,
      "attachmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    profilesId = builder.profilesId;
    attachmentId = builder.attachmentId;
    instanceId = builder.instanceId;
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
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a ReplaceProfileAttachmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the profilesId.
   *
   * The profile ID.
   *
   * @return the profilesId
   */
  public String profilesId() {
    return profilesId;
  }

  /**
   * Gets the attachmentId.
   *
   * The attachment ID.
   *
   * @return the attachmentId
   */
  public String attachmentId() {
    return attachmentId;
  }

  /**
   * Gets the instanceId.
   *
   * Instance id.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
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
}

