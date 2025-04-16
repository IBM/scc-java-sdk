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

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The response body for creating a service instance.
 */
public class Service extends GenericModel {

  @SerializedName("created_on")
  protected Date createdOn;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("updated_on")
  protected Date updatedOn;
  @SerializedName("updated_by")
  protected String updatedBy;
  @SerializedName("service_name")
  protected String serviceName;
  @SerializedName("service_display_name")
  protected String serviceDisplayName;
  protected String description;
  @SerializedName("monitoring_enabled")
  protected Boolean monitoringEnabled;
  @SerializedName("enforcement_enabled")
  protected Boolean enforcementEnabled;
  @SerializedName("service_listing_enabled")
  protected Boolean serviceListingEnabled;
  @SerializedName("config_information_point")
  protected ConfigurationInformationPoints configInformationPoint;
  @SerializedName("supported_configs")
  protected List<SupportedConfigs> supportedConfigs;

  protected Service() { }

  /**
   * Gets the createdOn.
   *
   * The service creation date.
   *
   * @return the createdOn
   */
  public Date getCreatedOn() {
    return createdOn;
  }

  /**
   * Gets the createdBy.
   *
   * The service author.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the updatedOn.
   *
   * The date when the service was modified.
   *
   * @return the updatedOn
   */
  public Date getUpdatedOn() {
    return updatedOn;
  }

  /**
   * Gets the updatedBy.
   *
   * The user who modified the service.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the serviceName.
   *
   * The service name.
   *
   * @return the serviceName
   */
  public String getServiceName() {
    return serviceName;
  }

  /**
   * Gets the serviceDisplayName.
   *
   * The display name of the service.
   *
   * @return the serviceDisplayName
   */
  public String getServiceDisplayName() {
    return serviceDisplayName;
  }

  /**
   * Gets the description.
   *
   * The service description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the monitoringEnabled.
   *
   * The indication of whether monitoring is enabled.
   *
   * @return the monitoringEnabled
   */
  public Boolean isMonitoringEnabled() {
    return monitoringEnabled;
  }

  /**
   * Gets the enforcementEnabled.
   *
   * The indication of whether enforcement is enabled.
   *
   * @return the enforcementEnabled
   */
  public Boolean isEnforcementEnabled() {
    return enforcementEnabled;
  }

  /**
   * Gets the serviceListingEnabled.
   *
   * The indication of whether service listing is enabled.
   *
   * @return the serviceListingEnabled
   */
  public Boolean isServiceListingEnabled() {
    return serviceListingEnabled;
  }

  /**
   * Gets the configInformationPoint.
   *
   * The service configuration information.
   *
   * @return the configInformationPoint
   */
  public ConfigurationInformationPoints getConfigInformationPoint() {
    return configInformationPoint;
  }

  /**
   * Gets the supportedConfigs.
   *
   * The supported configurations.
   *
   * @return the supportedConfigs
   */
  public List<SupportedConfigs> getSupportedConfigs() {
    return supportedConfigs;
  }
}

