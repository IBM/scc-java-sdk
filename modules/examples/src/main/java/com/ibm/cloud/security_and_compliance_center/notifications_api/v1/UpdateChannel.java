package com.ibm.cloud.security_and_compliance_center.notifications_api.v1;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.ChannelInfo;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.NotificationChannelAlertSourceItem;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.UpdateNotificationChannelOptions;

public class UpdateChannel {
    protected UpdateChannel() {
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

        NotificationChannelAlertSourceItem notificationChannelAlertSourceItemModel = new NotificationChannelAlertSourceItem.Builder()
        .providerName(testString)
        .findingTypes(new java.util.ArrayList<String>(java.util.Arrays.asList(testString)))
        .build();

        UpdateNotificationChannelOptions opts = new UpdateNotificationChannelOptions.Builder()
        .name(testString)
        .channelId(testString)
        .description(testString)
        .type("Webhook")
        .endpoint("https://webhook.site/e36d188b-1e74-42c1-b69a-9a33423d39f3")
        .enabled(true)
        .severity(new java.util.ArrayList<String>(java.util.Arrays.asList("low", "critical")))
        .accountId(accountId)
        .alertSource(new java.util.ArrayList<NotificationChannelAlertSourceItem>(java.util.Arrays.asList(notificationChannelAlertSourceItemModel)))
        .build();

        Response<ChannelInfo> resp = notificationsApi.updateNotificationChannel(opts).execute();
        System.out.println(resp.getResult());
    }
}
