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
package com.ibm.cloud.scc.compliance.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The details of the parameter.
 */
public class ParameterDetails extends GenericModel {

  /**
   * the type of the parameter.
   */
  public interface ParameterType {
    /** numeric. */
    String NUMERIC = "numeric";
    /** string_list. */
    String STRING_LIST = "string_list";
  }

  @SerializedName("parameter_name")
  protected String parameterName;
  @SerializedName("parameter_display_name")
  protected String parameterDisplayName;
  @SerializedName("parameter_type")
  protected String parameterType;
  @SerializedName("parameter_value")
  protected String parameterValue;
  @SerializedName("assessment_type")
  protected String assessmentType;
  @SerializedName("assessment_id")
  protected String assessmentId;
  protected List<ParameterInfo> parameters;

  /**
   * Builder.
   */
  public static class Builder {
    private String parameterName;
    private String parameterDisplayName;
    private String parameterType;
    private String parameterValue;
    private String assessmentType;
    private String assessmentId;
    private List<ParameterInfo> parameters;

    /**
     * Instantiates a new Builder from an existing ParameterDetails instance.
     *
     * @param parameterDetails the instance to initialize the Builder with
     */
    private Builder(ParameterDetails parameterDetails) {
      this.parameterName = parameterDetails.parameterName;
      this.parameterDisplayName = parameterDetails.parameterDisplayName;
      this.parameterType = parameterDetails.parameterType;
      this.parameterValue = parameterDetails.parameterValue;
      this.assessmentType = parameterDetails.assessmentType;
      this.assessmentId = parameterDetails.assessmentId;
      this.parameters = parameterDetails.parameters;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ParameterDetails.
     *
     * @return the new ParameterDetails instance
     */
    public ParameterDetails build() {
      return new ParameterDetails(this);
    }

    /**
     * Adds an parameters to parameters.
     *
     * @param parameters the new parameters
     * @return the ParameterDetails builder
     */
    public Builder addParameters(ParameterInfo parameters) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(parameters,
        "parameters cannot be null");
      if (this.parameters == null) {
        this.parameters = new ArrayList<ParameterInfo>();
      }
      this.parameters.add(parameters);
      return this;
    }

    /**
     * Set the parameterName.
     *
     * @param parameterName the parameterName
     * @return the ParameterDetails builder
     */
    public Builder parameterName(String parameterName) {
      this.parameterName = parameterName;
      return this;
    }

    /**
     * Set the parameterDisplayName.
     *
     * @param parameterDisplayName the parameterDisplayName
     * @return the ParameterDetails builder
     */
    public Builder parameterDisplayName(String parameterDisplayName) {
      this.parameterDisplayName = parameterDisplayName;
      return this;
    }

    /**
     * Set the parameterType.
     *
     * @param parameterType the parameterType
     * @return the ParameterDetails builder
     */
    public Builder parameterType(String parameterType) {
      this.parameterType = parameterType;
      return this;
    }

    /**
     * Set the parameterValue.
     *
     * @param parameterValue the parameterValue
     * @return the ParameterDetails builder
     */
    public Builder parameterValue(String parameterValue) {
      this.parameterValue = parameterValue;
      return this;
    }

    /**
     * Set the assessmentType.
     *
     * @param assessmentType the assessmentType
     * @return the ParameterDetails builder
     */
    public Builder assessmentType(String assessmentType) {
      this.assessmentType = assessmentType;
      return this;
    }

    /**
     * Set the assessmentId.
     *
     * @param assessmentId the assessmentId
     * @return the ParameterDetails builder
     */
    public Builder assessmentId(String assessmentId) {
      this.assessmentId = assessmentId;
      return this;
    }

    /**
     * Set the parameters.
     * Existing parameters will be replaced.
     *
     * @param parameters the parameters
     * @return the ParameterDetails builder
     */
    public Builder parameters(List<ParameterInfo> parameters) {
      this.parameters = parameters;
      return this;
    }
  }

  protected ParameterDetails() { }

  protected ParameterDetails(Builder builder) {
    parameterName = builder.parameterName;
    parameterDisplayName = builder.parameterDisplayName;
    parameterType = builder.parameterType;
    parameterValue = builder.parameterValue;
    assessmentType = builder.assessmentType;
    assessmentId = builder.assessmentId;
    parameters = builder.parameters;
  }

  /**
   * New builder.
   *
   * @return a ParameterDetails builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the parameterName.
   *
   * The name of the parameter.
   *
   * @return the parameterName
   */
  public String parameterName() {
    return parameterName;
  }

  /**
   * Gets the parameterDisplayName.
   *
   * The display name of the parameter.
   *
   * @return the parameterDisplayName
   */
  public String parameterDisplayName() {
    return parameterDisplayName;
  }

  /**
   * Gets the parameterType.
   *
   * the type of the parameter.
   *
   * @return the parameterType
   */
  public String parameterType() {
    return parameterType;
  }

  /**
   * Gets the parameterValue.
   *
   * The value of the parameter.
   *
   * @return the parameterValue
   */
  public String parameterValue() {
    return parameterValue;
  }

  /**
   * Gets the assessmentType.
   *
   * The assessment type of the parameter.
   *
   * @return the assessmentType
   */
  public String assessmentType() {
    return assessmentType;
  }

  /**
   * Gets the assessmentId.
   *
   * The Assessment ID of the parameter.
   *
   * @return the assessmentId
   */
  public String assessmentId() {
    return assessmentId;
  }

  /**
   * Gets the parameters.
   *
   * Parameters.
   *
   * @return the parameters
   */
  public List<ParameterInfo> parameters() {
    return parameters;
  }
}

