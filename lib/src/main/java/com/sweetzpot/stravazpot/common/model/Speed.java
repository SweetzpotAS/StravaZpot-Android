package com.sweetzpot.stravazpot.common.model;

public class Speed {
    private float metersPerSecond;

    public static Speed metersPerSecond(float metersPerSecond) {
        return new Speed(metersPerSecond);
    }

    public Speed(float metersPerSecond) {
        this.metersPerSecond = metersPerSecond;
    }

    public float getMetersPerSecond() {
        return metersPerSecond;
    }
}
