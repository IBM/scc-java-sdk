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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Account;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Credential;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceTargetOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Resource;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Tags;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceTargetOptions model.
 */
public class ReplaceTargetOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceTargetOptions() throws Throwable {
    Account accountModel = new Account.Builder()
      .id("531fc3e28bfc43c5a2cea07786d93f5c")
      .name("NIST")
      .type("account_type")
      .build();
    assertEquals(accountModel.id(), "531fc3e28bfc43c5a2cea07786d93f5c");
    assertEquals(accountModel.name(), "NIST");
    assertEquals(accountModel.type(), "account_type");

    Tags tagsModel = new Tags.Builder()
      .user(java.util.Arrays.asList("testString"))
      .access(java.util.Arrays.asList("testString"))
      .service(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(tagsModel.user(), java.util.Arrays.asList("testString"));
    assertEquals(tagsModel.access(), java.util.Arrays.asList("testString"));
    assertEquals(tagsModel.service(), java.util.Arrays.asList("testString"));

    Resource resourceModel = new Resource.Builder()
      .reportId("30b434b3-cb08-4845-af10-7a8fc682b6a8")
      .homeAccountId("2411ffdc16844b07b42521c3443f456d")
      .id("crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::")
      .resourceName("jeff's key")
      .account(accountModel)
      .componentId("cloud-object_storage")
      .componentName("cloud-object_storage")
      .environment("ibm cloud")
      .tags(tagsModel)
      .status("compliant")
      .totalCount(Long.valueOf("140"))
      .passCount(Long.valueOf("123"))
      .failureCount(Long.valueOf("12"))
      .errorCount(Long.valueOf("5"))
      .skippedCount(Long.valueOf("7"))
      .completedCount(Long.valueOf("135"))
      .serviceName("pm-20")
      .instanceCrn("testString")
      .build();
    assertEquals(resourceModel.reportId(), "30b434b3-cb08-4845-af10-7a8fc682b6a8");
    assertEquals(resourceModel.homeAccountId(), "2411ffdc16844b07b42521c3443f456d");
    assertEquals(resourceModel.id(), "crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::");
    assertEquals(resourceModel.resourceName(), "jeff's key");
    assertEquals(resourceModel.account(), accountModel);
    assertEquals(resourceModel.componentId(), "cloud-object_storage");
    assertEquals(resourceModel.componentName(), "cloud-object_storage");
    assertEquals(resourceModel.environment(), "ibm cloud");
    assertEquals(resourceModel.tags(), tagsModel);
    assertEquals(resourceModel.status(), "compliant");
    assertEquals(resourceModel.totalCount(), Long.valueOf("140"));
    assertEquals(resourceModel.passCount(), Long.valueOf("123"));
    assertEquals(resourceModel.failureCount(), Long.valueOf("12"));
    assertEquals(resourceModel.errorCount(), Long.valueOf("5"));
    assertEquals(resourceModel.skippedCount(), Long.valueOf("7"));
    assertEquals(resourceModel.completedCount(), Long.valueOf("135"));
    assertEquals(resourceModel.serviceName(), "pm-20");
    assertEquals(resourceModel.instanceCrn(), "testString");

    Credential credentialModel = new Credential.Builder()
      .secretCrn("dummy")
      .resources(java.util.Arrays.asList(resourceModel))
      .build();
    assertEquals(credentialModel.secretCrn(), "dummy");
    assertEquals(credentialModel.resources(), java.util.Arrays.asList(resourceModel));

    ReplaceTargetOptions replaceTargetOptionsModel = new ReplaceTargetOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .targetId("testString")
      .accountId("be200c80cabc456e91139e4152327823")
      .trustedProfileId("Profile-a0a4c149-4fed-47ff-bfb2-680bcfaa64d3")
      .name("Sample Target Name")
      .credentials(java.util.Arrays.asList(credentialModel))
      .build();
    assertEquals(replaceTargetOptionsModel.instanceId(), "acd7032c-15a3-484f-bf5b-67d41534d940");
    assertEquals(replaceTargetOptionsModel.targetId(), "testString");
    assertEquals(replaceTargetOptionsModel.accountId(), "be200c80cabc456e91139e4152327823");
    assertEquals(replaceTargetOptionsModel.trustedProfileId(), "Profile-a0a4c149-4fed-47ff-bfb2-680bcfaa64d3");
    assertEquals(replaceTargetOptionsModel.name(), "Sample Target Name");
    assertEquals(replaceTargetOptionsModel.credentials(), java.util.Arrays.asList(credentialModel));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceTargetOptionsError() throws Throwable {
    new ReplaceTargetOptions.Builder().build();
  }

}