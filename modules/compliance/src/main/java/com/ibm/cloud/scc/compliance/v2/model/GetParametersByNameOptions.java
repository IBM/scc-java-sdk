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
 * The getParametersByName options.
 */
public class GetParametersByNameOptions extends GenericModel {

  protected String profilesId;
  protected String attachmentId;
  protected String parameterName;
  protected String instanceId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String profilesId;
    private String attachmentId;
    private String parameterName;
    private String instanceId;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing GetParametersByNameOptions instance.
     *
     * @param getParametersByNameOptions the instance to initialize the Builder with
     */
    private Builder(GetParametersByNameOptions getParametersByNameOptions) {
      this.profilesId = getParametersByNameOptions.profilesId;
      this.attachmentId = getParametersByNameOptions.attachmentId;
      this.parameterName = getParametersByNameOptions.parameterName;
      this.instanceId = getParametersByNameOptions.instanceId;
      this.transactionId = getParametersByNameOptions.transactionId;
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
     * @param parameterName the parameterName
     * @param instanceId the instanceId
     */
    public Builder(String profilesId, String attachmentId, String parameterName, String instanceId) {
      this.profilesId = profilesId;
      this.attachmentId = attachmentId;
      this.parameterName = parameterName;
      this.instanceId = instanceId;
    }

    /**
     * Builds a GetParametersByNameOptions.
     *
     * @return the new GetParametersByNameOptions instance
     */
    public GetParametersByNameOptions build() {
      return new GetParametersByNameOptions(this);
    }

    /**
     * Set the profilesId.
     *
     * @param profilesId the profilesId
     * @return the GetParametersByNameOptions builder
     */
    public Builder profilesId(String profilesId) {
      this.profilesId = profilesId;
      return this;
    }

    /**
     * Set the attachmentId.
     *
     * @param attachmentId the attachmentId
     * @return the GetParametersByNameOptions builder
     */
    public Builder attachmentId(String attachmentId) {
      this.attachmentId = attachmentId;
      return this;
    }

    /**
     * Set the parameterName.
     *
     * @param parameterName the parameterName
     * @return the GetParametersByNameOptions builder
     */
    public Builder parameterName(String parameterName) {
      this.parameterName = parameterName;
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the GetParametersByNameOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the GetParametersByNameOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected GetParametersByNameOptions() { }

  protected GetParametersByNameOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profilesId,
      "profilesId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.attachmentId,
      "attachmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.parameterName,
      "parameterName cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    profilesId = builder.profilesId;
    attachmentId = builder.attachmentId;
    parameterName = builder.parameterName;
    instanceId = builder.instanceId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a GetParametersByNameOptions builder
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
   * Gets the parameterName.
   *
   * The parameter name.
   *
   * @return the parameterName
   */
  public String parameterName() {
    return parameterName;
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

