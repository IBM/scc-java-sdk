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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The implementation details of a control library.
 */
public class Implementation extends GenericModel {

  @SerializedName("assessment_id")
  protected String assessmentId;
  @SerializedName("assessment_method")
  protected String assessmentMethod;
  @SerializedName("assessment_type")
  protected String assessmentType;
  @SerializedName("assessment_description")
  protected String assessmentDescription;
  @SerializedName("parameter_count")
  protected Long parameterCount;
  protected List<ParameterInfo> parameters;

  /**
   * Builder.
   */
  public static class Builder {
    private String assessmentId;
    private String assessmentMethod;
    private String assessmentType;
    private String assessmentDescription;
    private Long parameterCount;
    private List<ParameterInfo> parameters;

    /**
     * Instantiates a new Builder from an existing Implementation instance.
     *
     * @param implementation the instance to initialize the Builder with
     */
    private Builder(Implementation implementation) {
      this.assessmentId = implementation.assessmentId;
      this.assessmentMethod = implementation.assessmentMethod;
      this.assessmentType = implementation.assessmentType;
      this.assessmentDescription = implementation.assessmentDescription;
      this.parameterCount = implementation.parameterCount;
      this.parameters = implementation.parameters;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Implementation.
     *
     * @return the new Implementation instance
     */
    public Implementation build() {
      return new Implementation(this);
    }

    /**
     * Adds an parameters to parameters.
     *
     * @param parameters the new parameters
     * @return the Implementation builder
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
     * Set the assessmentId.
     *
     * @param assessmentId the assessmentId
     * @return the Implementation builder
     */
    public Builder assessmentId(String assessmentId) {
      this.assessmentId = assessmentId;
      return this;
    }

    /**
     * Set the assessmentMethod.
     *
     * @param assessmentMethod the assessmentMethod
     * @return the Implementation builder
     */
    public Builder assessmentMethod(String assessmentMethod) {
      this.assessmentMethod = assessmentMethod;
      return this;
    }

    /**
     * Set the assessmentType.
     *
     * @param assessmentType the assessmentType
     * @return the Implementation builder
     */
    public Builder assessmentType(String assessmentType) {
      this.assessmentType = assessmentType;
      return this;
    }

    /**
     * Set the assessmentDescription.
     *
     * @param assessmentDescription the assessmentDescription
     * @return the Implementation builder
     */
    public Builder assessmentDescription(String assessmentDescription) {
      this.assessmentDescription = assessmentDescription;
      return this;
    }

    /**
     * Set the parameterCount.
     *
     * @param parameterCount the parameterCount
     * @return the Implementation builder
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
     * @return the Implementation builder
     */
    public Builder parameters(List<ParameterInfo> parameters) {
      this.parameters = parameters;
      return this;
    }
  }

  protected Implementation() { }

  protected Implementation(Builder builder) {
    assessmentId = builder.assessmentId;
    assessmentMethod = builder.assessmentMethod;
    assessmentType = builder.assessmentType;
    assessmentDescription = builder.assessmentDescription;
    parameterCount = builder.parameterCount;
    parameters = builder.parameters;
  }

  /**
   * New builder.
   *
   * @return a Implementation builder
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
   * The parameter count.
   *
   * @return the parameterCount
   */
  public Long parameterCount() {
    return parameterCount;
  }

  /**
   * Gets the parameters.
   *
   * The parameters.
   *
   * @return the parameters
   */
  public List<ParameterInfo> parameters() {
    return parameters;
  }
}

