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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopePropertyScopeAny;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ScopePropertyScopeAny model.
 */
public class ScopePropertyScopeAnyTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testScopePropertyScopeAny() throws Throwable {
    ScopePropertyScopeAny scopePropertyScopeAnyModel = new ScopePropertyScopeAny.Builder()
      .name("testString")
      .value("testString")
      .build();
    assertEquals(scopePropertyScopeAnyModel.name(), "testString");
    assertEquals(scopePropertyScopeAnyModel.value(), "testString");

    String json = TestUtilities.serialize(scopePropertyScopeAnyModel);

    ScopePropertyScopeAny scopePropertyScopeAnyModelNew = TestUtilities.deserialize(json, ScopePropertyScopeAny.class);
    assertTrue(scopePropertyScopeAnyModelNew instanceof ScopePropertyScopeAny);
    assertEquals(scopePropertyScopeAnyModelNew.name(), "testString");
    assertEquals(scopePropertyScopeAnyModelNew.value(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testScopePropertyScopeAnyError() throws Throwable {
    new ScopePropertyScopeAny.Builder().build();
  }

}