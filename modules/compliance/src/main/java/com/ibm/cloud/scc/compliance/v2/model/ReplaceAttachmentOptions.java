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
 * The replaceAttachment options.
 */
public class ReplaceAttachmentOptions extends GenericModel {

  /**
   * the type of the parameter.
   */
  public interface ParameterType {
    /** numeric. */
    String NUMERIC = "numeric";
    /** string_list. */
    String STRING_LIST = "string_list";
  }

  protected String profilesId;
  protected String attachmentId;
  protected String instanceId;
  protected String parameterName;
  protected String parameterDisplayName;
  protected String parameterType;
  protected String parameterValue;
  protected String assessmentType;
  protected String assessmentId;
  protected List<ParameterInfo> parameters;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String profilesId;
    private String attachmentId;
    private String instanceId;
    private String parameterName;
    private String parameterDisplayName;
    private String parameterType;
    private String parameterValue;
    private String assessmentType;
    private String assessmentId;
    private List<ParameterInfo> parameters;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing ReplaceAttachmentOptions instance.
     *
     * @param replaceAttachmentOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceAttachmentOptions replaceAttachmentOptions) {
      this.profilesId = replaceAttachmentOptions.profilesId;
      this.attachmentId = replaceAttachmentOptions.attachmentId;
      this.instanceId = replaceAttachmentOptions.instanceId;
      this.parameterName = replaceAttachmentOptions.parameterName;
      this.parameterDisplayName = replaceAttachmentOptions.parameterDisplayName;
      this.parameterType = replaceAttachmentOptions.parameterType;
      this.parameterValue = replaceAttachmentOptions.parameterValue;
      this.assessmentType = replaceAttachmentOptions.assessmentType;
      this.assessmentId = replaceAttachmentOptions.assessmentId;
      this.parameters = replaceAttachmentOptions.parameters;
      this.transactionId = replaceAttachmentOptions.transactionId;
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
     * @param instanceId the instanceId
     */
    public Builder(String profilesId, String attachmentId, String instanceId) {
      this.profilesId = profilesId;
      this.attachmentId = attachmentId;
      this.instanceId = instanceId;
    }

    /**
     * Builds a ReplaceAttachmentOptions.
     *
     * @return the new ReplaceAttachmentOptions instance
     */
    public ReplaceAttachmentOptions build() {
      return new ReplaceAttachmentOptions(this);
    }

    /**
     * Adds an parameters to parameters.
     *
     * @param parameters the new parameters
     * @return the ReplaceAttachmentOptions builder
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
     * Set the profilesId.
     *
     * @param profilesId the profilesId
     * @return the ReplaceAttachmentOptions builder
     */
    public Builder profilesId(String profilesId) {
      this.profilesId = profilesId;
      return this;
    }

    /**
     * Set the attachmentId.
     *
     * @param attachmentId the attachmentId
     * @return the ReplaceAttachmentOptions builder
     */
    public Builder attachmentId(String attachmentId) {
      this.attachmentId = attachmentId;
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ReplaceAttachmentOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the parameterName.
     *
     * @param parameterName the parameterName
     * @return the ReplaceAttachmentOptions builder
     */
    public Builder parameterName(String parameterName) {
      this.parameterName = parameterName;
      return this;
    }

    /**
     * Set the parameterDisplayName.
     *
     * @param parameterDisplayName the parameterDisplayName
     * @return the ReplaceAttachmentOptions builder
     */
    public Builder parameterDisplayName(String parameterDisplayName) {
      this.parameterDisplayName = parameterDisplayName;
      return this;
    }

    /**
     * Set the parameterType.
     *
     * @param parameterType the parameterType
     * @return the ReplaceAttachmentOptions builder
     */
    public Builder parameterType(String parameterType) {
      this.parameterType = parameterType;
      return this;
    }

    /**
     * Set the parameterValue.
     *
     * @param parameterValue the parameterValue
     * @return the ReplaceAttachmentOptions builder
     */
    public Builder parameterValue(String parameterValue) {
      this.parameterValue = parameterValue;
      return this;
    }

    /**
     * Set the assessmentType.
     *
     * @param assessmentType the assessmentType
     * @return the ReplaceAttachmentOptions builder
     */
    public Builder assessmentType(String assessmentType) {
      this.assessmentType = assessmentType;
      return this;
    }

    /**
     * Set the assessmentId.
     *
     * @param assessmentId the assessmentId
     * @return the ReplaceAttachmentOptions builder
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
     * @return the ReplaceAttachmentOptions builder
     */
    public Builder parameters(List<ParameterInfo> parameters) {
      this.parameters = parameters;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ReplaceAttachmentOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the parameterDetails.
     *
     * @param parameterDetails the parameterDetails
     * @return the ReplaceAttachmentOptions builder
     */
    public Builder parameterDetails(ParameterDetails parameterDetails) {
      this.parameterName = parameterDetails.parameterName();
      this.parameterDisplayName = parameterDetails.parameterDisplayName();
      this.parameterType = parameterDetails.parameterType();
      this.parameterValue = parameterDetails.parameterValue();
      this.assessmentType = parameterDetails.assessmentType();
      this.assessmentId = parameterDetails.assessmentId();
      this.parameters = parameterDetails.parameters();
      return this;
    }
  }

  protected ReplaceAttachmentOptions() { }

  protected ReplaceAttachmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profilesId,
      "profilesId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.attachmentId,
      "attachmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    profilesId = builder.profilesId;
    attachmentId = builder.attachmentId;
    instanceId = builder.instanceId;
    parameterName = builder.parameterName;
    parameterDisplayName = builder.parameterDisplayName;
    parameterType = builder.parameterType;
    parameterValue = builder.parameterValue;
    assessmentType = builder.assessmentType;
    assessmentId = builder.assessmentId;
    parameters = builder.parameters;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a ReplaceAttachmentOptions builder
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

