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
 * The getReportRule options.
 */
public class GetReportRuleOptions extends GenericModel {

  protected String instanceId;
  protected String reportId;
  protected String ruleId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String reportId;
    private String ruleId;

    /**
     * Instantiates a new Builder from an existing GetReportRuleOptions instance.
     *
     * @param getReportRuleOptions the instance to initialize the Builder with
     */
    private Builder(GetReportRuleOptions getReportRuleOptions) {
      this.instanceId = getReportRuleOptions.instanceId;
      this.reportId = getReportRuleOptions.reportId;
      this.ruleId = getReportRuleOptions.ruleId;
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
     * @param ruleId the ruleId
     */
    public Builder(String instanceId, String reportId, String ruleId) {
      this.instanceId = instanceId;
      this.reportId = reportId;
      this.ruleId = ruleId;
    }

    /**
     * Builds a GetReportRuleOptions.
     *
     * @return the new GetReportRuleOptions instance
     */
    public GetReportRuleOptions build() {
      return new GetReportRuleOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the GetReportRuleOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the reportId.
     *
     * @param reportId the reportId
     * @return the GetReportRuleOptions builder
     */
    public Builder reportId(String reportId) {
      this.reportId = reportId;
      return this;
    }

    /**
     * Set the ruleId.
     *
     * @param ruleId the ruleId
     * @return the GetReportRuleOptions builder
     */
    public Builder ruleId(String ruleId) {
      this.ruleId = ruleId;
      return this;
    }
  }

  protected GetReportRuleOptions() { }

  protected GetReportRuleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.reportId,
      "reportId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ruleId,
      "ruleId cannot be empty");
    instanceId = builder.instanceId;
    reportId = builder.reportId;
    ruleId = builder.ruleId;
  }

  /**
   * New builder.
   *
   * @return a GetReportRuleOptions builder
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
   * Gets the ruleId.
   *
   * The ID of the rule within a report.
   *
   * @return the ruleId
   */
  public String ruleId() {
    return ruleId;
  }
}

