/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:12.08.2024
 * TIME:11:13
 */
package com.example.Currency.exchange.service;

import com.example.Currency.exchange.repository.ConversionHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ConversionHistoryService {
    private final ConversionHistoryRepository conversionHistoryRepository;

    public ConversionHistoryService(ConversionHistoryRepository conversionHistoryRepository) {
        this.conversionHistoryRepository = conversionHistoryRepository;
    }
}
