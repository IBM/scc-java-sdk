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
 * The getOccurrenceNote options.
 */
public class GetOccurrenceNoteOptions extends GenericModel {

  protected String accountId;
  protected String providerId;
  protected String occurrenceId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String providerId;
    private String occurrenceId;
    private String transactionId;

    private Builder(GetOccurrenceNoteOptions getOccurrenceNoteOptions) {
      this.accountId = getOccurrenceNoteOptions.accountId;
      this.providerId = getOccurrenceNoteOptions.providerId;
      this.occurrenceId = getOccurrenceNoteOptions.occurrenceId;
      this.transactionId = getOccurrenceNoteOptions.transactionId;
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
     * @param providerId the providerId
     * @param occurrenceId the occurrenceId
     */
    public Builder(String accountId, String providerId, String occurrenceId) {
      this.accountId = accountId;
      this.providerId = providerId;
      this.occurrenceId = occurrenceId;
    }

    /**
     * Builds a GetOccurrenceNoteOptions.
     *
     * @return the new GetOccurrenceNoteOptions instance
     */
    public GetOccurrenceNoteOptions build() {
      return new GetOccurrenceNoteOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetOccurrenceNoteOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the providerId.
     *
     * @param providerId the providerId
     * @return the GetOccurrenceNoteOptions builder
     */
    public Builder providerId(String providerId) {
      this.providerId = providerId;
      return this;
    }

    /**
     * Set the occurrenceId.
     *
     * @param occurrenceId the occurrenceId
     * @return the GetOccurrenceNoteOptions builder
     */
    public Builder occurrenceId(String occurrenceId) {
      this.occurrenceId = occurrenceId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the GetOccurrenceNoteOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected GetOccurrenceNoteOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.providerId,
      "providerId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.occurrenceId,
      "occurrenceId cannot be empty");
    accountId = builder.accountId;
    providerId = builder.providerId;
    occurrenceId = builder.occurrenceId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a GetOccurrenceNoteOptions builder
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
   * Gets the providerId.
   *
   * First part of occurrence `name`: providers/{provider_id}/occurrences/{occurrence_id}.
   *
   * @return the providerId
   */
  public String providerId() {
    return providerId;
  }

  /**
   * Gets the occurrenceId.
   *
   * Second part of occurrence `name`: providers/{provider_id}/occurrences/{occurrence_id}.
   *
   * @return the occurrenceId
   */
  public String occurrenceId() {
    return occurrenceId;
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

