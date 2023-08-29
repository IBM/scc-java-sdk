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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The evaluation of a control specification assessment.
 */
public class Evaluation extends GenericModel {

  /**
   * The allowed values of an evaluation status.
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

  @SerializedName("home_account_id")
  protected String homeAccountId;
  @SerializedName("report_id")
  protected String reportId;
  @SerializedName("control_id")
  protected String controlId;
  @SerializedName("component_id")
  protected String componentId;
  protected Assessment assessment;
  @SerializedName("evaluate_time")
  protected String evaluateTime;
  protected TargetInfo target;
  protected String status;
  protected String reason;
  protected EvalDetails details;

  protected Evaluation() { }

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
   * Gets the reportId.
   *
   * The ID of the report that is associated to the evaluation.
   *
   * @return the reportId
   */
  public String getReportId() {
    return reportId;
  }

  /**
   * Gets the controlId.
   *
   * The control ID.
   *
   * @return the controlId
   */
  public String getControlId() {
    return controlId;
  }

  /**
   * Gets the componentId.
   *
   * The component ID.
   *
   * @return the componentId
   */
  public String getComponentId() {
    return componentId;
  }

  /**
   * Gets the assessment.
   *
   * The control specification assessment.
   *
   * @return the assessment
   */
  public Assessment getAssessment() {
    return assessment;
  }

  /**
   * Gets the evaluateTime.
   *
   * The time when the evaluation was made.
   *
   * @return the evaluateTime
   */
  public String getEvaluateTime() {
    return evaluateTime;
  }

  /**
   * Gets the target.
   *
   * The evaluation target.
   *
   * @return the target
   */
  public TargetInfo getTarget() {
    return target;
  }

  /**
   * Gets the status.
   *
   * The allowed values of an evaluation status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the reason.
   *
   * The reason for the evaluation failure.
   *
   * @return the reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * Gets the details.
   *
   * The evaluation details.
   *
   * @return the details
   */
  public EvalDetails getDetails() {
    return details;
  }
}

