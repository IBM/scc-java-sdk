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
 * The listControlLibraries options.
 */
public class ListControlLibrariesOptions extends GenericModel {

  protected String instanceId;
  protected String accountId;
  protected Long limit;
  protected String start;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String accountId;
    private Long limit;
    private String start;

    /**
     * Instantiates a new Builder from an existing ListControlLibrariesOptions instance.
     *
     * @param listControlLibrariesOptions the instance to initialize the Builder with
     */
    private Builder(ListControlLibrariesOptions listControlLibrariesOptions) {
      this.instanceId = listControlLibrariesOptions.instanceId;
      this.accountId = listControlLibrariesOptions.accountId;
      this.limit = listControlLibrariesOptions.limit;
      this.start = listControlLibrariesOptions.start;
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
     * Builds a ListControlLibrariesOptions.
     *
     * @return the new ListControlLibrariesOptions instance
     */
    public ListControlLibrariesOptions build() {
      return new ListControlLibrariesOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ListControlLibrariesOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListControlLibrariesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListControlLibrariesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListControlLibrariesOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }
  }

  protected ListControlLibrariesOptions() { }

  protected ListControlLibrariesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    accountId = builder.accountId;
    limit = builder.limit;
    start = builder.start;
  }

  /**
   * New builder.
   *
   * @return a ListControlLibrariesOptions builder
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
   * Gets the accountId.
   *
   * The user account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
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
}

