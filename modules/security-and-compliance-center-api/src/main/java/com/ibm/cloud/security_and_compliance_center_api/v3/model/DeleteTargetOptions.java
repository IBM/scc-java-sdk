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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteTarget options.
 */
public class DeleteTargetOptions extends GenericModel {

  protected String instanceId;
  protected String targetId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String targetId;

    /**
     * Instantiates a new Builder from an existing DeleteTargetOptions instance.
     *
     * @param deleteTargetOptions the instance to initialize the Builder with
     */
    private Builder(DeleteTargetOptions deleteTargetOptions) {
      this.instanceId = deleteTargetOptions.instanceId;
      this.targetId = deleteTargetOptions.targetId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceId the instanceId
     * @param targetId the targetId
     */
    public Builder(String instanceId, String targetId) {
      this.instanceId = instanceId;
      this.targetId = targetId;
    }

    /**
     * Builds a DeleteTargetOptions.
     *
     * @return the new DeleteTargetOptions instance
     */
    public DeleteTargetOptions build() {
      return new DeleteTargetOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the DeleteTargetOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the targetId.
     *
     * @param targetId the targetId
     * @return the DeleteTargetOptions builder
     */
    public Builder targetId(String targetId) {
      this.targetId = targetId;
      return this;
    }
  }

  protected DeleteTargetOptions() { }

  protected DeleteTargetOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.targetId,
      "targetId cannot be empty");
    instanceId = builder.instanceId;
    targetId = builder.targetId;
  }

  /**
   * New builder.
   *
   * @return a DeleteTargetOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The ID of the Security and Compliance Center instance.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the targetId.
   *
   * The target ID.
   *
   * @return the targetId
   */
  public String targetId() {
    return targetId;
  }
}

