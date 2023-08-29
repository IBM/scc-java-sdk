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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ProfileItem.
 */
public class ProfileItem extends GenericModel {

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
  @SerializedName("attachments_count")
  protected Long attachmentsCount;

  protected ProfileItem() { }

  /**
   * Gets the id.
   *
   * The profile ID.
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
   * The profile type.
   *
   * @return the profileType
   */
  public String getProfileType() {
    return profileType;
  }

  /**
   * Gets the profileVersion.
   *
   * The profile version.
   *
   * @return the profileVersion
   */
  public String getProfileVersion() {
    return profileVersion;
  }

  /**
   * Gets the versionGroupLabel.
   *
   * The version group label.
   *
   * @return the versionGroupLabel
   */
  public String getVersionGroupLabel() {
    return versionGroupLabel;
  }

  /**
   * Gets the latest.
   *
   * The latest profile.
   *
   * @return the latest
   */
  public Boolean isLatest() {
    return latest;
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
   * The number of controls.
   *
   * @return the controlsCount
   */
  public Long getControlsCount() {
    return controlsCount;
  }

  /**
   * Gets the attachmentsCount.
   *
   * The number of attachments.
   *
   * @return the attachmentsCount
   */
  public Long getAttachmentsCount() {
    return attachmentsCount;
  }
}

