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
 * The getScope options.
 */
public class GetScopeOptions extends GenericModel {

  protected String instanceId;
  protected String scopeId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String scopeId;

    /**
     * Instantiates a new Builder from an existing GetScopeOptions instance.
     *
     * @param getScopeOptions the instance to initialize the Builder with
     */
    private Builder(GetScopeOptions getScopeOptions) {
      this.instanceId = getScopeOptions.instanceId;
      this.scopeId = getScopeOptions.scopeId;
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
     * Builds a GetScopeOptions.
     *
     * @return the new GetScopeOptions instance
     */
    public GetScopeOptions build() {
      return new GetScopeOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the GetScopeOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the GetScopeOptions builder
     */
    public Builder scopeId(String scopeId) {
      this.scopeId = scopeId;
      return this;
    }
  }

  protected GetScopeOptions() { }

  protected GetScopeOptions(Builder builder) {
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
   * @return a GetScopeOptions builder
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

