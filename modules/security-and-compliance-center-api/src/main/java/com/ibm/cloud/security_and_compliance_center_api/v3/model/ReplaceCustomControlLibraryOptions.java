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
 * The replaceCustomControlLibrary options.
 */
public class ReplaceCustomControlLibraryOptions extends GenericModel {

  /**
   * Details that the control library is a user made(custom) or Security Compliance Center(predefined).
   */
  public interface ControlLibraryType {
    /** custom. */
    String CUSTOM = "custom";
  }

  protected String instanceId;
  protected String controlLibraryId;
  protected String controlLibraryName;
  protected String controlLibraryDescription;
  protected String controlLibraryType;
  protected String controlLibraryVersion;
  protected List<ControlPrototype> controls;
  protected String bssAccount;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String controlLibraryId;
    private String controlLibraryName;
    private String controlLibraryDescription;
    private String controlLibraryType;
    private String controlLibraryVersion;
    private List<ControlPrototype> controls;
    private String bssAccount;

    /**
     * Instantiates a new Builder from an existing ReplaceCustomControlLibraryOptions instance.
     *
     * @param replaceCustomControlLibraryOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceCustomControlLibraryOptions replaceCustomControlLibraryOptions) {
      this.instanceId = replaceCustomControlLibraryOptions.instanceId;
      this.controlLibraryId = replaceCustomControlLibraryOptions.controlLibraryId;
      this.controlLibraryName = replaceCustomControlLibraryOptions.controlLibraryName;
      this.controlLibraryDescription = replaceCustomControlLibraryOptions.controlLibraryDescription;
      this.controlLibraryType = replaceCustomControlLibraryOptions.controlLibraryType;
      this.controlLibraryVersion = replaceCustomControlLibraryOptions.controlLibraryVersion;
      this.controls = replaceCustomControlLibraryOptions.controls;
      this.bssAccount = replaceCustomControlLibraryOptions.bssAccount;
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
     * @param controlLibraryId the controlLibraryId
     * @param controlLibraryName the controlLibraryName
     * @param controlLibraryDescription the controlLibraryDescription
     * @param controlLibraryType the controlLibraryType
     * @param controlLibraryVersion the controlLibraryVersion
     * @param controls the controls
     */
    public Builder(String instanceId, String controlLibraryId, String controlLibraryName, String controlLibraryDescription, String controlLibraryType, String controlLibraryVersion, List<ControlPrototype> controls) {
      this.instanceId = instanceId;
      this.controlLibraryId = controlLibraryId;
      this.controlLibraryName = controlLibraryName;
      this.controlLibraryDescription = controlLibraryDescription;
      this.controlLibraryType = controlLibraryType;
      this.controlLibraryVersion = controlLibraryVersion;
      this.controls = controls;
    }

    /**
     * Builds a ReplaceCustomControlLibraryOptions.
     *
     * @return the new ReplaceCustomControlLibraryOptions instance
     */
    public ReplaceCustomControlLibraryOptions build() {
      return new ReplaceCustomControlLibraryOptions(this);
    }

    /**
     * Adds a new element to controls.
     *
     * @param controls the new element to be added
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder addControls(ControlPrototype controls) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(controls,
        "controls cannot be null");
      if (this.controls == null) {
        this.controls = new ArrayList<ControlPrototype>();
      }
      this.controls.add(controls);
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the controlLibraryId.
     *
     * @param controlLibraryId the controlLibraryId
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controlLibraryId(String controlLibraryId) {
      this.controlLibraryId = controlLibraryId;
      return this;
    }

    /**
     * Set the controlLibraryName.
     *
     * @param controlLibraryName the controlLibraryName
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controlLibraryName(String controlLibraryName) {
      this.controlLibraryName = controlLibraryName;
      return this;
    }

    /**
     * Set the controlLibraryDescription.
     *
     * @param controlLibraryDescription the controlLibraryDescription
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controlLibraryDescription(String controlLibraryDescription) {
      this.controlLibraryDescription = controlLibraryDescription;
      return this;
    }

    /**
     * Set the controlLibraryType.
     *
     * @param controlLibraryType the controlLibraryType
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controlLibraryType(String controlLibraryType) {
      this.controlLibraryType = controlLibraryType;
      return this;
    }

    /**
     * Set the controlLibraryVersion.
     *
     * @param controlLibraryVersion the controlLibraryVersion
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controlLibraryVersion(String controlLibraryVersion) {
      this.controlLibraryVersion = controlLibraryVersion;
      return this;
    }

    /**
     * Set the controls.
     * Existing controls will be replaced.
     *
     * @param controls the controls
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controls(List<ControlPrototype> controls) {
      this.controls = controls;
      return this;
    }

    /**
     * Set the bssAccount.
     *
     * @param bssAccount the bssAccount
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder bssAccount(String bssAccount) {
      this.bssAccount = bssAccount;
      return this;
    }
  }

  protected ReplaceCustomControlLibraryOptions() { }

  protected ReplaceCustomControlLibraryOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.controlLibraryId,
      "controlLibraryId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controlLibraryName,
      "controlLibraryName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controlLibraryDescription,
      "controlLibraryDescription cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controlLibraryType,
      "controlLibraryType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controlLibraryVersion,
      "controlLibraryVersion cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controls,
      "controls cannot be null");
    instanceId = builder.instanceId;
    controlLibraryId = builder.controlLibraryId;
    controlLibraryName = builder.controlLibraryName;
    controlLibraryDescription = builder.controlLibraryDescription;
    controlLibraryType = builder.controlLibraryType;
    controlLibraryVersion = builder.controlLibraryVersion;
    controls = builder.controls;
    bssAccount = builder.bssAccount;
  }

  /**
   * New builder.
   *
   * @return a ReplaceCustomControlLibraryOptions builder
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
   * Gets the controlLibraryId.
   *
   * The control library ID.
   *
   * @return the controlLibraryId
   */
  public String controlLibraryId() {
    return controlLibraryId;
  }

  /**
   * Gets the controlLibraryName.
   *
   * The name of the control library.
   *
   * @return the controlLibraryName
   */
  public String controlLibraryName() {
    return controlLibraryName;
  }

  /**
   * Gets the controlLibraryDescription.
   *
   * Details of the control library.
   *
   * @return the controlLibraryDescription
   */
  public String controlLibraryDescription() {
    return controlLibraryDescription;
  }

  /**
   * Gets the controlLibraryType.
   *
   * Details that the control library is a user made(custom) or Security Compliance Center(predefined).
   *
   * @return the controlLibraryType
   */
  public String controlLibraryType() {
    return controlLibraryType;
  }

  /**
   * Gets the controlLibraryVersion.
   *
   * The revision number of the control library.
   *
   * @return the controlLibraryVersion
   */
  public String controlLibraryVersion() {
    return controlLibraryVersion;
  }

  /**
   * Gets the controls.
   *
   * The list of rules that the control library attempts to adhere to.
   *
   * @return the controls
   */
  public List<ControlPrototype> controls() {
    return controls;
  }

  /**
   * Gets the bssAccount.
   *
   * The account id tied to billing.
   *
   * @return the bssAccount
   */
  public String bssAccount() {
    return bssAccount;
  }
}

