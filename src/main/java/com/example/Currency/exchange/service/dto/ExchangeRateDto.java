/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:15.08.2024
 * TIME:8:20
 */
package com.example.Currency.exchange.service.dto;

import com.example.Currency.exchange.entity.Currency;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExchangeRateDto {
    private Long id;
    private Long fromCurrencyId;
    private Long toCurrencyId;
    private BigDecimal rate;
    private LocalDate date;
}
