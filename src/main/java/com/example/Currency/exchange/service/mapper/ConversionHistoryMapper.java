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

@Mapper(componentModel = "spring")
public interface ConversionHistoryMapper {
    ConversionHistory toEntity(ConversionHistoryDto conversionHistoryDto);

    ConversionHistoryDto toDto(ConversionHistory conversionHistory);
}
