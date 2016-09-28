package com.sweetzpot.stravazpot.athlete.api;

import com.sweetzpot.stravazpot.athlete.model.Athlete;
import com.sweetzpot.stravazpot.common.api.StravaAPITest;

import org.junit.Test;

import java.util.List;

public class FriendAPITest extends StravaAPITest{

    @Test
    public void shouldRetrieveMyFriends() throws Exception {
        enqueueResponse("[]");
        FriendAPI friendAPI = givenAFriendAPI();

        List<Athlete> friends = friendAPI.getMyFriends()
                                        .inPage(2)
                                        .perPage(10)
                                        .execute();

        assertRequestPathContains(
                "/athlete/friends",
                "page=2",
                "per_page=10"
        );
    }

    private FriendAPI givenAFriendAPI() {
        return new FriendAPI(givenAValidConfig());
    }
}