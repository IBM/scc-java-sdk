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
 * The getControlLibrary options.
 */
public class GetControlLibraryOptions extends GenericModel {

  protected String instanceId;
  protected String controlLibraryId;
  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String controlLibraryId;
    private String accountId;

    /**
     * Instantiates a new Builder from an existing GetControlLibraryOptions instance.
     *
     * @param getControlLibraryOptions the instance to initialize the Builder with
     */
    private Builder(GetControlLibraryOptions getControlLibraryOptions) {
      this.instanceId = getControlLibraryOptions.instanceId;
      this.controlLibraryId = getControlLibraryOptions.controlLibraryId;
      this.accountId = getControlLibraryOptions.accountId;
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
     * @param controlLibraryId the controlLibraryId
     */
    public Builder(String instanceId, String controlLibraryId) {
      this.instanceId = instanceId;
      this.controlLibraryId = controlLibraryId;
    }

    /**
     * Builds a GetControlLibraryOptions.
     *
     * @return the new GetControlLibraryOptions instance
     */
    public GetControlLibraryOptions build() {
      return new GetControlLibraryOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the GetControlLibraryOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the controlLibraryId.
     *
     * @param controlLibraryId the controlLibraryId
     * @return the GetControlLibraryOptions builder
     */
    public Builder controlLibraryId(String controlLibraryId) {
      this.controlLibraryId = controlLibraryId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetControlLibraryOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected GetControlLibraryOptions() { }

  protected GetControlLibraryOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.controlLibraryId,
      "controlLibraryId cannot be empty");
    instanceId = builder.instanceId;
    controlLibraryId = builder.controlLibraryId;
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a GetControlLibraryOptions builder
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
   * Gets the controlLibraryId.
   *
   * The control library ID.
   *
   * @return the controlLibraryId
   */
  public String controlLibraryId() {
    return controlLibraryId;
  }

  /**
   * Gets the accountId.
   *
   * The user account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

