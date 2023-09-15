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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateSettings options.
 */
public class UpdateSettingsOptions extends GenericModel {

  protected EventNotifications eventNotifications;
  protected ObjectStorage objectStorage;
  protected String xCorrelationId;
  protected String xRequestId;

  /**
   * Builder.
   */
  public static class Builder {
    private EventNotifications eventNotifications;
    private ObjectStorage objectStorage;
    private String xCorrelationId;
    private String xRequestId;

    /**
     * Instantiates a new Builder from an existing UpdateSettingsOptions instance.
     *
     * @param updateSettingsOptions the instance to initialize the Builder with
     */
    private Builder(UpdateSettingsOptions updateSettingsOptions) {
      this.eventNotifications = updateSettingsOptions.eventNotifications;
      this.objectStorage = updateSettingsOptions.objectStorage;
      this.xCorrelationId = updateSettingsOptions.xCorrelationId;
      this.xRequestId = updateSettingsOptions.xRequestId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
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
     * Set the eventNotifications.
     *
     * @param eventNotifications the eventNotifications
     * @return the UpdateSettingsOptions builder
     */
    public Builder eventNotifications(EventNotifications eventNotifications) {
      this.eventNotifications = eventNotifications;
      return this;
    }

    /**
     * Set the objectStorage.
     *
     * @param objectStorage the objectStorage
     * @return the UpdateSettingsOptions builder
     */
    public Builder objectStorage(ObjectStorage objectStorage) {
      this.objectStorage = objectStorage;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the UpdateSettingsOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the UpdateSettingsOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }

    /**
     * Set the settings.
     *
     * @param settings the settings
     * @return the UpdateSettingsOptions builder
     */
    public Builder settings(Settings settings) {
      this.eventNotifications = settings.eventNotifications();
      this.objectStorage = settings.objectStorage();
      return this;
    }
  }

  protected UpdateSettingsOptions() { }

  protected UpdateSettingsOptions(Builder builder) {
    eventNotifications = builder.eventNotifications;
    objectStorage = builder.objectStorage;
    xCorrelationId = builder.xCorrelationId;
    xRequestId = builder.xRequestId;
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

  /**
   * Gets the xCorrelationId.
   *
   * The supplied or generated value of this header is logged for a request, and repeated in a response header for the
   * corresponding response. The same value is used for downstream requests and retries of those requests. If a value of
   * this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xCorrelationId
   */
  public String xCorrelationId() {
    return xCorrelationId;
  }

  /**
   * Gets the xRequestId.
   *
   * The supplied or generated value of this header is logged for a request, and repeated in a response header  for the
   * corresponding response.  The same value is not used for downstream requests and retries of those requests.  If a
   * value of this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xRequestId
   */
  public String xRequestId() {
    return xRequestId;
  }
}

