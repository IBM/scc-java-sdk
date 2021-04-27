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

package com.ibm.cloud.scc.findings_api.v1.model;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.scc.findings_api.v1.model.ValueTypeFindingCountValueType;
import com.ibm.cloud.scc.findings_api.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ValueTypeFindingCountValueType model.
 */
public class ValueTypeFindingCountValueTypeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testValueTypeFindingCountValueType() throws Throwable {
    ValueTypeFindingCountValueType valueTypeFindingCountValueTypeModel = new ValueTypeFindingCountValueType.Builder()
      .kind("FINDING_COUNT")
      .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .text("testString")
      .build();
    assertEquals(valueTypeFindingCountValueTypeModel.kind(), "FINDING_COUNT");
    assertEquals(valueTypeFindingCountValueTypeModel.findingNoteNames(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(valueTypeFindingCountValueTypeModel.text(), "testString");

    String json = TestUtilities.serialize(valueTypeFindingCountValueTypeModel);

    ValueTypeFindingCountValueType valueTypeFindingCountValueTypeModelNew = TestUtilities.deserialize(json, ValueTypeFindingCountValueType.class);
    assertTrue(valueTypeFindingCountValueTypeModelNew instanceof ValueTypeFindingCountValueType);
    assertEquals(valueTypeFindingCountValueTypeModelNew.kind(), "FINDING_COUNT");
    assertEquals(valueTypeFindingCountValueTypeModelNew.text(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testValueTypeFindingCountValueTypeError() throws Throwable {
    new ValueTypeFindingCountValueType.Builder().build();
  }

}