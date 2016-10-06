package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.club.model.SportType;

import java.io.IOException;

public class SportTypeTypeAdapter extends TypeAdapter<SportType> {

    @Override
    public void write(JsonWriter out, SportType type) throws IOException {
        out.value(type.toString());
    }

    @Override
    public SportType read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            String input = in.nextString();
            for (SportType type : SportType.values()) {
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
