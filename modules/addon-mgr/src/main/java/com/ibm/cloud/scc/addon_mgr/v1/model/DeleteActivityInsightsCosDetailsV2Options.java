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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteActivityInsightsCosDetailsV2 options.
 */
public class DeleteActivityInsightsCosDetailsV2Options extends GenericModel {

  protected List<String> ids;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> ids;
    private String transactionId;

    private Builder(DeleteActivityInsightsCosDetailsV2Options deleteActivityInsightsCosDetailsV2Options) {
      this.ids = deleteActivityInsightsCosDetailsV2Options.ids;
      this.transactionId = deleteActivityInsightsCosDetailsV2Options.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DeleteActivityInsightsCosDetailsV2Options.
     *
     * @return the new DeleteActivityInsightsCosDetailsV2Options instance
     */
    public DeleteActivityInsightsCosDetailsV2Options build() {
      return new DeleteActivityInsightsCosDetailsV2Options(this);
    }

    /**
     * Adds an ids to ids.
     *
     * @param ids the new ids
     * @return the DeleteActivityInsightsCosDetailsV2Options builder
     */
    public Builder addIds(String ids) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(ids,
        "ids cannot be null");
      if (this.ids == null) {
        this.ids = new ArrayList<String>();
      }
      this.ids.add(ids);
      return this;
    }

    /**
     * Set the ids.
     * Existing ids will be replaced.
     *
     * @param ids the ids
     * @return the DeleteActivityInsightsCosDetailsV2Options builder
     */
    public Builder ids(List<String> ids) {
      this.ids = ids;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the DeleteActivityInsightsCosDetailsV2Options builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected DeleteActivityInsightsCosDetailsV2Options(Builder builder) {
    ids = builder.ids;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a DeleteActivityInsightsCosDetailsV2Options builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the ids.
   *
   * Array of Ids of COS entries.
   *
   * @return the ids
   */
  public List<String> ids() {
    return ids;
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

