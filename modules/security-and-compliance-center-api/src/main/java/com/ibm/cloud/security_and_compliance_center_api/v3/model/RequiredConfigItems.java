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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * RequiredConfigItems.
 *
 * Classes which extend this class:
 * - RequiredConfigItemsRequiredConfigOr
 * - RequiredConfigItemsRequiredConfigAnd
 * - RequiredConfigItemsRequiredConfigBase
 */
public class RequiredConfigItems extends GenericModel {

  /**
   * The operator.
   */
  public interface Operator {
    /** string_equals. */
    String STRING_EQUALS = "string_equals";
    /** string_not_equals. */
    String STRING_NOT_EQUALS = "string_not_equals";
    /** string_match. */
    String STRING_MATCH = "string_match";
    /** string_not_match. */
    String STRING_NOT_MATCH = "string_not_match";
    /** string_contains. */
    String STRING_CONTAINS = "string_contains";
    /** string_not_contains. */
    String STRING_NOT_CONTAINS = "string_not_contains";
    /** num_equals. */
    String NUM_EQUALS = "num_equals";
    /** num_not_equals. */
    String NUM_NOT_EQUALS = "num_not_equals";
    /** num_less_than. */
    String NUM_LESS_THAN = "num_less_than";
    /** num_less_than_equals. */
    String NUM_LESS_THAN_EQUALS = "num_less_than_equals";
    /** num_greater_than. */
    String NUM_GREATER_THAN = "num_greater_than";
    /** num_greater_than_equals. */
    String NUM_GREATER_THAN_EQUALS = "num_greater_than_equals";
    /** is_empty. */
    String IS_EMPTY = "is_empty";
    /** is_not_empty. */
    String IS_NOT_EMPTY = "is_not_empty";
    /** is_true. */
    String IS_TRUE = "is_true";
    /** is_false. */
    String IS_FALSE = "is_false";
    /** strings_in_list. */
    String STRINGS_IN_LIST = "strings_in_list";
    /** strings_allowed. */
    String STRINGS_ALLOWED = "strings_allowed";
    /** strings_required. */
    String STRINGS_REQUIRED = "strings_required";
    /** ips_in_range. */
    String IPS_IN_RANGE = "ips_in_range";
    /** ips_equals. */
    String IPS_EQUALS = "ips_equals";
    /** ips_not_equals. */
    String IPS_NOT_EQUALS = "ips_not_equals";
    /** days_less_than. */
    String DAYS_LESS_THAN = "days_less_than";
  }

  protected String description;
  protected List<RequiredConfigItems> or;
  protected List<RequiredConfigItems> and;
  protected String property;
  protected String operator;
  protected Object value;

  protected RequiredConfigItems() { }

  /**
   * Gets the description.
   *
   * The required config description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the or.
   *
   * The `OR` required configurations.
   *
   * @return the or
   */
  public List<RequiredConfigItems> or() {
    return or;
  }

  /**
   * Gets the and.
   *
   * The `AND` required configurations.
   *
   * @return the and
   */
  public List<RequiredConfigItems> and() {
    return and;
  }

  /**
   * Gets the property.
   *
   * The property.
   *
   * @return the property
   */
  public String property() {
    return property;
  }

  /**
   * Gets the operator.
   *
   * The operator.
   *
   * @return the operator
   */
  public String operator() {
    return operator;
  }

  /**
   * Gets the value.
   *
   * Schema for any JSON type.
   *
   * @return the value
   */
  public Object value() {
    return value;
  }
}

