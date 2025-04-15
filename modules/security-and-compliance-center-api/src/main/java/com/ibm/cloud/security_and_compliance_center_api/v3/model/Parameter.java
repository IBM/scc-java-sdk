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
 * The details of a parameter used during an assessment.
 */
public class Parameter extends GenericModel {

  @SerializedName("assessment_type")
  protected String assessmentType;
  @SerializedName("assessment_id")
  protected String assessmentId;
  @SerializedName("parameter_name")
  protected String parameterName;
  @SerializedName("parameter_display_name")
  protected String parameterDisplayName;
  @SerializedName("parameter_type")
  protected String parameterType;
  @SerializedName("parameter_value")
  protected Object parameterValue;

  /**
   * Builder.
   */
  public static class Builder {
    private String assessmentType;
    private String assessmentId;
    private String parameterName;
    private String parameterDisplayName;
    private String parameterType;
    private Object parameterValue;

    /**
     * Instantiates a new Builder from an existing Parameter instance.
     *
     * @param parameter the instance to initialize the Builder with
     */
    private Builder(Parameter parameter) {
      this.assessmentType = parameter.assessmentType;
      this.assessmentId = parameter.assessmentId;
      this.parameterName = parameter.parameterName;
      this.parameterDisplayName = parameter.parameterDisplayName;
      this.parameterType = parameter.parameterType;
      this.parameterValue = parameter.parameterValue;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Parameter.
     *
     * @return the new Parameter instance
     */
    public Parameter build() {
      return new Parameter(this);
    }

    /**
     * Set the assessmentType.
     *
     * @param assessmentType the assessmentType
     * @return the Parameter builder
     */
    public Builder assessmentType(String assessmentType) {
      this.assessmentType = assessmentType;
      return this;
    }

    /**
     * Set the assessmentId.
     *
     * @param assessmentId the assessmentId
     * @return the Parameter builder
     */
    public Builder assessmentId(String assessmentId) {
      this.assessmentId = assessmentId;
      return this;
    }

    /**
     * Set the parameterName.
     *
     * @param parameterName the parameterName
     * @return the Parameter builder
     */
    public Builder parameterName(String parameterName) {
      this.parameterName = parameterName;
      return this;
    }

    /**
     * Set the parameterDisplayName.
     *
     * @param parameterDisplayName the parameterDisplayName
     * @return the Parameter builder
     */
    public Builder parameterDisplayName(String parameterDisplayName) {
      this.parameterDisplayName = parameterDisplayName;
      return this;
    }

    /**
     * Set the parameterType.
     *
     * @param parameterType the parameterType
     * @return the Parameter builder
     */
    public Builder parameterType(String parameterType) {
      this.parameterType = parameterType;
      return this;
    }

    /**
     * Set the parameterValue.
     *
     * @param parameterValue the parameterValue
     * @return the Parameter builder
     */
    public Builder parameterValue(Object parameterValue) {
      this.parameterValue = parameterValue;
      return this;
    }
  }

  protected Parameter() { }

  protected Parameter(Builder builder) {
    assessmentType = builder.assessmentType;
    assessmentId = builder.assessmentId;
    parameterName = builder.parameterName;
    parameterDisplayName = builder.parameterDisplayName;
    parameterType = builder.parameterType;
    parameterValue = builder.parameterValue;
  }

  /**
   * New builder.
   *
   * @return a Parameter builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assessmentType.
   *
   * The type of evaluation.
   *
   * @return the assessmentType
   */
  public String assessmentType() {
    return assessmentType;
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
   * Gets the parameterName.
   *
   * The parameter name.
   *
   * @return the parameterName
   */
  public String parameterName() {
    return parameterName;
  }

  /**
   * Gets the parameterDisplayName.
   *
   * The parameter display name.
   *
   * @return the parameterDisplayName
   */
  public String parameterDisplayName() {
    return parameterDisplayName;
  }

  /**
   * Gets the parameterType.
   *
   * The parameter type.
   *
   * @return the parameterType
   */
  public String parameterType() {
    return parameterType;
  }

  /**
   * Gets the parameterValue.
   *
   * The value can be of any type.
   *
   * @return the parameterValue
   */
  public Object parameterValue() {
    return parameterValue;
  }
}

