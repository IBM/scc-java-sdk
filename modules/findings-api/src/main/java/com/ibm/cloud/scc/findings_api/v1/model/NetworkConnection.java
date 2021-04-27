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
package com.ibm.cloud.scc.findings_api.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * It provides details about a network connection.
 */
public class NetworkConnection extends GenericModel {

  protected String direction;
  protected String protocol;
  protected SocketAddress client;
  protected SocketAddress server;

  /**
   * Builder.
   */
  public static class Builder {
    private String direction;
    private String protocol;
    private SocketAddress client;
    private SocketAddress server;

    private Builder(NetworkConnection networkConnection) {
      this.direction = networkConnection.direction;
      this.protocol = networkConnection.protocol;
      this.client = networkConnection.client;
      this.server = networkConnection.server;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a NetworkConnection.
     *
     * @return the new NetworkConnection instance
     */
    public NetworkConnection build() {
      return new NetworkConnection(this);
    }

    /**
     * Set the direction.
     *
     * @param direction the direction
     * @return the NetworkConnection builder
     */
    public Builder direction(String direction) {
      this.direction = direction;
      return this;
    }

    /**
     * Set the protocol.
     *
     * @param protocol the protocol
     * @return the NetworkConnection builder
     */
    public Builder protocol(String protocol) {
      this.protocol = protocol;
      return this;
    }

    /**
     * Set the client.
     *
     * @param client the client
     * @return the NetworkConnection builder
     */
    public Builder client(SocketAddress client) {
      this.client = client;
      return this;
    }

    /**
     * Set the server.
     *
     * @param server the server
     * @return the NetworkConnection builder
     */
    public Builder server(SocketAddress server) {
      this.server = server;
      return this;
    }
  }

  protected NetworkConnection(Builder builder) {
    direction = builder.direction;
    protocol = builder.protocol;
    client = builder.client;
    server = builder.server;
  }

  /**
   * New builder.
   *
   * @return a NetworkConnection builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the direction.
   *
   * The direction of this network connection.
   *
   * @return the direction
   */
  public String direction() {
    return direction;
  }

  /**
   * Gets the protocol.
   *
   * The protocol of this network connection.
   *
   * @return the protocol
   */
  public String protocol() {
    return protocol;
  }

  /**
   * Gets the client.
   *
   * It provides details about a socket address.
   *
   * @return the client
   */
  public SocketAddress client() {
    return client;
  }

  /**
   * Gets the server.
   *
   * It provides details about a socket address.
   *
   * @return the server
   */
  public SocketAddress server() {
    return server;
  }
}

