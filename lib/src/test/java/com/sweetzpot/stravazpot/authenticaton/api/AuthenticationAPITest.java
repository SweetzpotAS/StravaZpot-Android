package com.sweetzpot.stravazpot.authenticaton.api;

import com.sweetzpot.stravazpot.authenticaton.model.AppCredentials;
import com.sweetzpot.stravazpot.authenticaton.model.LoginResult;
import com.sweetzpot.stravazpot.common.api.AuthenticationConfig;
import com.sweetzpot.stravazpot.common.api.StravaAPITest;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class AuthenticationAPITest extends StravaAPITest {

    private static final long ANY_CLIENT_ID = 1234;
    private static final String ANY_CLIENT_SECRET = "any_secret";
    private static final String ANY_CODE = "any_code";

    @Test
    public void shouldRequestAToken() throws Exception {
        enqueueToken();
        AuthenticationAPI authenticationAPI = givenAnAuthenticationAPI();

        LoginResult loginResult = authenticationAPI.getTokenForApp(AppCredentials.with(ANY_CLIENT_ID, ANY_CLIENT_SECRET))
                                                    .withCode(ANY_CODE)
                                                    .execute();

        assertRequestBodyContains(
                "client_id=1234",
                "client_secret=any_secret",
                "code=any_code"
        );
        assertLoginResultParsedCorrectly(loginResult);
    }

    @Test
    public void shouldDeauthorize() throws Exception {
        enqueueToken();
        AuthenticationAPI authenticationAPI = givenAnAuthenticationAPI();
        authenticationAPI.deauthorize()
                .execute();
    }

    private AuthenticationAPI givenAnAuthenticationAPI() {
        return new AuthenticationAPI(givenAnAuthenticationConfig());
    }

    private AuthenticationConfig givenAnAuthenticationConfig() {
        return AuthenticationConfig.create()
                .debug()
                .baseURL(getBaseURL())
                .build();
    }

    private void assertLoginResultParsedCorrectly(LoginResult loginResult) {
        assertThat(loginResult.getToken().toString(), is("Bearer 83ebeabdec09f6670863766f792ead24d61fe3f9"));
        assertThat(loginResult.getAthlete(), is(notNullValue()));
    }

    private void enqueueToken() {
        String tokenJSON = "{\n" +
                "  \"access_token\": \"83ebeabdec09f6670863766f792ead24d61fe3f9\",\n" +
                "  \"athlete\": {\n" +
                "    \"id\": 227615,\n" +
                "    \"resource_state\": 3,\n" +
                "    \"firstname\": \"John\",\n" +
                "    \"lastname\": \"Applestrava\",\n" +
                "    \"profile_medium\": \"http://pics.com/227615/medium.jpg\",\n" +
                "    \"profile\": \"http://pics.com/227615/large.jpg\",\n" +
                "    \"city\": \"San Francisco\",\n" +
                "    \"state\": \"California\",\n" +
                "    \"country\": \"United States\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"friend\": null,\n" +
                "    \"follower\": null,\n" +
                "    \"premium\": true,\n" +
                "    \"created_at\": \"2008-01-01T17:44:00Z\",\n" +
                "    \"updated_at\": \"2013-09-04T20:00:50Z\",\n" +
                "    \"follower_count\": 273,\n" +
                "    \"friend_count\": 19,\n" +
                "    \"mutual_friend_count\": 0,\n" +
                "    \"date_preference\": \"%m/%d/%Y\",\n" +
                "    \"measurement_preference\": \"feet\",\n" +
                "    \"email\": \"john@applestrava.com\",\n" +
                "    \"clubs\": [ ],\n" +
                "    \"bikes\": [ ],\n" +
                "    \"shoes\": [ ]\n" +
                "  }\n" +
                "}";
        enqueueResponse(tokenJSON);
    }
}