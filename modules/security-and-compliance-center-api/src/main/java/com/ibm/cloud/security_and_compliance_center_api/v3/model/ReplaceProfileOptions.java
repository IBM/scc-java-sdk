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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceProfile options.
 */
public class ReplaceProfileOptions extends GenericModel {

  /**
   * The profile type.
   */
  public interface ProfileType {
    /** predefined. */
    String PREDEFINED = "predefined";
    /** custom. */
    String CUSTOM = "custom";
  }

  protected String profilesId;
  protected String profileName;
  protected String profileDescription;
  protected String profileType;
  protected List<ProfileControlsPrototype> controls;
  protected List<DefaultParametersPrototype> defaultParameters;
  protected String xCorrelationId;
  protected String xRequestId;

  /**
   * Builder.
   */
  public static class Builder {
    private String profilesId;
    private String profileName;
    private String profileDescription;
    private String profileType;
    private List<ProfileControlsPrototype> controls;
    private List<DefaultParametersPrototype> defaultParameters;
    private String xCorrelationId;
    private String xRequestId;

    /**
     * Instantiates a new Builder from an existing ReplaceProfileOptions instance.
     *
     * @param replaceProfileOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceProfileOptions replaceProfileOptions) {
      this.profilesId = replaceProfileOptions.profilesId;
      this.profileName = replaceProfileOptions.profileName;
      this.profileDescription = replaceProfileOptions.profileDescription;
      this.profileType = replaceProfileOptions.profileType;
      this.controls = replaceProfileOptions.controls;
      this.defaultParameters = replaceProfileOptions.defaultParameters;
      this.xCorrelationId = replaceProfileOptions.xCorrelationId;
      this.xRequestId = replaceProfileOptions.xRequestId;
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
     * @param profileName the profileName
     * @param profileDescription the profileDescription
     * @param profileType the profileType
     * @param controls the controls
     * @param defaultParameters the defaultParameters
     */
    public Builder(String profilesId, String profileName, String profileDescription, String profileType, List<ProfileControlsPrototype> controls, List<DefaultParametersPrototype> defaultParameters) {
      this.profilesId = profilesId;
      this.profileName = profileName;
      this.profileDescription = profileDescription;
      this.profileType = profileType;
      this.controls = controls;
      this.defaultParameters = defaultParameters;
    }

    /**
     * Builds a ReplaceProfileOptions.
     *
     * @return the new ReplaceProfileOptions instance
     */
    public ReplaceProfileOptions build() {
      return new ReplaceProfileOptions(this);
    }

    /**
     * Adds an controls to controls.
     *
     * @param controls the new controls
     * @return the ReplaceProfileOptions builder
     */
    public Builder addControls(ProfileControlsPrototype controls) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(controls,
        "controls cannot be null");
      if (this.controls == null) {
        this.controls = new ArrayList<ProfileControlsPrototype>();
      }
      this.controls.add(controls);
      return this;
    }

    /**
     * Adds an defaultParameters to defaultParameters.
     *
     * @param defaultParameters the new defaultParameters
     * @return the ReplaceProfileOptions builder
     */
    public Builder addDefaultParameters(DefaultParametersPrototype defaultParameters) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(defaultParameters,
        "defaultParameters cannot be null");
      if (this.defaultParameters == null) {
        this.defaultParameters = new ArrayList<DefaultParametersPrototype>();
      }
      this.defaultParameters.add(defaultParameters);
      return this;
    }

    /**
     * Set the profilesId.
     *
     * @param profilesId the profilesId
     * @return the ReplaceProfileOptions builder
     */
    public Builder profilesId(String profilesId) {
      this.profilesId = profilesId;
      return this;
    }

    /**
     * Set the profileName.
     *
     * @param profileName the profileName
     * @return the ReplaceProfileOptions builder
     */
    public Builder profileName(String profileName) {
      this.profileName = profileName;
      return this;
    }

    /**
     * Set the profileDescription.
     *
     * @param profileDescription the profileDescription
     * @return the ReplaceProfileOptions builder
     */
    public Builder profileDescription(String profileDescription) {
      this.profileDescription = profileDescription;
      return this;
    }

    /**
     * Set the profileType.
     *
     * @param profileType the profileType
     * @return the ReplaceProfileOptions builder
     */
    public Builder profileType(String profileType) {
      this.profileType = profileType;
      return this;
    }

    /**
     * Set the controls.
     * Existing controls will be replaced.
     *
     * @param controls the controls
     * @return the ReplaceProfileOptions builder
     */
    public Builder controls(List<ProfileControlsPrototype> controls) {
      this.controls = controls;
      return this;
    }

    /**
     * Set the defaultParameters.
     * Existing defaultParameters will be replaced.
     *
     * @param defaultParameters the defaultParameters
     * @return the ReplaceProfileOptions builder
     */
    public Builder defaultParameters(List<DefaultParametersPrototype> defaultParameters) {
      this.defaultParameters = defaultParameters;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the ReplaceProfileOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the ReplaceProfileOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }
  }

  protected ReplaceProfileOptions() { }

  protected ReplaceProfileOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profilesId,
      "profilesId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.profileName,
      "profileName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.profileDescription,
      "profileDescription cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.profileType,
      "profileType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controls,
      "controls cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.defaultParameters,
      "defaultParameters cannot be null");
    profilesId = builder.profilesId;
    profileName = builder.profileName;
    profileDescription = builder.profileDescription;
    profileType = builder.profileType;
    controls = builder.controls;
    defaultParameters = builder.defaultParameters;
    xCorrelationId = builder.xCorrelationId;
    xRequestId = builder.xRequestId;
  }

  /**
   * New builder.
   *
   * @return a ReplaceProfileOptions builder
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
   * Gets the profileName.
   *
   * The name of the profile.
   *
   * @return the profileName
   */
  public String profileName() {
    return profileName;
  }

  /**
   * Gets the profileDescription.
   *
   * The description of the profile.
   *
   * @return the profileDescription
   */
  public String profileDescription() {
    return profileDescription;
  }

  /**
   * Gets the profileType.
   *
   * The profile type.
   *
   * @return the profileType
   */
  public String profileType() {
    return profileType;
  }

  /**
   * Gets the controls.
   *
   * The controls that are in the profile.
   *
   * @return the controls
   */
  public List<ProfileControlsPrototype> controls() {
    return controls;
  }

  /**
   * Gets the defaultParameters.
   *
   * The default parameters of the profile.
   *
   * @return the defaultParameters
   */
  public List<DefaultParametersPrototype> defaultParameters() {
    return defaultParameters;
  }

  /**
   * Gets the xCorrelationId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header for the
   * corresponding response. The same value is used for downstream requests and retries of those requests. If a value of
   * this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xCorrelationId
   */
  public String xCorrelationId() {
    return xCorrelationId;
  }

  /**
   * Gets the xRequestId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header for the
   * corresponding response. The same value is not used for downstream requests and retries of those requests. If a
   * value of this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xRequestId
   */
  public String xRequestId() {
    return xRequestId;
  }
}

