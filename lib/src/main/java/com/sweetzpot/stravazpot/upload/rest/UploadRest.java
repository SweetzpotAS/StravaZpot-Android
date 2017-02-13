package com.sweetzpot.stravazpot.upload.rest;

import com.sweetzpot.stravazpot.upload.model.DataType;
import com.sweetzpot.stravazpot.upload.model.UploadActivityType;
import com.sweetzpot.stravazpot.upload.model.UploadStatus;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface UploadRest {

    @POST("upload") @Multipart
    Call<UploadStatus> upload(
            @Part("activity_type") UploadActivityType activityType,
            @Part("name") String name,
            @Part("description") String description,
            @Part("private") Integer isPrivate,
            @Part("trainer") Integer hasTrainer,
            @Part("commute") Integer isCommute,
            @Part("data_type") DataType dataType,
            @Part("external_id") String externalID,
            @Part MultipartBody.Part file);

    @GET("uploads/{id}")
    Call<UploadStatus> checkUploadStatus(@Path("id") int id);
}
