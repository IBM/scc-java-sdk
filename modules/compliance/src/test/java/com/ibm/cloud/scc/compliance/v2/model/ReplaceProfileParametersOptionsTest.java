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

import com.ibm.cloud.scc.compliance.v2.model.DefaultParameters;
import com.ibm.cloud.scc.compliance.v2.model.ReplaceProfileParametersOptions;
import com.ibm.cloud.scc.compliance.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceProfileParametersOptions model.
 */
public class ReplaceProfileParametersOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceProfileParametersOptions() throws Throwable {
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

    ReplaceProfileParametersOptions replaceProfileParametersOptionsModel = new ReplaceProfileParametersOptions.Builder()
      .profilesId("testString")
      .instanceId("testString")
      .id("testString")
      .defaultParameters(java.util.Arrays.asList(defaultParametersModel))
      .transactionId("testString")
      .build();
    assertEquals(replaceProfileParametersOptionsModel.profilesId(), "testString");
    assertEquals(replaceProfileParametersOptionsModel.instanceId(), "testString");
    assertEquals(replaceProfileParametersOptionsModel.id(), "testString");
    assertEquals(replaceProfileParametersOptionsModel.defaultParameters(), java.util.Arrays.asList(defaultParametersModel));
    assertEquals(replaceProfileParametersOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceProfileParametersOptionsError() throws Throwable {
    new ReplaceProfileParametersOptions.Builder().build();
  }

}