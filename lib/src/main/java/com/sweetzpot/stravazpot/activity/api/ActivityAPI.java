package com.sweetzpot.stravazpot.activity.api;

import com.sweetzpot.stravazpot.activity.request.CreateActivityRequest;
import com.sweetzpot.stravazpot.activity.request.DeleteActivityRequest;
import com.sweetzpot.stravazpot.activity.request.GetActivityRequest;
import com.sweetzpot.stravazpot.activity.request.ListActivityLapsRequest;
import com.sweetzpot.stravazpot.activity.request.ListActivityZonesRequest;
import com.sweetzpot.stravazpot.activity.request.ListFriendActivitiesRequest;
import com.sweetzpot.stravazpot.activity.request.ListMyActivitiesRequest;
import com.sweetzpot.stravazpot.activity.request.ListRelatedActivitiesRequest;
import com.sweetzpot.stravazpot.activity.request.UpdateActivityRequest;
import com.sweetzpot.stravazpot.activity.rest.ActivityRest;
import com.sweetzpot.stravazpot.common.api.StravaAPI;
import com.sweetzpot.stravazpot.common.api.StravaConfig;

public class ActivityAPI extends StravaAPI {

    public ActivityAPI(StravaConfig config) {
        super(config);
    }

    public CreateActivityRequest createActivity(String name) {
        return new CreateActivityRequest(name, getAPI(ActivityRest.class), this);
    }

    public GetActivityRequest getActivity(long activityID) {
        return new GetActivityRequest(activityID, getAPI(ActivityRest.class), this);
    }

    public UpdateActivityRequest updateActivity(long activityID) {
        return new UpdateActivityRequest(activityID, getAPI(ActivityRest.class), this);
    }

    public DeleteActivityRequest deleteActivity(long activityID) {
        return new DeleteActivityRequest(activityID, getAPI(ActivityRest.class), this);
    }

    public ListMyActivitiesRequest listMyActivities() {
        return new ListMyActivitiesRequest(getAPI(ActivityRest.class), this);
    }

    public ListFriendActivitiesRequest listFriendActivities() {
        return new ListFriendActivitiesRequest(getAPI(ActivityRest.class), this);
    }

    public ListRelatedActivitiesRequest listRelatedActivities(long activityID) {
        return new ListRelatedActivitiesRequest(activityID, getAPI(ActivityRest.class), this);
    }

    public ListActivityZonesRequest listActivityZones(long activityID) {
        return new ListActivityZonesRequest(activityID, getAPI(ActivityRest.class), this);
    }

    public ListActivityLapsRequest listActivityLaps(long activityID) {
        return new ListActivityLapsRequest(activityID, getAPI(ActivityRest.class), this);
    }
}
