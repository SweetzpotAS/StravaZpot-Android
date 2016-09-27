package com.sweetzpot.stravazpot.club;

import com.sweetzpot.stravazpot.common.ResourceState;

public class Club {
    private int ID;
    private ResourceState resourceState;
    private String name;
    private String profileMedium;
    private String profile;
    private String coverPhoto;
    private String coverPhotoSmall;
    private String description;
    private ClubType clubType;
    private SportType sportType;
    private String city;
    private String state;
    private String country;
    private boolean isPrivate;
    private int memberCount;
    private boolean featured;
    private boolean verified;
    private Membership membership;
    private boolean admin;
    private boolean owner;
    private int followingCount;
    private String url;

    public int getID() {
        return ID;
    }

    public ResourceState getResourceState() {
        return resourceState;
    }

    public String getName() {
        return name;
    }

    public String getProfileMedium() {
        return profileMedium;
    }

    public String getProfile() {
        return profile;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public String getCoverPhotoSmall() {
        return coverPhotoSmall;
    }

    public String getDescription() {
        return description;
    }

    public ClubType getClubType() {
        return clubType;
    }

    public SportType getSportType() {
        return sportType;
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

    public boolean isPrivate() {
        return isPrivate;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public boolean isFeatured() {
        return featured;
    }

    public boolean isVerified() {
        return verified;
    }

    public Membership getMembership() {
        return membership;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isOwner() {
        return owner;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public String getUrl() {
        return url;
    }
}
