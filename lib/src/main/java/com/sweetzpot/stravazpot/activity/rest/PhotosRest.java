package com.sweetzpot.stravazpot.activity.rest;

import com.sweetzpot.stravazpot.activity.model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PhotosRest {
    @GET("activities/{id}/photos")
    Call<List<Photo>> getActivityPhotos(
            @Path("id") Long id,
            @Query("photo_sources") Boolean photoSources);
}
