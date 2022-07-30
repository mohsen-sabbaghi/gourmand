package com.example.gourmand.util;

import com.example.gourmand.dto.BaseDto;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class GsonExclusionStrategy implements ExclusionStrategy {

    public boolean shouldSkipField(FieldAttributes f) {
        if (f.getDeclaringClass() == BaseDto.class && f.getName().equals("id")) {
            return true;
        }
        return f.getDeclaringClass() == BaseDto.class && f.getName().equals("created_at");
    }

    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }

}
