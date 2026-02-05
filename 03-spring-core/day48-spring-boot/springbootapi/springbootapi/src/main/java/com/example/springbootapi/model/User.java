package com.example.springbootapi.model;

public class User {

    private String name;
    private String email;

    // REQUIRED: default constructor
    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

