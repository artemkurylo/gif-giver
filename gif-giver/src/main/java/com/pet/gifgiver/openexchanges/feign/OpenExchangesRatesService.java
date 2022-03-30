package com.pet.gifgiver.openexchanges.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign клиент, позволяющий работать с API OpenExchangesRates.
 */
@FeignClient(name = "OpenExchanges",
        url = "${openexhange.api.url}")
public interface OpenExchangesRatesService {
    @GetMapping(value = "/latest.json")
    String getLatestRates(@RequestParam(value = "app_id") String appId, @RequestParam("base") String baseCurrency);
}
