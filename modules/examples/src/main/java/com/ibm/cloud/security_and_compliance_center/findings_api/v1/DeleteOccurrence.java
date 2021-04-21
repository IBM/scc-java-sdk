package com.ibm.cloud.security_and_compliance_center.findings_api.v1;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.DeleteOccurrenceOptions;

public class DeleteOccurrence {
    protected DeleteOccurrence() {
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

        DeleteOccurrenceOptions opts = new DeleteOccurrenceOptions.Builder().accountId(accountId).providerId(testString)
                .occurrenceId(testString).build();

        Response<Void> resp = service.deleteOccurrence(opts).execute();
        System.out.println(resp.getResult());
    }
}
