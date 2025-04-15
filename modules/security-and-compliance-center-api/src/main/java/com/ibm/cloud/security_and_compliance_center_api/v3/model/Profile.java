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
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A group of controls that are related to a compliance objective.
 */
public class Profile extends GenericModel {

  /**
   * The type of profile, either predefined or custom.
   */
  public interface ProfileType {
    /** custom. */
    String CUSTOM = "custom";
    /** predefined. */
    String PREDEFINED = "predefined";
  }

  protected String id;
  @SerializedName("profile_name")
  protected String profileName;
  @SerializedName("instance_id")
  protected String instanceId;
  @SerializedName("hierarchy_enabled")
  protected Boolean hierarchyEnabled;
  @SerializedName("profile_description")
  protected String profileDescription;
  @SerializedName("profile_type")
  protected String profileType;
  @SerializedName("profile_version")
  protected String profileVersion;
  @SerializedName("version_group_label")
  protected String versionGroupLabel;
  protected Boolean latest;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("created_on")
  protected Date createdOn;
  @SerializedName("updated_by")
  protected String updatedBy;
  @SerializedName("updated_on")
  protected Date updatedOn;
  @SerializedName("controls_count")
  protected Long controlsCount;
  @SerializedName("attachments_count")
  protected Long attachmentsCount;
  protected List<ProfileControls> controls;
  @SerializedName("default_parameters")
  protected List<DefaultParameters> defaultParameters;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String profileName;
    private String instanceId;
    private Boolean hierarchyEnabled;
    private String profileDescription;
    private String profileType;
    private String profileVersion;
    private String versionGroupLabel;
    private Boolean latest;
    private String createdBy;
    private Date createdOn;
    private String updatedBy;
    private Date updatedOn;
    private Long controlsCount;
    private Long attachmentsCount;
    private List<ProfileControls> controls;
    private List<DefaultParameters> defaultParameters;

    /**
     * Instantiates a new Builder from an existing Profile instance.
     *
     * @param profile the instance to initialize the Builder with
     */
    private Builder(Profile profile) {
      this.id = profile.id;
      this.profileName = profile.profileName;
      this.instanceId = profile.instanceId;
      this.hierarchyEnabled = profile.hierarchyEnabled;
      this.profileDescription = profile.profileDescription;
      this.profileType = profile.profileType;
      this.profileVersion = profile.profileVersion;
      this.versionGroupLabel = profile.versionGroupLabel;
      this.latest = profile.latest;
      this.createdBy = profile.createdBy;
      this.createdOn = profile.createdOn;
      this.updatedBy = profile.updatedBy;
      this.updatedOn = profile.updatedOn;
      this.controlsCount = profile.controlsCount;
      this.attachmentsCount = profile.attachmentsCount;
      this.controls = profile.controls;
      this.defaultParameters = profile.defaultParameters;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param profileType the profileType
     * @param controls the controls
     * @param defaultParameters the defaultParameters
     */
    public Builder(String profileType, List<ProfileControls> controls, List<DefaultParameters> defaultParameters) {
      this.profileType = profileType;
      this.controls = controls;
      this.defaultParameters = defaultParameters;
    }

    /**
     * Builds a Profile.
     *
     * @return the new Profile instance
     */
    public Profile build() {
      return new Profile(this);
    }

    /**
     * Adds a new element to controls.
     *
     * @param controls the new element to be added
     * @return the Profile builder
     */
    public Builder addControls(ProfileControls controls) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(controls,
        "controls cannot be null");
      if (this.controls == null) {
        this.controls = new ArrayList<ProfileControls>();
      }
      this.controls.add(controls);
      return this;
    }

    /**
     * Adds a new element to defaultParameters.
     *
     * @param defaultParameters the new element to be added
     * @return the Profile builder
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
     * Set the id.
     *
     * @param id the id
     * @return the Profile builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the profileName.
     *
     * @param profileName the profileName
     * @return the Profile builder
     */
    public Builder profileName(String profileName) {
      this.profileName = profileName;
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the Profile builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the hierarchyEnabled.
     *
     * @param hierarchyEnabled the hierarchyEnabled
     * @return the Profile builder
     */
    public Builder hierarchyEnabled(Boolean hierarchyEnabled) {
      this.hierarchyEnabled = hierarchyEnabled;
      return this;
    }

    /**
     * Set the profileDescription.
     *
     * @param profileDescription the profileDescription
     * @return the Profile builder
     */
    public Builder profileDescription(String profileDescription) {
      this.profileDescription = profileDescription;
      return this;
    }

    /**
     * Set the profileType.
     *
     * @param profileType the profileType
     * @return the Profile builder
     */
    public Builder profileType(String profileType) {
      this.profileType = profileType;
      return this;
    }

    /**
     * Set the profileVersion.
     *
     * @param profileVersion the profileVersion
     * @return the Profile builder
     */
    public Builder profileVersion(String profileVersion) {
      this.profileVersion = profileVersion;
      return this;
    }

    /**
     * Set the versionGroupLabel.
     *
     * @param versionGroupLabel the versionGroupLabel
     * @return the Profile builder
     */
    public Builder versionGroupLabel(String versionGroupLabel) {
      this.versionGroupLabel = versionGroupLabel;
      return this;
    }

    /**
     * Set the latest.
     *
     * @param latest the latest
     * @return the Profile builder
     */
    public Builder latest(Boolean latest) {
      this.latest = latest;
      return this;
    }

    /**
     * Set the createdBy.
     *
     * @param createdBy the createdBy
     * @return the Profile builder
     */
    public Builder createdBy(String createdBy) {
      this.createdBy = createdBy;
      return this;
    }

    /**
     * Set the createdOn.
     *
     * @param createdOn the createdOn
     * @return the Profile builder
     */
    public Builder createdOn(Date createdOn) {
      this.createdOn = createdOn;
      return this;
    }

    /**
     * Set the updatedBy.
     *
     * @param updatedBy the updatedBy
     * @return the Profile builder
     */
    public Builder updatedBy(String updatedBy) {
      this.updatedBy = updatedBy;
      return this;
    }

    /**
     * Set the updatedOn.
     *
     * @param updatedOn the updatedOn
     * @return the Profile builder
     */
    public Builder updatedOn(Date updatedOn) {
      this.updatedOn = updatedOn;
      return this;
    }

    /**
     * Set the controlsCount.
     *
     * @param controlsCount the controlsCount
     * @return the Profile builder
     */
    public Builder controlsCount(long controlsCount) {
      this.controlsCount = controlsCount;
      return this;
    }

    /**
     * Set the attachmentsCount.
     *
     * @param attachmentsCount the attachmentsCount
     * @return the Profile builder
     */
    public Builder attachmentsCount(long attachmentsCount) {
      this.attachmentsCount = attachmentsCount;
      return this;
    }

    /**
     * Set the controls.
     * Existing controls will be replaced.
     *
     * @param controls the controls
     * @return the Profile builder
     */
    public Builder controls(List<ProfileControls> controls) {
      this.controls = controls;
      return this;
    }

    /**
     * Set the defaultParameters.
     * Existing defaultParameters will be replaced.
     *
     * @param defaultParameters the defaultParameters
     * @return the Profile builder
     */
    public Builder defaultParameters(List<DefaultParameters> defaultParameters) {
      this.defaultParameters = defaultParameters;
      return this;
    }
  }

  protected Profile() { }

  protected Profile(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.profileType,
      "profileType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controls,
      "controls cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.defaultParameters,
      "defaultParameters cannot be null");
    id = builder.id;
    profileName = builder.profileName;
    instanceId = builder.instanceId;
    hierarchyEnabled = builder.hierarchyEnabled;
    profileDescription = builder.profileDescription;
    profileType = builder.profileType;
    profileVersion = builder.profileVersion;
    versionGroupLabel = builder.versionGroupLabel;
    latest = builder.latest;
    createdBy = builder.createdBy;
    createdOn = builder.createdOn;
    updatedBy = builder.updatedBy;
    updatedOn = builder.updatedOn;
    controlsCount = builder.controlsCount;
    attachmentsCount = builder.attachmentsCount;
    controls = builder.controls;
    defaultParameters = builder.defaultParameters;
  }

  /**
   * New builder.
   *
   * @return a Profile builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The ID of the profile.
   *
   * @return the id
   */
  public String id() {
    return id;
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
   * Gets the instanceId.
   *
   * The ID of the Security and Compliance Center instance who owns the profile.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the hierarchyEnabled.
   *
   * Determines if the profile can be set to a hierarchy.
   *
   * @return the hierarchyEnabled
   */
  public Boolean hierarchyEnabled() {
    return hierarchyEnabled;
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
   * Gets the profileType.
   *
   * The type of profile, either predefined or custom.
   *
   * @return the profileType
   */
  public String profileType() {
    return profileType;
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
   * Gets the createdBy.
   *
   * User who created the profile.
   *
   * @return the createdBy
   */
  public String createdBy() {
    return createdBy;
  }

  /**
   * Gets the createdOn.
   *
   * The date when the profile was created, in date-time format.
   *
   * @return the createdOn
   */
  public Date createdOn() {
    return createdOn;
  }

  /**
   * Gets the updatedBy.
   *
   * User who made the latest changes to the profile.
   *
   * @return the updatedBy
   */
  public String updatedBy() {
    return updatedBy;
  }

  /**
   * Gets the updatedOn.
   *
   * The date when the profile was last updated, in date-time format.
   *
   * @return the updatedOn
   */
  public Date updatedOn() {
    return updatedOn;
  }

  /**
   * Gets the controlsCount.
   *
   * The number of controls contained in the profile.
   *
   * @return the controlsCount
   */
  public Long controlsCount() {
    return controlsCount;
  }

  /**
   * Gets the attachmentsCount.
   *
   * The number of attachments associated with the profile.
   *
   * @return the attachmentsCount
   */
  public Long attachmentsCount() {
    return attachmentsCount;
  }

  /**
   * Gets the controls.
   *
   * The list of controls.
   *
   * @return the controls
   */
  public List<ProfileControls> controls() {
    return controls;
  }

  /**
   * Gets the defaultParameters.
   *
   * The default parameters of the profile.
   *
   * @return the defaultParameters
   */
  public List<DefaultParameters> defaultParameters() {
    return defaultParameters;
  }
}

