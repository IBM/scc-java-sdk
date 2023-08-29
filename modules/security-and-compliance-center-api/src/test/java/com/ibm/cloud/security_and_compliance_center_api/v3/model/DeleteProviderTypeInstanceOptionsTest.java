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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DeleteProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DeleteProviderTypeInstanceOptions model.
 */
public class DeleteProviderTypeInstanceOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeleteProviderTypeInstanceOptions() throws Throwable {
    DeleteProviderTypeInstanceOptions deleteProviderTypeInstanceOptionsModel = new DeleteProviderTypeInstanceOptions.Builder()
      .providerTypeId("testString")
      .providerTypeInstanceId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();
    assertEquals(deleteProviderTypeInstanceOptionsModel.providerTypeId(), "testString");
    assertEquals(deleteProviderTypeInstanceOptionsModel.providerTypeInstanceId(), "testString");
    assertEquals(deleteProviderTypeInstanceOptionsModel.xCorrelationId(), "testString");
    assertEquals(deleteProviderTypeInstanceOptionsModel.xRequestId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteProviderTypeInstanceOptionsError() throws Throwable {
    new DeleteProviderTypeInstanceOptions.Builder().build();
  }

}