package com.sweetzpot.stravazpot.activity.request;

import com.sweetzpot.stravazpot.activity.api.ActivityAPI;
import com.sweetzpot.stravazpot.activity.rest.ActivityRest;

import retrofit2.Call;

public class DeleteActivityRequest {

    private final long activityID;
    private final ActivityRest restService;
    private final ActivityAPI api;

    public DeleteActivityRequest(long activityID, ActivityRest restService, ActivityAPI api) {
        this.activityID = activityID;
        this.restService = restService;
        this.api = api;
    }

    public void execute() {
        Call<Void> call = restService.deleteActivity(activityID);
        api.execute(call);
    }
}
