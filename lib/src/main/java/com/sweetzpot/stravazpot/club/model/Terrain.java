package com.sweetzpot.stravazpot.club.model;

public enum Terrain {
    MOSTLY_FLAT(0),
    ROLLING_HILLS(1),
    KILLER_CLIMBS(2);

    private int rawValue;

    Terrain(int rawValue) {
        this.rawValue = rawValue;
    }

    public int getRawValue() {
        return rawValue;
    }
}
