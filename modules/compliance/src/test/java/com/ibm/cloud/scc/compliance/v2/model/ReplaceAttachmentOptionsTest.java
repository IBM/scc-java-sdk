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

import com.ibm.cloud.scc.compliance.v2.model.ParameterInfo;
import com.ibm.cloud.scc.compliance.v2.model.ReplaceAttachmentOptions;
import com.ibm.cloud.scc.compliance.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceAttachmentOptions model.
 */
public class ReplaceAttachmentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceAttachmentOptions() throws Throwable {
    ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
      .parameterName("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .build();
    assertEquals(parameterInfoModel.parameterName(), "testString");
    assertEquals(parameterInfoModel.parameterDisplayName(), "testString");
    assertEquals(parameterInfoModel.parameterType(), "numeric");

    ReplaceAttachmentOptions replaceAttachmentOptionsModel = new ReplaceAttachmentOptions.Builder()
      .profilesId("testString")
      .attachmentId("testString")
      .instanceId("testString")
      .parameterName("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .parameterValue("testString")
      .assessmentType("testString")
      .assessmentId("testString")
      .parameters(java.util.Arrays.asList(parameterInfoModel))
      .transactionId("testString")
      .build();
    assertEquals(replaceAttachmentOptionsModel.profilesId(), "testString");
    assertEquals(replaceAttachmentOptionsModel.attachmentId(), "testString");
    assertEquals(replaceAttachmentOptionsModel.instanceId(), "testString");
    assertEquals(replaceAttachmentOptionsModel.parameterName(), "testString");
    assertEquals(replaceAttachmentOptionsModel.parameterDisplayName(), "testString");
    assertEquals(replaceAttachmentOptionsModel.parameterType(), "numeric");
    assertEquals(replaceAttachmentOptionsModel.parameterValue(), "testString");
    assertEquals(replaceAttachmentOptionsModel.assessmentType(), "testString");
    assertEquals(replaceAttachmentOptionsModel.assessmentId(), "testString");
    assertEquals(replaceAttachmentOptionsModel.parameters(), java.util.Arrays.asList(parameterInfoModel));
    assertEquals(replaceAttachmentOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceAttachmentOptionsError() throws Throwable {
    new ReplaceAttachmentOptions.Builder().build();
  }

}