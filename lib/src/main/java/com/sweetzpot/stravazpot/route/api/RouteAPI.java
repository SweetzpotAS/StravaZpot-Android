package com.sweetzpot.stravazpot.route.api;

import com.sweetzpot.stravazpot.common.api.StravaAPI;
import com.sweetzpot.stravazpot.common.api.StravaConfig;
import com.sweetzpot.stravazpot.route.request.GetRouteRequest;
import com.sweetzpot.stravazpot.route.request.ListRoutesRequest;
import com.sweetzpot.stravazpot.route.rest.RouteRest;

public class RouteAPI extends StravaAPI{

    public RouteAPI(StravaConfig config) {
        super(config);
    }

    public GetRouteRequest getRoute(long routeID) {
        return new GetRouteRequest(routeID, getAPI(RouteRest.class), this);
    }

    public ListRoutesRequest listRoutes(long athleteID) {
        return new ListRoutesRequest(athleteID, getAPI(RouteRest.class), this);
    }
}
