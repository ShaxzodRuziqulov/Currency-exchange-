/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:15.08.2024
 * TIME:9:56
 */
package com.example.Currency.exchange.web.rest;

import com.example.Currency.exchange.entity.ExchangeRate;
import com.example.Currency.exchange.service.ExchangeRateService;
import com.example.Currency.exchange.service.dto.ExchangeRateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ExchangeRateResource {
    private final ExchangeRateService exchangeRateService;

    public ExchangeRateResource(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @PostMapping("/rate/create")
    public ResponseEntity<?> create(@RequestBody ExchangeRateDto exchangeRateDto) throws URISyntaxException {
        ExchangeRateDto result = exchangeRateService.create(exchangeRateDto);
        return ResponseEntity
                .created(new URI("api/rate/create" + result.getId()))
                .body(result);
    }

    @GetMapping("/rate/all")
    public ResponseEntity<?> allExchangeRate() {
        List<ExchangeRateDto> exchangeRates = exchangeRateService.allExchangeRates();
        return ResponseEntity.ok(exchangeRates);
    }

    @GetMapping("/rate/getRate/{fromCode}/{toCode}/{date}")
    public ResponseEntity<?> getExchangeRate(@PathVariable String fromCode, @PathVariable String toCode, @PathVariable LocalDate date) {
        BigDecimal exchangeRate = exchangeRateService.getExchangeRate(fromCode, toCode, date);
        return ResponseEntity.ok(exchangeRate);
    }
}
