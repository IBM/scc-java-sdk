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
    /** not_applicable. */
    String NOT_APPLICABLE = "not_applicable";
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

  protected String instanceId;
  protected String reportId;
  protected String controlId;
  protected String controlName;
  protected String controlDescription;
  protected String controlCategory;
  protected String status;
  protected String sort;
  protected String scopeId;
  protected String subscopeId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String reportId;
    private String controlId;
    private String controlName;
    private String controlDescription;
    private String controlCategory;
    private String status;
    private String sort;
    private String scopeId;
    private String subscopeId;

    /**
     * Instantiates a new Builder from an existing GetReportControlsOptions instance.
     *
     * @param getReportControlsOptions the instance to initialize the Builder with
     */
    private Builder(GetReportControlsOptions getReportControlsOptions) {
      this.instanceId = getReportControlsOptions.instanceId;
      this.reportId = getReportControlsOptions.reportId;
      this.controlId = getReportControlsOptions.controlId;
      this.controlName = getReportControlsOptions.controlName;
      this.controlDescription = getReportControlsOptions.controlDescription;
      this.controlCategory = getReportControlsOptions.controlCategory;
      this.status = getReportControlsOptions.status;
      this.sort = getReportControlsOptions.sort;
      this.scopeId = getReportControlsOptions.scopeId;
      this.subscopeId = getReportControlsOptions.subscopeId;
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
     * Builds a GetReportControlsOptions.
     *
     * @return the new GetReportControlsOptions instance
     */
    public GetReportControlsOptions build() {
      return new GetReportControlsOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the GetReportControlsOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
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

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the GetReportControlsOptions builder
     */
    public Builder scopeId(String scopeId) {
      this.scopeId = scopeId;
      return this;
    }

    /**
     * Set the subscopeId.
     *
     * @param subscopeId the subscopeId
     * @return the GetReportControlsOptions builder
     */
    public Builder subscopeId(String subscopeId) {
      this.subscopeId = subscopeId;
      return this;
    }
  }

  protected GetReportControlsOptions() { }

  protected GetReportControlsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.reportId,
      "reportId cannot be empty");
    instanceId = builder.instanceId;
    reportId = builder.reportId;
    controlId = builder.controlId;
    controlName = builder.controlName;
    controlDescription = builder.controlDescription;
    controlCategory = builder.controlCategory;
    status = builder.status;
    sort = builder.sort;
    scopeId = builder.scopeId;
    subscopeId = builder.subscopeId;
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

