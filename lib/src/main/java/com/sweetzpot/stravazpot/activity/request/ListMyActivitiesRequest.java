package com.sweetzpot.stravazpot.activity.request;

import com.sweetzpot.stravazpot.activity.api.ActivityAPI;
import com.sweetzpot.stravazpot.activity.model.Activity;
import com.sweetzpot.stravazpot.activity.rest.ActivityRest;
import com.sweetzpot.stravazpot.common.model.Time;

import java.util.List;

import retrofit2.Call;

public class ListMyActivitiesRequest {

    private final ActivityRest restService;
    private final ActivityAPI api;
    private Time before;
    private Time after;
    private Integer page;
    private Integer perPage;

    public ListMyActivitiesRequest(ActivityRest restService, ActivityAPI api) {
        this.restService = restService;
        this.api = api;
    }

    public ListMyActivitiesRequest before(Time before) {
        this.before = before;
        return this;
    }

    public ListMyActivitiesRequest after(Time after) {
        this.after = after;
        return this;
    }

    public ListMyActivitiesRequest inPage(int page) {
        this.page = page;
        return this;
    }

    public ListMyActivitiesRequest perPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public List<Activity> execute() {
        Call<List<Activity>> call = restService.getMyActivities(before, after, page, perPage);
        return api.execute(call);
    }

}
