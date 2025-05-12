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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The predefined profile comparison response.
 */
public class ComparePredefinedProfilesResponse extends GenericModel {

  @SerializedName("current_predefined_version")
  protected CompareProfileResponse currentPredefinedVersion;
  @SerializedName("latest_predefined_version")
  protected CompareProfileResponse latestPredefinedVersion;
  @SerializedName("controls_changes")
  protected ControlChanges controlsChanges;
  @SerializedName("default_parameters_changes")
  protected DefaultParametersChanges defaultParametersChanges;

  protected ComparePredefinedProfilesResponse() { }

  /**
   * Gets the currentPredefinedVersion.
   *
   * Shows a change in the Profile.
   *
   * @return the currentPredefinedVersion
   */
  public CompareProfileResponse getCurrentPredefinedVersion() {
    return currentPredefinedVersion;
  }

  /**
   * Gets the latestPredefinedVersion.
   *
   * Shows a change in the Profile.
   *
   * @return the latestPredefinedVersion
   */
  public CompareProfileResponse getLatestPredefinedVersion() {
    return latestPredefinedVersion;
  }

  /**
   * Gets the controlsChanges.
   *
   * Shows details of the controls that were changed.
   *
   * @return the controlsChanges
   */
  public ControlChanges getControlsChanges() {
    return controlsChanges;
  }

  /**
   * Gets the defaultParametersChanges.
   *
   * Shows details of the parameters that were changed.
   *
   * @return the defaultParametersChanges
   */
  public DefaultParametersChanges getDefaultParametersChanges() {
    return defaultParametersChanges;
  }
}

