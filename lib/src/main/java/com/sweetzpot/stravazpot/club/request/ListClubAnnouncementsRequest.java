package com.sweetzpot.stravazpot.club.request;

import com.sweetzpot.stravazpot.club.api.ClubAPI;
import com.sweetzpot.stravazpot.club.model.Announcement;
import com.sweetzpot.stravazpot.club.rest.ClubRest;

import java.util.List;

import retrofit2.Call;

public class ListClubAnnouncementsRequest {

    private final long clubID;
    private final ClubRest restService;
    private final ClubAPI api;

    public ListClubAnnouncementsRequest(long clubID, ClubRest restService, ClubAPI api) {
        this.clubID = clubID;
        this.restService = restService;
        this.api = api;
    }

    public List<Announcement> execute() {
        Call<List<Announcement>> call = restService.getClubAnnouncements(clubID);
        return api.execute(call);
    }
}
