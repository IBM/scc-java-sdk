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
package com.ibm.cloud.scc.notifications_api.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The alert sources. They identify the providers and their finding types which makes the findings available to Security
 * Advisor.
 */
public class NotificationChannelAlertSourceItem extends GenericModel {

  @SerializedName("provider_name")
  protected String providerName;
  @SerializedName("finding_types")
  protected List<String> findingTypes;

  /**
   * Builder.
   */
  public static class Builder {
    private String providerName;
    private List<String> findingTypes;

    private Builder(NotificationChannelAlertSourceItem notificationChannelAlertSourceItem) {
      this.providerName = notificationChannelAlertSourceItem.providerName;
      this.findingTypes = notificationChannelAlertSourceItem.findingTypes;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param providerName the providerName
     */
    public Builder(String providerName) {
      this.providerName = providerName;
    }

    /**
     * Builds a NotificationChannelAlertSourceItem.
     *
     * @return the new NotificationChannelAlertSourceItem instance
     */
    public NotificationChannelAlertSourceItem build() {
      return new NotificationChannelAlertSourceItem(this);
    }

    /**
     * Adds an findingTypes to findingTypes.
     *
     * @param findingTypes the new findingTypes
     * @return the NotificationChannelAlertSourceItem builder
     */
    public Builder addFindingTypes(String findingTypes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(findingTypes,
        "findingTypes cannot be null");
      if (this.findingTypes == null) {
        this.findingTypes = new ArrayList<String>();
      }
      this.findingTypes.add(findingTypes);
      return this;
    }

    /**
     * Set the providerName.
     *
     * @param providerName the providerName
     * @return the NotificationChannelAlertSourceItem builder
     */
    public Builder providerName(String providerName) {
      this.providerName = providerName;
      return this;
    }

    /**
     * Set the findingTypes.
     * Existing findingTypes will be replaced.
     *
     * @param findingTypes the findingTypes
     * @return the NotificationChannelAlertSourceItem builder
     */
    public Builder findingTypes(List<String> findingTypes) {
      this.findingTypes = findingTypes;
      return this;
    }
  }

  protected NotificationChannelAlertSourceItem(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.providerName,
      "providerName cannot be null");
    providerName = builder.providerName;
    findingTypes = builder.findingTypes;
  }

  /**
   * New builder.
   *
   * @return a NotificationChannelAlertSourceItem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the providerName.
   *
   * Below is a list of builtin providers that you can select in addition to the ones you obtain by calling Findings API
   * /v1/{account_id}/providers :
   *  | provider_name | The source they represent |
   *  |-----|-----|
   *  | VA  | Vulnerable image findings|
   *  | NA  | Network Insights findings|
   *  | ATA | Activity Insights findings|
   *  | CERT | Certificate Manager findings|
   *  | ALL | Special provider name to represent all the providers. Its mutually exclusive with other providers meaning
   * either you choose ALL or you don't|.
   *
   * @return the providerName
   */
  public String providerName() {
    return providerName;
  }

  /**
   * Gets the findingTypes.
   *
   * An array of the finding types of the provider_name or "ALL" to specify all finding types under that provider Below
   * is a list of supported finding types for each built in providers
   * | provider_name | Supported finding types |
   * |-----|-----|
   * | VA  | "image_with_vulnerabilities", "image_with_config_issues"|
   * | NA  | "anonym_server", "malware_server", "bot_server", "miner_server", "server_suspected_ratio",
   * "server_response", "data_extrusion", "server_weaponized_total"|
   * | ATA | "appid", "cos", "iks", "iam", "kms", "cert", "account", "app"|
   * | CERT | "expired_cert", "expiring_1day_cert", "expiring_10day_cert", "expiring_30day_cert", "expiring_60day_cert",
   * "expiring_90day_cert"|
   * | ALL | "ALL"|.
   *
   * @return the findingTypes
   */
  public List<String> findingTypes() {
    return findingTypes;
  }
}

