package com.sweetzpot.stravazpot.segment.request;

import com.sweetzpot.stravazpot.segment.api.SegmentAPI;
import com.sweetzpot.stravazpot.segment.model.Segment;
import com.sweetzpot.stravazpot.segment.rest.SegmentRest;

import retrofit2.Call;

public class GetSegmentRequest {

    private final int segmentID;
    private final SegmentRest restService;
    private final SegmentAPI api;

    public GetSegmentRequest(int segmentID, SegmentRest restService, SegmentAPI api) {
        this.segmentID = segmentID;
        this.restService = restService;
        this.api = api;
    }

    public Segment execute() {
        Call<Segment> call = restService.getSegment(segmentID);
        return api.execute(call);
    }
}
