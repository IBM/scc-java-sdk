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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getProviderTypeInstance options.
 */
public class GetProviderTypeInstanceOptions extends GenericModel {

  protected String instanceId;
  protected String providerTypeId;
  protected String providerTypeInstanceId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String providerTypeId;
    private String providerTypeInstanceId;

    /**
     * Instantiates a new Builder from an existing GetProviderTypeInstanceOptions instance.
     *
     * @param getProviderTypeInstanceOptions the instance to initialize the Builder with
     */
    private Builder(GetProviderTypeInstanceOptions getProviderTypeInstanceOptions) {
      this.instanceId = getProviderTypeInstanceOptions.instanceId;
      this.providerTypeId = getProviderTypeInstanceOptions.providerTypeId;
      this.providerTypeInstanceId = getProviderTypeInstanceOptions.providerTypeInstanceId;
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
     * @param providerTypeId the providerTypeId
     * @param providerTypeInstanceId the providerTypeInstanceId
     */
    public Builder(String instanceId, String providerTypeId, String providerTypeInstanceId) {
      this.instanceId = instanceId;
      this.providerTypeId = providerTypeId;
      this.providerTypeInstanceId = providerTypeInstanceId;
    }

    /**
     * Builds a GetProviderTypeInstanceOptions.
     *
     * @return the new GetProviderTypeInstanceOptions instance
     */
    public GetProviderTypeInstanceOptions build() {
      return new GetProviderTypeInstanceOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the GetProviderTypeInstanceOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the providerTypeId.
     *
     * @param providerTypeId the providerTypeId
     * @return the GetProviderTypeInstanceOptions builder
     */
    public Builder providerTypeId(String providerTypeId) {
      this.providerTypeId = providerTypeId;
      return this;
    }

    /**
     * Set the providerTypeInstanceId.
     *
     * @param providerTypeInstanceId the providerTypeInstanceId
     * @return the GetProviderTypeInstanceOptions builder
     */
    public Builder providerTypeInstanceId(String providerTypeInstanceId) {
      this.providerTypeInstanceId = providerTypeInstanceId;
      return this;
    }
  }

  protected GetProviderTypeInstanceOptions() { }

  protected GetProviderTypeInstanceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.providerTypeId,
      "providerTypeId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.providerTypeInstanceId,
      "providerTypeInstanceId cannot be empty");
    instanceId = builder.instanceId;
    providerTypeId = builder.providerTypeId;
    providerTypeInstanceId = builder.providerTypeInstanceId;
  }

  /**
   * New builder.
   *
   * @return a GetProviderTypeInstanceOptions builder
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
   * Gets the providerTypeId.
   *
   * The provider type ID.
   *
   * @return the providerTypeId
   */
  public String providerTypeId() {
    return providerTypeId;
  }

  /**
   * Gets the providerTypeInstanceId.
   *
   * The provider type instance ID.
   *
   * @return the providerTypeInstanceId
   */
  public String providerTypeInstanceId() {
    return providerTypeInstanceId;
  }
}

