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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateProviderTypeInstanceOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateProviderTypeInstanceOptions model.
 */
public class CreateProviderTypeInstanceOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateProviderTypeInstanceOptions() throws Throwable {
    CreateProviderTypeInstanceOptions createProviderTypeInstanceOptionsModel = new CreateProviderTypeInstanceOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .providerTypeId("3e25966275dccfa2c3a34786919c5af7")
      .name("workload-protection-instance-1")
      .attributes(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();
    assertEquals(createProviderTypeInstanceOptionsModel.instanceId(), "acd7032c-15a3-484f-bf5b-67d41534d940");
    assertEquals(createProviderTypeInstanceOptionsModel.providerTypeId(), "3e25966275dccfa2c3a34786919c5af7");
    assertEquals(createProviderTypeInstanceOptionsModel.name(), "workload-protection-instance-1");
    assertEquals(createProviderTypeInstanceOptionsModel.attributes(), java.util.Collections.singletonMap("anyKey", "anyValue"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateProviderTypeInstanceOptionsError() throws Throwable {
    new CreateProviderTypeInstanceOptions.Builder().build();
  }

}