package com.sweetzpot.stravazpot.common.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthorizationInterceptor implements Interceptor {
    private final String token;

    public AuthorizationInterceptor(String token) {
        this.token = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder requestBuilder = original.newBuilder()
                .header("Accept", "application/json")
                .header("Authorization", token)
                .method(original.method(), original.body());

        Request request = requestBuilder.build();

        return chain.proceed(request);
    }
}
