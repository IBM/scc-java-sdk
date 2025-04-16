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
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ConditionItemConditionBase model.
 */
public class ConditionItemConditionBaseTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testConditionItemConditionBase() throws Throwable {
    ConditionItemConditionBase conditionItemConditionBaseModel = new ConditionItemConditionBase.Builder()
      .description("testString")
      .property("testString")
      .operator("string_equals")
      .value("testString")
      .build();
    assertEquals(conditionItemConditionBaseModel.description(), "testString");
    assertEquals(conditionItemConditionBaseModel.property(), "testString");
    assertEquals(conditionItemConditionBaseModel.operator(), "string_equals");
    assertEquals(conditionItemConditionBaseModel.value(), "testString");

    String json = TestUtilities.serialize(conditionItemConditionBaseModel);

    ConditionItemConditionBase conditionItemConditionBaseModelNew = TestUtilities.deserialize(json, ConditionItemConditionBase.class);
    assertTrue(conditionItemConditionBaseModelNew instanceof ConditionItemConditionBase);
    assertEquals(conditionItemConditionBaseModelNew.description(), "testString");
    assertEquals(conditionItemConditionBaseModelNew.property(), "testString");
    assertEquals(conditionItemConditionBaseModelNew.operator(), "string_equals");
    assertEquals(conditionItemConditionBaseModelNew.value(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConditionItemConditionBaseError() throws Throwable {
    new ConditionItemConditionBase.Builder().build();
  }

}