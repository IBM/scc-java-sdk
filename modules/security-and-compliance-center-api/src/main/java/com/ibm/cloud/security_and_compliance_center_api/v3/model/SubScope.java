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
 * A segment of a scope. Subscopes are used to ensure that the members of your teams who review results only have access
 * to the information regarding the instances that they have access to.
 */
public class SubScope extends GenericModel {

  protected String id;
  protected String name;
  protected String description;
  protected String environment;
  @SerializedName("properties")
  protected List<ScopeProperty> xProperties;

  protected SubScope() { }

  /**
   * Gets the id.
   *
   * The Subscope ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * The name of the Subscope.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Text to describe the Subscope.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the environment.
   *
   * The virtual space where applications can be deployed and managed.
   *
   * @return the environment
   */
  public String getEnvironment() {
    return environment;
  }

  /**
   * Gets the xProperties.
   *
   * Additional attributes that are supported for scoping by this environment.
   *
   * @return the xProperties
   */
  public List<ScopeProperty> getXProperties() {
    return xProperties;
  }
}

