package com.sweetzpot.stravazpot.club;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.common.ResourceState;
import com.sweetzpot.stravazpot.athlete.Athlete;

import java.util.Date;

public class Announcement {
    @SerializedName("id") private int ID;
    @SerializedName("resource_state") private ResourceState resourceState;
    @SerializedName("club_id") private int clubID;
    @SerializedName("athlete") private Athlete athlete;
    @SerializedName("created_at") private Date createdAt;
    @SerializedName("message") private String message;

    public int getID() {
        return ID;
    }

    public ResourceState getResourceState() {
        return resourceState;
    }

    public int getClubID() {
        return clubID;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getMessage() {
        return message;
    }
}
