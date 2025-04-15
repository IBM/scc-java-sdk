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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListScopesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListScopesOptions model.
 */
public class ListScopesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListScopesOptions() throws Throwable {
    ListScopesOptions listScopesOptionsModel = new ListScopesOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .limit(Long.valueOf("50"))
      .start("testString")
      .name("testString")
      .description("testString")
      .environment("testString")
      .build();
    assertEquals(listScopesOptionsModel.instanceId(), "acd7032c-15a3-484f-bf5b-67d41534d940");
    assertEquals(listScopesOptionsModel.limit(), Long.valueOf("50"));
    assertEquals(listScopesOptionsModel.start(), "testString");
    assertEquals(listScopesOptionsModel.name(), "testString");
    assertEquals(listScopesOptionsModel.description(), "testString");
    assertEquals(listScopesOptionsModel.environment(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListScopesOptionsError() throws Throwable {
    new ListScopesOptions.Builder().build();
  }

}