package com.learnzilla.backend.postmarks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostMarksController {

    @GetMapping("/marks")
    public String postMarks(){
        return "SE/2018/001,Abdullah M.R.M.,A";
    }

    @PostMapping("/marks")
    public void addMarks(@RequestBody Student StudentMarks){
        System.out.println("Student ID :"+ StudentMarks.id);
        System.out.println("Student Name :"+ StudentMarks.name);
        System.out.println("Student Grade :"+ StudentMarks.grade);
        //place to save data in the server
    }
}
