package com.sweetzpot.stravazpot.athlete.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.club.model.Club;
import com.sweetzpot.stravazpot.common.model.Gender;
import com.sweetzpot.stravazpot.common.model.ResourceState;
import com.sweetzpot.stravazpot.gear.model.Gear;

import java.util.Date;
import java.util.List;

public class Athlete {
    @SerializedName("id") private long ID;
    @SerializedName("resource_state") private ResourceState resourceState;
    @SerializedName("firstname") private String firstName;
    @SerializedName("lastname") private String lastName;
    @SerializedName("profile_medium") private String profileMedium;
    @SerializedName("profile") private String profile;
    @SerializedName("city") private String city;
    @SerializedName("state") private String state;
    @SerializedName("country") private String country;
    @SerializedName("sex") private Gender sex;
    @SerializedName("friend") private FriendStatus friend;
    @SerializedName("follower") private FriendStatus follower;
    @SerializedName("premium") private boolean premium;
    @SerializedName("created_at") private Date createdAt;
    @SerializedName("updated_at") private Date updatedAt;
    @SerializedName("follower_count") private int followerCount;
    @SerializedName("friend_count") private int friendCount;
    @SerializedName("mutual_friend_count") private int mutualFriendCount;
    @SerializedName("athlete_type") private AthleteType athleteType;
    @SerializedName("date_preference") private String datePreference;
    @SerializedName("measurement_preference") private MeasurementPreference measurementPreference;
    @SerializedName("email") private String email;
    @SerializedName("ftp") private int ftp;
    @SerializedName("weight") private float weight;
    @SerializedName("clubs") private List<Club> clubs;
    @SerializedName("bikes") private List<Gear> bikes;
    @SerializedName("shoes") private List<Gear> shoes;

    public long getID() {
        return ID;
    }

    public ResourceState getResourceState() {
        return resourceState;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getProfileMedium() {
        return profileMedium;
    }

    public String getProfile() {
        return profile;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public Gender getSex() {
        return sex;
    }

    public FriendStatus getFriend() {
        return friend;
    }

    public FriendStatus getFollower() {
        return follower;
    }

    public boolean isPremium() {
        return premium;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public int getFriendCount() {
        return friendCount;
    }

    public int getMutualFriendCount() {
        return mutualFriendCount;
    }

    public AthleteType getAthleteType() {
        return athleteType;
    }

    public String getDatePreference() {
        return datePreference;
    }

    public MeasurementPreference getMeasurementPreference() {
        return measurementPreference;
    }

    public String getEmail() {
        return email;
    }

    public int getFtp() {
        return ftp;
    }

    public float getWeight() {
        return weight;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public List<Gear> getBikes() {
        return bikes;
    }

    public List<Gear> getShoes() {
        return shoes;
    }
}
