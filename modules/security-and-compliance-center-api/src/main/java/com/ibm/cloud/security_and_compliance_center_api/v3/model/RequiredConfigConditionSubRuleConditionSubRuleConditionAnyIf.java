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
 * A subrule using the 'any_ifexists' operator.
 */
public class RequiredConfigConditionSubRuleConditionSubRuleConditionAnyIf extends RequiredConfigConditionSubRule {


  /**
   * Builder.
   */
  public static class Builder {
    private SubRule anyIfexists;

    /**
     * Instantiates a new Builder from an existing RequiredConfigConditionSubRuleConditionSubRuleConditionAnyIf instance.
     *
     * @param requiredConfigConditionSubRuleConditionSubRuleConditionAnyIf the instance to initialize the Builder with
     */
    public Builder(RequiredConfigConditionSubRule requiredConfigConditionSubRuleConditionSubRuleConditionAnyIf) {
      this.anyIfexists = requiredConfigConditionSubRuleConditionSubRuleConditionAnyIf.anyIfexists;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RequiredConfigConditionSubRuleConditionSubRuleConditionAnyIf.
     *
     * @return the new RequiredConfigConditionSubRuleConditionSubRuleConditionAnyIf instance
     */
    public RequiredConfigConditionSubRuleConditionSubRuleConditionAnyIf build() {
      return new RequiredConfigConditionSubRuleConditionSubRuleConditionAnyIf(this);
    }

    /**
     * Set the anyIfexists.
     *
     * @param anyIfexists the anyIfexists
     * @return the RequiredConfigConditionSubRuleConditionSubRuleConditionAnyIf builder
     */
    public Builder anyIfexists(SubRule anyIfexists) {
      this.anyIfexists = anyIfexists;
      return this;
    }
  }

  protected RequiredConfigConditionSubRuleConditionSubRuleConditionAnyIf() { }

  protected RequiredConfigConditionSubRuleConditionSubRuleConditionAnyIf(Builder builder) {
    anyIfexists = builder.anyIfexists;
  }

  /**
   * New builder.
   *
   * @return a RequiredConfigConditionSubRuleConditionSubRuleConditionAnyIf builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

