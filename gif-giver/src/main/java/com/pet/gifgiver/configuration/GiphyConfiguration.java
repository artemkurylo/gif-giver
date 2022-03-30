package com.pet.gifgiver.configuration;

import at.mukprojects.giphy4j.Giphy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный класс для Giphy4J.
 */
@Configuration
public class GiphyConfiguration {
    @Value("${giphy.api.key}")
    private String apiKey;

    @Bean
    public Giphy giphy() {
        return new Giphy(apiKey);
    }
}
