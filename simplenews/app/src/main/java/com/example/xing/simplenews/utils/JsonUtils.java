package com.example.xing.simplenews.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

public class JsonUtils {

    private static Gson mGson = new Gson();

    public static <T> String serialize(T object) {
        return mGson.toJson(object);
    }

    public static <T> T deserialize(JsonObject json, Class<T> clz) throws JsonSyntaxException {
        return mGson.fromJson(json, clz);
    }

    public static <T> T deserialize(String jsonStr, Class<T> clazz) throws JsonSyntaxException {
        return mGson.fromJson(jsonStr, clazz);
    }

    public static <T> T deserialize(String jsonStr, Type type) throws Exception {
        return mGson.fromJson(jsonStr, type);
    }
}
