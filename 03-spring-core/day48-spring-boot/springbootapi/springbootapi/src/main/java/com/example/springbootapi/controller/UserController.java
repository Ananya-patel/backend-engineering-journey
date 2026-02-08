package com.example.springbootapi.controller;

import com.example.springbootapi.dto.UserRequestDTO;
import com.example.springbootapi.dto.UserResponseDTO;
import com.example.springbootapi.dto.UserUpdateRequestDTO;
import com.example.springbootapi.service.UserService;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO dto) {
        return userService.createUser(dto);
    }

    @PutMapping("/{id}")
    public UserResponseDTO updateUser(
            @PathVariable Long id,
            @RequestBody UserUpdateRequestDTO dto
    ) {
        return userService.updateUser(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping
    public Page<UserResponseDTO> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return userService.getUsers(page, size, sortBy);
    }
}
