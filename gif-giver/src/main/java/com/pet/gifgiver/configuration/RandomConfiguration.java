package com.pet.gifgiver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Конфигурационный класс для {@link Random}
 */
@Configuration
public class RandomConfiguration {
    @Bean
    public Random random() {
        return new SecureRandom();
    }
}
