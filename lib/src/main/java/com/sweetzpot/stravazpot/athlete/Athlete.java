package com.sweetzpot.stravazpot.athlete;

import com.sweetzpot.stravazpot.Gender;
import com.sweetzpot.stravazpot.ResourceState;

import java.util.Date;

public class Athlete {
    private long id;
    private ResourceState resourceState;
    private String firstName;
    private String lastName;
    private String profileMedium;
    private String profile;
    private String city;
    private String state;
    private String country;
    private Gender sex;
    private FriendStatus friend;
    private FriendStatus follower;
    private boolean premium;
    private Date createdAt;
    private Date updatedAt;
    private int followerCount;
    private int friendCount;
    private int mutualFriendCount;
    private AthleteType athleteType;
    private String datePreference;
    private MeasurementPreference measurementPreference;
    private String email;
    private int ftp;
    private float weight;

    public long getId() {
        return id;
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
}
