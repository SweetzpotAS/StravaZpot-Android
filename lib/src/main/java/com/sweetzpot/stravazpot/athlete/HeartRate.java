package com.sweetzpot.stravazpot.athlete;

import com.sweetzpot.stravazpot.common.Interval;

import java.util.List;

public class HeartRate {
    private boolean customZones;
    private List<Interval<Float>> zones;

    public boolean hasCustomZones() {
        return customZones;
    }

    public List<Interval<Float>> getZones() {
        return zones;
    }
}
