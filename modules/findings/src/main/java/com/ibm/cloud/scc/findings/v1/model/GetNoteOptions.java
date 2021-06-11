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
 * The getNote options.
 */
public class GetNoteOptions extends GenericModel {

  protected String providerId;
  protected String noteId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String providerId;
    private String noteId;
    private String transactionId;

    private Builder(GetNoteOptions getNoteOptions) {
      this.providerId = getNoteOptions.providerId;
      this.noteId = getNoteOptions.noteId;
      this.transactionId = getNoteOptions.transactionId;
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
     * @param noteId the noteId
     */
    public Builder(String providerId, String noteId) {
      this.providerId = providerId;
      this.noteId = noteId;
    }

    /**
     * Builds a GetNoteOptions.
     *
     * @return the new GetNoteOptions instance
     */
    public GetNoteOptions build() {
      return new GetNoteOptions(this);
    }

    /**
     * Set the providerId.
     *
     * @param providerId the providerId
     * @return the GetNoteOptions builder
     */
    public Builder providerId(String providerId) {
      this.providerId = providerId;
      return this;
    }

    /**
     * Set the noteId.
     *
     * @param noteId the noteId
     * @return the GetNoteOptions builder
     */
    public Builder noteId(String noteId) {
      this.noteId = noteId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the GetNoteOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected GetNoteOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.providerId,
      "providerId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.noteId,
      "noteId cannot be empty");
    providerId = builder.providerId;
    noteId = builder.noteId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a GetNoteOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the providerId.
   *
   * First part of note `name`: providers/{provider_id}/notes/{note_id}.
   *
   * @return the providerId
   */
  public String providerId() {
    return providerId;
  }

  /**
   * Gets the noteId.
   *
   * Second part of note `name`: providers/{provider_id}/notes/{note_id}.
   *
   * @return the noteId
   */
  public String noteId() {
    return noteId;
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

