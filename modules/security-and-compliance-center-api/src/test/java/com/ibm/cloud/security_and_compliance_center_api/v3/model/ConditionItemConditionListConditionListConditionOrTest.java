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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ConditionItemConditionBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ConditionItemConditionListConditionListConditionOr;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ConditionItemConditionListConditionListConditionOr model.
 */
public class ConditionItemConditionListConditionListConditionOrTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testConditionItemConditionListConditionListConditionOr() throws Throwable {
    ConditionItemConditionBase conditionItemModel = new ConditionItemConditionBase.Builder()
      .description("testString")
      .property("testString")
      .operator("string_equals")
      .value("testString")
      .build();
    assertEquals(conditionItemModel.description(), "testString");
    assertEquals(conditionItemModel.property(), "testString");
    assertEquals(conditionItemModel.operator(), "string_equals");
    assertEquals(conditionItemModel.value(), "testString");

    ConditionItemConditionListConditionListConditionOr conditionItemConditionListConditionListConditionOrModel = new ConditionItemConditionListConditionListConditionOr.Builder()
      .description("testString")
      .or(java.util.Arrays.asList(conditionItemModel))
      .build();
    assertEquals(conditionItemConditionListConditionListConditionOrModel.description(), "testString");
    assertEquals(conditionItemConditionListConditionListConditionOrModel.or(), java.util.Arrays.asList(conditionItemModel));

    String json = TestUtilities.serialize(conditionItemConditionListConditionListConditionOrModel);

    ConditionItemConditionListConditionListConditionOr conditionItemConditionListConditionListConditionOrModelNew = TestUtilities.deserialize(json, ConditionItemConditionListConditionListConditionOr.class);
    assertTrue(conditionItemConditionListConditionListConditionOrModelNew instanceof ConditionItemConditionListConditionListConditionOr);
    assertEquals(conditionItemConditionListConditionListConditionOrModelNew.description(), "testString");
  }
}