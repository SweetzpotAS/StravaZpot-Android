package com.sweetzpot.stravazpot.club.model;

import com.google.gson.annotations.SerializedName;

public class LeaveResult {
    @SerializedName("success") boolean success;
    @SerializedName("active") boolean active;

    public boolean isSuccess() {
        return success;
    }

    public boolean isActive() {
        return active;
    }
}
