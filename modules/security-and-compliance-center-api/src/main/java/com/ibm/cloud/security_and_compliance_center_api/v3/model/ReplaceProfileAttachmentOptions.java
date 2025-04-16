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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceProfileAttachment options.
 */
public class ReplaceProfileAttachmentOptions extends GenericModel {

  /**
   * Details how often a scan from a profile attachment is ran.
   */
  public interface Schedule {
    /** daily. */
    String DAILY = "daily";
    /** every_7_days. */
    String EVERY_7_DAYS = "every_7_days";
    /** every_30_days. */
    String EVERY_30_DAYS = "every_30_days";
  }

  /**
   * Details the state of a profile attachment.
   */
  public interface Status {
    /** enabled. */
    String ENABLED = "enabled";
    /** disabled. */
    String DISABLED = "disabled";
  }

  protected String instanceId;
  protected String profileId;
  protected String attachmentId;
  protected List<Parameter> attachmentParameters;
  protected String description;
  protected String name;
  protected AttachmentNotifications notifications;
  protected String schedule;
  protected List<MultiCloudScopePayload> scope;
  protected String status;
  protected DateRange dataSelectionRange;
  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String profileId;
    private String attachmentId;
    private List<Parameter> attachmentParameters;
    private String description;
    private String name;
    private AttachmentNotifications notifications;
    private String schedule;
    private List<MultiCloudScopePayload> scope;
    private String status;
    private DateRange dataSelectionRange;
    private String accountId;

    /**
     * Instantiates a new Builder from an existing ReplaceProfileAttachmentOptions instance.
     *
     * @param replaceProfileAttachmentOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceProfileAttachmentOptions replaceProfileAttachmentOptions) {
      this.instanceId = replaceProfileAttachmentOptions.instanceId;
      this.profileId = replaceProfileAttachmentOptions.profileId;
      this.attachmentId = replaceProfileAttachmentOptions.attachmentId;
      this.attachmentParameters = replaceProfileAttachmentOptions.attachmentParameters;
      this.description = replaceProfileAttachmentOptions.description;
      this.name = replaceProfileAttachmentOptions.name;
      this.notifications = replaceProfileAttachmentOptions.notifications;
      this.schedule = replaceProfileAttachmentOptions.schedule;
      this.scope = replaceProfileAttachmentOptions.scope;
      this.status = replaceProfileAttachmentOptions.status;
      this.dataSelectionRange = replaceProfileAttachmentOptions.dataSelectionRange;
      this.accountId = replaceProfileAttachmentOptions.accountId;
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
     * @param profileId the profileId
     * @param attachmentId the attachmentId
     * @param attachmentParameters the attachmentParameters
     * @param description the description
     * @param name the name
     * @param notifications the notifications
     * @param schedule the schedule
     * @param scope the scope
     * @param status the status
     */
    public Builder(String instanceId, String profileId, String attachmentId, List<Parameter> attachmentParameters, String description, String name, AttachmentNotifications notifications, String schedule, List<MultiCloudScopePayload> scope, String status) {
      this.instanceId = instanceId;
      this.profileId = profileId;
      this.attachmentId = attachmentId;
      this.attachmentParameters = attachmentParameters;
      this.description = description;
      this.name = name;
      this.notifications = notifications;
      this.schedule = schedule;
      this.scope = scope;
      this.status = status;
    }

    /**
     * Builds a ReplaceProfileAttachmentOptions.
     *
     * @return the new ReplaceProfileAttachmentOptions instance
     */
    public ReplaceProfileAttachmentOptions build() {
      return new ReplaceProfileAttachmentOptions(this);
    }

    /**
     * Adds a new element to attachmentParameters.
     *
     * @param attachmentParameters the new element to be added
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder addAttachmentParameters(Parameter attachmentParameters) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attachmentParameters,
        "attachmentParameters cannot be null");
      if (this.attachmentParameters == null) {
        this.attachmentParameters = new ArrayList<Parameter>();
      }
      this.attachmentParameters.add(attachmentParameters);
      return this;
    }

    /**
     * Adds a new element to scope.
     *
     * @param scope the new element to be added
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder addScope(MultiCloudScopePayload scope) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(scope,
        "scope cannot be null");
      if (this.scope == null) {
        this.scope = new ArrayList<MultiCloudScopePayload>();
      }
      this.scope.add(scope);
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the attachmentId.
     *
     * @param attachmentId the attachmentId
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder attachmentId(String attachmentId) {
      this.attachmentId = attachmentId;
      return this;
    }

    /**
     * Set the attachmentParameters.
     * Existing attachmentParameters will be replaced.
     *
     * @param attachmentParameters the attachmentParameters
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder attachmentParameters(List<Parameter> attachmentParameters) {
      this.attachmentParameters = attachmentParameters;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the notifications.
     *
     * @param notifications the notifications
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder notifications(AttachmentNotifications notifications) {
      this.notifications = notifications;
      return this;
    }

    /**
     * Set the schedule.
     *
     * @param schedule the schedule
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder schedule(String schedule) {
      this.schedule = schedule;
      return this;
    }

    /**
     * Set the scope.
     * Existing scope will be replaced.
     *
     * @param scope the scope
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder scope(List<MultiCloudScopePayload> scope) {
      this.scope = scope;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Set the dataSelectionRange.
     *
     * @param dataSelectionRange the dataSelectionRange
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder dataSelectionRange(DateRange dataSelectionRange) {
      this.dataSelectionRange = dataSelectionRange;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected ReplaceProfileAttachmentOptions() { }

  protected ReplaceProfileAttachmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.attachmentId,
      "attachmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.attachmentParameters,
      "attachmentParameters cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.description,
      "description cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.notifications,
      "notifications cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.schedule,
      "schedule cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.scope,
      "scope cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.status,
      "status cannot be null");
    instanceId = builder.instanceId;
    profileId = builder.profileId;
    attachmentId = builder.attachmentId;
    attachmentParameters = builder.attachmentParameters;
    description = builder.description;
    name = builder.name;
    notifications = builder.notifications;
    schedule = builder.schedule;
    scope = builder.scope;
    status = builder.status;
    dataSelectionRange = builder.dataSelectionRange;
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a ReplaceProfileAttachmentOptions builder
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
   * Gets the profileId.
   *
   * The profile ID.
   *
   * @return the profileId
   */
  public String profileId() {
    return profileId;
  }

  /**
   * Gets the attachmentId.
   *
   * The attachment ID.
   *
   * @return the attachmentId
   */
  public String attachmentId() {
    return attachmentId;
  }

  /**
   * Gets the attachmentParameters.
   *
   * The parameters associated with the profile attachment.
   *
   * @return the attachmentParameters
   */
  public List<Parameter> attachmentParameters() {
    return attachmentParameters;
  }

  /**
   * Gets the description.
   *
   * The details to describe the profile attachment.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the name.
   *
   * The name of the Profile Attachment.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the notifications.
   *
   * The notification configuration of the attachment.
   *
   * @return the notifications
   */
  public AttachmentNotifications notifications() {
    return notifications;
  }

  /**
   * Gets the schedule.
   *
   * Details how often a scan from a profile attachment is ran.
   *
   * @return the schedule
   */
  public String schedule() {
    return schedule;
  }

  /**
   * Gets the scope.
   *
   * A list of scopes associated with a profile attachment.
   *
   * @return the scope
   */
  public List<MultiCloudScopePayload> scope() {
    return scope;
  }

  /**
   * Gets the status.
   *
   * Details the state of a profile attachment.
   *
   * @return the status
   */
  public String status() {
    return status;
  }

  /**
   * Gets the dataSelectionRange.
   *
   * Date range.
   *
   * @return the dataSelectionRange
   */
  public DateRange dataSelectionRange() {
    return dataSelectionRange;
  }

  /**
   * Gets the accountId.
   *
   * The user account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

