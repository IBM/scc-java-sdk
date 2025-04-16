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
 * The getSubscope options.
 */
public class GetSubscopeOptions extends GenericModel {

  protected String instanceId;
  protected String scopeId;
  protected String subscopeId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String scopeId;
    private String subscopeId;

    /**
     * Instantiates a new Builder from an existing GetSubscopeOptions instance.
     *
     * @param getSubscopeOptions the instance to initialize the Builder with
     */
    private Builder(GetSubscopeOptions getSubscopeOptions) {
      this.instanceId = getSubscopeOptions.instanceId;
      this.scopeId = getSubscopeOptions.scopeId;
      this.subscopeId = getSubscopeOptions.subscopeId;
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
     * @param subscopeId the subscopeId
     */
    public Builder(String instanceId, String scopeId, String subscopeId) {
      this.instanceId = instanceId;
      this.scopeId = scopeId;
      this.subscopeId = subscopeId;
    }

    /**
     * Builds a GetSubscopeOptions.
     *
     * @return the new GetSubscopeOptions instance
     */
    public GetSubscopeOptions build() {
      return new GetSubscopeOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the GetSubscopeOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the GetSubscopeOptions builder
     */
    public Builder scopeId(String scopeId) {
      this.scopeId = scopeId;
      return this;
    }

    /**
     * Set the subscopeId.
     *
     * @param subscopeId the subscopeId
     * @return the GetSubscopeOptions builder
     */
    public Builder subscopeId(String subscopeId) {
      this.subscopeId = subscopeId;
      return this;
    }
  }

  protected GetSubscopeOptions() { }

  protected GetSubscopeOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.scopeId,
      "scopeId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.subscopeId,
      "subscopeId cannot be empty");
    instanceId = builder.instanceId;
    scopeId = builder.scopeId;
    subscopeId = builder.subscopeId;
  }

  /**
   * New builder.
   *
   * @return a GetSubscopeOptions builder
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

  /**
   * Gets the subscopeId.
   *
   * The ID of the scope being targeted.
   *
   * @return the subscopeId
   */
  public String subscopeId() {
    return subscopeId;
  }
}

