package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.activity.model.AchievementType;

import java.io.IOException;

public class AchievementTypeTypeAdapter extends TypeAdapter<AchievementType> {

    @Override
    public void write(JsonWriter out, AchievementType achievementType) throws IOException {
        out.value(achievementType.getRawValue());
    }

    @Override
    public AchievementType read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            int input = in.nextInt();

            for (AchievementType type : AchievementType.values()) {
                if (type.getRawValue() == input) {
                    return type;
                }
            }
        } else {
            in.nextNull();
        }
        return null;
    }
}
