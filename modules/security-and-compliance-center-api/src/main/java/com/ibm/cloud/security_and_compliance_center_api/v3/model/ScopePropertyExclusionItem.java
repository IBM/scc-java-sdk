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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Any exclusion to be defined in the scope.
 */
public class ScopePropertyExclusionItem extends GenericModel {

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
  public interface ScopeType {
    /** enterprise. */
    String ENTERPRISE = "enterprise";
    /** enterprise.account_group. */
    String ENTERPRISE_ACCOUNT_GROUP = "enterprise.account_group";
    /** enterprise.account. */
    String ENTERPRISE_ACCOUNT = "enterprise.account";
    /** account. */
    String ACCOUNT = "account";
    /** account.resource_group. */
    String ACCOUNT_RESOURCE_GROUP = "account.resource_group";
  }

  @SerializedName("scope_id")
  protected String scopeId;
  @SerializedName("scope_type")
  protected String scopeType;

  /**
   * Builder.
   */
  public static class Builder {
    private String scopeId;
    private String scopeType;

    /**
     * Instantiates a new Builder from an existing ScopePropertyExclusionItem instance.
     *
     * @param scopePropertyExclusionItem the instance to initialize the Builder with
     */
    private Builder(ScopePropertyExclusionItem scopePropertyExclusionItem) {
      this.scopeId = scopePropertyExclusionItem.scopeId;
      this.scopeType = scopePropertyExclusionItem.scopeType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param scopeType the scopeType
     */
    public Builder(String scopeType) {
      this.scopeType = scopeType;
    }

    /**
     * Builds a ScopePropertyExclusionItem.
     *
     * @return the new ScopePropertyExclusionItem instance
     */
    public ScopePropertyExclusionItem build() {
      return new ScopePropertyExclusionItem(this);
    }

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the ScopePropertyExclusionItem builder
     */
    public Builder scopeId(String scopeId) {
      this.scopeId = scopeId;
      return this;
    }

    /**
     * Set the scopeType.
     *
     * @param scopeType the scopeType
     * @return the ScopePropertyExclusionItem builder
     */
    public Builder scopeType(String scopeType) {
      this.scopeType = scopeType;
      return this;
    }
  }

  protected ScopePropertyExclusionItem() { }

  protected ScopePropertyExclusionItem(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.scopeType,
      "scopeType cannot be null");
    scopeId = builder.scopeId;
    scopeType = builder.scopeType;
  }

  /**
   * New builder.
   *
   * @return a ScopePropertyExclusionItem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the scopeId.
   *
   * @return the scopeId
   */
  public String scopeId() {
    return scopeId;
  }

  /**
   * Gets the scopeType.
   *
   * The type of scope it targets
   *
   * The scope values are as followed:
   * - enterprise: The scope targets an enterprise account
   * - enterprise.account_group: The scope targets an account group within an enterprise
   * - enterprise.account: The scope targets an account within an enterprise
   * - account: The scope targets an account not tied to an enterprise
   * - account.resource_group: The scope targets a resource group within an account.
   *
   * @return the scopeType
   */
  public String scopeType() {
    return scopeType;
  }
}

