/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:12.08.2024
 * TIME:10:48
 */
package com.example.Currency.exchange.service;

import com.example.Currency.exchange.entity.User;
import com.example.Currency.exchange.repository.UserRepository;
import com.example.Currency.exchange.service.dto.UserCreateDto;
import com.example.Currency.exchange.service.dto.UserDto;
import com.example.Currency.exchange.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto create(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }
}
