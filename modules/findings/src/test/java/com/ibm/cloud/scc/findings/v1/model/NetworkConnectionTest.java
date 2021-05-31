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

import com.ibm.cloud.scc.findings.v1.model.NetworkConnection;
import com.ibm.cloud.scc.findings.v1.model.SocketAddress;
import com.ibm.cloud.scc.findings.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the NetworkConnection model.
 */
public class NetworkConnectionTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testNetworkConnection() throws Throwable {
    SocketAddress socketAddressModel = new SocketAddress.Builder()
      .address("testString")
      .port(Long.valueOf("26"))
      .build();
    assertEquals(socketAddressModel.address(), "testString");
    assertEquals(socketAddressModel.port(), Long.valueOf("26"));

    NetworkConnection networkConnectionModel = new NetworkConnection.Builder()
      .direction("testString")
      .protocol("testString")
      .client(socketAddressModel)
      .server(socketAddressModel)
      .build();
    assertEquals(networkConnectionModel.direction(), "testString");
    assertEquals(networkConnectionModel.protocol(), "testString");
    assertEquals(networkConnectionModel.client(), socketAddressModel);
    assertEquals(networkConnectionModel.server(), socketAddressModel);

    String json = TestUtilities.serialize(networkConnectionModel);

    NetworkConnection networkConnectionModelNew = TestUtilities.deserialize(json, NetworkConnection.class);
    assertTrue(networkConnectionModelNew instanceof NetworkConnection);
    assertEquals(networkConnectionModelNew.direction(), "testString");
    assertEquals(networkConnectionModelNew.protocol(), "testString");
    assertEquals(networkConnectionModelNew.client().toString(), socketAddressModel.toString());
    assertEquals(networkConnectionModelNew.server().toString(), socketAddressModel.toString());
  }
}