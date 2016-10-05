package com.sweetzpot.stravazpot.activity.request;

import com.sweetzpot.stravazpot.activity.api.ActivityAPI;
import com.sweetzpot.stravazpot.activity.model.Activity;
import com.sweetzpot.stravazpot.activity.model.ActivityType;
import com.sweetzpot.stravazpot.activity.rest.ActivityRest;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.Time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;

public class CreateActivityRequest {

    private final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private final String name;
    private final ActivityRest restService;
    private final ActivityAPI api;
    private ActivityType type;
    private String startDate;
    private Time elapsedTime;
    private String description;
    private Distance distance;
    private Boolean isPrivate;
    private Boolean trainer;
    private Boolean commute;

    public CreateActivityRequest(String name, ActivityRest restService, ActivityAPI api) {
        this.name = name;
        this.restService = restService;
        this.api = api;
    }

    public CreateActivityRequest ofType(ActivityType type) {
        this.type = type;
        return this;
    }

    public CreateActivityRequest startingOn(Date startDate) {
        this.startDate = formatter.format(startDate);
        return this;
    }

    public CreateActivityRequest withElapsedTime(Time elapsedTime) {
        this.elapsedTime = elapsedTime;
        return this;
    }

    public CreateActivityRequest withDescription(String description) {
        this.description = description;
        return this;
    }

    public CreateActivityRequest withDistance(Distance distance) {
        this.distance = distance;
        return this;
    }

    public CreateActivityRequest isPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
        return this;
    }

    public CreateActivityRequest withTrainer(boolean trainer) {
        this.trainer = trainer;
        return this;
    }

    public CreateActivityRequest withCommute(boolean commute) {
        this.commute = commute;
        return this;
    }

    public Activity execute() {
        Call<Activity> call = restService.createActivity(name, type, startDate, elapsedTime,
                description, distance, boolToInt(isPrivate), boolToInt(trainer), boolToInt(commute));
        return api.execute(call);
    }

    private Integer boolToInt(Boolean booleanValue) {
        if(booleanValue == null) {
            return null;
        } else {
            return booleanValue ? 1 : 0;
        }
    }
}
