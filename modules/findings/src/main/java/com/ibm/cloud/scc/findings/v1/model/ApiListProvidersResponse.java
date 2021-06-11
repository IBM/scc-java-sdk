/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.scc.findings.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response including listed providers.
 */
public class ApiListProvidersResponse extends GenericModel {

  protected List<ApiProvider> providers;
  protected Long limit;
  protected Long skip;
  @SerializedName("total_count")
  protected Long totalCount;

  /**
   * Gets the providers.
   *
   * The providers requested.
   *
   * @return the providers
   */
  public List<ApiProvider> getProviders() {
    return providers;
  }

  /**
   * Gets the limit.
   *
   * The number of elements returned in the current instance. Default is 200.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the skip.
   *
   * The offset is the index of the item from which you want to start returning data from. Default is 0.
   *
   * @return the skip
   */
  public Long getSkip() {
    return skip;
  }

  /**
   * Gets the totalCount.
   *
   * The total number of providers available.
   *
   * @return the totalCount
   */
  public Long getTotalCount() {
    return totalCount;
  }
}

