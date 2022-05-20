package com.learnzilla.backend.register_login.controllers;

import com.learnzilla.backend.models.Students;
import com.learnzilla.backend.register_login.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {

    private StudentRepository studentRepository;
    private  PasswordEncoder passwordEncoder;

    @Autowired
    public StudentController(StudentRepository studentRepository, PasswordEncoder passwordEncoder, Students student) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup/student")
    public void signupStudent(@RequestBody Students studentData){
        studentData.setPassword(passwordEncoder.encode(studentData.getPassword()));
        studentRepository.save(studentData);
    }

    @GetMapping("/student/{email}")
    public Students getStudentByEmail(@PathVariable String email){

        return studentRepository.findByEmail(email);
    }

    @GetMapping("/student/{id}")

    public Students getStudent(@PathVariable Integer id) {
        return studentRepository.findById(id).get();
    }

}
