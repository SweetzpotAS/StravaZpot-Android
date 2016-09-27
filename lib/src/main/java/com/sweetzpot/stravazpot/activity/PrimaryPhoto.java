package com.sweetzpot.stravazpot.activity;

import java.util.HashMap;

public class PrimaryPhoto {
    private int id;
    private PhotoSource source;
    private String uniqueID;
    private HashMap<String, String> urls;

    public int getId() {
        return id;
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
