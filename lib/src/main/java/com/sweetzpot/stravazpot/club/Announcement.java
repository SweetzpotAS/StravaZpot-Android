package com.sweetzpot.stravazpot.club;

import com.sweetzpot.stravazpot.common.ResourceState;
import com.sweetzpot.stravazpot.athlete.Athlete;

import java.util.Date;

public class Announcement {
    private int ID;
    private ResourceState resourceState;
    private int clubID;
    private Athlete athlete;
    private Date createdAt;
    private String message;

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
