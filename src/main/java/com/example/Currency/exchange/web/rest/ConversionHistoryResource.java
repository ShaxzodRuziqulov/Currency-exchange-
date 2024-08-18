/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:18.08.2024
 * TIME:15:12
 */
package com.example.Currency.exchange.web.rest;

import com.example.Currency.exchange.entity.ConversionHistory;
import com.example.Currency.exchange.service.ConversionHistoryService;
import com.example.Currency.exchange.service.dto.ConversionHistoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ConversionHistoryResource {
    private final ConversionHistoryService conversionHistoryService;

    public ConversionHistoryResource(ConversionHistoryService conversionHistoryService) {
        this.conversionHistoryService = conversionHistoryService;
    }

    @PostMapping("/history/create")
    public ResponseEntity<?> create(@RequestBody ConversionHistoryDto conversionHistoryDto) throws URISyntaxException {
        ConversionHistoryDto result = conversionHistoryService.create(conversionHistoryDto);
        return ResponseEntity
                .created(new URI("/api/history/create" + result.getId()))
                .body(result);
    }

    @GetMapping("/history/all")
    public ResponseEntity<?> findAll() {
        List<ConversionHistoryDto> findAll = conversionHistoryService.findAll();
        return ResponseEntity.ok(findAll);
    }

}
