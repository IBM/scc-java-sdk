/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.cloud.security_and_compliance_center_api.v3.model;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Assessment;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Evaluation;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EvaluationDetails;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EvaluationProperty;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EvaluationProviderInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Parameter;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Tags;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.TargetInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Evaluation model.
 */
public class EvaluationTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testEvaluation() throws Throwable {
    Evaluation evaluationModel = new Evaluation();
    assertNull(evaluationModel.getReportId());
    assertNull(evaluationModel.getHomeAccountId());
    assertNull(evaluationModel.getComponentId());
    assertNull(evaluationModel.getComponentName());
    assertNull(evaluationModel.getAssessment());
    assertNull(evaluationModel.getEvaluateTime());
    assertNull(evaluationModel.getTarget());
    assertNull(evaluationModel.getStatus());
    assertNull(evaluationModel.getReason());
    assertNull(evaluationModel.getDetails());
    assertNull(evaluationModel.getEvaluatedBy());
  }
}