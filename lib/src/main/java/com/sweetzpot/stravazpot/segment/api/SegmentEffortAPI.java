package com.sweetzpot.stravazpot.segment.api;

import com.sweetzpot.stravazpot.common.api.StravaAPI;
import com.sweetzpot.stravazpot.common.api.StravaConfig;
import com.sweetzpot.stravazpot.segment.request.GetSegmentEffortRequest;
import com.sweetzpot.stravazpot.segment.rest.SegmentEffortRest;

public class SegmentEffortAPI extends StravaAPI{

    public SegmentEffortAPI(StravaConfig config) {
        super(config);
    }

    public GetSegmentEffortRequest getSegmentEffort(long segmentEffortID) {
        return new GetSegmentEffortRequest(segmentEffortID, getAPI(SegmentEffortRest.class), this);
    }
}
