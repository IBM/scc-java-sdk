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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteNotificationChannels options.
 */
public class DeleteNotificationChannelsOptions extends GenericModel {

  protected String accountId;
  protected List<String> body;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private List<String> body;
    private String transactionId;

    private Builder(DeleteNotificationChannelsOptions deleteNotificationChannelsOptions) {
      this.accountId = deleteNotificationChannelsOptions.accountId;
      this.body = deleteNotificationChannelsOptions.body;
      this.transactionId = deleteNotificationChannelsOptions.transactionId;
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
     * @param body the body
     */
    public Builder(String accountId, List<String> body) {
      this.accountId = accountId;
      this.body = body;
    }

    /**
     * Builds a DeleteNotificationChannelsOptions.
     *
     * @return the new DeleteNotificationChannelsOptions instance
     */
    public DeleteNotificationChannelsOptions build() {
      return new DeleteNotificationChannelsOptions(this);
    }

    /**
     * Adds an body to body.
     *
     * @param body the new body
     * @return the DeleteNotificationChannelsOptions builder
     */
    public Builder addBody(String body) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(body,
        "body cannot be null");
      if (this.body == null) {
        this.body = new ArrayList<String>();
      }
      this.body.add(body);
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the DeleteNotificationChannelsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the body.
     * Existing body will be replaced.
     *
     * @param body the body
     * @return the DeleteNotificationChannelsOptions builder
     */
    public Builder body(List<String> body) {
      this.body = body;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the DeleteNotificationChannelsOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected DeleteNotificationChannelsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.body,
      "body cannot be null");
    accountId = builder.accountId;
    body = builder.body;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a DeleteNotificationChannelsOptions builder
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
   * Gets the body.
   *
   * Body for bulk delete notification channels.
   *
   * @return the body
   */
  public List<String> body() {
    return body;
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

