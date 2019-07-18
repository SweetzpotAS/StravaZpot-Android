package com.sweetzpot.stravazpot.segment.api;

import com.sweetzpot.stravazpot.common.api.StravaAPI;
import com.sweetzpot.stravazpot.common.api.StravaConfig;
import com.sweetzpot.stravazpot.segment.model.Bounds;
import com.sweetzpot.stravazpot.segment.request.ExploreSegmentsRequest;
import com.sweetzpot.stravazpot.segment.request.GetSegmentLeaderboardRequest;
import com.sweetzpot.stravazpot.segment.request.GetSegmentRequest;
import com.sweetzpot.stravazpot.segment.request.ListAthleteStarredSegmentsRequest;
import com.sweetzpot.stravazpot.segment.request.ListMyStarredSegmentsRequest;
import com.sweetzpot.stravazpot.segment.request.ListSegmentEffortsRequest;
import com.sweetzpot.stravazpot.segment.request.StarSegmentRequest;
import com.sweetzpot.stravazpot.segment.rest.SegmentRest;

public class SegmentAPI extends StravaAPI{

    public SegmentAPI(StravaConfig config) {
        super(config);
    }

    public GetSegmentRequest getSegment(long segmentID) {
        return new GetSegmentRequest(segmentID, getAPI(SegmentRest.class), this);
    }

    public ListMyStarredSegmentsRequest listMyStarredSegments() {
        return new ListMyStarredSegmentsRequest(getAPI(SegmentRest.class), this);
    }

    public ListAthleteStarredSegmentsRequest listStarredSegmentsByAthlete(long athleteID) {
        return new ListAthleteStarredSegmentsRequest(athleteID, getAPI(SegmentRest.class), this);
    }

    public StarSegmentRequest starSegment(long segmentID) {
        return new StarSegmentRequest(segmentID, true, getAPI(SegmentRest.class), this);
    }

    public StarSegmentRequest unstarSegment(long segmentID) {
        return new StarSegmentRequest(segmentID, false, getAPI(SegmentRest.class), this);
    }

    public ListSegmentEffortsRequest listSegmentEfforts(long segmentID) {
        return new ListSegmentEffortsRequest(segmentID, getAPI(SegmentRest.class), this);
    }

    public GetSegmentLeaderboardRequest getLeaderboardForSegment(long segmentID) {
        return new GetSegmentLeaderboardRequest(segmentID, getAPI(SegmentRest.class), this);
    }

    public ExploreSegmentsRequest exploreSegmentsInRegion(Bounds bounds) {
        return new ExploreSegmentsRequest(bounds, getAPI(SegmentRest.class), this);
    }
}
