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
 * The listScopes options.
 */
public class ListScopesOptions extends GenericModel {

  protected String instanceId;
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
    private Long limit;
    private String start;
    private String name;
    private String description;
    private String environment;

    /**
     * Instantiates a new Builder from an existing ListScopesOptions instance.
     *
     * @param listScopesOptions the instance to initialize the Builder with
     */
    private Builder(ListScopesOptions listScopesOptions) {
      this.instanceId = listScopesOptions.instanceId;
      this.limit = listScopesOptions.limit;
      this.start = listScopesOptions.start;
      this.name = listScopesOptions.name;
      this.description = listScopesOptions.description;
      this.environment = listScopesOptions.environment;
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
     * Builds a ListScopesOptions.
     *
     * @return the new ListScopesOptions instance
     */
    public ListScopesOptions build() {
      return new ListScopesOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ListScopesOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListScopesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListScopesOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListScopesOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ListScopesOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the environment.
     *
     * @param environment the environment
     * @return the ListScopesOptions builder
     */
    public Builder environment(String environment) {
      this.environment = environment;
      return this;
    }
  }

  protected ListScopesOptions() { }

  protected ListScopesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    limit = builder.limit;
    start = builder.start;
    name = builder.name;
    description = builder.description;
    environment = builder.environment;
  }

  /**
   * New builder.
   *
   * @return a ListScopesOptions builder
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
   * determine name of scope returned in response.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * determine descriptions of scope returned in response.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the environment.
   *
   * determine environment of scopes returned in response.
   *
   * @return the environment
   */
  public String environment() {
    return environment;
  }
}

