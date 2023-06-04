/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.cloud.scc.compliance.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceCustomControlLibrary options.
 */
public class ReplaceCustomControlLibraryOptions extends GenericModel {

  /**
   * Control Library Type.
   */
  public interface ControlLibraryType {
    /** predefined. */
    String PREDEFINED = "predefined";
    /** custom. */
    String CUSTOM = "custom";
  }

  protected String controlLibrariesId;
  protected String instanceId;
  protected String id;
  protected String accountId;
  protected String controlLibraryName;
  protected String controlLibraryDescription;
  protected String controlLibraryType;
  protected String versionGroupLabel;
  protected String controlLibraryVersion;
  protected Boolean latest;
  protected Long controlsCount;
  protected List<ControlsInControlLibRequestPayload> controls;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String controlLibrariesId;
    private String instanceId;
    private String id;
    private String accountId;
    private String controlLibraryName;
    private String controlLibraryDescription;
    private String controlLibraryType;
    private String versionGroupLabel;
    private String controlLibraryVersion;
    private Boolean latest;
    private Long controlsCount;
    private List<ControlsInControlLibRequestPayload> controls;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing ReplaceCustomControlLibraryOptions instance.
     *
     * @param replaceCustomControlLibraryOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceCustomControlLibraryOptions replaceCustomControlLibraryOptions) {
      this.controlLibrariesId = replaceCustomControlLibraryOptions.controlLibrariesId;
      this.instanceId = replaceCustomControlLibraryOptions.instanceId;
      this.id = replaceCustomControlLibraryOptions.id;
      this.accountId = replaceCustomControlLibraryOptions.accountId;
      this.controlLibraryName = replaceCustomControlLibraryOptions.controlLibraryName;
      this.controlLibraryDescription = replaceCustomControlLibraryOptions.controlLibraryDescription;
      this.controlLibraryType = replaceCustomControlLibraryOptions.controlLibraryType;
      this.versionGroupLabel = replaceCustomControlLibraryOptions.versionGroupLabel;
      this.controlLibraryVersion = replaceCustomControlLibraryOptions.controlLibraryVersion;
      this.latest = replaceCustomControlLibraryOptions.latest;
      this.controlsCount = replaceCustomControlLibraryOptions.controlsCount;
      this.controls = replaceCustomControlLibraryOptions.controls;
      this.transactionId = replaceCustomControlLibraryOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param controlLibrariesId the controlLibrariesId
     * @param instanceId the instanceId
     */
    public Builder(String controlLibrariesId, String instanceId) {
      this.controlLibrariesId = controlLibrariesId;
      this.instanceId = instanceId;
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
     * Adds an controls to controls.
     *
     * @param controls the new controls
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder addControls(ControlsInControlLibRequestPayload controls) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(controls,
        "controls cannot be null");
      if (this.controls == null) {
        this.controls = new ArrayList<ControlsInControlLibRequestPayload>();
      }
      this.controls.add(controls);
      return this;
    }

    /**
     * Set the controlLibrariesId.
     *
     * @param controlLibrariesId the controlLibrariesId
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controlLibrariesId(String controlLibrariesId) {
      this.controlLibrariesId = controlLibrariesId;
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
     * Set the id.
     *
     * @param id the id
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
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
     * Set the versionGroupLabel.
     *
     * @param versionGroupLabel the versionGroupLabel
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder versionGroupLabel(String versionGroupLabel) {
      this.versionGroupLabel = versionGroupLabel;
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
     * Set the latest.
     *
     * @param latest the latest
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder latest(Boolean latest) {
      this.latest = latest;
      return this;
    }

    /**
     * Set the controlsCount.
     *
     * @param controlsCount the controlsCount
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controlsCount(long controlsCount) {
      this.controlsCount = controlsCount;
      return this;
    }

    /**
     * Set the controls.
     * Existing controls will be replaced.
     *
     * @param controls the controls
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controls(List<ControlsInControlLibRequestPayload> controls) {
      this.controls = controls;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the controlLibraryRequest.
     *
     * @param controlLibraryRequest the controlLibraryRequest
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controlLibraryRequest(ControlLibraryRequest controlLibraryRequest) {
      this.id = controlLibraryRequest.id();
      this.accountId = controlLibraryRequest.accountId();
      this.controlLibraryName = controlLibraryRequest.controlLibraryName();
      this.controlLibraryDescription = controlLibraryRequest.controlLibraryDescription();
      this.controlLibraryType = controlLibraryRequest.controlLibraryType();
      this.versionGroupLabel = controlLibraryRequest.versionGroupLabel();
      this.controlLibraryVersion = controlLibraryRequest.controlLibraryVersion();
      this.latest = controlLibraryRequest.latest();
      this.controlsCount = controlLibraryRequest.controlsCount();
      this.controls = controlLibraryRequest.controls();
      return this;
    }
  }

  protected ReplaceCustomControlLibraryOptions() { }

  protected ReplaceCustomControlLibraryOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.controlLibrariesId,
      "controlLibrariesId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    controlLibrariesId = builder.controlLibrariesId;
    instanceId = builder.instanceId;
    id = builder.id;
    accountId = builder.accountId;
    controlLibraryName = builder.controlLibraryName;
    controlLibraryDescription = builder.controlLibraryDescription;
    controlLibraryType = builder.controlLibraryType;
    versionGroupLabel = builder.versionGroupLabel;
    controlLibraryVersion = builder.controlLibraryVersion;
    latest = builder.latest;
    controlsCount = builder.controlsCount;
    controls = builder.controls;
    transactionId = builder.transactionId;
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
   * Gets the controlLibrariesId.
   *
   * The control library ID.
   *
   * @return the controlLibrariesId
   */
  public String controlLibrariesId() {
    return controlLibrariesId;
  }

  /**
   * Gets the instanceId.
   *
   * Instance id.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the id.
   *
   * Control Library ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the accountId.
   *
   * Account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the controlLibraryName.
   *
   * Control Library name.
   *
   * @return the controlLibraryName
   */
  public String controlLibraryName() {
    return controlLibraryName;
  }

  /**
   * Gets the controlLibraryDescription.
   *
   * Control Library Description.
   *
   * @return the controlLibraryDescription
   */
  public String controlLibraryDescription() {
    return controlLibraryDescription;
  }

  /**
   * Gets the controlLibraryType.
   *
   * Control Library Type.
   *
   * @return the controlLibraryType
   */
  public String controlLibraryType() {
    return controlLibraryType;
  }

  /**
   * Gets the versionGroupLabel.
   *
   * Version group label.
   *
   * @return the versionGroupLabel
   */
  public String versionGroupLabel() {
    return versionGroupLabel;
  }

  /**
   * Gets the controlLibraryVersion.
   *
   * Control Library Version.
   *
   * @return the controlLibraryVersion
   */
  public String controlLibraryVersion() {
    return controlLibraryVersion;
  }

  /**
   * Gets the latest.
   *
   * Latest.
   *
   * @return the latest
   */
  public Boolean latest() {
    return latest;
  }

  /**
   * Gets the controlsCount.
   *
   * Number of controls.
   *
   * @return the controlsCount
   */
  public Long controlsCount() {
    return controlsCount;
  }

  /**
   * Gets the controls.
   *
   * Controls.
   *
   * @return the controls
   */
  public List<ControlsInControlLibRequestPayload> controls() {
    return controls;
  }

  /**
   * Gets the transactionId.
   *
   * The transaction ID for the request in UUID v4 format.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

