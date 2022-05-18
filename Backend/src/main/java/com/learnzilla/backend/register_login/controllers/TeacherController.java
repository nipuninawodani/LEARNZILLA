package com.learnzilla.backend.register_login.controllers;

import com.learnzilla.backend.models.Teachers;
import com.learnzilla.backend.register_login.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TeacherController {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @PostMapping("/signup/teacher")
    public void signupTeacher(@RequestBody Teachers teacherData){
        teacherRepository.save(teacherData);
    }

    @GetMapping("/teacher/{email}")
    public Teachers getTeacherByEmail(@PathVariable String email){
        return teacherRepository.findByEmail(email);
    }

    @GetMapping("/teacher/{id}")
    public Teachers getTeacher(@PathVariable Integer id){
        return teacherRepository.findById(id).get();}
}