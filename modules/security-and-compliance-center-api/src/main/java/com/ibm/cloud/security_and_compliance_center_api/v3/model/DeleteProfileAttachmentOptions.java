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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteProfileAttachment options.
 */
public class DeleteProfileAttachmentOptions extends GenericModel {

  protected String attachmentId;
  protected String profileId;
  protected String xCorrelationId;
  protected String xRequestId;

  /**
   * Builder.
   */
  public static class Builder {
    private String attachmentId;
    private String profileId;
    private String xCorrelationId;
    private String xRequestId;

    /**
     * Instantiates a new Builder from an existing DeleteProfileAttachmentOptions instance.
     *
     * @param deleteProfileAttachmentOptions the instance to initialize the Builder with
     */
    private Builder(DeleteProfileAttachmentOptions deleteProfileAttachmentOptions) {
      this.attachmentId = deleteProfileAttachmentOptions.attachmentId;
      this.profileId = deleteProfileAttachmentOptions.profileId;
      this.xCorrelationId = deleteProfileAttachmentOptions.xCorrelationId;
      this.xRequestId = deleteProfileAttachmentOptions.xRequestId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param attachmentId the attachmentId
     * @param profileId the profileId
     */
    public Builder(String attachmentId, String profileId) {
      this.attachmentId = attachmentId;
      this.profileId = profileId;
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
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the DeleteProfileAttachmentOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the DeleteProfileAttachmentOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }
  }

  protected DeleteProfileAttachmentOptions() { }

  protected DeleteProfileAttachmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.attachmentId,
      "attachmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    attachmentId = builder.attachmentId;
    profileId = builder.profileId;
    xCorrelationId = builder.xCorrelationId;
    xRequestId = builder.xRequestId;
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

