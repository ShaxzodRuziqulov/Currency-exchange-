/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:12.08.2024
 * TIME:11:13
 */
package com.example.Currency.exchange.service;

import com.example.Currency.exchange.entity.ExchangeRate;
import com.example.Currency.exchange.repository.ExchangeRateRepository;
import com.example.Currency.exchange.service.dto.ExchangeRateDto;
import com.example.Currency.exchange.service.mapper.ExchangeRateMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExchangeRateService {
    private final ExchangeRateRepository exchangeRateRepository;
    private final ExchangeRateMapper exchangeRateMapper;

    public ExchangeRateService(ExchangeRateRepository exchangeRateRepository, ExchangeRateMapper exchangeRateMapper) {
        this.exchangeRateRepository = exchangeRateRepository;
        this.exchangeRateMapper = exchangeRateMapper;
    }

    public ExchangeRateDto create(ExchangeRateDto exchangeRateDto) {
        ExchangeRate exchangeRate = exchangeRateMapper.toEntity(exchangeRateDto);
        exchangeRate = exchangeRateRepository.save(exchangeRate);
        return exchangeRateMapper.toDto(exchangeRate);
    }

    public ExchangeRateDto update(ExchangeRateDto exchangeRateDto) {
        ExchangeRate exchangeRate = exchangeRateMapper.toEntity(exchangeRateDto);
        exchangeRate = exchangeRateRepository.save(exchangeRate);
        return exchangeRateMapper.toDto(exchangeRate);
    }

    public List<ExchangeRateDto> allExchangeRates() {
        return exchangeRateRepository
                .findAll()
                .stream()
                .map(exchangeRateMapper::toDto)
                .collect(Collectors.toList());
    }

    public BigDecimal getExchangeRate(String fromCode, String toCode, LocalDate date) {
        return exchangeRateRepository.findByFromCurrencyCodeAndToCurrencyCodeAndDate(fromCode, toCode, date)
                .map(ExchangeRate::getRate)
                .orElseThrow(() -> new RuntimeException("Exchange rate not found"));
    }

    public BigDecimal getExchangeRate(String fromCode, String toCode) {
        return exchangeRateRepository.findByFromCurrencyCodeAndToCurrencyCode(fromCode, toCode)
                .map(ExchangeRate::getRate)
                .orElseThrow(() -> new RuntimeException("Exchange rate not found"));
    }

    public BigDecimal convert(String fromCode, String toCode, BigDecimal amount) {
        BigDecimal exchangeRate = getExchangeRate(fromCode, toCode);

        if (exchangeRate == null || exchangeRate.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Valyuta kursi topilmadi yoki noto'gri");
        }

        return amount.multiply(exchangeRate);
    }

}
