package com.sweetzpot.stravazpot.common.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sweetzpot.stravazpot.club.model.SkillLevel;

import java.io.IOException;

public class SkillLevelTypeAdapter extends TypeAdapter<SkillLevel> {

    @Override
    public void write(JsonWriter out, SkillLevel skillLevel) throws IOException {
        out.value(skillLevel.getRawValue());
    }

    @Override
    public SkillLevel read(JsonReader in) throws IOException {
        if(!in.peek().equals(JsonToken.NULL)) {
            int value = in.nextInt();
            for (SkillLevel skillLevel : SkillLevel.values()) {
                if (skillLevel.getRawValue() == value) {
                    return skillLevel;
                }
            }
        } else {
            in.nextNull();
        }
        return null;
    }
}
