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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The report.
 */
public class Report extends GenericModel {

  protected String id;
  protected String type;
  @SerializedName("group_id")
  protected String groupId;
  @SerializedName("created_on")
  protected String createdOn;
  @SerializedName("scan_time")
  protected String scanTime;
  @SerializedName("cos_object")
  protected String cosObject;
  @SerializedName("instance_id")
  protected String instanceId;
  protected Account account;
  protected ProfileInfo profile;
  protected ScopeID scope;
  protected Attachment attachment;
  @SerializedName("controls_summary")
  protected ComplianceStatsWithNonCompliant controlsSummary;
  @SerializedName("evaluations_summary")
  protected EvalStats evaluationsSummary;
  protected Tags tags;
  protected List<ReportScope> scopes;
  @SerializedName("additional_details")
  protected AdditionalDetails additionalDetails;

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
   * The ID of the Security and Compliance Center instance.
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
   * Gets the scope.
   *
   * The scope ID that is associated with a report. Attributes for this object will be blank if the report has multiple
   * scopes tied to the report.
   *
   * @return the scope
   */
  public ScopeID getScope() {
    return scope;
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

  /**
   * Gets the controlsSummary.
   *
   * The compliance stats.
   *
   * @return the controlsSummary
   */
  public ComplianceStatsWithNonCompliant getControlsSummary() {
    return controlsSummary;
  }

  /**
   * Gets the evaluationsSummary.
   *
   * The evaluation stats.
   *
   * @return the evaluationsSummary
   */
  public EvalStats getEvaluationsSummary() {
    return evaluationsSummary;
  }

  /**
   * Gets the tags.
   *
   * The collection of different types of tags.
   *
   * @return the tags
   */
  public Tags getTags() {
    return tags;
  }

  /**
   * Gets the scopes.
   *
   * The scopes used in the report.
   *
   * @return the scopes
   */
  public List<ReportScope> getScopes() {
    return scopes;
  }

  /**
   * Gets the additionalDetails.
   *
   * Extended information for a report.
   *
   * @return the additionalDetails
   */
  public AdditionalDetails getAdditionalDetails() {
    return additionalDetails;
  }
}

