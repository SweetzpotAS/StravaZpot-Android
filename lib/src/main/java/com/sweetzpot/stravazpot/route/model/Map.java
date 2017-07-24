package com.sweetzpot.stravazpot.route.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.common.model.ResourceState;

public class Map {
    @SerializedName("id") private String ID;
    @SerializedName("resource_state") private ResourceState resourceState;
    @SerializedName("summary_polyline") private String summaryPolyline;
    @SerializedName("polyline") private String polyline;

    public String getID() {
        return ID;
    }

    public ResourceState getResourceState() {
        return resourceState;
    }

    public String getSummaryPolyline() {
        return summaryPolyline;
    }

    public String getPolyline() {
        return polyline;
    }
}
