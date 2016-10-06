package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.stream.model.Resolution;

import java.io.IOException;

public class ResolutionTypeAdapter extends TypeAdapter<Resolution> {

    @Override
    public void write(JsonWriter out, Resolution resolution) throws IOException {
        out.value(resolution.toString());
    }

    @Override
    public Resolution read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            String input = in.nextString();

            for (Resolution resolution : Resolution.values()) {
                if (resolution.toString().equalsIgnoreCase(input)) {
                    return resolution;
                }
            }
        } else {
            in.nextNull();
        }

        return null;
    }
}
