package com.sweetzpot.stravazpot.gear.model;

public enum FrameType {
    MTB(1),
    CROSS(2),
    ROAD(3),
    TIME_TRIAL(4);

    private int rawValue;

    FrameType(int rawValue) {
        this.rawValue = rawValue;
    }

    public int getRawValue() {
        return rawValue;
    }

    @Override
    public String toString() {
        return String.valueOf(rawValue);
    }
}
