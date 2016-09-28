package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.athlete.model.AthleteType;

import java.io.IOException;

public class AthleteTypeTypeAdapter extends TypeAdapter<AthleteType>{

    @Override
    public void write(JsonWriter out, AthleteType value) throws IOException {
        switch (value) {
            case RUNNER:
                out.value(1);
                break;
            case CYCLIST:
            default:
                out.value(0);
                break;
        }
    }

    @Override
    public AthleteType read(JsonReader in) throws IOException {
        int value = in.nextInt();

        if(value == 0) {
            return AthleteType.CYCLIST;
        } else if(value == 1){
            return AthleteType.RUNNER;
        }

        return AthleteType.CYCLIST;
    }
}
