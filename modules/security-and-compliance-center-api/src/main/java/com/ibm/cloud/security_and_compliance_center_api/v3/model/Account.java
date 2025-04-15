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
 * The account that is associated with a report.
 */
public class Account extends GenericModel {

  protected String id;
  protected String name;
  protected String type;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String name;
    private String type;

    /**
     * Instantiates a new Builder from an existing Account instance.
     *
     * @param account the instance to initialize the Builder with
     */
    private Builder(Account account) {
      this.id = account.id;
      this.name = account.name;
      this.type = account.type;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Account.
     *
     * @return the new Account instance
     */
    public Account build() {
      return new Account(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the Account builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the Account builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the Account builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }
  }

  protected Account() { }

  protected Account(Builder builder) {
    id = builder.id;
    name = builder.name;
    type = builder.type;
  }

  /**
   * New builder.
   *
   * @return a Account builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The account ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the name.
   *
   * The account name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the type.
   *
   * The account type.
   *
   * @return the type
   */
  public String type() {
    return type;
  }
}

