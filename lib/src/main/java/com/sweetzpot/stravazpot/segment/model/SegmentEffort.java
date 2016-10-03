package com.sweetzpot.stravazpot.segment.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.activity.model.Achievement;
import com.sweetzpot.stravazpot.activity.model.Activity;
import com.sweetzpot.stravazpot.athlete.model.Athlete;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.ResourceState;
import com.sweetzpot.stravazpot.common.model.Time;

import java.util.Date;
import java.util.List;

public class SegmentEffort {
    @SerializedName("id") private long ID;
    @SerializedName("resource_state") private ResourceState resourceState;
    @SerializedName("name") private String name;
    @SerializedName("activity") private Activity activity;
    @SerializedName("athlete") private Athlete athlete;
    @SerializedName("elapsed_time") private Time elapsedTime;
    @SerializedName("moving_time") private Time movingTime;
    @SerializedName("start_date") private Date startDate;
    @SerializedName("start_date_local") private Date startDateLocal;
    @SerializedName("distance") private Distance distance;
    @SerializedName("start_index") private int startIndex;
    @SerializedName("end_index") private int endIndex;
    @SerializedName("average_cadence") private float averageCadence;
    @SerializedName("average_watts") private float averageWatts;
    @SerializedName("device_watts") private boolean deviceWatts;
    @SerializedName("average_heartrate") private float averageHeartRate;
    @SerializedName("max_heartrate") private float maxHeartRate;
    @SerializedName("segment") private Segment segment;
    @SerializedName("kom_rank") private int komRank;
    @SerializedName("pr_rank") private int prRank;
    @SerializedName("hidden") private boolean hidden;
    @SerializedName("achievements") private List<Achievement> achievements;

    public long getID() {
        return ID;
    }

    public ResourceState getResourceState() {
        return resourceState;
    }

    public String getName() {
        return name;
    }

    public Activity getActivity() {
        return activity;
    }

    public Athlete getAthlete() {
        return athlete;
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

    public Distance getDistance() {
        return distance;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public float getAverageCadence() {
        return averageCadence;
    }

    public float getAverageWatts() {
        return averageWatts;
    }

    public boolean isDeviceWatts() {
        return deviceWatts;
    }

    public float getAverageHeartRate() {
        return averageHeartRate;
    }

    public float getMaxHeartRate() {
        return maxHeartRate;
    }

    public Segment getSegment() {
        return segment;
    }

    public int getKomRank() {
        return komRank;
    }

    public int getPrRank() {
        return prRank;
    }

    public boolean isHidden() {
        return hidden;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }
}
