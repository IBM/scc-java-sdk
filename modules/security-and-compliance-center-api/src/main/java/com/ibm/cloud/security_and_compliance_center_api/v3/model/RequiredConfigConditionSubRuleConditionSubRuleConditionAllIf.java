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
 * A subrule using the 'all_ifexists' operator.
 */
public class RequiredConfigConditionSubRuleConditionSubRuleConditionAllIf extends RequiredConfigConditionSubRule {


  /**
   * Builder.
   */
  public static class Builder {
    private SubRule allIfexists;

    /**
     * Instantiates a new Builder from an existing RequiredConfigConditionSubRuleConditionSubRuleConditionAllIf instance.
     *
     * @param requiredConfigConditionSubRuleConditionSubRuleConditionAllIf the instance to initialize the Builder with
     */
    public Builder(RequiredConfigConditionSubRule requiredConfigConditionSubRuleConditionSubRuleConditionAllIf) {
      this.allIfexists = requiredConfigConditionSubRuleConditionSubRuleConditionAllIf.allIfexists;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RequiredConfigConditionSubRuleConditionSubRuleConditionAllIf.
     *
     * @return the new RequiredConfigConditionSubRuleConditionSubRuleConditionAllIf instance
     */
    public RequiredConfigConditionSubRuleConditionSubRuleConditionAllIf build() {
      return new RequiredConfigConditionSubRuleConditionSubRuleConditionAllIf(this);
    }

    /**
     * Set the allIfexists.
     *
     * @param allIfexists the allIfexists
     * @return the RequiredConfigConditionSubRuleConditionSubRuleConditionAllIf builder
     */
    public Builder allIfexists(SubRule allIfexists) {
      this.allIfexists = allIfexists;
      return this;
    }
  }

  protected RequiredConfigConditionSubRuleConditionSubRuleConditionAllIf() { }

  protected RequiredConfigConditionSubRuleConditionSubRuleConditionAllIf(Builder builder) {
    allIfexists = builder.allIfexists;
  }

  /**
   * New builder.
   *
   * @return a RequiredConfigConditionSubRuleConditionSubRuleConditionAllIf builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

