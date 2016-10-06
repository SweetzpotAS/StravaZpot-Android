package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.common.model.ResourceState;

import java.io.IOException;

public class ResourceStateTypeAdapter extends TypeAdapter<ResourceState> {

    @Override
    public void write(JsonWriter out, ResourceState resourceState) throws IOException {
        out.value(resourceState.getRawValue());
    }

    @Override
    public ResourceState read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            int value = in.nextInt();
            for(ResourceState resourceState : ResourceState.values()) {
                if(resourceState.getRawValue() == value) {
                    return resourceState;
                }
            }
        } else {
            in.nextNull();
        }
        return null;
    }
}
