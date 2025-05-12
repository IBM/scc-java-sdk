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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Credential.
 */
public class Credential extends GenericModel {

  @SerializedName("secret_crn")
  protected String secretCrn;
  protected List<Resource> resources;

  /**
   * Builder.
   */
  public static class Builder {
    private String secretCrn;
    private List<Resource> resources;

    /**
     * Instantiates a new Builder from an existing Credential instance.
     *
     * @param credential the instance to initialize the Builder with
     */
    private Builder(Credential credential) {
      this.secretCrn = credential.secretCrn;
      this.resources = credential.resources;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param secretCrn the secretCrn
     * @param resources the resources
     */
    public Builder(String secretCrn, List<Resource> resources) {
      this.secretCrn = secretCrn;
      this.resources = resources;
    }

    /**
     * Builds a Credential.
     *
     * @return the new Credential instance
     */
    public Credential build() {
      return new Credential(this);
    }

    /**
     * Adds a new element to resources.
     *
     * @param resources the new element to be added
     * @return the Credential builder
     */
    public Builder addResources(Resource resources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(resources,
        "resources cannot be null");
      if (this.resources == null) {
        this.resources = new ArrayList<Resource>();
      }
      this.resources.add(resources);
      return this;
    }

    /**
     * Set the secretCrn.
     *
     * @param secretCrn the secretCrn
     * @return the Credential builder
     */
    public Builder secretCrn(String secretCrn) {
      this.secretCrn = secretCrn;
      return this;
    }

    /**
     * Set the resources.
     * Existing resources will be replaced.
     *
     * @param resources the resources
     * @return the Credential builder
     */
    public Builder resources(List<Resource> resources) {
      this.resources = resources;
      return this;
    }
  }

  protected Credential() { }

  protected Credential(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.secretCrn,
      "secretCrn cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resources,
      "resources cannot be null");
    secretCrn = builder.secretCrn;
    resources = builder.resources;
  }

  /**
   * New builder.
   *
   * @return a Credential builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the secretCrn.
   *
   * The CRN of the secret.
   *
   * @return the secretCrn
   */
  public String secretCrn() {
    return secretCrn;
  }

  /**
   * Gets the resources.
   *
   * Credential having service name and instance crn.
   *
   * @return the resources
   */
  public List<Resource> resources() {
    return resources;
  }
}

