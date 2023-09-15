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

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceCrn;
    private Date updatedOn;
    private String sourceId;
    private String sourceDescription;
    private String sourceName;

    /**
     * Instantiates a new Builder from an existing EventNotifications instance.
     *
     * @param eventNotifications the instance to initialize the Builder with
     */
    private Builder(EventNotifications eventNotifications) {
      this.instanceCrn = eventNotifications.instanceCrn;
      this.updatedOn = eventNotifications.updatedOn;
      this.sourceId = eventNotifications.sourceId;
      this.sourceDescription = eventNotifications.sourceDescription;
      this.sourceName = eventNotifications.sourceName;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a EventNotifications.
     *
     * @return the new EventNotifications instance
     */
    public EventNotifications build() {
      return new EventNotifications(this);
    }

    /**
     * Set the instanceCrn.
     *
     * @param instanceCrn the instanceCrn
     * @return the EventNotifications builder
     */
    public Builder instanceCrn(String instanceCrn) {
      this.instanceCrn = instanceCrn;
      return this;
    }

    /**
     * Set the updatedOn.
     *
     * @param updatedOn the updatedOn
     * @return the EventNotifications builder
     */
    public Builder updatedOn(Date updatedOn) {
      this.updatedOn = updatedOn;
      return this;
    }

    /**
     * Set the sourceId.
     *
     * @param sourceId the sourceId
     * @return the EventNotifications builder
     */
    public Builder sourceId(String sourceId) {
      this.sourceId = sourceId;
      return this;
    }

    /**
     * Set the sourceDescription.
     *
     * @param sourceDescription the sourceDescription
     * @return the EventNotifications builder
     */
    public Builder sourceDescription(String sourceDescription) {
      this.sourceDescription = sourceDescription;
      return this;
    }

    /**
     * Set the sourceName.
     *
     * @param sourceName the sourceName
     * @return the EventNotifications builder
     */
    public Builder sourceName(String sourceName) {
      this.sourceName = sourceName;
      return this;
    }
  }

  protected EventNotifications() { }

  protected EventNotifications(Builder builder) {
    instanceCrn = builder.instanceCrn;
    updatedOn = builder.updatedOn;
    sourceId = builder.sourceId;
    sourceDescription = builder.sourceDescription;
    sourceName = builder.sourceName;
  }

  /**
   * New builder.
   *
   * @return a EventNotifications builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceCrn.
   *
   * The Event Notifications instance CRN.
   *
   * @return the instanceCrn
   */
  public String instanceCrn() {
    return instanceCrn;
  }

  /**
   * Gets the updatedOn.
   *
   * The date when the Event Notifications connection was updated.
   *
   * @return the updatedOn
   */
  public Date updatedOn() {
    return updatedOn;
  }

  /**
   * Gets the sourceId.
   *
   * The connected Security and Compliance Center instance CRN.
   *
   * @return the sourceId
   */
  public String sourceId() {
    return sourceId;
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

