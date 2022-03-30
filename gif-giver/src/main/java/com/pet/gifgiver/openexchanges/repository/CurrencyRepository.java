package com.pet.gifgiver.openexchanges.repository;

import com.pet.gifgiver.openexchanges.entity.CurrencyInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

/**
 * Spring JPA репозиторий для удобной работы с {@link CurrencyInformation}
 */
public interface CurrencyRepository extends JpaRepository<CurrencyInformation, Long> {
    CurrencyInformation findFirstByTimestampBeforeOrderByTimestampDesc(Date timestamp);

    boolean existsByTimestamp(Date timestamp);
}
