

package com.example.springbootapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootapi.dto.UserRequestDTO;
import com.example.springbootapi.dto.UserResponseDTO;
import com.example.springbootapi.dto.UserUpdateRequestDTO;
import com.example.springbootapi.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // Constructor Injection 
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
public ResponseEntity<UserResponseDTO> createUser(
        @Valid @RequestBody UserRequestDTO dto) {

    UserResponseDTO response = userService.createUser(dto);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);
}
@PostMapping("/{id}/orders")
public ResponseEntity<String> createOrder(@PathVariable Long id) {

    userService.createOrderForUser(id);
    return ResponseEntity.ok("Order created");
}
@PostMapping("/transaction-test")
public ResponseEntity<String> testTransaction() {
    userService.createUserAndOrderTogether();
    return ResponseEntity.ok("Transaction completed");
}


@PutMapping("/{id}")
public ResponseEntity<UserResponseDTO> updateUser(
        @PathVariable Long id,
        @Valid @RequestBody UserUpdateRequestDTO dto) {

    UserResponseDTO response = userService.updateUser(id, dto);

    return ResponseEntity.ok(response);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

    userService.deleteUser(id);

    return ResponseEntity.noContent().build();
}

@GetMapping
public ResponseEntity<List<UserResponseDTO>> getUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
}
@GetMapping("/paged")
public ResponseEntity<?> getUsersPaged(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
) {
    return ResponseEntity.ok(
            userService.getUsersByPage(page, size)
    );
}








    



}