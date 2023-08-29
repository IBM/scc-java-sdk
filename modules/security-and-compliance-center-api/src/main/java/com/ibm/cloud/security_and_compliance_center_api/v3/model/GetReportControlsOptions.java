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
 * The getReportControls options.
 */
public class GetReportControlsOptions extends GenericModel {

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
  }

  /**
   * This field sorts controls by using a valid sort field. To learn more, see
   * [Sorting](https://cloud.ibm.com/docs/api-handbook?topic=api-handbook-sorting).
   */
  public interface Sort {
    /** control_name. */
    String CONTROL_NAME = "control_name";
    /** control_category. */
    String CONTROL_CATEGORY = "control_category";
    /** status. */
    String STATUS = "status";
  }

  protected String reportId;
  protected String xCorrelationId;
  protected String xRequestId;
  protected String controlId;
  protected String controlName;
  protected String controlDescription;
  protected String controlCategory;
  protected String status;
  protected String sort;

  /**
   * Builder.
   */
  public static class Builder {
    private String reportId;
    private String xCorrelationId;
    private String xRequestId;
    private String controlId;
    private String controlName;
    private String controlDescription;
    private String controlCategory;
    private String status;
    private String sort;

    /**
     * Instantiates a new Builder from an existing GetReportControlsOptions instance.
     *
     * @param getReportControlsOptions the instance to initialize the Builder with
     */
    private Builder(GetReportControlsOptions getReportControlsOptions) {
      this.reportId = getReportControlsOptions.reportId;
      this.xCorrelationId = getReportControlsOptions.xCorrelationId;
      this.xRequestId = getReportControlsOptions.xRequestId;
      this.controlId = getReportControlsOptions.controlId;
      this.controlName = getReportControlsOptions.controlName;
      this.controlDescription = getReportControlsOptions.controlDescription;
      this.controlCategory = getReportControlsOptions.controlCategory;
      this.status = getReportControlsOptions.status;
      this.sort = getReportControlsOptions.sort;
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
     * Builds a GetReportControlsOptions.
     *
     * @return the new GetReportControlsOptions instance
     */
    public GetReportControlsOptions build() {
      return new GetReportControlsOptions(this);
    }

    /**
     * Set the reportId.
     *
     * @param reportId the reportId
     * @return the GetReportControlsOptions builder
     */
    public Builder reportId(String reportId) {
      this.reportId = reportId;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the GetReportControlsOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the GetReportControlsOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }

    /**
     * Set the controlId.
     *
     * @param controlId the controlId
     * @return the GetReportControlsOptions builder
     */
    public Builder controlId(String controlId) {
      this.controlId = controlId;
      return this;
    }

    /**
     * Set the controlName.
     *
     * @param controlName the controlName
     * @return the GetReportControlsOptions builder
     */
    public Builder controlName(String controlName) {
      this.controlName = controlName;
      return this;
    }

    /**
     * Set the controlDescription.
     *
     * @param controlDescription the controlDescription
     * @return the GetReportControlsOptions builder
     */
    public Builder controlDescription(String controlDescription) {
      this.controlDescription = controlDescription;
      return this;
    }

    /**
     * Set the controlCategory.
     *
     * @param controlCategory the controlCategory
     * @return the GetReportControlsOptions builder
     */
    public Builder controlCategory(String controlCategory) {
      this.controlCategory = controlCategory;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the GetReportControlsOptions builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the GetReportControlsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }
  }

  protected GetReportControlsOptions() { }

  protected GetReportControlsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.reportId,
      "reportId cannot be empty");
    reportId = builder.reportId;
    xCorrelationId = builder.xCorrelationId;
    xRequestId = builder.xRequestId;
    controlId = builder.controlId;
    controlName = builder.controlName;
    controlDescription = builder.controlDescription;
    controlCategory = builder.controlCategory;
    status = builder.status;
    sort = builder.sort;
  }

  /**
   * New builder.
   *
   * @return a GetReportControlsOptions builder
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
   * Gets the controlId.
   *
   * The ID of the control.
   *
   * @return the controlId
   */
  public String controlId() {
    return controlId;
  }

  /**
   * Gets the controlName.
   *
   * The name of the control.
   *
   * @return the controlName
   */
  public String controlName() {
    return controlName;
  }

  /**
   * Gets the controlDescription.
   *
   * The description of the control.
   *
   * @return the controlDescription
   */
  public String controlDescription() {
    return controlDescription;
  }

  /**
   * Gets the controlCategory.
   *
   * A control category value.
   *
   * @return the controlCategory
   */
  public String controlCategory() {
    return controlCategory;
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
   * This field sorts controls by using a valid sort field. To learn more, see
   * [Sorting](https://cloud.ibm.com/docs/api-handbook?topic=api-handbook-sorting).
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }
}

