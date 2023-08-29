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

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.LastScan;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the LastScan model.
 */
public class LastScanTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testLastScan() throws Throwable {
    LastScan lastScanModel = new LastScan.Builder()
      .id("e8a39d25-0051-4328-8462-988ad321f49a")
      .status("in_progress")
      .time(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .build();
    assertEquals(lastScanModel.id(), "e8a39d25-0051-4328-8462-988ad321f49a");
    assertEquals(lastScanModel.status(), "in_progress");
    assertEquals(lastScanModel.time(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));

    String json = TestUtilities.serialize(lastScanModel);

    LastScan lastScanModelNew = TestUtilities.deserialize(json, LastScan.class);
    assertTrue(lastScanModelNew instanceof LastScan);
    assertEquals(lastScanModelNew.id(), "e8a39d25-0051-4328-8462-988ad321f49a");
    assertEquals(lastScanModelNew.status(), "in_progress");
    assertEquals(lastScanModelNew.time(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
  }
}