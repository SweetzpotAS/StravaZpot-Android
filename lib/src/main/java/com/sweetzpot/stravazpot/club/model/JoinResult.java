package com.sweetzpot.stravazpot.club.model;

import com.google.gson.annotations.SerializedName;

public class JoinResult {
    @SerializedName("success") boolean success;
    @SerializedName("active") boolean active;
    @SerializedName("membership") Membership membership;

    public boolean isSuccess() {
        return success;
    }

    public boolean isActive() {
        return active;
    }

    public Membership getMembership() {
        return membership;
    }
}
