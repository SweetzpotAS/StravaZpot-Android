package com.sweetzpot.stravazpot.stream.api;

import com.sweetzpot.stravazpot.common.api.StravaAPI;
import com.sweetzpot.stravazpot.common.api.StravaConfig;
import com.sweetzpot.stravazpot.stream.request.GetActivityStreamsRequest;
import com.sweetzpot.stravazpot.stream.request.GetRouteStreamsRequest;
import com.sweetzpot.stravazpot.stream.request.GetSegmentEffortStreamsRequest;
import com.sweetzpot.stravazpot.stream.request.GetSegmentStreamsRequest;
import com.sweetzpot.stravazpot.stream.rest.StreamRest;

public class StreamAPI extends StravaAPI {

    public StreamAPI(StravaConfig config) {
        super(config);
    }

    public GetActivityStreamsRequest getActivityStreams(long activityID) {
        return new GetActivityStreamsRequest(activityID, getAPI(StreamRest.class), this);
    }

    public GetSegmentEffortStreamsRequest getSegmentEffortStreams(long segmentEffortID) {
        return new GetSegmentEffortStreamsRequest(segmentEffortID, getAPI(StreamRest.class), this);
    }

    public GetSegmentStreamsRequest getSegmentStreams(long segmentID) {
        return new GetSegmentStreamsRequest(segmentID, getAPI(StreamRest.class), this);
    }

    public GetRouteStreamsRequest getRouteStreams(long routeID) {
        return new GetRouteStreamsRequest(routeID, getAPI(StreamRest.class), this);
    }
}
