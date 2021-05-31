/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.scc.notifications.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getNotificationChannel options.
 */
public class GetNotificationChannelOptions extends GenericModel {

  protected String accountId;
  protected String channelId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String channelId;
    private String transactionId;

    private Builder(GetNotificationChannelOptions getNotificationChannelOptions) {
      this.accountId = getNotificationChannelOptions.accountId;
      this.channelId = getNotificationChannelOptions.channelId;
      this.transactionId = getNotificationChannelOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountId the accountId
     * @param channelId the channelId
     */
    public Builder(String accountId, String channelId) {
      this.accountId = accountId;
      this.channelId = channelId;
    }

    /**
     * Builds a GetNotificationChannelOptions.
     *
     * @return the new GetNotificationChannelOptions instance
     */
    public GetNotificationChannelOptions build() {
      return new GetNotificationChannelOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetNotificationChannelOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the channelId.
     *
     * @param channelId the channelId
     * @return the GetNotificationChannelOptions builder
     */
    public Builder channelId(String channelId) {
      this.channelId = channelId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the GetNotificationChannelOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected GetNotificationChannelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.channelId,
      "channelId cannot be empty");
    accountId = builder.accountId;
    channelId = builder.channelId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a GetNotificationChannelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the channelId.
   *
   * Channel ID.
   *
   * @return the channelId
   */
  public String channelId() {
    return channelId;
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

