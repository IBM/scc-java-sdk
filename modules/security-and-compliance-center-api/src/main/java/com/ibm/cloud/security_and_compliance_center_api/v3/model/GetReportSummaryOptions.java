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
 * The getReportSummary options.
 */
public class GetReportSummaryOptions extends GenericModel {

  protected String instanceId;
  protected String reportId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String reportId;

    /**
     * Instantiates a new Builder from an existing GetReportSummaryOptions instance.
     *
     * @param getReportSummaryOptions the instance to initialize the Builder with
     */
    private Builder(GetReportSummaryOptions getReportSummaryOptions) {
      this.instanceId = getReportSummaryOptions.instanceId;
      this.reportId = getReportSummaryOptions.reportId;
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
     * Builds a GetReportSummaryOptions.
     *
     * @return the new GetReportSummaryOptions instance
     */
    public GetReportSummaryOptions build() {
      return new GetReportSummaryOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the GetReportSummaryOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the reportId.
     *
     * @param reportId the reportId
     * @return the GetReportSummaryOptions builder
     */
    public Builder reportId(String reportId) {
      this.reportId = reportId;
      return this;
    }
  }

  protected GetReportSummaryOptions() { }

  protected GetReportSummaryOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.reportId,
      "reportId cannot be empty");
    instanceId = builder.instanceId;
    reportId = builder.reportId;
  }

  /**
   * New builder.
   *
   * @return a GetReportSummaryOptions builder
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
}

