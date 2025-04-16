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
 * The updateScope options.
 */
public class UpdateScopeOptions extends GenericModel {

  protected String instanceId;
  protected String scopeId;
  protected String name;
  protected String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String scopeId;
    private String name;
    private String description;

    /**
     * Instantiates a new Builder from an existing UpdateScopeOptions instance.
     *
     * @param updateScopeOptions the instance to initialize the Builder with
     */
    private Builder(UpdateScopeOptions updateScopeOptions) {
      this.instanceId = updateScopeOptions.instanceId;
      this.scopeId = updateScopeOptions.scopeId;
      this.name = updateScopeOptions.name;
      this.description = updateScopeOptions.description;
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
     * Builds a UpdateScopeOptions.
     *
     * @return the new UpdateScopeOptions instance
     */
    public UpdateScopeOptions build() {
      return new UpdateScopeOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the UpdateScopeOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the UpdateScopeOptions builder
     */
    public Builder scopeId(String scopeId) {
      this.scopeId = scopeId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateScopeOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateScopeOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected UpdateScopeOptions() { }

  protected UpdateScopeOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.scopeId,
      "scopeId cannot be empty");
    instanceId = builder.instanceId;
    scopeId = builder.scopeId;
    name = builder.name;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a UpdateScopeOptions builder
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
   * Gets the name.
   *
   * The scope name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The scope description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

