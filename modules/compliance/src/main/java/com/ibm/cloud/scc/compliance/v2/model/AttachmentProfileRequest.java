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
 * request body of attachments of a profile.
 */
public class AttachmentProfileRequest extends GenericModel {

  protected List<AttachmentPayload> attachments;

  /**
   * Builder.
   */
  public static class Builder {
    private List<AttachmentPayload> attachments;

    /**
     * Instantiates a new Builder from an existing AttachmentProfileRequest instance.
     *
     * @param attachmentProfileRequest the instance to initialize the Builder with
     */
    private Builder(AttachmentProfileRequest attachmentProfileRequest) {
      this.attachments = attachmentProfileRequest.attachments;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AttachmentProfileRequest.
     *
     * @return the new AttachmentProfileRequest instance
     */
    public AttachmentProfileRequest build() {
      return new AttachmentProfileRequest(this);
    }

    /**
     * Adds an attachments to attachments.
     *
     * @param attachments the new attachments
     * @return the AttachmentProfileRequest builder
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
     * Set the attachments.
     * Existing attachments will be replaced.
     *
     * @param attachments the attachments
     * @return the AttachmentProfileRequest builder
     */
    public Builder attachments(List<AttachmentPayload> attachments) {
      this.attachments = attachments;
      return this;
    }
  }

  protected AttachmentProfileRequest() { }

  protected AttachmentProfileRequest(Builder builder) {
    attachments = builder.attachments;
  }

  /**
   * New builder.
   *
   * @return a AttachmentProfileRequest builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
}

