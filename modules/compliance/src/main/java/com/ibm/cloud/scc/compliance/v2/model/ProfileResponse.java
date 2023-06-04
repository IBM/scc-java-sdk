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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response body of the Profile.
 */
public class ProfileResponse extends GenericModel {

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
  protected List<ProfileControlsInResponse> controls;
  @SerializedName("default_parameters")
  protected List<DefaultParameters> defaultParameters;

  protected ProfileResponse() { }

  /**
   * Gets the id.
   *
   * Profile ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the profileName.
   *
   * Profile name.
   *
   * @return the profileName
   */
  public String getProfileName() {
    return profileName;
  }

  /**
   * Gets the profileDescription.
   *
   * Profile Description.
   *
   * @return the profileDescription
   */
  public String getProfileDescription() {
    return profileDescription;
  }

  /**
   * Gets the profileType.
   *
   * Profile Type.
   *
   * @return the profileType
   */
  public String getProfileType() {
    return profileType;
  }

  /**
   * Gets the profileVersion.
   *
   * Profile Version.
   *
   * @return the profileVersion
   */
  public String getProfileVersion() {
    return profileVersion;
  }

  /**
   * Gets the versionGroupLabel.
   *
   * Version Group Label.
   *
   * @return the versionGroupLabel
   */
  public String getVersionGroupLabel() {
    return versionGroupLabel;
  }

  /**
   * Gets the latest.
   *
   * Latest.
   *
   * @return the latest
   */
  public Boolean isLatest() {
    return latest;
  }

  /**
   * Gets the createdBy.
   *
   * Created By.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the createdOn.
   *
   * Created On.
   *
   * @return the createdOn
   */
  public String getCreatedOn() {
    return createdOn;
  }

  /**
   * Gets the updatedBy.
   *
   * Updated by.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the updatedOn.
   *
   * Updated On.
   *
   * @return the updatedOn
   */
  public String getUpdatedOn() {
    return updatedOn;
  }

  /**
   * Gets the controlsCount.
   *
   * Number of Controls.
   *
   * @return the controlsCount
   */
  public Long getControlsCount() {
    return controlsCount;
  }

  /**
   * Gets the attachmentsCount.
   *
   * Number of attachments.
   *
   * @return the attachmentsCount
   */
  public Long getAttachmentsCount() {
    return attachmentsCount;
  }

  /**
   * Gets the controls.
   *
   * Control IDs.
   *
   * @return the controls
   */
  public List<ProfileControlsInResponse> getControls() {
    return controls;
  }

  /**
   * Gets the defaultParameters.
   *
   * The default parameters of a profile.
   *
   * @return the defaultParameters
   */
  public List<DefaultParameters> getDefaultParameters() {
    return defaultParameters;
  }
}

