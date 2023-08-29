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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DefaultParametersPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileControlsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceProfileOptions model.
 */
public class ReplaceProfileOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceProfileOptions() throws Throwable {
    ProfileControlsPrototype profileControlsPrototypeModel = new ProfileControlsPrototype.Builder()
      .controlLibraryId("e98a56ff-dc24-41d4-9875-1e188e2da6cd")
      .controlId("5C453578-E9A1-421E-AD0F-C6AFCDD67CCF")
      .build();
    assertEquals(profileControlsPrototypeModel.controlLibraryId(), "e98a56ff-dc24-41d4-9875-1e188e2da6cd");
    assertEquals(profileControlsPrototypeModel.controlId(), "5C453578-E9A1-421E-AD0F-C6AFCDD67CCF");

    DefaultParametersPrototype defaultParametersPrototypeModel = new DefaultParametersPrototype.Builder()
      .assessmentType("testString")
      .assessmentId("testString")
      .parameterName("testString")
      .parameterDefaultValue("testString")
      .parameterDisplayName("testString")
      .parameterType("string")
      .build();
    assertEquals(defaultParametersPrototypeModel.assessmentType(), "testString");
    assertEquals(defaultParametersPrototypeModel.assessmentId(), "testString");
    assertEquals(defaultParametersPrototypeModel.parameterName(), "testString");
    assertEquals(defaultParametersPrototypeModel.parameterDefaultValue(), "testString");
    assertEquals(defaultParametersPrototypeModel.parameterDisplayName(), "testString");
    assertEquals(defaultParametersPrototypeModel.parameterType(), "string");

    ReplaceProfileOptions replaceProfileOptionsModel = new ReplaceProfileOptions.Builder()
      .profilesId("testString")
      .profileName("testString")
      .profileDescription("testString")
      .profileType("predefined")
      .controls(java.util.Arrays.asList(profileControlsPrototypeModel))
      .defaultParameters(java.util.Arrays.asList(defaultParametersPrototypeModel))
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();
    assertEquals(replaceProfileOptionsModel.profilesId(), "testString");
    assertEquals(replaceProfileOptionsModel.profileName(), "testString");
    assertEquals(replaceProfileOptionsModel.profileDescription(), "testString");
    assertEquals(replaceProfileOptionsModel.profileType(), "predefined");
    assertEquals(replaceProfileOptionsModel.controls(), java.util.Arrays.asList(profileControlsPrototypeModel));
    assertEquals(replaceProfileOptionsModel.defaultParameters(), java.util.Arrays.asList(defaultParametersPrototypeModel));
    assertEquals(replaceProfileOptionsModel.xCorrelationId(), "testString");
    assertEquals(replaceProfileOptionsModel.xRequestId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceProfileOptionsError() throws Throwable {
    new ReplaceProfileOptions.Builder().build();
  }

}