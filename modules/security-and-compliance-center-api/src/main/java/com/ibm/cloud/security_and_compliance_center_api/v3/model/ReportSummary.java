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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The report summary.
 */
public class ReportSummary extends GenericModel {

  @SerializedName("report_id")
  protected String reportId;
  @SerializedName("instance_id")
  protected String instanceId;
  protected Account account;
  protected ComplianceScore score;
  protected EvalStats evaluations;
  protected ComplianceStats controls;
  protected ResourceSummary resources;

  protected ReportSummary() { }

  /**
   * Gets the reportId.
   *
   * The ID of the report.
   *
   * @return the reportId
   */
  public String getReportId() {
    return reportId;
  }

  /**
   * Gets the instanceId.
   *
   * Instance ID.
   *
   * @return the instanceId
   */
  public String getInstanceId() {
    return instanceId;
  }

  /**
   * Gets the account.
   *
   * The account that is associated with a report.
   *
   * @return the account
   */
  public Account getAccount() {
    return account;
  }

  /**
   * Gets the score.
   *
   * The compliance score.
   *
   * @return the score
   */
  public ComplianceScore getScore() {
    return score;
  }

  /**
   * Gets the evaluations.
   *
   * The evaluation stats.
   *
   * @return the evaluations
   */
  public EvalStats getEvaluations() {
    return evaluations;
  }

  /**
   * Gets the controls.
   *
   * The compliance stats.
   *
   * @return the controls
   */
  public ComplianceStats getControls() {
    return controls;
  }

  /**
   * Gets the resources.
   *
   * The resource summary.
   *
   * @return the resources
   */
  public ResourceSummary getResources() {
    return resources;
  }
}

