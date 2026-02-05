package com.example.springbootapi.service;

import org.springframework.stereotype.Service;

import com.example.springbootapi.dto.UserRequestDTO;
import com.example.springbootapi.dto.UserResponseDTO;
import com.example.springbootapi.model.User;

@Service
public class UserService {

    public UserResponseDTO createUser(UserRequestDTO dto) {

        // DTO → Model
        User user = new User(dto.getName(), dto.getEmail());

        System.out.println("Saving user...");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());

        // Model → Response DTO
        return new UserResponseDTO(user.getName(), user.getEmail());
    }
}
