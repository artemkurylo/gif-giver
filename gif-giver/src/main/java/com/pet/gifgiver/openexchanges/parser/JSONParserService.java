package com.pet.gifgiver.openexchanges.parser;

import com.pet.gifgiver.openexchanges.entity.CurrencyInformation;

/**
 * Интерфейс, обеспечивающий парсинг информации из типа JSON в ${@link CurrencyInformation}.
 */
public interface JSONParserService {
    CurrencyInformation parseRates(String rates);
}
