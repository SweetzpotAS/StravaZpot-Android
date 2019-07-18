package com.sweetzpot.stravazpot.segment.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.common.model.Coordinates;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.Percentage;
import com.sweetzpot.stravazpot.common.model.ResourceState;
import com.sweetzpot.stravazpot.activity.model.ActivityType;
import com.sweetzpot.stravazpot.route.model.Map;

import java.util.Date;

public class Segment {
    @SerializedName("id") private long ID;
    @SerializedName("resource_state") private ResourceState resourceState;
    @SerializedName("name") private String name;
    @SerializedName("activity_type") private ActivityType activityType;
    @SerializedName("distance") private Distance distance;
    @SerializedName("average_grade") private Percentage averageGrade;
    @SerializedName("maximum_grade") private Percentage maximumGrade;
    @SerializedName("elevation_high") private Distance elevationHigh;
    @SerializedName("elevation_low") private Distance elevationLow;
    @SerializedName("start_latlng") private Coordinates startCoordinates;
    @SerializedName("end_latlng") private Coordinates endCoordinates;
    @SerializedName("climb_category") private int climbCategory;
    @SerializedName("city") private String city;
    @SerializedName("state") private String state;
    @SerializedName("country") private String country;
    @SerializedName("private") private boolean isPrivate;
    @SerializedName("starred") private boolean starred;
    @SerializedName("created_at") private Date createdAt;
    @SerializedName("updated_at") private Date updatedAt;
    @SerializedName("total_elevation_gain") private Distance totalElevationGain;
    @SerializedName("map") private Map map;
    @SerializedName("effort_count") private int effortCount;
    @SerializedName("athlete_count") private int athleteCount;
    @SerializedName("hazardous") private boolean hazardous;
    @SerializedName("star_count") private int starCount;

    public long getID() {
        return ID;
    }

    public ResourceState getResourceState() {
        return resourceState;
    }

    public String getName() {
        return name;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public Distance getDistance() {
        return distance;
    }

    public Percentage getAverageGrade() {
        return averageGrade;
    }

    public Percentage getMaximumGrade() {
        return maximumGrade;
    }

    public Distance getElevationHigh() {
        return elevationHigh;
    }

    public Distance getElevationLow() {
        return elevationLow;
    }

    public Coordinates getStartCoordinates() {
        return startCoordinates;
    }

    public Coordinates getEndCoordinates() {
        return endCoordinates;
    }

    public int getClimbCategory() {
        return climbCategory;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public boolean isStarred() {
        return starred;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Distance getTotalElevationGain() {
        return totalElevationGain;
    }

    public Map getMap() {
        return map;
    }

    public int getEffortCount() {
        return effortCount;
    }

    public int getAthleteCount() {
        return athleteCount;
    }

    public boolean isHazardous() {
        return hazardous;
    }

    public int getStarCount() {
        return starCount;
    }
}
