package com.sweetzpot.stravazpot.route.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.ResourceState;
import com.sweetzpot.stravazpot.athlete.model.Athlete;
import com.sweetzpot.stravazpot.segment.model.Segment;

import java.util.List;

public class Route {
    @SerializedName("id") private long ID;
    @SerializedName("resource_state") private ResourceState resourceState;
    @SerializedName("name") private String name;
    @SerializedName("description") private String description;
    @SerializedName("athlete") private Athlete athlete;
    @SerializedName("distance") private Distance distance;
    @SerializedName("elevation_gain") private Distance elevationGain;
    @SerializedName("map") private Map map;
    @SerializedName("type") private RouteType type;
    @SerializedName("sub_type") private RouteSubtype subtype;
    @SerializedName("private") private boolean isPrivate;
    @SerializedName("starred") private boolean starred;
    @SerializedName("timestamp") private long timestamp;
    @SerializedName("segments") private List<Segment> segments;
    @SerializedName("estimated_moving_time") private int estimatedMovingTime;

    public long getID() {
        return ID;
    }

    public ResourceState getResourceState() {
        return resourceState;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public Distance getDistance() {
        return distance;
    }

    public Distance getElevationGain() {
        return elevationGain;
    }

    public Map getMap() {
        return map;
    }

    public RouteType getType() {
        return type;
    }

    public RouteSubtype getSubtype() {
        return subtype;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public boolean isStarred() {
        return starred;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public int getEstimatedMovingTime() {
        return estimatedMovingTime;
    }
}
