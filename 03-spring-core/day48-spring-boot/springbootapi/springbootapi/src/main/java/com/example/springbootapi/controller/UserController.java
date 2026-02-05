

package com.example.springbootapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootapi.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public String createUser(@RequestBody User user) {

        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());

        return "User created successfully";
    }
}
