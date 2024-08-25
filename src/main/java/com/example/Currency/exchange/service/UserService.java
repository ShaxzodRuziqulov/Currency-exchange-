/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:12.08.2024
 * TIME:10:48
 */
package com.example.Currency.exchange.service;

import com.example.Currency.exchange.entity.User;
import com.example.Currency.exchange.entity.enumirated.Status;
import com.example.Currency.exchange.repository.UserRepository;
import com.example.Currency.exchange.service.dto.UserDto;
import com.example.Currency.exchange.service.mapper.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<UserDto> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDto update(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserDto getId(Long id) {
        return userRepository
                .findById(id)
                .map(UserMapper.INSTANCE::toDto)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    public void delete(Long id) {
        User user = userRepository.updateByStatus(id, Status.DELETE);
        userRepository.delete(user);
    }
}
