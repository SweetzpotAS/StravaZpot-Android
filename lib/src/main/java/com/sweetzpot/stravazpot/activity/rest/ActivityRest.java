package com.sweetzpot.stravazpot.activity.rest;

import com.sweetzpot.stravazpot.activity.model.Activity;
import com.sweetzpot.stravazpot.activity.model.ActivityLap;
import com.sweetzpot.stravazpot.activity.model.ActivityType;
import com.sweetzpot.stravazpot.activity.model.ActivityZone;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.Time;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ActivityRest {
    @POST("activities") @FormUrlEncoded
    Call<Activity> createActivity(
            @Field("name") String name,
            @Field("type") ActivityType type,
            @Field("start_date_local") String startDate,
            @Field("elapsed_time") Time elapsedTime,
            @Field("description") String description,
            @Field("distance") Distance distance,
            @Field("private") Integer isPrivate,
            @Field("trainer") Integer trainer,
            @Field("commute") Integer commute);

    @GET("activities/{id}")
    Call<Activity> getActivity(
            @Path("id") Integer id,
            @Query("include_all_efforts") Boolean includeAllEfforts);

    @PUT("activities/{id}") @FormUrlEncoded
    Call<Activity> updateActivity(
            @Path("id") Integer id,
            @Field("name") String name,
            @Field("type") ActivityType type,
            @Field("private") Boolean isPrivate,
            @Field("commute") Boolean commute,
            @Field("trainer") Boolean trainer,
            @Field("gear_id") String gearID,
            @Field("description") String description);

    @DELETE("activities/{id}")
    Call<Void> deleteActivity(@Path("id") Integer id);

    @GET("athlete/activities")
    Call<List<Activity>> getMyActivities(
            @Query("before") Integer before,
            @Query("after") Integer after,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage);

    @GET("activities/following")
    Call<List<Activity>> getFriendsActivities(
            @Query("before") Integer before,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage);

    @GET("activities/{id}/related")
    Call<List<Activity>> getRelatedActivities(
            @Path("id") Integer id,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage);

    @GET("activities/{id}/zones")
    Call<List<ActivityZone>> getActivityZones(@Path("id") Integer id);

    @GET("activities/{id}/laps")
    Call<List<ActivityLap>> getActivityLaps(@Path("id") Integer id);
}
