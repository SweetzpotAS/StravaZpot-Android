package com.sweetzpot.stravazpot.club;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.common.ResourceState;
import com.sweetzpot.stravazpot.activity.ActivityType;
import com.sweetzpot.stravazpot.athlete.Athlete;

import java.util.Date;
import java.util.List;

public class Event {
    @SerializedName("id") private int ID;
    @SerializedName("resource_state") private ResourceState resourceState;
    @SerializedName("title") private String title;
    @SerializedName("description") private String description;
    @SerializedName("club_id") private int clubID;
    @SerializedName("organizing_athlete") private Athlete organizingAthlete;
    @SerializedName("activity_type") private ActivityType activityType;
    @SerializedName("created_at") private Date createdAt;
    @SerializedName("route_id") private int routeID;
    @SerializedName("woman_only") private boolean womanOnly;
    @SerializedName("private") private boolean isPrivate;
    @SerializedName("skill_levels") private SkillLevel skillLevel;
    @SerializedName("terrain") private Terrain terrain;
    @SerializedName("upcoming_occurrences") private List<Date> upcomingOccurrences;
    @SerializedName("address") private String address;

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
