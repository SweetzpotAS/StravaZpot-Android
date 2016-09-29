package com.sweetzpot.stravazpot.segment.rest;

import com.sweetzpot.stravazpot.common.model.Gender;
import com.sweetzpot.stravazpot.segment.model.AgeGroup;
import com.sweetzpot.stravazpot.segment.model.DateRange;
import com.sweetzpot.stravazpot.segment.model.ExploreType;
import com.sweetzpot.stravazpot.segment.model.Leaderboard;
import com.sweetzpot.stravazpot.segment.model.Segment;
import com.sweetzpot.stravazpot.segment.model.SegmentEffort;
import com.sweetzpot.stravazpot.segment.model.WeightClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SegmentRest {
    @GET("segments/{id}")
    Call<Segment> getSegment(@Path("id") Integer id);

    @GET("segments/starred")
    Call<List<Segment>> getMyStarredSegments(
            @Query("page") Integer page,
            @Query("per_page") Integer perPage);

    @GET("athletes/{id}/segments/starred")
    Call<List<Segment>> getAthleteStarredSegments(
            @Path("id") Integer id,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage);

    @PUT("segments/{id}/starred") @FormUrlEncoded
    Call<Segment> starSegment(
            @Path("id") Integer id,
            @Field("starred") Boolean starred);

    @GET("segments/{id}/all_efforts")
    Call<List<SegmentEffort>> getSegmentEfforts(
            @Path("id") Integer id,
            @Query("athlete_id") Integer athleteID,
            @Query("start_date_local") String startDate,
            @Query("end_date_local") String endDate,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage);

    @GET("segments/{id}/leaderboard")
    Call<Leaderboard> getSegmentLeaderboard(
            @Path("id") Integer id,
            @Query("gender") Gender gender,
            @Query("age_group") AgeGroup ageGroup,
            @Query("weight_class") WeightClass weightClass,
            @Query("following") Boolean following,
            @Query("club_id") Integer clubID,
            @Query("date_range") DateRange dateRange,
            @Query("context_entries") Integer contextEntries,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage);

    @GET("segments/explore")
    Call<List<Segment>> exploreSegments(
            @Query("bounds") String bounds,
            @Query("activity_type") ExploreType activityType,
            @Query("min_cat") Integer minCat,
            @Query("max_cat") Integer maxCat);

}
