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
 * The collection of different types of tags.
 */
public class Tags extends GenericModel {

  protected List<String> user;
  protected List<String> access;
  protected List<String> service;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> user;
    private List<String> access;
    private List<String> service;

    /**
     * Instantiates a new Builder from an existing Tags instance.
     *
     * @param tags the instance to initialize the Builder with
     */
    private Builder(Tags tags) {
      this.user = tags.user;
      this.access = tags.access;
      this.service = tags.service;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Tags.
     *
     * @return the new Tags instance
     */
    public Tags build() {
      return new Tags(this);
    }

    /**
     * Adds a new element to user.
     *
     * @param user the new element to be added
     * @return the Tags builder
     */
    public Builder addUser(String user) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(user,
        "user cannot be null");
      if (this.user == null) {
        this.user = new ArrayList<String>();
      }
      this.user.add(user);
      return this;
    }

    /**
     * Adds a new element to access.
     *
     * @param access the new element to be added
     * @return the Tags builder
     */
    public Builder addAccess(String access) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(access,
        "access cannot be null");
      if (this.access == null) {
        this.access = new ArrayList<String>();
      }
      this.access.add(access);
      return this;
    }

    /**
     * Adds a new element to service.
     *
     * @param service the new element to be added
     * @return the Tags builder
     */
    public Builder addService(String service) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(service,
        "service cannot be null");
      if (this.service == null) {
        this.service = new ArrayList<String>();
      }
      this.service.add(service);
      return this;
    }

    /**
     * Set the user.
     * Existing user will be replaced.
     *
     * @param user the user
     * @return the Tags builder
     */
    public Builder user(List<String> user) {
      this.user = user;
      return this;
    }

    /**
     * Set the access.
     * Existing access will be replaced.
     *
     * @param access the access
     * @return the Tags builder
     */
    public Builder access(List<String> access) {
      this.access = access;
      return this;
    }

    /**
     * Set the service.
     * Existing service will be replaced.
     *
     * @param service the service
     * @return the Tags builder
     */
    public Builder service(List<String> service) {
      this.service = service;
      return this;
    }
  }

  protected Tags() { }

  protected Tags(Builder builder) {
    user = builder.user;
    access = builder.access;
    service = builder.service;
  }

  /**
   * New builder.
   *
   * @return a Tags builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the user.
   *
   * The collection of user tags.
   *
   * @return the user
   */
  public List<String> user() {
    return user;
  }

  /**
   * Gets the access.
   *
   * The collection of access tags.
   *
   * @return the access
   */
  public List<String> access() {
    return access;
  }

  /**
   * Gets the service.
   *
   * The collection of service tags.
   *
   * @return the service
   */
  public List<String> service() {
    return service;
  }
}

