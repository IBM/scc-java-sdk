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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The scopes used in the report.
 */
public class ReportScope extends GenericModel {

  protected String id;
  protected String name;
  protected String href;
  protected String environment;

  protected ReportScope() { }

  /**
   * Gets the id.
   *
   * The ID of the scope used.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * The name of the scope used.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the href.
   *
   * The url to a report concerning the specified scope.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the environment.
   *
   * The cloud provider that the scope is targeting.
   *
   * @return the environment
   */
  public String getEnvironment() {
    return environment;
  }
}

