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

import com.ibm.cloud.scc.findings.v1.model.ApiNoteRelatedUrl;
import com.ibm.cloud.scc.findings.v1.model.Card;
import com.ibm.cloud.scc.findings.v1.model.CardElementTimeSeriesCardElement;
import com.ibm.cloud.scc.findings.v1.model.CreateNoteOptions;
import com.ibm.cloud.scc.findings.v1.model.FindingType;
import com.ibm.cloud.scc.findings.v1.model.KpiType;
import com.ibm.cloud.scc.findings.v1.model.RemediationStep;
import com.ibm.cloud.scc.findings.v1.model.Reporter;
import com.ibm.cloud.scc.findings.v1.model.Section;
import com.ibm.cloud.scc.findings.v1.model.ValueTypeFindingCountValueType;
import com.ibm.cloud.scc.findings.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateNoteOptions model.
 */
public class CreateNoteOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateNoteOptions() throws Throwable {
    Reporter reporterModel = new Reporter.Builder()
      .id("testString")
      .title("testString")
      .url("testString")
      .build();
    assertEquals(reporterModel.id(), "testString");
    assertEquals(reporterModel.title(), "testString");
    assertEquals(reporterModel.url(), "testString");

    ApiNoteRelatedUrl apiNoteRelatedUrlModel = new ApiNoteRelatedUrl.Builder()
      .label("testString")
      .url("testString")
      .build();
    assertEquals(apiNoteRelatedUrlModel.label(), "testString");
    assertEquals(apiNoteRelatedUrlModel.url(), "testString");

    RemediationStep remediationStepModel = new RemediationStep.Builder()
      .title("testString")
      .url("testString")
      .build();
    assertEquals(remediationStepModel.title(), "testString");
    assertEquals(remediationStepModel.url(), "testString");

    FindingType findingTypeModel = new FindingType.Builder()
      .severity("LOW")
      .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
      .build();
    assertEquals(findingTypeModel.severity(), "LOW");
    assertEquals(findingTypeModel.nextSteps(), new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)));

    KpiType kpiTypeModel = new KpiType.Builder()
      .aggregationType("SUM")
      .build();
    assertEquals(kpiTypeModel.aggregationType(), "SUM");

    ValueTypeFindingCountValueType valueTypeModel = new ValueTypeFindingCountValueType.Builder()
      .kind("FINDING_COUNT")
      .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .text("testString")
      .build();
    assertEquals(valueTypeModel.kind(), "FINDING_COUNT");
    assertEquals(valueTypeModel.findingNoteNames(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(valueTypeModel.text(), "testString");

    CardElementTimeSeriesCardElement cardElementModel = new CardElementTimeSeriesCardElement.Builder()
      .text("testString")
      .defaultInterval("testString")
      .kind("TIME_SERIES")
      .defaultTimeRange("1d")
      .valueTypes(new java.util.ArrayList<ValueType>(java.util.Arrays.asList(valueTypeModel)))
      .build();
    assertEquals(cardElementModel.text(), "testString");
    assertEquals(cardElementModel.defaultInterval(), "testString");
    assertEquals(cardElementModel.kind(), "TIME_SERIES");
    assertEquals(cardElementModel.defaultTimeRange(), "1d");
    assertEquals(cardElementModel.valueTypes(), new java.util.ArrayList<ValueType>(java.util.Arrays.asList(valueTypeModel)));

    Card cardModel = new Card.Builder()
      .section("testString")
      .title("testString")
      .subtitle("testString")
      .order(Long.valueOf("1"))
      .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .requiresConfiguration(true)
      .badgeText("testString")
      .badgeImage("testString")
      .elements(new java.util.ArrayList<CardElement>(java.util.Arrays.asList(cardElementModel)))
      .build();
    assertEquals(cardModel.section(), "testString");
    assertEquals(cardModel.title(), "testString");
    assertEquals(cardModel.subtitle(), "testString");
    assertEquals(cardModel.order(), Long.valueOf("1"));
    assertEquals(cardModel.findingNoteNames(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(cardModel.requiresConfiguration(), Boolean.valueOf(true));
    assertEquals(cardModel.badgeText(), "testString");
    assertEquals(cardModel.badgeImage(), "testString");
    assertEquals(cardModel.elements(), new java.util.ArrayList<CardElement>(java.util.Arrays.asList(cardElementModel)));

    Section sectionModel = new Section.Builder()
      .title("testString")
      .image("testString")
      .build();
    assertEquals(sectionModel.title(), "testString");
    assertEquals(sectionModel.image(), "testString");

    CreateNoteOptions createNoteOptionsModel = new CreateNoteOptions.Builder()
      .accountId("testString")
      .providerId("testString")
      .shortDescription("testString")
      .longDescription("testString")
      .kind("FINDING")
      .id("testString")
      .reportedBy(reporterModel)
      .relatedUrl(new java.util.ArrayList<ApiNoteRelatedUrl>(java.util.Arrays.asList(apiNoteRelatedUrlModel)))
      .expirationTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .shared(true)
      .finding(findingTypeModel)
      .kpi(kpiTypeModel)
      .card(cardModel)
      .section(sectionModel)
      .transactionId("testString")
      .build();
    assertEquals(createNoteOptionsModel.accountId(), "testString");
    assertEquals(createNoteOptionsModel.providerId(), "testString");
    assertEquals(createNoteOptionsModel.shortDescription(), "testString");
    assertEquals(createNoteOptionsModel.longDescription(), "testString");
    assertEquals(createNoteOptionsModel.kind(), "FINDING");
    assertEquals(createNoteOptionsModel.id(), "testString");
    assertEquals(createNoteOptionsModel.reportedBy(), reporterModel);
    assertEquals(createNoteOptionsModel.relatedUrl(), new java.util.ArrayList<ApiNoteRelatedUrl>(java.util.Arrays.asList(apiNoteRelatedUrlModel)));
    assertEquals(createNoteOptionsModel.expirationTime(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(createNoteOptionsModel.shared(), Boolean.valueOf(true));
    assertEquals(createNoteOptionsModel.finding(), findingTypeModel);
    assertEquals(createNoteOptionsModel.kpi(), kpiTypeModel);
    assertEquals(createNoteOptionsModel.card(), cardModel);
    assertEquals(createNoteOptionsModel.section(), sectionModel);
    assertEquals(createNoteOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateNoteOptionsError() throws Throwable {
    new CreateNoteOptions.Builder().build();
  }

}