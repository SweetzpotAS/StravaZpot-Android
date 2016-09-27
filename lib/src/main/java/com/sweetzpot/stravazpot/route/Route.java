package com.sweetzpot.stravazpot.route;

import com.sweetzpot.stravazpot.common.Distance;
import com.sweetzpot.stravazpot.common.ResourceState;
import com.sweetzpot.stravazpot.athlete.Athlete;
import com.sweetzpot.stravazpot.segment.Segment;

import java.util.List;

public class Route {
    private int ID;
    private ResourceState resourceState;
    private String name;
    private String description;
    private Athlete athlete;
    private Distance distance;
    private Distance elevationGain;
    private Map map;
    private RouteType type;
    private RouteSubtype subtype;
    private boolean isPrivate;
    private boolean starred;
    private long timestamp;
    private List<Segment> segments;

    public int getID() {
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
}
