package com.sweetzpot.stravazpot.common.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sweetzpot.stravazpot.activity.model.AchievementType;
import com.sweetzpot.stravazpot.activity.model.ActivityType;
import com.sweetzpot.stravazpot.activity.model.PhotoSource;
import com.sweetzpot.stravazpot.activity.model.WorkoutType;
import com.sweetzpot.stravazpot.athlete.model.AthleteType;
import com.sweetzpot.stravazpot.athlete.model.FriendStatus;
import com.sweetzpot.stravazpot.athlete.model.MeasurementPreference;
import com.sweetzpot.stravazpot.authenticaton.model.Token;
import com.sweetzpot.stravazpot.club.model.ClubType;
import com.sweetzpot.stravazpot.club.model.Membership;
import com.sweetzpot.stravazpot.club.model.SkillLevel;
import com.sweetzpot.stravazpot.club.model.SportType;
import com.sweetzpot.stravazpot.club.model.Terrain;
import com.sweetzpot.stravazpot.common.model.Coordinates;
import com.sweetzpot.stravazpot.common.model.Distance;
import com.sweetzpot.stravazpot.common.model.Gender;
import com.sweetzpot.stravazpot.common.model.Percentage;
import com.sweetzpot.stravazpot.common.model.ResourceState;
import com.sweetzpot.stravazpot.common.model.Speed;
import com.sweetzpot.stravazpot.common.model.Temperature;
import com.sweetzpot.stravazpot.common.model.Time;
import com.sweetzpot.stravazpot.common.typeadapter.AchievementTypeTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.ActivityTypeTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.AthleteTypeTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.ClubTypeTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.CoordinatesTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.DistanceTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.FrameTypeTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.FriendStatusTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.GenderTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.MeasurementPreferenceTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.MembershipTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.PercentageTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.PhotoSourceTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.ResolutionTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.ResourceStateTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.RouteSubtypeTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.RouteTypeTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.SeriesTypeTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.SkillLevelTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.SpeedTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.SportTypeTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.StreamTypeTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.TemperatureTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.TerrainTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.TimeTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.TokenTypeAdapter;
import com.sweetzpot.stravazpot.common.typeadapter.WorkoutTypeTypeAdapter;
import com.sweetzpot.stravazpot.gear.model.FrameType;
import com.sweetzpot.stravazpot.route.model.RouteSubtype;
import com.sweetzpot.stravazpot.route.model.RouteType;
import com.sweetzpot.stravazpot.stream.model.Resolution;
import com.sweetzpot.stravazpot.stream.model.SeriesType;
import com.sweetzpot.stravazpot.stream.model.StreamType;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class Config {

    private Retrofit retrofit;

    public Config(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    protected static Retrofit createRetrofit(boolean debug, String baseURL, Interceptor... interceptors) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if(debug){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        for(Interceptor interceptor : interceptors) {
            builder.addInterceptor(interceptor);
        }

        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(makeGson()))
                .build();

        return retrofit;
    }

    private static Gson makeGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
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
                .registerTypeAdapter(Percentage.class, new PercentageTypeAdapter())
                .registerTypeAdapter(Coordinates.class, new CoordinatesTypeAdapter())
                .registerTypeAdapter(ActivityType.class, new ActivityTypeTypeAdapter())
                .registerTypeAdapter(StreamType.class, new StreamTypeTypeAdapter())
                .registerTypeAdapter(SeriesType.class, new SeriesTypeTypeAdapter())
                .registerTypeAdapter(Resolution.class, new ResolutionTypeAdapter())
                .registerTypeAdapter(ClubType.class, new ClubTypeTypeAdapter())
                .registerTypeAdapter(SportType.class, new SportTypeTypeAdapter())
                .registerTypeAdapter(Membership.class, new MembershipTypeAdapter())
                .registerTypeAdapter(SkillLevel.class, new SkillLevelTypeAdapter())
                .registerTypeAdapter(Terrain.class, new TerrainTypeAdapter())
                .registerTypeAdapter(Speed.class, new SpeedTypeAdapter())
                .registerTypeAdapter(PhotoSource.class, new PhotoSourceTypeAdapter())
                .registerTypeAdapter(WorkoutType.class, new WorkoutTypeTypeAdapter())
                .registerTypeAdapter(AchievementType.class, new AchievementTypeTypeAdapter())
                .registerTypeAdapter(Token.class, new TokenTypeAdapter())
                .registerTypeAdapter(Temperature.class, new TemperatureTypeAdapter())
                .create();
    }
}
