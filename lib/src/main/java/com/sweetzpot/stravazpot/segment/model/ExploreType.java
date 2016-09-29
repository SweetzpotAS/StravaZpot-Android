package com.sweetzpot.stravazpot.segment.model;

public enum ExploreType {
    RUNNING("running"),
    RIDING("riding");

    private String rawType;

    ExploreType(String rawType) {
        this.rawType = rawType;
    }

    @Override
    public String toString() {
        return rawType;
    }
}
