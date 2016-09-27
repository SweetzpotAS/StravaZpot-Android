package com.sweetzpot.stravazpot.activity;

import com.sweetzpot.stravazpot.athlete.Athlete;
import com.sweetzpot.stravazpot.common.Coordinates;
import com.sweetzpot.stravazpot.common.Distance;
import com.sweetzpot.stravazpot.common.ResourceState;
import com.sweetzpot.stravazpot.common.Speed;
import com.sweetzpot.stravazpot.common.Temperature;
import com.sweetzpot.stravazpot.common.Time;
import com.sweetzpot.stravazpot.gear.Gear;
import com.sweetzpot.stravazpot.route.Map;
import com.sweetzpot.stravazpot.segment.SegmentEffort;

import java.util.Date;
import java.util.List;

public class Activity {
    private int ID;
    private ResourceState resourceState;
    private String externalID;
    private int uploadID;
    private Athlete athlete;
    private String name;
    private String description;
    private Distance distance;
    private Time movingTime;
    private Time elapsedTime;
    private Distance totalElevationGain;
    private Distance elevationHigh;
    private Distance elevationLow;
    private ActivityType type;
    private Date startDate;
    private Date startDateLocal;
    private String timezone;
    private Coordinates startCoordinates;
    private Coordinates endCoordinates;
    private int achievementCount;
    private int kudosCount;
    private int commentCount;
    private int athleteCount;
    private int photoCount;
    private int totalPhotoCount;
    private PhotoSummary photos;
    private Map map;
    private boolean trainer;
    private boolean commute;
    private boolean manual;
    private boolean isPrivate;
    private String deviceName;
    private String embedToken;
    private boolean flagged;
    private WorkoutType workoutType;
    private String gearID;
    private Gear gear;
    private Speed averageSpeed;
    private Speed maxSpeed;
    private float averageCadence;
    private Temperature averageTemperature;
    private float averageWatts;
    private int maxWatts;
    private int weightedAverageWatts;
    private float kilojoules;
    private boolean deviceWatts;
    private boolean hasHeartRate;
    private float averageHeartRate;
    private int maxHeartRate;
    private float calories;
    private int sufferScore;
    private boolean hasKudoed;
    private List<SegmentEffort> segmentEfforts;
    private List<SegmentEffort> bestEfforts;

    public int getID() {
        return ID;
    }

    public ResourceState getResourceState() {
        return resourceState;
    }

    public String getExternalID() {
        return externalID;
    }

    public int getUploadID() {
        return uploadID;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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

    public Distance getTotalElevationGain() {
        return totalElevationGain;
    }

    public Distance getElevationHigh() {
        return elevationHigh;
    }

    public Distance getElevationLow() {
        return elevationLow;
    }

    public ActivityType getType() {
        return type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getStartDateLocal() {
        return startDateLocal;
    }

    public String getTimezone() {
        return timezone;
    }

    public Coordinates getStartCoordinates() {
        return startCoordinates;
    }

    public Coordinates getEndCoordinates() {
        return endCoordinates;
    }

    public int getAchievementCount() {
        return achievementCount;
    }

    public int getKudosCount() {
        return kudosCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public int getAthleteCount() {
        return athleteCount;
    }

    public int getPhotoCount() {
        return photoCount;
    }

    public int getTotalPhotoCount() {
        return totalPhotoCount;
    }

    public PhotoSummary getPhotos() {
        return photos;
    }

    public Map getMap() {
        return map;
    }

    public boolean isTrainer() {
        return trainer;
    }

    public boolean isCommute() {
        return commute;
    }

    public boolean isManual() {
        return manual;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getEmbedToken() {
        return embedToken;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public String getGearID() {
        return gearID;
    }

    public Gear getGear() {
        return gear;
    }

    public Speed getAverageSpeed() {
        return averageSpeed;
    }

    public Speed getMaxSpeed() {
        return maxSpeed;
    }

    public float getAverageCadence() {
        return averageCadence;
    }

    public Temperature getAverageTemperature() {
        return averageTemperature;
    }

    public float getAverageWatts() {
        return averageWatts;
    }

    public int getMaxWatts() {
        return maxWatts;
    }

    public int getWeightedAverageWatts() {
        return weightedAverageWatts;
    }

    public float getKilojoules() {
        return kilojoules;
    }

    public boolean isDeviceWatts() {
        return deviceWatts;
    }

    public boolean isHasHeartRate() {
        return hasHeartRate;
    }

    public float getAverageHeartRate() {
        return averageHeartRate;
    }

    public int getMaxHeartRate() {
        return maxHeartRate;
    }

    public float getCalories() {
        return calories;
    }

    public int getSufferScore() {
        return sufferScore;
    }

    public boolean isHasKudoed() {
        return hasKudoed;
    }

    public List<SegmentEffort> getSegmentEfforts() {
        return segmentEfforts;
    }

    public List<SegmentEffort> getBestEfforts() {
        return bestEfforts;
    }
}
