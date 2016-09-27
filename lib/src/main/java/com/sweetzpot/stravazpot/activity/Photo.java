package com.sweetzpot.stravazpot.activity;

import com.sweetzpot.stravazpot.Coordinates;
import com.sweetzpot.stravazpot.ResourceState;

import java.util.Date;
import java.util.HashMap;

public class Photo {
    private String uniqueID;
    private int ID;
    private int activityID;
    private ResourceState resourceState;
    private HashMap<String, String> urls;
    private String caption;
    private PhotoSource source;
    private Date uploadedAt;
    private Date createdAt;
    private Coordinates location;
    private String ref;
    private String uid;
    private String type;

    public String getUniqueID() {
        return uniqueID;
    }

    public int getID() {
        return ID;
    }

    public int getActivityID() {
        return activityID;
    }

    public ResourceState getResourceState() {
        return resourceState;
    }

    public HashMap<String, String> getUrls() {
        return urls;
    }

    public String getCaption() {
        return caption;
    }

    public PhotoSource getSource() {
        return source;
    }

    public Date getUploadedAt() {
        return uploadedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Coordinates getLocation() {
        return location;
    }

    public String getRef() {
        return ref;
    }

    public String getUid() {
        return uid;
    }

    public String getType() {
        return type;
    }
}
