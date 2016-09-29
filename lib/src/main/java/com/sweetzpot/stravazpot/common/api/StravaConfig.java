package com.sweetzpot.stravazpot.common.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sweetzpot.stravazpot.athlete.model.AthleteType;
import com.sweetzpot.stravazpot.athlete.model.FriendStatus;
import com.sweetzpot.stravazpot.athlete.model.MeasurementPreference;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.Gender;
import com.sweetzpot.stravazpot.common.model.ResourceState;
import com.sweetzpot.stravazpot.common.model.Time;
import com.sweetzpot.stravazpot.common.typeadapter.AthleteTypeTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.DistanceTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.FrameTypeTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.FriendStatusTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.GenderTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.MeasurementPreferenceTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.ResourceStateTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.RouteSubtypeTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.RouteTypeTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.TimeTypeAdapter;
import com.sweetzpot.stravazpot.gear.model.FrameType;
import com.sweetzpot.stravazpot.route.model.RouteSubtype;
import com.sweetzpot.stravazpot.route.model.RouteType;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StravaConfig {
    private Retrofit retrofit;

    StravaConfig(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public static StravaConfig.Builder withToken(String token) {
        return new StravaConfig.Builder(token);
    }

    public static class Builder {
        private static final String STRAVA_BASE_URL = "https://www.strava.com/api/v3/";

        private String token;
        private String baseURL = STRAVA_BASE_URL;
        private boolean debug = false;

        public Builder(String token) {
            this.token = token;
        }

        public Builder debug() {
            debug = true;
            return this;
        }

        public Builder baseURL(String baseURL) {
            this.baseURL = baseURL;
            return this;
        }

        public StravaConfig build() {
            return new StravaConfig(createRetrofit());
        }

        private Retrofit createRetrofit() {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            if(debug){
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(interceptor);
            }
            builder.addInterceptor(new AuthorizationInterceptor(token));

            OkHttpClient client = builder.build();

            Retrofit retrofit = new Retrofit.Builder().baseUrl(baseURL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(makeGson()))
                    .build();

            return retrofit;
        }

        private Gson makeGson() {
            return new GsonBuilder()
                        .registerTypeAdapter(Distance.class, new DistanceTypeAdapter())
                        .registerTypeAdapter(ResourceState.class, new ResourceStateTypeAdapter())
                        .registerTypeAdapter(Gender.class, new GenderTypeAdapter())
                        .registerTypeAdapter(FriendStatus.class, new FriendStatusTypeAdapter())
                        .registerTypeAdapter(AthleteType.class, new AthleteTypeTypeAdapter())
                        .registerTypeAdapter(MeasurementPreference.class, new MeasurementPreferenceTypeAdapter())
                        .registerTypeAdapter(Time.class, new TimeTypeAdapter())
                        .registerTypeAdapter(FrameType.class, new FrameTypeTypeAdapter())
                        .registerTypeAdapter(RouteType.class, new RouteTypeTypeAdapter())
                        .registerTypeAdapter(RouteSubtype.class, new RouteSubtypeTypeAdapter())
                        .create();
        }
    }
}
