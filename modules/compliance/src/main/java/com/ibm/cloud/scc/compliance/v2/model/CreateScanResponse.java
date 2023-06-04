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
package com.ibm.cloud.scc.compliance.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response schema for creating a scan.
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
  protected String lastScanTime;
  @SerializedName("next_scan_time")
  protected String nextScanTime;
  @SerializedName("scan_type")
  protected String scanType;
  protected Long occurence;

  protected CreateScanResponse() { }

  /**
   * Gets the id.
   *
   * Scan ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the accountId.
   *
   * Account ID.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the attachmentId.
   *
   * Attachment ID.
   *
   * @return the attachmentId
   */
  public String getAttachmentId() {
    return attachmentId;
  }

  /**
   * Gets the reportId.
   *
   * Report ID.
   *
   * @return the reportId
   */
  public String getReportId() {
    return reportId;
  }

  /**
   * Gets the status.
   *
   * Status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the lastScanTime.
   *
   * Last Scan Time.
   *
   * @return the lastScanTime
   */
  public String getLastScanTime() {
    return lastScanTime;
  }

  /**
   * Gets the nextScanTime.
   *
   * Next Scan Time.
   *
   * @return the nextScanTime
   */
  public String getNextScanTime() {
    return nextScanTime;
  }

  /**
   * Gets the scanType.
   *
   * Type of Scan.
   *
   * @return the scanType
   */
  public String getScanType() {
    return scanType;
  }

  /**
   * Gets the occurence.
   *
   * Occurance of Scan.
   *
   * @return the occurence
   */
  public Long getOccurence() {
    return occurence;
  }
}

