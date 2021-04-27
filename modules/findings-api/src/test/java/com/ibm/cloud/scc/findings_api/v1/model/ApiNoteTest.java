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

package com.ibm.cloud.scc.findings_api.v1.model;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.scc.findings_api.v1.model.ApiNote;
import com.ibm.cloud.scc.findings_api.v1.model.ApiNoteRelatedUrl;
import com.ibm.cloud.scc.findings_api.v1.model.Card;
import com.ibm.cloud.scc.findings_api.v1.model.CardElementTimeSeriesCardElement;
import com.ibm.cloud.scc.findings_api.v1.model.FindingType;
import com.ibm.cloud.scc.findings_api.v1.model.KpiType;
import com.ibm.cloud.scc.findings_api.v1.model.RemediationStep;
import com.ibm.cloud.scc.findings_api.v1.model.Reporter;
import com.ibm.cloud.scc.findings_api.v1.model.Section;
import com.ibm.cloud.scc.findings_api.v1.model.ValueTypeFindingCountValueType;
import com.ibm.cloud.scc.findings_api.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ApiNote model.
 */
public class ApiNoteTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testApiNote() throws Throwable {
    ApiNoteRelatedUrl apiNoteRelatedUrlModel = new ApiNoteRelatedUrl.Builder()
      .label("testString")
      .url("testString")
      .build();
    assertEquals(apiNoteRelatedUrlModel.label(), "testString");
    assertEquals(apiNoteRelatedUrlModel.url(), "testString");

    Reporter reporterModel = new Reporter.Builder()
      .id("testString")
      .title("testString")
      .url("testString")
      .build();
    assertEquals(reporterModel.id(), "testString");
    assertEquals(reporterModel.title(), "testString");
    assertEquals(reporterModel.url(), "testString");

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

    ApiNote apiNoteModel = new ApiNote.Builder()
      .shortDescription("testString")
      .longDescription("testString")
      .kind("FINDING")
      .relatedUrl(new java.util.ArrayList<ApiNoteRelatedUrl>(java.util.Arrays.asList(apiNoteRelatedUrlModel)))
      .expirationTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .createTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .updateTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .id("testString")
      .shared(true)
      .reportedBy(reporterModel)
      .finding(findingTypeModel)
      .kpi(kpiTypeModel)
      .card(cardModel)
      .section(sectionModel)
      .build();
    assertEquals(apiNoteModel.shortDescription(), "testString");
    assertEquals(apiNoteModel.longDescription(), "testString");
    assertEquals(apiNoteModel.kind(), "FINDING");
    assertEquals(apiNoteModel.relatedUrl(), new java.util.ArrayList<ApiNoteRelatedUrl>(java.util.Arrays.asList(apiNoteRelatedUrlModel)));
    assertEquals(apiNoteModel.expirationTime(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(apiNoteModel.createTime(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(apiNoteModel.updateTime(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(apiNoteModel.id(), "testString");
    assertEquals(apiNoteModel.shared(), Boolean.valueOf(true));
    assertEquals(apiNoteModel.reportedBy(), reporterModel);
    assertEquals(apiNoteModel.finding(), findingTypeModel);
    assertEquals(apiNoteModel.kpi(), kpiTypeModel);
    assertEquals(apiNoteModel.card(), cardModel);
    assertEquals(apiNoteModel.section(), sectionModel);

    String json = TestUtilities.serialize(apiNoteModel);

    ApiNote apiNoteModelNew = TestUtilities.deserialize(json, ApiNote.class);
    assertTrue(apiNoteModelNew instanceof ApiNote);
    assertEquals(apiNoteModelNew.shortDescription(), "testString");
    assertEquals(apiNoteModelNew.longDescription(), "testString");
    assertEquals(apiNoteModelNew.kind(), "FINDING");
    assertEquals(apiNoteModelNew.expirationTime(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(apiNoteModelNew.createTime(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(apiNoteModelNew.updateTime(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(apiNoteModelNew.id(), "testString");
    assertEquals(apiNoteModelNew.shared(), Boolean.valueOf(true));
    assertEquals(apiNoteModelNew.reportedBy().toString(), reporterModel.toString());
    assertEquals(apiNoteModelNew.finding().toString(), findingTypeModel.toString());
    assertEquals(apiNoteModelNew.kpi().toString(), kpiTypeModel.toString());
    assertEquals(apiNoteModelNew.card().toString(), cardModel.toString());
    assertEquals(apiNoteModelNew.section().toString(), sectionModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testApiNoteError() throws Throwable {
    new ApiNote.Builder().build();
  }

}