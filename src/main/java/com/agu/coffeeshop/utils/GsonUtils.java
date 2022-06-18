package com.agu.coffeeshop.utils;

import com.google.gson.GsonBuilder;

import java.time.Instant;

public class GsonUtils {
    public static GsonBuilder getGsonBuilder() {
        GsonBuilder builder = new GsonBuilder()
                .disableHtmlEscaping()
                .serializeNulls();
        builder.registerTypeAdapter(Instant.class, new InstantTypeAdapter());
        return builder;
    }
}
