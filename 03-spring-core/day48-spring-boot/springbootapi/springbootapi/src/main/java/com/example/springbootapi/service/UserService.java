package com.example.springbootapi.service;

import org.springframework.stereotype.Service;

import com.example.springbootapi.dto.UserRequestDTO;
import com.example.springbootapi.model.User;

@Service
public class UserService {

    public void createUser(UserRequestDTO dto) {

        // DTO → Model mapping
        User user = new User(dto.getName(), dto.getEmail());

        System.out.println("Validating user...");
        System.out.println("Saving user...");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
    }
}
