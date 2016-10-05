package com.sweetzpot.stravazpot.segment.request;

import com.sweetzpot.stravazpot.segment.api.SegmentEffortAPI;
import com.sweetzpot.stravazpot.segment.model.SegmentEffort;
import com.sweetzpot.stravazpot.segment.rest.SegmentEffortRest;

import retrofit2.Call;

public class GetSegmentEffortRequest {

    private final long segmentEffortID;
    private final SegmentEffortRest restService;
    private final SegmentEffortAPI api;

    public GetSegmentEffortRequest(long segmentEffortID, SegmentEffortRest restService, SegmentEffortAPI api) {
        this.segmentEffortID = segmentEffortID;
        this.restService = restService;
        this.api = api;
    }

    public SegmentEffort execute() {
        Call<SegmentEffort> call = restService.getSegmentEffort(segmentEffortID);
        return api.execute(call);
    }
}
