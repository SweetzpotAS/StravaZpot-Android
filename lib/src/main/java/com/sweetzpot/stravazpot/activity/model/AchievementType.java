package com.sweetzpot.stravazpot.activity.model;

public enum AchievementType {
    OVERALL(2),
    PR(3),
    YEAR_OVERALL(5);

    private int rawValue;

    AchievementType(int rawValue) {
        this.rawValue = rawValue;
    }

    public int getRawValue() {
        return rawValue;
    }
}
