package com.learnzilla.backend.register_login.controllers;

import com.learnzilla.backend.models.Teacher;
import com.learnzilla.backend.register_login.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @PostMapping("/signup/teacher")
    public void signupTeacher(@RequestBody Teacher teacherData){
        teacherRepository.save(teacherData);
    }

    @GetMapping("/teacher/{email}")
    public Teacher getTeacher(@PathVariable String email){
        return teacherRepository.findByEmail(email);
    }

    @GetMapping("/teacher/{id}")
    public Teacher getTeacher(@PathVariable Integer id){
        return teacherRepository.findById(id).get();}

}