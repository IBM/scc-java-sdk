/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.cloud.security_and_compliance_center_api.v3.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The upgradeAttachment options.
 */
public class UpgradeAttachmentOptions extends GenericModel {

  protected String instanceId;
  protected String profileId;
  protected String attachmentId;
  protected List<Parameter> attachmentParameters;
  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String profileId;
    private String attachmentId;
    private List<Parameter> attachmentParameters;
    private String accountId;

    /**
     * Instantiates a new Builder from an existing UpgradeAttachmentOptions instance.
     *
     * @param upgradeAttachmentOptions the instance to initialize the Builder with
     */
    private Builder(UpgradeAttachmentOptions upgradeAttachmentOptions) {
      this.instanceId = upgradeAttachmentOptions.instanceId;
      this.profileId = upgradeAttachmentOptions.profileId;
      this.attachmentId = upgradeAttachmentOptions.attachmentId;
      this.attachmentParameters = upgradeAttachmentOptions.attachmentParameters;
      this.accountId = upgradeAttachmentOptions.accountId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceId the instanceId
     * @param profileId the profileId
     * @param attachmentId the attachmentId
     * @param attachmentParameters the attachmentParameters
     */
    public Builder(String instanceId, String profileId, String attachmentId, List<Parameter> attachmentParameters) {
      this.instanceId = instanceId;
      this.profileId = profileId;
      this.attachmentId = attachmentId;
      this.attachmentParameters = attachmentParameters;
    }

    /**
     * Builds a UpgradeAttachmentOptions.
     *
     * @return the new UpgradeAttachmentOptions instance
     */
    public UpgradeAttachmentOptions build() {
      return new UpgradeAttachmentOptions(this);
    }

    /**
     * Adds a new element to attachmentParameters.
     *
     * @param attachmentParameters the new element to be added
     * @return the UpgradeAttachmentOptions builder
     */
    public Builder addAttachmentParameters(Parameter attachmentParameters) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attachmentParameters,
        "attachmentParameters cannot be null");
      if (this.attachmentParameters == null) {
        this.attachmentParameters = new ArrayList<Parameter>();
      }
      this.attachmentParameters.add(attachmentParameters);
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the UpgradeAttachmentOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the UpgradeAttachmentOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the attachmentId.
     *
     * @param attachmentId the attachmentId
     * @return the UpgradeAttachmentOptions builder
     */
    public Builder attachmentId(String attachmentId) {
      this.attachmentId = attachmentId;
      return this;
    }

    /**
     * Set the attachmentParameters.
     * Existing attachmentParameters will be replaced.
     *
     * @param attachmentParameters the attachmentParameters
     * @return the UpgradeAttachmentOptions builder
     */
    public Builder attachmentParameters(List<Parameter> attachmentParameters) {
      this.attachmentParameters = attachmentParameters;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the UpgradeAttachmentOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected UpgradeAttachmentOptions() { }

  protected UpgradeAttachmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.attachmentId,
      "attachmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.attachmentParameters,
      "attachmentParameters cannot be null");
    instanceId = builder.instanceId;
    profileId = builder.profileId;
    attachmentId = builder.attachmentId;
    attachmentParameters = builder.attachmentParameters;
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a UpgradeAttachmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The ID of the Security and Compliance Center instance.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the profileId.
   *
   * The profile ID.
   *
   * @return the profileId
   */
  public String profileId() {
    return profileId;
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
   * Gets the attachmentParameters.
   *
   * The attachment_parameters to set for a Profile Attachment.
   *
   * @return the attachmentParameters
   */
  public List<Parameter> attachmentParameters() {
    return attachmentParameters;
  }

  /**
   * Gets the accountId.
   *
   * The user account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

