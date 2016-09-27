package com.sweetzpot.stravazpot.segment.rest;

import com.sweetzpot.stravazpot.segment.model.SegmentEffort;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SegmentEffortRest {
    @GET("segment_efforts/{id}")
    Call<SegmentEffort> getSegmentEffort(@Path("id") Long id);
}
