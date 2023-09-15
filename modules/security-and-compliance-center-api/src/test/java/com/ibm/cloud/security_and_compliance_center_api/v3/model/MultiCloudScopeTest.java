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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.MultiCloudScope;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PropertyItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the MultiCloudScope model.
 */
public class MultiCloudScopeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testMultiCloudScope() throws Throwable {
    PropertyItem propertyItemModel = new PropertyItem.Builder()
      .name("name")
      .value("value")
      .build();
    assertEquals(propertyItemModel.name(), "name");
    assertEquals(propertyItemModel.value(), "value");

    MultiCloudScope multiCloudScopeModel = new MultiCloudScope.Builder()
      .environment("testString")
      .xProperties(java.util.Arrays.asList(propertyItemModel))
      .build();
    assertEquals(multiCloudScopeModel.environment(), "testString");
    assertEquals(multiCloudScopeModel.xProperties(), java.util.Arrays.asList(propertyItemModel));

    String json = TestUtilities.serialize(multiCloudScopeModel);

    MultiCloudScope multiCloudScopeModelNew = TestUtilities.deserialize(json, MultiCloudScope.class);
    assertTrue(multiCloudScopeModelNew instanceof MultiCloudScope);
    assertEquals(multiCloudScopeModelNew.environment(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testMultiCloudScopeError() throws Throwable {
    new MultiCloudScope.Builder().build();
  }

}