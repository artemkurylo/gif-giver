package com.pet.gifgiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@PropertySource({"classpath:open-exchanges-rates.properties", "classpath:gif-giver-rest.properties",
        "classpath:game.properties", "classpath:giphy.properties"})
public class GifGiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GifGiverApplication.class, args);
    }

}
