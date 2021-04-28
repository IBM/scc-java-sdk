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
import com.ibm.cloud.scc.findings_api.v1.model.CardElementTimeSeriesCardElement;
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
 * Unit test class for the CardElementTimeSeriesCardElement model.
 */
public class CardElementTimeSeriesCardElementTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCardElementTimeSeriesCardElement() throws Throwable {
    ValueTypeFindingCountValueType valueTypeModel = new ValueTypeFindingCountValueType.Builder()
      .kind("FINDING_COUNT")
      .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .text("testString")
      .build();
    assertEquals(valueTypeModel.kind(), "FINDING_COUNT");
    assertEquals(valueTypeModel.findingNoteNames(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(valueTypeModel.text(), "testString");

    CardElementTimeSeriesCardElement cardElementTimeSeriesCardElementModel = new CardElementTimeSeriesCardElement.Builder()
      .text("testString")
      .defaultInterval("testString")
      .kind("TIME_SERIES")
      .defaultTimeRange("1d")
      .valueTypes(new java.util.ArrayList<ValueType>(java.util.Arrays.asList(valueTypeModel)))
      .build();
    assertEquals(cardElementTimeSeriesCardElementModel.text(), "testString");
    assertEquals(cardElementTimeSeriesCardElementModel.defaultInterval(), "testString");
    assertEquals(cardElementTimeSeriesCardElementModel.kind(), "TIME_SERIES");
    assertEquals(cardElementTimeSeriesCardElementModel.defaultTimeRange(), "1d");
    assertEquals(cardElementTimeSeriesCardElementModel.valueTypes(), new java.util.ArrayList<ValueType>(java.util.Arrays.asList(valueTypeModel)));

    String json = TestUtilities.serialize(cardElementTimeSeriesCardElementModel);

    CardElementTimeSeriesCardElement cardElementTimeSeriesCardElementModelNew = TestUtilities.deserialize(json, CardElementTimeSeriesCardElement.class);
    assertTrue(cardElementTimeSeriesCardElementModelNew instanceof CardElementTimeSeriesCardElement);
    assertEquals(cardElementTimeSeriesCardElementModelNew.text(), "testString");
    assertEquals(cardElementTimeSeriesCardElementModelNew.defaultInterval(), "testString");
    assertEquals(cardElementTimeSeriesCardElementModelNew.kind(), "TIME_SERIES");
    assertEquals(cardElementTimeSeriesCardElementModelNew.defaultTimeRange(), "1d");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCardElementTimeSeriesCardElementError() throws Throwable {
    new CardElementTimeSeriesCardElement.Builder().build();
  }

}