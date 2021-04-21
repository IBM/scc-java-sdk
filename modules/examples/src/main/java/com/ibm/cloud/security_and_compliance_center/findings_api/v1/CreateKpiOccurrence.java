package com.ibm.cloud.security_and_compliance_center.findings_api.v1;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.ApiOccurrence;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.CreateOccurrenceOptions;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.Kpi;

public class CreateKpiOccurrence {
    protected CreateKpiOccurrence() {
    }

    public static String apiKey = System.getenv("API_KEY");
    public static String accountId = System.getenv("ACCOUNT_ID");
    public static String iamUrl = System.getenv("IAM_URL");
    public static String apiUrl = System.getenv("FINDINGS_API_URL");
    public static String testString = "testString";

    public static Authenticator authenticator = new IamAuthenticator(apiKey, iamUrl, null, null, true, null);
    public static FindingsApi service = new FindingsApi("findings_api", authenticator);

    public static void main(String[] args) {

        service.setServiceUrl(apiUrl);

        Kpi kpi = new Kpi.Builder().value(1.0).total(2.0).build();

        CreateOccurrenceOptions opts = new CreateOccurrenceOptions.Builder().accountId(accountId).providerId(testString)
                .noteName(accountId + "/providers/" + testString + "/notes/" + testString).kind("KPI").id(testString)
                .resourceUrl(testString).remediation(testString).kpi(kpi).replaceIfExists(true).build();

        Response<ApiOccurrence> resp = service.createOccurrence(opts).execute();
        System.out.println(resp.getResult());
    }
}
