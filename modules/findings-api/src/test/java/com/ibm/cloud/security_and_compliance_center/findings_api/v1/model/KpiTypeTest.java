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
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.KpiType;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the KpiType model.
 */
public class KpiTypeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testKpiType() throws Throwable {
    KpiType kpiTypeModel = new KpiType.Builder()
      .aggregationType("SUM")
      .build();
    assertEquals(kpiTypeModel.aggregationType(), "SUM");

    String json = TestUtilities.serialize(kpiTypeModel);

    KpiType kpiTypeModelNew = TestUtilities.deserialize(json, KpiType.class);
    assertTrue(kpiTypeModelNew instanceof KpiType);
    assertEquals(kpiTypeModelNew.aggregationType(), "SUM");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testKpiTypeError() throws Throwable {
    new KpiType.Builder().build();
  }

}