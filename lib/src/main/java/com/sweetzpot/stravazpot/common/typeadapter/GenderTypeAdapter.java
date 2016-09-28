package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.common.model.Gender;

import java.io.IOException;

public class GenderTypeAdapter extends TypeAdapter<Gender> {

    @Override
    public void write(JsonWriter out, Gender value) throws IOException {
        switch (value) {
            case MALE:
                out.value("M");
                break;
            case FEMALE:
                out.value("F");
                break;
            case NOT_DEFINED:
            default:
                out.nullValue();
                break;
        }
    }

    @Override
    public Gender read(JsonReader in) throws IOException {
        String value = in.nextString();

        if(value == null) {
            return Gender.NOT_DEFINED;
        } else if(value.equalsIgnoreCase("M")) {
            return Gender.MALE;
        } else if(value.equalsIgnoreCase("F")) {
            return Gender.FEMALE;
        }
        return Gender.NOT_DEFINED;
    }
}
