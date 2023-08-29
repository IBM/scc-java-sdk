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
package com.ibm.cloud.security_and_compliance_center_api.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The control documentation.
 */
public class ControlDocs extends GenericModel {

  @SerializedName("control_docs_id")
  protected String controlDocsId;
  @SerializedName("control_docs_type")
  protected String controlDocsType;

  /**
   * Builder.
   */
  public static class Builder {
    private String controlDocsId;
    private String controlDocsType;

    /**
     * Instantiates a new Builder from an existing ControlDocs instance.
     *
     * @param controlDocs the instance to initialize the Builder with
     */
    private Builder(ControlDocs controlDocs) {
      this.controlDocsId = controlDocs.controlDocsId;
      this.controlDocsType = controlDocs.controlDocsType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ControlDocs.
     *
     * @return the new ControlDocs instance
     */
    public ControlDocs build() {
      return new ControlDocs(this);
    }

    /**
     * Set the controlDocsId.
     *
     * @param controlDocsId the controlDocsId
     * @return the ControlDocs builder
     */
    public Builder controlDocsId(String controlDocsId) {
      this.controlDocsId = controlDocsId;
      return this;
    }

    /**
     * Set the controlDocsType.
     *
     * @param controlDocsType the controlDocsType
     * @return the ControlDocs builder
     */
    public Builder controlDocsType(String controlDocsType) {
      this.controlDocsType = controlDocsType;
      return this;
    }
  }

  protected ControlDocs() { }

  protected ControlDocs(Builder builder) {
    controlDocsId = builder.controlDocsId;
    controlDocsType = builder.controlDocsType;
  }

  /**
   * New builder.
   *
   * @return a ControlDocs builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the controlDocsId.
   *
   * The ID of the control documentation.
   *
   * @return the controlDocsId
   */
  public String controlDocsId() {
    return controlDocsId;
  }

  /**
   * Gets the controlDocsType.
   *
   * The type of control documentation.
   *
   * @return the controlDocsType
   */
  public String controlDocsType() {
    return controlDocsType;
  }
}

