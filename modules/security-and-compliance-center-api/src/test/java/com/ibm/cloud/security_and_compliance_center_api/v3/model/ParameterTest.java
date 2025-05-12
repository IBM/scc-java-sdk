/*
 * (C) Copyright IBM Corp. 2025.
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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Parameter;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Parameter model.
 */
public class ParameterTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testParameter() throws Throwable {
    Parameter parameterModel = new Parameter.Builder()
      .assessmentType("testString")
      .assessmentId("testString")
      .parameterName("location")
      .parameterDisplayName("Location")
      .parameterType("string")
      .parameterValue("testString")
      .build();
    assertEquals(parameterModel.assessmentType(), "testString");
    assertEquals(parameterModel.assessmentId(), "testString");
    assertEquals(parameterModel.parameterName(), "location");
    assertEquals(parameterModel.parameterDisplayName(), "Location");
    assertEquals(parameterModel.parameterType(), "string");
    assertEquals(parameterModel.parameterValue(), "testString");

    String json = TestUtilities.serialize(parameterModel);

    Parameter parameterModelNew = TestUtilities.deserialize(json, Parameter.class);
    assertTrue(parameterModelNew instanceof Parameter);
    assertEquals(parameterModelNew.assessmentType(), "testString");
    assertEquals(parameterModelNew.assessmentId(), "testString");
    assertEquals(parameterModelNew.parameterName(), "location");
    assertEquals(parameterModelNew.parameterDisplayName(), "Location");
    assertEquals(parameterModelNew.parameterType(), "string");
    assertEquals(parameterModelNew.parameterValue(), "testString");
  }
}