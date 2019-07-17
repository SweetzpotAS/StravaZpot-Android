package com.sweetzpot.stravazpot.club.request;

import com.sweetzpot.stravazpot.club.api.ClubAPI;
import com.sweetzpot.stravazpot.club.model.LeaveResult;
import com.sweetzpot.stravazpot.club.rest.ClubRest;

import retrofit2.Call;

public class LeaveClubRequest {

    private final long clubID;
    private final ClubRest restService;
    private final ClubAPI api;

    public LeaveClubRequest(long clubID, ClubRest restService, ClubAPI api) {
        this.clubID = clubID;
        this.restService = restService;
        this.api = api;
    }

    public LeaveResult execute() {
        Call<LeaveResult> call = restService.leaveClub(clubID);
        return api.execute(call);
    }
}
