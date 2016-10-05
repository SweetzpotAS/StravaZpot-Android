package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.route.model.RouteSubtype;

import java.io.IOException;

public class RouteSubtypeTypeAdapter extends TypeAdapter<RouteSubtype> {

    @Override
    public void write(JsonWriter out, RouteSubtype value) throws IOException {
        switch (value) {
            case MTB:
                out.value(2);
                break;
            case CX:
                out.value(3);
                break;
            case TRAIL:
                out.value(4);
                break;
            case MIXED:
                out.value(5);
                break;
            case ROAD:
            default:
                out.value(1);
        }
    }

    @Override
    public RouteSubtype read(JsonReader in) throws IOException {
        int value = in.nextInt();

        if(value == 1) {
            return RouteSubtype.ROAD;
        } else if(value == 2) {
            return RouteSubtype.MTB;
        } else if(value == 3) {
            return RouteSubtype.CX;
        } else if(value == 4) {
            return RouteSubtype.TRAIL;
        } else if(value == 5) {
            return RouteSubtype.MIXED;
        }

        return RouteSubtype.ROAD;
    }
}
