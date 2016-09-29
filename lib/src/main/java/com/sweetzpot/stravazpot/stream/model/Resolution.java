package com.sweetzpot.stravazpot.stream.model;

public enum Resolution {
    LOW("low"),
    MEDIUM("medium"),
    HIGH("high");

    private String rawValue;

    Resolution(String rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public String toString() {
        return rawValue;
    }
}
