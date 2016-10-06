package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.common.model.Gender;

import java.io.IOException;

public class GenderTypeAdapter extends TypeAdapter<Gender> {

    @Override
    public void write(JsonWriter out, Gender gender) throws IOException {
        if(gender == Gender.NOT_DEFINED) {
            out.nullValue();
        } else {
            out.value(gender.toString());
        }
    }

    @Override
    public Gender read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            String value = in.nextString();
            for(Gender gender : Gender.values()) {
                if(gender.toString().equalsIgnoreCase(value)) {
                    return gender;
                }
            }
        } else {
            in.nextNull();
        }

        return Gender.NOT_DEFINED;
    }
}
