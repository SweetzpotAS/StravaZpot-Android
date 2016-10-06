package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.stream.model.SeriesType;

import java.io.IOException;

public class SeriesTypeTypeAdapter extends TypeAdapter<SeriesType> {

    @Override
    public void write(JsonWriter out, SeriesType type) throws IOException {
        out.value(type.toString());
    }

    @Override
    public SeriesType read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            String input = in.nextString();
            for (SeriesType type : SeriesType.values()) {
                if (type.toString().equalsIgnoreCase(input)) {
                    return type;
                }
            }
        } else {
            in.nextNull();
        }

        return null;
    }
}
