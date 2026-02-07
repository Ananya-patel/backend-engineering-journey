package com.example.springbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
