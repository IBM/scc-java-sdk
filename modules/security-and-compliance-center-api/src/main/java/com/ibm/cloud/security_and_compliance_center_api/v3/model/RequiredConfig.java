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
 * The required configurations for a Rule.
 *
 * Classes which extend this class:
 * - RequiredConfigConditionBase
 * - RequiredConfigConditionList
 * - RequiredConfigConditionSubRule
 */
public class RequiredConfig extends GenericModel {

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
  protected String property;
  protected String operator;
  protected Object value;
  protected List<ConditionItem> or;
  protected List<ConditionItem> and;
  protected SubRule any;
  @SerializedName("any_ifexists")
  protected SubRule anyIfexists;
  protected SubRule all;
  @SerializedName("all_ifexists")
  protected SubRule allIfexists;

  protected RequiredConfig() { }

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
   * The value can be of any type.
   *
   * @return the value
   */
  public Object value() {
    return value;
  }

  /**
   * Gets the or.
   *
   * A list of required configurations where one item should evaluate to true.
   *
   * @return the or
   */
  public List<ConditionItem> or() {
    return or;
  }

  /**
   * Gets the and.
   *
   * A list of required configurations where all items should evaluate to true.
   *
   * @return the and
   */
  public List<ConditionItem> and() {
    return and;
  }

  /**
   * Gets the any.
   *
   * A rule within a rule used in the requiredConfig.
   *
   * @return the any
   */
  public SubRule any() {
    return any;
  }

  /**
   * Gets the anyIfexists.
   *
   * A rule within a rule used in the requiredConfig.
   *
   * @return the anyIfexists
   */
  public SubRule anyIfexists() {
    return anyIfexists;
  }

  /**
   * Gets the all.
   *
   * A rule within a rule used in the requiredConfig.
   *
   * @return the all
   */
  public SubRule all() {
    return all;
  }

  /**
   * Gets the allIfexists.
   *
   * A rule within a rule used in the requiredConfig.
   *
   * @return the allIfexists
   */
  public SubRule allIfexists() {
    return allIfexists;
  }
}

