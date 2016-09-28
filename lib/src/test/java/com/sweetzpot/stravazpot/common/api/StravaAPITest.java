package com.sweetzpot.stravazpot.common.api;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import org.junit.After;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.junit.Assert.assertThat;

public class StravaAPITest {
    private static final int HTTP_OK = 200;
    private static final int HTTP_UNAUTHORIZED = 401;
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

    public void assertRequestSentToContains(String... paths) throws InterruptedException {
        RecordedRequest request = server.takeRequest();

        for (String path : paths) {
            assertThat(request.getPath(), containsString(path));
        }
    }

    public void assertRequestSentTo(String url) throws InterruptedException {
        RecordedRequest request = server.takeRequest();
        assertThat(request.getPath(), endsWith(url));
    }
}