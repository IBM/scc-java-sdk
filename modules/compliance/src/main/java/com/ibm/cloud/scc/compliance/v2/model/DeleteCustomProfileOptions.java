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
 * The deleteCustomProfile options.
 */
public class DeleteCustomProfileOptions extends GenericModel {

  protected String profilesId;
  protected String instanceId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String profilesId;
    private String instanceId;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing DeleteCustomProfileOptions instance.
     *
     * @param deleteCustomProfileOptions the instance to initialize the Builder with
     */
    private Builder(DeleteCustomProfileOptions deleteCustomProfileOptions) {
      this.profilesId = deleteCustomProfileOptions.profilesId;
      this.instanceId = deleteCustomProfileOptions.instanceId;
      this.transactionId = deleteCustomProfileOptions.transactionId;
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
     * Builds a DeleteCustomProfileOptions.
     *
     * @return the new DeleteCustomProfileOptions instance
     */
    public DeleteCustomProfileOptions build() {
      return new DeleteCustomProfileOptions(this);
    }

    /**
     * Set the profilesId.
     *
     * @param profilesId the profilesId
     * @return the DeleteCustomProfileOptions builder
     */
    public Builder profilesId(String profilesId) {
      this.profilesId = profilesId;
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the DeleteCustomProfileOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the DeleteCustomProfileOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected DeleteCustomProfileOptions() { }

  protected DeleteCustomProfileOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profilesId,
      "profilesId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    profilesId = builder.profilesId;
    instanceId = builder.instanceId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a DeleteCustomProfileOptions builder
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

