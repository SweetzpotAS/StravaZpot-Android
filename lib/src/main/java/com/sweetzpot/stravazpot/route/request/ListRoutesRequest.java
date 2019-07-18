package com.sweetzpot.stravazpot.route.request;

import com.sweetzpot.stravazpot.route.api.RouteAPI;
import com.sweetzpot.stravazpot.route.model.Route;
import com.sweetzpot.stravazpot.route.rest.RouteRest;

import java.util.List;

import retrofit2.Call;

public class ListRoutesRequest {

    private final long athleteID;
    private final RouteRest restService;
    private final RouteAPI api;

    public ListRoutesRequest(long athleteID, RouteRest restService, RouteAPI api) {
        this.athleteID = athleteID;
        this.restService = restService;
        this.api = api;
    }

    public List<Route> execute() {
        Call<List<Route>> call = restService.getAthleteRoutes(athleteID);
        return api.execute(call);
    }
}
