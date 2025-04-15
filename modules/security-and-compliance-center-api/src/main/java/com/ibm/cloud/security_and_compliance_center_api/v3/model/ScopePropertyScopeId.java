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
 * The value of the identifier that correlates to scope type. If ScopePropertyScopeType schema uses the value
 * enterprise.account_group, the value should be the identifier or ID of the account_group within the enterprise.
 */
public class ScopePropertyScopeId {
  private String name;
  private String value;

  /**
   * The key for the scope property.
   */
  public interface Name {
    /** scope_id. */
    String SCOPE_ID = "scope_id";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String value;

    /**
     * Instantiates a new Builder from an existing ScopePropertyScopeId instance.
     *
     * @param scopePropertyScopeId the instance to initialize the Builder with
     */
    public Builder(ScopePropertyScopeId scopePropertyScopeId) {
      this.name = scopePropertyScopeId.name;
      this.value = scopePropertyScopeId.value;
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
    public Builder(String name, String value) {
      this.name = name;
      this.value = value;
    }

    /**
     * Builds a ScopePropertyScopeId.
     *
     * @return the new ScopePropertyScopeId instance
     */
    public ScopePropertyScopeId build() {
      return new ScopePropertyScopeId(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ScopePropertyScopeId builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the ScopePropertyScopeId builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected ScopePropertyScopeId() { }

  protected ScopePropertyScopeId(Builder builder) {
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
   * @return a ScopePropertyScopeId builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   * @return ScopePropertyScopeId name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the value.
   * @return List of ScopePropertyScopeId
   */
  public String value() {
    return value;
  }
}
