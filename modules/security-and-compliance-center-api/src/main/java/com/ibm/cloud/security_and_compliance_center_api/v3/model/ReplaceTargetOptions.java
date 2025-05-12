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
 * The replaceTarget options.
 */
public class ReplaceTargetOptions extends GenericModel {

  protected String instanceId;
  protected String targetId;
  protected String accountId;
  protected String trustedProfileId;
  protected String name;
  protected List<Credential> credentials;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String targetId;
    private String accountId;
    private String trustedProfileId;
    private String name;
    private List<Credential> credentials;

    /**
     * Instantiates a new Builder from an existing ReplaceTargetOptions instance.
     *
     * @param replaceTargetOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceTargetOptions replaceTargetOptions) {
      this.instanceId = replaceTargetOptions.instanceId;
      this.targetId = replaceTargetOptions.targetId;
      this.accountId = replaceTargetOptions.accountId;
      this.trustedProfileId = replaceTargetOptions.trustedProfileId;
      this.name = replaceTargetOptions.name;
      this.credentials = replaceTargetOptions.credentials;
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
     * @param targetId the targetId
     * @param accountId the accountId
     * @param trustedProfileId the trustedProfileId
     * @param name the name
     */
    public Builder(String instanceId, String targetId, String accountId, String trustedProfileId, String name) {
      this.instanceId = instanceId;
      this.targetId = targetId;
      this.accountId = accountId;
      this.trustedProfileId = trustedProfileId;
      this.name = name;
    }

    /**
     * Builds a ReplaceTargetOptions.
     *
     * @return the new ReplaceTargetOptions instance
     */
    public ReplaceTargetOptions build() {
      return new ReplaceTargetOptions(this);
    }

    /**
     * Adds a new element to credentials.
     *
     * @param credentials the new element to be added
     * @return the ReplaceTargetOptions builder
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
     * @return the ReplaceTargetOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the targetId.
     *
     * @param targetId the targetId
     * @return the ReplaceTargetOptions builder
     */
    public Builder targetId(String targetId) {
      this.targetId = targetId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ReplaceTargetOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the trustedProfileId.
     *
     * @param trustedProfileId the trustedProfileId
     * @return the ReplaceTargetOptions builder
     */
    public Builder trustedProfileId(String trustedProfileId) {
      this.trustedProfileId = trustedProfileId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ReplaceTargetOptions builder
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
     * @return the ReplaceTargetOptions builder
     */
    public Builder credentials(List<Credential> credentials) {
      this.credentials = credentials;
      return this;
    }
  }

  protected ReplaceTargetOptions() { }

  protected ReplaceTargetOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.targetId,
      "targetId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.trustedProfileId,
      "trustedProfileId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    instanceId = builder.instanceId;
    targetId = builder.targetId;
    accountId = builder.accountId;
    trustedProfileId = builder.trustedProfileId;
    name = builder.name;
    credentials = builder.credentials;
  }

  /**
   * New builder.
   *
   * @return a ReplaceTargetOptions builder
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
   * Gets the targetId.
   *
   * The target ID.
   *
   * @return the targetId
   */
  public String targetId() {
    return targetId;
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

