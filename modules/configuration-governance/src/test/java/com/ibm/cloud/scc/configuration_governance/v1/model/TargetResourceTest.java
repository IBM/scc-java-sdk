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

package com.ibm.cloud.scc.configuration_governance.v1.model;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.scc.configuration_governance.v1.model.TargetResource;
import com.ibm.cloud.scc.configuration_governance.v1.model.TargetResourceAdditionalTargetAttributesItem;
import com.ibm.cloud.scc.configuration_governance.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the TargetResource model.
 */
public class TargetResourceTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTargetResource() throws Throwable {
    TargetResourceAdditionalTargetAttributesItem targetResourceAdditionalTargetAttributesItemModel = new TargetResourceAdditionalTargetAttributesItem.Builder()
      .name("resource_id")
      .value("81f3db5e-f9db-4c46-9de3-a4a76e66adbf")
      .operator("string_equals")
      .build();
    assertEquals(targetResourceAdditionalTargetAttributesItemModel.name(), "resource_id");
    assertEquals(targetResourceAdditionalTargetAttributesItemModel.value(), "81f3db5e-f9db-4c46-9de3-a4a76e66adbf");
    assertEquals(targetResourceAdditionalTargetAttributesItemModel.operator(), "string_equals");

    TargetResource targetResourceModel = new TargetResource.Builder()
      .serviceName("cloud-object-storage")
      .resourceKind("bucket")
      .additionalTargetAttributes(new java.util.ArrayList<TargetResourceAdditionalTargetAttributesItem>(java.util.Arrays.asList(targetResourceAdditionalTargetAttributesItemModel)))
      .build();
    assertEquals(targetResourceModel.serviceName(), "cloud-object-storage");
    assertEquals(targetResourceModel.resourceKind(), "bucket");
    assertEquals(targetResourceModel.additionalTargetAttributes(), new java.util.ArrayList<TargetResourceAdditionalTargetAttributesItem>(java.util.Arrays.asList(targetResourceAdditionalTargetAttributesItemModel)));

    String json = TestUtilities.serialize(targetResourceModel);

    TargetResource targetResourceModelNew = TestUtilities.deserialize(json, TargetResource.class);
    assertTrue(targetResourceModelNew instanceof TargetResource);
    assertEquals(targetResourceModelNew.serviceName(), "cloud-object-storage");
    assertEquals(targetResourceModelNew.resourceKind(), "bucket");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTargetResourceError() throws Throwable {
    new TargetResource.Builder().build();
  }

}