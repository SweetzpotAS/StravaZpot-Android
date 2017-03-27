package com.sweetzpot.stravazpot.segment.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExploreResult {
    @SerializedName("segments") private List<Segment> segments;

    public List<Segment> getSegments() {
        return segments;
    }
}
