package com.sweetzpot.stravazpot.common.model;

public class Coordinates {
    private float latitude;
    private float longitude;

    public static Coordinates at(float latitude, float longitude) {
        return new Coordinates(latitude, longitude);
    }

    public Coordinates(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }
}
