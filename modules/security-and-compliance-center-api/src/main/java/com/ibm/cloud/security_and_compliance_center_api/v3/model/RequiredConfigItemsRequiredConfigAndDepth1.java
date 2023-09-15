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

import java.util.ArrayList;
import java.util.List;

/**
 * RequiredConfigItemsRequiredConfigAndDepth1.
 */
public class RequiredConfigItemsRequiredConfigAndDepth1 extends RequiredConfigItems {


  /**
   * Builder.
   */
  public static class Builder {
    private String description;
    private List<RequiredConfigBase> and;

    /**
     * Instantiates a new Builder from an existing RequiredConfigItemsRequiredConfigAndDepth1 instance.
     *
     * @param requiredConfigItemsRequiredConfigAndDepth1 the instance to initialize the Builder with
     */
    public Builder(RequiredConfigItems requiredConfigItemsRequiredConfigAndDepth1) {
      this.description = requiredConfigItemsRequiredConfigAndDepth1.description;
      this.and = requiredConfigItemsRequiredConfigAndDepth1.and;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RequiredConfigItemsRequiredConfigAndDepth1.
     *
     * @return the new RequiredConfigItemsRequiredConfigAndDepth1 instance
     */
    public RequiredConfigItemsRequiredConfigAndDepth1 build() {
      return new RequiredConfigItemsRequiredConfigAndDepth1(this);
    }

    /**
     * Adds an and to and.
     *
     * @param and the new and
     * @return the RequiredConfigItemsRequiredConfigAndDepth1 builder
     */
    public Builder addAnd(RequiredConfigBase and) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(and,
        "and cannot be null");
      if (this.and == null) {
        this.and = new ArrayList<RequiredConfigBase>();
      }
      this.and.add(and);
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the RequiredConfigItemsRequiredConfigAndDepth1 builder
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
     * @return the RequiredConfigItemsRequiredConfigAndDepth1 builder
     */
    public Builder and(List<RequiredConfigBase> and) {
      this.and = and;
      return this;
    }
  }

  protected RequiredConfigItemsRequiredConfigAndDepth1() { }

  protected RequiredConfigItemsRequiredConfigAndDepth1(Builder builder) {
    description = builder.description;
    and = builder.and;
  }

  /**
   * New builder.
   *
   * @return a RequiredConfigItemsRequiredConfigAndDepth1 builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

