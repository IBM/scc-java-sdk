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
 * Attribute that details what kind of type of scope.
 */
public class ScopePropertyScopeAny extends ScopeProperty {


  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private Object value;

    /**
     * Instantiates a new Builder from an existing ScopePropertyScopeAny instance.
     *
     * @param scopePropertyScopeAny the instance to initialize the Builder with
     */
    public Builder(ScopeProperty scopePropertyScopeAny) {
      this.name = scopePropertyScopeAny.name;
      this.value = scopePropertyScopeAny.value;
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
    public Builder(String name, Object value) {
      this.name = name;
      this.value = value;
    }

    /**
     * Builds a ScopePropertyScopeAny.
     *
     * @return the new ScopePropertyScopeAny instance
     */
    public ScopePropertyScopeAny build() {
      return new ScopePropertyScopeAny(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ScopePropertyScopeAny builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the ScopePropertyScopeAny builder
     */
    public Builder value(Object value) {
      this.value = value;
      return this;
    }
  }

  protected ScopePropertyScopeAny() { }

  protected ScopePropertyScopeAny(Builder builder) {
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
   * @return a ScopePropertyScopeAny builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

