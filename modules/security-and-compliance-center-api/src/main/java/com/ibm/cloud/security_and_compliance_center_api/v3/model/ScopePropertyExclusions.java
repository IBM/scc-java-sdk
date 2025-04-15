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
 * Any exclusions or resources that should not be part of the scope. Has to be the same type as the one specified.
 */
public class ScopePropertyExclusions extends ScopeProperty {

  /**
   * The key that denotes the user is declaring the exclusions.
   */
  public interface Name {
    /** exclusions. */
    String EXCLUSIONS = "exclusions";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private List<ScopePropertyExclusionItem> value;

    /**
     * Instantiates a new Builder from an existing ScopePropertyExclusions instance.
     *
     * @param scopePropertyExclusions the instance to initialize the Builder with
     */
    public Builder(ScopeProperty scopePropertyExclusions) {
      this.name = scopePropertyExclusions.name;
      this.value = scopePropertyExclusions.value;
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
     */
    public Builder(String name, List<ScopePropertyExclusionItem> value) {
      this.name = name;
      this.value = value;
    }

    /**
     * Builds a ScopePropertyExclusions.
     *
     * @return the new ScopePropertyExclusions instance
     */
    public ScopePropertyExclusions build() {
      return new ScopePropertyExclusions(this);
    }

    /**
     * Adds a new element to value.
     *
     * @param value the new element to be added
     * @return the ScopePropertyExclusions builder
     */
    public Builder addValue(ScopePropertyExclusionItem value) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(value,
        "value cannot be null");
      if (this.value == null) {
        this.value = new ArrayList<ScopePropertyExclusionItem>();
      }
      this.value.add(value);
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ScopePropertyExclusions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the value.
     * Existing value will be replaced.
     *
     * @param value the value
     * @return the ScopePropertyExclusions builder
     */
    public Builder value(List<ScopePropertyExclusionItem> value) {
      this.value = value;
      return this;
    }
  }

  protected ScopePropertyExclusions() { }

  protected ScopePropertyExclusions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.value,
      "value cannot be null");
    name = builder.name;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a ScopePropertyExclusions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

