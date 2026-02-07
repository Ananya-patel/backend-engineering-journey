package com.example.springbootapi.model;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // REQUIRED by JPA
    public User() {}

    // Used when creating a new user
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // ===== SETTERS (CRITICAL) =====
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
     private List<Order> orders;

}

