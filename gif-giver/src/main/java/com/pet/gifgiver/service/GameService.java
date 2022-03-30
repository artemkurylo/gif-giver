package com.pet.gifgiver.service;

public interface GameService {
    /**
     * Метод сверяет данные валют, относительно сейчас и заданного в настройках времени
     * @return Возращает булевое значение выросла ли валюта
     */
    boolean isCurrencyHigherThanBefore();
}
