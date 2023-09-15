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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createAttachment options.
 */
public class CreateAttachmentOptions extends GenericModel {

  protected String profileId;
  protected List<AttachmentsPrototype> attachments;
  protected String xCorrelationId;
  protected String xRequestId;

  /**
   * Builder.
   */
  public static class Builder {
    private String profileId;
    private List<AttachmentsPrototype> attachments;
    private String xCorrelationId;
    private String xRequestId;

    /**
     * Instantiates a new Builder from an existing CreateAttachmentOptions instance.
     *
     * @param createAttachmentOptions the instance to initialize the Builder with
     */
    private Builder(CreateAttachmentOptions createAttachmentOptions) {
      this.attachments = createAttachmentOptions.attachments;
      this.profileId = createAttachmentOptions.profileId;
      this.xCorrelationId = createAttachmentOptions.xCorrelationId;
      this.xRequestId = createAttachmentOptions.xRequestId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param profileId the profileId
     * @param attachments the attachments
     */
    public Builder(String profileId, List<AttachmentsPrototype> attachments) {
      this.profileId = profileId;
      this.attachments = attachments;
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
     * @return the CreateAttachmentOptions builder
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
     * @return the CreateAttachmentOptions builder
     */
    public Builder attachments(List<AttachmentsPrototype> attachments) {
      this.attachments = attachments;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the CreateAttachmentOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the CreateAttachmentOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }

    /**
     * Set the attachmentPrototype.
     *
     * @param attachmentPrototype the attachmentPrototype
     * @return the CreateAttachmentOptions builder
     */
    public Builder attachmentPrototype(AttachmentPrototype attachmentPrototype) {
      this.attachments = attachmentPrototype.attachments();
      this.profileId = attachmentPrototype.profileId();
      return this;
    }
  }

  protected CreateAttachmentOptions() { }

  protected CreateAttachmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.attachments,
      "attachments cannot be null");
    profileId = builder.profileId;
    attachments = builder.attachments;
    profileId = builder.profileId;
    xCorrelationId = builder.xCorrelationId;
    xRequestId = builder.xRequestId;
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
   * Gets the attachments.
   *
   * The array that displays all of the available attachments.
   *
   * @return the attachments
   */
  public List<AttachmentsPrototype> attachments() {
    return attachments;
  }

  /**
   * Gets the xCorrelationId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header for the
   * corresponding response. The same value is used for downstream requests and retries of those requests. If a value of
   * this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xCorrelationId
   */
  public String xCorrelationId() {
    return xCorrelationId;
  }

  /**
   * Gets the xRequestId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header for the
   * corresponding response. The same value is not used for downstream requests and retries of those requests. If a
   * value of this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xRequestId
   */
  public String xRequestId() {
    return xRequestId;
  }
}

