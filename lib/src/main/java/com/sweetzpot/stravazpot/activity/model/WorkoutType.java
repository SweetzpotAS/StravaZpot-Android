package com.sweetzpot.stravazpot.activity.model;

public enum WorkoutType {
    RUN_DEFAULT(0),
    RUN_RACE(1),
    RUN_LONGRUN(2),
    RUN_WORKOUT(3),
    RIDE_DEFAULT(10),
    RIDE_RACE(11),
    RIDE_WORKOUT(12);

    private int rawValue;

    WorkoutType(int rawValue) {
        this.rawValue = rawValue;
    }

    public int getRawValue() {
        return rawValue;
    }
}
