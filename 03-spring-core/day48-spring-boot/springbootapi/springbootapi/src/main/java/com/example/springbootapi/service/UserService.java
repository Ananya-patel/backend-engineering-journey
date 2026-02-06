package com.example.springbootapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.springbootapi.dto.UserRequestDTO;
import com.example.springbootapi.dto.UserResponseDTO;
import com.example.springbootapi.dto.UserUpdateRequestDTO;
import com.example.springbootapi.model.User;


@Service
public class UserService {

    private static final Logger logger =
            LoggerFactory.getLogger(UserService.class);

    public UserResponseDTO createUser(UserRequestDTO dto) {

        Long generatedId = 1L;
        User user = new User(generatedId, dto.getName(), dto.getEmail());

        logger.info("Creating user");
        logger.debug("User id: {}", generatedId);
        logger.debug("User name: {}", user.getName());
        logger.debug("User email: {}", user.getEmail());

        return new UserResponseDTO(user.getName(), user.getEmail());
    }

    public UserResponseDTO updateUser(Long id, UserUpdateRequestDTO dto) {

        logger.info("Updating user with id {}", id);
        User user = new User(id, dto.getName(), dto.getEmail());

        return new UserResponseDTO(user.getName(), user.getEmail());
    }

    public void deleteUser(Long id) {
        logger.warn("Deleting user with id {}", id);
    }
}
