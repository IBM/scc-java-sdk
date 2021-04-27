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
package com.ibm.cloud.scc.notifications_api.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listAllChannels options.
 */
public class ListAllChannelsOptions extends GenericModel {

  protected String accountId;
  protected String transactionId;
  protected Long limit;
  protected Long skip;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String transactionId;
    private Long limit;
    private Long skip;

    private Builder(ListAllChannelsOptions listAllChannelsOptions) {
      this.accountId = listAllChannelsOptions.accountId;
      this.transactionId = listAllChannelsOptions.transactionId;
      this.limit = listAllChannelsOptions.limit;
      this.skip = listAllChannelsOptions.skip;
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
     */
    public Builder(String accountId) {
      this.accountId = accountId;
    }

    /**
     * Builds a ListAllChannelsOptions.
     *
     * @return the new ListAllChannelsOptions instance
     */
    public ListAllChannelsOptions build() {
      return new ListAllChannelsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListAllChannelsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ListAllChannelsOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListAllChannelsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the skip.
     *
     * @param skip the skip
     * @return the ListAllChannelsOptions builder
     */
    public Builder skip(long skip) {
      this.skip = skip;
      return this;
    }
  }

  protected ListAllChannelsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    accountId = builder.accountId;
    transactionId = builder.transactionId;
    limit = builder.limit;
    skip = builder.skip;
  }

  /**
   * New builder.
   *
   * @return a ListAllChannelsOptions builder
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
   * Gets the transactionId.
   *
   * The transaction id for the request in uuid v4 format.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }

  /**
   * Gets the limit.
   *
   * Limit the number of the returned documents to the specified number.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the skip.
   *
   * The offset is the index of the item from which you want to start returning data from. Default is 0.
   *
   * @return the skip
   */
  public Long skip() {
    return skip;
  }
}

