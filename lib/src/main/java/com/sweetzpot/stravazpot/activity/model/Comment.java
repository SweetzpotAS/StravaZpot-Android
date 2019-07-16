package com.sweetzpot.stravazpot.activity.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.common.model.ResourceState;
import com.sweetzpot.stravazpot.athlete.model.Athlete;

import java.util.Date;

public class Comment {
    @SerializedName("id") private long ID;
    @SerializedName("resource_state") private ResourceState resourceState;
    @SerializedName("activity_id") private long activityID;
    @SerializedName("text") private String text;
    @SerializedName("athlete") private Athlete athlete;
    @SerializedName("created_at") private Date createdAt;

    public long getID() {
        return ID;
    }

    public ResourceState getResourceState() {
        return resourceState;
    }

    public long getActivityID() {
        return activityID;
    }

    public String getText() {
        return text;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
