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
package com.ibm.cloud.security_and_compliance_center_api.v3.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The scope payload for the multi cloud feature.
 */
public class MultiCloudScope extends GenericModel {

  protected String environment;
  @SerializedName("properties")
  protected List<PropertyItem> xProperties;

  /**
   * Builder.
   */
  public static class Builder {
    private String environment;
    private List<PropertyItem> xProperties;

    /**
     * Instantiates a new Builder from an existing MultiCloudScope instance.
     *
     * @param multiCloudScope the instance to initialize the Builder with
     */
    private Builder(MultiCloudScope multiCloudScope) {
      this.environment = multiCloudScope.environment;
      this.xProperties = multiCloudScope.xProperties;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environment the environment
     * @param xProperties the xProperties
     */
    public Builder(String environment, List<PropertyItem> xProperties) {
      this.environment = environment;
      this.xProperties = xProperties;
    }

    /**
     * Builds a MultiCloudScope.
     *
     * @return the new MultiCloudScope instance
     */
    public MultiCloudScope build() {
      return new MultiCloudScope(this);
    }

    /**
     * Adds an xProperties to xProperties.
     *
     * @param xProperties the new xProperties
     * @return the MultiCloudScope builder
     */
    public Builder addXProperties(PropertyItem xProperties) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(xProperties,
        "xProperties cannot be null");
      if (this.xProperties == null) {
        this.xProperties = new ArrayList<PropertyItem>();
      }
      this.xProperties.add(xProperties);
      return this;
    }

    /**
     * Set the environment.
     *
     * @param environment the environment
     * @return the MultiCloudScope builder
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
     * @return the MultiCloudScope builder
     */
    public Builder xProperties(List<PropertyItem> xProperties) {
      this.xProperties = xProperties;
      return this;
    }
  }

  protected MultiCloudScope() { }

  protected MultiCloudScope(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.environment,
      "environment cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.xProperties,
      "xProperties cannot be null");
    environment = builder.environment;
    xProperties = builder.xProperties;
  }

  /**
   * New builder.
   *
   * @return a MultiCloudScope builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environment.
   *
   * The environment that relates to this scope.
   *
   * @return the environment
   */
  public String environment() {
    return environment;
  }

  /**
   * Gets the xProperties.
   *
   * The properties supported for scoping by this environment.
   *
   * @return the xProperties
   */
  public List<PropertyItem> xProperties() {
    return xProperties;
  }
}

