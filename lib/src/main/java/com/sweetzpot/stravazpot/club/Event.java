package com.sweetzpot.stravazpot.club;

import com.sweetzpot.stravazpot.common.ResourceState;
import com.sweetzpot.stravazpot.activity.ActivityType;
import com.sweetzpot.stravazpot.athlete.Athlete;

import java.util.Date;
import java.util.List;

public class Event {
    private int ID;
    private ResourceState resourceState;
    private String title;
    private String description;
    private int clubID;
    private Athlete organizingAthlete;
    private ActivityType activityType;
    private Date createdAt;
    private int routeID;
    private boolean womanOnly;
    private boolean isPrivate;
    private SkillLevel skillLevel;
    private Terrain terrain;
    private List<Date> upcomingOccurrences;
    private String address;

    public int getID() {
        return ID;
    }

    public ResourceState getResourceState() {
        return resourceState;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getClubID() {
        return clubID;
    }

    public Athlete getOrganizingAthlete() {
        return organizingAthlete;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public int getRouteID() {
        return routeID;
    }

    public boolean isWomanOnly() {
        return womanOnly;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public List<Date> getUpcomingOccurrences() {
        return upcomingOccurrences;
    }

    public String getAddress() {
        return address;
    }
}
