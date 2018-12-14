package com.sweetzpot.stravazpot.authenticaton.request;

import com.sweetzpot.stravazpot.authenticaton.api.AuthenticationAPI;
import com.sweetzpot.stravazpot.authenticaton.model.AppCredentials;
import com.sweetzpot.stravazpot.authenticaton.model.LoginResult;
import com.sweetzpot.stravazpot.authenticaton.rest.AuthenticationRest;

import retrofit2.Call;

public class AuthenticationRequest {

    private final AppCredentials appCredentials;
    private final AuthenticationRest restService;
    private final AuthenticationAPI api;
    private String code;
    private String refreshToken;

    public AuthenticationRequest(AppCredentials appCredentials, AuthenticationRest restService, AuthenticationAPI api) {
        this.appCredentials = appCredentials;
        this.restService = restService;
        this.api = api;
    }

    public AuthenticationRequest withCode(String code) {
        this.code = code;
        return this;
    }


    public AuthenticationRequest withRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }


    public LoginResult refreshToken() {
        Call<LoginResult> call = restService.refreshToken(appCredentials.getClientID(), appCredentials.getClientSecret(),"refresh_token" ,refreshToken);
        return api.execute(call);
    }

    public LoginResult execute() {
        Call<LoginResult> call = restService.token(appCredentials.getClientID(), appCredentials.getClientSecret(), code);
        return api.execute(call);
    }
}
