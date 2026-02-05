package com.example.springbootapi.service;

import org.springframework.stereotype.Service;

import com.example.springbootapi.dto.UserRequestDTO;
import com.example.springbootapi.dto.UserResponseDTO;
import com.example.springbootapi.dto.UserUpdateRequestDTO;
import com.example.springbootapi.model.User;

@Service
public class UserService {

    public UserResponseDTO createUser(UserRequestDTO dto) {

        // Simulate DB-generated ID
        Long generatedId = 1L;

        // DTO → Model
        User user = new User(generatedId, dto.getName(), dto.getEmail());

        System.out.println("Saving user...");
        System.out.println("ID: " + user.getId());
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());

        // Model → Response DTO
        return new UserResponseDTO(user.getName(), user.getEmail());
    }

    public UserResponseDTO updateUser(Long id, UserUpdateRequestDTO dto) {

        // simulate fetching existing user
        User user = new User(id, dto.getName(), dto.getEmail());

        System.out.println("Updating user " + id);

        return new UserResponseDTO(user.getName(), user.getEmail());
    }

    public void deleteUser(Long id) {
        System.out.println("Deleting user with id " + id);
    }
}
