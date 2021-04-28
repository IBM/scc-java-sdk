package com.ibm.cloud.scc.notifications_api.v1;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.scc.notifications_api.v1.model.GetPublicKeyOptions;
import com.ibm.cloud.scc.notifications_api.v1.model.PublicKeyGet;

public class GetPublicKey {
    protected GetPublicKey() {
    }

    public static String apiKey = System.getenv("API_KEY");
    public static String accountId = System.getenv("ACCOUNT_ID");
    public static String iamUrl = System.getenv("IAM_URL");
    public static String apiUrl = System.getenv("FINDINGS_API_URL");
    public static String testString = "testString";

    public static Authenticator authenticator = new IamAuthenticator(apiKey, iamUrl, null, null, true, null);
    public static NotificationsApi service = new NotificationsApi("notifications-api", authenticator);

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator(apiKey);

        NotificationsApi notificationsApi = new NotificationsApi("notifications_api", authenticator);
        notificationsApi.setServiceUrl(apiUrl);

        GetPublicKeyOptions opts = new GetPublicKeyOptions.Builder()
        .accountId(accountId)
        .build();

        Response<PublicKeyGet> resp = notificationsApi.getPublicKey(opts).execute();
        System.out.println(resp.getResult());
    }
}
