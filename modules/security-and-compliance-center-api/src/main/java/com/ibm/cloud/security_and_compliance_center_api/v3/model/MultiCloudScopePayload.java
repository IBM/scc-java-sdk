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
 * MultiCloudScopePayload.
 *
 * Classes which extend this class:
 * - MultiCloudScopePayloadById
 * - MultiCloudScopePayloadByProperties
 */
public class MultiCloudScopePayload extends GenericModel {

  protected String id;
  protected String description;
  protected String environment;
  @SerializedName("properties")
  protected List<ScopeProperty> xProperties;

  protected MultiCloudScopePayload() { }

  /**
   * Gets the id.
   *
   * The UUID of the scope made.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the description.
   *
   * The details of a newly created scope.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the environment.
   *
   * The environment that relates to this scope.
   *
   * @return the environment
   */
  public String environment() {
    return environment;
  }

  /**
   * Gets the xProperties.
   *
   * The properties supported for scoping by this environment.
   *
   * @return the xProperties
   */
  public List<ScopeProperty> xProperties() {
    return xProperties;
  }
}

