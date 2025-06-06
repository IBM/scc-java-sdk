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

  /**
   * This field sorts resources by using a valid sort field. To learn more, see
   * [Sorting](https://cloud.ibm.com/docs/api-handbook?topic=api-handbook-sorting).
   */
  public interface Sort {
    /** assessment_id. */
    String ASSESSMENT_ID = "assessment_id";
    /** target_id. */
    String TARGET_ID = "target_id";
    /** target_name. */
    String TARGET_NAME = "target_name";
    /** status. */
    String STATUS = "status";
  }

  protected String instanceId;
  protected String reportId;
  protected String assessmentId;
  protected String assessmentMethod;
  protected String componentId;
  protected String targetId;
  protected String targetEnv;
  protected String targetName;
  protected String status;
  protected String start;
  protected Long limit;
  protected String sort;
  protected String scopeId;
  protected String subscopeId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String reportId;
    private String assessmentId;
    private String assessmentMethod;
    private String componentId;
    private String targetId;
    private String targetEnv;
    private String targetName;
    private String status;
    private String start;
    private Long limit;
    private String sort;
    private String scopeId;
    private String subscopeId;

    /**
     * Instantiates a new Builder from an existing ListReportEvaluationsOptions instance.
     *
     * @param listReportEvaluationsOptions the instance to initialize the Builder with
     */
    private Builder(ListReportEvaluationsOptions listReportEvaluationsOptions) {
      this.instanceId = listReportEvaluationsOptions.instanceId;
      this.reportId = listReportEvaluationsOptions.reportId;
      this.assessmentId = listReportEvaluationsOptions.assessmentId;
      this.assessmentMethod = listReportEvaluationsOptions.assessmentMethod;
      this.componentId = listReportEvaluationsOptions.componentId;
      this.targetId = listReportEvaluationsOptions.targetId;
      this.targetEnv = listReportEvaluationsOptions.targetEnv;
      this.targetName = listReportEvaluationsOptions.targetName;
      this.status = listReportEvaluationsOptions.status;
      this.start = listReportEvaluationsOptions.start;
      this.limit = listReportEvaluationsOptions.limit;
      this.sort = listReportEvaluationsOptions.sort;
      this.scopeId = listReportEvaluationsOptions.scopeId;
      this.subscopeId = listReportEvaluationsOptions.subscopeId;
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
     * Builds a ListReportEvaluationsOptions.
     *
     * @return the new ListReportEvaluationsOptions instance
     */
    public ListReportEvaluationsOptions build() {
      return new ListReportEvaluationsOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ListReportEvaluationsOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
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
     * Set the assessmentMethod.
     *
     * @param assessmentMethod the assessmentMethod
     * @return the ListReportEvaluationsOptions builder
     */
    public Builder assessmentMethod(String assessmentMethod) {
      this.assessmentMethod = assessmentMethod;
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
     * Set the targetEnv.
     *
     * @param targetEnv the targetEnv
     * @return the ListReportEvaluationsOptions builder
     */
    public Builder targetEnv(String targetEnv) {
      this.targetEnv = targetEnv;
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

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListReportEvaluationsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the ListReportEvaluationsOptions builder
     */
    public Builder scopeId(String scopeId) {
      this.scopeId = scopeId;
      return this;
    }

    /**
     * Set the subscopeId.
     *
     * @param subscopeId the subscopeId
     * @return the ListReportEvaluationsOptions builder
     */
    public Builder subscopeId(String subscopeId) {
      this.subscopeId = subscopeId;
      return this;
    }
  }

  protected ListReportEvaluationsOptions() { }

  protected ListReportEvaluationsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.reportId,
      "reportId cannot be empty");
    instanceId = builder.instanceId;
    reportId = builder.reportId;
    assessmentId = builder.assessmentId;
    assessmentMethod = builder.assessmentMethod;
    componentId = builder.componentId;
    targetId = builder.targetId;
    targetEnv = builder.targetEnv;
    targetName = builder.targetName;
    status = builder.status;
    start = builder.start;
    limit = builder.limit;
    sort = builder.sort;
    scopeId = builder.scopeId;
    subscopeId = builder.subscopeId;
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
   * Gets the assessmentMethod.
   *
   * The assessment method.
   *
   * @return the assessmentMethod
   */
  public String assessmentMethod() {
    return assessmentMethod;
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
   * Gets the targetEnv.
   *
   * The environment of the evaluation target.
   *
   * @return the targetEnv
   */
  public String targetEnv() {
    return targetEnv;
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
   * The indication of many resources to return, unless the response is the last page of resources.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
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

