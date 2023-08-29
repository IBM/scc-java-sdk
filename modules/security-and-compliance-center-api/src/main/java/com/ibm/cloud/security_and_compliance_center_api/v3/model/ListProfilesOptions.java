/*
 * (C) Copyright IBM Corp. 2023.
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
 * The listProfiles options.
 */
public class ListProfilesOptions extends GenericModel {

  protected String xCorrelationId;
  protected String xRequestId;
  protected Long limit;
  protected String profileType;
  protected String start;

  /**
   * Builder.
   */
  public static class Builder {
    private String xCorrelationId;
    private String xRequestId;
    private Long limit;
    private String profileType;
    private String start;

    /**
     * Instantiates a new Builder from an existing ListProfilesOptions instance.
     *
     * @param listProfilesOptions the instance to initialize the Builder with
     */
    private Builder(ListProfilesOptions listProfilesOptions) {
      this.xCorrelationId = listProfilesOptions.xCorrelationId;
      this.xRequestId = listProfilesOptions.xRequestId;
      this.limit = listProfilesOptions.limit;
      this.profileType = listProfilesOptions.profileType;
      this.start = listProfilesOptions.start;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListProfilesOptions.
     *
     * @return the new ListProfilesOptions instance
     */
    public ListProfilesOptions build() {
      return new ListProfilesOptions(this);
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the ListProfilesOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the ListProfilesOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListProfilesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the profileType.
     *
     * @param profileType the profileType
     * @return the ListProfilesOptions builder
     */
    public Builder profileType(String profileType) {
      this.profileType = profileType;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListProfilesOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }
  }

  protected ListProfilesOptions() { }

  protected ListProfilesOptions(Builder builder) {
    xCorrelationId = builder.xCorrelationId;
    xRequestId = builder.xRequestId;
    limit = builder.limit;
    profileType = builder.profileType;
    start = builder.start;
  }

  /**
   * New builder.
   *
   * @return a ListProfilesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the xCorrelationId.
   *
   * The supplied or generated value of this header is logged for a request, and repeated in a response header for the
   * corresponding response. The same value is used for downstream requests, and retries of those requests. If a value
   * of this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xCorrelationId
   */
  public String xCorrelationId() {
    return xCorrelationId;
  }

  /**
   * Gets the xRequestId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header for the
   * corresponding response. The same value is not used for downstream requests and retries of those requests. If a
   * value of this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xRequestId
   */
  public String xRequestId() {
    return xRequestId;
  }

  /**
   * Gets the limit.
   *
   * The indication of how many resources to return, unless the response is the last page of resources.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the profileType.
   *
   * The field that indicate how you want the resources to be filtered by.
   *
   * @return the profileType
   */
  public String profileType() {
    return profileType;
  }

  /**
   * Gets the start.
   *
   * Determine what resource to start the page on or after.
   *
   * @return the start
   */
  public String start() {
    return start;
  }
}

