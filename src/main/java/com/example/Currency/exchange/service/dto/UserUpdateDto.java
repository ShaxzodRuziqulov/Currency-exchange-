/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:24.08.2024
 * TIME:1:16
 */
package com.example.Currency.exchange.service.dto;

import com.example.Currency.exchange.entity.enumirated.Role;
import com.example.Currency.exchange.entity.enumirated.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {
    private String userName;
    private String email;
    private Role role;
    private Status status;
}