package com.ibm.cloud.scc.findings_api.v1;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.scc.findings_api.v1.model.ApiNote;
import com.ibm.cloud.scc.findings_api.v1.model.ApiNoteRelatedUrl;
import com.ibm.cloud.scc.findings_api.v1.model.Card;
import com.ibm.cloud.scc.findings_api.v1.model.CardElement;
import com.ibm.cloud.scc.findings_api.v1.model.CardElementBreakdownCardElement;
import com.ibm.cloud.scc.findings_api.v1.model.CreateNoteOptions;
import com.ibm.cloud.scc.findings_api.v1.model.Reporter;
import com.ibm.cloud.scc.findings_api.v1.model.ValueType;
import com.ibm.cloud.scc.findings_api.v1.model.ValueTypeFindingCountValueType;

public class CreateBreakdownCardFindingCount {
        protected CreateBreakdownCardFindingCount() {
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

                ValueTypeFindingCountValueType valueType = new ValueTypeFindingCountValueType.Builder()
                                .kind("FINDING_COUNT")
                                .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList(testString)))
                                .text(testString).build();

                CardElementBreakdownCardElement element = new CardElementBreakdownCardElement.Builder()
                                .kind("BREAKDOWN").defaultTimeRange("1d").text(testString)
                                .valueTypes(new java.util.ArrayList<ValueType>(java.util.Arrays.asList(valueType)))
                                .build();

                ApiNoteRelatedUrl relatedUrl = new ApiNoteRelatedUrl.Builder().label(testString).url(testString)
                                .build();

                Card card = new Card.Builder().section(testString).title(testString).subtitle(testString)
                                .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList(testString)))
                                .elements(new java.util.ArrayList<CardElement>(java.util.Arrays.asList(element)))
                                .build();

                Reporter reporter = new Reporter.Builder().id(testString).title(testString).url(testString).build();

                CreateNoteOptions opts = new CreateNoteOptions.Builder().accountId(accountId).providerId(testString)
                                .shortDescription(testString).longDescription(testString).kind("CARD").id(testString)
                                .reportedBy(reporter).relatedUrl(new java.util.ArrayList<ApiNoteRelatedUrl>(
                                                java.util.Arrays.asList(relatedUrl)))
                                .card(card).build();

                Response<ApiNote> resp = service.createNote(opts).execute();
                System.out.println(resp.getResult());
        }
}
