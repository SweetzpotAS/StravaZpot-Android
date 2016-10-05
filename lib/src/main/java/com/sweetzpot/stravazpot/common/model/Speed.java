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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Speed speed = (Speed) o;

        return Float.compare(speed.metersPerSecond, metersPerSecond) == 0;

    }

    @Override
    public int hashCode() {
        return (metersPerSecond != +0.0f ? Float.floatToIntBits(metersPerSecond) : 0);
    }
}
