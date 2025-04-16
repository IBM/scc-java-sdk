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
 * The createSubscope options.
 */
public class CreateSubscopeOptions extends GenericModel {

  protected String instanceId;
  protected String scopeId;
  protected List<ScopePrototype> subscopes;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String scopeId;
    private List<ScopePrototype> subscopes;

    /**
     * Instantiates a new Builder from an existing CreateSubscopeOptions instance.
     *
     * @param createSubscopeOptions the instance to initialize the Builder with
     */
    private Builder(CreateSubscopeOptions createSubscopeOptions) {
      this.instanceId = createSubscopeOptions.instanceId;
      this.scopeId = createSubscopeOptions.scopeId;
      this.subscopes = createSubscopeOptions.subscopes;
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
     * @param subscopes the subscopes
     */
    public Builder(String instanceId, String scopeId, List<ScopePrototype> subscopes) {
      this.instanceId = instanceId;
      this.scopeId = scopeId;
      this.subscopes = subscopes;
    }

    /**
     * Builds a CreateSubscopeOptions.
     *
     * @return the new CreateSubscopeOptions instance
     */
    public CreateSubscopeOptions build() {
      return new CreateSubscopeOptions(this);
    }

    /**
     * Adds a new element to subscopes.
     *
     * @param subscopes the new element to be added
     * @return the CreateSubscopeOptions builder
     */
    public Builder addSubscopes(ScopePrototype subscopes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(subscopes,
        "subscopes cannot be null");
      if (this.subscopes == null) {
        this.subscopes = new ArrayList<ScopePrototype>();
      }
      this.subscopes.add(subscopes);
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the CreateSubscopeOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the CreateSubscopeOptions builder
     */
    public Builder scopeId(String scopeId) {
      this.scopeId = scopeId;
      return this;
    }

    /**
     * Set the subscopes.
     * Existing subscopes will be replaced.
     *
     * @param subscopes the subscopes
     * @return the CreateSubscopeOptions builder
     */
    public Builder subscopes(List<ScopePrototype> subscopes) {
      this.subscopes = subscopes;
      return this;
    }
  }

  protected CreateSubscopeOptions() { }

  protected CreateSubscopeOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.scopeId,
      "scopeId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.subscopes,
      "subscopes cannot be null");
    instanceId = builder.instanceId;
    scopeId = builder.scopeId;
    subscopes = builder.subscopes;
  }

  /**
   * New builder.
   *
   * @return a CreateSubscopeOptions builder
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
   * Gets the subscopes.
   *
   * The array of subscopes.
   *
   * @return the subscopes
   */
  public List<ScopePrototype> subscopes() {
    return subscopes;
  }
}

