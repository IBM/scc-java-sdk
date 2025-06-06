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

/**
 * The required configuration base object.
 */
public class ConditionItemConditionBase extends ConditionItem {

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


  /**
   * Builder.
   */
  public static class Builder {
    private String description;
    private String property;
    private String operator;
    private Object value;

    /**
     * Instantiates a new Builder from an existing ConditionItemConditionBase instance.
     *
     * @param conditionItemConditionBase the instance to initialize the Builder with
     */
    public Builder(ConditionItem conditionItemConditionBase) {
      this.description = conditionItemConditionBase.description;
      this.property = conditionItemConditionBase.property;
      this.operator = conditionItemConditionBase.operator;
      this.value = conditionItemConditionBase.value;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param property the property
     * @param operator the operator
     */
    public Builder(String property, String operator) {
      this.property = property;
      this.operator = operator;
    }

    /**
     * Builds a ConditionItemConditionBase.
     *
     * @return the new ConditionItemConditionBase instance
     */
    public ConditionItemConditionBase build() {
      return new ConditionItemConditionBase(this);
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ConditionItemConditionBase builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the property.
     *
     * @param property the property
     * @return the ConditionItemConditionBase builder
     */
    public Builder property(String property) {
      this.property = property;
      return this;
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     * @return the ConditionItemConditionBase builder
     */
    public Builder operator(String operator) {
      this.operator = operator;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the ConditionItemConditionBase builder
     */
    public Builder value(Object value) {
      this.value = value;
      return this;
    }
  }

  protected ConditionItemConditionBase() { }

  protected ConditionItemConditionBase(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.property,
      "property cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.operator,
      "operator cannot be null");
    description = builder.description;
    property = builder.property;
    operator = builder.operator;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a ConditionItemConditionBase builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

