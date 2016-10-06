package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.athlete.model.MeasurementPreference;

import java.io.IOException;

public class MeasurementPreferenceTypeAdapter extends TypeAdapter<MeasurementPreference>{

    @Override
    public void write(JsonWriter out, MeasurementPreference measurementPreference) throws IOException {
        out.value(measurementPreference.toString());
    }

    @Override
    public MeasurementPreference read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            String value = in.nextString();

            for(MeasurementPreference measurementPreference : MeasurementPreference.values()) {
                if(measurementPreference.toString().equalsIgnoreCase(value)) {
                    return measurementPreference;
                }
            }
        } else {
            in.nextNull();
        }
        return null;
    }
}
