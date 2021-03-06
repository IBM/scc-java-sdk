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
 * The getOccurrence options.
 */
public class GetOccurrenceOptions extends GenericModel {

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

    private Builder(GetOccurrenceOptions getOccurrenceOptions) {
      this.providerId = getOccurrenceOptions.providerId;
      this.occurrenceId = getOccurrenceOptions.occurrenceId;
      this.transactionId = getOccurrenceOptions.transactionId;
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
     * Builds a GetOccurrenceOptions.
     *
     * @return the new GetOccurrenceOptions instance
     */
    public GetOccurrenceOptions build() {
      return new GetOccurrenceOptions(this);
    }

    /**
     * Set the providerId.
     *
     * @param providerId the providerId
     * @return the GetOccurrenceOptions builder
     */
    public Builder providerId(String providerId) {
      this.providerId = providerId;
      return this;
    }

    /**
     * Set the occurrenceId.
     *
     * @param occurrenceId the occurrenceId
     * @return the GetOccurrenceOptions builder
     */
    public Builder occurrenceId(String occurrenceId) {
      this.occurrenceId = occurrenceId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the GetOccurrenceOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected GetOccurrenceOptions(Builder builder) {
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
   * @return a GetOccurrenceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the providerId.
   *
   * Part of the parent. This field contains the provider ID. For example: providers/{provider_id}.
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
   * The transaction ID for the request in UUID v4 format.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

