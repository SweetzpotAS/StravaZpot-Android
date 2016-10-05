package com.sweetzpot.stravazpot.common.model;

public class Distance {
    private float meters;

    public static Distance meters(float meters) {
        return new Distance(meters);
    }

    public Distance(float meters) {
        this.meters = meters;
    }

    public float getMeters() {
        return meters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Distance distance = (Distance) o;

        return Float.compare(distance.meters, meters) == 0;

    }

    @Override
    public int hashCode() {
        return (meters != +0.0f ? Float.floatToIntBits(meters) : 0);
    }

    @Override
    public String toString() {
        return String.valueOf(meters);
    }
}
