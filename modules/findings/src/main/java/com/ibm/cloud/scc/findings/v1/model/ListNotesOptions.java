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
 * The listNotes options.
 */
public class ListNotesOptions extends GenericModel {

  protected String providerId;
  protected String transactionId;
  protected Long pageSize;
  protected String pageToken;

  /**
   * Builder.
   */
  public static class Builder {
    private String providerId;
    private String transactionId;
    private Long pageSize;
    private String pageToken;

    private Builder(ListNotesOptions listNotesOptions) {
      this.providerId = listNotesOptions.providerId;
      this.transactionId = listNotesOptions.transactionId;
      this.pageSize = listNotesOptions.pageSize;
      this.pageToken = listNotesOptions.pageToken;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param providerId the providerId
     */
    public Builder(String providerId) {
      this.providerId = providerId;
    }

    /**
     * Builds a ListNotesOptions.
     *
     * @return the new ListNotesOptions instance
     */
    public ListNotesOptions build() {
      return new ListNotesOptions(this);
    }

    /**
     * Set the providerId.
     *
     * @param providerId the providerId
     * @return the ListNotesOptions builder
     */
    public Builder providerId(String providerId) {
      this.providerId = providerId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ListNotesOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the pageSize.
     *
     * @param pageSize the pageSize
     * @return the ListNotesOptions builder
     */
    public Builder pageSize(long pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    /**
     * Set the pageToken.
     *
     * @param pageToken the pageToken
     * @return the ListNotesOptions builder
     */
    public Builder pageToken(String pageToken) {
      this.pageToken = pageToken;
      return this;
    }
  }

  protected ListNotesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.providerId,
      "providerId cannot be empty");
    providerId = builder.providerId;
    transactionId = builder.transactionId;
    pageSize = builder.pageSize;
    pageToken = builder.pageToken;
  }

  /**
   * New builder.
   *
   * @return a ListNotesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the providerId.
   *
   * Part of `parent`. This field contains the provider_id for example: providers/{provider_id}.
   *
   * @return the providerId
   */
  public String providerId() {
    return providerId;
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
   * Gets the pageSize.
   *
   * Number of notes to return in the list.
   *
   * @return the pageSize
   */
  public Long pageSize() {
    return pageSize;
  }

  /**
   * Gets the pageToken.
   *
   * Token to provide to skip to a particular spot in the list.
   *
   * @return the pageToken
   */
  public String pageToken() {
    return pageToken;
  }
}

