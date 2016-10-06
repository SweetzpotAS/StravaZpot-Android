package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.activity.model.ActivityType;

import java.io.IOException;

public class ActivityTypeTypeAdapter extends TypeAdapter<ActivityType> {

    @Override
    public void write(JsonWriter out, ActivityType value) throws IOException {
        out.value(value.toString());
    }

    @Override
    public ActivityType read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            String input = in.nextString();
            for (ActivityType type : ActivityType.values()) {
                if (type.toString().equalsIgnoreCase(input)) {
                    return type;
                }
            }
        } else {
            in.nextNull();
        }
        return ActivityType.RIDE;
    }
}
