package com.sweetzpot.stravazpot.athlete.model;

import com.google.gson.annotations.SerializedName;

public class Zones {
    @SerializedName("heart_rate") private HeartRate heartRate;
    @SerializedName("power") private Power power;

    public HeartRate getHeartRate() {
        return heartRate;
    }

    public Power getPower() {
        return power;
    }
}
