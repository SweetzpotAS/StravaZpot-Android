package com.sweetzpot.stravazpot.club.rest;

import com.sweetzpot.stravazpot.activity.model.Activity;
import com.sweetzpot.stravazpot.athlete.model.Athlete;
import com.sweetzpot.stravazpot.club.model.Announcement;
import com.sweetzpot.stravazpot.club.model.Club;
import com.sweetzpot.stravazpot.club.model.Event;
import com.sweetzpot.stravazpot.club.model.JoinResult;
import com.sweetzpot.stravazpot.club.model.LeaveResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ClubRest {
    @GET("clubs/{id}")
    Call<Club> getClub(@Path("id") Long id);

    @GET("clubs/{id}/announcements")
    Call<List<Announcement>> getClubAnnouncements(@Path("id") Long id);

    @GET("clubs/{id}/group_events")
    Call<List<Event>> getClubGroupEvents(@Path("id") Long id);

    @GET("athlete/clubs")
    Call<List<Club>> getMyClubs();

    @GET("clubs/{id}/members")
    Call<List<Athlete>> getClubMembers(
            @Path("id") Long id,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage);

    @GET("clubs/{id}/admins")
    Call<List<Athlete>> getClubAdmins(
            @Path("id") Long id,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage);

    @GET("clubs/{id}/activities")
    Call<List<Activity>> getClubActivities(
            @Path("id") Long id,
            @Query("before") Integer before,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage);

    @POST("clubs/{id}/join")
    Call<JoinResult> joinClub(@Path("id") Long id);

    @POST("clubs/{id}/leave")
    Call<LeaveResult> leaveClub(@Path("id") Long id);
}
