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
 * The `OR` required configurations.
 */
public class RequiredConfigItemsRequiredConfigOrDepth1 extends RequiredConfigItems {


  /**
   * Builder.
   */
  public static class Builder {
    private String description;
    private List<RequiredConfigBase> or;

    /**
     * Instantiates a new Builder from an existing RequiredConfigItemsRequiredConfigOrDepth1 instance.
     *
     * @param requiredConfigItemsRequiredConfigOrDepth1 the instance to initialize the Builder with
     */
    public Builder(RequiredConfigItems requiredConfigItemsRequiredConfigOrDepth1) {
      this.description = requiredConfigItemsRequiredConfigOrDepth1.description;
      this.or = requiredConfigItemsRequiredConfigOrDepth1.or;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RequiredConfigItemsRequiredConfigOrDepth1.
     *
     * @return the new RequiredConfigItemsRequiredConfigOrDepth1 instance
     */
    public RequiredConfigItemsRequiredConfigOrDepth1 build() {
      return new RequiredConfigItemsRequiredConfigOrDepth1(this);
    }

    /**
     * Adds an or to or.
     *
     * @param or the new or
     * @return the RequiredConfigItemsRequiredConfigOrDepth1 builder
     */
    public Builder addOr(RequiredConfigBase or) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(or,
        "or cannot be null");
      if (this.or == null) {
        this.or = new ArrayList<RequiredConfigBase>();
      }
      this.or.add(or);
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the RequiredConfigItemsRequiredConfigOrDepth1 builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the or.
     * Existing or will be replaced.
     *
     * @param or the or
     * @return the RequiredConfigItemsRequiredConfigOrDepth1 builder
     */
    public Builder or(List<RequiredConfigBase> or) {
      this.or = or;
      return this;
    }
  }

  protected RequiredConfigItemsRequiredConfigOrDepth1() { }

  protected RequiredConfigItemsRequiredConfigOrDepth1(Builder builder) {
    description = builder.description;
    or = builder.or;
  }

  /**
   * New builder.
   *
   * @return a RequiredConfigItemsRequiredConfigOrDepth1 builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

