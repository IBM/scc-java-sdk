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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DefaultParameters;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileControlsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
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
    ProfileControlsPrototype profileControlsPrototypeModel = new ProfileControlsPrototype.Builder()
      .controlLibraryId("testString")
      .controlId("testString")
      .build();
    assertEquals(profileControlsPrototypeModel.controlLibraryId(), "testString");
    assertEquals(profileControlsPrototypeModel.controlId(), "testString");

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

    CreateProfileOptions createProfileOptionsModel = new CreateProfileOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .profileName("Sample Profile")
      .profileVersion("0.0.1")
      .controls(java.util.Arrays.asList(profileControlsPrototypeModel))
      .defaultParameters(java.util.Arrays.asList(defaultParametersModel))
      .profileDescription("This is a sample profile")
      .latest(true)
      .versionGroupLabel("testString")
      .accountId("testString")
      .build();
    assertEquals(createProfileOptionsModel.instanceId(), "acd7032c-15a3-484f-bf5b-67d41534d940");
    assertEquals(createProfileOptionsModel.profileName(), "Sample Profile");
    assertEquals(createProfileOptionsModel.profileVersion(), "0.0.1");
    assertEquals(createProfileOptionsModel.controls(), java.util.Arrays.asList(profileControlsPrototypeModel));
    assertEquals(createProfileOptionsModel.defaultParameters(), java.util.Arrays.asList(defaultParametersModel));
    assertEquals(createProfileOptionsModel.profileDescription(), "This is a sample profile");
    assertEquals(createProfileOptionsModel.latest(), Boolean.valueOf(true));
    assertEquals(createProfileOptionsModel.versionGroupLabel(), "testString");
    assertEquals(createProfileOptionsModel.accountId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateProfileOptionsError() throws Throwable {
    new CreateProfileOptions.Builder().build();
  }

}