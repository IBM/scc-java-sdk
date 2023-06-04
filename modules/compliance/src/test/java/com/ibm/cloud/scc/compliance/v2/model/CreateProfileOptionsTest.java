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

import com.ibm.cloud.scc.compliance.v2.model.CreateProfileOptions;
import com.ibm.cloud.scc.compliance.v2.model.DefaultParameters;
import com.ibm.cloud.scc.compliance.v2.model.ProfileControlsInRequest;
import com.ibm.cloud.scc.compliance.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateProfileOptions model.
 */
public class CreateProfileOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateProfileOptions() throws Throwable {
    ProfileControlsInRequest profileControlsInRequestModel = new ProfileControlsInRequest.Builder()
      .controlLibraryId("testString")
      .controlId("testString")
      .build();
    assertEquals(profileControlsInRequestModel.controlLibraryId(), "testString");
    assertEquals(profileControlsInRequestModel.controlId(), "testString");

    DefaultParameters defaultParametersModel = new DefaultParameters.Builder()
      .assessmentType("testString")
      .assessmentId("testString")
      .parameterName("testString")
      .parameterDefaultValue("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .build();
    assertEquals(defaultParametersModel.assessmentType(), "testString");
    assertEquals(defaultParametersModel.assessmentId(), "testString");
    assertEquals(defaultParametersModel.parameterName(), "testString");
    assertEquals(defaultParametersModel.parameterDefaultValue(), "testString");
    assertEquals(defaultParametersModel.parameterDisplayName(), "testString");
    assertEquals(defaultParametersModel.parameterType(), "numeric");

    CreateProfileOptions createProfileOptionsModel = new CreateProfileOptions.Builder()
      .instanceId("testString")
      .profileName("testString")
      .profileDescription("testString")
      .profileType("predefined")
      .profileVersion("testString")
      .latest(true)
      .versionGroupLabel("testString")
      .controls(java.util.Arrays.asList(profileControlsInRequestModel))
      .defaultParameters(java.util.Arrays.asList(defaultParametersModel))
      .transactionId("testString")
      .build();
    assertEquals(createProfileOptionsModel.instanceId(), "testString");
    assertEquals(createProfileOptionsModel.profileName(), "testString");
    assertEquals(createProfileOptionsModel.profileDescription(), "testString");
    assertEquals(createProfileOptionsModel.profileType(), "predefined");
    assertEquals(createProfileOptionsModel.profileVersion(), "testString");
    assertEquals(createProfileOptionsModel.latest(), Boolean.valueOf(true));
    assertEquals(createProfileOptionsModel.versionGroupLabel(), "testString");
    assertEquals(createProfileOptionsModel.controls(), java.util.Arrays.asList(profileControlsInRequestModel));
    assertEquals(createProfileOptionsModel.defaultParameters(), java.util.Arrays.asList(defaultParametersModel));
    assertEquals(createProfileOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateProfileOptionsError() throws Throwable {
    new CreateProfileOptions.Builder().build();
  }

}