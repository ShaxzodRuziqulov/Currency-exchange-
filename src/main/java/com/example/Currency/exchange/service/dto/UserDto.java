/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:24.08.2024
 * TIME:1:05
 */
package com.example.Currency.exchange.service.dto;

import com.example.Currency.exchange.entity.enumirated.Role;
import com.example.Currency.exchange.entity.enumirated.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private Role role;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
