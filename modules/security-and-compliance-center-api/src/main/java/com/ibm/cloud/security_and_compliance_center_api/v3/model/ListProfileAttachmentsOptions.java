/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.cloud.security_and_compliance_center_api.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listProfileAttachments options.
 */
public class ListProfileAttachmentsOptions extends GenericModel {

  protected String instanceId;
  protected String profileId;
  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String profileId;
    private String accountId;

    /**
     * Instantiates a new Builder from an existing ListProfileAttachmentsOptions instance.
     *
     * @param listProfileAttachmentsOptions the instance to initialize the Builder with
     */
    private Builder(ListProfileAttachmentsOptions listProfileAttachmentsOptions) {
      this.instanceId = listProfileAttachmentsOptions.instanceId;
      this.profileId = listProfileAttachmentsOptions.profileId;
      this.accountId = listProfileAttachmentsOptions.accountId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceId the instanceId
     * @param profileId the profileId
     */
    public Builder(String instanceId, String profileId) {
      this.instanceId = instanceId;
      this.profileId = profileId;
    }

    /**
     * Builds a ListProfileAttachmentsOptions.
     *
     * @return the new ListProfileAttachmentsOptions instance
     */
    public ListProfileAttachmentsOptions build() {
      return new ListProfileAttachmentsOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ListProfileAttachmentsOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the ListProfileAttachmentsOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListProfileAttachmentsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected ListProfileAttachmentsOptions() { }

  protected ListProfileAttachmentsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    instanceId = builder.instanceId;
    profileId = builder.profileId;
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a ListProfileAttachmentsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The ID of the Security and Compliance Center instance.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the profileId.
   *
   * The profile ID.
   *
   * @return the profileId
   */
  public String profileId() {
    return profileId;
  }

  /**
   * Gets the accountId.
   *
   * The user account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

