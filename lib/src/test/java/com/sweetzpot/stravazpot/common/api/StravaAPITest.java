package com.sweetzpot.stravazpot.common.api;

import org.junit.After;
import org.junit.Before;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertThat;

public class StravaAPITest {
    private static final int HTTP_OK = 200;
    private static final int HTTP_UNAUTHORIZED = 401;
    protected static final String ANY_TOKEN = "Bearer 83ebeabdec09f6670863766f792ead24d61fe3f9";
    private MockWebServer server;

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        server.start();
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    public String getBaseURL() {
        return server.url("/").toString();
    }

    public void enqueueResponse(int code, String content) {
        MockResponse response = new MockResponse();
        response.setResponseCode(code);
        response.setBody(content);
        server.enqueue(response);
    }

    public void enqueueResponse(String content) {
        enqueueResponse(HTTP_OK, content);
    }

    public void enqueueUnauthorizedResponse() {
        enqueueResponse(HTTP_UNAUTHORIZED, "{}");
    }

    public void assertRequestPathContains(String... paths) throws InterruptedException {
        RecordedRequest request = server.takeRequest();

        for (String path : paths) {
            assertThat(request.getPath(), containsString(path));
        }
    }

    public void assertRequestBodyContains(String... paths) throws InterruptedException {
        RecordedRequest request = server.takeRequest();
        String body = request.getBody().readUtf8();

        for (String path : paths) {
            assertThat(body, containsString(path));
        }
    }

    public void assertRequestSentTo(String url) throws InterruptedException {
        RecordedRequest request = server.takeRequest();
        String path = request.getPath();
        assertThat(path, startsWith(url));
    }

    protected StravaConfig givenAValidConfig() {
        return StravaConfig
                .withToken(ANY_TOKEN)
                .debug()
                .baseURL(getBaseURL())
                .build();
    }
}