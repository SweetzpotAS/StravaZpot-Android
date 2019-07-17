package com.sweetzpot.stravazpot.activity.request;

import com.sweetzpot.stravazpot.activity.api.ActivityAPI;
import com.sweetzpot.stravazpot.activity.model.ActivityZone;
import com.sweetzpot.stravazpot.activity.rest.ActivityRest;

import java.util.List;

import retrofit2.Call;

public class ListActivityZonesRequest {

    private final long activityID;
    private final ActivityRest restService;
    private final ActivityAPI api;

    public ListActivityZonesRequest(long activityID, ActivityRest restService, ActivityAPI api) {
        this.activityID = activityID;
        this.restService = restService;
        this.api = api;
    }

    public List<ActivityZone> execute() {
        Call<List<ActivityZone>> call = restService.getActivityZones(activityID);
        return api.execute(call);
    }
}
