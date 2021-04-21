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
package com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The providers that act as alert sources and the potential findings that can be flagged as alerts.
 */
public class ChannelAlertSourceItem extends GenericModel {

  /**
   * The providers that you can receive alerts for. To view your available providers, you can call the
   * /v1/{account_id}/providers endpoint of the Findings API.
   */
  public interface ProviderName {
    /** VA. */
    String VA = "VA";
    /** NA. */
    String NA = "NA";
    /** ATA. */
    String ATA = "ATA";
    /** CERT. */
    String CERT = "CERT";
    /** ALL. */
    String ALL = "ALL";
  }

  @SerializedName("provider_name")
  protected String providerName;
  @SerializedName("finding_types")
  protected List<Object> findingTypes;

  /**
   * Gets the providerName.
   *
   * The providers that you can receive alerts for. To view your available providers, you can call the
   * /v1/{account_id}/providers endpoint of the Findings API.
   *
   * @return the providerName
   */
  public String getProviderName() {
    return providerName;
  }

  /**
   * Gets the findingTypes.
   *
   * The types of findings for each provider that you want to receive alerts for. Options are dependent upon the
   * provider that you select. Depending on that selection, some available options include `image_with_vulnerabilities`,
   * `anonym_server`, `server_suspected_ratio`, `appid`, `cos`, `expired_cert`, and `expiring_1day_cert`For a full list
   * of available finding types, see [the docs](/docs/).
   *
   * @return the findingTypes
   */
  public List<Object> getFindingTypes() {
    return findingTypes;
  }
}

