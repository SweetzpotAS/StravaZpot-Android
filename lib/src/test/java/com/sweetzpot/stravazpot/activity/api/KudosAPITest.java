package com.sweetzpot.stravazpot.activity.api;

import com.sweetzpot.stravazpot.athlete.model.Athlete;
import com.sweetzpot.stravazpot.common.api.StravaAPITest;

import org.junit.Test;

import java.util.List;

public class KudosAPITest extends StravaAPITest {

    @Test
    public void shouldListActivityKudoers() throws Exception {
        enqueueResponse("[]");
        KudosAPI kudosAPI = givenAKudosAPI();

        List<Athlete> athletes = kudosAPI.listActivityKudoers(123456L)
                                            .inPage(2)
                                            .perPage(10)
                                            .execute();

        assertRequestPathContains(
                "/activities/123456/kudos",
                "page=2",
                "per_page=10"
        );
    }

    private KudosAPI givenAKudosAPI() {
        return new KudosAPI(givenAValidConfig());
    }
}