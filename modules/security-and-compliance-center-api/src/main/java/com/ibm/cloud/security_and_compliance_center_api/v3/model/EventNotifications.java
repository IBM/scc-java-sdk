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
 * The Event Notifications settings.
 */
public class EventNotifications extends GenericModel {

  @SerializedName("instance_crn")
  protected String instanceCrn;
  @SerializedName("updated_on")
  protected Date updatedOn;
  @SerializedName("source_id")
  protected String sourceId;
  @SerializedName("source_description")
  protected String sourceDescription;
  @SerializedName("source_name")
  protected String sourceName;

  protected EventNotifications() { }

  /**
   * Gets the instanceCrn.
   *
   * The Event Notifications instance CRN.
   *
   * @return the instanceCrn
   */
  public String getInstanceCrn() {
    return instanceCrn;
  }

  /**
   * Gets the updatedOn.
   *
   * The date when the Event Notifications connection was updated.
   *
   * @return the updatedOn
   */
  public Date getUpdatedOn() {
    return updatedOn;
  }

  /**
   * Gets the sourceId.
   *
   * The connected Security and Compliance Center instance CRN.
   *
   * @return the sourceId
   */
  public String getSourceId() {
    return sourceId;
  }

  /**
   * Gets the sourceDescription.
   *
   * The description of the source of the Event Notifications.
   *
   * @return the sourceDescription
   */
  public String getSourceDescription() {
    return sourceDescription;
  }

  /**
   * Gets the sourceName.
   *
   * The name of the source of the Event Notifications.
   *
   * @return the sourceName
   */
  public String getSourceName() {
    return sourceName;
  }
}

