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
 * The control specification assessment.
 */
public class Assessment extends GenericModel {

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
  protected List<ParameterInfo> parameters;

  protected Assessment() { }

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
  public List<ParameterInfo> getParameters() {
    return parameters;
  }
}

