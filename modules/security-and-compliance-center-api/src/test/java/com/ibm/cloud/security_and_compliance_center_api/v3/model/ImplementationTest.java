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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Implementation;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ParameterInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Implementation model.
 */
public class ImplementationTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testImplementation() throws Throwable {
    ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
      .parameterName("parameter_name")
      .parameterDisplayName("parameter_display_name")
      .parameterType("string")
      .parameterValue("public")
      .build();
    assertEquals(parameterInfoModel.parameterName(), "parameter_name");
    assertEquals(parameterInfoModel.parameterDisplayName(), "parameter_display_name");
    assertEquals(parameterInfoModel.parameterType(), "string");
    assertEquals(parameterInfoModel.parameterValue(), "public");

    Implementation implementationModel = new Implementation.Builder()
      .assessmentId("testString")
      .assessmentMethod("testString")
      .assessmentType("testString")
      .assessmentDescription("testString")
      .parameterCount(Long.valueOf("26"))
      .parameters(java.util.Arrays.asList(parameterInfoModel))
      .build();
    assertEquals(implementationModel.assessmentId(), "testString");
    assertEquals(implementationModel.assessmentMethod(), "testString");
    assertEquals(implementationModel.assessmentType(), "testString");
    assertEquals(implementationModel.assessmentDescription(), "testString");
    assertEquals(implementationModel.parameterCount(), Long.valueOf("26"));
    assertEquals(implementationModel.parameters(), java.util.Arrays.asList(parameterInfoModel));

    String json = TestUtilities.serialize(implementationModel);

    Implementation implementationModelNew = TestUtilities.deserialize(json, Implementation.class);
    assertTrue(implementationModelNew instanceof Implementation);
    assertEquals(implementationModelNew.assessmentId(), "testString");
    assertEquals(implementationModelNew.assessmentMethod(), "testString");
    assertEquals(implementationModelNew.assessmentType(), "testString");
    assertEquals(implementationModelNew.assessmentDescription(), "testString");
    assertEquals(implementationModelNew.parameterCount(), Long.valueOf("26"));
  }
}