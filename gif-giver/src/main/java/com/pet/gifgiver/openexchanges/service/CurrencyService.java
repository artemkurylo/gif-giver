package com.pet.gifgiver.openexchanges.service;

import com.pet.gifgiver.openexchanges.entity.CurrencyInformation;

/**
 * Класс - сервис, позволяет работать над получением и обработкой котировок
 */
public interface CurrencyService {
    /**
     * Позволяет получить информацию из БД точно по дате, в случае если такой записи нет - идет поиск ближайшей подходящей даты.
     * @param ratesDate, дата в миллисекундах
     * @return
     */
    CurrencyInformation getCurrencyInformation(long ratesDate);
}
