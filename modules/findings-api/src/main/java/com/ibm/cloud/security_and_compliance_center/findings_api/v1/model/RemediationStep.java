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
package com.ibm.cloud.security_and_compliance_center.findings_api.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A remediation step description and associated URL.
 */
public class RemediationStep extends GenericModel {

  protected String title;
  protected String url;

  /**
   * Builder.
   */
  public static class Builder {
    private String title;
    private String url;

    private Builder(RemediationStep remediationStep) {
      this.title = remediationStep.title;
      this.url = remediationStep.url;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RemediationStep.
     *
     * @return the new RemediationStep instance
     */
    public RemediationStep build() {
      return new RemediationStep(this);
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the RemediationStep builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the RemediationStep builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }
  }

  protected RemediationStep(Builder builder) {
    title = builder.title;
    url = builder.url;
  }

  /**
   * New builder.
   *
   * @return a RemediationStep builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the title.
   *
   * Title of this next step.
   *
   * @return the title
   */
  public String title() {
    return title;
  }

  /**
   * Gets the url.
   *
   * The URL associated to this next steps.
   *
   * @return the url
   */
  public String url() {
    return url;
  }
}

