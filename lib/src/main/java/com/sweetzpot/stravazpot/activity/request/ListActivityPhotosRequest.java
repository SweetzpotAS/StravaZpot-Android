package com.sweetzpot.stravazpot.activity.request;

import com.sweetzpot.stravazpot.activity.api.PhotoAPI;
import com.sweetzpot.stravazpot.activity.model.Photo;
import com.sweetzpot.stravazpot.activity.rest.PhotosRest;

import java.util.List;

import retrofit2.Call;

public class ListActivityPhotosRequest {

    private final long activityID;
    private final PhotosRest restService;
    private final PhotoAPI api;

    public ListActivityPhotosRequest(long activityID, PhotosRest restService, PhotoAPI api) {
        this.activityID = activityID;
        this.restService = restService;
        this.api = api;
    }

    public List<Photo> execute() {
        Call<List<Photo>> call = restService.getActivityPhotos(activityID, true);
        return api.execute(call);
    }
}
