/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:12.08.2024
 * TIME:12:45
 */
package com.example.Currency.exchange.service.mapper;

import com.example.Currency.exchange.entity.Currency;
import com.example.Currency.exchange.service.dto.CurrencyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CurrencyMapper extends EntityMapper<CurrencyDto, Currency> {
    CurrencyDto toDto(Currency currency);

    Currency toEntity(CurrencyDto currencyDto);
}
