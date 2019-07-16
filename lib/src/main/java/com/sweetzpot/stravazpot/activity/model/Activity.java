package com.sweetzpot.stravazpot.activity.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.athlete.model.Athlete;
import com.sweetzpot.stravazpot.common.model.Coordinates;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.ResourceState;
import com.sweetzpot.stravazpot.common.model.Speed;
import com.sweetzpot.stravazpot.common.model.Temperature;
import com.sweetzpot.stravazpot.common.model.Time;
import com.sweetzpot.stravazpot.gear.model.Gear;
import com.sweetzpot.stravazpot.route.model.Map;
import com.sweetzpot.stravazpot.segment.model.SegmentEffort;

import java.util.Date;
import java.util.List;

public class Activity {
    @SerializedName("id") private long ID;
    @SerializedName("resource_state") private ResourceState resourceState;
    @SerializedName("external_id") private String externalID;
    @SerializedName("upload_id") private long uploadID;
    @SerializedName("athlete") private Athlete athlete;
    @SerializedName("name") private String name;
    @SerializedName("description") private String description;
    @SerializedName("distance") private Distance distance;
    @SerializedName("moving_time") private Time movingTime;
    @SerializedName("elapsed_time") private Time elapsedTime;
    @SerializedName("total_elevation_gain") private Distance totalElevationGain;
    @SerializedName("elev_high") private Distance elevationHigh;
    @SerializedName("elev_low") private Distance elevationLow;
    @SerializedName("type") private ActivityType type;
    @SerializedName("start_date") private Date startDate;
    @SerializedName("start_date_local") private Date startDateLocal;
    @SerializedName("timezone") private String timezone;
    @SerializedName("start_latlng") private Coordinates startCoordinates;
    @SerializedName("end_latlng") private Coordinates endCoordinates;
    @SerializedName("achievement_count") private int achievementCount;
    @SerializedName("kudos_count") private int kudosCount;
    @SerializedName("comment_count") private int commentCount;
    @SerializedName("athlete_count") private int athleteCount;
    @SerializedName("photo_count") private int photoCount;
    @SerializedName("total_photo_count") private int totalPhotoCount;
    @SerializedName("photos") private PhotoSummary photos;
    @SerializedName("map") private Map map;
    @SerializedName("trainer") private boolean trainer;
    @SerializedName("commute") private boolean commute;
    @SerializedName("manual") private boolean manual;
    @SerializedName("private") private boolean isPrivate;
    @SerializedName("device_name") private String deviceName;
    @SerializedName("embed_token") private String embedToken;
    @SerializedName("flagged") private boolean flagged;
    @SerializedName("workout_type") private WorkoutType workoutType;
    @SerializedName("gear_id") private String gearID;
    @SerializedName("gear") private Gear gear;
    @SerializedName("average_speed") private Speed averageSpeed;
    @SerializedName("max_speed") private Speed maxSpeed;
    @SerializedName("average_cadence") private float averageCadence;
    @SerializedName("average_temp") private Temperature averageTemperature;
    @SerializedName("average_watts") private float averageWatts;
    @SerializedName("max_watts") private int maxWatts;
    @SerializedName("weighted_average_watts") private int weightedAverageWatts;
    @SerializedName("kilojoules") private float kilojoules;
    @SerializedName("device_watts") private boolean deviceWatts;
    @SerializedName("has_heartrate") private boolean hasHeartRate;
    @SerializedName("average_heartrate") private float averageHeartRate;
    @SerializedName("max_heartrate") private int maxHeartRate;
    @SerializedName("calories") private float calories;
    @SerializedName("suffer_score") private int sufferScore;
    @SerializedName("has_kudoed") private boolean hasKudoed;
    @SerializedName("segment_efforts") private List<SegmentEffort> segmentEfforts;
    @SerializedName("best_efforts") private List<SegmentEffort> bestEfforts;
    @SerializedName("splits_metric") private List<Split> splitsMetric;
    @SerializedName("splits_standard") private List<Split> splitsStandard;

    public long getID() {
        return ID;
    }

    public ResourceState getResourceState() {
        return resourceState;
    }

    public String getExternalID() {
        return externalID;
    }

    public long getUploadID() {
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

    public boolean hasKudoed() {
        return hasKudoed;
    }

    public List<SegmentEffort> getSegmentEfforts() {
        return segmentEfforts;
    }

    public List<SegmentEffort> getBestEfforts() {
        return bestEfforts;
    }

    public List<Split> getSplitsMetric() {
        return splitsMetric;
    }

    public List<Split> getSplitsStandard() {
        return splitsStandard;
    }
}
