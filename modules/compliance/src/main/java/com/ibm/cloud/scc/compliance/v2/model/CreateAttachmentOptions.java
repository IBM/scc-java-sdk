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
 * The createAttachment options.
 */
public class CreateAttachmentOptions extends GenericModel {

  protected String profilesId;
  protected String instanceId;
  protected List<AttachmentPayload> attachments;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String profilesId;
    private String instanceId;
    private List<AttachmentPayload> attachments;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing CreateAttachmentOptions instance.
     *
     * @param createAttachmentOptions the instance to initialize the Builder with
     */
    private Builder(CreateAttachmentOptions createAttachmentOptions) {
      this.profilesId = createAttachmentOptions.profilesId;
      this.instanceId = createAttachmentOptions.instanceId;
      this.attachments = createAttachmentOptions.attachments;
      this.transactionId = createAttachmentOptions.transactionId;
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
     * @param instanceId the instanceId
     */
    public Builder(String profilesId, String instanceId) {
      this.profilesId = profilesId;
      this.instanceId = instanceId;
    }

    /**
     * Builds a CreateAttachmentOptions.
     *
     * @return the new CreateAttachmentOptions instance
     */
    public CreateAttachmentOptions build() {
      return new CreateAttachmentOptions(this);
    }

    /**
     * Adds an attachments to attachments.
     *
     * @param attachments the new attachments
     * @return the CreateAttachmentOptions builder
     */
    public Builder addAttachments(AttachmentPayload attachments) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attachments,
        "attachments cannot be null");
      if (this.attachments == null) {
        this.attachments = new ArrayList<AttachmentPayload>();
      }
      this.attachments.add(attachments);
      return this;
    }

    /**
     * Set the profilesId.
     *
     * @param profilesId the profilesId
     * @return the CreateAttachmentOptions builder
     */
    public Builder profilesId(String profilesId) {
      this.profilesId = profilesId;
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the CreateAttachmentOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the attachments.
     * Existing attachments will be replaced.
     *
     * @param attachments the attachments
     * @return the CreateAttachmentOptions builder
     */
    public Builder attachments(List<AttachmentPayload> attachments) {
      this.attachments = attachments;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the CreateAttachmentOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the attachmentProfileRequest.
     *
     * @param attachmentProfileRequest the attachmentProfileRequest
     * @return the CreateAttachmentOptions builder
     */
    public Builder attachmentProfileRequest(AttachmentProfileRequest attachmentProfileRequest) {
      this.attachments = attachmentProfileRequest.attachments();
      return this;
    }
  }

  protected CreateAttachmentOptions() { }

  protected CreateAttachmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profilesId,
      "profilesId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    profilesId = builder.profilesId;
    instanceId = builder.instanceId;
    attachments = builder.attachments;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a CreateAttachmentOptions builder
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
   * Gets the attachments.
   *
   * the attachments of a profile.
   *
   * @return the attachments
   */
  public List<AttachmentPayload> attachments() {
    return attachments;
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

