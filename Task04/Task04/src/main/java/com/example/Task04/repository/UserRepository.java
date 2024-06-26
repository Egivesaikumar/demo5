package com.example.Task04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Task04.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}