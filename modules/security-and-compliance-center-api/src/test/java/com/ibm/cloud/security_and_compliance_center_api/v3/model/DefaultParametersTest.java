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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DefaultParameters;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DefaultParameters model.
 */
public class DefaultParametersTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDefaultParameters() throws Throwable {
    DefaultParameters defaultParametersModel = new DefaultParameters.Builder()
      .assessmentType("testString")
      .assessmentId("testString")
      .parameterName("testString")
      .parameterDefaultValue("testString")
      .parameterDisplayName("testString")
      .parameterType("testString")
      .build();
    assertEquals(defaultParametersModel.assessmentType(), "testString");
    assertEquals(defaultParametersModel.assessmentId(), "testString");
    assertEquals(defaultParametersModel.parameterName(), "testString");
    assertEquals(defaultParametersModel.parameterDefaultValue(), "testString");
    assertEquals(defaultParametersModel.parameterDisplayName(), "testString");
    assertEquals(defaultParametersModel.parameterType(), "testString");

    String json = TestUtilities.serialize(defaultParametersModel);

    DefaultParameters defaultParametersModelNew = TestUtilities.deserialize(json, DefaultParameters.class);
    assertTrue(defaultParametersModelNew instanceof DefaultParameters);
    assertEquals(defaultParametersModelNew.assessmentType(), "testString");
    assertEquals(defaultParametersModelNew.assessmentId(), "testString");
    assertEquals(defaultParametersModelNew.parameterName(), "testString");
    assertEquals(defaultParametersModelNew.parameterDefaultValue(), "testString");
    assertEquals(defaultParametersModelNew.parameterDisplayName(), "testString");
    assertEquals(defaultParametersModelNew.parameterType(), "testString");
  }
}