package com.learnzilla.backend.register_login.controllers;

import com.learnzilla.backend.models.Students;
import com.learnzilla.backend.register_login.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {

    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/signup/student")
    public void signupStudent(@RequestBody Students studentData){
        studentRepository.save(studentData);
    }

    @GetMapping("/student/{email}")
    public ResponseEntity<Students> getStudentByEmail(@PathVariable String email){
        Students students = studentRepository.findByEmail(email);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/student/{id}")

    public ResponseEntity<Students> getStudent(@PathVariable Integer id) {
        Students students = studentRepository.findById(id).get();
        return ResponseEntity.ok(students);
    }

}
