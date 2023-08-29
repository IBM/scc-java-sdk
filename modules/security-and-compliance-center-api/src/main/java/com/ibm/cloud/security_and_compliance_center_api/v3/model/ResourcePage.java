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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The page of resource evaluation summaries.
 */
public class ResourcePage extends GenericModel {

  @SerializedName("total_count")
  protected Long totalCount;
  protected Long limit;
  protected String start;
  protected PageHRef first;
  protected PageHRef next;
  @SerializedName("home_account_id")
  protected String homeAccountId;
  @SerializedName("report_id")
  protected String reportId;
  protected List<Resource> resources;

  protected ResourcePage() { }

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
   * Gets the limit.
   *
   * The requested page limi.t.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the start.
   *
   * The token of the next page, when it's present.
   *
   * @return the start
   */
  public String getStart() {
    return start;
  }

  /**
   * Gets the first.
   *
   * The page reference.
   *
   * @return the first
   */
  public PageHRef getFirst() {
    return first;
  }

  /**
   * Gets the next.
   *
   * The page reference.
   *
   * @return the next
   */
  public PageHRef getNext() {
    return next;
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
   * Gets the resources.
   *
   * The list of resource evaluation summaries that are on the page.
   *
   * @return the resources
   */
  public List<Resource> getResources() {
    return resources;
  }
}

