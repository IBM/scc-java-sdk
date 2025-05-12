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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createTarget options.
 */
public class CreateTargetOptions extends GenericModel {

  protected String instanceId;
  protected String accountId;
  protected String trustedProfileId;
  protected String name;
  protected List<Credential> credentials;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String accountId;
    private String trustedProfileId;
    private String name;
    private List<Credential> credentials;

    /**
     * Instantiates a new Builder from an existing CreateTargetOptions instance.
     *
     * @param createTargetOptions the instance to initialize the Builder with
     */
    private Builder(CreateTargetOptions createTargetOptions) {
      this.instanceId = createTargetOptions.instanceId;
      this.accountId = createTargetOptions.accountId;
      this.trustedProfileId = createTargetOptions.trustedProfileId;
      this.name = createTargetOptions.name;
      this.credentials = createTargetOptions.credentials;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceId the instanceId
     * @param accountId the accountId
     * @param trustedProfileId the trustedProfileId
     * @param name the name
     */
    public Builder(String instanceId, String accountId, String trustedProfileId, String name) {
      this.instanceId = instanceId;
      this.accountId = accountId;
      this.trustedProfileId = trustedProfileId;
      this.name = name;
    }

    /**
     * Builds a CreateTargetOptions.
     *
     * @return the new CreateTargetOptions instance
     */
    public CreateTargetOptions build() {
      return new CreateTargetOptions(this);
    }

    /**
     * Adds a new element to credentials.
     *
     * @param credentials the new element to be added
     * @return the CreateTargetOptions builder
     */
    public Builder addCredentials(Credential credentials) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(credentials,
        "credentials cannot be null");
      if (this.credentials == null) {
        this.credentials = new ArrayList<Credential>();
      }
      this.credentials.add(credentials);
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the CreateTargetOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateTargetOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the trustedProfileId.
     *
     * @param trustedProfileId the trustedProfileId
     * @return the CreateTargetOptions builder
     */
    public Builder trustedProfileId(String trustedProfileId) {
      this.trustedProfileId = trustedProfileId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateTargetOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the credentials.
     * Existing credentials will be replaced.
     *
     * @param credentials the credentials
     * @return the CreateTargetOptions builder
     */
    public Builder credentials(List<Credential> credentials) {
      this.credentials = credentials;
      return this;
    }
  }

  protected CreateTargetOptions() { }

  protected CreateTargetOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.trustedProfileId,
      "trustedProfileId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    instanceId = builder.instanceId;
    accountId = builder.accountId;
    trustedProfileId = builder.trustedProfileId;
    name = builder.name;
    credentials = builder.credentials;
  }

  /**
   * New builder.
   *
   * @return a CreateTargetOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The ID of the Security and Compliance Center instance.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the accountId.
   *
   * The target account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the trustedProfileId.
   *
   * The trusted profile ID.
   *
   * @return the trustedProfileId
   */
  public String trustedProfileId() {
    return trustedProfileId;
  }

  /**
   * Gets the name.
   *
   * The target name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the credentials.
   *
   * Customer credential to access for a specific service to scan.
   *
   * @return the credentials
   */
  public List<Credential> credentials() {
    return credentials;
  }
}

