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
 * The report.
 */
public class Report extends GenericModel {

  protected String id;
  @SerializedName("group_id")
  protected String groupId;
  @SerializedName("created_on")
  protected String createdOn;
  @SerializedName("scan_time")
  protected String scanTime;
  protected String type;
  @SerializedName("cos_object")
  protected String cosObject;
  @SerializedName("instance_id")
  protected String instanceId;
  protected Account account;
  protected ProfileInfo profile;
  protected Attachment attachment;

  protected Report() { }

  /**
   * Gets the id.
   *
   * The ID of the report.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the groupId.
   *
   * The group ID that is associated with the report. The group ID combines profile, scope, and attachment IDs.
   *
   * @return the groupId
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * Gets the createdOn.
   *
   * The date when the report was created.
   *
   * @return the createdOn
   */
  public String getCreatedOn() {
    return createdOn;
  }

  /**
   * Gets the scanTime.
   *
   * The date when the scan was run.
   *
   * @return the scanTime
   */
  public String getScanTime() {
    return scanTime;
  }

  /**
   * Gets the type.
   *
   * The type of the scan.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the cosObject.
   *
   * The Cloud Object Storage object that is associated with the report.
   *
   * @return the cosObject
   */
  public String getCosObject() {
    return cosObject;
  }

  /**
   * Gets the instanceId.
   *
   * Instance ID.
   *
   * @return the instanceId
   */
  public String getInstanceId() {
    return instanceId;
  }

  /**
   * Gets the account.
   *
   * The account that is associated with a report.
   *
   * @return the account
   */
  public Account getAccount() {
    return account;
  }

  /**
   * Gets the profile.
   *
   * The profile information.
   *
   * @return the profile
   */
  public ProfileInfo getProfile() {
    return profile;
  }

  /**
   * Gets the attachment.
   *
   * The attachment that is associated with a report.
   *
   * @return the attachment
   */
  public Attachment getAttachment() {
    return attachment;
  }
}

