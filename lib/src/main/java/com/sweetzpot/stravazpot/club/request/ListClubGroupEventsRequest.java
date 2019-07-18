package com.sweetzpot.stravazpot.club.request;

import com.sweetzpot.stravazpot.club.api.ClubAPI;
import com.sweetzpot.stravazpot.club.model.Event;
import com.sweetzpot.stravazpot.club.rest.ClubRest;

import java.util.List;

import retrofit2.Call;

public class ListClubGroupEventsRequest {

    private final long clubID;
    private final ClubRest restService;
    private final ClubAPI api;

    public ListClubGroupEventsRequest(long clubID, ClubRest restService, ClubAPI api) {
        this.clubID = clubID;
        this.restService = restService;
        this.api = api;
    }

    public List<Event> execute() {
        Call<List<Event>> call = restService.getClubGroupEvents(clubID);
        return api.execute(call);
    }
}
