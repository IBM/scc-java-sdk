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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createScanReport options.
 */
public class CreateScanReportOptions extends GenericModel {

  /**
   * The enum of different report format types.
   */
  public interface Format {
    /** csv. */
    String CSV = "csv";
    /** pdf. */
    String PDF = "pdf";
  }

  protected String instanceId;
  protected String reportId;
  protected String format;
  protected String scopeId;
  protected String subscopeId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String reportId;
    private String format;
    private String scopeId;
    private String subscopeId;

    /**
     * Instantiates a new Builder from an existing CreateScanReportOptions instance.
     *
     * @param createScanReportOptions the instance to initialize the Builder with
     */
    private Builder(CreateScanReportOptions createScanReportOptions) {
      this.instanceId = createScanReportOptions.instanceId;
      this.reportId = createScanReportOptions.reportId;
      this.format = createScanReportOptions.format;
      this.scopeId = createScanReportOptions.scopeId;
      this.subscopeId = createScanReportOptions.subscopeId;
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
     * @param reportId the reportId
     * @param format the format
     */
    public Builder(String instanceId, String reportId, String format) {
      this.instanceId = instanceId;
      this.reportId = reportId;
      this.format = format;
    }

    /**
     * Builds a CreateScanReportOptions.
     *
     * @return the new CreateScanReportOptions instance
     */
    public CreateScanReportOptions build() {
      return new CreateScanReportOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the CreateScanReportOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the reportId.
     *
     * @param reportId the reportId
     * @return the CreateScanReportOptions builder
     */
    public Builder reportId(String reportId) {
      this.reportId = reportId;
      return this;
    }

    /**
     * Set the format.
     *
     * @param format the format
     * @return the CreateScanReportOptions builder
     */
    public Builder format(String format) {
      this.format = format;
      return this;
    }

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the CreateScanReportOptions builder
     */
    public Builder scopeId(String scopeId) {
      this.scopeId = scopeId;
      return this;
    }

    /**
     * Set the subscopeId.
     *
     * @param subscopeId the subscopeId
     * @return the CreateScanReportOptions builder
     */
    public Builder subscopeId(String subscopeId) {
      this.subscopeId = subscopeId;
      return this;
    }
  }

  protected CreateScanReportOptions() { }

  protected CreateScanReportOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.reportId,
      "reportId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.format,
      "format cannot be null");
    instanceId = builder.instanceId;
    reportId = builder.reportId;
    format = builder.format;
    scopeId = builder.scopeId;
    subscopeId = builder.subscopeId;
  }

  /**
   * New builder.
   *
   * @return a CreateScanReportOptions builder
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
   * Gets the reportId.
   *
   * The ID of the scan that is associated with a report.
   *
   * @return the reportId
   */
  public String reportId() {
    return reportId;
  }

  /**
   * Gets the format.
   *
   * The enum of different report format types.
   *
   * @return the format
   */
  public String format() {
    return format;
  }

  /**
   * Gets the scopeId.
   *
   * The ID of the scope.
   *
   * @return the scopeId
   */
  public String scopeId() {
    return scopeId;
  }

  /**
   * Gets the subscopeId.
   *
   * The ID of the sub-scope.
   *
   * @return the subscopeId
   */
  public String subscopeId() {
    return subscopeId;
  }
}

