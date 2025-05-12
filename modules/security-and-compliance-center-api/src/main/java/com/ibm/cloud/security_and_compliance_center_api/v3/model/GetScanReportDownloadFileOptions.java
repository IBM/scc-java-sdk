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
 * The getScanReportDownloadFile options.
 */
public class GetScanReportDownloadFileOptions extends GenericModel {

  protected String instanceId;
  protected String reportId;
  protected String jobId;
  protected String accept;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String reportId;
    private String jobId;
    private String accept;

    /**
     * Instantiates a new Builder from an existing GetScanReportDownloadFileOptions instance.
     *
     * @param getScanReportDownloadFileOptions the instance to initialize the Builder with
     */
    private Builder(GetScanReportDownloadFileOptions getScanReportDownloadFileOptions) {
      this.instanceId = getScanReportDownloadFileOptions.instanceId;
      this.reportId = getScanReportDownloadFileOptions.reportId;
      this.jobId = getScanReportDownloadFileOptions.jobId;
      this.accept = getScanReportDownloadFileOptions.accept;
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
     * @param jobId the jobId
     */
    public Builder(String instanceId, String reportId, String jobId) {
      this.instanceId = instanceId;
      this.reportId = reportId;
      this.jobId = jobId;
    }

    /**
     * Builds a GetScanReportDownloadFileOptions.
     *
     * @return the new GetScanReportDownloadFileOptions instance
     */
    public GetScanReportDownloadFileOptions build() {
      return new GetScanReportDownloadFileOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the GetScanReportDownloadFileOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the reportId.
     *
     * @param reportId the reportId
     * @return the GetScanReportDownloadFileOptions builder
     */
    public Builder reportId(String reportId) {
      this.reportId = reportId;
      return this;
    }

    /**
     * Set the jobId.
     *
     * @param jobId the jobId
     * @return the GetScanReportDownloadFileOptions builder
     */
    public Builder jobId(String jobId) {
      this.jobId = jobId;
      return this;
    }

    /**
     * Set the accept.
     *
     * @param accept the accept
     * @return the GetScanReportDownloadFileOptions builder
     */
    public Builder accept(String accept) {
      this.accept = accept;
      return this;
    }
  }

  protected GetScanReportDownloadFileOptions() { }

  protected GetScanReportDownloadFileOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.reportId,
      "reportId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.jobId,
      "jobId cannot be empty");
    instanceId = builder.instanceId;
    reportId = builder.reportId;
    jobId = builder.jobId;
    accept = builder.accept;
  }

  /**
   * New builder.
   *
   * @return a GetScanReportDownloadFileOptions builder
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
   * Gets the jobId.
   *
   * The ID of the scan_result.
   *
   * @return the jobId
   */
  public String jobId() {
    return jobId;
  }

  /**
   * Gets the accept.
   *
   * The type of the response: application/csv or application/pdf.
   *
   * @return the accept
   */
  public String accept() {
    return accept;
  }
}

