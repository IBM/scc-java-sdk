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
 * The listRules options.
 */
public class ListRulesOptions extends GenericModel {

  protected String xCorrelationId;
  protected String xRequestId;
  protected String type;
  protected String search;
  protected String serviceName;

  /**
   * Builder.
   */
  public static class Builder {
    private String xCorrelationId;
    private String xRequestId;
    private String type;
    private String search;
    private String serviceName;

    /**
     * Instantiates a new Builder from an existing ListRulesOptions instance.
     *
     * @param listRulesOptions the instance to initialize the Builder with
     */
    private Builder(ListRulesOptions listRulesOptions) {
      this.xCorrelationId = listRulesOptions.xCorrelationId;
      this.xRequestId = listRulesOptions.xRequestId;
      this.type = listRulesOptions.type;
      this.search = listRulesOptions.search;
      this.serviceName = listRulesOptions.serviceName;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListRulesOptions.
     *
     * @return the new ListRulesOptions instance
     */
    public ListRulesOptions build() {
      return new ListRulesOptions(this);
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the ListRulesOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the ListRulesOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ListRulesOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the search.
     *
     * @param search the search
     * @return the ListRulesOptions builder
     */
    public Builder search(String search) {
      this.search = search;
      return this;
    }

    /**
     * Set the serviceName.
     *
     * @param serviceName the serviceName
     * @return the ListRulesOptions builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }
  }

  protected ListRulesOptions() { }

  protected ListRulesOptions(Builder builder) {
    xCorrelationId = builder.xCorrelationId;
    xRequestId = builder.xRequestId;
    type = builder.type;
    search = builder.search;
    serviceName = builder.serviceName;
  }

  /**
   * New builder.
   *
   * @return a ListRulesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the xCorrelationId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header for the
   * corresponding response. The same value is used for downstream requests and retries of those requests. If a value of
   * this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xCorrelationId
   */
  public String xCorrelationId() {
    return xCorrelationId;
  }

  /**
   * Gets the xRequestId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header  for the
   * corresponding response.  The same value is not used for downstream requests and retries of those requests.  If a
   * value of this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xRequestId
   */
  public String xRequestId() {
    return xRequestId;
  }

  /**
   * Gets the type.
   *
   * The list of only user-defined, or system-defined rules.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the search.
   *
   * The indication of whether to search for rules with a specific string string in the name, description, or labels.
   *
   * @return the search
   */
  public String search() {
    return search;
  }

  /**
   * Gets the serviceName.
   *
   * Searches for rules targeting corresponding service.
   *
   * @return the serviceName
   */
  public String serviceName() {
    return serviceName;
  }
}

