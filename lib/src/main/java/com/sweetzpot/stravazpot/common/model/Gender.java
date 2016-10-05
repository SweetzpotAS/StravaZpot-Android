package com.sweetzpot.stravazpot.common.model;

public enum Gender {
    MALE("M"),
    FEMALE("F"),
    NOT_DEFINED("null");

    private String representation;

    Gender(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return representation;
    }
}
