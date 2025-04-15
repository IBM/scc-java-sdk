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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Shows a change in the Profile.
 */
public class CompareProfileResponse extends GenericModel {

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

  protected CompareProfileResponse() { }

  /**
   * Gets the id.
   *
   * The ID of the profile.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the profileName.
   *
   * The name of the profile.
   *
   * @return the profileName
   */
  public String getProfileName() {
    return profileName;
  }

  /**
   * Gets the profileDescription.
   *
   * A description of what the profile should represent.
   *
   * @return the profileDescription
   */
  public String getProfileDescription() {
    return profileDescription;
  }

  /**
   * Gets the profileType.
   *
   * The type of profile, either predefined or custom.
   *
   * @return the profileType
   */
  public String getProfileType() {
    return profileType;
  }

  /**
   * Gets the profileVersion.
   *
   * The version of the profile.
   *
   * @return the profileVersion
   */
  public String getProfileVersion() {
    return profileVersion;
  }

  /**
   * Gets the versionGroupLabel.
   *
   * The unique identifier of the profile revision.
   *
   * @return the versionGroupLabel
   */
  public String getVersionGroupLabel() {
    return versionGroupLabel;
  }

  /**
   * Gets the latest.
   *
   * Determines if the profile is up to date with the latest revisions.
   *
   * @return the latest
   */
  public Boolean isLatest() {
    return latest;
  }

  /**
   * Gets the createdBy.
   *
   * User who created the profile.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the createdOn.
   *
   * The date when the profile was created, in date-time format.
   *
   * @return the createdOn
   */
  public Date getCreatedOn() {
    return createdOn;
  }

  /**
   * Gets the updatedBy.
   *
   * User who made the latest changes to the profile.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the updatedOn.
   *
   * The date when the profile was last updated, in date-time format.
   *
   * @return the updatedOn
   */
  public Date getUpdatedOn() {
    return updatedOn;
  }

  /**
   * Gets the controlsCount.
   *
   * Number of controls in the profile.
   *
   * @return the controlsCount
   */
  public Long getControlsCount() {
    return controlsCount;
  }
}

