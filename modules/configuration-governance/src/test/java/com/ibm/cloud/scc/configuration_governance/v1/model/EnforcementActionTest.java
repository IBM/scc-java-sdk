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

package com.ibm.cloud.scc.configuration_governance.v1.model;

import com.ibm.cloud.scc.configuration_governance.v1.model.EnforcementAction;
import com.ibm.cloud.scc.configuration_governance.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the EnforcementAction model.
 */
public class EnforcementActionTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testEnforcementAction() throws Throwable {
    EnforcementAction enforcementActionModel = new EnforcementAction.Builder()
      .action("audit_log")
      .build();
    assertEquals(enforcementActionModel.action(), "audit_log");

    String json = TestUtilities.serialize(enforcementActionModel);

    EnforcementAction enforcementActionModelNew = TestUtilities.deserialize(json, EnforcementAction.class);
    assertTrue(enforcementActionModelNew instanceof EnforcementAction);
    assertEquals(enforcementActionModelNew.action(), "audit_log");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testEnforcementActionError() throws Throwable {
    new EnforcementAction.Builder().build();
  }

}