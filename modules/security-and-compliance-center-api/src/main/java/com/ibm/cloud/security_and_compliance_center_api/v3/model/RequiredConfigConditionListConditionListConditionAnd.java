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

import java.util.ArrayList;
import java.util.List;

/**
 * RequiredConfigConditionListConditionListConditionAnd.
 */
public class RequiredConfigConditionListConditionListConditionAnd extends RequiredConfigConditionList {


  /**
   * Builder.
   */
  public static class Builder {
    private String description;
    private List<ConditionItem> and;

    /**
     * Instantiates a new Builder from an existing RequiredConfigConditionListConditionListConditionAnd instance.
     *
     * @param requiredConfigConditionListConditionListConditionAnd the instance to initialize the Builder with
     */
    public Builder(RequiredConfigConditionList requiredConfigConditionListConditionListConditionAnd) {
      this.description = requiredConfigConditionListConditionListConditionAnd.description;
      this.and = requiredConfigConditionListConditionListConditionAnd.and;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RequiredConfigConditionListConditionListConditionAnd.
     *
     * @return the new RequiredConfigConditionListConditionListConditionAnd instance
     */
    public RequiredConfigConditionListConditionListConditionAnd build() {
      return new RequiredConfigConditionListConditionListConditionAnd(this);
    }

    /**
     * Adds a new element to and.
     *
     * @param and the new element to be added
     * @return the RequiredConfigConditionListConditionListConditionAnd builder
     */
    public Builder addAnd(ConditionItem and) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(and,
        "and cannot be null");
      if (this.and == null) {
        this.and = new ArrayList<ConditionItem>();
      }
      this.and.add(and);
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the RequiredConfigConditionListConditionListConditionAnd builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the and.
     * Existing and will be replaced.
     *
     * @param and the and
     * @return the RequiredConfigConditionListConditionListConditionAnd builder
     */
    public Builder and(List<ConditionItem> and) {
      this.and = and;
      return this;
    }
  }

  protected RequiredConfigConditionListConditionListConditionAnd() { }

  protected RequiredConfigConditionListConditionListConditionAnd(Builder builder) {
    description = builder.description;
    and = builder.and;
  }

  /**
   * New builder.
   *
   * @return a RequiredConfigConditionListConditionListConditionAnd builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

