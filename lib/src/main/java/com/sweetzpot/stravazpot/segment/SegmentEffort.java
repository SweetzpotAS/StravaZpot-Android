package com.sweetzpot.stravazpot.segment;

import com.sweetzpot.stravazpot.Distance;
import com.sweetzpot.stravazpot.ResourceState;
import com.sweetzpot.stravazpot.Time;
import com.sweetzpot.stravazpot.athlete.Athlete;

import java.util.Date;

public class SegmentEffort {
    private long ID;
    private ResourceState resourceState;
    private String name;
    private Athlete athlete;
    private Time elapsedTime;
    private Time movingTime;
    private Date startDate;
    private Date startDateLocal;
    private Distance distance;
    private int startIndex;
    private int endIndex;
    private float averageCadence;
    private float averageWatts;
    private boolean deviceWatts;
    private float averageHeartRate;
    private int maxHeartRate;
    private Segment segment;
    private int komRank;
    private int prRank;
    private boolean hidden;

    public long getID() {
        return ID;
    }

    public ResourceState getResourceState() {
        return resourceState;
    }

    public String getName() {
        return name;
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

    public int getMaxHeartRate() {
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
}
