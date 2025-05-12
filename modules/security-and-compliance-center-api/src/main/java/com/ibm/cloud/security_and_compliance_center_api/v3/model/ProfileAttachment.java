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
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The configuration set when starting a scan against a profile.
 */
public class ProfileAttachment extends GenericModel {

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

  @SerializedName("attachment_parameters")
  protected List<Parameter> attachmentParameters;
  protected String description;
  protected String name;
  protected AttachmentNotifications notifications;
  protected String schedule;
  protected List<MultiCloudScopePayload> scope;
  protected String status;
  @SerializedName("data_selection_range")
  protected DateRange dataSelectionRange;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("created_on")
  protected Date createdOn;
  protected String id;
  @SerializedName("instance_id")
  protected String instanceId;
  @SerializedName("last_scan")
  protected LastScan lastScan;
  @SerializedName("next_scan_time")
  protected Date nextScanTime;
  @SerializedName("profile_id")
  protected String profileId;
  @SerializedName("updated_by")
  protected String updatedBy;
  @SerializedName("updated_on")
  protected Date updatedOn;

  protected ProfileAttachment() { }

  /**
   * Gets the attachmentParameters.
   *
   * The parameters associated with the profile attachment.
   *
   * @return the attachmentParameters
   */
  public List<Parameter> getAttachmentParameters() {
    return attachmentParameters;
  }

  /**
   * Gets the description.
   *
   * The details to describe the profile attachment.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the name.
   *
   * The name of the Profile Attachment.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the notifications.
   *
   * The notification configuration of the attachment.
   *
   * @return the notifications
   */
  public AttachmentNotifications getNotifications() {
    return notifications;
  }

  /**
   * Gets the schedule.
   *
   * Details how often a scan from a profile attachment is ran.
   *
   * @return the schedule
   */
  public String getSchedule() {
    return schedule;
  }

  /**
   * Gets the scope.
   *
   * A list of scopes associated with a profile attachment.
   *
   * @return the scope
   */
  public List<MultiCloudScopePayload> getScope() {
    return scope;
  }

  /**
   * Gets the status.
   *
   * Details the state of a profile attachment.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the dataSelectionRange.
   *
   * Date range.
   *
   * @return the dataSelectionRange
   */
  public DateRange getDataSelectionRange() {
    return dataSelectionRange;
  }

  /**
   * Gets the accountId.
   *
   * The ID of the account.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the createdBy.
   *
   * User who created the profile attachment.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the createdOn.
   *
   * The date-time that the profile attachment was created.
   *
   * @return the createdOn
   */
  public Date getCreatedOn() {
    return createdOn;
  }

  /**
   * Gets the id.
   *
   * The ID of the profile attachment.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the instanceId.
   *
   * The ID of the associated Security and Compliance Center instance.
   *
   * @return the instanceId
   */
  public String getInstanceId() {
    return instanceId;
  }

  /**
   * Gets the lastScan.
   *
   * The last scan performed on a profile attachment.
   *
   * @return the lastScan
   */
  public LastScan getLastScan() {
    return lastScan;
  }

  /**
   * Gets the nextScanTime.
   *
   * The date-time for next scan.
   *
   * @return the nextScanTime
   */
  public Date getNextScanTime() {
    return nextScanTime;
  }

  /**
   * Gets the profileId.
   *
   * The ID of the profile.
   *
   * @return the profileId
   */
  public String getProfileId() {
    return profileId;
  }

  /**
   * Gets the updatedBy.
   *
   * User who made the latest changes to the profile attachment.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the updatedOn.
   *
   * The date when the profile was last updated, in date-time format.
   *
   * @return the updatedOn
   */
  public Date getUpdatedOn() {
    return updatedOn;
  }
}

