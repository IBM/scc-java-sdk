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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The control specification assessment.
 */
public class AssessmentWithStats extends GenericModel {

  @SerializedName("assessment_id")
  protected String assessmentId;
  @SerializedName("assessment_type")
  protected String assessmentType;
  @SerializedName("assessment_method")
  protected String assessmentMethod;
  @SerializedName("assessment_description")
  protected String assessmentDescription;
  @SerializedName("parameter_count")
  protected Long parameterCount;
  protected List<Parameter> parameters;
  @SerializedName("total_count")
  protected Long totalCount;
  @SerializedName("pass_count")
  protected Long passCount;
  @SerializedName("failure_count")
  protected Long failureCount;
  @SerializedName("error_count")
  protected Long errorCount;
  @SerializedName("completed_count")
  protected Long completedCount;

  protected AssessmentWithStats() { }

  /**
   * Gets the assessmentId.
   *
   * The assessment ID.
   *
   * @return the assessmentId
   */
  public String getAssessmentId() {
    return assessmentId;
  }

  /**
   * Gets the assessmentType.
   *
   * The assessment type.
   *
   * @return the assessmentType
   */
  public String getAssessmentType() {
    return assessmentType;
  }

  /**
   * Gets the assessmentMethod.
   *
   * The assessment method.
   *
   * @return the assessmentMethod
   */
  public String getAssessmentMethod() {
    return assessmentMethod;
  }

  /**
   * Gets the assessmentDescription.
   *
   * The assessment description.
   *
   * @return the assessmentDescription
   */
  public String getAssessmentDescription() {
    return assessmentDescription;
  }

  /**
   * Gets the parameterCount.
   *
   * The number of parameters of this assessment.
   *
   * @return the parameterCount
   */
  public Long getParameterCount() {
    return parameterCount;
  }

  /**
   * Gets the parameters.
   *
   * The list of parameters of this assessment.
   *
   * @return the parameters
   */
  public List<Parameter> getParameters() {
    return parameters;
  }

  /**
   * Gets the totalCount.
   *
   * The total number of evaluations.
   *
   * @return the totalCount
   */
  public Long getTotalCount() {
    return totalCount;
  }

  /**
   * Gets the passCount.
   *
   * The number of passed evaluations.
   *
   * @return the passCount
   */
  public Long getPassCount() {
    return passCount;
  }

  /**
   * Gets the failureCount.
   *
   * The number of failed evaluations.
   *
   * @return the failureCount
   */
  public Long getFailureCount() {
    return failureCount;
  }

  /**
   * Gets the errorCount.
   *
   * The number of evaluations that started, but did not finish, and ended with errors.
   *
   * @return the errorCount
   */
  public Long getErrorCount() {
    return errorCount;
  }

  /**
   * Gets the completedCount.
   *
   * The total number of completed evaluations.
   *
   * @return the completedCount
   */
  public Long getCompletedCount() {
    return completedCount;
  }
}

