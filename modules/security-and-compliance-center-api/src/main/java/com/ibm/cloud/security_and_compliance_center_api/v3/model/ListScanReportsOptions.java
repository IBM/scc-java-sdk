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
 * The listScanReports options.
 */
public class ListScanReportsOptions extends GenericModel {

  /**
   * This field sorts results by using a valid sort field.
   */
  public interface Sort {
    /** status. */
    String STATUS = "status";
    /** scope_id. */
    String SCOPE_ID = "scope_id";
    /** subscope_id. */
    String SUBSCOPE_ID = "subscope_id";
    /** created_on. */
    String CREATED_ON = "created_on";
  }

  protected String instanceId;
  protected String reportId;
  protected String scopeId;
  protected String subscopeId;
  protected String sort;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String reportId;
    private String scopeId;
    private String subscopeId;
    private String sort;

    /**
     * Instantiates a new Builder from an existing ListScanReportsOptions instance.
     *
     * @param listScanReportsOptions the instance to initialize the Builder with
     */
    private Builder(ListScanReportsOptions listScanReportsOptions) {
      this.instanceId = listScanReportsOptions.instanceId;
      this.reportId = listScanReportsOptions.reportId;
      this.scopeId = listScanReportsOptions.scopeId;
      this.subscopeId = listScanReportsOptions.subscopeId;
      this.sort = listScanReportsOptions.sort;
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
     * Builds a ListScanReportsOptions.
     *
     * @return the new ListScanReportsOptions instance
     */
    public ListScanReportsOptions build() {
      return new ListScanReportsOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ListScanReportsOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the reportId.
     *
     * @param reportId the reportId
     * @return the ListScanReportsOptions builder
     */
    public Builder reportId(String reportId) {
      this.reportId = reportId;
      return this;
    }

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the ListScanReportsOptions builder
     */
    public Builder scopeId(String scopeId) {
      this.scopeId = scopeId;
      return this;
    }

    /**
     * Set the subscopeId.
     *
     * @param subscopeId the subscopeId
     * @return the ListScanReportsOptions builder
     */
    public Builder subscopeId(String subscopeId) {
      this.subscopeId = subscopeId;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListScanReportsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }
  }

  protected ListScanReportsOptions() { }

  protected ListScanReportsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.reportId,
      "reportId cannot be empty");
    instanceId = builder.instanceId;
    reportId = builder.reportId;
    scopeId = builder.scopeId;
    subscopeId = builder.subscopeId;
    sort = builder.sort;
  }

  /**
   * New builder.
   *
   * @return a ListScanReportsOptions builder
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

