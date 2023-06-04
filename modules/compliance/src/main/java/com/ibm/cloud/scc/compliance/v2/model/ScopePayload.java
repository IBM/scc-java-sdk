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
package com.ibm.cloud.scc.compliance.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * scope payload.
 */
public class ScopePayload extends GenericModel {

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
     * Instantiates a new Builder from an existing ScopePayload instance.
     *
     * @param scopePayload the instance to initialize the Builder with
     */
    private Builder(ScopePayload scopePayload) {
      this.scopeId = scopePayload.scopeId;
      this.scopeType = scopePayload.scopeType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ScopePayload.
     *
     * @return the new ScopePayload instance
     */
    public ScopePayload build() {
      return new ScopePayload(this);
    }

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the ScopePayload builder
     */
    public Builder scopeId(String scopeId) {
      this.scopeId = scopeId;
      return this;
    }

    /**
     * Set the scopeType.
     *
     * @param scopeType the scopeType
     * @return the ScopePayload builder
     */
    public Builder scopeType(String scopeType) {
      this.scopeType = scopeType;
      return this;
    }
  }

  protected ScopePayload() { }

  protected ScopePayload(Builder builder) {
    scopeId = builder.scopeId;
    scopeType = builder.scopeType;
  }

  /**
   * New builder.
   *
   * @return a ScopePayload builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the scopeId.
   *
   * scope id.
   *
   * @return the scopeId
   */
  public String scopeId() {
    return scopeId;
  }

  /**
   * Gets the scopeType.
   *
   * Scope type.
   *
   * @return the scopeType
   */
  public String scopeType() {
    return scopeType;
  }
}

