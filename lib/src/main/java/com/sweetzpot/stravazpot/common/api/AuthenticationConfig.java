package com.sweetzpot.stravazpot.common.api;

import retrofit2.Retrofit;

public class AuthenticationConfig extends Config{

    public static AuthenticationConfig.Builder create() {
        return new AuthenticationConfig.Builder();
    }

    public AuthenticationConfig(Retrofit retrofit) {
        super(retrofit);
    }

    public static class Builder {
        private static final String STRAVA_AUTHORIZATION_URL = "https://www.strava.com";

        private String baseURL = STRAVA_AUTHORIZATION_URL;
        private boolean debug = false;

        public AuthenticationConfig.Builder debug() {
            debug = true;
            return this;
        }

        public AuthenticationConfig.Builder baseURL(String baseURL) {
            this.baseURL = baseURL;
            return this;
        }

        public AuthenticationConfig build() {
            return new AuthenticationConfig(createRetrofit(debug, baseURL));
        }
    }
}
