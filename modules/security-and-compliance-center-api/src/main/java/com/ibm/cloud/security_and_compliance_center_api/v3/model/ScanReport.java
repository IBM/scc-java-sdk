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
 * A report detailing the evaluations related to a specific control.
 */
public class ScanReport extends GenericModel {

  /**
   * The enum of different scan report status.
   */
  public interface Status {
    /** pending. */
    String PENDING = "pending";
    /** in_progress. */
    String IN_PROGRESS = "in_progress";
    /** error. */
    String ERROR = "error";
    /** completed. */
    String COMPLETED = "completed";
    /** deleted. */
    String DELETED = "deleted";
  }

  /**
   * The file type of the report.
   */
  public interface Format {
    /** csv. */
    String CSV = "csv";
    /** pdf. */
    String PDF = "pdf";
  }

  protected String id;
  @SerializedName("scan_id")
  protected String scanId;
  @SerializedName("instance_id")
  protected String instanceId;
  @SerializedName("scope_id")
  protected String scopeId;
  @SerializedName("subscope_id")
  protected String subscopeId;
  protected String status;
  @SerializedName("created_on")
  protected Date createdOn;
  protected String format;
  protected String href;

  protected ScanReport() { }

  /**
   * Gets the id.
   *
   * The ID of the scan report.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the scanId.
   *
   * The ID of the scan.
   *
   * @return the scanId
   */
  public String getScanId() {
    return scanId;
  }

  /**
   * Gets the instanceId.
   *
   * The ID of the Security and Compliance Center instance.
   *
   * @return the instanceId
   */
  public String getInstanceId() {
    return instanceId;
  }

  /**
   * Gets the scopeId.
   *
   * The ID of the scope.
   *
   * @return the scopeId
   */
  public String getScopeId() {
    return scopeId;
  }

  /**
   * Gets the subscopeId.
   *
   * The ID of the sub-scope.
   *
   * @return the subscopeId
   */
  public String getSubscopeId() {
    return subscopeId;
  }

  /**
   * Gets the status.
   *
   * The enum of different scan report status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the createdOn.
   *
   * The date when the report was created.
   *
   * @return the createdOn
   */
  public Date getCreatedOn() {
    return createdOn;
  }

  /**
   * Gets the format.
   *
   * The file type of the report.
   *
   * @return the format
   */
  public String getFormat() {
    return format;
  }

  /**
   * Gets the href.
   *
   * The URL of the scan report.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }
}

