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
 * The response schema for creating a scan.
 */
public class Scan extends GenericModel {

  /**
   * The status of the scan.
   */
  public interface Status {
    /** completed. */
    String COMPLETED = "completed";
    /** in_progress. */
    String IN_PROGRESS = "in_progress";
  }

  /**
   * The type of scan.
   */
  public interface ScanType {
    /** ondemand. */
    String ONDEMAND = "ondemand";
    /** scheduled. */
    String SCHEDULED = "scheduled";
  }

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

  protected Scan() { }

  /**
   * Gets the id.
   *
   * The scan ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the accountId.
   *
   * The account ID.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the attachmentId.
   *
   * The attachment ID of a profile.
   *
   * @return the attachmentId
   */
  public String getAttachmentId() {
    return attachmentId;
  }

  /**
   * Gets the reportId.
   *
   * The report ID.
   *
   * @return the reportId
   */
  public String getReportId() {
    return reportId;
  }

  /**
   * Gets the status.
   *
   * The status of the scan.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the lastScanTime.
   *
   * The last scan time.
   *
   * @return the lastScanTime
   */
  public String getLastScanTime() {
    return lastScanTime;
  }

  /**
   * Gets the nextScanTime.
   *
   * The next scan time.
   *
   * @return the nextScanTime
   */
  public String getNextScanTime() {
    return nextScanTime;
  }

  /**
   * Gets the scanType.
   *
   * The type of scan.
   *
   * @return the scanType
   */
  public String getScanType() {
    return scanType;
  }

  /**
   * Gets the occurence.
   *
   * The occurrence of the scan.
   *
   * @return the occurence
   */
  public Long getOccurence() {
    return occurence;
  }
}

