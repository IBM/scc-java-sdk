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
package com.ibm.cloud.security_and_compliance_center.findings_api.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Card provides details about a card kind of note.
 */
public class Section extends GenericModel {

  protected String title;
  protected String image;

  /**
   * Builder.
   */
  public static class Builder {
    private String title;
    private String image;

    private Builder(Section section) {
      this.title = section.title;
      this.image = section.image;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param title the title
     * @param image the image
     */
    public Builder(String title, String image) {
      this.title = title;
      this.image = image;
    }

    /**
     * Builds a Section.
     *
     * @return the new Section instance
     */
    public Section build() {
      return new Section(this);
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the Section builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }

    /**
     * Set the image.
     *
     * @param image the image
     * @return the Section builder
     */
    public Builder image(String image) {
      this.image = image;
      return this;
    }
  }

  protected Section(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.title,
      "title cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.image,
      "image cannot be null");
    title = builder.title;
    image = builder.image;
  }

  /**
   * New builder.
   *
   * @return a Section builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the title.
   *
   * The title of this section.
   *
   * @return the title
   */
  public String title() {
    return title;
  }

  /**
   * Gets the image.
   *
   * The image of this section.
   *
   * @return the image
   */
  public String image() {
    return image;
  }
}

