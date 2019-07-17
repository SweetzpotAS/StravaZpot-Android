package com.sweetzpot.stravazpot.stream.request;

import com.sweetzpot.stravazpot.stream.api.StreamAPI;
import com.sweetzpot.stravazpot.stream.model.Stream;
import com.sweetzpot.stravazpot.stream.rest.StreamRest;

import java.util.List;

import retrofit2.Call;

public class GetRouteStreamsRequest {

    private final long routeID;
    private final StreamRest restService;
    private final StreamAPI api;

    public GetRouteStreamsRequest(long routeID, StreamRest restService, StreamAPI api) {
        this.routeID = routeID;
        this.restService = restService;
        this.api = api;
    }

    public List<Stream> execute() {
        Call<List<Stream>> call = restService.getRouteStreams(routeID);
        return api.execute(call);
    }
}
