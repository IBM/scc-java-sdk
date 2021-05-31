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

import com.ibm.cloud.scc.findings.v1.model.DataTransferred;
import com.ibm.cloud.scc.findings.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DataTransferred model.
 */
public class DataTransferredTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDataTransferred() throws Throwable {
    DataTransferred dataTransferredModel = new DataTransferred.Builder()
      .clientBytes(Long.valueOf("26"))
      .serverBytes(Long.valueOf("26"))
      .clientPackets(Long.valueOf("26"))
      .serverPackets(Long.valueOf("26"))
      .build();
    assertEquals(dataTransferredModel.clientBytes(), Long.valueOf("26"));
    assertEquals(dataTransferredModel.serverBytes(), Long.valueOf("26"));
    assertEquals(dataTransferredModel.clientPackets(), Long.valueOf("26"));
    assertEquals(dataTransferredModel.serverPackets(), Long.valueOf("26"));

    String json = TestUtilities.serialize(dataTransferredModel);

    DataTransferred dataTransferredModelNew = TestUtilities.deserialize(json, DataTransferred.class);
    assertTrue(dataTransferredModelNew instanceof DataTransferred);
    assertEquals(dataTransferredModelNew.clientBytes(), Long.valueOf("26"));
    assertEquals(dataTransferredModelNew.serverBytes(), Long.valueOf("26"));
    assertEquals(dataTransferredModelNew.clientPackets(), Long.valueOf("26"));
    assertEquals(dataTransferredModelNew.serverPackets(), Long.valueOf("26"));
  }
}