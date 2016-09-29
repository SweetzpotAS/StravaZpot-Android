package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.route.model.RouteType;

import java.io.IOException;

public class RouteTypeTypeAdapter extends TypeAdapter<RouteType> {

    @Override
    public void write(JsonWriter out, RouteType value) throws IOException {
        switch (value) {
            case RUN:
                out.value(2);
                break;
            case RIDE:
            default:
                out.value(1);
                break;
        }
    }

    @Override
    public RouteType read(JsonReader in) throws IOException {
        int value = in.nextInt();

        if(value == 1) {
            return RouteType.RIDE;
        } else if(value == 2) {
            return RouteType.RUN;
        }

        return RouteType.RIDE;
    }
}
