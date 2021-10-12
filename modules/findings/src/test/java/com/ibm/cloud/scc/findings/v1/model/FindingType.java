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
package com.ibm.cloud.scc.findings.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * FindingType provides details about a finding note.
 */
public class FindingType extends GenericModel {

  /**
   * Note provider-assigned severity/impact ranking
   * - LOW&amp;#58; Low Impact
   * - MEDIUM&amp;#58; Medium Impact
   * - HIGH&amp;#58; High Impact
   * - CRITICAL&amp;#58; Critical Impact.
   */
  public interface Severity {
    /** LOW. */
    String LOW = "LOW";
    /** MEDIUM. */
    String MEDIUM = "MEDIUM";
    /** HIGH. */
    String HIGH = "HIGH";
    /** CRITICAL. */
    String CRITICAL = "CRITICAL";
  }

  protected String severity;
  @SerializedName("next_steps")
  protected List<RemediationStep> nextSteps;

  /**
   * Builder.
   */
  public static class Builder {
    private String severity;
    private List<RemediationStep> nextSteps;

    private Builder(FindingType findingType) {
      this.severity = findingType.severity;
      this.nextSteps = findingType.nextSteps;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param severity the severity
     */
    public Builder(String severity) {
      this.severity = severity;
    }

    /**
     * Builds a FindingType.
     *
     * @return the new FindingType instance
     */
    public FindingType build() {
      return new FindingType(this);
    }

    /**
     * Adds an nextSteps to nextSteps.
     *
     * @param nextSteps the new nextSteps
     * @return the FindingType builder
     */
    public Builder addNextSteps(RemediationStep nextSteps) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(nextSteps,
        "nextSteps cannot be null");
      if (this.nextSteps == null) {
        this.nextSteps = new ArrayList<RemediationStep>();
      }
      this.nextSteps.add(nextSteps);
      return this;
    }

    /**
     * Set the severity.
     *
     * @param severity the severity
     * @return the FindingType builder
     */
    public Builder severity(String severity) {
      this.severity = severity;
      return this;
    }

    /**
     * Set the nextSteps.
     * Existing nextSteps will be replaced.
     *
     * @param nextSteps the nextSteps
     * @return the FindingType builder
     */
    public Builder nextSteps(List<RemediationStep> nextSteps) {
      this.nextSteps = nextSteps;
      return this;
    }
  }

  protected FindingType(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.severity,
      "severity cannot be null");
    severity = builder.severity;
    nextSteps = builder.nextSteps;
  }

  /**
   * New builder.
   *
   * @return a FindingType builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the severity.
   *
   * Note provider-assigned severity/impact ranking
   * - LOW&amp;#58; Low Impact
   * - MEDIUM&amp;#58; Medium Impact
   * - HIGH&amp;#58; High Impact
   * - CRITICAL&amp;#58; Critical Impact.
   *
   * @return the severity
   */
  public String severity() {
    return severity;
  }

  /**
   * Gets the nextSteps.
   *
   * Common remediation steps for the finding of this type.
   *
   * @return the nextSteps
   */
  public List<RemediationStep> nextSteps() {
    return nextSteps;
  }
}

