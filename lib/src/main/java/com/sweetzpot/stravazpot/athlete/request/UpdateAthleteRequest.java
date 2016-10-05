package com.sweetzpot.stravazpot.athlete.request;

import com.sweetzpot.stravazpot.athlete.api.AthleteAPI;
import com.sweetzpot.stravazpot.athlete.model.Athlete;
import com.sweetzpot.stravazpot.athlete.rest.AthleteRest;
import com.sweetzpot.stravazpot.common.model.Gender;

import retrofit2.Call;

public class UpdateAthleteRequest {

    private final AthleteRest restService;
    private final AthleteAPI api;
    private String city;
    private String state;
    private String country;
    private Gender sex;
    private Float weight;

    public UpdateAthleteRequest(AthleteRest restService, AthleteAPI api) {
        this.restService = restService;
        this.api = api;
    }

    public UpdateAthleteRequest newCity(String city) {
        this.city = city;
        return this;
    }

    public UpdateAthleteRequest newState(String state) {
        this.state = state;
        return this;
    }

    public UpdateAthleteRequest newCountry(String country) {
        this.country = country;
        return this;
    }

    public UpdateAthleteRequest newSex(Gender sex) {
        this.sex = sex;
        return this;
    }

    public UpdateAthleteRequest newWeight(Float weight) {
        this.weight = weight;
        return this;
    }

    public Athlete execute() {
        Call<Athlete> call = restService.updateAthlete(city, state, country, sex, weight);
        return api.execute(call);
    }

}
