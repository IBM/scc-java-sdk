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
 * ControlLibraryListResponse.
 */
public class ControlLibraryListResponse extends GenericModel {

  protected String id;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("control_library_name")
  protected String controlLibraryName;
  @SerializedName("control_library_description")
  protected String controlLibraryDescription;
  @SerializedName("control_library_type")
  protected String controlLibraryType;
  @SerializedName("created_on")
  protected String createdOn;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("updated_on")
  protected String updatedOn;
  @SerializedName("updated_by")
  protected String updatedBy;
  @SerializedName("version_group_label")
  protected String versionGroupLabel;
  @SerializedName("control_library_version")
  protected String controlLibraryVersion;
  protected Boolean latest;
  @SerializedName("controls_count")
  protected Long controlsCount;

  protected ControlLibraryListResponse() { }

  /**
   * Gets the id.
   *
   * The ID of the control library.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the accountId.
   *
   * Account ID.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the controlLibraryName.
   *
   * The Control Library Name.
   *
   * @return the controlLibraryName
   */
  public String getControlLibraryName() {
    return controlLibraryName;
  }

  /**
   * Gets the controlLibraryDescription.
   *
   * Control Library Description.
   *
   * @return the controlLibraryDescription
   */
  public String getControlLibraryDescription() {
    return controlLibraryDescription;
  }

  /**
   * Gets the controlLibraryType.
   *
   * Control Library Type.
   *
   * @return the controlLibraryType
   */
  public String getControlLibraryType() {
    return controlLibraryType;
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
   * Gets the updatedOn.
   *
   * Updated ON.
   *
   * @return the updatedOn
   */
  public String getUpdatedOn() {
    return updatedOn;
  }

  /**
   * Gets the updatedBy.
   *
   * Updated By.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
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
   * Gets the controlLibraryVersion.
   *
   * Control Library Version.
   *
   * @return the controlLibraryVersion
   */
  public String getControlLibraryVersion() {
    return controlLibraryVersion;
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
   * Gets the controlsCount.
   *
   * Number of controls.
   *
   * @return the controlsCount
   */
  public Long getControlsCount() {
    return controlsCount;
  }
}

