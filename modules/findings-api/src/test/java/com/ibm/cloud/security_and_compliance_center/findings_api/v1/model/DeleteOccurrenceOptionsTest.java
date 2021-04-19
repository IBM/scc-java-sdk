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

package com.ibm.cloud.security_and_compliance_center.findings_api.v1.model;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.DeleteOccurrenceOptions;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DeleteOccurrenceOptions model.
 */
public class DeleteOccurrenceOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeleteOccurrenceOptions() throws Throwable {
    DeleteOccurrenceOptions deleteOccurrenceOptionsModel = new DeleteOccurrenceOptions.Builder()
      .accountId("testString")
      .providerId("testString")
      .occurrenceId("testString")
      .transactionId("testString")
      .build();
    assertEquals(deleteOccurrenceOptionsModel.accountId(), "testString");
    assertEquals(deleteOccurrenceOptionsModel.providerId(), "testString");
    assertEquals(deleteOccurrenceOptionsModel.occurrenceId(), "testString");
    assertEquals(deleteOccurrenceOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteOccurrenceOptionsError() throws Throwable {
    new DeleteOccurrenceOptions.Builder().build();
  }

}