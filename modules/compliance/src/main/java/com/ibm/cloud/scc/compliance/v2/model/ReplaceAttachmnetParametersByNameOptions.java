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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceAttachmnetParametersByName options.
 */
public class ReplaceAttachmnetParametersByNameOptions extends GenericModel {

  /**
   * the type of the parameter.
   */
  public interface NewParameterType {
    /** numeric. */
    String NUMERIC = "numeric";
    /** string_list. */
    String STRING_LIST = "string_list";
  }

  protected String profilesId;
  protected String attachmentId;
  protected String parameterName;
  protected String instanceId;
  protected String newParameterName;
  protected String newParameterDisplayName;
  protected String newParameterType;
  protected String newParameterValue;
  protected String newAssessmentType;
  protected String newAssessmentId;
  protected List<ParameterInfo> newParameters;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String profilesId;
    private String attachmentId;
    private String parameterName;
    private String instanceId;
    private String newParameterName;
    private String newParameterDisplayName;
    private String newParameterType;
    private String newParameterValue;
    private String newAssessmentType;
    private String newAssessmentId;
    private List<ParameterInfo> newParameters;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing ReplaceAttachmnetParametersByNameOptions instance.
     *
     * @param replaceAttachmnetParametersByNameOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceAttachmnetParametersByNameOptions replaceAttachmnetParametersByNameOptions) {
      this.profilesId = replaceAttachmnetParametersByNameOptions.profilesId;
      this.attachmentId = replaceAttachmnetParametersByNameOptions.attachmentId;
      this.parameterName = replaceAttachmnetParametersByNameOptions.parameterName;
      this.instanceId = replaceAttachmnetParametersByNameOptions.instanceId;
      this.newParameterName = replaceAttachmnetParametersByNameOptions.newParameterName;
      this.newParameterDisplayName = replaceAttachmnetParametersByNameOptions.newParameterDisplayName;
      this.newParameterType = replaceAttachmnetParametersByNameOptions.newParameterType;
      this.newParameterValue = replaceAttachmnetParametersByNameOptions.newParameterValue;
      this.newAssessmentType = replaceAttachmnetParametersByNameOptions.newAssessmentType;
      this.newAssessmentId = replaceAttachmnetParametersByNameOptions.newAssessmentId;
      this.newParameters = replaceAttachmnetParametersByNameOptions.newParameters;
      this.transactionId = replaceAttachmnetParametersByNameOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param profilesId the profilesId
     * @param attachmentId the attachmentId
     * @param parameterName the parameterName
     * @param instanceId the instanceId
     */
    public Builder(String profilesId, String attachmentId, String parameterName, String instanceId) {
      this.profilesId = profilesId;
      this.attachmentId = attachmentId;
      this.parameterName = parameterName;
      this.instanceId = instanceId;
    }

    /**
     * Builds a ReplaceAttachmnetParametersByNameOptions.
     *
     * @return the new ReplaceAttachmnetParametersByNameOptions instance
     */
    public ReplaceAttachmnetParametersByNameOptions build() {
      return new ReplaceAttachmnetParametersByNameOptions(this);
    }

    /**
     * Adds an newParameters to newParameters.
     *
     * @param newParameters the new newParameters
     * @return the ReplaceAttachmnetParametersByNameOptions builder
     */
    public Builder addNewParameters(ParameterInfo newParameters) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(newParameters,
        "newParameters cannot be null");
      if (this.newParameters == null) {
        this.newParameters = new ArrayList<ParameterInfo>();
      }
      this.newParameters.add(newParameters);
      return this;
    }

    /**
     * Set the profilesId.
     *
     * @param profilesId the profilesId
     * @return the ReplaceAttachmnetParametersByNameOptions builder
     */
    public Builder profilesId(String profilesId) {
      this.profilesId = profilesId;
      return this;
    }

    /**
     * Set the attachmentId.
     *
     * @param attachmentId the attachmentId
     * @return the ReplaceAttachmnetParametersByNameOptions builder
     */
    public Builder attachmentId(String attachmentId) {
      this.attachmentId = attachmentId;
      return this;
    }

    /**
     * Set the parameterName.
     *
     * @param parameterName the parameterName
     * @return the ReplaceAttachmnetParametersByNameOptions builder
     */
    public Builder parameterName(String parameterName) {
      this.parameterName = parameterName;
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ReplaceAttachmnetParametersByNameOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the newParameterName.
     *
     * @param newParameterName the newParameterName
     * @return the ReplaceAttachmnetParametersByNameOptions builder
     */
    public Builder newParameterName(String newParameterName) {
      this.newParameterName = newParameterName;
      return this;
    }

    /**
     * Set the newParameterDisplayName.
     *
     * @param newParameterDisplayName the newParameterDisplayName
     * @return the ReplaceAttachmnetParametersByNameOptions builder
     */
    public Builder newParameterDisplayName(String newParameterDisplayName) {
      this.newParameterDisplayName = newParameterDisplayName;
      return this;
    }

    /**
     * Set the newParameterType.
     *
     * @param newParameterType the newParameterType
     * @return the ReplaceAttachmnetParametersByNameOptions builder
     */
    public Builder newParameterType(String newParameterType) {
      this.newParameterType = newParameterType;
      return this;
    }

    /**
     * Set the newParameterValue.
     *
     * @param newParameterValue the newParameterValue
     * @return the ReplaceAttachmnetParametersByNameOptions builder
     */
    public Builder newParameterValue(String newParameterValue) {
      this.newParameterValue = newParameterValue;
      return this;
    }

    /**
     * Set the newAssessmentType.
     *
     * @param newAssessmentType the newAssessmentType
     * @return the ReplaceAttachmnetParametersByNameOptions builder
     */
    public Builder newAssessmentType(String newAssessmentType) {
      this.newAssessmentType = newAssessmentType;
      return this;
    }

    /**
     * Set the newAssessmentId.
     *
     * @param newAssessmentId the newAssessmentId
     * @return the ReplaceAttachmnetParametersByNameOptions builder
     */
    public Builder newAssessmentId(String newAssessmentId) {
      this.newAssessmentId = newAssessmentId;
      return this;
    }

    /**
     * Set the newParameters.
     * Existing newParameters will be replaced.
     *
     * @param newParameters the newParameters
     * @return the ReplaceAttachmnetParametersByNameOptions builder
     */
    public Builder newParameters(List<ParameterInfo> newParameters) {
      this.newParameters = newParameters;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ReplaceAttachmnetParametersByNameOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the parameterDetails.
     *
     * @param parameterDetails the parameterDetails
     * @return the ReplaceAttachmnetParametersByNameOptions builder
     */
    public Builder parameterDetails(ParameterDetails parameterDetails) {
      this.newParameterName = parameterDetails.parameterName();
      this.newParameterDisplayName = parameterDetails.parameterDisplayName();
      this.newParameterType = parameterDetails.parameterType();
      this.newParameterValue = parameterDetails.parameterValue();
      this.newAssessmentType = parameterDetails.assessmentType();
      this.newAssessmentId = parameterDetails.assessmentId();
      this.newParameters = parameterDetails.parameters();
      return this;
    }
  }

  protected ReplaceAttachmnetParametersByNameOptions() { }

  protected ReplaceAttachmnetParametersByNameOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profilesId,
      "profilesId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.attachmentId,
      "attachmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.parameterName,
      "parameterName cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    profilesId = builder.profilesId;
    attachmentId = builder.attachmentId;
    parameterName = builder.parameterName;
    instanceId = builder.instanceId;
    newParameterName = builder.newParameterName;
    newParameterDisplayName = builder.newParameterDisplayName;
    newParameterType = builder.newParameterType;
    newParameterValue = builder.newParameterValue;
    newAssessmentType = builder.newAssessmentType;
    newAssessmentId = builder.newAssessmentId;
    newParameters = builder.newParameters;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a ReplaceAttachmnetParametersByNameOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the profilesId.
   *
   * The profile ID.
   *
   * @return the profilesId
   */
  public String profilesId() {
    return profilesId;
  }

  /**
   * Gets the attachmentId.
   *
   * The attachment ID.
   *
   * @return the attachmentId
   */
  public String attachmentId() {
    return attachmentId;
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
   * Gets the instanceId.
   *
   * Instance id.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the newParameterName.
   *
   * The name of the parameter.
   *
   * @return the newParameterName
   */
  public String newParameterName() {
    return newParameterName;
  }

  /**
   * Gets the newParameterDisplayName.
   *
   * The display name of the parameter.
   *
   * @return the newParameterDisplayName
   */
  public String newParameterDisplayName() {
    return newParameterDisplayName;
  }

  /**
   * Gets the newParameterType.
   *
   * the type of the parameter.
   *
   * @return the newParameterType
   */
  public String newParameterType() {
    return newParameterType;
  }

  /**
   * Gets the newParameterValue.
   *
   * The value of the parameter.
   *
   * @return the newParameterValue
   */
  public String newParameterValue() {
    return newParameterValue;
  }

  /**
   * Gets the newAssessmentType.
   *
   * The assessment type of the parameter.
   *
   * @return the newAssessmentType
   */
  public String newAssessmentType() {
    return newAssessmentType;
  }

  /**
   * Gets the newAssessmentId.
   *
   * The Assessment ID of the parameter.
   *
   * @return the newAssessmentId
   */
  public String newAssessmentId() {
    return newAssessmentId;
  }

  /**
   * Gets the newParameters.
   *
   * Parameters.
   *
   * @return the newParameters
   */
  public List<ParameterInfo> newParameters() {
    return newParameters;
  }

  /**
   * Gets the transactionId.
   *
   * The transaction ID for the request in UUID v4 format.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

