package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.club.model.Membership;

import java.io.IOException;

public class MembershipTypeAdapter extends TypeAdapter<Membership> {

    @Override
    public void write(JsonWriter out, Membership membership) throws IOException {
        if(membership == Membership.NOT_MEMBER) {
            out.nullValue();
        } else {
            out.value(membership.toString());
        }
    }

    @Override
    public Membership read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            String input = in.nextString();
            for(Membership membership : Membership.values()) {
                if(membership.toString().equalsIgnoreCase(input)) {
                    return membership;
                }
            }
        }else{
            in.nextNull();
        }
        return null;
    }
}
