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
 * The listProviderTypeInstances options.
 */
public class ListProviderTypeInstancesOptions extends GenericModel {

  protected String instanceId;
  protected String providerTypeId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String providerTypeId;

    /**
     * Instantiates a new Builder from an existing ListProviderTypeInstancesOptions instance.
     *
     * @param listProviderTypeInstancesOptions the instance to initialize the Builder with
     */
    private Builder(ListProviderTypeInstancesOptions listProviderTypeInstancesOptions) {
      this.instanceId = listProviderTypeInstancesOptions.instanceId;
      this.providerTypeId = listProviderTypeInstancesOptions.providerTypeId;
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
     */
    public Builder(String instanceId, String providerTypeId) {
      this.instanceId = instanceId;
      this.providerTypeId = providerTypeId;
    }

    /**
     * Builds a ListProviderTypeInstancesOptions.
     *
     * @return the new ListProviderTypeInstancesOptions instance
     */
    public ListProviderTypeInstancesOptions build() {
      return new ListProviderTypeInstancesOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ListProviderTypeInstancesOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the providerTypeId.
     *
     * @param providerTypeId the providerTypeId
     * @return the ListProviderTypeInstancesOptions builder
     */
    public Builder providerTypeId(String providerTypeId) {
      this.providerTypeId = providerTypeId;
      return this;
    }
  }

  protected ListProviderTypeInstancesOptions() { }

  protected ListProviderTypeInstancesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.providerTypeId,
      "providerTypeId cannot be empty");
    instanceId = builder.instanceId;
    providerTypeId = builder.providerTypeId;
  }

  /**
   * New builder.
   *
   * @return a ListProviderTypeInstancesOptions builder
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
}

