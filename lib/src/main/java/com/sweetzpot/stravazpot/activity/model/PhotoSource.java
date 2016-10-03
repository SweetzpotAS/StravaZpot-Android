package com.sweetzpot.stravazpot.activity.model;

public enum PhotoSource {
    STRAVA(1),
    INSTAGRAM(2);

    private int rawValue;

    PhotoSource(int rawValue) {
        this.rawValue = rawValue;
    }

    public int getRawValue() {
        return rawValue;
    }
}
