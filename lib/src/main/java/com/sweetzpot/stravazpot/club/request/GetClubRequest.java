package com.sweetzpot.stravazpot.club.request;

import com.sweetzpot.stravazpot.club.api.ClubAPI;
import com.sweetzpot.stravazpot.club.model.Club;
import com.sweetzpot.stravazpot.club.rest.ClubRest;

import retrofit2.Call;

public class GetClubRequest {

    private final long clubID;
    private final ClubRest restService;
    private final ClubAPI api;

    public GetClubRequest(long clubID, ClubRest restService, ClubAPI api) {
        this.clubID = clubID;
        this.restService = restService;
        this.api = api;
    }

    public Club execute() {
        Call<Club> call = restService.getClub(clubID);
        return api.execute(call);
    }
}
