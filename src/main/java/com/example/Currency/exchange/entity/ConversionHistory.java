/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:12.08.2024
 * TIME:10:36
 */
package com.example.Currency.exchange.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity(name = "conversion_history")
public class ConversionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Currency fromCurrency;
    @ManyToOne
    private Currency toCurrency;
    private BigDecimal amount;
    private BigDecimal result;
    private LocalDateTime conversionDate;


}
