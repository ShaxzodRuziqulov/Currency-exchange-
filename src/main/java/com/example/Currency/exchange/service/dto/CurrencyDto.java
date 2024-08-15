/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:12.08.2024
 * TIME:12:43
 */
package com.example.Currency.exchange.service.dto;

import com.example.Currency.exchange.entity.enumirated.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class CurrencyDto {
    private Long id;
    private String code;
    private String name;
    private String symbol;
    @Enumerated(EnumType.STRING)
    private Status status;
}
