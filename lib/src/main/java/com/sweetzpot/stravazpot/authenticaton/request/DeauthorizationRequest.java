package com.sweetzpot.stravazpot.authenticaton.request;

import com.sweetzpot.stravazpot.authenticaton.api.AuthenticationAPI;
import com.sweetzpot.stravazpot.authenticaton.rest.AuthenticationRest;

import retrofit2.Call;

public class DeauthorizationRequest {

    private final AuthenticationRest restService;
    private final AuthenticationAPI api;

    public DeauthorizationRequest(AuthenticationRest restService, AuthenticationAPI api) {
        this.restService = restService;
        this.api = api;
    }

    public Void execute() {
        Call<Void> call = restService.deauthorize();
        return api.execute(call);
    }
}
