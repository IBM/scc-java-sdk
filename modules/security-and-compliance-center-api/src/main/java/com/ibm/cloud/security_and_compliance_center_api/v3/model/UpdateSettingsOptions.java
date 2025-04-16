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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateSettings options.
 */
public class UpdateSettingsOptions extends GenericModel {

  protected String instanceId;
  protected ObjectStoragePrototype objectStorage;
  protected EventNotificationsPrototype eventNotifications;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private ObjectStoragePrototype objectStorage;
    private EventNotificationsPrototype eventNotifications;

    /**
     * Instantiates a new Builder from an existing UpdateSettingsOptions instance.
     *
     * @param updateSettingsOptions the instance to initialize the Builder with
     */
    private Builder(UpdateSettingsOptions updateSettingsOptions) {
      this.instanceId = updateSettingsOptions.instanceId;
      this.objectStorage = updateSettingsOptions.objectStorage;
      this.eventNotifications = updateSettingsOptions.eventNotifications;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceId the instanceId
     */
    public Builder(String instanceId) {
      this.instanceId = instanceId;
    }

    /**
     * Builds a UpdateSettingsOptions.
     *
     * @return the new UpdateSettingsOptions instance
     */
    public UpdateSettingsOptions build() {
      return new UpdateSettingsOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the UpdateSettingsOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the objectStorage.
     *
     * @param objectStorage the objectStorage
     * @return the UpdateSettingsOptions builder
     */
    public Builder objectStorage(ObjectStoragePrototype objectStorage) {
      this.objectStorage = objectStorage;
      return this;
    }

    /**
     * Set the eventNotifications.
     *
     * @param eventNotifications the eventNotifications
     * @return the UpdateSettingsOptions builder
     */
    public Builder eventNotifications(EventNotificationsPrototype eventNotifications) {
      this.eventNotifications = eventNotifications;
      return this;
    }
  }

  protected UpdateSettingsOptions() { }

  protected UpdateSettingsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    objectStorage = builder.objectStorage;
    eventNotifications = builder.eventNotifications;
  }

  /**
   * New builder.
   *
   * @return a UpdateSettingsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The ID of the Security and Compliance Center instance.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the objectStorage.
   *
   * The payload to connect a Cloud Object Storage instance to an Security and Compliance Center instance.
   *
   * @return the objectStorage
   */
  public ObjectStoragePrototype objectStorage() {
    return objectStorage;
  }

  /**
   * Gets the eventNotifications.
   *
   * The payload to connect an Event Notification instance with a Security and Compliance Center instance.
   *
   * @return the eventNotifications
   */
  public EventNotificationsPrototype eventNotifications() {
    return eventNotifications;
  }
}

