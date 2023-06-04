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
 * The createScan options.
 */
public class CreateScanOptions extends GenericModel {

  protected String instanceId;
  protected String attachmentId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String attachmentId;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing CreateScanOptions instance.
     *
     * @param createScanOptions the instance to initialize the Builder with
     */
    private Builder(CreateScanOptions createScanOptions) {
      this.instanceId = createScanOptions.instanceId;
      this.attachmentId = createScanOptions.attachmentId;
      this.transactionId = createScanOptions.transactionId;
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
     */
    public Builder(String instanceId) {
      this.instanceId = instanceId;
    }

    /**
     * Builds a CreateScanOptions.
     *
     * @return the new CreateScanOptions instance
     */
    public CreateScanOptions build() {
      return new CreateScanOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the CreateScanOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the attachmentId.
     *
     * @param attachmentId the attachmentId
     * @return the CreateScanOptions builder
     */
    public Builder attachmentId(String attachmentId) {
      this.attachmentId = attachmentId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the CreateScanOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected CreateScanOptions() { }

  protected CreateScanOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    attachmentId = builder.attachmentId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a CreateScanOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Gets the attachmentId.
   *
   * Attachment ID.
   *
   * @return the attachmentId
   */
  public String attachmentId() {
    return attachmentId;
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

