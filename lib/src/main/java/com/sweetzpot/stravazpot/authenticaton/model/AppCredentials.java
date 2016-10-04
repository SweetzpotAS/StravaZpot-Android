package com.sweetzpot.stravazpot.authenticaton.model;

public class AppCredentials {

    private final int clientID;
    private final String clientSecret;

    public static AppCredentials with(int clientID, String clientSecret) {
        return new AppCredentials(clientID, clientSecret);
    }

    public AppCredentials(int clientID, String clientSecret) {
        this.clientID = clientID;
        this.clientSecret = clientSecret;
    }

    public int getClientID() {
        return clientID;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}
