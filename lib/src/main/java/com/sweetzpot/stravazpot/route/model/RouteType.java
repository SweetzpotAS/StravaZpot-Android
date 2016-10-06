package com.sweetzpot.stravazpot.route.model;

public enum RouteType {
    RIDE(1),
    RUN(2);

    private int rawValue;

    RouteType(int rawValue) {
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
