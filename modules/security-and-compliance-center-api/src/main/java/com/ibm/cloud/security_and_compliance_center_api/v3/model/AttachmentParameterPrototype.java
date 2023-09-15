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
 * The parameters related to the Attachment.
 */
public class AttachmentParameterPrototype extends GenericModel {

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
  @SerializedName("parameter_value")
  protected String parameterValue;
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
    private String parameterValue;
    private String parameterDisplayName;
    private String parameterType;

    /**
     * Instantiates a new Builder from an existing AttachmentParameterPrototype instance.
     *
     * @param attachmentParameterPrototype the instance to initialize the Builder with
     */
    private Builder(AttachmentParameterPrototype attachmentParameterPrototype) {
      this.assessmentType = attachmentParameterPrototype.assessmentType;
      this.assessmentId = attachmentParameterPrototype.assessmentId;
      this.parameterName = attachmentParameterPrototype.parameterName;
      this.parameterValue = attachmentParameterPrototype.parameterValue;
      this.parameterDisplayName = attachmentParameterPrototype.parameterDisplayName;
      this.parameterType = attachmentParameterPrototype.parameterType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AttachmentParameterPrototype.
     *
     * @return the new AttachmentParameterPrototype instance
     */
    public AttachmentParameterPrototype build() {
      return new AttachmentParameterPrototype(this);
    }

    /**
     * Set the assessmentType.
     *
     * @param assessmentType the assessmentType
     * @return the AttachmentParameterPrototype builder
     */
    public Builder assessmentType(String assessmentType) {
      this.assessmentType = assessmentType;
      return this;
    }

    /**
     * Set the assessmentId.
     *
     * @param assessmentId the assessmentId
     * @return the AttachmentParameterPrototype builder
     */
    public Builder assessmentId(String assessmentId) {
      this.assessmentId = assessmentId;
      return this;
    }

    /**
     * Set the parameterName.
     *
     * @param parameterName the parameterName
     * @return the AttachmentParameterPrototype builder
     */
    public Builder parameterName(String parameterName) {
      this.parameterName = parameterName;
      return this;
    }

    /**
     * Set the parameterValue.
     *
     * @param parameterValue the parameterValue
     * @return the AttachmentParameterPrototype builder
     */
    public Builder parameterValue(String parameterValue) {
      this.parameterValue = parameterValue;
      return this;
    }

    /**
     * Set the parameterDisplayName.
     *
     * @param parameterDisplayName the parameterDisplayName
     * @return the AttachmentParameterPrototype builder
     */
    public Builder parameterDisplayName(String parameterDisplayName) {
      this.parameterDisplayName = parameterDisplayName;
      return this;
    }

    /**
     * Set the parameterType.
     *
     * @param parameterType the parameterType
     * @return the AttachmentParameterPrototype builder
     */
    public Builder parameterType(String parameterType) {
      this.parameterType = parameterType;
      return this;
    }
  }

  protected AttachmentParameterPrototype() { }

  protected AttachmentParameterPrototype(Builder builder) {
    assessmentType = builder.assessmentType;
    assessmentId = builder.assessmentId;
    parameterName = builder.parameterName;
    parameterValue = builder.parameterValue;
    parameterDisplayName = builder.parameterDisplayName;
    parameterType = builder.parameterType;
  }

  /**
   * New builder.
   *
   * @return a AttachmentParameterPrototype builder
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

