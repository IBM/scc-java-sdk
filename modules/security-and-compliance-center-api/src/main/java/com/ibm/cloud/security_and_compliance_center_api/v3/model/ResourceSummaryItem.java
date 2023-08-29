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
 * The resource summary item.
 */
public class ResourceSummaryItem extends GenericModel {

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
  }

  protected String name;
  protected String id;
  protected String service;
  protected Tags tags;
  protected String account;
  protected String status;
  @SerializedName("total_count")
  protected Long totalCount;
  @SerializedName("pass_count")
  protected Long passCount;
  @SerializedName("failure_count")
  protected Long failureCount;
  @SerializedName("error_count")
  protected Long errorCount;
  @SerializedName("completed_count")
  protected Long completedCount;

  protected ResourceSummaryItem() { }

  /**
   * Gets the name.
   *
   * The resource name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the id.
   *
   * The resource ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the service.
   *
   * The service that is managing the resource.
   *
   * @return the service
   */
  public String getService() {
    return service;
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
   * Gets the account.
   *
   * The account that owns the resource.
   *
   * @return the account
   */
  public String getAccount() {
    return account;
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
   * The total number of evaluations.
   *
   * @return the totalCount
   */
  public Long getTotalCount() {
    return totalCount;
  }

  /**
   * Gets the passCount.
   *
   * The number of passed evaluations.
   *
   * @return the passCount
   */
  public Long getPassCount() {
    return passCount;
  }

  /**
   * Gets the failureCount.
   *
   * The number of failed evaluations.
   *
   * @return the failureCount
   */
  public Long getFailureCount() {
    return failureCount;
  }

  /**
   * Gets the errorCount.
   *
   * The number of evaluations that started, but did not finish, and ended with errors.
   *
   * @return the errorCount
   */
  public Long getErrorCount() {
    return errorCount;
  }

  /**
   * Gets the completedCount.
   *
   * The total number of completed evaluations.
   *
   * @return the completedCount
   */
  public Long getCompletedCount() {
    return completedCount;
  }
}

