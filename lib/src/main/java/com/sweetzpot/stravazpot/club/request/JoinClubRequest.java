package com.sweetzpot.stravazpot.club.request;

import com.sweetzpot.stravazpot.club.api.ClubAPI;
import com.sweetzpot.stravazpot.club.model.JoinResult;
import com.sweetzpot.stravazpot.club.rest.ClubRest;

import retrofit2.Call;

public class JoinClubRequest {

    private final long clubID;
    private final ClubRest restService;
    private final ClubAPI api;

    public JoinClubRequest(long clubID, ClubRest restService, ClubAPI api) {
        this.clubID = clubID;
        this.restService = restService;
        this.api = api;
    }

    public JoinResult execute() {
        Call<JoinResult> call = restService.joinClub(clubID);
        return api.execute(call);
    }
}
