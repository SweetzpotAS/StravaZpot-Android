package com.sweetzpot.stravazpot.route;

import com.sweetzpot.stravazpot.ResourceState;

public class Map {
    private int ID;
    private ResourceState resourceState;
    private String summaryPolyline;

    public int getID() {
        return ID;
    }

    public ResourceState getResourceState() {
        return resourceState;
    }

    public String getSummaryPolyline() {
        return summaryPolyline;
    }
}
