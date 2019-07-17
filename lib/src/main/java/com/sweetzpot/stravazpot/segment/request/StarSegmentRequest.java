package com.sweetzpot.stravazpot.segment.request;

import com.sweetzpot.stravazpot.segment.api.SegmentAPI;
import com.sweetzpot.stravazpot.segment.model.Segment;
import com.sweetzpot.stravazpot.segment.rest.SegmentRest;

import retrofit2.Call;

public class StarSegmentRequest {

    private final long segmentID;
    private final boolean star;
    private final SegmentRest restService;
    private final SegmentAPI api;

    public StarSegmentRequest(long segmentID, boolean star, SegmentRest restService, SegmentAPI api) {
        this.segmentID = segmentID;
        this.star = star;
        this.restService = restService;
        this.api = api;
    }

    public Segment execute() {
        Call<Segment> call = restService.starSegment(segmentID, star);
        return api.execute(call);
    }
}
