package com.example.springbootapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.springbootapi.dto.UserRequestDTO;
import com.example.springbootapi.dto.UserResponseDTO;
import com.example.springbootapi.dto.UserUpdateRequestDTO;
import com.example.springbootapi.model.User;
import com.example.springbootapi.repository.UserRepository;

@Service
public class UserService {

    private static final Logger logger =
            LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO dto) {

        User user = new User(dto.getName(), dto.getEmail());
        User savedUser = userRepository.save(user);

        logger.info("User saved with id {}", savedUser.getId());

        return new UserResponseDTO(
                savedUser.getName(),
                savedUser.getEmail()
        );
    }

    public List<UserResponseDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponseDTO(
                        user.getName(),
                        user.getEmail()))
                .collect(Collectors.toList());
    }

    public UserResponseDTO updateUser(Long id, UserUpdateRequestDTO dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        User updated = userRepository.save(user);

        return new UserResponseDTO(
                updated.getName(),
                updated.getEmail()
        );
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        logger.warn("Deleted user with id {}", id);
    }
}
