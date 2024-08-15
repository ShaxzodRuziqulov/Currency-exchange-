/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:12.08.2024
 * TIME:11:12
 */
package com.example.Currency.exchange.service;

import com.example.Currency.exchange.entity.Currency;
import com.example.Currency.exchange.entity.enumirated.Status;
import com.example.Currency.exchange.repository.CurrencyRepository;
import com.example.Currency.exchange.service.dto.CurrencyDto;
import com.example.Currency.exchange.service.mapper.CurrencyMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyService {
    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper currencyMapper;

    public CurrencyService(CurrencyRepository currencyRepository, CurrencyMapper currencyMapper) {
        this.currencyRepository = currencyRepository;
        this.currencyMapper = currencyMapper;
    }

    /**
     * create a currency
     *
     * @param currencyDto the entity to save
     * @return the persisted entity
     */
    public CurrencyDto createCurrency(CurrencyDto currencyDto) {
        Currency currency = currencyMapper.toEntity(currencyDto);
        currency = currencyRepository.save(currency);
        return currencyMapper.toDto(currency);
    }

    /**
     * update a currency
     */
    public CurrencyDto updateCurrency(CurrencyDto currencyDto) {
        Currency currency = currencyMapper.toEntity(currencyDto);
        currency = currencyRepository.save(currency);
        return currencyMapper.toDto(currency);
    }

    /**
     * find all currency
     */
    public List<CurrencyDto> findAll() {
        return currencyRepository
                .findAll()
                .stream()
                .map(currencyMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * delete currency
     */
    public void delete(Long id) {
        currencyRepository.updateByStatus(id, Status.DELETE);
    }

    /**
     * update status
     */
    public void updateStatus(Long id, Status status) {
        currencyRepository.updateByStatus(id, status);
    }

    /**
     * get currence by code
     */
    public Currency getCurrencyByCode(String code) {
        return currencyRepository.getCurrencyByCode(code);
    }
}
