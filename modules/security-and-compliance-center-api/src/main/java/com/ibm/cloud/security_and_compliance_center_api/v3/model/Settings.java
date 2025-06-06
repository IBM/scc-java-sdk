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
 * The settings.
 */
public class Settings extends GenericModel {

  @SerializedName("event_notifications")
  protected EventNotifications eventNotifications;
  @SerializedName("object_storage")
  protected ObjectStorage objectStorage;

  protected Settings() { }

  /**
   * Gets the eventNotifications.
   *
   * The Event Notifications settings.
   *
   * @return the eventNotifications
   */
  public EventNotifications getEventNotifications() {
    return eventNotifications;
  }

  /**
   * Gets the objectStorage.
   *
   * The Cloud Object Storage settings.
   *
   * @return the objectStorage
   */
  public ObjectStorage getObjectStorage() {
    return objectStorage;
  }
}

