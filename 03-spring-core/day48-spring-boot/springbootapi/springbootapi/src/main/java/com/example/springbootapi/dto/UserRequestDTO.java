package com.example.springbootapi.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRequestDTO {
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Email(message = "Email must be valid")
    private String email;

    public UserRequestDTO() {}

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
//important 
/*Validation belongs on DTO

DTO defines API contract

Client only sees this shape */