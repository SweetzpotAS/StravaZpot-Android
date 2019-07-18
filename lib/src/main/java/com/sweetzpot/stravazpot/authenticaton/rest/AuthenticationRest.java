package com.sweetzpot.stravazpot.authenticaton.rest;

import com.sweetzpot.stravazpot.authenticaton.model.LoginResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthenticationRest {

    @POST("/oauth/token")
    @FormUrlEncoded
    Call<LoginResult> token(
            @Field("client_id") Long clientID,
            @Field("client_secret") String clientSecret,
            @Field("code") String code);

    @POST("/oauth/deauthorize")
    Call<Void> deauthorize();
}
