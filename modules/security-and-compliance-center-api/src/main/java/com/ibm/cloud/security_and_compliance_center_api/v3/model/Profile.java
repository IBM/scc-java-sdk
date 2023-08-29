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

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The response body of the profile.
 */
public class Profile extends GenericModel {

  /**
   * The profile type, such as custom or predefined.
   */
  public interface ProfileType {
    /** predefined. */
    String PREDEFINED = "predefined";
    /** custom. */
    String CUSTOM = "custom";
  }

  protected String id;
  @SerializedName("profile_name")
  protected String profileName;
  @SerializedName("profile_description")
  protected String profileDescription;
  @SerializedName("profile_type")
  protected String profileType;
  @SerializedName("profile_version")
  protected String profileVersion;
  @SerializedName("version_group_label")
  protected String versionGroupLabel;
  @SerializedName("instance_id")
  protected String instanceId;
  protected Boolean latest;
  @SerializedName("hierarchy_enabled")
  protected Boolean hierarchyEnabled;
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
  @SerializedName("control_parents_count")
  protected Long controlParentsCount;
  @SerializedName("attachments_count")
  protected Long attachmentsCount;
  protected List<ProfileControls> controls;
  @SerializedName("default_parameters")
  protected List<DefaultParametersPrototype> defaultParameters;

  protected Profile() { }

  /**
   * Gets the id.
   *
   * The unique ID of the profile.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the profileName.
   *
   * The profile name.
   *
   * @return the profileName
   */
  public String getProfileName() {
    return profileName;
  }

  /**
   * Gets the profileDescription.
   *
   * The profile description.
   *
   * @return the profileDescription
   */
  public String getProfileDescription() {
    return profileDescription;
  }

  /**
   * Gets the profileType.
   *
   * The profile type, such as custom or predefined.
   *
   * @return the profileType
   */
  public String getProfileType() {
    return profileType;
  }

  /**
   * Gets the profileVersion.
   *
   * The version status of the profile.
   *
   * @return the profileVersion
   */
  public String getProfileVersion() {
    return profileVersion;
  }

  /**
   * Gets the versionGroupLabel.
   *
   * The version group label of the profile.
   *
   * @return the versionGroupLabel
   */
  public String getVersionGroupLabel() {
    return versionGroupLabel;
  }

  /**
   * Gets the instanceId.
   *
   * The instance ID.
   *
   * @return the instanceId
   */
  public String getInstanceId() {
    return instanceId;
  }

  /**
   * Gets the latest.
   *
   * The latest version of the profile.
   *
   * @return the latest
   */
  public Boolean isLatest() {
    return latest;
  }

  /**
   * Gets the hierarchyEnabled.
   *
   * The indication of whether hierarchy is enabled for the profile.
   *
   * @return the hierarchyEnabled
   */
  public Boolean isHierarchyEnabled() {
    return hierarchyEnabled;
  }

  /**
   * Gets the createdBy.
   *
   * The user who created the profile.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the createdOn.
   *
   * The date when the profile was created.
   *
   * @return the createdOn
   */
  public Date getCreatedOn() {
    return createdOn;
  }

  /**
   * Gets the updatedBy.
   *
   * The user who updated the profile.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the updatedOn.
   *
   * The date when the profile was updated.
   *
   * @return the updatedOn
   */
  public Date getUpdatedOn() {
    return updatedOn;
  }

  /**
   * Gets the controlsCount.
   *
   * The number of controls for the profile.
   *
   * @return the controlsCount
   */
  public Long getControlsCount() {
    return controlsCount;
  }

  /**
   * Gets the controlParentsCount.
   *
   * The number of parent controls for the profile.
   *
   * @return the controlParentsCount
   */
  public Long getControlParentsCount() {
    return controlParentsCount;
  }

  /**
   * Gets the attachmentsCount.
   *
   * The number of attachments related to this profile.
   *
   * @return the attachmentsCount
   */
  public Long getAttachmentsCount() {
    return attachmentsCount;
  }

  /**
   * Gets the controls.
   *
   * The array of controls that are used to create the profile.
   *
   * @return the controls
   */
  public List<ProfileControls> getControls() {
    return controls;
  }

  /**
   * Gets the defaultParameters.
   *
   * The default parameters of the profile.
   *
   * @return the defaultParameters
   */
  public List<DefaultParametersPrototype> getDefaultParameters() {
    return defaultParameters;
  }
}

