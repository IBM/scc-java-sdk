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
 * The getReport options.
 */
public class GetReportOptions extends GenericModel {

  protected String reportId;
  protected String instanceId;
  protected String scopeId;
  protected String subscopeId;

  /**
   * Builder.
   */
  public static class Builder {
    private String reportId;
    private String instanceId;
    private String scopeId;
    private String subscopeId;

    /**
     * Instantiates a new Builder from an existing GetReportOptions instance.
     *
     * @param getReportOptions the instance to initialize the Builder with
     */
    private Builder(GetReportOptions getReportOptions) {
      this.reportId = getReportOptions.reportId;
      this.instanceId = getReportOptions.instanceId;
      this.scopeId = getReportOptions.scopeId;
      this.subscopeId = getReportOptions.subscopeId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param reportId the reportId
     * @param instanceId the instanceId
     */
    public Builder(String reportId, String instanceId) {
      this.reportId = reportId;
      this.instanceId = instanceId;
    }

    /**
     * Builds a GetReportOptions.
     *
     * @return the new GetReportOptions instance
     */
    public GetReportOptions build() {
      return new GetReportOptions(this);
    }

    /**
     * Set the reportId.
     *
     * @param reportId the reportId
     * @return the GetReportOptions builder
     */
    public Builder reportId(String reportId) {
      this.reportId = reportId;
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the GetReportOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the GetReportOptions builder
     */
    public Builder scopeId(String scopeId) {
      this.scopeId = scopeId;
      return this;
    }

    /**
     * Set the subscopeId.
     *
     * @param subscopeId the subscopeId
     * @return the GetReportOptions builder
     */
    public Builder subscopeId(String subscopeId) {
      this.subscopeId = subscopeId;
      return this;
    }
  }

  protected GetReportOptions() { }

  protected GetReportOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.reportId,
      "reportId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    reportId = builder.reportId;
    instanceId = builder.instanceId;
    scopeId = builder.scopeId;
    subscopeId = builder.subscopeId;
  }

  /**
   * New builder.
   *
   * @return a GetReportOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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

