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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Shows details of the controls that were changed.
 */
public class ControlChanges extends GenericModel {

  @SerializedName("total_added")
  protected Long totalAdded;
  @SerializedName("total_removed")
  protected Long totalRemoved;
  @SerializedName("total_updated")
  protected Long totalUpdated;
  protected List<ProfileControls> added;
  protected List<ProfileControls> removed;
  protected List<ControlChangesUpdated> updated;

  protected ControlChanges() { }

  /**
   * Gets the totalAdded.
   *
   * How many controls were added.
   *
   * @return the totalAdded
   */
  public Long getTotalAdded() {
    return totalAdded;
  }

  /**
   * Gets the totalRemoved.
   *
   * How many controls were removed.
   *
   * @return the totalRemoved
   */
  public Long getTotalRemoved() {
    return totalRemoved;
  }

  /**
   * Gets the totalUpdated.
   *
   * How many controls were updated.
   *
   * @return the totalUpdated
   */
  public Long getTotalUpdated() {
    return totalUpdated;
  }

  /**
   * Gets the added.
   *
   * A list of controls that were added.
   *
   * @return the added
   */
  public List<ProfileControls> getAdded() {
    return added;
  }

  /**
   * Gets the removed.
   *
   * A list of controls that were removed.
   *
   * @return the removed
   */
  public List<ProfileControls> getRemoved() {
    return removed;
  }

  /**
   * Gets the updated.
   *
   * A list of controls that were updated.
   *
   * @return the updated
   */
  public List<ControlChangesUpdated> getUpdated() {
    return updated;
  }
}

