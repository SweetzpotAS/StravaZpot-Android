package com.sweetzpot.stravazpot.segment.api;

import com.sweetzpot.stravazpot.common.api.StravaAPI;
import com.sweetzpot.stravazpot.common.api.StravaConfig;
import com.sweetzpot.stravazpot.segment.request.GetSegmentRequest;
import com.sweetzpot.stravazpot.segment.request.ListMyStarredSegmentsRequest;
import com.sweetzpot.stravazpot.segment.rest.SegmentRest;

public class SegmentAPI extends StravaAPI{

    public SegmentAPI(StravaConfig config) {
        super(config);
    }

    public GetSegmentRequest getSegment(int segmentID) {
        return new GetSegmentRequest(segmentID, getAPI(SegmentRest.class), this);
    }

    public ListMyStarredSegmentsRequest listMyStarredSegments() {
        return new ListMyStarredSegmentsRequest(getAPI(SegmentRest.class), this);
    }
}
