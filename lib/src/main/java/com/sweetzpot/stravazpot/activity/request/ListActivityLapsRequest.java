package com.sweetzpot.stravazpot.activity.request;

import com.sweetzpot.stravazpot.activity.api.ActivityAPI;
import com.sweetzpot.stravazpot.activity.model.ActivityLap;
import com.sweetzpot.stravazpot.activity.rest.ActivityRest;

import java.util.List;

import retrofit2.Call;

public class ListActivityLapsRequest {

    private final long activityID;
    private final ActivityRest restService;
    private final ActivityAPI api;

    public ListActivityLapsRequest(long activityID, ActivityRest restService, ActivityAPI api) {
        this.activityID = activityID;
        this.restService = restService;
        this.api = api;
    }

    public List<ActivityLap> execute() {
        Call<List<ActivityLap>> call = restService.getActivityLaps(activityID);
        return api.execute(call);
    }
}
