package com.ibm.cloud.scc.notifications_api.v1;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.scc.notifications_api.v1.model.ChannelsDelete;
import com.ibm.cloud.scc.notifications_api.v1.model.DeleteNotificationChannelsOptions;

public class DeleteChannels {
    protected DeleteChannels() {
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

        DeleteNotificationChannelsOptions opts = new DeleteNotificationChannelsOptions.Builder()
        .accountId(accountId)
        .body(new java.util.ArrayList<String>(java.util.Arrays.asList(testString)))
        .build();

        Response<ChannelsDelete> resp = notificationsApi.deleteNotificationChannels(opts).execute();
        System.out.println(resp.getResult());
    }
}
