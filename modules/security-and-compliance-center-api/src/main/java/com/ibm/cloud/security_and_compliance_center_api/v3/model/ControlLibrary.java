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
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A Control Library.
 */
public class ControlLibrary extends GenericModel {

  /**
   * Details that the control library is a user made(custom) or Security Compliance Center(predefined).
   */
  public interface ControlLibraryType {
    /** custom. */
    String CUSTOM = "custom";
    /** predefined. */
    String PREDEFINED = "predefined";
  }

  @SerializedName("control_library_name")
  protected String controlLibraryName;
  @SerializedName("control_library_description")
  protected String controlLibraryDescription;
  @SerializedName("control_library_type")
  protected String controlLibraryType;
  @SerializedName("control_library_version")
  protected String controlLibraryVersion;
  protected List<Control> controls;
  protected String id;
  @SerializedName("account_id")
  protected String accountId;
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
  @SerializedName("hierarchy_enabled")
  protected Boolean hierarchyEnabled;
  @SerializedName("controls_count")
  protected Long controlsCount;
  @SerializedName("control_parents_count")
  protected Long controlParentsCount;

  protected ControlLibrary() { }

  /**
   * Gets the controlLibraryName.
   *
   * The name of the control library.
   *
   * @return the controlLibraryName
   */
  public String getControlLibraryName() {
    return controlLibraryName;
  }

  /**
   * Gets the controlLibraryDescription.
   *
   * Details of the control library.
   *
   * @return the controlLibraryDescription
   */
  public String getControlLibraryDescription() {
    return controlLibraryDescription;
  }

  /**
   * Gets the controlLibraryType.
   *
   * Details that the control library is a user made(custom) or Security Compliance Center(predefined).
   *
   * @return the controlLibraryType
   */
  public String getControlLibraryType() {
    return controlLibraryType;
  }

  /**
   * Gets the controlLibraryVersion.
   *
   * The revision number of the control library.
   *
   * @return the controlLibraryVersion
   */
  public String getControlLibraryVersion() {
    return controlLibraryVersion;
  }

  /**
   * Gets the controls.
   *
   * The list of rules that the control library attempts to adhere to.
   *
   * @return the controls
   */
  public List<Control> getControls() {
    return controls;
  }

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
   * The ID of the account associated with the creation of the control library.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the versionGroupLabel.
   *
   * The ETag or version of the Control Library.
   *
   * @return the versionGroupLabel
   */
  public String getVersionGroupLabel() {
    return versionGroupLabel;
  }

  /**
   * Gets the latest.
   *
   * Shows if the Control Library is the latest.
   *
   * @return the latest
   */
  public Boolean isLatest() {
    return latest;
  }

  /**
   * Gets the createdBy.
   *
   * The ID of the creator of the Control Library.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the createdOn.
   *
   * The date-time of the creation.
   *
   * @return the createdOn
   */
  public Date getCreatedOn() {
    return createdOn;
  }

  /**
   * Gets the updatedBy.
   *
   * The ID of the user who made the last update.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the updatedOn.
   *
   * The date-time of the update.
   *
   * @return the updatedOn
   */
  public Date getUpdatedOn() {
    return updatedOn;
  }

  /**
   * Gets the hierarchyEnabled.
   *
   * Determines if the control library has any hierarchy.
   *
   * @return the hierarchyEnabled
   */
  public Boolean isHierarchyEnabled() {
    return hierarchyEnabled;
  }

  /**
   * Gets the controlsCount.
   *
   * The count of controls tied to the control library.
   *
   * @return the controlsCount
   */
  public Long getControlsCount() {
    return controlsCount;
  }

  /**
   * Gets the controlParentsCount.
   *
   * THe count of control parents in the control library.
   *
   * @return the controlParentsCount
   */
  public Long getControlParentsCount() {
    return controlParentsCount;
  }
}

