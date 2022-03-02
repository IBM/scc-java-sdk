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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The addNetworkInsightsCosDetailsV2 options.
 */
public class AddNetworkInsightsCosDetailsV2Options extends GenericModel {

  protected String regionId;
  protected List<CosDetailsV2CosDetailsItem> cosDetails;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String regionId;
    private List<CosDetailsV2CosDetailsItem> cosDetails;
    private String transactionId;

    private Builder(AddNetworkInsightsCosDetailsV2Options addNetworkInsightsCosDetailsV2Options) {
      this.regionId = addNetworkInsightsCosDetailsV2Options.regionId;
      this.cosDetails = addNetworkInsightsCosDetailsV2Options.cosDetails;
      this.transactionId = addNetworkInsightsCosDetailsV2Options.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param regionId the regionId
     * @param cosDetails the cosDetails
     */
    public Builder(String regionId, List<CosDetailsV2CosDetailsItem> cosDetails) {
      this.regionId = regionId;
      this.cosDetails = cosDetails;
    }

    /**
     * Builds a AddNetworkInsightsCosDetailsV2Options.
     *
     * @return the new AddNetworkInsightsCosDetailsV2Options instance
     */
    public AddNetworkInsightsCosDetailsV2Options build() {
      return new AddNetworkInsightsCosDetailsV2Options(this);
    }

    /**
     * Adds an cosDetails to cosDetails.
     *
     * @param cosDetails the new cosDetails
     * @return the AddNetworkInsightsCosDetailsV2Options builder
     */
    public Builder addCosDetails(CosDetailsV2CosDetailsItem cosDetails) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(cosDetails,
        "cosDetails cannot be null");
      if (this.cosDetails == null) {
        this.cosDetails = new ArrayList<CosDetailsV2CosDetailsItem>();
      }
      this.cosDetails.add(cosDetails);
      return this;
    }

    /**
     * Set the regionId.
     *
     * @param regionId the regionId
     * @return the AddNetworkInsightsCosDetailsV2Options builder
     */
    public Builder regionId(String regionId) {
      this.regionId = regionId;
      return this;
    }

    /**
     * Set the cosDetails.
     * Existing cosDetails will be replaced.
     *
     * @param cosDetails the cosDetails
     * @return the AddNetworkInsightsCosDetailsV2Options builder
     */
    public Builder cosDetails(List<CosDetailsV2CosDetailsItem> cosDetails) {
      this.cosDetails = cosDetails;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the AddNetworkInsightsCosDetailsV2Options builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected AddNetworkInsightsCosDetailsV2Options(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.regionId,
      "regionId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.cosDetails,
      "cosDetails cannot be null");
    regionId = builder.regionId;
    cosDetails = builder.cosDetails;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a AddNetworkInsightsCosDetailsV2Options builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the regionId.
   *
   * Region for example - us-south, eu-gb.
   *
   * @return the regionId
   */
  public String regionId() {
    return regionId;
  }

  /**
   * Gets the cosDetails.
   *
   * @return the cosDetails
   */
  public List<CosDetailsV2CosDetailsItem> cosDetails() {
    return cosDetails;
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

