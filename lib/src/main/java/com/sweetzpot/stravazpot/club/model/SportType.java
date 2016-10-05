package com.sweetzpot.stravazpot.club.model;

public enum SportType {
    CYCLING("cycling"),
    RUNNING("running"),
    TRIATHLON("triathlon"),
    OTHER("other");

    private String rawValue;

    SportType(String rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public String toString() {
        return rawValue;
    }
}
