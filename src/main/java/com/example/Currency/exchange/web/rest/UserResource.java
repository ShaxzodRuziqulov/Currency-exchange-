/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:26.08.2024
 * TIME:0:41
 */
package com.example.Currency.exchange.web.rest;

import com.example.Currency.exchange.service.UserService;
import com.example.Currency.exchange.service.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/create")
    public ResponseEntity<?> create(@RequestBody UserDto userDto) throws URISyntaxException {
        UserDto result = userService.create(userDto);
        return ResponseEntity.created(new URI("/api/user/create" + result.getId())).body(result);
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<?> update(@RequestBody UserDto userDto, @PathVariable Long id) throws URISyntaxException {
        if (!userDto.getId().equals(id)) {
            return ResponseEntity.badRequest().body("Invalid id");
        }
        UserDto result = userService.update(userDto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/user/all")
    public ResponseEntity<?> getAll() {
        List<UserDto> result = userService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/user/byId/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        UserDto userDto = userService.getId(id);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
