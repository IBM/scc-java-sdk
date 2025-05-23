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
 * The control with compliance stats.
 */
public class ControlWithStats extends GenericModel {

  /**
   * The allowed values of an aggregated status for controls, specifications, assessments, and resources.
   */
  public interface Status {
    /** compliant. */
    String COMPLIANT = "compliant";
    /** not_compliant. */
    String NOT_COMPLIANT = "not_compliant";
    /** unable_to_perform. */
    String UNABLE_TO_PERFORM = "unable_to_perform";
    /** user_evaluation_required. */
    String USER_EVALUATION_REQUIRED = "user_evaluation_required";
    /** not_applicable. */
    String NOT_APPLICABLE = "not_applicable";
  }

  @SerializedName("report_id")
  protected String reportId;
  @SerializedName("home_account_id")
  protected String homeAccountId;
  protected String id;
  @SerializedName("control_library_id")
  protected String controlLibraryId;
  @SerializedName("control_library_version")
  protected String controlLibraryVersion;
  @SerializedName("control_name")
  protected String controlName;
  @SerializedName("control_description")
  protected String controlDescription;
  @SerializedName("control_category")
  protected String controlCategory;
  @SerializedName("control_specifications")
  protected List<ControlSpecificationWithStats> controlSpecifications;
  @SerializedName("resource_tags")
  protected Tags resourceTags;
  protected String status;
  @SerializedName("total_count")
  protected Long totalCount;
  @SerializedName("compliant_count")
  protected Long compliantCount;
  @SerializedName("not_compliant_count")
  protected Long notCompliantCount;
  @SerializedName("unable_to_perform_count")
  protected Long unableToPerformCount;
  @SerializedName("user_evaluation_required_count")
  protected Long userEvaluationRequiredCount;
  @SerializedName("not_applicable_count")
  protected Long notApplicableCount;

  protected ControlWithStats() { }

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
   * Gets the homeAccountId.
   *
   * The home account ID.
   *
   * @return the homeAccountId
   */
  public String getHomeAccountId() {
    return homeAccountId;
  }

  /**
   * Gets the id.
   *
   * The control ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the controlLibraryId.
   *
   * The control library ID.
   *
   * @return the controlLibraryId
   */
  public String getControlLibraryId() {
    return controlLibraryId;
  }

  /**
   * Gets the controlLibraryVersion.
   *
   * The control library version.
   *
   * @return the controlLibraryVersion
   */
  public String getControlLibraryVersion() {
    return controlLibraryVersion;
  }

  /**
   * Gets the controlName.
   *
   * The control name.
   *
   * @return the controlName
   */
  public String getControlName() {
    return controlName;
  }

  /**
   * Gets the controlDescription.
   *
   * The control description.
   *
   * @return the controlDescription
   */
  public String getControlDescription() {
    return controlDescription;
  }

  /**
   * Gets the controlCategory.
   *
   * The control category.
   *
   * @return the controlCategory
   */
  public String getControlCategory() {
    return controlCategory;
  }

  /**
   * Gets the controlSpecifications.
   *
   * The list of specifications that are on the page.
   *
   * @return the controlSpecifications
   */
  public List<ControlSpecificationWithStats> getControlSpecifications() {
    return controlSpecifications;
  }

  /**
   * Gets the resourceTags.
   *
   * The collection of different types of tags.
   *
   * @return the resourceTags
   */
  public Tags getResourceTags() {
    return resourceTags;
  }

  /**
   * Gets the status.
   *
   * The allowed values of an aggregated status for controls, specifications, assessments, and resources.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the totalCount.
   *
   * The total number of checks.
   *
   * @return the totalCount
   */
  public Long getTotalCount() {
    return totalCount;
  }

  /**
   * Gets the compliantCount.
   *
   * The number of compliant checks.
   *
   * @return the compliantCount
   */
  public Long getCompliantCount() {
    return compliantCount;
  }

  /**
   * Gets the notCompliantCount.
   *
   * The number of checks that are not compliant.
   *
   * @return the notCompliantCount
   */
  public Long getNotCompliantCount() {
    return notCompliantCount;
  }

  /**
   * Gets the unableToPerformCount.
   *
   * The number of checks that are unable to perform.
   *
   * @return the unableToPerformCount
   */
  public Long getUnableToPerformCount() {
    return unableToPerformCount;
  }

  /**
   * Gets the userEvaluationRequiredCount.
   *
   * The number of checks that require a user evaluation.
   *
   * @return the userEvaluationRequiredCount
   */
  public Long getUserEvaluationRequiredCount() {
    return userEvaluationRequiredCount;
  }

  /**
   * Gets the notApplicableCount.
   *
   * The number of not applicable (with no evaluations) checks.
   *
   * @return the notApplicableCount
   */
  public Long getNotApplicableCount() {
    return notApplicableCount;
  }
}

