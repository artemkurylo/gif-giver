package com.pet.gifgiver.openexchanges.service;

import com.pet.gifgiver.openexchanges.entity.CurrencyInformation;
import com.pet.gifgiver.openexchanges.feign.OpenExchangesRatesService;
import com.pet.gifgiver.openexchanges.parser.JSONParserService;
import com.pet.gifgiver.openexchanges.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Value("${openexhange.app.key}")
    private String appId;
    @Value("${openexhange.currency.base}")
    private String baseCurrency;
    private final OpenExchangesRatesService openExchangesRatesService;
    private final JSONParserService jsonParserService;
    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(OpenExchangesRatesService openExchangesRatesService, JSONParserService jsonParserService, CurrencyRepository currencyRepository) {
        this.openExchangesRatesService = openExchangesRatesService;
        this.jsonParserService = jsonParserService;
        this.currencyRepository = currencyRepository;
    }

    @Override
    public CurrencyInformation getCurrencyInformation(long ratesDate) {
        Date date = new Date(ratesDate);
        return currencyRepository.findFirstByTimestampBeforeOrderByTimestampDesc(date);
    }

    /**
     * Метод, позволяет обновлять котировки и заносить их в базу данных.
     * Метод срабатывает при подъеме приложения и после каждый час
     * В случае, если актуальная информация уже занесена - дублирования не происходит
     */
    @PostConstruct
    @Scheduled(cron = "0 0 * ? * *")
    private void updateRates() {
        String ratesJson = openExchangesRatesService.getLatestRates(appId, baseCurrency);
        CurrencyInformation currencyInformation = jsonParserService.parseRates(ratesJson);
        if (!currencyRepository.existsByTimestamp(currencyInformation.getTimestamp())) {
            currencyRepository.save(currencyInformation);
        }
    }
}
