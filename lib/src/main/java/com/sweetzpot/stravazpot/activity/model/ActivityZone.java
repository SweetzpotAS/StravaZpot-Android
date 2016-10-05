package com.sweetzpot.stravazpot.activity.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.common.model.ResourceState;
import com.sweetzpot.stravazpot.common.model.TimedInterval;

import java.util.List;

public class ActivityZone {
    @SerializedName("score") private int score;
    @SerializedName("distribution_buckets") private List<TimedInterval> distributionBuckets;
    @SerializedName("type") private String type;
    @SerializedName("resource_state") private ResourceState resourceState;
    @SerializedName("sensor_based") private boolean sensorBased;
    @SerializedName("points") private int points;
    @SerializedName("custom_zones") private boolean customZones;
    @SerializedName("max") private int max;

    public int getScore() {
        return score;
    }

    public List<TimedInterval> getDistributionBuckets() {
        return distributionBuckets;
    }

    public String getType() {
        return type;
    }

    public ResourceState getResourceState() {
        return resourceState;
    }

    public boolean isSensorBased() {
        return sensorBased;
    }

    public int getPoints() {
        return points;
    }

    public boolean hasCustomZones() {
        return customZones;
    }

    public int getMax() {
        return max;
    }
}
