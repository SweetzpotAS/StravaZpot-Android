package com.sweetzpot.stravazpot.athlete.model;

public enum AthleteType {
    CYCLIST(0), RUNNER(1);

    private int rawValue;

    AthleteType(int rawValue) {
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
