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
 * The entity reporting a note.
 */
public class Reporter extends GenericModel {

  protected String id;
  protected String title;
  protected String url;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String title;
    private String url;

    private Builder(Reporter reporter) {
      this.id = reporter.id;
      this.title = reporter.title;
      this.url = reporter.url;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     * @param title the title
     */
    public Builder(String id, String title) {
      this.id = id;
      this.title = title;
    }

    /**
     * Builds a Reporter.
     *
     * @return the new Reporter instance
     */
    public Reporter build() {
      return new Reporter(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the Reporter builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the Reporter builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the Reporter builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }
  }

  protected Reporter(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.id,
      "id cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.title,
      "title cannot be null");
    id = builder.id;
    title = builder.title;
    url = builder.url;
  }

  /**
   * New builder.
   *
   * @return a Reporter builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The id of this reporter.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the title.
   *
   * The title of this reporter.
   *
   * @return the title
   */
  public String title() {
    return title;
  }

  /**
   * Gets the url.
   *
   * The url of this reporter.
   *
   * @return the url
   */
  public String url() {
    return url;
  }
}

