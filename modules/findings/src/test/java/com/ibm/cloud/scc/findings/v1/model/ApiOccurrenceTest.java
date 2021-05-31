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

import com.ibm.cloud.scc.findings.v1.model.ApiOccurrence;
import com.ibm.cloud.scc.findings.v1.model.Context;
import com.ibm.cloud.scc.findings.v1.model.DataTransferred;
import com.ibm.cloud.scc.findings.v1.model.Finding;
import com.ibm.cloud.scc.findings.v1.model.Kpi;
import com.ibm.cloud.scc.findings.v1.model.NetworkConnection;
import com.ibm.cloud.scc.findings.v1.model.RemediationStep;
import com.ibm.cloud.scc.findings.v1.model.SocketAddress;
import com.ibm.cloud.scc.findings.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ApiOccurrence model.
 */
public class ApiOccurrenceTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testApiOccurrence() throws Throwable {
    Context contextModel = new Context.Builder()
      .region("testString")
      .resourceCrn("testString")
      .resourceId("testString")
      .resourceName("testString")
      .resourceType("testString")
      .serviceCrn("testString")
      .serviceName("testString")
      .environmentName("testString")
      .componentName("testString")
      .toolchainId("testString")
      .build();
    assertEquals(contextModel.region(), "testString");
    assertEquals(contextModel.resourceCrn(), "testString");
    assertEquals(contextModel.resourceId(), "testString");
    assertEquals(contextModel.resourceName(), "testString");
    assertEquals(contextModel.resourceType(), "testString");
    assertEquals(contextModel.serviceCrn(), "testString");
    assertEquals(contextModel.serviceName(), "testString");
    assertEquals(contextModel.environmentName(), "testString");
    assertEquals(contextModel.componentName(), "testString");
    assertEquals(contextModel.toolchainId(), "testString");

    RemediationStep remediationStepModel = new RemediationStep.Builder()
      .title("testString")
      .url("testString")
      .build();
    assertEquals(remediationStepModel.title(), "testString");
    assertEquals(remediationStepModel.url(), "testString");

    SocketAddress socketAddressModel = new SocketAddress.Builder()
      .address("testString")
      .port(Long.valueOf("26"))
      .build();
    assertEquals(socketAddressModel.address(), "testString");
    assertEquals(socketAddressModel.port(), Long.valueOf("26"));

    NetworkConnection networkConnectionModel = new NetworkConnection.Builder()
      .direction("testString")
      .protocol("testString")
      .client(socketAddressModel)
      .server(socketAddressModel)
      .build();
    assertEquals(networkConnectionModel.direction(), "testString");
    assertEquals(networkConnectionModel.protocol(), "testString");
    assertEquals(networkConnectionModel.client(), socketAddressModel);
    assertEquals(networkConnectionModel.server(), socketAddressModel);

    DataTransferred dataTransferredModel = new DataTransferred.Builder()
      .clientBytes(Long.valueOf("26"))
      .serverBytes(Long.valueOf("26"))
      .clientPackets(Long.valueOf("26"))
      .serverPackets(Long.valueOf("26"))
      .build();
    assertEquals(dataTransferredModel.clientBytes(), Long.valueOf("26"));
    assertEquals(dataTransferredModel.serverBytes(), Long.valueOf("26"));
    assertEquals(dataTransferredModel.clientPackets(), Long.valueOf("26"));
    assertEquals(dataTransferredModel.serverPackets(), Long.valueOf("26"));

    Finding findingModel = new Finding.Builder()
      .severity("LOW")
      .certainty("LOW")
      .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
      .networkConnection(networkConnectionModel)
      .dataTransferred(dataTransferredModel)
      .build();
    assertEquals(findingModel.severity(), "LOW");
    assertEquals(findingModel.certainty(), "LOW");
    assertEquals(findingModel.nextSteps(), new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)));
    assertEquals(findingModel.networkConnection(), networkConnectionModel);
    assertEquals(findingModel.dataTransferred(), dataTransferredModel);

    Kpi kpiModel = new Kpi.Builder()
      .value(Double.valueOf("72.5"))
      .total(Double.valueOf("72.5"))
      .build();
    assertEquals(kpiModel.value(), Double.valueOf("72.5"));
    assertEquals(kpiModel.total(), Double.valueOf("72.5"));

    ApiOccurrence apiOccurrenceModel = new ApiOccurrence.Builder()
      .resourceUrl("testString")
      .noteName("testString")
      .kind("FINDING")
      .remediation("testString")
      .id("testString")
      .context(contextModel)
      .finding(findingModel)
      .kpi(kpiModel)
      .referenceData(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .build();
    assertEquals(apiOccurrenceModel.resourceUrl(), "testString");
    assertEquals(apiOccurrenceModel.noteName(), "testString");
    assertEquals(apiOccurrenceModel.kind(), "FINDING");
    assertEquals(apiOccurrenceModel.remediation(), "testString");
    assertEquals(apiOccurrenceModel.id(), "testString");
    assertEquals(apiOccurrenceModel.context(), contextModel);
    assertEquals(apiOccurrenceModel.finding(), findingModel);
    assertEquals(apiOccurrenceModel.kpi(), kpiModel);
    assertEquals(apiOccurrenceModel.referenceData(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });

    String json = TestUtilities.serialize(apiOccurrenceModel);

    ApiOccurrence apiOccurrenceModelNew = TestUtilities.deserialize(json, ApiOccurrence.class);
    assertTrue(apiOccurrenceModelNew instanceof ApiOccurrence);
    assertEquals(apiOccurrenceModelNew.resourceUrl(), "testString");
    assertEquals(apiOccurrenceModelNew.noteName(), "testString");
    assertEquals(apiOccurrenceModelNew.kind(), "FINDING");
    assertEquals(apiOccurrenceModelNew.remediation(), "testString");
    assertEquals(apiOccurrenceModelNew.id(), "testString");
    assertEquals(apiOccurrenceModelNew.context().toString(), contextModel.toString());
    assertEquals(apiOccurrenceModelNew.finding().toString(), findingModel.toString());
    assertEquals(apiOccurrenceModelNew.kpi().toString(), kpiModel.toString());
    assertEquals(apiOccurrenceModelNew.referenceData().toString(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } }.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testApiOccurrenceError() throws Throwable {
    new ApiOccurrence.Builder().build();
  }

}