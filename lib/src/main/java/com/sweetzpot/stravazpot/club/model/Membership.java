package com.sweetzpot.stravazpot.club.model;

public enum Membership {
    MEMBER("member"),
    PENDING("pending"),
    NOT_MEMBER("null");

    private String rawType;

    Membership(String rawType) {
        this.rawType = rawType;
    }

    @Override
    public String toString() {
        return rawType;
    }
}
