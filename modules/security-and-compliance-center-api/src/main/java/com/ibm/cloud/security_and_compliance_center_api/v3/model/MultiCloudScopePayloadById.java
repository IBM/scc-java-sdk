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
 * The payload to reference a previously made scope object.
 */
public class MultiCloudScopePayloadById extends MultiCloudScopePayload {


  /**
   * Builder.
   */
  public static class Builder {
    private String id;

    /**
     * Instantiates a new Builder from an existing MultiCloudScopePayloadById instance.
     *
     * @param multiCloudScopePayloadById the instance to initialize the Builder with
     */
    public Builder(MultiCloudScopePayload multiCloudScopePayloadById) {
      this.id = multiCloudScopePayloadById.id;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a MultiCloudScopePayloadById.
     *
     * @return the new MultiCloudScopePayloadById instance
     */
    public MultiCloudScopePayloadById build() {
      return new MultiCloudScopePayloadById(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the MultiCloudScopePayloadById builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  protected MultiCloudScopePayloadById() { }

  protected MultiCloudScopePayloadById(Builder builder) {
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a MultiCloudScopePayloadById builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

