package com.ibm.cloud.scc.findings_api.v1;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.scc.findings_api.v1.model.ApiOccurrence;
import com.ibm.cloud.scc.findings_api.v1.model.Finding;
import com.ibm.cloud.scc.findings_api.v1.model.RemediationStep;
import com.ibm.cloud.scc.findings_api.v1.model.UpdateOccurrenceOptions;

public class UpdateOccurrence {
    protected UpdateOccurrence() {
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

        RemediationStep remediationStep = new RemediationStep.Builder().title(testString).url(testString).build();

        Finding finding = new Finding.Builder().severity("LOW").certainty("LOW")
                .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStep))).build();

        UpdateOccurrenceOptions opts = new UpdateOccurrenceOptions.Builder().accountId(accountId).providerId(testString)
                .noteName(accountId + "/providers/" + testString + "/notes/" + testString).kind("FINDING")
                .id(testString).resourceUrl(testString).remediation(testString).finding(finding)
                .occurrenceId(testString).build();

        Response<ApiOccurrence> resp = service.updateOccurrence(opts).execute();
        System.out.println(resp.getResult());
    }
}
