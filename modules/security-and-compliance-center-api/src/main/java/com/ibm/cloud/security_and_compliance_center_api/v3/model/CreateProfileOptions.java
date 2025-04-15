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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createProfile options.
 */
public class CreateProfileOptions extends GenericModel {

  protected String instanceId;
  protected String profileName;
  protected String profileVersion;
  protected List<ProfileControlsPrototype> controls;
  protected List<DefaultParameters> defaultParameters;
  protected String profileDescription;
  protected Boolean latest;
  protected String versionGroupLabel;
  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String profileName;
    private String profileVersion;
    private List<ProfileControlsPrototype> controls;
    private List<DefaultParameters> defaultParameters;
    private String profileDescription;
    private Boolean latest;
    private String versionGroupLabel;
    private String accountId;

    /**
     * Instantiates a new Builder from an existing CreateProfileOptions instance.
     *
     * @param createProfileOptions the instance to initialize the Builder with
     */
    private Builder(CreateProfileOptions createProfileOptions) {
      this.instanceId = createProfileOptions.instanceId;
      this.profileName = createProfileOptions.profileName;
      this.profileVersion = createProfileOptions.profileVersion;
      this.controls = createProfileOptions.controls;
      this.defaultParameters = createProfileOptions.defaultParameters;
      this.profileDescription = createProfileOptions.profileDescription;
      this.latest = createProfileOptions.latest;
      this.versionGroupLabel = createProfileOptions.versionGroupLabel;
      this.accountId = createProfileOptions.accountId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceId the instanceId
     * @param profileName the profileName
     * @param profileVersion the profileVersion
     * @param controls the controls
     * @param defaultParameters the defaultParameters
     */
    public Builder(String instanceId, String profileName, String profileVersion, List<ProfileControlsPrototype> controls, List<DefaultParameters> defaultParameters) {
      this.instanceId = instanceId;
      this.profileName = profileName;
      this.profileVersion = profileVersion;
      this.controls = controls;
      this.defaultParameters = defaultParameters;
    }

    /**
     * Builds a CreateProfileOptions.
     *
     * @return the new CreateProfileOptions instance
     */
    public CreateProfileOptions build() {
      return new CreateProfileOptions(this);
    }

    /**
     * Adds a new element to controls.
     *
     * @param controls the new element to be added
     * @return the CreateProfileOptions builder
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
     * Adds a new element to defaultParameters.
     *
     * @param defaultParameters the new element to be added
     * @return the CreateProfileOptions builder
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
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the CreateProfileOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the profileName.
     *
     * @param profileName the profileName
     * @return the CreateProfileOptions builder
     */
    public Builder profileName(String profileName) {
      this.profileName = profileName;
      return this;
    }

    /**
     * Set the profileVersion.
     *
     * @param profileVersion the profileVersion
     * @return the CreateProfileOptions builder
     */
    public Builder profileVersion(String profileVersion) {
      this.profileVersion = profileVersion;
      return this;
    }

    /**
     * Set the controls.
     * Existing controls will be replaced.
     *
     * @param controls the controls
     * @return the CreateProfileOptions builder
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
     * @return the CreateProfileOptions builder
     */
    public Builder defaultParameters(List<DefaultParameters> defaultParameters) {
      this.defaultParameters = defaultParameters;
      return this;
    }

    /**
     * Set the profileDescription.
     *
     * @param profileDescription the profileDescription
     * @return the CreateProfileOptions builder
     */
    public Builder profileDescription(String profileDescription) {
      this.profileDescription = profileDescription;
      return this;
    }

    /**
     * Set the latest.
     *
     * @param latest the latest
     * @return the CreateProfileOptions builder
     */
    public Builder latest(Boolean latest) {
      this.latest = latest;
      return this;
    }

    /**
     * Set the versionGroupLabel.
     *
     * @param versionGroupLabel the versionGroupLabel
     * @return the CreateProfileOptions builder
     */
    public Builder versionGroupLabel(String versionGroupLabel) {
      this.versionGroupLabel = versionGroupLabel;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateProfileOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected CreateProfileOptions() { }

  protected CreateProfileOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.profileName,
      "profileName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.profileVersion,
      "profileVersion cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controls,
      "controls cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.defaultParameters,
      "defaultParameters cannot be null");
    instanceId = builder.instanceId;
    profileName = builder.profileName;
    profileVersion = builder.profileVersion;
    controls = builder.controls;
    defaultParameters = builder.defaultParameters;
    profileDescription = builder.profileDescription;
    latest = builder.latest;
    versionGroupLabel = builder.versionGroupLabel;
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a CreateProfileOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The ID of the Security and Compliance Center instance.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
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
   * Gets the profileVersion.
   *
   * The version of the profile.
   *
   * @return the profileVersion
   */
  public String profileVersion() {
    return profileVersion;
  }

  /**
   * Gets the controls.
   *
   * List of controls associated with the profile.
   *
   * @return the controls
   */
  public List<ProfileControlsPrototype> controls() {
    return controls;
  }

  /**
   * Gets the defaultParameters.
   *
   * The default values when using the profile.
   *
   * @return the defaultParameters
   */
  public List<DefaultParameters> defaultParameters() {
    return defaultParameters;
  }

  /**
   * Gets the profileDescription.
   *
   * A description of what the profile should represent.
   *
   * @return the profileDescription
   */
  public String profileDescription() {
    return profileDescription;
  }

  /**
   * Gets the latest.
   *
   * Determines if the profile is up to date with the latest revisions.
   *
   * @return the latest
   */
  public Boolean latest() {
    return latest;
  }

  /**
   * Gets the versionGroupLabel.
   *
   * The unique identifier of the revision.
   *
   * @return the versionGroupLabel
   */
  public String versionGroupLabel() {
    return versionGroupLabel;
  }

  /**
   * Gets the accountId.
   *
   * The user account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

