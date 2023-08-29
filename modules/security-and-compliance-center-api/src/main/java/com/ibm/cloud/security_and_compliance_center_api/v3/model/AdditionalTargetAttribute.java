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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The additional target attribute of the service.
 */
public class AdditionalTargetAttribute extends GenericModel {

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

  protected String name;
  protected String operator;
  protected String value;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String operator;
    private String value;

    /**
     * Instantiates a new Builder from an existing AdditionalTargetAttribute instance.
     *
     * @param additionalTargetAttribute the instance to initialize the Builder with
     */
    private Builder(AdditionalTargetAttribute additionalTargetAttribute) {
      this.name = additionalTargetAttribute.name;
      this.operator = additionalTargetAttribute.operator;
      this.value = additionalTargetAttribute.value;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AdditionalTargetAttribute.
     *
     * @return the new AdditionalTargetAttribute instance
     */
    public AdditionalTargetAttribute build() {
      return new AdditionalTargetAttribute(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the AdditionalTargetAttribute builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     * @return the AdditionalTargetAttribute builder
     */
    public Builder operator(String operator) {
      this.operator = operator;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the AdditionalTargetAttribute builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected AdditionalTargetAttribute() { }

  protected AdditionalTargetAttribute(Builder builder) {
    name = builder.name;
    operator = builder.operator;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a AdditionalTargetAttribute builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The additional target attribute name.
   *
   * @return the name
   */
  public String name() {
    return name;
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
   * The value.
   *
   * @return the value
   */
  public String value() {
    return value;
  }
}

