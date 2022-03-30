package com.pet.gifgiver.configuration;

import com.google.gson.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * Конфигурационный класс для GSON.
 * Включает в себя адаптер типов из {@link Long} в класс {@link Date} и наоборот.
 */
@Configuration
public class GsonConfiguration {
    @Bean
    public Gson gson() {
        GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(Date.class, (JsonSerializer<Date>) (src, typeOfSrc, context) -> new JsonPrimitive(src.getTime()));
        builder.registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (p1, p2, p3) -> new Date(p1.getAsLong() * 1000));

        return builder.create();
    }
}
