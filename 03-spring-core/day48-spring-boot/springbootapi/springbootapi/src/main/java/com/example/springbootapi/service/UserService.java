package com.example.springbootapi.service;

import java.util.ArrayList;
import java.util.List;

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
    public List<UserResponseDTO> getAllUsers() {

    List<UserResponseDTO> users = new ArrayList<>();

    for (int i = 1; i <= 50; i++) {
        users.add(new UserResponseDTO(
                "User" + i,
                "user" + i + "@gmail.com"
        ));
    }

    return users;
}
public List<UserResponseDTO> getUsersByPage(int page, int size) {

    List<UserResponseDTO> allUsers = getAllUsers();

    int start = page * size;
    int end = Math.min(start + size, allUsers.size());

    if (start >= allUsers.size()) {
        return new ArrayList<>();
    }

    return allUsers.subList(start, end);
}

}
