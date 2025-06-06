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
 * The `OR` required configurations.
 */
public class RequiredConfigOr {
  private String description;
  private List<RequiredConfigItems> or;

  /**
   * Builder.
   */
  public static class Builder {
    private String description;
    private List<RequiredConfigItems> or;

    /**
     * Instantiates a new Builder from an existing RequiredConfigOr instance.
     *
     * @param requiredConfigOr the instance to initialize the Builder with
     */
    public Builder(RequiredConfigOr requiredConfigOr) {
      this.description = requiredConfigOr.description;
      this.or = requiredConfigOr.or;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RequiredConfigOr.
     *
     * @return the new RequiredConfigOr instance
     */
    public RequiredConfigOr build() {
      return new RequiredConfigOr(this);
    }

    /**
     * Adds an or to or.
     *
     * @param or the new or
     * @return the RequiredConfigOr builder
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
     * @return the RequiredConfigOr builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Gets the or.
     * <p>
     * A list of required configurations where one item should evaluate to true.
     *
     * @return the or
     */
    public List<RequiredConfigItems> or() {
      return this.or;
    }

    /**
     * Set the or.
     * Existing or will be replaced.
     *
     * @param or the or
     * @return the RequiredConfigOr builder
     */
    public Builder or(List<RequiredConfigItems> or) {
      this.or = or;
      return this;
    }
  }

  protected RequiredConfigOr() { }

  protected RequiredConfigOr(Builder builder) {
    description = builder.description;
    or = builder.or;
  }

  /**
   * New builder.
   *
   * @return a RequiredConfigOr builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the description.
   * <p>
   * A list of required configurations where one item should evaluate to true.
   *
   * @return the or
   */
  public String description() {
    return this.description;
  }

  /**
   * Gets the or.
   * <p>
   * A list of required configurations where one item should evaluate to true.
   *
   * @return the or
   */
  public List<RequiredConfigItems> or() {
    return this.or;
  }
}
