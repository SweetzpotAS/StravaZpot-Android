package com.sweetzpot.stravazpot.athlete.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.Time;

public class Totals {
    @SerializedName("count") private int count;
    @SerializedName("distance") private Distance distance;
    @SerializedName("moving_time") private Time movingTime;
    @SerializedName("elapsed_time") private Time elapsedTime;
    @SerializedName("elevation_gain") private Distance elevationGain;
    @SerializedName("achievement_count") private int achievementCount;

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
