package com.sweetzpot.stravazpot.authenticaton.model;

public class AppCredentials {

    private final long clientID;
    private final String clientSecret;

    public static AppCredentials with(long clientID, String clientSecret) {
        return new AppCredentials(clientID, clientSecret);
    }

    public AppCredentials(long clientID, String clientSecret) {
        this.clientID = clientID;
        this.clientSecret = clientSecret;
    }

    public long getClientID() {
        return clientID;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}
