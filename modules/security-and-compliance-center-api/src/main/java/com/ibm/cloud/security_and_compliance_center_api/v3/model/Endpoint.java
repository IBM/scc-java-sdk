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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The service configurations endpoint.
 */
public class Endpoint extends GenericModel {

  protected String host;
  protected String path;
  protected String region;
  @SerializedName("advisory_call_limit")
  protected Long advisoryCallLimit;

  protected Endpoint() { }

  /**
   * Gets the host.
   *
   * The endpoint host.
   *
   * @return the host
   */
  public String getHost() {
    return host;
  }

  /**
   * Gets the path.
   *
   * The endpoint path.
   *
   * @return the path
   */
  public String getPath() {
    return path;
  }

  /**
   * Gets the region.
   *
   * The endpoint region.
   *
   * @return the region
   */
  public String getRegion() {
    return region;
  }

  /**
   * Gets the advisoryCallLimit.
   *
   * The endpoints advisory call limit.
   *
   * @return the advisoryCallLimit
   */
  public Long getAdvisoryCallLimit() {
    return advisoryCallLimit;
  }
}

