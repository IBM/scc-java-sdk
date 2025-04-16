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

import java.util.ArrayList;
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
  protected List<Parameter> parameters;

  /**
   * Builder.
   */
  public static class Builder {
    private String assessmentId;
    private String assessmentType;
    private String assessmentMethod;
    private String assessmentDescription;
    private Long parameterCount;
    private List<Parameter> parameters;

    /**
     * Instantiates a new Builder from an existing Assessment instance.
     *
     * @param assessment the instance to initialize the Builder with
     */
    private Builder(Assessment assessment) {
      this.assessmentId = assessment.assessmentId;
      this.assessmentType = assessment.assessmentType;
      this.assessmentMethod = assessment.assessmentMethod;
      this.assessmentDescription = assessment.assessmentDescription;
      this.parameterCount = assessment.parameterCount;
      this.parameters = assessment.parameters;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param parameters the parameters
     */
    public Builder(List<Parameter> parameters) {
      this.parameters = parameters;
    }

    /**
     * Builds a Assessment.
     *
     * @return the new Assessment instance
     */
    public Assessment build() {
      return new Assessment(this);
    }

    /**
     * Adds a new element to parameters.
     *
     * @param parameters the new element to be added
     * @return the Assessment builder
     */
    public Builder addParameters(Parameter parameters) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(parameters,
        "parameters cannot be null");
      if (this.parameters == null) {
        this.parameters = new ArrayList<Parameter>();
      }
      this.parameters.add(parameters);
      return this;
    }

    /**
     * Set the assessmentId.
     *
     * @param assessmentId the assessmentId
     * @return the Assessment builder
     */
    public Builder assessmentId(String assessmentId) {
      this.assessmentId = assessmentId;
      return this;
    }

    /**
     * Set the assessmentType.
     *
     * @param assessmentType the assessmentType
     * @return the Assessment builder
     */
    public Builder assessmentType(String assessmentType) {
      this.assessmentType = assessmentType;
      return this;
    }

    /**
     * Set the assessmentMethod.
     *
     * @param assessmentMethod the assessmentMethod
     * @return the Assessment builder
     */
    public Builder assessmentMethod(String assessmentMethod) {
      this.assessmentMethod = assessmentMethod;
      return this;
    }

    /**
     * Set the assessmentDescription.
     *
     * @param assessmentDescription the assessmentDescription
     * @return the Assessment builder
     */
    public Builder assessmentDescription(String assessmentDescription) {
      this.assessmentDescription = assessmentDescription;
      return this;
    }

    /**
     * Set the parameterCount.
     *
     * @param parameterCount the parameterCount
     * @return the Assessment builder
     */
    public Builder parameterCount(long parameterCount) {
      this.parameterCount = parameterCount;
      return this;
    }

    /**
     * Set the parameters.
     * Existing parameters will be replaced.
     *
     * @param parameters the parameters
     * @return the Assessment builder
     */
    public Builder parameters(List<Parameter> parameters) {
      this.parameters = parameters;
      return this;
    }
  }

  protected Assessment() { }

  protected Assessment(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.parameters,
      "parameters cannot be null");
    assessmentId = builder.assessmentId;
    assessmentType = builder.assessmentType;
    assessmentMethod = builder.assessmentMethod;
    assessmentDescription = builder.assessmentDescription;
    parameterCount = builder.parameterCount;
    parameters = builder.parameters;
  }

  /**
   * New builder.
   *
   * @return a Assessment builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assessmentId.
   *
   * The assessment ID.
   *
   * @return the assessmentId
   */
  public String assessmentId() {
    return assessmentId;
  }

  /**
   * Gets the assessmentType.
   *
   * The assessment type.
   *
   * @return the assessmentType
   */
  public String assessmentType() {
    return assessmentType;
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
   * Gets the assessmentDescription.
   *
   * The assessment description.
   *
   * @return the assessmentDescription
   */
  public String assessmentDescription() {
    return assessmentDescription;
  }

  /**
   * Gets the parameterCount.
   *
   * The number of parameters of this assessment.
   *
   * @return the parameterCount
   */
  public Long parameterCount() {
    return parameterCount;
  }

  /**
   * Gets the parameters.
   *
   * The list of parameters of this assessment.
   *
   * @return the parameters
   */
  public List<Parameter> parameters() {
    return parameters;
  }
}

