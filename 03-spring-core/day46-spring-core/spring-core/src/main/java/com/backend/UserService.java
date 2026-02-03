package com.backend;

public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void printUser() {
        System.out.println(repository.getUser());
    }
}
