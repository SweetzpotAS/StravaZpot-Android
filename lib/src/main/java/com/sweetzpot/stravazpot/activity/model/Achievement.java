package com.sweetzpot.stravazpot.activity.model;

import com.google.gson.annotations.SerializedName;

public class Achievement {
    @SerializedName("type_id") private AchievementType typeID;
    @SerializedName("type") private String type;
    @SerializedName("rank") private int rank;

    public AchievementType getTypeID() {
        return typeID;
    }

    public String getType() {
        return type;
    }

    public int getRank() {
        return rank;
    }
}
