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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceProfile options.
 */
public class ReplaceProfileOptions extends GenericModel {

  /**
   * The type of profile, either predefined or custom.
   */
  public interface NewProfileType {
    /** custom. */
    String CUSTOM = "custom";
    /** predefined. */
    String PREDEFINED = "predefined";
  }

  protected String instanceId;
  protected String profileId;
  protected String newProfileType;
  protected List<ProfileControls> newControls;
  protected List<DefaultParameters> newDefaultParameters;
  protected String newId;
  protected String newProfileName;
  protected String newInstanceId;
  protected Boolean newHierarchyEnabled;
  protected String newProfileDescription;
  protected String newProfileVersion;
  protected String newVersionGroupLabel;
  protected Boolean newLatest;
  protected String newCreatedBy;
  protected Date newCreatedOn;
  protected String newUpdatedBy;
  protected Date newUpdatedOn;
  protected Long newControlsCount;
  protected Long newAttachmentsCount;
  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String profileId;
    private String newProfileType;
    private List<ProfileControls> newControls;
    private List<DefaultParameters> newDefaultParameters;
    private String newId;
    private String newProfileName;
    private String newInstanceId;
    private Boolean newHierarchyEnabled;
    private String newProfileDescription;
    private String newProfileVersion;
    private String newVersionGroupLabel;
    private Boolean newLatest;
    private String newCreatedBy;
    private Date newCreatedOn;
    private String newUpdatedBy;
    private Date newUpdatedOn;
    private Long newControlsCount;
    private Long newAttachmentsCount;
    private String accountId;

    /**
     * Instantiates a new Builder from an existing ReplaceProfileOptions instance.
     *
     * @param replaceProfileOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceProfileOptions replaceProfileOptions) {
      this.instanceId = replaceProfileOptions.instanceId;
      this.profileId = replaceProfileOptions.profileId;
      this.newProfileType = replaceProfileOptions.newProfileType;
      this.newControls = replaceProfileOptions.newControls;
      this.newDefaultParameters = replaceProfileOptions.newDefaultParameters;
      this.newId = replaceProfileOptions.newId;
      this.newProfileName = replaceProfileOptions.newProfileName;
      this.newInstanceId = replaceProfileOptions.newInstanceId;
      this.newHierarchyEnabled = replaceProfileOptions.newHierarchyEnabled;
      this.newProfileDescription = replaceProfileOptions.newProfileDescription;
      this.newProfileVersion = replaceProfileOptions.newProfileVersion;
      this.newVersionGroupLabel = replaceProfileOptions.newVersionGroupLabel;
      this.newLatest = replaceProfileOptions.newLatest;
      this.newCreatedBy = replaceProfileOptions.newCreatedBy;
      this.newCreatedOn = replaceProfileOptions.newCreatedOn;
      this.newUpdatedBy = replaceProfileOptions.newUpdatedBy;
      this.newUpdatedOn = replaceProfileOptions.newUpdatedOn;
      this.newControlsCount = replaceProfileOptions.newControlsCount;
      this.newAttachmentsCount = replaceProfileOptions.newAttachmentsCount;
      this.accountId = replaceProfileOptions.accountId;
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
     * @param profileId the profileId
     * @param newProfileType the newProfileType
     * @param newControls the newControls
     * @param newDefaultParameters the newDefaultParameters
     */
    public Builder(String instanceId, String profileId, String newProfileType, List<ProfileControls> newControls, List<DefaultParameters> newDefaultParameters) {
      this.instanceId = instanceId;
      this.profileId = profileId;
      this.newProfileType = newProfileType;
      this.newControls = newControls;
      this.newDefaultParameters = newDefaultParameters;
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
     * Adds a new element to newControls.
     *
     * @param newControls the new element to be added
     * @return the ReplaceProfileOptions builder
     */
    public Builder addNewControls(ProfileControls newControls) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(newControls,
        "newControls cannot be null");
      if (this.newControls == null) {
        this.newControls = new ArrayList<ProfileControls>();
      }
      this.newControls.add(newControls);
      return this;
    }

    /**
     * Adds a new element to newDefaultParameters.
     *
     * @param newDefaultParameters the new element to be added
     * @return the ReplaceProfileOptions builder
     */
    public Builder addNewDefaultParameters(DefaultParameters newDefaultParameters) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(newDefaultParameters,
        "newDefaultParameters cannot be null");
      if (this.newDefaultParameters == null) {
        this.newDefaultParameters = new ArrayList<DefaultParameters>();
      }
      this.newDefaultParameters.add(newDefaultParameters);
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ReplaceProfileOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the ReplaceProfileOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the newProfileType.
     *
     * @param newProfileType the newProfileType
     * @return the ReplaceProfileOptions builder
     */
    public Builder newProfileType(String newProfileType) {
      this.newProfileType = newProfileType;
      return this;
    }

    /**
     * Set the newControls.
     * Existing newControls will be replaced.
     *
     * @param newControls the newControls
     * @return the ReplaceProfileOptions builder
     */
    public Builder newControls(List<ProfileControls> newControls) {
      this.newControls = newControls;
      return this;
    }

    /**
     * Set the newDefaultParameters.
     * Existing newDefaultParameters will be replaced.
     *
     * @param newDefaultParameters the newDefaultParameters
     * @return the ReplaceProfileOptions builder
     */
    public Builder newDefaultParameters(List<DefaultParameters> newDefaultParameters) {
      this.newDefaultParameters = newDefaultParameters;
      return this;
    }

    /**
     * Set the newId.
     *
     * @param newId the newId
     * @return the ReplaceProfileOptions builder
     */
    public Builder newId(String newId) {
      this.newId = newId;
      return this;
    }

    /**
     * Set the newProfileName.
     *
     * @param newProfileName the newProfileName
     * @return the ReplaceProfileOptions builder
     */
    public Builder newProfileName(String newProfileName) {
      this.newProfileName = newProfileName;
      return this;
    }

    /**
     * Set the newInstanceId.
     *
     * @param newInstanceId the newInstanceId
     * @return the ReplaceProfileOptions builder
     */
    public Builder newInstanceId(String newInstanceId) {
      this.newInstanceId = newInstanceId;
      return this;
    }

    /**
     * Set the newHierarchyEnabled.
     *
     * @param newHierarchyEnabled the newHierarchyEnabled
     * @return the ReplaceProfileOptions builder
     */
    public Builder newHierarchyEnabled(Boolean newHierarchyEnabled) {
      this.newHierarchyEnabled = newHierarchyEnabled;
      return this;
    }

    /**
     * Set the newProfileDescription.
     *
     * @param newProfileDescription the newProfileDescription
     * @return the ReplaceProfileOptions builder
     */
    public Builder newProfileDescription(String newProfileDescription) {
      this.newProfileDescription = newProfileDescription;
      return this;
    }

    /**
     * Set the newProfileVersion.
     *
     * @param newProfileVersion the newProfileVersion
     * @return the ReplaceProfileOptions builder
     */
    public Builder newProfileVersion(String newProfileVersion) {
      this.newProfileVersion = newProfileVersion;
      return this;
    }

    /**
     * Set the newVersionGroupLabel.
     *
     * @param newVersionGroupLabel the newVersionGroupLabel
     * @return the ReplaceProfileOptions builder
     */
    public Builder newVersionGroupLabel(String newVersionGroupLabel) {
      this.newVersionGroupLabel = newVersionGroupLabel;
      return this;
    }

    /**
     * Set the newLatest.
     *
     * @param newLatest the newLatest
     * @return the ReplaceProfileOptions builder
     */
    public Builder newLatest(Boolean newLatest) {
      this.newLatest = newLatest;
      return this;
    }

    /**
     * Set the newCreatedBy.
     *
     * @param newCreatedBy the newCreatedBy
     * @return the ReplaceProfileOptions builder
     */
    public Builder newCreatedBy(String newCreatedBy) {
      this.newCreatedBy = newCreatedBy;
      return this;
    }

    /**
     * Set the newCreatedOn.
     *
     * @param newCreatedOn the newCreatedOn
     * @return the ReplaceProfileOptions builder
     */
    public Builder newCreatedOn(Date newCreatedOn) {
      this.newCreatedOn = newCreatedOn;
      return this;
    }

    /**
     * Set the newUpdatedBy.
     *
     * @param newUpdatedBy the newUpdatedBy
     * @return the ReplaceProfileOptions builder
     */
    public Builder newUpdatedBy(String newUpdatedBy) {
      this.newUpdatedBy = newUpdatedBy;
      return this;
    }

    /**
     * Set the newUpdatedOn.
     *
     * @param newUpdatedOn the newUpdatedOn
     * @return the ReplaceProfileOptions builder
     */
    public Builder newUpdatedOn(Date newUpdatedOn) {
      this.newUpdatedOn = newUpdatedOn;
      return this;
    }

    /**
     * Set the newControlsCount.
     *
     * @param newControlsCount the newControlsCount
     * @return the ReplaceProfileOptions builder
     */
    public Builder newControlsCount(long newControlsCount) {
      this.newControlsCount = newControlsCount;
      return this;
    }

    /**
     * Set the newAttachmentsCount.
     *
     * @param newAttachmentsCount the newAttachmentsCount
     * @return the ReplaceProfileOptions builder
     */
    public Builder newAttachmentsCount(long newAttachmentsCount) {
      this.newAttachmentsCount = newAttachmentsCount;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ReplaceProfileOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the profile.
     *
     * @param profile the profile
     * @return the ReplaceProfileOptions builder
     */
    public Builder profile(Profile profile) {
      this.newProfileType = profile.profileType();
      this.newControls = profile.controls();
      this.newDefaultParameters = profile.defaultParameters();
      this.newId = profile.id();
      this.newProfileName = profile.profileName();
      this.newInstanceId = profile.instanceId();
      this.newHierarchyEnabled = profile.hierarchyEnabled();
      this.newProfileDescription = profile.profileDescription();
      this.newProfileVersion = profile.profileVersion();
      this.newVersionGroupLabel = profile.versionGroupLabel();
      this.newLatest = profile.latest();
      this.newCreatedBy = profile.createdBy();
      this.newCreatedOn = profile.createdOn();
      this.newUpdatedBy = profile.updatedBy();
      this.newUpdatedOn = profile.updatedOn();
      this.newControlsCount = profile.controlsCount();
      this.newAttachmentsCount = profile.attachmentsCount();
      return this;
    }
  }

  protected ReplaceProfileOptions() { }

  protected ReplaceProfileOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.newProfileType,
      "newProfileType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.newControls,
      "newControls cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.newDefaultParameters,
      "newDefaultParameters cannot be null");
    instanceId = builder.instanceId;
    profileId = builder.profileId;
    newProfileType = builder.newProfileType;
    newControls = builder.newControls;
    newDefaultParameters = builder.newDefaultParameters;
    newId = builder.newId;
    newProfileName = builder.newProfileName;
    newInstanceId = builder.newInstanceId;
    newHierarchyEnabled = builder.newHierarchyEnabled;
    newProfileDescription = builder.newProfileDescription;
    newProfileVersion = builder.newProfileVersion;
    newVersionGroupLabel = builder.newVersionGroupLabel;
    newLatest = builder.newLatest;
    newCreatedBy = builder.newCreatedBy;
    newCreatedOn = builder.newCreatedOn;
    newUpdatedBy = builder.newUpdatedBy;
    newUpdatedOn = builder.newUpdatedOn;
    newControlsCount = builder.newControlsCount;
    newAttachmentsCount = builder.newAttachmentsCount;
    accountId = builder.accountId;
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
   * Gets the profileId.
   *
   * The profile ID.
   *
   * @return the profileId
   */
  public String profileId() {
    return profileId;
  }

  /**
   * Gets the newProfileType.
   *
   * The type of profile, either predefined or custom.
   *
   * @return the newProfileType
   */
  public String newProfileType() {
    return newProfileType;
  }

  /**
   * Gets the newControls.
   *
   * The list of controls.
   *
   * @return the newControls
   */
  public List<ProfileControls> newControls() {
    return newControls;
  }

  /**
   * Gets the newDefaultParameters.
   *
   * The default parameters of the profile.
   *
   * @return the newDefaultParameters
   */
  public List<DefaultParameters> newDefaultParameters() {
    return newDefaultParameters;
  }

  /**
   * Gets the newId.
   *
   * The ID of the profile.
   *
   * @return the newId
   */
  public String newId() {
    return newId;
  }

  /**
   * Gets the newProfileName.
   *
   * The name of the profile.
   *
   * @return the newProfileName
   */
  public String newProfileName() {
    return newProfileName;
  }

  /**
   * Gets the newInstanceId.
   *
   * The ID of the Security and Compliance Center instance who owns the profile.
   *
   * @return the newInstanceId
   */
  public String newInstanceId() {
    return newInstanceId;
  }

  /**
   * Gets the newHierarchyEnabled.
   *
   * Determines if the profile can be set to a hierarchy.
   *
   * @return the newHierarchyEnabled
   */
  public Boolean newHierarchyEnabled() {
    return newHierarchyEnabled;
  }

  /**
   * Gets the newProfileDescription.
   *
   * A description of what the profile should represent.
   *
   * @return the newProfileDescription
   */
  public String newProfileDescription() {
    return newProfileDescription;
  }

  /**
   * Gets the newProfileVersion.
   *
   * The version of the profile.
   *
   * @return the newProfileVersion
   */
  public String newProfileVersion() {
    return newProfileVersion;
  }

  /**
   * Gets the newVersionGroupLabel.
   *
   * The unique identifier of the revision.
   *
   * @return the newVersionGroupLabel
   */
  public String newVersionGroupLabel() {
    return newVersionGroupLabel;
  }

  /**
   * Gets the newLatest.
   *
   * Determines if the profile is up to date with the latest revisions.
   *
   * @return the newLatest
   */
  public Boolean newLatest() {
    return newLatest;
  }

  /**
   * Gets the newCreatedBy.
   *
   * User who created the profile.
   *
   * @return the newCreatedBy
   */
  public String newCreatedBy() {
    return newCreatedBy;
  }

  /**
   * Gets the newCreatedOn.
   *
   * The date when the profile was created, in date-time format.
   *
   * @return the newCreatedOn
   */
  public Date newCreatedOn() {
    return newCreatedOn;
  }

  /**
   * Gets the newUpdatedBy.
   *
   * User who made the latest changes to the profile.
   *
   * @return the newUpdatedBy
   */
  public String newUpdatedBy() {
    return newUpdatedBy;
  }

  /**
   * Gets the newUpdatedOn.
   *
   * The date when the profile was last updated, in date-time format.
   *
   * @return the newUpdatedOn
   */
  public Date newUpdatedOn() {
    return newUpdatedOn;
  }

  /**
   * Gets the newControlsCount.
   *
   * The number of controls contained in the profile.
   *
   * @return the newControlsCount
   */
  public Long newControlsCount() {
    return newControlsCount;
  }

  /**
   * Gets the newAttachmentsCount.
   *
   * The number of attachments associated with the profile.
   *
   * @return the newAttachmentsCount
   */
  public Long newAttachmentsCount() {
    return newAttachmentsCount;
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

