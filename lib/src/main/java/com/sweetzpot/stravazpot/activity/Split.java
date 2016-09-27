package com.sweetzpot.stravazpot.activity;

import com.sweetzpot.stravazpot.common.Distance;
import com.sweetzpot.stravazpot.common.Time;

public class Split {
    private Distance distance;
    private Time elapsedTime;
    private Distance elevationDifference;
    private Time movingTime;
    private int split;

    public Distance getDistance() {
        return distance;
    }

    public Time getElapsedTime() {
        return elapsedTime;
    }

    public Distance getElevationDifference() {
        return elevationDifference;
    }

    public Time getMovingTime() {
        return movingTime;
    }

    public int getSplit() {
        return split;
    }
}
