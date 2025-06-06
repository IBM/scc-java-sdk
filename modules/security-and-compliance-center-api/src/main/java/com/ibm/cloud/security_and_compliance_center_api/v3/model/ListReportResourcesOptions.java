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
 * The listReportResources options.
 */
public class ListReportResourcesOptions extends GenericModel {

  /**
   * The compliance status value.
   */
  public interface Status {
    /** compliant. */
    String COMPLIANT = "compliant";
    /** not_compliant. */
    String NOT_COMPLIANT = "not_compliant";
    /** unable_to_perform. */
    String UNABLE_TO_PERFORM = "unable_to_perform";
    /** user_evaluation_required. */
    String USER_EVALUATION_REQUIRED = "user_evaluation_required";
    /** not_applicable. */
    String NOT_APPLICABLE = "not_applicable";
  }

  /**
   * This field sorts resources by using a valid sort field. To learn more, see
   * [Sorting](https://cloud.ibm.com/docs/api-handbook?topic=api-handbook-sorting).
   */
  public interface Sort {
    /** account_id. */
    String ACCOUNT_ID = "account_id";
    /** component_id. */
    String COMPONENT_ID = "component_id";
    /** resource_name. */
    String RESOURCE_NAME = "resource_name";
    /** status. */
    String STATUS = "status";
  }

  protected String instanceId;
  protected String reportId;
  protected String id;
  protected String resourceName;
  protected String accountId;
  protected String componentId;
  protected String status;
  protected String sort;
  protected String start;
  protected Long limit;
  protected String scopeId;
  protected String subscopeId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String reportId;
    private String id;
    private String resourceName;
    private String accountId;
    private String componentId;
    private String status;
    private String sort;
    private String start;
    private Long limit;
    private String scopeId;
    private String subscopeId;

    /**
     * Instantiates a new Builder from an existing ListReportResourcesOptions instance.
     *
     * @param listReportResourcesOptions the instance to initialize the Builder with
     */
    private Builder(ListReportResourcesOptions listReportResourcesOptions) {
      this.instanceId = listReportResourcesOptions.instanceId;
      this.reportId = listReportResourcesOptions.reportId;
      this.id = listReportResourcesOptions.id;
      this.resourceName = listReportResourcesOptions.resourceName;
      this.accountId = listReportResourcesOptions.accountId;
      this.componentId = listReportResourcesOptions.componentId;
      this.status = listReportResourcesOptions.status;
      this.sort = listReportResourcesOptions.sort;
      this.start = listReportResourcesOptions.start;
      this.limit = listReportResourcesOptions.limit;
      this.scopeId = listReportResourcesOptions.scopeId;
      this.subscopeId = listReportResourcesOptions.subscopeId;
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
     * @param reportId the reportId
     */
    public Builder(String instanceId, String reportId) {
      this.instanceId = instanceId;
      this.reportId = reportId;
    }

    /**
     * Builds a ListReportResourcesOptions.
     *
     * @return the new ListReportResourcesOptions instance
     */
    public ListReportResourcesOptions build() {
      return new ListReportResourcesOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ListReportResourcesOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the reportId.
     *
     * @param reportId the reportId
     * @return the ListReportResourcesOptions builder
     */
    public Builder reportId(String reportId) {
      this.reportId = reportId;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ListReportResourcesOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the resourceName.
     *
     * @param resourceName the resourceName
     * @return the ListReportResourcesOptions builder
     */
    public Builder resourceName(String resourceName) {
      this.resourceName = resourceName;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListReportResourcesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the componentId.
     *
     * @param componentId the componentId
     * @return the ListReportResourcesOptions builder
     */
    public Builder componentId(String componentId) {
      this.componentId = componentId;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the ListReportResourcesOptions builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListReportResourcesOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListReportResourcesOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListReportResourcesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the ListReportResourcesOptions builder
     */
    public Builder scopeId(String scopeId) {
      this.scopeId = scopeId;
      return this;
    }

    /**
     * Set the subscopeId.
     *
     * @param subscopeId the subscopeId
     * @return the ListReportResourcesOptions builder
     */
    public Builder subscopeId(String subscopeId) {
      this.subscopeId = subscopeId;
      return this;
    }
  }

  protected ListReportResourcesOptions() { }

  protected ListReportResourcesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.reportId,
      "reportId cannot be empty");
    instanceId = builder.instanceId;
    reportId = builder.reportId;
    id = builder.id;
    resourceName = builder.resourceName;
    accountId = builder.accountId;
    componentId = builder.componentId;
    status = builder.status;
    sort = builder.sort;
    start = builder.start;
    limit = builder.limit;
    scopeId = builder.scopeId;
    subscopeId = builder.subscopeId;
  }

  /**
   * New builder.
   *
   * @return a ListReportResourcesOptions builder
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
   * Gets the reportId.
   *
   * The ID of the scan that is associated with a report.
   *
   * @return the reportId
   */
  public String reportId() {
    return reportId;
  }

  /**
   * Gets the id.
   *
   * The ID of the resource.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the resourceName.
   *
   * The name of the resource.
   *
   * @return the resourceName
   */
  public String resourceName() {
    return resourceName;
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
   * Gets the componentId.
   *
   * The ID of component.
   *
   * @return the componentId
   */
  public String componentId() {
    return componentId;
  }

  /**
   * Gets the status.
   *
   * The compliance status value.
   *
   * @return the status
   */
  public String status() {
    return status;
  }

  /**
   * Gets the sort.
   *
   * This field sorts resources by using a valid sort field. To learn more, see
   * [Sorting](https://cloud.ibm.com/docs/api-handbook?topic=api-handbook-sorting).
   *
   * @return the sort
   */
  public String sort() {
    return sort;
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
   * Gets the scopeId.
   *
   * The ID of the scope.
   *
   * @return the scopeId
   */
  public String scopeId() {
    return scopeId;
  }

  /**
   * Gets the subscopeId.
   *
   * The ID of the subscope.
   *
   * @return the subscopeId
   */
  public String subscopeId() {
    return subscopeId;
  }
}

