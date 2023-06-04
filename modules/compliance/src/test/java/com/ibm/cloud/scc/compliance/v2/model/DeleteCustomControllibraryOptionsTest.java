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

package com.ibm.cloud.scc.compliance.v2.model;

import com.ibm.cloud.scc.compliance.v2.model.DeleteCustomControllibraryOptions;
import com.ibm.cloud.scc.compliance.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DeleteCustomControllibraryOptions model.
 */
public class DeleteCustomControllibraryOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeleteCustomControllibraryOptions() throws Throwable {
    DeleteCustomControllibraryOptions deleteCustomControllibraryOptionsModel = new DeleteCustomControllibraryOptions.Builder()
      .controlLibrariesId("testString")
      .instanceId("testString")
      .transactionId("testString")
      .build();
    assertEquals(deleteCustomControllibraryOptionsModel.controlLibrariesId(), "testString");
    assertEquals(deleteCustomControllibraryOptionsModel.instanceId(), "testString");
    assertEquals(deleteCustomControllibraryOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCustomControllibraryOptionsError() throws Throwable {
    new DeleteCustomControllibraryOptions.Builder().build();
  }

}