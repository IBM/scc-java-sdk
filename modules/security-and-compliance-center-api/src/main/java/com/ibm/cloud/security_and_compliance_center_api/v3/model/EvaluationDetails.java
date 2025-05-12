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
 * A list of details related to the Evaluation.
 */
public class EvaluationDetails extends GenericModel {

  @SerializedName("properties")
  protected List<EvaluationProperty> xProperties;
  @SerializedName("provider_info")
  protected EvaluationProviderInfo providerInfo;

  protected EvaluationDetails() { }

  /**
   * Gets the xProperties.
   *
   * Details the evaluations that were incorrect.
   *
   * @return the xProperties
   */
  public List<EvaluationProperty> getXProperties() {
    return xProperties;
  }

  /**
   * Gets the providerInfo.
   *
   * The source provider of the evaluation.
   *
   * @return the providerInfo
   */
  public EvaluationProviderInfo getProviderInfo() {
    return providerInfo;
  }
}

