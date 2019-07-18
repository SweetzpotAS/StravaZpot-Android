package com.sweetzpot.stravazpot.route.request;

import com.sweetzpot.stravazpot.route.api.RouteAPI;
import com.sweetzpot.stravazpot.route.model.Route;
import com.sweetzpot.stravazpot.route.rest.RouteRest;

import retrofit2.Call;

public class GetRouteRequest {

    private final long routeID;
    private final RouteRest restService;
    private final RouteAPI api;

    public GetRouteRequest(long routeID, RouteRest restService, RouteAPI api) {
        this.routeID = routeID;
        this.restService = restService;
        this.api = api;
    }

    public Route execute() {
        Call<Route> call = restService.getRoute(routeID);
        return api.execute(call);
    }
}
