package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.stream.model.StreamType;

import java.io.IOException;

public class StreamTypeTypeAdapter extends TypeAdapter<StreamType> {

    @Override
    public void write(JsonWriter out, StreamType type) throws IOException {
        out.value(type.toString());
    }

    @Override
    public StreamType read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            String input = in.nextString();
            for (StreamType type : StreamType.values()) {
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
