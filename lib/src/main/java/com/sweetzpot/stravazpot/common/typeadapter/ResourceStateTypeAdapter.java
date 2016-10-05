package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.common.model.ResourceState;

import java.io.IOException;

public class ResourceStateTypeAdapter extends TypeAdapter<ResourceState> {

    @Override
    public void write(JsonWriter out, ResourceState value) throws IOException {
        switch (value) {
            case SUMMARY:
                out.value(2);
                break;
            case DETAILED:
                out.value(3);
                break;
            case META:
            default:
                out.value(1);
                break;
        }
    }

    @Override
    public ResourceState read(JsonReader in) throws IOException {
        int value = in.nextInt();
        if(value == 1) {
            return ResourceState.META;
        } else if(value == 2) {
            return ResourceState.SUMMARY;
        } else if(value == 3) {
            return ResourceState.DETAILED;
        }
        return ResourceState.META;
    }
}
