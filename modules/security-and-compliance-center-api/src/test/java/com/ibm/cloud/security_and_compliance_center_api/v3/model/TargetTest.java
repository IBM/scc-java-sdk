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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AdditionalTargetAttribute;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Target;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Target model.
 */
public class TargetTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTarget() throws Throwable {
    AdditionalTargetAttribute additionalTargetAttributeModel = new AdditionalTargetAttribute.Builder()
      .name("name")
      .operator("string_equals")
      .value("value")
      .build();
    assertEquals(additionalTargetAttributeModel.name(), "name");
    assertEquals(additionalTargetAttributeModel.operator(), "string_equals");
    assertEquals(additionalTargetAttributeModel.value(), "value");

    Target targetModel = new Target.Builder()
      .serviceName("testString")
      .serviceDisplayName("testString")
      .resourceKind("testString")
      .additionalTargetAttributes(java.util.Arrays.asList(additionalTargetAttributeModel))
      .build();
    assertEquals(targetModel.serviceName(), "testString");
    assertEquals(targetModel.serviceDisplayName(), "testString");
    assertEquals(targetModel.resourceKind(), "testString");
    assertEquals(targetModel.additionalTargetAttributes(), java.util.Arrays.asList(additionalTargetAttributeModel));

    String json = TestUtilities.serialize(targetModel);

    Target targetModelNew = TestUtilities.deserialize(json, Target.class);
    assertTrue(targetModelNew instanceof Target);
    assertEquals(targetModelNew.serviceName(), "testString");
    assertEquals(targetModelNew.serviceDisplayName(), "testString");
    assertEquals(targetModelNew.resourceKind(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTargetError() throws Throwable {
    new Target.Builder().build();
  }

}