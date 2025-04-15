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
 * The payload to connect an Event Notification instance with a Security and Compliance Center instance.
 */
public class EventNotificationsPrototype extends GenericModel {

  @SerializedName("instance_crn")
  protected String instanceCrn;
  @SerializedName("source_description")
  protected String sourceDescription;
  @SerializedName("source_name")
  protected String sourceName;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceCrn;
    private String sourceDescription;
    private String sourceName;

    /**
     * Instantiates a new Builder from an existing EventNotificationsPrototype instance.
     *
     * @param eventNotificationsPrototype the instance to initialize the Builder with
     */
    private Builder(EventNotificationsPrototype eventNotificationsPrototype) {
      this.instanceCrn = eventNotificationsPrototype.instanceCrn;
      this.sourceDescription = eventNotificationsPrototype.sourceDescription;
      this.sourceName = eventNotificationsPrototype.sourceName;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a EventNotificationsPrototype.
     *
     * @return the new EventNotificationsPrototype instance
     */
    public EventNotificationsPrototype build() {
      return new EventNotificationsPrototype(this);
    }

    /**
     * Set the instanceCrn.
     *
     * @param instanceCrn the instanceCrn
     * @return the EventNotificationsPrototype builder
     */
    public Builder instanceCrn(String instanceCrn) {
      this.instanceCrn = instanceCrn;
      return this;
    }

    /**
     * Set the sourceDescription.
     *
     * @param sourceDescription the sourceDescription
     * @return the EventNotificationsPrototype builder
     */
    public Builder sourceDescription(String sourceDescription) {
      this.sourceDescription = sourceDescription;
      return this;
    }

    /**
     * Set the sourceName.
     *
     * @param sourceName the sourceName
     * @return the EventNotificationsPrototype builder
     */
    public Builder sourceName(String sourceName) {
      this.sourceName = sourceName;
      return this;
    }
  }

  protected EventNotificationsPrototype() { }

  protected EventNotificationsPrototype(Builder builder) {
    instanceCrn = builder.instanceCrn;
    sourceDescription = builder.sourceDescription;
    sourceName = builder.sourceName;
  }

  /**
   * New builder.
   *
   * @return a EventNotificationsPrototype builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceCrn.
   *
   * The CRN of the Event Notification instance to connect.
   *
   * @return the instanceCrn
   */
  public String instanceCrn() {
    return instanceCrn;
  }

  /**
   * Gets the sourceDescription.
   *
   * The description of the source of the Event Notifications.
   *
   * @return the sourceDescription
   */
  public String sourceDescription() {
    return sourceDescription;
  }

  /**
   * Gets the sourceName.
   *
   * The name of the source of the Event Notifications.
   *
   * @return the sourceName
   */
  public String sourceName() {
    return sourceName;
  }
}

