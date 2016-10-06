package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.common.model.Coordinates;

import java.io.IOException;

public class CoordinatesTypeAdapter extends TypeAdapter<Coordinates> {

    @Override
    public void write(JsonWriter out, Coordinates coordinates) throws IOException {
        out.beginArray();
        out.value(coordinates.getLatitude());
        out.value(coordinates.getLongitude());
        out.endArray();
    }

    @Override
    public Coordinates read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            in.beginArray();
            float latitude = (float) (in.nextDouble());
            float longitude = (float) (in.nextDouble());
            in.endArray();
            return Coordinates.at(latitude, longitude);
        } else {
            in.nextNull();
            return null;
        }
    }
}
