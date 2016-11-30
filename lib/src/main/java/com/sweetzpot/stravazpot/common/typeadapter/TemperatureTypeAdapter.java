package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.common.model.Temperature;

import java.io.IOException;

public class TemperatureTypeAdapter extends TypeAdapter<Temperature> {

    @Override
    public void write(JsonWriter out, Temperature speed) throws IOException {
        out.value(speed.getCelsiusDegrees());
    }

    @Override
    public Temperature read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            return Temperature.celsiusDegrees((float) in.nextDouble());
        } else {
            in.nextNull();
            return null;
        }
    }
}
