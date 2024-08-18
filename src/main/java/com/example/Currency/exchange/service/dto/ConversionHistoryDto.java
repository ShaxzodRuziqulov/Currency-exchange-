/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:18.08.2024
 * TIME:14:10
 */
package com.example.Currency.exchange.service.dto;

import com.example.Currency.exchange.entity.Currency;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ConversionHistoryDto {
    private Long id;
    @ManyToOne
    private Currency fromCurrency;
    @ManyToOne
    private Currency toCurrency;
    private BigDecimal amount;
    private BigDecimal result;
    private LocalDateTime conversionDate;
}
