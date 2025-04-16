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
 * The scope ID that is associated with a report. Attributes for this object will be blank if the report has multiple
 * scopes tied to the report.
 */
public class ScopeID extends GenericModel {

  protected String id;
  protected String type;

  protected ScopeID() { }

  /**
   * Gets the id.
   *
   * The scope ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the type.
   *
   * The scope type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }
}

