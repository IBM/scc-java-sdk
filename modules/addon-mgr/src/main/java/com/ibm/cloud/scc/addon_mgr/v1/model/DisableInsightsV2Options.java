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
 * The disableInsightsV2 options.
 */
public class DisableInsightsV2Options extends GenericModel {

  protected String regionId;
  protected Boolean networkInsights;
  protected Boolean activityInsights;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String regionId;
    private Boolean networkInsights;
    private Boolean activityInsights;
    private String transactionId;

    private Builder(DisableInsightsV2Options disableInsightsV2Options) {
      this.regionId = disableInsightsV2Options.regionId;
      this.networkInsights = disableInsightsV2Options.networkInsights;
      this.activityInsights = disableInsightsV2Options.activityInsights;
      this.transactionId = disableInsightsV2Options.transactionId;
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
     */
    public Builder(String regionId) {
      this.regionId = regionId;
    }

    /**
     * Builds a DisableInsightsV2Options.
     *
     * @return the new DisableInsightsV2Options instance
     */
    public DisableInsightsV2Options build() {
      return new DisableInsightsV2Options(this);
    }

    /**
     * Set the regionId.
     *
     * @param regionId the regionId
     * @return the DisableInsightsV2Options builder
     */
    public Builder regionId(String regionId) {
      this.regionId = regionId;
      return this;
    }

    /**
     * Set the networkInsights.
     *
     * @param networkInsights the networkInsights
     * @return the DisableInsightsV2Options builder
     */
    public Builder networkInsights(Boolean networkInsights) {
      this.networkInsights = networkInsights;
      return this;
    }

    /**
     * Set the activityInsights.
     *
     * @param activityInsights the activityInsights
     * @return the DisableInsightsV2Options builder
     */
    public Builder activityInsights(Boolean activityInsights) {
      this.activityInsights = activityInsights;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the DisableInsightsV2Options builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected DisableInsightsV2Options(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.regionId,
      "regionId cannot be null");
    regionId = builder.regionId;
    networkInsights = builder.networkInsights;
    activityInsights = builder.activityInsights;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a DisableInsightsV2Options builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the regionId.
   *
   * Region id for example - us.
   *
   * @return the regionId
   */
  public String regionId() {
    return regionId;
  }

  /**
   * Gets the networkInsights.
   *
   * @return the networkInsights
   */
  public Boolean networkInsights() {
    return networkInsights;
  }

  /**
   * Gets the activityInsights.
   *
   * @return the activityInsights
   */
  public Boolean activityInsights() {
    return activityInsights;
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

