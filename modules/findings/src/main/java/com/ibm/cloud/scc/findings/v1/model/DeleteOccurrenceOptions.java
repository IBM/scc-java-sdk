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
 * The deleteOccurrence options.
 */
public class DeleteOccurrenceOptions extends GenericModel {

  protected String providerId;
  protected String occurrenceId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String providerId;
    private String occurrenceId;
    private String transactionId;

    private Builder(DeleteOccurrenceOptions deleteOccurrenceOptions) {
      this.providerId = deleteOccurrenceOptions.providerId;
      this.occurrenceId = deleteOccurrenceOptions.occurrenceId;
      this.transactionId = deleteOccurrenceOptions.transactionId;
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
     * @param occurrenceId the occurrenceId
     */
    public Builder(String providerId, String occurrenceId) {
      this.providerId = providerId;
      this.occurrenceId = occurrenceId;
    }

    /**
     * Builds a DeleteOccurrenceOptions.
     *
     * @return the new DeleteOccurrenceOptions instance
     */
    public DeleteOccurrenceOptions build() {
      return new DeleteOccurrenceOptions(this);
    }

    /**
     * Set the providerId.
     *
     * @param providerId the providerId
     * @return the DeleteOccurrenceOptions builder
     */
    public Builder providerId(String providerId) {
      this.providerId = providerId;
      return this;
    }

    /**
     * Set the occurrenceId.
     *
     * @param occurrenceId the occurrenceId
     * @return the DeleteOccurrenceOptions builder
     */
    public Builder occurrenceId(String occurrenceId) {
      this.occurrenceId = occurrenceId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the DeleteOccurrenceOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected DeleteOccurrenceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.providerId,
      "providerId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.occurrenceId,
      "occurrenceId cannot be empty");
    providerId = builder.providerId;
    occurrenceId = builder.occurrenceId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a DeleteOccurrenceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the providerId.
   *
   * First part of occurrence `name`: providers/{provider_id}/notes/{occurrence_id}.
   *
   * @return the providerId
   */
  public String providerId() {
    return providerId;
  }

  /**
   * Gets the occurrenceId.
   *
   * Second part of occurrence `name`: providers/{provider_id}/notes/{occurrence_id}.
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

