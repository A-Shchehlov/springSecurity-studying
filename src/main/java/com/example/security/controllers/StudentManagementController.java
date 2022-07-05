package com.example.security.controllers;

import com.example.security.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/management/api/students")
public class StudentManagementController {
    private static final List<Student> students = List.of(
            new Student(1,"John Smith"),
            new Student(2,"Kate Jonson"));

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents(){
        return students;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void saveNewStudent(@RequestBody Student student){
        System.out.println("save");
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable Integer studentId){
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable Integer studentId,
                              @RequestBody Student student){
        System.out.println("update");
    }
}
