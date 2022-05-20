package com.learnzilla.backend.register_login.controllers;

import com.learnzilla.backend.models.Students;
import com.learnzilla.backend.register_login.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
public class StudentController {

    private StudentRepository studentRepository;
    private  PasswordEncoder passwordEncoder;

    @Autowired
    public StudentController(StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup/student")
    public void signupStudent(@RequestBody Students studentData){
        studentData.setPassword(passwordEncoder.encode(studentData.getPassword()));
        studentRepository.save(studentData);
    }

    @GetMapping("/student/{email}")
    public ResponseEntity<Students> getStudentByEmail(@PathVariable String email){
        Students students = studentRepository.findByEmail(email);
        return ResponseEntity.ok(students);
    }


    @GetMapping("/student/id/{id}")
    public ResponseEntity<Students> getStudent(@PathVariable Integer id) {
        Students students = studentRepository.findById(id).get();
        return ResponseEntity.ok(students);
    }

}
