package com.sweetzpot.stravazpot.athlete.model;

public enum MeasurementPreference {
    FEET("feet"), METERS("meters");

    private String rawValue;

    MeasurementPreference(String rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public String toString() {
        return rawValue;
    }
}
