package com.sweetzpot.stravazpot.athlete.request;

import com.sweetzpot.stravazpot.athlete.api.AthleteAPI;
import com.sweetzpot.stravazpot.athlete.model.Athlete;
import com.sweetzpot.stravazpot.athlete.rest.AthleteRest;

import retrofit2.Call;

public class CurrentAthleteRequest {

    private final AthleteRest restService;
    private final AthleteAPI api;

    public CurrentAthleteRequest(AthleteRest restService, AthleteAPI api) {
        this.restService = restService;
        this.api = api;
    }

    public Athlete execute() {
        Call<Athlete> call = restService.getCurrentAthlete();
        return api.execute(call);
    }
}
