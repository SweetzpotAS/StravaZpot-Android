package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.activity.model.WorkoutType;

import java.io.IOException;

public class WorkoutTypeTypeAdapter extends TypeAdapter<WorkoutType> {

    @Override
    public void write(JsonWriter out, WorkoutType workoutType) throws IOException {

    }

    @Override
    public WorkoutType read(JsonReader in) throws IOException {
        return null;
    }
}
