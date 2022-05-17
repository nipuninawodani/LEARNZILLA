package com.learnzilla.backend.controllers;

import com.learnzilla.backend.models.Teacher;
import com.learnzilla.backend.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/teacher/email")
    public List<Teacher> getTeacher(@PathVariable String email){
        return teacherRepository.findAll();
    }

}