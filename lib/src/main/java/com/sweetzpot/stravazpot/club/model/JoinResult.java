package com.sweetzpot.stravazpot.club.model;

import com.google.gson.annotations.SerializedName;

public class JoinResult {
    @SerializedName("success") boolean success;
    @SerializedName("active") boolean active;
    @SerializedName("membership") String membership;

    public boolean isSuccess() {
        return success;
    }

    public boolean isActive() {
        return active;
    }

    public String getMembership() {
        return membership;
    }
}
