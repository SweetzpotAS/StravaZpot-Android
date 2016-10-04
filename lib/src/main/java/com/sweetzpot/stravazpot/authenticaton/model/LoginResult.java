package com.sweetzpot.stravazpot.authenticaton.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.athlete.model.Athlete;

public class LoginResult {
    @SerializedName("access_token") private Token token;
    @SerializedName("athlete") private Athlete athlete;

    public Token getToken() {
        return token;
    }

    public Athlete getAthlete() {
        return athlete;
    }
}
