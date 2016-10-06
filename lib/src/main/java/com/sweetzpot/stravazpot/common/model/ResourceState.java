package com.sweetzpot.stravazpot.common.model;

public enum ResourceState {
    META(1), SUMMARY(2), DETAILED(3);

    private int rawValue;

    ResourceState(int rawValue) {
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
