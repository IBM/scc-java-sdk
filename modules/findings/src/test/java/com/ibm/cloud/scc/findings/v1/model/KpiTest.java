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

package com.ibm.cloud.scc.findings.v1.model;

import com.ibm.cloud.scc.findings.v1.model.Kpi;
import com.ibm.cloud.scc.findings.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Kpi model.
 */
public class KpiTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testKpi() throws Throwable {
    Kpi kpiModel = new Kpi.Builder()
      .value(Double.valueOf("72.5"))
      .total(Double.valueOf("72.5"))
      .build();
    assertEquals(kpiModel.value(), Double.valueOf("72.5"));
    assertEquals(kpiModel.total(), Double.valueOf("72.5"));

    String json = TestUtilities.serialize(kpiModel);

    Kpi kpiModelNew = TestUtilities.deserialize(json, Kpi.class);
    assertTrue(kpiModelNew instanceof Kpi);
    assertEquals(kpiModelNew.value(), Double.valueOf("72.5"));
    assertEquals(kpiModelNew.total(), Double.valueOf("72.5"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testKpiError() throws Throwable {
    new Kpi.Builder().build();
  }

}