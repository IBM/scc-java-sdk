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
 * The listReports options.
 */
public class ListReportsOptions extends GenericModel {

  /**
   * The type of the scan.
   */
  public interface Type {
    /** ondemand. */
    String ONDEMAND = "ondemand";
    /** scheduled. */
    String SCHEDULED = "scheduled";
  }

  /**
   * This field sorts results by using a valid sort field.
   */
  public interface Sort {
    /** profile_name. */
    String PROFILE_NAME = "profile_name";
    /** scope_id. */
    String SCOPE_ID = "scope_id";
    /** group_id. */
    String GROUP_ID = "group_id";
    /** created_on. */
    String CREATED_ON = "created_on";
    /** type. */
    String TYPE = "type";
  }

  protected String instanceId;
  protected String reportAttachmentId;
  protected String groupId;
  protected String reportProfileId;
  protected String type;
  protected String start;
  protected Long limit;
  protected String sort;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String reportAttachmentId;
    private String groupId;
    private String reportProfileId;
    private String type;
    private String start;
    private Long limit;
    private String sort;

    /**
     * Instantiates a new Builder from an existing ListReportsOptions instance.
     *
     * @param listReportsOptions the instance to initialize the Builder with
     */
    private Builder(ListReportsOptions listReportsOptions) {
      this.instanceId = listReportsOptions.instanceId;
      this.reportAttachmentId = listReportsOptions.reportAttachmentId;
      this.groupId = listReportsOptions.groupId;
      this.reportProfileId = listReportsOptions.reportProfileId;
      this.type = listReportsOptions.type;
      this.start = listReportsOptions.start;
      this.limit = listReportsOptions.limit;
      this.sort = listReportsOptions.sort;
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
     * Builds a ListReportsOptions.
     *
     * @return the new ListReportsOptions instance
     */
    public ListReportsOptions build() {
      return new ListReportsOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ListReportsOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the reportAttachmentId.
     *
     * @param reportAttachmentId the reportAttachmentId
     * @return the ListReportsOptions builder
     */
    public Builder reportAttachmentId(String reportAttachmentId) {
      this.reportAttachmentId = reportAttachmentId;
      return this;
    }

    /**
     * Set the groupId.
     *
     * @param groupId the groupId
     * @return the ListReportsOptions builder
     */
    public Builder groupId(String groupId) {
      this.groupId = groupId;
      return this;
    }

    /**
     * Set the reportProfileId.
     *
     * @param reportProfileId the reportProfileId
     * @return the ListReportsOptions builder
     */
    public Builder reportProfileId(String reportProfileId) {
      this.reportProfileId = reportProfileId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ListReportsOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListReportsOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListReportsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListReportsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }
  }

  protected ListReportsOptions() { }

  protected ListReportsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    reportAttachmentId = builder.reportAttachmentId;
    groupId = builder.groupId;
    reportProfileId = builder.reportProfileId;
    type = builder.type;
    start = builder.start;
    limit = builder.limit;
    sort = builder.sort;
  }

  /**
   * New builder.
   *
   * @return a ListReportsOptions builder
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
   * Gets the reportAttachmentId.
   *
   * The ID of the attachment.
   *
   * @return the reportAttachmentId
   */
  public String reportAttachmentId() {
    return reportAttachmentId;
  }

  /**
   * Gets the groupId.
   *
   * The report group ID.
   *
   * @return the groupId
   */
  public String groupId() {
    return groupId;
  }

  /**
   * Gets the reportProfileId.
   *
   * The ID of the profile.
   *
   * @return the reportProfileId
   */
  public String reportProfileId() {
    return reportProfileId;
  }

  /**
   * Gets the type.
   *
   * The type of the scan.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the start.
   *
   * The indication of what resource to start the page on.
   *
   * @return the start
   */
  public String start() {
    return start;
  }

  /**
   * Gets the limit.
   *
   * The indication of many resources to return, unless the response is the last page of resources.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the sort.
   *
   * This field sorts results by using a valid sort field.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }
}

