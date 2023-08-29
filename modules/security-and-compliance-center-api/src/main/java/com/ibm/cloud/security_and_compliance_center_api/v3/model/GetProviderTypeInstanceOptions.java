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
 * The getProviderTypeInstance options.
 */
public class GetProviderTypeInstanceOptions extends GenericModel {

  protected String providerTypeId;
  protected String providerTypeInstanceId;
  protected String xCorrelationId;
  protected String xRequestId;

  /**
   * Builder.
   */
  public static class Builder {
    private String providerTypeId;
    private String providerTypeInstanceId;
    private String xCorrelationId;
    private String xRequestId;

    /**
     * Instantiates a new Builder from an existing GetProviderTypeInstanceOptions instance.
     *
     * @param getProviderTypeInstanceOptions the instance to initialize the Builder with
     */
    private Builder(GetProviderTypeInstanceOptions getProviderTypeInstanceOptions) {
      this.providerTypeId = getProviderTypeInstanceOptions.providerTypeId;
      this.providerTypeInstanceId = getProviderTypeInstanceOptions.providerTypeInstanceId;
      this.xCorrelationId = getProviderTypeInstanceOptions.xCorrelationId;
      this.xRequestId = getProviderTypeInstanceOptions.xRequestId;
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
     */
    public Builder(String providerTypeId, String providerTypeInstanceId) {
      this.providerTypeId = providerTypeId;
      this.providerTypeInstanceId = providerTypeInstanceId;
    }

    /**
     * Builds a GetProviderTypeInstanceOptions.
     *
     * @return the new GetProviderTypeInstanceOptions instance
     */
    public GetProviderTypeInstanceOptions build() {
      return new GetProviderTypeInstanceOptions(this);
    }

    /**
     * Set the providerTypeId.
     *
     * @param providerTypeId the providerTypeId
     * @return the GetProviderTypeInstanceOptions builder
     */
    public Builder providerTypeId(String providerTypeId) {
      this.providerTypeId = providerTypeId;
      return this;
    }

    /**
     * Set the providerTypeInstanceId.
     *
     * @param providerTypeInstanceId the providerTypeInstanceId
     * @return the GetProviderTypeInstanceOptions builder
     */
    public Builder providerTypeInstanceId(String providerTypeInstanceId) {
      this.providerTypeInstanceId = providerTypeInstanceId;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the GetProviderTypeInstanceOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the GetProviderTypeInstanceOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }
  }

  protected GetProviderTypeInstanceOptions() { }

  protected GetProviderTypeInstanceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.providerTypeId,
      "providerTypeId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.providerTypeInstanceId,
      "providerTypeInstanceId cannot be empty");
    providerTypeId = builder.providerTypeId;
    providerTypeInstanceId = builder.providerTypeInstanceId;
    xCorrelationId = builder.xCorrelationId;
    xRequestId = builder.xRequestId;
  }

  /**
   * New builder.
   *
   * @return a GetProviderTypeInstanceOptions builder
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

