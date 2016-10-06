package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.route.model.RouteSubtype;

import java.io.IOException;

public class RouteSubtypeTypeAdapter extends TypeAdapter<RouteSubtype> {

    @Override
    public void write(JsonWriter out, RouteSubtype routeSubtype) throws IOException {
        out.value(routeSubtype.getRawValue());
    }

    @Override
    public RouteSubtype read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            int value = in.nextInt();

            for(RouteSubtype routeSubtype : RouteSubtype.values()) {
                if(routeSubtype.getRawValue() == value) {
                    return routeSubtype;
                }
            }
        } else {
            in.nextNull();
        }
        return null;
    }
}
