package com.sweetzpot.stravazpot.activity;

import com.sweetzpot.stravazpot.common.ResourceState;
import com.sweetzpot.stravazpot.athlete.Athlete;

import java.util.Date;

public class Comment {
    private int id;
    private ResourceState resourceState;
    private int activityID;
    private String text;
    private Athlete athlete;
    private Date createdAt;

    public int getId() {
        return id;
    }

    public ResourceState getResourceState() {
        return resourceState;
    }

    public int getActivityID() {
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
