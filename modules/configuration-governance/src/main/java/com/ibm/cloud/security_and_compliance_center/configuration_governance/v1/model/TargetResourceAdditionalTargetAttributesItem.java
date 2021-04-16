/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.security_and_compliance_center.configuration_governance.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The attributes that are associated with a rule or template target.
 */
public class TargetResourceAdditionalTargetAttributesItem extends GenericModel {

  /**
   * The way in which the `name` field is compared to its value.
   *
   * There are three types of operators: string, numeric, and boolean.
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
    /** strings_in_list. */
    String STRINGS_IN_LIST = "strings_in_list";
    /** ips_in_range. */
    String IPS_IN_RANGE = "ips_in_range";
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
  }

  protected String name;
  protected String value;
  protected String operator;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String value;
    private String operator;

    private Builder(TargetResourceAdditionalTargetAttributesItem targetResourceAdditionalTargetAttributesItem) {
      this.name = targetResourceAdditionalTargetAttributesItem.name;
      this.value = targetResourceAdditionalTargetAttributesItem.value;
      this.operator = targetResourceAdditionalTargetAttributesItem.operator;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     * @param value the value
     * @param operator the operator
     */
    public Builder(String name, String value, String operator) {
      this.name = name;
      this.value = value;
      this.operator = operator;
    }

    /**
     * Builds a TargetResourceAdditionalTargetAttributesItem.
     *
     * @return the new TargetResourceAdditionalTargetAttributesItem instance
     */
    public TargetResourceAdditionalTargetAttributesItem build() {
      return new TargetResourceAdditionalTargetAttributesItem(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the TargetResourceAdditionalTargetAttributesItem builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the TargetResourceAdditionalTargetAttributesItem builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     * @return the TargetResourceAdditionalTargetAttributesItem builder
     */
    public Builder operator(String operator) {
      this.operator = operator;
      return this;
    }
  }

  protected TargetResourceAdditionalTargetAttributesItem(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.value,
      "value cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.operator,
      "operator cannot be null");
    name = builder.name;
    value = builder.value;
    operator = builder.operator;
  }

  /**
   * New builder.
   *
   * @return a TargetResourceAdditionalTargetAttributesItem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The name of the additional attribute that you want to use to further qualify the target.
   *
   * Options differ depending on the service or resource that you are targeting with a rule or template. For more
   * information, refer to the service documentation.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the value.
   *
   * The value that you want to apply to `name` field.
   *
   * Options differ depending on the rule or template that you configure. For more information, refer to the service
   * documentation.
   *
   * @return the value
   */
  public String value() {
    return value;
  }

  /**
   * Gets the operator.
   *
   * The way in which the `name` field is compared to its value.
   *
   * There are three types of operators: string, numeric, and boolean.
   *
   * @return the operator
   */
  public String operator() {
    return operator;
  }
}

