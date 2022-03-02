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
 * The enableInsightsV2 options.
 */
public class EnableInsightsV2Options extends GenericModel {

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

    private Builder(EnableInsightsV2Options enableInsightsV2Options) {
      this.regionId = enableInsightsV2Options.regionId;
      this.networkInsights = enableInsightsV2Options.networkInsights;
      this.activityInsights = enableInsightsV2Options.activityInsights;
      this.transactionId = enableInsightsV2Options.transactionId;
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
     * Builds a EnableInsightsV2Options.
     *
     * @return the new EnableInsightsV2Options instance
     */
    public EnableInsightsV2Options build() {
      return new EnableInsightsV2Options(this);
    }

    /**
     * Set the regionId.
     *
     * @param regionId the regionId
     * @return the EnableInsightsV2Options builder
     */
    public Builder regionId(String regionId) {
      this.regionId = regionId;
      return this;
    }

    /**
     * Set the networkInsights.
     *
     * @param networkInsights the networkInsights
     * @return the EnableInsightsV2Options builder
     */
    public Builder networkInsights(Boolean networkInsights) {
      this.networkInsights = networkInsights;
      return this;
    }

    /**
     * Set the activityInsights.
     *
     * @param activityInsights the activityInsights
     * @return the EnableInsightsV2Options builder
     */
    public Builder activityInsights(Boolean activityInsights) {
      this.activityInsights = activityInsights;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the EnableInsightsV2Options builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected EnableInsightsV2Options(Builder builder) {
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
   * @return a EnableInsightsV2Options builder
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

