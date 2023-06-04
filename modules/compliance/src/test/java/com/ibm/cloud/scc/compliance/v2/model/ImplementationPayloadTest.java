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

import com.ibm.cloud.scc.compliance.v2.model.ImplementationPayload;
import com.ibm.cloud.scc.compliance.v2.model.ParameterInfo;
import com.ibm.cloud.scc.compliance.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ImplementationPayload model.
 */
public class ImplementationPayloadTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testImplementationPayload() throws Throwable {
    ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
      .parameterName("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .build();
    assertEquals(parameterInfoModel.parameterName(), "testString");
    assertEquals(parameterInfoModel.parameterDisplayName(), "testString");
    assertEquals(parameterInfoModel.parameterType(), "numeric");

    ImplementationPayload implementationPayloadModel = new ImplementationPayload.Builder()
      .assessmentId("testString")
      .assessmentMethod("testString")
      .assessmentType("testString")
      .assessmentDescription("testString")
      .parameterCount(Long.valueOf("26"))
      .parameters(java.util.Arrays.asList(parameterInfoModel))
      .build();
    assertEquals(implementationPayloadModel.assessmentId(), "testString");
    assertEquals(implementationPayloadModel.assessmentMethod(), "testString");
    assertEquals(implementationPayloadModel.assessmentType(), "testString");
    assertEquals(implementationPayloadModel.assessmentDescription(), "testString");
    assertEquals(implementationPayloadModel.parameterCount(), Long.valueOf("26"));
    assertEquals(implementationPayloadModel.parameters(), java.util.Arrays.asList(parameterInfoModel));

    String json = TestUtilities.serialize(implementationPayloadModel);

    ImplementationPayload implementationPayloadModelNew = TestUtilities.deserialize(json, ImplementationPayload.class);
    assertTrue(implementationPayloadModelNew instanceof ImplementationPayload);
    assertEquals(implementationPayloadModelNew.assessmentId(), "testString");
    assertEquals(implementationPayloadModelNew.assessmentMethod(), "testString");
    assertEquals(implementationPayloadModelNew.assessmentType(), "testString");
    assertEquals(implementationPayloadModelNew.assessmentDescription(), "testString");
    assertEquals(implementationPayloadModelNew.parameterCount(), Long.valueOf("26"));
  }
}