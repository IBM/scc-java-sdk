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
 * The report violation data point.
 */
public class ReportViolationDataPoint extends GenericModel {

  @SerializedName("report_id")
  protected String reportId;
  @SerializedName("report_group_id")
  protected String reportGroupId;
  @SerializedName("scan_time")
  protected String scanTime;
  protected ComplianceStats controls;

  protected ReportViolationDataPoint() { }

  /**
   * Gets the reportId.
   *
   * The ID of the report.
   *
   * @return the reportId
   */
  public String getReportId() {
    return reportId;
  }

  /**
   * Gets the reportGroupId.
   *
   * The group ID that is associated with the report. The group ID combines profile, scope, and attachment IDs.
   *
   * @return the reportGroupId
   */
  public String getReportGroupId() {
    return reportGroupId;
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
   * Gets the controls.
   *
   * The compliance stats.
   *
   * @return the controls
   */
  public ComplianceStats getControls() {
    return controls;
  }
}

