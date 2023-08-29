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
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ObjectStorage;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ObjectStorage model.
 */
public class ObjectStorageTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testObjectStorage() throws Throwable {
    ObjectStorage objectStorageModel = new ObjectStorage.Builder()
      .instanceCrn("testString")
      .bucket("testString")
      .bucketLocation("testString")
      .bucketEndpoint("testString")
      .updatedOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .build();
    assertEquals(objectStorageModel.instanceCrn(), "testString");
    assertEquals(objectStorageModel.bucket(), "testString");
    assertEquals(objectStorageModel.bucketLocation(), "testString");
    assertEquals(objectStorageModel.bucketEndpoint(), "testString");
    assertEquals(objectStorageModel.updatedOn(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));

    String json = TestUtilities.serialize(objectStorageModel);

    ObjectStorage objectStorageModelNew = TestUtilities.deserialize(json, ObjectStorage.class);
    assertTrue(objectStorageModelNew instanceof ObjectStorage);
    assertEquals(objectStorageModelNew.instanceCrn(), "testString");
    assertEquals(objectStorageModelNew.bucket(), "testString");
    assertEquals(objectStorageModelNew.bucketLocation(), "testString");
    assertEquals(objectStorageModelNew.bucketEndpoint(), "testString");
    assertEquals(objectStorageModelNew.updatedOn(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
  }
}