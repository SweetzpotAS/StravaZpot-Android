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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (Float.compare(that.latitude, latitude) != 0) return false;
        return Float.compare(that.longitude, longitude) == 0;

    }

    @Override
    public int hashCode() {
        int result = (latitude != +0.0f ? Float.floatToIntBits(latitude) : 0);
        result = 31 * result + (longitude != +0.0f ? Float.floatToIntBits(longitude) : 0);
        return result;
    }
}
