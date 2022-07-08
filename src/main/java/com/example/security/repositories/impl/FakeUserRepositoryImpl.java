package com.example.security.repositories.impl;

import com.example.security.model.User;
import com.example.security.repositories.UserRepository;
import com.example.security.security.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository("fake")
public class FakeUserRepositoryImpl implements UserRepository {

    private final PasswordEncoder encoder;

    @Autowired
    public FakeUserRepositoryImpl(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return createUsers().stream()
                .filter(user -> Objects.equals(user.getUsername(), username))
                .findFirst();
    }

    private List<User> createUsers() {
        return List.of(
                User.builder()
                        .id(1L)
                        .username("johnsmth")
                        .password(encoder.encode("pass1"))
                        .userRole(UserRole.STUDENT)
                        .build(),
                User.builder()
                        .id(2L)
                        .username("kate")
                        .password(encoder.encode("pass2"))
                        .userRole(UserRole.ADMIN)
                        .build(),
                User.builder()
                        .id(3L)
                        .username("tom")
                        .password(encoder.encode("pass3"))
                        .userRole(UserRole.ADMINTRAINEE)
                        .build());
    }
}
