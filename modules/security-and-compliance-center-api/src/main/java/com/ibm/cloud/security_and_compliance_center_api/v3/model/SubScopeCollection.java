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
 * The response body of the subscopes.
 */
public class SubScopeCollection extends GenericModel {

  protected Long limit;
  @SerializedName("total_count")
  protected Long totalCount;
  protected PageHRefFirst first;
  protected PageHRefNext next;
  protected List<SubScope> subscopes;

  protected SubScopeCollection() { }

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
   * Gets the subscopes.
   *
   * The array of subscopes.
   *
   * @return the subscopes
   */
  public List<SubScope> getSubscopes() {
    return subscopes;
  }
}

