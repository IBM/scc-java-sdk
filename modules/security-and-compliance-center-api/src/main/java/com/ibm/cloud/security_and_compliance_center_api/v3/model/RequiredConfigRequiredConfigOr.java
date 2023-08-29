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
public class RequiredConfigRequiredConfigOr extends RequiredConfig {


  /**
   * Builder.
   */
  public static class Builder {
    private String description;
    private List<RequiredConfigItems> or;

    /**
     * Instantiates a new Builder from an existing RequiredConfigRequiredConfigOr instance.
     *
     * @param requiredConfigRequiredConfigOr the instance to initialize the Builder with
     */
    public Builder(RequiredConfig requiredConfigRequiredConfigOr) {
      this.description = requiredConfigRequiredConfigOr.description;
      this.or = requiredConfigRequiredConfigOr.or;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RequiredConfigRequiredConfigOr.
     *
     * @return the new RequiredConfigRequiredConfigOr instance
     */
    public RequiredConfigRequiredConfigOr build() {
      return new RequiredConfigRequiredConfigOr(this);
    }

    /**
     * Adds an or to or.
     *
     * @param or the new or
     * @return the RequiredConfigRequiredConfigOr builder
     */
    public Builder addOr(RequiredConfigItems or) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(or,
        "or cannot be null");
      if (this.or == null) {
        this.or = new ArrayList<RequiredConfigItems>();
      }
      this.or.add(or);
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the RequiredConfigRequiredConfigOr builder
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
     * @return the RequiredConfigRequiredConfigOr builder
     */
    public Builder or(List<RequiredConfigItems> or) {
      this.or = or;
      return this;
    }
  }

  protected RequiredConfigRequiredConfigOr() { }

  protected RequiredConfigRequiredConfigOr(Builder builder) {
    description = builder.description;
    or = builder.or;
  }

  /**
   * New builder.
   *
   * @return a RequiredConfigRequiredConfigOr builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

