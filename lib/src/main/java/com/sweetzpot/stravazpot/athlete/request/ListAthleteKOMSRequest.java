package com.sweetzpot.stravazpot.athlete.request;

import com.sweetzpot.stravazpot.athlete.api.AthleteAPI;
import com.sweetzpot.stravazpot.athlete.rest.AthleteRest;
import com.sweetzpot.stravazpot.segment.model.SegmentEffort;

import java.util.List;

import retrofit2.Call;

public class ListAthleteKOMSRequest {

    private final long athleteID;
    private final AthleteRest restService;
    private final AthleteAPI api;
    private Integer page;
    private Integer perPage;

    public ListAthleteKOMSRequest(long athleteID, AthleteRest restService, AthleteAPI api) {
        this.athleteID = athleteID;
        this.restService = restService;
        this.api = api;
    }

    public ListAthleteKOMSRequest inPage(int page) {
        this.page = page;
        return this;
    }

    public ListAthleteKOMSRequest perPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public List<SegmentEffort> execute() {
        Call<List<SegmentEffort>> call = restService.listAthleteKOMS(athleteID, page, perPage);
        return api.execute(call);
    }
}
