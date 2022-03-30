package com.pet.gifgiver.service;

import com.pet.gifgiver.openexchanges.entity.CurrencyInformation;
import com.pet.gifgiver.openexchanges.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class GameServiceImpl implements GameService {
    @Value("${game.millis.before.now}")
    private long millisBeforeDateNow;
    @Value("${game.base.currency}")
    private String baseCurrency;
    private final CurrencyService currencyService;

    @Autowired
    public GameServiceImpl(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Override
    public boolean isCurrencyHigherThanBefore() {
        long currentDate = System.currentTimeMillis();
        CurrencyInformation lastCurrencyInformation = currencyService.getCurrencyInformation(currentDate);
        long beforeDate = currentDate - millisBeforeDateNow;
        CurrencyInformation thenCurrencyInformation = currencyService.getCurrencyInformation(beforeDate);
        return lastCurrencyInformation.getRates().get(baseCurrency)
                > thenCurrencyInformation.getRates().get(baseCurrency);
    }
}
