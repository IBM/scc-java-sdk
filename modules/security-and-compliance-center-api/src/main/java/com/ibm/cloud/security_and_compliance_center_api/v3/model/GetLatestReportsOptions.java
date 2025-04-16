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
 * The getLatestReports options.
 */
public class GetLatestReportsOptions extends GenericModel {

  /**
   * This field sorts controls by using a valid sort field. To learn more, see
   * [Sorting](https://cloud.ibm.com/docs/api-handbook?topic=api-handbook-sorting).
   */
  public interface Sort {
    /** profile_name. */
    String PROFILE_NAME = "profile_name";
    /** scope_id. */
    String SCOPE_ID = "scope_id";
    /** created_on. */
    String CREATED_ON = "created_on";
  }

  protected String instanceId;
  protected String sort;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String sort;

    /**
     * Instantiates a new Builder from an existing GetLatestReportsOptions instance.
     *
     * @param getLatestReportsOptions the instance to initialize the Builder with
     */
    private Builder(GetLatestReportsOptions getLatestReportsOptions) {
      this.instanceId = getLatestReportsOptions.instanceId;
      this.sort = getLatestReportsOptions.sort;
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
     */
    public Builder(String instanceId) {
      this.instanceId = instanceId;
    }

    /**
     * Builds a GetLatestReportsOptions.
     *
     * @return the new GetLatestReportsOptions instance
     */
    public GetLatestReportsOptions build() {
      return new GetLatestReportsOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the GetLatestReportsOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the GetLatestReportsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }
  }

  protected GetLatestReportsOptions() { }

  protected GetLatestReportsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    sort = builder.sort;
  }

  /**
   * New builder.
   *
   * @return a GetLatestReportsOptions builder
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
   * Gets the sort.
   *
   * This field sorts controls by using a valid sort field. To learn more, see
   * [Sorting](https://cloud.ibm.com/docs/api-handbook?topic=api-handbook-sorting).
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }
}

