package com.sweetzpot.stravazpot.athlete.api;

import com.sweetzpot.stravazpot.athlete.request.AthleteRequest;
import com.sweetzpot.stravazpot.athlete.request.CurrentAthleteRequest;
import com.sweetzpot.stravazpot.athlete.request.GetTotalsAndStatsRequest;
import com.sweetzpot.stravazpot.athlete.request.GetZonesRequest;
import com.sweetzpot.stravazpot.athlete.request.ListAthleteKOMSRequest;
import com.sweetzpot.stravazpot.athlete.request.UpdateAthleteRequest;
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

    public AthleteRequest retrieveAthlete(long athleteID) {
        return new AthleteRequest(athleteID, getAPI(AthleteRest.class), this);
    }

    public UpdateAthleteRequest updateAthlete() {
        return new UpdateAthleteRequest(getAPI(AthleteRest.class), this);
    }

    public GetZonesRequest getAthleteZones() {
        return new GetZonesRequest(getAPI(AthleteRest.class), this);
    }

    public GetTotalsAndStatsRequest getAthleteTotalsAndStats(long athleteID) {
        return new GetTotalsAndStatsRequest(athleteID, getAPI(AthleteRest.class), this);
    }

    public ListAthleteKOMSRequest listAthleteKOMS(long athleteID) {
        return new ListAthleteKOMSRequest(athleteID, getAPI(AthleteRest.class), this);
    }
}
