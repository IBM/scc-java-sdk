/*
 * (C) Copyright IBM Corp. 2023.
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

  protected String reportId;
  protected String xCorrelationId;
  protected String xRequestId;
  protected Long scanTimeDuration;

  /**
   * Builder.
   */
  public static class Builder {
    private String reportId;
    private String xCorrelationId;
    private String xRequestId;
    private Long scanTimeDuration;

    /**
     * Instantiates a new Builder from an existing GetReportViolationsDriftOptions instance.
     *
     * @param getReportViolationsDriftOptions the instance to initialize the Builder with
     */
    private Builder(GetReportViolationsDriftOptions getReportViolationsDriftOptions) {
      this.reportId = getReportViolationsDriftOptions.reportId;
      this.xCorrelationId = getReportViolationsDriftOptions.xCorrelationId;
      this.xRequestId = getReportViolationsDriftOptions.xRequestId;
      this.scanTimeDuration = getReportViolationsDriftOptions.scanTimeDuration;
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
     */
    public Builder(String reportId) {
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
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the GetReportViolationsDriftOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the GetReportViolationsDriftOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
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
  }

  protected GetReportViolationsDriftOptions() { }

  protected GetReportViolationsDriftOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.reportId,
      "reportId cannot be empty");
    reportId = builder.reportId;
    xCorrelationId = builder.xCorrelationId;
    xRequestId = builder.xRequestId;
    scanTimeDuration = builder.scanTimeDuration;
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
   * Gets the xCorrelationId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header for the
   * corresponding response. The same value is used for downstream requests and retries of those requests. If a value of
   * this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xCorrelationId
   */
  public String xCorrelationId() {
    return xCorrelationId;
  }

  /**
   * Gets the xRequestId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header  for the
   * corresponding response.  The same value is not used for downstream requests and retries of those requests.  If a
   * value of this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xRequestId
   */
  public String xRequestId() {
    return xRequestId;
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
}

