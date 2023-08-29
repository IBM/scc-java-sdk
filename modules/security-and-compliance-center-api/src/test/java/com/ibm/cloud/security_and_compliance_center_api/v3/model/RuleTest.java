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

package com.ibm.cloud.security_and_compliance_center_api.v3.model;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AdditionalTargetAttribute;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Import;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Parameter;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigAnd;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.RequiredConfigItemsRequiredConfigOrDepth1;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Rule;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Target;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Rule model.
 */
public class RuleTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRule() throws Throwable {
    Rule ruleModel = new Rule();
    assertNull(ruleModel.getCreatedOn());
    assertNull(ruleModel.getCreatedBy());
    assertNull(ruleModel.getUpdatedOn());
    assertNull(ruleModel.getUpdatedBy());
    assertNull(ruleModel.getId());
    assertNull(ruleModel.getAccountId());
    assertNull(ruleModel.getDescription());
    assertNull(ruleModel.getType());
    assertNull(ruleModel.getVersion());
    assertNull(ruleModel.getXImport());
    assertNull(ruleModel.getTarget());
    assertNull(ruleModel.getRequiredConfig());
    assertNull(ruleModel.getLabels());
  }
}