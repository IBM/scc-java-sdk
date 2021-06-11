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

import com.ibm.cloud.scc.findings.v1.model.ListProvidersOptions;
import com.ibm.cloud.scc.findings.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListProvidersOptions model.
 */
public class ListProvidersOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListProvidersOptions() throws Throwable {
    ListProvidersOptions listProvidersOptionsModel = new ListProvidersOptions.Builder()
      .transactionId("testString")
      .limit(Long.valueOf("2"))
      .skip(Long.valueOf("26"))
      .startProviderId("testString")
      .endProviderId("testString")
      .build();
    assertEquals(listProvidersOptionsModel.transactionId(), "testString");
    assertEquals(listProvidersOptionsModel.limit(), Long.valueOf("2"));
    assertEquals(listProvidersOptionsModel.skip(), Long.valueOf("26"));
    assertEquals(listProvidersOptionsModel.startProviderId(), "testString");
    assertEquals(listProvidersOptionsModel.endProviderId(), "testString");
  }
}