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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopePropertyExclusionItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopePropertyExclusions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ScopePropertyExclusions model.
 */
public class ScopePropertyExclusionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testScopePropertyExclusions() throws Throwable {
    ScopePropertyExclusionItem scopePropertyExclusionItemModel = new ScopePropertyExclusionItem.Builder()
      .scopeId("testString")
      .scopeType("enterprise")
      .build();
    assertEquals(scopePropertyExclusionItemModel.scopeId(), "testString");
    assertEquals(scopePropertyExclusionItemModel.scopeType(), "enterprise");

    ScopePropertyExclusions scopePropertyExclusionsModel = new ScopePropertyExclusions.Builder()
      .name("exclusions")
      .value(java.util.Arrays.asList(scopePropertyExclusionItemModel))
      .build();
    assertEquals(scopePropertyExclusionsModel.name(), "exclusions");
    assertEquals(scopePropertyExclusionsModel.value(), java.util.Arrays.asList(scopePropertyExclusionItemModel));

    String json = TestUtilities.serialize(scopePropertyExclusionsModel);

    ScopePropertyExclusions scopePropertyExclusionsModelNew = TestUtilities.deserialize(json, ScopePropertyExclusions.class);
    assertTrue(scopePropertyExclusionsModelNew instanceof ScopePropertyExclusions);
    assertEquals(scopePropertyExclusionsModelNew.name(), "exclusions");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testScopePropertyExclusionsError() throws Throwable {
    new ScopePropertyExclusions.Builder().build();
  }

}