package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.athlete.model.FriendStatus;

import java.io.IOException;

public class FriendStatusTypeAdapter extends TypeAdapter<FriendStatus>{

    @Override
    public void write(JsonWriter out, FriendStatus value) throws IOException {
        switch (value) {
            case ACCEPTED:
                out.value("accepted");
                break;
            case PENDING:
                out.value("pending");
                break;
            case BLOCKED:
                out.value("blocked");
                break;
            case NOT_FRIENDS:
            default:
                out.nullValue();
                break;
        }
    }

    @Override
    public FriendStatus read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            String value = in.nextString();

            if (value.equalsIgnoreCase("accepted")) {
                return FriendStatus.ACCEPTED;
            } else if (value.equalsIgnoreCase("pending")) {
                return FriendStatus.PENDING;
            } else if (value.equalsIgnoreCase("blocked")) {
                return FriendStatus.BLOCKED;
            }
        } else {
            in.nextNull();
        }

        return FriendStatus.NOT_FRIENDS;
    }
}
