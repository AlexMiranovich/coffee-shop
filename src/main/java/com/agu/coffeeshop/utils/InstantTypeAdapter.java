package com.agu.coffeeshop.utils;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.ZoneOffset.UTC;
import static java.time.temporal.ChronoUnit.MILLIS;

public class InstantTypeAdapter implements JsonSerializer<Instant>, JsonDeserializer<Instant> {
    @Override
    public JsonElement serialize(Instant src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(DateTimeFormatter.ISO_DATE_TIME.withZone(UTC).format(src.truncatedTo(MILLIS)));
    }

    @Override
    public Instant deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_DATE_TIME).atZone(UTC).toInstant();
    }
}
