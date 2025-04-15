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

/**
 * The payload to create a new Scope from a Profile Attachment.
 */
public class MultiCloudScopePayloadByProperties extends MultiCloudScopePayload {


  /**
   * Builder.
   */
  public static class Builder {
    private String description;
    private String environment;
    private List<ScopeProperty> xProperties;

    /**
     * Instantiates a new Builder from an existing MultiCloudScopePayloadByProperties instance.
     *
     * @param multiCloudScopePayloadByProperties the instance to initialize the Builder with
     */
    public Builder(MultiCloudScopePayload multiCloudScopePayloadByProperties) {
      this.description = multiCloudScopePayloadByProperties.description;
      this.environment = multiCloudScopePayloadByProperties.environment;
      this.xProperties = multiCloudScopePayloadByProperties.xProperties;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param xProperties the xProperties
     */
    public Builder(List<ScopeProperty> xProperties) {
      this.xProperties = xProperties;
    }

    /**
     * Builds a MultiCloudScopePayloadByProperties.
     *
     * @return the new MultiCloudScopePayloadByProperties instance
     */
    public MultiCloudScopePayloadByProperties build() {
      return new MultiCloudScopePayloadByProperties(this);
    }

    /**
     * Adds a new element to xProperties.
     *
     * @param xProperties the new element to be added
     * @return the MultiCloudScopePayloadByProperties builder
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
     * Set the description.
     *
     * @param description the description
     * @return the MultiCloudScopePayloadByProperties builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the environment.
     *
     * @param environment the environment
     * @return the MultiCloudScopePayloadByProperties builder
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
     * @return the MultiCloudScopePayloadByProperties builder
     */
    public Builder xProperties(List<ScopeProperty> xProperties) {
      this.xProperties = xProperties;
      return this;
    }
  }

  protected MultiCloudScopePayloadByProperties() { }

  protected MultiCloudScopePayloadByProperties(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.xProperties,
      "xProperties cannot be null");
    description = builder.description;
    environment = builder.environment;
    xProperties = builder.xProperties;
  }

  /**
   * New builder.
   *
   * @return a MultiCloudScopePayloadByProperties builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

