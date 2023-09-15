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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigItemsRequiredConfigOrDepth1;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RequiredConfigItemsRequiredConfigOrDepth1 model.
 */
public class RequiredConfigItemsRequiredConfigOrDepth1Test {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRequiredConfigItemsRequiredConfigOrDepth1() throws Throwable {
    RequiredConfigBase requiredConfigBaseModel = new RequiredConfigBase.Builder()
      .description("testString")
      .property("testString")
      .operator("string_equals")
      .value("testString")
      .build();
    assertEquals(requiredConfigBaseModel.description(), "testString");
    assertEquals(requiredConfigBaseModel.property(), "testString");
    assertEquals(requiredConfigBaseModel.operator(), "string_equals");
    assertEquals(requiredConfigBaseModel.value(), "testString");

    RequiredConfigItemsRequiredConfigOrDepth1 requiredConfigItemsRequiredConfigOrDepth1Model = new RequiredConfigItemsRequiredConfigOrDepth1.Builder()
      .description("testString")
      .or(java.util.Arrays.asList(requiredConfigBaseModel))
      .build();
    assertEquals(requiredConfigItemsRequiredConfigOrDepth1Model.description(), "testString");
    assertEquals(requiredConfigItemsRequiredConfigOrDepth1Model.or(), java.util.Arrays.asList(requiredConfigBaseModel));

    String json = TestUtilities.serialize(requiredConfigItemsRequiredConfigOrDepth1Model);

    RequiredConfigItemsRequiredConfigOrDepth1 requiredConfigItemsRequiredConfigOrDepth1ModelNew = TestUtilities.deserialize(json, RequiredConfigItemsRequiredConfigOrDepth1.class);
    assertTrue(requiredConfigItemsRequiredConfigOrDepth1ModelNew instanceof RequiredConfigItemsRequiredConfigOrDepth1);
    assertEquals(requiredConfigItemsRequiredConfigOrDepth1ModelNew.description(), "testString");
  }
}