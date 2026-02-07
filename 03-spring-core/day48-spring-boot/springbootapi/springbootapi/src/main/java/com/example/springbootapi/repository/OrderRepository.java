package com.example.springbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springbootapi.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
