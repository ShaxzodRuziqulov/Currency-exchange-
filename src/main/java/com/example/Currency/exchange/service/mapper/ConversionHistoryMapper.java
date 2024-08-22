/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:18.08.2024
 * TIME:14:11
 */
package com.example.Currency.exchange.service.mapper;

import com.example.Currency.exchange.entity.ConversionHistory;
import com.example.Currency.exchange.service.dto.ConversionHistoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring", uses = {CurrencyMapper.class})
public interface ConversionHistoryMapper extends EntityMapper<ConversionHistoryDto, ConversionHistory> {

    @Mapping(source = "fromCurrencyId", target = "fromCurrency.id")
    @Mapping(source = "toCurrencyId", target = "toCurrency.id")
    ConversionHistory toEntity(ConversionHistoryDto conversionHistoryDTO);

    @Mapping(source = "fromCurrency.id", target = "fromCurrencyId")
    @Mapping(source = "toCurrency.id", target = "toCurrencyId")
    ConversionHistoryDto toDto(ConversionHistory conversionHistory);

    default ConversionHistory fromId(Long id) {
        if (id == null) {
            return null;
        }
        ConversionHistory res = new ConversionHistory();
        res.setId(id);
        return res;
    }
}

