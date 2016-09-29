package com.sweetzpot.stravazpot.stream.model;

public enum SeriesType {
    TIME("time"),
    DISTANCE("distance");

    private String rawValue;

    SeriesType(String rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public String toString() {
        return rawValue;
    }
}
