package com.sweetzpot.stravazpot.gear.request;

import com.sweetzpot.stravazpot.gear.api.GearAPI;
import com.sweetzpot.stravazpot.gear.model.Gear;
import com.sweetzpot.stravazpot.gear.rest.GearRest;

import retrofit2.Call;

public class GetGearRequest {

    private final String gearID;
    private final GearRest restService;
    private final GearAPI api;

    public GetGearRequest(String gearID, GearRest restService, GearAPI api) {
        this.gearID = gearID;
        this.restService = restService;
        this.api = api;
    }

    public Gear execute() {
        Call<Gear> call = restService.getGear(gearID);
        return api.execute(call);
    }
}
