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

import com.ibm.cloud.scc.findings.v1.model.Context;
import com.ibm.cloud.scc.findings.v1.model.CreateOccurrenceOptions;
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
 * Unit test class for the CreateOccurrenceOptions model.
 */
public class CreateOccurrenceOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateOccurrenceOptions() throws Throwable {
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

    CreateOccurrenceOptions createOccurrenceOptionsModel = new CreateOccurrenceOptions.Builder()
      .accountId("testString")
      .providerId("testString")
      .noteName("testString")
      .kind("FINDING")
      .id("testString")
      .resourceUrl("testString")
      .remediation("testString")
      .context(contextModel)
      .finding(findingModel)
      .kpi(kpiModel)
      .referenceData(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .replaceIfExists(true)
      .transactionId("testString")
      .build();
    assertEquals(createOccurrenceOptionsModel.accountId(), "testString");
    assertEquals(createOccurrenceOptionsModel.providerId(), "testString");
    assertEquals(createOccurrenceOptionsModel.noteName(), "testString");
    assertEquals(createOccurrenceOptionsModel.kind(), "FINDING");
    assertEquals(createOccurrenceOptionsModel.id(), "testString");
    assertEquals(createOccurrenceOptionsModel.resourceUrl(), "testString");
    assertEquals(createOccurrenceOptionsModel.remediation(), "testString");
    assertEquals(createOccurrenceOptionsModel.context(), contextModel);
    assertEquals(createOccurrenceOptionsModel.finding(), findingModel);
    assertEquals(createOccurrenceOptionsModel.kpi(), kpiModel);
    assertEquals(createOccurrenceOptionsModel.referenceData(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });
    assertEquals(createOccurrenceOptionsModel.replaceIfExists(), Boolean.valueOf(true));
    assertEquals(createOccurrenceOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateOccurrenceOptionsError() throws Throwable {
    new CreateOccurrenceOptions.Builder().build();
  }

}