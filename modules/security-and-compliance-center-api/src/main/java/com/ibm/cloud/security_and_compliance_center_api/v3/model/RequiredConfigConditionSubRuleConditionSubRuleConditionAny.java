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
 * A subrule using the 'any' operator.
 */
public class RequiredConfigConditionSubRuleConditionSubRuleConditionAny extends RequiredConfigConditionSubRule {


  /**
   * Builder.
   */
  public static class Builder {
    private SubRule any;

    /**
     * Instantiates a new Builder from an existing RequiredConfigConditionSubRuleConditionSubRuleConditionAny instance.
     *
     * @param requiredConfigConditionSubRuleConditionSubRuleConditionAny the instance to initialize the Builder with
     */
    public Builder(RequiredConfigConditionSubRule requiredConfigConditionSubRuleConditionSubRuleConditionAny) {
      this.any = requiredConfigConditionSubRuleConditionSubRuleConditionAny.any;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RequiredConfigConditionSubRuleConditionSubRuleConditionAny.
     *
     * @return the new RequiredConfigConditionSubRuleConditionSubRuleConditionAny instance
     */
    public RequiredConfigConditionSubRuleConditionSubRuleConditionAny build() {
      return new RequiredConfigConditionSubRuleConditionSubRuleConditionAny(this);
    }

    /**
     * Set the any.
     *
     * @param any the any
     * @return the RequiredConfigConditionSubRuleConditionSubRuleConditionAny builder
     */
    public Builder any(SubRule any) {
      this.any = any;
      return this;
    }
  }

  protected RequiredConfigConditionSubRuleConditionSubRuleConditionAny() { }

  protected RequiredConfigConditionSubRuleConditionSubRuleConditionAny(Builder builder) {
    any = builder.any;
  }

  /**
   * New builder.
   *
   * @return a RequiredConfigConditionSubRuleConditionSubRuleConditionAny builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

