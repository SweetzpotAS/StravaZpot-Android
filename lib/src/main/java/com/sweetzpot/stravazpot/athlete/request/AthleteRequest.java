package com.sweetzpot.stravazpot.athlete.request;

import com.sweetzpot.stravazpot.athlete.api.AthleteAPI;
import com.sweetzpot.stravazpot.athlete.model.Athlete;
import com.sweetzpot.stravazpot.athlete.rest.AthleteRest;

import retrofit2.Call;

public class AthleteRequest {
    private final long athleteID;
    private final AthleteRest restService;
    private final AthleteAPI api;

    public AthleteRequest(long athleteID, AthleteRest restService, AthleteAPI api) {
        this.athleteID = athleteID;
        this.restService = restService;
        this.api = api;
    }

    public Athlete execute() {
        Call<Athlete> call = restService.getAthlete(athleteID);
        return api.execute(call);
    }
}
