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
 * Response body of get All profiles.
 */
public class GetAllProfilesRespBody extends GenericModel {

  @SerializedName("total_count")
  protected Long totalCount;
  protected Long limit;
  protected PageRefFirst first;
  protected PageRefNext next;
  protected List<ListProfilesResponseStructure> profiles;

  protected GetAllProfilesRespBody() { }

  /**
   * Gets the totalCount.
   *
   * Number of profiles.
   *
   * @return the totalCount
   */
  public Long getTotalCount() {
    return totalCount;
  }

  /**
   * Gets the limit.
   *
   * limit.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the first.
   *
   * Reference page first.
   *
   * @return the first
   */
  public PageRefFirst getFirst() {
    return first;
  }

  /**
   * Gets the next.
   *
   * Reference page next.
   *
   * @return the next
   */
  public PageRefNext getNext() {
    return next;
  }

  /**
   * Gets the profiles.
   *
   * Profiles.
   *
   * @return the profiles
   */
  public List<ListProfilesResponseStructure> getProfiles() {
    return profiles;
  }
}

