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
 * The getSettings options.
 */
public class GetSettingsOptions extends GenericModel {

  protected String xCorrelationId;
  protected String xRequestId;

  /**
   * Builder.
   */
  public static class Builder {
    private String xCorrelationId;
    private String xRequestId;

    /**
     * Instantiates a new Builder from an existing GetSettingsOptions instance.
     *
     * @param getSettingsOptions the instance to initialize the Builder with
     */
    private Builder(GetSettingsOptions getSettingsOptions) {
      this.xCorrelationId = getSettingsOptions.xCorrelationId;
      this.xRequestId = getSettingsOptions.xRequestId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetSettingsOptions.
     *
     * @return the new GetSettingsOptions instance
     */
    public GetSettingsOptions build() {
      return new GetSettingsOptions(this);
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the GetSettingsOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the GetSettingsOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }
  }

  protected GetSettingsOptions() { }

  protected GetSettingsOptions(Builder builder) {
    xCorrelationId = builder.xCorrelationId;
    xRequestId = builder.xRequestId;
  }

  /**
   * New builder.
   *
   * @return a GetSettingsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the xCorrelationId.
   *
   * The supplied or generated value of this header is logged for a request, and repeated in a response header for the
   * corresponding response. The same value is used for downstream requests and retries of those requests. If a value of
   * this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xCorrelationId
   */
  public String xCorrelationId() {
    return xCorrelationId;
  }

  /**
   * Gets the xRequestId.
   *
   * The supplied or generated value of this header is logged for a request, and repeated in a response header  for the
   * corresponding response.  The same value is not used for downstream requests and retries of those requests.  If a
   * value of this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xRequestId
   */
  public String xRequestId() {
    return xRequestId;
  }
}

