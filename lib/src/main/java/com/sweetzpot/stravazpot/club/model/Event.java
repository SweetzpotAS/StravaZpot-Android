package com.sweetzpot.stravazpot.club.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.common.model.ResourceState;
import com.sweetzpot.stravazpot.activity.model.ActivityType;
import com.sweetzpot.stravazpot.athlete.model.Athlete;

import java.util.Date;
import java.util.List;

public class Event {
    @SerializedName("id") private long ID;
    @SerializedName("resource_state") private ResourceState resourceState;
    @SerializedName("title") private String title;
    @SerializedName("description") private String description;
    @SerializedName("club_id") private long clubID;
    @SerializedName("organizing_athlete") private Athlete organizingAthlete;
    @SerializedName("activity_type") private ActivityType activityType;
    @SerializedName("created_at") private Date createdAt;
    @SerializedName("route_id") private long routeID;
    @SerializedName("women_only") private boolean womenOnly;
    @SerializedName("private") private boolean isPrivate;
    @SerializedName("skill_levels") private SkillLevel skillLevel;
    @SerializedName("terrain") private Terrain terrain;
    @SerializedName("upcoming_occurrences") private List<Date> upcomingOccurrences;
    @SerializedName("address") private String address;

    public long getID() {
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

    public long getClubID() {
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

    public long getRouteID() {
        return routeID;
    }

    public boolean isWomenOnly() {
        return womenOnly;
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
