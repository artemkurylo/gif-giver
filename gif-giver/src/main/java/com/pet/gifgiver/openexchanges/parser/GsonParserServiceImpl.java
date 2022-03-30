package com.pet.gifgiver.openexchanges.parser;

import com.google.gson.Gson;
import com.pet.gifgiver.openexchanges.entity.CurrencyInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Имплементация сервиса {@link JSONParserService} через библиотеку GSON
 */
@Service
public class GsonParserServiceImpl implements JSONParserService {
    private final Gson gson;

    @Autowired
    public GsonParserServiceImpl(Gson gson) {
        this.gson = gson;
    }

    @Override
    public CurrencyInformation parseRates(String rates) {
        return gson.fromJson(rates, CurrencyInformation.class);
    }
}
