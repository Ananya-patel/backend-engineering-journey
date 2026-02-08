package com.example.springbootapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.springbootapi.dto.UserRequestDTO;
import com.example.springbootapi.dto.UserResponseDTO;
import com.example.springbootapi.dto.UserUpdateRequestDTO;
import com.example.springbootapi.model.User;
import com.example.springbootapi.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = new User(dto.getName(), dto.getEmail());
        User saved = userRepository.save(user);
        return new UserResponseDTO(saved.getId(), saved.getName(), saved.getEmail());
    }

    public UserResponseDTO updateUser(Long id, UserUpdateRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        User saved = userRepository.save(user);
        return new UserResponseDTO(saved.getId(), saved.getName(), saved.getEmail());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Page<UserResponseDTO> getUsers(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return userRepository.findAll(pageable)
                .map(u -> new UserResponseDTO(u.getId(), u.getName(), u.getEmail()));
    }
}
