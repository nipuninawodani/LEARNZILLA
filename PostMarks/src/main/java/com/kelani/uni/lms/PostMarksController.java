package com.kelani.uni.lms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostMarksController {

    @GetMapping("/postmarks")
    public String postMarks(){
        return "SE/2018/001,A";
    }
}
