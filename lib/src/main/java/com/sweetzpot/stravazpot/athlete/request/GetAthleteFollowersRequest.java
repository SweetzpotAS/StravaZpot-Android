package com.sweetzpot.stravazpot.athlete.request;

import com.sweetzpot.stravazpot.athlete.api.FriendAPI;
import com.sweetzpot.stravazpot.athlete.model.Athlete;
import com.sweetzpot.stravazpot.athlete.rest.FriendRest;

import java.util.List;

import retrofit2.Call;

public class GetAthleteFollowersRequest {

    private final long athleteID;
    private final FriendRest restService;
    private final FriendAPI api;
    private Integer page;
    private Integer perPage;

    public GetAthleteFollowersRequest(long athleteID, FriendRest restService, FriendAPI api) {
        this.athleteID = athleteID;
        this.restService = restService;
        this.api = api;
    }

    public GetAthleteFollowersRequest inPage(int page) {
        this.page = page;
        return this;
    }

    public GetAthleteFollowersRequest perPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public List<Athlete> execute() {
        Call<List<Athlete>> call = restService.getFollowers(athleteID, page, perPage);
        return api.execute(call);
    }

}
