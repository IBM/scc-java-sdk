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
public class ScopePropertyScopeType {
  private String name;
  private String value;

  /**
   * key to say the attribute targets the scope type.
   */
  public interface Name {
    /** scope_type. */
    String SCOPE_TYPE = "scope_type";
  }

  /**
   * The type of scope it targets
   *
   * The scope values are as followed:
   * - enterprise: The scope targets an enterprise account
   * - enterprise.account_group: The scope targets an account group within an enterprise
   * - enterprise.account: The scope targets an account within an enterprise
   * - account: The scope targets an account not tied to an enterprise
   * - account.resource_group: The scope targets a resource group within an account.
   */
  public interface Value {
    /** account. */
    String ACCOUNT = "account";
    /** account.resource_group. */
    String ACCOUNT_RESOURCE_GROUP = "account.resource_group";
    /** enterprise. */
    String ENTERPRISE = "enterprise";
    /** enterprise.account_group. */
    String ENTERPRISE_ACCOUNT_GROUP = "enterprise.account_group";
    /** enterprise.account. */
    String ENTERPRISE_ACCOUNT = "enterprise.account";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String value;

    /**
     * Instantiates a new Builder from an existing ScopePropertyScopeType instance.
     *
     * @param scopePropertyScopeType the instance to initialize the Builder with
     */
    public Builder(ScopePropertyScopeType scopePropertyScopeType) {
      this.name = scopePropertyScopeType.name;
      this.value = scopePropertyScopeType.value;
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
     * Builds a ScopePropertyScopeType.
     *
     * @return the new ScopePropertyScopeType instance
     */
    public ScopePropertyScopeType build() {
      return new ScopePropertyScopeType(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ScopePropertyScopeType builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the ScopePropertyScopeType builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected ScopePropertyScopeType() { }

  protected ScopePropertyScopeType(Builder builder) {
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
   * @return a ScopePropertyScopeType builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   * @return ScopePropertyScopeType name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the value.
   * @return ScopePropertyScopeType value
   */
  public String value() {
    return value;
  }
}
