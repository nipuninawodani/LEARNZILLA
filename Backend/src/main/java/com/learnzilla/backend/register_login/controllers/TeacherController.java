package com.learnzilla.backend.register_login.controllers;

import com.learnzilla.backend.models.Teachers;
import com.learnzilla.backend.register_login.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class TeacherController {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @PostMapping("/signup/teacher")
    public void signupTeacher(@RequestBody Teachers teacherData) {
        teacherRepository.save(teacherData);
    }

    @GetMapping("/teacher/{email}")
    public ResponseEntity<Teachers> getTeacherByEmail(@PathVariable String email) {
        Teachers teachers = teacherRepository.findByEmail(email);
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/teacher/id/{id}")
    public ResponseEntity<Teachers> getTeacher(@PathVariable Integer id) {
        Teachers teachers = teacherRepository.findById(id).get();
        return ResponseEntity.ok(teachers);
    }
}