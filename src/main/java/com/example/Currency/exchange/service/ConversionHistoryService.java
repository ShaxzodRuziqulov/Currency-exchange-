/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:12.08.2024
 * TIME:11:13
 */
package com.example.Currency.exchange.service;

import com.example.Currency.exchange.entity.ConversionHistory;
import com.example.Currency.exchange.repository.ConversionHistoryRepository;
import com.example.Currency.exchange.service.dto.ConversionHistoryDto;
import com.example.Currency.exchange.service.mapper.ConversionHistoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConversionHistoryService {
    private final ConversionHistoryRepository conversionHistoryRepository;
    private final ConversionHistoryMapper conversionHistoryMapper;

    public ConversionHistoryService(ConversionHistoryRepository conversionHistoryRepository, ConversionHistoryMapper conversionHistoryMapper) {
        this.conversionHistoryRepository = conversionHistoryRepository;
        this.conversionHistoryMapper = conversionHistoryMapper;
    }

    public ConversionHistoryDto create(ConversionHistoryDto conversionHistoryDto) {
        ConversionHistory conversionHistory = conversionHistoryMapper.toEntity(conversionHistoryDto);
        conversionHistory = conversionHistoryRepository.save(conversionHistory);
        return conversionHistoryMapper.toDto(conversionHistory);
    }

    public List<ConversionHistoryDto> findAll() {
        return conversionHistoryRepository
                .findAll()
                .stream()
                .map(conversionHistoryMapper::toDto)
                .collect(Collectors.toList());
    }

}
