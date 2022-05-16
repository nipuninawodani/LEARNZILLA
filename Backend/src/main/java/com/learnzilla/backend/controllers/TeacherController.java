package com.learnzilla.backend.controllers;

import com.learnzilla.backend.models.Teacher;
import com.learnzilla.backend.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/teacher/{id}")
    public Teacher getTeacher(@PathVariable Integer id){
        return teacherRepository.findById(id).get();
    }

}