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
package com.ibm.cloud.scc.findings_api.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Metadata for any related URL information.
 */
public class ApiNoteRelatedUrl extends GenericModel {

  protected String label;
  protected String url;

  /**
   * Builder.
   */
  public static class Builder {
    private String label;
    private String url;

    private Builder(ApiNoteRelatedUrl apiNoteRelatedUrl) {
      this.label = apiNoteRelatedUrl.label;
      this.url = apiNoteRelatedUrl.url;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ApiNoteRelatedUrl.
     *
     * @return the new ApiNoteRelatedUrl instance
     */
    public ApiNoteRelatedUrl build() {
      return new ApiNoteRelatedUrl(this);
    }

    /**
     * Set the label.
     *
     * @param label the label
     * @return the ApiNoteRelatedUrl builder
     */
    public Builder label(String label) {
      this.label = label;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the ApiNoteRelatedUrl builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }
  }

  protected ApiNoteRelatedUrl(Builder builder) {
    label = builder.label;
    url = builder.url;
  }

  /**
   * New builder.
   *
   * @return a ApiNoteRelatedUrl builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the label.
   *
   * @return the label
   */
  public String label() {
    return label;
  }

  /**
   * Gets the url.
   *
   * @return the url
   */
  public String url() {
    return url;
  }
}

