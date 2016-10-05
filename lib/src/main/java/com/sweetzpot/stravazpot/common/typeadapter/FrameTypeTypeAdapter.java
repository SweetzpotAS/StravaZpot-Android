package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.gear.model.FrameType;

import java.io.IOException;

public class FrameTypeTypeAdapter extends TypeAdapter<FrameType> {

    @Override
    public void write(JsonWriter out, FrameType value) throws IOException {
        switch (value) {
            case CROSS:
                out.value(2);
                break;
            case ROAD:
                out.value(3);
                break;
            case TIME_TRIAL:
                out.value(4);
                break;
            case MTB:
            default:
                out.value(1);
                break;
        }
    }

    @Override
    public FrameType read(JsonReader in) throws IOException {
        int value = in.nextInt();

        if(value == 1) {
            return FrameType.MTB;
        } else if(value == 2) {
            return FrameType.CROSS;
        } else if(value == 3) {
            return FrameType.ROAD;
        } else if(value == 4) {
            return FrameType.TIME_TRIAL;
        }

        return FrameType.MTB;
    }
}
