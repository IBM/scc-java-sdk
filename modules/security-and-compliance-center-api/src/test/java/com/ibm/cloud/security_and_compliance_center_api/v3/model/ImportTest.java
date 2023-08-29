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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Import;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Parameter;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Import model.
 */
public class ImportTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testImport() throws Throwable {
    Parameter parameterModel = new Parameter.Builder()
      .name("name")
      .displayName("display_name")
      .description("description")
      .type("string")
      .build();
    assertEquals(parameterModel.name(), "name");
    assertEquals(parameterModel.displayName(), "display_name");
    assertEquals(parameterModel.description(), "description");
    assertEquals(parameterModel.type(), "string");

    Import importModel = new Import.Builder()
      .parameters(java.util.Arrays.asList(parameterModel))
      .build();
    assertEquals(importModel.parameters(), java.util.Arrays.asList(parameterModel));

    String json = TestUtilities.serialize(importModel);

    Import importModelNew = TestUtilities.deserialize(json, Import.class);
    assertTrue(importModelNew instanceof Import);
  }
}