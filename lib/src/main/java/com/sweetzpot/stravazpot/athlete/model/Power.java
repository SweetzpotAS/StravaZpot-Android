package com.sweetzpot.stravazpot.athlete.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.common.model.Interval;

import java.util.List;

public class Power {
    @SerializedName("zones") private List<Interval<Float>> zones;

    public List<Interval<Float>> getZones() {
        return zones;
    }
}
