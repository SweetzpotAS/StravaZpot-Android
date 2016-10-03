package com.sweetzpot.stravazpot.activity.api;

import com.sweetzpot.stravazpot.common.api.StravaAPITest;
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

        activityAPI.getActivity(123456).execute();
    }

    private ActivityAPI givenAnActivityAPI() {
        return new ActivityAPI(givenAValidConfig());
    }


}
