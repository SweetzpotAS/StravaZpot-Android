package com.sweetzpot.stravazpot.athlete;

import com.sweetzpot.stravazpot.Distance;
import com.sweetzpot.stravazpot.Time;

public class Totals {
    private int count;
    private Distance distance;
    private Time movingTime;
    private Time elapsedTime;
    private Distance elevationGain;
    private int achievementCount;

    public int getCount() {
        return count;
    }

    public Distance getDistance() {
        return distance;
    }

    public Time getMovingTime() {
        return movingTime;
    }

    public Time getElapsedTime() {
        return elapsedTime;
    }

    public Distance getElevationGain() {
        return elevationGain;
    }

    public int getAchievementCount() {
        return achievementCount;
    }
}
