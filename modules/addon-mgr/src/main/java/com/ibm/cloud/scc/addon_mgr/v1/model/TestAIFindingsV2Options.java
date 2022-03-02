/*
 * (C) Copyright IBM Corp. 2022.
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
package com.ibm.cloud.scc.addon_mgr.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The testAiFindingsV2 options.
 */
public class TestAIFindingsV2Options extends GenericModel {

  protected String regionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String regionId;

    private Builder(TestAIFindingsV2Options testAiFindingsV2Options) {
      this.regionId = testAiFindingsV2Options.regionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param regionId the regionId
     */
    public Builder(String regionId) {
      this.regionId = regionId;
    }

    /**
     * Builds a TestAIFindingsV2Options.
     *
     * @return the new TestAIFindingsV2Options instance
     */
    public TestAIFindingsV2Options build() {
      return new TestAIFindingsV2Options(this);
    }

    /**
     * Set the regionId.
     *
     * @param regionId the regionId
     * @return the TestAIFindingsV2Options builder
     */
    public Builder regionId(String regionId) {
      this.regionId = regionId;
      return this;
    }
  }

  protected TestAIFindingsV2Options(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.regionId,
      "regionId cannot be null");
    regionId = builder.regionId;
  }

  /**
   * New builder.
   *
   * @return a TestAIFindingsV2Options builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the regionId.
   *
   * Region for example - us-south, eu-gb.
   *
   * @return the regionId
   */
  public String regionId() {
    return regionId;
  }
}

