package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.athlete.model.MeasurementPreference;

import java.io.IOException;

public class MeasurementPreferenceTypeAdapter extends TypeAdapter<MeasurementPreference>{

    @Override
    public void write(JsonWriter out, MeasurementPreference value) throws IOException {
        switch (value) {
            case METERS:
                out.value("meters");
                break;
            case FEET:
            default:
                out.value("feet");
                break;
        }
    }

    @Override
    public MeasurementPreference read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            String value = in.nextString();

            if(value.equalsIgnoreCase("feet")) {
                return MeasurementPreference.FEET;
            } else if(value.equalsIgnoreCase("meters")){
                return MeasurementPreference.METERS;
            }
        } else {
            in.nextNull();
        }
        return MeasurementPreference.FEET;
    }
}
