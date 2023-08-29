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

/**
 * The provider type instance payload for patching name.
 */
public class UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName extends UpdateProviderTypeInstanceRequest {


  /**
   * Builder.
   */
  public static class Builder {
    private String name;

    /**
     * Instantiates a new Builder from an existing UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName instance.
     *
     * @param updateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName the instance to initialize the Builder with
     */
    public Builder(UpdateProviderTypeInstanceRequest updateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName) {
      this.name = updateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName.name;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * Builds a UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName.
     *
     * @return the new UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName instance
     */
    public UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName build() {
      return new UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }
  }

  protected UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName() { }

  protected UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    name = builder.name;
  }

  /**
   * New builder.
   *
   * @return a UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

