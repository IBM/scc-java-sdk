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
package com.ibm.cloud.scc.findings.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listProviders options.
 */
public class ListProvidersOptions extends GenericModel {

  protected String transactionId;
  protected Long limit;
  protected Long skip;
  protected String startProviderId;
  protected String endProviderId;

  /**
   * Builder.
   */
  public static class Builder {
    private String transactionId;
    private Long limit;
    private Long skip;
    private String startProviderId;
    private String endProviderId;

    private Builder(ListProvidersOptions listProvidersOptions) {
      this.transactionId = listProvidersOptions.transactionId;
      this.limit = listProvidersOptions.limit;
      this.skip = listProvidersOptions.skip;
      this.startProviderId = listProvidersOptions.startProviderId;
      this.endProviderId = listProvidersOptions.endProviderId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListProvidersOptions.
     *
     * @return the new ListProvidersOptions instance
     */
    public ListProvidersOptions build() {
      return new ListProvidersOptions(this);
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ListProvidersOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListProvidersOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the skip.
     *
     * @param skip the skip
     * @return the ListProvidersOptions builder
     */
    public Builder skip(long skip) {
      this.skip = skip;
      return this;
    }

    /**
     * Set the startProviderId.
     *
     * @param startProviderId the startProviderId
     * @return the ListProvidersOptions builder
     */
    public Builder startProviderId(String startProviderId) {
      this.startProviderId = startProviderId;
      return this;
    }

    /**
     * Set the endProviderId.
     *
     * @param endProviderId the endProviderId
     * @return the ListProvidersOptions builder
     */
    public Builder endProviderId(String endProviderId) {
      this.endProviderId = endProviderId;
      return this;
    }
  }

  protected ListProvidersOptions(Builder builder) {
    transactionId = builder.transactionId;
    limit = builder.limit;
    skip = builder.skip;
    startProviderId = builder.startProviderId;
    endProviderId = builder.endProviderId;
  }

  /**
   * New builder.
   *
   * @return a ListProvidersOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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

  /**
   * Gets the limit.
   *
   * The number of documents that you want to return.
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

  /**
   * Gets the startProviderId.
   *
   * The first provider ID included in the result, sorted in ascending order. If not provided, this parameter is
   * ignored.
   *
   * @return the startProviderId
   */
  public String startProviderId() {
    return startProviderId;
  }

  /**
   * Gets the endProviderId.
   *
   * The last provider ID included in the result, sorted in ascending order. If not provided, this parameter is ignored.
   *
   * @return the endProviderId
   */
  public String endProviderId() {
    return endProviderId;
  }
}

