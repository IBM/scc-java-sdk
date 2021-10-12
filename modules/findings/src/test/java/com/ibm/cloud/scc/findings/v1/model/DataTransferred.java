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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * It provides details about data transferred between clients and servers.
 */
public class DataTransferred extends GenericModel {

  @SerializedName("client_bytes")
  protected Long clientBytes;
  @SerializedName("server_bytes")
  protected Long serverBytes;
  @SerializedName("client_packets")
  protected Long clientPackets;
  @SerializedName("server_packets")
  protected Long serverPackets;

  /**
   * Builder.
   */
  public static class Builder {
    private Long clientBytes;
    private Long serverBytes;
    private Long clientPackets;
    private Long serverPackets;

    private Builder(DataTransferred dataTransferred) {
      this.clientBytes = dataTransferred.clientBytes;
      this.serverBytes = dataTransferred.serverBytes;
      this.clientPackets = dataTransferred.clientPackets;
      this.serverPackets = dataTransferred.serverPackets;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DataTransferred.
     *
     * @return the new DataTransferred instance
     */
    public DataTransferred build() {
      return new DataTransferred(this);
    }

    /**
     * Set the clientBytes.
     *
     * @param clientBytes the clientBytes
     * @return the DataTransferred builder
     */
    public Builder clientBytes(long clientBytes) {
      this.clientBytes = clientBytes;
      return this;
    }

    /**
     * Set the serverBytes.
     *
     * @param serverBytes the serverBytes
     * @return the DataTransferred builder
     */
    public Builder serverBytes(long serverBytes) {
      this.serverBytes = serverBytes;
      return this;
    }

    /**
     * Set the clientPackets.
     *
     * @param clientPackets the clientPackets
     * @return the DataTransferred builder
     */
    public Builder clientPackets(long clientPackets) {
      this.clientPackets = clientPackets;
      return this;
    }

    /**
     * Set the serverPackets.
     *
     * @param serverPackets the serverPackets
     * @return the DataTransferred builder
     */
    public Builder serverPackets(long serverPackets) {
      this.serverPackets = serverPackets;
      return this;
    }
  }

  protected DataTransferred(Builder builder) {
    clientBytes = builder.clientBytes;
    serverBytes = builder.serverBytes;
    clientPackets = builder.clientPackets;
    serverPackets = builder.serverPackets;
  }

  /**
   * New builder.
   *
   * @return a DataTransferred builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the clientBytes.
   *
   * The number of client bytes transferred.
   *
   * @return the clientBytes
   */
  public Long clientBytes() {
    return clientBytes;
  }

  /**
   * Gets the serverBytes.
   *
   * The number of server bytes transferred.
   *
   * @return the serverBytes
   */
  public Long serverBytes() {
    return serverBytes;
  }

  /**
   * Gets the clientPackets.
   *
   * The number of client packets transferred.
   *
   * @return the clientPackets
   */
  public Long clientPackets() {
    return clientPackets;
  }

  /**
   * Gets the serverPackets.
   *
   * The number of server packets transferred.
   *
   * @return the serverPackets
   */
  public Long serverPackets() {
    return serverPackets;
  }
}

