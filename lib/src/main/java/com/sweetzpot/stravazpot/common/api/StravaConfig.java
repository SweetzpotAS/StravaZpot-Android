package com.sweetzpot.stravazpot.common.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StravaConfig {
    private Retrofit retrofit;

    StravaConfig(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public static StravaConfig.Builder withToken(String token) {
        return new StravaConfig.Builder(token);
    }

    public static class Builder {
        private static final String STRAVA_BASE_URL = "https://www.strava.com/api/v3/";

        private String token;
        private String baseURL = STRAVA_BASE_URL;
        private boolean debug = false;

        public Builder(String token) {
            this.token = token;
        }

        public Builder debug() {
            debug = true;
            return this;
        }

        public Builder baseURL(String baseURL) {
            this.baseURL = baseURL;
            return this;
        }

        public StravaConfig build() {
            return new StravaConfig(createRetrofit());
        }

        private Retrofit createRetrofit() {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            if(debug){
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(interceptor);
            }
            builder.addInterceptor(new AuthorizationInterceptor(token));

            OkHttpClient client = builder.build();

            Retrofit retrofit = new Retrofit.Builder().baseUrl(baseURL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit;
        }
    }
}
