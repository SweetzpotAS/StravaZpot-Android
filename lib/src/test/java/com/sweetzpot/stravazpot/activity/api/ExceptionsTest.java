package com.sweetzpot.stravazpot.activity.api;

import com.sweetzpot.stravazpot.common.api.StravaAPITest;
import com.sweetzpot.stravazpot.common.api.StravaConfig;
import com.sweetzpot.stravazpot.common.api.exception.StravaAPIException;
import com.sweetzpot.stravazpot.common.api.exception.StravaUnauthorizedException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionsTest extends StravaAPITest{

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowAnExceptionWhenOperationIsNotAuthorized() throws Exception {
        enqueueUnauthorizedResponse();
        ActivityAPI activityAPI = givenAnActivityAPI();

        thrown.expect(StravaUnauthorizedException.class);

        activityAPI.getActivity(123456L).execute();
    }

    @Test
    public void shoudlThrowAnExceptionIfConfigurationIsNotValid() throws Exception {
        enqueueResponse("{}");
        ActivityAPI activityAPI = givenAWronglyConfiguredActivityAPI();

        thrown.expect(StravaAPIException.class);

        activityAPI.getActivity(123456L).execute();
    }

    @Test
    public void shouldThrowAnExceptionIfResultJSONIsWrong() throws Exception {
        enqueueResponse("{]");
        ActivityAPI activityAPI = givenAnActivityAPI();

        thrown.expect(StravaAPIException.class);

        activityAPI.getActivity(123456L).execute();
    }

    @Test
    public void shouldThrowAnExceptionIfResponseCodeIsNotSuccessful() throws Exception {
        enqueueResponse(404, "");
        ActivityAPI activityAPI = givenAnActivityAPI();

        thrown.expect(StravaAPIException.class);
        
        activityAPI.getActivity(123456L).execute();
    }

    private ActivityAPI givenAWronglyConfiguredActivityAPI() {
        return new ActivityAPI(givenAWrongConfig());
    }

    private ActivityAPI givenAnActivityAPI() {
        return new ActivityAPI(givenAValidConfig());
    }

    private StravaConfig givenAWrongConfig() {
        return StravaConfig.withToken("A token")
                            .baseURL("http://fake.strava.com/api/")
                            .debug()
                            .build();
    }

}
