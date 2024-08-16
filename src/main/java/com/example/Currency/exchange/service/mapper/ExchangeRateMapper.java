/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:15.08.2024
 * TIME:8:21
 */
package com.example.Currency.exchange.service.mapper;

import com.example.Currency.exchange.entity.ExchangeRate;
import com.example.Currency.exchange.service.dto.CurrencyDto;
import com.example.Currency.exchange.service.dto.ExchangeRateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExchangeRateMapper {
    ExchangeRateDto toDto(ExchangeRate exchangeRate);
    ExchangeRate toEntity(ExchangeRateDto exchangeRateDto);
}
