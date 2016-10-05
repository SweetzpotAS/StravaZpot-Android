package com.sweetzpot.stravazpot.athlete.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.common.model.Interval;

import java.util.List;

public class HeartRate {
    @SerializedName("custom_zones") private boolean customZones;
    @SerializedName("zones") private List<Interval<Float>> zones;

    public boolean hasCustomZones() {
        return customZones;
    }

    public List<Interval<Float>> getZones() {
        return zones;
    }
}
