package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.athlete.model.AthleteType;

import java.io.IOException;

import static com.sweetzpot.stravazpot.athlete.model.AthleteType.CYCLIST;

public class AthleteTypeTypeAdapter extends TypeAdapter<AthleteType>{

    @Override
    public void write(JsonWriter out, AthleteType athleteType) throws IOException {
        out.value(athleteType.getRawValue());
    }

    @Override
    public AthleteType read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            int value = in.nextInt();

            for(AthleteType type : AthleteType.values()) {
                if(type.getRawValue() == value) {
                    return type;
                }
            }
        }

        return null;
    }
}
