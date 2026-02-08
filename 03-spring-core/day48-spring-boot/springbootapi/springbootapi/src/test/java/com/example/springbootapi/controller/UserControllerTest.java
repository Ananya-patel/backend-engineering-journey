package com.example.springbootapi.controller;

import com.example.springbootapi.dto.UserResponseDTO;
import com.example.springbootapi.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;


import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @WithMockUser(username = "testuser", roles = {"USER"})

    void shouldReturnPaginatedUsers() throws Exception {

        List<UserResponseDTO> users = List.of(
                new UserResponseDTO(1L, "Alice", "alice@gmail.com"),
                new UserResponseDTO(2L, "Bob", "bob@gmail.com")
        );

        Page<UserResponseDTO> page =
                new PageImpl<>(users, PageRequest.of(0, 5), 2);

        when(userService.getUsers(0, 5, "id")).thenReturn(page);

        mockMvc.perform(get("/users")
                        .param("page", "0")
                        .param("size", "5")
                        .param("sortBy", "id"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(2))
                .andExpect(jsonPath("$.content[0].name").value("Alice"))
                .andExpect(jsonPath("$.totalElements").value(2));
    }
}
