/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:12.08.2024
 * TIME:10:44
 */
package com.example.Currency.exchange.repository;

import com.example.Currency.exchange.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    Optional<ExchangeRate> findByFromCurrencyCodeAndToCurrencyCodeAndDate(String fromCode, String toCode, LocalDate date);

    @Query("select e from exchange_rate e where e.fromCurrency.code=:fromCode and e.toCurrency.code=:toCode")
    Optional<ExchangeRate> findByFromCurrencyCodeAndToCurrencyCode(@Param("fromCode") String fromCode,
                                                                   @Param("toCode") String toCode);
}
