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
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.CardElementNumericCardElement;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.NumericCardElementValueType;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CardElementNumericCardElement model.
 */
public class CardElementNumericCardElementTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCardElementNumericCardElement() throws Throwable {
    NumericCardElementValueType numericCardElementValueTypeModel = new NumericCardElementValueType.Builder()
      .kind("KPI")
      .kpiNoteName("testString")
      .text("testString")
      .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .build();
    assertEquals(numericCardElementValueTypeModel.kind(), "KPI");
    assertEquals(numericCardElementValueTypeModel.kpiNoteName(), "testString");
    assertEquals(numericCardElementValueTypeModel.text(), "testString");
    assertEquals(numericCardElementValueTypeModel.findingNoteNames(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    CardElementNumericCardElement cardElementNumericCardElementModel = new CardElementNumericCardElement.Builder()
      .text("testString")
      .kind("NUMERIC")
      .defaultTimeRange("1d")
      .valueType(numericCardElementValueTypeModel)
      .build();
    assertEquals(cardElementNumericCardElementModel.text(), "testString");
    assertEquals(cardElementNumericCardElementModel.kind(), "NUMERIC");
    assertEquals(cardElementNumericCardElementModel.defaultTimeRange(), "1d");
    assertEquals(cardElementNumericCardElementModel.valueType(), numericCardElementValueTypeModel);

    String json = TestUtilities.serialize(cardElementNumericCardElementModel);

    CardElementNumericCardElement cardElementNumericCardElementModelNew = TestUtilities.deserialize(json, CardElementNumericCardElement.class);
    assertTrue(cardElementNumericCardElementModelNew instanceof CardElementNumericCardElement);
    assertEquals(cardElementNumericCardElementModelNew.text(), "testString");
    assertEquals(cardElementNumericCardElementModelNew.kind(), "NUMERIC");
    assertEquals(cardElementNumericCardElementModelNew.defaultTimeRange(), "1d");
    assertEquals(cardElementNumericCardElementModelNew.valueType().toString(), numericCardElementValueTypeModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCardElementNumericCardElementError() throws Throwable {
    new CardElementNumericCardElement.Builder().build();
  }

}