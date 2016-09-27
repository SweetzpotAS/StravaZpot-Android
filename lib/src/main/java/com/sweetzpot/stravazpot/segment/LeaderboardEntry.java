package com.sweetzpot.stravazpot.segment;

import com.sweetzpot.stravazpot.Distance;
import com.sweetzpot.stravazpot.Gender;
import com.sweetzpot.stravazpot.Time;

import java.util.Date;

public class LeaderboardEntry {
    private String athleteName;
    private int athleteID;
    private Gender athleteGender;
    private float averageHeartRate;
    private float averageWatts;
    private Distance distance;
    private Time elapsedTime;
    private Time movingTime;
    private Date startDate;
    private Date startDateLocal;
    private int activityID;
    private int effortID;
    private int rank;
    private String athleteProfile;

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
