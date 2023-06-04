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

import com.ibm.cloud.scc.compliance.v2.model.GetAllProfilesRespBody;
import com.ibm.cloud.scc.compliance.v2.model.ListProfilesResponseStructure;
import com.ibm.cloud.scc.compliance.v2.model.PageRefFirst;
import com.ibm.cloud.scc.compliance.v2.model.PageRefNext;
import com.ibm.cloud.scc.compliance.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetAllProfilesRespBody model.
 */
public class GetAllProfilesRespBodyTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetAllProfilesRespBody() throws Throwable {
    GetAllProfilesRespBody getAllProfilesRespBodyModel = new GetAllProfilesRespBody();
    assertNull(getAllProfilesRespBodyModel.getTotalCount());
    assertNull(getAllProfilesRespBodyModel.getLimit());
    assertNull(getAllProfilesRespBodyModel.getFirst());
    assertNull(getAllProfilesRespBodyModel.getNext());
    assertNull(getAllProfilesRespBodyModel.getProfiles());
  }
}