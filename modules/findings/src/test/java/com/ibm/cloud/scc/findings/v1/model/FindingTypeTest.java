/*
 * (C) Copyright IBM Corp. 2021.
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

package com.ibm.cloud.scc.findings.v1.model;

import com.ibm.cloud.scc.findings.v1.model.FindingType;
import com.ibm.cloud.scc.findings.v1.model.RemediationStep;
import com.ibm.cloud.scc.findings.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the FindingType model.
 */
public class FindingTypeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testFindingType() throws Throwable {
    RemediationStep remediationStepModel = new RemediationStep.Builder()
      .title("testString")
      .url("testString")
      .build();
    assertEquals(remediationStepModel.title(), "testString");
    assertEquals(remediationStepModel.url(), "testString");

    FindingType findingTypeModel = new FindingType.Builder()
      .severity("LOW")
      .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
      .build();
    assertEquals(findingTypeModel.severity(), "LOW");
    assertEquals(findingTypeModel.nextSteps(), new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)));

    String json = TestUtilities.serialize(findingTypeModel);

    FindingType findingTypeModelNew = TestUtilities.deserialize(json, FindingType.class);
    assertTrue(findingTypeModelNew instanceof FindingType);
    assertEquals(findingTypeModelNew.severity(), "LOW");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testFindingTypeError() throws Throwable {
    new FindingType.Builder().build();
  }

}