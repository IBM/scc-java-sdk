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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteProfileAttachment options.
 */
public class DeleteProfileAttachmentOptions extends GenericModel {

  protected String instanceId;
  protected String profileId;
  protected String attachmentId;
  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String profileId;
    private String attachmentId;
    private String accountId;

    /**
     * Instantiates a new Builder from an existing DeleteProfileAttachmentOptions instance.
     *
     * @param deleteProfileAttachmentOptions the instance to initialize the Builder with
     */
    private Builder(DeleteProfileAttachmentOptions deleteProfileAttachmentOptions) {
      this.instanceId = deleteProfileAttachmentOptions.instanceId;
      this.profileId = deleteProfileAttachmentOptions.profileId;
      this.attachmentId = deleteProfileAttachmentOptions.attachmentId;
      this.accountId = deleteProfileAttachmentOptions.accountId;
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
     */
    public Builder(String instanceId, String profileId, String attachmentId) {
      this.instanceId = instanceId;
      this.profileId = profileId;
      this.attachmentId = attachmentId;
    }

    /**
     * Builds a DeleteProfileAttachmentOptions.
     *
     * @return the new DeleteProfileAttachmentOptions instance
     */
    public DeleteProfileAttachmentOptions build() {
      return new DeleteProfileAttachmentOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the DeleteProfileAttachmentOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the DeleteProfileAttachmentOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the attachmentId.
     *
     * @param attachmentId the attachmentId
     * @return the DeleteProfileAttachmentOptions builder
     */
    public Builder attachmentId(String attachmentId) {
      this.attachmentId = attachmentId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the DeleteProfileAttachmentOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected DeleteProfileAttachmentOptions() { }

  protected DeleteProfileAttachmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.attachmentId,
      "attachmentId cannot be empty");
    instanceId = builder.instanceId;
    profileId = builder.profileId;
    attachmentId = builder.attachmentId;
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a DeleteProfileAttachmentOptions builder
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

