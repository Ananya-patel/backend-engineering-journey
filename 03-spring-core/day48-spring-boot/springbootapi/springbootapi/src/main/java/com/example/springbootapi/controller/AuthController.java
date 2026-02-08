package com.example.springbootapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootapi.dto.LoginRequestDTO;
import com.example.springbootapi.dto.LoginResponseDTO;
import com.example.springbootapi.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    
@PostMapping("/login")
public LoginResponseDTO login(@RequestBody LoginRequestDTO dto) {

    // TEMP logic
    String role = dto.getEmail().contains("admin")
            ? "ROLE_ADMIN"
            : "ROLE_USER";

    String token = JwtUtil.generateToken(1L, dto.getEmail(), role);

    return new LoginResponseDTO(token);
}

}
