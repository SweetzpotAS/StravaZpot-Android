package com.sweetzpot.stravazpot.route.model;

public enum RouteSubtype {
    ROAD(1),
    MTB(2),
    CX(3),
    TRAIL(4),
    MIXED(5);

    private int rawValue;

    RouteSubtype(int rawValue) {
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
