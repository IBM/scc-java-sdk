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
import java.util.Date;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceProfileAttachment options.
 */
public class ReplaceProfileAttachmentOptions extends GenericModel {

  /**
   * The status of an attachment evaluation.
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

  protected String attachmentId;
  protected String profilesId;
  protected String id;
  protected String profileId;
  protected String accountId;
  protected String instanceId;
  protected List<MultiCloudScope> scope;
  protected Date createdOn;
  protected String createdBy;
  protected Date updatedOn;
  protected String updatedBy;
  protected String status;
  protected String schedule;
  protected AttachmentsNotificationsPrototype notifications;
  protected List<AttachmentParameterPrototype> attachmentParameters;
  protected LastScan lastScan;
  protected Date nextScanTime;
  protected String name;
  protected String description;
  protected String xCorrelationId;
  protected String xRequestId;

  /**
   * Builder.
   */
  public static class Builder {
    private String attachmentId;
    private String profilesId;
    private String id;
    private String profileId;
    private String accountId;
    private String instanceId;
    private List<MultiCloudScope> scope;
    private Date createdOn;
    private String createdBy;
    private Date updatedOn;
    private String updatedBy;
    private String status;
    private String schedule;
    private AttachmentsNotificationsPrototype notifications;
    private List<AttachmentParameterPrototype> attachmentParameters;
    private LastScan lastScan;
    private Date nextScanTime;
    private String name;
    private String description;
    private String xCorrelationId;
    private String xRequestId;

    /**
     * Instantiates a new Builder from an existing ReplaceProfileAttachmentOptions instance.
     *
     * @param replaceProfileAttachmentOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceProfileAttachmentOptions replaceProfileAttachmentOptions) {
      this.attachmentId = replaceProfileAttachmentOptions.attachmentId;
      this.profilesId = replaceProfileAttachmentOptions.profilesId;
      this.id = replaceProfileAttachmentOptions.id;
      this.profileId = replaceProfileAttachmentOptions.profileId;
      this.accountId = replaceProfileAttachmentOptions.accountId;
      this.instanceId = replaceProfileAttachmentOptions.instanceId;
      this.scope = replaceProfileAttachmentOptions.scope;
      this.createdOn = replaceProfileAttachmentOptions.createdOn;
      this.createdBy = replaceProfileAttachmentOptions.createdBy;
      this.updatedOn = replaceProfileAttachmentOptions.updatedOn;
      this.updatedBy = replaceProfileAttachmentOptions.updatedBy;
      this.status = replaceProfileAttachmentOptions.status;
      this.schedule = replaceProfileAttachmentOptions.schedule;
      this.notifications = replaceProfileAttachmentOptions.notifications;
      this.attachmentParameters = replaceProfileAttachmentOptions.attachmentParameters;
      this.lastScan = replaceProfileAttachmentOptions.lastScan;
      this.nextScanTime = replaceProfileAttachmentOptions.nextScanTime;
      this.name = replaceProfileAttachmentOptions.name;
      this.description = replaceProfileAttachmentOptions.description;
      this.xCorrelationId = replaceProfileAttachmentOptions.xCorrelationId;
      this.xRequestId = replaceProfileAttachmentOptions.xRequestId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param attachmentId the attachmentId
     * @param profilesId the profilesId
     */
    public Builder(String attachmentId, String profilesId) {
      this.attachmentId = attachmentId;
      this.profilesId = profilesId;
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
     * Adds an scope to scope.
     *
     * @param scope the new scope
     * @return the ReplaceProfileAttachmentOptions builder
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
     * @return the ReplaceProfileAttachmentOptions builder
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
     * Set the profilesId.
     *
     * @param profilesId the profilesId
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder profilesId(String profilesId) {
      this.profilesId = profilesId;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder id(String id) {
      this.id = id;
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
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
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
     * Set the scope.
     * Existing scope will be replaced.
     *
     * @param scope the scope
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder scope(List<MultiCloudScope> scope) {
      this.scope = scope;
      return this;
    }

    /**
     * Set the createdOn.
     *
     * @param createdOn the createdOn
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder createdOn(Date createdOn) {
      this.createdOn = createdOn;
      return this;
    }

    /**
     * Set the createdBy.
     *
     * @param createdBy the createdBy
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder createdBy(String createdBy) {
      this.createdBy = createdBy;
      return this;
    }

    /**
     * Set the updatedOn.
     *
     * @param updatedOn the updatedOn
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder updatedOn(Date updatedOn) {
      this.updatedOn = updatedOn;
      return this;
    }

    /**
     * Set the updatedBy.
     *
     * @param updatedBy the updatedBy
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder updatedBy(String updatedBy) {
      this.updatedBy = updatedBy;
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
     * Set the notifications.
     *
     * @param notifications the notifications
     * @return the ReplaceProfileAttachmentOptions builder
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
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder attachmentParameters(List<AttachmentParameterPrototype> attachmentParameters) {
      this.attachmentParameters = attachmentParameters;
      return this;
    }

    /**
     * Set the lastScan.
     *
     * @param lastScan the lastScan
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder lastScan(LastScan lastScan) {
      this.lastScan = lastScan;
      return this;
    }

    /**
     * Set the nextScanTime.
     *
     * @param nextScanTime the nextScanTime
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder nextScanTime(Date nextScanTime) {
      this.nextScanTime = nextScanTime;
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
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }

    /**
     * Set the attachmentItem.
     *
     * @param attachmentItem the attachmentItem
     * @return the ReplaceProfileAttachmentOptions builder
     */
    public Builder attachmentItem(AttachmentItem attachmentItem) {
      this.id = attachmentItem.id();
      this.profileId = attachmentItem.profileId();
      this.accountId = attachmentItem.accountId();
      this.instanceId = attachmentItem.instanceId();
      this.scope = attachmentItem.scope();
      this.createdOn = attachmentItem.createdOn();
      this.createdBy = attachmentItem.createdBy();
      this.updatedOn = attachmentItem.updatedOn();
      this.updatedBy = attachmentItem.updatedBy();
      this.status = attachmentItem.status();
      this.schedule = attachmentItem.schedule();
      this.notifications = attachmentItem.notifications();
      this.attachmentParameters = attachmentItem.attachmentParameters();
      this.lastScan = attachmentItem.lastScan();
      this.nextScanTime = attachmentItem.nextScanTime();
      this.name = attachmentItem.name();
      this.description = attachmentItem.description();
      return this;
    }
  }

  protected ReplaceProfileAttachmentOptions() { }

  protected ReplaceProfileAttachmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.attachmentId,
      "attachmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profilesId,
      "profilesId cannot be empty");
    attachmentId = builder.attachmentId;
    profilesId = builder.profilesId;
    id = builder.id;
    profileId = builder.profileId;
    accountId = builder.accountId;
    instanceId = builder.instanceId;
    scope = builder.scope;
    createdOn = builder.createdOn;
    createdBy = builder.createdBy;
    updatedOn = builder.updatedOn;
    updatedBy = builder.updatedBy;
    status = builder.status;
    schedule = builder.schedule;
    notifications = builder.notifications;
    attachmentParameters = builder.attachmentParameters;
    lastScan = builder.lastScan;
    nextScanTime = builder.nextScanTime;
    name = builder.name;
    description = builder.description;
    xCorrelationId = builder.xCorrelationId;
    xRequestId = builder.xRequestId;
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
   * Gets the profilesId.
   *
   * The profile ID.
   *
   * @return the profilesId
   */
  public String profilesId() {
    return profilesId;
  }

  /**
   * Gets the id.
   *
   * The ID of the attachment.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the profileId.
   *
   * The ID of the profile that is specified in the attachment.
   *
   * @return the profileId
   */
  public String profileId() {
    return profileId;
  }

  /**
   * Gets the accountId.
   *
   * The account ID that is associated to the attachment.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the instanceId.
   *
   * The instance ID of the account that is associated to the attachment.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
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
   * Gets the createdOn.
   *
   * The date when the attachment was created.
   *
   * @return the createdOn
   */
  public Date createdOn() {
    return createdOn;
  }

  /**
   * Gets the createdBy.
   *
   * The user who created the attachment.
   *
   * @return the createdBy
   */
  public String createdBy() {
    return createdBy;
  }

  /**
   * Gets the updatedOn.
   *
   * The date when the attachment was updated.
   *
   * @return the updatedOn
   */
  public Date updatedOn() {
    return updatedOn;
  }

  /**
   * Gets the updatedBy.
   *
   * The user who updated the attachment.
   *
   * @return the updatedBy
   */
  public String updatedBy() {
    return updatedBy;
  }

  /**
   * Gets the status.
   *
   * The status of an attachment evaluation.
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

  /**
   * Gets the lastScan.
   *
   * The details of the last scan of an attachment.
   *
   * @return the lastScan
   */
  public LastScan lastScan() {
    return lastScan;
  }

  /**
   * Gets the nextScanTime.
   *
   * The start time of the next scan.
   *
   * @return the nextScanTime
   */
  public Date nextScanTime() {
    return nextScanTime;
  }

  /**
   * Gets the name.
   *
   * The name of the attachment.
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
   * Gets the xCorrelationId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header for the
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
   * The supplied or generated value of this header is logged for a request and repeated in a response header for the
   * corresponding response. The same value is not used for downstream requests and retries of those requests. If a
   * value of this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xRequestId
   */
  public String xRequestId() {
    return xRequestId;
  }
}

