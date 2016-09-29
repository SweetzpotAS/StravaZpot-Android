package com.sweetzpot.stravazpot.segment.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.Gender;
import com.sweetzpot.stravazpot.common.model.Time;

import java.util.Date;

public class LeaderboardEntry {
    @SerializedName("athlete_name") private String athleteName;
    @SerializedName("athlete_id") private int athleteID;
    @SerializedName("athlete_gender") private Gender athleteGender;
    @SerializedName("average_hr") private float averageHeartRate;
    @SerializedName("average_watts") private float averageWatts;
    @SerializedName("distance") private Distance distance;
    @SerializedName("elapsed_time") private Time elapsedTime;
    @SerializedName("moving_time") private Time movingTime;
    @SerializedName("start_date") private Date startDate;
    @SerializedName("start_date_local") private Date startDateLocal;
    @SerializedName("activity_id") private int activityID;
    @SerializedName("effort_id") private int effortID;
    @SerializedName("rank") private int rank;
    @SerializedName("athlete_profile") private String athleteProfile;

    public String getAthleteName() {
        return athleteName;
    }

    public int getAthleteID() {
        return athleteID;
    }

    public Gender getAthleteGender() {
        return athleteGender;
    }

    public float getAverageHeartRate() {
        return averageHeartRate;
    }

    public float getAverageWatts() {
        return averageWatts;
    }

    public Distance getDistance() {
        return distance;
    }

    public Time getElapsedTime() {
        return elapsedTime;
    }

    public Time getMovingTime() {
        return movingTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getStartDateLocal() {
        return startDateLocal;
    }

    public int getActivityID() {
        return activityID;
    }

    public int getEffortID() {
        return effortID;
    }

    public int getRank() {
        return rank;
    }

    public String getAthleteProfile() {
        return athleteProfile;
    }
}
