package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.athlete.model.FriendStatus;

import java.io.IOException;

public class FriendStatusTypeAdapter extends TypeAdapter<FriendStatus>{

    @Override
    public void write(JsonWriter out, FriendStatus friendStatus) throws IOException {
        if(friendStatus == FriendStatus.NOT_FRIENDS) {
            out.nullValue();
        } else {
            out.value(friendStatus.toString());
        }
    }

    @Override
    public FriendStatus read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            String value = in.nextString();

            for(FriendStatus status : FriendStatus.values()) {
                if(status.toString().equalsIgnoreCase(value)) {
                    return status;
                }
            }
        } else {
            in.nextNull();
        }

        return FriendStatus.NOT_FRIENDS;
    }
}
