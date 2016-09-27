package com.sweetzpot.stravazpot.segment;

import com.sweetzpot.stravazpot.common.Coordinates;
import com.sweetzpot.stravazpot.common.Distance;
import com.sweetzpot.stravazpot.common.Percentage;
import com.sweetzpot.stravazpot.common.ResourceState;
import com.sweetzpot.stravazpot.activity.ActivityType;
import com.sweetzpot.stravazpot.route.Map;

import java.util.Date;

public class Segment {
    private int ID;
    private ResourceState resourceState;
    private String name;
    private ActivityType activityType;
    private Distance distance;
    private Percentage averageGrade;
    private Percentage maximumGrade;
    private Distance elevationHigh;
    private Distance elevationLow;
    private Coordinates startCoordinates;
    private Coordinates endCoordinates;
    private int climbCategory;
    private String city;
    private String state;
    private String country;
    private boolean isPrivate;
    private boolean starred;
    private Date createdAt;
    private Date updatedAt;
    private Distance totalElevationGain;
    private Map map;
    private int effortCount;
    private int athleteCount;
    private boolean hazardous;
    private int starCount;

    public int getID() {
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
