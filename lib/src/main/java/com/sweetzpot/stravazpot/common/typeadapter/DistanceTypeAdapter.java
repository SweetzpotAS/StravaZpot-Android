package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.common.model.Distance;

import java.io.IOException;

public class DistanceTypeAdapter extends TypeAdapter<Distance> {

    @Override
    public void write(JsonWriter out, Distance value) throws IOException {
        out.value(value.getMeters());
    }

    @Override
    public Distance read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            return new Distance((float) (in.nextDouble()));
        } else {
            in.nextNull();
            return null;
        }
    }
}
