package com.sweetzpot.stravazpot.gear.api;

import com.sweetzpot.stravazpot.common.api.StravaAPI;
import com.sweetzpot.stravazpot.common.api.StravaConfig;
import com.sweetzpot.stravazpot.gear.request.GetGearRequest;
import com.sweetzpot.stravazpot.gear.rest.GearRest;

public class GearAPI extends StravaAPI{

    public GearAPI(StravaConfig config) {
        super(config);
    }

    public GetGearRequest getGear(String gearID) {
        return new GetGearRequest(gearID, getAPI(GearRest.class), this);
    }
}
