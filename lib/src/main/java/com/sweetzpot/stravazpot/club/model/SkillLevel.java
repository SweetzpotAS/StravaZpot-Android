package com.sweetzpot.stravazpot.club.model;

public enum SkillLevel {
    CASUAL(1),
    TEMPO(2),
    HAMMERFEST(4);

    private int rawValue;

    SkillLevel(int rawValue) {
        this.rawValue = rawValue;
    }

    public int getRawValue() {
        return rawValue;
    }
}
