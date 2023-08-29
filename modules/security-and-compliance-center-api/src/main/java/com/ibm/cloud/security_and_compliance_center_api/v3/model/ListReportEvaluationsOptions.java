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
 * The listReportEvaluations options.
 */
public class ListReportEvaluationsOptions extends GenericModel {

  /**
   * The evaluation status value.
   */
  public interface Status {
    /** pass. */
    String PASS = "pass";
    /** failure. */
    String FAILURE = "failure";
    /** error. */
    String ERROR = "error";
    /** skipped. */
    String SKIPPED = "skipped";
  }

  protected String reportId;
  protected String xCorrelationId;
  protected String xRequestId;
  protected String assessmentId;
  protected String componentId;
  protected String targetId;
  protected String targetName;
  protected String status;
  protected String start;
  protected Long limit;

  /**
   * Builder.
   */
  public static class Builder {
    private String reportId;
    private String xCorrelationId;
    private String xRequestId;
    private String assessmentId;
    private String componentId;
    private String targetId;
    private String targetName;
    private String status;
    private String start;
    private Long limit;

    /**
     * Instantiates a new Builder from an existing ListReportEvaluationsOptions instance.
     *
     * @param listReportEvaluationsOptions the instance to initialize the Builder with
     */
    private Builder(ListReportEvaluationsOptions listReportEvaluationsOptions) {
      this.reportId = listReportEvaluationsOptions.reportId;
      this.xCorrelationId = listReportEvaluationsOptions.xCorrelationId;
      this.xRequestId = listReportEvaluationsOptions.xRequestId;
      this.assessmentId = listReportEvaluationsOptions.assessmentId;
      this.componentId = listReportEvaluationsOptions.componentId;
      this.targetId = listReportEvaluationsOptions.targetId;
      this.targetName = listReportEvaluationsOptions.targetName;
      this.status = listReportEvaluationsOptions.status;
      this.start = listReportEvaluationsOptions.start;
      this.limit = listReportEvaluationsOptions.limit;
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
     * Builds a ListReportEvaluationsOptions.
     *
     * @return the new ListReportEvaluationsOptions instance
     */
    public ListReportEvaluationsOptions build() {
      return new ListReportEvaluationsOptions(this);
    }

    /**
     * Set the reportId.
     *
     * @param reportId the reportId
     * @return the ListReportEvaluationsOptions builder
     */
    public Builder reportId(String reportId) {
      this.reportId = reportId;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the ListReportEvaluationsOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the ListReportEvaluationsOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }

    /**
     * Set the assessmentId.
     *
     * @param assessmentId the assessmentId
     * @return the ListReportEvaluationsOptions builder
     */
    public Builder assessmentId(String assessmentId) {
      this.assessmentId = assessmentId;
      return this;
    }

    /**
     * Set the componentId.
     *
     * @param componentId the componentId
     * @return the ListReportEvaluationsOptions builder
     */
    public Builder componentId(String componentId) {
      this.componentId = componentId;
      return this;
    }

    /**
     * Set the targetId.
     *
     * @param targetId the targetId
     * @return the ListReportEvaluationsOptions builder
     */
    public Builder targetId(String targetId) {
      this.targetId = targetId;
      return this;
    }

    /**
     * Set the targetName.
     *
     * @param targetName the targetName
     * @return the ListReportEvaluationsOptions builder
     */
    public Builder targetName(String targetName) {
      this.targetName = targetName;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the ListReportEvaluationsOptions builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListReportEvaluationsOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListReportEvaluationsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }
  }

  protected ListReportEvaluationsOptions() { }

  protected ListReportEvaluationsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.reportId,
      "reportId cannot be empty");
    reportId = builder.reportId;
    xCorrelationId = builder.xCorrelationId;
    xRequestId = builder.xRequestId;
    assessmentId = builder.assessmentId;
    componentId = builder.componentId;
    targetId = builder.targetId;
    targetName = builder.targetName;
    status = builder.status;
    start = builder.start;
    limit = builder.limit;
  }

  /**
   * New builder.
   *
   * @return a ListReportEvaluationsOptions builder
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
   * Gets the assessmentId.
   *
   * The ID of the assessment.
   *
   * @return the assessmentId
   */
  public String assessmentId() {
    return assessmentId;
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
   * Gets the targetId.
   *
   * The ID of the evaluation target.
   *
   * @return the targetId
   */
  public String targetId() {
    return targetId;
  }

  /**
   * Gets the targetName.
   *
   * The name of the evaluation target.
   *
   * @return the targetName
   */
  public String targetName() {
    return targetName;
  }

  /**
   * Gets the status.
   *
   * The evaluation status value.
   *
   * @return the status
   */
  public String status() {
    return status;
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
   * The indication of many resources to return, unless the response is  the last page of resources.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

