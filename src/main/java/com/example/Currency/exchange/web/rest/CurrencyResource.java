/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:12.08.2024
 * TIME:17:38
 */
package com.example.Currency.exchange.web.rest;

import com.example.Currency.exchange.entity.enumirated.Status;
import com.example.Currency.exchange.service.CurrencyService;
import com.example.Currency.exchange.service.dto.CurrencyDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CurrencyResource {
    private final CurrencyService currencyService;

    public CurrencyResource(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping("/currency/create")
    public ResponseEntity<?> create(@RequestBody CurrencyDto currencyDto) throws URISyntaxException {
        CurrencyDto result = currencyService.createCurrency(currencyDto);
        return ResponseEntity
                .created(new URI("api/currency/create" + result.getId()))
                .body(result);
    }

    @PutMapping("/currency/update/{id}")
    private ResponseEntity<?> update(@RequestBody CurrencyDto currencyDto, @PathVariable Long id) {
        if (currencyDto.getId() != 0 && !currencyDto.getId().equals(id)) {
            return ResponseEntity.badRequest().body("Invalid Id");
        }
        CurrencyDto result = currencyService.updateCurrency(currencyDto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/currency/all")
    public ResponseEntity<?> findAll() {
        List<CurrencyDto> currencyDtoList = currencyService.findAll();
        return ResponseEntity.ok(currencyDtoList);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteCurrency(@PathVariable Long id) {
        currencyService.delete(id);
        return ResponseEntity.ok("deleted");
    }

    @GetMapping("updateStatus/{id}/{status}")
    public ResponseEntity<?> updateCurrencyStatus(@PathVariable Long id, @PathVariable Status status) {
        currencyService.updateStatus(id, status);
        return ResponseEntity.ok("update status");
    }
}
