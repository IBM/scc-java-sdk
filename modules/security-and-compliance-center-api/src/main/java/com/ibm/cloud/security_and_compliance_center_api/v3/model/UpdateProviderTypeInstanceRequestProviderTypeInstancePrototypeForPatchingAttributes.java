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

import java.util.Map;

/**
 * The provider type instance payload for patching attributes.
 */
public class UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingAttributes extends UpdateProviderTypeInstanceRequest {


  /**
   * Builder.
   */
  public static class Builder {
    private Map<String, Object> attributes;

    /**
     * Instantiates a new Builder from an existing UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingAttributes instance.
     *
     * @param updateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingAttributes the instance to initialize the Builder with
     */
    public Builder(UpdateProviderTypeInstanceRequest updateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingAttributes) {
      this.attributes = updateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingAttributes.attributes;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param attributes the attributes
     */
    public Builder(Map<String, Object> attributes) {
      this.attributes = attributes;
    }

    /**
     * Builds a UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingAttributes.
     *
     * @return the new UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingAttributes instance
     */
    public UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingAttributes build() {
      return new UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingAttributes(this);
    }

    /**
     * Set the attributes.
     *
     * @param attributes the attributes
     * @return the UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingAttributes builder
     */
    public Builder attributes(Map<String, Object> attributes) {
      this.attributes = attributes;
      return this;
    }
  }

  protected UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingAttributes() { }

  protected UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingAttributes(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.attributes,
      "attributes cannot be null");
    attributes = builder.attributes;
  }

  /**
   * New builder.
   *
   * @return a UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingAttributes builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

