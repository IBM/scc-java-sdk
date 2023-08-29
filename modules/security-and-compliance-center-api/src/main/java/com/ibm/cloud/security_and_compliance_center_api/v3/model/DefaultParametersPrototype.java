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
 * The control details of a profile.
 */
public class DefaultParametersPrototype extends GenericModel {

  /**
   * The parameter type.
   */
  public interface ParameterType {
    /** string. */
    String STRING = "string";
    /** numeric. */
    String NUMERIC = "numeric";
    /** general. */
    String GENERAL = "general";
    /** boolean. */
    String X_BOOLEAN = "boolean";
    /** string_list. */
    String STRING_LIST = "string_list";
    /** ip_list. */
    String IP_LIST = "ip_list";
    /** timestamp. */
    String TIMESTAMP = "timestamp";
  }

  @SerializedName("assessment_type")
  protected String assessmentType;
  @SerializedName("assessment_id")
  protected String assessmentId;
  @SerializedName("parameter_name")
  protected String parameterName;
  @SerializedName("parameter_default_value")
  protected String parameterDefaultValue;
  @SerializedName("parameter_display_name")
  protected String parameterDisplayName;
  @SerializedName("parameter_type")
  protected String parameterType;

  /**
   * Builder.
   */
  public static class Builder {
    private String assessmentType;
    private String assessmentId;
    private String parameterName;
    private String parameterDefaultValue;
    private String parameterDisplayName;
    private String parameterType;

    /**
     * Instantiates a new Builder from an existing DefaultParametersPrototype instance.
     *
     * @param defaultParametersPrototype the instance to initialize the Builder with
     */
    private Builder(DefaultParametersPrototype defaultParametersPrototype) {
      this.assessmentType = defaultParametersPrototype.assessmentType;
      this.assessmentId = defaultParametersPrototype.assessmentId;
      this.parameterName = defaultParametersPrototype.parameterName;
      this.parameterDefaultValue = defaultParametersPrototype.parameterDefaultValue;
      this.parameterDisplayName = defaultParametersPrototype.parameterDisplayName;
      this.parameterType = defaultParametersPrototype.parameterType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DefaultParametersPrototype.
     *
     * @return the new DefaultParametersPrototype instance
     */
    public DefaultParametersPrototype build() {
      return new DefaultParametersPrototype(this);
    }

    /**
     * Set the assessmentType.
     *
     * @param assessmentType the assessmentType
     * @return the DefaultParametersPrototype builder
     */
    public Builder assessmentType(String assessmentType) {
      this.assessmentType = assessmentType;
      return this;
    }

    /**
     * Set the assessmentId.
     *
     * @param assessmentId the assessmentId
     * @return the DefaultParametersPrototype builder
     */
    public Builder assessmentId(String assessmentId) {
      this.assessmentId = assessmentId;
      return this;
    }

    /**
     * Set the parameterName.
     *
     * @param parameterName the parameterName
     * @return the DefaultParametersPrototype builder
     */
    public Builder parameterName(String parameterName) {
      this.parameterName = parameterName;
      return this;
    }

    /**
     * Set the parameterDefaultValue.
     *
     * @param parameterDefaultValue the parameterDefaultValue
     * @return the DefaultParametersPrototype builder
     */
    public Builder parameterDefaultValue(String parameterDefaultValue) {
      this.parameterDefaultValue = parameterDefaultValue;
      return this;
    }

    /**
     * Set the parameterDisplayName.
     *
     * @param parameterDisplayName the parameterDisplayName
     * @return the DefaultParametersPrototype builder
     */
    public Builder parameterDisplayName(String parameterDisplayName) {
      this.parameterDisplayName = parameterDisplayName;
      return this;
    }

    /**
     * Set the parameterType.
     *
     * @param parameterType the parameterType
     * @return the DefaultParametersPrototype builder
     */
    public Builder parameterType(String parameterType) {
      this.parameterType = parameterType;
      return this;
    }
  }

  protected DefaultParametersPrototype() { }

  protected DefaultParametersPrototype(Builder builder) {
    assessmentType = builder.assessmentType;
    assessmentId = builder.assessmentId;
    parameterName = builder.parameterName;
    parameterDefaultValue = builder.parameterDefaultValue;
    parameterDisplayName = builder.parameterDisplayName;
    parameterType = builder.parameterType;
  }

  /**
   * New builder.
   *
   * @return a DefaultParametersPrototype builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assessmentType.
   *
   * The type of the implementation.
   *
   * @return the assessmentType
   */
  public String assessmentType() {
    return assessmentType;
  }

  /**
   * Gets the assessmentId.
   *
   * The implementation ID of the parameter.
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
   * Gets the parameterDefaultValue.
   *
   * The default value of the parameter.
   *
   * @return the parameterDefaultValue
   */
  public String parameterDefaultValue() {
    return parameterDefaultValue;
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
}

