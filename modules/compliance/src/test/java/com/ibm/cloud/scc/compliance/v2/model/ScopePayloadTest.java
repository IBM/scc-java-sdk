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

package com.ibm.cloud.scc.compliance.v2.model;

import com.ibm.cloud.scc.compliance.v2.model.ScopePayload;
import com.ibm.cloud.scc.compliance.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ScopePayload model.
 */
public class ScopePayloadTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testScopePayload() throws Throwable {
    ScopePayload scopePayloadModel = new ScopePayload.Builder()
      .scopeId("testString")
      .scopeType("testString")
      .build();
    assertEquals(scopePayloadModel.scopeId(), "testString");
    assertEquals(scopePayloadModel.scopeType(), "testString");

    String json = TestUtilities.serialize(scopePayloadModel);

    ScopePayload scopePayloadModelNew = TestUtilities.deserialize(json, ScopePayload.class);
    assertTrue(scopePayloadModelNew instanceof ScopePayload);
    assertEquals(scopePayloadModelNew.scopeId(), "testString");
    assertEquals(scopePayloadModelNew.scopeType(), "testString");
  }
}