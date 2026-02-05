package com.example.springbootapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserUpdateRequestDTO {

    @NotBlank
    private String name;

    @Email
    private String email;

    public UserUpdateRequestDTO() {}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
