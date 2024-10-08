/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:12.08.2024
 * TIME:10:29
 */
package com.example.Currency.exchange.entity;

import com.example.Currency.exchange.entity.enumirated.Status;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String symbol;
    @Enumerated(EnumType.STRING)
    private Status status;
}
