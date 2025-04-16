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
 * ScopeProperty.
 *
 * Classes which extend this class:
 * - ScopePropertyScopeAny
 * - ScopePropertyScopeType
 * - ScopePropertyScopeId
 * - ScopePropertyExclusions
 */
public class ScopeProperty extends GenericModel {

  protected String name;
  protected Object value;

  protected ScopeProperty() { }

  /**
   * Gets the name.
   *
   * key to say the attribute targets the scope type.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the value.
   *
   * The value can be a string or a string list.
   *
   * @return the value
   */
  public Object value() {
    return value;
  }
}

