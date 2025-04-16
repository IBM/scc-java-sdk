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
 * The listInstanceAttachments options.
 */
public class ListInstanceAttachmentsOptions extends GenericModel {

  /**
   * The sorted collection of attachments. The available values are `created_on` and `scope_type`.
   */
  public interface Sort {
    /** created_on. */
    String CREATED_ON = "created_on";
    /** scope_type. */
    String SCOPE_TYPE = "scope_type";
  }

  /**
   * The collection of attachments that is sorted in ascending order. To sort the collection in descending order, use
   * the `DESC` schema.
   */
  public interface Direction {
    /** desc. */
    String DESC = "desc";
    /** asc. */
    String ASC = "asc";
  }

  protected String instanceId;
  protected String accountId;
  protected String versionGroupLabel;
  protected Long limit;
  protected String sort;
  protected String direction;
  protected String start;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String accountId;
    private String versionGroupLabel;
    private Long limit;
    private String sort;
    private String direction;
    private String start;

    /**
     * Instantiates a new Builder from an existing ListInstanceAttachmentsOptions instance.
     *
     * @param listInstanceAttachmentsOptions the instance to initialize the Builder with
     */
    private Builder(ListInstanceAttachmentsOptions listInstanceAttachmentsOptions) {
      this.instanceId = listInstanceAttachmentsOptions.instanceId;
      this.accountId = listInstanceAttachmentsOptions.accountId;
      this.versionGroupLabel = listInstanceAttachmentsOptions.versionGroupLabel;
      this.limit = listInstanceAttachmentsOptions.limit;
      this.sort = listInstanceAttachmentsOptions.sort;
      this.direction = listInstanceAttachmentsOptions.direction;
      this.start = listInstanceAttachmentsOptions.start;
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
     * Builds a ListInstanceAttachmentsOptions.
     *
     * @return the new ListInstanceAttachmentsOptions instance
     */
    public ListInstanceAttachmentsOptions build() {
      return new ListInstanceAttachmentsOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ListInstanceAttachmentsOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListInstanceAttachmentsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the versionGroupLabel.
     *
     * @param versionGroupLabel the versionGroupLabel
     * @return the ListInstanceAttachmentsOptions builder
     */
    public Builder versionGroupLabel(String versionGroupLabel) {
      this.versionGroupLabel = versionGroupLabel;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListInstanceAttachmentsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListInstanceAttachmentsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the direction.
     *
     * @param direction the direction
     * @return the ListInstanceAttachmentsOptions builder
     */
    public Builder direction(String direction) {
      this.direction = direction;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListInstanceAttachmentsOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }
  }

  protected ListInstanceAttachmentsOptions() { }

  protected ListInstanceAttachmentsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    accountId = builder.accountId;
    versionGroupLabel = builder.versionGroupLabel;
    limit = builder.limit;
    sort = builder.sort;
    direction = builder.direction;
    start = builder.start;
  }

  /**
   * New builder.
   *
   * @return a ListInstanceAttachmentsOptions builder
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
   * Gets the versionGroupLabel.
   *
   * The profile version group label.
   *
   * @return the versionGroupLabel
   */
  public String versionGroupLabel() {
    return versionGroupLabel;
  }

  /**
   * Gets the limit.
   *
   * The number of items that are retrieved in a collection.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the sort.
   *
   * The sorted collection of attachments. The available values are `created_on` and `scope_type`.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }

  /**
   * Gets the direction.
   *
   * The collection of attachments that is sorted in ascending order. To sort the collection in descending order, use
   * the `DESC` schema.
   *
   * @return the direction
   */
  public String direction() {
    return direction;
  }

  /**
   * Gets the start.
   *
   * The reference to the first item in the results page. Take the value from the `next` field that is in the response
   * from the previous page.
   *
   * @return the start
   */
  public String start() {
    return start;
  }
}

