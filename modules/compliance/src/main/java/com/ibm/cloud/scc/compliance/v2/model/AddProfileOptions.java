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
 * The addProfile options.
 */
public class AddProfileOptions extends GenericModel {

  /**
   * Type of the profile.
   */
  public interface ProfileType {
    /** predefined. */
    String PREDEFINED = "predefined";
    /** custom. */
    String CUSTOM = "custom";
  }

  protected String profilesId;
  protected String instanceId;
  protected String profileName;
  protected String profileDescription;
  protected String profileType;
  protected String profileVersion;
  protected Boolean latest;
  protected String versionGroupLabel;
  protected List<ProfileControlsInRequest> controls;
  protected List<DefaultParameters> defaultParameters;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String profilesId;
    private String instanceId;
    private String profileName;
    private String profileDescription;
    private String profileType;
    private String profileVersion;
    private Boolean latest;
    private String versionGroupLabel;
    private List<ProfileControlsInRequest> controls;
    private List<DefaultParameters> defaultParameters;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing AddProfileOptions instance.
     *
     * @param addProfileOptions the instance to initialize the Builder with
     */
    private Builder(AddProfileOptions addProfileOptions) {
      this.profilesId = addProfileOptions.profilesId;
      this.instanceId = addProfileOptions.instanceId;
      this.profileName = addProfileOptions.profileName;
      this.profileDescription = addProfileOptions.profileDescription;
      this.profileType = addProfileOptions.profileType;
      this.profileVersion = addProfileOptions.profileVersion;
      this.latest = addProfileOptions.latest;
      this.versionGroupLabel = addProfileOptions.versionGroupLabel;
      this.controls = addProfileOptions.controls;
      this.defaultParameters = addProfileOptions.defaultParameters;
      this.transactionId = addProfileOptions.transactionId;
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
     * @param instanceId the instanceId
     */
    public Builder(String profilesId, String instanceId) {
      this.profilesId = profilesId;
      this.instanceId = instanceId;
    }

    /**
     * Builds a AddProfileOptions.
     *
     * @return the new AddProfileOptions instance
     */
    public AddProfileOptions build() {
      return new AddProfileOptions(this);
    }

    /**
     * Adds an controls to controls.
     *
     * @param controls the new controls
     * @return the AddProfileOptions builder
     */
    public Builder addControls(ProfileControlsInRequest controls) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(controls,
        "controls cannot be null");
      if (this.controls == null) {
        this.controls = new ArrayList<ProfileControlsInRequest>();
      }
      this.controls.add(controls);
      return this;
    }

    /**
     * Adds an defaultParameters to defaultParameters.
     *
     * @param defaultParameters the new defaultParameters
     * @return the AddProfileOptions builder
     */
    public Builder addDefaultParameters(DefaultParameters defaultParameters) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(defaultParameters,
        "defaultParameters cannot be null");
      if (this.defaultParameters == null) {
        this.defaultParameters = new ArrayList<DefaultParameters>();
      }
      this.defaultParameters.add(defaultParameters);
      return this;
    }

    /**
     * Set the profilesId.
     *
     * @param profilesId the profilesId
     * @return the AddProfileOptions builder
     */
    public Builder profilesId(String profilesId) {
      this.profilesId = profilesId;
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the AddProfileOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the profileName.
     *
     * @param profileName the profileName
     * @return the AddProfileOptions builder
     */
    public Builder profileName(String profileName) {
      this.profileName = profileName;
      return this;
    }

    /**
     * Set the profileDescription.
     *
     * @param profileDescription the profileDescription
     * @return the AddProfileOptions builder
     */
    public Builder profileDescription(String profileDescription) {
      this.profileDescription = profileDescription;
      return this;
    }

    /**
     * Set the profileType.
     *
     * @param profileType the profileType
     * @return the AddProfileOptions builder
     */
    public Builder profileType(String profileType) {
      this.profileType = profileType;
      return this;
    }

    /**
     * Set the profileVersion.
     *
     * @param profileVersion the profileVersion
     * @return the AddProfileOptions builder
     */
    public Builder profileVersion(String profileVersion) {
      this.profileVersion = profileVersion;
      return this;
    }

    /**
     * Set the latest.
     *
     * @param latest the latest
     * @return the AddProfileOptions builder
     */
    public Builder latest(Boolean latest) {
      this.latest = latest;
      return this;
    }

    /**
     * Set the versionGroupLabel.
     *
     * @param versionGroupLabel the versionGroupLabel
     * @return the AddProfileOptions builder
     */
    public Builder versionGroupLabel(String versionGroupLabel) {
      this.versionGroupLabel = versionGroupLabel;
      return this;
    }

    /**
     * Set the controls.
     * Existing controls will be replaced.
     *
     * @param controls the controls
     * @return the AddProfileOptions builder
     */
    public Builder controls(List<ProfileControlsInRequest> controls) {
      this.controls = controls;
      return this;
    }

    /**
     * Set the defaultParameters.
     * Existing defaultParameters will be replaced.
     *
     * @param defaultParameters the defaultParameters
     * @return the AddProfileOptions builder
     */
    public Builder defaultParameters(List<DefaultParameters> defaultParameters) {
      this.defaultParameters = defaultParameters;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the AddProfileOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected AddProfileOptions() { }

  protected AddProfileOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profilesId,
      "profilesId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    profilesId = builder.profilesId;
    instanceId = builder.instanceId;
    profileName = builder.profileName;
    profileDescription = builder.profileDescription;
    profileType = builder.profileType;
    profileVersion = builder.profileVersion;
    latest = builder.latest;
    versionGroupLabel = builder.versionGroupLabel;
    controls = builder.controls;
    defaultParameters = builder.defaultParameters;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a AddProfileOptions builder
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
   * Gets the profileName.
   *
   * Name of the Profile.
   *
   * @return the profileName
   */
  public String profileName() {
    return profileName;
  }

  /**
   * Gets the profileDescription.
   *
   * Description of the profile.
   *
   * @return the profileDescription
   */
  public String profileDescription() {
    return profileDescription;
  }

  /**
   * Gets the profileType.
   *
   * Type of the profile.
   *
   * @return the profileType
   */
  public String profileType() {
    return profileType;
  }

  /**
   * Gets the profileVersion.
   *
   * Version of the profile.
   *
   * @return the profileVersion
   */
  public String profileVersion() {
    return profileVersion;
  }

  /**
   * Gets the latest.
   *
   * If Latest is enabled or not.
   *
   * @return the latest
   */
  public Boolean latest() {
    return latest;
  }

  /**
   * Gets the versionGroupLabel.
   *
   * The version group label of the profile.
   *
   * @return the versionGroupLabel
   */
  public String versionGroupLabel() {
    return versionGroupLabel;
  }

  /**
   * Gets the controls.
   *
   * Controls in the profile.
   *
   * @return the controls
   */
  public List<ProfileControlsInRequest> controls() {
    return controls;
  }

  /**
   * Gets the defaultParameters.
   *
   * default parameters of the profile.
   *
   * @return the defaultParameters
   */
  public List<DefaultParameters> defaultParameters() {
    return defaultParameters;
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

