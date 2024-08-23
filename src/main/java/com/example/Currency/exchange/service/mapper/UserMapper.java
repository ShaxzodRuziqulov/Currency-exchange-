/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:24.08.2024
 * TIME:1:16
 */
package com.example.Currency.exchange.service.mapper;

import com.example.Currency.exchange.entity.User;
import com.example.Currency.exchange.service.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDto, User> {
    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
