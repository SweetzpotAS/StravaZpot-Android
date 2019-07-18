package com.sweetzpot.stravazpot.athlete.request;

import com.sweetzpot.stravazpot.athlete.api.AthleteAPI;
import com.sweetzpot.stravazpot.athlete.model.Stats;
import com.sweetzpot.stravazpot.athlete.rest.AthleteRest;

import retrofit2.Call;

public class GetTotalsAndStatsRequest {

    private final long athleteID;
    private final AthleteRest restService;
    private final AthleteAPI api;

    public GetTotalsAndStatsRequest(long athleteID, AthleteRest restService, AthleteAPI api) {
        this.athleteID = athleteID;
        this.restService = restService;
        this.api = api;
    }

    public Stats execute() {
        Call<Stats> call = restService.getAthleteStats(athleteID);
        return api.execute(call);
    }
}
