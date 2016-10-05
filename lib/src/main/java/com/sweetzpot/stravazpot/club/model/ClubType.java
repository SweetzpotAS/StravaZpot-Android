package com.sweetzpot.stravazpot.club.model;

public enum ClubType {
    CASUAL_CLUB("casual_club"),
    RACING_TEAM("racing_team"),
    SHOP("shop"),
    COMPANY("company"),
    OTHER("other");

    private String rawValue;

    ClubType(String rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public String toString() {
        return rawValue;
    }
}
