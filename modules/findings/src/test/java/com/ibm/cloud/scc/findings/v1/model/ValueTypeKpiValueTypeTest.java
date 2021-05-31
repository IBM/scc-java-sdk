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

import com.ibm.cloud.scc.findings.v1.model.ValueTypeKpiValueType;
import com.ibm.cloud.scc.findings.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ValueTypeKpiValueType model.
 */
public class ValueTypeKpiValueTypeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testValueTypeKpiValueType() throws Throwable {
    ValueTypeKpiValueType valueTypeKpiValueTypeModel = new ValueTypeKpiValueType.Builder()
      .kind("KPI")
      .kpiNoteName("testString")
      .text("testString")
      .build();
    assertEquals(valueTypeKpiValueTypeModel.kind(), "KPI");
    assertEquals(valueTypeKpiValueTypeModel.kpiNoteName(), "testString");
    assertEquals(valueTypeKpiValueTypeModel.text(), "testString");

    String json = TestUtilities.serialize(valueTypeKpiValueTypeModel);

    ValueTypeKpiValueType valueTypeKpiValueTypeModelNew = TestUtilities.deserialize(json, ValueTypeKpiValueType.class);
    assertTrue(valueTypeKpiValueTypeModelNew instanceof ValueTypeKpiValueType);
    assertEquals(valueTypeKpiValueTypeModelNew.kind(), "KPI");
    assertEquals(valueTypeKpiValueTypeModelNew.kpiNoteName(), "testString");
    assertEquals(valueTypeKpiValueTypeModelNew.text(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testValueTypeKpiValueTypeError() throws Throwable {
    new ValueTypeKpiValueType.Builder().build();
  }

}