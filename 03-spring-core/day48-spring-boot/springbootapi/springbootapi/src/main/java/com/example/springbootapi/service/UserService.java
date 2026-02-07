package com.example.springbootapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootapi.dto.UserRequestDTO;
import com.example.springbootapi.dto.UserResponseDTO;
import com.example.springbootapi.dto.UserUpdateRequestDTO;
import com.example.springbootapi.model.Order;
import com.example.springbootapi.model.User;
import com.example.springbootapi.repository.OrderRepository;
import com.example.springbootapi.repository.UserRepository;



@Service
public class UserService {

    private static final Logger logger =
            LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    //  Constructor-based Dependency Injection
    public UserService(UserRepository userRepository,
                       OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    // ================= CREATE =================
    public UserResponseDTO createUser(UserRequestDTO dto) {

        User user = new User(dto.getName(), dto.getEmail());
        User savedUser = userRepository.save(user);

        logger.info("User created with id {}", savedUser.getId());

        return new UserResponseDTO(
                savedUser.getName(),
                savedUser.getEmail()
        );
    }

    // ================= READ =================
    public List<UserResponseDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponseDTO(
                        user.getName(),
                        user.getEmail()))
                .collect(Collectors.toList());
    }

    // ================= UPDATE =================
    public UserResponseDTO updateUser(Long id, UserUpdateRequestDTO dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        User updatedUser = userRepository.save(user);

        logger.info("User updated with id {}", id);

        return new UserResponseDTO(
                updatedUser.getName(),
                updatedUser.getEmail()
        );
    }

    // ================= DELETE =================
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        logger.warn("User deleted with id {}", id);
    }

    // ================= RELATIONSHIP =================
    public void createOrderForUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order order = new Order("Laptop", 75000, user);

        orderRepository.save(order);

        logger.info("Order created for user {}", userId);
    }
    @Transactional
public void createUserAndOrderTogether() {

    User user = new User("Transactional User", "tx@gmail.com");
    userRepository.save(user);

    // Simulate failure
    if (true) {
        throw new RuntimeException("Something went wrong after user save!");
    }

    Order order = new Order("Phone", 50000, user);
    orderRepository.save(order);
}
public Page<UserResponseDTO> getUsersByPage(int page, int size) {

    Pageable pageable = PageRequest.of(
            page,
            size,
            Sort.by("name").ascending()
    );

    return userRepository.findAll(pageable)
            .map(user -> new UserResponseDTO(
                    user.getName(),
                    user.getEmail()
            ));
}


}
