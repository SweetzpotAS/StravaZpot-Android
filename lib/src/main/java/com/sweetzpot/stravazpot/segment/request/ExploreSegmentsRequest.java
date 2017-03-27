package com.sweetzpot.stravazpot.segment.request;

import com.sweetzpot.stravazpot.segment.api.SegmentAPI;
import com.sweetzpot.stravazpot.segment.model.Bounds;
import com.sweetzpot.stravazpot.segment.model.ExploreResult;
import com.sweetzpot.stravazpot.segment.model.ExploreType;
import com.sweetzpot.stravazpot.segment.model.Segment;
import com.sweetzpot.stravazpot.segment.rest.SegmentRest;

import java.util.List;

import retrofit2.Call;

public class ExploreSegmentsRequest {

    private final Bounds bounds;
    private final SegmentRest restService;
    private final SegmentAPI api;
    private ExploreType activityType;
    private Integer minCategory;
    private Integer maxCategory;

    public ExploreSegmentsRequest(Bounds bounds, SegmentRest restService, SegmentAPI api) {
        this.bounds = bounds;
        this.restService = restService;
        this.api = api;
    }

    public ExploreSegmentsRequest forActivityType(ExploreType activityType) {
        this.activityType = activityType;
        return this;
    }

    public ExploreSegmentsRequest withMinimumClimbCategory(int minCategory) {
        this.minCategory = minCategory;
        return this;
    }

    public ExploreSegmentsRequest withMaximumClimbCategory(int maxCategory) {
        this.maxCategory = maxCategory;
        return this;
    }

    public List<Segment> execute() {
        Call<ExploreResult> call = restService.exploreSegments(bounds.toString(),
                activityType, minCategory, maxCategory);
        return api.execute(call).getSegments();
    }
}
