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
 * CredentialResponse.
 */
public class CredentialResponse extends GenericModel {

  protected String type;
  @SerializedName("secret_crn")
  protected String secretCrn;
  @SerializedName("secret_name")
  protected String secretName;
  protected List<Resource> resources;

  protected CredentialResponse() { }

  /**
   * Gets the type.
   *
   * The type of the credential.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the secretCrn.
   *
   * The CRN of the secret.
   *
   * @return the secretCrn
   */
  public String getSecretCrn() {
    return secretCrn;
  }

  /**
   * Gets the secretName.
   *
   * The name of the secret.
   *
   * @return the secretName
   */
  public String getSecretName() {
    return secretName;
  }

  /**
   * Gets the resources.
   *
   * Credential having service name and instance crn.
   *
   * @return the resources
   */
  public List<Resource> getResources() {
    return resources;
  }
}

