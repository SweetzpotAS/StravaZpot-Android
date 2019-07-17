package com.sweetzpot.stravazpot.activity.request;

import com.sweetzpot.stravazpot.activity.api.ActivityAPI;
import com.sweetzpot.stravazpot.activity.model.Activity;
import com.sweetzpot.stravazpot.activity.rest.ActivityRest;

import java.util.List;

import retrofit2.Call;

public class ListRelatedActivitiesRequest {

    private final long activityID;
    private final ActivityRest restService;
    private final ActivityAPI api;
    private Integer page;
    private Integer perPage;

    public ListRelatedActivitiesRequest(long activityID, ActivityRest restService, ActivityAPI api) {
        this.activityID = activityID;
        this.restService = restService;
        this.api = api;
    }

    public ListRelatedActivitiesRequest inPage(int page) {
        this.page = page;
        return this;
    }

    public ListRelatedActivitiesRequest perPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public List<Activity> execute() {
        Call<List<Activity>> call = restService.getRelatedActivities(activityID, page, perPage);
        return api.execute(call);
    }

}
