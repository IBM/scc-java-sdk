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
 * A subrule using the 'all' operator.
 */
public class ConditionItemConditionSubRuleConditionSubRuleConditionAll extends ConditionItemConditionSubRule {


  /**
   * Builder.
   */
  public static class Builder {
    private SubRule all;

    /**
     * Instantiates a new Builder from an existing ConditionItemConditionSubRuleConditionSubRuleConditionAll instance.
     *
     * @param conditionItemConditionSubRuleConditionSubRuleConditionAll the instance to initialize the Builder with
     */
    public Builder(ConditionItemConditionSubRule conditionItemConditionSubRuleConditionSubRuleConditionAll) {
      this.all = conditionItemConditionSubRuleConditionSubRuleConditionAll.all;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ConditionItemConditionSubRuleConditionSubRuleConditionAll.
     *
     * @return the new ConditionItemConditionSubRuleConditionSubRuleConditionAll instance
     */
    public ConditionItemConditionSubRuleConditionSubRuleConditionAll build() {
      return new ConditionItemConditionSubRuleConditionSubRuleConditionAll(this);
    }

    /**
     * Set the all.
     *
     * @param all the all
     * @return the ConditionItemConditionSubRuleConditionSubRuleConditionAll builder
     */
    public Builder all(SubRule all) {
      this.all = all;
      return this;
    }
  }

  protected ConditionItemConditionSubRuleConditionSubRuleConditionAll() { }

  protected ConditionItemConditionSubRuleConditionSubRuleConditionAll(Builder builder) {
    all = builder.all;
  }

  /**
   * New builder.
   *
   * @return a ConditionItemConditionSubRuleConditionSubRuleConditionAll builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

