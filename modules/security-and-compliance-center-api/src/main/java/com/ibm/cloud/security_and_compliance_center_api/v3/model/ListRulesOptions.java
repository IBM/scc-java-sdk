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
 * The listRules options.
 */
public class ListRulesOptions extends GenericModel {

  /**
   * The list of only user-defined, or system-defined rules.
   */
  public interface Type {
    /** user_defined. */
    String USER_DEFINED = "user_defined";
    /** system_defined. */
    String SYSTEM_DEFINED = "system_defined";
  }

  /**
   * Field used to sort rules. Rules can be sorted in ascending or descending order.
   */
  public interface Sort {
    /** description. */
    String DESCRIPTION = "description";
    /** service_display_name. */
    String SERVICE_DISPLAY_NAME = "service_display_name";
    /** type. */
    String TYPE = "type";
    /** updated_on. */
    String UPDATED_ON = "updated_on";
  }

  protected String instanceId;
  protected Long limit;
  protected String start;
  protected String type;
  protected String search;
  protected String serviceName;
  protected String sort;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private Long limit;
    private String start;
    private String type;
    private String search;
    private String serviceName;
    private String sort;

    /**
     * Instantiates a new Builder from an existing ListRulesOptions instance.
     *
     * @param listRulesOptions the instance to initialize the Builder with
     */
    private Builder(ListRulesOptions listRulesOptions) {
      this.instanceId = listRulesOptions.instanceId;
      this.limit = listRulesOptions.limit;
      this.start = listRulesOptions.start;
      this.type = listRulesOptions.type;
      this.search = listRulesOptions.search;
      this.serviceName = listRulesOptions.serviceName;
      this.sort = listRulesOptions.sort;
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
     * Builds a ListRulesOptions.
     *
     * @return the new ListRulesOptions instance
     */
    public ListRulesOptions build() {
      return new ListRulesOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ListRulesOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListRulesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListRulesOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ListRulesOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the search.
     *
     * @param search the search
     * @return the ListRulesOptions builder
     */
    public Builder search(String search) {
      this.search = search;
      return this;
    }

    /**
     * Set the serviceName.
     *
     * @param serviceName the serviceName
     * @return the ListRulesOptions builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListRulesOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }
  }

  protected ListRulesOptions() { }

  protected ListRulesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    limit = builder.limit;
    start = builder.start;
    type = builder.type;
    search = builder.search;
    serviceName = builder.serviceName;
    sort = builder.sort;
  }

  /**
   * New builder.
   *
   * @return a ListRulesOptions builder
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
   * Gets the type.
   *
   * The list of only user-defined, or system-defined rules.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the search.
   *
   * The indication of whether to search for rules with a specific string string in the name, description, or labels.
   *
   * @return the search
   */
  public String search() {
    return search;
  }

  /**
   * Gets the serviceName.
   *
   * Searches for rules targeting corresponding service.
   *
   * @return the serviceName
   */
  public String serviceName() {
    return serviceName;
  }

  /**
   * Gets the sort.
   *
   * Field used to sort rules. Rules can be sorted in ascending or descending order.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }
}

