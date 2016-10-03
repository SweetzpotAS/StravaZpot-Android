package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.common.model.Speed;

import java.io.IOException;

public class SpeedTypeAdapter extends TypeAdapter<Speed> {

    @Override
    public void write(JsonWriter out, Speed speed) throws IOException {
        out.value(speed.getMetersPerSecond());
    }

    @Override
    public Speed read(JsonReader in) throws IOException {
        return Speed.metersPerSecond((float) (in.nextDouble()));
    }
}
