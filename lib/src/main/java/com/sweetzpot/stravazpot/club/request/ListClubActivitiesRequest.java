package com.sweetzpot.stravazpot.club.request;

import com.sweetzpot.stravazpot.activity.model.Activity;
import com.sweetzpot.stravazpot.club.api.ClubAPI;
import com.sweetzpot.stravazpot.club.rest.ClubRest;

import java.util.List;

import retrofit2.Call;

public class ListClubActivitiesRequest {

    private final long clubID;
    private final ClubRest restService;
    private final ClubAPI api;
    private Integer before;
    private Integer page;
    private Integer perPage;

    public ListClubActivitiesRequest(long clubID, ClubRest restService, ClubAPI api) {
        this.clubID = clubID;
        this.restService = restService;
        this.api = api;
    }

    public ListClubActivitiesRequest before(int before) {
        this.before = before;
        return this;
    }

    public ListClubActivitiesRequest inPage(int page) {
        this.page = page;
        return this;
    }

    public ListClubActivitiesRequest perPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public List<Activity> execute() {
        Call<List<Activity>> call = restService.getClubActivities(clubID, before, page, perPage);
        return api.execute(call);
    }
}
