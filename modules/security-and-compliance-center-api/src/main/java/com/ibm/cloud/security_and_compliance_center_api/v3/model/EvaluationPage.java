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
 * The page of assessment evaluations.
 */
public class EvaluationPage extends GenericModel {

  protected Long limit;
  @SerializedName("total_count")
  protected Long totalCount;
  protected PageHRefFirst first;
  protected PageHRefNext next;
  @SerializedName("report_id")
  protected String reportId;
  @SerializedName("home_account_id")
  protected String homeAccountId;
  protected List<Evaluation> evaluations;

  protected EvaluationPage() { }

  /**
   * Gets the limit.
   *
   * The requested page limit.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the totalCount.
   *
   * The total number of resources that are in the collection.
   *
   * @return the totalCount
   */
  public Long getTotalCount() {
    return totalCount;
  }

  /**
   * Gets the first.
   *
   * A page reference.
   *
   * @return the first
   */
  public PageHRefFirst getFirst() {
    return first;
  }

  /**
   * Gets the next.
   *
   * A page reference.
   *
   * @return the next
   */
  public PageHRefNext getNext() {
    return next;
  }

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
   * Gets the homeAccountId.
   *
   * The ID of the home account.
   *
   * @return the homeAccountId
   */
  public String getHomeAccountId() {
    return homeAccountId;
  }

  /**
   * Gets the evaluations.
   *
   * The list of evaluations that are on the page.
   *
   * @return the evaluations
   */
  public List<Evaluation> getEvaluations() {
    return evaluations;
  }
}

