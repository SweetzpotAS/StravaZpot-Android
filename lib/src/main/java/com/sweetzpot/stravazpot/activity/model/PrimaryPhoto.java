package com.sweetzpot.stravazpot.activity.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class PrimaryPhoto {
    @SerializedName("id") private long ID;
    @SerializedName("source") private PhotoSource source;
    @SerializedName("unique_id") private String uniqueID;
    @SerializedName("urls") private HashMap<String, String> urls;

    public long getID() {
        return ID;
    }

    public PhotoSource getSource() {
        return source;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public HashMap<String, String> getUrls() {
        return urls;
    }
}
