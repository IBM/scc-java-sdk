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
 * The createProfileAttachment options.
 */
public class CreateProfileAttachmentOptions extends GenericModel {

  protected String instanceId;
  protected String profileId;
  protected List<ProfileAttachmentBase> newAttachments;
  protected String newProfileId;
  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String profileId;
    private List<ProfileAttachmentBase> newAttachments;
    private String newProfileId;
    private String accountId;

    /**
     * Instantiates a new Builder from an existing CreateProfileAttachmentOptions instance.
     *
     * @param createProfileAttachmentOptions the instance to initialize the Builder with
     */
    private Builder(CreateProfileAttachmentOptions createProfileAttachmentOptions) {
      this.instanceId = createProfileAttachmentOptions.instanceId;
      this.profileId = createProfileAttachmentOptions.profileId;
      this.newAttachments = createProfileAttachmentOptions.newAttachments;
      this.newProfileId = createProfileAttachmentOptions.newProfileId;
      this.accountId = createProfileAttachmentOptions.accountId;
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
     * @param newAttachments the newAttachments
     */
    public Builder(String instanceId, String profileId, List<ProfileAttachmentBase> newAttachments) {
      this.instanceId = instanceId;
      this.profileId = profileId;
      this.newAttachments = newAttachments;
    }

    /**
     * Builds a CreateProfileAttachmentOptions.
     *
     * @return the new CreateProfileAttachmentOptions instance
     */
    public CreateProfileAttachmentOptions build() {
      return new CreateProfileAttachmentOptions(this);
    }

    /**
     * Adds a new element to newAttachments.
     *
     * @param newAttachments the new element to be added
     * @return the CreateProfileAttachmentOptions builder
     */
    public Builder addNewAttachments(ProfileAttachmentBase newAttachments) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(newAttachments,
        "newAttachments cannot be null");
      if (this.newAttachments == null) {
        this.newAttachments = new ArrayList<ProfileAttachmentBase>();
      }
      this.newAttachments.add(newAttachments);
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the CreateProfileAttachmentOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the CreateProfileAttachmentOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the newAttachments.
     * Existing newAttachments will be replaced.
     *
     * @param newAttachments the newAttachments
     * @return the CreateProfileAttachmentOptions builder
     */
    public Builder newAttachments(List<ProfileAttachmentBase> newAttachments) {
      this.newAttachments = newAttachments;
      return this;
    }

    /**
     * Set the newProfileId.
     *
     * @param newProfileId the newProfileId
     * @return the CreateProfileAttachmentOptions builder
     */
    public Builder newProfileId(String newProfileId) {
      this.newProfileId = newProfileId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateProfileAttachmentOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected CreateProfileAttachmentOptions() { }

  protected CreateProfileAttachmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.newAttachments,
      "newAttachments cannot be null");
    instanceId = builder.instanceId;
    profileId = builder.profileId;
    newAttachments = builder.newAttachments;
    newProfileId = builder.newProfileId;
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a CreateProfileAttachmentOptions builder
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
   * Gets the newAttachments.
   *
   * The Prototype to create a profile attachment.
   *
   * @return the newAttachments
   */
  public List<ProfileAttachmentBase> newAttachments() {
    return newAttachments;
  }

  /**
   * Gets the newProfileId.
   *
   * The profile ID to target against.
   *
   * @return the newProfileId
   */
  public String newProfileId() {
    return newProfileId;
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

