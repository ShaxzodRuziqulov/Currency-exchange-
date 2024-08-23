/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:15.08.2024
 * TIME:8:21
 */
package com.example.Currency.exchange.service.mapper;

import com.example.Currency.exchange.entity.ExchangeRate;
import com.example.Currency.exchange.service.dto.ExchangeRateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CurrencyMapper.class)
public interface ExchangeRateMapper extends EntityMapper<ExchangeRateDto, ExchangeRate> {
    @Mapping(source = "fromCurrency.id", target = "fromCurrencyId")
    @Mapping(source = "toCurrency.id", target = "toCurrencyId")
    ExchangeRateDto toDto(ExchangeRate exchangeRate);

    @Mapping(source = "fromCurrencyId", target = "fromCurrency.id")
    @Mapping(source = "toCurrencyId", target = "toCurrency.id")
    ExchangeRate toEntity(ExchangeRateDto exchangeRateDto);

    default ExchangeRate fromId(Long id) {
        if (id == null) {
            return null;
        }
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setId(id);
        return exchangeRate;
    }
}
