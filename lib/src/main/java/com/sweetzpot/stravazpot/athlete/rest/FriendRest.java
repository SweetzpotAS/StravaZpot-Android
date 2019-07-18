package com.sweetzpot.stravazpot.athlete.rest;

import com.sweetzpot.stravazpot.athlete.model.Athlete;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FriendRest {
    @GET("athlete/friends")
    Call<List<Athlete>> getMyFriends(
            @Query("page") Integer page,
            @Query("per_page") Integer perPage);

    @GET("athletes/{id}/friends")
    Call<List<Athlete>> getFriends(
            @Path("id") Long id,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage);

    @GET("athlete/followers")
    Call<List<Athlete>> getMyFollowers(
            @Query("page") Integer page,
            @Query("per_page") Integer perPage);

    @GET("athletes/{id}/followers")
    Call<List<Athlete>> getFollowers(
            @Path("id") Long id,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage);

    @GET("athletes/{id}/both-following")
    Call<List<Athlete>> getBothFollowing(
            @Path("id") Long id,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage);
}
