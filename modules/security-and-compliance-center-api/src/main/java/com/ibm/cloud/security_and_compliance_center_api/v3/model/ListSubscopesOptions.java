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
 * The listSubscopes options.
 */
public class ListSubscopesOptions extends GenericModel {

  protected String instanceId;
  protected String scopeId;
  protected Long limit;
  protected String start;
  protected String name;
  protected String description;
  protected String environment;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String scopeId;
    private Long limit;
    private String start;
    private String name;
    private String description;
    private String environment;

    /**
     * Instantiates a new Builder from an existing ListSubscopesOptions instance.
     *
     * @param listSubscopesOptions the instance to initialize the Builder with
     */
    private Builder(ListSubscopesOptions listSubscopesOptions) {
      this.instanceId = listSubscopesOptions.instanceId;
      this.scopeId = listSubscopesOptions.scopeId;
      this.limit = listSubscopesOptions.limit;
      this.start = listSubscopesOptions.start;
      this.name = listSubscopesOptions.name;
      this.description = listSubscopesOptions.description;
      this.environment = listSubscopesOptions.environment;
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
     * Builds a ListSubscopesOptions.
     *
     * @return the new ListSubscopesOptions instance
     */
    public ListSubscopesOptions build() {
      return new ListSubscopesOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ListSubscopesOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the ListSubscopesOptions builder
     */
    public Builder scopeId(String scopeId) {
      this.scopeId = scopeId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListSubscopesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListSubscopesOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListSubscopesOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ListSubscopesOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the environment.
     *
     * @param environment the environment
     * @return the ListSubscopesOptions builder
     */
    public Builder environment(String environment) {
      this.environment = environment;
      return this;
    }
  }

  protected ListSubscopesOptions() { }

  protected ListSubscopesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.scopeId,
      "scopeId cannot be empty");
    instanceId = builder.instanceId;
    scopeId = builder.scopeId;
    limit = builder.limit;
    start = builder.start;
    name = builder.name;
    description = builder.description;
    environment = builder.environment;
  }

  /**
   * New builder.
   *
   * @return a ListSubscopesOptions builder
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
   * Gets the limit.
   *
   * The indication of how many resources to return, unless the response is the last page of resources.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the start.
   *
   * Determine what resource to start the page on or after.
   *
   * @return the start
   */
  public String start() {
    return start;
  }

  /**
   * Gets the name.
   *
   * determine name of subscope returned in response.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * determine descriptions of subscopes returned in response.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the environment.
   *
   * determine environment of subscopes returned in response.
   *
   * @return the environment
   */
  public String environment() {
    return environment;
  }
}

