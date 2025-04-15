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
 * The deleteScope options.
 */
public class DeleteScopeOptions extends GenericModel {

  protected String instanceId;
  protected String scopeId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String scopeId;

    /**
     * Instantiates a new Builder from an existing DeleteScopeOptions instance.
     *
     * @param deleteScopeOptions the instance to initialize the Builder with
     */
    private Builder(DeleteScopeOptions deleteScopeOptions) {
      this.instanceId = deleteScopeOptions.instanceId;
      this.scopeId = deleteScopeOptions.scopeId;
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
     * @param scopeId the scopeId
     */
    public Builder(String instanceId, String scopeId) {
      this.instanceId = instanceId;
      this.scopeId = scopeId;
    }

    /**
     * Builds a DeleteScopeOptions.
     *
     * @return the new DeleteScopeOptions instance
     */
    public DeleteScopeOptions build() {
      return new DeleteScopeOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the DeleteScopeOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the DeleteScopeOptions builder
     */
    public Builder scopeId(String scopeId) {
      this.scopeId = scopeId;
      return this;
    }
  }

  protected DeleteScopeOptions() { }

  protected DeleteScopeOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.scopeId,
      "scopeId cannot be empty");
    instanceId = builder.instanceId;
    scopeId = builder.scopeId;
  }

  /**
   * New builder.
   *
   * @return a DeleteScopeOptions builder
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
   * Gets the scopeId.
   *
   * The ID of the scope being targeted.
   *
   * @return the scopeId
   */
  public String scopeId() {
    return scopeId;
  }
}

