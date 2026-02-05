package com.example.springbootapi.service;
import org.springframework.stereotype.Service;

import com.example.springbootapi.model.User;

@Service

public class UserService {
    public void createUser(User user) {
        // business logic lives here
        System.out.println("Validating user...");
        System.out.println("Saving user...");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
    }

    
}
