package com.example.security.repositories;

import com.example.security.model.User;

import java.util.Optional;
public interface UserRepository{
    Optional<User> findUserByUsername(String username);
}
