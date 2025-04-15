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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The request body to make a Scope.
 */
public class ScopePrototype extends GenericModel {

  protected String name;
  protected String description;
  protected String environment;
  @SerializedName("properties")
  protected List<ScopeProperty> xProperties;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String description;
    private String environment;
    private List<ScopeProperty> xProperties;

    /**
     * Instantiates a new Builder from an existing ScopePrototype instance.
     *
     * @param scopePrototype the instance to initialize the Builder with
     */
    private Builder(ScopePrototype scopePrototype) {
      this.name = scopePrototype.name;
      this.description = scopePrototype.description;
      this.environment = scopePrototype.environment;
      this.xProperties = scopePrototype.xProperties;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ScopePrototype.
     *
     * @return the new ScopePrototype instance
     */
    public ScopePrototype build() {
      return new ScopePrototype(this);
    }

    /**
     * Adds a new element to xProperties.
     *
     * @param xProperties the new element to be added
     * @return the ScopePrototype builder
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
     * Set the name.
     *
     * @param name the name
     * @return the ScopePrototype builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ScopePrototype builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the environment.
     *
     * @param environment the environment
     * @return the ScopePrototype builder
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
     * @return the ScopePrototype builder
     */
    public Builder xProperties(List<ScopeProperty> xProperties) {
      this.xProperties = xProperties;
      return this;
    }
  }

  protected ScopePrototype() { }

  protected ScopePrototype(Builder builder) {
    name = builder.name;
    description = builder.description;
    environment = builder.environment;
    xProperties = builder.xProperties;
  }

  /**
   * New builder.
   *
   * @return a ScopePrototype builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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

