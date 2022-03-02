/*
 * (C) Copyright IBM Corp. 2022.
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

package com.ibm.cloud.scc.addon_mgr.v1.model;

import com.ibm.cloud.scc.addon_mgr.v1.model.CosDetailsV2CosDetailsItem;
import com.ibm.cloud.scc.addon_mgr.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CosDetailsV2CosDetailsItem model.
 */
public class CosDetailsV2CosDetailsItemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCosDetailsV2CosDetailsItem() throws Throwable {
    CosDetailsV2CosDetailsItem cosDetailsV2CosDetailsItemModel = new CosDetailsV2CosDetailsItem.Builder()
      .cosInstance("testString")
      .bucketName("testString")
      .description("testString")
      .type("network-insights")
      .cosBucketUrl("testString")
      .build();
    assertEquals(cosDetailsV2CosDetailsItemModel.cosInstance(), "testString");
    assertEquals(cosDetailsV2CosDetailsItemModel.bucketName(), "testString");
    assertEquals(cosDetailsV2CosDetailsItemModel.description(), "testString");
    assertEquals(cosDetailsV2CosDetailsItemModel.type(), "network-insights");
    assertEquals(cosDetailsV2CosDetailsItemModel.cosBucketUrl(), "testString");

    String json = TestUtilities.serialize(cosDetailsV2CosDetailsItemModel);

    CosDetailsV2CosDetailsItem cosDetailsV2CosDetailsItemModelNew = TestUtilities.deserialize(json, CosDetailsV2CosDetailsItem.class);
    assertTrue(cosDetailsV2CosDetailsItemModelNew instanceof CosDetailsV2CosDetailsItem);
    assertEquals(cosDetailsV2CosDetailsItemModelNew.cosInstance(), "testString");
    assertEquals(cosDetailsV2CosDetailsItemModelNew.bucketName(), "testString");
    assertEquals(cosDetailsV2CosDetailsItemModelNew.description(), "testString");
    assertEquals(cosDetailsV2CosDetailsItemModelNew.type(), "network-insights");
    assertEquals(cosDetailsV2CosDetailsItemModelNew.cosBucketUrl(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCosDetailsV2CosDetailsItemError() throws Throwable {
    new CosDetailsV2CosDetailsItem.Builder().build();
  }

}