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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Card provides details about a card kind of note.
 */
public class Card extends GenericModel {

  protected String section;
  protected String title;
  protected String subtitle;
  protected Long order;
  @SerializedName("finding_note_names")
  protected List<String> findingNoteNames;
  @SerializedName("requires_configuration")
  protected Boolean requiresConfiguration;
  @SerializedName("badge_text")
  protected String badgeText;
  @SerializedName("badge_image")
  protected String badgeImage;
  protected List<CardElement> elements;

  /**
   * Builder.
   */
  public static class Builder {
    private String section;
    private String title;
    private String subtitle;
    private Long order;
    private List<String> findingNoteNames;
    private Boolean requiresConfiguration;
    private String badgeText;
    private String badgeImage;
    private List<CardElement> elements;

    private Builder(Card card) {
      this.section = card.section;
      this.title = card.title;
      this.subtitle = card.subtitle;
      this.order = card.order;
      this.findingNoteNames = card.findingNoteNames;
      this.requiresConfiguration = card.requiresConfiguration;
      this.badgeText = card.badgeText;
      this.badgeImage = card.badgeImage;
      this.elements = card.elements;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param section the section
     * @param title the title
     * @param subtitle the subtitle
     * @param findingNoteNames the findingNoteNames
     * @param elements the elements
     */
    public Builder(String section, String title, String subtitle, List<String> findingNoteNames, List<CardElement> elements) {
      this.section = section;
      this.title = title;
      this.subtitle = subtitle;
      this.findingNoteNames = findingNoteNames;
      this.elements = elements;
    }

    /**
     * Builds a Card.
     *
     * @return the new Card instance
     */
    public Card build() {
      return new Card(this);
    }

    /**
     * Adds an findingNoteNames to findingNoteNames.
     *
     * @param findingNoteNames the new findingNoteNames
     * @return the Card builder
     */
    public Builder addFindingNoteNames(String findingNoteNames) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(findingNoteNames,
        "findingNoteNames cannot be null");
      if (this.findingNoteNames == null) {
        this.findingNoteNames = new ArrayList<String>();
      }
      this.findingNoteNames.add(findingNoteNames);
      return this;
    }

    /**
     * Adds an elements to elements.
     *
     * @param elements the new elements
     * @return the Card builder
     */
    public Builder addElements(CardElement elements) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(elements,
        "elements cannot be null");
      if (this.elements == null) {
        this.elements = new ArrayList<CardElement>();
      }
      this.elements.add(elements);
      return this;
    }

    /**
     * Set the section.
     *
     * @param section the section
     * @return the Card builder
     */
    public Builder section(String section) {
      this.section = section;
      return this;
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the Card builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }

    /**
     * Set the subtitle.
     *
     * @param subtitle the subtitle
     * @return the Card builder
     */
    public Builder subtitle(String subtitle) {
      this.subtitle = subtitle;
      return this;
    }

    /**
     * Set the order.
     *
     * @param order the order
     * @return the Card builder
     */
    public Builder order(long order) {
      this.order = order;
      return this;
    }

    /**
     * Set the findingNoteNames.
     * Existing findingNoteNames will be replaced.
     *
     * @param findingNoteNames the findingNoteNames
     * @return the Card builder
     */
    public Builder findingNoteNames(List<String> findingNoteNames) {
      this.findingNoteNames = findingNoteNames;
      return this;
    }

    /**
     * Set the requiresConfiguration.
     *
     * @param requiresConfiguration the requiresConfiguration
     * @return the Card builder
     */
    public Builder requiresConfiguration(Boolean requiresConfiguration) {
      this.requiresConfiguration = requiresConfiguration;
      return this;
    }

    /**
     * Set the badgeText.
     *
     * @param badgeText the badgeText
     * @return the Card builder
     */
    public Builder badgeText(String badgeText) {
      this.badgeText = badgeText;
      return this;
    }

    /**
     * Set the badgeImage.
     *
     * @param badgeImage the badgeImage
     * @return the Card builder
     */
    public Builder badgeImage(String badgeImage) {
      this.badgeImage = badgeImage;
      return this;
    }

    /**
     * Set the elements.
     * Existing elements will be replaced.
     *
     * @param elements the elements
     * @return the Card builder
     */
    public Builder elements(List<CardElement> elements) {
      this.elements = elements;
      return this;
    }
  }

  protected Card(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.section,
      "section cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.title,
      "title cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.subtitle,
      "subtitle cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.findingNoteNames,
      "findingNoteNames cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.elements,
      "elements cannot be null");
    section = builder.section;
    title = builder.title;
    subtitle = builder.subtitle;
    order = builder.order;
    findingNoteNames = builder.findingNoteNames;
    requiresConfiguration = builder.requiresConfiguration;
    badgeText = builder.badgeText;
    badgeImage = builder.badgeImage;
    elements = builder.elements;
  }

  /**
   * New builder.
   *
   * @return a Card builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the section.
   *
   * The section this card belongs to.
   *
   * @return the section
   */
  public String section() {
    return section;
  }

  /**
   * Gets the title.
   *
   * The title of this card.
   *
   * @return the title
   */
  public String title() {
    return title;
  }

  /**
   * Gets the subtitle.
   *
   * The subtitle of this card.
   *
   * @return the subtitle
   */
  public String subtitle() {
    return subtitle;
  }

  /**
   * Gets the order.
   *
   * The order of the card in which it will appear on SA dashboard in the mentioned section.
   *
   * @return the order
   */
  public Long order() {
    return order;
  }

  /**
   * Gets the findingNoteNames.
   *
   * The finding note names associated to this card.
   *
   * @return the findingNoteNames
   */
  public List<String> findingNoteNames() {
    return findingNoteNames;
  }

  /**
   * Gets the requiresConfiguration.
   *
   * @return the requiresConfiguration
   */
  public Boolean requiresConfiguration() {
    return requiresConfiguration;
  }

  /**
   * Gets the badgeText.
   *
   * The text associated to the card's badge.
   *
   * @return the badgeText
   */
  public String badgeText() {
    return badgeText;
  }

  /**
   * Gets the badgeImage.
   *
   * The base64 content of the image associated to the card's badge.
   *
   * @return the badgeImage
   */
  public String badgeImage() {
    return badgeImage;
  }

  /**
   * Gets the elements.
   *
   * The elements of this card.
   *
   * @return the elements
   */
  public List<CardElement> elements() {
    return elements;
  }
}

