package com.learnzilla.backend.register_login.controllers;

import com.learnzilla.backend.models.Student;
import com.learnzilla.backend.register_login.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/signup/student")
    public void signupStudent(@RequestBody Student studentData){
        studentRepository.save(studentData);
    }

    @GetMapping("/student/{email}")
    public Student getStudent(@PathVariable String email){
        return studentRepository.findByEmail(email);
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return studentRepository.findById(id).get();
    }

}
