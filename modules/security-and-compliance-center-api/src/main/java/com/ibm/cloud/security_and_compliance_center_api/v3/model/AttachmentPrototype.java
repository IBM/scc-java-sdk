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
package com.ibm.cloud.security_and_compliance_center_api.v3.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The request body of getting an attachment that is associated with your account.
 */
public class AttachmentPrototype extends GenericModel {

  @SerializedName("profile_id")
  protected String profileId;
  protected List<AttachmentsPrototype> attachments;

  /**
   * Builder.
   */
  public static class Builder {
    private String profileId;
    private List<AttachmentsPrototype> attachments;

    /**
     * Instantiates a new Builder from an existing AttachmentPrototype instance.
     *
     * @param attachmentPrototype the instance to initialize the Builder with
     */
    private Builder(AttachmentPrototype attachmentPrototype) {
      this.profileId = attachmentPrototype.profileId;
      this.attachments = attachmentPrototype.attachments;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param attachments the attachments
     */
    public Builder(List<AttachmentsPrototype> attachments) {
      this.attachments = attachments;
    }

    /**
     * Builds a AttachmentPrototype.
     *
     * @return the new AttachmentPrototype instance
     */
    public AttachmentPrototype build() {
      return new AttachmentPrototype(this);
    }

    /**
     * Adds an attachments to attachments.
     *
     * @param attachments the new attachments
     * @return the AttachmentPrototype builder
     */
    public Builder addAttachments(AttachmentsPrototype attachments) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attachments,
        "attachments cannot be null");
      if (this.attachments == null) {
        this.attachments = new ArrayList<AttachmentsPrototype>();
      }
      this.attachments.add(attachments);
      return this;
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the AttachmentPrototype builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the attachments.
     * Existing attachments will be replaced.
     *
     * @param attachments the attachments
     * @return the AttachmentPrototype builder
     */
    public Builder attachments(List<AttachmentsPrototype> attachments) {
      this.attachments = attachments;
      return this;
    }
  }

  protected AttachmentPrototype() { }

  protected AttachmentPrototype(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.attachments,
      "attachments cannot be null");
    profileId = builder.profileId;
    attachments = builder.attachments;
  }

  /**
   * New builder.
   *
   * @return a AttachmentPrototype builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the profileId.
   *
   * The ID of the profile that is specified in the attachment.
   *
   * @return the profileId
   */
  public String profileId() {
    return profileId;
  }

  /**
   * Gets the attachments.
   *
   * The array that displays all of the available attachments.
   *
   * @return the attachments
   */
  public List<AttachmentsPrototype> attachments() {
    return attachments;
  }
}

