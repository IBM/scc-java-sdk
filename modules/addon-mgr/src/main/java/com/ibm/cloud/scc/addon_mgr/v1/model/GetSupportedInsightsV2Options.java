/*
 * (C) Copyright IBM Corp. 2022.
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
package com.ibm.cloud.scc.addon_mgr.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getSupportedInsightsV2 options.
 */
public class GetSupportedInsightsV2Options extends GenericModel {

  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String transactionId;

    private Builder(GetSupportedInsightsV2Options getSupportedInsightsV2Options) {
      this.transactionId = getSupportedInsightsV2Options.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetSupportedInsightsV2Options.
     *
     * @return the new GetSupportedInsightsV2Options instance
     */
    public GetSupportedInsightsV2Options build() {
      return new GetSupportedInsightsV2Options(this);
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the GetSupportedInsightsV2Options builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected GetSupportedInsightsV2Options(Builder builder) {
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a GetSupportedInsightsV2Options builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the transactionId.
   *
   * The transaction id for the request in uuid v4 format.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

