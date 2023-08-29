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
package com.ibm.cloud.security_and_compliance_center_api.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateProviderTypeInstance options.
 */
public class UpdateProviderTypeInstanceOptions extends GenericModel {

  protected String providerTypeId;
  protected String providerTypeInstanceId;
  protected UpdateProviderTypeInstanceRequest updateProviderTypeInstanceRequest;
  protected String xCorrelationId;
  protected String xRequestId;

  /**
   * Builder.
   */
  public static class Builder {
    private String providerTypeId;
    private String providerTypeInstanceId;
    private UpdateProviderTypeInstanceRequest updateProviderTypeInstanceRequest;
    private String xCorrelationId;
    private String xRequestId;

    /**
     * Instantiates a new Builder from an existing UpdateProviderTypeInstanceOptions instance.
     *
     * @param updateProviderTypeInstanceOptions the instance to initialize the Builder with
     */
    private Builder(UpdateProviderTypeInstanceOptions updateProviderTypeInstanceOptions) {
      this.providerTypeId = updateProviderTypeInstanceOptions.providerTypeId;
      this.providerTypeInstanceId = updateProviderTypeInstanceOptions.providerTypeInstanceId;
      this.updateProviderTypeInstanceRequest = updateProviderTypeInstanceOptions.updateProviderTypeInstanceRequest;
      this.xCorrelationId = updateProviderTypeInstanceOptions.xCorrelationId;
      this.xRequestId = updateProviderTypeInstanceOptions.xRequestId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param providerTypeId the providerTypeId
     * @param providerTypeInstanceId the providerTypeInstanceId
     * @param updateProviderTypeInstanceRequest the updateProviderTypeInstanceRequest
     */
    public Builder(String providerTypeId, String providerTypeInstanceId, UpdateProviderTypeInstanceRequest updateProviderTypeInstanceRequest) {
      this.providerTypeId = providerTypeId;
      this.providerTypeInstanceId = providerTypeInstanceId;
      this.updateProviderTypeInstanceRequest = updateProviderTypeInstanceRequest;
    }

    /**
     * Builds a UpdateProviderTypeInstanceOptions.
     *
     * @return the new UpdateProviderTypeInstanceOptions instance
     */
    public UpdateProviderTypeInstanceOptions build() {
      return new UpdateProviderTypeInstanceOptions(this);
    }

    /**
     * Set the providerTypeId.
     *
     * @param providerTypeId the providerTypeId
     * @return the UpdateProviderTypeInstanceOptions builder
     */
    public Builder providerTypeId(String providerTypeId) {
      this.providerTypeId = providerTypeId;
      return this;
    }

    /**
     * Set the providerTypeInstanceId.
     *
     * @param providerTypeInstanceId the providerTypeInstanceId
     * @return the UpdateProviderTypeInstanceOptions builder
     */
    public Builder providerTypeInstanceId(String providerTypeInstanceId) {
      this.providerTypeInstanceId = providerTypeInstanceId;
      return this;
    }

    /**
     * Set the updateProviderTypeInstanceRequest.
     *
     * @param updateProviderTypeInstanceRequest the updateProviderTypeInstanceRequest
     * @return the UpdateProviderTypeInstanceOptions builder
     */
    public Builder updateProviderTypeInstanceRequest(UpdateProviderTypeInstanceRequest updateProviderTypeInstanceRequest) {
      this.updateProviderTypeInstanceRequest = updateProviderTypeInstanceRequest;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the UpdateProviderTypeInstanceOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the UpdateProviderTypeInstanceOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }
  }

  protected UpdateProviderTypeInstanceOptions() { }

  protected UpdateProviderTypeInstanceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.providerTypeId,
      "providerTypeId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.providerTypeInstanceId,
      "providerTypeInstanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.updateProviderTypeInstanceRequest,
      "updateProviderTypeInstanceRequest cannot be null");
    providerTypeId = builder.providerTypeId;
    providerTypeInstanceId = builder.providerTypeInstanceId;
    updateProviderTypeInstanceRequest = builder.updateProviderTypeInstanceRequest;
    xCorrelationId = builder.xCorrelationId;
    xRequestId = builder.xRequestId;
  }

  /**
   * New builder.
   *
   * @return a UpdateProviderTypeInstanceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the providerTypeId.
   *
   * The provider type ID.
   *
   * @return the providerTypeId
   */
  public String providerTypeId() {
    return providerTypeId;
  }

  /**
   * Gets the providerTypeInstanceId.
   *
   * The provider type instance ID.
   *
   * @return the providerTypeInstanceId
   */
  public String providerTypeInstanceId() {
    return providerTypeInstanceId;
  }

  /**
   * Gets the updateProviderTypeInstanceRequest.
   *
   * Provider type instance object to be patched.
   *
   * @return the updateProviderTypeInstanceRequest
   */
  public UpdateProviderTypeInstanceRequest updateProviderTypeInstanceRequest() {
    return updateProviderTypeInstanceRequest;
  }

  /**
   * Gets the xCorrelationId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header for the
   * corresponding response. The same value is used for downstream requests and retries of those requests. If a value of
   * this headers is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xCorrelationId
   */
  public String xCorrelationId() {
    return xCorrelationId;
  }

  /**
   * Gets the xRequestId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header  for the
   * corresponding response.  The same value is not used for downstream requests and retries of those requests.  If a
   * value of this headers is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xRequestId
   */
  public String xRequestId() {
    return xRequestId;
  }
}

