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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.MultiCloudScopePayloadByProperties;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopePropertyScopeAny;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the MultiCloudScopePayloadByProperties model.
 */
public class MultiCloudScopePayloadByPropertiesTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testMultiCloudScopePayloadByProperties() throws Throwable {
    ScopePropertyScopeAny scopePropertyModel = new ScopePropertyScopeAny.Builder()
      .name("testString")
      .value("testString")
      .build();
    assertEquals(scopePropertyModel.name(), "testString");
    assertEquals(scopePropertyModel.value(), "testString");

    MultiCloudScopePayloadByProperties multiCloudScopePayloadByPropertiesModel = new MultiCloudScopePayloadByProperties.Builder()
      .description("testString")
      .environment("testString")
      .xProperties(java.util.Arrays.asList(scopePropertyModel))
      .build();
    assertEquals(multiCloudScopePayloadByPropertiesModel.description(), "testString");
    assertEquals(multiCloudScopePayloadByPropertiesModel.environment(), "testString");
    assertEquals(multiCloudScopePayloadByPropertiesModel.xProperties(), java.util.Arrays.asList(scopePropertyModel));

    String json = TestUtilities.serialize(multiCloudScopePayloadByPropertiesModel);

    MultiCloudScopePayloadByProperties multiCloudScopePayloadByPropertiesModelNew = TestUtilities.deserialize(json, MultiCloudScopePayloadByProperties.class);
    assertTrue(multiCloudScopePayloadByPropertiesModelNew instanceof MultiCloudScopePayloadByProperties);
    assertEquals(multiCloudScopePayloadByPropertiesModelNew.description(), "testString");
    assertEquals(multiCloudScopePayloadByPropertiesModelNew.environment(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testMultiCloudScopePayloadByPropertiesError() throws Throwable {
    new MultiCloudScopePayloadByProperties.Builder().build();
  }

}