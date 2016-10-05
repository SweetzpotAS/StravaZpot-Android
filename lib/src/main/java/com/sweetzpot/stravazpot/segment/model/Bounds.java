package com.sweetzpot.stravazpot.segment.model;

import com.sweetzpot.stravazpot.common.model.Coordinates;

public class Bounds {

    private final Coordinates southWest;
    private final Coordinates northEast;

    public static Bounds with(Coordinates southWest, Coordinates northEast) {
        return new Bounds(southWest, northEast);
    }

    public Bounds(Coordinates southWest, Coordinates northEast) {
        this.southWest = southWest;
        this.northEast = northEast;
    }

    @Override
    public String toString() {
        return southWest.getLatitude() + "," + southWest.getLongitude() + "," +
                northEast.getLatitude() + "," + northEast.getLongitude();
    }
}
