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

import java.util.Date;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The provider type item.
 */
public class ProviderTypeItem extends GenericModel {

  protected String id;
  protected String type;
  protected String name;
  protected String description;
  @SerializedName("s2s_enabled")
  protected Boolean s2sEnabled;
  @SerializedName("instance_limit")
  protected Long instanceLimit;
  protected String mode;
  @SerializedName("data_type")
  protected String dataType;
  protected String icon;
  protected LabelType label;
  protected Map<String, AdditionalProperty> attributes;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("updated_at")
  protected Date updatedAt;

  protected ProviderTypeItem() { }

  /**
   * Gets the id.
   *
   * The unique identifier of the provider type.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the type.
   *
   * The type of the provider type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the name.
   *
   * The name of the provider type.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The provider type description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the s2sEnabled.
   *
   * A boolean that indicates whether the provider type is s2s-enabled.
   *
   * @return the s2sEnabled
   */
  public Boolean isS2sEnabled() {
    return s2sEnabled;
  }

  /**
   * Gets the instanceLimit.
   *
   * The maximum number of instances that can be created for the provider type.
   *
   * @return the instanceLimit
   */
  public Long getInstanceLimit() {
    return instanceLimit;
  }

  /**
   * Gets the mode.
   *
   * The mode that is used to get results from provider (`PUSH` or `PULL`).
   *
   * @return the mode
   */
  public String getMode() {
    return mode;
  }

  /**
   * Gets the dataType.
   *
   * The format of the results that a provider supports.
   *
   * @return the dataType
   */
  public String getDataType() {
    return dataType;
  }

  /**
   * Gets the icon.
   *
   * The icon of a provider in .svg format that is encoded as a base64 string.
   *
   * @return the icon
   */
  public String getIcon() {
    return icon;
  }

  /**
   * Gets the label.
   *
   * The label that is associated with the provider type.
   *
   * @return the label
   */
  public LabelType getLabel() {
    return label;
  }

  /**
   * Gets the attributes.
   *
   * The attributes that are required when you're creating an instance of a provider type. The attributes field can have
   * multiple  keys in its value. Each of those keys has a value  object that includes the type, and display name as
   * keys. For example, `{type:"", display_name:""}`.
   * **NOTE;** If the provider type is s2s-enabled, which means that if the `s2s_enabled` field is set to `true`, then a
   * CRN field of type text is required in the attributes value object.
   *
   * @return the attributes
   */
  public Map<String, AdditionalProperty> getAttributes() {
    return attributes;
  }

  /**
   * Gets the createdAt.
   *
   * Time at which resource was created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the updatedAt.
   *
   * Time at which resource was updated.
   *
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }
}

