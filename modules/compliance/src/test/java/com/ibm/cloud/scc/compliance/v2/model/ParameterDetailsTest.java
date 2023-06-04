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

import com.ibm.cloud.scc.compliance.v2.model.ParameterDetails;
import com.ibm.cloud.scc.compliance.v2.model.ParameterInfo;
import com.ibm.cloud.scc.compliance.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ParameterDetails model.
 */
public class ParameterDetailsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testParameterDetails() throws Throwable {
    ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
      .parameterName("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .build();
    assertEquals(parameterInfoModel.parameterName(), "testString");
    assertEquals(parameterInfoModel.parameterDisplayName(), "testString");
    assertEquals(parameterInfoModel.parameterType(), "numeric");

    ParameterDetails parameterDetailsModel = new ParameterDetails.Builder()
      .parameterName("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .parameterValue("testString")
      .assessmentType("testString")
      .assessmentId("testString")
      .parameters(java.util.Arrays.asList(parameterInfoModel))
      .build();
    assertEquals(parameterDetailsModel.parameterName(), "testString");
    assertEquals(parameterDetailsModel.parameterDisplayName(), "testString");
    assertEquals(parameterDetailsModel.parameterType(), "numeric");
    assertEquals(parameterDetailsModel.parameterValue(), "testString");
    assertEquals(parameterDetailsModel.assessmentType(), "testString");
    assertEquals(parameterDetailsModel.assessmentId(), "testString");
    assertEquals(parameterDetailsModel.parameters(), java.util.Arrays.asList(parameterInfoModel));

    String json = TestUtilities.serialize(parameterDetailsModel);

    ParameterDetails parameterDetailsModelNew = TestUtilities.deserialize(json, ParameterDetails.class);
    assertTrue(parameterDetailsModelNew instanceof ParameterDetails);
    assertEquals(parameterDetailsModelNew.parameterName(), "testString");
    assertEquals(parameterDetailsModelNew.parameterDisplayName(), "testString");
    assertEquals(parameterDetailsModelNew.parameterType(), "numeric");
    assertEquals(parameterDetailsModelNew.parameterValue(), "testString");
    assertEquals(parameterDetailsModelNew.assessmentType(), "testString");
    assertEquals(parameterDetailsModelNew.assessmentId(), "testString");
  }
}