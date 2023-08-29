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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The request payload of getting all of the attachments that are associated with the account.
 */
public class AttachmentsPrototype extends GenericModel {

  /**
   * The status of the scan of an attachment.
   */
  public interface Status {
    /** enabled. */
    String ENABLED = "enabled";
    /** disabled. */
    String DISABLED = "disabled";
  }

  /**
   * The schedule of an attachment evaluation.
   */
  public interface Schedule {
    /** daily. */
    String DAILY = "daily";
    /** every_7_days. */
    String EVERY_7_DAYS = "every_7_days";
    /** every_30_days. */
    String EVERY_30_DAYS = "every_30_days";
  }

  protected String id;
  protected String name;
  protected String description;
  protected List<MultiCloudScope> scope;
  protected String status;
  protected String schedule;
  protected AttachmentsNotificationsPrototype notifications;
  @SerializedName("attachment_parameters")
  protected List<AttachmentParameterPrototype> attachmentParameters;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String name;
    private String description;
    private List<MultiCloudScope> scope;
    private String status;
    private String schedule;
    private AttachmentsNotificationsPrototype notifications;
    private List<AttachmentParameterPrototype> attachmentParameters;

    /**
     * Instantiates a new Builder from an existing AttachmentsPrototype instance.
     *
     * @param attachmentsPrototype the instance to initialize the Builder with
     */
    private Builder(AttachmentsPrototype attachmentsPrototype) {
      this.id = attachmentsPrototype.id;
      this.name = attachmentsPrototype.name;
      this.description = attachmentsPrototype.description;
      this.scope = attachmentsPrototype.scope;
      this.status = attachmentsPrototype.status;
      this.schedule = attachmentsPrototype.schedule;
      this.notifications = attachmentsPrototype.notifications;
      this.attachmentParameters = attachmentsPrototype.attachmentParameters;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     * @param scope the scope
     * @param status the status
     * @param schedule the schedule
     * @param attachmentParameters the attachmentParameters
     */
    public Builder(String name, List<MultiCloudScope> scope, String status, String schedule, List<AttachmentParameterPrototype> attachmentParameters) {
      this.name = name;
      this.scope = scope;
      this.status = status;
      this.schedule = schedule;
      this.attachmentParameters = attachmentParameters;
    }

    /**
     * Builds a AttachmentsPrototype.
     *
     * @return the new AttachmentsPrototype instance
     */
    public AttachmentsPrototype build() {
      return new AttachmentsPrototype(this);
    }

    /**
     * Adds an scope to scope.
     *
     * @param scope the new scope
     * @return the AttachmentsPrototype builder
     */
    public Builder addScope(MultiCloudScope scope) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(scope,
        "scope cannot be null");
      if (this.scope == null) {
        this.scope = new ArrayList<MultiCloudScope>();
      }
      this.scope.add(scope);
      return this;
    }

    /**
     * Adds an attachmentParameters to attachmentParameters.
     *
     * @param attachmentParameters the new attachmentParameters
     * @return the AttachmentsPrototype builder
     */
    public Builder addAttachmentParameters(AttachmentParameterPrototype attachmentParameters) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attachmentParameters,
        "attachmentParameters cannot be null");
      if (this.attachmentParameters == null) {
        this.attachmentParameters = new ArrayList<AttachmentParameterPrototype>();
      }
      this.attachmentParameters.add(attachmentParameters);
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the AttachmentsPrototype builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the AttachmentsPrototype builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the AttachmentsPrototype builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the scope.
     * Existing scope will be replaced.
     *
     * @param scope the scope
     * @return the AttachmentsPrototype builder
     */
    public Builder scope(List<MultiCloudScope> scope) {
      this.scope = scope;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the AttachmentsPrototype builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Set the schedule.
     *
     * @param schedule the schedule
     * @return the AttachmentsPrototype builder
     */
    public Builder schedule(String schedule) {
      this.schedule = schedule;
      return this;
    }

    /**
     * Set the notifications.
     *
     * @param notifications the notifications
     * @return the AttachmentsPrototype builder
     */
    public Builder notifications(AttachmentsNotificationsPrototype notifications) {
      this.notifications = notifications;
      return this;
    }

    /**
     * Set the attachmentParameters.
     * Existing attachmentParameters will be replaced.
     *
     * @param attachmentParameters the attachmentParameters
     * @return the AttachmentsPrototype builder
     */
    public Builder attachmentParameters(List<AttachmentParameterPrototype> attachmentParameters) {
      this.attachmentParameters = attachmentParameters;
      return this;
    }
  }

  protected AttachmentsPrototype() { }

  protected AttachmentsPrototype(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.scope,
      "scope cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.status,
      "status cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.schedule,
      "schedule cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.attachmentParameters,
      "attachmentParameters cannot be null");
    id = builder.id;
    name = builder.name;
    description = builder.description;
    scope = builder.scope;
    status = builder.status;
    schedule = builder.schedule;
    notifications = builder.notifications;
    attachmentParameters = builder.attachmentParameters;
  }

  /**
   * New builder.
   *
   * @return a AttachmentsPrototype builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The id that is generated from the scope type and ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the name.
   *
   * The name that is generated from the scope type and ID.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description for the attachment.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the scope.
   *
   * The scope payload for the multi cloud feature.
   *
   * @return the scope
   */
  public List<MultiCloudScope> scope() {
    return scope;
  }

  /**
   * Gets the status.
   *
   * The status of the scan of an attachment.
   *
   * @return the status
   */
  public String status() {
    return status;
  }

  /**
   * Gets the schedule.
   *
   * The schedule of an attachment evaluation.
   *
   * @return the schedule
   */
  public String schedule() {
    return schedule;
  }

  /**
   * Gets the notifications.
   *
   * The request payload of the attachment notifications.
   *
   * @return the notifications
   */
  public AttachmentsNotificationsPrototype notifications() {
    return notifications;
  }

  /**
   * Gets the attachmentParameters.
   *
   * The profile parameters for the attachment.
   *
   * @return the attachmentParameters
   */
  public List<AttachmentParameterPrototype> attachmentParameters() {
    return attachmentParameters;
  }
}

