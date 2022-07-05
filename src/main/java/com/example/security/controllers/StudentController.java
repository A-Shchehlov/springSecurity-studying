package com.example.security.controllers;

import com.example.security.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private static final List<Student> list = List.of(
            new Student(1, "John Smith"),
            new Student(2, "Kate Jonson"));

    @GetMapping(path = "{id}")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public Student getStudent(@PathVariable int id) {
        return list.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No user found"));
    }
}
