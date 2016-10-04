package com.sweetzpot.stravazpot.common.api;

import com.sweetzpot.stravazpot.common.api.exception.StravaAPIException;
import com.sweetzpot.stravazpot.common.api.exception.StravaUnauthorizedException;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public abstract class StravaAPI {
    private static final int UNAUTHORIZED_CODE = 401;
    private final Config config;

    public StravaAPI(Config config) {
        this.config = config;
    }

    protected <T> T getAPI(Class<T> apiRest) {
        return config.getRetrofit().create(apiRest);
    }

    public <T> T execute(Call<T> call) throws StravaAPIException, StravaUnauthorizedException {
        Response<T> response;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new StravaAPIException("A network error happened contacting Strava API", e);
        }

        if(response.isSuccessful()) {
            return response.body();
        } else if(response.code() == UNAUTHORIZED_CODE){
            throw new StravaUnauthorizedException();
        } else {
            throw new StravaAPIException("Response was not successful");
        }
    }
}
