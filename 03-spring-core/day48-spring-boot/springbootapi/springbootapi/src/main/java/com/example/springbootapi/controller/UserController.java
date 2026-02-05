

package com.example.springbootapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootapi.dto.UserRequestDTO;
import com.example.springbootapi.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // Constructor Injection 
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
public String createUser(@Valid @RequestBody UserRequestDTO dto) {
    userService.createUser(dto);
    return "User created successfully";
}



}