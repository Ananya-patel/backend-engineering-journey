package com.example.springbootapi.service;

import org.springframework.stereotype.Service;

import com.example.springbootapi.exception.UserNotFoundException;
import com.example.springbootapi.model.User;

@Service
public class UserService {

    public void createUser(User user) {

        if (user.getName() == null || user.getName().isEmpty()) {
            throw new UserNotFoundException("User name cannot be empty");
        }

        System.out.println("Validating user...");
        System.out.println("Saving user...");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
    }
}

