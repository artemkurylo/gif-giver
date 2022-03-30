package com.pet.gifgiver.openexchanges.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Класс - модель, соответствующая модели от OpenExchangesRates
 */
@Data
@Entity
public class CurrencyInformation {
    @Id
    private UUID uuid = UUID.randomUUID();
    private Date timestamp;
    @SerializedName("base")
    private String baseCurrency;
    @ElementCollection
    private Map<String, Double> rates;
}
