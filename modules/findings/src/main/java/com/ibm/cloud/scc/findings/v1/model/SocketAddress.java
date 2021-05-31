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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * It provides details about a socket address.
 */
public class SocketAddress extends GenericModel {

  protected String address;
  protected Long port;

  /**
   * Builder.
   */
  public static class Builder {
    private String address;
    private Long port;

    private Builder(SocketAddress socketAddress) {
      this.address = socketAddress.address;
      this.port = socketAddress.port;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param address the address
     */
    public Builder(String address) {
      this.address = address;
    }

    /**
     * Builds a SocketAddress.
     *
     * @return the new SocketAddress instance
     */
    public SocketAddress build() {
      return new SocketAddress(this);
    }

    /**
     * Set the address.
     *
     * @param address the address
     * @return the SocketAddress builder
     */
    public Builder address(String address) {
      this.address = address;
      return this;
    }

    /**
     * Set the port.
     *
     * @param port the port
     * @return the SocketAddress builder
     */
    public Builder port(long port) {
      this.port = port;
      return this;
    }
  }

  protected SocketAddress(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.address,
      "address cannot be null");
    address = builder.address;
    port = builder.port;
  }

  /**
   * New builder.
   *
   * @return a SocketAddress builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the address.
   *
   * The IP address of this socket address.
   *
   * @return the address
   */
  public String address() {
    return address;
  }

  /**
   * Gets the port.
   *
   * The port number of this socket address.
   *
   * @return the port
   */
  public Long port() {
    return port;
  }
}

