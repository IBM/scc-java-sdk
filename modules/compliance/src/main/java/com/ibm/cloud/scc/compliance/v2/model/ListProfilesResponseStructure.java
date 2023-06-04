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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ListProfilesResponseStructure.
 */
public class ListProfilesResponseStructure extends GenericModel {

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
  protected String createdOn;
  @SerializedName("updated_by")
  protected String updatedBy;
  @SerializedName("updated_on")
  protected String updatedOn;
  @SerializedName("controls_count")
  protected Long controlsCount;
  @SerializedName("attachments_count")
  protected Long attachmentsCount;

  protected ListProfilesResponseStructure() { }

  /**
   * Gets the id.
   *
   * id of the profile.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the profileName.
   *
   * name of the profile.
   *
   * @return the profileName
   */
  public String getProfileName() {
    return profileName;
  }

  /**
   * Gets the profileDescription.
   *
   * description of the profile.
   *
   * @return the profileDescription
   */
  public String getProfileDescription() {
    return profileDescription;
  }

  /**
   * Gets the profileType.
   *
   * type of the profile.
   *
   * @return the profileType
   */
  public String getProfileType() {
    return profileType;
  }

  /**
   * Gets the profileVersion.
   *
   * version of the profile.
   *
   * @return the profileVersion
   */
  public String getProfileVersion() {
    return profileVersion;
  }

  /**
   * Gets the versionGroupLabel.
   *
   * version group label.
   *
   * @return the versionGroupLabel
   */
  public String getVersionGroupLabel() {
    return versionGroupLabel;
  }

  /**
   * Gets the latest.
   *
   * latest.
   *
   * @return the latest
   */
  public Boolean isLatest() {
    return latest;
  }

  /**
   * Gets the createdBy.
   *
   * created by.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the createdOn.
   *
   * created on.
   *
   * @return the createdOn
   */
  public String getCreatedOn() {
    return createdOn;
  }

  /**
   * Gets the updatedBy.
   *
   * updated by.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the updatedOn.
   *
   * updated on.
   *
   * @return the updatedOn
   */
  public String getUpdatedOn() {
    return updatedOn;
  }

  /**
   * Gets the controlsCount.
   *
   * No of controls.
   *
   * @return the controlsCount
   */
  public Long getControlsCount() {
    return controlsCount;
  }

  /**
   * Gets the attachmentsCount.
   *
   * No of attachments.
   *
   * @return the attachmentsCount
   */
  public Long getAttachmentsCount() {
    return attachmentsCount;
  }
}

