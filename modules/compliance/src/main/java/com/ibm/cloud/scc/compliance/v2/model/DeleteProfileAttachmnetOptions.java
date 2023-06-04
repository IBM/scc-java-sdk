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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteProfileAttachmnet options.
 */
public class DeleteProfileAttachmnetOptions extends GenericModel {

  protected String profilesId;
  protected String attachmentId;
  protected String instanceId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String profilesId;
    private String attachmentId;
    private String instanceId;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing DeleteProfileAttachmnetOptions instance.
     *
     * @param deleteProfileAttachmnetOptions the instance to initialize the Builder with
     */
    private Builder(DeleteProfileAttachmnetOptions deleteProfileAttachmnetOptions) {
      this.profilesId = deleteProfileAttachmnetOptions.profilesId;
      this.attachmentId = deleteProfileAttachmnetOptions.attachmentId;
      this.instanceId = deleteProfileAttachmnetOptions.instanceId;
      this.transactionId = deleteProfileAttachmnetOptions.transactionId;
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
     * Builds a DeleteProfileAttachmnetOptions.
     *
     * @return the new DeleteProfileAttachmnetOptions instance
     */
    public DeleteProfileAttachmnetOptions build() {
      return new DeleteProfileAttachmnetOptions(this);
    }

    /**
     * Set the profilesId.
     *
     * @param profilesId the profilesId
     * @return the DeleteProfileAttachmnetOptions builder
     */
    public Builder profilesId(String profilesId) {
      this.profilesId = profilesId;
      return this;
    }

    /**
     * Set the attachmentId.
     *
     * @param attachmentId the attachmentId
     * @return the DeleteProfileAttachmnetOptions builder
     */
    public Builder attachmentId(String attachmentId) {
      this.attachmentId = attachmentId;
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the DeleteProfileAttachmnetOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the DeleteProfileAttachmnetOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected DeleteProfileAttachmnetOptions() { }

  protected DeleteProfileAttachmnetOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profilesId,
      "profilesId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.attachmentId,
      "attachmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    profilesId = builder.profilesId;
    attachmentId = builder.attachmentId;
    instanceId = builder.instanceId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a DeleteProfileAttachmnetOptions builder
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

