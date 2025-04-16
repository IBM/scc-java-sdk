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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The response that details the whether starting a scan was successful.
 */
public class CreateScanResponse extends GenericModel {

  protected String id;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("attachment_id")
  protected String attachmentId;
  @SerializedName("report_id")
  protected String reportId;
  protected String status;
  @SerializedName("last_scan_time")
  protected Date lastScanTime;
  @SerializedName("next_scan_time")
  protected Date nextScanTime;
  @SerializedName("scan_type")
  protected String scanType;
  protected Long occurence;

  protected CreateScanResponse() { }

  /**
   * Gets the id.
   *
   * The ID of the scan generated.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the accountId.
   *
   * The ID of the account associated with the scan.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the attachmentId.
   *
   * The ID of the profile attachment associated with the scan.
   *
   * @return the attachmentId
   */
  public String getAttachmentId() {
    return attachmentId;
  }

  /**
   * Gets the reportId.
   *
   * The ID of the report associated with the scan.
   *
   * @return the reportId
   */
  public String getReportId() {
    return reportId;
  }

  /**
   * Gets the status.
   *
   * Details the state of a scan.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the lastScanTime.
   *
   * The last time a scan was performed.
   *
   * @return the lastScanTime
   */
  public Date getLastScanTime() {
    return lastScanTime;
  }

  /**
   * Gets the nextScanTime.
   *
   * The next time a scan will be triggered.
   *
   * @return the nextScanTime
   */
  public Date getNextScanTime() {
    return nextScanTime;
  }

  /**
   * Gets the scanType.
   *
   * Shows how a scan gets triggered.
   *
   * @return the scanType
   */
  public String getScanType() {
    return scanType;
  }

  /**
   * Gets the occurence.
   *
   * The number of times the scan appeared.
   *
   * @return the occurence
   */
  public Long getOccurence() {
    return occurence;
  }
}

