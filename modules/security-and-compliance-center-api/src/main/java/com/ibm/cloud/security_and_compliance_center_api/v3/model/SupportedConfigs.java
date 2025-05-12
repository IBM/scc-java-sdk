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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The location information of supported configurations.
 */
public class SupportedConfigs extends GenericModel {

  @SerializedName("resource_kind")
  protected String resourceKind;
  @SerializedName("additional_target_attributes")
  protected List<AdditionalTargetAttribute> additionalTargetAttributes;
  @SerializedName("properties")
  protected List<RuleProperty> xProperties;
  protected String description;
  @SerializedName("cip_requires_service_instance")
  protected Boolean cipRequiresServiceInstance;
  @SerializedName("resource_group_support")
  protected Boolean resourceGroupSupport;
  @SerializedName("tagging_support")
  protected Boolean taggingSupport;
  @SerializedName("inherit_tags")
  protected Boolean inheritTags;

  protected SupportedConfigs() { }

  /**
   * Gets the resourceKind.
   *
   * The supported config resource kind.
   *
   * @return the resourceKind
   */
  public String getResourceKind() {
    return resourceKind;
  }

  /**
   * Gets the additionalTargetAttributes.
   *
   * The supported config list of additional target attributes.
   *
   * @return the additionalTargetAttributes
   */
  public List<AdditionalTargetAttribute> getAdditionalTargetAttributes() {
    return additionalTargetAttributes;
  }

  /**
   * Gets the xProperties.
   *
   * The supported config list properties.
   *
   * @return the xProperties
   */
  public List<RuleProperty> getXProperties() {
    return xProperties;
  }

  /**
   * Gets the description.
   *
   * The supported config description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the cipRequiresServiceInstance.
   *
   * The indication of whether the configuration information point (CIP) requires a service instance.
   *
   * @return the cipRequiresServiceInstance
   */
  public Boolean isCipRequiresServiceInstance() {
    return cipRequiresServiceInstance;
  }

  /**
   * Gets the resourceGroupSupport.
   *
   * The supported config resource group support.
   *
   * @return the resourceGroupSupport
   */
  public Boolean isResourceGroupSupport() {
    return resourceGroupSupport;
  }

  /**
   * Gets the taggingSupport.
   *
   * The supported config tagging support.
   *
   * @return the taggingSupport
   */
  public Boolean isTaggingSupport() {
    return taggingSupport;
  }

  /**
   * Gets the inheritTags.
   *
   * The supported config inherited tags.
   *
   * @return the inheritTags
   */
  public Boolean isInheritTags() {
    return inheritTags;
  }
}

