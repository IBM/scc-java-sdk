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
 * The getReportViolationsDrift options.
 */
public class GetReportViolationsDriftOptions extends GenericModel {

  protected String instanceId;
  protected String reportId;
  protected Long scanTimeDuration;
  protected String scopeId;
  protected String subscopeId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String reportId;
    private Long scanTimeDuration;
    private String scopeId;
    private String subscopeId;

    /**
     * Instantiates a new Builder from an existing GetReportViolationsDriftOptions instance.
     *
     * @param getReportViolationsDriftOptions the instance to initialize the Builder with
     */
    private Builder(GetReportViolationsDriftOptions getReportViolationsDriftOptions) {
      this.instanceId = getReportViolationsDriftOptions.instanceId;
      this.reportId = getReportViolationsDriftOptions.reportId;
      this.scanTimeDuration = getReportViolationsDriftOptions.scanTimeDuration;
      this.scopeId = getReportViolationsDriftOptions.scopeId;
      this.subscopeId = getReportViolationsDriftOptions.subscopeId;
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
     * Builds a GetReportViolationsDriftOptions.
     *
     * @return the new GetReportViolationsDriftOptions instance
     */
    public GetReportViolationsDriftOptions build() {
      return new GetReportViolationsDriftOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the GetReportViolationsDriftOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the reportId.
     *
     * @param reportId the reportId
     * @return the GetReportViolationsDriftOptions builder
     */
    public Builder reportId(String reportId) {
      this.reportId = reportId;
      return this;
    }

    /**
     * Set the scanTimeDuration.
     *
     * @param scanTimeDuration the scanTimeDuration
     * @return the GetReportViolationsDriftOptions builder
     */
    public Builder scanTimeDuration(long scanTimeDuration) {
      this.scanTimeDuration = scanTimeDuration;
      return this;
    }

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the GetReportViolationsDriftOptions builder
     */
    public Builder scopeId(String scopeId) {
      this.scopeId = scopeId;
      return this;
    }

    /**
     * Set the subscopeId.
     *
     * @param subscopeId the subscopeId
     * @return the GetReportViolationsDriftOptions builder
     */
    public Builder subscopeId(String subscopeId) {
      this.subscopeId = subscopeId;
      return this;
    }
  }

  protected GetReportViolationsDriftOptions() { }

  protected GetReportViolationsDriftOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.reportId,
      "reportId cannot be empty");
    instanceId = builder.instanceId;
    reportId = builder.reportId;
    scanTimeDuration = builder.scanTimeDuration;
    scopeId = builder.scopeId;
    subscopeId = builder.subscopeId;
  }

  /**
   * New builder.
   *
   * @return a GetReportViolationsDriftOptions builder
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
   * Gets the scanTimeDuration.
   *
   * The duration of the `scan_time` timestamp in number of days.
   *
   * @return the scanTimeDuration
   */
  public Long scanTimeDuration() {
    return scanTimeDuration;
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

