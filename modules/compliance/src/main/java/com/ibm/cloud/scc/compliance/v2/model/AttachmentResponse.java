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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * attachment details for profile.
 */
public class AttachmentResponse extends GenericModel {

  protected String id;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("included_scope")
  protected ScopePayload includedScope;
  protected List<ScopePayload> exclusions;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("created_on")
  protected String createdOn;
  @SerializedName("updated_by")
  protected String updatedBy;
  @SerializedName("updated_on")
  protected String updatedOn;
  protected String status;
  @SerializedName("attachment_parameters")
  protected List<ParameterDetails> attachmentParameters;
  @SerializedName("last_scan")
  protected String lastScan;
  @SerializedName("last_scan_status")
  protected String lastScanStatus;
  @SerializedName("last_scan_time")
  protected String lastScanTime;

  protected AttachmentResponse() { }

  /**
   * Gets the id.
   *
   * Attachment id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the accountId.
   *
   * Account id.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the includedScope.
   *
   * scope payload.
   *
   * @return the includedScope
   */
  public ScopePayload getIncludedScope() {
    return includedScope;
  }

  /**
   * Gets the exclusions.
   *
   * Excluded scopes.
   *
   * @return the exclusions
   */
  public List<ScopePayload> getExclusions() {
    return exclusions;
  }

  /**
   * Gets the createdBy.
   *
   * Created by.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the createdOn.
   *
   * Created on.
   *
   * @return the createdOn
   */
  public String getCreatedOn() {
    return createdOn;
  }

  /**
   * Gets the updatedBy.
   *
   * Updated by.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the updatedOn.
   *
   * Updated on.
   *
   * @return the updatedOn
   */
  public String getUpdatedOn() {
    return updatedOn;
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
   * Gets the attachmentParameters.
   *
   * Attachment parameters.
   *
   * @return the attachmentParameters
   */
  public List<ParameterDetails> getAttachmentParameters() {
    return attachmentParameters;
  }

  /**
   * Gets the lastScan.
   *
   * Last scan id.
   *
   * @return the lastScan
   */
  public String getLastScan() {
    return lastScan;
  }

  /**
   * Gets the lastScanStatus.
   *
   * Last scan status.
   *
   * @return the lastScanStatus
   */
  public String getLastScanStatus() {
    return lastScanStatus;
  }

  /**
   * Gets the lastScanTime.
   *
   * Last scan time.
   *
   * @return the lastScanTime
   */
  public String getLastScanTime() {
    return lastScanTime;
  }
}

