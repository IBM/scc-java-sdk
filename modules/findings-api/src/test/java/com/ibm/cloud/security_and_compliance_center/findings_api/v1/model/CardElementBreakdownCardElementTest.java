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
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.CardElementBreakdownCardElement;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.ValueTypeFindingCountValueType;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CardElementBreakdownCardElement model.
 */
public class CardElementBreakdownCardElementTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCardElementBreakdownCardElement() throws Throwable {
    ValueTypeFindingCountValueType valueTypeModel = new ValueTypeFindingCountValueType.Builder()
      .kind("FINDING_COUNT")
      .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .text("testString")
      .build();
    assertEquals(valueTypeModel.kind(), "FINDING_COUNT");
    assertEquals(valueTypeModel.findingNoteNames(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(valueTypeModel.text(), "testString");

    CardElementBreakdownCardElement cardElementBreakdownCardElementModel = new CardElementBreakdownCardElement.Builder()
      .text("testString")
      .kind("BREAKDOWN")
      .defaultTimeRange("1d")
      .valueTypes(new java.util.ArrayList<ValueType>(java.util.Arrays.asList(valueTypeModel)))
      .build();
    assertEquals(cardElementBreakdownCardElementModel.text(), "testString");
    assertEquals(cardElementBreakdownCardElementModel.kind(), "BREAKDOWN");
    assertEquals(cardElementBreakdownCardElementModel.defaultTimeRange(), "1d");
    assertEquals(cardElementBreakdownCardElementModel.valueTypes(), new java.util.ArrayList<ValueType>(java.util.Arrays.asList(valueTypeModel)));

    String json = TestUtilities.serialize(cardElementBreakdownCardElementModel);

    CardElementBreakdownCardElement cardElementBreakdownCardElementModelNew = TestUtilities.deserialize(json, CardElementBreakdownCardElement.class);
    assertTrue(cardElementBreakdownCardElementModelNew instanceof CardElementBreakdownCardElement);
    assertEquals(cardElementBreakdownCardElementModelNew.text(), "testString");
    assertEquals(cardElementBreakdownCardElementModelNew.kind(), "BREAKDOWN");
    assertEquals(cardElementBreakdownCardElementModelNew.defaultTimeRange(), "1d");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCardElementBreakdownCardElementError() throws Throwable {
    new CardElementBreakdownCardElement.Builder().build();
  }

}