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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The property.
 */
public class Property extends GenericModel {

  protected String property;
  @SerializedName("property_description")
  protected String propertyDescription;
  protected String operator;
  @SerializedName("expected_value")
  protected Object expectedValue;
  @SerializedName("found_value")
  protected Object foundValue;

  protected Property() { }

  /**
   * Gets the property.
   *
   * The property name.
   *
   * @return the property
   */
  public String getProperty() {
    return property;
  }

  /**
   * Gets the propertyDescription.
   *
   * The property description.
   *
   * @return the propertyDescription
   */
  public String getPropertyDescription() {
    return propertyDescription;
  }

  /**
   * Gets the operator.
   *
   * The property operator.
   *
   * @return the operator
   */
  public String getOperator() {
    return operator;
  }

  /**
   * Gets the expectedValue.
   *
   * The property value.
   *
   * @return the expectedValue
   */
  public Object getExpectedValue() {
    return expectedValue;
  }

  /**
   * Gets the foundValue.
   *
   * The property value.
   *
   * @return the foundValue
   */
  public Object getFoundValue() {
    return foundValue;
  }
}

