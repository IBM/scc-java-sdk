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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The response body of the `get_latest_reports` operation.
 */
public class ReportLatest extends GenericModel {

  @SerializedName("home_account_id")
  protected String homeAccountId;
  @SerializedName("controls_summary")
  protected ComplianceStats controlsSummary;
  @SerializedName("evaluations_summary")
  protected EvalStats evaluationsSummary;
  protected ComplianceScore score;
  protected List<Report> reports;

  protected ReportLatest() { }

  /**
   * Gets the homeAccountId.
   *
   * The ID of the home account.
   *
   * @return the homeAccountId
   */
  public String getHomeAccountId() {
    return homeAccountId;
  }

  /**
   * Gets the controlsSummary.
   *
   * The compliance stats.
   *
   * @return the controlsSummary
   */
  public ComplianceStats getControlsSummary() {
    return controlsSummary;
  }

  /**
   * Gets the evaluationsSummary.
   *
   * The evaluation stats.
   *
   * @return the evaluationsSummary
   */
  public EvalStats getEvaluationsSummary() {
    return evaluationsSummary;
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
   * Gets the reports.
   *
   * The list of reports.
   *
   * @return the reports
   */
  public List<Report> getReports() {
    return reports;
  }
}

