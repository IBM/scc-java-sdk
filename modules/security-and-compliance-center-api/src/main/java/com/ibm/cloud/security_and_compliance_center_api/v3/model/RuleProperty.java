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
 * The supported config property.
 */
public class RuleProperty extends GenericModel {

  /**
   * The operator kind used when evaluating a property.
   */
  public interface Type {
    /** string. */
    String STRING = "string";
    /** numeric. */
    String NUMERIC = "numeric";
    /** general. */
    String GENERAL = "general";
    /** boolean. */
    String X_BOOLEAN = "boolean";
    /** string_list. */
    String STRING_LIST = "string_list";
    /** ip_list. */
    String IP_LIST = "ip_list";
    /** timestamp. */
    String TIMESTAMP = "timestamp";
  }

  protected String name;
  protected String description;
  protected String type;

  protected RuleProperty() { }

  /**
   * Gets the name.
   *
   * The property name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The property description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the type.
   *
   * The operator kind used when evaluating a property.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }
}

