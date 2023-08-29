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

  /**
   * Builder.
   */
  public static class Builder {
    private EventNotifications eventNotifications;
    private ObjectStorage objectStorage;

    /**
     * Instantiates a new Builder from an existing Settings instance.
     *
     * @param settings the instance to initialize the Builder with
     */
    private Builder(Settings settings) {
      this.eventNotifications = settings.eventNotifications;
      this.objectStorage = settings.objectStorage;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Settings.
     *
     * @return the new Settings instance
     */
    public Settings build() {
      return new Settings(this);
    }

    /**
     * Set the eventNotifications.
     *
     * @param eventNotifications the eventNotifications
     * @return the Settings builder
     */
    public Builder eventNotifications(EventNotifications eventNotifications) {
      this.eventNotifications = eventNotifications;
      return this;
    }

    /**
     * Set the objectStorage.
     *
     * @param objectStorage the objectStorage
     * @return the Settings builder
     */
    public Builder objectStorage(ObjectStorage objectStorage) {
      this.objectStorage = objectStorage;
      return this;
    }
  }

  protected Settings() { }

  protected Settings(Builder builder) {
    eventNotifications = builder.eventNotifications;
    objectStorage = builder.objectStorage;
  }

  /**
   * New builder.
   *
   * @return a Settings builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the eventNotifications.
   *
   * The Event Notifications settings.
   *
   * @return the eventNotifications
   */
  public EventNotifications eventNotifications() {
    return eventNotifications;
  }

  /**
   * Gets the objectStorage.
   *
   * The Cloud Object Storage settings.
   *
   * @return the objectStorage
   */
  public ObjectStorage objectStorage() {
    return objectStorage;
  }
}

