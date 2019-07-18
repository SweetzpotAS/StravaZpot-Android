package com.sweetzpot.stravazpot.activity.request;

import com.sweetzpot.stravazpot.activity.api.ActivityAPI;
import com.sweetzpot.stravazpot.activity.model.Activity;
import com.sweetzpot.stravazpot.activity.rest.ActivityRest;

import retrofit2.Call;

public class GetActivityRequest {

    private final long activityID;
    private final ActivityRest restService;
    private final ActivityAPI api;
    private Boolean includeAllEfforts;

    public GetActivityRequest(long activityID, ActivityRest restService, ActivityAPI api) {
        this.activityID = activityID;
        this.restService = restService;
        this.api = api;
    }

    public GetActivityRequest includeAllEfforts(boolean includeAllEfforts) {
        this.includeAllEfforts = includeAllEfforts;
        return this;
    }

    public Activity execute() {
        Call<Activity> call = restService.getActivity(activityID, includeAllEfforts);
        return api.execute(call);
    }
}
