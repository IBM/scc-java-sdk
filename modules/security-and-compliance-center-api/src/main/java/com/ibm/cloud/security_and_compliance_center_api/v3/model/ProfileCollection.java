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
 * The response body to get all profiles that are linked to your account.
 */
public class ProfileCollection extends GenericModel {

  @SerializedName("total_count")
  protected Long totalCount;
  protected Long limit;
  protected PaginatedCollectionFirst first;
  protected PaginatedCollectionNext next;
  protected List<ProfileItem> profiles;

  protected ProfileCollection() { }

  /**
   * Gets the totalCount.
   *
   * The number of profiles.
   *
   * @return the totalCount
   */
  public Long getTotalCount() {
    return totalCount;
  }

  /**
   * Gets the limit.
   *
   * The limit of profiles that can be created.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the first.
   *
   * The reference to the first page of entries.
   *
   * @return the first
   */
  public PaginatedCollectionFirst getFirst() {
    return first;
  }

  /**
   * Gets the next.
   *
   * The reference URL for the next few entries.
   *
   * @return the next
   */
  public PaginatedCollectionNext getNext() {
    return next;
  }

  /**
   * Gets the profiles.
   *
   * The profiles.
   *
   * @return the profiles
   */
  public List<ProfileItem> getProfiles() {
    return profiles;
  }
}

