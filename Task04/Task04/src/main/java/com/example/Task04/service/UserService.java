package com.example.Task04.service;

import com.example.Task04.model.User;

public interface UserService {
    User findByUsername(String username);
    void save(User user);
}