package com.sweetzpot.stravazpot.club.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.common.model.ResourceState;

public class Club {
    @SerializedName("id") private long ID;
    @SerializedName("resource_state") private ResourceState resourceState;
    @SerializedName("name") private String name;
    @SerializedName("profile_medium") private String profileMedium;
    @SerializedName("profile") private String profile;
    @SerializedName("cover_photo") private String coverPhoto;
    @SerializedName("cover_photo_small") private String coverPhotoSmall;
    @SerializedName("description") private String description;
    @SerializedName("club_type") private ClubType clubType;
    @SerializedName("sport_type") private SportType sportType;
    @SerializedName("city") private String city;
    @SerializedName("state") private String state;
    @SerializedName("country") private String country;
    @SerializedName("private") private boolean isPrivate;
    @SerializedName("member_count") private int memberCount;
    @SerializedName("featured") private boolean featured;
    @SerializedName("verified") private boolean verified;
    @SerializedName("membership") private Membership membership;
    @SerializedName("admin") private boolean admin;
    @SerializedName("owner") private boolean owner;
    @SerializedName("following_count") private int followingCount;
    @SerializedName("url") private String url;

    public long getID() {
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
