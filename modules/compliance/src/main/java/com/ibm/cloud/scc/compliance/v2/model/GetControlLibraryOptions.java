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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getControlLibrary options.
 */
public class GetControlLibraryOptions extends GenericModel {

  protected String controlLibrariesId;
  protected String instanceId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String controlLibrariesId;
    private String instanceId;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing GetControlLibraryOptions instance.
     *
     * @param getControlLibraryOptions the instance to initialize the Builder with
     */
    private Builder(GetControlLibraryOptions getControlLibraryOptions) {
      this.controlLibrariesId = getControlLibraryOptions.controlLibrariesId;
      this.instanceId = getControlLibraryOptions.instanceId;
      this.transactionId = getControlLibraryOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param controlLibrariesId the controlLibrariesId
     * @param instanceId the instanceId
     */
    public Builder(String controlLibrariesId, String instanceId) {
      this.controlLibrariesId = controlLibrariesId;
      this.instanceId = instanceId;
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
     * Set the controlLibrariesId.
     *
     * @param controlLibrariesId the controlLibrariesId
     * @return the GetControlLibraryOptions builder
     */
    public Builder controlLibrariesId(String controlLibrariesId) {
      this.controlLibrariesId = controlLibrariesId;
      return this;
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
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the GetControlLibraryOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected GetControlLibraryOptions() { }

  protected GetControlLibraryOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.controlLibrariesId,
      "controlLibrariesId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    controlLibrariesId = builder.controlLibrariesId;
    instanceId = builder.instanceId;
    transactionId = builder.transactionId;
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
   * Gets the controlLibrariesId.
   *
   * The control library ID.
   *
   * @return the controlLibrariesId
   */
  public String controlLibrariesId() {
    return controlLibrariesId;
  }

  /**
   * Gets the instanceId.
   *
   * Instance id.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the transactionId.
   *
   * The transaction ID for the request in UUID v4 format.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

