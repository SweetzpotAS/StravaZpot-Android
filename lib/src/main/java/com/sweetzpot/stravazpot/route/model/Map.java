package com.sweetzpot.stravazpot.route.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.common.model.ResourceState;

public class Map {
    @SerializedName("id") private int ID;
    @SerializedName("resource_state") private ResourceState resourceState;
    @SerializedName("summary_polyline") private String summaryPolyline;

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
