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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createScope options.
 */
public class CreateScopeOptions extends GenericModel {

  protected String instanceId;
  protected String name;
  protected String description;
  protected String environment;
  protected List<ScopeProperty> xProperties;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String name;
    private String description;
    private String environment;
    private List<ScopeProperty> xProperties;

    /**
     * Instantiates a new Builder from an existing CreateScopeOptions instance.
     *
     * @param createScopeOptions the instance to initialize the Builder with
     */
    private Builder(CreateScopeOptions createScopeOptions) {
      this.instanceId = createScopeOptions.instanceId;
      this.name = createScopeOptions.name;
      this.description = createScopeOptions.description;
      this.environment = createScopeOptions.environment;
      this.xProperties = createScopeOptions.xProperties;
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
     * Builds a CreateScopeOptions.
     *
     * @return the new CreateScopeOptions instance
     */
    public CreateScopeOptions build() {
      return new CreateScopeOptions(this);
    }

    /**
     * Adds a new element to xProperties.
     *
     * @param xProperties the new element to be added
     * @return the CreateScopeOptions builder
     */
    public Builder addXProperties(ScopeProperty xProperties) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(xProperties,
        "xProperties cannot be null");
      if (this.xProperties == null) {
        this.xProperties = new ArrayList<ScopeProperty>();
      }
      this.xProperties.add(xProperties);
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the CreateScopeOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateScopeOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateScopeOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the environment.
     *
     * @param environment the environment
     * @return the CreateScopeOptions builder
     */
    public Builder environment(String environment) {
      this.environment = environment;
      return this;
    }

    /**
     * Set the xProperties.
     * Existing xProperties will be replaced.
     *
     * @param xProperties the xProperties
     * @return the CreateScopeOptions builder
     */
    public Builder xProperties(List<ScopeProperty> xProperties) {
      this.xProperties = xProperties;
      return this;
    }
  }

  protected CreateScopeOptions() { }

  protected CreateScopeOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    name = builder.name;
    description = builder.description;
    environment = builder.environment;
    xProperties = builder.xProperties;
  }

  /**
   * New builder.
   *
   * @return a CreateScopeOptions builder
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

  /**
   * Gets the environment.
   *
   * The scope environment.
   *
   * @return the environment
   */
  public String environment() {
    return environment;
  }

  /**
   * Gets the xProperties.
   *
   * The properties that are supported for scoping by this environment.
   *
   * @return the xProperties
   */
  public List<ScopeProperty> xProperties() {
    return xProperties;
  }
}

