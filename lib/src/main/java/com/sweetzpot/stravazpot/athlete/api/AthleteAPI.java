package com.sweetzpot.stravazpot.athlete.api;

import com.sweetzpot.stravazpot.athlete.request.CurrentAthleteRequest;
import com.sweetzpot.stravazpot.athlete.rest.AthleteRest;
import com.sweetzpot.stravazpot.common.api.StravaAPI;
import com.sweetzpot.stravazpot.common.api.StravaConfig;

public class AthleteAPI extends StravaAPI {

    public AthleteAPI(StravaConfig config) {
        super(config);
    }

    public CurrentAthleteRequest retrieveCurrentAthlete() {
        return new CurrentAthleteRequest(getAPI(AthleteRest.class), this);
    }
}
