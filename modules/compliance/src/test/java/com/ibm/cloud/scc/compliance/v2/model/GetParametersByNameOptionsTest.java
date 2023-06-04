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

import com.ibm.cloud.scc.compliance.v2.model.GetParametersByNameOptions;
import com.ibm.cloud.scc.compliance.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetParametersByNameOptions model.
 */
public class GetParametersByNameOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetParametersByNameOptions() throws Throwable {
    GetParametersByNameOptions getParametersByNameOptionsModel = new GetParametersByNameOptions.Builder()
      .profilesId("testString")
      .attachmentId("testString")
      .parameterName("testString")
      .instanceId("testString")
      .transactionId("testString")
      .build();
    assertEquals(getParametersByNameOptionsModel.profilesId(), "testString");
    assertEquals(getParametersByNameOptionsModel.attachmentId(), "testString");
    assertEquals(getParametersByNameOptionsModel.parameterName(), "testString");
    assertEquals(getParametersByNameOptionsModel.instanceId(), "testString");
    assertEquals(getParametersByNameOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetParametersByNameOptionsError() throws Throwable {
    new GetParametersByNameOptions.Builder().build();
  }

}