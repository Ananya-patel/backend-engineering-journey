package com.example.springbootapi.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UseController {
    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable int id) {
        return "User with id: " + id;
    }
    @GetMapping("/search")
public String search(
        @RequestParam String keyword,
        @RequestParam(defaultValue = "1") int page) {

    return "Searching for: " + keyword + ", page: " + page;
}


    
}

