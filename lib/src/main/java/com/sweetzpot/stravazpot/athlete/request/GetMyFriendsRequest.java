package com.sweetzpot.stravazpot.athlete.request;

import com.sweetzpot.stravazpot.athlete.api.FriendAPI;
import com.sweetzpot.stravazpot.athlete.model.Athlete;
import com.sweetzpot.stravazpot.athlete.rest.FriendRest;

import java.util.List;

import retrofit2.Call;

public class GetMyFriendsRequest {

    private final FriendRest restService;
    private final FriendAPI api;
    private Integer page;
    private Integer perPage;

    public GetMyFriendsRequest(FriendRest restService, FriendAPI api) {
        this.restService = restService;
        this.api = api;
    }

    public GetMyFriendsRequest inPage(int page) {
        this.page = page;
        return this;
    }

    public GetMyFriendsRequest perPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public List<Athlete> execute() {
        Call<List<Athlete>> call = restService.getMyFriends(page, perPage);
        return api.execute(call);
    }
}
