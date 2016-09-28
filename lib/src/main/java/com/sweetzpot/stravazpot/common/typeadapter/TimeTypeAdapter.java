package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.common.model.Time;

import java.io.IOException;

public class TimeTypeAdapter extends TypeAdapter<Time>{

    @Override
    public void write(JsonWriter out, Time value) throws IOException {
        out.value(value.getSeconds());
    }

    @Override
    public Time read(JsonReader in) throws IOException {
        return Time.seconds(in.nextInt());
    }
}
